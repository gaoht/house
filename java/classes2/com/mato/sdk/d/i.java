package com.mato.sdk.d;

import com.mato.sdk.b.g;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final String a = g.b("");
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 0;
  private static int g = 1;
  private static int h = 2;
  private static int i = 3;
  private static int j = 1;
  private static int k = 2;
  private static int l = 3;
  private static int m = 4;
  private static int n = 5;
  private int o = 2;
  private int p = 1;
  private int q = 1;
  private String r = "maabiz1.chinanetcenter.com";
  private int s = 6666;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private int x = 16;
  private final int y;
  private String z = "";
  
  public i(int paramInt)
  {
    this.y = paramInt;
  }
  
  private void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      this.p = paramInt;
      return;
    }
    new StringBuilder("Invalid protocol : ").append(paramInt);
  }
  
  private void b(String paramString)
  {
    this.r = paramString;
  }
  
  private void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  private void c(int paramInt)
  {
    if ((paramInt <= 5) && (paramInt > 0))
    {
      this.q = paramInt;
      return;
    }
    new StringBuilder("Invalid compressType : ").append(paramInt);
  }
  
  private void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  private void d(int paramInt)
  {
    this.s = paramInt;
  }
  
  private void d(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  private void e(int paramInt)
  {
    this.x = paramInt;
  }
  
  private static String m()
  {
    return "";
  }
  
  private static int n()
  {
    return 0;
  }
  
  private int o()
  {
    switch (this.p)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 3;
    }
    return 5;
  }
  
  private boolean p()
  {
    int i1 = this.p;
    return (i1 == 1) || (i1 == 2) || (i1 == 3);
  }
  
  public final String a()
  {
    return this.z;
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      this.o = paramInt;
      return;
    }
    new StringBuilder("Invalid compressPolicy : ").append(paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    int i1 = paramJSONObject.optInt("compressionPolicy", this.o);
    if ((i1 >= 0) && (i1 <= 3))
    {
      this.o = i1;
      i1 = paramJSONObject.optInt("protocol", this.p);
      if ((i1 < 0) || (i1 > 3)) {
        break label206;
      }
      this.p = i1;
      label50:
      i1 = paramJSONObject.optInt("compressionType", this.q);
      if ((i1 > 5) || (i1 <= 0)) {
        break label223;
      }
      this.q = i1;
    }
    for (;;)
    {
      this.s = paramJSONObject.optInt("cachePeerPort", this.s);
      this.t = paramJSONObject.optBoolean("forceGzip", this.t);
      this.u = paramJSONObject.optBoolean("forceWsgDecode", this.u);
      this.v = paramJSONObject.optBoolean("alwaysBackSource", this.v);
      this.x = paramJSONObject.optInt("wspInitWindow", this.x);
      this.w = paramJSONObject.optBoolean("useWmp", this.w);
      this.r = paramJSONObject.optString("cachePeerHost", this.r);
      this.z = paramJSONObject.optString("backupIP", this.z);
      return true;
      new StringBuilder("Invalid compressPolicy : ").append(i1);
      break;
      label206:
      new StringBuilder("Invalid protocol : ").append(i1);
      break label50;
      label223:
      new StringBuilder("Invalid compressType : ").append(i1);
    }
  }
  
  public final boolean b()
  {
    return this.v;
  }
  
  public final boolean c()
  {
    return this.u;
  }
  
  public final int d()
  {
    return this.p;
  }
  
  public final int e()
  {
    return this.q;
  }
  
  public final String f()
  {
    return this.r;
  }
  
  public final int g()
  {
    return this.s;
  }
  
  public final boolean h()
  {
    return this.t;
  }
  
  public final int i()
  {
    return this.o;
  }
  
  public final boolean j()
  {
    return this.w;
  }
  
  public final int k()
  {
    return this.x;
  }
  
  public final int l()
  {
    return this.y;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */