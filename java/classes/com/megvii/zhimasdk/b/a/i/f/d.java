package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.g;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
public abstract class d
  implements com.megvii.zhimasdk.b.a.j.a, g
{
  private static final byte[] a = { 13, 10 };
  private OutputStream b;
  private com.megvii.zhimasdk.b.a.o.c c;
  private Charset d;
  private boolean e;
  private int f;
  private k g;
  private CodingErrorAction h;
  private CodingErrorAction i;
  private CharsetEncoder j;
  private ByteBuffer k;
  
  private void a(CharBuffer paramCharBuffer)
  {
    if (!paramCharBuffer.hasRemaining()) {
      return;
    }
    if (this.j == null)
    {
      this.j = this.d.newEncoder();
      this.j.onMalformedInput(this.h);
      this.j.onUnmappableCharacter(this.i);
    }
    if (this.k == null) {
      this.k = ByteBuffer.allocate(1024);
    }
    this.j.reset();
    while (paramCharBuffer.hasRemaining()) {
      a(this.j.encode(paramCharBuffer, this.k, true));
    }
    a(this.j.flush(this.k));
    this.k.clear();
  }
  
  private void a(CoderResult paramCoderResult)
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.k.flip();
    while (this.k.hasRemaining()) {
      a(this.k.get());
    }
    this.k.compact();
  }
  
  public void a()
  {
    d();
    this.b.flush();
  }
  
  public void a(int paramInt)
  {
    if (this.c.g()) {
      d();
    }
    this.c.a(paramInt);
  }
  
  public void a(com.megvii.zhimasdk.b.a.o.d paramd)
  {
    int n = 0;
    if (paramd == null) {
      return;
    }
    if (this.e)
    {
      int m = paramd.c();
      while (m > 0)
      {
        int i1 = Math.min(this.c.c() - this.c.d(), m);
        if (i1 > 0) {
          this.c.a(paramd, n, i1);
        }
        if (this.c.g()) {
          d();
        }
        n += i1;
        m -= i1;
      }
    }
    a(CharBuffer.wrap(paramd.b(), 0, paramd.c()));
    a(a);
  }
  
  protected void a(OutputStream paramOutputStream, int paramInt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramOutputStream, "Input stream");
    com.megvii.zhimasdk.b.a.o.a.b(paramInt, "Buffer size");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    this.b = paramOutputStream;
    this.c = new com.megvii.zhimasdk.b.a.o.c(paramInt);
    paramOutputStream = (String)parame.a("http.protocol.element-charset");
    if (paramOutputStream != null)
    {
      paramOutputStream = Charset.forName(paramOutputStream);
      this.d = paramOutputStream;
      this.e = this.d.equals(com.megvii.zhimasdk.b.a.c.b);
      this.j = null;
      this.f = parame.a("http.connection.min-chunk-limit", 512);
      this.g = c();
      paramOutputStream = (CodingErrorAction)parame.a("http.malformed.input.action");
      if (paramOutputStream == null) {
        break label156;
      }
      label122:
      this.h = paramOutputStream;
      paramOutputStream = (CodingErrorAction)parame.a("http.unmappable.input.action");
      if (paramOutputStream == null) {
        break label163;
      }
    }
    for (;;)
    {
      this.i = paramOutputStream;
      return;
      paramOutputStream = com.megvii.zhimasdk.b.a.c.b;
      break;
      label156:
      paramOutputStream = CodingErrorAction.REPORT;
      break label122;
      label163:
      paramOutputStream = CodingErrorAction.REPORT;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.length() > 0)
    {
      if (this.e)
      {
        int m = 0;
        while (m < paramString.length())
        {
          a(paramString.charAt(m));
          m += 1;
        }
      }
      a(CharBuffer.wrap(paramString));
    }
    a(a);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if ((paramInt2 > this.f) || (paramInt2 > this.c.c()))
    {
      d();
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      this.g.a(paramInt2);
      return;
    }
    if (paramInt2 > this.c.c() - this.c.d()) {
      d();
    }
    this.c.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public com.megvii.zhimasdk.b.a.j.e b()
  {
    return this.g;
  }
  
  protected k c()
  {
    return new k();
  }
  
  protected void d()
  {
    int m = this.c.d();
    if (m > 0)
    {
      this.b.write(this.c.e(), 0, m);
      this.c.a();
      this.g.a(m);
    }
  }
  
  public int e()
  {
    return this.c.d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */