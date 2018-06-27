package com.ziroom.ziroomcustomer.payment.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class CouponCardsActivity_ViewBinding<T extends CouponCardsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public CouponCardsActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.listCards = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692063, "field 'listCards'", ListView.class));
    paramView = Utils.findRequiredView(paramView, 2131692064, "field 'btnSure' and method 'onViewClicked'");
    paramT.btnSure = ((Button)Utils.castView(paramView, 2131692064, "field 'btnSure'", Button.class));
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
    CouponCardsActivity localCouponCardsActivity = this.a;
    if (localCouponCardsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCouponCardsActivity.ivBack = null;
    localCouponCardsActivity.tvTitle = null;
    localCouponCardsActivity.listCards = null;
    localCouponCardsActivity.btnSure = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/CouponCardsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */