package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuTopHouseDetailLiteActivity_ViewBinding<T extends MinsuTopHouseDetailLiteActivity>
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
  
  public MinsuTopHouseDetailLiteActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_back' and method 'onClick'");
    paramT.btn_back = ((ImageView)Utils.castView(localView, 2131690078, "field 'btn_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.v_bg = Utils.findRequiredView(paramView, 2131690815, "field 'v_bg'");
    localView = Utils.findRequiredView(paramView, 2131691393, "field 'btn_share' and method 'onClick'");
    paramT.btn_share = ((ImageView)Utils.castView(localView, 2131691393, "field 'btn_share'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691394, "field 'btn_collect' and method 'onClick'");
    paramT.btn_collect = ((ImageView)Utils.castView(localView, 2131691394, "field 'btn_collect'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691363, "field 'btn_confirm' and method 'onClick'");
    paramT.btn_confirm = ((TextView)Utils.castView(localView, 2131691363, "field 'btn_confirm'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691362, "field 'btn_landlord_call' and method 'onClick'");
    paramT.btn_landlord_call = localView;
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691367, "field 'sdv_detail' and method 'onClick'");
    paramT.sdv_detail = ((SimpleDraweeView)Utils.castView(localView, 2131691367, "field 'sdv_detail'", SimpleDraweeView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691368, "field 'tv_title'", TextView.class));
    paramT.fl_image_tag = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131691369, "field 'fl_image_tag'", FlowLayout.class));
    paramT.osv_main = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691365, "field 'osv_main'", ObservableScrollView.class));
    paramT.rl_title_container = Utils.findRequiredView(paramView, 2131691392, "field 'rl_title_container'");
    paramT.tv_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691396, "field 'tv_price'", TextView.class));
    paramT.v_title_bottom = Utils.findRequiredView(paramView, 2131691395, "field 'v_title_bottom'");
    localView = Utils.findRequiredView(paramView, 2131691381, "field 'btn_eva_all' and method 'onClick'");
    paramT.btn_eva_all = localView;
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_eva_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691382, "field 'tv_eva_count'", TextView.class));
    paramT.tv_eva_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691383, "field 'tv_eva_content'", TextView.class));
    paramT.tv_eva_author = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691384, "field 'tv_eva_author'", TextView.class));
    paramT.rl_eva_container = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691379, "field 'rl_eva_container'", RelativeLayout.class));
    paramT.ll_fac_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691387, "field 'll_fac_container'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691386, "field 'btn_fac_all' and method 'onClick'");
    paramT.btn_fac_all = localView;
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.lv_rule = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131691388, "field 'lv_rule'", ListViewForScrollView.class));
    paramView = Utils.findRequiredView(paramView, 2131691390, "field 'btn_rule_unfold' and method 'onClick'");
    paramT.btn_rule_unfold = paramView;
    this.j = paramView;
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
    MinsuTopHouseDetailLiteActivity localMinsuTopHouseDetailLiteActivity = this.a;
    if (localMinsuTopHouseDetailLiteActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuTopHouseDetailLiteActivity.btn_back = null;
    localMinsuTopHouseDetailLiteActivity.v_bg = null;
    localMinsuTopHouseDetailLiteActivity.btn_share = null;
    localMinsuTopHouseDetailLiteActivity.btn_collect = null;
    localMinsuTopHouseDetailLiteActivity.btn_confirm = null;
    localMinsuTopHouseDetailLiteActivity.btn_landlord_call = null;
    localMinsuTopHouseDetailLiteActivity.sdv_detail = null;
    localMinsuTopHouseDetailLiteActivity.tv_title = null;
    localMinsuTopHouseDetailLiteActivity.fl_image_tag = null;
    localMinsuTopHouseDetailLiteActivity.osv_main = null;
    localMinsuTopHouseDetailLiteActivity.rl_title_container = null;
    localMinsuTopHouseDetailLiteActivity.tv_price = null;
    localMinsuTopHouseDetailLiteActivity.v_title_bottom = null;
    localMinsuTopHouseDetailLiteActivity.btn_eva_all = null;
    localMinsuTopHouseDetailLiteActivity.tv_eva_count = null;
    localMinsuTopHouseDetailLiteActivity.tv_eva_content = null;
    localMinsuTopHouseDetailLiteActivity.tv_eva_author = null;
    localMinsuTopHouseDetailLiteActivity.rl_eva_container = null;
    localMinsuTopHouseDetailLiteActivity.ll_fac_container = null;
    localMinsuTopHouseDetailLiteActivity.btn_fac_all = null;
    localMinsuTopHouseDetailLiteActivity.lv_rule = null;
    localMinsuTopHouseDetailLiteActivity.btn_rule_unfold = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTopHouseDetailLiteActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */