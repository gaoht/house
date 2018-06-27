package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class ZryuBillDetailActivity_ViewBinding<T extends ZryuBillDetailActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuBillDetailActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.lvBillDetailList = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692818, "field 'lvBillDetailList'", ListViewForScrollView.class));
    paramT.tvZryuBillDetailTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692819, "field 'tvZryuBillDetailTotal'", TextView.class));
    paramT.btnZryuOnlinePay = ((Button)Utils.findRequiredViewAsType(paramView, 2131692824, "field 'btnZryuOnlinePay'", Button.class));
    paramT.tvBillNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692814, "field 'tvBillNum'", TextView.class));
    paramT.tvContractNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692815, "field 'tvContractNum'", TextView.class));
    paramT.tvHadPaiedPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692816, "field 'tvHadPaiedPrice'", TextView.class));
    paramT.tvShouldPayTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692817, "field 'tvShouldPayTime'", TextView.class));
    paramT.tvThisTimePayPriceDynamic = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692821, "field 'tvThisTimePayPriceDynamic'", TextView.class));
    paramT.seekbarThisTimePayPrice = ((SeekBar)Utils.findRequiredViewAsType(paramView, 2131692822, "field 'seekbarThisTimePayPrice'", SeekBar.class));
    paramT.etThisTimePayPrice = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692823, "field 'etThisTimePayPrice'", EditText.class));
    paramT.llSeekBarContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692820, "field 'llSeekBarContainer'", LinearLayout.class));
  }
  
  public void unbind()
  {
    ZryuBillDetailActivity localZryuBillDetailActivity = this.a;
    if (localZryuBillDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuBillDetailActivity.btnBack = null;
    localZryuBillDetailActivity.tvTitle = null;
    localZryuBillDetailActivity.lvBillDetailList = null;
    localZryuBillDetailActivity.tvZryuBillDetailTotal = null;
    localZryuBillDetailActivity.btnZryuOnlinePay = null;
    localZryuBillDetailActivity.tvBillNum = null;
    localZryuBillDetailActivity.tvContractNum = null;
    localZryuBillDetailActivity.tvHadPaiedPrice = null;
    localZryuBillDetailActivity.tvShouldPayTime = null;
    localZryuBillDetailActivity.tvThisTimePayPriceDynamic = null;
    localZryuBillDetailActivity.seekbarThisTimePayPrice = null;
    localZryuBillDetailActivity.etThisTimePayPrice = null;
    localZryuBillDetailActivity.llSeekBarContainer = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */