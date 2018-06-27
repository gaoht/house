package com.umeng.analytics.pro;

public class da
{
  public final String a;
  public final byte b;
  public final short c;
  
  public da()
  {
    this("", (byte)0, (short)0);
  }
  
  public da(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }
  
  public boolean a(da paramda)
  {
    return (this.b == paramda.b) && (this.c == paramda.c);
  }
  
  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */