package cn.sharesdk.framework;

import android.graphics.Bitmap;
import java.util.HashMap;

public class ShareSDK
{
  public static final String SDK_TAG = "SHARESDK";
  public static final int SDK_VERSION_CODE;
  public static final String SDK_VERSION_NAME = "3.1.4";
  private static f a;
  private static boolean b;
  
  static
  {
    int i = 0;
    b = true;
    String[] arrayOfString = "3.1.4".split("\\.");
    int k = arrayOfString.length;
    int j = 0;
    while (i < k)
    {
      j = j * 100 + Integer.parseInt(arrayOfString[i]);
      i += 1;
    }
    SDK_VERSION_CODE = j;
    c();
  }
  
  static String a(int paramInt, String paramString)
  {
    c();
    return a.a(paramInt, paramString);
  }
  
  static String a(Bitmap paramBitmap)
  {
    c();
    return a.a(paramBitmap);
  }
  
  static String a(String paramString)
  {
    c();
    return a.c(paramString);
  }
  
  static String a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    c();
    return a.a(paramString1, paramBoolean, paramInt, paramString2);
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    c();
    a.a(paramInt1, paramInt2);
  }
  
  static void a(String paramString1, String paramString2)
  {
    c();
    a.a(paramString1, paramString2);
  }
  
  static boolean a()
  {
    c();
    return a.d();
  }
  
  static String b(String paramString1, String paramString2)
  {
    c();
    return a.b(paramString1, paramString2);
  }
  
  static boolean b()
  {
    c();
    return a.e();
  }
  
  private static void c()
  {
    try
    {
      if (a == null)
      {
        f localf = new f();
        localf.a();
        a = localf;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void closeDebug()
  {
    b = false;
  }
  
  public static void deleteCache()
  {
    c();
    a.f();
  }
  
  public static Platform getPlatform(String paramString)
  {
    c();
    return a.a(paramString);
  }
  
  public static Platform[] getPlatformList()
  {
    c();
    return a.b();
  }
  
  public static <T extends Service> T getService(Class<T> paramClass)
  {
    c();
    return a.c(paramClass);
  }
  
  public static boolean isDebug()
  {
    return b;
  }
  
  public static boolean isRemoveCookieOnAuthorize()
  {
    c();
    return a.c();
  }
  
  public static void logApiEvent(String paramString, int paramInt)
  {
    c();
    a.a(paramString, paramInt);
  }
  
  public static void logDemoEvent(int paramInt, Platform paramPlatform)
  {
    c();
    a.a(paramInt, paramPlatform);
  }
  
  public static String platformIdToName(int paramInt)
  {
    c();
    return a.c(paramInt);
  }
  
  public static int platformNameToId(String paramString)
  {
    c();
    return a.b(paramString);
  }
  
  public static void registerPlatform(Class<? extends CustomPlatform> paramClass)
  {
    c();
    a.d(paramClass);
  }
  
  public static void registerService(Class<? extends Service> paramClass)
  {
    c();
    a.a(paramClass);
  }
  
  public static void removeCookieOnAuthorize(boolean paramBoolean)
  {
    c();
    a.a(paramBoolean);
  }
  
  public static void setConnTimeout(int paramInt)
  {
    c();
    a.a(paramInt);
  }
  
  public static void setPlatformDevInfo(String paramString, HashMap<String, Object> paramHashMap)
  {
    c();
    a.a(paramString, paramHashMap);
  }
  
  public static void setReadTimeout(int paramInt)
  {
    c();
    a.b(paramInt);
  }
  
  public static void unregisterPlatform(Class<? extends CustomPlatform> paramClass)
  {
    c();
    a.e(paramClass);
  }
  
  public static void unregisterService(Class<? extends Service> paramClass)
  {
    c();
    a.b(paramClass);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/ShareSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */