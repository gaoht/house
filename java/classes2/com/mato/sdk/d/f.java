package com.mato.sdk.d;

import android.text.TextUtils;
import org.json.JSONObject;

public final class f
{
  private static final int a = 10;
  private static final int b = 100;
  private static String c = "http://mlog.chinanetcenter.com/file";
  private static int d = -1;
  private static final String h = "num";
  private static final String i = "totalNum";
  private static final String j = "reportUrl";
  private final int e;
  private final int f;
  private final String g;
  
  public f()
  {
    this(10, 100, "http://mlog.chinanetcenter.com/file");
  }
  
  private f(int paramInt1, int paramInt2, String paramString)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramString;
  }
  
  public static f a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.optInt("num", 10);
    String str = paramJSONObject.optString("reportUrl", "http://mlog.chinanetcenter.com/file");
    return new f(k, paramJSONObject.optInt("totalNum", 100), str);
  }
  
  public final int a()
  {
    return this.e;
  }
  
  public final boolean a(f paramf)
  {
    return (this.e == paramf.e) && (this.f == paramf.f) && (TextUtils.equals(this.g, paramf.g));
  }
  
  public final String b()
  {
    return this.g;
  }
  
  public final int c()
  {
    return this.f;
  }
  
  public final boolean d()
  {
    return this.f == -1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */