package c.a.b.e;

import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class g
  implements a
{
  private boolean a;
  private a.a b;
  private ByteBuffer c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public g(a.a parama)
  {
    this.b = parama;
    this.c = c.a.b.b.b.a();
    this.a = true;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
  }
  
  public static g a(a.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("Supplied opcode cannot be null");
    }
    switch (1.a[parama.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Supplied opcode is invalid");
    case 1: 
      return new h();
    case 2: 
      return new i();
    case 3: 
      return new j();
    case 4: 
      return new b();
    case 5: 
      return new c();
    }
    return new d();
  }
  
  public void a(a parama)
  {
    ByteBuffer localByteBuffer1 = parama.d();
    if (this.c == null)
    {
      this.c = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.c.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.a = parama.e();
      return;
    }
    localByteBuffer1.mark();
    this.c.position(this.c.limit());
    this.c.limit(this.c.capacity());
    if (localByteBuffer1.remaining() > this.c.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.c.capacity());
      this.c.flip();
      localByteBuffer2.put(this.c);
      localByteBuffer2.put(localByteBuffer1);
      this.c = localByteBuffer2;
    }
    for (;;)
    {
      this.c.rewind();
      localByteBuffer1.reset();
      break;
      this.c.put(localByteBuffer1);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.c = paramByteBuffer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public abstract void c()
    throws c.a.b.d.b;
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public ByteBuffer d()
  {
    return this.c;
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public boolean g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return this.d;
  }
  
  public a.a j()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "Framedata{ optcode:" + j() + ", fin:" + e() + ", rsv1:" + f() + ", rsv2:" + g() + ", rsv3:" + h() + ", payloadlength:[pos:" + this.c.position() + ", len:" + this.c.remaining() + "], payload:" + Arrays.toString(c.a.b.b.c.a(new String(this.c.array()))) + "}";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */