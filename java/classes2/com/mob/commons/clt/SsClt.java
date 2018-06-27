package com.mob.commons.clt;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SsClt
  extends a
  implements PublicMemberKeeper
{
  private a a = new a();
  
  private HashMap<String, Object> a(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = ResHelper.getCacheRootFile(MobSDK.getContext(), paramString);
      if (!paramString.exists()) {
        return new HashMap();
      }
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream(paramString));
      paramString = (HashMap)localObjectInputStream.readObject();
      return paramString;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          localObjectInputStream.close();
          if (paramString != null) {
            break;
          }
          return new HashMap();
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        localThrowable2 = localThrowable2;
        paramString = (String)localObject;
        localObject = localThrowable2;
        MobLog.getInstance().d((Throwable)localObject);
      }
    }
  }
  
  private void a(HashMap<String, Object> paramHashMap, String paramString)
  {
    try
    {
      paramString = ResHelper.getCacheRootFile(MobSDK.getContext(), paramString);
      if ((paramHashMap == null) || (paramHashMap.isEmpty()))
      {
        paramString.delete();
        return;
      }
      paramString = new ObjectOutputStream(new FileOutputStream(paramString));
      paramString.writeObject(paramHashMap);
      paramString.close();
      return;
    }
    catch (Throwable paramHashMap)
    {
      MobLog.getInstance().w(paramHashMap);
    }
  }
  
  private void b(HashMap<String, Object> paramHashMap, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString);
    localHashMap.put("data", paramHashMap);
    long l = com.mob.commons.a.a();
    localHashMap.put("datetime", Long.valueOf(l));
    b.a().a(l, localHashMap);
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "Start PE Clt" });
        if (!this.a.b()) {
          break label553;
        }
        localObject5 = this.a.c();
        if (localObject5 == null) {
          break;
        }
        localHashMap = a("comm/dbs/.pecd");
        localObject3 = null;
      }
      catch (Throwable localThrowable1)
      {
        Object localObject5;
        Object localObject1;
        Object localObject4;
        int i;
        MobLog.getInstance().d(localThrowable1);
        return;
      }
      try
      {
        localObject1 = (ArrayList)localHashMap.get("time");
      }
      catch (Throwable localThrowable2) {}
      try
      {
        localObject4 = (ArrayList)localHashMap.get("step");
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = new ArrayList();
        }
        i = ((ArrayList)localObject4).size();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() == i)) {
          break label596;
        }
        localObject3 = new ArrayList();
        localObject1 = new ArrayList();
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          long l2;
          long l1;
          localObject3 = localObject2;
          continue;
          Object localObject2 = localHashMap;
        }
        localObject3 = localThrowable3;
        continue;
      }
      long l3 = com.mob.commons.a.a();
      ((ArrayList)localObject3).add(Long.valueOf(l3));
      localHashMap.put("time", localObject3);
      localObject4 = ((HashMap)localObject5).entrySet().iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        if (localObject5 != null) {
          ((ArrayList)localObject1).add(((Map.Entry)localObject5).getValue());
        }
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "PE got. time: " + l3 + ", data: " + ((Map.Entry)localObject5).getValue() });
        continue;
        MobLog.getInstance().d(localThrowable2);
        localObject2 = null;
      }
      else
      {
        localHashMap.put("step", localObject2);
        l2 = ((Long)ResHelper.forceCast(localHashMap.get("nextUploadTime"), Long.valueOf(0L))).longValue();
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = com.mob.commons.a.I() * 1000L + l3;
          localHashMap.put("nextUploadTime", Long.valueOf(l1));
        }
        if ((((ArrayList)localObject3).size() < 200) && (l3 < l1)) {
          break label589;
        }
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "PE push. dataSize: " + ((ArrayList)localObject3).size() + ", curTime: " + l3 + ", cacheTime: " + l1 });
        localHashMap.remove("nextUploadTime");
        b(localHashMap, "PEDOMETER");
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("nextUploadTime", Long.valueOf(com.mob.commons.a.a() + com.mob.commons.a.I() * 1000L));
        a((HashMap)localObject2, "comm/dbs/.pecd");
      }
    }
    for (;;)
    {
      a(1, com.mob.commons.a.H() * 1000L);
      return;
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "No PE data" });
      continue;
      label553:
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "S-Listener NOT activated currently, do NOT process" });
    }
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "Start AC Clt" });
        if (!this.a.b()) {
          break label621;
        }
        localObject5 = this.a.d();
        if (localObject5 == null) {
          break;
        }
        localHashMap = a("comm/dbs/.accd");
        localObject3 = null;
      }
      catch (Throwable localThrowable1)
      {
        Object localObject5;
        Object localObject1;
        Object localObject4;
        int i;
        MobLog.getInstance().d(localThrowable1);
        return;
      }
      try
      {
        localObject1 = (ArrayList)localHashMap.get("time");
      }
      catch (Throwable localThrowable2) {}
      try
      {
        localObject4 = (ArrayList)localHashMap.get("acceleration");
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = new ArrayList();
        }
        i = ((ArrayList)localObject4).size();
        if ((localObject1 != null) && (((ArrayList)localObject1).size() == i)) {
          break label664;
        }
        localObject3 = new ArrayList();
        localObject1 = new ArrayList();
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          long l2;
          long l1;
          localObject3 = localObject2;
          continue;
          Object localObject2 = localHashMap;
        }
        localObject3 = localThrowable3;
        continue;
      }
      long l3 = com.mob.commons.a.a();
      ((ArrayList)localObject3).add(Long.valueOf(l3));
      localHashMap.put("time", localObject3);
      localObject4 = ((HashMap)localObject5).entrySet().iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        if (localObject5 != null) {
          ((ArrayList)localObject1).add(((Map.Entry)localObject5).getValue());
        }
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "AC got. time: " + l3 + ", data: [" + ((ArrayList)((Map.Entry)localObject5).getValue()).get(0) + "," + ((ArrayList)((Map.Entry)localObject5).getValue()).get(1) + "," + ((ArrayList)((Map.Entry)localObject5).getValue()).get(2) + "]" });
        continue;
        MobLog.getInstance().d(localThrowable2);
        localObject2 = null;
      }
      else
      {
        localHashMap.put("acceleration", localObject2);
        l2 = ((Long)ResHelper.forceCast(localHashMap.get("nextUploadTime"), Long.valueOf(0L))).longValue();
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = com.mob.commons.a.K() * 1000L + l3;
          localHashMap.put("nextUploadTime", Long.valueOf(l1));
        }
        if ((((ArrayList)localObject3).size() < 200) && (l3 < l1)) {
          break label657;
        }
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "AC push. dataSize: " + ((ArrayList)localObject3).size() + ", curTime: " + l3 + ", cacheTime: " + l1 });
        localHashMap.remove("nextUploadTime");
        b(localHashMap, "ACCELEROMETER");
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("nextUploadTime", Long.valueOf(com.mob.commons.a.a() + com.mob.commons.a.K() * 1000L));
        a((HashMap)localObject2, "comm/dbs/.accd");
      }
    }
    for (;;)
    {
      a(2, com.mob.commons.a.J() * 1000L);
      return;
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "No AC data" });
      continue;
      label621:
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "S-Listener not activated currently, do NOT process" });
    }
  }
  
  protected File a()
  {
    return c.a("comm/locks/.ss_lock");
  }
  
  protected void a(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (com.mob.commons.a.H() > 0L) {
        g();
      }
    }
    while ((paramMessage.what != 2) || (com.mob.commons.a.J() <= 0L)) {
      return;
    }
    h();
  }
  
  protected boolean b()
  {
    return (com.mob.commons.a.H() > 0L) || (com.mob.commons.a.J() > 0L);
  }
  
  protected void c()
  {
    if (this.a == null)
    {
      bool = false;
      if (!bool) {
        break label119;
      }
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "PE supported" });
      this.a.b(SsClt.a.b.a);
      b(1);
      label52:
      if (this.a != null) {
        break label146;
      }
    }
    label119:
    label146:
    for (boolean bool = false;; bool = this.a.a(SsClt.a.b.b))
    {
      if (!bool) {
        break label160;
      }
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "AC supported" });
      this.a.b(SsClt.a.b.b);
      b(2);
      return;
      bool = this.a.a(SsClt.a.b.a);
      break;
      MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "PE NOT supported" });
      break label52;
    }
    label160:
    MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "AC NOT supported" });
  }
  
  protected void e()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  private static class a
  {
    private static HashMap<Long, ArrayList<Float>> c;
    private a a;
    private SensorManager b;
    
    public a()
    {
      try
      {
        this.b = ((SensorManager)MobSDK.getContext().getSystemService("sensor"));
        return;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
    }
    
    private static HashMap<Long, ArrayList<Float>> f()
    {
      MobLog.getInstance().d("Write a initial ac data", new Object[0]);
      if (c == null)
      {
        c = new HashMap();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Float.valueOf(0.0F));
        localArrayList.add(Float.valueOf(0.0F));
        localArrayList.add(Float.valueOf(9.81F));
        c.put(Long.valueOf(com.mob.commons.a.a()), localArrayList);
      }
      return c;
    }
    
    public void a()
    {
      try
      {
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "Listener unregistered." });
        this.b.unregisterListener(this.a);
        return;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
    }
    
    public boolean a(b paramb)
    {
      try
      {
        switch (SsClt.1.a[paramb.ordinal()])
        {
        case 1: 
          return MobSDK.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
        }
      }
      catch (Throwable paramb)
      {
        boolean bool;
        MobLog.getInstance().d(paramb);
        return false;
      }
      bool = MobSDK.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
      return bool;
      return false;
    }
    
    public void b(b paramb)
    {
      Sensor localSensor = null;
      try
      {
        if (paramb == b.a) {
          localSensor = this.b.getDefaultSensor(19);
        }
        while (localSensor != null)
        {
          if (this.a == null) {
            this.a = new a(null);
          }
          this.b.registerListener(this.a, localSensor, 3);
          MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "Listener registered. type: " + paramb });
          return;
          if (paramb == b.b) {
            localSensor = this.b.getDefaultSensor(1);
          }
        }
        MobLog.getInstance().d("[%s] %s", new Object[] { "SsClt", "Listener NOT registered since can not obtain instance. type: " + paramb });
        return;
      }
      catch (Throwable paramb)
      {
        MobLog.getInstance().w(paramb);
      }
    }
    
    public boolean b()
    {
      if (this.a != null) {
        return this.a.a();
      }
      return false;
    }
    
    public HashMap<Long, Integer> c()
    {
      if (this.a != null) {
        return this.a.b();
      }
      return null;
    }
    
    public HashMap<Long, ArrayList<Float>> d()
    {
      if (this.a != null) {
        return this.a.c();
      }
      return f();
    }
    
    private static class a
      implements SensorEventListener
    {
      private HashMap<Long, Integer> a;
      private HashMap<Long, ArrayList<Float>> b;
      private ArrayList<Float> c;
      private Long d;
      
      private Object a(Object paramObject)
      {
        try
        {
          Object localObject = new ByteArrayOutputStream();
          ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
          localObjectOutputStream.writeObject(paramObject);
          localObjectOutputStream.close();
          paramObject = new ObjectInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray()));
          localObject = ((ObjectInputStream)paramObject).readObject();
          ((ObjectInputStream)paramObject).close();
          return localObject;
        }
        catch (Exception paramObject) {}
        return null;
      }
      
      public boolean a()
      {
        return System.currentTimeMillis() - this.d.longValue() < 1000L;
      }
      
      public HashMap<Long, Integer> b()
      {
        if ((this.a != null) && (!this.a.isEmpty())) {
          return this.a;
        }
        return null;
      }
      
      public HashMap<Long, ArrayList<Float>> c()
      {
        try
        {
          if (this.b != null)
          {
            boolean bool = this.b.isEmpty();
            if (!bool) {
              try
              {
                HashMap localHashMap4 = (HashMap)a(this.b);
                this.b.clear();
                HashMap localHashMap1 = localHashMap4;
                if (localHashMap4 == null) {
                  localHashMap1 = SsClt.a.e();
                }
                return localHashMap1;
              }
              catch (Throwable localThrowable)
              {
                MobLog.getInstance().w(localThrowable);
                HashMap localHashMap2 = SsClt.a.e();
                return localHashMap2;
              }
            }
          }
          localHashMap3 = SsClt.a.e();
        }
        finally {}
        HashMap localHashMap3;
        return localHashMap3;
      }
      
      public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
      
      public void onSensorChanged(SensorEvent paramSensorEvent)
      {
        if (paramSensorEvent != null)
        {
          try
          {
            this.d = Long.valueOf(System.currentTimeMillis());
            int i = paramSensorEvent.sensor.getType();
            if (i == 19)
            {
              if (this.a == null) {
                this.a = new HashMap();
              }
              for (;;)
              {
                this.a.put(Long.valueOf(paramSensorEvent.timestamp), Integer.valueOf((int)paramSensorEvent.values[0]));
                return;
                this.a.clear();
              }
            }
            if (i != 1) {
              return;
            }
          }
          catch (Throwable paramSensorEvent)
          {
            MobLog.getInstance().d(paramSensorEvent);
            return;
          }
          for (;;)
          {
            try
            {
              if (this.b == null)
              {
                this.b = new HashMap();
                if (this.c != null) {
                  break label223;
                }
                this.c = new ArrayList();
                this.c.add(Float.valueOf(paramSensorEvent.values[0]));
                this.c.add(Float.valueOf(paramSensorEvent.values[1]));
                this.c.add(Float.valueOf(paramSensorEvent.values[2]));
                this.b.put(Long.valueOf(paramSensorEvent.timestamp), this.c);
                return;
              }
            }
            finally {}
            this.b.clear();
            continue;
            label223:
            this.c.clear();
          }
        }
      }
    }
    
    public static enum b
    {
      private b() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/SsClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */