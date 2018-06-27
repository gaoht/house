package com.baidu.location.a;

import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.d;
import com.baidu.location.d.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static a c = null;
  public boolean a = false;
  boolean b = false;
  private ArrayList<a> d = null;
  private boolean e = false;
  private BDLocation f = null;
  private BDLocation g = null;
  
  private a a(Messenger paramMessenger)
  {
    if (this.d == null) {
      return null;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.equals(paramMessenger)) {
        return locala;
      }
    }
    return null;
  }
  
  public static a a()
  {
    if (c == null) {
      c = new a();
    }
    return c;
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (a(parama.b) != null)
    {
      a.a(parama, 14);
      return;
    }
    this.d.add(parama);
    a.a(parama, 13);
  }
  
  private void e()
  {
    f();
    d();
  }
  
  private void f()
  {
    Iterator localIterator = this.d.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.c.openGps) {
        bool2 = true;
      }
      if (!locala.c.location_change_notify) {
        break label89;
      }
      bool1 = true;
    }
    label89:
    for (;;)
    {
      break;
      com.baidu.location.d.j.a = bool1;
      if (this.e != bool2)
      {
        this.e = bool2;
        d.a().a(this.e);
      }
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {
      return;
    }
    this.a = true;
    a(new a(paramMessage));
    e();
  }
  
  public void a(BDLocation paramBDLocation)
  {
    boolean bool = i.h;
    if (bool) {
      i.h = false;
    }
    Object localObject;
    if ((com.baidu.location.d.j.T >= 10000) && ((paramBDLocation.getLocType() == 61) || (paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66)))
    {
      if (this.f == null) {
        break label210;
      }
      localObject = new float[1];
      Location.distanceBetween(this.f.getLatitude(), this.f.getLongitude(), paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject);
      if ((localObject[0] > com.baidu.location.d.j.V) || (bool)) {}
    }
    for (;;)
    {
      return;
      this.f = null;
      this.f = new BDLocation(paramBDLocation);
      label210:
      for (;;)
      {
        if (h.a().b()) {
          break label225;
        }
        if (this.g == null)
        {
          this.g = new BDLocation();
          this.g.setLocType(505);
        }
        paramBDLocation = this.d.iterator();
        try
        {
          while (paramBDLocation.hasNext())
          {
            localObject = (a)paramBDLocation.next();
            ((a)localObject).a(this.g);
            if (((a)localObject).d > 4) {
              paramBDLocation.remove();
            }
          }
          this.f = new BDLocation(paramBDLocation);
        }
        catch (Exception paramBDLocation)
        {
          return;
        }
      }
      label225:
      localObject = this.d.iterator();
      try
      {
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          locala.a(paramBDLocation);
          if (locala.d > 4) {
            ((Iterator)localObject).remove();
          }
        }
        return;
      }
      catch (Exception paramBDLocation) {}
    }
  }
  
  public void a(String paramString)
  {
    paramString = new BDLocation(paramString);
    Address localAddress = i.c().a(paramString);
    String str = i.c().f();
    List localList = i.c().g();
    if (localAddress != null) {
      paramString.setAddr(localAddress);
    }
    if (str != null) {
      paramString.setLocationDescribe(str);
    }
    if (localList != null) {
      paramString.setPoiList(localList);
    }
    i.c().b(paramString);
    a(paramString);
  }
  
  public void b()
  {
    this.d.clear();
    this.f = null;
    e();
  }
  
  public void b(Message paramMessage)
  {
    paramMessage = a(paramMessage.replyTo);
    if (paramMessage != null) {
      this.d.remove(paramMessage);
    }
    j.a().c();
    e();
  }
  
  public String c()
  {
    Object localObject = new StringBuffer(256);
    if (this.d.isEmpty()) {
      return "&prod=" + b.e + ":" + b.d;
    }
    a locala = (a)this.d.get(0);
    if (locala.c.prodName != null) {
      ((StringBuffer)localObject).append(locala.c.prodName);
    }
    if (locala.a != null)
    {
      ((StringBuffer)localObject).append(":");
      ((StringBuffer)localObject).append(locala.a);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      return "&prod=" + (String)localObject;
    }
    return null;
  }
  
  public boolean c(Message paramMessage)
  {
    boolean bool = true;
    a locala = a(paramMessage.replyTo);
    if (locala == null) {
      return false;
    }
    int i = locala.c.scanSpan;
    locala.c.scanSpan = paramMessage.getData().getInt("scanSpan", locala.c.scanSpan);
    if (locala.c.scanSpan < 1000)
    {
      j.a().c();
      this.a = false;
      if ((locala.c.scanSpan <= 999) || (i >= 1000)) {
        break label424;
      }
      if ((locala.c.mIsNeedDeviceDirect) || (locala.c.isNeedAltitude))
      {
        j.a().a(locala.c.mIsNeedDeviceDirect);
        j.a().b(locala.c.isNeedAltitude);
        j.a().b();
      }
      this.b |= locala.c.isNeedAltitude;
    }
    for (;;)
    {
      locala.c.openGps = paramMessage.getData().getBoolean("openGPS", locala.c.openGps);
      String str = paramMessage.getData().getString("coorType");
      LocationClientOption localLocationClientOption = locala.c;
      if ((str != null) && (!str.equals("")))
      {
        label234:
        localLocationClientOption.coorType = str;
        str = paramMessage.getData().getString("addrType");
        localLocationClientOption = locala.c;
        if ((str == null) || (str.equals(""))) {
          break label411;
        }
      }
      for (;;)
      {
        localLocationClientOption.addrType = str;
        if (!com.baidu.location.d.j.f.equals(locala.c.addrType)) {
          i.c().i();
        }
        locala.c.timeOut = paramMessage.getData().getInt("timeOut", locala.c.timeOut);
        locala.c.location_change_notify = paramMessage.getData().getBoolean("location_change_notify", locala.c.location_change_notify);
        locala.c.priority = paramMessage.getData().getInt("priority", locala.c.priority);
        e();
        return bool;
        this.a = true;
        break;
        str = locala.c.coorType;
        break label234;
        label411:
        str = locala.c.addrType;
      }
      label424:
      bool = false;
    }
  }
  
  public int d(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {}
    do
    {
      return 1;
      paramMessage = a(paramMessage.replyTo);
    } while ((paramMessage == null) || (paramMessage.c == null));
    return paramMessage.c.priority;
  }
  
  public void d()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public int e(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {}
    do
    {
      return 1000;
      paramMessage = a(paramMessage.replyTo);
    } while ((paramMessage == null) || (paramMessage.c == null));
    return paramMessage.c.scanSpan;
  }
  
  private class a
  {
    public String a = null;
    public Messenger b = null;
    public LocationClientOption c = new LocationClientOption();
    public int d = 0;
    
    public a(Message paramMessage)
    {
      this.b = paramMessage.replyTo;
      this.a = paramMessage.getData().getString("packName");
      this.c.prodName = paramMessage.getData().getString("prodName");
      b.a().a(this.c.prodName, this.a);
      this.c.coorType = paramMessage.getData().getString("coorType");
      this.c.addrType = paramMessage.getData().getString("addrType");
      this.c.enableSimulateGps = paramMessage.getData().getBoolean("enableSimulateGps", false);
      if ((com.baidu.location.d.j.k) || (this.c.enableSimulateGps))
      {
        bool1 = true;
        com.baidu.location.d.j.k = bool1;
        if (!com.baidu.location.d.j.f.equals("all")) {
          com.baidu.location.d.j.f = this.c.addrType;
        }
        this.c.openGps = paramMessage.getData().getBoolean("openGPS");
        this.c.scanSpan = paramMessage.getData().getInt("scanSpan");
        this.c.timeOut = paramMessage.getData().getInt("timeOut");
        this.c.priority = paramMessage.getData().getInt("priority");
        this.c.location_change_notify = paramMessage.getData().getBoolean("location_change_notify");
        this.c.mIsNeedDeviceDirect = paramMessage.getData().getBoolean("needDirect", false);
        this.c.isNeedAltitude = paramMessage.getData().getBoolean("isneedaltitude", false);
        if ((!com.baidu.location.d.j.g) && (!paramMessage.getData().getBoolean("isneedaptag", false))) {
          break label527;
        }
        bool1 = true;
        label322:
        com.baidu.location.d.j.g = bool1;
        bool1 = bool2;
        if (!com.baidu.location.d.j.h) {
          if (!paramMessage.getData().getBoolean("isneedaptagd", false)) {
            break label533;
          }
        }
      }
      label527:
      label533:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.baidu.location.d.j.h = bool1;
        com.baidu.location.d.j.O = paramMessage.getData().getFloat("autoNotifyLocSensitivity", 0.5F);
        int i = paramMessage.getData().getInt("autoNotifyMaxInterval", 0);
        if (i >= com.baidu.location.d.j.T) {
          com.baidu.location.d.j.T = i;
        }
        i = paramMessage.getData().getInt("autoNotifyMinDistance", 0);
        if (i >= com.baidu.location.d.j.V) {
          com.baidu.location.d.j.V = i;
        }
        i = paramMessage.getData().getInt("autoNotifyMinTimeInterval", 0);
        if (i >= com.baidu.location.d.j.U) {
          com.baidu.location.d.j.U = i;
        }
        if ((this.c.scanSpan < 1000) || ((this.c.mIsNeedDeviceDirect) || (this.c.isNeedAltitude)))
        {
          j.a().a(this.c.mIsNeedDeviceDirect);
          j.a().b(this.c.isNeedAltitude);
          j.a().b();
        }
        a.this.b |= this.c.isNeedAltitude;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label322;
      }
    }
    
    private void a(int paramInt)
    {
      Message localMessage = Message.obtain(null, paramInt);
      try
      {
        if (this.b != null) {
          this.b.send(localMessage);
        }
        this.d = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException)) {}
        this.d += 1;
      }
    }
    
    private void a(int paramInt, String paramString, BDLocation paramBDLocation)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString, paramBDLocation);
      localBundle.setClassLoader(BDLocation.class.getClassLoader());
      paramString = Message.obtain(null, paramInt);
      paramString.setData(localBundle);
      try
      {
        if (this.b != null) {
          this.b.send(paramString);
        }
        this.d = 0;
        return;
      }
      catch (Exception paramString)
      {
        while (!(paramString instanceof DeadObjectException)) {}
        this.d += 1;
      }
    }
    
    public void a()
    {
      if (this.c.location_change_notify == true)
      {
        if (com.baidu.location.d.j.b) {
          a(54);
        }
      }
      else {
        return;
      }
      a(55);
    }
    
    public void a(BDLocation paramBDLocation)
    {
      a(paramBDLocation, 21);
    }
    
    public void a(BDLocation paramBDLocation, int paramInt)
    {
      paramBDLocation = new BDLocation(paramBDLocation);
      if ((j.a().g()) && ((paramBDLocation.getLocType() == 161) || (paramBDLocation.getLocType() == 66))) {
        paramBDLocation.setAltitude(j.a().i());
      }
      if (paramInt == 21) {
        a(27, "locStr", paramBDLocation);
      }
      double d1;
      double d2;
      double[] arrayOfDouble;
      if ((this.c.coorType != null) && (!this.c.coorType.equals("gcj02")))
      {
        d1 = paramBDLocation.getLongitude();
        d2 = paramBDLocation.getLatitude();
        if ((d1 != Double.MIN_VALUE) && (d2 != Double.MIN_VALUE))
        {
          if (((paramBDLocation.getCoorType() == null) || (!paramBDLocation.getCoorType().equals("gcj02"))) && (paramBDLocation.getCoorType() != null)) {
            break label194;
          }
          arrayOfDouble = Jni.coorEncrypt(d1, d2, this.c.coorType);
          paramBDLocation.setLongitude(arrayOfDouble[0]);
          paramBDLocation.setLatitude(arrayOfDouble[1]);
          paramBDLocation.setCoorType(this.c.coorType);
        }
      }
      for (;;)
      {
        a(paramInt, "locStr", paramBDLocation);
        return;
        label194:
        if ((paramBDLocation.getCoorType() != null) && (paramBDLocation.getCoorType().equals("wgs84")) && (!this.c.coorType.equals("bd09ll")))
        {
          arrayOfDouble = Jni.coorEncrypt(d1, d2, "wgs842mc");
          paramBDLocation.setLongitude(arrayOfDouble[0]);
          paramBDLocation.setLatitude(arrayOfDouble[1]);
          paramBDLocation.setCoorType("wgs84mc");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */