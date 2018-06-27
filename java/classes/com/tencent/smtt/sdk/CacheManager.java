package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.u;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager
{
  @Deprecated
  public static boolean cacheDisabled()
  {
    Object localObject = bg.b();
    if ((localObject != null) && (((bg)localObject).c())) {
      return ((Boolean)((bg)localObject).d().c()).booleanValue();
    }
    localObject = u.a("android.webkit.CacheManager", "cacheDisabled");
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static InputStream getCacheFile(String paramString, boolean paramBoolean)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().a(paramString, paramBoolean);
    }
    return null;
  }
  
  public static Object getCacheFile(String paramString, Map<String, String> paramMap)
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return localbg.d().g();
    }
    try
    {
      paramString = u.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[] { String.class, Map.class }, new Object[] { paramString, paramMap });
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  @Deprecated
  public static File getCacheFileBaseDir()
  {
    bg localbg = bg.b();
    if ((localbg != null) && (localbg.c())) {
      return (File)localbg.d().g();
    }
    return (File)u.a("android.webkit.CacheManager", "getCacheFileBaseDir");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/tencent/smtt/sdk/CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */