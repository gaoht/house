package cn.jiguang.c.f;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  public static String a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[2];
    int m = 0;
    Object localObject2 = "EY\n\025aqm^\b(ch;V!Q\032\000\037";
    int i = -1;
    int i4;
    Object localObject3;
    int n;
    for (Object localObject1 = arrayOfString;; localObject1 = arrayOfString)
    {
      char[] arrayOfChar = ((String)localObject2).toCharArray();
      j = arrayOfChar.length;
      int i1 = 0;
      k = 0;
      int i3 = i;
      localObject2 = arrayOfChar;
      i4 = m;
      localObject3 = localObject1;
      n = j;
      Object localObject4;
      int i2;
      if (j <= 1)
      {
        localObject4 = localObject1;
        localObject1 = arrayOfChar;
        i2 = i;
      }
      label143:
      do
      {
        n = k;
        for (;;)
        {
          localObject2 = localObject1;
          i1 = localObject2[k];
          switch (n % 5)
          {
          default: 
            i = 76;
            localObject2[k] = ((char)(i ^ i1));
            n += 1;
            if (j != 0) {
              break label143;
            }
            k = j;
          }
        }
        i1 = n;
        n = j;
        localObject3 = localObject4;
        i4 = m;
        localObject2 = localObject1;
        i3 = i2;
        i2 = i3;
        localObject1 = localObject2;
        m = i4;
        localObject4 = localObject3;
        j = n;
        k = i1;
      } while (n > i1);
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        m = 1;
        localObject2 = "EY\n\025\001qD\027$\004QM\000\037";
        i = 0;
      }
    }
    localObject3[i4] = localObject1;
    z = arrayOfString;
    localObject1 = "EY\n\025\001qD\0273\004tM\036".toCharArray();
    int j = localObject1.length;
    m = 0;
    i = 0;
    localObject2 = localObject1;
    int k = j;
    if (j <= 1) {}
    label292:
    label409:
    do
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 76;
      }
      for (;;)
      {
        localObject2[k] = ((char)(i ^ n));
        m += 1;
        if (j != 0) {
          break label409;
        }
        k = j;
        break label292;
        i = 60;
        break;
        i = 32;
        break;
        i = 115;
        break;
        i = 108;
        break;
        i = 60;
        continue;
        i = 32;
        continue;
        i = 115;
        continue;
        i = 108;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
    } while (k > m);
    a = new String((char[])localObject2).intern();
  }
  
  public static String a()
  {
    return new SimpleDateFormat(z[0]).format(new Date());
  }
  
  public static String b()
  {
    return new SimpleDateFormat(z[1]).format(new Date());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */