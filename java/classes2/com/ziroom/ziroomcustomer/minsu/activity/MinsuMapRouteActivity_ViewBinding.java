package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.baidu.mapapi.map.MapView;
import com.google.android.flexbox.FlexboxLayout;

public class MinsuMapRouteActivity_ViewBinding<T extends MinsuMapRouteActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public MinsuMapRouteActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mMapView = ((MapView)Utils.findRequiredViewAsType(paramView, 2131690823, "field 'mMapView'", MapView.class));
    View localView = Utils.findRequiredView(paramView, 2131691586, "field 'mIvBackUp' and method 'onViewClicked'");
    paramT.mIvBackUp = ((ImageView)Utils.castView(localView, 2131691586, "field 'mIvBackUp'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'mIvBack' and method 'onViewClicked'");
    paramT.mIvBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'mIvBack'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691587, "field 'mIvSwitchAddress' and method 'onViewClicked'");
    paramT.mIvSwitchAddress = ((ImageView)Utils.castView(localView, 2131691587, "field 'mIvSwitchAddress'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691589, "field 'mTvRouteStart' and method 'onViewClicked'");
    paramT.mTvRouteStart = ((TextView)Utils.castView(localView, 2131691589, "field 'mTvRouteStart'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691590, "field 'mTvRouteEnd' and method 'onViewClicked'");
    paramT.mTvRouteEnd = ((TextView)Utils.castView(localView, 2131691590, "field 'mTvRouteEnd'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.mLlSearch = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691588, "field 'mLlSearch'", LinearLayout.class));
    paramT.mRlHeader = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690902, "field 'mRlHeader'", RelativeLayout.class));
    paramT.mLlHistory = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690323, "field 'mLlHistory'", LinearLayout.class));
    paramT.mLvHistory = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689827, "field 'mLvHistory'", ListView.class));
    paramT.mRbTransit = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690818, "field 'mRbTransit'", RadioButton.class));
    paramT.mRbDrive = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690819, "field 'mRbDrive'", RadioButton.class));
    paramT.mRbBike = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690820, "field 'mRbBike'", RadioButton.class));
    paramT.mRbWalk = ((RadioButton)Utils.findRequiredViewAsType(paramView, 2131690821, "field 'mRbWalk'", RadioButton.class));
    paramT.mLvRoute = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691594, "field 'mLvRoute'", ListView.class));
    paramT.mRgType = ((RadioGroup)Utils.findRequiredViewAsType(paramView, 2131690817, "field 'mRgType'", RadioGroup.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690822, "field 'mTvEmpty'", TextView.class));
    paramT.mFlButtons = ((FlexboxLayout)Utils.findRequiredViewAsType(paramView, 2131691592, "field 'mFlButtons'", FlexboxLayout.class));
    paramT.mBottomSheet = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691591, "field 'mBottomSheet'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    MinsuMapRouteActivity localMinsuMapRouteActivity = this.a;
    if (localMinsuMapRouteActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuMapRouteActivity.mMapView = null;
    localMinsuMapRouteActivity.mIvBackUp = null;
    localMinsuMapRouteActivity.mIvBack = null;
    localMinsuMapRouteActivity.mIvSwitchAddress = null;
    localMinsuMapRouteActivity.mTvRouteStart = null;
    localMinsuMapRouteActivity.mTvRouteEnd = null;
    localMinsuMapRouteActivity.mLlSearch = null;
    localMinsuMapRouteActivity.mRlHeader = null;
    localMinsuMapRouteActivity.mLlHistory = null;
    localMinsuMapRouteActivity.mLvHistory = null;
    localMinsuMapRouteActivity.mRbTransit = null;
    localMinsuMapRouteActivity.mRbDrive = null;
    localMinsuMapRouteActivity.mRbBike = null;
    localMinsuMapRouteActivity.mRbWalk = null;
    localMinsuMapRouteActivity.mLvRoute = null;
    localMinsuMapRouteActivity.mRgType = null;
    localMinsuMapRouteActivity.mTvEmpty = null;
    localMinsuMapRouteActivity.mFlButtons = null;
    localMinsuMapRouteActivity.mBottomSheet = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuMapRouteActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */