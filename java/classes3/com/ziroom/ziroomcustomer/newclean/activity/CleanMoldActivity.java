package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.commonlibrary.widget.convenientbanner.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView;
import com.ziroom.ziroomcustomer.newServiceList.view.CustomScrollView.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo.DocumentMo;
import com.ziroom.ziroomcustomer.newclean.d.ad;
import com.ziroom.ziroomcustomer.newclean.d.y;
import com.ziroom.ziroomcustomer.newclean.d.y.a;
import com.ziroom.ziroomcustomer.newclean.d.z;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.List;

public class CleanMoldActivity
  extends BaseActivity
  implements View.OnClickListener, CustomScrollView.a
{
  private SimpleDraweeView A;
  private LinearLayout B;
  private LinearLayout C;
  private LinearLayout D;
  private LinearLayout E;
  private LinearLayout F;
  private SimpleDraweeView G;
  private SimpleDraweeView H;
  private SimpleDraweeView I;
  private SimpleDraweeView J;
  private View K;
  private View L;
  private Intent M;
  private SimpleDraweeView N;
  private SimpleDraweeView O;
  private SimpleDraweeView P;
  private SimpleDraweeView Q;
  private ListViewForScrollView R;
  private LinearLayout S;
  private LocationClient T;
  private a U;
  private BroadcastReceiver V = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        CleanMoldActivity.l(CleanMoldActivity.this);
      }
    }
  };
  private Context a;
  private CustomScrollView b;
  private View c;
  private View d;
  private TextView e;
  private ImageView f;
  private RelativeLayout g;
  private TextView r;
  private TextView s;
  private ImageView t;
  private ConvenientBanner u;
  private CleanUesrIsNewMo v;
  private String w;
  private List<String> x = new ArrayList();
  private SimpleDraweeView y;
  private SimpleDraweeView z;
  
  private void a()
  {
    this.b = ((CustomScrollView)findViewById(2131690263));
    this.c = findViewById(2131690283);
    this.e = ((TextView)findViewById(2131690303));
    this.d = findViewById(2131690284);
    this.f = ((ImageView)findViewById(2131690302));
    this.g = ((RelativeLayout)findViewById(2131690265));
    this.r = ((TextView)findViewById(2131690267));
    this.s = ((TextView)findViewById(2131690268));
    this.t = ((ImageView)findViewById(2131690269));
    this.u = ((ConvenientBanner)findViewById(2131690264));
    this.C = ((LinearLayout)findViewById(2131690286));
    this.y = ((SimpleDraweeView)findViewById(2131690287));
    this.z = ((SimpleDraweeView)findViewById(2131690288));
    this.A = ((SimpleDraweeView)findViewById(2131690290));
    this.L = findViewById(2131690289);
    this.B = ((LinearLayout)findViewById(2131690291));
    this.D = ((LinearLayout)findViewById(2131690292));
    this.N = ((SimpleDraweeView)findViewById(2131690293));
    this.O = ((SimpleDraweeView)findViewById(2131690294));
    this.P = ((SimpleDraweeView)findViewById(2131690295));
    this.E = ((LinearLayout)findViewById(2131690296));
    this.F = ((LinearLayout)findViewById(2131690297));
    this.G = ((SimpleDraweeView)findViewById(2131690298));
    this.H = ((SimpleDraweeView)findViewById(2131690299));
    this.I = ((SimpleDraweeView)findViewById(2131690300));
    this.J = ((SimpleDraweeView)findViewById(2131690301));
    this.Q = ((SimpleDraweeView)findViewById(2131690285));
    this.R = ((ListViewForScrollView)findViewById(2131690281));
    this.S = ((LinearLayout)findViewById(2131690280));
    this.K = findViewById(2131690279);
    View localView = findViewById(2131690303);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
  }
  
  private void a(BDLocation paramBDLocation)
  {
    double d2 = 0.0D;
    double d1;
    if (paramBDLocation != null)
    {
      d1 = paramBDLocation.getLongitude();
      d2 = paramBDLocation.getLatitude();
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.n.getCleanBottomCleaner(this.a, d1, d2, new com.freelxl.baselibrary.d.c.a(new e(z.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          CleanMoldActivity.j(CleanMoldActivity.this).setVisibility(8);
          CleanMoldActivity.k(CleanMoldActivity.this).setVisibility(8);
        }
        
        public void onSuccess(int paramAnonymousInt, List<z> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            CleanMoldActivity.i(CleanMoldActivity.this).setVisibility(8);
            CleanMoldActivity.j(CleanMoldActivity.this).setVisibility(0);
            CleanMoldActivity.k(CleanMoldActivity.this).setVisibility(0);
            paramAnonymousList = new com.ziroom.ziroomcustomer.newclean.b.m(CleanMoldActivity.b(CleanMoldActivity.this), paramAnonymousList);
            CleanMoldActivity.k(CleanMoldActivity.this).setAdapter(paramAnonymousList);
            return;
          }
          CleanMoldActivity.i(CleanMoldActivity.this).setVisibility(0);
          CleanMoldActivity.j(CleanMoldActivity.this).setVisibility(8);
          CleanMoldActivity.k(CleanMoldActivity.this).setVisibility(8);
        }
      });
      return;
      d1 = 0.0D;
    }
  }
  
  private void a(y.a parama)
  {
    if ("ff8080813164497d01316483ef880023".equals(parama.getServiceInfoId())) {
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
        g.textToast(this.a, "请先登录");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (parama.getOpen() == 0)
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("已签约的自如客才能使用哦~").setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean) {}
            }).build().show();
            return;
          }
        } while (parama.getOpen() != 1);
        this.M = new Intent(this.a, ForCleaningActivity.class);
        this.M.putExtra("ServiceInfoId", parama.getServiceInfoId());
        this.M.putExtra("ServiceInfoName", parama.getServiceInfoName());
        startActivity(this.M);
        return;
        if (parama.getOpen() == 0)
        {
          g.textToast(this.a, "服务尚未开通，敬请期待");
          return;
        }
      } while (parama.getOpen() != 1);
      if (parama.getApp() == 0)
      {
        String str1 = parama.getServiceInfoName();
        String str2 = parama.getTargetUrl();
        String str3 = parama.getSlogan();
        parama = parama.getPicUrl();
        JsBridgeWebActivity.start(this.a, str1, str2, true, str3, parama, false);
        return;
      }
    } while (parama.getApp() != 1);
    if ("ff8080813164497d01316483ef880023".equals(parama.getServiceInfoId()))
    {
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
        g.textToast(this.a, "请先登录");
        return;
      }
      if ((ApplicationEx.c.getContracts() == null) || ((ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() == 0)))
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("已签约的自如客才能使用哦~").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean) {}
        }).build().show();
        return;
      }
      this.M = new Intent(this.a, ForCleaningActivity.class);
      this.M.putExtra("ServiceInfoId", parama.getServiceInfoId());
      this.M.putExtra("ServiceInfoName", parama.getServiceInfoName());
    }
    for (;;)
    {
      startActivity(this.M);
      return;
      if (parama.getZhengZu() == 1)
      {
        this.M = new Intent(this.a, GeneralCleaningActivity.class);
        this.M.putExtra("isZhengZu", "isZhengZu");
        this.M.putExtra("ServiceInfoId", parama.getServiceInfoId());
        this.M.putExtra("ServiceInfoName", parama.getServiceInfoName());
      }
      else
      {
        this.M = new Intent(this.a, CleanIndexActivity.class);
        this.M.putExtra("ServiceInfoId", parama.getServiceInfoId());
        this.M.putExtra("ServiceInfoName", parama.getServiceInfoName());
        this.M.putExtra("shareImage", "");
        this.M.putExtra("serviceContent", "");
      }
    }
  }
  
  private void a(final y paramy)
  {
    if ((paramy.getDefaults() == null) || (paramy.getDefaults().size() == 0))
    {
      this.C.setVisibility(8);
      if ((paramy.getQualities() != null) && (paramy.getQualities().size() != 0)) {
        break label1124;
      }
      this.B.setVisibility(8);
      this.D.setVisibility(8);
      label65:
      if ((paramy.getProfessionals() != null) && (paramy.getProfessionals().size() != 0)) {
        break label1649;
      }
      this.E.setVisibility(8);
      this.F.setVisibility(8);
    }
    label216:
    label311:
    label437:
    label599:
    label760:
    label962:
    label1043:
    label1124:
    label1211:
    label1299:
    label1487:
    label1568:
    label1649:
    label1824:
    label1912:
    do
    {
      return;
      this.C.setVisibility(0);
      final int i = paramy.getDefaults().size();
      if (i == 1)
      {
        this.A.setVisibility(8);
        this.L.setVisibility(8);
        if (paramy.getDefaults().get(0) != null)
        {
          if (this.y.getTag() != null) {
            break label437;
          }
          this.y.setTag(((y.a)paramy.getDefaults().get(0)).getPicUrl());
          this.y.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(0)).getPicUrl()));
        }
      }
      if (i == 2)
      {
        this.A.setVisibility(8);
        this.L.setVisibility(8);
        if (paramy.getDefaults().get(0) != null)
        {
          if (this.y.getTag() == null)
          {
            this.y.setTag(((y.a)paramy.getDefaults().get(0)).getPicUrl());
            this.y.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(0)).getPicUrl()));
          }
        }
        else if (paramy.getDefaults().get(1) != null)
        {
          if (this.z.getTag() != null) {
            break label599;
          }
          this.z.setTag(((y.a)paramy.getDefaults().get(1)).getPicUrl());
          this.z.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(1)).getPicUrl()));
        }
      }
      for (;;)
      {
        this.y.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i > 0) {
              CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getDefaults().get(0));
            }
          }
        });
        this.z.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i > 1) {
              CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getDefaults().get(1));
            }
          }
        });
        this.A.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i > 2) {
              CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getDefaults().get(2));
            }
          }
        });
        break;
        if (((y.a)paramy.getDefaults().get(0)).getPicUrl().equals(this.y.getTag())) {
          break label216;
        }
        this.y.setTag(((y.a)paramy.getDefaults().get(0)).getPicUrl());
        this.y.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(0)).getPicUrl()));
        break label216;
        if (((y.a)paramy.getDefaults().get(0)).getPicUrl().equals(this.y.getTag())) {
          break label311;
        }
        this.y.setTag(((y.a)paramy.getDefaults().get(0)).getPicUrl());
        this.y.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(0)).getPicUrl()));
        break label311;
        if (!((y.a)paramy.getDefaults().get(1)).getPicUrl().equals(this.z.getTag()))
        {
          this.z.setTag(((y.a)paramy.getDefaults().get(1)).getPicUrl());
          this.z.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(1)).getPicUrl()));
          continue;
          if (i == 3)
          {
            this.A.setVisibility(0);
            this.L.setVisibility(0);
            if (this.y.getTag() == null)
            {
              this.y.setTag(((y.a)paramy.getDefaults().get(0)).getPicUrl());
              this.y.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(0)).getPicUrl()));
              if (this.z.getTag() != null) {
                break label962;
              }
              this.z.setTag(((y.a)paramy.getDefaults().get(1)).getPicUrl());
              this.z.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(1)).getPicUrl()));
            }
            for (;;)
            {
              if (this.A.getTag() != null) {
                break label1043;
              }
              this.A.setTag(((y.a)paramy.getDefaults().get(2)).getPicUrl());
              this.A.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(2)).getPicUrl()));
              break;
              if (((y.a)paramy.getDefaults().get(0)).getPicUrl().equals(this.y.getTag())) {
                break label760;
              }
              this.y.setTag(((y.a)paramy.getDefaults().get(0)).getPicUrl());
              this.y.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(0)).getPicUrl()));
              break label760;
              if (!((y.a)paramy.getDefaults().get(1)).getPicUrl().equals(this.z.getTag()))
              {
                this.z.setTag(((y.a)paramy.getDefaults().get(1)).getPicUrl());
                this.z.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(1)).getPicUrl()));
              }
            }
            if (!((y.a)paramy.getDefaults().get(2)).getPicUrl().equals(this.z.getTag()))
            {
              this.A.setTag(((y.a)paramy.getDefaults().get(2)).getPicUrl());
              this.A.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getDefaults().get(2)).getPicUrl()));
            }
          }
        }
      }
      this.B.setVisibility(0);
      this.D.setVisibility(0);
      if (paramy.getQualities().size() > 0)
      {
        if (this.N.getTag() == null)
        {
          this.N.setTag(((y.a)paramy.getQualities().get(0)).getPicUrl());
          this.N.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getQualities().get(0)).getPicUrl()));
          this.N.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getQualities().get(0));
            }
          });
        }
      }
      else
      {
        if (paramy.getQualities().size() > 1)
        {
          if (this.O.getTag() != null) {
            break label1487;
          }
          this.O.setTag(((y.a)paramy.getQualities().get(1)).getPicUrl());
          this.O.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getQualities().get(1)).getPicUrl()));
          this.O.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getQualities().get(1));
            }
          });
        }
        if (paramy.getQualities().size() <= 2) {
          break label65;
        }
        if (this.P.getTag() != null) {
          break label1568;
        }
        this.P.setTag(((y.a)paramy.getQualities().get(2)).getPicUrl());
        this.P.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getQualities().get(2)).getPicUrl()));
      }
      for (;;)
      {
        this.P.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getQualities().get(2));
          }
        });
        break;
        if (((y.a)paramy.getQualities().get(0)).getPicUrl().equals(this.N.getTag())) {
          break label1211;
        }
        this.N.setTag(((y.a)paramy.getQualities().get(0)).getPicUrl());
        this.N.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getQualities().get(0)).getPicUrl()));
        break label1211;
        if (((y.a)paramy.getQualities().get(1)).getPicUrl().equals(this.O.getTag())) {
          break label1299;
        }
        this.O.setTag(((y.a)paramy.getQualities().get(1)).getPicUrl());
        this.O.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getQualities().get(1)).getPicUrl()));
        break label1299;
        if (!((y.a)paramy.getQualities().get(2)).getPicUrl().equals(this.P.getTag()))
        {
          this.P.setTag(((y.a)paramy.getQualities().get(2)).getPicUrl());
          this.P.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getQualities().get(2)).getPicUrl()));
        }
      }
      this.E.setVisibility(0);
      this.F.setVisibility(0);
      if (paramy.getProfessionals().size() > 0)
      {
        if (this.G.getTag() != null) {
          break label2017;
        }
        this.G.setTag(((y.a)paramy.getProfessionals().get(0)).getPicUrl());
        this.G.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(0)).getPicUrl()));
        this.G.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getProfessionals().get(0));
          }
        });
      }
      if (paramy.getProfessionals().size() > 1)
      {
        if (this.H.getTag() != null) {
          break label2098;
        }
        this.H.setTag(((y.a)paramy.getProfessionals().get(1)).getPicUrl());
        this.H.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(1)).getPicUrl()));
        this.H.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getProfessionals().get(1));
          }
        });
      }
      if (paramy.getProfessionals().size() > 2)
      {
        if (this.I.getTag() != null) {
          break label2179;
        }
        this.I.setTag(((y.a)paramy.getProfessionals().get(2)).getPicUrl());
        this.I.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(2)).getPicUrl()));
        this.I.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getProfessionals().get(2));
          }
        });
      }
    } while (paramy.getProfessionals().size() <= 3);
    if (this.J.getTag() == null)
    {
      this.J.setTag(((y.a)paramy.getProfessionals().get(3)).getPicUrl());
      this.J.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(3)).getPicUrl()));
    }
    for (;;)
    {
      this.J.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CleanMoldActivity.a(CleanMoldActivity.this, (y.a)paramy.getProfessionals().get(3));
        }
      });
      return;
      label2017:
      if (((y.a)paramy.getProfessionals().get(0)).getPicUrl().equals(this.G.getTag())) {
        break;
      }
      this.G.setTag(((y.a)paramy.getProfessionals().get(0)).getPicUrl());
      this.G.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(0)).getPicUrl()));
      break;
      label2098:
      if (((y.a)paramy.getProfessionals().get(1)).getPicUrl().equals(this.H.getTag())) {
        break label1824;
      }
      this.H.setTag(((y.a)paramy.getProfessionals().get(1)).getPicUrl());
      this.H.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(1)).getPicUrl()));
      break label1824;
      label2179:
      if (((y.a)paramy.getProfessionals().get(2)).getPicUrl().equals(this.I.getTag())) {
        break label1912;
      }
      this.I.setTag(((y.a)paramy.getProfessionals().get(2)).getPicUrl());
      this.I.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(2)).getPicUrl()));
      break label1912;
      if (!((y.a)paramy.getProfessionals().get(3)).getPicUrl().equals(this.J.getTag()))
      {
        this.J.setTag(((y.a)paramy.getProfessionals().get(3)).getPicUrl());
        this.J.setController(com.freelxl.baselibrary.f.c.frescoController(((y.a)paramy.getProfessionals().get(3)).getPicUrl()));
      }
    }
  }
  
  private void a(final List<ad> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.x.clear();
      int i = 0;
      while (i < paramList.size())
      {
        this.x.add(((ad)paramList.get(i)).getImg());
        i += 1;
      }
      this.u.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
      {
        public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
        {
          return new com.ziroom.ziroomcustomer.newServiceList.view.c();
        }
      }, this.x).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new b()
      {
        public void onItemClick(int paramAnonymousInt) {}
      });
      this.u.startTurning(3000L);
      this.u.setOnItemClickListener(new b()
      {
        public void onItemClick(int paramAnonymousInt)
        {
          String str1 = ((ad)paramList.get(paramAnonymousInt)).getTitle();
          String str2 = ((ad)paramList.get(paramAnonymousInt)).getTarget();
          String str3 = ((ad)paramList.get(paramAnonymousInt)).getDescription();
          String str4 = ((ad)paramList.get(paramAnonymousInt)).getImg();
          JsBridgeWebActivity.start(CleanMoldActivity.b(CleanMoldActivity.this), str1, str2, true, str3, str4, false);
        }
      });
    } while ((this.x == null) || (this.x.size() <= 0));
    if (this.x.size() == 1)
    {
      this.u.setPointViewVisible(false);
      this.u.setCanLoop(false);
      return;
    }
    this.u.setPointViewVisible(true);
    this.u.setCanLoop(true);
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.V, localIntentFilter);
    this.b.setOnScrollChangedCallback(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
  }
  
  private void e()
  {
    i();
    h();
    g();
    f();
    BDLocation localBDLocation = ApplicationEx.c.getLocation();
    if (localBDLocation == null)
    {
      j();
      return;
    }
    a(localBDLocation);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.n.getCommonTemplateOnCityV2(this.a, Integer.valueOf(20), new com.freelxl.baselibrary.d.c.a(new f(com.ziroom.ziroomcustomer.newServiceList.model.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final com.ziroom.ziroomcustomer.newServiceList.model.c paramAnonymousc)
      {
        if ((paramAnonymousc != null) && (paramAnonymousc.getCleanListPage() != null) && (paramAnonymousc.getCleanListPage().getValid() == 1))
        {
          CleanMoldActivity.a(CleanMoldActivity.this).setVisibility(0);
          CleanMoldActivity.a(CleanMoldActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousc.getCleanListPage().getImage()));
          CleanMoldActivity.a(CleanMoldActivity.this).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = ApplicationEx.c.getUser();
              if (paramAnonymous2View == null)
              {
                com.ziroom.commonlibrary.login.a.startLoginActivity(CleanMoldActivity.this);
                return;
              }
              paramAnonymous2View = paramAnonymousc.getCleanListPage().getUrl() + "?uid=" + paramAnonymous2View.getUid();
              String str = paramAnonymousc.getCleanListPage().getImage();
              JsBridgeWebActivity.start(CleanMoldActivity.b(CleanMoldActivity.this), "", paramAnonymous2View, false, "", str, false);
            }
          });
          return;
        }
        CleanMoldActivity.a(CleanMoldActivity.this).setVisibility(8);
      }
    });
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.e.n.getCleanTopLunBoPic(this.a, new d(this.a, new e(ad.class))
    {
      public void onSuccess(int paramAnonymousInt, List<ad> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (paramAnonymousList != null) {
          CleanMoldActivity.a(CleanMoldActivity.this, paramAnonymousList);
        }
      }
    });
  }
  
  private void h()
  {
    String str = j.getUid();
    com.ziroom.ziroomcustomer.e.n.requestIsUserInfo(this.a, str, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(CleanUesrIsNewMo.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showFailureMessage(CleanMoldActivity.b(CleanMoldActivity.this), paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, CleanUesrIsNewMo paramAnonymousCleanUesrIsNewMo)
      {
        if (paramAnonymousCleanUesrIsNewMo != null)
        {
          CleanMoldActivity.a(CleanMoldActivity.this, paramAnonymousCleanUesrIsNewMo);
          CleanMoldActivity.a(CleanMoldActivity.this, CleanMoldActivity.c(CleanMoldActivity.this).getDocument().getText());
          if (!TextUtils.isEmpty(CleanMoldActivity.d(CleanMoldActivity.this)))
          {
            CleanMoldActivity.e(CleanMoldActivity.this).setVisibility(0);
            CleanMoldActivity.f(CleanMoldActivity.this).setText(CleanMoldActivity.d(CleanMoldActivity.this));
            CleanMoldActivity.g(CleanMoldActivity.this).setText("立即购买");
          }
        }
        else
        {
          return;
        }
        CleanMoldActivity.e(CleanMoldActivity.this).setVisibility(8);
      }
    });
  }
  
  private void i()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str = "";
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    com.ziroom.ziroomcustomer.e.n.getCleanTyepList(this.a, str, new d(this.a, new f(y.class))
    {
      public void onSuccess(int paramAnonymousInt, y paramAnonymousy)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousy);
        if (paramAnonymousy != null) {
          CleanMoldActivity.a(CleanMoldActivity.this, paramAnonymousy);
        }
      }
    });
  }
  
  private void j()
  {
    this.T = new LocationClient(this.a);
    this.U = new a();
    this.T.registerLocationListener(this.U);
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(5000);
    localLocationClientOption.setIsNeedAddress(true);
    this.T.setLocOption(localLocationClientOption);
    this.T.start();
  }
  
  private void k()
  {
    this.T.stop();
    if (this.U != null) {
      this.T.unRegisterLocationListener(this.U);
    }
    this.T = null;
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
    }
    startActivity(new Intent(this.a, CleanStoredCardBuyActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903146);
    this.a = this;
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.V);
  }
  
  protected void onResume()
  {
    super.onResume();
    int i = ac.getScreenWidth(this.a);
    ViewGroup.LayoutParams localLayoutParams = this.u.getLayoutParams();
    localLayoutParams.height = (i * 211 / 375);
    this.u.setLayoutParams(localLayoutParams);
    localLayoutParams = this.C.getLayoutParams();
    localLayoutParams.height = ((i - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 42.0F)) / 2 * 80 / 166);
    this.C.setLayoutParams(localLayoutParams);
    localLayoutParams = this.D.getLayoutParams();
    localLayoutParams.height = ((i - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 36.0F)) * 132 / 339);
    this.D.setLayoutParams(localLayoutParams);
    localLayoutParams = this.F.getLayoutParams();
    localLayoutParams.height = ((i - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 36.0F)) * 160 / 339);
    this.F.setLayoutParams(localLayoutParams);
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(this, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.d.setAlpha(f1);
      this.e.setAlpha(f1);
      this.c.setAlpha(f1);
      return;
      f1 = f2;
    }
  }
  
  public void scrollEnd()
  {
    this.Q.setAlpha(1.0F);
  }
  
  public void scrollStart()
  {
    this.Q.setAlpha(0.3F);
  }
  
  public class a
    implements BDLocationListener
  {
    public a() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      VdsAgent.onReceiveLocation(this, paramBDLocation);
      if (paramBDLocation != null) {
        CleanMoldActivity.a(CleanMoldActivity.this, paramBDLocation);
      }
      for (;;)
      {
        CleanMoldActivity.h(CleanMoldActivity.this);
        return;
        CleanMoldActivity.a(CleanMoldActivity.this, null);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanMoldActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */