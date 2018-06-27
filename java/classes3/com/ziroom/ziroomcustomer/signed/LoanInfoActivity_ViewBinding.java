package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class LoanInfoActivity_ViewBinding<T extends LoanInfoActivity>
  implements Unbinder
{
  protected T a;
  
  public LoanInfoActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.mTvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689822, "field 'mTvStatus'", TextView.class));
    paramT.mTvStatusDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691103, "field 'mTvStatusDesc'", TextView.class));
    paramT.mLlStatus = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691102, "field 'mLlStatus'", LinearLayout.class));
    paramT.mBtnSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
    paramT.mTvLender = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691104, "field 'mTvLender'", TextView.class));
    paramT.mTvAmount = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691105, "field 'mTvAmount'", TextView.class));
    paramT.mTvRepayment = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691106, "field 'mTvRepayment'", TextView.class));
    paramT.mTvFee = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691107, "field 'mTvFee'", TextView.class));
    paramT.mTvVoucher = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691110, "field 'mTvVoucher'", TextView.class));
    paramT.mCbAgreeContract = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131691111, "field 'mCbAgreeContract'", CheckBox.class));
    paramT.mVMasking = Utils.findRequiredView(paramView, 2131691113, "field 'mVMasking'");
    paramT.mVDividerVoucher = Utils.findRequiredView(paramView, 2131691108, "field 'mVDividerVoucher'");
    paramT.mTvVoucherLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691109, "field 'mTvVoucherLabel'", TextView.class));
    paramT.mTvAgreeContract = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691112, "field 'mTvAgreeContract'", TextView.class));
  }
  
  public void unbind()
  {
    LoanInfoActivity localLoanInfoActivity = this.a;
    if (localLoanInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLoanInfoActivity.mBztb = null;
    localLoanInfoActivity.mTvStatus = null;
    localLoanInfoActivity.mTvStatusDesc = null;
    localLoanInfoActivity.mLlStatus = null;
    localLoanInfoActivity.mBtnSubmit = null;
    localLoanInfoActivity.mTvLender = null;
    localLoanInfoActivity.mTvAmount = null;
    localLoanInfoActivity.mTvRepayment = null;
    localLoanInfoActivity.mTvFee = null;
    localLoanInfoActivity.mTvVoucher = null;
    localLoanInfoActivity.mCbAgreeContract = null;
    localLoanInfoActivity.mVMasking = null;
    localLoanInfoActivity.mVDividerVoucher = null;
    localLoanInfoActivity.mTvVoucherLabel = null;
    localLoanInfoActivity.mTvAgreeContract = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/LoanInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */