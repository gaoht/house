package com.ziroom.commonlibrary.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.R.string;
import com.ziroom.commonlibrary.login.LoginActivity;

public class a
{
  public static void handleMessage(Context paramContext, String paramString)
  {
    handleMessage(paramContext, paramString, null);
  }
  
  public static void handleMessage(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if ("40005".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_token_invalid));
      if ((paramContext instanceof Activity)) {
        paramContext.startActivity(new Intent(paramContext, LoginActivity.class));
      }
      paramString1 = new Intent("com.ziroom.commonlibrary.login.broadcast");
      paramString1.putExtra("type", 7);
      LocalBroadcastManager.getInstance(paramContext).sendBroadcast(paramString1);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      g.textToast(localContext, paramString2);
      return;
    }
    if ("50000".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_server));
      return;
    }
    if ("10001".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_data));
      return;
    }
    if ("10000".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_net));
      return;
    }
    if ("40005".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_token_invalid));
      if ((paramContext instanceof Activity)) {
        paramContext.startActivity(new Intent(paramContext, LoginActivity.class));
      }
      paramString1 = new Intent("com.ziroom.commonlibrary.login.broadcast");
      paramString1.putExtra("type", 7);
      LocalBroadcastManager.getInstance(paramContext).sendBroadcast(paramString1);
      return;
    }
    if ("40010".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_three));
      return;
    }
    if ("40001".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_vcode));
      return;
    }
    if ("40002".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_user_exists));
      return;
    }
    if ("40003".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_password));
      return;
    }
    if ("40004".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_user_unexists));
      return;
    }
    if (("40006".equals(paramString1)) || ("40007".equals(paramString1)))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_account));
      return;
    }
    if ("40011".equals(paramString1))
    {
      g.textToast(localContext, localContext.getString(R.string.login_msg_error_vcode_frequency));
      return;
    }
    g.textToast(localContext, localContext.getString(R.string.login_msg_error_server));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */