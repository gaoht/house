package com.baidu.trace;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.baidu.trace.a.c;
import com.baidu.trace.a.g;
import com.baidu.trace.a.j;
import com.baidu.trace.api.entity.LocRequest;
import com.baidu.trace.api.entity.OnEntityListener;
import com.baidu.trace.c.d;
import com.baidu.trace.model.LocationMode;
import com.baidu.trace.model.TraceLocation;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class ar
{
  protected static aj a = null;
  public static int b = 5000;
  public static int c = 1;
  public static int d = 600000;
  private Context e = null;
  private WeakReference<LBSTraceService> f = null;
  private LocRequest g = null;
  private y h;
  private p i;
  private ak j;
  private g k = null;
  private ArrayList<j> l = null;
  private c m = null;
  private boolean n = true;
  private boolean o = false;
  private boolean p = true;
  private boolean q = true;
  private int r = LocationMode.High_Accuracy.ordinal();
  private Handler s = null;
  private OnEntityListener t = null;
  
  public ar(Context paramContext, Handler paramHandler)
  {
    this.e = paramContext;
    this.h = new y(this.e);
    this.i = new p(this.e);
    this.j = new ak(this.e);
    this.s = paramHandler;
  }
  
  public ar(WeakReference<LBSTraceService> paramWeakReference, Handler paramHandler)
  {
    this.f = paramWeakReference;
    if ((this.f != null) && (this.f.get() != null))
    {
      this.e = ((LBSTraceService)this.f.get()).getServiceContext();
      this.r = ((LBSTraceService)this.f.get()).getLocationMode();
    }
    this.h = new y(this.e);
    this.i = new p(this.e);
    this.j = new ak(this.e);
    this.s = paramHandler;
    if (PreferenceManager.getDefaultSharedPreferences(this.e).getBoolean("same_process", false)) {
      com.baidu.trace.c.a.a(this.e, LBSTraceClient.class);
    }
    for (;;)
    {
      this.t = new as(this);
      return;
      com.baidu.trace.c.a.a(this.e, LBSTraceService.class);
    }
  }
  
  private ArrayList<com.baidu.trace.a.e> a(long paramLong)
  {
    if ((this.f == null) || (this.f.get() == null) || (((LBSTraceService)this.f.get()).getClientListener() == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      if ((this.f != null) && (this.f.get() != null))
      {
        Object localObject1 = ((LBSTraceService)this.f.get()).getClientListener().gatherAttribute(paramLong);
        if (localObject1 == null) {
          break label194;
        }
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
          com.baidu.trace.a.e locale = new com.baidu.trace.a.e();
          if (!"_entity_name".equals(localEntry.getKey()))
          {
            locale.a = d.a((String)localEntry.getKey());
            locale.b = d.a((String)localEntry.getValue());
            localArrayList.add(locale);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    label194:
    return localArrayList;
  }
  
  protected final void a()
  {
    TraceJniInterface.a().clearCustomData();
    TraceJniInterface.a().clearWifiData();
    TraceJniInterface.a().clearBluetoothData();
    TraceJniInterface.a().clearNearbyCells();
    int i1;
    g localg;
    if (LocationMode.Battery_Saving.ordinal() != this.r)
    {
      i1 = b / 2;
      int i2 = b;
      localg = new g();
      if ((this.j != null) && (com.baidu.trace.c.e.e(this.e)) && (this.j.a(i1)))
      {
        this.j.a(localg, i2 * 2);
        if (localg.a)
        {
          this.p = false;
          this.q = false;
          this.o = true;
          this.k = localg;
        }
      }
    }
    for (;;)
    {
      label179:
      Object localObject1;
      if ((localg != null) && (localg.a))
      {
        TraceJniInterface.a().setGPSData(localg.c, localg.d, localg.e, localg.f, localg.g, localg.h, localg.i);
        if (LocationMode.Device_Sensors.ordinal() == this.r) {
          break label986;
        }
        if (this.p) {
          break label321;
        }
        localObject1 = null;
        label202:
        this.l = ((ArrayList)localObject1);
      }
      label321:
      label949:
      label986:
      for (Object localObject2 = localObject1;; localObject2 = null)
      {
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          i1 = 0;
          for (;;)
          {
            if (i1 < ((ArrayList)localObject2).size())
            {
              localObject1 = (j)((ArrayList)localObject2).get(i1);
              TraceJniInterface.a().addWifiData(((j)localObject1).a, ((j)localObject1).b, ((j)localObject1).c, ((j)localObject1).d);
              i1 += 1;
              continue;
              d();
              break;
              this.o = false;
              localg.a = false;
              d();
              break;
              TraceJniInterface.a().setGPSData((byte)0, (short)0, (byte)0, (short)0, (short)0, 0, 0);
              break label179;
              localObject2 = new ArrayList();
              localObject1 = localObject2;
              if (!com.baidu.trace.c.e.f(this.e)) {
                break label202;
              }
              localObject1 = localObject2;
              if (!this.h.a()) {
                break label202;
              }
              this.h.a((ArrayList)localObject2);
              localObject1 = localObject2;
              break label202;
            }
          }
        }
        if (LocationMode.Device_Sensors.ordinal() != this.r) {
          if (!this.q)
          {
            localObject1 = null;
            this.m = ((c)localObject1);
          }
        }
        for (;;)
        {
          if ((localObject1 != null) && (((c)localObject1).a))
          {
            TraceJniInterface.a().setCellData(((c)localObject1).b, ((c)localObject1).c, ((c)localObject1).d, ((c)localObject1).e, ((c)localObject1).f, ((c)localObject1).g);
            i1 = 0;
          }
          for (;;)
          {
            if ((i1 < ((c)localObject1).h.length) && (i1 < ((c)localObject1).i.length))
            {
              TraceJniInterface.a().addNearbyCell(localObject1.h[i1], localObject1.i[i1]);
              i1 += 1;
              continue;
              localObject1 = new c();
              if ((com.baidu.trace.c.e.g(this.e)) && (this.i.a()))
              {
                this.i.a((c)localObject1);
                break;
              }
              ((c)localObject1).a = false;
              break;
              TraceJniInterface.a().setCellData((byte)0, (byte)0, (short)0, (short)0, 0, 0);
            }
          }
          long l1 = System.currentTimeMillis();
          if ((localg != null) && (localg.a) && (localg.b > 0L))
          {
            a.a("L-GPS local time is: " + localg.b);
            if (Math.abs(System.currentTimeMillis() - localg.b) > d) {
              l1 = localg.b;
            }
          }
          for (;;)
          {
            a.a("L-GPS locTime is: " + l1);
            System.out.println("locTimeOffset : " + d);
            TraceJniInterface.a().addCustomData("_entity_name".getBytes(), z.c.getBytes());
            localObject1 = a(l1);
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              i1 = 0;
              while (i1 < ((ArrayList)localObject1).size())
              {
                localObject3 = (com.baidu.trace.a.e)((ArrayList)localObject1).get(i1);
                TraceJniInterface.a().addCustomData(((com.baidu.trace.a.e)localObject3).a, ((com.baidu.trace.a.e)localObject3).b);
                i1 += 1;
              }
            }
            Object localObject3 = TraceJniInterface.a().buildLocationData((int)(l1 / 1000L));
            if (localObject3 == null) {
              return;
            }
            if ((b <= 5000) && (this.n) && (localg != null) && (localg.a))
            {
              this.n = false;
              return;
            }
            localObject3 = new a(z.c, (byte[])localObject3, l1 / 1000L);
            if (bd.c != null) {
              bd.c.offer(localObject3);
            }
            if ((a != null) && (!a.a()))
            {
              l1 = ((a)localObject3).c;
              if ((localg != null) && (localg.a)) {
                break label949;
              }
              if (this.g == null) {
                this.g = new LocRequest(z.b);
              }
              aa.a(this.e, this.g, this.t);
            }
            for (;;)
            {
              if (localObject2 != null) {
                ((ArrayList)localObject2).clear();
              }
              if (localObject1 == null) {
                break;
              }
              ((ArrayList)localObject1).clear();
              return;
              if (com.baidu.trace.c.a.a != null) {
                com.baidu.trace.c.a.a.execute(new at(this, localg, l1));
              }
            }
          }
          localObject1 = null;
        }
      }
      localg = null;
    }
  }
  
  public final void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  protected final boolean a(Context paramContext, Handler paramHandler, TraceLocation paramTraceLocation)
  {
    if ((this.j == null) || (!this.o)) {}
    while (this.j == null) {
      try
      {
        paramHandler.post(new au(this, paramContext));
        return false;
      }
      finally
      {
        paramContext = finally;
        throw paramContext;
      }
    }
    paramContext = new g();
    this.j.a(paramContext, 10000);
    if (paramContext.a)
    {
      paramTraceLocation.setLatitude(paramContext.i / 600000.0D);
      paramTraceLocation.setLongitude(paramContext.h / 600000.0D);
      paramTraceLocation.setRadius(paramContext.d);
      paramTraceLocation.setAltitude(paramContext.g);
      paramTraceLocation.setDirection(paramContext.e << 1);
      paramTraceLocation.setSpeed(paramContext.f / 100.0F);
      paramTraceLocation.setTime(com.baidu.trace.c.e.c());
      com.baidu.trace.c.e.a(paramTraceLocation);
    }
    return paramContext.a;
  }
  
  protected final void b()
  {
    if (this.j != null)
    {
      this.j.a();
      this.j = null;
    }
  }
  
  protected final void c()
  {
    b();
    if (com.baidu.trace.c.a.a == null) {}
    for (;;)
    {
      if (this.h != null)
      {
        this.h.b();
        this.h = null;
      }
      if (this.i != null)
      {
        this.i.b();
        this.i = null;
      }
      if (this.l != null)
      {
        this.l.clear();
        this.l = null;
      }
      if (this.m != null) {
        this.m = null;
      }
      if (this.k != null) {
        this.k = null;
      }
      if (this.e != null) {
        this.e = null;
      }
      if (this.f != null)
      {
        this.f.clear();
        this.f = null;
      }
      if (this.s != null) {
        this.s = null;
      }
      if (a != null)
      {
        a.b();
        a = null;
      }
      TraceJniInterface.clearTrackData();
      return;
      if ((!PreferenceManager.getDefaultSharedPreferences(this.e).getBoolean("same_process", true)) && ("FinalizableDelegatedExecutorService".equals(com.baidu.trace.c.a.a.getClass().getSimpleName()))) {
        com.baidu.trace.c.a.a();
      }
    }
  }
  
  protected final void d()
  {
    this.q = true;
    this.p = true;
    this.o = false;
  }
  
  static final class a
  {
    String a;
    byte[] b;
    long c;
    
    public a(String paramString, byte[] paramArrayOfByte, long paramLong)
    {
      this.a = paramString;
      this.b = paramArrayOfByte;
      this.c = paramLong;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */