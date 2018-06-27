package com.superrtc.call;

public class q
{
  public final a a;
  public final String b;
  
  public q(a parama, String paramString)
  {
    this.a = parama;
    this.b = paramString;
  }
  
  public static enum a
  {
    private a() {}
    
    public static a fromCanonicalForm(String paramString)
    {
      return (a)valueOf(a.class, paramString.toUpperCase());
    }
    
    public String canonicalForm()
    {
      return name().toLowerCase();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */