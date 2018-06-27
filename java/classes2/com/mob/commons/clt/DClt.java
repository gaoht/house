package com.mob.commons.clt;

import android.os.Message;
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
import com.mob.tools.utils.ReflectHelper.ReflectRunnable;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DClt
  extends a
  implements PublicMemberKeeper
{
  private long a(HashMap<String, Object> paramHashMap)
  {
    for (;;)
    {
      HashMap localHashMap;
      Object localObject1;
      ArrayList localArrayList1;
      Object localObject6;
      Object localObject2;
      Object localObject3;
      ArrayList localArrayList4;
      ArrayList localArrayList3;
      ArrayList localArrayList2;
      Object localObject7;
      long l1;
      try
      {
        localHashMap = h();
        try
        {
          localObject1 = (ArrayList)localHashMap.get("time");
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            Object localObject4;
            int i;
            long l3;
            long l2;
            localHashMap.remove("nextUploadTime");
            localHashMap.remove("cacheSize");
            a(localHashMap, "LIGHT_ELECTRIC_INFO");
            paramHashMap = new HashMap();
            paramHashMap.put("nextUploadTime", Long.valueOf(com.mob.commons.a.a() + com.mob.commons.a.B() * 1000L));
            b(paramHashMap);
            return l1;
          }
          catch (Throwable paramHashMap)
          {
            label1047:
            Object localObject5;
            continue;
          }
          localThrowable1 = localThrowable1;
          localArrayList1 = null;
          localObject6 = null;
          localArrayList4 = null;
          localObject3 = null;
          localObject1 = null;
          localArrayList3 = null;
          localArrayList2 = null;
          localObject2 = null;
          MobLog.getInstance().d(localThrowable1);
          localObject5 = null;
          localObject7 = localObject6;
          localObject6 = localObject1;
          localObject1 = localObject5;
          localObject5 = localObject2;
          continue;
        }
      }
      catch (Throwable paramHashMap)
      {
        l1 = 0L;
        MobLog.getInstance().d(paramHashMap);
        return l1;
      }
      try
      {
        localArrayList1 = (ArrayList)localHashMap.get("light");
      }
      catch (Throwable localThrowable2)
      {
        localObject7 = null;
        localArrayList3 = null;
        localArrayList2 = null;
        localObject2 = null;
        localArrayList1 = null;
        localObject6 = null;
        localArrayList4 = null;
        localObject3 = localObject1;
        localObject1 = localObject7;
        continue;
      }
      try
      {
        localObject6 = (ArrayList)localHashMap.get("lightMode");
      }
      catch (Throwable localThrowable3)
      {
        localObject6 = null;
        localArrayList4 = null;
        localObject3 = localObject1;
        localObject1 = null;
        localArrayList3 = null;
        localArrayList2 = null;
        localObject2 = null;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject2 = (HashMap)localHashMap.get("batteryState");
          if (localObject2 != null) {
            continue;
          }
        }
        catch (Throwable localThrowable4)
        {
          localArrayList4 = null;
          localObject3 = localObject1;
          localArrayList2 = null;
          localObject2 = null;
          localObject1 = null;
          localArrayList3 = null;
          break label1047;
          break;
        }
        try
        {
          localObject3 = new HashMap();
          localObject2 = localObject3;
        }
        catch (Throwable localThrowable5)
        {
          localArrayList3 = null;
          localArrayList2 = null;
          localObject7 = null;
          localArrayList4 = null;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject7;
          break label1047;
        }
      }
      try
      {
        localArrayList4 = (ArrayList)((HashMap)localObject2).get("temperature");
      }
      catch (Throwable localThrowable6)
      {
        localArrayList3 = null;
        localArrayList2 = null;
        localObject7 = null;
        localObject3 = localObject1;
        localArrayList4 = null;
        localObject1 = localObject2;
        localObject2 = localObject7;
        continue;
      }
      try
      {
        localArrayList3 = (ArrayList)((HashMap)localObject2).get("voltage");
      }
      catch (Throwable localThrowable7)
      {
        localObject3 = localObject1;
        localArrayList3 = null;
        localArrayList2 = null;
        localObject7 = null;
        localObject1 = localObject2;
        localObject2 = localObject7;
        continue;
      }
      try
      {
        localArrayList2 = (ArrayList)((HashMap)localObject2).get("status");
      }
      catch (Throwable localThrowable8)
      {
        localObject3 = localObject1;
        localArrayList2 = null;
        localObject7 = null;
        localObject1 = localObject2;
        localObject2 = localObject7;
        continue;
      }
      try
      {
        localObject3 = (ArrayList)((HashMap)localObject2).get("plugged");
      }
      catch (Throwable localThrowable9)
      {
        localObject3 = localObject1;
        localObject7 = null;
        localObject1 = localObject2;
        localObject2 = localObject7;
        continue;
      }
      try
      {
        localObject4 = (ArrayList)((HashMap)localObject2).get("level");
        localObject7 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject3;
        localObject3 = localObject7;
        localObject7 = localObject6;
        localObject6 = localObject2;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new ArrayList();
        }
        i = ((ArrayList)localObject2).size();
        if ((localArrayList1 != null) && (localObject7 != null) && (localArrayList4 != null) && (localArrayList3 != null) && (localArrayList2 != null) && (localObject4 != null) && (localObject1 != null) && (localArrayList1.size() == i) && (((ArrayList)localObject7).size() == i) && (localArrayList4.size() == i) && (localArrayList3.size() == i) && (localArrayList2.size() == i) && (((ArrayList)localObject4).size() == i) && (((ArrayList)localObject1).size() == i)) {
          break label1339;
        }
        localObject2 = new ArrayList();
        localArrayList1 = new ArrayList();
        localObject1 = new ArrayList();
        localObject6 = new HashMap();
        localArrayList4 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject4 = new ArrayList();
        localObject3 = new ArrayList();
      }
      catch (Throwable localThrowable10)
      {
        localObject7 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject7;
        continue;
        paramHashMap = localHashMap;
        continue;
        l1 = 0L;
        continue;
        label1339:
        localObject3 = localObject1;
        localObject1 = localObject7;
      }
    }
    localObject7 = DeviceHelper.getInstance(MobSDK.getContext());
    localArrayList1.add(Integer.valueOf(((DeviceHelper)localObject7).getScreenBrightness()));
    ((ArrayList)localObject1).add(Integer.valueOf(((DeviceHelper)localObject7).getScreenBrightnessMode()));
    localHashMap.put("light", localArrayList1);
    localHashMap.put("lightMode", localObject1);
    ((HashMap)localObject6).put("present", Boolean.valueOf(((Boolean)ResHelper.forceCast(paramHashMap.get("present"), Boolean.valueOf(false))).booleanValue()));
    ((HashMap)localObject6).put("technology", (String)ResHelper.forceCast(paramHashMap.get("technology")));
    ((HashMap)localObject6).put("charge_type", Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("charge_type"), Integer.valueOf(-1))).intValue()));
    ((HashMap)localObject6).put("scale", Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("scale"), Integer.valueOf(-1))).intValue()));
    ((HashMap)localObject6).put("current_now", Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("current_now"), Integer.valueOf(-1))).intValue()));
    ((HashMap)localObject6).put("current_avg", Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("current_avg"), Integer.valueOf(-1))).intValue()));
    ((HashMap)localObject6).put("health", Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("health"), Integer.valueOf(-1))).intValue()));
    ((HashMap)localObject6).put("capacity", Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("capacity"), Integer.valueOf(-1))).intValue()));
    localArrayList4.add(Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("temperature"), Integer.valueOf(-1))).intValue()));
    localArrayList3.add(Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("voltage"), Integer.valueOf(-1))).intValue()));
    localArrayList2.add(Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("status"), Integer.valueOf(-1))).intValue()));
    ((ArrayList)localObject4).add(Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("plugged"), Integer.valueOf(-1))).intValue()));
    ((ArrayList)localObject3).add(Integer.valueOf(((Integer)ResHelper.forceCast(paramHashMap.get("level"), Integer.valueOf(-1))).intValue()));
    ((HashMap)localObject6).put("temperature", localArrayList4);
    ((HashMap)localObject6).put("voltage", localArrayList3);
    ((HashMap)localObject6).put("status", localArrayList2);
    ((HashMap)localObject6).put("plugged", localObject4);
    ((HashMap)localObject6).put("level", localObject3);
    localHashMap.put("batteryState", localObject6);
    l3 = com.mob.commons.a.a();
    ((ArrayList)localObject2).add(Long.valueOf(l3));
    localHashMap.put("time", localObject2);
    l1 = ((Long)ResHelper.forceCast(localHashMap.get("nextUploadTime"), Long.valueOf(0L))).longValue();
    l2 = l1;
    if (l1 == 0L)
    {
      l2 = com.mob.commons.a.B() * 1000L + l3;
      localHashMap.put("nextUploadTime", Long.valueOf(l2));
    }
    i = ((ArrayList)localObject2).size();
    if ((i >= 200) && (l3 < l2))
    {
      l1 = l2 - l3;
      if (l3 < l2) {}
    }
  }
  
  private void a(HashMap<String, Object> paramHashMap, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString);
    localHashMap.put("data", paramHashMap);
    long l = com.mob.commons.a.a();
    localHashMap.put("datetime", Long.valueOf(l));
    b.a().a(l, localHashMap);
  }
  
  private void b(HashMap<String, Object> paramHashMap)
  {
    Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.lecd");
    if ((localObject != null) && ((paramHashMap == null) || (paramHashMap.isEmpty())))
    {
      ((File)localObject).delete();
      return;
    }
    try
    {
      localObject = new ObjectOutputStream(new FileOutputStream((File)localObject));
      ((ObjectOutputStream)localObject).writeObject(paramHashMap);
      ((ObjectOutputStream)localObject).close();
      return;
    }
    catch (Throwable paramHashMap)
    {
      MobLog.getInstance().d(paramHashMap);
    }
  }
  
  private void g()
  {
    bool5 = false;
    bool4 = false;
    localObject2 = new StringBuilder();
    localObject3 = DeviceHelper.getInstance(MobSDK.getContext());
    str = ((DeviceHelper)localObject3).getQemuKernel();
    ((StringBuilder)localObject2).append(str);
    try
    {
      localObject1 = new File("/system/lib/libc_malloc_debug_qemu.so");
      localObject4 = new File("/sys/qemu_trace");
      localObject5 = new File("/system/bin/qemu-props");
      if ((!((File)localObject1).exists()) && (!((File)localObject4).exists()))
      {
        bool1 = ((File)localObject5).exists();
        if (!bool1) {
          break label577;
        }
      }
      bool1 = true;
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        localObject1 = new File("/dev/qemu_pipe");
        localObject4 = new File("/dev/socket/qemud");
        if (((File)localObject1).exists()) {
          break label148;
        }
        bool1 = ((File)localObject4).exists();
        if (!bool1) {
          break label598;
        }
        bool1 = true;
        bool3 = bool1;
        ((StringBuilder)localObject2).append(bool3);
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          bool1 = ((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.appmart");
          if (bool1) {
            break label190;
          }
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            try
            {
              bool5 = new File("/data/bluestacks.prop").exists();
              if (bool5)
              {
                bool1 = true;
                if (bool1) {
                  continue;
                }
              }
            }
            catch (Throwable localThrowable4)
            {
              Object localObject1;
              Object localObject4;
              Object localObject5;
              boolean bool2;
              boolean bool3;
              continue;
              boolean bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
              continue;
            }
            try
            {
              if (new File("/mnt/prebundledapps/bluestacks.prop.orig").exists())
              {
                continue;
                if (bool1) {
                  continue;
                }
                if (((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.BstCommandProcessor"))
                {
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.help")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.home")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.s2p")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.searchapp")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.accelerometerui")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.appfinder")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.appmart")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.appsettings")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.BstCommandProcessor")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.bstfolder")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.setup")) {
                    continue;
                  }
                  continue;
                  if (bool1) {
                    continue;
                  }
                  if (!((DeviceHelper)localObject3).isPackageInstalled("com.bluestacks.spotlight")) {
                    continue;
                  }
                  continue;
                  if (!bool1)
                  {
                    bool5 = ((DeviceHelper)localObject3).isPackageInstalled("com.androVM.vmconfig");
                    bool1 = bool4;
                    if (!bool5) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                  ((StringBuilder)localObject2).append(bool1);
                  localObject1 = ((DeviceHelper)localObject3).getTTYDriversInfo();
                  if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
                    continue;
                  }
                  localObject4 = ((ArrayList)localObject1).iterator();
                  if (!((Iterator)localObject4).hasNext()) {
                    continue;
                  }
                  localObject5 = (ArrayList)((Iterator)localObject4).next();
                  if ((localObject5 == null) || (((ArrayList)localObject5).isEmpty())) {
                    continue;
                  }
                  localObject5 = ((ArrayList)localObject5).iterator();
                  if (((Iterator)localObject5).hasNext())
                  {
                    ((StringBuilder)localObject2).append((String)((Iterator)localObject5).next());
                    continue;
                  }
                  continue;
                  bool1 = false;
                  continue;
                  localThrowable1 = localThrowable1;
                  MobLog.getInstance().d(localThrowable1);
                  bool2 = false;
                  continue;
                  bool1 = false;
                  continue;
                  localThrowable2 = localThrowable2;
                  MobLog.getInstance().d(localThrowable2);
                  bool3 = false;
                  continue;
                  bool1 = false;
                  continue;
                }
              }
              else
              {
                bool1 = false;
                continue;
              }
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              bool1 = false;
              continue;
              localThrowable3 = localThrowable3;
              bool1 = bool5;
            }
            catch (Throwable localThrowable5)
            {
              continue;
            }
            MobLog.getInstance().d(localThrowable3);
          }
          localObject3 = ((DeviceHelper)localObject3).getCPUInfo();
          ((StringBuilder)localObject2).append(new Hashon().fromHashMap((HashMap)localObject3));
          localObject2 = Data.MD5(((StringBuilder)localObject2).toString());
          localObject4 = d.n();
          if ((localObject2 != null) && (((String)localObject2).equals(localObject4))) {
            break label861;
          }
          d.h((String)localObject2);
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("qemuKernel", str);
          ((HashMap)localObject2).put("qemuFileExist", Boolean.valueOf(bool2));
          ((HashMap)localObject2).put("qemuDevExist", Boolean.valueOf(bool3));
          ((HashMap)localObject2).put("blueStacksFileExist", Boolean.valueOf(bool1));
          ((HashMap)localObject2).put("ttyDrivers", localThrowable3);
          ((HashMap)localObject2).put("cpuInfo", localObject3);
          a((HashMap)localObject2, "SIMULATOR_DET_INFO");
          return;
        }
      }
    }
    bool2 = bool1;
    ((StringBuilder)localObject2).append(bool2);
  }
  
  private HashMap<String, Object> h()
  {
    Object localObject2 = null;
    Object localObject1 = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.lecd");
    if ((localObject1 != null) && (!((File)localObject1).exists()))
    {
      localObject2 = new HashMap();
      return (HashMap<String, Object>)localObject2;
    }
    for (;;)
    {
      try
      {
        localObjectInputStream = new ObjectInputStream(new FileInputStream((File)localObject1));
        localObject1 = (HashMap)localObjectInputStream.readObject();
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          ObjectInputStream localObjectInputStream;
          localObjectInputStream.close();
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          return new HashMap();
        }
        catch (Throwable localThrowable1)
        {
          for (;;) {}
        }
        localThrowable2 = localThrowable2;
        localObject1 = localObject2;
        localObject2 = localThrowable2;
      }
      MobLog.getInstance().d((Throwable)localObject2);
    }
  }
  
  protected File a()
  {
    return c.a("comm/locks/.lesd_lock");
  }
  
  protected void a(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (com.mob.commons.a.A() > 0L) {
        DeviceHelper.getInstance(MobSDK.getContext()).getBatteryState(new ReflectHelper.ReflectRunnable()
        {
          public Void a(HashMap<String, Object> paramAnonymousHashMap)
          {
            Message localMessage = new Message();
            localMessage.obj = paramAnonymousHashMap;
            localMessage.what = 2;
            DClt.this.b(localMessage);
            return null;
          }
        });
      }
    }
    long l1;
    do
    {
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          long l2 = a((HashMap)paramMessage.obj);
          l1 = l2;
          if (l2 == 0L) {
            l1 = com.mob.commons.a.A() * 1000L;
          }
          a(1, l1);
          return;
        }
      } while (paramMessage.what != 3);
      l1 = com.mob.commons.a.C();
    } while (l1 <= 0L);
    g();
    a(3, l1 * 1000L);
  }
  
  protected boolean b()
  {
    return (com.mob.commons.a.A() > 0L) || (com.mob.commons.a.C() > 0L);
  }
  
  protected void c()
  {
    b(1);
    b(3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/DClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */