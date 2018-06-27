package com.megvii.zhimasdk.b.a.b.c;

import com.megvii.zhimasdk.b.a.b.f.a;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.l;

public abstract class e
  extends i
  implements l
{
  private k c;
  
  public void a(k paramk)
  {
    this.c = paramk;
  }
  
  public boolean b()
  {
    com.megvii.zhimasdk.b.a.e locale = c("Expect");
    return (locale != null) && ("100-continue".equalsIgnoreCase(locale.d()));
  }
  
  public k c()
  {
    return this.c;
  }
  
  public Object clone()
  {
    e locale = (e)super.clone();
    if (this.c != null) {
      locale.c = ((k)a.a(this.c));
    }
    return locale;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */