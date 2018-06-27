package com.ziroom.ziroomcustomer.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.a;
import com.ziroom.ziroomcustomer.util.u;

public class MyWillPayListActivity
  extends BaseActivity
{
  private String a = MyWillPayListActivity.class.getSimpleName();
  private boolean b = false;
  private FragmentManager c;
  private MyWillPayFriendlyBillFragment d;
  private MyWillPayZryuBillFragment e;
  private String f;
  @BindView(2131691866)
  FrameLayout flFrag;
  private BroadcastReceiver g = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MyWillPayListActivity.a(MyWillPayListActivity.this, false);
    }
  };
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131691865)
  TextView tvFinished;
  @BindView(2131691864)
  TextView tvGoing;
  
  private void a()
  {
    this.f = getIntent().getStringExtra("tabIndex");
    this.c = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = this.c.beginTransaction();
    this.d = MyWillPayFriendlyBillFragment.getInstance();
    localFragmentTransaction.replace(2131691866, this.d);
    localFragmentTransaction.commitAllowingStateLoss();
    u.i(this.a, "tabIndex:" + this.f);
    if ("1".equals(this.f)) {
      a(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 2131624588;
    int k = 2130837975;
    if (this.b == paramBoolean) {
      return;
    }
    this.b = paramBoolean;
    this.ivBack.setVisibility(0);
    int i;
    int j;
    if (paramBoolean)
    {
      i = 2131624583;
      if (!paramBoolean) {
        break label112;
      }
      j = 2131624597;
      label44:
      if (!paramBoolean) {
        break label118;
      }
      label48:
      if (!paramBoolean) {
        break label125;
      }
    }
    for (;;)
    {
      this.tvGoing.setTextColor(getResources().getColor(j));
      this.tvGoing.setBackgroundResource(i);
      this.tvFinished.setTextColor(getResources().getColor(m));
      this.tvFinished.setBackgroundResource(k);
      b(paramBoolean);
      return;
      i = 2130837975;
      break;
      label112:
      j = 2131624588;
      break label44;
      label118:
      k = 2131624583;
      break label48;
      label125:
      m = 2131624597;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localFragmentTransaction = this.c.beginTransaction();
      this.e = MyWillPayZryuBillFragment.getInstance();
      localFragmentTransaction.replace(2131691866, this.e);
      localFragmentTransaction.commitAllowingStateLoss();
      this.d = null;
      return;
    }
    FragmentTransaction localFragmentTransaction = this.c.beginTransaction();
    localFragmentTransaction.replace(2131691866, MyWillPayFriendlyBillFragment.getInstance());
    localFragmentTransaction.commitAllowingStateLoss();
    this.e = null;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 66) {}
  }
  
  @OnClick({2131689492, 2131691864, 2131691865})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131691864: 
      a(false);
      return;
    }
    a(true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903377);
    ButterKnife.bind(this);
    a();
    registerReceiver(this.g, new IntentFilter("com.ziroom.ziroomcustomer.easily_pay"));
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.g);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyWillPayListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */