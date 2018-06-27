package com.ziroom.ziroomcustomer.newclean.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;

public class ForCleaningActivity_ViewBinding<T extends ForCleaningActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public ForCleaningActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvContractAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690032, "field 'mTvContractAddress'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690591, "field 'mTvChangeContract' and method 'onClick'");
    paramT.mTvChangeContract = ((TextView)Utils.castView(localView, 2131690591, "field 'mTvChangeContract'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mSdvAdatar = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690070, "field 'mSdvAdatar'", SimpleDraweeView.class));
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mTvAgePlace = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690593, "field 'mTvAgePlace'", TextView.class));
    paramT.mRsStar = ((RatingStar)Utils.findRequiredViewAsType(paramView, 2131690595, "field 'mRsStar'", RatingStar.class));
    paramT.mTvScore = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690059, "field 'mTvScore'", TextView.class));
    paramT.mTvTimes = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690596, "field 'mTvTimes'", TextView.class));
    paramT.mRlIndicator = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690603, "field 'mRlIndicator'", RelativeLayout.class));
    paramT.mVp = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131690606, "field 'mVp'", ViewPager.class));
    paramT.mIv70 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690604, "field 'mIv70'", ImageView.class));
    paramT.mIv60 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690605, "field 'mIv60'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131690048, "field 'mTvOrder' and method 'onClick'");
    paramT.mTvOrder = ((TextView)Utils.castView(localView, 2131690048, "field 'mTvOrder'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690601, "field 'mTvCleaner' and method 'onClick'");
    paramT.mTvCleaner = ((TextView)Utils.castView(localView, 2131690601, "field 'mTvCleaner'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690602, "field 'mTvEval' and method 'onClick'");
    paramT.mTvEval = ((TextView)Utils.castView(localView, 2131690602, "field 'mTvEval'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mIvShow = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690598, "field 'mIvShow'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131690599, "field 'mRLBedroom' and method 'onClick'");
    paramT.mRLBedroom = ((RelativeLayout)Utils.castView(localView, 2131690599, "field 'mRLBedroom'", RelativeLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mRlCleaner = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690274, "field 'mRlCleaner'", RelativeLayout.class));
    paramT.mLlPager = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690600, "field 'mLlPager'", LinearLayout.class));
    paramT.mFl = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690607, "field 'mFl'", FrameLayout.class));
    localView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690597, "method 'onClick'");
    this.h = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    ForCleaningActivity localForCleaningActivity = this.a;
    if (localForCleaningActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForCleaningActivity.mTvContractAddress = null;
    localForCleaningActivity.mTvChangeContract = null;
    localForCleaningActivity.mSdvAdatar = null;
    localForCleaningActivity.mTvName = null;
    localForCleaningActivity.mTvAgePlace = null;
    localForCleaningActivity.mRsStar = null;
    localForCleaningActivity.mTvScore = null;
    localForCleaningActivity.mTvTimes = null;
    localForCleaningActivity.mRlIndicator = null;
    localForCleaningActivity.mVp = null;
    localForCleaningActivity.mIv70 = null;
    localForCleaningActivity.mIv60 = null;
    localForCleaningActivity.mTvOrder = null;
    localForCleaningActivity.mTvCleaner = null;
    localForCleaningActivity.mTvEval = null;
    localForCleaningActivity.mIvShow = null;
    localForCleaningActivity.mRLBedroom = null;
    localForCleaningActivity.mRlCleaner = null;
    localForCleaningActivity.mLlPager = null;
    localForCleaningActivity.mFl = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/ForCleaningActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */