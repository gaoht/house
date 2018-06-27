package okhttp3.internal.ws;

import d.d;
import d.e;
import d.f;
import d.l;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;

public final class RealWebSocket
  implements WebSocket, WebSocketReader.FrameCallback
{
  private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
  private static final long MAX_QUEUE_SIZE = 16777216L;
  private static final List<Protocol> ONLY_HTTP1;
  private boolean awaitingPong;
  private Call call;
  private ScheduledFuture<?> cancelFuture;
  private boolean enqueuedClose;
  private ScheduledExecutorService executor;
  private boolean failed;
  private final String key;
  final WebSocketListener listener;
  private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque();
  private final Request originalRequest;
  private final long pingIntervalMillis;
  private final ArrayDeque<f> pongQueue = new ArrayDeque();
  private long queueSize;
  private final Random random;
  private WebSocketReader reader;
  private int receivedCloseCode = -1;
  private String receivedCloseReason;
  private int receivedPingCount;
  private int receivedPongCount;
  private int sentPingCount;
  private Streams streams;
  private WebSocketWriter writer;
  private final Runnable writerRunnable;
  
  static
  {
    if (!RealWebSocket.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
      return;
    }
  }
  
  public RealWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom, long paramLong)
  {
    if (!"GET".equals(paramRequest.method())) {
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    }
    this.originalRequest = paramRequest;
    this.listener = paramWebSocketListener;
    this.random = paramRandom;
    this.pingIntervalMillis = paramLong;
    paramRequest = new byte[16];
    paramRandom.nextBytes(paramRequest);
    this.key = f.of(paramRequest).base64();
    this.writerRunnable = new Runnable()
    {
      public void run()
      {
        try
        {
          boolean bool;
          do
          {
            bool = RealWebSocket.this.writeOneFrame();
          } while (bool);
          return;
        }
        catch (IOException localIOException)
        {
          RealWebSocket.this.failWebSocket(localIOException, null);
        }
      }
    };
  }
  
  private void runWriter()
  {
    assert (Thread.holdsLock(this));
    if (this.executor != null) {
      this.executor.execute(this.writerRunnable);
    }
  }
  
  private boolean send(f paramf, int paramInt)
  {
    boolean bool2 = false;
    for (boolean bool1 = bool2;; bool1 = true)
    {
      try
      {
        if (!this.failed)
        {
          bool1 = this.enqueuedClose;
          if (!bool1) {
            break label31;
          }
        }
        for (bool1 = bool2;; bool1 = bool2)
        {
          return bool1;
          label31:
          if (this.queueSize + paramf.size() <= 16777216L) {
            break;
          }
          close(1001, null);
        }
        this.queueSize += paramf.size();
      }
      finally {}
      this.messageAndCloseQueue.add(new Message(paramInt, paramf));
      runWriter();
    }
  }
  
  void awaitTermination(int paramInt, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    this.executor.awaitTermination(paramInt, paramTimeUnit);
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  void checkResponse(Response paramResponse)
    throws ProtocolException
  {
    if (paramResponse.code() != 101) {
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    }
    String str = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase(str)) {
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + str + "'");
    }
    str = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase(str)) {
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + str + "'");
    }
    paramResponse = paramResponse.header("Sec-WebSocket-Accept");
    str = f.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    if (!str.equals(paramResponse)) {
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str + "' but was '" + paramResponse + "'");
    }
  }
  
  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }
  
  boolean close(int paramInt, String paramString, long paramLong)
  {
    boolean bool1 = true;
    Object localObject;
    try
    {
      WebSocketProtocol.validateCloseCode(paramInt);
      localObject = null;
      if (paramString != null)
      {
        f localf = f.encodeUtf8(paramString);
        localObject = localf;
        if (localf.size() > 123L) {
          throw new IllegalArgumentException("reason.size() > 123: " + paramString);
        }
      }
    }
    finally {}
    if (!this.failed)
    {
      boolean bool2 = this.enqueuedClose;
      if (!bool2) {}
    }
    else
    {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      this.enqueuedClose = true;
      this.messageAndCloseQueue.add(new Close(paramInt, (f)localObject, paramLong));
      runWriter();
    }
  }
  
  public void connect(OkHttpClient paramOkHttpClient)
  {
    paramOkHttpClient = paramOkHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
    final Request localRequest = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    this.call = Internal.instance.newWebSocketCall(paramOkHttpClient, localRequest);
    this.call.enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        RealWebSocket.this.failWebSocket(paramAnonymousIOException, null);
      }
      
      /* Error */
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   4: aload_2
        //   5: invokevirtual 41	okhttp3/internal/ws/RealWebSocket:checkResponse	(Lokhttp3/Response;)V
        //   8: getstatic 47	okhttp3/internal/Internal:instance	Lokhttp3/internal/Internal;
        //   11: aload_1
        //   12: invokevirtual 51	okhttp3/internal/Internal:streamAllocation	(Lokhttp3/Call;)Lokhttp3/internal/connection/StreamAllocation;
        //   15: astore_1
        //   16: aload_1
        //   17: invokevirtual 56	okhttp3/internal/connection/StreamAllocation:noNewStreams	()V
        //   20: aload_1
        //   21: invokevirtual 60	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
        //   24: aload_1
        //   25: invokevirtual 66	okhttp3/internal/connection/RealConnection:newWebSocketStreams	(Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/ws/RealWebSocket$Streams;
        //   28: astore_3
        //   29: aload_0
        //   30: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   33: getfield 70	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
        //   36: aload_0
        //   37: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   40: aload_2
        //   41: invokevirtual 76	okhttp3/WebSocketListener:onOpen	(Lokhttp3/WebSocket;Lokhttp3/Response;)V
        //   44: new 78	java/lang/StringBuilder
        //   47: dup
        //   48: invokespecial 79	java/lang/StringBuilder:<init>	()V
        //   51: ldc 81
        //   53: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: aload_0
        //   57: getfield 21	okhttp3/internal/ws/RealWebSocket$2:val$request	Lokhttp3/Request;
        //   60: invokevirtual 91	okhttp3/Request:url	()Lokhttp3/HttpUrl;
        //   63: invokevirtual 97	okhttp3/HttpUrl:redact	()Ljava/lang/String;
        //   66: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   69: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   72: astore_2
        //   73: aload_0
        //   74: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   77: aload_2
        //   78: aload_3
        //   79: invokevirtual 104	okhttp3/internal/ws/RealWebSocket:initReaderAndWriter	(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V
        //   82: aload_1
        //   83: invokevirtual 60	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
        //   86: invokevirtual 108	okhttp3/internal/connection/RealConnection:socket	()Ljava/net/Socket;
        //   89: iconst_0
        //   90: invokevirtual 114	java/net/Socket:setSoTimeout	(I)V
        //   93: aload_0
        //   94: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   97: invokevirtual 117	okhttp3/internal/ws/RealWebSocket:loopReader	()V
        //   100: return
        //   101: astore_1
        //   102: aload_0
        //   103: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   106: aload_1
        //   107: aload_2
        //   108: invokevirtual 31	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
        //   111: aload_2
        //   112: invokestatic 123	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
        //   115: return
        //   116: astore_1
        //   117: aload_0
        //   118: getfield 19	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   121: aload_1
        //   122: aconst_null
        //   123: invokevirtual 31	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
        //   126: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	127	0	this	2
        //   0	127	1	paramAnonymousCall	Call
        //   0	127	2	paramAnonymousResponse	Response
        //   28	51	3	localStreams	RealWebSocket.Streams
        // Exception table:
        //   from	to	target	type
        //   0	8	101	java/net/ProtocolException
        //   29	100	116	java/lang/Exception
      }
    });
  }
  
  /* Error */
  public void failWebSocket(Exception paramException, @javax.annotation.Nullable Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 198	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 198	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: aload_0
    //   18: getfield 372	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   21: astore_3
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 372	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   27: aload_0
    //   28: getfield 374	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   31: ifnull +14 -> 45
    //   34: aload_0
    //   35: getfield 374	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   38: iconst_0
    //   39: invokeinterface 379 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 188	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   49: ifnull +12 -> 61
    //   52: aload_0
    //   53: getfield 188	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   56: invokeinterface 382 1 0
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 151	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 388	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   73: aload_3
    //   74: invokestatic 394	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_3
    //   85: invokestatic 394	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	RealWebSocket
    //   0	90	1	paramException	Exception
    //   0	90	2	paramResponse	Response
    //   21	64	3	localStreams	Streams
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   12	45	78	finally
    //   45	61	78	finally
    //   61	63	78	finally
    //   79	81	78	finally
    //   63	73	83	finally
  }
  
  public void initReaderAndWriter(String paramString, Streams paramStreams)
    throws IOException
  {
    try
    {
      this.streams = paramStreams;
      this.writer = new WebSocketWriter(paramStreams.client, paramStreams.sink, this.random);
      this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(paramString, false));
      if (this.pingIntervalMillis != 0L) {
        this.executor.scheduleAtFixedRate(new PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
      }
      if (!this.messageAndCloseQueue.isEmpty()) {
        runWriter();
      }
      this.reader = new WebSocketReader(paramStreams.client, paramStreams.source, this);
      return;
    }
    finally {}
  }
  
  public void loopReader()
    throws IOException
  {
    while (this.receivedCloseCode == -1) {
      this.reader.processNextFrame();
    }
  }
  
  public void onReadClose(int paramInt, String paramString)
  {
    if (paramInt == -1) {
      throw new IllegalArgumentException();
    }
    try
    {
      if (this.receivedCloseCode != -1) {
        throw new IllegalStateException("already closed");
      }
    }
    finally {}
    this.receivedCloseCode = paramInt;
    this.receivedCloseReason = paramString;
    Streams localStreams;
    if ((this.enqueuedClose) && (this.messageAndCloseQueue.isEmpty()))
    {
      localStreams = this.streams;
      this.streams = null;
      if (this.cancelFuture != null) {
        this.cancelFuture.cancel(false);
      }
      this.executor.shutdown();
    }
    for (;;)
    {
      try
      {
        this.listener.onClosing(this, paramInt, paramString);
        if (localStreams != null) {
          this.listener.onClosed(this, paramInt, paramString);
        }
        return;
      }
      finally
      {
        Util.closeQuietly(localStreams);
      }
      localStreams = null;
    }
  }
  
  public void onReadMessage(f paramf)
    throws IOException
  {
    this.listener.onMessage(this, paramf);
  }
  
  public void onReadMessage(String paramString)
    throws IOException
  {
    this.listener.onMessage(this, paramString);
  }
  
  /* Error */
  public void onReadPing(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 198	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 200	okhttp3/internal/ws/RealWebSocket:enqueuedClose	Z
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: getfield 114	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   20: invokevirtual 436	java/util/ArrayDeque:isEmpty	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 112	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   35: aload_1
    //   36: invokevirtual 216	java/util/ArrayDeque:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: aload_0
    //   41: invokespecial 218	okhttp3/internal/ws/RealWebSocket:runWriter	()V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 480	okhttp3/internal/ws/RealWebSocket:receivedPingCount	I
    //   49: iconst_1
    //   50: iadd
    //   51: putfield 480	okhttp3/internal/ws/RealWebSocket:receivedPingCount	I
    //   54: goto -26 -> 28
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	RealWebSocket
    //   0	62	1	paramf	f
    //   23	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	57	finally
    //   31	54	57	finally
  }
  
  public void onReadPong(f paramf)
  {
    try
    {
      this.receivedPongCount += 1;
      this.awaitingPong = false;
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  /* Error */
  boolean pong(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 198	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 200	okhttp3/internal/ws/RealWebSocket:enqueuedClose	Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 114	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   20: invokevirtual 436	java/util/ArrayDeque:isEmpty	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +9 -> 34
    //   28: iconst_0
    //   29: istore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 112	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   38: aload_1
    //   39: invokevirtual 216	java/util/ArrayDeque:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: invokespecial 218	okhttp3/internal/ws/RealWebSocket:runWriter	()V
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -19 -> 30
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	RealWebSocket
    //   0	57	1	paramf	f
    //   23	26	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	52	finally
    //   34	47	52	finally
  }
  
  boolean processNextFrame()
    throws IOException
  {
    boolean bool = false;
    try
    {
      this.reader.processNextFrame();
      int i = this.receivedCloseCode;
      if (i == -1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      failWebSocket(localException, null);
    }
    return false;
  }
  
  public long queueSize()
  {
    try
    {
      long l = this.queueSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int receivedPingCount()
  {
    try
    {
      int i = this.receivedPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int receivedPongCount()
  {
    try
    {
      int i = this.receivedPongCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  public boolean send(f paramf)
  {
    if (paramf == null) {
      throw new NullPointerException("bytes == null");
    }
    return send(paramf, 2);
  }
  
  public boolean send(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("text == null");
    }
    return send(f.encodeUtf8(paramString), 1);
  }
  
  int sentPingCount()
  {
    try
    {
      int i = this.sentPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void tearDown()
    throws InterruptedException
  {
    if (this.cancelFuture != null) {
      this.cancelFuture.cancel(false);
    }
    this.executor.shutdown();
    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
  }
  
  boolean writeOneFrame()
    throws IOException
  {
    Object localObject7 = null;
    for (;;)
    {
      WebSocketWriter localWebSocketWriter;
      f localf;
      int i;
      try
      {
        if (this.failed) {
          return false;
        }
        localWebSocketWriter = this.writer;
        localf = (f)this.pongQueue.poll();
        if (localf != null) {
          break label326;
        }
        localObject1 = this.messageAndCloseQueue.poll();
        if ((localObject1 instanceof Close))
        {
          i = this.receivedCloseCode;
          localObject3 = this.receivedCloseReason;
          if (i != -1)
          {
            localStreams = this.streams;
            this.streams = null;
            this.executor.shutdown();
            localObject7 = localObject3;
            localObject3 = localObject1;
            localObject1 = localStreams;
            if (localf == null) {
              break label175;
            }
          }
        }
      }
      finally {}
      try
      {
        localWebSocketWriter.writePong(localf);
        Util.closeQuietly((Closeable)localObject1);
        return true;
      }
      finally
      {
        Util.closeQuietly(localCloseable);
      }
      this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close)localObject1).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
      Streams localStreams = null;
      localObject7 = localObject3;
      Object localObject3 = localObject1;
      Object localObject1 = localStreams;
      continue;
      label175:
      Object localObject6;
      if (localObject1 == null)
      {
        return false;
        if ((localObject3 instanceof Message))
        {
          localObject7 = ((Message)localObject3).data;
          localObject3 = l.buffer(localWebSocketWriter.newMessageSink(((Message)localObject3).formatOpcode, ((f)localObject7).size()));
          ((d)localObject3).write((f)localObject7);
          ((d)localObject3).close();
          try
          {
            this.queueSize -= ((f)localObject7).size();
            continue;
          }
          finally {}
        }
        else if ((localObject5 instanceof Close))
        {
          localObject6 = (Close)localObject5;
          localWebSocketWriter.writeClose(((Close)localObject6).code, ((Close)localObject6).reason);
          if (localCloseable != null) {
            this.listener.onClosed(this, i, (String)localObject7);
          }
        }
        else
        {
          throw new AssertionError();
        }
      }
      else
      {
        i = -1;
        localStreams = null;
        localObject6 = localCloseable;
        Object localObject2 = localStreams;
        continue;
        label326:
        localObject2 = null;
        i = -1;
        localObject6 = null;
      }
    }
  }
  
  void writePingFrame()
  {
    try
    {
      if (this.failed) {
        return;
      }
      WebSocketWriter localWebSocketWriter = this.writer;
      if (this.awaitingPong) {}
      for (int i = this.sentPingCount;; i = -1)
      {
        this.sentPingCount += 1;
        this.awaitingPong = true;
        if (i == -1) {
          break;
        }
        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        return;
      }
      try
      {
        ((WebSocketWriter)localObject).writePing(f.b);
        return;
      }
      catch (IOException localIOException)
      {
        failWebSocket(localIOException, null);
      }
    }
    finally {}
  }
  
  final class CancelRunnable
    implements Runnable
  {
    CancelRunnable() {}
    
    public void run()
    {
      RealWebSocket.this.cancel();
    }
  }
  
  static final class Close
  {
    final long cancelAfterCloseMillis;
    final int code;
    final f reason;
    
    Close(int paramInt, f paramf, long paramLong)
    {
      this.code = paramInt;
      this.reason = paramf;
      this.cancelAfterCloseMillis = paramLong;
    }
  }
  
  static final class Message
  {
    final f data;
    final int formatOpcode;
    
    Message(int paramInt, f paramf)
    {
      this.formatOpcode = paramInt;
      this.data = paramf;
    }
  }
  
  private final class PingRunnable
    implements Runnable
  {
    PingRunnable() {}
    
    public void run()
    {
      RealWebSocket.this.writePingFrame();
    }
  }
  
  public static abstract class Streams
    implements Closeable
  {
    public final boolean client;
    public final d sink;
    public final e source;
    
    public Streams(boolean paramBoolean, e parame, d paramd)
    {
      this.client = paramBoolean;
      this.source = parame;
      this.sink = paramd;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/ws/RealWebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */