package com.megvii.zhimasdk.b.a;

import java.io.Serializable;

public final class v
  extends ac
  implements Serializable
{
  public static final v a = new v(0, 9);
  public static final v b = new v(1, 0);
  public static final v c = new v(1, 1);
  
  public v(int paramInt1, int paramInt2)
  {
    super("HTTP", paramInt1, paramInt2);
  }
  
  public ac a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.e) && (paramInt2 == this.f)) {
      return this;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0) {
        return b;
      }
      if (paramInt2 == 1) {
        return c;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 9)) {
      return a;
    }
    return new v(paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */