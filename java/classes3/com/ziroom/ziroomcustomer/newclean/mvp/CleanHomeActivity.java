package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView.a;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralOrderDetailActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo.DocumentMo;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodGeneralDetailActivity;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.ac;

public class CleanHomeActivity
  extends BaseActivity
  implements a.b
{
  private Unbinder a;
  private CleanHomeActivity b;
  private a.a c;
  private BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        CleanHomeActivity.a(CleanHomeActivity.this).reAgainLogin();
      }
    }
  };
  @BindView(2131690264)
  ConvenientBanner mCbBanner;
  @BindView(2131690276)
  ConvenientBanner mCbCenterBanner;
  @BindView(2131690275)
  CardView mCvCenterBanner;
  @BindView(2131690273)
  CardView mCvCleaner;
  @BindView(2131690272)
  MyGridView mGvChoice;
  @BindView(2131690270)
  MyGridView mGvClean;
  @BindView(2131690283)
  View mHead;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690285)
  SimpleDraweeView mIvInvite;
  @BindView(2131689849)
  ImageView mIvType;
  @BindView(2131690271)
  LinearLayout mLlChoiceTitle;
  @BindView(2131690280)
  LinearLayout mLlCleanerTitle;
  @BindView(2131690281)
  ListViewForScrollView mLvCleaner;
  @BindView(2131690265)
  RelativeLayout mRlHot;
  @BindView(2131690278)
  RecyclerView mRvPraise;
  @BindView(2131690263)
  CustomScrollView mSc;
  @BindView(2131690284)
  View mTitleLine;
  @BindView(2131690053)
  TextView mTvAddress;
  @BindView(2131690268)
  TextView mTvHotGo;
  @BindView(2131690267)
  TextView mTvHotTitle;
  @BindView(2131689822)
  TextView mTvStatus;
  @BindView(2131689852)
  TextView mTvTime;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131689848)
  TextView mTvType;
  
  private void a()
  {
    new b(this);
    this.c.start();
    j.requestFocus(findViewById(2131689541));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.b).registerReceiver(this.d, localIntentFilter);
  }
  
  private void b()
  {
    this.mIvBack.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanHomeActivity.this.finish();
      }
    });
    this.mSc.setOnScrollChangedCallback(new CustomScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f1 = 1.0F;
        float f2 = paramAnonymousInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(CleanHomeActivity.b(CleanHomeActivity.this), 100.0F);
        if (f2 > 1.0F) {}
        for (;;)
        {
          CleanHomeActivity.this.mTitleLine.setAlpha(f1);
          CleanHomeActivity.this.mTvTitle.setAlpha(f1);
          CleanHomeActivity.this.mHead.setAlpha(f1);
          return;
          f1 = f2;
        }
      }
      
      public void scrollEnd()
      {
        CleanHomeActivity.this.mIvInvite.setAlpha(1.0F);
      }
      
      public void scrollStart()
      {
        CleanHomeActivity.this.mIvInvite.setAlpha(0.3F);
      }
    });
  }
  
  public MyGridView geGvChoice()
  {
    return this.mGvChoice;
  }
  
  public CardView getCardCenter()
  {
    return this.mCvCenterBanner;
  }
  
  public MyGridView getGvClean()
  {
    return this.mGvClean;
  }
  
  public SimpleDraweeView getIvInvite()
  {
    return this.mIvInvite;
  }
  
  public ListViewForScrollView getLvCleaner()
  {
    return this.mLvCleaner;
  }
  
  public RecyclerView getRvPraise()
  {
    return this.mRvPraise;
  }
  
  public Context getViewContext()
  {
    return this.b;
  }
  
  public ConvenientBanner getmCbBanner()
  {
    return this.mCbBanner;
  }
  
  public ConvenientBanner getmCbCenterBanner()
  {
    return this.mCbCenterBanner;
  }
  
  public LinearLayout getmLlChoiceTitle()
  {
    return this.mLlChoiceTitle;
  }
  
  public LinearLayout getmLlCleanerTitle()
  {
    return this.mLlCleanerTitle;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903144);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.d != null) {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    }
    this.c.detachView();
  }
  
  protected void onResume()
  {
    super.onResume();
    int i = ac.getScreenWidth(this.b);
    ViewGroup.LayoutParams localLayoutParams = this.mCbBanner.getLayoutParams();
    localLayoutParams.height = (i * 200 / 375);
    this.mCbBanner.setLayoutParams(localLayoutParams);
    localLayoutParams = this.mCvCenterBanner.getLayoutParams();
    localLayoutParams.height = (i * 110 / 375);
    this.mCvCenterBanner.setLayoutParams(localLayoutParams);
  }
  
  public void setCardTip(CleanUesrIsNewMo paramCleanUesrIsNewMo)
  {
    if (paramCleanUesrIsNewMo != null)
    {
      paramCleanUesrIsNewMo = paramCleanUesrIsNewMo.getDocument().getText();
      if (!TextUtils.isEmpty(paramCleanUesrIsNewMo))
      {
        this.mRlHot.setVisibility(0);
        this.mTvHotTitle.setText(paramCleanUesrIsNewMo);
        this.mTvHotGo.setText("立即购买");
        this.mTvHotGo.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(CleanHomeActivity.b(CleanHomeActivity.this), CleanStoredCardBuyActivity.class);
            CleanHomeActivity.this.startActivity(paramAnonymousView);
          }
        });
      }
    }
    else
    {
      return;
    }
    this.mRlHot.setVisibility(8);
  }
  
  public void setPresenter(a.a parama)
  {
    this.c = parama;
  }
  
  public void setServeOrder(final com.ziroom.ziroomcustomer.newclean.d.n paramn)
  {
    if (paramn == null)
    {
      this.mCvCleaner.setVisibility(8);
      return;
    }
    this.mCvCleaner.setVisibility(0);
    this.mTvType.setText(paramn.getProductName());
    this.mTvStatus.setText(paramn.getOrderStatusName());
    this.mTvTime.setText("·  " + paramn.getAppointmentTimeStr());
    this.mTvAddress.setText("·  " + paramn.getOrderAddress());
    this.mCvCleaner.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (TextUtils.isEmpty(paramn.getCyclePlanOrderCode()))
        {
          paramAnonymousView = new Intent(CleanHomeActivity.b(CleanHomeActivity.this), GeneralOrderDetailActivity.class);
          paramAnonymousView.putExtra("cleanId", paramn.getUserOrderCode());
          paramAnonymousView.putExtra("serviceInfoId", paramn.getProductCode());
          paramAnonymousView.putExtra("serviceInfoName", paramn.getProductName());
          CleanHomeActivity.this.startActivity(paramAnonymousView);
          return;
        }
        paramAnonymousView = new Intent(CleanHomeActivity.b(CleanHomeActivity.this), PeriodGeneralDetailActivity.class);
        paramAnonymousView.putExtra("cleanId", paramn.getUserOrderCode());
        paramAnonymousView.putExtra("serviceInfoId", paramn.getProductCode());
        paramAnonymousView.putExtra("serviceInfoName", paramn.getProductName());
        CleanHomeActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanHomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */