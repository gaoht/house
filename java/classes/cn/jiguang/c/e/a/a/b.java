package cn.jiguang.c.e.a.a;

import cn.jiguang.c.f.a.a;
import cn.jiguang.d.d;
import cn.jiguang.f.h;

public final class b
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[3];
    Object localObject2 = "\002(c\b\020 $z\f'$";
    int i = -1;
    int j = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int k = localObject2.length;
    int m;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      localObject3 = localObject1;
      n = j;
      localObject1 = localObject2;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 64;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label121;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "5(e\f,\023\"v/5'g}\b.&3yMzq";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        j = 2;
        localObject2 = "\"(\033%33U\f4 }";
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 65;
        break label99;
        i = 71;
        break label99;
        i = 17;
        break label99;
        i = 109;
        break label99;
        m = 0;
        i2 = i;
        i3 = j;
        localObject4 = localObject1;
        i = k;
        j = m;
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = a.a(paramArrayOfByte, paramInt);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      d.h(z[0], z[1]);
      return null;
    }
    d.a(z[0], z[2] + h.a(paramArrayOfByte));
    return paramArrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/e/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */