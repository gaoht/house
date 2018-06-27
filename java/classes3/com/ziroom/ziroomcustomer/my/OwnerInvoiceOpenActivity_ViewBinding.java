package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;

public class OwnerInvoiceOpenActivity_ViewBinding<T extends OwnerInvoiceOpenActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  
  public OwnerInvoiceOpenActivity_ViewBinding(final T paramT, View paramView)
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
    localView = Utils.findRequiredView(paramView, 2131690624, "field 'tvTopRight' and method 'onViewClicked'");
    paramT.tvTopRight = ((TextView)Utils.castView(localView, 2131690624, "field 'tvTopRight'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvInvoiceOpenDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692006, "field 'tvInvoiceOpenDesc'", TextView.class));
    paramT.tvInvoiceTypeDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692007, "field 'tvInvoiceTypeDesc'", TextView.class));
    paramT.flInvoiceType = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131690631, "field 'flInvoiceType'", FlowLayout.class));
    paramT.tvInvoiceDetailDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690609, "field 'tvInvoiceDetailDesc'", TextView.class));
    paramT.cbCompany = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690636, "field 'cbCompany'", ImageView.class));
    paramT.cbPersonal = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690638, "field 'cbPersonal'", ImageView.class));
    paramT.tvInvoiceTopName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690639, "field 'tvInvoiceTopName'", TextView.class));
    paramT.tvInvoiceContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692008, "field 'tvInvoiceContent'", TextView.class));
    paramT.tvInvoicePrice = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690644, "field 'tvInvoicePrice'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692009, "field 'llSeePriceDetail' and method 'onViewClicked'");
    paramT.llSeePriceDetail = ((LinearLayout)Utils.castView(localView, 2131692009, "field 'llSeePriceDetail'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.etInvoicePhoneNum = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692010, "field 'etInvoicePhoneNum'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131689997, "field 'tvSubmit' and method 'onViewClicked'");
    paramT.tvSubmit = ((TextView)Utils.castView(localView, 2131689997, "field 'tvSubmit'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.etInvoiceIdentityNum = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690641, "field 'etInvoiceIdentityNum'", EditText.class));
    paramT.llInvoiceIdentityContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690640, "field 'llInvoiceIdentityContainer'", LinearLayout.class));
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.stubError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    localView = Utils.findRequiredView(paramView, 2131690635, "field 'llCompany' and method 'onViewClicked'");
    paramT.llCompany = ((LinearLayout)Utils.castView(localView, 2131690635, "field 'llCompany'", LinearLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690637, "field 'llPersonal' and method 'onViewClicked'");
    paramT.llPersonal = ((LinearLayout)Utils.castView(paramView, 2131690637, "field 'llPersonal'", LinearLayout.class));
    this.g = paramView;
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
    OwnerInvoiceOpenActivity localOwnerInvoiceOpenActivity = this.a;
    if (localOwnerInvoiceOpenActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerInvoiceOpenActivity.btnBack = null;
    localOwnerInvoiceOpenActivity.tvTitle = null;
    localOwnerInvoiceOpenActivity.tvTopRight = null;
    localOwnerInvoiceOpenActivity.tvInvoiceOpenDesc = null;
    localOwnerInvoiceOpenActivity.tvInvoiceTypeDesc = null;
    localOwnerInvoiceOpenActivity.flInvoiceType = null;
    localOwnerInvoiceOpenActivity.tvInvoiceDetailDesc = null;
    localOwnerInvoiceOpenActivity.cbCompany = null;
    localOwnerInvoiceOpenActivity.cbPersonal = null;
    localOwnerInvoiceOpenActivity.tvInvoiceTopName = null;
    localOwnerInvoiceOpenActivity.tvInvoiceContent = null;
    localOwnerInvoiceOpenActivity.tvInvoicePrice = null;
    localOwnerInvoiceOpenActivity.llSeePriceDetail = null;
    localOwnerInvoiceOpenActivity.etInvoicePhoneNum = null;
    localOwnerInvoiceOpenActivity.tvSubmit = null;
    localOwnerInvoiceOpenActivity.etInvoiceIdentityNum = null;
    localOwnerInvoiceOpenActivity.llInvoiceIdentityContainer = null;
    localOwnerInvoiceOpenActivity.llContentContainer = null;
    localOwnerInvoiceOpenActivity.stubError = null;
    localOwnerInvoiceOpenActivity.llCompany = null;
    localOwnerInvoiceOpenActivity.llPersonal = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceOpenActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */