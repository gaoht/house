package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class k
  extends a
{
  private static int f = 10000;
  private static int g = 10000;
  private static int h = 10000;
  private static int i = 10485760;
  private static int j = 104857600;
  
  public k(org.apache.thrift.transport.d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramd, paramBoolean1, paramBoolean2);
  }
  
  public d k()
  {
    byte b1 = r();
    byte b2 = r();
    int k = t();
    if (k > f) {
      throw new f(3, "Thrift map size " + k + " out of range!");
    }
    return new d(b1, b2, k);
  }
  
  public c m()
  {
    byte b = r();
    int k = t();
    if (k > g) {
      throw new f(3, "Thrift list size " + k + " out of range!");
    }
    return new c(b, k);
  }
  
  public i o()
  {
    byte b = r();
    int k = t();
    if (k > h) {
      throw new f(3, "Thrift set size " + k + " out of range!");
    }
    return new i(b, k);
  }
  
  public String w()
  {
    int k = t();
    if (k > i) {
      throw new f(3, "Thrift string size " + k + " out of range!");
    }
    if (this.e.c() >= k) {
      try
      {
        String str = new String(this.e.a(), this.e.b(), k, "UTF-8");
        this.e.a(k);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new org.apache.thrift.f("JVM DOES NOT SUPPORT UTF-8");
      }
    }
    return b(k);
  }
  
  public ByteBuffer x()
  {
    int k = t();
    if (k > j) {
      throw new f(3, "Thrift binary size " + k + " out of range!");
    }
    d(k);
    if (this.e.c() >= k)
    {
      localObject = ByteBuffer.wrap(this.e.a(), this.e.b(), k);
      this.e.a(k);
      return (ByteBuffer)localObject;
    }
    Object localObject = new byte[k];
    this.e.d((byte[])localObject, 0, k);
    return ByteBuffer.wrap((byte[])localObject);
  }
  
  public static class a
    extends a.a
  {
    public a()
    {
      super(true);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      super(paramBoolean2, paramInt);
    }
    
    public e a(org.apache.thrift.transport.d paramd)
    {
      paramd = new k(paramd, this.a, this.b);
      if (this.c != 0) {
        paramd.c(this.c);
      }
      return paramd;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/protocol/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */