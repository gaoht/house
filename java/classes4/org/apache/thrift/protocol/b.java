package org.apache.thrift.protocol;

public class b
{
  public final String a;
  public final byte b;
  public final short c;
  
  public b()
  {
    this("", (byte)0, (short)0);
  }
  
  public b(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }
  
  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/protocol/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */