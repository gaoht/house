package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.testin.analysis.TestinApi;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.view.HomeCListCtrlView.b;
import com.ziroom.ziroomcustomer.newServiceList.a.o;
import com.ziroom.ziroomcustomer.newServiceList.model.bf;
import com.ziroom.ziroomcustomer.newServiceList.model.c.e;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView.a;
import com.ziroom.ziroomcustomer.newclean.d.bm;
import com.ziroom.ziroomcustomer.newclean.d.bm.a;
import com.ziroom.ziroomcustomer.newclean.d.bm.b;
import com.ziroom.ziroomcustomer.newclean.view.ServiceRecyclerView;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecEntranceModel;
import com.ziroom.ziroomcustomer.newmovehouse.mvp.MoveRecActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.Iterator;
import java.util.List;

public class MoveTypeActivity
  extends BaseActivity
  implements View.OnClickListener, CustomScrollView.a
{
  private String A;
  private TextView B;
  private String C;
  private String D;
  private SimpleDraweeView E;
  private RelativeLayout F;
  private SimpleDraweeView G;
  private TextView H;
  private TextView I;
  private SimpleDraweeView J;
  private RelativeLayout a;
  private ImageView b;
  private TextView c;
  private View d;
  private CustomScrollView e;
  private ListViewForScrollView f;
  private ServiceRecyclerView g;
  private Context r;
  private List<bm.b> s;
  private SimpleDraweeView t;
  private RelativeLayout u;
  private TextView v;
  private TextView w;
  private ImageView x;
  private String y;
  private String z;
  
  private void a()
  {
    this.r = this;
    this.a = ((RelativeLayout)findViewById(2131692321));
    this.b = ((ImageView)findViewById(2131690302));
    this.b.setFocusable(true);
    this.b.setFocusableInTouchMode(true);
    this.b.requestFocus();
    this.c = ((TextView)findViewById(2131690303));
    this.d = findViewById(2131690284);
    this.e = ((CustomScrollView)findViewById(2131690263));
    this.t = ((SimpleDraweeView)findViewById(2131690304));
    this.f = ((ListViewForScrollView)findViewById(2131692318));
    this.g = ((ServiceRecyclerView)findViewById(2131692320));
    this.E = ((SimpleDraweeView)findViewById(2131692330));
    this.g.setClickable(true);
    ViewGroup.LayoutParams localLayoutParams = this.t.getLayoutParams();
    localLayoutParams.width = ac.getScreenWidth(this.r);
    localLayoutParams.height = (ac.getScreenWidth(this.r) * 27 / 50);
    this.t.setLayoutParams(localLayoutParams);
    this.u = ((RelativeLayout)findViewById(2131690265));
    this.v = ((TextView)findViewById(2131690267));
    this.w = ((TextView)findViewById(2131690268));
    this.x = ((ImageView)findViewById(2131690269));
    this.B = ((TextView)findViewById(2131692319));
    this.F = ((RelativeLayout)findViewById(2131692325));
    this.J = ((SimpleDraweeView)findViewById(2131692326));
    this.G = ((SimpleDraweeView)findViewById(2131692327));
    this.H = ((TextView)findViewById(2131692328));
    this.I = ((TextView)findViewById(2131692329));
    int i = getWindowManager().getDefaultDisplay().getWidth();
    localLayoutParams = this.J.getLayoutParams();
    localLayoutParams.height = ((i - getResources().getDimensionPixelSize(2131230786)) * 100 / 345);
    this.J.setLayoutParams(localLayoutParams);
  }
  
  private void a(final List<bf> paramList)
  {
    this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (bf)paramList.get(paramAnonymousInt);
        if (paramAnonymousAdapterView.getOpen() == 0) {
          g.textToast(MoveTypeActivity.a(MoveTypeActivity.this), "服务尚未开通，敬请期待");
        }
        do
        {
          do
          {
            return;
          } while (paramAnonymousAdapterView.getOpen() != 1);
          if (paramAnonymousAdapterView.getApp() == 0)
          {
            paramAnonymousView = paramAnonymousAdapterView.getServiceInfoName();
            String str1 = paramAnonymousAdapterView.getTargetUrl();
            String str2 = paramAnonymousAdapterView.getSlogan();
            paramAnonymousAdapterView = paramAnonymousAdapterView.getPicUrl();
            JsBridgeWebActivity.start(MoveTypeActivity.a(MoveTypeActivity.this), paramAnonymousView, str1, true, str2, paramAnonymousAdapterView, false);
            return;
          }
        } while (paramAnonymousAdapterView.getApp() != 1);
        paramAnonymousView = new Intent(MoveTypeActivity.a(MoveTypeActivity.this), MovingIndexActivity.class);
        paramAnonymousView.putExtra("productCode", paramAnonymousAdapterView.getServiceInfoId());
        paramAnonymousView.putExtra("ServiceInfoName", paramAnonymousAdapterView.getServiceInfoName());
        paramAnonymousView.putExtra("shareImage", paramAnonymousAdapterView.getPicUrl());
        paramAnonymousView.putExtra("serviceContent", paramAnonymousAdapterView.getSlogan());
        paramAnonymousView.putExtra("recommendCode", MoveTypeActivity.c(MoveTypeActivity.this));
        paramAnonymousView.putExtra("channelCode", MoveTypeActivity.d(MoveTypeActivity.this));
        MoveTypeActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.e.setOnScrollChangedCallback(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.F.setOnClickListener(this);
  }
  
  private void e()
  {
    this.C = getIntent().getStringExtra("recommendCode");
    this.D = getIntent().getStringExtra("channelCode");
    f();
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.n.getMoveSecondList(this.r, new com.freelxl.baselibrary.d.c.a(new e(bf.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<bf> paramAnonymousList)
      {
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          l.d("=====搬家==返回数据size=======", Integer.valueOf(paramAnonymousList.size()));
          Object localObject = paramAnonymousList.iterator();
          while (((Iterator)localObject).hasNext()) {
            l.d("===搬家====返回数据size=======", ((bf)((Iterator)localObject).next()).getServiceInfoName());
          }
          localObject = new o(MoveTypeActivity.a(MoveTypeActivity.this), paramAnonymousList);
          MoveTypeActivity.b(MoveTypeActivity.this).setAdapter((ListAdapter)localObject);
          MoveTypeActivity.a(MoveTypeActivity.this, paramAnonymousList);
        }
      }
    });
    h();
    g();
    i();
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.e.n.getCommonTemplateOnCityV2(this.r, Integer.valueOf(20), new com.freelxl.baselibrary.d.c.a(new f(com.ziroom.ziroomcustomer.newServiceList.model.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final com.ziroom.ziroomcustomer.newServiceList.model.c paramAnonymousc)
      {
        if ((paramAnonymousc != null) && (paramAnonymousc.getMoveListPage() != null) && (paramAnonymousc.getMoveListPage().getValid() == 1))
        {
          final String str1 = paramAnonymousc.getMoveListPage().getUrl();
          MoveTypeActivity.e(MoveTypeActivity.this).setVisibility(0);
          final String str2 = paramAnonymousc.getMoveListPage().getImage();
          MoveTypeActivity.e(MoveTypeActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(str2));
          MoveTypeActivity.e(MoveTypeActivity.this).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if ((paramAnonymousc.getMoveListPage().getShareDisplay() != null) && (paramAnonymousc.getMoveListPage().getShareDisplay().intValue() == 1))
              {
                paramAnonymous2View = paramAnonymousc.getMoveListPage().getShareTitle();
                String str = paramAnonymousc.getMoveListPage().getShareImage();
                JsBridgeWebActivity.start(MoveTypeActivity.a(MoveTypeActivity.this), paramAnonymous2View, str1, true, "", str, false);
                return;
              }
              JsBridgeWebActivity.start(MoveTypeActivity.a(MoveTypeActivity.this), "", str1, false, "", str2, false);
            }
          });
          return;
        }
        MoveTypeActivity.e(MoveTypeActivity.this).setVisibility(8);
      }
    });
  }
  
  private void h()
  {
    j.getCommonJsonGate(this.r, q.o + "contentful/ziruke-app/v1/fuwu/banjia.json", new com.freelxl.baselibrary.d.c.a(new f(bm.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, bm paramAnonymousbm)
      {
        if (paramAnonymousbm != null)
        {
          bm.a locala = paramAnonymousbm.getTopBanner();
          if (locala != null)
          {
            String str = locala.getPic();
            MoveTypeActivity.f(MoveTypeActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(str));
            MoveTypeActivity.a(MoveTypeActivity.this, locala.getTitle());
            str = locala.getSubtitle();
            MoveTypeActivity.b(MoveTypeActivity.this, locala.getUrl());
            MoveTypeActivity.c(MoveTypeActivity.this, locala.getTypes());
            if (TextUtils.isEmpty(MoveTypeActivity.g(MoveTypeActivity.this))) {
              break label192;
            }
            MoveTypeActivity.h(MoveTypeActivity.this).setVisibility(0);
            MoveTypeActivity.i(MoveTypeActivity.this).setText(MoveTypeActivity.g(MoveTypeActivity.this));
            MoveTypeActivity.j(MoveTypeActivity.this).setText(str);
          }
        }
        for (;;)
        {
          MoveTypeActivity.b(MoveTypeActivity.this, paramAnonymousbm.getTips());
          if ((MoveTypeActivity.k(MoveTypeActivity.this) != null) && (!MoveTypeActivity.k(MoveTypeActivity.this).isEmpty())) {
            MoveTypeActivity.l(MoveTypeActivity.this).setVisibility(0);
          }
          MoveTypeActivity.this.bindServiceTips(MoveTypeActivity.k(MoveTypeActivity.this));
          return;
          label192:
          MoveTypeActivity.h(MoveTypeActivity.this).setVisibility(8);
        }
      }
    });
  }
  
  private void i()
  {
    if ("versionB".equals(TestinApi.getStringFlag("Recommend", "versionA"))) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.requestMoveRecEntrance(this, new com.freelxl.baselibrary.d.c.a(new e(MoveRecEntranceModel.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<MoveRecEntranceModel> paramAnonymousList)
      {
        if ((paramAnonymousList == null) || (paramAnonymousList.size() < 1) || (paramAnonymousList.get(0) == null)) {
          return;
        }
        MoveTypeActivity.m(MoveTypeActivity.this).setVisibility(0);
        MoveTypeActivity.n(MoveTypeActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(((MoveRecEntranceModel)paramAnonymousList.get(0)).picUrl));
      }
    });
  }
  
  public void bindServiceTips(final List<bm.b> paramList)
  {
    if (paramList == null)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    this.g.setData(this.r, paramList);
    this.g.setOnClickListener(new HomeCListCtrlView.b()
    {
      public void onClick() {}
      
      public void onItemClick(int paramAnonymousInt)
      {
        String str1 = ((bm.b)paramList.get(paramAnonymousInt)).getUrl();
        String str2 = ((bm.b)paramList.get(paramAnonymousInt)).getTitle();
        Intent localIntent = new Intent(MoveTypeActivity.a(MoveTypeActivity.this), HomeWebActivity.class);
        localIntent.putExtra("title", str2);
        localIntent.putExtra("url", str1);
        MoveTypeActivity.this.startActivity(localIntent);
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690302: 
      finish();
      return;
    case 2131690265: 
    case 2131690268: 
    case 2131690269: 
      paramView = null;
      if (this.A.equals("1"))
      {
        paramView = new Intent(this.r, HomeWebActivity.class);
        paramView.putExtra("url", this.y);
        paramView.putExtra("title", this.z);
        startActivity(paramView);
        return;
      }
      String str = this.y;
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        label164:
        switch (i)
        {
        }
        break;
      }
      while (paramView != null)
      {
        startActivity(paramView);
        return;
        if (!str.equals("move_xiaoban")) {
          break label164;
        }
        i = 0;
        break label164;
        if (!str.equals("move_truck")) {
          break label164;
        }
        i = 1;
        break label164;
        paramView = new Intent(this.r, MovingIndexActivity.class);
        paramView.putExtra("productCode", "2c9085f248ba3f3a0148bb156f6e0004");
        paramView.putExtra("recommendCode", this.C);
        paramView.putExtra("channelCode", this.D);
        continue;
        paramView = new Intent(this.r, MovingIndexActivity.class);
        paramView.putExtra("productCode", "8a90a5f8593e65b501593e65b5200000");
        paramView.putExtra("recommendCode", this.C);
        paramView.putExtra("channelCode", this.D);
      }
    }
    MoveRecActivity.launchActivity(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903476);
    a();
    b();
    e();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(this, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.a.setAlpha(f1);
      this.c.setAlpha(f1);
      this.d.setAlpha(f1);
      if (f1 > 0.6D)
      {
        this.b.setImageResource(2130840141);
        return;
      }
      this.b.setImageResource(2130840141);
      return;
      f1 = f2;
    }
  }
  
  public void scrollEnd()
  {
    this.E.setAlpha(1.0F);
  }
  
  public void scrollStart()
  {
    this.E.setAlpha(0.3F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MoveTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */