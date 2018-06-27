package com.ziroom.commonlib.ziroomhttp;

import android.app.Application;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.ziroom.commonlib.utils.d;
import com.ziroom.commonlib.utils.s;

public class b
{
  public static void handleMessage(String paramString)
  {
    handleMessage(paramString, null);
  }
  
  public static void handleMessage(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if ("40005".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_token_invalid));
      paramString1 = new Intent("com.ziroom.commonlibrary.login.broadcast");
      paramString1.putExtra("type", 7);
      LocalBroadcastManager.getInstance(d.a).sendBroadcast(paramString1);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      s.showToast(paramString2);
      return;
    }
    if ("50000".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_server));
      return;
    }
    if ("10001".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_data));
      return;
    }
    if ("10000".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_net));
      return;
    }
    if ("40005".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_token_invalid));
      paramString1 = new Intent("com.ziroom.commonlibrary.login.broadcast");
      paramString1.putExtra("type", 7);
      LocalBroadcastManager.getInstance(d.a).sendBroadcast(paramString1);
      return;
    }
    if ("40010".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_three));
      return;
    }
    if ("40001".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_vcode));
      return;
    }
    if ("40002".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_user_exists));
      return;
    }
    if ("40003".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_password));
      return;
    }
    if ("40004".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_user_unexists));
      return;
    }
    if (("40006".equals(paramString1)) || ("40007".equals(paramString1)))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_account));
      return;
    }
    if ("40011".equals(paramString1))
    {
      s.showToast(d.a.getString(R.string.login_msg_error_vcode_frequency));
      return;
    }
    s.showToast(d.a.getString(R.string.login_msg_error_server));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */