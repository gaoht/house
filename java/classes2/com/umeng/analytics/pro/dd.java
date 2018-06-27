package com.umeng.analytics.pro;

public final class dd
{
  public final String a;
  public final byte b;
  public final int c;
  
  public dd()
  {
    this("", (byte)0, 0);
  }
  
  public dd(String paramString, byte paramByte, int paramInt)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramInt;
  }
  
  public boolean a(dd paramdd)
  {
    return (this.a.equals(paramdd.a)) && (this.b == paramdd.b) && (this.c == paramdd.c);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof dd)) {
      return a((dd)paramObject);
    }
    return false;
  }
  
  public String toString()
  {
    return "<TMessage name:'" + this.a + "' type: " + this.b + " seqid:" + this.c + ">";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */