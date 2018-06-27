package cn.sharesdk.tencent.qzone;

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
  private static String a;
  private static PlatformActionListener b;
  
  public static void a(PlatformActionListener paramPlatformActionListener)
  {
    b = paramPlatformActionListener;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
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
        if ((str1 == null) || (!str1.startsWith(a))) {
          return;
        }
        finish();
        paramBundle = ResHelper.urlToBundle(paramBundle.getDataString());
        str1 = String.valueOf(paramBundle.get("result"));
        String str2 = String.valueOf(paramBundle.get("action"));
        if (("shareToQQ".equals(str2)) || ("shareToQzone".equals(str2)))
        {
          if (!"complete".equals(str1)) {
            continue;
          }
          if (b != null)
          {
            paramBundle = String.valueOf(paramBundle.get("response"));
            paramBundle = new Hashon().fromJson(paramBundle);
            b.onComplete(null, 9, paramBundle);
          }
        }
      }
      catch (Throwable paramBundle)
      {
        String str1;
        e.b().d(paramBundle);
        if (b == null) {
          return;
        }
        b.onError(null, 9, paramBundle);
        return;
        if (b == null) {
          continue;
        }
        b.onCancel(null, 9);
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
      if (b != null)
      {
        paramBundle = new Throwable(String.valueOf(paramBundle.get("response")));
        b.onError(null, 9, paramBundle);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qzone/ReceiveActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */