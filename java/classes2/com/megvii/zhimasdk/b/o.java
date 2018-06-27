package com.megvii.zhimasdk.b;

import com.megvii.zhimasdk.b.a.b.c.j;
import java.io.File;

public abstract class o
  extends h
{
  private long b;
  private boolean c;
  
  public void a(j paramj)
  {
    if ((this.a.exists()) && (this.a.canWrite())) {
      this.b = this.a.length();
    }
    if (this.b > 0L)
    {
      this.c = true;
      paramj.b("Range", "bytes=" + this.b + "-");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */