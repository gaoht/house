package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.XListView;

public class SignerCouponActivity_ViewBinding<T extends SignerCouponActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public SignerCouponActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'iv_back' and method 'onClick'");
    paramT.iv_back = ((ImageView)Utils.castView(localView, 2131689492, "field 'iv_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.xl_type = ((XListView)Utils.findRequiredViewAsType(paramView, 2131690260, "field 'xl_type'", XListView.class));
    paramT.et_fill_coupon = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690254, "field 'et_fill_coupon'", EditText.class));
    localView = Utils.findRequiredView(paramView, 2131690255, "field 'btn_exchange_conpon' and method 'onClick'");
    paramT.btn_exchange_conpon = ((Button)Utils.castView(localView, 2131690255, "field 'btn_exchange_conpon'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_coupon_point = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690259, "field 'tv_coupon_point'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131690256, "field 'iv_coupon_delete' and method 'onClick'");
    paramT.iv_coupon_delete = ((ImageView)Utils.castView(paramView, 2131690256, "field 'iv_coupon_delete'", ImageView.class));
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    SignerCouponActivity localSignerCouponActivity = this.a;
    if (localSignerCouponActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSignerCouponActivity.iv_back = null;
    localSignerCouponActivity.xl_type = null;
    localSignerCouponActivity.et_fill_coupon = null;
    localSignerCouponActivity.btn_exchange_conpon = null;
    localSignerCouponActivity.tv_coupon_point = null;
    localSignerCouponActivity.iv_coupon_delete = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerCouponActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */