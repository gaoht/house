package com.ziroom.ziroomcustomer.payment.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class PaymentActivity_ViewBinding<T extends PaymentActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public PaymentActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvLastTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691194, "field 'tvLastTime'", TextView.class));
    paramT.llLastTime = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692049, "field 'llLastTime'", LinearLayout.class));
    paramT.tvMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689846, "field 'tvMoney'", TextView.class));
    paramT.tvCardsContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692057, "field 'tvCardsContent'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onClick'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692056, "field 'llCards' and method 'onClick'");
    paramT.llCards = ((LinearLayout)Utils.castView(localView, 2131692056, "field 'llCards'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvAccountMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692059, "field 'tvAccountMoney'", TextView.class));
    paramT.checkAccount = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131692060, "field 'checkAccount'", CheckBox.class));
    localView = Utils.findRequiredView(paramView, 2131691846, "field 'llAccount' and method 'onClick'");
    paramT.llAccount = ((LinearLayout)Utils.castView(localView, 2131691846, "field 'llAccount'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvSelectPayway = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692061, "field 'tvSelectPayway'", TextView.class));
    paramT.payList = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692062, "field 'payList'", ListViewForScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131690461, "field 'btnPay' and method 'onClick'");
    paramT.btnPay = ((Button)Utils.castView(localView, 2131690461, "field 'btnPay'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.scrollview = ((ScrollView)Utils.findRequiredViewAsType(paramView, 2131689506, "field 'scrollview'", ScrollView.class));
    paramT.vCards = Utils.findRequiredView(paramView, 2131692058, "field 'vCards'");
    paramT.tvValuecardMoney = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692051, "field 'tvValuecardMoney'", TextView.class));
    paramT.checkValuecard = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131692054, "field 'checkValuecard'", CheckBox.class));
    paramT.rlValuecard = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692050, "field 'rlValuecard'", RelativeLayout.class));
    paramT.vValuecard = Utils.findRequiredView(paramView, 2131692055, "field 'vValuecard'");
    paramT.vAccount = Utils.findRequiredView(paramView, 2131690343, "field 'vAccount'");
    localView = Utils.findRequiredView(paramView, 2131692052, "field 'tvValuecardBuy' and method 'onClick'");
    paramT.tvValuecardBuy = ((TextView)Utils.castView(localView, 2131692052, "field 'tvValuecardBuy'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ivBuy = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692053, "field 'ivBuy'", ImageView.class));
  }
  
  public void unbind()
  {
    PaymentActivity localPaymentActivity = this.a;
    if (localPaymentActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPaymentActivity.tvLastTime = null;
    localPaymentActivity.llLastTime = null;
    localPaymentActivity.tvMoney = null;
    localPaymentActivity.tvCardsContent = null;
    localPaymentActivity.ivBack = null;
    localPaymentActivity.llCards = null;
    localPaymentActivity.tvAccountMoney = null;
    localPaymentActivity.checkAccount = null;
    localPaymentActivity.llAccount = null;
    localPaymentActivity.tvSelectPayway = null;
    localPaymentActivity.payList = null;
    localPaymentActivity.btnPay = null;
    localPaymentActivity.scrollview = null;
    localPaymentActivity.vCards = null;
    localPaymentActivity.tvValuecardMoney = null;
    localPaymentActivity.checkValuecard = null;
    localPaymentActivity.rlValuecard = null;
    localPaymentActivity.vValuecard = null;
    localPaymentActivity.vAccount = null;
    localPaymentActivity.tvValuecardBuy = null;
    localPaymentActivity.ivBuy = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/PaymentActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */