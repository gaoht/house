package cn.testin.analysis;

import java.io.Serializable;
import java.util.Comparator;

final class im
  implements Serializable, Comparator<ii>
{
  private final float a;
  
  private im(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public int a(ii paramii1, ii paramii2)
  {
    float f1 = Math.abs(paramii2.c() - this.a);
    float f2 = Math.abs(paramii1.c() - this.a);
    if (f1 < f2) {
      return -1;
    }
    if (f1 > f2) {
      return 1;
    }
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/im.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */