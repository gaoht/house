package com.ziroom.ziroomcustomer.minsu.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class MinsuChatActivity
  extends BaseActivity
{
  String a;
  private MinsuChatFragment b;
  private BroadcastReceiver c;
  
  private void a()
  {
    this.c = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (!MinsuChatActivity.this.isFinishing()) {
          MinsuChatActivity.this.finish();
        }
      }
    };
    IntentFilter localIntentFilter = new IntentFilter(getString(2131296569));
    LocalBroadcastManager.getInstance(this).registerReceiver(this.c, localIntentFilter);
  }
  
  private void a(Intent paramIntent)
  {
    int i = 1;
    if ("android.intent.action.VIEW".equals(paramIntent.getAction()))
    {
      Uri localUri = paramIntent.getData();
      if (localUri != null)
      {
        String str = localUri.getQueryParameter("uid");
        if (!com.ziroom.ziroomcustomer.minsu.e.d.getUid().equals(str)) {
          break label134;
        }
        this.a = localUri.getQueryParameter("toChatUsername");
        if (Integer.parseInt(localUri.getQueryParameter("msgSenderType")) == 1) {
          i = 2;
        }
        this.a = j.appendEMPrefix(this.a);
        paramIntent.putExtra("userId", this.a);
        paramIntent.putExtra("msgSenderType", i);
        com.freelxl.baselibrary.f.d.i("lanzhihong", "toChatUsername==" + this.a + "-----msgSenderType===" + i);
      }
    }
    return;
    label134:
    startActivity(new Intent(this, MainActivity.class));
    finish();
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
    if (!com.ziroom.commonlibrary.login.a.getLoginState(this))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if (localBundle != null) {
      this.a = localBundle.getString("userId");
    }
    for (;;)
    {
      this.b = new MinsuChatFragment();
      a(paramBundle);
      this.b.setArguments(paramBundle.getExtras());
      getSupportFragmentManager().beginTransaction().add(2131691278, this.b).commit();
      a();
      return;
      paramBundle.putExtra("chatType", 1);
    }
  }
  
  protected void onDestroy()
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huaweiwww", " minsuchat activity");
    b();
    super.onDestroy();
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    if (!com.ziroom.commonlibrary.login.a.getLoginState(this))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    String str1 = paramIntent.getStringExtra("userId");
    a(paramIntent);
    String str2 = paramIntent.getStringExtra("action");
    if ((ae.notNull(this.a)) && (this.a.equals(str1)) && (this.b != null) && (!"send_housecard".equals(str2)))
    {
      super.onNewIntent(paramIntent);
      return;
    }
    finish();
    startActivity(paramIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */