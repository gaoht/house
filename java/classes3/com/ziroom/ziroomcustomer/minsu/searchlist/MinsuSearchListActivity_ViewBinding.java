package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.home.view.CustomTabLayout;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView;

public class MinsuSearchListActivity_ViewBinding<T extends MinsuSearchListActivity>
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
  private View s;
  private View t;
  private View u;
  private View v;
  private View w;
  private View x;
  
  public MinsuSearchListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.slsv_root = ((SearchListScrollView)Utils.findRequiredViewAsType(paramView, 2131691456, "field 'slsv_root'", SearchListScrollView.class));
    paramT.rl_title_container = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691392, "field 'rl_title_container'", RelativeLayout.class));
    paramT.ll_search_container = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691656, "field 'll_search_container'", LinearLayout.class));
    paramT.ctl_tab_container = ((CustomTabLayout)Utils.findRequiredViewAsType(paramView, 2131691657, "field 'ctl_tab_container'", CustomTabLayout.class));
    paramT.rl_search_lite_container = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691653, "field 'rl_search_lite_container'", RelativeLayout.class));
    paramT.vp_fragment_container = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131691658, "field 'vp_fragment_container'", ViewPager.class));
    paramT.ll_minsu_search_condition_bottom = ((CardView)Utils.findRequiredViewAsType(paramView, 2131691659, "field 'll_minsu_search_condition_bottom'", CardView.class));
    paramT.tv_location = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690748, "field 'tv_location'", TextView.class));
    paramT.tv_condition = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696322, "field 'tv_condition'", TextView.class));
    paramT.tv_sort = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690900, "field 'tv_sort'", TextView.class));
    paramT.tv_condition_num = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696324, "field 'tv_condition_num'", TextView.class));
    paramT.iv_condition = Utils.findRequiredView(paramView, 2131696323, "field 'iv_condition'");
    View localView = Utils.findRequiredView(paramView, 2131691401, "field 'et_search' and method 'OnClick'");
    paramT.et_search = ((EditText)Utils.castView(localView, 2131691401, "field 'et_search'", EditText.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691407, "field 'tv_search_city' and method 'OnClick'");
    paramT.tv_search_city = ((TextView)Utils.castView(localView, 2131691407, "field 'tv_search_city'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691408, "field 'tv_search_date' and method 'OnClick'");
    paramT.tv_search_date = ((TextView)Utils.castView(localView, 2131691408, "field 'tv_search_date'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691410, "field 'tv_search_count' and method 'OnClick'");
    paramT.tv_search_count = ((TextView)Utils.castView(localView, 2131691410, "field 'tv_search_count'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.tv_info = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691571, "field 'tv_info'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691406, "field 'tv_clear_global_condition' and method 'OnClick'");
    paramT.tv_clear_global_condition = ((TextView)Utils.castView(localView, 2131691406, "field 'tv_clear_global_condition'", TextView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691651, "field 'btn_clean_keyword' and method 'OnClick'");
    paramT.btn_clean_keyword = localView;
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691660, "field 'll_search_cover_container' and method 'OnClick'");
    paramT.ll_search_cover_container = localView;
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691667, "field 'iv_arrow_up_out' and method 'OnClick'");
    paramT.iv_arrow_up_out = localView;
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691668, "field 'tv_clear_out' and method 'OnClick'");
    paramT.tv_clear_out = localView;
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691670, "field 'tv_search_city_out' and method 'OnClick'");
    paramT.tv_search_city_out = ((TextView)Utils.castView(localView, 2131691670, "field 'tv_search_city_out'", TextView.class));
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691671, "field 'tv_search_date_out' and method 'OnClick'");
    paramT.tv_search_date_out = ((TextView)Utils.castView(localView, 2131691671, "field 'tv_search_date_out'", TextView.class));
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691672, "field 'tv_search_count_out' and method 'OnClick'");
    paramT.tv_search_count_out = ((TextView)Utils.castView(localView, 2131691672, "field 'tv_search_count_out'", TextView.class));
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691663, "field 'et_search_out' and method 'OnClick'");
    paramT.et_search_out = ((EditText)Utils.castView(localView, 2131691663, "field 'et_search_out'", EditText.class));
    this.n = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691664, "field 'btn_clean_keyword_out' and method 'OnClick'");
    paramT.btn_clean_keyword_out = localView;
    this.o = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramT.rl_clear_container = Utils.findRequiredView(paramView, 2131691654, "field 'rl_clear_container'");
    localView = Utils.findRequiredView(paramView, 2131691655, "field 'tv_search_condition_combination' and method 'OnClick'");
    paramT.tv_search_condition_combination = ((TextView)Utils.castView(localView, 2131691655, "field 'tv_search_condition_combination'", TextView.class));
    this.p = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691652, "field 'ic_minsu_map' and method 'OnClick'");
    paramT.ic_minsu_map = localView;
    this.q = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696328, "method 'OnClick'");
    this.r = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696325, "method 'OnClick'");
    this.s = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696321, "method 'OnClick'");
    this.t = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689936, "method 'OnClick'");
    this.u = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691399, "method 'OnClick'");
    this.v = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691662, "method 'OnClick'");
    this.w = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.OnClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131691405, "method 'OnClick'");
    this.x = paramView;
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
    MinsuSearchListActivity localMinsuSearchListActivity = this.a;
    if (localMinsuSearchListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuSearchListActivity.slsv_root = null;
    localMinsuSearchListActivity.rl_title_container = null;
    localMinsuSearchListActivity.ll_search_container = null;
    localMinsuSearchListActivity.ctl_tab_container = null;
    localMinsuSearchListActivity.rl_search_lite_container = null;
    localMinsuSearchListActivity.vp_fragment_container = null;
    localMinsuSearchListActivity.ll_minsu_search_condition_bottom = null;
    localMinsuSearchListActivity.tv_location = null;
    localMinsuSearchListActivity.tv_condition = null;
    localMinsuSearchListActivity.tv_sort = null;
    localMinsuSearchListActivity.tv_condition_num = null;
    localMinsuSearchListActivity.iv_condition = null;
    localMinsuSearchListActivity.et_search = null;
    localMinsuSearchListActivity.tv_search_city = null;
    localMinsuSearchListActivity.tv_search_date = null;
    localMinsuSearchListActivity.tv_search_count = null;
    localMinsuSearchListActivity.tv_info = null;
    localMinsuSearchListActivity.tv_clear_global_condition = null;
    localMinsuSearchListActivity.btn_clean_keyword = null;
    localMinsuSearchListActivity.ll_search_cover_container = null;
    localMinsuSearchListActivity.iv_arrow_up_out = null;
    localMinsuSearchListActivity.tv_clear_out = null;
    localMinsuSearchListActivity.tv_search_city_out = null;
    localMinsuSearchListActivity.tv_search_date_out = null;
    localMinsuSearchListActivity.tv_search_count_out = null;
    localMinsuSearchListActivity.et_search_out = null;
    localMinsuSearchListActivity.btn_clean_keyword_out = null;
    localMinsuSearchListActivity.rl_clear_container = null;
    localMinsuSearchListActivity.tv_search_condition_combination = null;
    localMinsuSearchListActivity.ic_minsu_map = null;
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
    this.s.setOnClickListener(null);
    this.s = null;
    this.t.setOnClickListener(null);
    this.t = null;
    this.u.setOnClickListener(null);
    this.u = null;
    this.v.setOnClickListener(null);
    this.v = null;
    this.w.setOnClickListener(null);
    this.w = null;
    this.x.setOnClickListener(null);
    this.x = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/MinsuSearchListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */