package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.network.HostManager;
import com.xiaomi.smack.g;
import com.xiaomi.smack.l;
import com.xiaomi.stats.h;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.af;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class XMPushService
  extends Service
  implements com.xiaomi.smack.d
{
  public static int b = 1;
  private static final int g = ;
  final BroadcastReceiver a = new bg(this);
  private com.xiaomi.smack.b c;
  private ar d;
  private e e;
  private long f = 0L;
  private com.xiaomi.slim.f h;
  private com.xiaomi.smack.a i;
  private b j;
  private PacketSync k = null;
  private i l = null;
  private com.xiaomi.smack.f m = new az(this);
  
  static
  {
    HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
    HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2:443");
    HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
    HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
    HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
  }
  
  @TargetApi(11)
  public static Notification a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, XMPushService.class);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = new Notification.Builder(paramContext);
      ((Notification.Builder)localObject).setSmallIcon(paramContext.getApplicationInfo().icon);
      ((Notification.Builder)localObject).setContentTitle("Push Service");
      ((Notification.Builder)localObject).setContentText("Push Service");
      ((Notification.Builder)localObject).setContentIntent(PendingIntent.getActivity(paramContext, 0, localIntent, 0));
      return ((Notification.Builder)localObject).getNotification();
    }
    Object localObject = new Notification();
    ((Notification)localObject).setLatestEventInfo(paramContext, "Push Service", "Push Service", PendingIntent.getService(paramContext, 0, localIntent, 0));
    return (Notification)localObject;
  }
  
  private com.xiaomi.smack.packet.c a(com.xiaomi.smack.packet.c paramc, String paramString)
  {
    Object localObject = aq.a(paramString, paramc.k());
    paramString = new com.xiaomi.smack.packet.c();
    paramString.n(paramc.n());
    paramString.m(paramc.m());
    paramString.k(paramc.k());
    paramString.l(paramc.l());
    paramString.b(true);
    paramc = aq.a((byte[])localObject, com.xiaomi.smack.util.d.c(paramc.c()));
    localObject = new com.xiaomi.smack.packet.a("s", null, (String[])null, (String[])null);
    ((com.xiaomi.smack.packet.a)localObject).b(paramc);
    paramString.a((com.xiaomi.smack.packet.a)localObject);
    return paramString;
  }
  
  private com.xiaomi.smack.packet.d a(com.xiaomi.smack.packet.d paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    ak localak = ak.a();
    List localList = localak.b(paramString1);
    if (localList.isEmpty())
    {
      com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before sending a packet, pkg=" + paramString1);
      paramString1 = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramString1;
        paramd.o(paramString1);
        localObject = paramd.l();
        paramString1 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString1 = (String)localList.get(0);
          paramd.l(paramString1);
        }
        localObject = localak.b(paramString1, paramd.n());
        if (!f())
        {
          com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not connected, chid=" + paramString1);
          break;
        }
        if ((localObject == null) || (((ak.b)localObject).m != ak.c.c))
        {
          com.xiaomi.channel.commonutils.logger.b.a("drop a packet as the channel is not opened, chid=" + paramString1);
          break;
        }
        if (!TextUtils.equals(paramString2, ((ak.b)localObject).j))
        {
          com.xiaomi.channel.commonutils.logger.b.a("invalid session. " + paramString2);
          break;
        }
        paramString1 = paramd;
      } while (!(paramd instanceof com.xiaomi.smack.packet.c));
      paramString1 = paramd;
    } while (!paramBoolean);
    return a((com.xiaomi.smack.packet.c)paramd, ((ak.b)localObject).i);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra(am.y);
    Object localObject2 = paramIntent.getStringExtra(am.B);
    Bundle localBundle = paramIntent.getBundleExtra("ext_packet");
    boolean bool = paramIntent.getBooleanExtra("ext_encrypt", true);
    localObject1 = (com.xiaomi.smack.packet.c)a(new com.xiaomi.smack.packet.c(localBundle), (String)localObject1, (String)localObject2, false);
    if (localObject1 == null) {}
    do
    {
      return;
      localObject2 = ak.a().b(((com.xiaomi.smack.packet.c)localObject1).l(), ((com.xiaomi.smack.packet.c)localObject1).n());
      if ((bool) && ("3".equals(((com.xiaomi.smack.packet.c)localObject1).l())))
      {
        paramIntent = h();
        if ((paramIntent != null) && (paramIntent.a()))
        {
          c(new as(this, com.xiaomi.slim.b.a((com.xiaomi.smack.packet.d)localObject1, ((ak.b)localObject2).i)));
          return;
        }
      }
      paramIntent = (Intent)localObject1;
      if (bool) {
        paramIntent = a((com.xiaomi.smack.packet.c)localObject1, ((ak.b)localObject2).i);
      }
    } while (paramIntent == null);
    c(new as(this, paramIntent));
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = ak.a().c(paramString);
    if (localObject != null)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ak.b localb = (ak.b)((Iterator)localObject).next();
        if (localb != null) {
          a(new o(localb, paramInt, null, null));
        }
      }
    }
    ak.a().a(paramString);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Collection localCollection = ak.a().c("5");
    if (localCollection.isEmpty()) {
      if (paramBoolean) {
        r.b(paramString, paramArrayOfByte);
      }
    }
    do
    {
      return;
      if (((ak.b)localCollection.iterator().next()).m == ak.c.c) {
        break;
      }
    } while (!paramBoolean);
    r.b(paramString, paramArrayOfByte);
    return;
    c(new bm(this, 4, paramString, paramArrayOfByte));
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if ((TextUtils.equals(paramString, "Enter")) && (paramInt == 1)) {}
    while ((TextUtils.equals(paramString, "Leave")) && (paramInt == 2)) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra(am.p);
    localObject = ak.a().b(paramString, (String)localObject);
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localObject != null)
    {
      bool1 = bool3;
      if (paramString != null)
      {
        String str = paramIntent.getStringExtra(am.B);
        paramIntent = paramIntent.getStringExtra(am.u);
        bool1 = bool2;
        if (!TextUtils.isEmpty(((ak.b)localObject).j))
        {
          bool1 = bool2;
          if (!TextUtils.equals(str, ((ak.b)localObject).j))
          {
            com.xiaomi.channel.commonutils.logger.b.a("session changed. old session=" + ((ak.b)localObject).j + ", new session=" + str + " chid = " + paramString);
            bool1 = true;
          }
        }
        if (!paramIntent.equals(((ak.b)localObject).i))
        {
          com.xiaomi.channel.commonutils.logger.b.a("security changed. chid = " + paramString + " sechash = " + com.xiaomi.channel.commonutils.string.c.a(paramIntent));
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString1, String paramString2, Context paramContext)
  {
    if ((TextUtils.equals("Leave", paramString1)) && (!TextUtils.equals("Enter", e.a(paramContext).c(paramString2)))) {
      return false;
    }
    if (e.a(paramContext).a(paramString2, paramString1) == 0)
    {
      com.xiaomi.channel.commonutils.logger.b.a("update geofence statue failed geo_id:" + paramString2);
      return false;
    }
    return true;
  }
  
  private ak.b b(String paramString, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra(am.p);
    localObject = ak.a().b(paramString, (String)localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ak.b(this);
    }
    paramString.h = paramIntent.getStringExtra(am.q);
    paramString.b = paramIntent.getStringExtra(am.p);
    paramString.c = paramIntent.getStringExtra(am.s);
    paramString.a = paramIntent.getStringExtra(am.y);
    paramString.f = paramIntent.getStringExtra(am.w);
    paramString.g = paramIntent.getStringExtra(am.x);
    paramString.e = paramIntent.getBooleanExtra(am.v, false);
    paramString.i = paramIntent.getStringExtra(am.u);
    paramString.j = paramIntent.getStringExtra(am.B);
    paramString.d = paramIntent.getStringExtra(am.t);
    paramString.k = this.j;
    paramString.l = getApplicationContext();
    ak.a().a(paramString);
    return paramString;
  }
  
  private void b(Intent paramIntent)
  {
    int i2 = 0;
    int i1 = 0;
    Object localObject = paramIntent.getStringExtra(am.y);
    String str = paramIntent.getStringExtra(am.B);
    Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("ext_packets");
    com.xiaomi.smack.packet.c[] arrayOfc = new com.xiaomi.smack.packet.c[arrayOfParcelable.length];
    boolean bool = paramIntent.getBooleanExtra("ext_encrypt", true);
    int n = 0;
    while (n < arrayOfParcelable.length)
    {
      arrayOfc[n] = new com.xiaomi.smack.packet.c((Bundle)arrayOfParcelable[n]);
      arrayOfc[n] = ((com.xiaomi.smack.packet.c)a(arrayOfc[n], (String)localObject, str, false));
      if (arrayOfc[n] == null) {
        return;
      }
      n += 1;
    }
    localObject = ak.a();
    n = i2;
    if (bool)
    {
      n = i2;
      if ("3".equals(arrayOfc[0].l()))
      {
        paramIntent = h();
        n = i2;
        if (paramIntent != null)
        {
          n = i2;
          if (paramIntent.a())
          {
            paramIntent = new com.xiaomi.slim.b[arrayOfc.length];
            n = i1;
            while (n < arrayOfc.length)
            {
              str = arrayOfc[n];
              paramIntent[n] = com.xiaomi.slim.b.a(str, ((ak)localObject).b(str.l(), str.n()).i);
              n += 1;
            }
            c(new a(this, paramIntent));
            return;
          }
        }
      }
    }
    if (n < arrayOfc.length)
    {
      paramIntent = ((ak)localObject).b(arrayOfc[n].l(), arrayOfc[n].n());
      if (bool) {}
      for (paramIntent = a(arrayOfc[n], paramIntent.i);; paramIntent = arrayOfc[n])
      {
        arrayOfc[n] = paramIntent;
        n += 1;
        break;
      }
    }
    c(new a(this, arrayOfc));
  }
  
  private void b(boolean paramBoolean)
  {
    this.f = System.currentTimeMillis();
    if (this.l.d())
    {
      com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
      ak.a().a(this, 14);
      stopSelf();
      return;
    }
    if (!f())
    {
      a(true);
      return;
    }
    if ((this.i.o()) || (com.xiaomi.channel.commonutils.network.d.f(this)))
    {
      a(new l(paramBoolean));
      return;
    }
    a(new f(17, null));
    a(true);
  }
  
  private void c(Intent paramIntent)
  {
    Object localObject2 = null;
    int n = 1;
    int i1 = 0;
    Object localObject4 = ak.a();
    Object localObject1;
    if ((am.d.equalsIgnoreCase(paramIntent.getAction())) || (am.j.equalsIgnoreCase(paramIntent.getAction())))
    {
      localObject1 = paramIntent.getStringExtra(am.q);
      if (TextUtils.isEmpty(paramIntent.getStringExtra(am.u))) {
        com.xiaomi.channel.commonutils.logger.b.a("security is empty. ignore.");
      }
    }
    label933:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  boolean bool;
                  for (;;)
                  {
                    return;
                    if (localObject1 != null)
                    {
                      bool = a((String)localObject1, paramIntent);
                      paramIntent = b((String)localObject1, paramIntent);
                      if (!com.xiaomi.channel.commonutils.network.d.d(this))
                      {
                        this.j.a(this, paramIntent, false, 2, null);
                        return;
                      }
                      if (f())
                      {
                        if (paramIntent.m == ak.c.a)
                        {
                          c(new a(paramIntent));
                          return;
                        }
                        if (bool)
                        {
                          c(new m(paramIntent));
                          return;
                        }
                        if (paramIntent.m == ak.c.b)
                        {
                          com.xiaomi.channel.commonutils.logger.b.a(String.format("the client is binding. %1$s %2$s.", new Object[] { paramIntent.h, paramIntent.b }));
                          return;
                        }
                        if (paramIntent.m == ak.c.c) {
                          this.j.a(this, paramIntent, true, 0, null);
                        }
                      }
                      else
                      {
                        a(true);
                      }
                    }
                    else
                    {
                      com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
                      return;
                      if (am.i.equalsIgnoreCase(paramIntent.getAction()))
                      {
                        localObject1 = paramIntent.getStringExtra(am.y);
                        localObject2 = paramIntent.getStringExtra(am.q);
                        paramIntent = paramIntent.getStringExtra(am.p);
                        com.xiaomi.channel.commonutils.logger.b.a("Service called closechannel chid = " + (String)localObject2 + " userId = " + paramIntent);
                        if (TextUtils.isEmpty((CharSequence)localObject2))
                        {
                          paramIntent = ((ak)localObject4).b((String)localObject1).iterator();
                          while (paramIntent.hasNext()) {
                            a((String)paramIntent.next(), 2);
                          }
                        }
                        else
                        {
                          if (TextUtils.isEmpty(paramIntent))
                          {
                            a((String)localObject2, 2);
                            return;
                          }
                          a((String)localObject2, paramIntent, 2, null, null);
                        }
                      }
                      else
                      {
                        if (am.e.equalsIgnoreCase(paramIntent.getAction()))
                        {
                          a(paramIntent);
                          return;
                        }
                        if (am.g.equalsIgnoreCase(paramIntent.getAction()))
                        {
                          b(paramIntent);
                          return;
                        }
                        if (am.f.equalsIgnoreCase(paramIntent.getAction()))
                        {
                          localObject1 = paramIntent.getStringExtra(am.y);
                          localObject2 = paramIntent.getStringExtra(am.B);
                          paramIntent = new com.xiaomi.smack.packet.b(paramIntent.getBundleExtra("ext_packet"));
                          if (a(paramIntent, (String)localObject1, (String)localObject2, false) != null) {
                            c(new as(this, paramIntent));
                          }
                        }
                        else if (am.h.equalsIgnoreCase(paramIntent.getAction()))
                        {
                          localObject1 = paramIntent.getStringExtra(am.y);
                          localObject2 = paramIntent.getStringExtra(am.B);
                          paramIntent = new com.xiaomi.smack.packet.f(paramIntent.getBundleExtra("ext_packet"));
                          if (a(paramIntent, (String)localObject1, (String)localObject2, false) != null) {
                            c(new as(this, paramIntent));
                          }
                        }
                        else if (am.k.equals(paramIntent.getAction()))
                        {
                          localObject1 = paramIntent.getStringExtra(am.q);
                          localObject2 = paramIntent.getStringExtra(am.p);
                          if (localObject1 != null)
                          {
                            com.xiaomi.channel.commonutils.logger.b.a("request reset connection from chid = " + (String)localObject1);
                            localObject1 = ak.a().b((String)localObject1, (String)localObject2);
                            if ((localObject1 != null) && (((ak.b)localObject1).i.equals(paramIntent.getStringExtra(am.u))) && (((ak.b)localObject1).m == ak.c.c))
                            {
                              paramIntent = h();
                              if ((paramIntent == null) || (!paramIntent.a(System.currentTimeMillis() - 15000L))) {
                                c(new n());
                              }
                            }
                          }
                        }
                        else
                        {
                          if (!am.l.equals(paramIntent.getAction())) {
                            break;
                          }
                          localObject1 = paramIntent.getStringExtra(am.y);
                          List localList = ((ak)localObject4).b((String)localObject1);
                          if (localList.isEmpty())
                          {
                            com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before update info, pkg=" + (String)localObject1);
                            return;
                          }
                          localObject3 = paramIntent.getStringExtra(am.q);
                          String str = paramIntent.getStringExtra(am.p);
                          localObject1 = localObject3;
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            localObject1 = (String)localList.get(0);
                          }
                          if (TextUtils.isEmpty(str))
                          {
                            localObject3 = ((ak)localObject4).c((String)localObject1);
                            localObject1 = localObject2;
                            if (localObject3 != null)
                            {
                              localObject1 = localObject2;
                              if (((Collection)localObject3).isEmpty()) {}
                            }
                          }
                          for (localObject1 = (ak.b)((Collection)localObject3).iterator().next();; localObject1 = ((ak)localObject4).b((String)localObject1, str))
                          {
                            if (localObject1 == null) {
                              break label933;
                            }
                            if (paramIntent.hasExtra(am.w)) {
                              ((ak.b)localObject1).f = paramIntent.getStringExtra(am.w);
                            }
                            if (!paramIntent.hasExtra(am.x)) {
                              break;
                            }
                            ((ak.b)localObject1).g = paramIntent.getStringExtra(am.x);
                            return;
                          }
                        }
                      }
                    }
                  }
                  if ("com.xiaomi.mipush.REGISTER_APP".equals(paramIntent.getAction()))
                  {
                    if ((ao.a(getApplicationContext()).a()) && (ao.a(getApplicationContext()).b() == 0))
                    {
                      com.xiaomi.channel.commonutils.logger.b.a("register without being provisioned. " + paramIntent.getStringExtra("mipush_app_package"));
                      return;
                    }
                    localObject1 = paramIntent.getByteArrayExtra("mipush_payload");
                    localObject2 = paramIntent.getStringExtra("mipush_app_package");
                    bool = paramIntent.getBooleanExtra("mipush_env_chanage", false);
                    n = paramIntent.getIntExtra("mipush_env_type", 1);
                    p.a(this).g((String)localObject2);
                    if ((bool) && (!"com.xiaomi.xmsf".equals(getPackageName())))
                    {
                      c(new bk(this, 14, n, (byte[])localObject1, (String)localObject2));
                      return;
                    }
                    a((byte[])localObject1, (String)localObject2);
                    return;
                  }
                  if (("com.xiaomi.mipush.SEND_MESSAGE".equals(paramIntent.getAction())) || ("com.xiaomi.mipush.UNREGISTER_APP".equals(paramIntent.getAction())))
                  {
                    localObject1 = paramIntent.getStringExtra("mipush_app_package");
                    localObject2 = paramIntent.getByteArrayExtra("mipush_payload");
                    bool = paramIntent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    if ("com.xiaomi.mipush.UNREGISTER_APP".equals(paramIntent.getAction())) {
                      p.a(this).d((String)localObject1);
                    }
                    a((String)localObject1, (byte[])localObject2, bool);
                    return;
                  }
                  if (!ap.a.equals(paramIntent.getAction())) {
                    break;
                  }
                  paramIntent = paramIntent.getStringExtra("uninstall_pkg_name");
                } while ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.trim())));
                try
                {
                  getPackageManager().getPackageInfo(paramIntent, 8192);
                  n = 0;
                }
                catch (PackageManager.NameNotFoundException localNameNotFoundException)
                {
                  for (;;) {}
                }
                if (("com.xiaomi.channel".equals(paramIntent)) && (!ak.a().c("1").isEmpty()) && (n != 0))
                {
                  a("1", 0);
                  com.xiaomi.channel.commonutils.logger.b.a("close the miliao channel as the app is uninstalled.");
                  return;
                }
                localObject2 = getSharedPreferences("pref_registered_pkg_names", 0);
                localObject1 = ((SharedPreferences)localObject2).getString(paramIntent, null);
              } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (n == 0));
              localObject2 = ((SharedPreferences)localObject2).edit();
              ((SharedPreferences.Editor)localObject2).remove(paramIntent);
              ((SharedPreferences.Editor)localObject2).commit();
              if (ac.e(this, paramIntent)) {
                ac.d(this, paramIntent);
              }
              ac.b(this, paramIntent);
            } while ((!f()) || (localObject1 == null));
            try
            {
              aa.a(this, aa.a(paramIntent, (String)localObject1));
              com.xiaomi.channel.commonutils.logger.b.a("uninstall " + paramIntent + " msg sent");
              return;
            }
            catch (l paramIntent)
            {
              com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + paramIntent.getMessage());
              a(10, paramIntent);
              return;
            }
            if (!"com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(paramIntent.getAction())) {
              break;
            }
            localObject1 = paramIntent.getStringExtra(am.y);
            n = paramIntent.getIntExtra(am.z, -2);
          } while (TextUtils.isEmpty((CharSequence)localObject1));
          if (n >= -1)
          {
            ac.a(this, (String)localObject1, n);
            return;
          }
          ac.a(this, (String)localObject1, paramIntent.getStringExtra(am.D), paramIntent.getStringExtra(am.E));
          return;
          if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(paramIntent.getAction()))
          {
            localObject1 = paramIntent.getStringExtra(am.y);
            localObject2 = paramIntent.getStringExtra(am.C);
            if (paramIntent.hasExtra(am.A))
            {
              n = paramIntent.getIntExtra(am.A, 0);
              paramIntent = com.xiaomi.channel.commonutils.string.c.b((String)localObject1 + n);
            }
            while ((TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.equals((CharSequence)localObject2, paramIntent)))
            {
              com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + (String)localObject1);
              return;
              paramIntent = com.xiaomi.channel.commonutils.string.c.b((String)localObject1);
              n = 0;
              i1 = 1;
            }
            if (i1 != 0)
            {
              ac.d(this, (String)localObject1);
              return;
            }
            ac.b(this, (String)localObject1, n);
            return;
          }
          if (!"com.xiaomi.mipush.DISABLE_PUSH".equals(paramIntent.getAction())) {
            break;
          }
          paramIntent = paramIntent.getStringExtra("mipush_app_package");
          if (!TextUtils.isEmpty(paramIntent)) {
            p.a(this).e(paramIntent);
          }
        } while ("com.xiaomi.xmsf".equals(getPackageName()));
        if (this.e != null)
        {
          unregisterReceiver(this.e);
          this.e = null;
        }
        this.l.c();
        a(new bl(this, 2));
        ak.a().e();
        ak.a().a(this, 0);
        ak.a().d();
        at.a().b();
        com.xiaomi.push.service.timers.a.a();
        return;
      } while ((!"com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(paramIntent.getAction())) && (!"com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(paramIntent.getAction())));
      localObject1 = paramIntent.getStringExtra("mipush_app_package");
      localObject2 = paramIntent.getByteArrayExtra("mipush_payload");
      Object localObject3 = paramIntent.getStringExtra("mipush_app_id");
      localObject4 = paramIntent.getStringExtra("mipush_app_token");
      if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(paramIntent.getAction())) {
        p.a(this).f((String)localObject1);
      }
      if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(paramIntent.getAction()))
      {
        p.a(this).h((String)localObject1);
        p.a(this).i((String)localObject1);
      }
      if (localObject2 == null)
      {
        r.a(this, (String)localObject1, (byte[])localObject2, 70000003, "null payload");
        return;
      }
      r.b((String)localObject1, (byte[])localObject2);
      a(new q(this, (String)localObject1, (String)localObject3, (String)localObject4, (byte[])localObject2));
    } while ((!"com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(paramIntent.getAction())) || (this.e != null));
    this.e = new e();
    paramIntent = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.e, paramIntent);
  }
  
  private void c(h paramh)
  {
    this.l.a(paramh);
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (j.d())
      {
        if (paramBoolean)
        {
          sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
          return;
        }
        sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        return;
      }
    }
    catch (Exception localException)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localException);
    }
  }
  
  private aw.b j()
  {
    return new bi(this);
  }
  
  private void k()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        com.xiaomi.channel.commonutils.logger.b.a("network changed, " + localNetworkInfo.toString());
        if (com.xiaomi.stats.f.b() != null) {
          com.xiaomi.stats.f.b().b();
        }
        this.h.p();
        if (!com.xiaomi.channel.commonutils.network.d.d(this)) {
          break label154;
        }
        if ((f()) && (l())) {
          b(false);
        }
        if ((!f()) && (!g()))
        {
          this.l.b(1);
          a(new d());
        }
        com.xiaomi.push.log.b.a(this).a();
        n();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a(localException);
        Object localObject = null;
        continue;
        com.xiaomi.channel.commonutils.logger.b.a("network changed, no active network");
        continue;
        label154:
        a(new f(2, null));
      }
    }
  }
  
  private boolean l()
  {
    if (System.currentTimeMillis() - this.f < 30000L) {
      return false;
    }
    return com.xiaomi.channel.commonutils.network.d.e(this);
  }
  
  private boolean m()
  {
    return ("com.xiaomi.xmsf".equals(getPackageName())) || (!p.a(this).b(getPackageName()));
  }
  
  private void n()
  {
    if (b())
    {
      if (!com.xiaomi.push.service.timers.a.b()) {
        com.xiaomi.push.service.timers.a.a(true);
      }
      return;
    }
    com.xiaomi.push.service.timers.a.a();
  }
  
  private void o()
  {
    if ((this.i != null) && (this.i.j())) {
      com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
    }
    do
    {
      return;
      if ((this.i != null) && (this.i.k()))
      {
        com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
        return;
      }
      this.c.a(com.xiaomi.channel.commonutils.network.d.k(this));
      p();
    } while (this.i != null);
    ak.a().a(this);
    c(false);
  }
  
  private void p()
  {
    try
    {
      this.h.a(this.m, new bb(this));
      this.h.r();
      this.i = this.h;
      return;
    }
    catch (l locall)
    {
      com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", locall);
      this.h.b(3, locall);
    }
  }
  
  private boolean q()
  {
    if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
      return false;
    }
    return ah.a(this).a(com.xiaomi.xmpush.thrift.e.H.a(), false);
  }
  
  private void r()
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      startForeground(g, new Notification());
      return;
    }
    bindService(new Intent(this, XMJobService.class), new bc(this), 1);
  }
  
  void a()
  {
    if (System.currentTimeMillis() - this.f < g.c()) {}
    while (!com.xiaomi.channel.commonutils.network.d.e(this)) {
      return;
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    this.l.b(paramInt);
  }
  
  public void a(int paramInt, Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("disconnect ").append(hashCode()).append(", ");
    if (this.i == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.i.hashCode()))
    {
      com.xiaomi.channel.commonutils.logger.b.a(localObject);
      if (this.i != null)
      {
        this.i.b(paramInt, paramException);
        this.i = null;
      }
      a(7);
      a(4);
      ak.a().a(this, paramInt);
      return;
    }
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.xiaomi.metok.geofencing.state_change");
    registerReceiver(paramBroadcastReceiver, localIntentFilter);
  }
  
  public void a(h paramh)
  {
    a(paramh, 0L);
  }
  
  public void a(h paramh, long paramLong)
  {
    try
    {
      this.l.a(paramh, paramLong);
      return;
    }
    catch (IllegalStateException paramh) {}
  }
  
  public void a(ak.b paramb)
  {
    if (paramb != null)
    {
      long l1 = paramb.a();
      com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + l1 / 1000L);
      a(new a(paramb), l1);
    }
  }
  
  public void a(com.xiaomi.slim.b paramb)
  {
    if (this.i != null)
    {
      this.i.b(paramb);
      return;
    }
    throw new l("try send msg while connection is null.");
  }
  
  public void a(com.xiaomi.smack.a parama)
  {
    com.xiaomi.stats.f.b().a(parama);
    c(true);
    this.d.a();
    parama = ak.a().b().iterator();
    while (parama.hasNext()) {
      a(new a((ak.b)parama.next()));
    }
  }
  
  public void a(com.xiaomi.smack.a parama, int paramInt, Exception paramException)
  {
    com.xiaomi.stats.f.b().a(parama, paramInt, paramException);
    a(false);
  }
  
  public void a(com.xiaomi.smack.a parama, Exception paramException)
  {
    com.xiaomi.stats.f.b().a(parama, paramException);
    c(false);
    a(false);
  }
  
  public void a(com.xiaomi.smack.packet.d paramd)
  {
    if (this.i != null)
    {
      this.i.a(paramd);
      return;
    }
    throw new l("try send msg while connection is null.");
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ak.b localb = ak.a().b(paramString1, paramString2);
    if (localb != null) {
      a(new o(localb, paramInt, paramString4, paramString3));
    }
    ak.a().a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null)
    {
      r.a(this, paramString, paramArrayOfByte, 70000003, "null payload");
      com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
      return;
    }
    ab localab = new ab();
    try
    {
      com.xiaomi.xmpush.thrift.aq.a(localab, paramArrayOfByte);
      if (localab.a == com.xiaomi.xmpush.thrift.a.a)
      {
        af localaf = new af();
        try
        {
          com.xiaomi.xmpush.thrift.aq.a(localaf, localab.f());
          r.a(localab.j(), paramArrayOfByte);
          a(new q(this, localab.j(), localaf.d(), localaf.h(), paramArrayOfByte));
          return;
        }
        catch (org.apache.thrift.f localf1)
        {
          com.xiaomi.channel.commonutils.logger.b.a(localf1);
          r.a(this, paramString, paramArrayOfByte, 70000003, " data action error.");
          return;
        }
      }
      r.a(this, paramString, paramArrayOfByte, 70000003, " registration action required.");
    }
    catch (org.apache.thrift.f localf2)
    {
      com.xiaomi.channel.commonutils.logger.b.a(localf2);
      r.a(this, paramString, paramArrayOfByte, 70000003, " data container error.");
      return;
    }
    com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
  }
  
  public void a(com.xiaomi.slim.b[] paramArrayOfb)
  {
    if (this.i != null)
    {
      this.i.a(paramArrayOfb);
      return;
    }
    throw new l("try send msg while connection is null.");
  }
  
  public void a(com.xiaomi.smack.packet.d[] paramArrayOfd)
  {
    if (this.i != null)
    {
      this.i.a(paramArrayOfd);
      return;
    }
    throw new l("try send msg while connection is null.");
  }
  
  public void b(h paramh)
  {
    this.l.a(paramh.a, paramh);
  }
  
  public void b(com.xiaomi.smack.a parama)
  {
    com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
    com.xiaomi.stats.f.b().b(parama);
  }
  
  public boolean b()
  {
    return (com.xiaomi.channel.commonutils.network.d.d(this)) && (ak.a().c() > 0) && (!c()) && (m());
  }
  
  public boolean b(int paramInt)
  {
    return this.l.a(paramInt);
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    try
    {
      Object localObject = Class.forName("miui.os.Build");
      Field localField1 = ((Class)localObject).getField("IS_CM_CUSTOMIZATION_TEST");
      Field localField2 = ((Class)localObject).getField("IS_CU_CUSTOMIZATION_TEST");
      localObject = ((Class)localObject).getField("IS_CT_CUSTOMIZATION_TEST");
      if ((!localField1.getBoolean(null)) && (!localField2.getBoolean(null)))
      {
        boolean bool2 = ((Field)localObject).getBoolean(null);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public b d()
  {
    return new b();
  }
  
  public b e()
  {
    return this.j;
  }
  
  public boolean f()
  {
    return (this.i != null) && (this.i.k());
  }
  
  public boolean g()
  {
    return (this.i != null) && (this.i.j());
  }
  
  public com.xiaomi.smack.a h()
  {
    return this.i;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new j();
  }
  
  public void onCreate()
  {
    super.onCreate();
    j.a(this);
    Object localObject = o.a(this);
    if (localObject != null) {
      com.xiaomi.channel.commonutils.misc.a.a(((n)localObject).g);
    }
    an.a(this);
    this.c = new bd(this, null, 5222, "xiaomi.com", null);
    this.c.a(true);
    this.h = new com.xiaomi.slim.f(this, this.c);
    this.j = d();
    try
    {
      if (j.d()) {
        this.j.a(this);
      }
      com.xiaomi.push.service.timers.a.a(this);
      this.h.a(this);
      this.k = new PacketSync(this);
      this.d = new ar(this);
      new c().a();
      com.xiaomi.stats.f.a().a(this);
      this.l = new i("Connection Controller Thread");
      if (m()) {
        a(new be(this, 11));
      }
      localObject = ak.a();
      ((ak)localObject).e();
      ((ak)localObject).a(new bf(this));
      if (m())
      {
        this.e = new e();
        localObject = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.e, (IntentFilter)localObject);
      }
      if (q()) {
        r();
      }
      if (!getPackageName().equals(com.xiaomi.channel.commonutils.android.b.c(this)))
      {
        localObject = aw.a();
        if (((aw)localObject).b()) {
          ((aw)localObject).a(this);
        }
        ((aw)localObject).a(j(), "UPLOADER_FROM_XMPUSHSERVICE");
      }
      a(this.a);
      com.xiaomi.channel.commonutils.misc.f.a(this).a(new d(this), 86400);
      com.xiaomi.channel.commonutils.logger.b.a("XMPushService created pid = " + g);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a(localException);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.e != null) {
      unregisterReceiver(this.e);
    }
    unregisterReceiver(this.a);
    this.l.c();
    a(new ba(this, 2));
    a(new i());
    ak.a().e();
    ak.a().a(this, 15);
    ak.a().d();
    this.h.b(this);
    at.a().b();
    com.xiaomi.push.service.timers.a.a();
    super.onDestroy();
    com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null)
    {
      com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
      if ((paramIntent != null) && (paramIntent.getAction() != null))
      {
        if (!"com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction())) {
          break label86;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Service called on timer");
        if (l()) {
          b(false);
        }
      }
    }
    label86:
    label118:
    do
    {
      do
      {
        return;
        com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s", new Object[] { paramIntent.getAction(), paramIntent.getStringExtra(am.q) }));
        break;
        if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(paramIntent.getAction())) {
          break label118;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Service called on check alive.");
      } while (!l());
      b(false);
      return;
    } while ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(paramIntent.getAction()));
    a(new g(paramIntent));
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return b;
  }
  
  class a
    extends XMPushService.h
  {
    ak.b b = null;
    
    public a(ak.b paramb)
    {
      super();
      this.b = paramb;
    }
    
    public void a()
    {
      try
      {
        if (!XMPushService.this.f())
        {
          com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
          return;
        }
        ak.b localb = ak.a().b(this.b.h, this.b.b);
        if (localb == null)
        {
          com.xiaomi.channel.commonutils.logger.b.a("ignore bind because the channel " + this.b.h + " is removed ");
          return;
        }
      }
      catch (l locall)
      {
        com.xiaomi.channel.commonutils.logger.b.a(locall);
        XMPushService.this.a(10, locall);
        return;
      }
      if (locall.m == ak.c.a)
      {
        locall.a(ak.c.b, 0, 0, null, null);
        XMPushService.c(XMPushService.this).a(locall);
        h.a(XMPushService.this, locall);
        return;
      }
      com.xiaomi.channel.commonutils.logger.b.a("trying duplicate bind, ingore! " + locall.m);
    }
    
    public String b()
    {
      return "bind the client. " + this.b.h;
    }
  }
  
  static class b
    extends XMPushService.h
  {
    private final ak.b b;
    
    public b(ak.b paramb)
    {
      super();
      this.b = paramb;
    }
    
    public void a()
    {
      this.b.a(ak.c.a, 1, 21, null, null);
    }
    
    public String b()
    {
      return "bind time out. chid=" + this.b.h;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b)) {
        return false;
      }
      return TextUtils.equals(((b)paramObject).b.h, this.b.h);
    }
    
    public int hashCode()
    {
      return this.b.h.hashCode();
    }
  }
  
  class c
    extends XMPushService.h
  {
    private com.xiaomi.slim.b c = null;
    
    public c(com.xiaomi.slim.b paramb)
    {
      super();
      this.c = paramb;
    }
    
    public void a()
    {
      XMPushService.e(XMPushService.this).a(this.c);
    }
    
    public String b()
    {
      return "receive a message.";
    }
  }
  
  public class d
    extends XMPushService.h
  {
    d()
    {
      super();
    }
    
    public void a()
    {
      if (XMPushService.this.b())
      {
        XMPushService.f(XMPushService.this);
        return;
      }
      com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
    }
    
    public String b()
    {
      return "do reconnect..";
    }
  }
  
  class e
    extends BroadcastReceiver
  {
    e() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      XMPushService.g(XMPushService.this);
    }
  }
  
  public class f
    extends XMPushService.h
  {
    public int b;
    public Exception c;
    
    f(int paramInt, Exception paramException)
    {
      super();
      this.b = paramInt;
      this.c = paramException;
    }
    
    public void a()
    {
      XMPushService.this.a(this.b, this.c);
    }
    
    public String b()
    {
      return "disconnect the connection.";
    }
  }
  
  class g
    extends XMPushService.h
  {
    private Intent c = null;
    
    public g(Intent paramIntent)
    {
      super();
      this.c = paramIntent;
    }
    
    public void a()
    {
      XMPushService.a(XMPushService.this, this.c);
    }
    
    public String b()
    {
      return "Handle intent action = " + this.c.getAction();
    }
  }
  
  public static abstract class h
    extends i.b
  {
    public h(int paramInt)
    {
      super();
    }
    
    public abstract void a();
    
    public abstract String b();
    
    public void run()
    {
      if ((this.a != 4) && (this.a != 8)) {
        com.xiaomi.channel.commonutils.logger.b.a("JOB: " + b());
      }
      a();
    }
  }
  
  class i
    extends XMPushService.h
  {
    public i()
    {
      super();
    }
    
    public void a()
    {
      XMPushService.d(XMPushService.this).b();
    }
    
    public String b()
    {
      return "ask the job queue to quit";
    }
  }
  
  public class j
    extends Binder
  {
    public j() {}
  }
  
  class k
    extends XMPushService.h
  {
    private com.xiaomi.smack.packet.d c = null;
    
    public k(com.xiaomi.smack.packet.d paramd)
    {
      super();
      this.c = paramd;
    }
    
    public void a()
    {
      XMPushService.e(XMPushService.this).a(this.c);
    }
    
    public String b()
    {
      return "receive a message.";
    }
  }
  
  class l
    extends XMPushService.h
  {
    boolean b;
    
    public l(boolean paramBoolean)
    {
      super();
      this.b = paramBoolean;
    }
    
    public void a()
    {
      if (XMPushService.this.f()) {}
      try
      {
        if (!this.b) {
          h.a();
        }
        XMPushService.c(XMPushService.this).b(this.b);
        return;
      }
      catch (l locall)
      {
        com.xiaomi.channel.commonutils.logger.b.a(locall);
        XMPushService.this.a(10, locall);
      }
    }
    
    public String b()
    {
      return "send ping..";
    }
  }
  
  class m
    extends XMPushService.h
  {
    ak.b b = null;
    
    public m(ak.b paramb)
    {
      super();
      this.b = paramb;
    }
    
    public void a()
    {
      try
      {
        this.b.a(ak.c.a, 1, 16, null, null);
        XMPushService.c(XMPushService.this).a(this.b.h, this.b.b);
        this.b.a(ak.c.b, 1, 16, null, null);
        XMPushService.c(XMPushService.this).a(this.b);
        return;
      }
      catch (l locall)
      {
        com.xiaomi.channel.commonutils.logger.b.a(locall);
        XMPushService.this.a(10, locall);
      }
    }
    
    public String b()
    {
      return "rebind the client. " + this.b.h;
    }
  }
  
  class n
    extends XMPushService.h
  {
    n()
    {
      super();
    }
    
    public void a()
    {
      XMPushService.this.a(11, null);
      if (XMPushService.this.b()) {
        XMPushService.f(XMPushService.this);
      }
    }
    
    public String b()
    {
      return "reset the connection.";
    }
  }
  
  class o
    extends XMPushService.h
  {
    ak.b b = null;
    int c;
    String d;
    String e;
    
    public o(ak.b paramb, int paramInt, String paramString1, String paramString2)
    {
      super();
      this.b = paramb;
      this.c = paramInt;
      this.d = paramString1;
      this.e = paramString2;
    }
    
    public void a()
    {
      if ((this.b.m != ak.c.a) && (XMPushService.c(XMPushService.this) != null)) {}
      try
      {
        XMPushService.c(XMPushService.this).a(this.b.h, this.b.b);
        this.b.a(ak.c.a, this.c, 0, this.e, this.d);
        return;
      }
      catch (l locall)
      {
        for (;;)
        {
          com.xiaomi.channel.commonutils.logger.b.a(locall);
          XMPushService.this.a(10, locall);
        }
      }
    }
    
    public String b()
    {
      return "unbind the channel. " + this.b.h;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/XMPushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */