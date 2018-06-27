package com.baidu.location.b;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.a.c;
import com.baidu.location.a.q;
import com.baidu.location.a.s;
import com.baidu.location.d.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class d
{
  private static d c = null;
  private static int k = 0;
  private static String r = null;
  private final long a = 1000L;
  private final long b = 9000L;
  private Context d;
  private LocationManager e = null;
  private Location f;
  private b g = null;
  private c h = null;
  private GpsStatus i;
  private a j = null;
  private long l = 0L;
  private boolean m = false;
  private boolean n = false;
  private String o = null;
  private boolean p = false;
  private long q = 0L;
  private Handler s = null;
  private final int t = 1;
  private final int u = 2;
  private final int v = 3;
  private final int w = 4;
  private int x;
  private int y;
  private HashMap<Integer, List<GpsSatellite>> z;
  
  private int a(f paramf, int paramInt)
  {
    if (k >= j.B) {}
    do
    {
      double d1;
      do
      {
        do
        {
          return 1;
          if (k <= j.A) {
            return 4;
          }
          d1 = paramf.c();
        } while (d1 <= j.w);
        if (d1 >= j.x) {
          return 4;
        }
        d1 = paramf.b();
      } while (d1 <= j.y);
      if (d1 >= j.z) {
        return 4;
      }
    } while (paramInt >= j.D);
    if (paramInt <= j.C) {
      return 4;
    }
    if (this.z != null) {
      return a(this.z);
    }
    return 3;
  }
  
  private int a(HashMap<Integer, List<GpsSatellite>> paramHashMap)
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i1;
    Object localObject;
    int i2;
    if (this.x > 4)
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramHashMap = paramHashMap.entrySet().iterator();
      i1 = 0;
      if (paramHashMap.hasNext())
      {
        localObject = (List)((Map.Entry)paramHashMap.next()).getValue();
        if (localObject == null) {
          break label301;
        }
        localObject = a((List)localObject);
        if (localObject == null) {
          break label301;
        }
        localArrayList1.add(localObject);
        i2 = i1 + 1;
        localArrayList2.add(Integer.valueOf(i1));
        i1 = i2;
      }
    }
    label301:
    for (;;)
    {
      break;
      if (!localArrayList1.isEmpty())
      {
        paramHashMap = new double[2];
        i2 = localArrayList1.size();
        i1 = 0;
        while (i1 < i2)
        {
          localObject = (double[])localArrayList1.get(i1);
          int i3 = ((Integer)localArrayList2.get(i1)).intValue();
          localObject[0] *= i3;
          localObject[1] *= i3;
          paramHashMap[0] += localObject[0];
          double d1 = paramHashMap[1];
          localObject[1] += d1;
          i1 += 1;
        }
        paramHashMap[0] /= i2;
        paramHashMap[1] /= i2;
        paramHashMap = b(paramHashMap[0], paramHashMap[1]);
        if (paramHashMap[0] <= j.F) {
          return 1;
        }
        if (paramHashMap[0] >= j.G) {
          return 4;
        }
      }
      return 3;
    }
  }
  
  public static d a()
  {
    try
    {
      if (c == null) {
        c = new d();
      }
      d locald = c;
      return locald;
    }
    finally {}
  }
  
  private String a(GpsSatellite paramGpsSatellite, HashMap<Integer, List<GpsSatellite>> paramHashMap)
  {
    int i2 = (int)Math.floor(paramGpsSatellite.getAzimuth() / 6.0F);
    float f1 = paramGpsSatellite.getElevation();
    int i3 = (int)Math.floor(f1 / 1.5D);
    float f2 = paramGpsSatellite.getSnr();
    int i4 = Math.round(f2 / 5.0F);
    int i1 = paramGpsSatellite.getPrn();
    if (i1 >= 65) {
      i1 -= 32;
    }
    for (;;)
    {
      if ((f2 >= 10.0F) && (f1 >= 1.0F))
      {
        List localList = (List)paramHashMap.get(Integer.valueOf(i4));
        Object localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(paramGpsSatellite);
        paramHashMap.put(Integer.valueOf(i4), localObject);
        this.x += 1;
      }
      if ((i2 < 64) || ((i3 < 64) || (i1 >= 65))) {}
      return null;
    }
  }
  
  public static String a(Location paramLocation)
  {
    float f3 = -1.0F;
    if (paramLocation == null) {
      return null;
    }
    float f1 = (float)(paramLocation.getSpeed() * 3.6D);
    if (!paramLocation.hasSpeed()) {
      f1 = -1.0F;
    }
    float f2;
    int i1;
    if (paramLocation.hasAccuracy())
    {
      f2 = paramLocation.getAccuracy();
      i1 = (int)f2;
      if (!paramLocation.hasAltitude()) {
        break label178;
      }
    }
    label178:
    for (double d1 = paramLocation.getAltitude();; d1 = 555.0D)
    {
      f2 = f3;
      if (paramLocation.hasBearing()) {
        f2 = paramLocation.getBearing();
      }
      return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", new Object[] { Double.valueOf(paramLocation.getLongitude()), Double.valueOf(paramLocation.getLatitude()), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(k), Double.valueOf(d1), Long.valueOf(paramLocation.getTime() / 1000L) });
      f2 = -1.0F;
      break;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramDouble1 >= 73.146973D)
    {
      i1 = i2;
      if (paramDouble1 <= 135.252686D)
      {
        i1 = i2;
        if (paramDouble2 <= 54.258807D)
        {
          i1 = i2;
          if (paramDouble2 >= 14.604847D)
          {
            if (paramFloat <= 18.0F) {
              break label78;
            }
            i1 = i2;
          }
        }
      }
    }
    for (;;)
    {
      if (j.s != i1) {
        j.s = i1;
      }
      return;
      label78:
      double d1 = j.q;
      double d2 = j.r;
      i1 = (int)((paramDouble1 - d1) * 1000.0D);
      int i3 = (int)((d2 - paramDouble2) * 1000.0D);
      if ((i1 > 0) && (i1 < 50) && (i3 > 0) && (i3 < 50))
      {
        i3 = i1 + i3 * 50;
        i1 = i2;
        if (j.u) {
          i1 = j.t[(i3 >> 2)] >> (i3 & 0x3) * 2 & 0x3;
        }
      }
      else
      {
        String str = String.format(Locale.CHINA, "&ll=%.5f|%.5f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
        new StringBuilder().append(str).append("&im=").append(com.baidu.location.d.b.a().b()).toString();
        j.o = paramDouble1;
        j.p = paramDouble2;
        i1 = i2;
      }
    }
  }
  
  private void a(String paramString, Location paramLocation)
  {
    if (paramLocation == null) {}
    boolean bool;
    do
    {
      return;
      paramString = paramString + com.baidu.location.a.a.a().c();
      bool = h.a().d();
      q.a(new a(b.a().f()));
      q.a(System.currentTimeMillis());
      q.a(new Location(paramLocation));
      q.a(paramString);
    } while (bool);
    s.a(q.c(), null, q.d(), paramString);
  }
  
  public static boolean a(Location paramLocation1, Location paramLocation2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramLocation1 == paramLocation2) {
      bool1 = false;
    }
    float f2;
    do
    {
      do
      {
        float f1;
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (paramLocation1 == null);
              bool1 = bool2;
            } while (paramLocation2 == null);
            f1 = paramLocation2.getSpeed();
            if ((!paramBoolean) || ((j.s != 3) && (com.baidu.location.d.d.a().a(paramLocation2.getLongitude(), paramLocation2.getLatitude())))) {
              break;
            }
            bool1 = bool2;
          } while (f1 < 5.0F);
          f2 = paramLocation2.distanceTo(paramLocation1);
          if (f1 <= j.I) {
            break;
          }
          bool1 = bool2;
        } while (f2 > j.K);
        return false;
        if (f1 <= j.H) {
          break;
        }
        bool1 = bool2;
      } while (f2 > j.J);
      return false;
      bool1 = bool2;
    } while (f2 > 5.0F);
    return false;
  }
  
  private double[] a(double paramDouble1, double paramDouble2)
  {
    return new double[] { Math.sin(Math.toRadians(paramDouble2)) * paramDouble1, Math.cos(Math.toRadians(paramDouble2)) * paramDouble1 };
  }
  
  private double[] a(List<GpsSatellite> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    double[] arrayOfDouble = new double[2];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (GpsSatellite)localIterator.next();
      if (localObject != null)
      {
        localObject = a(90.0F - ((GpsSatellite)localObject).getElevation(), ((GpsSatellite)localObject).getAzimuth());
        arrayOfDouble[0] += localObject[0];
        arrayOfDouble[1] += localObject[1];
      }
    }
    int i1 = paramList.size();
    arrayOfDouble[0] /= i1;
    arrayOfDouble[1] /= i1;
    return arrayOfDouble;
  }
  
  public static String b(Location paramLocation)
  {
    String str = a(paramLocation);
    paramLocation = str;
    if (str != null) {
      paramLocation = str + "&g_tp=0";
    }
    return paramLocation;
  }
  
  private void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if ((paramBoolean) && (!i())) {}
  }
  
  private double[] b(double paramDouble1, double paramDouble2)
  {
    double d1 = 0.0D;
    if (paramDouble2 == 0.0D) {
      if (paramDouble1 > 0.0D) {
        d1 = 90.0D;
      }
    }
    for (;;)
    {
      return new double[] { Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2), d1 };
      if (paramDouble1 < 0.0D)
      {
        d1 = 270.0D;
        continue;
        d1 = Math.toDegrees(Math.atan(paramDouble1 / paramDouble2));
      }
    }
  }
  
  public static String c(Location paramLocation)
  {
    String str = a(paramLocation);
    paramLocation = str;
    if (str != null) {
      paramLocation = str + r;
    }
    return paramLocation;
  }
  
  private void d(Location paramLocation)
  {
    paramLocation = this.s.obtainMessage(1, paramLocation);
    this.s.sendMessage(paramLocation);
  }
  
  private void e(Location paramLocation)
  {
    int i2;
    int i1;
    if (paramLocation != null)
    {
      i2 = k;
      i1 = i2;
      if (i2 != 0) {}
    }
    try
    {
      i1 = paramLocation.getExtras().getInt("satellites");
      if ((i1 == 0) && (!j.k)) {}
      for (;;)
      {
        return;
        this.f = null;
        return;
        this.f = paramLocation;
        if (this.f == null) {
          this.o = null;
        }
        try
        {
          com.baidu.location.a.f.a().a(this.f);
          if (this.f != null) {
            c.a().a(this.f);
          }
          if ((!i()) || (this.f == null)) {
            continue;
          }
          com.baidu.location.a.a.a().a(f());
          if ((k <= 2) || (!s.a(this.f, true))) {
            continue;
          }
          boolean bool = h.a().d();
          q.a(new a(b.a().f()));
          q.a(System.currentTimeMillis());
          q.a(new Location(this.f));
          q.a(com.baidu.location.a.a.a().c());
          if (bool) {
            continue;
          }
          s.a(q.c(), null, q.d(), com.baidu.location.a.a.a().c());
          return;
          l1 = System.currentTimeMillis();
          this.f.setTime(l1);
          f1 = (float)(this.f.getSpeed() * 3.6D);
          if (!this.f.hasSpeed()) {
            f1 = -1.0F;
          }
          i2 = k;
          i1 = i2;
          if (i2 != 0) {}
        }
        catch (Exception paramLocation)
        {
          try
          {
            for (;;)
            {
              long l1;
              float f1;
              i1 = this.f.getExtras().getInt("satellites");
              this.o = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", new Object[] { Double.valueOf(this.f.getLongitude()), Double.valueOf(this.f.getLatitude()), Float.valueOf(f1), Float.valueOf(this.f.getBearing()), Integer.valueOf(i1), Long.valueOf(l1) });
              a(this.f.getLongitude(), this.f.getLatitude(), f1);
            }
            paramLocation = paramLocation;
          }
          catch (Exception paramLocation)
          {
            for (;;)
            {
              i1 = i2;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
      return;
    }
    d();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 585	com/baidu/location/f:isServing	Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokestatic 589	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: putfield 591	com/baidu/location/b/d:d	Landroid/content/Context;
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 591	com/baidu/location/b/d:d	Landroid/content/Context;
    //   25: ldc_w 593
    //   28: invokevirtual 599	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 601	android/location/LocationManager
    //   34: putfield 73	com/baidu/location/b/d:e	Landroid/location/LocationManager;
    //   37: aload_0
    //   38: new 6	com/baidu/location/b/d$a
    //   41: dup
    //   42: aload_0
    //   43: aconst_null
    //   44: invokespecial 604	com/baidu/location/b/d$a:<init>	(Lcom/baidu/location/b/d;Lcom/baidu/location/b/e;)V
    //   47: putfield 79	com/baidu/location/b/d:j	Lcom/baidu/location/b/d$a;
    //   50: aload_0
    //   51: getfield 73	com/baidu/location/b/d:e	Landroid/location/LocationManager;
    //   54: aload_0
    //   55: getfield 79	com/baidu/location/b/d:j	Lcom/baidu/location/b/d$a;
    //   58: invokevirtual 608	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   61: pop
    //   62: aload_0
    //   63: new 12	com/baidu/location/b/d$c
    //   66: dup
    //   67: aload_0
    //   68: aconst_null
    //   69: invokespecial 609	com/baidu/location/b/d$c:<init>	(Lcom/baidu/location/b/d;Lcom/baidu/location/b/e;)V
    //   72: putfield 77	com/baidu/location/b/d:h	Lcom/baidu/location/b/d$c;
    //   75: aload_0
    //   76: getfield 73	com/baidu/location/b/d:e	Landroid/location/LocationManager;
    //   79: ldc_w 611
    //   82: ldc2_w 68
    //   85: fconst_0
    //   86: aload_0
    //   87: getfield 77	com/baidu/location/b/d:h	Lcom/baidu/location/b/d$c;
    //   90: invokevirtual 615	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   93: aload_0
    //   94: new 617	com/baidu/location/b/e
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 620	com/baidu/location/b/e:<init>	(Lcom/baidu/location/b/d;)V
    //   102: putfield 93	com/baidu/location/b/d:s	Landroid/os/Handler;
    //   105: goto -95 -> 10
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore_2
    //   114: goto -21 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	d
    //   5	2	1	bool	boolean
    //   108	4	2	localObject	Object
    //   113	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	6	108	finally
    //   13	20	108	finally
    //   20	93	108	finally
    //   93	105	108	finally
    //   20	93	113	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/baidu/location/b/d:n	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: new 9	com/baidu/location/b/d$b
    //   12: dup
    //   13: aload_0
    //   14: aconst_null
    //   15: invokespecial 621	com/baidu/location/b/d$b:<init>	(Lcom/baidu/location/b/d;Lcom/baidu/location/b/e;)V
    //   18: putfield 75	com/baidu/location/b/d:g	Lcom/baidu/location/b/d$b;
    //   21: new 539	android/os/Bundle
    //   24: dup
    //   25: invokespecial 622	android/os/Bundle:<init>	()V
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 73	com/baidu/location/b/d:e	Landroid/location/LocationManager;
    //   33: ldc_w 624
    //   36: ldc_w 626
    //   39: aload_1
    //   40: invokevirtual 630	android/location/LocationManager:sendExtraCommand	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   43: pop
    //   44: aload_0
    //   45: getfield 73	com/baidu/location/b/d:e	Landroid/location/LocationManager;
    //   48: ldc_w 624
    //   51: ldc2_w 64
    //   54: fconst_0
    //   55: aload_0
    //   56: getfield 75	com/baidu/location/b/d:g	Lcom/baidu/location/b/d$b;
    //   59: invokevirtual 615	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   62: aload_0
    //   63: getfield 73	com/baidu/location/b/d:e	Landroid/location/LocationManager;
    //   66: aload_0
    //   67: getfield 79	com/baidu/location/b/d:j	Lcom/baidu/location/b/d$a;
    //   70: invokevirtual 634	android/location/LocationManager:addNmeaListener	(Landroid/location/GpsStatus$NmeaListener;)Z
    //   73: pop
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 85	com/baidu/location/b/d:n	Z
    //   79: return
    //   80: astore_1
    //   81: return
    //   82: astore_1
    //   83: goto -39 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	d
    //   28	12	1	localBundle	Bundle
    //   80	1	1	localException1	Exception
    //   82	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	21	80	java/lang/Exception
    //   44	79	80	java/lang/Exception
    //   21	44	82	java/lang/Exception
  }
  
  public void d()
  {
    if (!this.n) {
      return;
    }
    if (this.e != null) {}
    try
    {
      if (this.g != null) {
        this.e.removeUpdates(this.g);
      }
      if (this.j != null) {
        this.e.removeNmeaListener(this.j);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    j.d = 0;
    j.s = 0;
    this.g = null;
    this.n = false;
    b(false);
  }
  
  public void e()
  {
    for (;;)
    {
      try
      {
        d();
        LocationManager localLocationManager = this.e;
        if (localLocationManager == null) {
          return;
        }
      }
      finally {}
      try
      {
        if (this.j != null) {
          this.e.removeGpsStatusListener(this.j);
        }
        this.e.removeUpdates(this.h);
      }
      catch (Exception localException)
      {
        continue;
      }
      this.j = null;
      this.e = null;
    }
  }
  
  public String f()
  {
    Object localObject = null;
    String str;
    float f1;
    int i2;
    int i1;
    if (this.f != null)
    {
      str = "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
      if (!this.f.hasAccuracy()) {
        break label349;
      }
      f1 = this.f.getAccuracy();
      i2 = (int)f1;
      f1 = (float)(this.f.getSpeed() * 3.6D);
      if (!this.f.hasSpeed()) {
        f1 = -1.0F;
      }
      if (!com.baidu.location.d.d.a().a(this.f.getLongitude(), this.f.getLatitude())) {
        break label355;
      }
      localObject = Jni.coorEncrypt(this.f.getLongitude(), this.f.getLatitude(), "gps2gcj");
      if ((localObject[0] > 0.0D) || (localObject[1] > 0.0D)) {
        break label407;
      }
      localObject[0] = this.f.getLongitude();
      localObject[1] = this.f.getLatitude();
      i1 = 1;
    }
    for (;;)
    {
      str = String.format(Locale.CHINA, str, new Object[] { Double.valueOf(localObject[0]), Double.valueOf(localObject[1]), Integer.valueOf(i2), Float.valueOf(this.f.getBearing()), Float.valueOf(f1), Integer.valueOf(k) });
      localObject = str;
      if (i1 == 0) {
        localObject = str + ",\"in_cn\":\"0\"";
      }
      if (this.f.hasAltitude())
      {
        localObject = (String)localObject + String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[] { Double.valueOf(this.f.getAltitude()) });
        return (String)localObject;
        label349:
        f1 = 10.0F;
        break;
        label355:
        localObject = new double[] { this.f.getLongitude(), this.f.getLatitude() };
        i1 = 0;
        continue;
      }
      return (String)localObject + "}}";
      label407:
      i1 = 1;
    }
  }
  
  public Location g()
  {
    if (this.f == null) {}
    while (Math.abs(System.currentTimeMillis() - this.f.getTime()) > 60000L) {
      return null;
    }
    return this.f;
  }
  
  public boolean h()
  {
    try
    {
      if ((this.f == null) || (this.f.getLatitude() == 0.0D) || (this.f.getLongitude() == 0.0D)) {
        break label60;
      }
      if (k <= 2)
      {
        int i1 = this.f.getExtras().getInt("satellites", 3);
        if (i1 <= 2) {
          break label60;
        }
      }
    }
    catch (Exception localException)
    {
      label60:
      do
      {
        if ((this.f == null) || (this.f.getLatitude() == 0.0D)) {
          break;
        }
      } while (this.f.getLongitude() != 0.0D);
    }
    return true;
    return false;
    return false;
  }
  
  public boolean i()
  {
    if (!h()) {}
    while (System.currentTimeMillis() - this.q > 10000L) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    if ((this.m) && (l1 - this.l < 3000L)) {
      return true;
    }
    return this.p;
  }
  
  private class a
    implements GpsStatus.Listener, GpsStatus.NmeaListener
  {
    long a = 0L;
    private long c = 0L;
    private final int d = 400;
    private boolean e = false;
    private List<String> f = new ArrayList();
    private String g = null;
    private String h = null;
    private String i = null;
    private long j = 0L;
    
    private a() {}
    
    public void a(String paramString)
    {
      if ((System.currentTimeMillis() - this.c > 400L) && (this.e) && (this.f.size() > 0)) {}
      try
      {
        f localf = new f(this.f, this.g, this.h, this.i);
        if (localf.a())
        {
          j.d = d.a(d.this, localf, d.h(d.this));
          if (j.d > 0) {
            d.a(String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", new Object[] { Double.valueOf(localf.c()), Double.valueOf(localf.b()), Integer.valueOf(j.d) }));
          }
        }
        for (;;)
        {
          this.f.clear();
          this.i = null;
          this.h = null;
          this.g = null;
          this.e = false;
          if (!paramString.startsWith("$GPGGA")) {
            break;
          }
          this.e = true;
          this.g = paramString.trim();
          this.c = System.currentTimeMillis();
          return;
          j.d = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          j.d = 0;
          continue;
          if (paramString.startsWith("$GPGSV")) {
            this.f.add(paramString.trim());
          } else if (paramString.startsWith("$GPGSA")) {
            this.i = paramString.trim();
          }
        }
      }
    }
    
    public void onGpsStatusChanged(int paramInt)
    {
      if (d.d(d.this) == null) {}
      for (;;)
      {
        return;
        switch (paramInt)
        {
        case 3: 
        default: 
          return;
        case 2: 
          d.b(d.this, null);
          d.a(d.this, false);
          d.a(0);
          return;
        }
        if (d.b(d.this)) {
          try
          {
            if (d.e(d.this) == null) {
              d.a(d.this, d.d(d.this).getGpsStatus(null));
            }
            for (;;)
            {
              Iterator localIterator = d.e(d.this).getSatellites().iterator();
              d.a(d.this, 0);
              d.b(d.this, 0);
              d.a(d.this, new HashMap());
              paramInt = 0;
              while (localIterator.hasNext())
              {
                GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
                if (localGpsSatellite.usedInFix())
                {
                  paramInt += 1;
                  if (localGpsSatellite.getSnr() >= j.E) {
                    d.f(d.this);
                  }
                  d.a(d.this, localGpsSatellite, d.g(d.this));
                }
              }
              d.d(d.this).getGpsStatus(d.e(d.this));
            }
            if (paramInt > 0)
            {
              this.j = System.currentTimeMillis();
              d.a(paramInt);
              return;
            }
            if (System.currentTimeMillis() - this.j > 100L)
            {
              this.j = System.currentTimeMillis();
              d.a(paramInt);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    }
    
    public void onNmeaReceived(long paramLong, String paramString)
    {
      if (!d.b(d.this)) {}
      while ((paramString == null) || (paramString.equals("")) || (paramString.length() < 9) || (paramString.length() > 150) || (!d.this.i())) {
        return;
      }
      d.c(d.this).sendMessage(d.c(d.this).obtainMessage(2, paramString));
    }
  }
  
  private class b
    implements LocationListener
  {
    private b() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      d.a(d.this, System.currentTimeMillis());
      d.a(d.this, true);
      d.b(d.this, paramLocation);
      d.b(d.this, false);
    }
    
    public void onProviderDisabled(String paramString)
    {
      d.b(d.this, null);
      d.a(d.this, false);
    }
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        d.b(d.this, null);
        d.a(d.this, false);
        return;
      case 1: 
        d.b(d.this, System.currentTimeMillis());
        d.b(d.this, true);
        d.a(d.this, false);
        return;
      }
      d.b(d.this, false);
    }
  }
  
  private class c
    implements LocationListener
  {
    private long b = 0L;
    
    private c() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if (d.b(d.this)) {}
      while ((paramLocation == null) || (paramLocation.getProvider() != "gps") || (System.currentTimeMillis() - this.b < 10000L) || (!s.a(paramLocation, false))) {
        return;
      }
      this.b = System.currentTimeMillis();
      paramLocation = d.c(d.this).obtainMessage(4, paramLocation);
      d.c(d.this).sendMessage(paramLocation);
    }
    
    public void onProviderDisabled(String paramString) {}
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */