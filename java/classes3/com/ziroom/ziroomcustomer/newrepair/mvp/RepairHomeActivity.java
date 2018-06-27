package com.ziroom.ziroomcustomer.newrepair.mvp;

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
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairNewDetailActivity_New;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newrepair.b.s.d;
import com.ziroom.ziroomcustomer.newrepair.utils.c;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;

public class RepairHomeActivity
  extends BaseActivity
  implements a.b
{
  private RepairHomeActivity a;
  private Unbinder b;
  private a.a c;
  private BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        RepairHomeActivity.a(RepairHomeActivity.this).reAgainLogin();
      }
    }
  };
  @BindView(2131690276)
  ConvenientBanner mCbCenterBanner;
  @BindView(2131690275)
  CardView mCvCenter;
  @BindView(2131690273)
  CardView mCvCleaner;
  @BindView(2131690272)
  MyGridView mGvChoice;
  @BindView(2131690283)
  View mHead;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131690271)
  LinearLayout mLlChoiceTitle;
  @BindView(2131690277)
  LinearLayout mLlStoryTitle;
  @BindView(2131690278)
  RecyclerView mRvPraise;
  @BindView(2131690263)
  ObservableScrollView mSc;
  @BindView(2131690027)
  SimpleDraweeView mSdvBanner;
  @BindView(2131690287)
  SimpleDraweeView mSdvZiru;
  @BindView(2131690284)
  View mTitleLine;
  @BindView(2131690053)
  TextView mTvAddress;
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
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.a).registerReceiver(this.d, localIntentFilter);
  }
  
  private void b()
  {
    this.mIvBack.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairHomeActivity.this.finish();
      }
    });
    this.mSc.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f1 = 1.0F;
        float f2 = paramAnonymousInt2 / n.dip2px(RepairHomeActivity.b(RepairHomeActivity.this), 100.0F);
        if (f2 > 1.0F) {}
        for (;;)
        {
          RepairHomeActivity.this.mTitleLine.setAlpha(f1);
          RepairHomeActivity.this.mTvTitle.setAlpha(f1);
          RepairHomeActivity.this.mHead.setAlpha(f1);
          return;
          f1 = f2;
        }
      }
    });
    this.mSdvZiru.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.clice2Repair(RepairHomeActivity.b(RepairHomeActivity.this));
      }
    });
  }
  
  public MyGridView geGvChoice()
  {
    return this.mGvChoice;
  }
  
  public RecyclerView getRvPraise()
  {
    return this.mRvPraise;
  }
  
  public Context getViewContext()
  {
    return this.a;
  }
  
  public ConvenientBanner getmCbCenterBanner()
  {
    return this.mCbCenterBanner;
  }
  
  public CardView getmCvCenter()
  {
    return this.mCvCenter;
  }
  
  public LinearLayout getmLlChoiceTitle()
  {
    return this.mLlChoiceTitle;
  }
  
  public LinearLayout getmLlStoryTitle()
  {
    return this.mLlStoryTitle;
  }
  
  public SimpleDraweeView getmSdvBanner()
  {
    return this.mSdvBanner;
  }
  
  public SimpleDraweeView getmSdvZiru()
  {
    return this.mSdvZiru;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903448);
    this.b = ButterKnife.bind(this);
    this.a = this;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.d != null) {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    }
    this.b.unbind();
    this.c.detachView();
  }
  
  protected void onResume()
  {
    super.onResume();
    int i = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(this.a);
    ViewGroup.LayoutParams localLayoutParams = this.mSdvZiru.getLayoutParams();
    localLayoutParams.height = (i * 116 / 375);
    this.mSdvZiru.setLayoutParams(localLayoutParams);
  }
  
  public void setPresenter(a.a parama)
  {
    this.c = parama;
  }
  
  public void setServeOrder(final s.d paramd)
  {
    if (paramd == null)
    {
      this.mCvCleaner.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(paramd.getCategoryName()))
    {
      this.mCvCleaner.setVisibility(8);
      return;
    }
    this.mCvCleaner.setVisibility(0);
    this.mTvType.setText(paramd.getCategoryName());
    this.mTvStatus.setText(paramd.getOrderStatus());
    this.mTvTime.setText("·  " + paramd.getCreateDate());
    this.mTvAddress.setText("·  " + paramd.getAddress());
    this.mCvCleaner.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(RepairHomeActivity.b(RepairHomeActivity.this), RepairNewDetailActivity_New.class);
        paramAnonymousView.putExtra("serviceType", "付费维修");
        paramAnonymousView.putExtra("maintainOrderCode", paramd.getLogicCode());
        RepairHomeActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/mvp/RepairHomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */