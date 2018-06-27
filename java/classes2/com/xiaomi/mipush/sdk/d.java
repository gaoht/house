package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.f.a;
import com.xiaomi.push.service.ah;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.m;
import com.xiaomi.xmpush.thrift.o;
import com.xiaomi.xmpush.thrift.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class d
  extends f.a
{
  private final int a = 30;
  private final int b = -1;
  private final int c = 3600;
  private final String d = "mipush_extra";
  private final String e = "GeoFenceNetInfoUpdateJob";
  private final String f = "last_upload_lbs_data_timestamp";
  private Context g;
  private Comparator<ScanResult> h;
  
  public d(Context paramContext)
  {
    this.g = paramContext;
    this.h = new e(this);
  }
  
  private Location a(Location paramLocation1, Location paramLocation2)
  {
    Location localLocation;
    if (paramLocation1 == null) {
      localLocation = paramLocation2;
    }
    do
    {
      do
      {
        return localLocation;
        localLocation = paramLocation1;
      } while (paramLocation2 == null);
      localLocation = paramLocation1;
    } while (paramLocation1.getTime() > paramLocation2.getTime());
    return paramLocation2;
  }
  
  private boolean a(long paramLong)
  {
    boolean bool = false;
    long l = this.g.getSharedPreferences("mipush_extra", 0).getLong("last_upload_lbs_data_timestamp", -1L);
    if (Math.abs(System.currentTimeMillis() / 1000L - l) / 1000L > paramLong) {
      bool = true;
    }
    return bool;
  }
  
  private boolean c()
  {
    if (com.xiaomi.channel.commonutils.network.d.f(this.g)) {}
    int i;
    do
    {
      return true;
      i = ah.a(this.g).a(com.xiaomi.xmpush.thrift.e.P.a(), 3600);
    } while (((com.xiaomi.channel.commonutils.network.d.g(this.g)) && (a(i))) || ((com.xiaomi.channel.commonutils.network.d.h(this.g)) && (a(i))) || ((com.xiaomi.channel.commonutils.network.d.i(this.g)) && (a(i))));
    return false;
  }
  
  private m d()
  {
    m localm = new m();
    localm.a(e());
    localm.b(f());
    localm.a(g());
    return localm;
  }
  
  private List<v> e()
  {
    for (;;)
    {
      int i;
      try
      {
        List localList = ((WifiManager)this.g.getSystemService("wifi")).getScanResults();
        if (!com.xiaomi.channel.commonutils.misc.b.a(localList))
        {
          Collections.sort(localList, this.h);
          ArrayList localArrayList = new ArrayList();
          i = 0;
          if (i < Math.min(30, localList.size()))
          {
            ScanResult localScanResult = (ScanResult)localList.get(i);
            if (localScanResult == null) {
              break label154;
            }
            v localv = new v();
            if (TextUtils.isEmpty(localScanResult.BSSID))
            {
              str = "";
              localv.a(str);
              localv.a(localScanResult.level);
              localv.b(localScanResult.SSID);
              localArrayList.add(localv);
              break label154;
            }
            String str = localScanResult.BSSID;
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      return null;
      label154:
      i += 1;
    }
  }
  
  /* Error */
  private List<com.xiaomi.xmpush.thrift.b> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/xiaomi/mipush/sdk/d:g	Landroid/content/Context;
    //   4: ldc -42
    //   6: invokevirtual 145	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast 216	android/telephony/TelephonyManager
    //   12: invokevirtual 219	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   15: astore_3
    //   16: iconst_0
    //   17: istore_1
    //   18: aconst_null
    //   19: astore_2
    //   20: iload_1
    //   21: aload_3
    //   22: invokeinterface 169 1 0
    //   27: if_icmpge +92 -> 119
    //   30: aload_3
    //   31: iload_1
    //   32: invokeinterface 176 2 0
    //   37: checkcast 221	android/telephony/NeighboringCellInfo
    //   40: astore 4
    //   42: new 163	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 164	java/util/ArrayList:<init>	()V
    //   49: astore_2
    //   50: aload 4
    //   52: invokevirtual 224	android/telephony/NeighboringCellInfo:getLac	()I
    //   55: ifgt +11 -> 66
    //   58: aload 4
    //   60: invokevirtual 227	android/telephony/NeighboringCellInfo:getCid	()I
    //   63: ifle +46 -> 109
    //   66: new 229	com/xiaomi/xmpush/thrift/b
    //   69: dup
    //   70: invokespecial 230	com/xiaomi/xmpush/thrift/b:<init>	()V
    //   73: astore 5
    //   75: aload 5
    //   77: aload 4
    //   79: invokevirtual 227	android/telephony/NeighboringCellInfo:getCid	()I
    //   82: invokevirtual 233	com/xiaomi/xmpush/thrift/b:a	(I)Lcom/xiaomi/xmpush/thrift/b;
    //   85: pop
    //   86: aload 5
    //   88: aload 4
    //   90: invokevirtual 236	android/telephony/NeighboringCellInfo:getRssi	()I
    //   93: iconst_2
    //   94: imul
    //   95: bipush 113
    //   97: isub
    //   98: invokevirtual 238	com/xiaomi/xmpush/thrift/b:b	(I)Lcom/xiaomi/xmpush/thrift/b;
    //   101: pop
    //   102: aload_2
    //   103: aload 5
    //   105: invokevirtual 210	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   108: pop
    //   109: iload_1
    //   110: iconst_1
    //   111: iadd
    //   112: istore_1
    //   113: goto -93 -> 20
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_2
    //   120: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	d
    //   17	96	1	i	int
    //   19	84	2	localArrayList	ArrayList
    //   116	1	2	localThrowable	Throwable
    //   118	2	2	localList	List<com.xiaomi.xmpush.thrift.b>
    //   15	16	3	localList1	List
    //   40	49	4	localNeighboringCellInfo	android.telephony.NeighboringCellInfo
    //   73	31	5	localb	com.xiaomi.xmpush.thrift.b
    // Exception table:
    //   from	to	target	type
    //   0	16	116	java/lang/Throwable
    //   20	66	116	java/lang/Throwable
    //   66	109	116	java/lang/Throwable
  }
  
  private i g()
  {
    if (!b()) {}
    Location localLocation;
    do
    {
      return null;
      localLocation = h();
    } while (localLocation == null);
    l locall = new l();
    locall.b(localLocation.getLatitude());
    locall.a(localLocation.getLongitude());
    i locali = new i();
    locali.a(localLocation.getAccuracy());
    locali.a(locall);
    locali.a(localLocation.getProvider());
    locali.a(new Date().getTime() - localLocation.getTime());
    return locali;
  }
  
  private Location h()
  {
    Object localObject3 = (LocationManager)this.g.getSystemService("location");
    try
    {
      localLocation1 = ((LocationManager)localObject3).getLastKnownLocation("network");
    }
    catch (Exception localException2)
    {
      try
      {
        localLocation2 = ((LocationManager)localObject3).getLastKnownLocation("gps");
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            Location localLocation1;
            Location localLocation2;
            localObject3 = ((LocationManager)localObject3).getLastKnownLocation("passive");
            return a((Location)localObject3, a(localLocation1, localLocation2));
            localException1 = localException1;
            Object localObject1 = null;
            continue;
            localException2 = localException2;
            Object localObject2 = null;
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject4 = null;
          }
        }
      }
    }
  }
  
  private void i()
  {
    SharedPreferences.Editor localEditor = this.g.getSharedPreferences("mipush_extra", 0).edit();
    localEditor.putLong("last_upload_lbs_data_timestamp", System.currentTimeMillis() / 1000L);
    localEditor.commit();
  }
  
  public int a()
  {
    return 14;
  }
  
  protected boolean b()
  {
    boolean bool = false;
    PackageManager localPackageManager = this.g.getPackageManager();
    String str = this.g.getPackageName();
    int i;
    if (localPackageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", str) == 0)
    {
      i = 1;
      if (localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", str) != 0) {
        break label67;
      }
    }
    label67:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public void run()
  {
    if (!com.xiaomi.channel.commonutils.network.d.e(this.g))
    {
      com.xiaomi.channel.commonutils.logger.b.d("GeoFenceNetInfoUpdateJobNetwork.is not Connected");
      return;
    }
    if (!c())
    {
      com.xiaomi.channel.commonutils.logger.b.d("GeoFenceNetInfoUpdateJobverifyUploadData");
      return;
    }
    byte[] arrayOfByte = aq.a(d());
    ae localae = new ae("-1", false);
    localae.c(o.C.N);
    localae.a(arrayOfByte);
    u.a(this.g).a(localae, a.i, true, null);
    i();
    com.xiaomi.channel.commonutils.logger.b.a("GeoFenceNetInfoUpdateJob: update_loc_data");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */