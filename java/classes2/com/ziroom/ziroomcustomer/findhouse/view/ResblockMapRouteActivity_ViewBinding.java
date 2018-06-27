package com.ziroom.ziroomcustomer.findhouse.view;

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

public class ResblockMapRouteActivity_ViewBinding<T extends ResblockMapRouteActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public ResblockMapRouteActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.mLlShortcut = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692232, "field 'mLlShortcut'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131693164, "field 'mTvCompanyAddress' and method 'onViewClicked'");
    paramT.mTvCompanyAddress = ((TextView)Utils.castView(localView, 2131693164, "field 'mTvCompanyAddress'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696450, "field 'mTvCompanySetting' and method 'onViewClicked'");
    paramT.mTvCompanySetting = ((TextView)Utils.castView(localView, 2131696450, "field 'mTvCompanySetting'", TextView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696451, "field 'mLlCurrentAddress' and method 'onViewClicked'");
    paramT.mLlCurrentAddress = ((LinearLayout)Utils.castView(localView, 2131696451, "field 'mLlCurrentAddress'", LinearLayout.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
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
    ResblockMapRouteActivity localResblockMapRouteActivity = this.a;
    if (localResblockMapRouteActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localResblockMapRouteActivity.mMapView = null;
    localResblockMapRouteActivity.mIvBackUp = null;
    localResblockMapRouteActivity.mIvBack = null;
    localResblockMapRouteActivity.mIvSwitchAddress = null;
    localResblockMapRouteActivity.mTvRouteStart = null;
    localResblockMapRouteActivity.mTvRouteEnd = null;
    localResblockMapRouteActivity.mLlSearch = null;
    localResblockMapRouteActivity.mRlHeader = null;
    localResblockMapRouteActivity.mLlHistory = null;
    localResblockMapRouteActivity.mLvHistory = null;
    localResblockMapRouteActivity.mLlShortcut = null;
    localResblockMapRouteActivity.mTvCompanyAddress = null;
    localResblockMapRouteActivity.mTvCompanySetting = null;
    localResblockMapRouteActivity.mLlCurrentAddress = null;
    localResblockMapRouteActivity.mRbTransit = null;
    localResblockMapRouteActivity.mRbDrive = null;
    localResblockMapRouteActivity.mRbBike = null;
    localResblockMapRouteActivity.mRbWalk = null;
    localResblockMapRouteActivity.mLvRoute = null;
    localResblockMapRouteActivity.mRgType = null;
    localResblockMapRouteActivity.mTvEmpty = null;
    localResblockMapRouteActivity.mFlButtons = null;
    localResblockMapRouteActivity.mBottomSheet = null;
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
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/ResblockMapRouteActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */