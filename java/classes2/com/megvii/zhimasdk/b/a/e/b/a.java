package com.megvii.zhimasdk.b.a.e.b;

import com.megvii.zhimasdk.b.a.n;
import java.net.InetAddress;

public class a
  implements c
{
  protected int a(e parame)
  {
    int i = 1;
    if (parame.c() > 1) {
      i = 2;
    }
    return i;
  }
  
  public int a(e parame1, e parame2)
  {
    com.megvii.zhimasdk.b.a.o.a.a(parame1, "Planned route");
    if ((parame2 == null) || (parame2.c() < 1)) {
      return a(parame1);
    }
    if (parame1.c() > 1) {
      return c(parame1, parame2);
    }
    return b(parame1, parame2);
  }
  
  protected int b(e parame1, e parame2)
  {
    if (parame2.c() > 1) {}
    while ((!parame1.a().equals(parame2.a())) || (parame1.g() != parame2.g()) || ((parame1.b() != null) && (!parame1.b().equals(parame2.b())))) {
      return -1;
    }
    return 0;
  }
  
  protected int c(e parame1, e parame2)
  {
    if (parame2.c() <= 1) {}
    label90:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          do
          {
            return -1;
          } while (!parame1.a().equals(parame2.a()));
          j = parame1.c();
          k = parame2.c();
        } while (j < k);
        int i = 0;
        for (;;)
        {
          if (i >= k - 1) {
            break label90;
          }
          if (!parame1.a(i).equals(parame2.a(i))) {
            break;
          }
          i += 1;
        }
        if (j > k) {
          return 4;
        }
      } while (((parame2.e()) && (!parame1.e())) || ((parame2.f()) && (!parame1.f())));
      if ((parame1.e()) && (!parame2.e())) {
        return 3;
      }
      if ((parame1.f()) && (!parame2.f())) {
        return 5;
      }
    } while (parame1.g() != parame2.g());
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */