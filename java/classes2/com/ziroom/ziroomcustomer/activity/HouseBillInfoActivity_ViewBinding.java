package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class HouseBillInfoActivity_ViewBinding<T extends HouseBillInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public HouseBillInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.activity_house_bill_info_rl = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690798, "field 'activity_house_bill_info_rl'", RelativeLayout.class));
    paramT.bill_title = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131690799, "field 'bill_title'", BasicZiroomToolBar.class));
    paramT.house_bill_info_data_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690803, "field 'house_bill_info_data_ll'", LinearLayout.class));
    paramT.house_bill_info_money_im = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690810, "field 'house_bill_info_money_im'", ImageView.class));
    paramT.house_bill_info_money_hint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690806, "field 'house_bill_info_money_hint'", TextView.class));
    paramT.house_bill_info_money_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690805, "field 'house_bill_info_money_text'", TextView.class));
    paramT.house_bill_info_money = ((EditText)Utils.findRequiredViewAsType(paramView, 2131690809, "field 'house_bill_info_money'", EditText.class));
    paramT.iv_pic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131689908, "field 'iv_pic'", SimpleDraweeView.class));
    paramT.tv_house_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691210, "field 'tv_house_name'", TextView.class));
    paramT.tv_house_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690979, "field 'tv_house_price'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131690802, "field 'to_pay_checkstand' and method 'onClick'");
    paramT.to_pay_checkstand = ((Button)Utils.castView(localView, 2131690802, "field 'to_pay_checkstand'", Button.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.hint_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696052, "field 'hint_ll'", LinearLayout.class));
    paramT.hint_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696055, "field 'hint_text'", TextView.class));
    paramT.hint_date = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696053, "field 'hint_date'", TextView.class));
    paramT.wyj_hint_ll = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131692963, "field 'wyj_hint_ll'", LinearLayout.class));
    paramT.wyj_hint_text = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692964, "field 'wyj_hint_text'", TextView.class));
    paramT.to_pay_money_hint = ((Button)Utils.findRequiredViewAsType(paramView, 2131690801, "field 'to_pay_money_hint'", Button.class));
    paramT.house_bill_info_money_tv = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690808, "field 'house_bill_info_money_tv'", TextView.class));
    paramT.hint_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696054, "field 'hint_status'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131690811, "field 'rl_easy_pay_guiding' and method 'onClick'");
    paramT.rl_easy_pay_guiding = ((RelativeLayout)Utils.castView(localView, 2131690811, "field 'rl_easy_pay_guiding'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.iv_easy_pay_guiding = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690812, "field 'iv_easy_pay_guiding'", ImageView.class));
  }
  
  public void unbind()
  {
    HouseBillInfoActivity localHouseBillInfoActivity = this.a;
    if (localHouseBillInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHouseBillInfoActivity.activity_house_bill_info_rl = null;
    localHouseBillInfoActivity.bill_title = null;
    localHouseBillInfoActivity.house_bill_info_data_ll = null;
    localHouseBillInfoActivity.house_bill_info_money_im = null;
    localHouseBillInfoActivity.house_bill_info_money_hint = null;
    localHouseBillInfoActivity.house_bill_info_money_text = null;
    localHouseBillInfoActivity.house_bill_info_money = null;
    localHouseBillInfoActivity.iv_pic = null;
    localHouseBillInfoActivity.tv_house_name = null;
    localHouseBillInfoActivity.tv_house_price = null;
    localHouseBillInfoActivity.to_pay_checkstand = null;
    localHouseBillInfoActivity.hint_ll = null;
    localHouseBillInfoActivity.hint_text = null;
    localHouseBillInfoActivity.hint_date = null;
    localHouseBillInfoActivity.wyj_hint_ll = null;
    localHouseBillInfoActivity.wyj_hint_text = null;
    localHouseBillInfoActivity.to_pay_money_hint = null;
    localHouseBillInfoActivity.house_bill_info_money_tv = null;
    localHouseBillInfoActivity.hint_status = null;
    localHouseBillInfoActivity.rl_easy_pay_guiding = null;
    localHouseBillInfoActivity.iv_easy_pay_guiding = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/HouseBillInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */