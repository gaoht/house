package com.mato.sdk.c.d;

import com.mato.sdk.proxy.Proxy;

public class a
{
  private static int a = 1;
  private static boolean h;
  private final long b;
  private final int c;
  private final int d;
  private final String e;
  private final String f;
  private final String g;
  
  public a() {}
  
  public a(a parama)
  {
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.d = a.c(parama);
    this.e = a.d(parama);
    this.f = a.e(parama);
    this.g = a.f(parama);
  }
  
  private int b()
  {
    return this.c;
  }
  
  private int c()
  {
    return this.d;
  }
  
  private String d()
  {
    return this.e;
  }
  
  public final String a()
  {
    return String.valueOf(this.b) + "\t" + this.c + "\t" + this.d + "\t" + '"' + this.e + '"' + "\t" + '"' + this.f + '"' + "\t" + '"' + this.g + '"';
  }
  
  public final boolean a(a parama)
  {
    return (parama.c == this.c) && (parama.d == this.d) && (parama.e.equals(this.e));
  }
  
  public final boolean b(a parama)
  {
    return parama.b > this.b;
  }
  
  public static final class a
  {
    private long a;
    private int b;
    private int c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    
    public a()
    {
      this.g = true;
      this.f = Proxy.getVersion();
      this.a = System.currentTimeMillis();
    }
    
    public a(String paramString)
    {
      paramString = paramString.split("\t");
      if ((paramString == null) || (paramString.length < 6))
      {
        this.g = false;
        return;
      }
      try
      {
        this.a = Long.parseLong(paramString[0]);
        this.b = Integer.parseInt(paramString[1]);
        this.c = Integer.parseInt(paramString[2]);
        this.d = c(paramString[3]);
        this.e = c(paramString[4]);
        this.f = c(paramString[5]);
        this.g = true;
        return;
      }
      catch (Exception paramString)
      {
        this.g = false;
      }
    }
    
    private a a(long paramLong)
    {
      this.a = paramLong;
      return this;
    }
    
    private static String c(String paramString)
    {
      paramString = paramString.split("\"");
      if (paramString.length == 0) {
        return "";
      }
      return paramString[1];
    }
    
    public final a a(int paramInt)
    {
      this.b = 1;
      return this;
    }
    
    public final a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public final a a()
    {
      if (!this.g) {
        return null;
      }
      if (this.d == null) {
        this.d = "";
      }
      return new a(this);
    }
    
    public final a b(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public final a b(String paramString)
    {
      this.e = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */