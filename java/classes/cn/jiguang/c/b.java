package cn.jiguang.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.jiguang.d.d;

final class b
  implements ServiceConnection
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "\003\025^Z+\fV\007\023+\f%OA2\013\025Op+\f\030OP0\007\022\006\023\007\r\033Z\\*\007\030^}%\017\023\020";
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
          i = 68;
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
        localObject1 = "(5EA!%\032EQ%\016";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "0\023G\\0\007VyV6\024\037IVd\000\037DWd\021\003IP!\021\005\004";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "\003\025^Z+\fV\007\023+\f%OA2\013\025Ow-\021\025E]*\007\025^V NVi\\)\022\031DV*\0268K^!X";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 98;
        break label91;
        i = 118;
        break label91;
        i = 42;
        break label91;
        i = 51;
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
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    d.c(z[1], z[0] + paramComponentName.toString());
    d.e(z[1], z[2]);
    a.m = cn.jiguang.b.b.a(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    d.c(z[1], z[3] + paramComponentName.toString());
    a.m = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */