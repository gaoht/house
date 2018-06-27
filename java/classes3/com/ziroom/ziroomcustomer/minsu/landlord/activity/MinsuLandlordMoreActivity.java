package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.commonlibrary.login.a.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuLandlordAuthInfoActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuPersonalDataActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.f.f;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuLandlordMoreActivity
  extends BaseActivity
{
  private int a;
  private String b = "";
  private f c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131690319)
  TextView tvAgreement;
  @BindView(2131691488)
  TextView tvAuthentication;
  @BindView(2131691490)
  TextView tvContract;
  @BindView(2131691487)
  TextView tvPeopleMessage;
  @BindView(2131691492)
  TextView tvQuit;
  @BindView(2131691489)
  TextView tvServiceAbout;
  @BindView(2131691491)
  TextView tvSuggestion;
  
  private void a()
  {
    if (this.c == null)
    {
      this.c = new f(this);
      this.c.init();
    }
    if (this.c != null) {
      this.c.showPop();
    }
  }
  
  public void initTitle()
  {
    this.commonTitle.setLeftButtonType(0);
    this.commonTitle.setMiddleText("更多");
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLandlordMoreActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903298);
    ButterKnife.bind(this);
    this.a = getIntent().getIntExtra("authCode", 0);
    this.b = getIntent().getStringExtra("phone");
    initTitle();
  }
  
  @OnClick({2131691487, 2131691488, 2131691489, 2131691490, 2131691491, 2131690319, 2131691492})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691487: 
      startActivityForResult(new Intent(this, MinsuPersonalDataActivity.class), 289);
      return;
    case 2131691488: 
      paramView = new Intent(this, MinsuLandlordAuthInfoActivity.class);
      paramView.putExtra("flag", MinsuLandlordAuthInfoActivity.b);
      if (this.a == 1) {
        paramView.putExtra("flag", MinsuLandlordAuthInfoActivity.a);
      }
      for (;;)
      {
        startActivity(paramView);
        return;
        paramView.putExtra("flag", MinsuLandlordAuthInfoActivity.b);
      }
    case 2131691489: 
      paramView = new Intent(this, MinsuLandlordPlatformServiceActivity.class);
      paramView.putExtra("phone400", this.b);
      startActivity(paramView);
      return;
    case 2131691490: 
      a();
      return;
    case 2131691491: 
      startActivity(new Intent(this, MinsuLandlordSuggestActivity.class));
      return;
    case 2131690319: 
      paramView = new Intent(this, MinsuWebActivity.class);
      paramView.putExtra("isShowShare", false);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.f);
      paramView.putExtra("title", getString(2131297105));
      startActivity(paramView);
      return;
    }
    com.ziroom.commonlibrary.login.a.showLogoutDialog(this, new a.a()
    {
      public void onLogoutFinish(boolean paramAnonymousBoolean)
      {
        Intent localIntent = new Intent();
        localIntent.setClass(MinsuLandlordMoreActivity.this, LoginActivity.class);
        MinsuLandlordMoreActivity.this.startActivity(localIntent);
        MinsuLandlordMoreActivity.this.finish();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordMoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */