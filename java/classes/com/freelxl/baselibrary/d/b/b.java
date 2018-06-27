package com.freelxl.baselibrary.d.b;

import android.text.TextUtils;
import com.freelxl.baselibrary.d.c.a;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.OkHttp3Instrumentation;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

@Instrumented
public class b
  extends e
{
  public b addHeader(String paramString1, String paramString2)
  {
    super.addHeader(paramString1, paramString2);
    return this;
  }
  
  public b addParam(String paramString1, String paramString2)
  {
    super.addParam(paramString1, paramString2);
    return this;
  }
  
  public b addRespProgressCallback(com.freelxl.baselibrary.d.c.b paramb)
  {
    this.e = paramb;
    return this;
  }
  
  public Call enqueue(Callback paramCallback)
  {
    if (TextUtils.isEmpty(this.h)) {
      throw new IllegalArgumentException("url can not be null !");
    }
    if ((this.i != null) && (this.i.size() > 0)) {
      this.h = a(this.h, this.i);
    }
    Object localObject = new Request.Builder().url(this.h);
    if (this.k != null) {
      ((Request.Builder)localObject).tag(this.k);
    }
    a((Request.Builder)localObject, this.j);
    localObject = ((Request.Builder)localObject).build();
    if ((paramCallback instanceof a)) {
      ((a)paramCallback).onStart();
    }
    OkHttpClient localOkHttpClient = a();
    if (!(localOkHttpClient instanceof OkHttpClient)) {}
    for (localObject = localOkHttpClient.newCall((Request)localObject);; localObject = OkHttp3Instrumentation.newCall((OkHttpClient)localOkHttpClient, (Request)localObject))
    {
      ((Call)localObject).enqueue(paramCallback);
      return (Call)localObject;
    }
  }
  
  public Response execute()
    throws IOException
  {
    if (TextUtils.isEmpty(this.h)) {
      throw new IllegalArgumentException("url can not be null !");
    }
    if ((this.i != null) && (this.i.size() > 0)) {
      this.h = a(this.h, this.i);
    }
    Object localObject = new Request.Builder().url(this.h);
    if (this.k != null) {
      ((Request.Builder)localObject).tag(this.k);
    }
    a((Request.Builder)localObject, this.j);
    localObject = ((Request.Builder)localObject).build();
    OkHttpClient localOkHttpClient = a();
    if (!(localOkHttpClient instanceof OkHttpClient)) {}
    for (localObject = localOkHttpClient.newCall((Request)localObject);; localObject = OkHttp3Instrumentation.newCall((OkHttpClient)localOkHttpClient, (Request)localObject)) {
      return ((Call)localObject).execute();
    }
  }
  
  public b headers(Map<String, String> paramMap)
  {
    super.headers(paramMap);
    return this;
  }
  
  public b params(Map<String, String> paramMap)
  {
    super.params(paramMap);
    return this;
  }
  
  public b setReadTimeOut(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public b setWriteTimeOut(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public b tag(Object paramObject)
  {
    super.tag(paramObject);
    return this;
  }
  
  public b url(String paramString)
  {
    super.url(paramString);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */