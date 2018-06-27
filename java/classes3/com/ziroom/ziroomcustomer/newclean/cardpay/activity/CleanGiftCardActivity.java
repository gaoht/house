package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newclean.fragment.CleanGiftBuyCardFragment;
import com.ziroom.ziroomcustomer.newclean.fragment.CleanGiftCardManageFragment;
import com.ziroom.ziroomcustomer.payment.a;
import java.lang.reflect.Field;

public class CleanGiftCardActivity
  extends BaseActivity
{
  public Boolean a = Boolean.valueOf(false);
  private String[] b = { "选购礼品卡", "管理礼品卡" };
  private com.ziroom.ziroomcustomer.newclean.cardpay.adapter.g c;
  private Context d;
  private BroadcastReceiver e = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getIntExtra("code", -1) == 1))
      {
        paramAnonymousIntent.getStringExtra("payType");
        ((CleanGiftBuyCardFragment)CleanGiftCardActivity.a(CleanGiftCardActivity.this).getItem(0)).initData();
        CleanGiftCardActivity.this.upDateView();
      }
      while ((paramAnonymousIntent == null) || (paramAnonymousIntent.getStringExtra("message") == null)) {
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(CleanGiftCardActivity.b(CleanGiftCardActivity.this), paramAnonymousIntent.getStringExtra("message"));
    }
  };
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131689768)
  RelativeLayout rlBaseTitle;
  @BindView(2131690261)
  TabLayout tabs;
  @BindView(2131690262)
  ViewPager viewpage;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903143);
    ButterKnife.bind(this);
    this.d = this;
    this.c = new com.ziroom.ziroomcustomer.newclean.cardpay.adapter.g(getSupportFragmentManager(), this.b);
    this.viewpage.setAdapter(this.c);
    this.tabs.setupWithViewPager(this.viewpage);
    this.viewpage.setOffscreenPageLimit(2);
    setIndicator(this, this.tabs, 60, 60);
    registerReceiver(this.e, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    if (!getIntent().getBooleanExtra("isbuy", true)) {
      this.viewpage.setCurrentItem(1);
    }
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.e);
    super.onDestroy();
  }
  
  @OnClick({2131689492})
  public void onViewClicked()
  {
    finish();
  }
  
  public void setIndicator(Context paramContext, TabLayout paramTabLayout, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramTabLayout.getClass();
    try
    {
      localObject1 = ((Class)localObject1).getDeclaredField("mTabStrip");
      ((Field)localObject1).setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        paramTabLayout = (LinearLayout)((Field)localObject1).get(paramTabLayout);
        localObject1 = new DisplayMetrics();
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        int i = (int)(((DisplayMetrics)localObject1).density * paramInt1);
        paramInt2 = (int)(((DisplayMetrics)localObject1).density * paramInt2);
        paramInt1 = 0;
        while (paramInt1 < paramTabLayout.getChildCount())
        {
          paramContext = paramTabLayout.getChildAt(paramInt1);
          paramContext.setPadding(0, 0, 0, 0);
          localObject1 = new LinearLayout.LayoutParams(0, -1, 1.0F);
          ((LinearLayout.LayoutParams)localObject1).leftMargin = i;
          ((LinearLayout.LayoutParams)localObject1).rightMargin = paramInt2;
          paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramContext.invalidate();
          paramInt1 += 1;
          continue;
          localNoSuchFieldException = localNoSuchFieldException;
          localNoSuchFieldException.printStackTrace();
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException paramTabLayout)
      {
        for (;;)
        {
          paramTabLayout.printStackTrace();
          paramTabLayout = null;
        }
      }
    }
  }
  
  public void upDateView()
  {
    ((CleanGiftCardManageFragment)this.c.getItem(1)).reLoadData();
    this.viewpage.setCurrentItem(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanGiftCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */