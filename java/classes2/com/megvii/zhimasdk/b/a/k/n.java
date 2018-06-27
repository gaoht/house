package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.d;
import java.io.Serializable;

public class n
  implements af, Serializable, Cloneable
{
  private final ac a;
  private final int b;
  private final String c;
  
  public n(ac paramac, int paramInt, String paramString)
  {
    this.a = ((ac)a.a(paramac, "Version"));
    this.b = a.b(paramInt, "Status code");
    this.c = paramString;
  }
  
  public ac a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String toString()
  {
    return i.b.a(null, this).toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */