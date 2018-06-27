package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.MobUIShell;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;

public class ReceiveActivity
  extends Activity
{
  private static PlatformActionListener listener;
  private static String uriScheme;
  
  public static void setPlatformActionListener(PlatformActionListener paramPlatformActionListener)
  {
    listener = paramPlatformActionListener;
  }
  
  public static void setUriScheme(String paramString)
  {
    uriScheme = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        paramBundle = getIntent();
        str1 = paramBundle.getScheme();
        finish();
        if ((str1 == null) || (!str1.startsWith(uriScheme))) {
          return;
        }
        paramBundle = ResHelper.urlToBundle(paramBundle.getDataString());
        str1 = String.valueOf(paramBundle.get("result"));
        String str2 = String.valueOf(paramBundle.get("action"));
        if (("shareToQQ".equals(str2)) || ("shareToQzone".equals(str2)))
        {
          if (!"complete".equals(str1)) {
            continue;
          }
          if (listener != null)
          {
            paramBundle = String.valueOf(paramBundle.get("response"));
            paramBundle = new Hashon().fromJson(paramBundle);
            listener.onComplete(null, 9, paramBundle);
          }
        }
      }
      catch (Throwable paramBundle)
      {
        String str1;
        e.b().d(paramBundle);
        if (listener == null) {
          return;
        }
        listener.onError(null, 9, paramBundle);
        return;
        if (listener == null) {
          continue;
        }
        listener.onCancel(null, 9);
        continue;
      }
      paramBundle = new Intent("android.intent.action.VIEW");
      paramBundle.setClass(this, MobUIShell.class);
      paramBundle.setFlags(335544320);
      startActivity(paramBundle);
      return;
      if (!"error".equals(str1)) {
        continue;
      }
      if (listener != null)
      {
        paramBundle = new Throwable(String.valueOf(paramBundle.get("response")));
        listener.onError(null, 9, paramBundle);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/ReceiveActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */