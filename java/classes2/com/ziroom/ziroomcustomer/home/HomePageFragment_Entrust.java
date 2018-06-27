package com.ziroom.ziroomcustomer.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.YezhuStoryListActivity;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.e.h;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.home.view.HomeRecyclerView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.util.y;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomePageFragment_Entrust
  extends BaseFragment
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private View C;
  private String D;
  private String E;
  private b F;
  private String G;
  private String H;
  private final String I = "1";
  private BroadcastReceiver J = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getAction().equals("select_city")) && (HomePageFragment_Entrust.b(HomePageFragment_Entrust.this) != null)) {
        HomePageFragment_Entrust.b(HomePageFragment_Entrust.this).loadData();
      }
    }
  };
  int a;
  private Context b;
  private HomeRecyclerView c;
  private MyGridView d;
  private HomeRecyclerView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private LinearLayout q;
  private LinearLayout r;
  private LinearLayout s;
  private FrameLayout t;
  private FrameLayout u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(View paramView)
  {
    this.a = this.b.getResources().getDisplayMetrics().widthPixels;
    this.c = ((HomeRecyclerView)paramView.findViewById(2131694066));
    this.C = paramView.findViewById(2131694065);
    this.d = ((MyGridView)paramView.findViewById(2131694067));
    this.d.setSelector(new ColorDrawable(0));
    this.e = ((HomeRecyclerView)paramView.findViewById(2131694068));
    this.i = ((TextView)paramView.findViewById(2131694069));
    this.s = ((LinearLayout)paramView.findViewById(2131694070));
    this.m = ((TextView)paramView.findViewById(2131694071));
    this.o = ((TextView)paramView.findViewById(2131694074));
    this.p = ((TextView)paramView.findViewById(2131694075));
    this.n = ((TextView)paramView.findViewById(2131694072));
    this.q = ((LinearLayout)paramView.findViewById(2131694073));
    this.r = ((LinearLayout)paramView.findViewById(2131694076));
    this.f = ((TextView)paramView.findViewById(2131690459));
    this.g = ((TextView)paramView.findViewById(2131694054));
    this.h = ((TextView)paramView.findViewById(2131694077));
    this.j = ((TextView)paramView.findViewById(2131694055));
    this.l = ((TextView)paramView.findViewById(2131694052));
    this.k = ((TextView)paramView.findViewById(2131694053));
    this.t = ((FrameLayout)paramView.findViewById(2131694056));
    this.v = ((TextView)paramView.findViewById(2131694057));
    this.u = ((FrameLayout)paramView.findViewById(2131694058));
    this.w = ((TextView)paramView.findViewById(2131694059));
    this.x = ((TextView)paramView.findViewById(2131694060));
    this.y = ((TextView)paramView.findViewById(2131694061));
    this.z = ((TextView)paramView.findViewById(2131694062));
    this.A = ((TextView)paramView.findViewById(2131694063));
    this.B = ((TextView)paramView.findViewById(2131694064));
    new LinearLayoutManager(this.b).setOrientation(1);
    this.F = new b(this, getActivity());
    this.F.loadData();
    this.e.setClickable(true);
  }
  
  private void a(com.alibaba.fastjson.e parame)
  {
    Object localObject = parame.getJSONObject("resblock").getString("name") + parame.getJSONObject("building").getString("building_no");
    this.w.setText((CharSequence)localObject);
    localObject = parame.getJSONArray("price");
    if ((localObject != null) && (((com.alibaba.fastjson.b)localObject).size() > 0))
    {
      parame = new ArrayList();
      int i1 = 0;
      while (i1 < ((com.alibaba.fastjson.b)localObject).size())
      {
        parame.add(((com.alibaba.fastjson.e)((com.alibaba.fastjson.b)localObject).get(i1)).getInteger("price"));
        i1 += 1;
      }
      if (parame.size() >= 2)
      {
        localObject = this.x;
        StringBuilder localStringBuilder = new StringBuilder().append("¥");
        if (((Integer)parame.get(0)).intValue() < ((Integer)parame.get(1)).intValue())
        {
          parame = parame.get(0) + "-" + parame.get(1);
          ((TextView)localObject).setText(parame);
        }
      }
      for (;;)
      {
        this.y.setVisibility(0);
        return;
        parame = parame.get(1) + "-" + parame.get(0);
        break;
        if (parame.size() >= 1) {
          this.x.setText("¥" + parame.get(0));
        }
      }
    }
    this.x.setText("暂无估价");
    this.y.setVisibility(8);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    j.getEstimateLastInfo(this.b, new com.freelxl.baselibrary.d.c.a(new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        Log.i("getEstimateDoneLastInfo", "result:" + paramAnonymousString);
        if (TextUtils.isEmpty(paramAnonymousString)) {}
        do
        {
          do
          {
            return;
            paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
          } while (paramAnonymousString == null);
          paramAnonymousString = paramAnonymousString.getJSONArray("houseData");
        } while ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0));
        paramAnonymousString = (com.alibaba.fastjson.e)paramAnonymousString.get(0);
        HomePageFragment_Entrust.a(HomePageFragment_Entrust.this).setText(paramAnonymousString.getString("appInfo"));
      }
    }, g.buildGetEstimateDoneInfo(paramString1, paramString2, paramString3));
  }
  
  private void a(List<ContentBean> paramList)
  {
    float f1 = this.b.getResources().getDisplayMetrics().density;
    this.q.removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final Object localObject = (ContentBean)paramList.next();
        View localView = localLayoutInflater.inflate(2130904189, this.q, false);
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131691098);
        localSimpleDraweeView.setLayoutParams(new RelativeLayout.LayoutParams(this.a, this.a * 2 / 3));
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(x.makeUrl(((ContentBean)localObject).getPic())));
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), localObject.getTitle(), localObject.getLink(), true, localObject.getSubtitle(), localObject.getPic(), false);
          }
        });
        localObject = new LinearLayout.LayoutParams(-1, this.a * 2 / 3);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, (int)(12.0F * f1));
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.q.addView(localView);
      }
    }
  }
  
  private void a(List<ContentBean> paramList, final String paramString)
  {
    this.s.removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final ContentBean localContentBean = (ContentBean)paramList.next();
        View localView = localLayoutInflater.inflate(2130904190, this.s, false);
        Object localObject = (SimpleDraweeView)localView.findViewById(2131691098);
        ((SimpleDraweeView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(this.a, this.a * 226 / 339));
        ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(x.makeUrl(localContentBean.getPic())));
        localObject = (TextView)localView.findViewById(2131694975);
        ((TextView)localObject).setText(localContentBean.getTitle());
        ((TextView)localObject).setVisibility(8);
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), paramString, localContentBean.getLink(), false, "", "", false);
          }
        });
        this.s.addView(localView);
      }
    }
  }
  
  private void b(List<ContentBean> paramList)
  {
    float f1 = this.b.getResources().getDisplayMetrics().density;
    this.r.removeAllViews();
    int i3;
    int i4;
    LayoutInflater localLayoutInflater;
    int i1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i3 = (int)(this.b.getResources().getDisplayMetrics().widthPixels * 0.44D);
      i4 = i3 * 2 / 3;
      localLayoutInflater = LayoutInflater.from(this.b);
      i1 = paramList.size();
      if (paramList.size() <= 3) {
        break label289;
      }
      i1 = 3;
    }
    label289:
    for (;;)
    {
      int i2 = 0;
      while (i2 < i1)
      {
        final Object localObject = (ContentBean)paramList.get(i2);
        View localView = localLayoutInflater.inflate(2130904425, this.r, false);
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131691098);
        localSimpleDraweeView.setLayoutParams(new RelativeLayout.LayoutParams(i3, i4));
        TextView localTextView1 = (TextView)localView.findViewById(2131689541);
        TextView localTextView2 = (TextView)localView.findViewById(2131690071);
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(x.makeUrl(((ContentBean)localObject).getPic(), 0.5F)));
        localTextView1.setText(((ContentBean)localObject).getTitle());
        localTextView2.setText(((ContentBean)localObject).getSubtitle());
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), localObject.getTitle(), localObject.getLink(), true, localObject.getSubtitle(), localObject.getPic(), false);
          }
        });
        localObject = new LinearLayout.LayoutParams(-1, i4);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, (int)(16.0F * f1));
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.r.addView(localView);
        i2 += 1;
      }
      return;
    }
  }
  
  private void c()
  {
    if (ae.notNull(this.H))
    {
      com.alibaba.fastjson.e locale = com.alibaba.fastjson.a.parseObject(this.H);
      if (locale.size() > 0)
      {
        this.t.setVisibility(8);
        this.u.setVisibility(0);
        a(locale);
        a("1", locale.getJSONObject("resblock").getString("code"), locale.getJSONObject("city").getString("name"));
        return;
      }
      this.t.setVisibility(0);
      this.u.setVisibility(8);
      return;
    }
    this.t.setVisibility(0);
    this.u.setVisibility(8);
  }
  
  private void d()
  {
    this.j.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.B.setOnClickListener(this);
  }
  
  public static HomePageFragment_Entrust newInstance()
  {
    HomePageFragment_Entrust localHomePageFragment_Entrust = new HomePageFragment_Entrust();
    localHomePageFragment_Entrust.setArguments(new Bundle());
    return localHomePageFragment_Entrust;
  }
  
  public void bindEntrustProduct(List<ContentBean> paramList, String paramString1, String paramString2)
  {
    this.m.setText(paramString1);
    this.n.setText(paramString2);
    a(paramList);
  }
  
  public void bindEntrustTitle(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.k.setText(paramString4);
    this.l.setText(paramString3);
    this.D = paramString5;
    this.E = paramString6;
  }
  
  public void bindKnowZiroom(final List<ContentBean> paramList, String paramString1, final String paramString2, String paramString3)
  {
    if (paramList == null)
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    this.e.setTitle(paramString1);
    this.e.setSubTitle(null);
    if (ae.isNull(paramString3)) {
      this.e.setData(this.b, paramList, 6);
    }
    for (;;)
    {
      this.e.setOnClickListener(new HomeCListCtrlView.b()
      {
        public void onClick()
        {
          if (ae.notNull(paramString2)) {
            JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), null, paramString2);
          }
        }
        
        public void onItemClick(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 0) {
            HomePageFragment_Entrust.a(HomePageFragment_Entrust.this, HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), "homepage_delegatehouse_understandziroom1");
          }
          for (;;)
          {
            ContentBean localContentBean = (ContentBean)paramList.get(paramAnonymousInt);
            JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), localContentBean.getTitle(), localContentBean.getLink(), true, localContentBean.getSubtitle(), localContentBean.getPic(), false);
            return;
            if (paramAnonymousInt == 1) {
              HomePageFragment_Entrust.b(HomePageFragment_Entrust.this, HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), "homepage_delegatehouse_understandziroom2");
            } else if (paramAnonymousInt == 2) {
              HomePageFragment_Entrust.c(HomePageFragment_Entrust.this, HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), "homepage_delegatehouse_understandziroom3");
            } else if (paramAnonymousInt == 3) {
              HomePageFragment_Entrust.d(HomePageFragment_Entrust.this, HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), "homepage_delegatehouse_understandziroom4");
            }
          }
        }
      });
      return;
      this.e.setData(this.b, paramList, 8);
    }
  }
  
  public void bindOwnerEntrustDesc(List<ContentBean> paramList)
  {
    paramList = new com.ziroom.ziroomcustomer.home.a.e(getContext(), paramList);
    this.d.setAdapter(paramList);
  }
  
  public void bindOwnerEntrustProgress(List<ContentBean> paramList, String paramString)
  {
    if (paramList == null)
    {
      this.i.setVisibility(8);
      this.s.setVisibility(8);
      return;
    }
    this.i.setText(paramString);
    a(paramList, paramString);
  }
  
  public void bindOwnerRentNew(final List<ContentBean> paramList, String paramString)
  {
    if (paramList == null)
    {
      this.c.setVisibility(8);
      this.C.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setTitle(paramString);
    this.c.setData(this.b, paramList, 1);
    this.c.setOnClickListener(new HomeCListCtrlView.b()
    {
      public void onClick() {}
      
      public void onItemClick(int paramAnonymousInt)
      {
        ContentBean localContentBean = (ContentBean)paramList.get(paramAnonymousInt);
        JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), localContentBean.getTitle(), localContentBean.getLink(), true, localContentBean.getSubtitle(), localContentBean.getPic(), false);
      }
    });
  }
  
  public void bindOwnerStory(final List<ContentBean> paramList, final String paramString1, final String paramString2, String paramString3)
  {
    this.o.setText(paramString1);
    if (ae.notNull(paramString3)) {
      this.p.setVisibility(0);
    }
    for (;;)
    {
      this.p.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("yezhustory".equals(paramString2))
          {
            paramAnonymousView = new Intent(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), YezhuStoryListActivity.class);
            paramAnonymousView.putExtra("title", paramString1);
            paramAnonymousView.putExtra("datalist", (Serializable)paramList);
            HomePageFragment_Entrust.this.startActivity(paramAnonymousView);
            return;
          }
          JsBridgeWebActivity.start(HomePageFragment_Entrust.c(HomePageFragment_Entrust.this), null, paramString2);
        }
      });
      b(paramList);
      return;
      this.p.setVisibility(8);
    }
  }
  
  public void initEstimatePrice(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      return;
    }
    this.G = y.getStringWithDes(this.b, "owner_estimate_form_info");
    this.H = y.getStringWithDes(this.b, "owner_estimate_result_info");
    c();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    do
    {
      do
      {
        return;
        JsBridgeWebActivity.start(this.b, "", q.ar + e.h.M);
        return;
        JsBridgeWebActivity.start(this.b, "", q.ar + e.h.L);
        return;
        a(this.b, "homepage_delegatehouse_immediately");
      } while (TextUtils.isEmpty(this.E));
      JsBridgeWebActivity.start(this.b, this.D, this.E);
      return;
      a(this.b, "homepage_delegatehouse_telephone");
      ah.callPhone(this.b, "4001001111,1");
      return;
      a(this.b, "homepage_delegatehouse_online");
    } while (TextUtils.isEmpty(this.E));
    JsBridgeWebActivity.start(this.b, this.D, this.E);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getActivity();
    paramLayoutInflater = LayoutInflater.from(this.b).inflate(2130903916, paramViewGroup, false);
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("select_city");
    getActivity().registerReceiver(this.J, paramViewGroup);
    a(paramLayoutInflater);
    d();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.J);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((getUserVisibleHint()) && (this.F != null)) {
      this.F.initEstimate();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (getParentFragment() != null) && (this.F.getBrandImg() != null)) {
      ((a)getParentFragment()).onBrandImgReady(this.F.getBrandImg());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/HomePageFragment_Entrust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */