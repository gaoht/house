package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.DraweeTransition;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.presenter.a.a;
import com.ziroom.ziroomcustomer.findhouse.presenter.a.b;
import com.ziroom.ziroomcustomer.findhouse.presenter.d;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.util.HashMap;
import java.util.Map;

public class RentHouseDetailActivity
  extends BaseActivity
  implements a.b, a
{
  ViewStub a;
  ScrollView b;
  ViewStub c;
  private a.a d;
  private String e;
  private String f;
  private RentHouseDetail g;
  private String r;
  private int s;
  private int t;
  private SimpleDraweeView u;
  private BroadcastReceiver v = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (HouseListActivity.e) {
        RentHouseDetailActivity.this.finish();
      }
    }
  };
  
  private void a()
  {
    this.t = getIntent().getIntExtra("placeholder_type", -1);
    this.a = ((ViewStub)findViewById(2131690894));
    this.b = ((ScrollView)findViewById(2131692127));
    this.c = ((ViewStub)findViewById(2131692129));
    if (this.t == 2)
    {
      e();
      return;
    }
    b();
  }
  
  private void a(Bundle paramBundle)
  {
    this.e = getIntent().getStringExtra("id");
    this.f = getIntent().getStringExtra("house_id");
    this.r = getIntent().getStringExtra("SIGNBACK");
    if (paramBundle != null) {
      this.g = ((RentHouseDetail)paramBundle.getSerializable("rent_detail"));
    }
    new com.ziroom.ziroomcustomer.findhouse.presenter.c(this.e, this.f, this.g, this);
    this.d.initData();
    paramBundle = new IntentFilter("finishHouseDetailActivity");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.v, paramBundle);
  }
  
  private void a(BaseFragment paramBaseFragment)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (Build.VERSION.SDK_INT >= 21)
    {
      Fade localFade = new Fade();
      localFade.setDuration(600L);
      paramBaseFragment.setEnterTransition(localFade);
    }
    for (;;)
    {
      localFragmentTransaction.add(2131691466, paramBaseFragment, "rent_content");
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.setCustomAnimations(2130968587, 2130968589);
    }
  }
  
  private void b()
  {
    if ((!isFinishing()) && (this.b.getVisibility() != 0))
    {
      this.b.setVisibility(0);
      ImageView localImageView = (ImageView)findViewById(2131689492);
      this.u = ((SimpleDraweeView)findViewById(2131690027));
      String str = getIntent().getStringExtra("bannerUrl");
      if (!TextUtils.isEmpty(str)) {
        this.u.setController(com.freelxl.baselibrary.f.c.frescoController(str));
      }
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("SIGNBACK".equals(RentHouseDetailActivity.a(RentHouseDetailActivity.this)))
          {
            paramAnonymousView = new Intent(RentHouseDetailActivity.this, MainActivity.class);
            RentHouseDetailActivity.this.startActivity(paramAnonymousView);
            return;
          }
          RentHouseDetailActivity.this.finish();
        }
      });
    }
  }
  
  private void e()
  {
    if ((!isFinishing()) && (this.c.getVisibility() != 0))
    {
      this.c.setVisibility(0);
      this.u = ((SimpleDraweeView)findViewById(2131696384));
      String str = getIntent().getStringExtra("bannerUrl");
      if (!TextUtils.isEmpty(str)) {
        this.u.setController(com.freelxl.baselibrary.f.c.frescoController(str));
      }
      ((ImageView)findViewById(2131689492)).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("SIGNBACK".equals(RentHouseDetailActivity.a(RentHouseDetailActivity.this)))
          {
            paramAnonymousView = new Intent(RentHouseDetailActivity.this, MainActivity.class);
            RentHouseDetailActivity.this.startActivity(paramAnonymousView);
            return;
          }
          RentHouseDetailActivity.this.finish();
        }
      });
    }
  }
  
  protected String c()
  {
    return "rid=" + this.e + "&hid=" + this.f;
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void initWithData(RentHouseDetail paramRentHouseDetail)
  {
    if ((paramRentHouseDetail != null) && (!isFinishing()) && (this.d != null))
    {
      this.g = paramRentHouseDetail;
      Fragment localFragment = getSupportFragmentManager().findFragmentByTag("rent_content");
      if (localFragment != null) {
        getSupportFragmentManager().beginTransaction().remove(localFragment).commitAllowingStateLoss();
      }
      if (paramRentHouseDetail.getHouse_type() == 8)
      {
        paramRentHouseDetail = LuxuryHouseDetailFragment.getInstance(paramRentHouseDetail);
        new d(paramRentHouseDetail);
        a(paramRentHouseDetail);
        return;
      }
      paramRentHouseDetail = RentHouseDetailFragment.getInstance(paramRentHouseDetail);
      new d(paramRentHouseDetail);
      a(paramRentHouseDetail);
      return;
    }
    showError();
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void onBackClick()
  {
    if ("SIGNBACK".equals(this.r))
    {
      startActivity(new Intent(this, MainActivity.class));
      return;
    }
    finish();
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903439);
    this.s = getResources().getDisplayMetrics().widthPixels;
    a();
    String str = getIntent().getStringExtra("bannerUrl");
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null) && (getWindow().getEnterTransition() != null) && (!TextUtils.isEmpty(str)) && (paramBundle == null))
    {
      getWindow().getEnterTransition().setDuration(500L);
      getWindow().getEnterTransition().addListener(new Transition.TransitionListener()
      {
        public void onTransitionCancel(Transition paramAnonymousTransition) {}
        
        public void onTransitionEnd(Transition paramAnonymousTransition)
        {
          RentHouseDetailActivity.a(RentHouseDetailActivity.this, paramBundle);
        }
        
        public void onTransitionPause(Transition paramAnonymousTransition) {}
        
        public void onTransitionResume(Transition paramAnonymousTransition) {}
        
        public void onTransitionStart(Transition paramAnonymousTransition) {}
      });
      getWindow().setSharedElementEnterTransition(DraweeTransition.createTransitionSet(ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.CENTER_CROP));
      getWindow().setSharedElementReturnTransition(null);
      getWindow().setReturnTransition(null);
      return;
    }
    a(paramBundle);
  }
  
  protected void onDestroy()
  {
    this.d.detachView();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.v);
    super.onDestroy();
  }
  
  public void onEvent(String paramString)
  {
    HashMap localHashMap = new HashMap();
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      localHashMap.put("uid", localUserInfo.getUid());
    }
    localHashMap.put("houseCODE", this.f);
    a(paramString, localHashMap);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    finish();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onEvent(this, "app_RentHouseDetailActivity_0");
    if (this.d == null)
    {
      MobclickAgent.onEvent(this, "app_RentHouseDetailActivity_1");
      new com.ziroom.ziroomcustomer.findhouse.presenter.c(this.e, this.f, null, this);
      this.d.initData();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("rent_detail", this.g);
  }
  
  public void setPresenter(a.a parama)
  {
    this.d = parama;
  }
  
  public void showError()
  {
    if ((!isFinishing()) && (this.a.getVisibility() != 0))
    {
      this.a.setVisibility(0);
      ImageView localImageView1 = (ImageView)findViewById(2131690082);
      localImageView1.setImageResource(2130840094);
      ImageView localImageView2 = (ImageView)findViewById(2131695976);
      ((TextView)findViewById(2131690822)).setText("网络不佳，请点击图片进行刷新");
      localImageView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("SIGNBACK".equals(RentHouseDetailActivity.a(RentHouseDetailActivity.this)))
          {
            paramAnonymousView = new Intent(RentHouseDetailActivity.this, MainActivity.class);
            RentHouseDetailActivity.this.startActivity(paramAnonymousView);
            return;
          }
          RentHouseDetailActivity.this.finish();
        }
      });
      localImageView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RentHouseDetailActivity.b(RentHouseDetailActivity.this).initData();
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */