package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

final class RealCall
  implements Call
{
  final OkHttpClient client;
  private EventListener eventListener;
  private boolean executed;
  final boolean forWebSocket;
  final Request originalRequest;
  final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
  
  private RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(paramOkHttpClient, paramBoolean);
  }
  
  private void captureCallStackTrace()
  {
    Object localObject = Platform.get().getStackTraceForCloseable("response.body().close()");
    this.retryAndFollowUpInterceptor.setCallStackTrace(localObject);
  }
  
  static RealCall newRealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    paramRequest = new RealCall(paramOkHttpClient, paramRequest, paramBoolean);
    paramRequest.eventListener = paramOkHttpClient.eventListenerFactory().create(paramRequest);
    return paramRequest;
  }
  
  public void cancel()
  {
    this.retryAndFollowUpInterceptor.cancel();
  }
  
  public RealCall clone()
  {
    return newRealCall(this.client, this.originalRequest, this.forWebSocket);
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    captureCallStackTrace();
    this.eventListener.callStart(this);
    this.client.dispatcher().enqueue(new AsyncCall(paramCallback));
  }
  
  public Response execute()
    throws IOException
  {
    try
    {
      if (this.executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.executed = true;
    captureCallStackTrace();
    this.eventListener.callStart(this);
    try
    {
      this.client.dispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain();
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    catch (IOException localIOException)
    {
      this.eventListener.callFailed(this, localIOException);
      throw localIOException;
    }
    finally
    {
      this.client.dispatcher().finished(this);
    }
    this.client.dispatcher().finished(this);
    return localResponse2;
  }
  
  Response getResponseWithInterceptorChain()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.client.interceptors());
    localArrayList.add(this.retryAndFollowUpInterceptor);
    localArrayList.add(new BridgeInterceptor(this.client.cookieJar()));
    localArrayList.add(new CacheInterceptor(this.client.internalCache()));
    localArrayList.add(new ConnectInterceptor(this.client));
    if (!this.forWebSocket) {
      localArrayList.addAll(this.client.networkInterceptors());
    }
    localArrayList.add(new CallServerInterceptor(this.forWebSocket));
    return new RealInterceptorChain(localArrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
  }
  
  public boolean isCanceled()
  {
    return this.retryAndFollowUpInterceptor.isCanceled();
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  String redactedUrl()
  {
    return this.originalRequest.url().redact();
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  StreamAllocation streamAllocation()
  {
    return this.retryAndFollowUpInterceptor.streamAllocation();
  }
  
  String toLoggableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.forWebSocket) {
        break label62;
      }
    }
    label62:
    for (String str = "web socket";; str = "call")
    {
      return str + " to " + redactedUrl();
      str = "";
      break;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final Callback responseCallback;
    
    AsyncCall(Callback paramCallback)
    {
      super(new Object[] { RealCall.this.redactedUrl() });
      this.responseCallback = paramCallback;
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   6: invokevirtual 37	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
      //   9: astore_3
      //   10: aload_0
      //   11: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   14: getfield 41	okhttp3/RealCall:retryAndFollowUpInterceptor	Lokhttp3/internal/http/RetryAndFollowUpInterceptor;
      //   17: invokevirtual 47	okhttp3/internal/http/RetryAndFollowUpInterceptor:isCanceled	()Z
      //   20: istore_2
      //   21: iload_2
      //   22: ifeq +40 -> 62
      //   25: aload_0
      //   26: getfield 28	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   29: aload_0
      //   30: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   33: new 33	java/io/IOException
      //   36: dup
      //   37: ldc 49
      //   39: invokespecial 52	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   42: invokeinterface 58 3 0
      //   47: aload_0
      //   48: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   51: getfield 62	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   54: invokevirtual 68	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   57: aload_0
      //   58: invokevirtual 74	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   61: return
      //   62: aload_0
      //   63: getfield 28	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   66: aload_0
      //   67: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   70: aload_3
      //   71: invokeinterface 78 3 0
      //   76: goto -29 -> 47
      //   79: astore_3
      //   80: iload_1
      //   81: ifeq +51 -> 132
      //   84: invokestatic 84	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
      //   87: iconst_4
      //   88: new 86	java/lang/StringBuilder
      //   91: dup
      //   92: invokespecial 88	java/lang/StringBuilder:<init>	()V
      //   95: ldc 90
      //   97: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: aload_0
      //   101: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   104: invokevirtual 97	okhttp3/RealCall:toLoggableString	()Ljava/lang/String;
      //   107: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   110: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   113: aload_3
      //   114: invokevirtual 104	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   117: aload_0
      //   118: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   121: getfield 62	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   124: invokevirtual 68	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   127: aload_0
      //   128: invokevirtual 74	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   131: return
      //   132: aload_0
      //   133: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   136: invokestatic 108	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
      //   139: aload_0
      //   140: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   143: aload_3
      //   144: invokevirtual 113	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
      //   147: aload_0
      //   148: getfield 28	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   151: aload_0
      //   152: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   155: aload_3
      //   156: invokeinterface 58 3 0
      //   161: goto -44 -> 117
      //   164: astore_3
      //   165: aload_0
      //   166: getfield 15	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   169: getfield 62	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   172: invokevirtual 68	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   175: aload_0
      //   176: invokevirtual 74	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   179: aload_3
      //   180: athrow
      //   181: astore_3
      //   182: iconst_0
      //   183: istore_1
      //   184: goto -104 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	187	0	this	AsyncCall
      //   1	183	1	i	int
      //   20	2	2	bool	boolean
      //   9	62	3	localResponse	Response
      //   79	77	3	localIOException1	IOException
      //   164	16	3	localObject	Object
      //   181	1	3	localIOException2	IOException
      // Exception table:
      //   from	to	target	type
      //   25	47	79	java/io/IOException
      //   62	76	79	java/io/IOException
      //   2	21	164	finally
      //   25	47	164	finally
      //   62	76	164	finally
      //   84	117	164	finally
      //   132	161	164	finally
      //   2	21	181	java/io/IOException
    }
    
    RealCall get()
    {
      return RealCall.this;
    }
    
    String host()
    {
      return RealCall.this.originalRequest.url().host();
    }
    
    Request request()
    {
      return RealCall.this.originalRequest;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/RealCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */