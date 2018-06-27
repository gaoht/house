package com.ziroom.ziroomcustomer.newclean.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.g.a;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.ag;
import com.ziroom.ziroomcustomer.newclean.d.ai;
import com.ziroom.ziroomcustomer.newclean.d.ay;
import com.ziroom.ziroomcustomer.newclean.d.s;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanerSelectActivity;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class CleanTimeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static CleanTimeActivity a = null;
  private String A;
  private List<String> B = new ArrayList();
  private String C;
  private List<ai> D;
  private TextView E;
  private TextView F;
  private List<String> G = new ArrayList();
  private List<String> H = new ArrayList();
  private View I;
  private UserInfo J;
  private String K;
  private String L;
  private List<ay> M;
  private List<String> N = new ArrayList();
  private String O;
  private String P;
  private RelativeLayout Q;
  private SimpleDraweeView R;
  private TextView S;
  private TextView T;
  private TextView U;
  private ImageView V;
  private ImageView W;
  private ImageView X;
  private ImageView Y;
  private ImageView Z;
  private TextView aa;
  private String ab;
  private String ac;
  private ag ad;
  private View ae;
  private String af;
  private LinearLayout ag;
  private ImageView ah;
  private int ai = 0;
  private String aj;
  private String ak;
  private String al;
  private SharedPreferences am;
  private boolean an;
  private String ao;
  private String ap;
  private boolean aq = false;
  private String ar;
  private Timer as = new Timer(true);
  private String at;
  private TextView au;
  private TimerTask av = new TimerTask()
  {
    public void run()
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      CleanTimeActivity.a(CleanTimeActivity.this).sendMessage(localMessage);
    }
  };
  private LinearLayout aw;
  private TextView ax;
  private Handler ay = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 69896: 
      case 69957: 
        do
        {
          return;
          if (((l)localObject).getSuccess().booleanValue())
          {
            CleanTimeActivity.b(CleanTimeActivity.this, (List)((l)localObject).getObject());
            if ((CleanTimeActivity.q(CleanTimeActivity.this) != null) && (CleanTimeActivity.q(CleanTimeActivity.this).size() > 0))
            {
              paramAnonymousMessage = CleanTimeActivity.q(CleanTimeActivity.this).iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (ai)paramAnonymousMessage.next();
                CleanTimeActivity.n(CleanTimeActivity.this).add(((ai)localObject).getServPmName() + "    " + ((ai)localObject).getServPmPrice() + "元");
              }
            }
          }
          else
          {
            com.freelxl.baselibrary.f.g.textToast(CleanTimeActivity.c(CleanTimeActivity.this), ((l)localObject).getMessage());
          }
          CleanTimeActivity.this.dismissProgress();
          return;
          if (!((l)localObject).getSuccess().booleanValue()) {
            break;
          }
          paramAnonymousMessage = (List)((l)localObject).getObject();
          CleanTimeActivity.u(CleanTimeActivity.this).clear();
          CleanTimeActivity.v(CleanTimeActivity.this).clear();
          CleanTimeActivity.t(CleanTimeActivity.this).clear();
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() > 0))
          {
            paramAnonymousMessage = paramAnonymousMessage.iterator();
            while (paramAnonymousMessage.hasNext())
            {
              localObject = (com.ziroom.ziroomcustomer.newclean.d.u)paramAnonymousMessage.next();
              CleanTimeActivity.t(CleanTimeActivity.this).add(((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDate());
              CleanTimeActivity.u(CleanTimeActivity.this).add(i.getDayTime(((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDateWeek(), ((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDate()));
              CleanTimeActivity.v(CleanTimeActivity.this).add(i.getCandleTime(((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDate()));
            }
          }
          CleanTimeActivity.a(CleanTimeActivity.this, CleanTimeActivity.u(CleanTimeActivity.this), CleanTimeActivity.v(CleanTimeActivity.this), 4);
        } while ((CleanTimeActivity.t(CleanTimeActivity.this) == null) || (CleanTimeActivity.t(CleanTimeActivity.this).size() <= 0));
        if (TextUtils.isEmpty(CleanTimeActivity.l(CleanTimeActivity.this)))
        {
          CleanTimeActivity.i(CleanTimeActivity.this, (String)CleanTimeActivity.t(CleanTimeActivity.this).get(0));
          CleanTimeActivity.r(CleanTimeActivity.this);
          return;
        }
        CleanTimeActivity.r(CleanTimeActivity.this);
        return;
        com.freelxl.baselibrary.f.g.textToast(CleanTimeActivity.c(CleanTimeActivity.this), ((l)localObject).getMessage());
        return;
      }
      CleanTimeActivity.d(CleanTimeActivity.this).scrollBy(com.ziroom.ziroomcustomer.util.n.dip2px(CleanTimeActivity.c(CleanTimeActivity.this), 1.0F), 0);
    }
  };
  private ImageView b;
  private LabeledEditText c;
  private View d;
  private View e;
  private ViewGroup f;
  private HorizontalScrollView g;
  private int r;
  private Context s;
  private MyGridView t;
  private com.ziroom.ziroomcustomer.newclean.b.o u;
  private TextView v;
  private RelativeLayout w;
  private TextView x;
  private TextView y;
  private int z = 0;
  
  private void a()
  {
    View localView = findViewById(2131689541);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((LabeledEditText)findViewById(2131690367));
    this.d = findViewById(2131690366);
    this.e = findViewById(2131690368);
    this.f = ((ViewGroup)findViewById(2131690094));
    this.g = ((HorizontalScrollView)findViewById(2131690093));
    this.t = ((MyGridView)findViewById(2131689973));
    this.v = ((TextView)findViewById(2131689541));
    this.w = ((RelativeLayout)findViewById(2131690362));
    this.x = ((TextView)findViewById(2131690363));
    this.y = ((TextView)findViewById(2131689956));
    this.ae = findViewById(2131690375);
    this.ag = ((LinearLayout)findViewById(2131690377));
    this.au = ((TextView)findViewById(2131689857));
    this.Q = ((RelativeLayout)findViewById(2131690369));
    this.R = ((SimpleDraweeView)findViewById(2131690047));
    this.S = ((TextView)findViewById(2131690371));
    this.T = ((TextView)findViewById(2131690372));
    this.U = ((TextView)findViewById(2131690373));
    this.V = ((ImageView)findViewById(2131690054));
    this.W = ((ImageView)findViewById(2131690055));
    this.X = ((ImageView)findViewById(2131690056));
    this.Y = ((ImageView)findViewById(2131690057));
    this.Z = ((ImageView)findViewById(2131690058));
    this.aa = ((TextView)findViewById(2131690374));
    this.ah = ((ImageView)findViewById(2131690376));
    this.aw = ((LinearLayout)findViewById(2131690364));
    this.ax = ((TextView)findViewById(2131690365));
  }
  
  @SuppressLint({"NewApi"})
  private void a(List<String> paramList1, List<String> paramList2, int paramInt)
  {
    int i = getWindowManager().getDefaultDisplay().getWidth() / 9;
    Object localObject = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject).width = -2;
    ((ViewPager.LayoutParams)localObject).height = -2;
    localObject = getLayoutInflater();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject).inflate(2130904225, null);
      this.E = ((TextView)localRelativeLayout.findViewById(2131695057));
      this.F = ((TextView)localRelativeLayout.findViewById(2131695058));
      this.I = localRelativeLayout.findViewById(2131693860);
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i * 2, -1));
      this.E.setText((CharSequence)paramList1.get(paramInt));
      this.F.setText((CharSequence)paramList2.get(paramInt));
      localRelativeLayout.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          for (;;)
          {
            if (i < CleanTimeActivity.s(CleanTimeActivity.this).getChildCount())
            {
              if ((RelativeLayout)CleanTimeActivity.s(CleanTimeActivity.this).getChildAt(i) == paramAnonymousView)
              {
                CleanTimeActivity.b(CleanTimeActivity.this, i);
                CleanTimeActivity.c(CleanTimeActivity.this, i);
                CleanTimeActivity.i(CleanTimeActivity.this, (String)CleanTimeActivity.t(CleanTimeActivity.this).get(i));
                CleanTimeActivity.a(CleanTimeActivity.this, "");
                CleanTimeActivity.b(CleanTimeActivity.this, "");
                CleanTimeActivity.r(CleanTimeActivity.this);
              }
            }
            else {
              return;
            }
            i += 1;
          }
        }
      });
      if (paramInt == this.ai)
      {
        this.E.setTextColor(40960);
        this.F.setTextColor(40960);
        this.I.setVisibility(0);
      }
      for (;;)
      {
        this.f.addView(localRelativeLayout);
        paramInt += 1;
        break;
        this.E.setTextColor(-12303292);
        this.F.setTextColor(-6710887);
        this.I.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
  }
  
  @SuppressLint({"NewApi"})
  private void b(int paramInt)
  {
    int m = 0;
    this.f.measure(this.f.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.f.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int k = 0;
    int j = 0;
    int i = 0;
    int n;
    if (k < this.f.getChildCount())
    {
      localObject = (RelativeLayout)this.f.getChildAt(k);
      n = ((RelativeLayout)localObject).getMeasuredWidth();
      if (k >= paramInt) {
        break label382;
      }
      i += n;
    }
    label352:
    label382:
    for (;;)
    {
      if (paramInt == k)
      {
        ((TextView)((RelativeLayout)localObject).findViewById(2131695057)).setTextColor(33792);
        ((TextView)((RelativeLayout)localObject).findViewById(2131695058)).setTextColor(33792);
        ((RelativeLayout)localObject).findViewById(2131693860).setVisibility(0);
      }
      for (;;)
      {
        k += 1;
        j += n;
        break;
        ((TextView)((RelativeLayout)localObject).findViewById(2131695057)).setTextColor(-12303292);
        ((TextView)((RelativeLayout)localObject).findViewById(2131695058)).setTextColor(-6710887);
        ((RelativeLayout)localObject).findViewById(2131693860).setVisibility(8);
      }
      n = this.f.getChildAt(paramInt).getMeasuredWidth();
      k = m;
      int i1;
      if (paramInt > 0)
      {
        if (paramInt == this.f.getChildCount() - 1) {
          k = m;
        }
      }
      else
      {
        m = getWindowManager().getDefaultDisplay().getWidth();
        i1 = i - (m - n) / 2 - (m - n) / 4;
        if (this.r >= paramInt) {
          break label352;
        }
        if (n + i + k >= m / 2) {
          ((HorizontalScrollView)this.f.getParent()).setScrollX(i1 * 2);
        }
      }
      for (;;)
      {
        this.r = paramInt;
        return;
        k = this.f.getChildAt(paramInt - 1).getMeasuredWidth();
        break;
        if (j - i >= m / 2) {
          ((HorizontalScrollView)this.f.getParent()).setScrollX(i1 * 2);
        }
      }
    }
  }
  
  private void d(String paramString)
  {
    e.newBuilder(this.s).setTitle("提示").setContent(paramString).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanTimeActivity.this.finish();
      }
    }).build().show();
  }
  
  private void e()
  {
    this.K = getIntent().getStringExtra("appointDate");
    this.A = getIntent().getStringExtra("serviceInfoId");
    this.C = getIntent().getStringExtra("servicePmId");
    this.L = getIntent().getStringExtra("addressId");
    this.O = getIntent().getStringExtra("defaultName");
    this.ac = getIntent().getStringExtra("cleanerId");
    this.ad = ((ag)getIntent().getSerializableExtra("cleanerItem"));
    this.aj = getIntent().getStringExtra("day_index");
    this.ak = getIntent().getStringExtra("card_index");
    this.al = getIntent().getStringExtra("service_price");
    this.ao = getIntent().getStringExtra("isSelectCleaner");
    this.P = getIntent().getStringExtra("appointDateTime");
    this.af = getIntent().getStringExtra("appointTime");
    this.ap = getIntent().getStringExtra("isDayCleaner");
    this.ar = getIntent().getStringExtra("cleanType");
    if ("2c9084454b7835b0014b7841269101a9".equals(this.A))
    {
      this.aw.setVisibility(0);
      this.ax.setText("想预约的时间预约不上？使用周期预约快人一步锁定服务时间");
      this.aw.setOnClickListener(this);
    }
    try
    {
      this.ai = Integer.parseInt(this.aj);
      this.z = Integer.parseInt(this.ak);
      b(this.ai);
      this.c.setText(this.O);
      com.ziroom.ziroomcustomer.e.o.getCleanDataTime(this.s, this.ay, this.A, this.C);
      this.J = ApplicationEx.c.getUser();
      this.ab = getIntent().getStringExtra("iscleaner");
      this.am = getSharedPreferences("cleanTime_animation", 0);
      this.an = this.am.getBoolean("cleanTime_is_first", true);
      if (this.an)
      {
        Object localObject = this.am.edit();
        ((SharedPreferences.Editor)localObject).putBoolean("cleanTime_is_first", false);
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new TranslateAnimation(0.0F, -com.ziroom.ziroomcustomer.util.n.dip2px(this.s, 100.0F), 0.0F, 0.0F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject).setDuration(1500L);
        localAlphaAnimation.setDuration(1500L);
        ((Animation)localObject).setRepeatCount(1);
        localAlphaAnimation.setRepeatCount(1);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setFillEnabled(true);
        this.ah.setAnimation(localAnimationSet);
        localAnimationSet.startNow();
        this.as.schedule(this.av, 100L, 10L);
        localAnimationSet.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            CleanTimeActivity.b(CleanTimeActivity.this).cancel();
            CleanTimeActivity.d(CleanTimeActivity.this).scrollBy(-com.ziroom.ziroomcustomer.util.n.dip2px(CleanTimeActivity.c(CleanTimeActivity.this), 300.0F), 0);
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.u = new com.ziroom.ziroomcustomer.newclean.b.o(4, this.M, this.s);
        this.t.setAdapter(this.u);
        this.t.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if ("0".equals(((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(paramAnonymousInt)).getFlag()))
            {
              if (CleanTimeActivity.f(CleanTimeActivity.this) != null) {
                CleanTimeActivity.f(CleanTimeActivity.this).setSelectPosition(paramAnonymousInt);
              }
              CleanTimeActivity.a(CleanTimeActivity.this, ((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(paramAnonymousInt)).getDatePlan());
              CleanTimeActivity.b(CleanTimeActivity.this, ((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(paramAnonymousInt)).getTimePoint());
              CleanTimeActivity.a(CleanTimeActivity.this, paramAnonymousInt);
              CleanTimeActivity.a(CleanTimeActivity.this, true);
              return;
            }
            CleanTimeActivity.a(CleanTimeActivity.this, false);
            com.freelxl.baselibrary.f.g.textToast(CleanTimeActivity.c(CleanTimeActivity.this), "已约满，请选择其他时间");
          }
        });
        if (!"2c9084454b7835b0014b7841269101a9".equals(this.A)) {
          break label658;
        }
        this.c.setTopHint("服务时长");
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        j.getServiceCalendarTip(this.s, "clean", this.au);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.ah.setVisibility(8);
        continue;
        label658:
        if ("8a90a5d8580a5cb2015822c397920018".equals(this.A))
        {
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          this.e.setVisibility(8);
        }
        else if ("8a90a5d85841edb0015847dd78a80014".equals(this.A))
        {
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          this.e.setVisibility(8);
        }
        else
        {
          this.c.setTopHint("服务项目");
          this.c.setVisibility(8);
          this.d.setVisibility(8);
          this.e.setVisibility(8);
        }
      }
    }
  }
  
  private void f()
  {
    if ("2c9084454b7835b0014b7841269101a9".equals(this.A))
    {
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.y.setVisibility(0);
    }
    for (;;)
    {
      this.ae.setVisibility(8);
      if (this.J != null) {
        com.ziroom.ziroomcustomer.e.n.getCommonCleanCapacity(this.s, this.J.getUid(), this.K, this.A, this.C, this.L, new b(), true);
      }
      return;
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.y.setVisibility(0);
    }
  }
  
  private void g()
  {
    if (!this.aq)
    {
      com.freelxl.baselibrary.f.g.textToast(this.s, "请先选择预约时间");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("clean_time_info");
    localIntent.putExtra("appointDate", this.K);
    localIntent.putExtra("servicePmId", this.C);
    localIntent.putExtra("appointTime", this.af);
    localIntent.putExtra("day_index", this.ai + "");
    localIntent.putExtra("card_index", this.z + "");
    localIntent.putExtra("defaultName", this.O);
    localIntent.putExtra("service_price", this.al);
    localIntent.putExtra("cleanType", this.ar);
    localIntent.putExtra("appointDateTime", this.P);
    localIntent.putExtra("isFromCleanTime", "yes");
    if (this.ad != null)
    {
      localIntent.putExtra("cleanname", this.ad.getName());
      localIntent.putExtra("cleanage", this.ad.getAge());
      localIntent.putExtra("cleanplace", this.ad.getNativePlace());
    }
    ApplicationEx.c.sendBroadcast(localIntent);
    finish();
  }
  
  private void h()
  {
    if (!this.aq)
    {
      com.freelxl.baselibrary.f.g.textToast(this.s, "请先选择预约时间");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("clean_time_info");
    localIntent.putExtra("appointDate", this.K);
    localIntent.putExtra("servicePmId", this.C);
    localIntent.putExtra("appointTime", this.af);
    localIntent.putExtra("day_index", this.ai + "");
    localIntent.putExtra("card_index", this.z + "");
    localIntent.putExtra("defaultName", this.O);
    localIntent.putExtra("service_price", this.al);
    localIntent.putExtra("cleanType", this.ar);
    ApplicationEx.c.sendBroadcast(localIntent);
    finish();
  }
  
  private void i()
  {
    Object localObject = new com.ziroom.ziroomcustomer.dialog.g(this, new a(), this.B, null);
    ((com.ziroom.ziroomcustomer.dialog.g)localObject).setCanceledOnTouchOutside(true);
    Window localWindow = ((com.ziroom.ziroomcustomer.dialog.g)localObject).getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
    ((com.ziroom.ziroomcustomer.dialog.g)localObject).show();
    localObject = ((com.ziroom.ziroomcustomer.dialog.g)localObject).getTv_choose();
    if ("2c9084454b7835b0014b7841269101a9".equals(this.A))
    {
      ((TextView)localObject).setText("服务时长");
      return;
    }
    ((TextView)localObject).setText("服务项目");
  }
  
  private void j()
  {
    if (!this.aq)
    {
      com.freelxl.baselibrary.f.g.textToast(this.s, "请先选择预约时间");
      return;
    }
    if (TextUtils.isEmpty(this.P))
    {
      com.freelxl.baselibrary.f.g.textToast(this.s, "请先选择时间");
      return;
    }
    Intent localIntent = new Intent(this.s, SelectCleanerActivity.class);
    localIntent.putExtra("appointDateTime", this.P);
    localIntent.putExtra("serviceInfoId", this.A);
    localIntent.putExtra("servicePmId", this.C);
    localIntent.putExtra("addressId", this.L);
    localIntent.putExtra("appointDate", this.K);
    localIntent.putExtra("defaultName", this.O);
    localIntent.putExtra("appointTime", this.af);
    localIntent.putExtra("day_index", this.ai + "");
    localIntent.putExtra("card_index", this.z + "");
    localIntent.putExtra("service_price", this.al);
    localIntent.putExtra("cleanType", this.ar);
    startActivity(localIntent);
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
      this.as.cancel();
      finish();
      return;
    case 2131690367: 
      i();
      return;
    case 2131690362: 
      h();
      return;
    case 2131690363: 
      j();
      return;
    case 2131689956: 
      g();
      return;
    }
    PeriodCleanerSelectActivity.StartPeriodCleanActivity(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903155);
    this.s = this;
    a = this;
    a();
    b();
    e();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.as.cancel();
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  class a
    implements g.a
  {
    a() {}
    
    public void showHour(String paramString, int paramInt)
    {
      CleanTimeActivity.o(CleanTimeActivity.this).setText((String)CleanTimeActivity.n(CleanTimeActivity.this).get(paramInt));
      if ("2c9084454b7835b0014b7841269101a9".equals(CleanTimeActivity.p(CleanTimeActivity.this))) {
        CleanTimeActivity.o(CleanTimeActivity.this).setTopHint("服务时长");
      }
      for (;;)
      {
        CleanTimeActivity.e(CleanTimeActivity.this, ((ai)CleanTimeActivity.q(CleanTimeActivity.this).get(paramInt)).getServPmId());
        CleanTimeActivity.f(CleanTimeActivity.this, ((ai)CleanTimeActivity.q(CleanTimeActivity.this).get(paramInt)).getServPmPrice() + "");
        CleanTimeActivity.g(CleanTimeActivity.this, ((ai)CleanTimeActivity.q(CleanTimeActivity.this).get(paramInt)).getServPmName());
        CleanTimeActivity.h(CleanTimeActivity.this, (String)CleanTimeActivity.n(CleanTimeActivity.this).get(paramInt));
        CleanTimeActivity.r(CleanTimeActivity.this);
        return;
        CleanTimeActivity.o(CleanTimeActivity.this).setTopHint("服务项目");
      }
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      com.ziroom.ziroomcustomer.util.u.d("dsdkdsg", "======" + com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((s)a.parseObject(paramString.get("data").toString(), s.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      int k = 0;
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (s)paramk.getObject();
        CleanTimeActivity.a(CleanTimeActivity.this, paramk.getOptionDateList());
        CleanTimeActivity.c(CleanTimeActivity.this, paramk.getTransactionScheduleSwitch());
        if ("on".equals(CleanTimeActivity.g(CleanTimeActivity.this)))
        {
          CleanTimeActivity.h(CleanTimeActivity.this).setVisibility(8);
          CleanTimeActivity.i(CleanTimeActivity.this).setVisibility(8);
          CleanTimeActivity.j(CleanTimeActivity.this).setVisibility(0);
        }
      }
      label122:
      label444:
      do
      {
        if ((CleanTimeActivity.e(CleanTimeActivity.this) != null) && (CleanTimeActivity.e(CleanTimeActivity.this).size() > 0))
        {
          int i = 0;
          if (i < CleanTimeActivity.e(CleanTimeActivity.this).size())
          {
            if ("0".equals(((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(i)).getFlag())) {
              CleanTimeActivity.a(CleanTimeActivity.this, true);
            }
          }
          else
          {
            CleanTimeActivity.k(CleanTimeActivity.this).setVisibility(0);
            CleanTimeActivity.f(CleanTimeActivity.this).setData(CleanTimeActivity.e(CleanTimeActivity.this));
            if (!TextUtils.isEmpty(CleanTimeActivity.l(CleanTimeActivity.this))) {
              break label444;
            }
            i = 0;
          }
          for (;;)
          {
            int j = k;
            if (i < CleanTimeActivity.e(CleanTimeActivity.this).size())
            {
              if ("0".equals(((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(i)).getFlag()))
              {
                CleanTimeActivity.a(CleanTimeActivity.this, i);
                CleanTimeActivity.a(CleanTimeActivity.this, ((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(CleanTimeActivity.m(CleanTimeActivity.this))).getDatePlan());
                CleanTimeActivity.b(CleanTimeActivity.this, ((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(CleanTimeActivity.m(CleanTimeActivity.this))).getTimePoint());
                CleanTimeActivity.f(CleanTimeActivity.this).setSelectPosition(i);
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                CleanTimeActivity.f(CleanTimeActivity.this).setSelectPosition(-1);
              }
              CleanTimeActivity.f(CleanTimeActivity.this).notifyDataSetChanged();
              return;
              if (!"off".equals(CleanTimeActivity.g(CleanTimeActivity.this))) {
                break;
              }
              CleanTimeActivity.h(CleanTimeActivity.this).setVisibility(8);
              CleanTimeActivity.i(CleanTimeActivity.this).setVisibility(8);
              CleanTimeActivity.j(CleanTimeActivity.this).setVisibility(0);
              break;
              i += 1;
              break label122;
            }
            i += 1;
          }
          if ("0".equals(((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(CleanTimeActivity.m(CleanTimeActivity.this))).getFlag()))
          {
            CleanTimeActivity.a(CleanTimeActivity.this, ((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(CleanTimeActivity.m(CleanTimeActivity.this))).getDatePlan());
            CleanTimeActivity.b(CleanTimeActivity.this, ((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(CleanTimeActivity.m(CleanTimeActivity.this))).getTimePoint());
            CleanTimeActivity.f(CleanTimeActivity.this).setSelectPosition(CleanTimeActivity.m(CleanTimeActivity.this));
          }
          for (;;)
          {
            CleanTimeActivity.f(CleanTimeActivity.this).notifyDataSetChanged();
            return;
            if ("1".equals(((ay)CleanTimeActivity.e(CleanTimeActivity.this).get(CleanTimeActivity.m(CleanTimeActivity.this))).getFlag()))
            {
              CleanTimeActivity.f(CleanTimeActivity.this).setSelectPosition(-1);
              CleanTimeActivity.a(CleanTimeActivity.this, false);
            }
          }
        }
        CleanTimeActivity.a(CleanTimeActivity.this, false);
        CleanTimeActivity.k(CleanTimeActivity.this).setVisibility(8);
        return;
        CleanTimeActivity.a(CleanTimeActivity.this, false);
        CleanTimeActivity.k(CleanTimeActivity.this).setVisibility(8);
      } while (TextUtils.isEmpty(paramk.getMessage()));
      if ("服务异常".equals(paramk.getMessage()))
      {
        com.freelxl.baselibrary.f.g.textToast(CleanTimeActivity.c(CleanTimeActivity.this), paramk.getMessage());
        return;
      }
      CleanTimeActivity.d(CleanTimeActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */