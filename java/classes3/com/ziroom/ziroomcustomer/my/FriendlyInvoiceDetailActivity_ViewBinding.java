package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class FriendlyInvoiceDetailActivity_ViewBinding<T extends FriendlyInvoiceDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public FriendlyInvoiceDetailActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.tvInvoiceDetailMinute = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696248, "field 'tvInvoiceDetailMinute'", TextView.class));
    paramT.tvInvoiceDetailSecond = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696249, "field 'tvInvoiceDetailSecond'", TextView.class));
    paramT.tvInvoiceDetailTax = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696250, "field 'tvInvoiceDetailTax'", TextView.class));
    paramT.llInvoiceDetailTimeCounter = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696247, "field 'llInvoiceDetailTimeCounter'", LinearLayout.class));
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
    paramT.tvInvoiceReceiverTips = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690611, "field 'tvInvoiceReceiverTips'", TextView.class));
    paramT.llPayButtons = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690617, "field 'llPayButtons'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690618, "field 'tvInvoiceCancel' and method 'onViewClicked'");
    paramT.tvInvoiceCancel = ((TextView)Utils.castView(localView, 2131690618, "field 'tvInvoiceCancel'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690619, "field 'tvTaxPay' and method 'onViewClicked'");
    paramT.tvTaxPay = ((TextView)Utils.castView(localView, 2131690619, "field 'tvTaxPay'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    paramT.tvDownloadUrl = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690615, "field 'tvDownloadUrl'", TextView.class));
    paramT.llDownloadUrlContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690614, "field 'llDownloadUrlContainer'", LinearLayout.class));
  }
  
  public void unbind()
  {
    FriendlyInvoiceDetailActivity localFriendlyInvoiceDetailActivity = this.a;
    if (localFriendlyInvoiceDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localFriendlyInvoiceDetailActivity.btnBack = null;
    localFriendlyInvoiceDetailActivity.tvTitle = null;
    localFriendlyInvoiceDetailActivity.tvInvoiceDetailDesc = null;
    localFriendlyInvoiceDetailActivity.tvInvoiceDetailMinute = null;
    localFriendlyInvoiceDetailActivity.tvInvoiceDetailSecond = null;
    localFriendlyInvoiceDetailActivity.tvInvoiceDetailTax = null;
    localFriendlyInvoiceDetailActivity.llInvoiceDetailTimeCounter = null;
    localFriendlyInvoiceDetailActivity.llInvoiceInfoList = null;
    localFriendlyInvoiceDetailActivity.tvCancelOpen = null;
    localFriendlyInvoiceDetailActivity.tvDownload = null;
    localFriendlyInvoiceDetailActivity.llInvoicePersonalInfo = null;
    localFriendlyInvoiceDetailActivity.tvInvoiceReceiverTips = null;
    localFriendlyInvoiceDetailActivity.llPayButtons = null;
    localFriendlyInvoiceDetailActivity.tvInvoiceCancel = null;
    localFriendlyInvoiceDetailActivity.tvTaxPay = null;
    localFriendlyInvoiceDetailActivity.llContentContainer = null;
    localFriendlyInvoiceDetailActivity.stubError = null;
    localFriendlyInvoiceDetailActivity.tvDownloadUrl = null;
    localFriendlyInvoiceDetailActivity.llDownloadUrlContainer = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */