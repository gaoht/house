package com.pgyersdk.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import android.util.Log;
import com.pgyersdk.i.e;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class b
  implements Thread.UncaughtExceptionHandler
{
  private boolean a = false;
  private g b;
  private Thread.UncaughtExceptionHandler c;
  private String d;
  private Context e;
  
  public b(Context paramContext, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, g paramg, boolean paramBoolean, String paramString)
  {
    this.e = paramContext;
    this.c = paramUncaughtExceptionHandler;
    this.a = paramBoolean;
    this.b = paramg;
    this.d = paramString;
  }
  
  private static void a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = com.pgyersdk.b.a.a + "/" + paramString2;
      if (paramString1.trim().length() > 0)
      {
        paramString2 = new BufferedWriter(new FileWriter(paramString2));
        paramString2.write(paramString1);
        paramString2.flush();
        paramString2.close();
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void a(Throwable paramThrowable, g paramg)
  {
    Date localDate = new Date();
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    try
    {
      paramThrowable = UUID.randomUUID().toString();
      Object localObject = com.pgyersdk.b.a.a + "/" + paramThrowable + ".stacktrace";
      com.pgyersdk.i.g.a("PgyerSDK", "Writing unhandled exception to: " + (String)localObject);
      localObject = new BufferedWriter(new FileWriter((String)localObject));
      ((BufferedWriter)localObject).write("Package: " + com.pgyersdk.b.a.c + "\n");
      ((BufferedWriter)localObject).write("Version Code: " + com.pgyersdk.b.a.b + "\n");
      ((BufferedWriter)localObject).write("Version Name: " + com.pgyersdk.b.a.d + "\n");
      if ((paramg == null) || (paramg.b()))
      {
        ((BufferedWriter)localObject).write("Android: " + com.pgyersdk.b.a.e + "\n");
        ((BufferedWriter)localObject).write("Manufacturer: " + com.pgyersdk.b.a.g + "\n");
        ((BufferedWriter)localObject).write("Model: " + com.pgyersdk.b.a.f + "\n");
      }
      if ((com.pgyersdk.b.a.h != null) && ((paramg == null) || (paramg.c()))) {
        ((BufferedWriter)localObject).write("CrashReporter Key: " + com.pgyersdk.b.a.h + "\n");
      }
      ((BufferedWriter)localObject).write("Date: " + localDate + "\n");
      ((BufferedWriter)localObject).write("\n");
      ((BufferedWriter)localObject).write(localStringWriter.toString());
      ((BufferedWriter)localObject).flush();
      ((BufferedWriter)localObject).close();
      if (paramg != null)
      {
        a(b(paramg.d()), paramThrowable + ".user");
        a(b(paramg.e()), paramThrowable + ".contact");
        a(paramg.f(), paramThrowable + ".description");
      }
      return;
    }
    catch (Exception paramThrowable)
    {
      Log.e("PgyerSDK", "Error saving exception stacktrace!\n", paramThrowable);
    }
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 255) {
        str = paramString.substring(0, 255);
      }
    }
    return str;
  }
  
  public void a(g paramg)
  {
    this.b = paramg;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(Throwable paramThrowable)
  {
    Object localObject3 = new Date();
    localBoolean = Boolean.valueOf(false);
    Object localObject4 = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localObject4));
    for (;;)
    {
      try
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("Package: " + com.pgyersdk.b.a.c + "\n");
        ((StringBuffer)localObject1).append("Version Code: " + com.pgyersdk.b.a.b + "\n");
        ((StringBuffer)localObject1).append("Version Name: " + com.pgyersdk.b.a.d + "\n");
        if ((this.b == null) || (this.b.b()))
        {
          ((StringBuffer)localObject1).append("Android: " + com.pgyersdk.b.a.e + "\n");
          ((StringBuffer)localObject1).append("Manufacturer: " + com.pgyersdk.b.a.g + "\n");
          ((StringBuffer)localObject1).append("Model: " + com.pgyersdk.b.a.f + "\n");
        }
        if ((com.pgyersdk.b.a.h != null) && ((this.b == null) || (this.b.c()))) {
          ((StringBuffer)localObject1).append("CrashReporter Key: " + com.pgyersdk.b.a.h + "\n");
        }
        ((StringBuffer)localObject1).append("Date: " + localObject3 + "\n");
        ((StringBuffer)localObject1).append("\n");
        ((StringBuffer)localObject1).append(localObject4.toString());
        com.pgyersdk.i.g.a("PgyerSDK", "Transmitting crash data: \n" + localObject4.toString());
        localObject3 = new HashMap();
        ((Map)localObject3).put("crashLog", ((StringBuffer)localObject1).toString());
        ((Map)localObject3).put("versionCode", com.pgyersdk.b.a.b);
        ((Map)localObject3).put("version", com.pgyersdk.b.a.d);
        ((Map)localObject3).put("agKey", this.d);
        ((Map)localObject3).put("deviceId", com.pgyersdk.b.a.i);
        ((Map)localObject3).put("deviceName", com.pgyersdk.b.a.g);
        ((Map)localObject3).put("deviceModel", com.pgyersdk.b.a.f);
        ((Map)localObject3).put("osVersion", com.pgyersdk.b.a.e);
        ((Map)localObject3).put("resolution", com.pgyersdk.b.a.j);
        ((Map)localObject3).put("osType", "2");
        if (!com.pgyersdk.b.a.a()) {
          continue;
        }
        localObject1 = "1";
        ((Map)localObject3).put("jailBroken", localObject1);
        localObject1 = com.pgyersdk.e.a.a();
        ((Map)localObject3).put("freeSpace", localObject1[1] + " / " + localObject1[0]);
        if (com.pgyersdk.e.a.c())
        {
          localObject1 = com.pgyersdk.e.a.b();
          ((Map)localObject3).put("freeSdc", localObject1[1] + " / " + localObject1[0]);
        }
        localObject4 = com.pgyersdk.e.a.b(this.e);
        localObject1 = "";
        if (localObject4.length == 2) {
          localObject1 = localObject4[1] + " / " + localObject4[0];
        }
        ((Map)localObject3).put("freeRam", localObject1);
        ((Map)localObject3).put("protrait", this.e.getResources().getConfiguration().orientation + "");
        localObject1 = "";
        localObject4 = com.pgyersdk.e.a.a(this.e);
        if (((Map)localObject4).containsKey("network_type")) {
          localObject1 = (String)((Map)localObject4).get("network_type");
        }
        ((Map)localObject3).put("network", localObject1);
        ((Map)localObject3).put("sdkVersion", com.pgyersdk.b.a.k);
        ((Map)localObject3).put("_api_key", "305092bc73c180b55c26012a94809131");
        int i = new e("http://www.pgyer.com/apiv1/crash/add").a("POST").a((Map)localObject3, this.e, null, null).a().getResponseCode();
        if (i == 202) {
          continue;
        }
        if (i != 201) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        localException.printStackTrace();
        if (!localBoolean.booleanValue()) {
          continue;
        }
        com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
        return;
        com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed, will retry on next register() call");
        a(paramThrowable, this.b);
        return;
      }
      finally
      {
        if (!localBoolean.booleanValue()) {
          continue;
        }
        com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
        throw ((Throwable)localObject2);
        com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed, will retry on next register() call");
        a(paramThrowable, this.b);
        continue;
        boolean bool = true;
        continue;
      }
      if (!Boolean.valueOf(bool).booleanValue()) {
        continue;
      }
      com.pgyersdk.i.g.a("PgyerSDK", "Transmission succeeded");
      return;
      localObject1 = "2";
      continue;
      bool = false;
    }
    com.pgyersdk.i.g.a("PgyerSDK", "Transmission failed, will retry on next register() call");
    a(paramThrowable, this.b);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (com.pgyersdk.b.a.a == null)
    {
      this.c.uncaughtException(paramThread, paramThrowable);
      return;
    }
    new c(this, paramThrowable).start();
    if (!this.a)
    {
      this.c.uncaughtException(paramThread, paramThrowable);
      return;
    }
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */