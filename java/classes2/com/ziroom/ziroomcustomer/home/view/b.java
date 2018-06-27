package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.contract.New_ZiroomClubActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.CustomGallery;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuMapActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuProjectListOptiActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.ActivityBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.BusinessBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.CityBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.CityBean.CityNameBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.CommunityBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.CommunityBean.CommunitylistBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.HeadBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.HeadBean.BannarBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.RecommendBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.RecommendBean.CityNameBeanX;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.ZiroomerBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.HomePageBeanZRY.ZiroomerBean.ZiroomerlistBean;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuHomePageZiroomerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
{
  private Context a;
  private View b;
  private HomePageBeanZRY c;
  private SimpleDraweeView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private LinearLayout h;
  private TextView i;
  private LinearLayout j;
  private LinearLayout k;
  private HomeRecyclerViewZryu l;
  private ConvenientBanner m;
  private RelativeLayout n;
  private CustomGallery o;
  private TextView p;
  private TextView q;
  private LinearLayout r;
  private TextView s;
  private TextView t;
  private LinearLayout u;
  private TextView v;
  private TextView w;
  private boolean x = true;
  
  public b(View paramView, Context paramContext)
  {
    this.a = paramContext;
    this.b = paramView;
    a();
  }
  
  private View a(final HomePageBeanZRY.CityBean.CityNameBean paramCityNameBean)
  {
    if (paramCityNameBean == null) {
      return null;
    }
    View localView = LayoutInflater.from(this.a).inflate(2130904224, null, false);
    Object localObject = (SimpleDraweeView)localView.findViewById(2131695054);
    TextView localTextView1 = (TextView)localView.findViewById(2131694971);
    TextView localTextView2 = (TextView)localView.findViewById(2131695055);
    ((SimpleDraweeView)localObject).setController(c.frescoController(x.makeUrl(paramCityNameBean.getImg(), 0.5F)));
    localTextView1.setText(paramCityNameBean.getTitle());
    localTextView2.setText(paramCityNameBean.getDescription());
    float f1 = this.a.getResources().getDisplayMetrics().density;
    localObject = new LinearLayout.LayoutParams(0, (int)(111.0F * f1), 1.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(3.0F * f1));
    ((LinearLayout.LayoutParams)localObject).rightMargin = ((int)(f1 * 3.0F));
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(b.c(b.this), ZryuMapActivity.class);
        paramAnonymousView.putExtra("citycode", paramCityNameBean.getTarget());
        b.c(b.this).startActivity(paramAnonymousView);
      }
    });
    return localView;
  }
  
  private void a()
  {
    this.h = ((LinearLayout)this.b.findViewById(2131690589));
    this.d = ((SimpleDraweeView)this.b.findViewById(2131690753));
    this.e = ((ImageView)this.b.findViewById(2131690754));
    this.f = ((TextView)this.b.findViewById(2131690787));
    this.g = ((TextView)this.b.findViewById(2131690788));
    this.i = ((TextView)this.b.findViewById(2131696554));
    this.j = ((LinearLayout)this.b.findViewById(2131696555));
    this.k = ((LinearLayout)this.b.findViewById(2131690789));
    this.l = ((HomeRecyclerViewZryu)this.b.findViewById(2131690790));
    this.m = ((ConvenientBanner)this.b.findViewById(2131690791));
    this.m.setClickable(true);
    this.p = ((TextView)this.b.findViewById(2131690770));
    this.q = ((TextView)this.b.findViewById(2131690771));
    this.n = ((RelativeLayout)this.b.findViewById(2131690767));
    this.o = ((CustomGallery)this.b.findViewById(2131690773));
    this.o.setmPager(((MainActivity)this.a).c);
    this.o.setClickable(true);
    this.r = ((LinearLayout)this.b.findViewById(2131690794));
    this.u = ((LinearLayout)this.b.findViewById(2131690795));
    this.v = ((TextView)this.b.findViewById(2131690796));
    this.w = ((TextView)this.b.findViewById(2131690797));
    this.s = ((TextView)this.b.findViewById(2131690776));
    this.t = ((TextView)this.b.findViewById(2131690793));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ("0".equals(paramString1))
    {
      paramString1 = new Intent(this.a, HomeWebActivity.class);
      paramString1.putExtra("url", paramString2);
      paramString1.putExtra("title", paramString3);
      paramString1.putExtra("houseType", 3);
      this.a.startActivity(paramString1);
    }
    while (!"1".equals(paramString1)) {
      return;
    }
    com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(this.a, paramString2);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ("0".equals(paramString1)) {
      JsBridgeWebActivity.start(this.a, paramString3, paramString2, true, paramString5, paramString4, false);
    }
    do
    {
      return;
      if ("1".equals(paramString1))
      {
        com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(this.a, paramString2);
        return;
      }
    } while (!"3".equals(paramString1));
  }
  
  private void b()
  {
    if ((this.c == null) || (this.a == null) || (this.b == null)) {
      return;
    }
    j();
    k();
    h();
    i();
    f();
    e();
    g();
    d();
    c();
  }
  
  private void c()
  {
    HomePageBeanZRY.BusinessBean localBusinessBean = this.c.getBusiness();
    if (localBusinessBean == null)
    {
      this.u.setVisibility(8);
      return;
    }
    this.u.setVisibility(0);
    this.v.setText("邮箱：" + localBusinessBean.getBusiness_mail());
    this.w.setText("联系电话：" + localBusinessBean.getBusiness_tel());
  }
  
  private void d()
  {
    final List localList = this.c.getZiroomer().getZiroomerlist();
    if ((localList == null) || (localList.size() < 1)) {}
    do
    {
      return;
      this.s.setText(this.c.getZiroomer().getTitle());
      this.t.setText(this.c.getZiroomer().getSub_title());
      this.r.removeAllViews();
      if (localList.size() > 3) {}
      for (int i1 = 3;; i1 = localList.size())
      {
        int i2 = 0;
        while (i2 < i1)
        {
          localObject = new ZryuHomePageZiroomerView(this.a);
          ((ZryuHomePageZiroomerView)localObject).setContent((HomePageBeanZRY.ZiroomerBean.ZiroomerlistBean)localList.get(i2));
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.topMargin = ((int)(this.a.getResources().getDisplayMetrics().density * 16.0F));
          ((ZryuHomePageZiroomerView)localObject).setLayoutParams(localLayoutParams);
          ((ZryuHomePageZiroomerView)localObject).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(b.c(b.this), HomeWebActivity.class);
              paramAnonymousView.putExtra("url", this.a.getUrl());
              paramAnonymousView.putExtra("title", this.a.getTitle());
              paramAnonymousView.putExtra("content", this.a.getSubtitle());
              paramAnonymousView.putExtra("pic", this.a.getPic());
              paramAnonymousView.putExtra("ziru", "homeService");
              b.c(b.this).startActivity(paramAnonymousView);
            }
          });
          this.r.addView((View)localObject);
          i2 += 1;
        }
      }
    } while (localList.size() <= 3);
    Object localObject = new TextView(this.a);
    ((TextView)localObject).setTextSize(2, 14.0F);
    ((TextView)localObject).setTextColor(this.a.getResources().getColor(2131624417));
    ((TextView)localObject).setBackgroundResource(2130837959);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText("更多自如客故事");
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    float f1 = this.a.getResources().getDisplayMetrics().density;
    localLayoutParams.topMargin = ((int)(16.0F * f1));
    localLayoutParams.height = ((int)(f1 * 48.0F));
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new ArrayList();
        int i = 0;
        while (i < localList.size())
        {
          localObject = new ContentBean();
          HomePageBeanZRY.ZiroomerBean.ZiroomerlistBean localZiroomerlistBean = (HomePageBeanZRY.ZiroomerBean.ZiroomerlistBean)localList.get(i);
          ((ContentBean)localObject).setTitle(localZiroomerlistBean.getTitle());
          ((ContentBean)localObject).setSubtitle(localZiroomerlistBean.getSubtitle());
          ((ContentBean)localObject).setLink(localZiroomerlistBean.getUrl());
          ((ContentBean)localObject).setType(localZiroomerlistBean.getTypes());
          ((ContentBean)localObject).setPic(localZiroomerlistBean.getPic());
          paramAnonymousView.add(localObject);
          i += 1;
        }
        Object localObject = new Intent(b.c(b.this), ZiroomerListActivity.class);
        ((Intent)localObject).putExtra("ziroomers", (Serializable)paramAnonymousView);
        ((Intent)localObject).putExtra("title", "自如客故事");
        b.c(b.this).startActivity((Intent)localObject);
      }
    });
    this.r.addView((View)localObject);
  }
  
  private void e()
  {
    List localList = this.c.getActivity();
    if ((localList == null) || (localList.size() < 1)) {
      return;
    }
    new com.ziroom.ziroomcustomer.home.a.b(this.a, localList);
  }
  
  private void f()
  {
    if ((this.c.getActivity() == null) || (this.c.getActivity().size() < 1))
    {
      this.m.setVisibility(8);
      return;
    }
    this.m.setVisibility(0);
    final List localList = this.c.getActivity();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < localList.size())
    {
      localArrayList.add(((HomePageBeanZRY.ActivityBean)localList.get(i1)).getImg());
      i1 += 1;
    }
    this.m.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public b.a createHolder()
      {
        return new b.a(b.this, null);
      }
    }, localArrayList).setPageIndicator(new int[] { 2130839320, 2130839312 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        HomePageBeanZRY.ActivityBean localActivityBean = (HomePageBeanZRY.ActivityBean)localList.get(paramAnonymousInt);
        if ("1".equals(localActivityBean.getApp()))
        {
          b.a(b.this, "1", localActivityBean.getTarget(), "");
          return;
        }
        JsBridgeWebActivity.start(b.c(b.this), localActivityBean.getTitle(), localActivityBean.getTarget(), true, localActivityBean.getDescription(), localActivityBean.getImg(), false);
      }
    }).setPointViewVisible(true);
    this.m.startTurning(5000L);
  }
  
  private void g()
  {
    final List localList = this.c.getCommunity().getCommunitylist();
    if ((localList == null) || (localList.size() < 1))
    {
      this.n.setVisibility(8);
      return;
    }
    this.n.setVisibility(0);
    com.ziroom.ziroomcustomer.home.a.d locald = new com.ziroom.ziroomcustomer.home.a.d(this.a, localList);
    this.o.setAdapter(locald);
    this.o.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (HomePageBeanZRY.CommunityBean.CommunitylistBean)localList.get(paramAnonymousInt);
        JsBridgeWebActivity.start(b.c(b.this), paramAnonymousAdapterView.getTitle(), paramAnonymousAdapterView.getUrl(), true, paramAnonymousAdapterView.getSubtitle(), paramAnonymousAdapterView.getPic(), false);
      }
    });
    this.q.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(b.c(b.this), New_ZiroomClubActivity.class);
        paramAnonymousView.putExtra("isZryu", "zryu");
        b.c(b.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void h()
  {
    if ((this.c.getCity() == null) || (this.c.getCity().getCity_name() == null) || (this.c.getCity().getCity_name().size() < 1)) {
      this.k.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.k.setVisibility(0);
      Object localObject = this.c.getCity();
      this.i.setText(((HomePageBeanZRY.CityBean)localObject).getTitle());
      this.j.removeAllViews();
      localObject = ((HomePageBeanZRY.CityBean)localObject).getCity_name().iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = a((HomePageBeanZRY.CityBean.CityNameBean)((Iterator)localObject).next());
        if (localView != null) {
          this.j.addView(localView);
        }
      }
    }
  }
  
  private void i()
  {
    if ((this.c.getRecommend() == null) || (this.c.getRecommend().getList() == null) || (this.c.getRecommend().getList().size() < 1))
    {
      this.l.setVisibility(8);
      return;
    }
    Object localObject = this.c.getRecommend();
    this.l.setVisibility(0);
    this.l.setTitle(((HomePageBeanZRY.RecommendBean)localObject).getTitle());
    this.l.setSubTitle(((HomePageBeanZRY.RecommendBean)localObject).getSubtitle());
    final ArrayList localArrayList = new ArrayList();
    localObject = ((HomePageBeanZRY.RecommendBean)localObject).getList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      HomePageBeanZRY.RecommendBean.CityNameBeanX localCityNameBeanX = (HomePageBeanZRY.RecommendBean.CityNameBeanX)((Iterator)localObject).next();
      ContentBean localContentBean = new ContentBean();
      localContentBean.setTitle(localCityNameBeanX.getTitle());
      localContentBean.setSubtitle(localCityNameBeanX.getSub_title());
      localContentBean.setShare_title(localCityNameBeanX.getShare_title());
      localContentBean.setShare_content(localCityNameBeanX.getShare_desc());
      localContentBean.setPic(localCityNameBeanX.getImg());
      localContentBean.setLink(localCityNameBeanX.getTarget());
      localContentBean.setType(localCityNameBeanX.getApp());
      localArrayList.add(localContentBean);
    }
    this.l.setData(this.a, localArrayList, 0);
    this.l.setOnClickListener(new HomeCListCtrlView.b()
    {
      public void onClick()
      {
        Intent localIntent = new Intent(b.c(b.this), ZryuProjectListOptiActivity.class);
        if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
          localIntent.putExtra("citycode", com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode());
        }
        b.c(b.this).startActivity(localIntent);
      }
      
      public void onItemClick(int paramAnonymousInt)
      {
        ContentBean localContentBean = (ContentBean)localArrayList.get(paramAnonymousInt);
        b.a(b.this, localContentBean.getType(), localContentBean.getLink(), localContentBean.getShare_title(), localContentBean.getPic(), localContentBean.getShare_content());
      }
    });
  }
  
  private void j()
  {
    if (this.c.getHead() == null) {
      return;
    }
    this.f.setText(this.c.getHead().getTitle());
    this.g.setText(this.c.getHead().getSub_title());
  }
  
  private void k()
  {
    if ((this.c.getHead() == null) || (this.c.getHead().getBannar() == null)) {
      return;
    }
    final HomePageBeanZRY.HeadBean localHeadBean = this.c.getHead();
    final HomePageBeanZRY.HeadBean.BannarBean localBannarBean = this.c.getHead().getBannar();
    String str = x.makeUrl(localBannarBean.getImg());
    this.d.setController(c.frescoController(str));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.a(b.this, localBannarBean.getType(), localBannarBean.getTarget(), localHeadBean.getTitle(), localBannarBean.getImg(), localHeadBean.getSub_title());
      }
    });
  }
  
  public void detach()
  {
    this.b = null;
    this.a = null;
  }
  
  public void loadData()
  {
    if ((!ah.checkNet(this.a)) || (!this.x)) {
      return;
    }
    String str = "110000";
    if (com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity() != null) {
      str = com.ziroom.ziroomcustomer.base.b.getZryuCurrentCity().getCode();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("city_code", str);
    j.getCommonJsonGate(this.a, q.o + q.ae, localHashMap, new com.ziroom.ziroomcustomer.e.a.e(this.a, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.a(b.this).setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        if (paramAnonymouse != null)
        {
          b.a(b.this, (HomePageBeanZRY)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), HomePageBeanZRY.class));
          b.a(b.this).setVisibility(0);
          b.b(b.this);
        }
        for (;;)
        {
          b.a(b.this, false);
          return;
          b.a(b.this).setVisibility(8);
        }
      }
    });
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */