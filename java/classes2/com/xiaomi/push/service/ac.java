package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.android.b.a;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.r;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ac
{
  public static long a = 0L;
  private static final LinkedList<Pair<Integer, ab>> b = new LinkedList();
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.equals(paramContext.getPackageName())) {
      return paramContext.getResources().getIdentifier(paramString2, "drawable", paramString1);
    }
    return 0;
  }
  
  private static Notification a(Notification paramNotification)
  {
    Object localObject = a.a(paramNotification, "extraNotification");
    if (localObject != null) {
      a.a(localObject, "setCustomizedIcon", new Object[] { Boolean.valueOf(true) });
    }
    return paramNotification;
  }
  
  private static Notification a(Notification paramNotification, String paramString)
  {
    try
    {
      Object localObject = Notification.class.getDeclaredField("extraNotification");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramNotification);
      Method localMethod = localObject.getClass().getDeclaredMethod("setTargetPkg", new Class[] { CharSequence.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject, new Object[] { paramString });
      return paramNotification;
    }
    catch (Exception paramString)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramString);
    }
    return paramNotification;
  }
  
  private static PendingIntent a(Context paramContext, ab paramab, r paramr, byte[] paramArrayOfByte)
  {
    if ((paramr != null) && (!TextUtils.isEmpty(paramr.g)))
    {
      paramab = new Intent("android.intent.action.VIEW");
      paramab.setData(Uri.parse(paramr.g));
      paramab.addFlags(268435456);
      return PendingIntent.getActivity(paramContext, 0, paramab, 134217728);
    }
    if (b(paramab))
    {
      paramab = new Intent();
      paramab.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
      paramab.putExtra("mipush_payload", paramArrayOfByte);
      paramab.putExtra("mipush_notified", true);
      paramab.addCategory(String.valueOf(paramr.q()));
      return PendingIntent.getService(paramContext, 0, paramab, 134217728);
    }
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setComponent(new ComponentName(paramab.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
    localIntent.putExtra("mipush_payload", paramArrayOfByte);
    localIntent.putExtra("mipush_notified", true);
    localIntent.addCategory(String.valueOf(paramr.q()));
    return PendingIntent.getService(paramContext, 0, localIntent, 134217728);
  }
  
  private static Bitmap a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDrawable(paramInt));
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    int j = 1;
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    if (i > 0) {}
    for (;;)
    {
      int k = paramDrawable.getIntrinsicHeight();
      if (k > 0) {
        j = k;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
      i = 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  private static a a(Context paramContext, ab paramab, byte[] paramArrayOfByte, RemoteViews paramRemoteViews, PendingIntent paramPendingIntent)
  {
    a locala = new a();
    r localr = paramab.m();
    String str = a(paramab);
    Map localMap = localr.s();
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    paramab = a(paramContext, localr);
    localBuilder.setContentTitle(paramab[0]);
    localBuilder.setContentText(paramab[1]);
    label90:
    label112:
    int j;
    if (paramRemoteViews != null)
    {
      localBuilder.setContent(paramRemoteViews);
      localBuilder.setWhen(System.currentTimeMillis());
      if (localMap != null) {
        break label605;
      }
      paramab = null;
      if (!TextUtils.isEmpty(paramab)) {
        break label622;
      }
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setShowWhen(true);
      }
      localBuilder.setContentIntent(paramPendingIntent);
      i = a(paramContext, str, "mipush_notification");
      j = a(paramContext, str, "mipush_small_notification");
      if ((i <= 0) || (j <= 0)) {
        break label635;
      }
      localBuilder.setLargeIcon(a(paramContext, i));
      localBuilder.setSmallIcon(j);
      label172:
      if (localMap != null) {
        break label650;
      }
      paramab = null;
      label179:
      if ((localMap == null) || (!Boolean.parseBoolean((String)localMap.get("__adiom")))) {
        break label667;
      }
      i = 1;
      label206:
      if ((i == 0) && (!g.b())) {
        break label673;
      }
      i = 1;
      label220:
      if ((paramab == null) || (i == 0)) {
        break label691;
      }
      paramArrayOfByte = null;
      if (!paramab.startsWith("http")) {
        break label679;
      }
      paramRemoteViews = ag.a(paramContext, paramab);
      paramab = paramArrayOfByte;
      if (paramRemoteViews != null)
      {
        paramab = paramRemoteViews.a;
        locala.b = paramRemoteViews.b;
      }
      label267:
      if (paramab == null) {
        break label691;
      }
      localBuilder.setLargeIcon(paramab);
    }
    label605:
    label622:
    label635:
    label650:
    label667:
    label673:
    label679:
    label688:
    label691:
    for (int i = 1;; i = 0)
    {
      if ((localMap != null) && (Build.VERSION.SDK_INT >= 24))
      {
        paramab = (String)localMap.get("notification_group");
        boolean bool = Boolean.parseBoolean((String)localMap.get("notification_is_summary"));
        a.a(localBuilder, "setGroup", new Object[] { paramab });
        a.a(localBuilder, "setGroupSummary", new Object[] { Boolean.valueOf(bool) });
      }
      localBuilder.setAutoCancel(true);
      long l = System.currentTimeMillis();
      if ((localMap != null) && (localMap.containsKey("ticker"))) {
        localBuilder.setTicker((CharSequence)localMap.get("ticker"));
      }
      if (l - a > 10000L)
      {
        a = l;
        j = localr.f;
        if (!e(paramContext, str)) {
          break label688;
        }
        j = c(paramContext, str);
      }
      for (;;)
      {
        localBuilder.setDefaults(j);
        if ((localMap != null) && ((j & 0x1) != 0))
        {
          paramContext = (String)localMap.get("sound_uri");
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.startsWith("android.resource://" + str)))
          {
            localBuilder.setDefaults(j ^ 0x1);
            localBuilder.setSound(Uri.parse(paramContext));
          }
        }
        paramContext = localBuilder.getNotification();
        if ((i != 0) && (g.a())) {
          a(paramContext);
        }
        locala.a = paramContext;
        return locala;
        if (Build.VERSION.SDK_INT < 16) {
          break;
        }
        localBuilder.setStyle(new Notification.BigTextStyle().bigText(paramab[1]));
        break;
        paramab = (String)localMap.get("notification_show_when");
        break label90;
        localBuilder.setShowWhen(Boolean.parseBoolean(paramab));
        break label112;
        localBuilder.setSmallIcon(f(paramContext, str));
        break label172;
        paramab = (String)localMap.get("__dynamic_icon_uri");
        break label179;
        i = 0;
        break label206;
        i = 0;
        break label220;
        paramab = ag.b(paramContext, paramab);
        break label267;
      }
    }
  }
  
  public static b a(Context arg0, ab paramab, byte[] paramArrayOfByte)
  {
    b localb = new b();
    if (com.xiaomi.channel.commonutils.android.b.d(???, a(paramab)) == b.a.c)
    {
      com.xiaomi.channel.commonutils.logger.b.a("Do not notify because user block " + a(paramab) + "‘s notification");
      return localb;
    }
    if (ay.a(???, paramab))
    {
      ??? = ay.a(paramab);
      com.xiaomi.channel.commonutils.logger.b.a("Do not notify because user block " + ??? + "‘s notification");
      return localb;
    }
    NotificationManager localNotificationManager = (NotificationManager)???.getSystemService("notification");
    r localr = paramab.m();
    Object localObject1 = b(???, paramab, paramArrayOfByte);
    Object localObject2 = a(???, paramab, localr, paramArrayOfByte);
    if (localObject2 == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("The click PendingIntent is null. ");
      return localb;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramArrayOfByte = a(???, paramab, paramArrayOfByte, (RemoteViews)localObject1, (PendingIntent)localObject2);
      localb.b = paramArrayOfByte.b;
      localb.a = a(paramab);
      paramArrayOfByte = paramArrayOfByte.a;
      if ((g.a()) && (Build.VERSION.SDK_INT >= 19) && (!TextUtils.isEmpty(localr.b()))) {
        paramArrayOfByte.extras.putString("message_id", localr.b());
      }
      if (localr.s() != null) {
        break label718;
      }
      localObject1 = null;
      label246:
      if ((!g.a()) || (localObject1 == null)) {}
    }
    label718:
    label754:
    for (;;)
    {
      try
      {
        a(paramArrayOfByte, Integer.parseInt((String)localObject1));
        if ("com.xiaomi.xmsf".equals(???.getPackageName())) {
          a(paramArrayOfByte, a(paramab));
        }
        if ("com.xiaomi.xmsf".equals(a(paramab))) {
          ay.a(???, paramab, paramArrayOfByte);
        }
        i = localr.q() + a(paramab).hashCode() / 10 * 10;
        localNotificationManager.notify(i, paramArrayOfByte);
        paramab = new Pair(Integer.valueOf(i), paramab);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        synchronized (b)
        {
          int i;
          b.add(paramab);
          if (b.size() > 100) {
            b.remove();
          }
          return localb;
          paramArrayOfByte = new Notification(f(???, a(paramab)), null, System.currentTimeMillis());
          String[] arrayOfString = a(???, localr);
          try
          {
            paramArrayOfByte.getClass().getMethod("setLatestEventInfo", new Class[] { Context.class, CharSequence.class, CharSequence.class, PendingIntent.class }).invoke(paramArrayOfByte, new Object[] { ???, arrayOfString[0], arrayOfString[1], localObject2 });
            localObject2 = localr.s();
            if ((localObject2 != null) && (((Map)localObject2).containsKey("ticker"))) {
              paramArrayOfByte.tickerText = ((CharSequence)((Map)localObject2).get("ticker"));
            }
            long l = System.currentTimeMillis();
            if (l - a > 10000L)
            {
              a = l;
              i = localr.f;
              if (!e(???, a(paramab))) {
                break label754;
              }
              i = c(???, a(paramab));
              paramArrayOfByte.defaults = i;
              if ((localObject2 != null) && ((i & 0x1) != 0))
              {
                localObject2 = (String)((Map)localObject2).get("sound_uri");
                if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith("android.resource://" + a(paramab))))
                {
                  paramArrayOfByte.defaults = (i ^ 0x1);
                  paramArrayOfByte.sound = Uri.parse((String)localObject2);
                }
              }
            }
            paramArrayOfByte.flags |= 0x10;
            if (localObject1 != null) {
              paramArrayOfByte.contentView = ((RemoteViews)localObject1);
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            com.xiaomi.channel.commonutils.logger.b.a(localNoSuchMethodException);
            continue;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            com.xiaomi.channel.commonutils.logger.b.a(localIllegalAccessException);
            continue;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            com.xiaomi.channel.commonutils.logger.b.a(localIllegalArgumentException);
            continue;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            com.xiaomi.channel.commonutils.logger.b.a(localInvocationTargetException);
            continue;
          }
          localObject1 = (String)localr.s().get("message_count");
          break label246;
          localNumberFormatException = localNumberFormatException;
          com.xiaomi.channel.commonutils.logger.b.a(localNumberFormatException);
        }
      }
    }
  }
  
  static String a(ab paramab)
  {
    if ("com.xiaomi.xmsf".equals(paramab.f))
    {
      Object localObject = paramab.m();
      if ((localObject != null) && (((r)localObject).s() != null))
      {
        localObject = (String)((r)localObject).s().get("miui_package_name");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          return (String)localObject;
        }
      }
    }
    return paramab.f;
  }
  
  private static void a(Notification paramNotification, int paramInt)
  {
    paramNotification = a.a(paramNotification, "extraNotification");
    if (paramNotification != null) {
      a.a(paramNotification, "setMessageCount", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public static void a(Context arg0, String paramString, int paramInt)
  {
    NotificationManager localNotificationManager = (NotificationManager)???.getSystemService("notification");
    int i = paramString.hashCode() / 10 * 10 + paramInt;
    LinkedList localLinkedList = new LinkedList();
    if (paramInt >= 0) {
      localNotificationManager.cancel(i);
    }
    for (;;)
    {
      Pair localPair;
      Object localObject;
      synchronized (b)
      {
        Iterator localIterator = b.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localPair = (Pair)localIterator.next();
        localObject = (ab)localPair.second;
        if (localObject == null) {
          continue;
        }
        localObject = a((ab)localObject);
        if (paramInt >= 0)
        {
          if ((i != ((Integer)localPair.first).intValue()) || (!TextUtils.equals((CharSequence)localObject, paramString))) {
            continue;
          }
          localLinkedList.add(localPair);
        }
      }
      if ((paramInt == -1) && (TextUtils.equals((CharSequence)localObject, paramString)))
      {
        localNotificationManager.cancel(((Integer)localPair.first).intValue());
        localLinkedList.add(localPair);
      }
    }
    if (b != null)
    {
      b.removeAll(localLinkedList);
      a(localLinkedList);
    }
  }
  
  public static void a(Context arg0, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    NotificationManager localNotificationManager = (NotificationManager)???.getSystemService("notification");
    LinkedList localLinkedList = new LinkedList();
    synchronized (b)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        Object localObject = (ab)localPair.second;
        if (localObject != null)
        {
          String str = a((ab)localObject);
          localObject = ((ab)localObject).m();
          if ((localObject != null) && (TextUtils.equals(str, paramString1)))
          {
            str = ((r)localObject).h();
            localObject = ((r)localObject).j();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (a(paramString2, str)) && (a(paramString3, (String)localObject)))
            {
              localNotificationManager.cancel(((Integer)localPair.first).intValue());
              localLinkedList.add(localPair);
            }
          }
        }
      }
    }
    if (b != null)
    {
      b.removeAll(localLinkedList);
      a(localLinkedList);
    }
  }
  
  private static void a(LinkedList<Pair<Integer, ab>> paramLinkedList)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      aw.a().a("category_clear_notification", "clear_notification", paramLinkedList.size(), "");
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.importance == 100) && (Arrays.asList(localRunningAppProcessInfo.pkgList).contains(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (TextUtils.isEmpty(paramString1)) || (paramString2.contains(paramString1));
  }
  
  public static boolean a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (!paramMap.containsKey("notify_foreground"))) {
      return true;
    }
    return "1".equals((String)paramMap.get("notify_foreground"));
  }
  
  private static String[] a(Context paramContext, r paramr)
  {
    Object localObject1 = paramr.h();
    String str = paramr.j();
    Map localMap = paramr.s();
    paramr = (r)localObject1;
    Object localObject2 = str;
    int i;
    if (localMap != null)
    {
      i = paramContext.getResources().getDisplayMetrics().widthPixels;
      float f = paramContext.getResources().getDisplayMetrics().density;
      i = Float.valueOf(i / f + 0.5F).intValue();
      if (i > 320) {
        break label139;
      }
      paramContext = (String)localMap.get("title_short");
      if (!TextUtils.isEmpty(paramContext)) {
        localObject1 = paramContext;
      }
      paramContext = (String)localMap.get("description_short");
      if (TextUtils.isEmpty(paramContext)) {
        break label214;
      }
    }
    for (;;)
    {
      localObject2 = paramContext;
      paramr = (r)localObject1;
      for (;;)
      {
        return new String[] { paramr, localObject2 };
        label139:
        paramr = (r)localObject1;
        localObject2 = str;
        if (i > 360)
        {
          paramContext = (String)localMap.get("title_long");
          if (!TextUtils.isEmpty(paramContext)) {
            localObject1 = paramContext;
          }
          paramContext = (String)localMap.get("description_long");
          paramr = (r)localObject1;
          localObject2 = str;
          if (!TextUtils.isEmpty(paramContext))
          {
            localObject2 = paramContext;
            paramr = (r)localObject1;
          }
        }
      }
      label214:
      paramContext = str;
    }
  }
  
  private static RemoteViews b(Context paramContext, ab paramab, byte[] paramArrayOfByte)
  {
    Object localObject1 = paramab.m();
    paramArrayOfByte = a(paramab);
    localObject1 = ((r)localObject1).s();
    if (localObject1 == null) {
      return null;
    }
    paramab = (String)((Map)localObject1).get("layout_name");
    Object localObject2 = (String)((Map)localObject1).get("layout_value");
    if ((TextUtils.isEmpty(paramab)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
      return null;
    }
    paramContext = paramContext.getPackageManager();
    int i;
    try
    {
      localObject1 = paramContext.getResourcesForApplication(paramArrayOfByte);
      i = ((Resources)localObject1).getIdentifier(paramab, "layout", paramArrayOfByte);
      if (i == 0) {
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
      return null;
    }
    RemoteViews localRemoteViews = new RemoteViews(paramArrayOfByte, i);
    Object localObject3;
    String str;
    try
    {
      paramContext = new JSONObject((String)localObject2);
      if (paramContext.has("text"))
      {
        paramab = paramContext.getJSONObject("text");
        localObject2 = paramab.keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          str = paramab.getString((String)localObject3);
          i = ((Resources)localObject1).getIdentifier((String)localObject3, "id", paramArrayOfByte);
          if (i > 0) {
            localRemoteViews.setTextViewText(i, str);
          }
        }
      }
      if (!paramContext.has("image")) {
        break label309;
      }
    }
    catch (JSONException paramContext)
    {
      com.xiaomi.channel.commonutils.logger.b.a(paramContext);
      return null;
    }
    paramab = paramContext.getJSONObject("image");
    localObject2 = paramab.keys();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      str = paramab.getString((String)localObject3);
      i = ((Resources)localObject1).getIdentifier((String)localObject3, "id", paramArrayOfByte);
      int j = ((Resources)localObject1).getIdentifier(str, "drawable", paramArrayOfByte);
      if (i > 0) {
        localRemoteViews.setImageViewResource(i, j);
      }
    }
    label309:
    if (paramContext.has("time"))
    {
      localObject2 = paramContext.getJSONObject("time");
      localObject3 = ((JSONObject)localObject2).keys();
      while (((Iterator)localObject3).hasNext())
      {
        str = (String)((Iterator)localObject3).next();
        paramab = ((JSONObject)localObject2).getString(str);
        paramContext = paramab;
        if (paramab.length() == 0) {
          paramContext = "yy-MM-dd hh:mm";
        }
        i = ((Resources)localObject1).getIdentifier(str, "id", paramArrayOfByte);
        if (i > 0)
        {
          long l = System.currentTimeMillis();
          localRemoteViews.setTextViewText(i, new SimpleDateFormat(paramContext).format(new Date(l)));
        }
      }
    }
    return localRemoteViews;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, -1);
  }
  
  static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static boolean b(ab paramab)
  {
    paramab = paramab.m();
    return (paramab != null) && (paramab.v());
  }
  
  static int c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).getInt(paramString, Integer.MAX_VALUE);
  }
  
  static void d(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("pref_notify_type", 0).edit().remove(paramString).commit();
  }
  
  static boolean e(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pref_notify_type", 0).contains(paramString);
  }
  
  private static int f(Context paramContext, String paramString)
  {
    int i = a(paramContext, paramString, "mipush_notification");
    int j = a(paramContext, paramString, "mipush_small_notification");
    if (i > 0) {}
    for (;;)
    {
      j = i;
      if (i == 0)
      {
        j = i;
        if (Build.VERSION.SDK_INT >= 9) {
          j = paramContext.getApplicationInfo().logo;
        }
      }
      return j;
      if (j > 0) {
        i = j;
      } else {
        i = paramContext.getApplicationInfo().icon;
      }
    }
  }
  
  public static class a
  {
    Notification a;
    long b = 0L;
  }
  
  public static class b
  {
    public String a;
    public long b = 0L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */