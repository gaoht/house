package com.ziroom.ziroomcustomer.newrepair.mvp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class RepairHomeActivity_ViewBinding<T extends RepairHomeActivity>
  implements Unbinder
{
  protected T a;
  
  public RepairHomeActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mSc = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690263, "field 'mSc'", ObservableScrollView.class));
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'mIvBack'", ImageView.class));
    paramT.mSdvBanner = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690027, "field 'mSdvBanner'", SimpleDraweeView.class));
    paramT.mSdvZiru = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690287, "field 'mSdvZiru'", SimpleDraweeView.class));
    paramT.mLlChoiceTitle = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690271, "field 'mLlChoiceTitle'", LinearLayout.class));
    paramT.mGvChoice = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131690272, "field 'mGvChoice'", MyGridView.class));
    paramT.mCvCleaner = ((CardView)Utils.findRequiredViewAsType(paramView, 2131690273, "field 'mCvCleaner'", CardView.class));
    paramT.mTvType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689848, "field 'mTvType'", TextView.class));
    paramT.mTvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689822, "field 'mTvStatus'", TextView.class));
    paramT.mTvTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689852, "field 'mTvTime'", TextView.class));
    paramT.mTvAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690053, "field 'mTvAddress'", TextView.class));
    paramT.mLlStoryTitle = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690277, "field 'mLlStoryTitle'", LinearLayout.class));
    paramT.mRvPraise = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131690278, "field 'mRvPraise'", RecyclerView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mTitleLine = Utils.findRequiredView(paramView, 2131690284, "field 'mTitleLine'");
    paramT.mHead = Utils.findRequiredView(paramView, 2131690283, "field 'mHead'");
    paramT.mCvCenter = ((CardView)Utils.findRequiredViewAsType(paramView, 2131690275, "field 'mCvCenter'", CardView.class));
    paramT.mCbCenterBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690276, "field 'mCbCenterBanner'", ConvenientBanner.class));
  }
  
  public void unbind()
  {
    RepairHomeActivity localRepairHomeActivity = this.a;
    if (localRepairHomeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRepairHomeActivity.mSc = null;
    localRepairHomeActivity.mIvBack = null;
    localRepairHomeActivity.mSdvBanner = null;
    localRepairHomeActivity.mSdvZiru = null;
    localRepairHomeActivity.mLlChoiceTitle = null;
    localRepairHomeActivity.mGvChoice = null;
    localRepairHomeActivity.mCvCleaner = null;
    localRepairHomeActivity.mTvType = null;
    localRepairHomeActivity.mTvStatus = null;
    localRepairHomeActivity.mTvTime = null;
    localRepairHomeActivity.mTvAddress = null;
    localRepairHomeActivity.mLlStoryTitle = null;
    localRepairHomeActivity.mRvPraise = null;
    localRepairHomeActivity.mTvTitle = null;
    localRepairHomeActivity.mTitleLine = null;
    localRepairHomeActivity.mHead = null;
    localRepairHomeActivity.mCvCenter = null;
    localRepairHomeActivity.mCbCenterBanner = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/mvp/RepairHomeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */