package com.ziroom.ziroomcustomer.newclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class GeneralCleaningActivity_ViewBinding<T extends GeneralCleaningActivity>
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
  private View l;
  private View m;
  
  public GeneralCleaningActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690373, "field 'tv_service_address' and method 'onClick'");
    paramT.tv_service_address = ((LabeledEditText)Utils.castView(localView, 2131690373, "field 'tv_service_address'", LabeledEditText.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690679, "field 'tv_service_duration' and method 'onClick'");
    paramT.tv_service_duration = ((LabeledEditText)Utils.castView(localView, 2131690679, "field 'tv_service_duration'", LabeledEditText.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690388, "field 'tv_service_time' and method 'onClick'");
    paramT.tv_service_time = ((LabeledEditText)Utils.castView(localView, 2131690388, "field 'tv_service_time'", LabeledEditText.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690363, "field 'tv_select_cleaner' and method 'onClick'");
    paramT.tv_select_cleaner = ((LabeledEditText)Utils.castView(localView, 2131690363, "field 'tv_select_cleaner'", LabeledEditText.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690390, "field 'tv_clean_scoupon' and method 'onClick'");
    paramT.tv_clean_scoupon = ((LabeledEditText)Utils.castView(localView, 2131690390, "field 'tv_clean_scoupon'", LabeledEditText.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690391, "field 'tv_fill_special_need' and method 'onClick'");
    paramT.tv_fill_special_need = ((LabeledEditText)Utils.castView(localView, 2131690391, "field 'tv_fill_special_need'", LabeledEditText.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690398, "field 'tv_acarus_killing' and method 'onClick'");
    paramT.tv_acarus_killing = ((LabeledEditText)Utils.castView(localView, 2131690398, "field 'tv_acarus_killing'", LabeledEditText.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ll_select_cleaner = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690389, "field 'll_select_cleaner'", LinearLayout.class));
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tv_title'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689492, "field 'iv_back' and method 'onClick'");
    paramT.iv_back = ((ImageView)Utils.castView(localView, 2131689492, "field 'iv_back'", ImageView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_all_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689841, "field 'tv_all_price'", TextView.class));
    paramT.tv_price_from = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690386, "field 'tv_price_from'", TextView.class));
    paramT.tv_unit = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689840, "field 'tv_unit'", TextView.class));
    paramT.iv_all_price = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689842, "field 'iv_all_price'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131689843, "field 'btn_commit' and method 'onClick'");
    paramT.btn_commit = ((Button)Utils.castView(localView, 2131689843, "field 'btn_commit'", Button.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689839, "field 'll_show_money' and method 'onClick'");
    paramT.ll_show_money = ((LinearLayout)Utils.castView(localView, 2131689839, "field 'll_show_money'", LinearLayout.class));
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690393, "field 'iv_service_list' and method 'onClick'");
    paramT.iv_service_list = ((ImageView)Utils.castView(localView, 2131690393, "field 'iv_service_list'", ImageView.class));
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_message_dot = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690394, "field 'tv_message_dot'", TextView.class));
    paramT.ll_acarus_killing = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690397, "field 'll_acarus_killing'", LinearLayout.class));
    paramT.rl_show_cost = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131690385, "field 'rl_show_cost'", RelativeLayout.class));
    paramT.ll_service_duration = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690387, "field 'll_service_duration'", LinearLayout.class));
    paramT.ll_glass_tip = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690680, "field 'll_glass_tip'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131690023, "field 'iv_chat' and method 'onClick'");
    paramT.iv_chat = ((ImageView)Utils.castView(paramView, 2131690023, "field 'iv_chat'", ImageView.class));
    this.m = paramView;
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
    GeneralCleaningActivity localGeneralCleaningActivity = this.a;
    if (localGeneralCleaningActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localGeneralCleaningActivity.tv_service_address = null;
    localGeneralCleaningActivity.tv_service_duration = null;
    localGeneralCleaningActivity.tv_service_time = null;
    localGeneralCleaningActivity.tv_select_cleaner = null;
    localGeneralCleaningActivity.tv_clean_scoupon = null;
    localGeneralCleaningActivity.tv_fill_special_need = null;
    localGeneralCleaningActivity.tv_acarus_killing = null;
    localGeneralCleaningActivity.ll_select_cleaner = null;
    localGeneralCleaningActivity.tv_title = null;
    localGeneralCleaningActivity.iv_back = null;
    localGeneralCleaningActivity.tv_all_price = null;
    localGeneralCleaningActivity.tv_price_from = null;
    localGeneralCleaningActivity.tv_unit = null;
    localGeneralCleaningActivity.iv_all_price = null;
    localGeneralCleaningActivity.btn_commit = null;
    localGeneralCleaningActivity.ll_show_money = null;
    localGeneralCleaningActivity.iv_service_list = null;
    localGeneralCleaningActivity.tv_message_dot = null;
    localGeneralCleaningActivity.ll_acarus_killing = null;
    localGeneralCleaningActivity.rl_show_cost = null;
    localGeneralCleaningActivity.ll_service_duration = null;
    localGeneralCleaningActivity.ll_glass_tip = null;
    localGeneralCleaningActivity.iv_chat = null;
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
    this.l.setOnClickListener(null);
    this.l = null;
    this.m.setOnClickListener(null);
    this.m = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/GeneralCleaningActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */