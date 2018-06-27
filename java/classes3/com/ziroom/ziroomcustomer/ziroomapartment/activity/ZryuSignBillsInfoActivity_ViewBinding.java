package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZryuSignBillsInfoActivity_ViewBinding<T extends ZryuSignBillsInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public ZryuSignBillsInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.zryu_bill_info_list = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692965, "field 'zryu_bill_info_list'", LinearLayout.class));
    View localView = Utils.findRequiredView(paramView, 2131692958, "field 'zryu_bill_activity_sv' and method 'onViewClick'");
    paramT.zryu_bill_activity_sv = ((ScrollView)Utils.castView(localView, 2131692958, "field 'zryu_bill_activity_sv'", ScrollView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692959, "field 'zryu_bill_activity_ll' and method 'onViewClick'");
    paramT.zryu_bill_activity_ll = ((LinearLayout)Utils.castView(localView, 2131692959, "field 'zryu_bill_activity_ll'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.sdv = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691098, "field 'sdv'", SimpleDraweeView.class));
    paramT.tv_house_info_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696404, "field 'tv_house_info_name'", TextView.class));
    paramT.tv_house_info_add = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696579, "field 'tv_house_info_add'", TextView.class));
    paramT.tv_house_info_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696402, "field 'tv_house_info_price'", TextView.class));
    paramT.rl_house_info = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131696578, "field 'rl_house_info'", RelativeLayout.class));
    paramT.zryu_bill_info_title_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692960, "field 'zryu_bill_info_title_ll'", LinearLayout.class));
    paramT.zryu_bill_info_date = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692962, "field 'zryu_bill_info_date'", TextView.class));
    paramT.zryu_bill_info_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692961, "field 'zryu_bill_info_title'", TextView.class));
    paramT.wyj_hint_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692963, "field 'wyj_hint_ll'", LinearLayout.class));
    paramT.wyj_hint_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692964, "field 'wyj_hint_text'", TextView.class));
    paramT.zryu_bill_activitys_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692966, "field 'zryu_bill_activitys_ll'", LinearLayout.class));
    paramT.zryu_bill_activitys_title_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692967, "field 'zryu_bill_activitys_title_ll'", LinearLayout.class));
    paramT.tv_cost_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692968, "field 'tv_cost_name'", TextView.class));
    paramT.tv_cost_value = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692969, "field 'tv_cost_value'", TextView.class));
    paramT.zryu_bill_activitys_info = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692970, "field 'zryu_bill_activitys_info'", LinearLayout.class));
    paramT.zryu_bill_pay_all_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692971, "field 'zryu_bill_pay_all_tv'", TextView.class));
    paramT.zryu_bill_pay_all_money_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692972, "field 'zryu_bill_pay_all_money_tv'", TextView.class));
    paramT.pay_history_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692973, "field 'pay_history_ll'", LinearLayout.class));
    paramT.pay_history_title_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692975, "field 'pay_history_title_tv'", TextView.class));
    paramT.pay_history_title_iv = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692976, "field 'pay_history_title_iv'", ImageView.class));
    paramT.pay_history_price_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692977, "field 'pay_history_price_tv'", TextView.class));
    paramT.pay_history_list_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692978, "field 'pay_history_list_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131692974, "field 'pay_history_title_rl' and method 'onViewClick'");
    paramT.pay_history_title_rl = ((RelativeLayout)Utils.castView(localView, 2131692974, "field 'pay_history_title_rl'", RelativeLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.remain_money_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692979, "field 'remain_money_rl'", RelativeLayout.class));
    paramT.remain_money_title_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692980, "field 'remain_money_title_tv'", TextView.class));
    paramT.remain_money_price_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692981, "field 'remain_money_price_tv'", TextView.class));
    paramT.remain_money_line = Utils.findRequiredView(paramView, 2131692982, "field 'remain_money_line'");
    paramT.bill_info_money_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692983, "field 'bill_info_money_rl'", RelativeLayout.class));
    paramT.bill_info_money_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692985, "field 'bill_info_money_text'", TextView.class));
    paramT.bill_info_money_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692986, "field 'bill_info_money_hint'", TextView.class));
    paramT.bill_info_money = ((EditText)Utils.findRequiredViewAsType(paramView, 2131692989, "field 'bill_info_money'", EditText.class));
    paramT.bill_info_money_im = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692990, "field 'bill_info_money_im'", ImageView.class));
    paramT.zryu_bill_info_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692957, "field 'zryu_bill_info_ll'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClick'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
    paramT.btn_hint = ((Button)Utils.findRequiredViewAsType(paramView, 2131692991, "field 'btn_hint'", Button.class));
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'onViewClick'");
    this.f = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    ZryuSignBillsInfoActivity localZryuSignBillsInfoActivity = this.a;
    if (localZryuSignBillsInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuSignBillsInfoActivity.zryu_bill_info_list = null;
    localZryuSignBillsInfoActivity.zryu_bill_activity_sv = null;
    localZryuSignBillsInfoActivity.zryu_bill_activity_ll = null;
    localZryuSignBillsInfoActivity.sdv = null;
    localZryuSignBillsInfoActivity.tv_house_info_name = null;
    localZryuSignBillsInfoActivity.tv_house_info_add = null;
    localZryuSignBillsInfoActivity.tv_house_info_price = null;
    localZryuSignBillsInfoActivity.rl_house_info = null;
    localZryuSignBillsInfoActivity.zryu_bill_info_title_ll = null;
    localZryuSignBillsInfoActivity.zryu_bill_info_date = null;
    localZryuSignBillsInfoActivity.zryu_bill_info_title = null;
    localZryuSignBillsInfoActivity.wyj_hint_ll = null;
    localZryuSignBillsInfoActivity.wyj_hint_text = null;
    localZryuSignBillsInfoActivity.zryu_bill_activitys_ll = null;
    localZryuSignBillsInfoActivity.zryu_bill_activitys_title_ll = null;
    localZryuSignBillsInfoActivity.tv_cost_name = null;
    localZryuSignBillsInfoActivity.tv_cost_value = null;
    localZryuSignBillsInfoActivity.zryu_bill_activitys_info = null;
    localZryuSignBillsInfoActivity.zryu_bill_pay_all_tv = null;
    localZryuSignBillsInfoActivity.zryu_bill_pay_all_money_tv = null;
    localZryuSignBillsInfoActivity.pay_history_ll = null;
    localZryuSignBillsInfoActivity.pay_history_title_tv = null;
    localZryuSignBillsInfoActivity.pay_history_title_iv = null;
    localZryuSignBillsInfoActivity.pay_history_price_tv = null;
    localZryuSignBillsInfoActivity.pay_history_list_ll = null;
    localZryuSignBillsInfoActivity.pay_history_title_rl = null;
    localZryuSignBillsInfoActivity.remain_money_rl = null;
    localZryuSignBillsInfoActivity.remain_money_title_tv = null;
    localZryuSignBillsInfoActivity.remain_money_price_tv = null;
    localZryuSignBillsInfoActivity.remain_money_line = null;
    localZryuSignBillsInfoActivity.bill_info_money_rl = null;
    localZryuSignBillsInfoActivity.bill_info_money_text = null;
    localZryuSignBillsInfoActivity.bill_info_money_hint = null;
    localZryuSignBillsInfoActivity.bill_info_money = null;
    localZryuSignBillsInfoActivity.bill_info_money_im = null;
    localZryuSignBillsInfoActivity.zryu_bill_info_ll = null;
    localZryuSignBillsInfoActivity.btn = null;
    localZryuSignBillsInfoActivity.btn_hint = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignBillsInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */