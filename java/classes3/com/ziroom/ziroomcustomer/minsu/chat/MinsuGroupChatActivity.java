package com.ziroom.ziroomcustomer.minsu.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class MinsuGroupChatActivity
  extends BaseActivity
{
  String a;
  private MinsuGroupChatFragment b;
  private BroadcastReceiver c;
  
  private void a()
  {
    this.c = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (!MinsuGroupChatActivity.this.isFinishing()) {
          MinsuGroupChatActivity.this.finish();
        }
      }
    };
    IntentFilter localIntentFilter = new IntentFilter(getString(2131296569));
    LocalBroadcastManager.getInstance(this).registerReceiver(this.c, localIntentFilter);
  }
  
  private void b()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.c);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 4) && (this.b.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public String getToChatUsername()
  {
    return this.a;
  }
  
  public void onBackPressed()
  {
    this.b.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904883);
    if (!a.getLoginState(this))
    {
      a.startLoginActivity(this);
      return;
    }
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.a = localBundle.getString("userId");
    }
    for (;;)
    {
      this.b = new MinsuGroupChatFragment();
      this.b.setArguments(paramBundle.getExtras());
      getSupportFragmentManager().beginTransaction().add(2131691278, this.b).commit();
      a();
      return;
      paramBundle.putExtra("chatType", 2);
    }
  }
  
  protected void onDestroy()
  {
    b();
    super.onDestroy();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    if (!a.getLoginState(this))
    {
      a.startLoginActivity(this);
      return;
    }
    String str = paramIntent.getStringExtra("userId");
    if ((ae.notNull(this.a)) && (this.a.equals(str))) {
      super.onNewIntent(paramIntent);
    }
    if (this.b != null)
    {
      this.b.onNewIntent();
      return;
    }
    finish();
    startActivity(paramIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuGroupChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */