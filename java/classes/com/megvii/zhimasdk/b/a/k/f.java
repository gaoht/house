package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.y;
import java.util.ArrayList;
import java.util.List;

public class f
  implements r
{
  @Deprecated
  public static final f a = new f();
  public static final f b = new f();
  private static final char[] c = { 59, 44 };
  
  private static boolean a(char paramChar, char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramArrayOfChar != null)
    {
      j = paramArrayOfChar.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramChar == paramArrayOfChar[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static com.megvii.zhimasdk.b.a.f[] a(String paramString, r paramr)
  {
    a.a(paramString, "Value");
    com.megvii.zhimasdk.b.a.o.d locald = new com.megvii.zhimasdk.b.a.o.d(paramString.length());
    locald.a(paramString);
    paramString = new u(0, paramString.length());
    if (paramr != null) {}
    for (;;)
    {
      return paramr.a(locald, paramString);
      paramr = b;
    }
  }
  
  protected com.megvii.zhimasdk.b.a.f a(String paramString1, String paramString2, y[] paramArrayOfy)
  {
    return new c(paramString1, paramString2, paramArrayOfy);
  }
  
  public y a(com.megvii.zhimasdk.b.a.o.d paramd, u paramu, char[] paramArrayOfChar)
  {
    int i2 = 1;
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    int j = paramu.b();
    int k = paramu.b();
    int i3 = paramu.a();
    char c1;
    int i;
    if (j < i3)
    {
      c1 = paramd.a(j);
      if (c1 == '=') {
        i = 0;
      }
    }
    for (;;)
    {
      label60:
      String str;
      if (j == i3) {
        str = paramd.b(k, i3);
      }
      for (int m = 1;; m = i)
      {
        if (m == 0) {
          break label146;
        }
        paramu.a(j);
        return a(str, null);
        if (a(c1, paramArrayOfChar))
        {
          i = 1;
          break label60;
        }
        j += 1;
        break;
        str = paramd.b(k, j);
        j += 1;
      }
      label146:
      int i1 = 0;
      k = 0;
      i = j;
      label191:
      int n;
      if (i < i3)
      {
        c1 = paramd.a(i);
        if ((c1 == '"') && (i1 == 0)) {
          if (k == 0)
          {
            k = 1;
            n = k;
            label195:
            if ((n != 0) || (i1 != 0) || (!a(c1, paramArrayOfChar))) {
              break label252;
            }
            m = i2;
          }
        }
      }
      for (;;)
      {
        if ((j < i) && (com.megvii.zhimasdk.b.a.n.d.a(paramd.a(j))))
        {
          j += 1;
          continue;
          k = 0;
          break label191;
          label252:
          if (i1 != 0) {
            k = 0;
          }
          for (;;)
          {
            i += 1;
            i1 = k;
            k = n;
            break;
            if ((n != 0) && (c1 == '\\')) {
              k = 1;
            } else {
              k = 0;
            }
          }
        }
        for (;;)
        {
          if ((k > j) && (com.megvii.zhimasdk.b.a.n.d.a(paramd.a(k - 1))))
          {
            k -= 1;
          }
          else
          {
            i1 = k;
            n = j;
            if (k - j >= 2)
            {
              i1 = k;
              n = j;
              if (paramd.a(j) == '"')
              {
                i1 = k;
                n = j;
                if (paramd.a(k - 1) == '"')
                {
                  n = j + 1;
                  i1 = k - 1;
                }
              }
            }
            paramd = paramd.a(n, i1);
            if (m != 0) {
              i += 1;
            }
            for (;;)
            {
              paramu.a(i);
              return a(str, paramd);
            }
            k = i;
          }
        }
        n = k;
        break label195;
      }
      i = 0;
    }
  }
  
  protected y a(String paramString1, String paramString2)
  {
    return new l(paramString1, paramString2);
  }
  
  public com.megvii.zhimasdk.b.a.f[] a(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    ArrayList localArrayList = new ArrayList();
    while (!paramu.c())
    {
      com.megvii.zhimasdk.b.a.f localf = b(paramd, paramu);
      if ((localf.a().length() != 0) || (localf.b() != null)) {
        localArrayList.add(localf);
      }
    }
    return (com.megvii.zhimasdk.b.a.f[])localArrayList.toArray(new com.megvii.zhimasdk.b.a.f[localArrayList.size()]);
  }
  
  public com.megvii.zhimasdk.b.a.f b(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    y localy = d(paramd, paramu);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!paramu.c())
    {
      localObject1 = localObject2;
      if (paramd.a(paramu.b() - 1) != ',') {
        localObject1 = c(paramd, paramu);
      }
    }
    return a(localy.a(), localy.b(), (y[])localObject1);
  }
  
  public y[] c(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    a.a(paramd, "Char array buffer");
    a.a(paramu, "Parser cursor");
    int i = paramu.b();
    int j = paramu.a();
    while ((i < j) && (com.megvii.zhimasdk.b.a.n.d.a(paramd.a(i)))) {
      i += 1;
    }
    paramu.a(i);
    if (paramu.c()) {
      return new y[0];
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (paramu.c()) {
        break;
      }
      localArrayList.add(d(paramd, paramu));
    } while (paramd.a(paramu.b() - 1) != ',');
    return (y[])localArrayList.toArray(new y[localArrayList.size()]);
  }
  
  public y d(com.megvii.zhimasdk.b.a.o.d paramd, u paramu)
  {
    return a(paramd, paramu, c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */