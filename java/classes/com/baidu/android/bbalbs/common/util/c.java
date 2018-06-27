package com.baidu.android.bbalbs.common.util;

import java.util.Comparator;

class c
  implements Comparator<b.a>
{
  c(b paramb) {}
  
  public int a(b.a parama1, b.a parama2)
  {
    int j = parama2.b - parama1.b;
    int i = j;
    if (j == 0)
    {
      if ((!parama1.d) || (!parama2.d)) {
        break label37;
      }
      i = 0;
    }
    label37:
    do
    {
      return i;
      if (parama1.d) {
        return -1;
      }
      i = j;
    } while (!parama2.d);
    return 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/android/bbalbs/common/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */