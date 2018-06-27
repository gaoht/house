package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class OwnerInvoiceDetailActivity_ViewBinding<T extends OwnerInvoiceDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public OwnerInvoiceDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
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
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvInvoiceDetailDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690609, "field 'tvInvoiceDetailDesc'", TextView.class));
    paramT.llInvoiceInfoList = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690610, "field 'llInvoiceInfoList'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690613, "field 'tvCancelOpen' and method 'onViewClicked'");
    paramT.tvCancelOpen = ((TextView)Utils.castView(localView, 2131690613, "field 'tvCancelOpen'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690616, "field 'tvDownload' and method 'onViewClicked'");
    paramT.tvDownload = ((TextView)Utils.castView(localView, 2131690616, "field 'tvDownload'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llInvoicePersonalInfo = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690612, "field 'llInvoicePersonalInfo'", LinearLayout.class));
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    paramT.tvDownloadUrl = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690615, "field 'tvDownloadUrl'", TextView.class));
    paramT.llDownloadUrlContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690614, "field 'llDownloadUrlContainer'", LinearLayout.class));
  }
  
  public void unbind()
  {
    OwnerInvoiceDetailActivity localOwnerInvoiceDetailActivity = this.a;
    if (localOwnerInvoiceDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerInvoiceDetailActivity.btnBack = null;
    localOwnerInvoiceDetailActivity.tvTitle = null;
    localOwnerInvoiceDetailActivity.tvInvoiceDetailDesc = null;
    localOwnerInvoiceDetailActivity.llInvoiceInfoList = null;
    localOwnerInvoiceDetailActivity.tvCancelOpen = null;
    localOwnerInvoiceDetailActivity.tvDownload = null;
    localOwnerInvoiceDetailActivity.llInvoicePersonalInfo = null;
    localOwnerInvoiceDetailActivity.llContentContainer = null;
    localOwnerInvoiceDetailActivity.stubError = null;
    localOwnerInvoiceDetailActivity.tvDownloadUrl = null;
    localOwnerInvoiceDetailActivity.llDownloadUrlContainer = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */