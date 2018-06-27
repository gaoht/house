package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class OwnerDeliveryDetailActivity_ViewBinding<T extends OwnerDeliveryDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public OwnerDeliveryDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691990, "field 'tvContactKeeper' and method 'onViewClicked'");
    paramT.tvContactKeeper = ((TextView)Utils.castView(localView, 2131691990, "field 'tvContactKeeper'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.owner_delivery_detail_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692004, "field 'owner_delivery_detail_list'", ListViewForScrollView.class));
    paramT.owner_delivery_detail_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692003, "field 'owner_delivery_detail_time'", TextView.class));
  }
  
  public void unbind()
  {
    OwnerDeliveryDetailActivity localOwnerDeliveryDetailActivity = this.a;
    if (localOwnerDeliveryDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerDeliveryDetailActivity.ivBack = null;
    localOwnerDeliveryDetailActivity.tvContactKeeper = null;
    localOwnerDeliveryDetailActivity.llContentContainer = null;
    localOwnerDeliveryDetailActivity.owner_delivery_detail_list = null;
    localOwnerDeliveryDetailActivity.owner_delivery_detail_time = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerDeliveryDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */