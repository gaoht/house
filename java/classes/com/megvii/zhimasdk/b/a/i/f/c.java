package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.o.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
public abstract class c
  implements com.megvii.zhimasdk.b.a.j.a, f
{
  private InputStream a;
  private byte[] b;
  private com.megvii.zhimasdk.b.a.o.c c;
  private Charset d;
  private boolean e;
  private int f;
  private int g;
  private k h;
  private CodingErrorAction i;
  private CodingErrorAction j;
  private int k;
  private int l;
  private CharsetDecoder m;
  private CharBuffer n;
  
  private int a(d paramd, int paramInt)
  {
    int i2 = this.k;
    this.k = (paramInt + 1);
    int i1 = paramInt;
    if (paramInt > i2)
    {
      i1 = paramInt;
      if (this.b[(paramInt - 1)] == 13) {
        i1 = paramInt - 1;
      }
    }
    paramInt = i1 - i2;
    if (this.e)
    {
      paramd.a(this.b, i2, paramInt);
      return paramInt;
    }
    return a(paramd, ByteBuffer.wrap(this.b, i2, paramInt));
  }
  
  private int a(d paramd, ByteBuffer paramByteBuffer)
  {
    int i1 = 0;
    if (!paramByteBuffer.hasRemaining()) {
      return 0;
    }
    if (this.m == null)
    {
      this.m = this.d.newDecoder();
      this.m.onMalformedInput(this.i);
      this.m.onUnmappableCharacter(this.j);
    }
    if (this.n == null) {
      this.n = CharBuffer.allocate(1024);
    }
    this.m.reset();
    while (paramByteBuffer.hasRemaining()) {
      i1 += a(this.m.decode(paramByteBuffer, this.n, true), paramd, paramByteBuffer);
    }
    int i2 = a(this.m.flush(this.n), paramd, paramByteBuffer);
    this.n.clear();
    return i1 + i2;
  }
  
  private int a(CoderResult paramCoderResult, d paramd, ByteBuffer paramByteBuffer)
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.n.flip();
    int i1 = this.n.remaining();
    while (this.n.hasRemaining()) {
      paramd.a(this.n.get());
    }
    this.n.compact();
    return i1;
  }
  
  private int b(d paramd)
  {
    int i3 = this.c.d();
    int i1 = i3;
    if (i3 > 0)
    {
      int i2 = i3;
      if (this.c.b(i3 - 1) == 10) {
        i2 = i3 - 1;
      }
      i1 = i2;
      if (i2 > 0)
      {
        i1 = i2;
        if (this.c.b(i2 - 1) == 13) {
          i1 = i2 - 1;
        }
      }
    }
    if (this.e) {
      paramd.a(this.c, 0, i1);
    }
    for (;;)
    {
      this.c.a();
      return i1;
      i1 = a(paramd, ByteBuffer.wrap(this.c.e(), 0, i1));
    }
  }
  
  private int c()
  {
    int i1 = this.k;
    while (i1 < this.l)
    {
      if (this.b[i1] == 10) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a()
  {
    while (!g()) {
      if (f() == -1) {
        return -1;
      }
    }
    byte[] arrayOfByte = this.b;
    int i1 = this.k;
    this.k = (i1 + 1);
    return arrayOfByte[i1] & 0xFF;
  }
  
  public int a(d paramd)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramd, "Char array buffer");
    int i2 = 1;
    int i3 = 0;
    if (i2 != 0)
    {
      int i1 = c();
      int i4;
      if (i1 != -1)
      {
        if (this.c.f()) {
          return a(paramd, i1);
        }
        i2 = this.k;
        this.c.a(this.b, this.k, i1 + 1 - i2);
        this.k = (i1 + 1);
        i1 = 0;
        i4 = i3;
      }
      for (;;)
      {
        i2 = i1;
        i3 = i4;
        if (this.f <= 0) {
          break;
        }
        i2 = i1;
        i3 = i4;
        if (this.c.d() < this.f) {
          break;
        }
        throw new IOException("Maximum line length limit exceeded");
        if (g())
        {
          i1 = this.l;
          i3 = this.k;
          this.c.a(this.b, this.k, i1 - i3);
          this.k = this.l;
        }
        i3 = f();
        i1 = i2;
        i4 = i3;
        if (i3 == -1)
        {
          i1 = 0;
          i4 = i3;
        }
      }
    }
    if ((i3 == -1) && (this.c.f())) {
      return -1;
    }
    return b(paramd);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      paramInt1 = 0;
    }
    do
    {
      return paramInt1;
      if (g())
      {
        paramInt2 = Math.min(paramInt2, this.l - this.k);
        System.arraycopy(this.b, this.k, paramArrayOfByte, paramInt1, paramInt2);
        this.k += paramInt2;
        return paramInt2;
      }
      if (paramInt2 <= this.g) {
        break;
      }
      paramInt2 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    this.h.a(paramInt2);
    return paramInt2;
    while (!g()) {
      if (f() == -1) {
        return -1;
      }
    }
    paramInt2 = Math.min(paramInt2, this.l - this.k);
    System.arraycopy(this.b, this.k, paramArrayOfByte, paramInt1, paramInt2);
    this.k += paramInt2;
    return paramInt2;
  }
  
  protected void a(InputStream paramInputStream, int paramInt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramInputStream, "Input stream");
    com.megvii.zhimasdk.b.a.o.a.b(paramInt, "Buffer size");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    this.a = paramInputStream;
    this.b = new byte[paramInt];
    this.k = 0;
    this.l = 0;
    this.c = new com.megvii.zhimasdk.b.a.o.c(paramInt);
    paramInputStream = (String)parame.a("http.protocol.element-charset");
    if (paramInputStream != null)
    {
      paramInputStream = Charset.forName(paramInputStream);
      this.d = paramInputStream;
      this.e = this.d.equals(com.megvii.zhimasdk.b.a.c.b);
      this.m = null;
      this.f = parame.a("http.connection.max-line-length", -1);
      this.g = parame.a("http.connection.min-chunk-limit", 512);
      this.h = d();
      paramInputStream = (CodingErrorAction)parame.a("http.malformed.input.action");
      if (paramInputStream == null) {
        break label189;
      }
      label154:
      this.i = paramInputStream;
      paramInputStream = (CodingErrorAction)parame.a("http.unmappable.input.action");
      if (paramInputStream == null) {
        break label196;
      }
    }
    for (;;)
    {
      this.j = paramInputStream;
      return;
      paramInputStream = com.megvii.zhimasdk.b.a.c.b;
      break;
      label189:
      paramInputStream = CodingErrorAction.REPORT;
      break label154;
      label196:
      paramInputStream = CodingErrorAction.REPORT;
    }
  }
  
  public com.megvii.zhimasdk.b.a.j.e b()
  {
    return this.h;
  }
  
  protected k d()
  {
    return new k();
  }
  
  public int e()
  {
    return this.l - this.k;
  }
  
  protected int f()
  {
    if (this.k > 0)
    {
      i1 = this.l - this.k;
      if (i1 > 0) {
        System.arraycopy(this.b, this.k, this.b, 0, i1);
      }
      this.k = 0;
      this.l = i1;
    }
    int i1 = this.l;
    int i2 = this.b.length;
    i2 = this.a.read(this.b, i1, i2 - i1);
    if (i2 == -1) {
      return -1;
    }
    this.l = (i1 + i2);
    this.h.a(i2);
    return i2;
  }
  
  protected boolean g()
  {
    return this.k < this.l;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */