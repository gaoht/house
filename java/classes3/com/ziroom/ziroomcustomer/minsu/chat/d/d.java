package com.ziroom.ziroomcustomer.minsu.chat.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Environment;
import com.hyphenate.chat.EMMessage;
import java.util.List;

public class d
{
  public static String getTopActivity(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (paramContext != null) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return "";
  }
  
  public static boolean isNetWorkConnected(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isNetworkConnAndAvailable(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getAllNetworkInfo();
    boolean bool1 = bool2;
    int i;
    if (paramContext != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramContext.length)
      {
        if ((paramContext[i].getState() == NetworkInfo.State.CONNECTED) && (paramContext[i].isAvailable())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isSdcardExist()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean isSilentMessage(EMMessage paramEMMessage)
  {
    return paramEMMessage.getBooleanAttribute("em_ignore_notification", false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */