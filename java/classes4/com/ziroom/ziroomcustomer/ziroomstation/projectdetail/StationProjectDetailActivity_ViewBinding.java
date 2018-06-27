package com.ziroom.ziroomcustomer.ziroomstation.projectdetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CustomViewPager;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ZiroomFlowLayout;

public class StationProjectDetailActivity_ViewBinding<T extends StationProjectDetailActivity>
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
  private View n;
  private View o;
  private View p;
  private View q;
  private View r;
  
  public StationProjectDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691363, "field 'btn_confirm' and method 'onClick'");
    paramT.btn_confirm = ((TextView)Utils.castView(localView, 2131691363, "field 'btn_confirm'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692539, "field 'btn_price_detail' and method 'onClick'");
    paramT.btn_price_detail = localView;
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_project_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692543, "field 'tv_project_name'", TextView.class));
    paramT.tv_project_eva_grade = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692545, "field 'tv_project_eva_grade'", TextView.class));
    paramT.tv_project_eva_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692546, "field 'tv_project_eva_count'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692555, "field 'tv_station_project_intro' and method 'onClick'");
    paramT.tv_station_project_intro = ((TextView)Utils.castView(localView, 2131692555, "field 'tv_station_project_intro'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692558, "field 'btn_start_time' and method 'onClick'");
    paramT.btn_start_time = localView;
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692561, "field 'btn_end_time' and method 'onClick'");
    paramT.btn_end_time = localView;
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_station_check_in_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692559, "field 'tv_station_check_in_time'", TextView.class));
    paramT.tv_station_check_out_time = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692562, "field 'tv_station_check_out_time'", TextView.class));
    paramT.rv_station_room = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131692563, "field 'rv_station_room'", RecyclerView.class));
    paramT.ll_fac_out_container = Utils.findRequiredView(paramView, 2131692567, "field 'll_fac_out_container'");
    localView = Utils.findRequiredView(paramView, 2131691386, "field 'btn_fac_all' and method 'onClick'");
    paramT.btn_fac_all = localView;
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ll_fac_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691387, "field 'll_fac_container'", LinearLayout.class));
    paramT.v_fac_line = Utils.findRequiredView(paramView, 2131692568, "field 'v_fac_line'");
    paramT.lv_rule = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691388, "field 'lv_rule'", ListView.class));
    paramT.cvp_wonderful_activities = ((CustomViewPager)Utils.findRequiredViewAsType(paramView, 2131692571, "field 'cvp_wonderful_activities'", CustomViewPager.class));
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
    localView = Utils.findRequiredView(paramView, 2131690078, "field 'btn_back' and method 'onClick'");
    paramT.btn_back = ((ImageView)Utils.castView(localView, 2131690078, "field 'btn_back'", ImageView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690459, "field 'btn_call' and method 'onClick'");
    paramT.btn_call = ((ImageView)Utils.castView(localView, 2131690459, "field 'btn_call'", ImageView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.osv_main = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131691365, "field 'osv_main'", ObservableScrollView.class));
    paramT.tv_no_evaluate = Utils.findRequiredView(paramView, 2131692547, "field 'tv_no_evaluate'");
    paramT.rl_eva_container = Utils.findRequiredView(paramView, 2131691379, "field 'rl_eva_container'");
    paramT.ll_title_date_container = Utils.findRequiredView(paramView, 2131692577, "field 'll_title_date_container'");
    localView = Utils.findRequiredView(paramView, 2131692578, "field 'btn_title_check_in' and method 'onClick'");
    paramT.btn_title_check_in = localView;
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692581, "field 'btn_title_check_out' and method 'onClick'");
    paramT.btn_title_check_out = localView;
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_title_date_check_in = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692580, "field 'tv_title_date_check_in'", TextView.class));
    paramT.tv_title_date_check_out = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692583, "field 'tv_title_date_check_out'", TextView.class));
    paramT.ll_time_selector_container = Utils.findRequiredView(paramView, 2131692557, "field 'll_time_selector_container'");
    paramT.ll_rule_container = Utils.findRequiredView(paramView, 2131692569, "field 'll_rule_container'");
    paramT.iv_total_price_right_icon = Utils.findRequiredView(paramView, 2131692537, "field 'iv_total_price_right_icon'");
    paramT.rl_title_container = Utils.findRequiredView(paramView, 2131691392, "field 'rl_title_container'");
    paramT.v_title_bottom = Utils.findRequiredView(paramView, 2131691395, "field 'v_title_bottom'");
    paramT.v_date_bottom_line = Utils.findRequiredView(paramView, 2131692556, "field 'v_date_bottom_line'");
    paramT.tv_title_check_in_info = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692579, "field 'tv_title_check_in_info'", TextView.class));
    paramT.tv_title_check_out_info = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692582, "field 'tv_title_check_out_info'", TextView.class));
    paramT.iv_title_cover = Utils.findRequiredView(paramView, 2131692575, "field 'iv_title_cover'");
    paramT.ll_wonderful_activities_container = Utils.findRequiredView(paramView, 2131692570, "field 'll_wonderful_activities_container'");
    paramT.zfl_station_project_label_container = ((ZiroomFlowLayout)Utils.findRequiredViewAsType(paramView, 2131692548, "field 'zfl_station_project_label_container'", ZiroomFlowLayout.class));
    localView = Utils.findRequiredView(paramView, 2131692554, "field 'btn_project_intro_more' and method 'onClick'");
    paramT.btn_project_intro_more = localView;
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691393, "field 'btn_share' and method 'onClick'");
    paramT.btn_share = ((ImageView)Utils.castView(localView, 2131691393, "field 'btn_share'", ImageView.class));
    this.n = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692576, "field 'btn_panoramic' and method 'onClick'");
    paramT.btn_panoramic = ((TextView)Utils.castView(localView, 2131692576, "field 'btn_panoramic'", TextView.class));
    this.o = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_station_location = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692551, "field 'tv_station_location'", TextView.class));
    paramT.tv_station_location_transport = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692552, "field 'tv_station_location_transport'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131692549, "field 'btn_station_location' and method 'onClick'");
    paramT.btn_station_location = localView;
    this.p = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ll_station_evaluate_container = Utils.findRequiredView(paramView, 2131692564, "field 'll_station_evaluate_container'");
    paramT.rv_evaluate = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131692566, "field 'rv_evaluate'", RecyclerView.class));
    paramT.tv_stay_in_count = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692560, "field 'tv_stay_in_count'", TextView.class));
    paramT.btn_cannot_order = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692541, "field 'btn_cannot_order'", TextView.class));
    paramT.rv_strategy = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131692574, "field 'rv_strategy'", RecyclerView.class));
    paramT.ll_strategy_container = Utils.findRequiredView(paramView, 2131692572, "field 'll_strategy_container'");
    localView = Utils.findRequiredView(paramView, 2131692573, "field 'btn_strategy_more' and method 'onClick'");
    paramT.btn_strategy_more = localView;
    this.q = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mLlCarousel = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690884, "field 'mLlCarousel'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131692565, "method 'onClick'");
    this.r = paramView;
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
    StationProjectDetailActivity localStationProjectDetailActivity = this.a;
    if (localStationProjectDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStationProjectDetailActivity.btn_confirm = null;
    localStationProjectDetailActivity.btn_price_detail = null;
    localStationProjectDetailActivity.tv_project_name = null;
    localStationProjectDetailActivity.tv_project_eva_grade = null;
    localStationProjectDetailActivity.tv_project_eva_count = null;
    localStationProjectDetailActivity.tv_station_project_intro = null;
    localStationProjectDetailActivity.btn_start_time = null;
    localStationProjectDetailActivity.btn_end_time = null;
    localStationProjectDetailActivity.tv_station_check_in_time = null;
    localStationProjectDetailActivity.tv_station_check_out_time = null;
    localStationProjectDetailActivity.rv_station_room = null;
    localStationProjectDetailActivity.ll_fac_out_container = null;
    localStationProjectDetailActivity.btn_fac_all = null;
    localStationProjectDetailActivity.ll_fac_container = null;
    localStationProjectDetailActivity.v_fac_line = null;
    localStationProjectDetailActivity.lv_rule = null;
    localStationProjectDetailActivity.cvp_wonderful_activities = null;
    localStationProjectDetailActivity.btn_eva_all = null;
    localStationProjectDetailActivity.btn_back = null;
    localStationProjectDetailActivity.btn_call = null;
    localStationProjectDetailActivity.osv_main = null;
    localStationProjectDetailActivity.tv_no_evaluate = null;
    localStationProjectDetailActivity.rl_eva_container = null;
    localStationProjectDetailActivity.ll_title_date_container = null;
    localStationProjectDetailActivity.btn_title_check_in = null;
    localStationProjectDetailActivity.btn_title_check_out = null;
    localStationProjectDetailActivity.tv_title_date_check_in = null;
    localStationProjectDetailActivity.tv_title_date_check_out = null;
    localStationProjectDetailActivity.ll_time_selector_container = null;
    localStationProjectDetailActivity.ll_rule_container = null;
    localStationProjectDetailActivity.iv_total_price_right_icon = null;
    localStationProjectDetailActivity.rl_title_container = null;
    localStationProjectDetailActivity.v_title_bottom = null;
    localStationProjectDetailActivity.v_date_bottom_line = null;
    localStationProjectDetailActivity.tv_title_check_in_info = null;
    localStationProjectDetailActivity.tv_title_check_out_info = null;
    localStationProjectDetailActivity.iv_title_cover = null;
    localStationProjectDetailActivity.ll_wonderful_activities_container = null;
    localStationProjectDetailActivity.zfl_station_project_label_container = null;
    localStationProjectDetailActivity.btn_project_intro_more = null;
    localStationProjectDetailActivity.btn_share = null;
    localStationProjectDetailActivity.btn_panoramic = null;
    localStationProjectDetailActivity.tv_station_location = null;
    localStationProjectDetailActivity.tv_station_location_transport = null;
    localStationProjectDetailActivity.btn_station_location = null;
    localStationProjectDetailActivity.ll_station_evaluate_container = null;
    localStationProjectDetailActivity.rv_evaluate = null;
    localStationProjectDetailActivity.tv_stay_in_count = null;
    localStationProjectDetailActivity.btn_cannot_order = null;
    localStationProjectDetailActivity.rv_strategy = null;
    localStationProjectDetailActivity.ll_strategy_container = null;
    localStationProjectDetailActivity.btn_strategy_more = null;
    localStationProjectDetailActivity.mLlCarousel = null;
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
    this.n.setOnClickListener(null);
    this.n = null;
    this.o.setOnClickListener(null);
    this.o = null;
    this.p.setOnClickListener(null);
    this.p = null;
    this.q.setOnClickListener(null);
    this.q = null;
    this.r.setOnClickListener(null);
    this.r = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/StationProjectDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */