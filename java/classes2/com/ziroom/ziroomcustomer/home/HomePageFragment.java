package com.ziroom.ziroomcustomer.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.MessageCenterActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.dialog.SelectCityPop;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.util.MessageUtil;
import com.ziroom.ziroomcustomer.util.MessageUtil.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.c.e;
import com.ziroom.ziroomcustomer.util.c.e.a;
import com.ziroom.ziroomcustomer.util.c.e.b;
import com.ziroom.ziroomcustomer.util.c.g;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;

public class HomePageFragment
  extends BaseFluxFragment
{
  protected Context b;
  protected ImageView c;
  protected FrameLayout d;
  protected TextView e;
  protected ImageView f;
  protected TextView g;
  protected FrameLayout h;
  protected TextView i;
  protected ImageView j;
  protected ImageView k;
  protected SimpleDraweeView l;
  protected RelativeLayout m;
  protected ObservableScrollView n;
  protected boolean o = true;
  protected int p;
  protected int q = 200;
  protected int r = 400;
  public BroadcastReceiver s = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 7)
      {
        HomePageFragment.this.i.setText("");
        HomePageFragment.this.i.setVisibility(8);
        HomePageFragment.this.k.setVisibility(8);
      }
    }
  };
  private int t;
  private View u;
  private FrameLayout v;
  private a w;
  private SelectCityPop x = null;
  private MessageUpdateReceiver y;
  
  public HomePageFragment(int paramInt)
  {
    this.t = paramInt;
  }
  
  private void f()
  {
    this.y = new MessageUpdateReceiver();
    IntentFilter localIntentFilter = new IntentFilter(getString(2131296572));
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.y, localIntentFilter);
    localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.s, localIntentFilter);
  }
  
  private void g()
  {
    if ((this.c == null) && (this.m == null) && (this.e == null) && (this.j == null) && (this.f == null)) {
      return;
    }
    if (g.checkSkin())
    {
      h();
      return;
    }
    i();
  }
  
  private void h()
  {
    e locale = g.getMainTitle();
    if (locale != null) {
      if (locale.getColors() != null) {
        if (!ae.notNull(locale.getColors().getColor_text_selectCity())) {}
      }
    }
    for (;;)
    {
      try
      {
        i1 = Color.parseColor(locale.getColors().getColor_text_selectCity());
        i2 = i1;
        if (ae.notNull(locale.getColors().getColor_background())) {}
        try
        {
          this.m.setBackgroundColor(Color.parseColor(locale.getColors().getColor_background()));
          i2 = i1;
        }
        catch (Exception localException2)
        {
          localException2.getLocalizedMessage();
          i2 = i1;
          continue;
        }
        g.setImage(this.c, locale.getImages().getImage_logo());
        g.setImage(this.j, locale.getImages().getImage_message());
        g.setImage(this.f, locale.getImages().getImage_selectCity_indicate());
        this.e.setTextColor(i2);
        return;
      }
      catch (Exception localException1)
      {
        localException1.getLocalizedMessage();
        i1 = Color.parseColor("#444444");
        continue;
      }
      int i1 = Color.parseColor("#444444");
      continue;
      int i2 = Color.parseColor("#444444");
      continue;
      i2 = Color.parseColor("#444444");
    }
  }
  
  private void i()
  {
    this.c.setImageResource(2130838619);
    this.m.setBackground(null);
    this.e.setTextColor(Color.parseColor("#444444"));
    this.j.setImageResource(2130840275);
    this.f.setImageResource(2130838621);
  }
  
  private void j()
  {
    if (this.x == null) {
      this.x = new SelectCityPop(this.b);
    }
    this.x.show(this.e);
  }
  
  protected void a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      this.c.setVisibility(0);
      this.c.setAlpha(1.0F);
      if (this.o)
      {
        this.d.setAlpha(1.0F);
        this.d.setVisibility(0);
      }
      this.g.setVisibility(8);
    }
    do
    {
      return;
      if (paramFloat <= 0.33333334F)
      {
        this.c.setVisibility(0);
        this.c.setAlpha(1.0F - paramFloat * 3.0F);
        if (this.o)
        {
          this.d.setAlpha(1.0F - paramFloat * 3.0F);
          this.d.setVisibility(0);
        }
        this.g.setVisibility(8);
        return;
      }
      if (paramFloat <= 1.0F)
      {
        this.c.setVisibility(8);
        if (this.o) {
          this.d.setVisibility(8);
        }
        this.g.setVisibility(0);
        this.g.setAlpha((paramFloat * 3.0F - 1.0F) / 2.0F);
        this.g.setTranslationX(40.0F * (3.0F - paramFloat * 3.0F));
        return;
      }
    } while (paramFloat < 1.0F);
    this.c.setVisibility(8);
    if (this.o) {
      this.d.setVisibility(8);
    }
    this.g.setVisibility(0);
    this.g.setAlpha(1.0F);
    this.g.setTranslationX(0.0F);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    float f1;
    if (paramInt2 >= this.r) {
      f1 = 1.0F;
    }
    for (;;)
    {
      a(f1);
      return;
      if ((paramInt2 >= this.q) && (paramInt2 <= this.r)) {
        f1 = (paramInt2 - this.q) / (this.r - this.q);
      } else {
        f1 = 0.0F;
      }
    }
  }
  
  protected void a(View paramView) {}
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama) {}
  
  protected void b(String paramString)
  {
    if (this.e != null) {
      this.e.setText(paramString);
    }
  }
  
  protected void c()
  {
    if (this.o) {
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          HomePageFragment.a(HomePageFragment.this);
        }
      });
    }
    for (;;)
    {
      this.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          HomePageFragment.this.e();
        }
      });
      this.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((ApplicationEx.c.getUser() != null) && (ApplicationEx.c.isLoginState()))
          {
            paramAnonymousView = new Intent(HomePageFragment.this.b, MessageCenterActivity.class);
            HomePageFragment.this.startActivity(paramAnonymousView);
            return;
          }
          com.ziroom.commonlibrary.login.a.startLoginActivity(HomePageFragment.this.b);
        }
      });
      return;
      this.d.setVisibility(8);
    }
  }
  
  protected void d()
  {
    MessageUtil.doAfterMsgNumUpdate(new MessageUtil.a()
    {
      public void onMessageNumUpdate()
      {
        int i;
        int j;
        if ((HomePageFragment.this.i != null) && (HomePageFragment.this.k != null))
        {
          i = MessageUtil.getCustomServiceMsgNum() + MessageUtil.getMinsuCustomServiceMsgNum() + MessageUtil.getMinsuImMsgNum() + MessageUtil.getsMeetaMsgNum();
          j = MessageUtil.getSystemMsgNum();
          u.i("huanxin", " 自如客服 = " + MessageUtil.getCustomServiceMsgNum() + " 民宿客服 = " + MessageUtil.getMinsuCustomServiceMsgNum() + " 民宿  im = " + MessageUtil.getMinsuImMsgNum() + " 三个之和 = " + i + " 系统消息 = " + MessageUtil.getSystemMsgNum());
          if ((i > 0) && (i <= 99))
          {
            HomePageFragment.this.i.setVisibility(0);
            HomePageFragment.this.k.setVisibility(8);
            HomePageFragment.this.i.setText(i + "");
          }
        }
        else
        {
          return;
        }
        if (i > 99)
        {
          HomePageFragment.this.i.setVisibility(0);
          HomePageFragment.this.k.setVisibility(8);
          HomePageFragment.this.i.setText("99+");
          return;
        }
        if (j > 0)
        {
          HomePageFragment.this.i.setVisibility(8);
          HomePageFragment.this.k.setVisibility(0);
          HomePageFragment.this.i.setText("99+");
          return;
        }
        HomePageFragment.this.i.setVisibility(8);
        HomePageFragment.this.k.setVisibility(8);
      }
    });
  }
  
  protected void e() {}
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.b = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.u = paramLayoutInflater.inflate(2130903915, paramViewGroup, false);
    this.v = ((FrameLayout)this.u.findViewById(2131694051));
    this.m = ((RelativeLayout)this.u.findViewById(2131694043));
    this.c = ((ImageView)this.u.findViewById(2131689859));
    this.d = ((FrameLayout)this.u.findViewById(2131692496));
    this.e = ((TextView)this.u.findViewById(2131692744));
    this.f = ((ImageView)this.u.findViewById(2131694044));
    this.j = ((ImageView)this.u.findViewById(2131694046));
    this.g = ((TextView)this.u.findViewById(2131694049));
    this.h = ((FrameLayout)this.u.findViewById(2131694045));
    this.i = ((TextView)this.u.findViewById(2131694047));
    this.k = ((ImageView)this.u.findViewById(2131694048));
    this.l = ((SimpleDraweeView)this.u.findViewById(2131692330));
    paramLayoutInflater = paramLayoutInflater.inflate(this.t, this.v, false);
    this.v.addView(paramLayoutInflater);
    this.n = ((ObservableScrollView)this.u.findViewById(2131694050));
    this.n.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        HomePageFragment.this.a(paramAnonymousInt1, paramAnonymousInt2);
      }
    });
    this.p = this.b.getResources().getDisplayMetrics().widthPixels;
    this.q = 0;
    this.r = ((int)(this.p * 3.0F / 8.0F));
    c();
    a(paramLayoutInflater);
    d();
    f();
    this.w = new a();
    paramLayoutInflater = new IntentFilter();
    paramLayoutInflater.addAction("com.ziroom.ziroomcustomer.main.title");
    getActivity().registerReceiver(this.w, paramLayoutInflater);
    g();
    return this.u;
  }
  
  public void onDestroy()
  {
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.y);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.w);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.s);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    this.n.clearFocus();
    d();
  }
  
  public class MessageUpdateReceiver
    extends BroadcastReceiver
  {
    public MessageUpdateReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      u.i("huanxin", " MessageUpdateReceiver  onReceive  -------------- " + HomePageFragment.this.getClass().getSimpleName());
      HomePageFragment.this.d();
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      HomePageFragment.b(HomePageFragment.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/HomePageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */