package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class MovingVanActivity_ViewBinding<T extends MovingVanActivity>
  implements Unbinder
{
  protected T a;
  
  public MovingVanActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLetTime = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691796, "field 'mLetTime'", LabeledEditText.class));
    paramT.mLetOutAdd = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691797, "field 'mLetOutAdd'", LabeledEditText.class));
    paramT.mLetInAdd = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691798, "field 'mLetInAdd'", LabeledEditText.class));
    paramT.mLetPhone = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131689983, "field 'mLetPhone'", LabeledEditText.class));
    paramT.mLetBulky = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691800, "field 'mLetBulky'", LabeledEditText.class));
    paramT.mLetMovingGoods = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691802, "field 'mLetMovingGoods'", LabeledEditText.class));
    paramT.mLetRequirement = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691804, "field 'mLetRequirement'", LabeledEditText.class));
    paramT.mLetCoupon = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691805, "field 'mLetCoupon'", LabeledEditText.class));
    paramT.mTvPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689912, "field 'mTvPrice'", TextView.class));
    paramT.mIvPrice = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691807, "field 'mIvPrice'", ImageView.class));
    paramT.mBtnSubmit = ((Button)Utils.findRequiredViewAsType(paramView, 2131689816, "field 'mBtnSubmit'", Button.class));
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mTvTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691809, "field 'mTvTotal'", TextView.class));
    paramT.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131690814, "field 'mMapView'", MapView.class));
    paramT.mLlEstimate = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691808, "field 'mLlEstimate'", LinearLayout.class));
    paramT.mAllLine = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691810, "field 'mAllLine'", TextView.class));
    paramT.img_end_other = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691726, "field 'img_end_other'", ImageView.class));
    paramT.iv_line = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691723, "field 'iv_line'", ImageView.class));
    paramT.img_end = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691725, "field 'img_end'", ImageView.class));
    paramT.let_out_add_lift = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691728, "field 'let_out_add_lift'", LabeledEditText.class));
    paramT.view_out_add_lift = Utils.findRequiredView(paramView, 2131691729, "field 'view_out_add_lift'");
    paramT.view_in_add_lift = Utils.findRequiredView(paramView, 2131691731, "field 'view_in_add_lift'");
    paramT.let_in_add_lift = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131691732, "field 'let_in_add_lift'", LabeledEditText.class));
    paramT.img_start = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691724, "field 'img_start'", ImageView.class));
    paramT.line_moving_goods = Utils.findRequiredView(paramView, 2131691803, "field 'line_moving_goods'");
    paramT.iv_close = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690588, "field 'iv_close'", ImageView.class));
    paramT.mRlBulkyTip = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691801, "field 'mRlBulkyTip'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    MovingVanActivity localMovingVanActivity = this.a;
    if (localMovingVanActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMovingVanActivity.mLetTime = null;
    localMovingVanActivity.mLetOutAdd = null;
    localMovingVanActivity.mLetInAdd = null;
    localMovingVanActivity.mLetPhone = null;
    localMovingVanActivity.mLetBulky = null;
    localMovingVanActivity.mLetMovingGoods = null;
    localMovingVanActivity.mLetRequirement = null;
    localMovingVanActivity.mLetCoupon = null;
    localMovingVanActivity.mTvPrice = null;
    localMovingVanActivity.mIvPrice = null;
    localMovingVanActivity.mBtnSubmit = null;
    localMovingVanActivity.mLv = null;
    localMovingVanActivity.mTvTotal = null;
    localMovingVanActivity.mMapView = null;
    localMovingVanActivity.mLlEstimate = null;
    localMovingVanActivity.mAllLine = null;
    localMovingVanActivity.img_end_other = null;
    localMovingVanActivity.iv_line = null;
    localMovingVanActivity.img_end = null;
    localMovingVanActivity.let_out_add_lift = null;
    localMovingVanActivity.view_out_add_lift = null;
    localMovingVanActivity.view_in_add_lift = null;
    localMovingVanActivity.let_in_add_lift = null;
    localMovingVanActivity.img_start = null;
    localMovingVanActivity.line_moving_goods = null;
    localMovingVanActivity.iv_close = null;
    localMovingVanActivity.mRlBulkyTip = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */