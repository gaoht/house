package com.xiaomi.push.service;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class s
{
  public static Intent a(byte[] paramArrayOfByte, long paramLong)
  {
    ab localab = a(paramArrayOfByte);
    if (localab == null) {
      return null;
    }
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.putExtra("mipush_payload", paramArrayOfByte);
    localIntent.putExtra("mrt", Long.toString(paramLong));
    localIntent.setPackage(localab.f);
    return localIntent;
  }
  
  public static ab a(Context paramContext, ab paramab)
  {
    return a(paramContext, paramab, false, false, false);
  }
  
  public static ab a(Context paramContext, ab paramab, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.xiaomi.xmpush.thrift.w localw = new com.xiaomi.xmpush.thrift.w();
    localw.b(paramab.h());
    r localr = paramab.m();
    if (localr != null)
    {
      localw.a(localr.b());
      localw.a(localr.d());
      if (!TextUtils.isEmpty(localr.f())) {
        localw.c(localr.f());
      }
    }
    localw.a(com.xiaomi.xmpush.thrift.aq.a(paramContext, paramab));
    localw.b(com.xiaomi.xmpush.thrift.aq.a(paramBoolean1, paramBoolean2, paramBoolean3));
    paramContext = aa.a(paramab.j(), paramab.h(), localw, com.xiaomi.xmpush.thrift.a.f);
    paramab = paramab.m().a();
    paramab.a("mat", Long.toString(System.currentTimeMillis()));
    paramContext.a(paramab);
    return paramContext;
  }
  
  public static ab a(byte[] paramArrayOfByte)
  {
    ab localab = new ab();
    try
    {
      com.xiaomi.xmpush.thrift.aq.a(localab, paramArrayOfByte);
      return localab;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramArrayOfByte);
    }
    return null;
  }
  
  private static void a(XMPushService paramXMPushService, ab paramab)
  {
    paramXMPushService.a(new t(4, paramXMPushService, paramab));
  }
  
  private static void a(XMPushService paramXMPushService, ab paramab, String paramString)
  {
    paramXMPushService.a(new x(4, paramXMPushService, paramab, paramString));
  }
  
  private static void a(XMPushService paramXMPushService, ab paramab, String paramString1, String paramString2)
  {
    paramXMPushService.a(new y(4, paramXMPushService, paramab, paramString1, paramString2));
  }
  
  public static void a(XMPushService paramXMPushService, ab paramab, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramXMPushService.a(new z(4, paramXMPushService, paramab, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  public static void a(XMPushService paramXMPushService, String paramString, byte[] paramArrayOfByte, Intent paramIntent, boolean paramBoolean)
  {
    ab localab = a(paramArrayOfByte);
    r localr = localab.m();
    if ((c(localab)) && (a(paramXMPushService, paramString))) {
      d(paramXMPushService, localab);
    }
    for (;;)
    {
      return;
      if ((a(localab)) && (!a(paramXMPushService, paramString)) && (!b(localab)))
      {
        e(paramXMPushService, localab);
        return;
      }
      if (((!ac.b(localab)) || (!com.xiaomi.channel.commonutils.android.b.f(paramXMPushService, localab.f))) && (!a(paramXMPushService, paramIntent))) {
        break;
      }
      if (com.xiaomi.xmpush.thrift.a.a == localab.a())
      {
        paramString = localab.j();
        SharedPreferences.Editor localEditor = paramXMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
        localEditor.putString(paramString, localab.e);
        localEditor.commit();
        aw.a().b("Registe Success, package name is " + paramString);
      }
      if ((localr == null) || (TextUtils.isEmpty(localr.h())) || (TextUtils.isEmpty(localr.j())) || (localr.h == 1) || ((!ac.a(localr.s())) && (ac.a(paramXMPushService, localab.f)))) {
        if (("com.xiaomi.xmsf".contains(localab.f)) && (!localab.c()) && (localr != null) && (localr.s() != null) && (localr.s().containsKey("ab")))
        {
          c(paramXMPushService, localab);
          com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + localr.b());
        }
      }
      while ((localab.a() == com.xiaomi.xmpush.thrift.a.b) && (!"com.xiaomi.xmsf".equals(paramXMPushService.getPackageName())))
      {
        paramXMPushService.stopSelf();
        return;
        paramXMPushService.sendBroadcast(paramIntent, b.a(localab.f));
        continue;
        boolean bool = false;
        paramIntent = null;
        paramString = null;
        if (localr != null)
        {
          if (localr.j != null) {
            paramString = (String)localr.j.get("jobkey");
          }
          paramIntent = paramString;
          if (TextUtils.isEmpty(paramString)) {
            paramIntent = localr.b();
          }
          bool = ad.a(paramXMPushService, localab.f, paramIntent);
        }
        if (bool) {
          com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + paramIntent);
        }
        for (;;)
        {
          if (!paramBoolean) {
            break label606;
          }
          a(paramXMPushService, localab, false, true, false);
          break;
          paramString = ac.a(paramXMPushService, localab, paramArrayOfByte);
          if ((paramString.b > 0L) && (!TextUtils.isEmpty(paramString.a))) {
            com.xiaomi.smack.util.g.a(paramXMPushService, paramString.a, paramString.b, true, System.currentTimeMillis());
          }
          if (!ac.b(localab))
          {
            paramString = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            paramString.putExtra("mipush_payload", paramArrayOfByte);
            paramString.setPackage(localab.f);
            try
            {
              paramArrayOfByte = paramXMPushService.getPackageManager().queryBroadcastReceivers(paramString, 0);
              if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty())) {
                paramXMPushService.sendBroadcast(paramString, b.a(localab.f));
              }
            }
            catch (Exception paramArrayOfByte)
            {
              paramXMPushService.sendBroadcast(paramString, b.a(localab.f));
            }
          }
        }
        label606:
        c(paramXMPushService, localab);
      }
    }
    if (!com.xiaomi.channel.commonutils.android.b.f(paramXMPushService, localab.f))
    {
      a(paramXMPushService, localab);
      return;
    }
    com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message, we can see the app, but we can't see the receiver.");
  }
  
  private static void a(XMPushService paramXMPushService, byte[] paramArrayOfByte, long paramLong)
  {
    ab localab = a(paramArrayOfByte);
    if (localab == null) {
      return;
    }
    if (TextUtils.isEmpty(localab.f))
    {
      com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message without package name");
      return;
    }
    Object localObject = Long.valueOf(System.currentTimeMillis());
    Intent localIntent = a(paramArrayOfByte, ((Long)localObject).longValue());
    String str = ac.a(localab);
    com.xiaomi.smack.util.g.a(paramXMPushService, str, paramLong, true, System.currentTimeMillis());
    r localr = localab.m();
    if (localr != null) {
      localr.a("mrt", Long.toString(((Long)localObject).longValue()));
    }
    if ((com.xiaomi.xmpush.thrift.a.e == localab.a()) && (p.a(paramXMPushService).a(localab.f)) && (!ac.b(localab)))
    {
      paramArrayOfByte = "";
      if (localr != null) {
        paramArrayOfByte = localr.b();
      }
      com.xiaomi.channel.commonutils.logger.b.a("Drop a message for unregistered, msgid=" + paramArrayOfByte);
      a(paramXMPushService, localab, localab.f);
      return;
    }
    if ((com.xiaomi.xmpush.thrift.a.e == localab.a()) && (p.a(paramXMPushService).c(localab.f)) && (!ac.b(localab)))
    {
      paramArrayOfByte = "";
      if (localr != null) {
        paramArrayOfByte = localr.b();
      }
      com.xiaomi.channel.commonutils.logger.b.a("Drop a message for push closed, msgid=" + paramArrayOfByte);
      a(paramXMPushService, localab, localab.f);
      return;
    }
    if ((com.xiaomi.xmpush.thrift.a.e == localab.a()) && (!TextUtils.equals(paramXMPushService.getPackageName(), "com.xiaomi.xmsf")) && (!TextUtils.equals(paramXMPushService.getPackageName(), localab.f)))
    {
      com.xiaomi.channel.commonutils.logger.b.a("Receive a message with wrong package name, expect " + paramXMPushService.getPackageName() + ", received " + localab.f);
      a(paramXMPushService, localab, "unmatched_package", "package should be " + paramXMPushService.getPackageName() + ", but got " + localab.f);
      return;
    }
    if ((localr != null) && (localr.b() != null)) {
      com.xiaomi.channel.commonutils.logger.b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", new Object[] { localab.h(), localr.b() }));
    }
    if (localr != null)
    {
      localObject = localr.s();
      if ((localObject != null) && (((Map)localObject).containsKey("hide")) && ("true".equalsIgnoreCase((String)((Map)localObject).get("hide"))))
      {
        c(paramXMPushService, localab);
        return;
      }
    }
    if ((localr != null) && (localr.s() != null) && (localr.s().containsKey("__miid")))
    {
      localObject = (String)localr.s().get("__miid");
      Account localAccount = f.a(paramXMPushService);
      int i;
      int j;
      if (localAccount == null)
      {
        i = 1;
        if (TextUtils.equals((CharSequence)localObject, localAccount.name)) {
          break label661;
        }
        j = 1;
        label566:
        if ((i | j) == 0) {
          break label685;
        }
        if ((String)localObject + " should be login, but got " + localAccount != null) {
          break label667;
        }
        paramArrayOfByte = "nothing";
        label607:
        com.xiaomi.channel.commonutils.logger.b.a(paramArrayOfByte);
        if ((String)localObject + " should be login, but got " + localAccount != null) {
          break label676;
        }
      }
      label661:
      label667:
      label676:
      for (paramArrayOfByte = "nothing";; paramArrayOfByte = localAccount.name)
      {
        a(paramXMPushService, localab, "miid already logout or anther already login", paramArrayOfByte);
        return;
        i = 0;
        break;
        j = 0;
        break label566;
        paramArrayOfByte = localAccount.name;
        break label607;
      }
    }
    label685:
    if ((localr != null) && (a(localr.s()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        if (!b(paramXMPushService, localab)) {
          break;
        }
        boolean bool2 = a(paramXMPushService, localr, paramArrayOfByte);
        a(paramXMPushService, localab, true, false, false);
        if (!bool2) {
          break;
        }
      }
      a(paramXMPushService, str, paramArrayOfByte, localIntent, bool1);
      return;
    }
  }
  
  private static boolean a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.queryBroadcastReceivers(paramIntent, 32);
      if (paramContext != null)
      {
        boolean bool = paramContext.isEmpty();
        if (!bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    Intent localIntent1 = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
    localIntent1.setPackage(paramString);
    Intent localIntent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
    localIntent2.setPackage(paramString);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.queryBroadcastReceivers(localIntent2, 32);
      paramContext = paramContext.queryIntentServices(localIntent1, 32);
      if (paramString.isEmpty())
      {
        boolean bool2 = paramContext.isEmpty();
        if (bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
    }
    return false;
  }
  
  private static boolean a(XMPushService paramXMPushService, r paramr, byte[] paramArrayOfByte)
  {
    Map localMap = paramr.s();
    String[] arrayOfString = ((String)localMap.get("__geo_ids")).split(",");
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("geo_id", str);
      localContentValues.put("message_id", paramr.b());
      int k = Integer.parseInt((String)localMap.get("__geo_action"));
      localContentValues.put("action", Integer.valueOf(k));
      localContentValues.put("content", paramArrayOfByte);
      localContentValues.put("deadline", Long.valueOf(Long.parseLong((String)localMap.get("__geo_deadline"))));
      if ((TextUtils.equals(e.a(paramXMPushService).c(str), "Enter")) && (k == 1)) {
        return true;
      }
      localArrayList.add(localContentValues);
      i += 1;
    }
    if (!g.a(paramXMPushService).a(localArrayList)) {
      com.xiaomi.channel.commonutils.logger.b.c("geofence added some new geofence message failed messagi_id:" + paramr.b());
    }
    return false;
  }
  
  private static boolean a(ab paramab)
  {
    return ("com.xiaomi.xmsf".equals(paramab.f)) && (paramab.m() != null) && (paramab.m().s() != null) && (paramab.m().s().containsKey("miui_package_name"));
  }
  
  private static boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    while (!paramMap.containsKey("__geo_ids")) {
      return false;
    }
    return true;
  }
  
  private static boolean b(XMPushService paramXMPushService, ab paramab)
  {
    if (!h.a(paramXMPushService)) {
      return false;
    }
    if (!h.b(paramXMPushService)) {
      return false;
    }
    if (!com.xiaomi.channel.commonutils.android.b.f(paramXMPushService, paramab.f))
    {
      a(paramXMPushService, paramab);
      return false;
    }
    paramXMPushService = paramab.m().s();
    if (paramXMPushService == null) {
      return false;
    }
    if (!"12".contains((CharSequence)paramXMPushService.get("__geo_action"))) {
      return false;
    }
    return !TextUtils.isEmpty((CharSequence)paramXMPushService.get("__geo_ids"));
  }
  
  private static boolean b(ab paramab)
  {
    paramab = paramab.m().s();
    return (paramab != null) && (paramab.containsKey("notify_effect"));
  }
  
  private static void c(XMPushService paramXMPushService, ab paramab)
  {
    paramXMPushService.a(new u(4, paramXMPushService, paramab));
  }
  
  private static boolean c(ab paramab)
  {
    if ((paramab.m() == null) || (paramab.m().s() == null)) {
      return false;
    }
    return "1".equals(paramab.m().s().get("obslete_ads_message"));
  }
  
  private static void d(XMPushService paramXMPushService, ab paramab)
  {
    paramXMPushService.a(new v(4, paramXMPushService, paramab));
  }
  
  private static void e(XMPushService paramXMPushService, ab paramab)
  {
    paramXMPushService.a(new w(4, paramXMPushService, paramab));
  }
  
  public void a(Context paramContext, ak.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      paramb = o.a(paramContext);
      if ((paramb == null) || (!"token-expired".equals(paramString))) {}
    }
    try
    {
      o.a(paramContext, paramb.d, paramb.e, paramb.f);
      return;
    }
    catch (IOException paramContext)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
      return;
    }
    catch (JSONException paramContext)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
    }
  }
  
  public void a(XMPushService paramXMPushService, com.xiaomi.slim.b paramb, ak.b paramb1)
  {
    try
    {
      a(paramXMPushService, paramb.d(paramb1.i), paramb.l());
      return;
    }
    catch (IllegalArgumentException paramXMPushService)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramXMPushService);
    }
  }
  
  public void a(XMPushService paramXMPushService, d paramd, ak.b paramb)
  {
    if ((paramd instanceof c))
    {
      c localc = (c)paramd;
      com.xiaomi.smack.packet.a locala = localc.p("s");
      if (locala != null) {}
      try
      {
        a(paramXMPushService, aq.b(aq.a(paramb.i, localc.k()), locala.c()), com.xiaomi.smack.util.g.a(paramd.c()));
        return;
      }
      catch (IllegalArgumentException paramXMPushService)
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramXMPushService);
        return;
      }
    }
    com.xiaomi.channel.commonutils.logger.b.a("not a mipush message");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */