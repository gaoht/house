package com.mato.android.matoid.service.mtunnel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.mato.sdk.b.g;
import com.mato.sdk.b.j;
import com.mato.sdk.b.m;
import com.mato.sdk.proxy.Proxy;
import com.mato.sdk.proxy.p;
import java.io.File;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;

public class HttpHandler
  extends Thread
{
  private static final String a = g.b("");
  private static boolean b = false;
  private static String c = "";
  private static b d;
  private static b e;
  private static int g = 0;
  private static int h = -1;
  private static int i = -2;
  private static int j = -3;
  private static int k = -4;
  private static String l = "libcom.maa.wspxld.so";
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = 2;
  private static final int p = 3;
  private final boolean f;
  
  static
  {
    b localb = new b();
    d = localb;
    e = localb;
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 3;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int a(Context paramContext, boolean paramBoolean)
    throws p
  {
    c = paramContext.getFilesDir().getAbsolutePath();
    int i1;
    for (;;)
    {
      try
      {
        System.loadLibrary("com.maa.wspxld");
        b = true;
        i1 = d();
        if (i1 > 0)
        {
          int i2 = i1 / 1000;
          int i3 = i2 / 1000;
          str = String.format(Locale.US, "%d.%d.%d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2 % 1000), Integer.valueOf(i1 % 1000) });
          if (Proxy.getVersion().startsWith(str)) {
            break;
          }
          throw new p("Invalid libcom.maa.wspxld.so's version: " + str, -14);
        }
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        Log.e(a, "please copy libcom.maa.wspxld.so to your libs");
        return -1;
      }
      catch (Throwable paramContext)
      {
        Log.e(a, "unable to loadLibrary libcom.maa.wspxld.so", paramContext);
        return -2;
      }
      String str = "Unknown";
    }
    try
    {
      if (Build.VERSION.SDK_INT < 9) {}
      for (paramContext = paramContext.getApplicationInfo().dataDir + "/lib/libcom.maa.wspxld.so";; paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/libcom.maa.wspxld.so")
      {
        i1 = init(paramContext, 6, paramBoolean);
        if (i1 == 0) {
          break;
        }
        Log.e(a, "wspxld init faild: " + i1);
        return -3;
      }
      return 0;
    }
    catch (Throwable paramContext)
    {
      Log.e(a, "wspxld init error", paramContext);
      return -4;
    }
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return paramContext.getApplicationInfo().dataDir + "/lib/libcom.maa.wspxld.so";
    }
    return paramContext.getApplicationInfo().nativeLibraryDir + "/libcom.maa.wspxld.so";
  }
  
  public static void a(b paramb)
  {
    b localb = paramb;
    if (paramb == null) {
      localb = d;
    }
    e = localb;
  }
  
  private native void addNodesToBlacklistByHost(String paramString1, String paramString2);
  
  public static String b()
  {
    if (b) {
      try
      {
        String str = getABI();
        return str;
      }
      catch (Throwable localThrowable) {}
    }
    return "unknown";
  }
  
  public static int c(boolean paramBoolean)
    throws j
  {
    if (b) {
      try
      {
        int i1 = getBindPort(false);
        return i1;
      }
      catch (Throwable localThrowable)
      {
        throw new j(localThrowable.getMessage());
      }
    }
    return -1;
  }
  
  private static String c()
  {
    int i1 = d();
    if (i1 > 0)
    {
      int i2 = i1 / 1000;
      int i3 = i2 / 1000;
      return String.format(Locale.US, "%d.%d.%d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2 % 1000), Integer.valueOf(i1 % 1000) });
    }
    return "Unknown";
  }
  
  private static int d()
  {
    if (b) {
      try
      {
        int i1 = getVersion();
        return i1;
      }
      catch (Throwable localThrowable) {}
    }
    return -1;
  }
  
  private void e()
  {
    if (!b) {
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      try
      {
        setVideoViaProxy(true);
        i1 = 1;
        String str3 = g.a;
        Locale localLocale = Locale.US;
        if (i1 == 0) {
          break label65;
        }
        String str1 = "enabled";
        Log.i(str3, String.format(localLocale, "wsjh %s", new Object[] { str1 }));
        return;
      }
      catch (Throwable localThrowable) {}
      int i1 = 0;
      continue;
      label65:
      String str2 = "disabled";
    }
  }
  
  private static int f()
  {
    for (;;)
    {
      try
      {
        localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        i1 = 0;
      }
      catch (Throwable localThrowable2)
      {
        Enumeration localEnumeration1;
        NetworkInterface localNetworkInterface;
        Enumeration localEnumeration2;
        int i1 = 0;
        continue;
      }
      try
      {
        if (!localEnumeration1.hasMoreElements()) {
          continue;
        }
        localNetworkInterface = (NetworkInterface)localEnumeration1.nextElement();
        localEnumeration2 = localNetworkInterface.getInetAddresses();
        try
        {
          if (localEnumeration2.hasMoreElements())
          {
            InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
            if ((localInetAddress.isLoopbackAddress()) || (localInetAddress.isLinkLocalAddress())) {
              continue;
            }
            if ((localInetAddress instanceof Inet4Address))
            {
              localNetworkInterface.getName();
              localInetAddress.getHostAddress().toString();
              i1 |= 0x1;
              continue;
            }
            if ((localInetAddress instanceof Inet6Address))
            {
              localNetworkInterface.getName();
              localInetAddress.getHostAddress().toString();
              i1 |= 0x2;
              continue;
            }
            localNetworkInterface.getName();
            localInetAddress.getHostAddress().toString();
            continue;
            return i1;
          }
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable3)
      {
        continue;
      }
    }
  }
  
  private static native String getABI();
  
  private native String getAuthString(String paramString);
  
  private static native int getBindPort(boolean paramBoolean);
  
  public static String getFilesDir()
  {
    return c;
  }
  
  public static int getNetworkState()
  {
    return e.b();
  }
  
  public static String getOriginalDestAddr(int paramInt)
  {
    return m.e(paramInt);
  }
  
  private static native int getVersion();
  
  private native int handleHTTP();
  
  private static native int init(String paramString, int paramInt, boolean paramBoolean);
  
  public static void onAccessCountChanged(int paramInt)
  {
    e.b(paramInt);
  }
  
  public static void onBackendhostResolved(String paramString1, String[] paramArrayOfString, String paramString2) {}
  
  public static void onHijackDetectionDone(String paramString)
  {
    e.b(paramString);
  }
  
  public static void onHttpFailed(int paramInt, String paramString1, String paramString2) {}
  
  private static int onNdkCallback(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    paramInt3 = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      return paramInt1;
    case 0: 
      return e.a(paramString1, paramString2);
    case 1: 
      return e.b(paramString1, paramString2);
    case 2: 
      return e.a(paramInt2, paramString1);
    }
    paramInt1 = paramInt3;
    switch (f())
    {
    case 1: 
    default: 
      return 3;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public static void onNdkCrashed(String paramString)
  {
    e.a(paramString);
  }
  
  private native void resetCustomHeaders(String[] paramArrayOfString, int paramInt);
  
  private native void resetTunnel(boolean paramBoolean);
  
  private native void setAccessLogPath(String paramString);
  
  private native void setBypassRemoteProxy(boolean paramBoolean);
  
  private native void setDebugLogSettings(int paramInt, String paramString);
  
  private native void setSettings(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean);
  
  private native void setVideoViaProxy(boolean paramBoolean);
  
  private native void startHijackDetection(String[] paramArrayOfString);
  
  private native void stopServer();
  
  private native void xcacheAppendFiles(String[] paramArrayOfString);
  
  private native void xcacheSetCacheDir(String paramString);
  
  private native void xcacheSwitch(boolean paramBoolean);
  
  public final String a(String paramString)
    throws j
  {
    if (b) {
      try
      {
        paramString = getAuthString(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        throw new j(paramString.getMessage());
      }
    }
    return null;
  }
  
  public final void a()
    throws j
  {
    if (b) {}
    try
    {
      stopServer();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new j(localThrowable.getMessage());
    }
  }
  
  public final void a(int paramInt, String paramString)
    throws j
  {
    if (!b) {
      return;
    }
    try
    {
      setDebugLogSettings(paramInt, paramString);
      return;
    }
    catch (Throwable paramString)
    {
      throw new j(paramString.getMessage());
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!b) {
      return;
    }
    try
    {
      addNodesToBlacklistByHost(paramString1, paramString2);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public final void a(boolean paramBoolean)
    throws j
  {
    if (b) {}
    try
    {
      setBypassRemoteProxy(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new j(localThrowable.getMessage());
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws j
  {
    if (b) {}
    try
    {
      setSettings(paramArrayOfByte, paramInt, paramBoolean);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw new j(paramArrayOfByte.getMessage());
    }
  }
  
  public final void a(String[] paramArrayOfString)
    throws j
  {
    if (!b) {}
    while (paramArrayOfString == null) {
      return;
    }
    try
    {
      xcacheAppendFiles(paramArrayOfString);
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      throw new j(paramArrayOfString.getMessage());
    }
  }
  
  public final void a(String[] paramArrayOfString, int paramInt)
    throws j
  {
    if (b) {}
    try
    {
      resetCustomHeaders(paramArrayOfString, paramInt);
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      throw new j(paramArrayOfString.getMessage());
    }
  }
  
  public final void b(String paramString)
    throws j
  {
    if (!b) {
      return;
    }
    try
    {
      setAccessLogPath(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      throw new j(paramString.getMessage());
    }
  }
  
  public final void b(boolean paramBoolean)
    throws j
  {
    if (b) {}
    try
    {
      xcacheSwitch(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new j(localThrowable.getMessage());
    }
  }
  
  public final void b(String[] paramArrayOfString)
    throws j
  {
    if (!b) {
      return;
    }
    try
    {
      startHijackDetection(paramArrayOfString);
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      throw new j(paramArrayOfString.getMessage());
    }
  }
  
  public final void c(String paramString)
    throws j
  {
    if (!b) {
      return;
    }
    try
    {
      xcacheSetCacheDir(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      throw new j(paramString.getMessage());
    }
  }
  
  public final void d(boolean paramBoolean)
    throws j
  {
    if (b) {}
    try
    {
      resetTunnel(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new j(localThrowable.getMessage());
    }
  }
  
  public void run()
  {
    if (!b) {
      return;
    }
    int i1 = 55450;
    try
    {
      int i2 = handleHTTP();
      i1 = i2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e(a, "handleHTTP unknown error", localThrowable);
      }
    }
    Log.w(a, String.format(Locale.US, "handleHTTP retcode=%d", new Object[] { Integer.valueOf(i1) }));
    e.c(i1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/android/matoid/service/mtunnel/HttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */