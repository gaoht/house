package cn.jiguang.a.a.a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import cn.jiguang.d.d;
import com.growingio.android.sdk.agent.VdsAgent;

final class g
  implements LocationListener
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "9{\026q\t\030d(Y\t\037l\000J";
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
          i = 103;
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
        localObject1 = "\022d\006Y\023\027d\013\030\013\027x\021]\t\033y_";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\021e5J\b\bb\001]\025:b\026Y\005\022n\001\002";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "\021e5J\b\bb\001]\025;e\004Z\013\033o_";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 126;
        break label91;
        i = 11;
        break label91;
        i = 101;
        break label91;
        i = 56;
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
  
  g(f paramf) {}
  
  public final void onLocationChanged(Location paramLocation)
  {
    VdsAgent.onLocationChanged(this, paramLocation);
    d.c(z[0], z[1] + paramLocation);
    if (paramLocation != null) {
      f.a(this.a, paramLocation, f.a(this.a));
    }
    f.b(this.a);
  }
  
  public final void onProviderDisabled(String paramString)
  {
    d.a(z[0], z[2] + paramString);
    f.b(this.a);
  }
  
  public final void onProviderEnabled(String paramString)
  {
    d.a(z[0], z[3] + paramString);
    this.a.c();
    this.a.b();
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */