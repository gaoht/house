package com.ziroom.commonlib.ziroomhttp;

import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.OkHttp3Instrumentation;
import com.ziroom.commonlib.ziroomhttp.b.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;

@Instrumented
public class a
{
  private static OkHttpClient a;
  private static OkHttpClient.Builder b;
  
  private static OkHttpClient a()
  {
    try
    {
      if (a == null)
      {
        if (b == null) {
          b = OkHttp3Instrumentation.newOkHttpClientBuilder().connectTimeout(20L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS);
        }
        a = b.build();
      }
      return a;
    }
    finally {}
  }
  
  public static void cancel(Object paramObject)
  {
    Object localObject1 = getInstance().dispatcher();
    Object localObject2 = ((Dispatcher)localObject1).queuedCalls().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Call localCall = (Call)((Iterator)localObject2).next();
      if (paramObject.equals(localCall.request().tag())) {
        localCall.cancel();
      }
    }
    localObject1 = ((Dispatcher)localObject1).runningCalls().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Call)((Iterator)localObject1).next();
      if (paramObject.equals(((Call)localObject2).request().tag())) {
        ((Call)localObject2).cancel();
      }
    }
  }
  
  public static com.ziroom.commonlib.ziroomhttp.b.a delete(String paramString)
  {
    return new com.ziroom.commonlib.ziroomhttp.b.a().url(paramString);
  }
  
  public static com.ziroom.commonlib.ziroomhttp.b.b get(String paramString)
  {
    return new com.ziroom.commonlib.ziroomhttp.b.b().url(paramString);
  }
  
  public static OkHttpClient getInstance()
  {
    if (a == null) {
      return a();
    }
    return a;
  }
  
  public static OkHttpClient.Builder getInstanceBuilder()
  {
    if (b == null) {
      b = OkHttp3Instrumentation.newOkHttpClientBuilder().connectTimeout(20L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS);
    }
    return b;
  }
  
  public static void isLog(boolean paramBoolean)
  {
    if (paramBoolean) {
      getInstanceBuilder().addInterceptor(new com.ziroom.commonlib.ziroomhttp.e.a());
    }
  }
  
  public static void isMock(boolean paramBoolean, File paramFile)
  {
    if ((paramBoolean) && (paramFile != null)) {}
    try
    {
      if ((!paramFile.exists()) && (paramFile.mkdirs())) {}
      getInstanceBuilder().addInterceptor(new com.ziroom.commonlib.ziroomhttp.e.c(paramFile));
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public static void isPrintLog(boolean paramBoolean)
  {
    if (paramBoolean) {
      getInstanceBuilder().addInterceptor(new com.ziroom.commonlib.ziroomhttp.e.b());
    }
  }
  
  public static com.ziroom.commonlib.ziroomhttp.b.c post(String paramString)
  {
    return new com.ziroom.commonlib.ziroomhttp.b.c().url(paramString);
  }
  
  public static d put(String paramString)
  {
    return new d().url(paramString);
  }
  
  public static void setInstance(OkHttpClient paramOkHttpClient)
  {
    a = paramOkHttpClient;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */