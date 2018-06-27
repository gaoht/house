package com.baidu.trace;

import android.content.Context;
import android.content.Intent;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.baidu.trace.a.g;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.List;

public final class ak
  implements LocationListener
{
  protected static int a = -1;
  private LocationManager b;
  private Location c;
  private boolean d;
  private int e = 0;
  private int f = 10;
  private long g = 0L;
  private Context h;
  private a i;
  private final GpsStatus.Listener j = new al(this);
  
  public ak(Context paramContext)
  {
    this.h = paramContext;
    for (;;)
    {
      try
      {
        this.b = ((LocationManager)this.h.getSystemService("location"));
        if ((this.b != null) && (this.b.getAllProviders() != null) && (this.b.getAllProviders().contains("gps"))) {
          continue;
        }
        this.b = null;
      }
      catch (SecurityException paramContext)
      {
        continue;
      }
      catch (Exception paramContext)
      {
        this.b = null;
        continue;
      }
      this.i = new a();
      return;
      this.b.addGpsStatusListener(this.j);
      this.b.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
    }
  }
  
  protected final void a()
  {
    if (this.b != null) {
      this.b.removeUpdates(this);
    }
    a = -1;
  }
  
  protected final void a(int paramInt, String paramString)
  {
    a = paramInt;
    Intent localIntent = new Intent("com.baidu.trace.action.GPS_STATUS");
    localIntent.putExtra("statusCode", paramInt);
    localIntent.putExtra("statusMessage", paramString);
    this.h.sendBroadcast(localIntent);
  }
  
  protected final void a(g paramg, int paramInt)
  {
    boolean bool = true;
    if ((this.i != null) && (System.currentTimeMillis() - this.g < paramInt)) {
      if (this.e != 0)
      {
        paramInt = this.e;
        paramg.c = Integer.valueOf(paramInt).byteValue();
        paramg.d = Integer.valueOf(this.i.b).shortValue();
        paramg.g = Integer.valueOf(this.i.e).shortValue();
        paramg.e = Integer.valueOf(this.i.c).byteValue();
        paramg.i = this.i.g;
        paramg.h = this.i.f;
        paramg.f = Integer.valueOf(this.i.d).shortValue();
        if ((paramg.c <= 0) || (paramg.i == 0) || (paramg.h == 0)) {
          break label217;
        }
        label157:
        paramg.a = bool;
        paramg.b = this.i.a;
        a.a("G-GPS local time is: " + this.i.a);
        if (a != 0) {
          a(0, "已通过GPS定位");
        }
      }
    }
    label217:
    do
    {
      return;
      paramInt = 1;
      break;
      bool = false;
      break label157;
      paramg.a = false;
    } while (1 == a);
    a(1, "正在搜索GPS");
  }
  
  protected final boolean a(int paramInt)
  {
    if (this.b == null) {
      return false;
    }
    this.d = this.b.isProviderEnabled("gps");
    if (!this.d)
    {
      if (2 != a) {
        a(2, "已关闭GPS");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        if (this.c == null)
        {
          if (this.b.getLastKnownLocation("gps") == null) {
            continue;
          }
          localLocation = this.b.getLastKnownLocation("gps");
          this.c = localLocation;
        }
        this.b.addGpsStatusListener(this.j);
        this.b.requestLocationUpdates(this.c.getProvider(), paramInt, this.f, this);
      }
      catch (Exception localException)
      {
        Location localLocation;
        continue;
        if (1 == a) {
          break label153;
        }
        a(1, "正在搜索GPS");
      }
      if (this.c == null) {
        continue;
      }
      return true;
      localLocation = new Location("gps");
    }
    label153:
    return false;
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    int i3 = 1;
    VdsAgent.onLocationChanged(this, paramLocation);
    this.g = System.currentTimeMillis();
    Object localObject;
    int i1;
    if (paramLocation != null)
    {
      localObject = this.c;
      if (localObject != null) {
        break label182;
      }
      i1 = i3;
    }
    label182:
    int m;
    label205:
    int n;
    label217:
    int k;
    label226:
    do
    {
      if (i1 != 0)
      {
        this.c = paramLocation;
        if (this.i == null) {
          this.i = new a();
        }
        this.i.a = this.c.getTime();
        this.i.b = ((int)this.c.getAccuracy());
        this.i.c = ((int)(this.c.getBearing() / 2.0F));
        this.i.d = ((int)(this.c.getSpeed() * 360.0F));
        this.i.e = ((int)this.c.getAltitude());
        this.i.f = ((int)(this.c.getLongitude() * 600000.0D));
        this.i.g = ((int)(this.c.getLatitude() * 600000.0D));
      }
      return;
      long l = paramLocation.getTime() - ((Location)localObject).getTime();
      if (l <= 120000L) {
        break;
      }
      m = 1;
      if (l >= -120000L) {
        break label354;
      }
      n = 1;
      if (l <= 0L) {
        break label360;
      }
      k = 1;
      i1 = i3;
    } while (m != 0);
    label259:
    label267:
    int i2;
    label278:
    String str;
    boolean bool;
    if (n == 0)
    {
      i1 = (int)(paramLocation.getAccuracy() - ((Location)localObject).getAccuracy());
      if (i1 <= 0) {
        break label365;
      }
      m = 1;
      if (i1 >= 0) {
        break label370;
      }
      n = 1;
      if (i1 <= 200) {
        break label376;
      }
      i2 = 1;
      str = paramLocation.getProvider();
      localObject = ((Location)localObject).getProvider();
      if (str != null) {
        break label388;
      }
      if (localObject != null) {
        break label382;
      }
      bool = true;
    }
    for (;;)
    {
      i1 = i3;
      if (n != 0) {
        break;
      }
      if (k != 0)
      {
        i1 = i3;
        if (m == 0) {
          break;
        }
      }
      if ((k != 0) && (i2 == 0))
      {
        i1 = i3;
        if (bool) {
          break;
        }
      }
      i1 = 0;
      break;
      m = 0;
      break label205;
      label354:
      n = 0;
      break label217;
      label360:
      k = 0;
      break label226;
      label365:
      m = 0;
      break label259;
      label370:
      n = 0;
      break label267;
      label376:
      i2 = 0;
      break label278;
      label382:
      bool = false;
      continue;
      label388:
      bool = str.equals(localObject);
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public final class a
  {
    long a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    
    protected a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */