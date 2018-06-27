package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.widget.VerticalDrawerLayout;

public class ZryuMapActivity_ViewBinding<T extends ZryuMapActivity>
  implements Unbinder
{
  protected T a;
  
  public ZryuMapActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mVdlRoot = ((VerticalDrawerLayout)Utils.findRequiredViewAsType(paramView, 2131690813, "field 'mVdlRoot'", VerticalDrawerLayout.class));
    paramT.mTvCity = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692497, "field 'mTvCity'", TextView.class));
    paramT.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131692902, "field 'mMapView'", MapView.class));
    paramT.mVBg = Utils.findRequiredView(paramView, 2131690815, "field 'mVBg'");
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
  }
  
  public void unbind()
  {
    ZryuMapActivity localZryuMapActivity = this.a;
    if (localZryuMapActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuMapActivity.mVdlRoot = null;
    localZryuMapActivity.mTvCity = null;
    localZryuMapActivity.mMapView = null;
    localZryuMapActivity.mVBg = null;
    localZryuMapActivity.mLv = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuMapActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */