package com.unionpay.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class ag
{
  static boolean a = false;
  static volatile boolean b = false;
  static volatile boolean c = false;
  static boolean d = false;
  static boolean e = false;
  static boolean f = false;
  static bi g;
  private static final HandlerThread h = new HandlerThread("PauseEventThread");
  private static Handler i = new ah(h.getLooper());
  
  static
  {
    h.start();
  }
  
  private static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equalsIgnoreCase(paramString)) {
          return String.valueOf(paramBundle.get(paramString));
        }
      }
    }
    return null;
  }
  
  private static final String a(Throwable paramThrowable)
  {
    int j = 50;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.toString());
    localStringBuilder.append("\r\n");
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if (arrayOfStackTraceElement.length > 50) {}
    for (;;)
    {
      int k = 0;
      while (k < j)
      {
        localStringBuilder.append("\t");
        localStringBuilder.append(arrayOfStackTraceElement[k]);
        localStringBuilder.append("\r\n");
        k += 1;
      }
      j = arrayOfStackTraceElement.length;
    }
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null) {
      a(localStringBuilder, arrayOfStackTraceElement, paramThrowable, 1);
    }
    return localStringBuilder.toString();
  }
  
  static final void a()
  {
    f = true;
  }
  
  static final void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    a(paramActivity, paramActivity.getLocalClassName(), true);
  }
  
  static final void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((o.f() != null) && (o.f().equals("2"))) {
      b();
    }
    i.removeMessages(0);
    o.b("0");
    if (!b) {
      a(paramActivity, paramString1, paramString2);
    }
    r.execute(new ak(paramActivity, paramActivity.getLocalClassName()));
  }
  
  static final void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (!b) {
      a(paramActivity);
    }
    if ((o.f() != null) && (o.f().equals("2"))) {
      b();
    }
    i.removeMessages(0);
    o.b("0");
    if ((paramActivity != null) && ((paramActivity.getChangingConfigurations() & 0x80) == 128))
    {
      k.a("Ignore page changing during screen switch");
      d = true;
      return;
    }
    r.execute(new aj(paramString, paramBoolean, paramActivity));
  }
  
  static final void a(Context paramContext)
  {
    Object localObject;
    String str2;
    if (!b)
    {
      if (paramContext == null) {
        return;
      }
      String str1;
      try
      {
        localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
        str2 = a((Bundle)localObject, "UP_APP_ID");
        str1 = a((Bundle)localObject, "UP_CHANNEL_ID");
        if ((str2 == null) || (str2.trim().isEmpty()))
        {
          k.b("[SDKInit] UP_APP_ID not found in AndroidManifest.xml!");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        k.a("[SDKInit] Failed to initialize!", paramContext);
        return;
      }
      if (str1 == null) {
        break label105;
      }
      localObject = str1;
      if (str1.trim().isEmpty()) {
        break label105;
      }
    }
    for (;;)
    {
      a(paramContext, str2, (String)localObject, true);
      return;
      g();
      b();
      return;
      label105:
      localObject = "Default";
    }
  }
  
  static final void a(Context paramContext, String paramString)
  {
    k.a("onPageStart being called!, pagename: " + paramString);
    if (d)
    {
      d = false;
      return;
    }
    String str = paramString;
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if (paramString != null)
      {
        str = paramString;
        if (!paramString.isEmpty()) {}
      }
      else
      {
        str = localActivity.getLocalClassName();
      }
    }
    a(paramContext, str, 6);
  }
  
  private static final void a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext != null) && (!b)) {
      a(paramContext);
    }
    r.execute(new am(paramInt, paramString));
  }
  
  static final void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      k.a("Init failed Context is null");
      return;
    }
    d.c = paramContext.getApplicationContext();
    a(paramContext, paramString1, paramString2, false);
  }
  
  static final void a(Context paramContext, String paramString1, String paramString2, Map paramMap)
  {
    r.execute(new ai(paramString1, paramString2, paramMap, paramContext));
  }
  
  private static final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    long l1 = System.currentTimeMillis();
    if (a) {
      k.a("[TimeSpan] Init Begin at: " + String.valueOf(l1));
    }
    r.c = "UPLog";
    if (!b)
    {
      if (paramContext == null) {}
      try
      {
        k.a("Init failed Context is null");
        return;
      }
      catch (Throwable paramContext)
      {
        k.a("[SDKInit] Failed to initialize!", paramContext);
      }
      d.c = paramContext.getApplicationContext();
      if (paramBoolean) {
        break label188;
      }
      if ((paramContext == null) || (paramString1 == null) || (paramString1.trim().isEmpty())) {
        break label182;
      }
      if (j != 0) {
        break label188;
      }
      k.b("[SDKInit] Failed to initialize due to invalid input.");
      return;
    }
    for (;;)
    {
      Thread.setDefaultUncaughtExceptionHandler(new c());
      if (!a) {
        return;
      }
      long l2 = System.currentTimeMillis();
      k.a("[TimeSpan] Init End at: " + String.valueOf(l2));
      k.a("[TimeSpan] Init duration: " + String.valueOf(l2 - l1));
      return;
      label182:
      j = 0;
      break;
      label188:
      if (r.b(paramContext, "android.permission.INTERNET")) {
        break label211;
      }
      k.b("[SDKInit] Permission \"android.permission.INTERNET\" is needed.");
      b = true;
    }
    label211:
    String str2 = r.a(paramContext, "ChannelConfig.json");
    String str1 = paramString2;
    if (str2 != null) {
      if (!str2.trim().isEmpty()) {
        break label471;
      }
    }
    label379:
    label471:
    for (str1 = paramString2;; str1 = str2)
    {
      d.a(paramString1, str1);
      try
      {
        ar.a().register(u.a());
        paramBoolean = r.a(14);
        if (paramBoolean)
        {
          paramString1 = null;
          try
          {
            if (!(d.c instanceof Activity)) {
              break label379;
            }
            paramString1 = ((Activity)d.c).getApplication();
            if ((paramString1 != null) && (!e))
            {
              paramString2 = Class.forName("android.app.Application$ActivityLifecycleCallbacks");
              paramString2 = paramString1.getClass().getMethod("registerActivityLifecycleCallbacks", new Class[] { paramString2 });
              g = new bi();
              paramString2.invoke(paramString1, new Object[] { g });
              e = true;
            }
            g();
          }
          catch (Throwable paramString1)
          {
            for (;;)
            {
              if (a) {
                paramString1.printStackTrace();
              }
            }
          }
          r.execute(new ao(paramContext));
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          k.a(paramString1);
          continue;
          if ((d.c instanceof Application))
          {
            paramString1 = (Application)d.c;
            continue;
            paramString1 = new ap(paramContext);
            try
            {
              r.a(Class.forName("android.app.ActivityManagerNative"), paramString1, "gDefault", "android.app.IActivityManager");
              e = true;
            }
            catch (Throwable paramString1)
            {
              k.b("registerActivityLifecycleListener " + paramString1.getMessage());
            }
          }
        }
      }
    }
  }
  
  static final void a(Context paramContext, Throwable paramThrowable)
  {
    r.execute(new an(paramThrowable, paramContext));
  }
  
  static final void a(String paramString, long paramLong)
  {
    if (d.c != null) {
      l.a(d.c, "UPpref_longtime", "UPadditionalVersionName", paramString);
    }
    if (d.c != null) {
      l.a(d.c, "UPpref_longtime", "UPadditionalVersionCode", paramLong);
    }
  }
  
  private static final void a(StringBuilder paramStringBuilder, StackTraceElement[] paramArrayOfStackTraceElement, Throwable paramThrowable, int paramInt)
  {
    int j = paramInt;
    for (;;)
    {
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      paramInt = arrayOfStackTraceElement.length;
      int k = paramArrayOfStackTraceElement.length;
      paramInt -= 1;
      k -= 1;
      while ((paramInt >= 0) && (k >= 0) && (arrayOfStackTraceElement[paramInt].equals(paramArrayOfStackTraceElement[k])))
      {
        k -= 1;
        paramInt -= 1;
      }
      k = paramInt;
      if (paramInt > 50) {
        k = 50;
      }
      paramStringBuilder.append("Caused by : ");
      paramStringBuilder.append(paramThrowable);
      paramStringBuilder.append("\r\n");
      paramInt = 0;
      while (paramInt <= k)
      {
        paramStringBuilder.append("\t");
        paramStringBuilder.append(arrayOfStackTraceElement[paramInt]);
        paramStringBuilder.append("\r\n");
        paramInt += 1;
      }
      if (j >= 5) {}
      while (paramThrowable.getCause() == null) {
        return;
      }
      j += 1;
      paramArrayOfStackTraceElement = arrayOfStackTraceElement;
    }
  }
  
  static final void a(Throwable paramThrowable, String paramString)
  {
    int j = 0;
    if (d.c == null) {
      return;
    }
    for (Object localObject = paramThrowable; ((Throwable)localObject).getCause() != null; localObject = ((Throwable)localObject).getCause()) {}
    StackTraceElement[] arrayOfStackTraceElement = ((Throwable)localObject).getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject.getClass().getName()).append(":");
    localObject = d.c.getPackageName();
    int m;
    for (int k = 0; (k < 3) && (j < arrayOfStackTraceElement.length); k = m)
    {
      String str = arrayOfStackTraceElement[j].getClassName();
      if (str.startsWith("java."))
      {
        m = k;
        if (!((String)localObject).startsWith("java.")) {}
      }
      else if (str.startsWith("javax."))
      {
        m = k;
        if (!((String)localObject).startsWith("javax.")) {}
      }
      else if (str.startsWith("android."))
      {
        m = k;
        if (!((String)localObject).startsWith("android.")) {}
      }
      else if (str.startsWith("com.android."))
      {
        m = k;
        if (!((String)localObject).startsWith("com.android.")) {}
      }
      else
      {
        localStringBuilder.append(arrayOfStackTraceElement[j].toString()).append(":");
        m = k + 1;
      }
      j += 1;
    }
    if (paramString.trim().isEmpty()) {}
    for (long l = System.currentTimeMillis();; l = Long.valueOf(paramString).longValue())
    {
      t.a().b();
      t.a().a(l, a(paramThrowable));
      t.a().c();
      o.a(System.currentTimeMillis());
      return;
    }
  }
  
  static final String b(Context paramContext)
  {
    if ((paramContext != null) && (!b)) {
      a(paramContext, d.a(paramContext), d.b(paramContext));
    }
    return g.a(paramContext);
  }
  
  static void b()
  {
    a locala = new a();
    locala.a.put("apiType", Integer.valueOf(1));
    locala.a.put("controller", af.a());
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.obj = locala;
    bk.a().sendMessageDelayed(localMessage, 100L);
  }
  
  static final void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    b(paramActivity, paramActivity.getLocalClassName(), true);
  }
  
  static final void b(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    o.b("1");
    r.execute(new al(paramString, paramActivity, paramBoolean));
    i.removeMessages(0);
    i.sendEmptyMessageDelayed(0, d.k);
  }
  
  static final void b(Context paramContext, String paramString)
  {
    k.a("onPageEnd being called! pageName: " + paramString);
    Object localObject = null;
    String str = paramString;
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if (paramString != null)
      {
        localObject = localActivity;
        str = paramString;
        if (!paramString.isEmpty()) {}
      }
      else
      {
        str = localActivity.getLocalClassName();
        localObject = localActivity;
      }
    }
    if ((localObject != null) && ((((Activity)localObject).getChangingConfigurations() & 0x80) == 128))
    {
      d = true;
      return;
    }
    a(paramContext, str, 7);
  }
  
  static FileChannel c()
  {
    localObject3 = null;
    try
    {
      Object localObject1 = new File(d.c.getFilesDir(), "td.lock");
      if (!((File)localObject1).exists()) {
        ((File)localObject1).createNewFile();
      }
      Object localObject2 = new RandomAccessFile((File)localObject1, "rw");
      try
      {
        do
        {
          ((RandomAccessFile)localObject2).close();
          localObject2 = localObject3;
        } while (!UPAgent.LOG_ON);
        localThrowable1.printStackTrace();
        return null;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (UPAgent.LOG_ON) {
            localException.printStackTrace();
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localObject1 = ((RandomAccessFile)localObject2).getChannel();
        localObject2 = localObject1;
        return (FileChannel)localObject2;
      }
      catch (Throwable localThrowable2)
      {
        for (;;) {}
      }
      localThrowable1 = localThrowable1;
      localObject2 = null;
    }
  }
  
  static void d() {}
  
  private static void g()
  {
    af.a();
    ad.a();
    ae.a();
    c.a();
  }
  
  static final class a
  {
    HashMap a = new HashMap();
    boolean b = true;
  }
  
  static final class b
  {
    private static Handler a = new aq(b.getLooper());
    private static final HandlerThread b;
    
    static
    {
      HandlerThread localHandlerThread = new HandlerThread("AdditionalHandlerThread");
      b = localHandlerThread;
      localHandlerThread.start();
    }
    
    static final Handler a()
    {
      return a;
    }
  }
  
  static final class c
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    
    public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      if (d.b)
      {
        ag.a(paramThrowable, String.valueOf(System.currentTimeMillis()));
        Log.w("UPLog", "UncaughtException in Thread " + paramThread.getName(), paramThrowable);
      }
      if (this.a != null) {
        this.a.uncaughtException(paramThread, paramThrowable);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */