package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class OwnerInvoiceListActivity_ViewBinding<T extends OwnerInvoiceListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public OwnerInvoiceListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack', method 'onViewClicked', and method 'onViewClicked'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
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
    paramT.tvInvoiceDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692005, "field 'tvInvoiceDesc'", TextView.class));
    paramT.lvOwnerInvoices = ((ListView)Utils.findRequiredViewAsType(paramView, 2131690622, "field 'lvOwnerInvoices'", ListView.class));
  }
  
  public void unbind()
  {
    OwnerInvoiceListActivity localOwnerInvoiceListActivity = this.a;
    if (localOwnerInvoiceListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerInvoiceListActivity.llContentContainer = null;
    localOwnerInvoiceListActivity.stubError = null;
    localOwnerInvoiceListActivity.btnBack = null;
    localOwnerInvoiceListActivity.tvTitle = null;
    localOwnerInvoiceListActivity.tvInvoiceDesc = null;
    localOwnerInvoiceListActivity.lvOwnerInvoices = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */