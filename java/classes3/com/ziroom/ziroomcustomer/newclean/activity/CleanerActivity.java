package com.ziroom.ziroomcustomer.newclean.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.utils.trans.EasyTransitionOptions.ViewAttrs;
import com.ziroom.ziroomcustomer.newServiceList.view.LoadListView;
import com.ziroom.ziroomcustomer.newServiceList.view.LoadListView.a;
import com.ziroom.ziroomcustomer.newclean.b.q;
import com.ziroom.ziroomcustomer.newclean.d.af;
import com.ziroom.ziroomcustomer.newclean.d.ag;
import com.ziroom.ziroomcustomer.newclean.d.ah;
import com.ziroom.ziroomcustomer.newclean.d.ai;
import com.ziroom.ziroomcustomer.newclean.d.v;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanMainActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CleanerBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleanerActivity
  extends BaseActivity
  implements View.OnClickListener, LoadListView.a
{
  public static CleanerActivity a = null;
  private String A;
  private String B;
  private af C;
  private List<String> D = new ArrayList();
  private List<v> E = new ArrayList();
  private int F = 1;
  private int G = 0;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private String N;
  private ag O;
  private LinearLayout P;
  private TextView Q;
  private String R;
  private com.ziroom.ziroomcustomer.newclean.d.c S;
  private CleanerBean T;
  private FrequencyBean U;
  private TextView V;
  private LinearLayout W;
  private TextView X;
  private TextView Y;
  private TextView Z;
  private RelativeLayout aa;
  private SimpleDraweeView ab;
  private TextView ac;
  private TextView ad;
  private TextView ae;
  private TextView af;
  private TextView ag;
  private View ah;
  private String ai;
  private View aj;
  private CardView ak;
  private q al;
  private ImageView am;
  private ImageView an;
  private TextView ao;
  private TextView ap;
  private boolean aq = true;
  private Context b;
  private ImageView c;
  private LoadListView d;
  private RelativeLayout e;
  private TextView f;
  private View g;
  private SimpleDraweeView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private FlowLayout w;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((LoadListView)findViewById(2131690040));
    this.e = ((RelativeLayout)findViewById(2131690257));
    this.f = ((TextView)findViewById(2131689956));
    this.W = ((LinearLayout)findViewById(2131690378));
    this.r = ((SimpleDraweeView)findViewById(2131690047));
    this.s = ((TextView)findViewById(2131690049));
    this.t = ((TextView)findViewById(2131690052));
    this.u = ((TextView)findViewById(2131690053));
    this.V = ((TextView)findViewById(2131690381));
    this.v = ((TextView)findViewById(2131690003));
    this.ah = findViewById(2131690379);
    this.am = ((ImageView)findViewById(2131690383));
    this.ao = ((TextView)findViewById(2131690384));
    this.g = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130904652, null, false);
    this.w = ((FlowLayout)this.g.findViewById(2131690332));
    this.P = ((LinearLayout)this.g.findViewById(2131695944));
    this.Q = ((TextView)this.g.findViewById(2131695945));
    this.X = ((TextView)this.g.findViewById(2131695942));
    this.Y = ((TextView)this.g.findViewById(2131695943));
    this.Z = ((TextView)this.g.findViewById(2131694915));
    this.aa = ((RelativeLayout)this.g.findViewById(2131695933));
    this.aj = this.g.findViewById(2131695934);
    this.ak = ((CardView)this.g.findViewById(2131695935));
    this.ab = ((SimpleDraweeView)this.g.findViewById(2131695112));
    this.ac = ((TextView)this.g.findViewById(2131695936));
    this.ad = ((TextView)this.g.findViewById(2131695937));
    this.ae = ((TextView)this.g.findViewById(2131693248));
    this.af = ((TextView)this.g.findViewById(2131695938));
    this.ag = ((TextView)this.g.findViewById(2131695939));
    this.an = ((ImageView)this.g.findViewById(2131695940));
    this.ap = ((TextView)this.g.findViewById(2131695941));
    this.d.setPullLoadEnable(true);
    this.d.setXListViewListener(this);
    this.al = new q(this.b, this.E);
    this.d.setAdapter(this.al);
    this.d.addHeaderView(this.g);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void a(final int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2) {}
    for (String str = "3";; str = paramInt1 + "")
    {
      com.ziroom.ziroomcustomer.e.n.getCleanerEval(this, this.B, str, paramInt2, 8, new com.freelxl.baselibrary.d.c.a(new e(v.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, List<v> paramAnonymousList)
        {
          CleanerActivity.x(CleanerActivity.this).stopLoadMore();
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            CleanerActivity.y(CleanerActivity.this).addAll(paramAnonymousList);
            CleanerActivity.z(CleanerActivity.this).notifyDataSetChanged();
            CleanerActivity.A(CleanerActivity.this).setVisibility(0);
            CleanerActivity.B(CleanerActivity.this).setVisibility(8);
          }
          do
          {
            return;
            if (CleanerActivity.y(CleanerActivity.this).size() > 0)
            {
              g.textToast(CleanerActivity.C(CleanerActivity.this), "没有数据了");
              CleanerActivity.B(CleanerActivity.this).setVisibility(8);
              return;
            }
          } while (paramInt1 != 0);
          CleanerActivity.B(CleanerActivity.this).setVisibility(0);
        }
      });
      return;
    }
  }
  
  private void a(ArrayList<EasyTransitionOptions.ViewAttrs> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        final EasyTransitionOptions.ViewAttrs localViewAttrs = (EasyTransitionOptions.ViewAttrs)paramArrayList.next();
        final View localView = findViewById(localViewAttrs.a);
        if (localView != null) {
          localView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public boolean onPreDraw()
            {
              localView.getViewTreeObserver().removeOnPreDrawListener(this);
              int[] arrayOfInt = new int[2];
              localView.getLocationOnScreen(arrayOfInt);
              localView.setPivotX(0.0F);
              localView.setPivotY(0.0F);
              localView.setScaleX(localViewAttrs.d / localView.getWidth());
              localView.setScaleY(localViewAttrs.e / localView.getHeight());
              localView.setTranslationX(localViewAttrs.b - arrayOfInt[0]);
              localView.setTranslationY(localViewAttrs.c - arrayOfInt[1]);
              Log.d("lsdjgkd222", "===== attr.startY" + localViewAttrs.c + "   location[0]=" + arrayOfInt[1]);
              localView.animate().scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setDuration(800L).setStartDelay(80L).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter()
              {
                public void onAnimationEnd(Animator paramAnonymous2Animator)
                {
                  u.e("skjdgl", "=====  onAnimationEnd");
                  CleanerActivity.E(CleanerActivity.this).setVisibility(0);
                  CleanerActivity.E(CleanerActivity.this).setAlpha(1.0F);
                  CleanerActivity.E(CleanerActivity.this).setTranslationY(com.ziroom.ziroomcustomer.util.n.dip2px(CleanerActivity.C(CleanerActivity.this), 66.0F));
                  CleanerActivity.E(CleanerActivity.this).animate().setDuration(800L).translationY(0.0F).setListener(new AnimatorListenerAdapter()
                  {
                    public void onAnimationEnd(Animator paramAnonymous3Animator)
                    {
                      super.onAnimationEnd(paramAnonymous3Animator);
                      CleanerActivity.F(CleanerActivity.this).setVisibility(0);
                      CleanerActivity.F(CleanerActivity.this).setBackgroundColor(-1);
                      CleanerActivity.G(CleanerActivity.this).setVisibility(0);
                      CleanerActivity.H(CleanerActivity.this).setVisibility(0);
                      CleanerActivity.6.this.a.setVisibility(8);
                      CleanerActivity.I(CleanerActivity.this).setVisibility(8);
                    }
                  });
                }
              });
              return true;
            }
          });
        }
      }
    }
  }
  
  private void b()
  {
    this.ai = getIntent().getStringExtra("from_type");
    this.S = ((com.ziroom.ziroomcustomer.newclean.d.c)getIntent().getSerializableExtra("address"));
    this.T = ((CleanerBean)getIntent().getSerializableExtra("cleanerBean"));
    this.B = getIntent().getStringExtra("cleanerId");
    this.x = getIntent().getStringExtra("appointDateTime");
    this.y = getIntent().getStringExtra("serviceInfoId");
    this.z = getIntent().getStringExtra("servicePmId");
    this.A = getIntent().getStringExtra("addressId");
    this.H = getIntent().getStringExtra("appointDate");
    this.I = getIntent().getStringExtra("appointTime");
    this.J = getIntent().getStringExtra("defaultName");
    this.K = getIntent().getStringExtra("service_price");
    this.L = getIntent().getStringExtra("day_index");
    this.M = getIntent().getStringExtra("card_index");
    this.N = getIntent().getStringExtra("isSelectCleaner");
    this.R = getIntent().getStringExtra("cleanType");
    this.O = ((ag)getIntent().getSerializableExtra("cleanerItem"));
    this.U = ((FrequencyBean)getIntent().getSerializableExtra("selectFreqBean"));
    Object localObject = getIntent().getStringExtra("noneAddress");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("noneAddress".equals(localObject))) {
      this.f.setVisibility(8);
    }
    if ((!TextUtils.isEmpty(this.N)) && ("isSelectCleaner".equals(this.N)))
    {
      this.f.setText("查看日程");
      this.f.setBackgroundColor(40960);
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.ai)) || (!"clean_general".equals(this.ai)))
      {
        this.aa.setVisibility(0);
        this.aa.setBackgroundColor(-1);
        this.aj.setVisibility(0);
        this.ak.setVisibility(0);
        this.W.setVisibility(0);
        findViewById(2131690380).setVisibility(8);
        this.ah.setVisibility(8);
      }
      getCleanerInfo();
      d(this.B);
      this.D.add("全部");
      this.D.add("好评");
      this.D.add("差评");
      localObject = this.D.iterator();
      while (((Iterator)localObject).hasNext()) {
        e((String)((Iterator)localObject).next());
      }
      this.f.setText("预约");
      this.f.setBackgroundColor(40960);
    }
    a(0, 1);
  }
  
  private void back()
  {
    finish();
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getCleanTagNum(this, paramString, new com.freelxl.baselibrary.d.c.a(new f(ah.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, ah paramAnonymousah)
      {
        if (paramAnonymousah != null)
        {
          CleanerActivity.v(CleanerActivity.this).clear();
          CleanerActivity.v(CleanerActivity.this).add("全部(" + paramAnonymousah.getAllTotal() + ")");
          CleanerActivity.v(CleanerActivity.this).add("好评(" + paramAnonymousah.getGoodTotal() + ")");
          CleanerActivity.v(CleanerActivity.this).add("差评(" + paramAnonymousah.getBadTotal() + ")");
          CleanerActivity.w(CleanerActivity.this).removeAllViews();
          paramAnonymousah = CleanerActivity.v(CleanerActivity.this).iterator();
          while (paramAnonymousah.hasNext())
          {
            String str = (String)paramAnonymousah.next();
            CleanerActivity.b(CleanerActivity.this, str);
          }
        }
      }
    });
  }
  
  private void e()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    com.ziroom.ziroomcustomer.e.n.getCleanerEvalInfo(this.b, (String)localObject, this.B, this.x, this.y, this.z, this.A, new com.freelxl.baselibrary.d.c.a(new m(af.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, af paramAnonymousaf)
      {
        if (paramAnonymousaf != null)
        {
          CleanerActivity.a(CleanerActivity.this, paramAnonymousaf);
          CleanerActivity.c(CleanerActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(CleanerActivity.b(CleanerActivity.this).getHeadPic()));
          CleanerActivity.d(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getName());
          CleanerActivity.e(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getAge() + "岁");
          CleanerActivity.f(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getNativePlace());
          if (!TextUtils.isEmpty(CleanerActivity.b(CleanerActivity.this).getServeNum())) {
            CleanerActivity.g(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getServeNum() + "单");
          }
          CleanerActivity.h(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getGoodEvaluateNum() + "单好评");
          CleanerActivity.i(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getHireYearNum() + "年经验");
          CleanerActivity.j(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getHireYearNum() + "年经验");
        }
        try
        {
          paramAnonymousaf = new DecimalFormat("######0.0");
          CleanerActivity.k(CleanerActivity.this).setText(paramAnonymousaf.format(CleanerActivity.b(CleanerActivity.this).getPercent() * 100.0D) + "%");
          CleanerActivity.l(CleanerActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(CleanerActivity.b(CleanerActivity.this).getHeadPic()));
          CleanerActivity.m(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getName());
          CleanerActivity.n(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getAge() + "岁");
          CleanerActivity.o(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getNativePlace());
          CleanerActivity.p(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getHireYearNum() + "年经验");
          if (!TextUtils.isEmpty(CleanerActivity.b(CleanerActivity.this).getServeNum())) {
            CleanerActivity.q(CleanerActivity.this).setText(CleanerActivity.b(CleanerActivity.this).getServeNum() + "单");
          }
          paramAnonymousInt = CleanerActivity.b(CleanerActivity.this).getRankMedal();
          if (paramAnonymousInt == 1)
          {
            CleanerActivity.r(CleanerActivity.this).setBackgroundResource(2130840106);
            CleanerActivity.s(CleanerActivity.this).setBackgroundResource(2130840106);
            CleanerActivity.t(CleanerActivity.this).setText("金牌保洁员");
            CleanerActivity.u(CleanerActivity.this).setText("金牌保洁员");
            return;
          }
        }
        catch (Exception paramAnonymousaf)
        {
          do
          {
            for (;;)
            {
              paramAnonymousaf.printStackTrace();
            }
            if (paramAnonymousInt == 2)
            {
              CleanerActivity.r(CleanerActivity.this).setBackgroundResource(2130840025);
              CleanerActivity.s(CleanerActivity.this).setBackgroundResource(2130840025);
              CleanerActivity.t(CleanerActivity.this).setText("银牌保洁员");
              CleanerActivity.u(CleanerActivity.this).setText("银牌保洁员");
              return;
            }
          } while (paramAnonymousInt != 3);
          CleanerActivity.r(CleanerActivity.this).setBackgroundResource(2130840024);
          CleanerActivity.s(CleanerActivity.this).setBackgroundResource(2130840024);
          CleanerActivity.t(CleanerActivity.this).setText("铜牌保洁员");
          CleanerActivity.u(CleanerActivity.this).setText("铜牌保洁员");
        }
      }
    });
  }
  
  private void e(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(-6710887);
    localButton.setTextSize(10.0F);
    localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 5.0F));
    localButton.setBackgroundResource(2130838210);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 12.0F), 0);
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        int i = 0;
        VdsAgent.onClick(this, paramAnonymousView);
        CleanerActivity.a(CleanerActivity.this, false);
        Button localButton = (Button)paramAnonymousView;
        if (i < CleanerActivity.w(CleanerActivity.this).getChildCount())
        {
          localButton = (Button)CleanerActivity.w(CleanerActivity.this).getChildAt(i);
          CleanerActivity.a(CleanerActivity.this, i);
          if (localButton == paramAnonymousView)
          {
            localButton.setBackgroundResource(2130838211);
            localButton.setTextColor(CleanerActivity.this.getResources().getColor(2131624583));
            CleanerActivity.b(CleanerActivity.this, 1);
            CleanerActivity.y(CleanerActivity.this).clear();
            CleanerActivity.z(CleanerActivity.this).notifyDataSetChanged();
            CleanerActivity.a(CleanerActivity.this, CleanerActivity.D(CleanerActivity.this), 1);
          }
          for (;;)
          {
            i += 1;
            break;
            localButton.setBackgroundResource(2130838210);
            localButton.setTextColor(-6710887);
          }
        }
      }
    });
    if ((this.aq) && (this.w.getChildCount() > 0))
    {
      paramString = (Button)this.w.getChildAt(0);
      paramString.setBackgroundResource(2130838211);
      paramString.setTextColor(getResources().getColor(2131624583));
    }
    this.w.addView(localButton);
  }
  
  private void f()
  {
    if (this.S != null)
    {
      localIntent = new Intent(this.b, PeriodCleanMainActivity.class);
      localIntent.putExtra("address", this.S);
      localIntent.putExtra("cleaner", this.T);
      localIntent.putExtra("selectFreqBean", this.U);
      startActivity(localIntent);
      return;
    }
    if ((!TextUtils.isEmpty(this.N)) && ("isSelectCleaner".equals(this.N)))
    {
      localIntent = new Intent(this.b, CleanerTimeActivity.class);
      localIntent.putExtra("iscleaner", "iscleaner");
      localIntent.putExtra("cleanerId", this.B);
      localIntent.putExtra("appointDate", this.H);
      localIntent.putExtra("serviceInfoId", this.y);
      localIntent.putExtra("servicePmId", this.z);
      localIntent.putExtra("addressId", this.A);
      localIntent.putExtra("cleanerItem", this.O);
      localIntent.putExtra("defaultName", this.J);
      localIntent.putExtra("day_index", this.L);
      localIntent.putExtra("card_index", this.M);
      localIntent.putExtra("service_price", this.K);
      localIntent.putExtra("isDayCleaner", "isDayCleaner");
      localIntent.putExtra("cleanType", this.R);
      localIntent.putExtra("appointDateTime", this.x);
      startActivity(localIntent);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("clean_time_info");
    localIntent.putExtra("appointDate", this.H);
    localIntent.putExtra("servicePmId", this.z);
    localIntent.putExtra("appointTime", this.I);
    localIntent.putExtra("defaultName", this.J);
    localIntent.putExtra("service_price", this.K);
    localIntent.putExtra("cleanType", this.R);
    if (this.C != null)
    {
      localIntent.putExtra("cleanname", this.C.getName());
      localIntent.putExtra("cleanage", this.C.getAge());
      localIntent.putExtra("cleanplace", this.C.getNativePlace());
      localIntent.putExtra("employeeLogicCode", this.C.getCleanerId());
    }
    localIntent.putExtra("day_index", this.L);
    localIntent.putExtra("card_index", this.M);
    localIntent.putExtra("appointDateTime", this.x);
    ApplicationEx.c.sendBroadcast(localIntent);
    if (SelectCleanerActivity.a != null) {
      SelectCleanerActivity.a.finish();
    }
    if (CleanerTimeActivity.a != null) {
      CleanerTimeActivity.a.finish();
    }
    finish();
  }
  
  private void g()
  {
    if ((TextUtils.isEmpty(this.ai)) || (!"clean_general".equals(this.ai))) {
      return;
    }
    a(getIntent().getParcelableArrayListExtra("easy_transition_options"));
  }
  
  public void getCleanerInfo()
  {
    if (this.T != null)
    {
      this.x = i.getCleanerTime();
      this.y = "2c9084454b7835b0014b7841269101a9";
      com.ziroom.ziroomcustomer.e.n.getGeneralItem(this.b, 1, 10, this.y, new com.freelxl.baselibrary.d.c.a(new l(ai.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, List<ai> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            CleanerActivity.a(CleanerActivity.this, ((ai)paramAnonymousList.get(0)).getServPmId());
            CleanerActivity.a(CleanerActivity.this);
          }
        }
      });
      return;
    }
    e();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      back();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903156);
    this.b = this;
    a = this;
    a();
    b();
    g();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLoadMore()
  {
    int i = this.G;
    int j = this.F + 1;
    this.F = j;
    a(i, j);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */