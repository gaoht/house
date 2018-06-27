package com.ziroom.ziroomcustomer.findhouse.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout;

public class HouseMapSearchActivity_ViewBinding<T extends HouseMapSearchActivity>
  implements Unbinder
{
  protected T a;
  
  public HouseMapSearchActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mRlCommuteType = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690834, "field 'mRlCommuteType'", RelativeLayout.class));
    paramT.mRgCommuteType = ((RadioGroup)Utils.findRequiredViewAsType(paramView, 2131690835, "field 'mRgCommuteType'", RadioGroup.class));
    paramT.mRbCommuteTypeTransit = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690836, "field 'mRbCommuteTypeTransit'", RadioButton.class));
    paramT.mRbCommuteTypeDriving = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690837, "field 'mRbCommuteTypeDriving'", RadioButton.class));
    paramT.mRbCommuteTypeBiking = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690838, "field 'mRbCommuteTypeBiking'", RadioButton.class));
    paramT.mRbCommuteTypeWalking = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690839, "field 'mRbCommuteTypeWalking'", RadioButton.class));
    paramT.mIvLocationPoint = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690845, "field 'mIvLocationPoint'", ImageView.class));
    paramT.mTvName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'mTvName'", TextView.class));
    paramT.mIvMyLocation = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690824, "field 'mIvMyLocation'", ImageView.class));
    paramT.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131690823, "field 'mMapView'", MapView.class));
    paramT.ivBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'ivBack'", ImageView.class));
    paramT.tvSearch = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690826, "field 'tvSearch'", TextView.class));
    paramT.tvSearchCommute = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690830, "field 'tvSearchCommute'", TextView.class));
    paramT.tvFilter = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690827, "field 'tvFilter'", TextView.class));
    paramT.llTitle = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690825, "field 'llTitle'", LinearLayout.class));
    paramT.llTitleCommute = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690828, "field 'llTitleCommute'", LinearLayout.class));
    paramT.mVBg = Utils.findRequiredView(paramView, 2131690815, "field 'mVBg'");
    paramT.mLv = ((HouseListXListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", HouseListXListView.class));
    paramT.mRlList = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690816, "field 'mRlList'", RelativeLayout.class));
    paramT.mVdlRoot = ((VerticalDrawerLayout)Utils.findRequiredViewAsType(paramView, 2131690813, "field 'mVdlRoot'", VerticalDrawerLayout.class));
    paramT.mTvCommute = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690842, "field 'mTvCommute'", TextView.class));
    paramT.mTvCommuteLabel = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690846, "field 'mTvCommuteLabel'", TextView.class));
    paramT.mRlCommutePin = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690843, "field 'mRlCommutePin'", RelativeLayout.class));
    paramT.mSbCommute = ((SeekBar)Utils.findRequiredViewAsType(paramView, 2131690840, "field 'mSbCommute'", SeekBar.class));
    paramT.mLlSbSection = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690841, "field 'mLlSbSection'", LinearLayout.class));
    paramT.mLlCommute = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690847, "field 'mLlCommute'", LinearLayout.class));
    paramT.mTvDataTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690850, "field 'mTvDataTip'", TextView.class));
    paramT.mLlTitleCommuteAddressConfirmed = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690831, "field 'mLlTitleCommuteAddressConfirmed'", LinearLayout.class));
    paramT.mTvCommuteMsg = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690848, "field 'mTvCommuteMsg'", TextView.class));
    paramT.mIvCommuteType = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690849, "field 'mIvCommuteType'", ImageView.class));
  }
  
  public void unbind()
  {
    HouseMapSearchActivity localHouseMapSearchActivity = this.a;
    if (localHouseMapSearchActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHouseMapSearchActivity.mRlCommuteType = null;
    localHouseMapSearchActivity.mRgCommuteType = null;
    localHouseMapSearchActivity.mRbCommuteTypeTransit = null;
    localHouseMapSearchActivity.mRbCommuteTypeDriving = null;
    localHouseMapSearchActivity.mRbCommuteTypeBiking = null;
    localHouseMapSearchActivity.mRbCommuteTypeWalking = null;
    localHouseMapSearchActivity.mIvLocationPoint = null;
    localHouseMapSearchActivity.mTvName = null;
    localHouseMapSearchActivity.mIvMyLocation = null;
    localHouseMapSearchActivity.mMapView = null;
    localHouseMapSearchActivity.ivBack = null;
    localHouseMapSearchActivity.tvSearch = null;
    localHouseMapSearchActivity.tvSearchCommute = null;
    localHouseMapSearchActivity.tvFilter = null;
    localHouseMapSearchActivity.llTitle = null;
    localHouseMapSearchActivity.llTitleCommute = null;
    localHouseMapSearchActivity.mVBg = null;
    localHouseMapSearchActivity.mLv = null;
    localHouseMapSearchActivity.mRlList = null;
    localHouseMapSearchActivity.mVdlRoot = null;
    localHouseMapSearchActivity.mTvCommute = null;
    localHouseMapSearchActivity.mTvCommuteLabel = null;
    localHouseMapSearchActivity.mRlCommutePin = null;
    localHouseMapSearchActivity.mSbCommute = null;
    localHouseMapSearchActivity.mLlSbSection = null;
    localHouseMapSearchActivity.mLlCommute = null;
    localHouseMapSearchActivity.mTvDataTip = null;
    localHouseMapSearchActivity.mLlTitleCommuteAddressConfirmed = null;
    localHouseMapSearchActivity.mTvCommuteMsg = null;
    localHouseMapSearchActivity.mIvCommuteType = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseMapSearchActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */