package cn.jiguang.c.b;

import android.content.Context;

public final class b
{
  public static int a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    int j = 0;
    Object localObject2 = "\002G[6S2JL#Q\002Jx<T\004\017J<U\004@K!\030\\\017";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label67:
      n = m;
      label70:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 56;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label70;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label67;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "O\\['N\bL[&Y\027Jx<T\004";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\002G[6S2JL#Q\002Jx<T\004\017[-[\004_J<W\017\001\020{";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "+lQ']2JL#Q\002Jk!Q\r\\";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "+K&PAFP<LAL_;j\024An K\t|['N\bL[u\002";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = -1;
        return;
        i = 97;
        continue;
        i = 47;
        continue;
        i = 62;
        continue;
        i = 85;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    new d(paramContext).start();
  }
  
  public static boolean a()
  {
    return a == 0;
  }
  
  public static void b()
  {
    cn.jiguang.c.f.d.a().a(new c());
  }
  
  public static boolean c()
  {
    return a == 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */