package com.ziroom.ziroomcustomer.minsu.activity;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;

public class MinsuHouseMapActivity_ViewBinding<T extends MinsuHouseMapActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MinsuHouseMapActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mHsvTabs = ((HorizontalScrollView)Utils.findRequiredViewAsType(paramView, 2131696445, "field 'mHsvTabs'", HorizontalScrollView.class));
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'mTvTitle'", TextView.class));
    paramT.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131690823, "field 'mMapView'", MapView.class));
    paramT.mTvPoiName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696448, "field 'mTvPoiName'", TextView.class));
    paramT.mTvPoiAddress = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690544, "field 'mTvPoiAddress'", TextView.class));
    paramT.mTvPoiDistance = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696449, "field 'mTvPoiDistance'", TextView.class));
    paramT.mClPoi = ((ConstraintLayout)Utils.findRequiredViewAsType(paramView, 2131696447, "field 'mClPoi'", ConstraintLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691585, "field 'mIvSwitchMode' and method 'onViewClicked'");
    paramT.mIvSwitchMode = ((ImageView)Utils.castView(localView, 2131691585, "field 'mIvSwitchMode'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mLlSwitchMode = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691584, "field 'mLlSwitchMode'", LinearLayout.class));
    paramT.mLlTabs = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696446, "field 'mLlTabs'", LinearLayout.class));
  }
  
  public void unbind()
  {
    MinsuHouseMapActivity localMinsuHouseMapActivity = this.a;
    if (localMinsuHouseMapActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuHouseMapActivity.mHsvTabs = null;
    localMinsuHouseMapActivity.mIvBack = null;
    localMinsuHouseMapActivity.mTvTitle = null;
    localMinsuHouseMapActivity.mMapView = null;
    localMinsuHouseMapActivity.mTvPoiName = null;
    localMinsuHouseMapActivity.mTvPoiAddress = null;
    localMinsuHouseMapActivity.mTvPoiDistance = null;
    localMinsuHouseMapActivity.mClPoi = null;
    localMinsuHouseMapActivity.mIvSwitchMode = null;
    localMinsuHouseMapActivity.mLlSwitchMode = null;
    localMinsuHouseMapActivity.mLlTabs = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseMapActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */