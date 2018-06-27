package cn.jpush.android.a;

import cn.jpush.android.b;
import cn.jpush.android.c.f;

public final class e
  extends b
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "~#9q\031Y/,l\026_\"\034m\032E)m\032Dl>q\005Ul/a_Q%)tS\020?$b\032\020vm";
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
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 127;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
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
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "}9!l\026~=\036l\nR\004(t\017U>";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "@9>p3_+$v_C8,l\nCl/a_Q%)tEV-!k\032";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "~#9q\031Y/,l\026_\"\034m\032E)mh\020\\ mz\006\020-$|\023\034l#w\013Y*${\036D%\"v6Tlw8";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "~#9q\031Y/,l\026_\"\034m\032E)m{\020^8,q\021Cl/a_Q%)tS\020\"\"l\026V%.y\013Y##Q\033\020vm";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "~#9q\031Y/,l\026_\"\034m\032E)mw\031V)?8\035Il,q\033\\`mv\020D%+q\034Q8$w\021y(m\"_";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 48;
        continue;
        i = 76;
        continue;
        i = 77;
        continue;
        i = 24;
      }
    }
  }
  
  public final int a()
  {
    int i = i.a();
    f.a(z[1], z[3] + i);
    return i;
  }
  
  public final boolean a(int paramInt)
  {
    f.a(z[1], z[5] + paramInt);
    return i.a(paramInt);
  }
  
  public final int b()
  {
    int i = i.b();
    f.a(z[1], z[0] + i);
    return i;
  }
  
  public final boolean b(int paramInt)
  {
    f.a(z[1], z[4] + paramInt);
    return i.b(paramInt);
  }
  
  public final boolean c()
  {
    f.a(z[1], z[2]);
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */