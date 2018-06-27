package com.ziroom.ziroomcustomer.findhouse.view;

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

public class ResblockMapActivity_ViewBinding<T extends ResblockMapActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public ResblockMapActivity_ViewBinding(final T paramT, View paramView)
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
    ResblockMapActivity localResblockMapActivity = this.a;
    if (localResblockMapActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localResblockMapActivity.mHsvTabs = null;
    localResblockMapActivity.mIvBack = null;
    localResblockMapActivity.mTvTitle = null;
    localResblockMapActivity.mMapView = null;
    localResblockMapActivity.mTvPoiName = null;
    localResblockMapActivity.mTvPoiAddress = null;
    localResblockMapActivity.mTvPoiDistance = null;
    localResblockMapActivity.mClPoi = null;
    localResblockMapActivity.mIvSwitchMode = null;
    localResblockMapActivity.mLlSwitchMode = null;
    localResblockMapActivity.mLlTabs = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/ResblockMapActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */