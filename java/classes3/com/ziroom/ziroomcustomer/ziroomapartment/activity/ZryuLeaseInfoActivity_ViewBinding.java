package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZryuLeaseInfoActivity_ViewBinding<T extends ZryuLeaseInfoActivity>
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
  
  public ZryuLeaseInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131692863, "field 'tv_delete_contract' and method 'OnClick'");
    paramT.tv_delete_contract = ((TextView)Utils.castView(localView, 2131692863, "field 'tv_delete_contract'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.sdv = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691098, "field 'sdv'", SimpleDraweeView.class));
    paramT.tv_house_info_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696404, "field 'tv_house_info_name'", TextView.class));
    paramT.tv_house_info_add = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696579, "field 'tv_house_info_add'", TextView.class));
    paramT.tv_house_info_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696402, "field 'tv_house_info_price'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696578, "field 'rl_house_info' and method 'OnClick'");
    paramT.rl_house_info = ((RelativeLayout)Utils.castView(localView, 2131696578, "field 'rl_house_info'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692865, "field 'zryu_leasse_info_call' and method 'OnClick'");
    paramT.zryu_leasse_info_call = ((TextView)Utils.castView(localView, 2131692865, "field 'zryu_leasse_info_call'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692866, "field 'zryu_leasse_info_btn' and method 'OnClick'");
    paramT.zryu_leasse_info_btn = ((TextView)Utils.castView(localView, 2131692866, "field 'zryu_leasse_info_btn'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.zryu_lease_contract_code_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692868, "field 'zryu_lease_contract_code_tv'", TextView.class));
    paramT.zryu_lease_contract_code_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692869, "field 'zryu_lease_contract_code_img'", ImageView.class));
    paramT.zryu_lease_contract_status_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692870, "field 'zryu_lease_contract_status_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692867, "field 'zryu_lease_contract_code_rl' and method 'OnClick'");
    paramT.zryu_lease_contract_code_rl = ((RelativeLayout)Utils.castView(localView, 2131692867, "field 'zryu_lease_contract_code_rl'", RelativeLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.sign_data_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692871, "field 'sign_data_ll'", LinearLayout.class));
    paramT.sign_data_name_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692872, "field 'sign_data_name_tv'", TextView.class));
    paramT.sign_data_sex_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692873, "field 'sign_data_sex_tv'", TextView.class));
    paramT.sign_data_card_id_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692874, "field 'sign_data_card_id_tv'", TextView.class));
    paramT.sign_data_phone_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692875, "field 'sign_data_phone_tv'", TextView.class));
    paramT.house_data_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692876, "field 'house_data_ll'", LinearLayout.class));
    paramT.house_data_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692878, "field 'house_data_content'", TextView.class));
    paramT.lease_date_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692879, "field 'lease_date_ll'", LinearLayout.class));
    paramT.lease_date_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692881, "field 'lease_date_content'", TextView.class));
    paramT.sign_pay_type_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692882, "field 'sign_pay_type_ll'", LinearLayout.class));
    paramT.sign_pay_type_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692884, "field 'sign_pay_type_content'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692885, "field 'lease_all_bill_rl' and method 'OnClick'");
    paramT.lease_all_bill_rl = ((RelativeLayout)Utils.castView(localView, 2131692885, "field 'lease_all_bill_rl'", RelativeLayout.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.lease_all_bill_hint_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692887, "field 'lease_all_bill_hint_tv'", TextView.class));
    paramT.lease_all_bill_btn_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692888, "field 'lease_all_bill_btn_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692889, "field 'zryu_lease_delivery_rl' and method 'OnClick'");
    paramT.zryu_lease_delivery_rl = ((RelativeLayout)Utils.castView(localView, 2131692889, "field 'zryu_lease_delivery_rl'", RelativeLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.zryu_lease_delivery_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692890, "field 'zryu_lease_delivery_tv'", TextView.class));
    paramT.zryu_lease_delivery_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692892, "field 'zryu_lease_delivery_img'", ImageView.class));
    paramT.zryu_lease_delivery_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692891, "field 'zryu_lease_delivery_status'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692893, "field 'zryu_lease_roommates_rl' and method 'OnClick'");
    paramT.zryu_lease_roommates_rl = ((RelativeLayout)Utils.castView(localView, 2131692893, "field 'zryu_lease_roommates_rl'", RelativeLayout.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.zryu_lease_roommates_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692894, "field 'zryu_lease_roommates_tv'", TextView.class));
    paramT.zryu_lease_roommates_img = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131692896, "field 'zryu_lease_roommates_img'", ImageView.class));
    paramT.zryu_lease_roommates_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692895, "field 'zryu_lease_roommates_status'", TextView.class));
    paramT.zryu_lease_hint_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692901, "field 'zryu_lease_hint_tv'", TextView.class));
    paramT.old_contract_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131692897, "field 'old_contract_rl'", RelativeLayout.class));
    paramT.lease_old_contract_hint_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692899, "field 'lease_old_contract_hint_tv'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692900, "field 'old_contract_btn_tv' and method 'OnClick'");
    paramT.old_contract_btn_tv = ((TextView)Utils.castView(localView, 2131692900, "field 'old_contract_btn_tv'", TextView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689492, "method 'OnClick'");
    this.k = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    ZryuLeaseInfoActivity localZryuLeaseInfoActivity = this.a;
    if (localZryuLeaseInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuLeaseInfoActivity.tv_delete_contract = null;
    localZryuLeaseInfoActivity.sdv = null;
    localZryuLeaseInfoActivity.tv_house_info_name = null;
    localZryuLeaseInfoActivity.tv_house_info_add = null;
    localZryuLeaseInfoActivity.tv_house_info_price = null;
    localZryuLeaseInfoActivity.rl_house_info = null;
    localZryuLeaseInfoActivity.zryu_leasse_info_call = null;
    localZryuLeaseInfoActivity.zryu_leasse_info_btn = null;
    localZryuLeaseInfoActivity.zryu_lease_contract_code_tv = null;
    localZryuLeaseInfoActivity.zryu_lease_contract_code_img = null;
    localZryuLeaseInfoActivity.zryu_lease_contract_status_tv = null;
    localZryuLeaseInfoActivity.zryu_lease_contract_code_rl = null;
    localZryuLeaseInfoActivity.sign_data_ll = null;
    localZryuLeaseInfoActivity.sign_data_name_tv = null;
    localZryuLeaseInfoActivity.sign_data_sex_tv = null;
    localZryuLeaseInfoActivity.sign_data_card_id_tv = null;
    localZryuLeaseInfoActivity.sign_data_phone_tv = null;
    localZryuLeaseInfoActivity.house_data_ll = null;
    localZryuLeaseInfoActivity.house_data_content = null;
    localZryuLeaseInfoActivity.lease_date_ll = null;
    localZryuLeaseInfoActivity.lease_date_content = null;
    localZryuLeaseInfoActivity.sign_pay_type_ll = null;
    localZryuLeaseInfoActivity.sign_pay_type_content = null;
    localZryuLeaseInfoActivity.lease_all_bill_rl = null;
    localZryuLeaseInfoActivity.lease_all_bill_hint_tv = null;
    localZryuLeaseInfoActivity.lease_all_bill_btn_tv = null;
    localZryuLeaseInfoActivity.zryu_lease_delivery_rl = null;
    localZryuLeaseInfoActivity.zryu_lease_delivery_tv = null;
    localZryuLeaseInfoActivity.zryu_lease_delivery_img = null;
    localZryuLeaseInfoActivity.zryu_lease_delivery_status = null;
    localZryuLeaseInfoActivity.zryu_lease_roommates_rl = null;
    localZryuLeaseInfoActivity.zryu_lease_roommates_tv = null;
    localZryuLeaseInfoActivity.zryu_lease_roommates_img = null;
    localZryuLeaseInfoActivity.zryu_lease_roommates_status = null;
    localZryuLeaseInfoActivity.zryu_lease_hint_tv = null;
    localZryuLeaseInfoActivity.old_contract_rl = null;
    localZryuLeaseInfoActivity.lease_old_contract_hint_tv = null;
    localZryuLeaseInfoActivity.old_contract_btn_tv = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuLeaseInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */