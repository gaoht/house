package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class OwnerInvoiceSubmitSuccActivity_ViewBinding<T extends OwnerInvoiceSubmitSuccActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public OwnerInvoiceSubmitSuccActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.sdvResultIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691986, "field 'sdvResultIcon'", SimpleDraweeView.class));
    paramT.tvResultTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691987, "field 'tvResultTitle'", TextView.class));
    paramT.tvResultDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691988, "field 'tvResultDesc'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131692014, "field 'btnSeeDetail' and method 'onViewClicked'");
    paramT.btnSeeDetail = ((LinearLayout)Utils.castView(paramView, 2131692014, "field 'btnSeeDetail'", LinearLayout.class));
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    OwnerInvoiceSubmitSuccActivity localOwnerInvoiceSubmitSuccActivity = this.a;
    if (localOwnerInvoiceSubmitSuccActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerInvoiceSubmitSuccActivity.btnBack = null;
    localOwnerInvoiceSubmitSuccActivity.tvTitle = null;
    localOwnerInvoiceSubmitSuccActivity.sdvResultIcon = null;
    localOwnerInvoiceSubmitSuccActivity.tvResultTitle = null;
    localOwnerInvoiceSubmitSuccActivity.tvResultDesc = null;
    localOwnerInvoiceSubmitSuccActivity.btnSeeDetail = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceSubmitSuccActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */