package com.mob.commons.clt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Message;
import android.util.Base64;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VplClt
  extends a
  implements PublicMemberKeeper
{
  private SharePrefrenceHelper a;
  
  private Object a(HashMap<String, Object> paramHashMap)
  {
    try
    {
      paramHashMap.put("cplAt", Long.valueOf(com.mob.commons.a.a()));
      paramHashMap = a(paramHashMap, "http://v.data.mob.com/cpl");
      return paramHashMap;
    }
    catch (Throwable paramHashMap)
    {
      MobLog.getInstance().w(paramHashMap);
    }
    return null;
  }
  
  private static Object a(HashMap<String, Object> paramHashMap, String paramString)
    throws Throwable
  {
    if (com.mob.commons.a.D()) {
      return null;
    }
    return new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1").requestSynchronized(paramHashMap, paramString, false);
  }
  
  private void g()
  {
    try
    {
      if (this.a == null)
      {
        this.a = new SharePrefrenceHelper(MobSDK.getContext());
        this.a.open("vpl_cache");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void h()
  {
    for (;;)
    {
      HashMap localHashMap1;
      Object localObject2;
      Object localObject3;
      try
      {
        DeviceHelper localDeviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        localHashMap1 = new HashMap();
        localObject2 = MobSDK.getAppkey();
        localObject3 = DeviceAuthorizer.authorize(null);
        localHashMap1.put("appkey", localObject2);
        localHashMap1.put("apppkg", localDeviceHelper.getPackageName());
        localHashMap1.put("appver", Integer.valueOf(localDeviceHelper.getAppVersion()));
        localHashMap1.put("duid", localObject3);
        localHashMap1.put("plat", Integer.valueOf(localDeviceHelper.getPlatformCode()));
        localHashMap1.put("networktype", localDeviceHelper.getNetworkType());
        localHashMap1.put("lastVplAt", Long.valueOf(getLastUploadPrePkgTime()));
        localObject2 = Base64.encodeToString(((String)localObject2 + ":" + (String)localObject3).getBytes("utf-8"), 2);
        localHashMap1.put("lastVplId", localObject2);
        localObject3 = (HashMap)a(localHashMap1, "http://v.data.mob.com/vpl");
        if (localObject3 == null) {
          break label556;
        }
        if (((HashMap)localObject3).size() == 0) {
          return;
        }
        saveLastUploadPrePkgTime();
        Object localObject4 = (List)((HashMap)localObject3).get("pkgs");
        if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
          break label556;
        }
        localObject3 = new ArrayList();
        localObject4 = ((List)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          localHashMap2 = new HashMap();
          localHashMap2.put("apppkg", localObject5);
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject5;
        HashMap localHashMap2;
        MobLog.getInstance().d(localThrowable1);
        return;
      }
      try
      {
        localObject5 = MobSDK.getContext().getPackageManager().getPackageInfo((String)localObject5, 0);
        localHashMap2.put("appver", ((PackageInfo)localObject5).versionName);
        if ((((PackageInfo)localObject5).applicationInfo.flags & 0x1) != 1) {
          break label384;
        }
        i = 1;
        if ((((PackageInfo)localObject5).applicationInfo.flags & 0x80) != 1) {
          break label389;
        }
        j = 1;
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      localHashMap2.put("issys", Boolean.valueOf(bool));
      ((List)localObject3).add(localHashMap2);
      continue;
      label384:
      int i = 0;
      continue;
      label389:
      int j = 0;
      label556:
      while ((i == 0) && (j == 0))
      {
        bool = false;
        break;
        localHashMap1.remove("networktype");
        localHashMap1.remove("lastVplAt");
        localHashMap1.remove("lastVplId");
        localHashMap1.put("mac", localThrowable1.getMacAddress());
        localHashMap1.put("model", localThrowable1.getModel());
        localHashMap1.put("imei", localThrowable1.getIMEI());
        localHashMap1.put("serialno", localThrowable1.getSerialno());
        localHashMap1.put("datetime", Long.valueOf(com.mob.commons.a.a()));
        localHashMap1.put("id", localObject2);
        localHashMap1.put("pkgs", localObject3);
        localObject2 = a(localHashMap1);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(localHashMap1);
        }
        if (localObject1 == null)
        {
          setLastUploadPrePkgFailedData(localHashMap1);
          return;
        }
        return;
      }
      boolean bool = true;
    }
  }
  
  protected File a()
  {
    return getAppMultiProcessLock();
  }
  
  protected void a(Message paramMessage)
  {
    long l;
    if (paramMessage.what == 0)
    {
      l = com.mob.commons.a.y();
      if (l <= 0L) {}
    }
    try
    {
      Thread.sleep(l * 1000L);
      paramMessage = getLastUploadPrePkgFailedData();
      if ((paramMessage != null) && (!paramMessage.isEmpty()) && (a(paramMessage) != null)) {
        setLastUploadPrePkgFailedData(null);
      }
    }
    catch (Throwable paramMessage)
    {
      for (;;) {}
    }
    h();
    a(0, com.mob.commons.a.z() * 1000L);
  }
  
  protected boolean b()
  {
    return com.mob.commons.a.y() > 0L;
  }
  
  protected void c()
  {
    b(0);
  }
  
  public File getAppMultiProcessLock()
  {
    File localFile = new File(ResHelper.getDataCache(MobSDK.getContext()), ".vpl_lock");
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    return localFile;
  }
  
  public HashMap<String, Object> getLastUploadPrePkgFailedData()
  {
    try
    {
      g();
      HashMap localHashMap = (HashMap)this.a.get("LAST_FAILED_DATA");
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLastUploadPrePkgTime()
  {
    try
    {
      g();
      long l = this.a.getLong("LAST_UPLOAD_TIME");
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void saveLastUploadPrePkgTime()
  {
    try
    {
      g();
      this.a.putLong("LAST_UPLOAD_TIME", Long.valueOf(com.mob.commons.a.a()));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void setLastUploadPrePkgFailedData(HashMap<String, Object> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 346	com/mob/commons/clt/VplClt:g	()V
    //   6: aload_1
    //   7: ifnonnull +16 -> 23
    //   10: aload_0
    //   11: getfield 76	com/mob/commons/clt/VplClt:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   14: ldc_w 348
    //   17: invokevirtual 364	com/mob/tools/utils/SharePrefrenceHelper:remove	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 76	com/mob/commons/clt/VplClt:a	Lcom/mob/tools/utils/SharePrefrenceHelper;
    //   27: ldc_w 348
    //   30: aload_1
    //   31: invokevirtual 367	com/mob/tools/utils/SharePrefrenceHelper:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	VplClt
    //   0	42	1	paramHashMap	HashMap<String, Object>
    // Exception table:
    //   from	to	target	type
    //   2	6	37	finally
    //   10	20	37	finally
    //   23	34	37	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/VplClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */