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
import com.freelxl.baselibrary.f.c;
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
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CleanerTimeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static CleanerTimeActivity a = null;
  private String A;
  private List<ai> B;
  private TextView C;
  private TextView D;
  private List<String> E = new ArrayList();
  private List<String> F = new ArrayList();
  private View G;
  private UserInfo H;
  private String I;
  private String J;
  private List<ay> K;
  private List<String> L = new ArrayList();
  private String M;
  private List<Integer> N = new ArrayList();
  private String O;
  private RelativeLayout P;
  private SimpleDraweeView Q;
  private TextView R;
  private TextView S;
  private TextView T;
  private ImageView U;
  private ImageView V;
  private ImageView W;
  private ImageView X;
  private ImageView Y;
  private TextView Z;
  private String aa;
  private String ab;
  private ag ac;
  private View ad;
  private String ae;
  private LinearLayout af;
  private TextView ag;
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
  private Handler as = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69896: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          CleanerTimeActivity.b(CleanerTimeActivity.this, (List)((l)localObject).getObject());
          if ((CleanerTimeActivity.k(CleanerTimeActivity.this) == null) || (CleanerTimeActivity.k(CleanerTimeActivity.this).size() <= 0)) {
            break label215;
          }
          paramAnonymousMessage = CleanerTimeActivity.k(CleanerTimeActivity.this).iterator();
        }
        break;
      }
      for (;;)
      {
        if (paramAnonymousMessage.hasNext()) {
          localObject = (ai)paramAnonymousMessage.next();
        }
        try
        {
          CleanerTimeActivity.o(CleanerTimeActivity.this).add(Integer.valueOf(Integer.parseInt(((ai)localObject).getServPmName().substring(0, 1))));
          CleanerTimeActivity.h(CleanerTimeActivity.this).add(((ai)localObject).getServPmName() + "    " + ((ai)localObject).getServPmPrice() + "元");
          continue;
          com.freelxl.baselibrary.f.g.textToast(CleanerTimeActivity.c(CleanerTimeActivity.this), ((l)localObject).getMessage());
          label215:
          CleanerTimeActivity.this.dismissProgress();
          return;
          if (((l)localObject).getSuccess().booleanValue())
          {
            paramAnonymousMessage = (List)((l)localObject).getObject();
            CleanerTimeActivity.p(CleanerTimeActivity.this).clear();
            CleanerTimeActivity.q(CleanerTimeActivity.this).clear();
            CleanerTimeActivity.n(CleanerTimeActivity.this).clear();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() > 0))
            {
              paramAnonymousMessage = paramAnonymousMessage.iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (com.ziroom.ziroomcustomer.newclean.d.u)paramAnonymousMessage.next();
                CleanerTimeActivity.n(CleanerTimeActivity.this).add(((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDate());
                CleanerTimeActivity.p(CleanerTimeActivity.this).add(i.getDayTime(((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDateWeek(), ((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDate()));
                CleanerTimeActivity.q(CleanerTimeActivity.this).add(i.getCandleTime(((com.ziroom.ziroomcustomer.newclean.d.u)localObject).getDate()));
              }
            }
            CleanerTimeActivity.a(CleanerTimeActivity.this, CleanerTimeActivity.p(CleanerTimeActivity.this), CleanerTimeActivity.q(CleanerTimeActivity.this), 4);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(CleanerTimeActivity.c(CleanerTimeActivity.this), ((l)localObject).getMessage());
          return;
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
    }
  };
  private ImageView b;
  private LabeledEditText c;
  private ViewGroup d;
  private HorizontalScrollView e;
  private int f;
  private Context g;
  private MyGridView r;
  private com.ziroom.ziroomcustomer.newclean.b.o s;
  private TextView t;
  private RelativeLayout u;
  private TextView v;
  private TextView w;
  private int x = 0;
  private String y;
  private List<String> z = new ArrayList();
  
  private void a()
  {
    View localView = findViewById(2131689541);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((LabeledEditText)findViewById(2131690367));
    this.d = ((ViewGroup)findViewById(2131690094));
    this.e = ((HorizontalScrollView)findViewById(2131690093));
    this.r = ((MyGridView)findViewById(2131689973));
    this.t = ((TextView)findViewById(2131689541));
    this.u = ((RelativeLayout)findViewById(2131690362));
    this.v = ((TextView)findViewById(2131690363));
    this.w = ((TextView)findViewById(2131689956));
    this.ad = findViewById(2131690375);
    this.af = ((LinearLayout)findViewById(2131690377));
    this.P = ((RelativeLayout)findViewById(2131690369));
    this.Q = ((SimpleDraweeView)findViewById(2131690047));
    this.R = ((TextView)findViewById(2131690371));
    this.S = ((TextView)findViewById(2131690372));
    this.T = ((TextView)findViewById(2131690373));
    this.U = ((ImageView)findViewById(2131690054));
    this.V = ((ImageView)findViewById(2131690055));
    this.W = ((ImageView)findViewById(2131690056));
    this.X = ((ImageView)findViewById(2131690057));
    this.Y = ((ImageView)findViewById(2131690058));
    this.Z = ((TextView)findViewById(2131690374));
    this.ah = ((ImageView)findViewById(2131690376));
    this.ag = ((TextView)findViewById(2131689857));
  }
  
  @SuppressLint({"NewApi"})
  private void a(List<String> paramList1, List<String> paramList2, int paramInt)
  {
    paramInt = getWindowManager().getDefaultDisplay().getWidth();
    Object localObject = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject).width = -2;
    ((ViewPager.LayoutParams)localObject).height = -2;
    int i = paramInt / 9;
    localObject = getLayoutInflater();
    paramInt = 0;
    if (paramInt < paramList1.size())
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject).inflate(2130904225, null);
      this.C = ((TextView)localRelativeLayout.findViewById(2131695057));
      this.D = ((TextView)localRelativeLayout.findViewById(2131695058));
      this.G = localRelativeLayout.findViewById(2131693860);
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i * 2, -1));
      this.C.setText((CharSequence)paramList1.get(paramInt));
      this.D.setText((CharSequence)paramList2.get(paramInt));
      localRelativeLayout.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          for (;;)
          {
            if (i < CleanerTimeActivity.m(CleanerTimeActivity.this).getChildCount())
            {
              if ((RelativeLayout)CleanerTimeActivity.m(CleanerTimeActivity.this).getChildAt(i) == paramAnonymousView)
              {
                CleanerTimeActivity.b(CleanerTimeActivity.this, i);
                CleanerTimeActivity.c(CleanerTimeActivity.this, i);
                CleanerTimeActivity.h(CleanerTimeActivity.this, (String)CleanerTimeActivity.n(CleanerTimeActivity.this).get(i));
                CleanerTimeActivity.l(CleanerTimeActivity.this);
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
        this.C.setTextColor(33792);
        this.D.setTextColor(33792);
        this.G.setVisibility(0);
      }
      for (;;)
      {
        this.d.addView(localRelativeLayout);
        paramInt += 1;
        break;
        this.C.setTextColor(-12303292);
        this.D.setTextColor(-6710887);
        this.G.setVisibility(8);
      }
    }
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
  }
  
  @SuppressLint({"NewApi"})
  private void b(int paramInt)
  {
    int m = 0;
    this.d.measure(this.d.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.d.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int k = 0;
    int j = 0;
    int i = 0;
    int n;
    if (k < this.d.getChildCount())
    {
      localObject = (RelativeLayout)this.d.getChildAt(k);
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
      n = this.d.getChildAt(paramInt).getMeasuredWidth();
      k = m;
      int i1;
      if (paramInt > 0)
      {
        if (paramInt == this.d.getChildCount() - 1) {
          k = m;
        }
      }
      else
      {
        m = getWindowManager().getDefaultDisplay().getWidth();
        i1 = i - (m - n) / 2 - (m - n) / 4;
        if (this.f >= paramInt) {
          break label352;
        }
        if (n + i + k >= m / 2) {
          ((HorizontalScrollView)this.d.getParent()).setScrollX(i1 * 2);
        }
      }
      for (;;)
      {
        this.f = paramInt;
        return;
        k = this.d.getChildAt(paramInt - 1).getMeasuredWidth();
        break;
        if (j - i >= m / 2) {
          ((HorizontalScrollView)this.d.getParent()).setScrollX(i1 * 2);
        }
      }
    }
  }
  
  private void back()
  {
    finish();
  }
  
  private void d(String paramString)
  {
    e.newBuilder(this.g).setTitle("提示").setContent(paramString).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanerTimeActivity.this.finish();
      }
    }).build().show();
  }
  
  private void e()
  {
    this.I = getIntent().getStringExtra("appointDate");
    this.y = getIntent().getStringExtra("serviceInfoId");
    this.A = getIntent().getStringExtra("servicePmId");
    this.J = getIntent().getStringExtra("addressId");
    this.M = getIntent().getStringExtra("defaultName");
    this.ab = getIntent().getStringExtra("cleanerId");
    this.ac = ((ag)getIntent().getSerializableExtra("cleanerItem"));
    this.aj = getIntent().getStringExtra("day_index");
    this.ak = getIntent().getStringExtra("card_index");
    this.al = getIntent().getStringExtra("service_price");
    this.ao = getIntent().getStringExtra("isSelectCleaner");
    this.O = getIntent().getStringExtra("appointDateTime");
    this.ae = getIntent().getStringExtra("appointTime");
    this.ap = getIntent().getStringExtra("isDayCleaner");
    this.ar = getIntent().getStringExtra("cleanType");
    try
    {
      this.ai = Integer.parseInt(this.aj);
      this.x = Integer.parseInt(this.ak);
      b(this.ai);
      this.c.setText(this.M);
      com.ziroom.ziroomcustomer.e.o.getCleanDataTime(this.g, this.as, this.y, this.A);
      this.H = ApplicationEx.c.getUser();
      this.aa = getIntent().getStringExtra("iscleaner");
      f();
      this.am = getSharedPreferences("cleanTime_animation", 0);
      this.an = this.am.getBoolean("cleanTime_is_first", true);
      if (this.an)
      {
        Object localObject = this.am.edit();
        ((SharedPreferences.Editor)localObject).putBoolean("cleanTime_is_first", false);
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new TranslateAnimation(0.0F, -com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 100.0F), 0.0F, 0.0F);
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
        this.s = new com.ziroom.ziroomcustomer.newclean.b.o(4, this.K, this.g);
        this.r.setAdapter(this.s);
        this.r.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            if ("0".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(paramAnonymousInt)).getFlag()))
            {
              if (CleanerTimeActivity.b(CleanerTimeActivity.this) != null) {
                CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(paramAnonymousInt);
              }
              CleanerTimeActivity.a(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(paramAnonymousInt)).getDatePlan());
              CleanerTimeActivity.b(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(paramAnonymousInt)).getTimePoint());
              CleanerTimeActivity.a(CleanerTimeActivity.this, paramAnonymousInt);
              CleanerTimeActivity.a(CleanerTimeActivity.this, true);
              return;
            }
            CleanerTimeActivity.a(CleanerTimeActivity.this, false);
            com.freelxl.baselibrary.f.g.textToast(CleanerTimeActivity.c(CleanerTimeActivity.this), "已约满，请选择其他时间");
          }
        });
        j.getServiceCalendarTip(this.g, "clean", this.ag);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.ah.setVisibility(8);
      }
    }
  }
  
  private void f()
  {
    if ((!TextUtils.isEmpty(this.aa)) && ("iscleaner".equals(this.aa)))
    {
      this.P.setVisibility(0);
      this.ad.setVisibility(0);
      this.t.setText("日程安排");
      this.u.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(0);
      if (this.H != null) {
        com.ziroom.ziroomcustomer.e.n.getCleanerCapacity(this.g, this.H.getUid(), this.ab, this.I, this.y, this.A, this.J, "1.0", new c(), true);
      }
      if (this.ac != null) {
        g();
      }
    }
    do
    {
      return;
      this.u.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(0);
      this.ad.setVisibility(8);
    } while (this.H == null);
    com.ziroom.ziroomcustomer.e.n.getCommonCleanCapacity(this.g, this.H.getUid(), this.I, this.y, this.A, this.J, new b(), true);
  }
  
  private void g()
  {
    this.R.setText(this.ac.getName());
    this.Q.setController(c.frescoController(this.ac.getHeadPic()));
    this.S.setText(this.ac.getAge() + "岁");
    this.T.setText(this.ac.getNativePlace());
    if (!TextUtils.isEmpty(this.ac.getSocre())) {
      j.getStar((int)(Double.parseDouble(this.ac.getSocre()) + 0.5D), this.U, this.V, this.W, this.X, this.Y);
    }
    while (TextUtils.isEmpty(this.ac.getServeNum()))
    {
      this.Z.setText("");
      return;
      j.getStar(5, this.U, this.V, this.W, this.X, this.Y);
    }
    this.Z.setText(this.ac.getServeNum() + "单");
  }
  
  private void h() {}
  
  private void i()
  {
    if (!this.aq)
    {
      com.freelxl.baselibrary.f.g.textToast(this.g, "请先选择预约时间");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("clean_time_info");
    localIntent.putExtra("appointDate", this.I);
    localIntent.putExtra("servicePmId", this.A);
    localIntent.putExtra("appointTime", this.ae);
    localIntent.putExtra("day_index", this.ai + "");
    localIntent.putExtra("card_index", this.x + "");
    localIntent.putExtra("defaultName", this.M);
    localIntent.putExtra("service_price", this.al);
    localIntent.putExtra("cleanType", this.ar);
    localIntent.putExtra("appointDateTime", this.O);
    localIntent.putExtra("isCleanerSchedule", "yes");
    if (this.ac != null)
    {
      localIntent.putExtra("cleanname", this.ac.getName());
      localIntent.putExtra("cleanage", this.ac.getAge());
      localIntent.putExtra("cleanplace", this.ac.getNativePlace());
      localIntent.putExtra("employeeLogicCode", this.ac.getCleanerId());
    }
    ApplicationEx.c.sendBroadcast(localIntent);
    if ((!TextUtils.isEmpty(this.ao)) && ("isSelectCleaner".equals(this.ao)))
    {
      if (SelectCleanerActivity.a != null) {
        SelectCleanerActivity.a.finish();
      }
      finish();
      return;
    }
    if ((!TextUtils.isEmpty(this.ap)) && ("isDayCleaner".equals(this.ap)))
    {
      if (CleanerActivity.a != null) {
        CleanerActivity.a.finish();
      }
      if (SelectCleanerActivity.a != null) {
        SelectCleanerActivity.a.finish();
      }
      finish();
      return;
    }
    finish();
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("clean_time_info");
    localIntent.putExtra("appointDate", this.I);
    localIntent.putExtra("servicePmId", this.A);
    localIntent.putExtra("appointTime", this.ae);
    localIntent.putExtra("day_index", this.ai + "");
    localIntent.putExtra("card_index", this.x + "");
    localIntent.putExtra("defaultName", this.M);
    localIntent.putExtra("service_price", this.al);
    ApplicationEx.c.sendBroadcast(localIntent);
    com.ziroom.ziroomcustomer.util.u.e("sdjfs", this.ae);
    finish();
  }
  
  private void k()
  {
    Object localObject = new com.ziroom.ziroomcustomer.dialog.g(this, new a(), this.z, null);
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
    if ("2c9084454b7835b0014b7841269101a9".equals(this.y))
    {
      ((TextView)localObject).setText("服务时长");
      return;
    }
    ((TextView)localObject).setText("服务项目");
  }
  
  private void l()
  {
    if (TextUtils.isEmpty(this.O))
    {
      com.freelxl.baselibrary.f.g.textToast(this.g, "请先选择时间");
      return;
    }
    Intent localIntent = new Intent(this.g, SelectCleanerActivity.class);
    localIntent.putExtra("appointDateTime", this.O);
    localIntent.putExtra("serviceInfoId", this.y);
    localIntent.putExtra("servicePmId", this.A);
    localIntent.putExtra("addressId", this.J);
    localIntent.putExtra("appointDate", this.I);
    localIntent.putExtra("defaultName", this.M);
    localIntent.putExtra("appointTime", this.ae);
    localIntent.putExtra("day_index", this.ai + "");
    localIntent.putExtra("card_index", this.x + "");
    localIntent.putExtra("service_price", this.al);
    startActivity(localIntent);
    finish();
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
    case 2131690367: 
      k();
      return;
    case 2131690362: 
      j();
      return;
    case 2131690363: 
      l();
      return;
    }
    i();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903155);
    this.g = this;
    a = this;
    a();
    b();
    e();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
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
      CleanerTimeActivity.i(CleanerTimeActivity.this).setText((String)CleanerTimeActivity.h(CleanerTimeActivity.this).get(paramInt));
      if ("2c9084454b7835b0014b7841269101a9".equals(CleanerTimeActivity.j(CleanerTimeActivity.this))) {
        CleanerTimeActivity.i(CleanerTimeActivity.this).setTopHint("服务时长");
      }
      for (;;)
      {
        CleanerTimeActivity.d(CleanerTimeActivity.this, ((ai)CleanerTimeActivity.k(CleanerTimeActivity.this).get(paramInt)).getServPmId());
        CleanerTimeActivity.e(CleanerTimeActivity.this, ((ai)CleanerTimeActivity.k(CleanerTimeActivity.this).get(paramInt)).getServPmPrice() + "");
        CleanerTimeActivity.f(CleanerTimeActivity.this, ((ai)CleanerTimeActivity.k(CleanerTimeActivity.this).get(paramInt)).getServPmName());
        CleanerTimeActivity.g(CleanerTimeActivity.this, (String)CleanerTimeActivity.h(CleanerTimeActivity.this).get(paramInt));
        CleanerTimeActivity.l(CleanerTimeActivity.this);
        return;
        CleanerTimeActivity.i(CleanerTimeActivity.this).setTopHint("服务项目");
      }
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      com.ziroom.ziroomcustomer.util.u.e("dsdkdsg", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(a.parseArray(paramString.get("data").toString(), ay.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      int i = 0;
      if (paramk.getSuccess().booleanValue())
      {
        CleanerTimeActivity.a(CleanerTimeActivity.this, (List)paramk.getObject());
        if ((CleanerTimeActivity.a(CleanerTimeActivity.this) != null) && (CleanerTimeActivity.a(CleanerTimeActivity.this).size() > 0))
        {
          CleanerTimeActivity.g(CleanerTimeActivity.this).setVisibility(0);
          CleanerTimeActivity.b(CleanerTimeActivity.this).setData(CleanerTimeActivity.a(CleanerTimeActivity.this));
          if (TextUtils.isEmpty(CleanerTimeActivity.d(CleanerTimeActivity.this))) {
            if (i < CleanerTimeActivity.a(CleanerTimeActivity.this).size())
            {
              if (!"0".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(i)).getFlag())) {
                break label230;
              }
              CleanerTimeActivity.a(CleanerTimeActivity.this, i);
              CleanerTimeActivity.a(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getDatePlan());
              CleanerTimeActivity.b(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getTimePoint());
              CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(i);
            }
          }
          for (;;)
          {
            CleanerTimeActivity.f(CleanerTimeActivity.this);
            return;
            label230:
            i += 1;
            break;
            if ("0".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getFlag()))
            {
              CleanerTimeActivity.a(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getDatePlan());
              CleanerTimeActivity.b(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getTimePoint());
              CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(CleanerTimeActivity.e(CleanerTimeActivity.this));
            }
          }
        }
        CleanerTimeActivity.g(CleanerTimeActivity.this).setVisibility(8);
        return;
      }
      CleanerTimeActivity.g(CleanerTimeActivity.this).setVisibility(8);
      CleanerTimeActivity.c(CleanerTimeActivity.this, paramk.getMessage());
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      com.ziroom.ziroomcustomer.util.u.e("dsdkdsg", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(a.parseArray(paramString.get("data").toString(), ay.class));
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
      int i;
      if (paramk.getSuccess().booleanValue())
      {
        CleanerTimeActivity.a(CleanerTimeActivity.this, (List)paramk.getObject());
        if ((CleanerTimeActivity.a(CleanerTimeActivity.this) != null) && (CleanerTimeActivity.a(CleanerTimeActivity.this).size() > 0))
        {
          CleanerTimeActivity.b(CleanerTimeActivity.this).setData(CleanerTimeActivity.a(CleanerTimeActivity.this));
          i = 0;
          while (i < CleanerTimeActivity.a(CleanerTimeActivity.this).size())
          {
            if ("0".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(i)).getFlag())) {
              CleanerTimeActivity.a(CleanerTimeActivity.this, true);
            }
            i += 1;
          }
          if (TextUtils.isEmpty(CleanerTimeActivity.d(CleanerTimeActivity.this)))
          {
            i = 0;
            int j = k;
            if (i < CleanerTimeActivity.a(CleanerTimeActivity.this).size())
            {
              if ("0".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(i)).getFlag()))
              {
                CleanerTimeActivity.a(CleanerTimeActivity.this, i);
                CleanerTimeActivity.a(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getDatePlan());
                CleanerTimeActivity.b(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getTimePoint());
                CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(i);
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(-1);
              }
              label295:
              CleanerTimeActivity.f(CleanerTimeActivity.this);
            }
          }
        }
      }
      do
      {
        return;
        i += 1;
        break;
        if ("0".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getFlag()))
        {
          CleanerTimeActivity.a(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getDatePlan());
          CleanerTimeActivity.b(CleanerTimeActivity.this, ((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getTimePoint());
          CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(CleanerTimeActivity.e(CleanerTimeActivity.this));
          break label295;
        }
        if (!"1".equals(((ay)CleanerTimeActivity.a(CleanerTimeActivity.this).get(CleanerTimeActivity.e(CleanerTimeActivity.this))).getFlag())) {
          break label295;
        }
        CleanerTimeActivity.b(CleanerTimeActivity.this).setSelectPosition(-1);
        CleanerTimeActivity.a(CleanerTimeActivity.this, false);
        break label295;
        CleanerTimeActivity.a(CleanerTimeActivity.this, false);
        return;
        CleanerTimeActivity.a(CleanerTimeActivity.this, false);
      } while (TextUtils.isEmpty(paramk.getMessage()));
      if ("服务异常".equals(paramk.getMessage()))
      {
        com.freelxl.baselibrary.f.g.textToast(CleanerTimeActivity.c(CleanerTimeActivity.this), paramk.getMessage());
        return;
      }
      CleanerTimeActivity.c(CleanerTimeActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanerTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */