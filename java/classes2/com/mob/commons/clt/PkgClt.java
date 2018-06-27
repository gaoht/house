package com.mob.commons.clt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class PkgClt
  extends a
  implements PublicMemberKeeper
{
  private static final String[] a = { "android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED" };
  private BroadcastReceiver b;
  private Hashon c = new Hashon();
  
  private ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> paramArrayList1, ArrayList<HashMap<String, String>> paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList1 = paramArrayList1.iterator();
    label116:
    for (;;)
    {
      HashMap localHashMap;
      if (paramArrayList1.hasNext())
      {
        localHashMap = (HashMap)paramArrayList1.next();
        String str = (String)localHashMap.get("pkg");
        if (!TextUtils.isEmpty(str))
        {
          Iterator localIterator = paramArrayList2.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!str.equals(((HashMap)localIterator.next()).get("pkg")));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label116;
          }
          localArrayList.add(localHashMap);
          break;
          return localArrayList;
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.nulal");
    try
    {
      localObject = new DataOutputStream(new FileOutputStream((File)localObject));
      ((DataOutputStream)localObject).writeLong(paramLong);
      ((DataOutputStream)localObject).flush();
      ((DataOutputStream)localObject).close();
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
  }
  
  private void a(long paramLong, String paramString, ArrayList<HashMap<String, String>> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString);
    localHashMap.put("list", paramArrayList);
    localHashMap.put("datetime", Long.valueOf(com.mob.commons.a.a()));
    b.a().a(paramLong, localHashMap);
  }
  
  private void a(ArrayList<HashMap<String, String>> paramArrayList)
  {
    Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.al");
    try
    {
      localObject = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream((File)localObject)), "utf-8");
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        HashMap localHashMap = (HashMap)paramArrayList.next();
        ((OutputStreamWriter)localObject).append(this.c.fromHashMap(localHashMap)).append('\n');
      }
      ((OutputStreamWriter)localObject).flush();
    }
    catch (Throwable paramArrayList)
    {
      MobLog.getInstance().d(paramArrayList);
      return;
    }
    ((OutputStreamWriter)localObject).close();
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void g()
  {
    ArrayList localArrayList1 = h();
    ArrayList localArrayList2;
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      try
      {
        localArrayList1 = DeviceHelper.getInstance(MobSDK.getContext()).getInstalledApp(false);
        a(com.mob.commons.a.s(), "APPS_ALL", localArrayList1);
        a(localArrayList1);
        a(com.mob.commons.a.a() + com.mob.commons.a.h() * 1000L);
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          MobLog.getInstance().w(localThrowable1);
          localArrayList2 = new ArrayList();
        }
      }
    }
    long l1 = com.mob.commons.a.a();
    long l2 = i();
    if ((l2 == 0L) || (l1 >= l2)) {
      try
      {
        localArrayList2 = DeviceHelper.getInstance(MobSDK.getContext()).getInstalledApp(false);
        a(com.mob.commons.a.s(), "APPS_ALL", localArrayList2);
        a(localArrayList2);
        a(com.mob.commons.a.h() * 1000L + l1);
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          MobLog.getInstance().w(localThrowable2);
          ArrayList localArrayList3 = new ArrayList();
        }
      }
    }
    l();
  }
  
  private ArrayList<HashMap<String, String>> h()
  {
    Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.al");
    if ((localObject != null) && (((File)localObject).exists())) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream((File)localObject)), "utf-8"));
        for (localObject = localBufferedReader.readLine(); localObject != null; localObject = localBufferedReader.readLine())
        {
          localObject = this.c.fromJson((String)localObject);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        localBufferedReader.close();
        return localArrayList;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
    }
    return new ArrayList();
  }
  
  private long i()
  {
    Object localObject = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.nulal");
    if (((File)localObject).exists()) {
      try
      {
        localObject = new DataInputStream(new FileInputStream((File)localObject));
        long l = ((DataInputStream)localObject).readLong();
        ((DataInputStream)localObject).close();
        return l;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
    }
    return 0L;
  }
  
  private void j()
  {
    IntentFilter localIntentFilter;
    if ((com.mob.commons.a.e()) && (com.mob.commons.a.g()))
    {
      if (this.b == null) {
        this.b = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            paramAnonymousContext = null;
            if (paramAnonymousIntent != null) {
              paramAnonymousContext = paramAnonymousIntent.getAction();
            }
            if (PkgClt.a(PkgClt.this, paramAnonymousContext))
            {
              PkgClt.this.a(1);
              PkgClt.this.a(1, 5000L);
            }
          }
        };
      }
      localIntentFilter = new IntentFilter();
      int i = 0;
      while (i < a.length)
      {
        localIntentFilter.addAction(a[i]);
        i += 1;
      }
      localIntentFilter.addDataScheme("package");
    }
    try
    {
      MobSDK.getContext().registerReceiver(this.b, localIntentFilter);
      for (;;)
      {
        a(2, 3600000L);
        return;
        a(1);
        k();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void k()
  {
    if (this.b != null) {}
    try
    {
      MobSDK.getContext().unregisterReceiver(this.b);
      this.b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private void l()
  {
    ArrayList localArrayList3 = h();
    try
    {
      ArrayList localArrayList1 = DeviceHelper.getInstance(MobSDK.getContext()).getInstalledApp(false);
      if ((localArrayList3 == null) || (localArrayList3.isEmpty()))
      {
        a(com.mob.commons.a.s(), "APPS_ALL", localArrayList1);
        a(localArrayList1);
        a(com.mob.commons.a.a() + com.mob.commons.a.h() * 1000L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ArrayList localArrayList2;
      for (;;)
      {
        MobLog.getInstance().w(localThrowable);
        localArrayList2 = new ArrayList();
      }
      ArrayList localArrayList4 = a(localArrayList2, localArrayList3);
      if (!localArrayList4.isEmpty()) {
        a(com.mob.commons.a.a(), "APPS_INCR", localArrayList4);
      }
      localArrayList3 = a(localArrayList3, localArrayList2);
      if (!localArrayList3.isEmpty()) {
        a(com.mob.commons.a.a(), "UNINSTALL", localArrayList3);
      }
      a(localArrayList2);
    }
  }
  
  protected File a()
  {
    return c.a("comm/locks/.pkg_lock");
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      l();
      return;
    }
    j();
  }
  
  protected boolean b()
  {
    if (com.mob.commons.a.f()) {
      g();
    }
    return true;
  }
  
  protected void c()
  {
    b(2);
  }
  
  protected void e()
  {
    k();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/PkgClt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */