package com.ziroom.credit.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.router.activityrouter.Routers;

public class CreditMainActivity
  extends Activity
{
  public BroadcastReceiver a = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      int j = paramAnonymousIntent.getIntExtra("status", 0);
      l.e("huanxin", "  环信 = ");
      if ((i == 17) && (j == 1)) {
        Routers.open(paramAnonymousContext, "ziroomCustomer://zrCreditModule/home");
      }
    }
  };
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(new View(this));
    if (!a.getLoginState(this)) {
      a.startLoginActivity(this, true);
    }
    for (;;)
    {
      paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
      LocalBroadcastManager.getInstance(this).registerReceiver(this.a, paramBundle);
      return;
      Routers.open(this, "ziroomCustomer://zrCreditModule/home");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */