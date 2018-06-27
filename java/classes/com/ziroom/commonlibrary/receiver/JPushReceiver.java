package com.ziroom.commonlibrary.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import com.freelxl.baselibrary.f.d;

public class JPushReceiver
  extends BroadcastReceiver
{
  public static String a = "";
  
  private void a(Context paramContext, Bundle paramBundle)
  {
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().openMessageActivity(paramContext, paramBundle);
    }
  }
  
  private void b(Context paramContext, Bundle paramBundle)
  {
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().processCustomMessage(paramContext, paramBundle);
    }
  }
  
  private void c(Context paramContext, Bundle paramBundle)
  {
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().processNotification(paramContext, paramBundle);
    }
  }
  
  private void d(Context paramContext, Bundle paramBundle)
  {
    if (com.ziroom.commonlibrary.g.a.getInstance().getjPushListener() != null) {
      com.ziroom.commonlibrary.g.a.getInstance().getjPushListener().processRegistration(paramContext, paramBundle);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = paramIntent.getExtras();
      } while (localBundle == null);
      if (JPushInterface.ACTION_REGISTRATION_ID.equals(paramIntent.getAction()))
      {
        d.i("PushFeedback", "极光EXTRA_REGISTRATION_ID：" + localBundle.getString(JPushInterface.EXTRA_REGISTRATION_ID));
        d(paramContext, localBundle);
        return;
      }
      if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(paramIntent.getAction()))
      {
        b(paramContext, localBundle);
        return;
      }
      if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(paramIntent.getAction()))
      {
        c(paramContext, localBundle);
        return;
      }
      if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(paramIntent.getAction()))
      {
        a(paramContext, localBundle);
        return;
      }
    } while (!JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(paramIntent.getAction()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlibrary/receiver/JPushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */