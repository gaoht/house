package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Field;

public class CookieSyncManager
{
  private static android.webkit.CookieSyncManager a;
  private static CookieSyncManager b;
  private static boolean c = false;
  
  private CookieSyncManager(Context paramContext)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
      c = true;
    }
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      a = android.webkit.CookieSyncManager.createInstance(paramContext);
      if ((b == null) || (!c)) {
        b = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      if (b == null) {
        throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
      }
    }
    finally {}
    CookieSyncManager localCookieSyncManager = b;
    return localCookieSyncManager;
  }
  
  public void startSync()
  {
    Object localObject = bg.b();
    if ((localObject != null) && (((bg)localObject).c()))
    {
      ((bg)localObject).d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
      return;
    }
    a.startSync();
    try
    {
      localObject = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      ((Field)localObject).setAccessible(true);
      ((Thread)((Field)localObject).get(a)).setUncaughtExceptionHandler(new l());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopSync()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
      return;
    }
    a.stopSync();
  }
  
  public void sync()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c()))
    {
      localbg.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
      return;
    }
    a.sync();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/CookieSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */