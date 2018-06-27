package com.ziroom.ziroomcustomer.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class MyAccountActivity
  extends BaseActivity
  implements b.b
{
  private b.a a;
  private Unbinder b;
  private BroadcastReceiver c = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      if ((i == 19) || (i == 20) || (i == 5)) {
        MyAccountActivity.a(MyAccountActivity.this).updatePhoneEmailUsername();
      }
      while (i != 7) {
        return;
      }
      MyAccountActivity.this.dismissProgress();
      MyAccountActivity.this.finish();
    }
  };
  @BindView(2131691823)
  TextView mTvEmail;
  @BindView(2131690666)
  TextView mTvPhone;
  @BindView(2131691821)
  TextView mTvUsername;
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return (this != null) && (!isFinishing());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903365);
    this.b = ButterKnife.bind(this);
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.c, paramBundle);
    this.a = new c(this);
    this.a.updatePhoneEmailUsername();
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.c);
    this.b.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131691820, 2131690984, 2131691822, 2131691824, 2131689895, 2131691825})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691820: 
      this.a.editUserName();
      return;
    case 2131690984: 
      this.a.editTelephone();
      return;
    case 2131691822: 
      this.a.editEmail();
      return;
    case 2131691824: 
      this.a.editPassword();
      return;
    case 2131689895: 
      finish();
      return;
    }
    this.a.editIntelligenceLockPassword();
  }
  
  public void showEmail(String paramString)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    this.mTvEmail.setText(paramString);
  }
  
  public void showTelephone(String paramString)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    this.mTvPhone.setText(paramString);
  }
  
  public void showUserName(String paramString)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    this.mTvUsername.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */