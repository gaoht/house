package okhttp3.internal.http2;

import d.c;
import d.d;
import d.e;
import d.f;
import d.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class Http2Connection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService listenerExecutor;
  private boolean awaitingPong;
  long bytesLeftInWriteWindow;
  final boolean client;
  final Set<Integer> currentPushRequests = new LinkedHashSet();
  final String hostname;
  int lastGoodStreamId;
  final Listener listener;
  int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private final ExecutorService pushExecutor;
  final PushObserver pushObserver;
  final ReaderRunnable readerRunnable;
  boolean receivedInitialPeerSettings = false;
  boolean shutdown;
  final Socket socket;
  final Map<Integer, Http2Stream> streams = new LinkedHashMap();
  long unacknowledgedBytesRead = 0L;
  final Http2Writer writer;
  private final ScheduledExecutorService writerExecutor;
  
  static
  {
    if (!Http2Connection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
      return;
    }
  }
  
  Http2Connection(Builder paramBuilder)
  {
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    if (paramBuilder.client) {}
    for (int i = 1;; i = 2)
    {
      this.nextStreamId = i;
      if (paramBuilder.client) {
        this.nextStreamId += 2;
      }
      if (paramBuilder.client) {
        this.okHttpSettings.set(7, 16777216);
      }
      this.hostname = paramBuilder.hostname;
      this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", new Object[] { this.hostname }), false));
      if (paramBuilder.pingIntervalMillis != 0) {
        this.writerExecutor.scheduleAtFixedRate(new PingRunnable(false, 0, 0), paramBuilder.pingIntervalMillis, paramBuilder.pingIntervalMillis, TimeUnit.MILLISECONDS);
      }
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[] { this.hostname }), true));
      this.peerSettings.set(7, 65535);
      this.peerSettings.set(5, 16384);
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize();
      this.socket = paramBuilder.socket;
      this.writer = new Http2Writer(paramBuilder.sink, this.client);
      this.readerRunnable = new ReaderRunnable(new Http2Reader(paramBuilder.source, this.client));
      return;
    }
  }
  
  private void failConnection()
  {
    try
    {
      close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private Http2Stream newStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false) {
      synchronized (this.writer)
      {
        try
        {
          if (this.nextStreamId > 1073741823) {
            shutdown(ErrorCode.REFUSED_STREAM);
          }
          if (!this.shutdown) {
            break;
          }
          throw new ConnectionShutdownException();
        }
        finally {}
      }
    }
    int j = this.nextStreamId;
    this.nextStreamId += 2;
    Http2Stream localHttp2Stream = new Http2Stream(j, this, bool, false, paramList);
    if ((paramBoolean) && (this.bytesLeftInWriteWindow != 0L) && (localHttp2Stream.bytesLeftInWriteWindow != 0L)) {}
    for (;;)
    {
      if (localHttp2Stream.isOpen()) {
        this.streams.put(Integer.valueOf(j), localHttp2Stream);
      }
      if (paramInt == 0) {
        this.writer.synStream(bool, j, paramInt, paramList);
      }
      for (;;)
      {
        if (i != 0) {
          this.writer.flush();
        }
        return localHttp2Stream;
        if (this.client) {
          throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        }
        this.writer.pushPromise(paramInt, j, paramList);
      }
      i = 1;
    }
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  /* Error */
  void awaitPong()
    throws IOException, InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 242	okhttp3/internal/http2/Http2Connection:awaitingPong	Z
    //   6: ifeq +15 -> 21
    //   9: aload_0
    //   10: invokevirtual 321	java/lang/Object:wait	()V
    //   13: goto -11 -> 2
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	Http2Connection
    //   16	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  /* Error */
  void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 88	okhttp3/internal/http2/Http2Connection:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 333	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 335	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 336	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 263	okhttp3/internal/http2/Http2Connection:shutdown	(Lokhttp3/internal/http2/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 125	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   34: invokeinterface 339 1 0
    //   39: ifne +177 -> 216
    //   42: aload_0
    //   43: getfield 125	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   46: invokeinterface 343 1 0
    //   51: aload_0
    //   52: getfield 125	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   55: invokeinterface 346 1 0
    //   60: anewarray 270	okhttp3/internal/http2/Http2Stream
    //   63: invokeinterface 352 2 0
    //   68: checkcast 354	[Lokhttp3/internal/http2/Http2Stream;
    //   71: astore 6
    //   73: aload_0
    //   74: getfield 125	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   77: invokeinterface 357 1 0
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: astore 5
    //   87: aload 6
    //   89: ifnull +65 -> 154
    //   92: aload 6
    //   94: arraylength
    //   95: istore 4
    //   97: iconst_0
    //   98: istore_3
    //   99: iload_3
    //   100: iload 4
    //   102: if_icmpge +49 -> 151
    //   105: aload 6
    //   107: iload_3
    //   108: aaload
    //   109: astore 5
    //   111: aload 5
    //   113: aload_2
    //   114: invokevirtual 359	okhttp3/internal/http2/Http2Stream:close	(Lokhttp3/internal/http2/ErrorCode;)V
    //   117: aload_1
    //   118: astore 5
    //   120: iload_3
    //   121: iconst_1
    //   122: iadd
    //   123: istore_3
    //   124: aload 5
    //   126: astore_1
    //   127: goto -28 -> 99
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore 7
    //   137: aload_1
    //   138: astore 5
    //   140: aload_1
    //   141: ifnull -21 -> 120
    //   144: aload 7
    //   146: astore 5
    //   148: goto -28 -> 120
    //   151: aload_1
    //   152: astore 5
    //   154: aload_0
    //   155: getfield 215	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   158: invokevirtual 361	okhttp3/internal/http2/Http2Writer:close	()V
    //   161: aload 5
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 204	okhttp3/internal/http2/Http2Connection:socket	Ljava/net/Socket;
    //   168: invokevirtual 364	java/net/Socket:close	()V
    //   171: aload_0
    //   172: getfield 172	okhttp3/internal/http2/Http2Connection:writerExecutor	Ljava/util/concurrent/ScheduledExecutorService;
    //   175: invokeinterface 366 1 0
    //   180: aload_0
    //   181: getfield 194	okhttp3/internal/http2/Http2Connection:pushExecutor	Ljava/util/concurrent/ExecutorService;
    //   184: invokeinterface 369 1 0
    //   189: aload_1
    //   190: ifnull +21 -> 211
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aload 5
    //   198: ifnull -34 -> 164
    //   201: aload 5
    //   203: astore_1
    //   204: goto -40 -> 164
    //   207: astore_1
    //   208: goto -180 -> 28
    //   211: return
    //   212: astore_1
    //   213: goto -42 -> 171
    //   216: aconst_null
    //   217: astore 6
    //   219: goto -137 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	Http2Connection
    //   0	222	1	paramErrorCode1	ErrorCode
    //   0	222	2	paramErrorCode2	ErrorCode
    //   98	26	3	i	int
    //   95	8	4	j	int
    //   85	117	5	localObject	Object
    //   71	147	6	arrayOfHttp2Stream	Http2Stream[]
    //   135	10	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   30	82	130	finally
    //   82	84	130	finally
    //   131	133	130	finally
    //   111	117	135	java/io/IOException
    //   154	161	195	java/io/IOException
    //   21	26	207	java/io/IOException
    //   164	171	212	java/io/IOException
  }
  
  public void flush()
    throws IOException
  {
    this.writer.flush();
  }
  
  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }
  
  Http2Stream getStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.get(Integer.valueOf(paramInt));
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isShutdown()
  {
    try
    {
      boolean bool = this.shutdown;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int maxConcurrentStreams()
  {
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Http2Stream newStream(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void pushDataLater(final int paramInt1, e parame, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    final c localc = new c();
    parame.require(paramInt2);
    parame.read(localc, paramInt2);
    if (localc.size() != paramInt2) {
      throw new IOException(localc.size() + " != " + paramInt2);
    }
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt1) })
    {
      public void execute()
      {
        try
        {
          boolean bool = Http2Connection.this.pushObserver.onData(paramInt1, localc, paramInt2, paramBoolean);
          if (bool) {
            Http2Connection.this.writer.rstStream(paramInt1, ErrorCode.CANCEL);
          }
          if ((bool) || (paramBoolean)) {
            synchronized (Http2Connection.this)
            {
              Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt1));
              return;
            }
          }
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  void pushHeadersLater(final int paramInt, final List<Header> paramList, final boolean paramBoolean)
  {
    try
    {
      this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) })
      {
        public void execute()
        {
          boolean bool = Http2Connection.this.pushObserver.onHeaders(paramInt, paramList, paramBoolean);
          if (bool) {}
          try
          {
            Http2Connection.this.writer.rstStream(paramInt, ErrorCode.CANCEL);
            if ((bool) || (paramBoolean)) {
              synchronized (Http2Connection.this)
              {
                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
                return;
              }
            }
            return;
          }
          catch (IOException localIOException) {}
        }
      });
      return;
    }
    catch (RejectedExecutionException paramList) {}
  }
  
  /* Error */
  void pushRequestLater(final int paramInt, final List<Header> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 141	okhttp3/internal/http2/Http2Connection:currentPushRequests	Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 457 2 0
    //   15: ifeq +14 -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic 250	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   23: invokevirtual 461	okhttp3/internal/http2/Http2Connection:writeSynResetLater	(ILokhttp3/internal/http2/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 141	okhttp3/internal/http2/Http2Connection:currentPushRequests	Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokeinterface 464 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: getfield 194	okhttp3/internal/http2/Http2Connection:pushExecutor	Ljava/util/concurrent/ExecutorService;
    //   49: new 12	okhttp3/internal/http2/Http2Connection$3
    //   52: dup
    //   53: aload_0
    //   54: ldc_w 466
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield 159	okhttp3/internal/http2/Http2Connection:hostname	Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload_1
    //   71: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: iload_1
    //   76: aload_2
    //   77: invokespecial 469	okhttp3/internal/http2/Http2Connection$3:<init>	(Lokhttp3/internal/http2/Http2Connection;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   80: invokeinterface 440 2 0
    //   85: return
    //   86: astore_2
    //   87: return
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	Http2Connection
    //   0	93	1	paramInt	int
    //   0	93	2	paramList	List<Header>
    // Exception table:
    //   from	to	target	type
    //   45	85	86	java/util/concurrent/RejectedExecutionException
    //   2	28	88	finally
    //   29	45	88	finally
    //   89	91	88	finally
  }
  
  void pushResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) })
    {
      public void execute()
      {
        Http2Connection.this.pushObserver.onReset(paramInt, paramErrorCode);
        synchronized (Http2Connection.this)
        {
          Http2Connection.this.currentPushRequests.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  public Http2Stream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.client) {
      throw new IllegalStateException("Client cannot push requests.");
    }
    return newStream(paramInt, paramList, paramBoolean);
  }
  
  boolean pushedStream(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  Http2Stream removeStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setSettings(Settings paramSettings)
    throws IOException
  {
    synchronized (this.writer)
    {
      try
      {
        if (this.shutdown) {
          throw new ConnectionShutdownException();
        }
      }
      finally {}
    }
    this.okHttpSettings.merge(paramSettings);
    this.writer.settings(paramSettings);
  }
  
  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    int i;
    synchronized (this.writer) {}
  }
  
  public void start()
    throws IOException
  {
    start(true);
  }
  
  void start(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.writer.connectionPreface();
      this.writer.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize();
      if (i != 65535) {
        this.writer.windowUpdate(0, i - 65535);
      }
    }
    new Thread(this.readerRunnable).start();
  }
  
  public void writeData(int paramInt, boolean paramBoolean, c paramc, long paramLong)
    throws IOException
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.writer.data(paramBoolean, paramInt, paramc, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i = Math.min((int)Math.min(l, this.bytesLeftInWriteWindow), this.writer.maxDataLength());
        this.bytesLeftInWriteWindow -= i;
        l -= i;
        Http2Writer localHttp2Writer = this.writer;
        if ((!paramBoolean) || (l != 0L)) {
          break label164;
        }
        bool = true;
        localHttp2Writer.data(bool, paramInt, paramc, i);
        if (l <= 0L) {
          break;
        }
        try
        {
          if (this.bytesLeftInWriteWindow > 0L) {
            continue;
          }
          if (!this.streams.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramc)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label164:
      boolean bool = false;
    }
  }
  
  void writePing(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      try
      {
        boolean bool = this.awaitingPong;
        this.awaitingPong = true;
        if (bool)
        {
          failConnection();
          return;
        }
      }
      finally {}
    }
    try
    {
      this.writer.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      failConnection();
    }
  }
  
  void writePingAndAwaitPong()
    throws IOException, InterruptedException
  {
    writePing(false, 1330343787, -257978967);
    awaitPong();
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.writer.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.writer.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(final int paramInt, final ErrorCode paramErrorCode)
  {
    try
    {
      this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) })
      {
        public void execute()
        {
          try
          {
            Http2Connection.this.writeSynReset(paramInt, paramErrorCode);
            return;
          }
          catch (IOException localIOException)
          {
            Http2Connection.this.failConnection();
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException paramErrorCode) {}
  }
  
  void writeWindowUpdateLater(final int paramInt, final long paramLong)
  {
    try
    {
      this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) })
      {
        public void execute()
        {
          try
          {
            Http2Connection.this.writer.windowUpdate(paramInt, paramLong);
            return;
          }
          catch (IOException localIOException)
          {
            Http2Connection.this.failConnection();
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  public static class Builder
  {
    boolean client;
    String hostname;
    Http2Connection.Listener listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
    int pingIntervalMillis;
    PushObserver pushObserver = PushObserver.CANCEL;
    d sink;
    Socket socket;
    e source;
    
    public Builder(boolean paramBoolean)
    {
      this.client = paramBoolean;
    }
    
    public Http2Connection build()
    {
      return new Http2Connection(this);
    }
    
    public Builder listener(Http2Connection.Listener paramListener)
    {
      this.listener = paramListener;
      return this;
    }
    
    public Builder pingIntervalMillis(int paramInt)
    {
      this.pingIntervalMillis = paramInt;
      return this;
    }
    
    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }
    
    public Builder socket(Socket paramSocket)
      throws IOException
    {
      return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), l.buffer(l.source(paramSocket)), l.buffer(l.sink(paramSocket)));
    }
    
    public Builder socket(Socket paramSocket, String paramString, e parame, d paramd)
    {
      this.socket = paramSocket;
      this.hostname = paramString;
      this.source = parame;
      this.sink = paramd;
      return this;
    }
  }
  
  public static abstract class Listener
  {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener()
    {
      public void onStream(Http2Stream paramAnonymousHttp2Stream)
        throws IOException
      {
        paramAnonymousHttp2Stream.close(ErrorCode.REFUSED_STREAM);
      }
    };
    
    public void onSettings(Http2Connection paramHttp2Connection) {}
    
    public abstract void onStream(Http2Stream paramHttp2Stream)
      throws IOException;
  }
  
  final class PingRunnable
    extends NamedRunnable
  {
    final int payload1;
    final int payload2;
    final boolean reply;
    
    PingRunnable(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      super(new Object[] { Http2Connection.this.hostname, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.reply = paramBoolean;
      this.payload1 = paramInt1;
      this.payload2 = paramInt2;
    }
    
    public void execute()
    {
      Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
    }
  }
  
  class ReaderRunnable
    extends NamedRunnable
    implements Http2Reader.Handler
  {
    final Http2Reader reader;
    
    ReaderRunnable(Http2Reader paramHttp2Reader)
    {
      super(new Object[] { Http2Connection.this.hostname });
      this.reader = paramHttp2Reader;
    }
    
    private void applyAndAckSettings(final Settings paramSettings)
    {
      try
      {
        Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[] { Http2Connection.this.hostname })
        {
          public void execute()
          {
            try
            {
              Http2Connection.this.writer.applyAndAckSettings(paramSettings);
              return;
            }
            catch (IOException localIOException)
            {
              Http2Connection.this.failConnection();
            }
          }
        });
        return;
      }
      catch (RejectedExecutionException paramSettings) {}
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, f paramf, String paramString2, int paramInt2, long paramLong) {}
    
    public void data(boolean paramBoolean, int paramInt1, e parame, int paramInt2)
      throws IOException
    {
      if (Http2Connection.this.pushedStream(paramInt1)) {
        Http2Connection.this.pushDataLater(paramInt1, parame, paramInt2, paramBoolean);
      }
      Http2Stream localHttp2Stream;
      do
      {
        return;
        localHttp2Stream = Http2Connection.this.getStream(paramInt1);
        if (localHttp2Stream == null)
        {
          Http2Connection.this.writeSynResetLater(paramInt1, ErrorCode.PROTOCOL_ERROR);
          parame.skip(paramInt2);
          return;
        }
        localHttp2Stream.receiveData(parame, paramInt2);
      } while (!paramBoolean);
      localHttp2Stream.receiveFin();
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: getstatic 105	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_3
      //   4: getstatic 105	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   17: aload_0
      //   18: invokevirtual 111	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
      //   21: aload_3
      //   22: astore_2
      //   23: aload_3
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   29: iconst_0
      //   30: aload_0
      //   31: invokevirtual 115	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
      //   34: ifne -13 -> 21
      //   37: aload_3
      //   38: astore_2
      //   39: aload_3
      //   40: astore_1
      //   41: getstatic 118	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   44: astore_3
      //   45: aload_3
      //   46: astore_2
      //   47: aload_3
      //   48: astore_1
      //   49: getstatic 121	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   52: astore 5
      //   54: aload_0
      //   55: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   58: aload_3
      //   59: aload 5
      //   61: invokevirtual 125	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   64: aload_0
      //   65: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   68: invokestatic 131	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   71: return
      //   72: astore_1
      //   73: aload_2
      //   74: astore_1
      //   75: getstatic 82	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   78: astore_3
      //   79: getstatic 82	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   82: astore_1
      //   83: aload_0
      //   84: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   87: aload_3
      //   88: aload_1
      //   89: invokevirtual 125	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   92: aload_0
      //   93: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   96: invokestatic 131	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   99: return
      //   100: astore_2
      //   101: aload_1
      //   102: astore_3
      //   103: aload_2
      //   104: astore_1
      //   105: aload_0
      //   106: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   109: aload_3
      //   110: aload 4
      //   112: invokevirtual 125	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   115: aload_0
      //   116: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   119: invokestatic 131	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_2
      //   125: goto -10 -> 115
      //   128: astore_1
      //   129: goto -24 -> 105
      //   132: astore_1
      //   133: goto -41 -> 92
      //   136: astore_1
      //   137: goto -73 -> 64
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	140	0	this	ReaderRunnable
      //   12	37	1	localObject1	Object
      //   72	1	1	localIOException1	IOException
      //   74	49	1	localObject2	Object
      //   128	1	1	localObject3	Object
      //   132	1	1	localIOException2	IOException
      //   136	1	1	localIOException3	IOException
      //   10	64	2	localObject4	Object
      //   100	4	2	localObject5	Object
      //   124	1	2	localIOException4	IOException
      //   3	107	3	localObject6	Object
      //   7	104	4	localErrorCode1	ErrorCode
      //   52	8	5	localErrorCode2	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   13	21	72	java/io/IOException
      //   25	37	72	java/io/IOException
      //   41	45	72	java/io/IOException
      //   49	54	72	java/io/IOException
      //   13	21	100	finally
      //   25	37	100	finally
      //   41	45	100	finally
      //   49	54	100	finally
      //   75	79	100	finally
      //   105	115	124	java/io/IOException
      //   79	83	128	finally
      //   83	92	132	java/io/IOException
      //   54	64	136	java/io/IOException
    }
    
    public void goAway(int paramInt, ErrorCode arg2, f paramf)
    {
      if (paramf.size() > 0) {}
      synchronized (Http2Connection.this)
      {
        paramf = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
        Http2Connection.this.shutdown = true;
        int j = paramf.length;
        int i = 0;
        if (i < j)
        {
          ??? = paramf[i];
          if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
          {
            ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
            Http2Connection.this.removeStream(???.getId());
          }
          i += 1;
        }
      }
    }
    
    public void headers(boolean paramBoolean, int paramInt1, int paramInt2, final List<Header> paramList)
    {
      if (Http2Connection.this.pushedStream(paramInt1)) {
        Http2Connection.this.pushHeadersLater(paramInt1, paramList, paramBoolean);
      }
      Http2Stream localHttp2Stream;
      label193:
      do
      {
        return;
        synchronized (Http2Connection.this)
        {
          localHttp2Stream = Http2Connection.this.getStream(paramInt1);
          if (localHttp2Stream != null) {
            break label193;
          }
          if (Http2Connection.this.shutdown) {
            return;
          }
        }
        if (paramInt1 <= Http2Connection.this.lastGoodStreamId) {
          return;
        }
        if (paramInt1 % 2 == Http2Connection.this.nextStreamId % 2) {
          return;
        }
        paramList = new Http2Stream(paramInt1, Http2Connection.this, false, paramBoolean, paramList);
        Http2Connection.this.lastGoodStreamId = paramInt1;
        Http2Connection.this.streams.put(Integer.valueOf(paramInt1), paramList);
        Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[] { Http2Connection.this.hostname, Integer.valueOf(paramInt1) })
        {
          public void execute()
          {
            try
            {
              Http2Connection.this.listener.onStream(paramList);
              return;
            }
            catch (IOException localIOException1)
            {
              Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, localIOException1);
              try
              {
                paramList.close(ErrorCode.PROTOCOL_ERROR);
                return;
              }
              catch (IOException localIOException2) {}
            }
          }
        });
        return;
        localHttp2Stream.receiveHeaders(paramList);
      } while (!paramBoolean);
      localHttp2Stream.receiveFin();
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean) {
        synchronized (Http2Connection.this)
        {
          Http2Connection.access$302(Http2Connection.this, false);
          Http2Connection.this.notifyAll();
          return;
        }
      }
      try
      {
        Http2Connection.this.writerExecutor.execute(new Http2Connection.PingRunnable(Http2Connection.this, true, paramInt1, paramInt2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException) {}
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      Http2Connection.this.pushRequestLater(paramInt2, paramList);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (Http2Connection.this.pushedStream(paramInt)) {
        Http2Connection.this.pushResetLater(paramInt, paramErrorCode);
      }
      Http2Stream localHttp2Stream;
      do
      {
        return;
        localHttp2Stream = Http2Connection.this.removeStream(paramInt);
      } while (localHttp2Stream == null);
      localHttp2Stream.receiveRstStream(paramErrorCode);
    }
    
    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      for (;;)
      {
        int i;
        synchronized (Http2Connection.this)
        {
          i = Http2Connection.this.peerSettings.getInitialWindowSize();
          if (paramBoolean) {
            Http2Connection.this.peerSettings.clear();
          }
          Http2Connection.this.peerSettings.merge(paramSettings);
          applyAndAckSettings(paramSettings);
          int j = Http2Connection.this.peerSettings.getInitialWindowSize();
          if ((j == -1) || (j == i)) {
            break label261;
          }
          l = j - i;
          if (!Http2Connection.this.receivedInitialPeerSettings)
          {
            Http2Connection.this.addBytesToWriteWindow(l);
            Http2Connection.this.receivedInitialPeerSettings = true;
          }
          if (Http2Connection.this.streams.isEmpty()) {
            break label256;
          }
          paramSettings = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
          Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", new Object[] { Http2Connection.this.hostname })
          {
            public void execute()
            {
              Http2Connection.this.listener.onSettings(Http2Connection.this);
            }
          });
          if ((paramSettings == null) || (l == 0L)) {
            break label255;
          }
          j = paramSettings.length;
          i = 0;
          if (i >= j) {
            break label255;
          }
        }
        synchronized (paramSettings[i])
        {
          ???.addBytesToWriteWindow(l);
          i += 1;
          continue;
          paramSettings = finally;
          throw paramSettings;
        }
        label255:
        return;
        label256:
        paramSettings = null;
        continue;
        label261:
        paramSettings = null;
        long l = 0L;
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (Http2Connection.this)
        {
          Http2Connection localHttp2Connection = Http2Connection.this;
          localHttp2Connection.bytesLeftInWriteWindow += paramLong;
          Http2Connection.this.notifyAll();
          return;
        }
      }
      ??? = Http2Connection.this.getStream(paramInt);
      if (??? != null) {
        try
        {
          ((Http2Stream)???).addBytesToWriteWindow(paramLong);
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/http2/Http2Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */