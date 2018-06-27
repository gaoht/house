package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f;
import com.megvii.zhimasdk.b.a.k.c;
import com.megvii.zhimasdk.b.a.k.l;
import com.megvii.zhimasdk.b.a.k.u;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.y;
import java.util.ArrayList;
import java.util.List;

public class t
{
  public static final t a = new t();
  
  private y b(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    int m = 1;
    int k = 0;
    int j = paramu.b();
    int i1 = paramu.b();
    int n = paramu.a();
    int i = k;
    label50:
    String str;
    if (j < n)
    {
      i = paramd.a(j);
      if (i == 61) {
        i = k;
      }
    }
    else
    {
      if (j != n) {
        break label112;
      }
      str = paramd.b(i1, n);
    }
    for (k = 1;; k = i)
    {
      if (k == 0) {
        break label134;
      }
      paramu.a(j);
      return new l(str, null);
      if (i == 59)
      {
        i = 1;
        break label50;
      }
      j += 1;
      break;
      label112:
      str = paramd.b(i1, j);
      j += 1;
    }
    label134:
    i = j;
    if (i < n) {
      if (paramd.a(i) == ';') {
        k = m;
      }
    }
    for (;;)
    {
      if ((j < i) && (com.megvii.zhimasdk.b.a.n.d.a(paramd.a(j))))
      {
        j += 1;
        continue;
        i += 1;
        break;
      }
      for (;;)
      {
        if ((m > j) && (com.megvii.zhimasdk.b.a.n.d.a(paramd.a(m - 1))))
        {
          m -= 1;
        }
        else
        {
          paramd = paramd.a(j, m);
          if (k != 0) {
            i += 1;
          }
          for (;;)
          {
            paramu.a(i);
            return new l(str, paramd);
          }
          m = i;
        }
      }
    }
  }
  
  public f a(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    y localy = b(paramd, paramu);
    ArrayList localArrayList = new ArrayList();
    while (!paramu.c()) {
      localArrayList.add(b(paramd, paramu));
    }
    return new c(localy.a(), localy.b(), (y[])localArrayList.toArray(new y[localArrayList.size()]));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */