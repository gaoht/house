package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.f;

public class a
  extends e
{
  private static final j f = new j();
  protected boolean a = false;
  protected boolean b = true;
  protected int c;
  protected boolean d = false;
  private byte[] g = new byte[1];
  private byte[] h = new byte[2];
  private byte[] i = new byte[4];
  private byte[] j = new byte[8];
  private byte[] k = new byte[1];
  private byte[] l = new byte[2];
  private byte[] m = new byte[4];
  private byte[] n = new byte[8];
  
  public a(org.apache.thrift.transport.d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramd);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d(paramInt2);
    return this.e.d(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a() {}
  
  public void a(byte paramByte)
  {
    this.g[0] = paramByte;
    this.e.b(this.g, 0, 1);
  }
  
  public void a(double paramDouble)
  {
    a(Double.doubleToLongBits(paramDouble));
  }
  
  public void a(int paramInt)
  {
    this.i[0] = ((byte)(paramInt >> 24 & 0xFF));
    this.i[1] = ((byte)(paramInt >> 16 & 0xFF));
    this.i[2] = ((byte)(paramInt >> 8 & 0xFF));
    this.i[3] = ((byte)(paramInt & 0xFF));
    this.e.b(this.i, 0, 4);
  }
  
  public void a(long paramLong)
  {
    this.j[0] = ((byte)(int)(paramLong >> 56 & 0xFF));
    this.j[1] = ((byte)(int)(paramLong >> 48 & 0xFF));
    this.j[2] = ((byte)(int)(paramLong >> 40 & 0xFF));
    this.j[3] = ((byte)(int)(paramLong >> 32 & 0xFF));
    this.j[4] = ((byte)(int)(paramLong >> 24 & 0xFF));
    this.j[5] = ((byte)(int)(paramLong >> 16 & 0xFF));
    this.j[6] = ((byte)(int)(paramLong >> 8 & 0xFF));
    this.j[7] = ((byte)(int)(0xFF & paramLong));
    this.e.b(this.j, 0, 8);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      a(paramString.length);
      this.e.b(paramString, 0, paramString.length);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new f("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit() - paramByteBuffer.position() - paramByteBuffer.arrayOffset();
    a(i1);
    this.e.b(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), i1);
  }
  
  public void a(b paramb)
  {
    a(paramb.b);
    a(paramb.c);
  }
  
  public void a(c paramc)
  {
    a(paramc.a);
    a(paramc.b);
  }
  
  public void a(d paramd)
  {
    a(paramd.a);
    a(paramd.b);
    a(paramd.c);
  }
  
  public void a(i parami)
  {
    a(parami.a);
    a(parami.b);
  }
  
  public void a(j paramj) {}
  
  public void a(short paramShort)
  {
    this.h[0] = ((byte)(paramShort >> 8 & 0xFF));
    this.h[1] = ((byte)(paramShort & 0xFF));
    this.e.b(this.h, 0, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 1;; b1 = 0)
    {
      a(b1);
      return;
    }
  }
  
  public String b(int paramInt)
  {
    try
    {
      d(paramInt);
      Object localObject = new byte[paramInt];
      this.e.d((byte[])localObject, 0, paramInt);
      localObject = new String((byte[])localObject, "UTF-8");
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new f("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void b() {}
  
  public void c()
  {
    a((byte)0);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
    this.d = true;
  }
  
  public void d() {}
  
  protected void d(int paramInt)
  {
    if (paramInt < 0) {
      throw new f("Negative length: " + paramInt);
    }
    if (this.d)
    {
      this.c -= paramInt;
      if (this.c < 0) {
        throw new f("Message length exceeded: " + paramInt);
      }
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public j g()
  {
    return f;
  }
  
  public void h() {}
  
  public b i()
  {
    byte b1 = r();
    if (b1 == 0) {}
    for (short s = 0;; s = s()) {
      return new b("", b1, s);
    }
  }
  
  public void j() {}
  
  public d k()
  {
    return new d(r(), r(), t());
  }
  
  public void l() {}
  
  public c m()
  {
    return new c(r(), t());
  }
  
  public void n() {}
  
  public i o()
  {
    return new i(r(), t());
  }
  
  public void p() {}
  
  public boolean q()
  {
    return r() == 1;
  }
  
  public byte r()
  {
    if (this.e.c() >= 1)
    {
      byte b1 = this.e.a()[this.e.b()];
      this.e.a(1);
      return b1;
    }
    a(this.k, 0, 1);
    return this.k[0];
  }
  
  public short s()
  {
    int i1 = 0;
    byte[] arrayOfByte = this.l;
    if (this.e.c() >= 2)
    {
      arrayOfByte = this.e.a();
      i1 = this.e.b();
      this.e.a(2);
    }
    for (;;)
    {
      int i2 = arrayOfByte[i1];
      return (short)(arrayOfByte[(i1 + 1)] & 0xFF | (i2 & 0xFF) << 8);
      a(this.l, 0, 2);
    }
  }
  
  public int t()
  {
    int i1 = 0;
    byte[] arrayOfByte = this.m;
    if (this.e.c() >= 4)
    {
      arrayOfByte = this.e.a();
      i1 = this.e.b();
      this.e.a(4);
    }
    for (;;)
    {
      int i2 = arrayOfByte[i1];
      int i3 = arrayOfByte[(i1 + 1)];
      int i4 = arrayOfByte[(i1 + 2)];
      return arrayOfByte[(i1 + 3)] & 0xFF | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 8;
      a(this.m, 0, 4);
    }
  }
  
  public long u()
  {
    int i1 = 0;
    byte[] arrayOfByte = this.n;
    if (this.e.c() >= 8)
    {
      arrayOfByte = this.e.a();
      i1 = this.e.b();
      this.e.a(8);
    }
    for (;;)
    {
      long l1 = arrayOfByte[i1] & 0xFF;
      long l2 = arrayOfByte[(i1 + 1)] & 0xFF;
      long l3 = arrayOfByte[(i1 + 2)] & 0xFF;
      long l4 = arrayOfByte[(i1 + 3)] & 0xFF;
      long l5 = arrayOfByte[(i1 + 4)] & 0xFF;
      long l6 = arrayOfByte[(i1 + 5)] & 0xFF;
      long l7 = arrayOfByte[(i1 + 6)] & 0xFF;
      return arrayOfByte[(i1 + 7)] & 0xFF | l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8;
      a(this.n, 0, 8);
    }
  }
  
  public double v()
  {
    return Double.longBitsToDouble(u());
  }
  
  public String w()
  {
    int i1 = t();
    if (this.e.c() >= i1) {
      try
      {
        String str = new String(this.e.a(), this.e.b(), i1, "UTF-8");
        this.e.a(i1);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new f("JVM DOES NOT SUPPORT UTF-8");
      }
    }
    return b(i1);
  }
  
  public ByteBuffer x()
  {
    int i1 = t();
    d(i1);
    if (this.e.c() >= i1)
    {
      localObject = ByteBuffer.wrap(this.e.a(), this.e.b(), i1);
      this.e.a(i1);
      return (ByteBuffer)localObject;
    }
    Object localObject = new byte[i1];
    this.e.d((byte[])localObject, 0, i1);
    return ByteBuffer.wrap((byte[])localObject);
  }
  
  public static class a
    implements g
  {
    protected boolean a = false;
    protected boolean b = true;
    protected int c;
    
    public a()
    {
      this(false, true);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this(paramBoolean1, paramBoolean2, 0);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramInt;
    }
    
    public e a(org.apache.thrift.transport.d paramd)
    {
      paramd = new a(paramd, this.a, this.b);
      if (this.c != 0) {
        paramd.c(this.c);
      }
      return paramd;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/apache/thrift/protocol/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */