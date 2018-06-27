package cn.testin.analysis;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class eq
  implements en
{
  protected static byte[] b = new byte[0];
  private ByteBuffer a;
  protected boolean c;
  protected ep d;
  protected boolean e;
  
  public eq() {}
  
  public eq(eo parameo)
  {
    this.c = parameo.d();
    this.d = parameo.f();
    this.a = parameo.c();
    this.e = parameo.e();
  }
  
  public eq(ep paramep)
  {
    this.d = paramep;
    this.a = ByteBuffer.wrap(b);
  }
  
  public void a(ep paramep)
  {
    this.d = paramep;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public ByteBuffer c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public ep f()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(fc.a(new String(this.a.array()))) + "}";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */