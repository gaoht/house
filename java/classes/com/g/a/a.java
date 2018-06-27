package com.g.a;

public abstract class a
{
  public static a a = new aa("TRACKING", 1);
  public static a b = new ay("ENV", 2);
  public static a[] c = { a, b };
  private String d;
  private int e;
  
  protected a(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = paramInt;
  }
  
  public static a a(String paramString)
  {
    if (paramString.equals(a.b())) {
      return a;
    }
    if (paramString.equals(b.b())) {
      return b;
    }
    return null;
  }
  
  public static a[] a()
  {
    return c;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public String d()
  {
    return "";
  }
  
  public abstract String e();
  
  public abstract String f();
  
  public abstract String g();
  
  public abstract String h();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */