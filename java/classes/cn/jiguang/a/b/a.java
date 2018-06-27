package cn.jiguang.a.b;

import android.content.Context;
import cn.jiguang.a.a.b.g;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.f.h;

public final class a
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "NHh#\bRbk4\000";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 109;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
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
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "NHh#\bRbd1\035SXf3\bT";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\022_<q\tE\rcp\013\030\005` \013\024\0040x^F\fay_\027_4x\016\026\016";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "RXu.\037Tbi.\016AIl.\003[w$\034UXk\"\024";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 32;
        break label91;
        i = 61;
        break label91;
        i = 5;
        break label91;
        i = 65;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public static long a()
  {
    long l = MultiSpHelper.getLong(cn.jiguang.c.a.e, z[3], 3600000L);
    if (l > 0L) {
      return l;
    }
    return 3600000L;
  }
  
  public static String a(Context paramContext)
  {
    return cn.jiguang.c.a.a.b(paramContext, z[1], z[2]);
  }
  
  public static String b(Context paramContext)
  {
    String str2 = g.b(paramContext);
    String str1 = str2;
    if (h.a(str2)) {
      str1 = z[0];
    }
    return cn.jiguang.c.a.a.b(paramContext, str1, "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */