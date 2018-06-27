package com.hyphenate.chat;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.hyphenate.util.EMLog;

@SuppressLint({"Registered"})
public class EMChatService
  extends Service
{
  private static final String TAG = "chatservice";
  private final IBinder mBinder = new LocalBinder();
  
  public IBinder onBind(Intent paramIntent)
  {
    EMLog.d("chatservice", "onBind");
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    EMLog.i("chatservice", "chat service created");
  }
  
  public void onDestroy()
  {
    EMLog.d("chatservice", "onDestroy");
    if (EMPushHelper.getInstance().getPushType() == EMPushHelper.EMPushType.NORMAL) {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            if (!EMClient.getInstance().stopService) {
              EMClient.getInstance().doStartService();
            }
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }).start();
    }
  }
  
  public int onStartCommand(final Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (EMPushHelper.getInstance().getPushType() == EMPushHelper.EMPushType.NORMAL) && (!EMMonitor.getInstance().isStarted())) {
      new Thread(new Runnable()
      {
        public void run()
        {
          String str = "";
          try
          {
            if (paramIntent.hasExtra("reason")) {
              str = paramIntent.getStringExtra("reason");
            }
            EMMonitor.getInstance().start(EMChatService.this, EMChatService.this.getPackageName() + "/" + this.val$serviceName);
            EMMonitor.getInstance().startWakeup(EMChatService.this, str);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }).start();
    }
    if ((EMPushHelper.getInstance().getPushType() == EMPushHelper.EMPushType.GCM) || (EMPushHelper.getInstance().getPushType() == EMPushHelper.EMPushType.FCM))
    {
      EMLog.d("chatservice", "start not sticky!");
      return 2;
    }
    EMLog.d("chatservice", "start sticky!");
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return true;
  }
  
  public class LocalBinder
    extends Binder
  {
    public LocalBinder() {}
    
    EMChatService getService()
    {
      return EMChatService.this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMChatService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */