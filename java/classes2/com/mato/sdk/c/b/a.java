package com.mato.sdk.c.b;

import android.text.TextUtils;
import com.mato.sdk.b.g;
import com.mato.sdk.proxy.Proxy;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final String a = g.b("");
  private static int b = 20480;
  private static int c = 5;
  private final String d;
  private final long e;
  private final boolean f;
  private final e g;
  private final boolean h;
  private final boolean i;
  private final String j;
  
  private a(String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2, e parame, boolean paramBoolean3)
  {
    this.d = paramString1;
    this.e = paramLong;
    this.h = paramBoolean1;
    this.j = paramString2;
    this.f = paramBoolean2;
    this.g = parame;
    this.i = paramBoolean3;
  }
  
  public static a a(String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.indexOf("\n");
      if (k != -1) {
        str = paramString.substring(0, k);
      }
    }
    for (;;)
    {
      paramString = new e(str, paramString);
      str = UUID.randomUUID().toString();
      long l = System.currentTimeMillis();
      boolean bool = c(paramString.a());
      return new a(str, l, true, Proxy.getVersion(), bool, paramString, false);
      str = paramString;
      continue;
      paramString = "";
      str = "";
    }
  }
  
  public static a a(Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    String str = UUID.randomUUID().toString();
    long l = System.currentTimeMillis();
    paramThrowable = new e(a(paramThrowable));
    paramThrowable.a(paramString);
    boolean bool = c(paramThrowable.a());
    return new a(str, l, false, Proxy.getVersion(), bool, paramThrowable, paramBoolean);
  }
  
  private static Throwable a(Throwable paramThrowable)
  {
    for (;;)
    {
      Throwable localThrowable = paramThrowable.getCause();
      if (localThrowable == null) {
        return paramThrowable;
      }
      paramThrowable = localThrowable;
    }
  }
  
  public static a b(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    String str1 = localJSONObject.optString("uuid");
    long l = localJSONObject.optLong("timestamp");
    boolean bool1 = localJSONObject.optBoolean("isNDK", false);
    String str2 = localJSONObject.optString("sdkVersion", "");
    boolean bool2 = localJSONObject.optBoolean("isSdkCrash", false);
    paramString = null;
    localJSONObject = localJSONObject.optJSONObject("exception");
    if (localJSONObject != null) {
      paramString = e.a(localJSONObject);
    }
    return new a(str1, l, bool1, str2, bool2, paramString, false);
  }
  
  private static boolean c(String paramString)
  {
    if (paramString.contains("com.mato.sdk")) {}
    while ((paramString.contains("libcom.maa.wspxld.so")) || (paramString.contains("wspx.rm")) || (paramString.contains("wspx:"))) {
      return true;
    }
    return false;
  }
  
  private static void j()
  {
    throw new RuntimeException("test");
  }
  
  public final boolean a()
  {
    return this.i;
  }
  
  public final long b()
  {
    return this.e;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final boolean d()
  {
    return this.f;
  }
  
  public final boolean e()
  {
    return this.h;
  }
  
  public final e f()
  {
    return this.g;
  }
  
  public final boolean g()
  {
    return (this.g != null) && (!TextUtils.isEmpty(this.j));
  }
  
  public final String h()
  {
    return this.j;
  }
  
  public final String i()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uuid", this.d.toString());
      ((JSONObject)localObject).put("timestamp", this.e);
      ((JSONObject)localObject).put("isSdkCrash", this.f);
      ((JSONObject)localObject).put("isNDK", this.h);
      ((JSONObject)localObject).put("sdkVersion", this.j);
      if (this.g != null) {
        ((JSONObject)localObject).put("exception", this.g.d());
      }
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */