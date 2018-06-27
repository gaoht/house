package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;

class bh
{
  private DexLoader a;
  
  public bh(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public int a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, ValueCallback<String> paramValueCallback)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return -1;
    }
    if (paramString2 == null)
    {
      paramValueCallback = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class, ValueCallback.class }, new Object[] { paramContext, paramString1, paramMap, paramValueCallback });
      paramString2 = paramValueCallback;
      if (paramValueCallback == null) {
        paramString2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString1, paramMap });
      }
      paramMap = paramString2;
      if (paramString2 == null) {
        paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      }
      if (paramMap == null) {
        return -3;
      }
      return ((Integer)paramMap).intValue();
    }
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 });
    if (paramContext == null) {
      return -3;
    }
    return ((Integer)paramContext).intValue();
  }
  
  public IX5WebViewBase a(Context paramContext)
  {
    Object localObject4 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[] { Context.class }, new Object[] { paramContext });
    if (localObject4 == null) {}
    try
    {
      localObject1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((localObject1 != null) && ((localObject1 instanceof Throwable))) {
        TbsCoreLoadStat.getInstance().a(paramContext, 325, (Throwable)localObject1);
      }
      if ((localObject1 == null) || (!(localObject1 instanceof String))) {
        break label200;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 325, new Throwable((String)localObject1));
    }
    catch (Exception localException1)
    {
      try
      {
        if (localIX5WebViewBase.getView() != null) {
          break label204;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 325, new Throwable("x5webview.getView is null!"));
        localObject3 = null;
        Object localObject1 = localIX5WebViewBase;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          IX5WebViewBase localIX5WebViewBase;
          Context localContext;
          paramContext = localIX5WebViewBase;
        }
      }
      localException1 = localException1;
      paramContext = null;
    }
    localIX5WebViewBase = (IX5WebViewBase)localObject4;
    localObject1 = localIX5WebViewBase;
    Object localObject3 = localObject4;
    if (localIX5WebViewBase != null)
    {
      localObject1 = localIX5WebViewBase;
      localObject3 = localObject4;
      localException1.printStackTrace();
      localContext = paramContext;
    }
    label200:
    label204:
    for (localObject3 = localObject4; localObject3 != null; localObject3 = null)
    {
      return localContext;
      Object localObject2 = null;
    }
    return null;
  }
  
  public InputStream a(String paramString, boolean paramBoolean)
  {
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[] { String.class, Boolean.TYPE }, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramString == null) {
      return null;
    }
    return (InputStream)paramString;
  }
  
  public String a(String paramString)
  {
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null) {
      return null;
    }
    return (String)paramString;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
    if (paramBoolean)
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class }, new Object[] { paramContext });
      return;
    }
    try
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class, Boolean.TYPE }, new Object[] { paramContext, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
      this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
      this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
      paramContext = this.a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.a.invokeMethod(paramContext, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
      }
      paramContext = this.a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.a.invokeMethod(paramContext, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
      }
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }
  }
  
  public void a(ValueCallback<Map> paramValueCallback)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void a(String paramString, long paramLong)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[] { String.class, Long.TYPE }, new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  public void a(String paramString, ValueCallback<Long> paramValueCallback)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public void a(String paramString, IconListener paramIconListener)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
  }
  
  public boolean a()
  {
    try
    {
      Object localObject = this.a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
    return ((Boolean)localThrowable).booleanValue();
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if ((paramContext instanceof Boolean)) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public boolean a(Map<String, String[]> paramMap)
  {
    paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null) {
      return false;
    }
    return ((Boolean)paramMap).booleanValue();
  }
  
  public Uri[] a(int paramInt, Intent paramIntent)
  {
    paramIntent = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[] { Integer.TYPE, Intent.class }, new Object[] { Integer.valueOf(paramInt), paramIntent });
    if (paramIntent == null) {
      return null;
    }
    return (Uri[])paramIntent;
  }
  
  public DexLoader b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void b(String paramString, ValueCallback<Long> paramValueCallback)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
  }
  
  public boolean b(Context paramContext)
  {
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public Object c()
  {
    return this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
  }
  
  public void c(Context paramContext)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void c(String paramString)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void d(String paramString)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public boolean d()
  {
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public boolean d(Context paramContext)
  {
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public void e()
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
  }
  
  public void e(Context paramContext)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public void e(String paramString)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public String f()
  {
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (String)localObject;
  }
  
  public boolean f(Context paramContext)
  {
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public Object g()
  {
    return this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
  }
  
  public void g(Context paramContext)
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
  }
  
  public boolean h()
  {
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public IX5WebChromeClient i()
  {
    if (this.a == null) {
      return null;
    }
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebChromeClient)localObject;
  }
  
  public IX5WebViewClient j()
  {
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebViewClient)localObject;
  }
  
  public IX5WebViewClientExtension k()
  {
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
    if (localObject == null) {
      return null;
    }
    return (IX5WebViewClientExtension)localObject;
  }
  
  public void l()
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
  }
  
  public void m()
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
  }
  
  public void n()
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
  }
  
  public void o()
  {
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */