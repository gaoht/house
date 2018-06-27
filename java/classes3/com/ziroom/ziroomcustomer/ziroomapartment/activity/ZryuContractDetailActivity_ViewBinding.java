package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZryuContractDetailActivity_ViewBinding<T extends ZryuContractDetailActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuContractDetailActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.btnCall = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690459, "field 'btnCall'", ImageView.class));
    paramT.topLine = Utils.findRequiredView(paramView, 2131690426, "field 'topLine'");
    paramT.ivIvZryuContractDetail = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131692843, "field 'ivIvZryuContractDetail'", SimpleDraweeView.class));
    paramT.ivZryuContractDetailShadow = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692844, "field 'ivZryuContractDetailShadow'", ImageView.class));
    paramT.flZryuContractDetailImgContainer = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131692842, "field 'flZryuContractDetailImgContainer'", FrameLayout.class));
    paramT.tvZryuContractDetailHouseName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692845, "field 'tvZryuContractDetailHouseName'", TextView.class));
    paramT.tvZryuContractDetailStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692846, "field 'tvZryuContractDetailStatus'", TextView.class));
    paramT.tvZryuContractDetailTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692847, "field 'tvZryuContractDetailTime'", TextView.class));
    paramT.tvZryuContractDetailRoomName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692848, "field 'tvZryuContractDetailRoomName'", TextView.class));
    paramT.tvZryuContractDetailPrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692849, "field 'tvZryuContractDetailPrice'", TextView.class));
    paramT.tvContractNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692815, "field 'tvContractNum'", TextView.class));
    paramT.tvContractAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692850, "field 'tvContractAddress'", TextView.class));
    paramT.llIconContractAddress = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692851, "field 'llIconContractAddress'", LinearLayout.class));
    paramT.tvPayWayInfo = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692852, "field 'tvPayWayInfo'", TextView.class));
    paramT.llCheckAllBills = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692855, "field 'llCheckAllBills'", LinearLayout.class));
    paramT.llCheckContractContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692853, "field 'llCheckContractContainer'", LinearLayout.class));
  }
  
  public void unbind()
  {
    ZryuContractDetailActivity localZryuContractDetailActivity = this.a;
    if (localZryuContractDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuContractDetailActivity.btnBack = null;
    localZryuContractDetailActivity.tvTitle = null;
    localZryuContractDetailActivity.btnCall = null;
    localZryuContractDetailActivity.topLine = null;
    localZryuContractDetailActivity.ivIvZryuContractDetail = null;
    localZryuContractDetailActivity.ivZryuContractDetailShadow = null;
    localZryuContractDetailActivity.flZryuContractDetailImgContainer = null;
    localZryuContractDetailActivity.tvZryuContractDetailHouseName = null;
    localZryuContractDetailActivity.tvZryuContractDetailStatus = null;
    localZryuContractDetailActivity.tvZryuContractDetailTime = null;
    localZryuContractDetailActivity.tvZryuContractDetailRoomName = null;
    localZryuContractDetailActivity.tvZryuContractDetailPrice = null;
    localZryuContractDetailActivity.tvContractNum = null;
    localZryuContractDetailActivity.tvContractAddress = null;
    localZryuContractDetailActivity.llIconContractAddress = null;
    localZryuContractDetailActivity.tvPayWayInfo = null;
    localZryuContractDetailActivity.llCheckAllBills = null;
    localZryuContractDetailActivity.llCheckContractContainer = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuContractDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */