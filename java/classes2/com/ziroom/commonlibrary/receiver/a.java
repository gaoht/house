package com.ziroom.commonlibrary.receiver;

import android.content.Context;
import android.os.Bundle;
import com.ziroom.commonlibrary.c.b;

public abstract interface a
{
  public abstract void onClickNotiInBar(Context paramContext, b paramb);
  
  public abstract void onClickNotiInSysMess(Context paramContext, b paramb);
  
  public abstract void openMessageActivity(Context paramContext, Bundle paramBundle);
  
  public abstract void processCustomMessage(Context paramContext, Bundle paramBundle);
  
  public abstract void processNotification(Context paramContext, Bundle paramBundle);
  
  public abstract void processRegistration(Context paramContext, Bundle paramBundle);
  
  public abstract b saveMessage(Context paramContext, Bundle paramBundle);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/receiver/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */