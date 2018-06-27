package org.apache.thrift;

import org.apache.thrift.protocol.a.a;
import org.apache.thrift.protocol.g;
import org.apache.thrift.transport.c;

public class e
{
  private final org.apache.thrift.protocol.e a;
  private final c b = new c();
  
  public e()
  {
    this(new a.a());
  }
  
  public e(g paramg)
  {
    this.a = paramg.a(this.b);
  }
  
  public void a(a parama, byte[] paramArrayOfByte)
  {
    try
    {
      this.b.a(paramArrayOfByte);
      parama.a(this.a);
      return;
    }
    finally
    {
      this.a.y();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */