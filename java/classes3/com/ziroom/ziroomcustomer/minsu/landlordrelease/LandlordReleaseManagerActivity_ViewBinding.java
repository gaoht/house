package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class LandlordReleaseManagerActivity_ViewBinding<T extends LandlordReleaseManagerActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public LandlordReleaseManagerActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    View localView = Utils.findRequiredView(paramView, 2131691098, "field 'sdv' and method 'onViewClicked'");
    paramT.sdv = ((SimpleDraweeView)Utils.castView(localView, 2131691098, "field 'sdv'", SimpleDraweeView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvStatus = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689822, "field 'tvStatus'", TextView.class));
    paramT.listview = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131690955, "field 'listview'", ListViewForScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.btnArea = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691099, "field 'btnArea'", FrameLayout.class));
    paramT.btn_bottom_area = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691100, "field 'btn_bottom_area'", FrameLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691101, "field 'btnBottom' and method 'onViewClicked'");
    paramT.btnBottom = ((Button)Utils.castView(localView, 2131691101, "field 'btnBottom'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.content = ((ViewGroup)Utils.findRequiredViewAsType(paramView, 2131691097, "field 'content'", ViewGroup.class));
    paramT.scrollview = ((ViewGroup)Utils.findRequiredViewAsType(paramView, 2131689506, "field 'scrollview'", ViewGroup.class));
  }
  
  public void unbind()
  {
    LandlordReleaseManagerActivity localLandlordReleaseManagerActivity = this.a;
    if (localLandlordReleaseManagerActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseManagerActivity.commonTitle = null;
    localLandlordReleaseManagerActivity.sdv = null;
    localLandlordReleaseManagerActivity.tvStatus = null;
    localLandlordReleaseManagerActivity.listview = null;
    localLandlordReleaseManagerActivity.btn = null;
    localLandlordReleaseManagerActivity.btnArea = null;
    localLandlordReleaseManagerActivity.btn_bottom_area = null;
    localLandlordReleaseManagerActivity.btnBottom = null;
    localLandlordReleaseManagerActivity.content = null;
    localLandlordReleaseManagerActivity.scrollview = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseManagerActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */