package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandleService
  extends IntentService
{
  private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue();
  
  public MessageHandleService()
  {
    super("MessageHandleThread");
  }
  
  public static void addJob(a parama)
  {
    if (parama != null) {
      a.add(parama);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = (a)a.poll();
      if (localObject != null) {
        break label19;
      }
    }
    label19:
    label162:
    label183:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              paramIntent = ((a)localObject).a();
              localObject = ((a)localObject).b();
              switch (((Intent)localObject).getIntExtra("message_type", 1))
              {
              case 4: 
              case 1: 
                localObject = s.a(this).a((Intent)localObject);
                if (localObject != null)
                {
                  if (!(localObject instanceof MiPushMessage)) {
                    break label183;
                  }
                  localObject = (MiPushMessage)localObject;
                  if (!((MiPushMessage)localObject).isArrivedMessage()) {
                    paramIntent.onReceiveMessage(this, (MiPushMessage)localObject);
                  }
                  if (((MiPushMessage)localObject).getPassThrough() != 1) {
                    break label162;
                  }
                  paramIntent.onReceivePassThroughMessage(this, (MiPushMessage)localObject);
                  return;
                }
                break;
              }
            }
            catch (RuntimeException paramIntent)
            {
              b.a(paramIntent);
              return;
            }
          }
          localObject = (MiPushCommandMessage)((Intent)localObject).getSerializableExtra("key_command");
          paramIntent.onCommandResult(this, (MiPushCommandMessage)localObject);
        } while (!TextUtils.equals(((MiPushCommandMessage)localObject).getCommand(), "register"));
        paramIntent.onReceiveRegisterResult(this, (MiPushCommandMessage)localObject);
        return;
        if (((MiPushMessage)localObject).isNotified())
        {
          paramIntent.onNotificationMessageClicked(this, (MiPushMessage)localObject);
          return;
        }
        paramIntent.onNotificationMessageArrived(this, (MiPushMessage)localObject);
        return;
      } while (!(localObject instanceof MiPushCommandMessage));
      localObject = (MiPushCommandMessage)localObject;
      paramIntent.onCommandResult(this, (MiPushCommandMessage)localObject);
    } while (!TextUtils.equals(((MiPushCommandMessage)localObject).getCommand(), "register"));
    paramIntent.onReceiveRegisterResult(this, (MiPushCommandMessage)localObject);
    return;
  }
  
  public static class a
  {
    private PushMessageReceiver a;
    private Intent b;
    
    public a(Intent paramIntent, PushMessageReceiver paramPushMessageReceiver)
    {
      this.a = paramPushMessageReceiver;
      this.b = paramIntent;
    }
    
    public PushMessageReceiver a()
    {
      return this.a;
    }
    
    public Intent b()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/MessageHandleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */