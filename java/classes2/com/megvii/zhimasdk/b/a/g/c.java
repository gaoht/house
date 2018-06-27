package com.megvii.zhimasdk.b.a.g;

import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class c
  extends f
{
  private final byte[] a;
  
  public c(k paramk)
  {
    super(paramk);
    if ((!paramk.d()) || (paramk.b() < 0L))
    {
      this.a = com.megvii.zhimasdk.b.a.o.f.b(paramk);
      return;
    }
    this.a = null;
  }
  
  public InputStream a()
  {
    if (this.a != null) {
      return new ByteArrayInputStream(this.a);
    }
    return super.a();
  }
  
  public void a(OutputStream paramOutputStream)
  {
    a.a(paramOutputStream, "Output stream");
    if (this.a != null)
    {
      paramOutputStream.write(this.a);
      return;
    }
    super.a(paramOutputStream);
  }
  
  public long b()
  {
    if (this.a != null) {
      return this.a.length;
    }
    return super.b();
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean e()
  {
    return (this.a == null) && (super.e());
  }
  
  public boolean f()
  {
    return (this.a == null) && (super.f());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */