package com.megvii.zhimasdk.b.a.e;

import com.megvii.zhimasdk.b.a.g.f;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

@Deprecated
public class a
  extends f
  implements i, l
{
  protected o a;
  protected final boolean b;
  
  public a(com.megvii.zhimasdk.b.a.k paramk, o paramo, boolean paramBoolean)
  {
    super(paramk);
    com.megvii.zhimasdk.b.a.o.a.a(paramo, "Connection");
    this.a = paramo;
    this.b = paramBoolean;
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/megvii/zhimasdk/b/a/e/a:a	Lcom/megvii/zhimasdk/b/a/e/o;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 29	com/megvii/zhimasdk/b/a/e/a:b	Z
    //   12: ifeq +24 -> 36
    //   15: aload_0
    //   16: getfield 36	com/megvii/zhimasdk/b/a/e/a:d	Lcom/megvii/zhimasdk/b/a/k;
    //   19: invokestatic 40	com/megvii/zhimasdk/b/a/o/f:a	(Lcom/megvii/zhimasdk/b/a/k;)V
    //   22: aload_0
    //   23: getfield 27	com/megvii/zhimasdk/b/a/e/a:a	Lcom/megvii/zhimasdk/b/a/e/o;
    //   26: invokeinterface 45 1 0
    //   31: aload_0
    //   32: invokevirtual 46	com/megvii/zhimasdk/b/a/e/a:k	()V
    //   35: return
    //   36: aload_0
    //   37: getfield 27	com/megvii/zhimasdk/b/a/e/a:a	Lcom/megvii/zhimasdk/b/a/e/o;
    //   40: invokeinterface 48 1 0
    //   45: goto -14 -> 31
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 46	com/megvii/zhimasdk/b/a/e/a:k	()V
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	a
    //   48	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	31	48	finally
    //   36	45	48	finally
  }
  
  public InputStream a()
  {
    return new k(this.d.a(), this);
  }
  
  public void a(OutputStream paramOutputStream)
  {
    super.a(paramOutputStream);
    l();
  }
  
  /* Error */
  public boolean a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/megvii/zhimasdk/b/a/e/a:a	Lcom/megvii/zhimasdk/b/a/e/o;
    //   4: ifnull +23 -> 27
    //   7: aload_0
    //   8: getfield 29	com/megvii/zhimasdk/b/a/e/a:b	Z
    //   11: ifeq +22 -> 33
    //   14: aload_1
    //   15: invokevirtual 68	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: getfield 27	com/megvii/zhimasdk/b/a/e/a:a	Lcom/megvii/zhimasdk/b/a/e/o;
    //   22: invokeinterface 45 1 0
    //   27: aload_0
    //   28: invokevirtual 46	com/megvii/zhimasdk/b/a/e/a:k	()V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 27	com/megvii/zhimasdk/b/a/e/a:a	Lcom/megvii/zhimasdk/b/a/e/o;
    //   37: invokeinterface 48 1 0
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 46	com/megvii/zhimasdk/b/a/e/a:k	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	a
    //   0	52	1	paramInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   0	27	45	finally
    //   33	42	45	finally
  }
  
  public boolean b(InputStream paramInputStream)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.a != null)
        {
          if (this.b) {
            bool = this.a.c();
          }
        }
        else {
          try
          {
            paramInputStream.close();
            this.a.k();
            return false;
          }
          catch (SocketException paramInputStream)
          {
            if (!bool) {
              continue;
            }
            throw paramInputStream;
          }
        }
        this.a.l();
      }
      finally
      {
        k();
      }
    }
  }
  
  @Deprecated
  public void c()
  {
    l();
  }
  
  public boolean c(InputStream paramInputStream)
  {
    if (this.a != null) {
      this.a.j();
    }
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void i()
  {
    l();
  }
  
  public void j()
  {
    if (this.a != null) {}
    try
    {
      this.a.j();
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  protected void k()
  {
    if (this.a != null) {}
    try
    {
      this.a.i();
      return;
    }
    finally
    {
      this.a = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */