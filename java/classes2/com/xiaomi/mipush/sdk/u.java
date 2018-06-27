package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.channel.commonutils.string.c;
import com.xiaomi.push.service.ao;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.o;
import com.xiaomi.xmpush.thrift.r;
import java.util.ArrayList;
import java.util.Iterator;

public class u
{
  private static u b;
  private static final ArrayList<a> e = new ArrayList();
  private boolean a = false;
  private Context c;
  private String d;
  private Handler f = null;
  private Intent g = null;
  private Integer h = null;
  
  private u(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.d = null;
    this.a = h();
    this.f = new v(this, Looper.getMainLooper());
  }
  
  public static u a(Context paramContext)
  {
    if (b == null) {
      b = new u(paramContext);
    }
    return b;
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      this.c.startService(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      b.a(paramIntent);
    }
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    if ((!a.a(this.c).b()) || (!d.d(this.c))) {
      return;
    }
    ae localae = new ae();
    Intent localIntent = i();
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = MiPushClient.generatePacketID();
      localae.a(paramString);
      localObject = new ae(paramString, true);
    }
    for (;;)
    {
      try
      {
        p.a(this.c).a(paramString);
        if (!paramBoolean) {
          break label357;
        }
        localae.c(o.L.N);
        ((ae)localObject).c(o.L.N);
        localIntent.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
        localae.b(a.a(this.c).c());
        localae.d(this.c.getPackageName());
        a(localae, com.xiaomi.xmpush.thrift.a.i, false, null);
        ((ae)localObject).b(a.a(this.c).c());
        ((ae)localObject).d(this.c.getPackageName());
        localObject = aq.a(q.a(this.c, (org.apache.thrift.a)localObject, com.xiaomi.xmpush.thrift.a.i, false, this.c.getPackageName(), a.a(this.c).c()));
        if (localObject != null)
        {
          localIntent.putExtra("mipush_payload", (byte[])localObject);
          localIntent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
          localIntent.putExtra("mipush_app_id", a.a(this.c).c());
          localIntent.putExtra("mipush_app_token", a.a(this.c).d());
          a(localIntent);
        }
        localObject = Message.obtain();
        if (paramBoolean) {
          i = 1;
        }
        ((Message)localObject).obj = paramString;
        ((Message)localObject).arg1 = i;
        this.f.sendMessageDelayed((Message)localObject, 5000L);
        return;
      }
      finally {}
      localae.a(paramString);
      localObject = new ae(paramString, true);
      continue;
      label357:
      localae.c(o.M.N);
      ((ae)localObject).c(o.M.N);
      localIntent.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
    }
  }
  
  private boolean h()
  {
    Object localObject = this.c.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.xiaomi.xmsf", 4);
      if (localObject == null) {
        return false;
      }
      int i = ((PackageInfo)localObject).versionCode;
      if (i >= 105) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private Intent i()
  {
    Intent localIntent = new Intent();
    String str = this.c.getPackageName();
    if ((c()) && (!"com.xiaomi.xmsf".equals(str)))
    {
      localIntent.setPackage("com.xiaomi.xmsf");
      localIntent.setClassName("com.xiaomi.xmsf", j());
      localIntent.putExtra("mipush_app_package", str);
      k();
      return localIntent;
    }
    l();
    localIntent.setComponent(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"));
    localIntent.putExtra("mipush_app_package", str);
    return localIntent;
  }
  
  private String j()
  {
    try
    {
      if (this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
        return "com.xiaomi.push.service.XMPushService";
      }
    }
    catch (Exception localException) {}
    return "com.xiaomi.xmsf.push.service.XMPushService";
  }
  
  private void k()
  {
    try
    {
      this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 2, 1);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void l()
  {
    try
    {
      this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 1, 1);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private boolean m()
  {
    String str = this.c.getPackageName();
    if ((str.contains("miui")) || (str.contains("xiaomi"))) {}
    while ((this.c.getApplicationInfo().flags & 0x1) != 0) {
      return true;
    }
    return false;
  }
  
  public void a()
  {
    a(i());
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = i();
    localIntent.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
    localIntent.putExtra(com.xiaomi.push.service.am.y, this.c.getPackageName());
    localIntent.putExtra(com.xiaomi.push.service.am.z, paramInt);
    a(localIntent);
  }
  
  public final void a(af paramaf, boolean paramBoolean)
  {
    this.g = null;
    Intent localIntent = i();
    paramaf = aq.a(q.a(this.c, paramaf, com.xiaomi.xmpush.thrift.a.a));
    if (paramaf == null)
    {
      b.a("register fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.REGISTER_APP");
    localIntent.putExtra("mipush_app_id", a.a(this.c).c());
    localIntent.putExtra("mipush_payload", paramaf);
    localIntent.putExtra("mipush_session", this.d);
    localIntent.putExtra("mipush_env_chanage", paramBoolean);
    localIntent.putExtra("mipush_env_type", a.a(this.c).m());
    if ((d.d(this.c)) && (g()))
    {
      a(localIntent);
      return;
    }
    this.g = localIntent;
  }
  
  public final void a(com.xiaomi.xmpush.thrift.am paramam)
  {
    Intent localIntent = i();
    paramam = aq.a(q.a(this.c, paramam, com.xiaomi.xmpush.thrift.a.b));
    if (paramam == null)
    {
      b.a("unregister fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.UNREGISTER_APP");
    localIntent.putExtra("mipush_app_id", a.a(this.c).c());
    localIntent.putExtra("mipush_payload", paramam);
    a(localIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Intent localIntent = i();
    localIntent.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
    localIntent.putExtra(com.xiaomi.push.service.am.y, this.c.getPackageName());
    localIntent.putExtra(com.xiaomi.push.service.am.D, paramString1);
    localIntent.putExtra(com.xiaomi.push.service.am.E, paramString2);
    a(localIntent);
  }
  
  public final <T extends org.apache.thrift.a<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, r paramr)
  {
    if (!parama.equals(com.xiaomi.xmpush.thrift.a.a)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramT, parama, bool, paramr);
      return;
    }
  }
  
  public <T extends org.apache.thrift.a<T, ?>> void a(T arg1, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean)
  {
    a locala = new a();
    locala.a = ???;
    locala.b = parama;
    locala.c = paramBoolean;
    synchronized (e)
    {
      e.add(locala);
      if (e.size() > 10) {
        e.remove(0);
      }
      return;
    }
  }
  
  public final <T extends org.apache.thrift.a<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean, r paramr)
  {
    a(paramT, parama, paramBoolean, true, paramr, true);
  }
  
  public final <T extends org.apache.thrift.a<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean1, r paramr, boolean paramBoolean2)
  {
    a(paramT, parama, paramBoolean1, true, paramr, paramBoolean2);
  }
  
  public final <T extends org.apache.thrift.a<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean1, boolean paramBoolean2, r paramr, boolean paramBoolean3)
  {
    a(paramT, parama, paramBoolean1, paramBoolean2, paramr, paramBoolean3, this.c.getPackageName(), a.a(this.c).c());
  }
  
  public final <T extends org.apache.thrift.a<T, ?>> void a(T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean1, boolean paramBoolean2, r paramr, boolean paramBoolean3, String paramString1, String paramString2)
  {
    if (!a.a(this.c).i())
    {
      if (paramBoolean2)
      {
        a(paramT, parama, paramBoolean1);
        return;
      }
      b.a("drop the message before initialization.");
      return;
    }
    Intent localIntent = i();
    paramT = q.a(this.c, paramT, parama, paramBoolean1, paramString1, paramString2);
    if (paramr != null) {
      paramT.a(paramr);
    }
    paramT = aq.a(paramT);
    if (paramT == null)
    {
      b.a("send message fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.SEND_MESSAGE");
    localIntent.putExtra("mipush_payload", paramT);
    localIntent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", paramBoolean3);
    a(localIntent);
  }
  
  public final void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      p.a(this.c).f("disable_syncing");
    }
    for (;;)
    {
      a(paramString, paramBoolean);
      return;
      p.a(this.c).f("enable_syncing");
    }
  }
  
  public final void b()
  {
    Intent localIntent = i();
    localIntent.setAction("com.xiaomi.mipush.DISABLE_PUSH");
    a(localIntent);
  }
  
  public void b(int paramInt)
  {
    Intent localIntent = i();
    localIntent.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
    localIntent.putExtra(com.xiaomi.push.service.am.y, this.c.getPackageName());
    localIntent.putExtra(com.xiaomi.push.service.am.A, paramInt);
    localIntent.putExtra(com.xiaomi.push.service.am.C, c.b(this.c.getPackageName() + paramInt));
    a(localIntent);
  }
  
  public boolean c()
  {
    return (this.a) && (1 == a.a(this.c).m());
  }
  
  public void d()
  {
    if (this.g != null)
    {
      a(this.g);
      this.g = null;
    }
  }
  
  public void e()
  {
    synchronized (e)
    {
      Iterator localIterator = e.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        a(locala.a, locala.b, locala.c, false, null, true);
      }
    }
    e.clear();
  }
  
  public void f()
  {
    Intent localIntent = i();
    localIntent.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
    localIntent.putExtra(com.xiaomi.push.service.am.y, this.c.getPackageName());
    localIntent.putExtra(com.xiaomi.push.service.am.C, c.b(this.c.getPackageName()));
    a(localIntent);
  }
  
  public boolean g()
  {
    if ((c()) && (m())) {
      if (this.h == null)
      {
        this.h = Integer.valueOf(ao.a(this.c).b());
        if (this.h.intValue() == 0)
        {
          w localw = new w(this, new Handler(Looper.getMainLooper()));
          this.c.getContentResolver().registerContentObserver(ao.a(this.c).c(), false, localw);
        }
      }
    }
    return this.h.intValue() != 0;
  }
  
  static class a<T extends org.apache.thrift.a<T, ?>>
  {
    T a;
    com.xiaomi.xmpush.thrift.a b;
    boolean c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */