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

public class FriendlyInvoiceListActivity_ViewBinding<T extends FriendlyInvoiceListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public FriendlyInvoiceListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    View localView = Utils.findRequiredView(paramView, 2131690621, "field 'tvBtnTitleRight' and method 'onViewClicked'");
    paramT.tvBtnTitleRight = ((TextView)Utils.castView(localView, 2131690621, "field 'tvBtnTitleRight'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690623, "field 'ivAdvice' and method 'onViewClicked'");
    paramT.ivAdvice = ((ImageView)Utils.castView(localView, 2131690623, "field 'ivAdvice'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack' and method 'onViewClicked'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689541, "field 'tvTitle' and method 'onViewClicked'");
    paramT.tvTitle = ((TextView)Utils.castView(localView, 2131689541, "field 'tvTitle'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.lvOwnerInvoices = ((ListView)Utils.findRequiredViewAsType(paramView, 2131690622, "field 'lvOwnerInvoices'", ListView.class));
    paramT.llTips = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689834, "field 'llTips'", LinearLayout.class));
  }
  
  public void unbind()
  {
    FriendlyInvoiceListActivity localFriendlyInvoiceListActivity = this.a;
    if (localFriendlyInvoiceListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localFriendlyInvoiceListActivity.llContentContainer = null;
    localFriendlyInvoiceListActivity.stubError = null;
    localFriendlyInvoiceListActivity.tvBtnTitleRight = null;
    localFriendlyInvoiceListActivity.ivAdvice = null;
    localFriendlyInvoiceListActivity.btnBack = null;
    localFriendlyInvoiceListActivity.tvTitle = null;
    localFriendlyInvoiceListActivity.lvOwnerInvoices = null;
    localFriendlyInvoiceListActivity.llTips = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */