package cn.jpush.android.api;

import android.app.Notification;
import java.util.Map;

public abstract interface PushNotificationBuilder
{
  public abstract Notification buildNotification(Map<String, String> paramMap);
  
  public abstract String getDeveloperArg0();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/PushNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */