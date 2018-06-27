package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class NewLeaseInfoActivity_ViewBinding<T extends NewLeaseInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  
  public NewLeaseInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691948, "field 'leaseInfoApplyInvoice' and method 'onClic'");
    paramT.leaseInfoApplyInvoice = ((RelativeLayout)Utils.castView(localView, 2131691948, "field 'leaseInfoApplyInvoice'", RelativeLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691915, "field 'lease_info_title_call' and method 'onClic'");
    paramT.lease_info_title_call = ((TextView)Utils.castView(localView, 2131691915, "field 'lease_info_title_call'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_contract_code = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691923, "field 'lease_contract_code'", TextView.class));
    paramT.lease_contract_state = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691924, "field 'lease_contract_state'", TextView.class));
    paramT.lease_info_house_image = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691927, "field 'lease_info_house_image'", SimpleDraweeView.class));
    paramT.lease_info_house_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691928, "field 'lease_info_house_title'", TextView.class));
    paramT.lease_info_house_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691929, "field 'lease_info_house_content'", TextView.class));
    paramT.lease_info_house_area = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691930, "field 'lease_info_house_area'", TextView.class));
    paramT.lease_info_lease_date_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691932, "field 'lease_info_lease_date_tv'", TextView.class));
    paramT.lease_info_pay_type_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691934, "field 'lease_info_pay_type_tv'", TextView.class));
    paramT.lease_info_goods_delivery_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691935, "field 'lease_info_goods_delivery_rl'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691936, "field 'lease_info_goods_delivery_ll' and method 'onClic'");
    paramT.lease_info_goods_delivery_ll = ((LinearLayout)Utils.castView(localView, 2131691936, "field 'lease_info_goods_delivery_ll'", LinearLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_info_goods_delivery_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691937, "field 'lease_info_goods_delivery_tv'", TextView.class));
    paramT.lease_info_show_contract_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691939, "field 'lease_info_show_contract_rl'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691940, "field 'lease_info_show_contract_ll' and method 'onClic'");
    paramT.lease_info_show_contract_ll = ((LinearLayout)Utils.castView(localView, 2131691940, "field 'lease_info_show_contract_ll'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691942, "field 'lease_info_all_pay_rl' and method 'onClic'");
    paramT.lease_info_all_pay_rl = ((RelativeLayout)Utils.castView(localView, 2131691942, "field 'lease_info_all_pay_rl'", RelativeLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_info_all_pay_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691943, "field 'lease_info_all_pay_ll'", LinearLayout.class));
    paramT.lease_info_all_pay_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691944, "field 'lease_info_all_pay_tv'", TextView.class));
    paramT.lease_info_cert_info_tv1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691954, "field 'lease_info_cert_info_tv1'", TextView.class));
    paramT.lease_info_cert_info_ll1 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691955, "field 'lease_info_cert_info_ll1'", LinearLayout.class));
    paramT.lease_info_cert_info_tv2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691957, "field 'lease_info_cert_info_tv2'", TextView.class));
    paramT.lease_info_cert_info_ll2 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691958, "field 'lease_info_cert_info_ll2'", LinearLayout.class));
    paramT.lease_title_hint_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691922, "field 'lease_title_hint_ll'", LinearLayout.class));
    paramT.lease_info_cert_info_lin1 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691953, "field 'lease_info_cert_info_lin1'", LinearLayout.class));
    paramT.lease_info_cert_info_lin2 = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691956, "field 'lease_info_cert_info_lin2'", LinearLayout.class));
    paramT.lease_info_to_pay_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691918, "field 'lease_info_to_pay_rl'", RelativeLayout.class));
    paramT.lease_info_pay_conut_money_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691919, "field 'lease_info_pay_conut_money_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691917, "field 'lease_info_goods_delivery_btn' and method 'onClic'");
    paramT.lease_info_goods_delivery_btn = ((TextView)Utils.castView(localView, 2131691917, "field 'lease_info_goods_delivery_btn'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_info_goods_delivery_iv = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691938, "field 'lease_info_goods_delivery_iv'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131691945, "field 'lease_info_sharer_rl' and method 'onClic'");
    paramT.lease_info_sharer_rl = ((RelativeLayout)Utils.castView(localView, 2131691945, "field 'lease_info_sharer_rl'", RelativeLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramT.lease_info_record = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691949, "field 'lease_info_record'", RelativeLayout.class));
    paramT.lease_info_record_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691951, "field 'lease_info_record_tv'", TextView.class));
    paramT.lease_info_record_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691952, "field 'lease_info_record_img'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131691920, "method 'onClic'");
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691914, "method 'onClic'");
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691950, "method 'onClic'");
    this.k = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClic(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    NewLeaseInfoActivity localNewLeaseInfoActivity = this.a;
    if (localNewLeaseInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localNewLeaseInfoActivity.leaseInfoApplyInvoice = null;
    localNewLeaseInfoActivity.lease_info_title_call = null;
    localNewLeaseInfoActivity.lease_contract_code = null;
    localNewLeaseInfoActivity.lease_contract_state = null;
    localNewLeaseInfoActivity.lease_info_house_image = null;
    localNewLeaseInfoActivity.lease_info_house_title = null;
    localNewLeaseInfoActivity.lease_info_house_content = null;
    localNewLeaseInfoActivity.lease_info_house_area = null;
    localNewLeaseInfoActivity.lease_info_lease_date_tv = null;
    localNewLeaseInfoActivity.lease_info_pay_type_tv = null;
    localNewLeaseInfoActivity.lease_info_goods_delivery_rl = null;
    localNewLeaseInfoActivity.lease_info_goods_delivery_ll = null;
    localNewLeaseInfoActivity.lease_info_goods_delivery_tv = null;
    localNewLeaseInfoActivity.lease_info_show_contract_rl = null;
    localNewLeaseInfoActivity.lease_info_show_contract_ll = null;
    localNewLeaseInfoActivity.lease_info_all_pay_rl = null;
    localNewLeaseInfoActivity.lease_info_all_pay_ll = null;
    localNewLeaseInfoActivity.lease_info_all_pay_tv = null;
    localNewLeaseInfoActivity.lease_info_cert_info_tv1 = null;
    localNewLeaseInfoActivity.lease_info_cert_info_ll1 = null;
    localNewLeaseInfoActivity.lease_info_cert_info_tv2 = null;
    localNewLeaseInfoActivity.lease_info_cert_info_ll2 = null;
    localNewLeaseInfoActivity.lease_title_hint_ll = null;
    localNewLeaseInfoActivity.lease_info_cert_info_lin1 = null;
    localNewLeaseInfoActivity.lease_info_cert_info_lin2 = null;
    localNewLeaseInfoActivity.lease_info_to_pay_rl = null;
    localNewLeaseInfoActivity.lease_info_pay_conut_money_tv = null;
    localNewLeaseInfoActivity.lease_info_goods_delivery_btn = null;
    localNewLeaseInfoActivity.lease_info_goods_delivery_iv = null;
    localNewLeaseInfoActivity.lease_info_sharer_rl = null;
    localNewLeaseInfoActivity.lease_info_record = null;
    localNewLeaseInfoActivity.lease_info_record_tv = null;
    localNewLeaseInfoActivity.lease_info_record_img = null;
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
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/NewLeaseInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */