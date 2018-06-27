package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class OwnerInvoicePriceListActivity_ViewBinding<T extends OwnerInvoicePriceListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public OwnerInvoicePriceListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.ownerInvoiceName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692012, "field 'ownerInvoiceName'", TextView.class));
    paramT.tvPriceTotal = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692013, "field 'tvPriceTotal'", TextView.class));
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack' and method 'onViewClicked'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689541, "field 'tvTitle' and method 'onViewClicked'");
    paramT.tvTitle = ((TextView)Utils.castView(localView, 2131689541, "field 'tvTitle'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.lvOwnerInvoices = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692011, "field 'lvOwnerInvoices'", ListViewForScrollView.class));
  }
  
  public void unbind()
  {
    OwnerInvoicePriceListActivity localOwnerInvoicePriceListActivity = this.a;
    if (localOwnerInvoicePriceListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerInvoicePriceListActivity.ownerInvoiceName = null;
    localOwnerInvoicePriceListActivity.tvPriceTotal = null;
    localOwnerInvoicePriceListActivity.llContentContainer = null;
    localOwnerInvoicePriceListActivity.stubError = null;
    localOwnerInvoicePriceListActivity.btnBack = null;
    localOwnerInvoicePriceListActivity.tvTitle = null;
    localOwnerInvoicePriceListActivity.lvOwnerInvoices = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoicePriceListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */