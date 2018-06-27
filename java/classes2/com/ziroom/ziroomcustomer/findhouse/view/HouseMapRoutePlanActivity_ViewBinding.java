package com.ziroom.ziroomcustomer.findhouse.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout;

public class HouseMapRoutePlanActivity_ViewBinding<T extends HouseMapRoutePlanActivity>
  implements Unbinder
{
  protected T a;
  
  public HouseMapRoutePlanActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131690814, "field 'mMapView'", MapView.class));
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'mIvBack'", ImageView.class));
    paramT.mVBg = Utils.findRequiredView(paramView, 2131690815, "field 'mVBg'");
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mRbTransit = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690818, "field 'mRbTransit'", RadioButton.class));
    paramT.mRbDrive = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690819, "field 'mRbDrive'", RadioButton.class));
    paramT.mRbBike = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690820, "field 'mRbBike'", RadioButton.class));
    paramT.mRbWalk = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690821, "field 'mRbWalk'", RadioButton.class));
    paramT.mRgType = ((RadioGroup)Utils.findRequiredViewAsType(paramView, 2131690817, "field 'mRgType'", RadioGroup.class));
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mRlList = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690816, "field 'mRlList'", RelativeLayout.class));
    paramT.mVdlRoot = ((VerticalDrawerLayout)Utils.findRequiredViewAsType(paramView, 2131690813, "field 'mVdlRoot'", VerticalDrawerLayout.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690822, "field 'mTvEmpty'", TextView.class));
  }
  
  public void unbind()
  {
    HouseMapRoutePlanActivity localHouseMapRoutePlanActivity = this.a;
    if (localHouseMapRoutePlanActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHouseMapRoutePlanActivity.mMapView = null;
    localHouseMapRoutePlanActivity.mIvBack = null;
    localHouseMapRoutePlanActivity.mVBg = null;
    localHouseMapRoutePlanActivity.mTvName = null;
    localHouseMapRoutePlanActivity.mRbTransit = null;
    localHouseMapRoutePlanActivity.mRbDrive = null;
    localHouseMapRoutePlanActivity.mRbBike = null;
    localHouseMapRoutePlanActivity.mRbWalk = null;
    localHouseMapRoutePlanActivity.mRgType = null;
    localHouseMapRoutePlanActivity.mLv = null;
    localHouseMapRoutePlanActivity.mRlList = null;
    localHouseMapRoutePlanActivity.mVdlRoot = null;
    localHouseMapRoutePlanActivity.mTvEmpty = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseMapRoutePlanActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */