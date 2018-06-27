package com.growingio.android.sdk.collection;

import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.utils.ExclusiveIOManager;
import com.growingio.android.sdk.utils.FileMMapExclusiveIO.DATA_TYPE;
import java.util.UUID;

public class SessionManager
{
  private static long a = -1L;
  private static boolean b = true;
  private static UUID c = UUID.randomUUID();
  private static boolean d = false;
  
  public static String a()
  {
    if (GConfig.s().a())
    {
      Object localObject = ExclusiveIOManager.a(AppState.l().k()).a("sid", FileMMapExclusiveIO.DATA_TYPE.d);
      if (localObject == null) {
        return c.toString();
      }
      return ((String)localObject).toString();
    }
    return c.toString();
  }
  
  public static void a(String paramString)
  {
    if (GConfig.s().a()) {
      ExclusiveIOManager.a(AppState.l().k()).a("sid", paramString, FileMMapExclusiveIO.DATA_TYPE.d);
    }
  }
  
  public static long b()
  {
    if (GConfig.s().a())
    {
      Object localObject = ExclusiveIOManager.a(AppState.l().k()).a("lgt", FileMMapExclusiveIO.DATA_TYPE.c);
      if (localObject == null) {
        return a;
      }
      a = ((Long)localObject).longValue();
      return a;
    }
    return a;
  }
  
  public static boolean c()
  {
    AppState localAppState = AppState.l();
    boolean bool;
    if (((b) && (System.currentTimeMillis() > b() + GConfig.s().r())) || (e()) || (localAppState.o()))
    {
      bool = true;
      c = UUID.randomUUID();
      a(c.toString());
      localAppState.a(false);
    }
    for (;;)
    {
      b = false;
      return bool;
      bool = false;
    }
  }
  
  static void d()
  {
    if (GConfig.s().a())
    {
      ExclusiveIOManager localExclusiveIOManager = ExclusiveIOManager.a(AppState.l().k());
      if (localExclusiveIOManager.b() <= 1)
      {
        a = System.currentTimeMillis();
        localExclusiveIOManager.a("lgt", Long.valueOf(a), FileMMapExclusiveIO.DATA_TYPE.a);
      }
    }
    for (;;)
    {
      b = true;
      return;
      a = System.currentTimeMillis();
    }
  }
  
  private static boolean e()
  {
    boolean bool2 = c.e().a();
    if (d != bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      d = bool2;
      return bool1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/SessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */