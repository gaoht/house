package com.ziroom.commonlib.ziroomhttp.b;

import android.text.TextUtils;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.OkHttp3Instrumentation;
import com.ziroom.commonlib.ziroomhttp.c.b;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody.Builder;
import okhttp3.Headers.Builder;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

@Instrumented
public abstract class e
{
  protected MultipartBody.Builder b;
  protected RequestBody c;
  protected b d;
  protected b e;
  protected int f;
  protected int g;
  protected String h;
  protected Map<String, String> i;
  protected Map<String, String> j;
  protected Object k;
  
  protected String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    label67:
    StringBuilder localStringBuilder2;
    if (paramString.contains("?"))
    {
      localStringBuilder1.append(paramString + "&");
      if ((paramMap == null) || (paramMap.isEmpty())) {
        break label169;
      }
      Iterator localIterator = paramMap.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label169;
      }
      paramString = (String)localIterator.next();
      localStringBuilder2 = localStringBuilder1.append(paramString).append("=");
      if (paramMap.get(paramString) != null) {
        break label155;
      }
    }
    label155:
    for (paramString = "";; paramString = (String)paramMap.get(paramString))
    {
      localStringBuilder2.append(paramString).append("&");
      break label67;
      localStringBuilder1.append(paramString + "?");
      break;
    }
    label169:
    return localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1).toString();
  }
  
  protected Call a(String paramString, Callback paramCallback)
  {
    if (TextUtils.isEmpty(this.h)) {
      throw new IllegalArgumentException("url can not be null !");
    }
    Object localObject = new Request.Builder().url(this.h);
    if (this.k != null) {
      ((Request.Builder)localObject).tag(this.k);
    }
    a((Request.Builder)localObject, this.j);
    a(paramString, (Request.Builder)localObject);
    paramString = ((Request.Builder)localObject).build();
    localObject = a();
    if (!(localObject instanceof OkHttpClient)) {}
    for (paramString = ((OkHttpClient)localObject).newCall(paramString);; paramString = OkHttp3Instrumentation.newCall((OkHttpClient)localObject, paramString))
    {
      paramString.enqueue(paramCallback);
      if ((paramCallback instanceof com.ziroom.commonlib.ziroomhttp.c.a)) {
        ((com.ziroom.commonlib.ziroomhttp.c.a)paramCallback).onStart();
      }
      return paramString;
    }
  }
  
  protected OkHttpClient a()
  {
    Object localObject2 = null;
    if (this.g * this.f > 0)
    {
      localObject1 = com.ziroom.commonlib.ziroomhttp.a.getInstance().newBuilder();
      if (this.g > 0) {
        ((OkHttpClient.Builder)localObject1).writeTimeout(this.g, TimeUnit.SECONDS);
      }
      if (this.f > 0) {
        ((OkHttpClient.Builder)localObject1).readTimeout(this.f, TimeUnit.SECONDS);
      }
      localObject2 = ((OkHttpClient.Builder)localObject1).build();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = com.ziroom.commonlib.ziroomhttp.a.getInstance();
    }
    localObject2 = localObject1;
    if (this.e != null) {
      localObject2 = com.ziroom.commonlib.ziroomhttp.a.a.addProgressResponseListener((OkHttpClient)localObject1, this.e);
    }
    return (OkHttpClient)localObject2;
  }
  
  protected Response a(String paramString)
    throws IOException
  {
    if (TextUtils.isEmpty(this.h)) {
      throw new IllegalArgumentException("url can not be null !");
    }
    Object localObject = new Request.Builder().url(this.h);
    if (this.k != null) {
      ((Request.Builder)localObject).tag(this.k);
    }
    a((Request.Builder)localObject, this.j);
    a(paramString, (Request.Builder)localObject);
    paramString = ((Request.Builder)localObject).build();
    localObject = a();
    if (!(localObject instanceof OkHttpClient)) {}
    for (paramString = ((OkHttpClient)localObject).newCall(paramString);; paramString = OkHttp3Instrumentation.newCall((OkHttpClient)localObject, paramString)) {
      return paramString.execute();
    }
  }
  
  protected void a(String paramString, Request.Builder paramBuilder)
  {
    if (this.d != null)
    {
      if (this.b != null)
      {
        paramBuilder.method(paramString, com.ziroom.commonlib.ziroomhttp.a.a.addProgressRequestListener(this.b.build(), this.d));
        return;
      }
      if (this.c != null)
      {
        paramBuilder.method(paramString, com.ziroom.commonlib.ziroomhttp.a.a.addProgressRequestListener(this.c, this.d));
        return;
      }
      localBuilder = new FormBody.Builder();
      a(localBuilder, this.i);
      paramBuilder.method(paramString, com.ziroom.commonlib.ziroomhttp.a.a.addProgressRequestListener(localBuilder.build(), this.d));
      return;
    }
    if (this.b != null)
    {
      paramBuilder.method(paramString, this.b.build());
      return;
    }
    if (this.c != null)
    {
      paramBuilder.method(paramString, this.c);
      return;
    }
    FormBody.Builder localBuilder = new FormBody.Builder();
    a(localBuilder, this.i);
    paramBuilder.method(paramString, localBuilder.build());
  }
  
  protected void a(FormBody.Builder paramBuilder, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str3);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramBuilder.add(str3, str1);
      }
    }
  }
  
  protected void a(Request.Builder paramBuilder, Map<String, String> paramMap)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str3);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localBuilder.add(str3, str1);
    }
    paramBuilder.headers(localBuilder.build());
  }
  
  public e addHeader(String paramString1, String paramString2)
  {
    if (this.j == null) {
      this.j = new IdentityHashMap();
    }
    this.j.put(paramString1, paramString2);
    return this;
  }
  
  public e addParam(String paramString1, String paramString2)
  {
    if (this.i == null) {
      this.i = new IdentityHashMap();
    }
    this.i.put(paramString1, paramString2);
    return this;
  }
  
  public e headers(Map<String, String> paramMap)
  {
    this.j = paramMap;
    return this;
  }
  
  public e params(Map<String, String> paramMap)
  {
    this.i = paramMap;
    return this;
  }
  
  public e tag(Object paramObject)
  {
    this.k = paramObject;
    return this;
  }
  
  public e url(String paramString)
  {
    this.h = paramString;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */