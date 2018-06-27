package com.ziroom.ziroomcustomer.sublet.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class LeaseSubletInfoActivity_ViewBinding<T extends LeaseSubletInfoActivity>
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
  
  public LeaseSubletInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691914, "field 'iv_lease_back' and method 'onClic'");
    paramT.iv_lease_back = ((ImageView)Utils.castView(localView, 2131691914, "field 'iv_lease_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_sublet_info_phone = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696685, "field 'lease_sublet_info_phone'", TextView.class));
    paramT.lease_sublet_info_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696684, "field 'lease_sublet_info_name'", TextView.class));
    paramT.signed_image_shade = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131692416, "field 'signed_image_shade'", SimpleDraweeView.class));
    paramT.lease_sublet_checkin_date = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696683, "field 'lease_sublet_checkin_date'", TextView.class));
    paramT.lease_sublet_srequest_date = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696686, "field 'lease_sublet_srequest_date'", TextView.class));
    paramT.lease_sublet_estimate_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696680, "field 'lease_sublet_estimate_price'", TextView.class));
    paramT.tv_date_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696682, "field 'tv_date_title'", TextView.class));
    paramT.lease_way = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696619, "field 'lease_way'", TextView.class));
    paramT.signed_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692417, "field 'signed_address'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696678, "field 'lease_sublet_why' and method 'onClic'");
    paramT.lease_sublet_why = ((TextView)Utils.castView(localView, 2131696678, "field 'lease_sublet_why'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_sublet_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696677, "field 'lease_sublet_status'", TextView.class));
    paramT.lease_sublet_status_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131696676, "field 'lease_sublet_status_img'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131696675, "field 'lease_sublet_status_ll' and method 'onClic'");
    paramT.lease_sublet_status_ll = ((LinearLayout)Utils.castView(localView, 2131696675, "field 'lease_sublet_status_ll'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_sublet_viewgroup = ((ViewGroup)Utils.findRequiredViewAsType(paramView, 2131696673, "field 'lease_sublet_viewgroup'", ViewGroup.class));
    localView = Utils.findRequiredView(paramView, 2131692414, "field 'to_see_rl' and method 'onClic'");
    paramT.to_see_rl = ((RelativeLayout)Utils.castView(localView, 2131692414, "field 'to_see_rl'", RelativeLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696669, "method 'onClic'");
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696670, "method 'onClic'");
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696667, "method 'onClic'");
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131696665, "method 'onClic'");
    this.i = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    LeaseSubletInfoActivity localLeaseSubletInfoActivity = this.a;
    if (localLeaseSubletInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLeaseSubletInfoActivity.iv_lease_back = null;
    localLeaseSubletInfoActivity.lease_sublet_info_phone = null;
    localLeaseSubletInfoActivity.lease_sublet_info_name = null;
    localLeaseSubletInfoActivity.signed_image_shade = null;
    localLeaseSubletInfoActivity.lease_sublet_checkin_date = null;
    localLeaseSubletInfoActivity.lease_sublet_srequest_date = null;
    localLeaseSubletInfoActivity.lease_sublet_estimate_price = null;
    localLeaseSubletInfoActivity.tv_date_title = null;
    localLeaseSubletInfoActivity.lease_way = null;
    localLeaseSubletInfoActivity.signed_address = null;
    localLeaseSubletInfoActivity.lease_sublet_why = null;
    localLeaseSubletInfoActivity.lease_sublet_status = null;
    localLeaseSubletInfoActivity.lease_sublet_status_img = null;
    localLeaseSubletInfoActivity.lease_sublet_status_ll = null;
    localLeaseSubletInfoActivity.lease_sublet_viewgroup = null;
    localLeaseSubletInfoActivity.to_see_rl = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */