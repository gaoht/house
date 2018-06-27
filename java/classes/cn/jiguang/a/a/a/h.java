package cn.jiguang.a.a.a;

import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.d.d;

final class h
  extends Handler
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "_dS^Vx\022OOt+\003HQ|b\000^J~eSZKteSJFe+\037LPe+\030CLfeSALrj\007DL*";
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
          i = 35;
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
        localObject1 = "vn\007\rDaxSYJ|nSBVe+";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "Ec\026\rScd\005DGtySDP1b\037AFvj\037\rBcl\006@FR";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "V{\000dMwd>LMpl\026_";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 17;
        break label91;
        i = 11;
        break label91;
        i = 115;
        break label91;
        i = 45;
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
  
  public h(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      d.g(z[3], z[1]);
      f.b(this.a);
      return;
    }
    try
    {
      f.d(this.a).requestLocationUpdates(f.a(this.a), 2000L, 0.0F, f.c(this.a));
      f.e(this.a).sendEmptyMessageDelayed(1001, 30000L);
      return;
    }
    catch (SecurityException paramMessage)
    {
      d.g(z[3], z[0]);
      f.b(this.a);
      return;
    }
    catch (Exception paramMessage)
    {
      d.g(z[3], z[2]);
      f.b(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */