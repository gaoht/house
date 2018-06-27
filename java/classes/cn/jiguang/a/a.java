package cn.jiguang.a;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JAnalyticsAction;
import cn.jiguang.api.JCoreInterface;

public final class a
{
  public static JAnalyticsAction a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "\t\025\013z\001\037\bM>\020\004\037W\030\016UL~\005\017\025Q>#/+jB%";
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
          i = 113;
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
        localObject1 = "\013\030Qy\036\004";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\030\036U\003\036U@h\005\030\032\013y\037\f\024";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "\t\tDc\0315\027Jw";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "\030\036U\003\036";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 106;
        break label91;
        i = 123;
        break label91;
        i = 37;
        break label91;
        i = 16;
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
  
  public static void a(Context paramContext)
  {
    cn.jiguang.a.a.c.a.a.a().a(paramContext);
    paramContext = paramContext.getApplicationContext();
    String str = z[3];
    Bundle localBundle = new Bundle();
    localBundle.putString(z[1], z[0]);
    localBundle.putString(z[4], str);
    localBundle.putString(z[2], "");
    JCoreInterface.sendAction(paramContext, cn.jiguang.c.a.a, localBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */