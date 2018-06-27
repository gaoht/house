package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.contract.New_ZiroomClubActivity;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.home.a.a;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo;
import com.ziroom.ziroomcustomer.home.bean.HomePageBannerInfo.DataBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageInfo;
import com.ziroom.ziroomcustomer.life.ZirukeDetailActivity;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.widget.CustomGallery;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.ziroomstation.ZiroomStationMainActivity;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.StationProjectDetailActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePageFragmentZYI
  extends BaseFragment
  implements View.OnClickListener
{
  private com.ziroom.ziroomcustomer.home.a.c A;
  private TextView B;
  private ImageView C;
  public boolean a = false;
  boolean b = true;
  public double[] c;
  private int d = 4;
  private int e = 5;
  private TextView f;
  private TextView g;
  private Context h;
  private LinearLayout i;
  private LinearLayout j;
  private LinearLayout k;
  private LinearLayout l;
  private LinearLayout m;
  private ObservableScrollView n;
  private ImageView o;
  private SimpleDraweeView p;
  private CustomGallery q;
  private CustomGallery r;
  private CustomGallery s;
  private SearchCondition t;
  private HomePageInfo u = new HomePageInfo();
  private HomePageBannerInfo v = new HomePageBannerInfo();
  private HomePageBannerInfo w = new HomePageBannerInfo();
  private HomePageBannerInfo x = new HomePageBannerInfo();
  private HomePageBannerInfo y = new HomePageBannerInfo();
  private a z;
  
  private void a(View paramView)
  {
    this.B = ((TextView)paramView.findViewById(2131690761));
    this.C = ((ImageView)paramView.findViewById(2131690762));
    this.B.setVisibility(0);
    this.C.setVisibility(0);
    this.B.setOnClickListener(this);
    this.f = ((TextView)paramView.findViewById(2131690755));
    this.g = ((TextView)paramView.findViewById(2131690756));
    this.o = ((ImageView)paramView.findViewById(2131690751));
    this.p = ((SimpleDraweeView)paramView.findViewById(2131690753));
    Object localObject = (WindowManager)getActivity().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    localObject = this.p.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = localDisplayMetrics.widthPixels;
    ((ViewGroup.LayoutParams)localObject).height = localDisplayMetrics.widthPixels;
    this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.l = ((LinearLayout)paramView.findViewById(2131690786));
    this.r = ((CustomGallery)paramView.findViewById(2131690763));
    this.s = ((CustomGallery)paramView.findViewById(2131690766));
    this.s.setmPager(((MainActivity)getActivity()).c);
    this.r.setmPager(((MainActivity)getActivity()).c);
    this.q = ((CustomGallery)paramView.findViewById(2131690773));
    this.q.setmPager(((MainActivity)this.h).c);
    this.r.setClickable(true);
    this.q.setClickable(true);
    this.s.setClickable(true);
    GrowingIO.setViewContent(this.r, "自如驿首页房源推荐");
    GrowingIO.setViewContent(this.q, "自如驿首页最新活动");
    GrowingIO.setViewContent(this.s, "自如驿首页社区生活");
  }
  
  private void a(List<HomePageBannerInfo.DataBean> paramList)
  {
    Object localObject;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 0) {}
    }
    else
    {
      localObject = new ArrayList();
      ((List)localObject).add(new HomePageBannerInfo.DataBean());
    }
    this.A = new com.ziroom.ziroomcustomer.home.a.c(this.h, (List)localObject, 2);
    this.q.setAdapter(this.A);
  }
  
  private void c()
  {
    this.p.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnScrollChangedCallback(this);
    this.q.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((HomePageFragmentZYI.a(HomePageFragmentZYI.this).getData() != null) && (HomePageFragmentZYI.a(HomePageFragmentZYI.this).getData().size() > 0))
        {
          paramAnonymousAdapterView = (HomePageBannerInfo.DataBean)HomePageFragmentZYI.a(HomePageFragmentZYI.this).getData().get(paramAnonymousInt);
          if ("1".equalsIgnoreCase(paramAnonymousAdapterView.getTypes()))
          {
            paramAnonymousView = new Intent(HomePageFragmentZYI.b(HomePageFragmentZYI.this), ZirukeDetailActivity.class);
            paramAnonymousView.putExtra("url", paramAnonymousAdapterView.getUrl());
            paramAnonymousView.putExtra("title", paramAnonymousAdapterView.getTitle());
            paramAnonymousView.putExtra("pic", paramAnonymousAdapterView.getPic());
            HomePageFragmentZYI.b(HomePageFragmentZYI.this).startActivity(paramAnonymousView);
            if (HomePageFragmentZYI.c(HomePageFragmentZYI.this) != 1) {
              break label157;
            }
            MobclickAgent.onEvent(HomePageFragmentZYI.b(HomePageFragmentZYI.this), "joint_community_life");
          }
        }
        return;
        label157:
        MobclickAgent.onEvent(HomePageFragmentZYI.b(HomePageFragmentZYI.this), "entire_community_life");
      }
    });
    this.r.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((HomePageFragmentZYI.d(HomePageFragmentZYI.this).getData() != null) && (HomePageFragmentZYI.d(HomePageFragmentZYI.this).getData().size() > 0))
        {
          paramAnonymousAdapterView = (HomePageBannerInfo.DataBean)HomePageFragmentZYI.d(HomePageFragmentZYI.this).getData().get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.getId()))
          {
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("pid", paramAnonymousAdapterView.getId());
            w.onEventValueToZiroomAndUmeng("zinn_home_num", paramAnonymousView);
          }
          if (!"0".equals(paramAnonymousAdapterView.getUrl())) {
            break label110;
          }
        }
        label110:
        do
        {
          return;
          if ("0".equals(paramAnonymousAdapterView.getTypes()))
          {
            paramAnonymousView = new Intent(HomePageFragmentZYI.b(HomePageFragmentZYI.this), StationProjectDetailActivity.class);
            paramAnonymousView.putExtra("projectBid", paramAnonymousAdapterView.getUrl());
            HomePageFragmentZYI.b(HomePageFragmentZYI.this).startActivity(paramAnonymousView);
            return;
          }
        } while (!"1".equals(paramAnonymousAdapterView.getTypes()));
        paramAnonymousView = new Intent(HomePageFragmentZYI.b(HomePageFragmentZYI.this), HomeWebActivity.class);
        paramAnonymousView.putExtra("url", paramAnonymousAdapterView.getUrl());
        paramAnonymousView.putExtra("title", paramAnonymousAdapterView.getTitle());
        paramAnonymousView.putExtra("content", paramAnonymousAdapterView.getSubtitle());
        paramAnonymousView.putExtra("houseType", HomePageFragmentZYI.c(HomePageFragmentZYI.this));
        HomePageFragmentZYI.this.startActivity(paramAnonymousView);
      }
    });
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((HomePageFragmentZYI.e(HomePageFragmentZYI.this).getData() != null) && (HomePageFragmentZYI.e(HomePageFragmentZYI.this).getData().size() > 0))
        {
          paramAnonymousAdapterView = (HomePageBannerInfo.DataBean)HomePageFragmentZYI.e(HomePageFragmentZYI.this).getData().get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.getId()))
          {
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("id", paramAnonymousAdapterView.getId());
            w.onEventValueToZiroomAndUmeng("zinn_home_sale", paramAnonymousView);
          }
          if ("1".equalsIgnoreCase(paramAnonymousAdapterView.getTypes()))
          {
            paramAnonymousView = new Intent(HomePageFragmentZYI.b(HomePageFragmentZYI.this), ZiRuWebViewActivity.class);
            paramAnonymousView.putExtra("ziru", "ziruviewpager");
            paramAnonymousView.putExtra("url", paramAnonymousAdapterView.getUrl());
            paramAnonymousView.putExtra("title", paramAnonymousAdapterView.getTitle());
            paramAnonymousView.putExtra("pic", paramAnonymousAdapterView.getPic());
            HomePageFragmentZYI.b(HomePageFragmentZYI.this).startActivity(paramAnonymousView);
          }
        }
      }
    });
  }
  
  private void d()
  {
    Map localMap = g.buildHomeBigLogData(this.d);
    j.getHomeBigLog(getActivity(), new a(), localMap, true);
    localMap = g.buildGameData(this.d);
    j.getHomeBigLog(getActivity(), new b(), localMap, true);
    localMap = g.buildReconmandData(this.e);
    j.getHomeBigLog(getActivity(), new c(), localMap, true);
    localMap = g.buildCommunityData(this.d);
    j.getHomeBigLog(this.h, new d(), localMap, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.a = ApplicationEx.c.isLoginState();
    this.t = new SearchCondition();
    this.c = ApplicationEx.c.getLatlng_array();
    if ((this.c != null) && (this.c.length >= 4))
    {
      this.t.setMin_lat(String.valueOf(this.c[0]));
      this.t.setMin_lng(String.valueOf(this.c[1]));
      this.t.setMax_lat(String.valueOf(this.c[2]));
      this.t.setMax_lng(String.valueOf(this.c[3]));
    }
    switch (paramView.getId())
    {
    default: 
    case 2131690753: 
      do
      {
        do
        {
          return;
        } while ((this.v == null) || (this.v.getData() == null) || (this.v.getData().get(0) == null));
        paramView = (HomePageBannerInfo.DataBean)this.v.getData().get(0);
        if ("1".equals(paramView.getTypes()))
        {
          localIntent = new Intent(this.h, HomeWebActivity.class);
          localIntent.putExtra("url", paramView.getUrl());
          localIntent.putExtra("title", paramView.getTitle());
          localIntent.putExtra("content", paramView.getSubtitle());
          localIntent.putExtra("houseType", this.d);
          this.h.startActivity(localIntent);
          return;
        }
      } while (!"0".equals(paramView.getTypes()));
      Intent localIntent = new Intent(this.h, StationProjectDetailActivity.class);
      localIntent.putExtra("projectBid", paramView.getUrl());
      this.h.startActivity(localIntent);
      return;
    case 2131690768: 
      w.onEvent(this.h, "home_activity_more");
      startActivity(new Intent(this.h, New_ZiroomClubActivity.class));
      return;
    }
    startActivity(new Intent(this.h, ZiroomStationMainActivity.class));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.h = getActivity();
    paramLayoutInflater = View.inflate(getActivity(), 2130903198, null);
    this.i = ((LinearLayout)paramLayoutInflater.findViewById(2131690752));
    this.j = ((LinearLayout)paramLayoutInflater.findViewById(2131690589));
    this.k = ((LinearLayout)paramLayoutInflater.findViewById(2131690747));
    this.m = ((LinearLayout)paramLayoutInflater.findViewById(2131690746));
    this.n = ((ObservableScrollView)paramLayoutInflater.findViewById(2131689919));
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    a("zinn_home_duration");
    super.onResume();
  }
  
  public void setMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
      paramView.requestLayout();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.b)
      {
        d();
        this.b = false;
      }
      w.onEventToZiroomAndUmeng("zinn_home");
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (HomePageFragmentZYI.this.getActivity() == null) {}
      do
      {
        do
        {
          return;
        } while (!paramk.getSuccess().booleanValue());
        HomePageFragmentZYI.b(HomePageFragmentZYI.this, (HomePageBannerInfo)paramk.getObject());
      } while ((HomePageFragmentZYI.h(HomePageFragmentZYI.this) == null) || (HomePageFragmentZYI.h(HomePageFragmentZYI.this).getData().size() <= 0));
      int i = (int)(0.0D + Math.random() * HomePageFragmentZYI.h(HomePageFragmentZYI.this).getData().size());
      paramk = new DisplayMetrics();
      HomePageFragmentZYI.i(HomePageFragmentZYI.this).setController(com.freelxl.baselibrary.f.c.frescoResizeController(((HomePageBannerInfo.DataBean)HomePageFragmentZYI.h(HomePageFragmentZYI.this).getData().get(i)).getPic(), paramk.widthPixels, paramk.heightPixels));
      HomePageFragmentZYI.j(HomePageFragmentZYI.this).setText(((HomePageBannerInfo.DataBean)HomePageFragmentZYI.h(HomePageFragmentZYI.this).getData().get(i)).getTitle());
      HomePageFragmentZYI.k(HomePageFragmentZYI.this).setText(((HomePageBannerInfo.DataBean)HomePageFragmentZYI.h(HomePageFragmentZYI.this).getData().get(i)).getSubtitle());
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (HomePageFragmentZYI.this.getActivity() == null) {}
      do
      {
        return;
        if (!paramk.getSuccess().booleanValue()) {
          break;
        }
        HomePageFragmentZYI.d(HomePageFragmentZYI.this, (HomePageBannerInfo)paramk.getObject());
      } while ((HomePageFragmentZYI.e(HomePageFragmentZYI.this) == null) || (HomePageFragmentZYI.e(HomePageFragmentZYI.this).getData() == null));
      if (HomePageFragmentZYI.e(HomePageFragmentZYI.this).getData().size() > 0)
      {
        HomePageFragmentZYI.a(HomePageFragmentZYI.this, new a(HomePageFragmentZYI.this.getActivity(), HomePageFragmentZYI.e(HomePageFragmentZYI.this).getData()));
        HomePageFragmentZYI.n(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.m(HomePageFragmentZYI.this));
        return;
      }
      paramk = new ArrayList();
      paramk.add(new HomePageBannerInfo.DataBean());
      HomePageFragmentZYI.a(HomePageFragmentZYI.this, new a(HomePageFragmentZYI.b(HomePageFragmentZYI.this), paramk));
      HomePageFragmentZYI.n(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.m(HomePageFragmentZYI.this));
      return;
      paramk = new ArrayList();
      paramk.add(new HomePageBannerInfo.DataBean());
      HomePageFragmentZYI.a(HomePageFragmentZYI.this, new a(HomePageFragmentZYI.b(HomePageFragmentZYI.this), paramk));
      HomePageFragmentZYI.n(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.m(HomePageFragmentZYI.this));
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (HomePageFragmentZYI.this.getActivity() == null) {}
      do
      {
        do
        {
          return;
          if (!paramk.getSuccess().booleanValue()) {
            break;
          }
        } while (HomePageFragmentZYI.d(HomePageFragmentZYI.this) == null);
        HomePageFragmentZYI.c(HomePageFragmentZYI.this, (HomePageBannerInfo)paramk.getObject());
      } while (HomePageFragmentZYI.d(HomePageFragmentZYI.this).getData() == null);
      if (HomePageFragmentZYI.d(HomePageFragmentZYI.this).getData().size() > 0)
      {
        HomePageFragmentZYI.a(HomePageFragmentZYI.this, new com.ziroom.ziroomcustomer.home.a.c(HomePageFragmentZYI.this.getActivity(), HomePageFragmentZYI.d(HomePageFragmentZYI.this).getData(), 0));
        HomePageFragmentZYI.l(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.f(HomePageFragmentZYI.this));
        return;
      }
      paramk = new ArrayList();
      paramk.add(new HomePageBannerInfo.DataBean());
      HomePageFragmentZYI.a(HomePageFragmentZYI.this, new com.ziroom.ziroomcustomer.home.a.c(HomePageFragmentZYI.b(HomePageFragmentZYI.this), paramk, 1));
      HomePageFragmentZYI.l(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.f(HomePageFragmentZYI.this));
      return;
      paramk = new ArrayList();
      paramk.add(new HomePageBannerInfo.DataBean());
      HomePageFragmentZYI.a(HomePageFragmentZYI.this, new com.ziroom.ziroomcustomer.home.a.c(HomePageFragmentZYI.b(HomePageFragmentZYI.this), paramk, 1));
      HomePageFragmentZYI.l(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.f(HomePageFragmentZYI.this));
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (HomePageFragmentZYI.b(HomePageFragmentZYI.this) == null) {
        return;
      }
      if (paramk.getSuccess().booleanValue())
      {
        HomePageFragmentZYI.a(HomePageFragmentZYI.this, (HomePageBannerInfo)paramk.getObject());
        HomePageFragmentZYI.a(HomePageFragmentZYI.this, HomePageFragmentZYI.a(HomePageFragmentZYI.this).getData());
        return;
      }
      paramk = new ArrayList();
      paramk.add(new HomePageBannerInfo.DataBean());
      HomePageFragmentZYI.a(HomePageFragmentZYI.this, new com.ziroom.ziroomcustomer.home.a.c(HomePageFragmentZYI.b(HomePageFragmentZYI.this), paramk, 2));
      HomePageFragmentZYI.g(HomePageFragmentZYI.this).setAdapter(HomePageFragmentZYI.f(HomePageFragmentZYI.this));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/HomePageFragmentZYI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */