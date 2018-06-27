package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.ak;
import com.xiaomi.xmpush.thrift.am;
import com.xiaomi.xmpush.thrift.ao;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public abstract class MiPushClient
{
  private static z mSyncMIIDHelper;
  private static Context sContext;
  private static long sCurMsgId = ;
  
  private static boolean acceptTimeSet(Context paramContext, String paramString1, String paramString2)
  {
    return TextUtils.equals(getAcceptTime(paramContext), paramString1 + "," + paramString2);
  }
  
  public static long accountSetTime(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("account_" + paramString, -1L);
  }
  
  static void addAcceptTime(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putString("accept_time", paramString1 + "," + paramString2).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void addAccount(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + paramString, System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void addAlias(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + paramString, System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void addPullNotificationTime(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
  }
  
  private static void addRegRequestTime(Context paramContext)
  {
    paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("last_reg_request", System.currentTimeMillis()).commit();
  }
  
  static void addTopic(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + paramString, System.currentTimeMillis()).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static long aliasSetTime(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("alias_" + paramString, -1L);
  }
  
  public static void awakeApps(Context paramContext, String[] paramArrayOfString)
  {
    new Thread(new n(paramArrayOfString, paramContext)).start();
  }
  
  private static void awakePushServiceByPackageInfo(Context paramContext, PackageInfo paramPackageInfo)
  {
    Object localObject = paramPackageInfo.services;
    int j;
    int i;
    if (localObject != null)
    {
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        paramPackageInfo = localObject[i];
        if ((!paramPackageInfo.exported) || (!paramPackageInfo.enabled) || (!"com.xiaomi.mipush.sdk.PushMessageHandler".equals(paramPackageInfo.name)) || (paramContext.getPackageName().equals(paramPackageInfo.packageName))) {
          break label135;
        }
      }
      label135:
      try
      {
        Thread.sleep((Math.random() * 2.0D + 1.0D) * 1000L);
        localObject = new Intent();
        ((Intent)localObject).setClassName(paramPackageInfo.packageName, paramPackageInfo.name);
        ((Intent)localObject).setAction("com.xiaomi.mipush.sdk.WAKEUP");
        ((Intent)localObject).putExtra("waker_pkgname", paramContext.getPackageName());
        paramContext.startService((Intent)localObject);
        return;
      }
      catch (Throwable paramContext) {}
      i += 1;
    }
  }
  
  private static void checkNotNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("param " + paramString + " is not nullable");
    }
  }
  
  protected static void clearExtras(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).edit();
    paramContext.clear();
    paramContext.commit();
  }
  
  public static void clearLocalNotificationType(Context paramContext)
  {
    u.a(paramContext).f();
  }
  
  public static void clearNotification(Context paramContext)
  {
    u.a(paramContext).a(-1);
  }
  
  public static void clearNotification(Context paramContext, int paramInt)
  {
    u.a(paramContext).a(paramInt);
  }
  
  public static void clearNotification(Context paramContext, String paramString1, String paramString2)
  {
    u.a(paramContext).a(paramString1, paramString2);
  }
  
  public static void disablePush(Context paramContext)
  {
    u.a(paramContext).a(true);
  }
  
  public static void enablePush(Context paramContext)
  {
    u.a(paramContext).a(false);
  }
  
  protected static String generatePacketID()
  {
    try
    {
      String str = com.xiaomi.channel.commonutils.string.d.a(4) + sCurMsgId;
      sCurMsgId += 1L;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected static String getAcceptTime(Context paramContext)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
  }
  
  public static List<String> getAllAlias(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (str.startsWith("alias_")) {
        localArrayList.add(str.substring("alias_".length()));
      }
    }
    return localArrayList;
  }
  
  public static List<String> getAllTopic(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if ((str.startsWith("topic_")) && (!str.contains("**ALL**"))) {
        localArrayList.add(str.substring("topic_".length()));
      }
    }
    return localArrayList;
  }
  
  public static List<String> getAllUserAccount(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      if (str.startsWith("account_")) {
        localArrayList.add(str.substring("account_".length()));
      }
    }
    return localArrayList;
  }
  
  private static boolean getDefaultSwitch()
  {
    return g.b();
  }
  
  public static String getRegId(Context paramContext)
  {
    if (a.a(paramContext).i()) {
      return a.a(paramContext).e();
    }
    return null;
  }
  
  @Deprecated
  public static void initialize(Context paramContext, String paramString1, String paramString2, MiPushClientCallback paramMiPushClientCallback)
  {
    boolean bool = false;
    checkNotNull(paramContext, "context");
    checkNotNull(paramString1, "appID");
    checkNotNull(paramString2, "appToken");
    for (;;)
    {
      try
      {
        if (aw.a().b()) {
          aw.a().a(paramContext);
        }
        aw.a().a(new ab(paramContext), "UPLOADER_FROM_MIPUSHCLIENT");
        sContext = paramContext.getApplicationContext();
        if (sContext == null) {
          sContext = paramContext;
        }
        if (paramMiPushClientCallback != null) {
          PushMessageHandler.a(paramMiPushClientCallback);
        }
        if (j.b(paramContext)) {
          h.a(paramContext);
        }
        if (a.a(sContext).m() != Constants.a()) {
          bool = true;
        }
        if ((!bool) && (!shouldSendRegRequest(sContext)))
        {
          u.a(paramContext).a();
          com.xiaomi.channel.commonutils.logger.b.a("Could not send  register message within 5s repeatly .");
          return;
        }
        if ((!bool) && (a.a(sContext).a(paramString1, paramString2)) && (!a.a(sContext).n())) {
          if (1 == PushMessageHelper.getPushMode(paramContext))
          {
            checkNotNull(paramMiPushClientCallback, "callback");
            paramMiPushClientCallback.onInitializeResult(0L, null, a.a(paramContext).e());
            u.a(paramContext).a();
            if (a.a(sContext).a())
            {
              paramString1 = new ae();
              paramString1.b(a.a(paramContext).c());
              paramString1.c("client_info_update");
              paramString1.a(generatePacketID());
              paramString1.h = new HashMap();
              paramString1.h.put("app_version", com.xiaomi.channel.commonutils.android.b.a(sContext, sContext.getPackageName()));
              paramString1.h.put("app_version_code", Integer.toString(com.xiaomi.channel.commonutils.android.b.b(sContext, sContext.getPackageName())));
              paramString1.h.put("push_sdk_vn", "3_2_3");
              paramString1.h.put("push_sdk_vc", Integer.toString(30203));
              paramString2 = a.a(sContext).g();
              if (!TextUtils.isEmpty(paramString2)) {
                paramString1.h.put("deviceid", paramString2);
              }
              u.a(paramContext).a(paramString1, com.xiaomi.xmpush.thrift.a.i, false, null);
            }
            if (!com.xiaomi.channel.commonutils.android.h.a(sContext, "update_devId", false))
            {
              updateIMEI();
              com.xiaomi.channel.commonutils.android.h.b(sContext, "update_devId", true);
            }
            if ((shouldUseMIUIPush(sContext)) && (shouldPullNotification(sContext)))
            {
              paramContext = new ae();
              paramContext.b(a.a(sContext).c());
              paramContext.c("pull");
              paramContext.a(generatePacketID());
              paramContext.a(false);
              u.a(sContext).a(paramContext, com.xiaomi.xmpush.thrift.a.i, false, null, false);
              addPullNotificationTime(sContext);
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleGeoFenceRepeatJobs();
            loadPlugin();
            x.a(sContext);
          }
        }
      }
      catch (Throwable paramContext)
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramContext);
        return;
      }
      try
      {
        if (mSyncMIIDHelper == null) {
          mSyncMIIDHelper = new z(sContext);
        }
        mSyncMIIDHelper.a(sContext);
      }
      catch (Exception paramContext)
      {
        String str;
        int i;
        com.xiaomi.channel.commonutils.logger.b.d(paramContext.toString());
        continue;
      }
      if ("disable_syncing".equals(p.a(sContext).a())) {
        disablePush(sContext);
      }
      if (!"enable_syncing".equals(p.a(sContext).a())) {
        return;
      }
      enablePush(sContext);
      return;
      paramString1 = new ArrayList();
      paramString1.add(a.a(paramContext).e());
      paramString1 = PushMessageHelper.generateCommandMessage("register", paramString1, 0L, null, null);
      PushMessageHelper.sendCommandMessageBroadcast(sContext, paramString1);
      continue;
      str = com.xiaomi.channel.commonutils.string.d.a(6);
      a.a(sContext).h();
      a.a(sContext).a(Constants.a());
      a.a(sContext).a(paramString1, paramString2, str);
      clearExtras(sContext);
      paramMiPushClientCallback = new af();
      paramMiPushClientCallback.a(generatePacketID());
      paramMiPushClientCallback.b(paramString1);
      paramMiPushClientCallback.e(paramString2);
      paramMiPushClientCallback.d(paramContext.getPackageName());
      paramMiPushClientCallback.f(str);
      paramMiPushClientCallback.c(com.xiaomi.channel.commonutils.android.b.a(paramContext, paramContext.getPackageName()));
      paramMiPushClientCallback.b(com.xiaomi.channel.commonutils.android.b.b(paramContext, paramContext.getPackageName()));
      paramMiPushClientCallback.g("3_2_3");
      paramMiPushClientCallback.a(30203);
      paramMiPushClientCallback.h(com.xiaomi.channel.commonutils.android.e.b(sContext));
      paramMiPushClientCallback.a(t.c);
      paramContext = com.xiaomi.channel.commonutils.android.e.d(sContext);
      if (!TextUtils.isEmpty(paramContext))
      {
        if (g.b()) {
          paramMiPushClientCallback.i(paramContext);
        }
        paramMiPushClientCallback.k(com.xiaomi.channel.commonutils.string.d.a(paramContext));
      }
      paramMiPushClientCallback.j(com.xiaomi.channel.commonutils.android.e.a());
      i = com.xiaomi.channel.commonutils.android.e.b();
      if (i >= 0) {
        paramMiPushClientCallback.c(i);
      }
      u.a(sContext).a(paramMiPushClientCallback, bool);
    }
  }
  
  private static void loadPlugin()
  {
    int i = com.xiaomi.xmpush.thrift.e.z.a();
    if (ah.a(sContext).a(i, getDefaultSwitch())) {
      f.a(sContext).a(new l(), 10);
    }
  }
  
  public static void pausePush(Context paramContext, String paramString)
  {
    setAcceptTime(paramContext, 0, 0, 0, 0, paramString);
  }
  
  static void reInitialize(Context paramContext, t paramt)
  {
    if (!a.a(paramContext).i()) {
      return;
    }
    String str1 = com.xiaomi.channel.commonutils.string.d.a(6);
    String str2 = a.a(paramContext).c();
    String str3 = a.a(paramContext).d();
    a.a(paramContext).h();
    a.a(paramContext).a(str2, str3, str1);
    af localaf = new af();
    localaf.a(generatePacketID());
    localaf.b(str2);
    localaf.e(str3);
    localaf.f(str1);
    localaf.d(paramContext.getPackageName());
    localaf.c(com.xiaomi.channel.commonutils.android.b.a(paramContext, paramContext.getPackageName()));
    localaf.a(paramt);
    u.a(paramContext).a(localaf, false);
  }
  
  private static void registerNetworkReceiver(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addCategory("android.intent.category.DEFAULT");
    paramContext.registerReceiver(new NetworkStatusReceiver(null), localIntentFilter);
  }
  
  public static void registerPush(Context paramContext, String paramString1, String paramString2)
  {
    if (!NetworkStatusReceiver.a()) {
      registerNetworkReceiver(paramContext);
    }
    new Thread(new k(paramContext, paramString1, paramString2)).start();
  }
  
  static void removeAcceptTime(Context paramContext)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("accept_time").commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void removeAccount(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + paramString).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void removeAlias(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + paramString).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void removeAllAccounts(Context paramContext)
  {
    try
    {
      Iterator localIterator = getAllUserAccount(paramContext).iterator();
      while (localIterator.hasNext()) {
        removeAccount(paramContext, (String)localIterator.next());
      }
    }
    finally {}
  }
  
  static void removeAllAliases(Context paramContext)
  {
    try
    {
      Iterator localIterator = getAllAlias(paramContext).iterator();
      while (localIterator.hasNext()) {
        removeAlias(paramContext, (String)localIterator.next());
      }
    }
    finally {}
  }
  
  static void removeAllTopics(Context paramContext)
  {
    try
    {
      Iterator localIterator = getAllTopic(paramContext).iterator();
      while (localIterator.hasNext()) {
        removeTopic(paramContext, (String)localIterator.next());
      }
    }
    finally {}
  }
  
  static void removeTopic(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + paramString).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void reportIgnoreRegMessageClicked(Context paramContext, String paramString1, r paramr, String paramString2, String paramString3)
  {
    ae localae = new ae();
    if (TextUtils.isEmpty(paramString3))
    {
      com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
      return;
    }
    localae.b(paramString3);
    localae.c("bar:click");
    localae.a(paramString1);
    localae.a(false);
    u.a(paramContext).a(localae, com.xiaomi.xmpush.thrift.a.i, false, true, paramr, true, paramString2, paramString3);
  }
  
  public static void reportMessageClicked(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    r localr = new r();
    localr.a(paramMiPushMessage.getMessageId());
    localr.b(paramMiPushMessage.getTopic());
    localr.d(paramMiPushMessage.getDescription());
    localr.c(paramMiPushMessage.getTitle());
    localr.c(paramMiPushMessage.getNotifyId());
    localr.a(paramMiPushMessage.getNotifyType());
    localr.b(paramMiPushMessage.getPassThrough());
    localr.a(paramMiPushMessage.getExtra());
    reportMessageClicked(paramContext, paramMiPushMessage.getMessageId(), localr, null);
  }
  
  @Deprecated
  public static void reportMessageClicked(Context paramContext, String paramString)
  {
    reportMessageClicked(paramContext, paramString, null, null);
  }
  
  static void reportMessageClicked(Context paramContext, String paramString1, r paramr, String paramString2)
  {
    ae localae = new ae();
    if (TextUtils.isEmpty(paramString2)) {
      if (a.a(paramContext).b()) {
        localae.b(a.a(paramContext).c());
      }
    }
    for (;;)
    {
      localae.c("bar:click");
      localae.a(paramString1);
      localae.a(false);
      u.a(paramContext).a(localae, com.xiaomi.xmpush.thrift.a.i, false, paramr);
      return;
      com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
      return;
      localae.b(paramString2);
    }
  }
  
  public static void resumePush(Context paramContext, String paramString)
  {
    setAcceptTime(paramContext, 0, 0, 23, 59, paramString);
  }
  
  private static void scheduleGeoFenceRepeatJobs()
  {
    if (!com.xiaomi.push.service.h.b(sContext)) {
      return;
    }
    int i = ah.a(sContext).a(com.xiaomi.xmpush.thrift.e.O.a(), 900);
    f.a(sContext).a(new d(sContext), i);
  }
  
  private static void scheduleOcVersionCheckJob()
  {
    int i = ah.a(sContext).a(com.xiaomi.xmpush.thrift.e.A.a(), 86400);
    f.a(sContext).a(new o(sContext), i, 5);
  }
  
  public static void setAcceptTime(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 24) || (paramInt3 < 0) || (paramInt3 >= 24) || (paramInt2 < 0) || (paramInt2 >= 60) || (paramInt4 < 0) || (paramInt4 >= 60)) {
      throw new IllegalArgumentException("the input parameter is not valid.");
    }
    Object localObject1 = TimeZone.getTimeZone("GMT+08");
    Object localObject2 = TimeZone.getDefault();
    long l2 = (((TimeZone)localObject1).getRawOffset() - ((TimeZone)localObject2).getRawOffset()) / 1000 / 60;
    long l1 = (paramInt1 * 60 + paramInt2 + l2 + 1440L) % 1440L;
    l2 = (l2 + (paramInt3 * 60 + paramInt4) + 1440L) % 1440L;
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(String.format("%1$02d:%2$02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) }));
    ((ArrayList)localObject1).add(String.format("%1$02d:%2$02d", new Object[] { Long.valueOf(l2 / 60L), Long.valueOf(l2 % 60L) }));
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(String.format("%1$02d:%2$02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    ((ArrayList)localObject2).add(String.format("%1$02d:%2$02d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    if (acceptTimeSet(paramContext, (String)((ArrayList)localObject1).get(0), (String)((ArrayList)localObject1).get(1)))
    {
      if (1 == PushMessageHelper.getPushMode(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString, "accept-time", 0L, null, (List)localObject2);
        return;
      }
      PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage("accept-time", (List)localObject2, 0L, null, null));
      return;
    }
    setCommand(paramContext, "accept-time", (ArrayList)localObject1, paramString);
  }
  
  public static void setAlias(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      setCommand(paramContext, "set-alias", paramString1, paramString2);
    }
  }
  
  protected static void setCommand(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(paramString2);
    }
    if (("set-alias".equalsIgnoreCase(paramString1)) && (Math.abs(System.currentTimeMillis() - aliasSetTime(paramContext, paramString2)) < 3600000L))
    {
      if (1 == PushMessageHelper.getPushMode(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString3, paramString1, 0L, null, localArrayList);
        return;
      }
      PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage("set-alias", localArrayList, 0L, null, null));
      return;
    }
    if (("unset-alias".equalsIgnoreCase(paramString1)) && (aliasSetTime(paramContext, paramString2) < 0L))
    {
      com.xiaomi.channel.commonutils.logger.b.a("Don't cancel alias for " + localArrayList + " is unseted");
      return;
    }
    if (("set-account".equalsIgnoreCase(paramString1)) && (Math.abs(System.currentTimeMillis() - accountSetTime(paramContext, paramString2)) < 3600000L))
    {
      if (1 == PushMessageHelper.getPushMode(paramContext))
      {
        PushMessageHandler.a(paramContext, paramString3, paramString1, 0L, null, localArrayList);
        return;
      }
      PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage("set-account", localArrayList, 0L, null, null));
      return;
    }
    if (("unset-account".equalsIgnoreCase(paramString1)) && (accountSetTime(paramContext, paramString2) < 0L))
    {
      com.xiaomi.channel.commonutils.logger.b.a("Don't cancel account for " + localArrayList + " is unseted");
      return;
    }
    setCommand(paramContext, paramString1, localArrayList, paramString3);
  }
  
  protected static void setCommand(Context paramContext, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    if (TextUtils.isEmpty(a.a(paramContext).c())) {
      return;
    }
    com.xiaomi.xmpush.thrift.z localz = new com.xiaomi.xmpush.thrift.z();
    localz.a(generatePacketID());
    localz.b(a.a(paramContext).c());
    localz.c(paramString1);
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext()) {
      localz.d((String)paramString1.next());
    }
    localz.f(paramString2);
    localz.e(paramContext.getPackageName());
    u.a(paramContext).a(localz, com.xiaomi.xmpush.thrift.a.j, null);
  }
  
  public static void setLocalNotificationType(Context paramContext, int paramInt)
  {
    u.a(paramContext).b(paramInt & 0xFFFFFFFF);
  }
  
  public static void setUserAccount(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      setCommand(paramContext, "set-account", paramString1, paramString2);
    }
  }
  
  private static boolean shouldPullNotification(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    if (Math.abs(System.currentTimeMillis() - paramContext.getLong("last_pull_notification", -1L)) > 300000L) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean shouldSendRegRequest(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("mipush_extra", 0);
    if (Math.abs(System.currentTimeMillis() - paramContext.getLong("last_reg_request", -1L)) > 5000L) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean shouldUseMIUIPush(Context paramContext)
  {
    return u.a(paramContext).c();
  }
  
  public static void subscribe(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(a.a(paramContext).c())) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(paramContext, paramString1)) > 86400000L)
    {
      ak localak = new ak();
      localak.a(generatePacketID());
      localak.b(a.a(paramContext).c());
      localak.c(paramString1);
      localak.d(paramContext.getPackageName());
      localak.e(paramString2);
      u.a(paramContext).a(localak, com.xiaomi.xmpush.thrift.a.c, null);
      return;
    }
    if (1 == PushMessageHelper.getPushMode(paramContext))
    {
      PushMessageHandler.a(paramContext, paramString2, 0L, null, paramString1);
      return;
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    PushMessageHelper.sendCommandMessageBroadcast(paramContext, PushMessageHelper.generateCommandMessage("subscribe-topic", paramString2, 0L, null, null));
  }
  
  public static long topicSubscribedTime(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mipush_extra", 0).getLong("topic_" + paramString, -1L);
  }
  
  public static void unregisterPush(Context paramContext)
  {
    if (!a.a(paramContext).b()) {}
    do
    {
      return;
      am localam = new am();
      localam.a(generatePacketID());
      localam.b(a.a(paramContext).c());
      localam.c(a.a(paramContext).e());
      localam.e(a.a(paramContext).d());
      localam.d(paramContext.getPackageName());
      u.a(paramContext).a(localam);
      PushMessageHandler.a();
      a.a(paramContext).k();
      clearExtras(paramContext);
      clearLocalNotificationType(paramContext);
      clearNotification(paramContext);
    } while (mSyncMIIDHelper == null);
    com.xiaomi.push.service.k.a(paramContext).b(mSyncMIIDHelper);
  }
  
  public static void unsetAlias(Context paramContext, String paramString1, String paramString2)
  {
    setCommand(paramContext, "unset-alias", paramString1, paramString2);
  }
  
  public static void unsetUserAccount(Context paramContext, String paramString1, String paramString2)
  {
    setCommand(paramContext, "unset-account", paramString1, paramString2);
  }
  
  public static void unsubscribe(Context paramContext, String paramString1, String paramString2)
  {
    if (!a.a(paramContext).b()) {
      return;
    }
    if (topicSubscribedTime(paramContext, paramString1) < 0L)
    {
      com.xiaomi.channel.commonutils.logger.b.a("Don't cancel subscribe for " + paramString1 + " is unsubscribed");
      return;
    }
    ao localao = new ao();
    localao.a(generatePacketID());
    localao.b(a.a(paramContext).c());
    localao.c(paramString1);
    localao.d(paramContext.getPackageName());
    localao.e(paramString2);
    u.a(paramContext).a(localao, com.xiaomi.xmpush.thrift.a.d, null);
  }
  
  private static void updateIMEI()
  {
    new Thread(new m()).start();
  }
  
  @Deprecated
  public static abstract class MiPushClientCallback
  {
    private String category;
    
    protected String getCategory()
    {
      return this.category;
    }
    
    public void onCommandResult(String paramString1, long paramLong, String paramString2, List<String> paramList) {}
    
    public void onInitializeResult(long paramLong, String paramString1, String paramString2) {}
    
    public void onReceiveMessage(MiPushMessage paramMiPushMessage) {}
    
    public void onReceiveMessage(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
    
    public void onSubscribeResult(long paramLong, String paramString1, String paramString2) {}
    
    public void onUnsubscribeResult(long paramLong, String paramString1, String paramString2) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/xiaomi/mipush/sdk/MiPushClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */