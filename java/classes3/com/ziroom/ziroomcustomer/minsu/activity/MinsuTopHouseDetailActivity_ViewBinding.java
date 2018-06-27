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
import com.ziroom.ziroomcustomer.minsu.view.CustomViewPager;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuTopHouseDetailActivity_ViewBinding<T extends MinsuTopHouseDetailActivity>
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
  
  public MinsuTopHouseDetailActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.v_bg = Utils.findRequiredView(paramView, 2131690815, "field 'v_bg'");
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
    paramT.tv_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690979, "field 'tv_price'", TextView.class));
    paramT.osv_main = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691365, "field 'osv_main'", ObservableScrollView.class));
    paramT.rl_title_container = Utils.findRequiredView(paramView, 2131691392, "field 'rl_title_container'");
    paramT.tv_house_address = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691378, "field 'tv_house_address'", TextView.class));
    paramT.tv_landlord_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691375, "field 'tv_landlord_name'", TextView.class));
    paramT.tv_landlord_recommend = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691377, "field 'tv_landlord_recommend'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691376, "field 'sdv_landlord_head' and method 'onClick'");
    paramT.sdv_landlord_head = ((SimpleDraweeView)Utils.castView(localView, 2131691376, "field 'sdv_landlord_head'", SimpleDraweeView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691374, "field 'sdv_top_list' and method 'onClick'");
    paramT.sdv_top_list = ((SimpleDraweeView)Utils.castView(localView, 2131691374, "field 'sdv_top_list'", SimpleDraweeView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.sdv_top_special_icon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691371, "field 'sdv_top_special_icon'", SimpleDraweeView.class));
    paramT.tv_top_special_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691370, "field 'tv_top_special_title'", TextView.class));
    paramT.v_title_bottom = Utils.findRequiredView(paramView, 2131691395, "field 'v_title_bottom'");
    paramT.ll_more_house = Utils.findRequiredView(paramView, 2131691355, "field 'll_more_house'");
    paramT.ll_pic_word_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691372, "field 'll_pic_word_container'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691373, "field 'btn_pic_word_unfold' and method 'onClick'");
    paramT.btn_pic_word_unfold = ((TextView)Utils.castView(localView, 2131691373, "field 'btn_pic_word_unfold'", TextView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ll_fac_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691387, "field 'll_fac_container'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691386, "field 'btn_fac_all' and method 'onClick'");
    paramT.btn_fac_all = localView;
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.fl_house_info_tag = ((FlowLayout)Utils.findRequiredViewAsType(paramView, 2131691385, "field 'fl_house_info_tag'", FlowLayout.class));
    paramT.lv_rule = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131691388, "field 'lv_rule'", ListViewForScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131691390, "field 'btn_rule_unfold' and method 'onClick'");
    paramT.btn_rule_unfold = localView;
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ll_rule_unfold_container = Utils.findRequiredView(paramView, 2131691389, "field 'll_rule_unfold_container'");
    paramT.tv_eva_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691382, "field 'tv_eva_count'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691381, "field 'btn_eva_all' and method 'onClick'");
    paramT.btn_eva_all = localView;
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_eva_content = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691383, "field 'tv_eva_content'", TextView.class));
    paramT.tv_eva_author = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691384, "field 'tv_eva_author'", TextView.class));
    paramT.rl_eva_container = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691379, "field 'rl_eva_container'", RelativeLayout.class));
    paramT.cvp_other_room = ((CustomViewPager)Utils.findRequiredViewAsType(paramView, 2131691391, "field 'cvp_other_room'", CustomViewPager.class));
  }
  
  public void unbind()
  {
    MinsuTopHouseDetailActivity localMinsuTopHouseDetailActivity = this.a;
    if (localMinsuTopHouseDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuTopHouseDetailActivity.btn_back = null;
    localMinsuTopHouseDetailActivity.btn_share = null;
    localMinsuTopHouseDetailActivity.v_bg = null;
    localMinsuTopHouseDetailActivity.btn_collect = null;
    localMinsuTopHouseDetailActivity.btn_confirm = null;
    localMinsuTopHouseDetailActivity.btn_landlord_call = null;
    localMinsuTopHouseDetailActivity.sdv_detail = null;
    localMinsuTopHouseDetailActivity.tv_title = null;
    localMinsuTopHouseDetailActivity.fl_image_tag = null;
    localMinsuTopHouseDetailActivity.tv_price = null;
    localMinsuTopHouseDetailActivity.osv_main = null;
    localMinsuTopHouseDetailActivity.rl_title_container = null;
    localMinsuTopHouseDetailActivity.tv_house_address = null;
    localMinsuTopHouseDetailActivity.tv_landlord_name = null;
    localMinsuTopHouseDetailActivity.tv_landlord_recommend = null;
    localMinsuTopHouseDetailActivity.sdv_landlord_head = null;
    localMinsuTopHouseDetailActivity.sdv_top_list = null;
    localMinsuTopHouseDetailActivity.sdv_top_special_icon = null;
    localMinsuTopHouseDetailActivity.tv_top_special_title = null;
    localMinsuTopHouseDetailActivity.v_title_bottom = null;
    localMinsuTopHouseDetailActivity.ll_more_house = null;
    localMinsuTopHouseDetailActivity.ll_pic_word_container = null;
    localMinsuTopHouseDetailActivity.btn_pic_word_unfold = null;
    localMinsuTopHouseDetailActivity.ll_fac_container = null;
    localMinsuTopHouseDetailActivity.btn_fac_all = null;
    localMinsuTopHouseDetailActivity.fl_house_info_tag = null;
    localMinsuTopHouseDetailActivity.lv_rule = null;
    localMinsuTopHouseDetailActivity.btn_rule_unfold = null;
    localMinsuTopHouseDetailActivity.ll_rule_unfold_container = null;
    localMinsuTopHouseDetailActivity.tv_eva_count = null;
    localMinsuTopHouseDetailActivity.btn_eva_all = null;
    localMinsuTopHouseDetailActivity.tv_eva_content = null;
    localMinsuTopHouseDetailActivity.tv_eva_author = null;
    localMinsuTopHouseDetailActivity.rl_eva_container = null;
    localMinsuTopHouseDetailActivity.cvp_other_room = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTopHouseDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */