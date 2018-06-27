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

public class ZryuBillDetailOptiActivity_ViewBinding<T extends ZryuBillDetailOptiActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuBillDetailOptiActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.lvBillDetailList = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692818, "field 'lvBillDetailList'", ListViewForScrollView.class));
    paramT.tvZryuBillDetailTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692819, "field 'tvZryuBillDetailTotal'", TextView.class));
    paramT.btnZryuOnlinePay = ((Button)Utils.findRequiredViewAsType(paramView, 2131692824, "field 'btnZryuOnlinePay'", Button.class));
    paramT.tvBillNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692814, "field 'tvBillNum'", TextView.class));
    paramT.tvContractNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692815, "field 'tvContractNum'", TextView.class));
    paramT.tvShouldPayTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692817, "field 'tvShouldPayTime'", TextView.class));
    paramT.tvThisTimePayPriceDynamic = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692821, "field 'tvThisTimePayPriceDynamic'", TextView.class));
    paramT.tvFavorableTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692826, "field 'tvFavorableTitle'", TextView.class));
    paramT.tvFavorablePrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692827, "field 'tvFavorablePrice'", TextView.class));
    paramT.seekbarThisTimePayPrice = ((SeekBar)Utils.findRequiredViewAsType(paramView, 2131692822, "field 'seekbarThisTimePayPrice'", SeekBar.class));
    paramT.etThisTimePayPrice = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692823, "field 'etThisTimePayPrice'", EditText.class));
    paramT.llSeekBarContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692820, "field 'llSeekBarContainer'", LinearLayout.class));
    paramT.ll_zryu_bill_detail_favorable = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692825, "field 'll_zryu_bill_detail_favorable'", LinearLayout.class));
    paramT.line_below_rentCoupon = Utils.findRequiredView(paramView, 2131692828, "field 'line_below_rentCoupon'");
  }
  
  public void unbind()
  {
    ZryuBillDetailOptiActivity localZryuBillDetailOptiActivity = this.a;
    if (localZryuBillDetailOptiActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuBillDetailOptiActivity.btnBack = null;
    localZryuBillDetailOptiActivity.tvTitle = null;
    localZryuBillDetailOptiActivity.lvBillDetailList = null;
    localZryuBillDetailOptiActivity.tvZryuBillDetailTotal = null;
    localZryuBillDetailOptiActivity.btnZryuOnlinePay = null;
    localZryuBillDetailOptiActivity.tvBillNum = null;
    localZryuBillDetailOptiActivity.tvContractNum = null;
    localZryuBillDetailOptiActivity.tvShouldPayTime = null;
    localZryuBillDetailOptiActivity.tvThisTimePayPriceDynamic = null;
    localZryuBillDetailOptiActivity.tvFavorableTitle = null;
    localZryuBillDetailOptiActivity.tvFavorablePrice = null;
    localZryuBillDetailOptiActivity.seekbarThisTimePayPrice = null;
    localZryuBillDetailOptiActivity.etThisTimePayPrice = null;
    localZryuBillDetailOptiActivity.llSeekBarContainer = null;
    localZryuBillDetailOptiActivity.ll_zryu_bill_detail_favorable = null;
    localZryuBillDetailOptiActivity.line_below_rentCoupon = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillDetailOptiActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */