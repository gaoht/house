package cn.jiguang.a.a.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import cn.jiguang.c.a.a;

public final class f
{
  private static final String[] z;
  public double a;
  public double b;
  private Context c;
  private LocationManager d;
  private Location e;
  private String f;
  private long g;
  private String h = "";
  private int i = 0;
  private Handler j;
  private d k;
  private final LocationListener l = new g(this);
  
  static
  {
    String[] arrayOfString = new String[23];
    int n = 0;
    Object localObject2 = "R(aW(r";
    int m = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i1 = arrayOfChar.length;
    int i4 = 0;
    int i2 = 0;
    int i6 = m;
    localObject2 = arrayOfChar;
    int i7 = n;
    Object localObject3 = localObject1;
    int i3 = i1;
    Object localObject4;
    int i5;
    if (i1 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i5 = m;
      label68:
      i3 = i2;
      label71:
      localObject2 = localObject1;
      i4 = localObject2[i2];
      switch (i3 % 5)
      {
      default: 
        m = 21;
      }
    }
    for (;;)
    {
      localObject2[i2] = ((char)(m ^ i4));
      i3 += 1;
      if (i1 == 0)
      {
        i2 = i1;
        break label71;
      }
      i4 = i3;
      i3 = i1;
      localObject3 = localObject4;
      i7 = n;
      localObject2 = localObject1;
      i6 = i5;
      i5 = i6;
      localObject1 = localObject2;
      n = i7;
      localObject4 = localObject3;
      i1 = i3;
      i2 = i4;
      if (i3 > i4) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i6)
      {
      default: 
        localObject3[i7] = localObject1;
        n = 1;
        localObject2 = "y7oW{X(Q{_ yl";
        m = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i7] = localObject1;
        n = 2;
        localObject2 = "Y7o";
        m = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i7] = localObject1;
        n = 3;
        localObject2 = "j/y>eL(jwq[5<ErN4A>|Mgury[ }r5_5{kx[)h?";
        m = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i7] = localObject1;
        n = 4;
        localObject2 = "N&om|H\"";
        m = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i7] = localObject1;
        n = 5;
        localObject2 = "P\"hizL,";
        m = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i7] = localObject1;
        n = 6;
        localObject2 = "p(<m`W3}|y[gl{gS.om|Q)<wf\0367n{f[)h>bV\"r>r[3<YEm\030LLZh\016X[G\037";
        m = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i7] = localObject1;
        n = 7;
        localObject2 = "r(aW(r>yW4h{{[5<wf\036)iry\036k<zz\036)sj}W){?";
        m = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i7] = localObject1;
        n = 8;
        localObject2 = "\0352r{m]\"ljpZg1>yQ(l{g\0366iwa\036!}wy[#<}tK4y>wGg&";
        m = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i7] = localObject1;
        n = 9;
        localObject2 = "M3sn";
        m = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i7] = localObject1;
        n = 10;
        localObject2 = "P\"hRz]&hwzP}";
        m = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i7] = localObject1;
        n = 11;
        localObject2 = "Y7oRz]&hwzP}";
        m = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i7] = localObject1;
        n = 12;
        localObject2 = "R(aW(r$";
        m = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i7] = localObject1;
        n = 13;
        localObject2 = "y7oVtP#p{g";
        m = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i7] = localObject1;
        n = 14;
        localObject2 = "N&omYQ$}j|Q)&";
        m = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i7] = localObject1;
        n = 15;
        localObject2 = "j/y>eL(jwq[5<wf\036.prpY&p>tL ispP3=";
        m = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i7] = localObject1;
        n = 16;
        localObject2 = "\0227nqcW#yl/";
        m = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i7] = localObject1;
        n = 17;
        localObject2 = "P\"yz5P(h>g[4hgJg{nfR(aW(r2aV\"<j|S\"<i|J/<rtM3&";
        m = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i7] = localObject1;
        n = 18;
        localObject2 = "p(<m`W3}|y[gl{gS.om|Q)<i}[)<ypJgpfJgwpzI)<rz]&hwzPf";
        m = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i7] = localObject1;
        n = 19;
        localObject2 = "]\"prYQ$}j|Q)Q{_ yl5W4<p`R+0ny[&o{5]/y}~\036.h";
        m = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i7] = localObject1;
        n = 20;
        localObject2 = "R(aW(r0r[3Hwx[o5$";
        m = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i7] = localObject1;
        n = 21;
        localObject2 = "K7xa[\020uj}p\"kRz]&hwzPgyfv[7h{q\004";
        m = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i7] = localObject1;
        n = 22;
        localObject2 = "Eepa\034}9x9\034+ry7\004bz27_+h</\033!0<w[&n</\033!0<t]$>$0Xk>jtYe&<0Me0<|J.q{7\004e9z7C";
        m = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i7] = localObject1;
        z = arrayOfString;
        return;
        m = 62;
        continue;
        m = 71;
        continue;
        m = 28;
        continue;
        m = 30;
      }
    }
  }
  
  public f(Context paramContext)
  {
    this.c = paramContext;
    paramContext = z[0];
    this.d = ((LocationManager)this.c.getSystemService(paramContext));
  }
  
  private void a(Location paramLocation, String paramString)
  {
    if (paramLocation != null) {
      try
      {
        this.a = paramLocation.getLatitude();
        this.b = paramLocation.getLongitude();
        this.g = System.currentTimeMillis();
        cn.jiguang.d.d.a(z[1], z[20] + a.a(paramLocation.getTime()));
        this.f = String.format(z[22], new Object[] { Double.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(paramLocation.getAltitude()), Float.valueOf(paramLocation.getBearing()), Float.valueOf(paramLocation.getAccuracy()), paramString, Long.valueOf(a.a(paramLocation.getTime())) });
        return;
      }
      catch (Exception paramLocation)
      {
        cn.jiguang.d.d.i(z[1], z[21] + paramLocation.getMessage());
      }
    }
    this.f = "";
  }
  
  private void e()
  {
    c();
    if (this.k != null)
    {
      this.k.a(this.f);
      this.k.a();
      return;
    }
    cn.jiguang.d.d.h(z[1], z[19]);
  }
  
  public final void a(d paramd)
  {
    this.k = paramd;
  }
  
  public final boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.d != null) {
        if ((!this.d.isProviderEnabled(z[2])) && (!this.d.isProviderEnabled(z[5])))
        {
          boolean bool3 = this.d.isProviderEnabled(z[4]);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (SecurityException localSecurityException)
    {
      cn.jiguang.d.d.g(z[1], z[6]);
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      cn.jiguang.d.d.g(z[1], z[3]);
    }
    return false;
  }
  
  public final void b()
  {
    long l3 = 0L;
    for (;;)
    {
      Location localLocation2;
      Location localLocation3;
      long l1;
      long l2;
      try
      {
        if (this.d == null) {
          break label479;
        }
        localLocation2 = this.d.getLastKnownLocation(z[2]);
        localLocation3 = this.d.getLastKnownLocation(z[5]);
        localObject = this.d.getLastKnownLocation(z[4]);
        cn.jiguang.d.d.a(z[1], z[11] + localLocation2);
        cn.jiguang.d.d.a(z[1], z[10] + localLocation3);
        cn.jiguang.d.d.a(z[1], z[14] + localObject);
        if (localLocation2 == null)
        {
          l1 = 0L;
          break label484;
          this.e = ((Location)localObject);
          if ((this.e != null) && (System.currentTimeMillis() - this.e.getTime() < 30000L))
          {
            cn.jiguang.d.d.c(z[1], z[17] + (System.currentTimeMillis() - this.e.getTime()));
            a(this.e, this.e.getProvider());
            e();
          }
        }
        else
        {
          l1 = localLocation2.getTime();
          break label484;
          l2 = localLocation3.getTime();
          break label491;
          l3 = ((Location)localObject).getTime();
          break label496;
        }
        if (this.e != null) {
          a(this.e, this.h);
        }
        if (!this.d.isProviderEnabled(z[2])) {
          continue;
        }
        this.h = z[2];
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject;
        cn.jiguang.d.d.g(z[1], z[18]);
        e();
        return;
        this.d.isProviderEnabled(z[5]);
        this.h = z[5];
        continue;
      }
      catch (Exception localException)
      {
        cn.jiguang.d.d.g(z[1], z[15]);
        e();
        return;
      }
      cn.jiguang.d.d.a(z[1], z[12] + this.e + z[16] + this.h);
      if (this.j == null)
      {
        localObject = new HandlerThread(z[13]);
        ((HandlerThread)localObject).start();
        this.j = new h(this, ((HandlerThread)localObject).getLooper());
      }
      this.j.sendEmptyMessage(1002);
      return;
      label479:
      e();
      return;
      label484:
      if (localLocation3 == null)
      {
        l2 = 0L;
        label491:
        if (localException == null)
        {
          label496:
          Location localLocation1;
          if (l1 > l2)
          {
            if (l1 > l3) {
              localLocation1 = localLocation2;
            }
          }
          else if (l2 > l3) {
            localLocation1 = localLocation3;
          }
        }
      }
    }
  }
  
  public final void c()
  {
    try
    {
      cn.jiguang.d.d.a(z[1], z[9]);
      if (this.l != null)
      {
        this.d.removeUpdates(this.l);
        if (this.j != null) {
          this.j.removeCallbacksAndMessages(null);
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.j.getLooper().quit();
          this.j = null;
          return;
          cn.jiguang.d.d.g(z[1], z[7]);
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          cn.jiguang.d.d.i(z[1], z[8] + localException2.getMessage());
        }
      }
    }
  }
  
  public final String d()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */