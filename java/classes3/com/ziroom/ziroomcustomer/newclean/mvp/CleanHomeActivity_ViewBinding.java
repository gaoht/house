package com.ziroom.ziroomcustomer.newclean.mvp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public class CleanHomeActivity_ViewBinding<T extends CleanHomeActivity>
  implements Unbinder
{
  protected T a;
  
  public CleanHomeActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mSc = ((CustomScrollView)Utils.findRequiredViewAsType(paramView, 2131690263, "field 'mSc'", CustomScrollView.class));
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'mIvBack'", ImageView.class));
    paramT.mCbBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690264, "field 'mCbBanner'", ConvenientBanner.class));
    paramT.mRlHot = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690265, "field 'mRlHot'", RelativeLayout.class));
    paramT.mTvHotTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690267, "field 'mTvHotTitle'", TextView.class));
    paramT.mTvHotGo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690268, "field 'mTvHotGo'", TextView.class));
    paramT.mGvClean = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131690270, "field 'mGvClean'", MyGridView.class));
    paramT.mGvChoice = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131690272, "field 'mGvChoice'", MyGridView.class));
    paramT.mCvCleaner = ((CardView)Utils.findRequiredViewAsType(paramView, 2131690273, "field 'mCvCleaner'", CardView.class));
    paramT.mIvType = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689849, "field 'mIvType'", ImageView.class));
    paramT.mTvType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689848, "field 'mTvType'", TextView.class));
    paramT.mTvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689822, "field 'mTvStatus'", TextView.class));
    paramT.mTvTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689852, "field 'mTvTime'", TextView.class));
    paramT.mTvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'mTvAddress'", TextView.class));
    paramT.mCbCenterBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690276, "field 'mCbCenterBanner'", ConvenientBanner.class));
    paramT.mRvPraise = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131690278, "field 'mRvPraise'", RecyclerView.class));
    paramT.mLvCleaner = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131690281, "field 'mLvCleaner'", ListViewForScrollView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTitleLine = Utils.findRequiredView(paramView, 2131690284, "field 'mTitleLine'");
    paramT.mHead = Utils.findRequiredView(paramView, 2131690283, "field 'mHead'");
    paramT.mIvInvite = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690285, "field 'mIvInvite'", SimpleDraweeView.class));
    paramT.mCvCenterBanner = ((CardView)Utils.findRequiredViewAsType(paramView, 2131690275, "field 'mCvCenterBanner'", CardView.class));
    paramT.mLlCleanerTitle = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690280, "field 'mLlCleanerTitle'", LinearLayout.class));
    paramT.mLlChoiceTitle = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690271, "field 'mLlChoiceTitle'", LinearLayout.class));
  }
  
  public void unbind()
  {
    CleanHomeActivity localCleanHomeActivity = this.a;
    if (localCleanHomeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCleanHomeActivity.mSc = null;
    localCleanHomeActivity.mIvBack = null;
    localCleanHomeActivity.mCbBanner = null;
    localCleanHomeActivity.mRlHot = null;
    localCleanHomeActivity.mTvHotTitle = null;
    localCleanHomeActivity.mTvHotGo = null;
    localCleanHomeActivity.mGvClean = null;
    localCleanHomeActivity.mGvChoice = null;
    localCleanHomeActivity.mCvCleaner = null;
    localCleanHomeActivity.mIvType = null;
    localCleanHomeActivity.mTvType = null;
    localCleanHomeActivity.mTvStatus = null;
    localCleanHomeActivity.mTvTime = null;
    localCleanHomeActivity.mTvAddress = null;
    localCleanHomeActivity.mCbCenterBanner = null;
    localCleanHomeActivity.mRvPraise = null;
    localCleanHomeActivity.mLvCleaner = null;
    localCleanHomeActivity.mTvTitle = null;
    localCleanHomeActivity.mTitleLine = null;
    localCleanHomeActivity.mHead = null;
    localCleanHomeActivity.mIvInvite = null;
    localCleanHomeActivity.mCvCenterBanner = null;
    localCleanHomeActivity.mLlCleanerTitle = null;
    localCleanHomeActivity.mLlChoiceTitle = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanHomeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */