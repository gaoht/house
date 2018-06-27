package com.superrtc.call;

public class s
{
  public final String a;
  public final String b;
  public final double c;
  public final a[] d;
  
  public s(String paramString1, String paramString2, double paramDouble, a[] paramArrayOfa)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDouble;
    this.d = paramArrayOfa;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.a).append(", type: ").append(this.b).append(", timestamp: ").append(this.c).append(", values: ");
    int i = 0;
    while (i < this.d.length)
    {
      localStringBuilder.append(this.d[i].toString()).append(", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public final String a;
    public final String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append(this.a).append(": ").append(this.b).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */