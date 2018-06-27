package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.SearchListScrollView;
import com.ziroom.ziroomcustomer.minsu.view.IntellectDeviceView;

public class MinsuLandLordMainNewActivity_ViewBinding<T extends MinsuLandLordMainNewActivity>
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
  
  public MinsuLandLordMainNewActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_icon_status = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691482, "field 'tv_icon_status'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691481, "field 'myinfoIvIcon' and method 'onViewClicked'");
    paramT.myinfoIvIcon = ((SimpleDraweeView)Utils.castView(localView, 2131691481, "field 'myinfoIvIcon'", SimpleDraweeView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692018, "field 'myinfoTvName' and method 'onViewClicked'");
    paramT.myinfoTvName = ((TextView)Utils.castView(localView, 2131692018, "field 'myinfoTvName'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.myinfoTvRole = ((TextView)Utils.findRequiredViewAsType(paramView, 2131696888, "field 'myinfoTvRole'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131696352, "field 'myinfoTvLogin' and method 'onViewClicked'");
    paramT.myinfoTvLogin = ((TextView)Utils.castView(localView, 2131696352, "field 'myinfoTvLogin'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696878, "field 'myinfoMessage' and method 'onViewClicked'");
    paramT.myinfoMessage = ((IntellectDeviceView)Utils.castView(localView, 2131696878, "field 'myinfoMessage'", IntellectDeviceView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696879, "field 'myinfoOrders' and method 'onViewClicked'");
    paramT.myinfoOrders = ((IntellectDeviceView)Utils.castView(localView, 2131696879, "field 'myinfoOrders'", IntellectDeviceView.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696880, "field 'myinfoEvaluation' and method 'onViewClicked'");
    paramT.myinfoEvaluation = ((IntellectDeviceView)Utils.castView(localView, 2131696880, "field 'myinfoEvaluation'", IntellectDeviceView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696881, "field 'myinfoHouseMessage' and method 'onViewClicked'");
    paramT.myinfoHouseMessage = ((IntellectDeviceView)Utils.castView(localView, 2131696881, "field 'myinfoHouseMessage'", IntellectDeviceView.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696882, "field 'myinfoOverage' and method 'onViewClicked'");
    paramT.myinfoOverage = ((IntellectDeviceView)Utils.castView(localView, 2131696882, "field 'myinfoOverage'", IntellectDeviceView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696883, "field 'myinfoPrePaidCard' and method 'onViewClicked'");
    paramT.myinfoPrePaidCard = ((IntellectDeviceView)Utils.castView(localView, 2131696883, "field 'myinfoPrePaidCard'", IntellectDeviceView.class));
    this.j = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696884, "field 'myinfoVoucher' and method 'onViewClicked'");
    paramT.myinfoVoucher = ((IntellectDeviceView)Utils.castView(localView, 2131696884, "field 'myinfoVoucher'", IntellectDeviceView.class));
    this.k = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131696885, "field 'myinfoMove' and method 'onViewClicked'");
    paramT.myinfoMove = ((IntellectDeviceView)Utils.castView(localView, 2131696885, "field 'myinfoMove'", IntellectDeviceView.class));
    this.l = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.viewpage = ((ViewPager)Utils.findRequiredViewAsType(paramView, 2131690262, "field 'viewpage'", ViewPager.class));
    localView = Utils.findRequiredView(paramView, 2131691474, "field 'tvChangeMode' and method 'onViewClicked'");
    paramT.tvChangeMode = ((TextView)Utils.castView(localView, 2131691474, "field 'tvChangeMode'", TextView.class));
    this.m = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.cb = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690977, "field 'cb'", ConvenientBanner.class));
    paramT.appBarLayout = ((AppBarLayout)Utils.findRequiredViewAsType(paramView, 2131691403, "field 'appBarLayout'", AppBarLayout.class));
    paramT.coordinatorLayout = ((SearchListScrollView)Utils.findRequiredViewAsType(paramView, 2131691402, "field 'coordinatorLayout'", SearchListScrollView.class));
    paramT.tabs = ((TabLayout)Utils.findRequiredViewAsType(paramView, 2131690261, "field 'tabs'", TabLayout.class));
    paramT.bottomLine = Utils.findRequiredView(paramView, 2131690079, "field 'bottomLine'");
    paramT.todayHintPic = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691485, "field 'todayHintPic'", SimpleDraweeView.class));
    paramT.closeToday = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691486, "field 'closeToday'", ImageView.class));
    paramT.llTodayHint = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691484, "field 'llTodayHint'", RelativeLayout.class));
    localView = Utils.findRequiredView(paramView, 2131691475, "field 'tvReleaseHouse' and method 'onViewClicked'");
    paramT.tvReleaseHouse = ((TextView)Utils.castView(localView, 2131691475, "field 'tvReleaseHouse'", TextView.class));
    this.n = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.swipeRefreshLayout = ((SwipeRefreshLayout)Utils.findRequiredViewAsType(paramView, 2131691476, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class));
    localView = Utils.findRequiredView(paramView, 2131696889, "field 'll_emblem_bg' and method 'onViewClicked'");
    paramT.ll_emblem_bg = ((FrameLayout)Utils.castView(localView, 2131696889, "field 'll_emblem_bg'", FrameLayout.class));
    this.o = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.ll_emblem = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696890, "field 'll_emblem'", LinearLayout.class));
    paramT.tv_icon_emblem = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691483, "field 'tv_icon_emblem'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131691479, "field 'tv_emblem_hint' and method 'onViewClicked'");
    paramT.tv_emblem_hint = ((TextView)Utils.castView(localView, 2131691479, "field 'tv_emblem_hint'", TextView.class));
    this.p = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.flPhoto = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691480, "field 'flPhoto'", FrameLayout.class));
    paramT.myinfoUserinfoWrap = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131691477, "field 'myinfoUserinfoWrap'", RelativeLayout.class));
    paramT.llMyinfo = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131696887, "field 'llMyinfo'", LinearLayout.class));
    paramView = Utils.findRequiredView(paramView, 2131691473, "method 'onViewClicked'");
    this.q = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    MinsuLandLordMainNewActivity localMinsuLandLordMainNewActivity = this.a;
    if (localMinsuLandLordMainNewActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuLandLordMainNewActivity.tv_icon_status = null;
    localMinsuLandLordMainNewActivity.myinfoIvIcon = null;
    localMinsuLandLordMainNewActivity.myinfoTvName = null;
    localMinsuLandLordMainNewActivity.myinfoTvRole = null;
    localMinsuLandLordMainNewActivity.myinfoTvLogin = null;
    localMinsuLandLordMainNewActivity.myinfoMessage = null;
    localMinsuLandLordMainNewActivity.myinfoOrders = null;
    localMinsuLandLordMainNewActivity.myinfoEvaluation = null;
    localMinsuLandLordMainNewActivity.myinfoHouseMessage = null;
    localMinsuLandLordMainNewActivity.myinfoOverage = null;
    localMinsuLandLordMainNewActivity.myinfoPrePaidCard = null;
    localMinsuLandLordMainNewActivity.myinfoVoucher = null;
    localMinsuLandLordMainNewActivity.myinfoMove = null;
    localMinsuLandLordMainNewActivity.viewpage = null;
    localMinsuLandLordMainNewActivity.tvChangeMode = null;
    localMinsuLandLordMainNewActivity.cb = null;
    localMinsuLandLordMainNewActivity.appBarLayout = null;
    localMinsuLandLordMainNewActivity.coordinatorLayout = null;
    localMinsuLandLordMainNewActivity.tabs = null;
    localMinsuLandLordMainNewActivity.bottomLine = null;
    localMinsuLandLordMainNewActivity.todayHintPic = null;
    localMinsuLandLordMainNewActivity.closeToday = null;
    localMinsuLandLordMainNewActivity.llTodayHint = null;
    localMinsuLandLordMainNewActivity.tvReleaseHouse = null;
    localMinsuLandLordMainNewActivity.swipeRefreshLayout = null;
    localMinsuLandLordMainNewActivity.ll_emblem_bg = null;
    localMinsuLandLordMainNewActivity.ll_emblem = null;
    localMinsuLandLordMainNewActivity.tv_icon_emblem = null;
    localMinsuLandLordMainNewActivity.tv_emblem_hint = null;
    localMinsuLandLordMainNewActivity.flPhoto = null;
    localMinsuLandLordMainNewActivity.myinfoUserinfoWrap = null;
    localMinsuLandLordMainNewActivity.llMyinfo = null;
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
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandLordMainNewActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */