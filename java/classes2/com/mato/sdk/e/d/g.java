package com.mato.sdk.e.d;

import android.text.TextUtils;
import com.mato.sdk.d.c;
import org.json.JSONObject;

public final class g
{
  private static final int b = -1;
  private static final String c = "taskId";
  private static final String d = "url";
  private static final String e = "connectTimeout";
  private static final String f = "totalTimeout";
  private static final String g = "host";
  private static final String h = "port";
  private static final String i = "protocol";
  private static final String j = "compressionType";
  private static final String k = "forceWzip";
  final f a;
  private final String l;
  private final String m;
  private final long n;
  private final long o;
  private final String p;
  private final int q;
  private final int r;
  private final int s;
  private final boolean t;
  private final int u;
  
  private g(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    this.l = paramString1;
    this.m = paramString2;
    this.n = paramLong1;
    this.o = paramLong2;
    this.p = paramString3;
    this.q = paramInt1;
    this.r = paramInt2;
    this.s = paramInt3;
    this.t = paramBoolean;
    this.u = paramInt4;
    this.a = new f(paramString1);
  }
  
  public static g a(JSONObject paramJSONObject, int paramInt)
  {
    return new g(paramJSONObject.optString("taskId", ""), c.a(paramJSONObject.optString("url", "")), paramJSONObject.optLong("connectTimeout", -1L), paramJSONObject.optLong("totalTimeout", -1L), paramJSONObject.optString("host", ""), paramJSONObject.optInt("port", -1), paramJSONObject.optInt("protocol", -1), paramJSONObject.optInt("compressionType", -1), paramJSONObject.optBoolean("forceWzip", false), paramInt);
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt >= 100) && (paramInt < 199);
  }
  
  public final int a()
  {
    return this.u;
  }
  
  public final String b()
  {
    return this.l;
  }
  
  public final String c()
  {
    return this.m;
  }
  
  public final long d()
  {
    return this.n;
  }
  
  public final long e()
  {
    return this.o;
  }
  
  public final String f()
  {
    return this.p;
  }
  
  public final int g()
  {
    return this.q;
  }
  
  public final int h()
  {
    return this.r;
  }
  
  public final int i()
  {
    return this.s;
  }
  
  public final boolean j()
  {
    return this.t;
  }
  
  public final boolean k()
  {
    if ((!TextUtils.isEmpty(this.l)) && (!TextUtils.isEmpty(this.m)) && (this.n != -1L) && (this.o != -1L) && (!TextUtils.isEmpty(this.p)) && (this.q != -1) && (this.r != -1) && (this.s != -1))
    {
      int i1 = this.u;
      if ((i1 >= 100) && (i1 < 199)) {}
      for (i1 = 1; i1 != 0; i1 = 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */