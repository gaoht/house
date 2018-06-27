package com.baidu.location.a;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.b.d;
import com.baidu.location.b.h;
import com.baidu.location.f;
import java.util.List;

public class i
  extends g
{
  public static boolean h = false;
  private static i i = null;
  private double A;
  private boolean B = false;
  private long C = 0L;
  private long D = 0L;
  private a E = null;
  private boolean F = false;
  private boolean G = false;
  private boolean H = true;
  private boolean I = false;
  private b J = null;
  private boolean K = false;
  final int e = 1000;
  public g.b f = null;
  public final Handler g = new g.a(this);
  private boolean j = true;
  private String k = null;
  private BDLocation l = null;
  private BDLocation m = null;
  private com.baidu.location.b.g n = null;
  private com.baidu.location.b.a o = null;
  private com.baidu.location.b.g p = null;
  private com.baidu.location.b.a q = null;
  private boolean r = true;
  private volatile boolean s = false;
  private boolean t = false;
  private long u = 0L;
  private long v = 0L;
  private Address w = null;
  private String x = null;
  private List<Poi> y = null;
  private double z;
  
  private boolean a(com.baidu.location.b.a parama)
  {
    boolean bool2 = true;
    this.b = com.baidu.location.b.b.a().f();
    boolean bool1;
    if (this.b == parama) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.b == null);
        bool1 = bool2;
      } while (parama == null);
      bool1 = bool2;
    } while (!parama.a(this.b));
    return false;
  }
  
  private boolean a(com.baidu.location.b.g paramg)
  {
    boolean bool2 = true;
    this.a = h.a().m();
    boolean bool1;
    if (paramg == this.a) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.a == null);
        bool1 = bool2;
      } while (paramg == null);
      bool1 = bool2;
    } while (!paramg.c(this.a));
    return false;
  }
  
  public static i c()
  {
    try
    {
      if (i == null) {
        i = new i();
      }
      i locali = i;
      return locali;
    }
    finally {}
  }
  
  private void c(Message paramMessage)
  {
    boolean bool = paramMessage.getData().getBoolean("isWaitingLocTag", false);
    if (bool) {
      h = true;
    }
    if (bool) {}
    int i1 = a.a().d(paramMessage);
    j.a().d();
    switch (i1)
    {
    default: 
      throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[] { Integer.valueOf(i1) }));
    case 3: 
      if (d.a().i()) {
        e(paramMessage);
      }
      return;
    case 1: 
      d(paramMessage);
      return;
    }
    f(paramMessage);
  }
  
  private void d(Message paramMessage)
  {
    if (d.a().i())
    {
      e(paramMessage);
      j.a().c();
      return;
    }
    f(paramMessage);
    j.a().b();
  }
  
  private void e(Message paramMessage)
  {
    paramMessage = new BDLocation(d.a().f());
    if ((com.baidu.location.d.j.f.equals("all")) || (com.baidu.location.d.j.g) || (com.baidu.location.d.j.h))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.A, this.z, paramMessage.getLatitude(), paramMessage.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] >= 100.0F) {
        break label134;
      }
      if (this.w != null) {
        paramMessage.setAddr(this.w);
      }
      if (this.x != null) {
        paramMessage.setLocationDescribe(this.x);
      }
      if (this.y != null) {
        paramMessage.setPoiList(this.y);
      }
    }
    for (;;)
    {
      this.l = paramMessage;
      this.m = null;
      a.a().a(paramMessage);
      return;
      label134:
      this.B = true;
      f(null);
    }
  }
  
  private void f(Message paramMessage)
  {
    if (this.r)
    {
      this.D = SystemClock.uptimeMillis();
      g(paramMessage);
    }
    while (this.s) {
      return;
    }
    this.D = SystemClock.uptimeMillis();
    if (h.a().e())
    {
      this.t = true;
      if (this.J == null) {
        this.J = new b(null);
      }
      if ((this.K) && (this.J != null)) {
        this.g.removeCallbacks(this.J);
      }
      this.g.postDelayed(this.J, 3500L);
      this.K = true;
      return;
    }
    g(paramMessage);
  }
  
  private void g(Message paramMessage)
  {
    if (this.s) {
      return;
    }
    if ((System.currentTimeMillis() - this.u > 0L) && (System.currentTimeMillis() - this.u < 1000L) && (this.l != null))
    {
      a.a().a(this.l);
      k();
      return;
    }
    this.s = true;
    this.j = a(this.o);
    if ((!a(this.n)) && (!this.j) && (this.l != null) && (!this.B))
    {
      if ((this.m != null) && (System.currentTimeMillis() - this.v > 30000L))
      {
        this.l = this.m;
        this.m = null;
      }
      if (j.a().f()) {
        this.l.setDirection(j.a().h());
      }
      a.a().a(this.l);
      k();
      return;
    }
    this.u = System.currentTimeMillis();
    Object localObject2 = a(null);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      j();
      long l1 = System.currentTimeMillis();
      if (l1 - this.C > 60000L) {
        this.C = l1;
      }
      localObject1 = h.a().j();
      if (localObject1 == null) {
        break label408;
      }
    }
    label408:
    for (localObject2 = (String)localObject1 + b();; localObject2 = "" + b())
    {
      String str = com.baidu.location.d.b.a().a(true);
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = (String)localObject2 + str;
      }
      localObject2 = localObject1;
      if (this.k != null)
      {
        localObject2 = (String)localObject1 + this.k;
        this.k = null;
      }
      this.f.a((String)localObject2);
      this.o = this.b;
      this.n = this.a;
      if (this.r != true) {
        break;
      }
      this.r = false;
      if ((!h.h()) || (paramMessage == null) || (a.a().e(paramMessage) >= 1000)) {
        break;
      }
      return;
    }
  }
  
  private String[] j()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "Location failed beacuse we can not get any loc information!";
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("&apl=");
    int i1 = com.baidu.location.d.j.a(f.getServiceContext());
    if (i1 == 1) {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
    }
    localStringBuffer.append(i1);
    String str = com.baidu.location.d.j.c(f.getServiceContext());
    if (str.contains("0|0|")) {
      arrayOfString[1] = "Location failed beacuse we can not get any loc information without any location permission!";
    }
    localStringBuffer.append(str);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localStringBuffer.append("&loc=");
      if (com.baidu.location.d.j.b(f.getServiceContext()) == 0) {
        arrayOfString[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
      }
      localStringBuffer.append(com.baidu.location.d.j.b(f.getServiceContext()));
    }
    localStringBuffer.append(h.a().f());
    localStringBuffer.append(com.baidu.location.b.b.a().g());
    localStringBuffer.append(com.baidu.location.d.j.d(f.getServiceContext()));
    arrayOfString[0] = localStringBuffer.toString();
    return arrayOfString;
  }
  
  private void k()
  {
    this.s = false;
    this.G = false;
    this.H = false;
    this.B = false;
    l();
  }
  
  private void l()
  {
    if (this.l != null) {
      s.a().c();
    }
  }
  
  public Address a(BDLocation paramBDLocation)
  {
    if ((com.baidu.location.d.j.f.equals("all")) || (com.baidu.location.d.j.g) || (com.baidu.location.d.j.h))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.A, this.z, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] < 100.0F)
      {
        if (this.w != null) {
          return this.w;
        }
      }
      else
      {
        this.x = null;
        this.y = null;
        this.B = true;
        f(null);
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((this.E != null) && (this.F))
    {
      this.F = false;
      this.g.removeCallbacks(this.E);
    }
    BDLocation localBDLocation;
    if (d.a().i())
    {
      localBDLocation = new BDLocation(d.a().f());
      if ((com.baidu.location.d.j.f.equals("all")) || (com.baidu.location.d.j.g) || (com.baidu.location.d.j.h))
      {
        float[] arrayOfFloat = new float[2];
        Location.distanceBetween(this.A, this.z, localBDLocation.getLatitude(), localBDLocation.getLongitude(), arrayOfFloat);
        if (arrayOfFloat[0] < 100.0F)
        {
          if (this.w != null) {
            localBDLocation.setAddr(this.w);
          }
          if (this.x != null) {
            localBDLocation.setLocationDescribe(this.x);
          }
          if (this.y != null) {
            localBDLocation.setPoiList(this.y);
          }
        }
      }
      a.a().a(localBDLocation);
      k();
      return;
    }
    if (this.G)
    {
      k();
      return;
    }
    if ((!this.j) && (this.l != null)) {
      a.a().a(this.l);
    }
    for (;;)
    {
      this.m = null;
      k();
      return;
      localBDLocation = new BDLocation();
      localBDLocation.setLocType(63);
      this.l = null;
      a.a().a(localBDLocation);
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.E != null) && (this.F))
    {
      this.F = false;
      this.g.removeCallbacks(this.E);
    }
    paramMessage = (BDLocation)paramMessage.obj;
    new BDLocation(paramMessage);
    if (paramMessage.hasAddr())
    {
      this.w = paramMessage.getAddress();
      this.z = paramMessage.getLongitude();
      this.A = paramMessage.getLatitude();
    }
    if (paramMessage.getLocationDescribe() != null)
    {
      this.x = paramMessage.getLocationDescribe();
      this.z = paramMessage.getLongitude();
      this.A = paramMessage.getLatitude();
    }
    if (paramMessage.getPoiList() != null)
    {
      this.y = paramMessage.getPoiList();
      this.z = paramMessage.getLongitude();
      this.A = paramMessage.getLatitude();
    }
    float[] arrayOfFloat;
    if (d.a().i())
    {
      paramMessage = new BDLocation(d.a().f());
      if ((com.baidu.location.d.j.f.equals("all")) || (com.baidu.location.d.j.g) || (com.baidu.location.d.j.h))
      {
        arrayOfFloat = new float[2];
        Location.distanceBetween(this.A, this.z, paramMessage.getLatitude(), paramMessage.getLongitude(), arrayOfFloat);
        if (arrayOfFloat[0] < 100.0F)
        {
          if (this.w != null) {
            paramMessage.setAddr(this.w);
          }
          if (this.x != null) {
            paramMessage.setLocationDescribe(this.x);
          }
          if (this.y != null) {
            paramMessage.setPoiList(this.y);
          }
        }
      }
      a.a().a(paramMessage);
      k();
      return;
    }
    if (this.G)
    {
      arrayOfFloat = new float[2];
      if (this.l != null) {
        Location.distanceBetween(this.l.getLatitude(), this.l.getLongitude(), paramMessage.getLatitude(), paramMessage.getLongitude(), arrayOfFloat);
      }
      if (arrayOfFloat[0] > 10.0F)
      {
        this.l = paramMessage;
        if (!this.H)
        {
          this.H = false;
          a.a().a(paramMessage);
        }
      }
      for (;;)
      {
        k();
        return;
        if (paramMessage.getUserIndoorState() > -1)
        {
          this.l = paramMessage;
          a.a().a(paramMessage);
        }
      }
    }
    this.m = null;
    int i1;
    if ((paramMessage.getLocType() == 161) && ("cl".equals(paramMessage.getNetworkLocationType())) && (this.l != null) && (this.l.getLocType() == 161) && ("wf".equals(this.l.getNetworkLocationType())) && (System.currentTimeMillis() - this.v < 30000L))
    {
      i1 = 1;
      this.m = paramMessage;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        a.a().a(this.l);
        if (!com.baidu.location.d.j.a(paramMessage)) {
          break label566;
        }
        if (i1 == 0) {
          this.l = paramMessage;
        }
        label499:
        i1 = com.baidu.location.d.j.a(c, "ssid\":\"", "\"");
        if ((i1 == Integer.MIN_VALUE) || (this.n == null)) {
          break label574;
        }
      }
      label566:
      label574:
      for (this.k = this.n.b(i1);; this.k = null)
      {
        if (h.h()) {}
        k();
        return;
        a.a().a(paramMessage);
        this.v = System.currentTimeMillis();
        break;
        this.l = null;
        break label499;
      }
      i1 = 0;
    }
  }
  
  public void b(Message paramMessage)
  {
    if (!this.I) {
      return;
    }
    c(paramMessage);
  }
  
  public void b(BDLocation paramBDLocation)
  {
    this.l = new BDLocation(paramBDLocation);
  }
  
  public void d()
  {
    this.r = true;
    this.s = false;
    this.I = true;
  }
  
  public void e()
  {
    this.s = false;
    this.t = false;
    this.G = false;
    this.H = true;
    i();
    this.I = false;
  }
  
  public String f()
  {
    return this.x;
  }
  
  public List<Poi> g()
  {
    return this.y;
  }
  
  public void h()
  {
    if (this.t)
    {
      g(null);
      this.t = false;
    }
  }
  
  public void i()
  {
    this.l = null;
  }
  
  private class a
    implements Runnable
  {
    public void run()
    {
      if (i.c(this.a) == true)
      {
        i.c(this.a, false);
        if (i.d(this.a)) {}
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (i.a(i.this)) {
        i.a(i.this, false);
      }
      if (i.b(i.this) == true)
      {
        i.b(i.this, false);
        i.a(i.this, null);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */