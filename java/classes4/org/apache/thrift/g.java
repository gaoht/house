package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import org.apache.thrift.protocol.a.a;
import org.apache.thrift.protocol.e;

public class g
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final org.apache.thrift.transport.a b = new org.apache.thrift.transport.a(this.a);
  private e c;
  
  public g()
  {
    this(new a.a());
  }
  
  public g(org.apache.thrift.protocol.g paramg)
  {
    this.c = paramg.a(this.b);
  }
  
  public byte[] a(a parama)
  {
    this.a.reset();
    parama.b(this.c);
    return this.a.toByteArray();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */