package com.ziroom.ziroomcustomer.newchat;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  private List<Activity> a = new ArrayList();
  
  public static boolean getNetWorkType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      paramContext = paramContext.getTypeName();
      if (paramContext.equalsIgnoreCase("WIFI")) {
        return true;
      }
      if (paramContext.equalsIgnoreCase("MOBILE")) {
        return false;
      }
    }
    return false;
  }
  
  public boolean isEvalMessage(EMMessage paramEMMessage)
  {
    try
    {
      paramEMMessage = paramEMMessage.getJSONObjectAttribute("weichat");
      u.e("WEICHAT_MSG", "========   WEICHAT_MSG11  " + a.toJSONString(paramEMMessage));
      boolean bool = paramEMMessage.has("ctrlType");
      if (bool) {
        try
        {
          paramEMMessage = paramEMMessage.getString("ctrlType");
          if (!TextUtils.isEmpty(paramEMMessage)) {
            if (!paramEMMessage.equalsIgnoreCase("inviteEnquiry"))
            {
              bool = paramEMMessage.equalsIgnoreCase("enquiry");
              if (!bool) {}
            }
            else
            {
              return true;
            }
          }
        }
        catch (JSONException paramEMMessage)
        {
          paramEMMessage.printStackTrace();
        }
      }
    }
    catch (HyphenateException paramEMMessage)
    {
      for (;;) {}
    }
    return false;
  }
  
  public void pushActivity(Activity paramActivity)
  {
    if (!this.a.contains(paramActivity)) {
      this.a.add(0, paramActivity);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */