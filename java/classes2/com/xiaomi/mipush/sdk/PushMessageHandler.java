package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.aw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class PushMessageHandler
  extends IntentService
{
  private static List<MiPushClient.MiPushClientCallback> a = new ArrayList();
  
  public PushMessageHandler()
  {
    super("mipush message handler");
  }
  
  protected static void a()
  {
    synchronized (a)
    {
      a.clear();
      return;
    }
  }
  
  public static void a(long paramLong, String paramString1, String paramString2)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      if (localIterator.hasNext()) {
        ((MiPushClient.MiPushClientCallback)localIterator.next()).onInitializeResult(paramLong, paramString1, paramString2);
      }
    }
  }
  
  public static void a(Context arg0, MiPushMessage paramMiPushMessage)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramMiPushMessage.getCategory(), localMiPushClientCallback.getCategory()))
        {
          localMiPushClientCallback.onReceiveMessage(paramMiPushMessage.getContent(), paramMiPushMessage.getAlias(), paramMiPushMessage.getTopic(), paramMiPushMessage.isNotified());
          localMiPushClientCallback.onReceiveMessage(paramMiPushMessage);
        }
      }
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    Object localObject = null;
    if ((parama instanceof MiPushMessage)) {
      a(paramContext, (MiPushMessage)parama);
    }
    MiPushCommandMessage localMiPushCommandMessage;
    do
    {
      do
      {
        return;
      } while (!(parama instanceof MiPushCommandMessage));
      localMiPushCommandMessage = (MiPushCommandMessage)parama;
      parama = localMiPushCommandMessage.getCommand();
      if ("register".equals(parama))
      {
        parama = localMiPushCommandMessage.getCommandArguments();
        paramContext = (Context)localObject;
        if (parama != null)
        {
          paramContext = (Context)localObject;
          if (!parama.isEmpty()) {
            paramContext = (String)parama.get(0);
          }
        }
        a(localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), paramContext);
        return;
      }
      if (("set-alias".equals(parama)) || ("unset-alias".equals(parama)) || ("accept-time".equals(parama)))
      {
        a(paramContext, localMiPushCommandMessage.getCategory(), parama, localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), localMiPushCommandMessage.getCommandArguments());
        return;
      }
      if ("subscribe-topic".equals(parama))
      {
        parama = localMiPushCommandMessage.getCommandArguments();
        if ((parama != null) && (!parama.isEmpty())) {}
        for (parama = (String)parama.get(0);; parama = null)
        {
          a(paramContext, localMiPushCommandMessage.getCategory(), localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), parama);
          return;
        }
      }
    } while (!"unsubscibe-topic".equals(parama));
    parama = localMiPushCommandMessage.getCommandArguments();
    if ((parama != null) && (!parama.isEmpty())) {}
    for (parama = (String)parama.get(0);; parama = null)
    {
      b(paramContext, localMiPushCommandMessage.getCategory(), localMiPushCommandMessage.getResultCode(), localMiPushCommandMessage.getReason(), parama);
      return;
    }
  }
  
  protected static void a(Context arg0, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.getCategory())) {
          localMiPushClientCallback.onSubscribeResult(paramLong, paramString2, paramString3);
        }
      }
    }
  }
  
  protected static void a(Context arg0, String paramString1, String paramString2, long paramLong, String paramString3, List<String> paramList)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.getCategory())) {
          localMiPushClientCallback.onCommandResult(paramString2, paramLong, paramString3, paramList);
        }
      }
    }
  }
  
  protected static void a(MiPushClient.MiPushClientCallback paramMiPushClientCallback)
  {
    synchronized (a)
    {
      if (!a.contains(paramMiPushClientCallback)) {
        a.add(paramMiPushClientCallback);
      }
      return;
    }
  }
  
  protected static boolean a(String paramString1, String paramString2)
  {
    return ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.equals(paramString1, paramString2));
  }
  
  protected static void b(Context arg0, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        MiPushClient.MiPushClientCallback localMiPushClientCallback = (MiPushClient.MiPushClientCallback)localIterator.next();
        if (a(paramString1, localMiPushClientCallback.getCategory())) {
          localMiPushClientCallback.onUnsubscribeResult(paramLong, paramString2, paramString3);
        }
      }
    }
  }
  
  public static boolean b()
  {
    return a.isEmpty();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Object localObject;
    try
    {
      if ("com.xiaomi.mipush.sdk.WAKEUP".equals(paramIntent.getAction()))
      {
        if (!a.a(this).i()) {
          return;
        }
        u.a(this).a();
        paramIntent = paramIntent.getStringExtra("waker_pkgname");
        localObject = new JSONObject();
        if (TextUtils.isEmpty(paramIntent)) {
          ((JSONObject)localObject).put("wakerPkgName", paramIntent);
        }
        ((JSONObject)localObject).put("selfPkgName", getPackageName());
        aw.a().a("system_running_log", "wake_up_app", 1L, ((JSONObject)localObject).toString());
        return;
      }
      if (1 != PushMessageHelper.getPushMode(this)) {
        break label132;
      }
      if (b())
      {
        b.d("receive a message before application calling initialize");
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      b.a(paramIntent);
      return;
    }
    paramIntent = s.a(this).a(paramIntent);
    if (paramIntent != null)
    {
      a(this, paramIntent);
      return;
      label132:
      localObject = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
      ((Intent)localObject).setPackage(getPackageName());
      ((Intent)localObject).putExtras(paramIntent);
      for (paramIntent = getPackageManager();; paramIntent = null)
      {
        try
        {
          paramIntent = paramIntent.queryBroadcastReceivers((Intent)localObject, 32);
          if (paramIntent == null) {
            continue;
          }
          Iterator localIterator = paramIntent.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            paramIntent = (ResolveInfo)localIterator.next();
          } while ((paramIntent.activityInfo == null) || (!paramIntent.activityInfo.packageName.equals(getPackageName())));
          if (paramIntent != null)
          {
            ((PushMessageReceiver)Class.forName(paramIntent.activityInfo.name).newInstance()).onReceive(getApplicationContext(), (Intent)localObject);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          b.a(paramIntent);
          return;
        }
        b.d("cannot find the receiver to handler this message, check your manifest");
        return;
      }
    }
  }
  
  static abstract interface a
    extends Serializable
  {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/PushMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */