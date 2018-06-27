package com.ziroom.ziroomcustomer.minsu.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.GuideCardBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHouseInfoBean;
import com.ziroom.ziroomcustomer.minsu.d.b;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.h;
import com.ziroom.ziroomcustomer.minsu.f.n;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MinsuHouseListBadActivity
  extends BaseActivity
  implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener
{
  private int A = 1;
  private int B = 10;
  private int C = -1;
  private ImageView D;
  private EditText E;
  private Calendar F = null;
  private Calendar G = null;
  private String H;
  private TextView I;
  private TextView J;
  private TextView K;
  private AppBarLayout L;
  private LinearLayout M;
  private RelativeLayout N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private TextView S;
  private View T;
  private int U;
  private View V;
  private com.ziroom.ziroomcustomer.minsu.dialog.f W;
  private Bundle X;
  private View Y;
  private List<MinsuHouseBean.DataBean.GuideCardBean> Z;
  int a;
  private long aa;
  private long ab;
  private long ac;
  private BroadcastReceiver ad = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MinsuHouseListBadActivity.u(MinsuHouseListBadActivity.this);
    }
  };
  private ObjectAnimator ae;
  private ValueAnimator af;
  private ObjectAnimator ag;
  private ObjectAnimator ah;
  private ValueAnimator ai;
  private ValueAnimator aj;
  private int ak = 0;
  private int al = 0;
  private Bundle am;
  private SharedElementCallback an = new SharedElementCallback()
  {
    public void onMapSharedElements(List<String> paramAnonymousList, Map<String, View> paramAnonymousMap)
    {
      if (MinsuHouseListBadActivity.x(MinsuHouseListBadActivity.this) != null)
      {
        u.i("info", "list  reenter ");
        return;
      }
      u.i("info", "list  exit ");
    }
  };
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int r;
  int s;
  int t = 0;
  private RecyclerView u;
  private SwipeToLoadLayout v;
  private com.ziroom.ziroomcustomer.minsu.adapter.m w;
  private List<MinsuHouseBean.DataBean.ListBean> x = new ArrayList();
  private MinsuSearchHouseInfoBean y;
  private RelativeLayout z;
  
  private void a()
  {
    this.aa = SystemClock.uptimeMillis();
    this.ab = (ac.getScreenWidth(this) / 2);
    this.ac = (ac.getScreenHeight(this) / 2);
    this.q.post(new Runnable()
    {
      public void run()
      {
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 0, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this), 0));
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 2, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this), 0));
      }
    });
    this.q.postDelayed(new Runnable()
    {
      public void run()
      {
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 2, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this) + MinsuHouseListBadActivity.this.d * 1 / 4), 0));
      }
    }, 100);
    this.q.postDelayed(new Runnable()
    {
      public void run()
      {
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 2, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this) + MinsuHouseListBadActivity.this.d * 1 / 4), 0));
      }
    }, 'È');
    this.q.postDelayed(new Runnable()
    {
      public void run()
      {
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 2, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this) + MinsuHouseListBadActivity.this.d * 1 / 4), 0));
      }
    }, 'Ĭ');
    this.q.postDelayed(new Runnable()
    {
      public void run()
      {
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 2, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this) + MinsuHouseListBadActivity.this.d * 1 / 4), 0));
        MinsuHouseListBadActivity.this.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this), SystemClock.uptimeMillis(), 1, (float)MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this), (float)MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this), 0));
      }
    }, 'Ɛ');
  }
  
  private void a(MinsuSearchHouseInfoBean paramMinsuSearchHouseInfoBean)
  {
    bool1 = true;
    int j = 0;
    for (;;)
    {
      try
      {
        Field[] arrayOfField = paramMinsuSearchHouseInfoBean.getClass().getDeclaredFields();
        int k = arrayOfField.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        Field localField = arrayOfField[i];
        localField.setAccessible(true);
        boolean bool2 = com.ziroom.ziroomcustomer.minsu.f.c.isNull(localField.get(paramMinsuSearchHouseInfoBean));
        if (bool2) {
          continue;
        }
      }
      catch (IllegalAccessException paramMinsuSearchHouseInfoBean)
      {
        paramMinsuSearchHouseInfoBean.printStackTrace();
        bool1 = false;
        continue;
        int i = 8;
        continue;
      }
      this.W.setClearShow(bool1);
      paramMinsuSearchHouseInfoBean = this.S;
      if (!bool1) {
        continue;
      }
      i = j;
      paramMinsuSearchHouseInfoBean.setVisibility(i);
      return;
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.ag != null) && (this.ak != 4) && (!this.ag.isRunning()))
      {
        this.ag.start();
        u.i("info", "开始展示 顶部");
      }
    }
    while ((this.ae == null) || (this.ak == 2) || (this.ae.isRunning())) {
      return;
    }
    this.ae.start();
    u.i("info", "开始隐藏 顶部");
  }
  
  private void b()
  {
    this.a = ad.dp2px(this, 42);
    this.b = ad.dp2px(this, 1);
    this.c = ad.dp2px(this, 28);
    this.d = ad.dp2px(this, 56);
    this.e = ad.dp2px(this, 84);
    this.f = (this.a + this.d);
    this.g = (this.a + this.d + this.b + this.c);
    this.r = (this.a + this.d + this.b + this.d);
    this.s = ad.dp2px(this, 212);
  }
  
  private void b(int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toMinsuSearchTabActivity(this, paramInt, this.y, this.X);
  }
  
  private void b(MinsuSearchHouseInfoBean paramMinsuSearchHouseInfoBean)
  {
    int i = paramMinsuSearchHouseInfoBean.getCheckConfCount();
    paramMinsuSearchHouseInfoBean = (TextView)findViewById(2131695335);
    if (i > 0)
    {
      paramMinsuSearchHouseInfoBean.setVisibility(0);
      paramMinsuSearchHouseInfoBean.setText(i + "");
      return;
    }
    paramMinsuSearchHouseInfoBean.setVisibility(8);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.ai != null) && (this.al != 4) && (!this.ai.isRunning()))
      {
        this.ai.start();
        u.i("info", "开始展示 底部");
      }
    }
    while ((this.af == null) || (this.al == 2) || (this.af.isRunning())) {
      return;
    }
    this.af.start();
    u.i("info", "开始隐藏 底部");
  }
  
  private MinsuSearchHouseInfoBean c(MinsuSearchHouseInfoBean paramMinsuSearchHouseInfoBean)
  {
    MinsuSearchHouseInfoBean localMinsuSearchHouseInfoBean = new MinsuSearchHouseInfoBean();
    localMinsuSearchHouseInfoBean.setCityCode(paramMinsuSearchHouseInfoBean.getCityCode());
    localMinsuSearchHouseInfoBean.setCityName(b.getIntance(this).getName(paramMinsuSearchHouseInfoBean.getCityCode()));
    localMinsuSearchHouseInfoBean.setStartTime(paramMinsuSearchHouseInfoBean.getStartTime());
    localMinsuSearchHouseInfoBean.setEndTime(paramMinsuSearchHouseInfoBean.getEndTime());
    c(true);
    return localMinsuSearchHouseInfoBean;
  }
  
  private void c(int paramInt)
  {
    boolean bool = true;
    SwipeToLoadLayout localSwipeToLoadLayout = this.v;
    if (paramInt > 1) {}
    for (;;)
    {
      localSwipeToLoadLayout.setLoadMoreEnabled(bool);
      return;
      bool = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.X != null) && (!paramBoolean))
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("sortAdapter", this.X.getSerializable("sortAdapter"));
      localBundle.putInt("selection", this.X.getInt("selection"));
      localBundle.putInt("lastSelection", this.X.getInt("lastSelection"));
      this.X = localBundle;
      return;
    }
    this.X = null;
  }
  
  private Calendar d(String paramString)
  {
    Calendar localCalendar = null;
    if (ae.isNull(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      return localCalendar;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localCalendar;
      }
    }
  }
  
  private void e()
  {
    this.W = new com.ziroom.ziroomcustomer.minsu.dialog.f(this, this);
  }
  
  private void f()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.ad, localIntentFilter);
  }
  
  private Bitmap g()
  {
    return n.convertViewToBitmap(getWindow().getDecorView());
  }
  
  private void h()
  {
    this.z = ((RelativeLayout)findViewById(2131691272));
    this.T = findViewById(2131694306);
    this.L = ((AppBarLayout)findViewById(2131691403));
    this.M = ((LinearLayout)findViewById(2131691404));
    this.N = ((RelativeLayout)findViewById(2131691409));
    this.R = ((TextView)findViewById(2131691414));
    this.R.setOnClickListener(this);
    this.O = ((TextView)findViewById(2131691407));
    this.P = ((TextView)findViewById(2131691408));
    this.Q = ((TextView)findViewById(2131691410));
    this.S = ((TextView)findViewById(2131691406));
    this.S.setOnClickListener(this);
    this.u = ((RecyclerView)findViewById(2131689522));
    this.u.setLayoutManager(new LinearLayoutManager(this));
    this.u.addOnScrollListener(new a(null));
    this.u.addItemDecoration(new com.ziroom.ziroomcustomer.minsu.view.b.d(this, 1));
    this.v = ((SwipeToLoadLayout)findViewById(2131691285));
    this.v.setLoadMoreEnabled(true);
    this.v.setRefreshEnabled(false);
    this.v.setOnLoadMoreListener(new com.aspsine.swipetoloadlayout.a()
    {
      public void onLoadMore()
      {
        MinsuHouseListBadActivity.f(MinsuHouseListBadActivity.this);
        MinsuHouseListBadActivity.g(MinsuHouseListBadActivity.this);
      }
    });
    this.w = new com.ziroom.ziroomcustomer.minsu.adapter.m(this, this.x);
    this.w.setOnItemClickListener(new e.a()
    {
      public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        paramAnonymousu = (MinsuHouseBean.DataBean.ListBean)MinsuHouseListBadActivity.h(MinsuHouseListBadActivity.this).get(paramAnonymousInt);
        if ((MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getDatas() == null) || (MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getDatas().size() <= paramAnonymousInt - 1)) {}
        do
        {
          do
          {
            return;
          } while (paramAnonymousu.type == 1);
          if (paramAnonymousu.type != 2) {
            break;
          }
          paramAnonymousView = paramAnonymousView.getTag();
        } while ((paramAnonymousView == null) || (!(paramAnonymousView instanceof MinsuHouseBean.DataBean.GuideCardBean)));
        switch (((MinsuHouseBean.DataBean.GuideCardBean)paramAnonymousView).code)
        {
        default: 
          return;
        case 1: 
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuCityListActivityForResult(MinsuHouseListBadActivity.this);
          return;
        case 2: 
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectActivityForResult(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.j(MinsuHouseListBadActivity.this), MinsuHouseListBadActivity.k(MinsuHouseListBadActivity.this));
          return;
        case 3: 
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuPersonActivityForResult(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.d(MinsuHouseListBadActivity.this).getPersonCount());
          return;
        case 4: 
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuHouseTypeActivityForResult(MinsuHouseListBadActivity.this);
          return;
        }
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuPriceActivityForResult(MinsuHouseListBadActivity.this);
        return;
        if (paramAnonymousu.isTop50Online == 1) {}
        for (paramAnonymousView = new Intent(MinsuHouseListBadActivity.this, MinsuTopHouseDetailActivity.class);; paramAnonymousView = new Intent(MinsuHouseListBadActivity.this, MinsuHouseDetailActivity.class))
        {
          paramAnonymousView.putExtra("fid", paramAnonymousu.fid);
          paramAnonymousView.putExtra("rentWay", paramAnonymousu.rentWay);
          paramAnonymousView.putExtra("startTime", MinsuHouseListBadActivity.d(MinsuHouseListBadActivity.this).getStartTime());
          paramAnonymousView.putExtra("endTime", MinsuHouseListBadActivity.d(MinsuHouseListBadActivity.this).getEndTime());
          paramAnonymousView.putExtra("tag", MinsuHouseListBadActivity.l(MinsuHouseListBadActivity.this));
          paramAnonymousView.putExtra("image", paramAnonymousu.picUrl);
          MinsuHouseListBadActivity.this.startActivityForResult(paramAnonymousView, 119);
          return;
        }
      }
      
      public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
      {
        return false;
      }
    });
    this.u.setAdapter(this.w);
    findViewById(2131694308).setOnClickListener(this);
    findViewById(2131690325).setOnClickListener(this);
    findViewById(2131694310).setOnClickListener(this);
    this.I = ((TextView)findViewById(2131694309));
    this.J = ((TextView)findViewById(2131690326));
    this.K = ((TextView)findViewById(2131690900));
    this.O.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.V = findViewById(2131691398);
    this.U = ad.dp2px(this, 40);
    this.Y = findViewById(2131691412);
  }
  
  private void i()
  {
    if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.y)) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.y.getCityCode())))
    {
      this.O.setText(b.getIntance(this).getName(this.y.getCityCode()));
      p();
    }
  }
  
  private void j()
  {
    this.A = 1;
    if ((this.y != null) && (ae.notNull(this.y.getCityCode())))
    {
      this.H = this.y.getCityCode();
      com.ziroom.ziroomcustomer.minsu.d.f.getInstance(this).checkCityCode(this.y.getCityCode());
    }
    if (this.y == null) {
      return;
    }
    b(this.y);
    r();
    com.ziroom.ziroomcustomer.minsu.e.a.query(this, this.y.getRentWay(), this.y.getRoomCount(), this.y.getOrderType(), this.y.getQ(), this.y.getStartTime(), this.y.getEndTime(), this.y.getCityCode(), this.B, this.A, this.y.getPriceStart(), this.y.getPriceEnd(), this.y.getPersonCount() + "", this.y.getHotReginScenic(), this.y.getHotReginBusiness(), this.y.getSortType(), this.y.getSubway(), this.y.getAreaCode(), this.y.getSubwayCode(), this.y.getLineFid(), this.y.getHouseType(), this.y.getLongTermDiscount(), this.y.getJiaxinDiscount(), true, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseListBadActivity.m(MinsuHouseListBadActivity.this);
        MinsuHouseBean localMinsuHouseBean = (MinsuHouseBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseBean != null) && (localMinsuHouseBean.checkSuccess(MinsuHouseListBadActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuHouseBean.toString());
          if (localMinsuHouseBean.data.total < 1)
          {
            if ((localMinsuHouseBean.data.suggest != null) && (localMinsuHouseBean.data.suggest.size() > 0))
            {
              MinsuHouseListBadActivity.n(MinsuHouseListBadActivity.this);
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getDatas().clear();
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).addDatas(localMinsuHouseBean.data.suggest);
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).notifyDataSetChanged();
              MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, localMinsuHouseBean.data.guideCard);
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).setGuideCardList(MinsuHouseListBadActivity.p(MinsuHouseListBadActivity.this));
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).setCityCardBean(localMinsuHouseBean.data.cityCard);
              MinsuHouseListBadActivity.q(MinsuHouseListBadActivity.this).setAdapter(MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this));
              MinsuHouseListBadActivity.q(MinsuHouseListBadActivity.this).scrollToPosition(0);
              if ((MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).getLayoutParams().height > 0) && (MinsuHouseListBadActivity.s(MinsuHouseListBadActivity.this).getVisibility() == 0) && (MinsuHouseListBadActivity.this.t >= MinsuHouseListBadActivity.this.s * 90 / 100)) {
                MinsuHouseListBadActivity.t(MinsuHouseListBadActivity.this);
              }
              return;
            }
            paramAnonymousk = MinsuHouseListBadActivity.this;
            if ((localMinsuHouseBean == null) || (localMinsuHouseBean.data == null) || (localMinsuHouseBean.data.list == null)) {}
            for (i = 0;; i = localMinsuHouseBean.data.list.size())
            {
              MinsuHouseListBadActivity.a(paramAnonymousk, i);
              MinsuHouseListBadActivity.this.showToast("没有更多数据");
              MinsuHouseListBadActivity.o(MinsuHouseListBadActivity.this);
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).setDatas(new ArrayList());
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).notifyDataSetChanged();
              break;
            }
          }
          MinsuHouseListBadActivity.o(MinsuHouseListBadActivity.this);
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getDatas().clear();
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).addDatas(localMinsuHouseBean.data.list);
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).notifyDataSetChanged();
          paramAnonymousk = MinsuHouseListBadActivity.this;
          if ((localMinsuHouseBean == null) || (localMinsuHouseBean.data == null) || (localMinsuHouseBean.data.list == null)) {}
          for (int i = 0;; i = localMinsuHouseBean.data.list.size())
          {
            MinsuHouseListBadActivity.a(paramAnonymousk, i);
            break;
          }
        }
        if (localMinsuHouseBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void k()
  {
    this.Y.setVisibility(8);
    this.w.setType(1);
  }
  
  private void l()
  {
    this.Y.setVisibility(0);
    this.w.setType(2);
  }
  
  private void m()
  {
    if (this.y == null) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.query(this, this.y.getRentWay(), this.y.getRoomCount(), this.y.getOrderType(), this.y.getQ(), this.y.getStartTime(), this.y.getEndTime(), this.y.getCityCode(), this.B, this.A, this.y.getPriceStart(), this.y.getPriceEnd(), this.y.getPersonCount() + "", this.y.getHotReginScenic(), this.y.getHotReginBusiness(), this.y.getSortType(), this.y.getSubway(), this.y.getAreaCode(), this.y.getSubwayCode(), this.y.getLineFid(), this.y.getHouseType(), this.y.getLongTermDiscount(), this.y.getJiaxinDiscount(), false, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseListBadActivity.m(MinsuHouseListBadActivity.this);
        MinsuHouseBean localMinsuHouseBean = (MinsuHouseBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseBean != null) && (localMinsuHouseBean.checkSuccess(MinsuHouseListBadActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuHouseBean.toString());
          paramAnonymousk = MinsuHouseListBadActivity.this;
          if ((localMinsuHouseBean == null) || (localMinsuHouseBean.data == null) || (localMinsuHouseBean.data.list == null)) {}
          for (int i = 0;; i = localMinsuHouseBean.data.list.size())
          {
            MinsuHouseListBadActivity.a(paramAnonymousk, i);
            if (localMinsuHouseBean.data.total >= 1) {
              break;
            }
            return;
          }
          if (localMinsuHouseBean.data.list.size() < 1) {
            MinsuHouseListBadActivity.this.showToast("没有更多数据");
          }
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).addDatas(localMinsuHouseBean.data.list);
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).notifyDataSetChanged();
          return;
        }
        if (localMinsuHouseBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void n()
  {
    this.v.setRefreshing(false);
    this.v.setLoadingMore(false);
  }
  
  private void o()
  {
    int i = this.w.getItemCount();
    if ((this.y != null) && (ae.notNull(this.y.getCityCode())))
    {
      this.H = this.y.getCityCode();
      com.ziroom.ziroomcustomer.minsu.d.f.getInstance(this).checkCityCode(this.y.getCityCode());
    }
    this.A = 1;
    if (this.y == null) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.query(this, this.y.getRentWay(), this.y.getRoomCount(), this.y.getOrderType(), this.y.getQ(), this.y.getStartTime(), this.y.getEndTime(), this.y.getCityCode(), i, this.A, this.y.getPriceStart(), this.y.getPriceEnd(), this.y.getPersonCount() + "", this.y.getHotReginScenic(), this.y.getHotReginBusiness(), this.y.getSortType(), this.y.getSubway(), this.y.getAreaCode(), this.y.getSubwayCode(), this.y.getLineFid(), this.y.getHouseType(), this.y.getLongTermDiscount(), this.y.getJiaxinDiscount(), true, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseListBadActivity.m(MinsuHouseListBadActivity.this);
        MinsuHouseBean localMinsuHouseBean = (MinsuHouseBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseBean != null) && (localMinsuHouseBean.checkSuccess(MinsuHouseListBadActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuHouseBean.toString());
          if (localMinsuHouseBean.data.total < 1)
          {
            MinsuHouseListBadActivity.this.showToast("没有更多数据");
            if ((localMinsuHouseBean.data.suggest != null) && (localMinsuHouseBean.data.suggest.size() > 0))
            {
              MinsuHouseListBadActivity.n(MinsuHouseListBadActivity.this);
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getDatas().clear();
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).addDatas(localMinsuHouseBean.data.suggest);
              MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).notifyDataSetChanged();
              return;
            }
            MinsuHouseListBadActivity.o(MinsuHouseListBadActivity.this);
            return;
          }
          MinsuHouseListBadActivity.o(MinsuHouseListBadActivity.this);
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getDatas().clear();
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).addDatas(localMinsuHouseBean.data.list);
          MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).notifyDataSetChanged();
          paramAnonymousk = MinsuHouseListBadActivity.this;
          if ((localMinsuHouseBean == null) || (localMinsuHouseBean.data == null) || (localMinsuHouseBean.data.list == null)) {}
          for (int i = 0;; i = localMinsuHouseBean.data.list.size())
          {
            MinsuHouseListBadActivity.a(paramAnonymousk, i);
            return;
          }
        }
        if (localMinsuHouseBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void p()
  {
    String str1 = getString(2131297416);
    String str2 = b.getIntance(this).getName(this.y.getCityCode());
    this.W.setCity(str2);
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(str2))
    {
      str1 = str1.replace("city", "城市");
      str2 = this.P.getText().toString();
      this.W.setDate(str2);
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(str2)) {
        break label156;
      }
      str1 = str1.replace("date", "日期");
      label88:
      str2 = this.Q.getText().toString();
      this.W.setCount(str2);
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(str2)) {
        break label168;
      }
    }
    label156:
    label168:
    for (str1 = str1.replace("count", "人数");; str1 = str1.replace("count", str2))
    {
      this.R.setText(str1);
      a(this.y);
      return;
      str1 = str1.replace("city", str2);
      break;
      str1 = str1.replace("date", str2);
      break label88;
    }
  }
  
  private void q()
  {
    if (this.W.isShowing()) {
      this.W.dismiss();
    }
  }
  
  private void r()
  {
    if ((this.ah != null) && (this.ak != 4) && (!this.ag.isRunning()))
    {
      this.ah.start();
      u.i("info", "fast 开始展示 顶部");
    }
    if ((this.aj != null) && (this.al != 4) && (!this.ai.isRunning()))
    {
      this.aj.start();
      u.i("info", "fast 开始展示 底部");
    }
  }
  
  private void s()
  {
    int i = ad.dp2px(this, 56);
    if (this.ae == null)
    {
      this.ae = ObjectAnimator.ofFloat(this.R, View.Y, new float[] { 0.0F, -i });
      this.ae.setDuration(300L);
      this.ae.setInterpolator(new LinearInterpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          if (MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getType() == 2)
          {
            u.i("wzc_info", " input = " + paramAnonymousFloat + " h = " + (int)(ab.dp2px(ApplicationEx.c, 56.0F) * (1.0F - paramAnonymousFloat)));
            MinsuHouseListBadActivity.v(MinsuHouseListBadActivity.this).getLayoutParams().height = ((int)(ab.dp2px(ApplicationEx.c, 56.0F) * (1.0F - paramAnonymousFloat)));
          }
          return super.getInterpolation(paramAnonymousFloat);
        }
      });
      this.ae.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, 2);
          MinsuHouseListBadActivity.s(MinsuHouseListBadActivity.this).setVisibility(8);
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, 1);
        }
      });
    }
    if (this.af == null)
    {
      this.af = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.af.setDuration(300L);
      this.af.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          u.i("onAnimationUpdate", "  == 1  " + paramAnonymousValueAnimator.getAnimatedValue());
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).getLayoutParams().height = ((int)((1.0F - f) * MinsuHouseListBadActivity.w(MinsuHouseListBadActivity.this)));
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).invalidate();
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).requestLayout();
        }
      });
      this.af.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this, 2);
          u.i("info", " 已经完成 隐藏 底部 ");
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this, 1);
          u.i("info", " 已经开始 隐藏 底部 ");
        }
      });
    }
    if (this.ag == null)
    {
      this.ag = ObjectAnimator.ofFloat(this.R, View.Y, new float[] { -i, 0.0F });
      this.ag.setDuration(300L);
      this.ag.setInterpolator(new LinearInterpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          if (MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getType() == 2)
          {
            u.i("wzc_info", " input = " + paramAnonymousFloat + " h = " + (int)(ab.dp2px(ApplicationEx.c, 56.0F) * paramAnonymousFloat));
            MinsuHouseListBadActivity.v(MinsuHouseListBadActivity.this).getLayoutParams().height = ((int)(ab.dp2px(ApplicationEx.c, 56.0F) * paramAnonymousFloat));
          }
          return super.getInterpolation(paramAnonymousFloat);
        }
      });
      this.ag.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, 4);
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, 3);
          MinsuHouseListBadActivity.s(MinsuHouseListBadActivity.this).setVisibility(0);
        }
      });
    }
    if (this.ah == null)
    {
      this.ah = ObjectAnimator.ofFloat(this.R, View.Y, new float[] { -i, 0.0F });
      this.ah.setDuration(2L);
      this.ah.setInterpolator(new LinearInterpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          if (MinsuHouseListBadActivity.i(MinsuHouseListBadActivity.this).getType() == 2)
          {
            u.i("wzc_info", " input = " + paramAnonymousFloat + " h = " + (int)(ab.dp2px(ApplicationEx.c, 56.0F) * paramAnonymousFloat));
            MinsuHouseListBadActivity.v(MinsuHouseListBadActivity.this).getLayoutParams().height = ((int)(ab.dp2px(ApplicationEx.c, 56.0F) * paramAnonymousFloat));
          }
          return super.getInterpolation(paramAnonymousFloat);
        }
      });
      this.ah.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, 4);
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, 3);
          MinsuHouseListBadActivity.s(MinsuHouseListBadActivity.this).setVisibility(0);
        }
      });
    }
    if (this.ai == null)
    {
      this.ai = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.ai.setDuration(300L);
      this.ai.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          u.i("onAnimationUpdate", "  == 1  - " + paramAnonymousValueAnimator.getAnimatedValue());
          u.i("onAnimationUpdate", "  == 2  - " + paramAnonymousValueAnimator.getCurrentPlayTime());
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).getLayoutParams().height = ((int)(f * MinsuHouseListBadActivity.w(MinsuHouseListBadActivity.this)));
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).invalidate();
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).requestLayout();
        }
      });
      this.ai.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this, 4);
          u.i("info", " 完成 1 显示 底部 ");
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this, 3);
          u.i("info", " 开始 1 显示 底部 ");
        }
      });
    }
    if (this.aj == null)
    {
      this.aj = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aj.setDuration(2L);
      this.aj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          u.i("onAnimationUpdate", "  == 1  - " + paramAnonymousValueAnimator.getAnimatedValue());
          u.i("onAnimationUpdate", "  == 2  - " + paramAnonymousValueAnimator.getCurrentPlayTime());
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).getLayoutParams().height = ((int)(f * MinsuHouseListBadActivity.w(MinsuHouseListBadActivity.this)));
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).invalidate();
          MinsuHouseListBadActivity.r(MinsuHouseListBadActivity.this).requestLayout();
        }
      });
      this.aj.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this, 4);
          u.i("info", " 完成 1 显示 底部 ");
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          MinsuHouseListBadActivity.c(MinsuHouseListBadActivity.this, 3);
          u.i("info", " 开始 1 显示 底部 ");
        }
      });
    }
  }
  
  public void initTitle()
  {
    this.E = ((EditText)findViewById(2131691401));
    this.D = ((ImageView)findViewById(2131691399));
    this.D.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.minsu.b.c.a = null;
        MinsuHouseListBadActivity.this.finish();
      }
    });
    this.E.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        v.onClick(MinsuHouseListBadActivity.this, "M-Search_keyword");
        paramAnonymousView = new Intent(MinsuHouseListBadActivity.this, MinsuHouseListSearchActivity.class);
        paramAnonymousView.putExtra("key", MinsuHouseListBadActivity.d(MinsuHouseListBadActivity.this).getQ());
        com.ziroom.ziroomcustomer.minsu.d.a.getInstance().doBlurInBack(MinsuHouseListBadActivity.this, MinsuHouseListBadActivity.e(MinsuHouseListBadActivity.this));
        paramAnonymousView.putExtra("cityCode", MinsuHouseListBadActivity.d(MinsuHouseListBadActivity.this).getCityCode());
        MinsuHouseListBadActivity.this.startActivityForResult(paramAnonymousView, 120);
      }
    });
  }
  
  public void onActivityReenter(int paramInt, Intent paramIntent)
  {
    super.onActivityReenter(paramInt, paramIntent);
    u.i("info", "list  onActivityReenter ");
    if (Build.VERSION.SDK_INT >= 21)
    {
      postponeEnterTransition();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          Log.e("test", "run ... ........");
          if (Build.VERSION.SDK_INT >= 21) {
            MinsuHouseListBadActivity.this.startPostponedEnterTransition();
          }
        }
      }, 20L);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    String str = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    label355:
    boolean bool1;
    switch (paramInt1)
    {
    case 112: 
    case 114: 
    case 115: 
    case 116: 
    case 117: 
    case 118: 
    case 121: 
    case 122: 
    default: 
    case 123: 
    case 119: 
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt2 != -1);
          this.X = paramIntent.getExtras();
          localObject1 = (MinsuSearchHouseInfoBean)paramIntent.getSerializableExtra("search");
        } while (localObject1 == null);
        paramInt1 = paramIntent.getIntExtra("index", -1);
        localObject2 = paramIntent.getStringExtra("text");
        switch (paramInt1)
        {
        }
        for (;;)
        {
          this.y = ((MinsuSearchHouseInfoBean)localObject1);
          a((MinsuSearchHouseInfoBean)localObject1);
          j();
          return;
          this.I.setText((CharSequence)localObject2);
          continue;
          this.J.setText((CharSequence)localObject2);
          paramInt1 = paramIntent.getIntExtra("confCount", 0);
          paramIntent = (TextView)findViewById(2131695335);
          if (paramInt1 > 0)
          {
            paramIntent.setVisibility(0);
            paramIntent.setText(paramInt1 + "");
          }
          else
          {
            paramIntent.setVisibility(8);
            continue;
            this.K.setText((CharSequence)localObject2);
          }
        }
      } while (paramInt2 != 101);
      localObject2 = paramIntent.getStringExtra("fid");
      u.i("wzc_info", "OA  --  HOUSE_DETAIL  fid = " + (String)localObject2);
      paramInt2 = paramIntent.getIntExtra("rentWay", -1);
      int j = this.x.size();
      paramInt1 = 0;
      if (paramInt1 < j)
      {
        localObject1 = (MinsuHouseBean.DataBean.ListBean)this.x.get(paramInt1);
        if ((localObject1 != null) && (((MinsuHouseBean.DataBean.ListBean)localObject1).rentWay == paramInt2) && (((MinsuHouseBean.DataBean.ListBean)localObject1).fid != null) && (((MinsuHouseBean.DataBean.ListBean)localObject1).fid.equals(localObject2))) {
          if (((MinsuHouseBean.DataBean.ListBean)localObject1).isCollect == 1)
          {
            bool1 = true;
            label423:
            boolean bool2 = paramIntent.getBooleanExtra("isCollect", bool1);
            if (!bool2) {
              break label564;
            }
            paramInt2 = i;
            label442:
            ((MinsuHouseBean.DataBean.ListBean)localObject1).isCollect = paramInt2;
            u.i("wzc_info", "OA  -- isCollectBefore  = " + bool1 + "  isCollectLater  = " + bool2);
            paramIntent = (Intent)localObject1;
          }
        }
      }
      break;
    }
    while ((paramInt1 != -1) && (paramIntent != null))
    {
      localObject1 = (LinearLayoutManager)this.u.getLayoutManager();
      paramInt1 = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      paramInt2 = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      while (paramInt1 <= paramInt2)
      {
        if (paramIntent.equals((MinsuHouseBean.DataBean.ListBean)((LinearLayoutManager)localObject1).findViewByPosition(paramInt1).getTag(2131689523)))
        {
          this.w.notifyItemChanged(paramInt1);
          return;
          bool1 = false;
          break label423;
          label564:
          paramInt2 = 0;
          break label442;
          paramInt1 += 1;
          break label355;
        }
        paramInt1 += 1;
      }
      if (-1 != paramInt2) {
        break;
      }
      localObject1 = paramIntent.getStringExtra("type");
      if ("keyWord".equals(localObject1))
      {
        paramIntent = paramIntent.getStringExtra("key");
        this.y = c(this.y);
        resetText();
        this.Q.setText("");
        this.E.setText(paramIntent + "");
        this.y.setQ(paramIntent);
      }
      for (;;)
      {
        p();
        j();
        return;
        if ("houseType".equals(localObject1))
        {
          paramIntent = paramIntent.getStringExtra("houseType");
          this.y = c(this.y);
          resetText();
          this.Q.setText("");
          this.y.setHouseType(paramIntent);
        }
        else if ("hot".equals(localObject1))
        {
          localObject1 = paramIntent.getStringExtra("hotType");
          paramIntent = paramIntent.getStringExtra("value");
          this.y = c(this.y);
          resetText();
          this.Q.setText("");
          if ("1".equals(localObject1)) {
            this.y.setHotReginBusiness(paramIntent);
          } else if ("2".equals(localObject1)) {
            this.y.setHotReginScenic(paramIntent);
          }
        }
      }
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = (MinsuSearchHouseInfoBean)paramIntent.getSerializableExtra("search");
      this.y.setCityCode(paramIntent.getCityCode());
      this.y.setCityName(paramIntent.getCityName());
      com.ziroom.ziroomcustomer.minsu.b.c.a = this.y.getCityCode();
      this.O.setText(this.y.getCityName());
      this.y.setHotReginBusiness(null);
      this.y.setHotReginScenic(null);
      this.y.setQ(null);
      this.y.setSubwayCode(null);
      this.y.setSubway(null);
      this.y.setHouseType(null);
      this.y.setAreaCode(null);
      this.I.setText("位置");
      this.E.setText("");
      c(false);
      p();
      j();
      return;
      if (paramInt2 != -1) {
        break;
      }
      str = paramIntent.getStringExtra("startDate");
      localObject2 = paramIntent.getStringExtra("endDate");
      if (ae.isNull(str))
      {
        paramIntent = null;
        this.F = paramIntent;
        if (!ae.isNull((String)localObject2)) {
          break label1199;
        }
        paramIntent = (Intent)localObject1;
        label1041:
        this.G = paramIntent;
        paramInt1 = this.F.getTime().getMonth();
        paramInt2 = this.G.getTime().getMonth();
        localObject1 = com.ziroom.ziroomcustomer.util.m.getFormatDate(this.F.getTime(), "M月d日");
        localObject2 = this.G.getTime();
        if (paramInt1 != paramInt2) {
          break label1209;
        }
      }
      label1199:
      label1209:
      for (paramIntent = "d日";; paramIntent = "M月d日")
      {
        paramIntent = com.ziroom.ziroomcustomer.util.m.getFormatDate((Date)localObject2, paramIntent);
        this.P.setText((String)localObject1 + "-" + paramIntent);
        this.y.setStartTime(com.ziroom.ziroomcustomer.util.m.getFormatDate(this.F.getTime(), com.ziroom.ziroomcustomer.util.m.b));
        this.y.setEndTime(com.ziroom.ziroomcustomer.util.m.getFormatDate(this.G.getTime(), com.ziroom.ziroomcustomer.util.m.b));
        p();
        j();
        return;
        paramIntent = d(str);
        break;
        paramIntent = d((String)localObject2);
        break label1041;
      }
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = paramIntent.getIntExtra("personNum", 0);
      this.Q.setText(paramInt1 + "人");
      localObject1 = this.y;
      if (paramInt1 <= 0) {}
      for (paramIntent = str;; paramIntent = Integer.valueOf(paramInt1))
      {
        ((MinsuSearchHouseInfoBean)localObject1).setPersonCount(paramIntent);
        p();
        j();
        return;
      }
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = paramIntent.getIntExtra("priceStart", -1);
      paramInt2 = paramIntent.getIntExtra("priceEnd", -1);
      localObject1 = this.y;
      if (paramInt1 == -1)
      {
        paramIntent = null;
        ((MinsuSearchHouseInfoBean)localObject1).setPriceStart(paramIntent);
        localObject1 = this.y;
        if (paramInt2 != -1) {
          break label1376;
        }
      }
      label1376:
      for (paramIntent = (Intent)localObject2;; paramIntent = Integer.valueOf(paramInt2))
      {
        ((MinsuSearchHouseInfoBean)localObject1).setPriceEnd(paramIntent);
        a(this.y);
        j();
        return;
        paramIntent = Integer.valueOf(paramInt1);
        break;
      }
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = paramIntent.getIntExtra("houseType", -1);
      localObject1 = this.y;
      if (paramInt1 == -1) {}
      for (paramIntent = (Intent)localObject3;; paramIntent = Integer.valueOf(paramInt1))
      {
        ((MinsuSearchHouseInfoBean)localObject1).setRentWay(paramIntent);
        a(this.y);
        j();
        return;
      }
      paramIntent = null;
      paramInt1 = -1;
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      int i = -1;
      for (;;)
      {
        if (i != -1) {
          b(i);
        }
        return;
        if (ae.isNull(com.ziroom.ziroomcustomer.minsu.b.c.a))
        {
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuCityListActivityForResult(this);
          return;
        }
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuCityListActivityForResult(this);
        q();
        i = -1;
        continue;
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectActivityForResult(this, this.F, this.G);
        q();
        i = -1;
        continue;
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuPersonActivityForResult(this, this.y.getPersonCount());
        q();
        i = -1;
      }
      paramView = this.W;
      RelativeLayout localRelativeLayout = this.z;
      if (!(paramView instanceof PopupWindow)) {
        paramView.showAsDropDown(localRelativeLayout);
      }
      for (;;)
      {
        i = -1;
        break;
        VdsAgent.showAsDropDown((PopupWindow)paramView, localRelativeLayout);
      }
      this.y = new MinsuSearchHouseInfoBean();
      this.O.setText("");
      this.F = null;
      this.G = null;
      this.P.setText("");
      this.Q.setText("");
      this.E.setText("");
      com.ziroom.ziroomcustomer.minsu.b.c.a = null;
      com.ziroom.ziroomcustomer.minsu.d.f.getInstance(this).checkCityCode(null);
      resetText();
      p();
      j();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903283);
    this.y = ((MinsuSearchHouseInfoBean)getIntent().getSerializableExtra("search"));
    if (this.y == null) {
      this.y = new MinsuSearchHouseInfoBean();
    }
    this.C = getIntent().getIntExtra("tag", -1);
    paramBundle = getIntent().getStringExtra("todayDiscountCode");
    if (!TextUtils.isEmpty(paramBundle)) {
      this.y.setJiaxinDiscount(paramBundle);
    }
    h();
    initTitle();
    j();
    f();
    s();
    e();
    i();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    h.setTempBitmap(null);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.ad);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      com.ziroom.ziroomcustomer.minsu.b.c.a = null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    u.i("info", " == onLowMemory == ");
  }
  
  public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    paramInt = Math.abs(paramInt);
    this.t = paramInt;
    if (paramInt <= this.f)
    {
      u.i("info", " verticalOffset = " + paramInt + " 1111 ");
      this.R.setVisibility(8);
    }
    do
    {
      return;
      if ((paramInt > this.f) && (paramInt < this.g))
      {
        u.i("info", " verticalOffset = " + paramInt + " 2222 " + (1.0F - (paramInt - this.d * 2.0F) / this.c));
        this.R.setVisibility(8);
        return;
      }
      if ((paramInt >= this.g) && (paramInt < this.r))
      {
        float f1 = (paramInt - this.g) * 1.0F / this.c;
        this.R.setVisibility(8);
        u.i("info", " verticalOffset = " + paramInt + " 3333  alpha = " + f1 * 1.0F);
        return;
      }
    } while (paramInt <= this.r);
    this.R.setVisibility(0);
    u.i("info", " verticalOffset = " + paramInt + " 4444 tv.visi = " + this.R.getVisibility());
    u.i("info", " lv4 =  = " + this.s);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.L.addOnOffsetChangedListener(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.L.removeOnOffsetChangedListener(this);
  }
  
  public void resetText()
  {
    this.I.setText("位置");
    this.J.setText("筛选");
    this.K.setText("排序");
    c(true);
  }
  
  private class a
    extends RecyclerView.l
  {
    private int b;
    
    private a() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      u.i("info", "dx = " + paramInt1 + "  dy " + paramInt2 + "  min fling = " + ViewConfiguration.getMinimumFlingVelocity() * 3);
      if (paramInt2 != 0) {
        this.b = paramInt2;
      }
      if (paramInt2 > ViewConfiguration.getMinimumFlingVelocity() * 3)
      {
        MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, false);
        MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, false);
      }
      while ((paramInt2 > 0) || (paramInt2 == 0) || (paramInt2 >= 0) || (paramInt2 >= -ViewConfiguration.getMinimumFlingVelocity() * 3)) {
        return;
      }
      MinsuHouseListBadActivity.a(MinsuHouseListBadActivity.this, true);
      MinsuHouseListBadActivity.b(MinsuHouseListBadActivity.this, true);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseListBadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */