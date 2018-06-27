package com.unionpay.mobile.android.model;

public final class a
  implements c
{
  private int a = 2;
  private int b = 0;
  private String c = null;
  private String d = null;
  private String e = null;
  private String f;
  
  public a()
  {
    this.c = null;
    this.d = null;
    this.e = null;
  }
  
  public a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
  }
  
  private a(String paramString1, String paramString2, String paramString3)
  {
    this(0, paramString1, paramString2, paramString3, 2);
  }
  
  public a(String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this(paramString1, paramString2, paramString3);
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
  }
  
  public final String b()
  {
    return this.e;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.a;
  }
  
  public final String e()
  {
    if (this.b == 0) {
      return this.d;
    }
    return String.format("<font color=\"#FF0000\">%s</font>", new Object[] { this.f });
  }
  
  public final String toString()
  {
    return this.c + "," + this.d + "," + this.e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */