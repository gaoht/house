package cn.sharesdk.wechat.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.log.NLog;

public class WechatHandlerActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973839);
    super.onCreate(paramBundle);
    try
    {
      k.a().a(this);
      finish();
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        e.b().d(paramBundle);
      }
    }
  }
  
  public void onGetMessageFromWXReq(WXMediaMessage paramWXMediaMessage) {}
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    try
    {
      k.a().a(this);
      finish();
      return;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        e.b().d(paramIntent);
      }
    }
  }
  
  public void onShowMessageFromWXReq(WXMediaMessage paramWXMediaMessage) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/WechatHandlerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */