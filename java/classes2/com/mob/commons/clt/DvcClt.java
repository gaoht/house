package com.mob.commons.clt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.d;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class DvcClt
  extends a
  implements PublicMemberKeeper
{
  private Hashon a = new Hashon();
  private Random b = new Random();
  private BroadcastReceiver c;
  private BroadcastReceiver d;
  private long e = 0L;
  
  private void a(Location paramLocation, int paramInt)
  {
    HashMap localHashMap;
    if (paramLocation != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("accuracy", Float.valueOf(paramLocation.getAccuracy()));
      localHashMap.put("latitude", Double.valueOf(paramLocation.getLatitude()));
      localHashMap.put("longitude", Double.valueOf(paramLocation.getLongitude()));
      paramLocation = new HashMap();
      if (paramInt != 0) {
        break label163;
      }
      paramLocation.put("type", "O_LOCATION");
    }
    for (;;)
    {
      Object localObject = DeviceHelper.getInstance(MobSDK.getContext());
      String str = ((DeviceHelper)localObject).getSSID();
      localObject = ((DeviceHelper)localObject).getBssid();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("cur_bssid", localObject);
      }
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("cur_ssid", str);
      }
      paramLocation.put("data", localHashMap);
      paramLocation.put("datetime", Long.valueOf(com.mob.commons.a.a()));
      b.a().a(com.mob.commons.a.a(), paramLocation);
      return;
      label163:
      paramLocation.put("type", "LOCATION");
      localHashMap.put("location_type", Integer.valueOf(paramInt));
    }
  }
  
  private void a(Parcelable paramParcelable)
  {
    try
    {
      if (!((NetworkInfo)paramParcelable).isConnected()) {
        return;
      }
      paramParcelable = new HashMap();
      Object localObject = DeviceHelper.getInstance(MobSDK.getContext());
      paramParcelable.put("ssid", ((DeviceHelper)localObject).getSSID());
      paramParcelable.put("bssid", ((DeviceHelper)localObject).getBssid());
      paramParcelable = Data.MD5(this.a.fromHashMap(paramParcelable));
      localObject = d.c();
      if (((localObject == null) || (!((String)localObject).equals(paramParcelable))) && (com.mob.commons.a.o()))
      {
        i();
        return;
      }
    }
    catch (Throwable paramParcelable)
    {
      MobLog.getInstance().w(paramParcelable);
    }
  }
  
  private void a(ArrayList<HashMap<String, Object>> paramArrayList)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "WIFI_SCAN_LIST");
      localHashMap.put("list", paramArrayList);
      localHashMap.put("datetime", Long.valueOf(com.mob.commons.a.a()));
      b.a().a(com.mob.commons.a.a(), localHashMap);
      return;
    }
    catch (Throwable paramArrayList)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramArrayList);
      }
    }
    finally {}
  }
  
  private void c(int paramInt)
  {
    if (this.d == null) {
      this.d = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if ("android.net.wifi.SCAN_RESULTS".equals(paramAnonymousIntent.getAction())) {
            DvcClt.this.b(8);
          }
        }
      };
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    try
    {
      MobSDK.getContext().registerReceiver(this.d, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void g()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject1 = DeviceHelper.getInstance(MobSDK.getContext());
      localHashMap.put("phonename", ((DeviceHelper)localObject1).getBluetoothName());
      localHashMap.put("signmd5", ((DeviceHelper)localObject1).getSignMD5());
      localObject1 = Data.MD5(this.a.fromHashMap(localHashMap));
      Object localObject2 = d.a();
      if ((localObject2 == null) || (!((String)localObject2).equals(localObject1)))
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", "DEVEXT");
        ((HashMap)localObject2).put("data", localHashMap);
        ((HashMap)localObject2).put("datetime", Long.valueOf(com.mob.commons.a.a()));
        b.a().a(com.mob.commons.a.a(), (HashMap)localObject2);
        d.a((String)localObject1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  private boolean h()
  {
    long l = d.b();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    l = com.mob.commons.a.a();
    localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    int m = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    return (i != m) || (j != n) || (k != i1);
  }
  
  private void i()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject2 = DeviceHelper.getInstance(MobSDK.getContext());
      localHashMap.put("ssid", ((DeviceHelper)localObject2).getSSID());
      localHashMap.put("bssid", ((DeviceHelper)localObject2).getBssid());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("type", "WIFI_INFO");
      ((HashMap)localObject2).put("data", localHashMap);
      long l = com.mob.commons.a.a();
      ((HashMap)localObject2).put("datetime", Long.valueOf(l));
      b.a().a(com.mob.commons.a.a(), (HashMap)localObject2);
      d.a(l);
      d.b(Data.MD5(this.a.fromHashMap(localHashMap)));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().w(localThrowable);
      }
    }
    finally {}
  }
  
  private void j()
  {
    if (this.c == null) {
      this.c = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if ((paramAnonymousIntent != null) && ("android.net.wifi.STATE_CHANGE".equals(paramAnonymousIntent.getAction())))
          {
            paramAnonymousContext = paramAnonymousIntent.getParcelableExtra("networkInfo");
            if (paramAnonymousContext != null)
            {
              paramAnonymousIntent = new Message();
              paramAnonymousIntent.what = 9;
              paramAnonymousIntent.obj = paramAnonymousContext;
              DvcClt.this.b(paramAnonymousIntent);
            }
          }
        }
      };
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    try
    {
      MobSDK.getContext().registerReceiver(this.c, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void k()
  {
    if (this.c != null) {}
    try
    {
      MobSDK.getContext().unregisterReceiver(this.c);
      this.c = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void l()
    throws Throwable
  {
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
    try
    {
      i = Integer.parseInt(localDeviceHelper.getCarrier());
      int j = localDeviceHelper.getCellLac();
      int k = localDeviceHelper.getCellId();
      int m = localDeviceHelper.getPsc();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (i != -1)
      {
        localObject1 = localObject2;
        if (j != -1)
        {
          localObject1 = localObject2;
          if (k != -1)
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("lac", Integer.valueOf(j));
            ((HashMap)localObject2).put("cell", Integer.valueOf(k));
            localObject1 = localObject2;
            if (m != -1)
            {
              ((HashMap)localObject2).put("psc", Integer.valueOf(m));
              localObject1 = localObject2;
            }
          }
        }
      }
      j = localDeviceHelper.getCdmaBid();
      k = localDeviceHelper.getCdmaSid();
      m = localDeviceHelper.getCdmaNid();
      int n = localDeviceHelper.getCdmaLat();
      int i1 = localDeviceHelper.getCdmaLon();
      Object localObject3 = localObject1;
      if (i != -1)
      {
        localObject3 = localObject1;
        if (j != -1)
        {
          localObject3 = localObject1;
          if (k != -1)
          {
            localObject3 = localObject1;
            if (m != -1)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new HashMap();
              }
              ((HashMap)localObject2).put("bid", Integer.valueOf(j));
              ((HashMap)localObject2).put("sid", Integer.valueOf(k));
              ((HashMap)localObject2).put("nid", Integer.valueOf(m));
              if (n != -1) {
                ((HashMap)localObject2).put("lat", Integer.valueOf(n));
              }
              localObject3 = localObject2;
              if (i1 != -1)
              {
                ((HashMap)localObject2).put("lon", Integer.valueOf(i1));
                localObject3 = localObject2;
              }
            }
          }
        }
      }
      if (localObject3 != null)
      {
        ((HashMap)localObject3).put("carrier", Integer.valueOf(i));
        ((HashMap)localObject3).put("simopname", localDeviceHelper.getCarrierName());
        localObject1 = localDeviceHelper.getNeighboringCellInfo();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          ((HashMap)localObject3).put("nearby", localObject1);
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("type", "BSINFO");
        ((HashMap)localObject1).put("data", localObject3);
        ((HashMap)localObject1).put("datetime", Long.valueOf(com.mob.commons.a.a()));
        b.a().a(com.mob.commons.a.a(), (HashMap)localObject1);
        d.c(Data.MD5(this.a.fromHashMap((HashMap)localObject3)));
      }
      d.b(com.mob.commons.a.a() + com.mob.commons.a.l() * 1000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
  
  private boolean m()
    throws Throwable
  {
    Object localObject1 = DeviceHelper.getInstance(MobSDK.getContext());
    try
    {
      i = Integer.parseInt(((DeviceHelper)localObject1).getCarrier());
      int j = ((DeviceHelper)localObject1).getCellLac();
      int k = ((DeviceHelper)localObject1).getCellId();
      if ((i == -1) || (j == -1) || (k == -1)) {
        break label151;
      }
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("carrier", Integer.valueOf(i));
      ((HashMap)localObject2).put("simopname", ((DeviceHelper)localObject1).getCarrierName());
      ((HashMap)localObject2).put("lac", Integer.valueOf(j));
      ((HashMap)localObject2).put("cell", Integer.valueOf(k));
      localObject1 = Data.MD5(this.a.fromHashMap((HashMap)localObject2));
      localObject2 = d.d();
      if ((localObject2 == null) || (!((String)localObject2).equals(localObject1))) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    return false;
    label151:
    return false;
  }
  
  private void n()
  {
    label267:
    label314:
    for (;;)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        long l = com.mob.commons.a.a();
        if ((this.e > 0L) && (l - this.e < 120000L)) {
          return;
        }
        this.e = l;
        Object localObject1 = DeviceHelper.getInstance(MobSDK.getContext());
        Object localObject3 = ((DeviceHelper)localObject1).getAvailableWifiList();
        if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
          break;
        }
        localObject2 = com.mob.commons.a.r();
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          break;
        }
        localArrayList1 = new ArrayList();
        localObject1 = ((DeviceHelper)localObject1).getBssid();
        localArrayList2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label267;
        }
        HashMap localHashMap = (HashMap)((Iterator)localObject3).next();
        Object localObject4 = localHashMap.get("BSSID");
        if (localObject4 == null) {
          break label314;
        }
        localArrayList2.add(String.valueOf(localObject4));
        if (!String.valueOf(localObject4).equals(localObject1)) {
          break label314;
        }
        localHashMap.put("___curConn", Boolean.valueOf(true));
        localObject1 = null;
        localObject4 = new HashMap();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Object localObject5 = localHashMap.get(str2);
          if (localObject5 == null) {
            continue;
          }
          ((HashMap)localObject4).put(str2, localObject5);
          continue;
        }
        localArrayList1.add(localObject4);
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        return;
      }
      continue;
      Collections.sort(localArrayList2);
      String str1 = Data.MD5(TextUtils.join("", localArrayList2));
      Object localObject2 = d.j();
      if ((localObject2 != null) && (((String)localObject2).equals(str1))) {
        break;
      }
      a(localArrayList1);
      d.g(str1);
      return;
    }
  }
  
  private void o()
  {
    if (this.d != null) {}
    try
    {
      MobSDK.getContext().unregisterReceiver(this.d);
      this.d = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  protected File a()
  {
    return c.a("comm/locks/.dic_lock");
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          do
          {
            return;
          } while (!com.mob.commons.a.j());
          g();
          return;
          if (com.mob.commons.a.o())
          {
            if (h()) {
              i();
            }
            j();
          }
          for (;;)
          {
            a(2, 3600000L);
            return;
            k();
          }
        } while (!com.mob.commons.a.k());
        try
        {
          l();
          a(4, (this.b.nextInt(120) + 180) * 1000);
          return;
        }
        catch (Throwable paramMessage)
        {
          for (;;)
          {
            MobLog.getInstance().w(paramMessage);
          }
        }
      } while (!com.mob.commons.a.k());
      if (d.e() >= com.mob.commons.a.a()) {}
      try
      {
        if (m()) {
          l();
        }
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          MobLog.getInstance().w(paramMessage);
        }
      }
      a(4, (this.b.nextInt(120) + 180) * 1000);
      return;
    case 5: 
      if (com.mob.commons.a.m()) {}
      try
      {
        paramMessage = DeviceHelper.getInstance(MobSDK.getContext());
        a(paramMessage.getLocation(30, 0, true), 1);
        a(paramMessage.getLocation(0, 15, true), 2);
        a(5, com.mob.commons.a.n() * 1000);
        return;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          MobLog.getInstance().w(paramMessage);
        }
      }
    case 6: 
      int i = com.mob.commons.a.q();
      if ((i > 0) && (com.mob.commons.a.p()))
      {
        c(i);
        Message localMessage = new Message();
        localMessage.what = 6;
        localMessage.arg1 = 1;
        if (paramMessage.arg1 == 0)
        {
          a(localMessage, (int)(System.currentTimeMillis() % 3L + 1L) * 60 * 1000);
          return;
        }
        DeviceHelper.getInstance(MobSDK.getContext()).scanWifiList();
        a(localMessage, i * 1000);
        return;
      }
      o();
      a(6, 3600000L);
      return;
    case 7: 
      if (com.mob.commons.a.v()) {}
      try
      {
        a(DeviceHelper.getInstance(MobSDK.getContext()).getLocation(0, 0, true), 0);
        a(7, com.mob.commons.a.n() * 1000);
        return;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          MobLog.getInstance().w(paramMessage);
        }
      }
    case 8: 
      n();
      return;
    }
    a((Parcelable)paramMessage.obj);
  }
  
  protected void c()
  {
    b(1);
    b(2);
    b(6);
    b(3);
    b(5);
    b(7);
  }
  
  protected void e()
  {
    k();
    o();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/DvcClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */