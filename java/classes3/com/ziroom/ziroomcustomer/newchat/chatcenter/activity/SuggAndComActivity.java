package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.v;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.view.NewsTitleTextView;
import com.ziroom.ziroomcustomer.newchat.chatcenter.MySuggestionActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.a.c;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.e;
import com.ziroom.ziroomcustomer.newchat.chatcenter.d;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.MyViewPaper;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SuggAndComActivity
  extends BaseActivity
{
  private LinearLayout A;
  private LinearLayout B;
  private LinearLayout C;
  private e D;
  private List<d> E = new ArrayList();
  private ObservableScrollView F;
  private MyViewPaper G;
  private View H;
  private int I;
  private RelativeLayout J;
  BasicZiroomToolBar a;
  private final String b = "SuggAndComActivity";
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private ImageView s;
  private ImageView t;
  private ImageView u;
  private View v;
  private View w;
  private TextView x;
  private TextView y;
  private Button z;
  
  private void a()
  {
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("投诉建议");
    w.onEventToZiroomAndUmeng("life_camplain_time");
    this.H = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130904737, null, false);
    this.C = ((LinearLayout)findViewById(2131692591));
    this.c = ((LinearLayout)findViewById(2131692592));
    this.c.addView(this.H);
    this.G = ((MyViewPaper)findViewById(2131691905));
    this.G.setOffscreenPageLimit(0);
    this.F = ((ObservableScrollView)findViewById(2131689506));
    this.A = ((LinearLayout)this.c.findViewById(2131696261));
    this.d = ((TextView)this.c.findViewById(2131689852));
    this.e = ((TextView)this.c.findViewById(2131695389));
    this.f = ((TextView)this.c.findViewById(2131696265));
    this.g = ((TextView)this.c.findViewById(2131696266));
    this.r = ((TextView)this.c.findViewById(2131696267));
    this.s = ((ImageView)this.c.findViewById(2131696268));
    this.t = ((ImageView)this.c.findViewById(2131696270));
    this.u = ((ImageView)this.c.findViewById(2131696272));
    this.v = this.c.findViewById(2131696269);
    this.w = this.c.findViewById(2131696271);
    this.x = ((TextView)this.c.findViewById(2131690415));
    this.y = ((TextView)this.c.findViewById(2131690416));
    this.z = ((Button)this.c.findViewById(2131696273));
    this.J = ((RelativeLayout)this.c.findViewById(2131696274));
    this.B = ((LinearLayout)findViewById(2131690094));
    this.F.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt2 == SuggAndComActivity.a(SuggAndComActivity.this)) {}
        do
        {
          do
          {
            return;
            SuggAndComActivity.b(SuggAndComActivity.this).setFocusable(false);
            SuggAndComActivity.b(SuggAndComActivity.this).setFocusableInTouchMode(false);
            if (paramAnonymousInt2 <= SuggAndComActivity.a(SuggAndComActivity.this)) {
              break;
            }
          } while (SuggAndComActivity.c(SuggAndComActivity.this).getParent() == SuggAndComActivity.d(SuggAndComActivity.this));
          SuggAndComActivity.b(SuggAndComActivity.this).removeView(SuggAndComActivity.c(SuggAndComActivity.this));
          SuggAndComActivity.d(SuggAndComActivity.this).addView(SuggAndComActivity.c(SuggAndComActivity.this));
          SuggAndComActivity.a(SuggAndComActivity.this, SuggAndComActivity.b(SuggAndComActivity.this).getBottom());
          return;
        } while (SuggAndComActivity.c(SuggAndComActivity.this).getParent() == SuggAndComActivity.b(SuggAndComActivity.this));
        SuggAndComActivity.d(SuggAndComActivity.this).removeView(SuggAndComActivity.c(SuggAndComActivity.this));
        SuggAndComActivity.b(SuggAndComActivity.this).addView(SuggAndComActivity.c(SuggAndComActivity.this));
        SuggAndComActivity.a(SuggAndComActivity.this, SuggAndComActivity.b(SuggAndComActivity.this).getBottom() - SuggAndComActivity.c(SuggAndComActivity.this).getMeasuredHeight());
      }
    });
    this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        SuggAndComActivity.b(SuggAndComActivity.this).setFocusable(true);
        SuggAndComActivity.b(SuggAndComActivity.this).setFocusableInTouchMode(true);
      }
    });
    this.G.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        SuggAndComActivity.a(SuggAndComActivity.this, paramAnonymousInt, true);
      }
    });
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.B.measure(this.B.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.B.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.B.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < this.B.getChildCount())
    {
      localObject = (NewsTitleTextView)this.B.getChildAt(j);
      int n = ((NewsTitleTextView)localObject).getMeasuredWidth();
      int m = i;
      if (j < paramInt) {
        m = i + n + ah.dip2px(this, 32.0F);
      }
      k += n;
      if (paramInt != j)
      {
        ((NewsTitleTextView)localObject).setTextColor(-16777216);
        ((NewsTitleTextView)localObject).setIsHorizontaline(false);
      }
      for (;;)
      {
        j += 1;
        i = m;
        break;
        ((NewsTitleTextView)localObject).setTextColor(33792);
        ((NewsTitleTextView)localObject).setIsHorizontaline(true);
      }
    }
    paramInt = this.B.getChildAt(paramInt).getMeasuredWidth();
    if (paramBoolean)
    {
      j = getWindowManager().getDefaultDisplay().getWidth();
      k = ((HorizontalScrollView)this.B.getParent()).getScrollX();
      if ((i - k <= 0) || (i - k >= j)) {
        break label229;
      }
    }
    label229:
    do
    {
      return;
      if (i - k >= j)
      {
        ((HorizontalScrollView)this.B.getParent()).setScrollX(paramInt + (i - j) + ah.dip2px(this, 32.0F));
        return;
      }
    } while (i - k >= 0);
    ((HorizontalScrollView)this.B.getParent()).setScrollX(i);
  }
  
  private void a(e parame)
  {
    this.d.setText(parame.getCreateTime());
    this.e.setText(parame.getConsultContent());
    String str = parame.getUpgradeStatus();
    if ("2".equals(str))
    {
      this.x.setText("受理倒计时预计");
      this.f.setBackgroundResource(2130838239);
      this.f.setTextColor(-1);
      this.g.setBackgroundResource(2130838224);
      this.g.setTextColor(-6710887);
      this.r.setBackgroundResource(2130838224);
      this.r.setTextColor(-6710887);
      this.s.setImageResource(2130838241);
      this.t.setImageResource(2130838240);
      this.u.setImageResource(2130838240);
      this.v.setBackgroundColor(-2236963);
      this.w.setBackgroundColor(-2236963);
    }
    for (;;)
    {
      this.y.setText(parame.getLittleTime());
      this.I = (this.c.getBottom() - this.H.getMeasuredHeight());
      return;
      if (("5".equals(str)) || ("6".equals(str)))
      {
        this.x.setText("完成倒计时预计");
        this.f.setBackgroundResource(2130838239);
        this.f.setTextColor(-1);
        this.g.setBackgroundResource(2130838239);
        this.g.setTextColor(-1);
        this.r.setBackgroundResource(2130838239);
        this.r.setTextColor(-1);
        this.s.setImageResource(2130838241);
        this.t.setImageResource(2130838241);
        this.u.setImageResource(2130838241);
        this.v.setBackgroundColor(40960);
        this.w.setBackgroundColor(40960);
      }
      else
      {
        this.x.setText("处理倒计时预计");
        this.f.setBackgroundResource(2130838239);
        this.f.setTextColor(-1);
        this.g.setBackgroundResource(2130838239);
        this.g.setTextColor(-1);
        this.r.setBackgroundResource(2130838224);
        this.r.setTextColor(-6710887);
        this.s.setImageResource(2130838241);
        this.t.setImageResource(2130838241);
        this.u.setImageResource(2130838240);
        this.v.setBackgroundColor(40960);
        this.w.setBackgroundColor(-2236963);
      }
    }
  }
  
  private void a(List<d> paramList)
  {
    getWindowManager().getDefaultDisplay().getWidth();
    Object localObject1 = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject1).width = -2;
    ((ViewPager.LayoutParams)localObject1).height = -2;
    localObject1 = getLayoutInflater();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((d)paramList.get(i)).getValue();
      Object localObject2 = ((LayoutInflater)localObject1).inflate(2130903664, null);
      ((TextView)((View)localObject2).findViewById(2131691097)).setText(str);
      localArrayList.add(localObject2);
      localObject2 = new NewsTitleTextView(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      localLayoutParams.setMargins(ah.dip2px(this, 16.0F), 0, ah.dip2px(this, 16.0F), 0);
      ((NewsTitleTextView)localObject2).setPadding(ah.dip2px(this, 3.0F), 0, ah.dip2px(this, 3.0F), 0);
      ((NewsTitleTextView)localObject2).setLayoutParams(localLayoutParams);
      ((NewsTitleTextView)localObject2).setTextSize(14.0F);
      ((NewsTitleTextView)localObject2).setText(str);
      ((NewsTitleTextView)localObject2).setGravity(17);
      ((NewsTitleTextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          for (;;)
          {
            if (i < SuggAndComActivity.i(SuggAndComActivity.this).getChildCount())
            {
              if ((NewsTitleTextView)SuggAndComActivity.i(SuggAndComActivity.this).getChildAt(i) == paramAnonymousView)
              {
                SuggAndComActivity.a(SuggAndComActivity.this, i, false);
                SuggAndComActivity.h(SuggAndComActivity.this).setCurrentItem(i);
              }
            }
            else {
              return;
            }
            i += 1;
          }
        }
      });
      if (i == 0)
      {
        ((NewsTitleTextView)localObject2).setTextColor(33792);
        ((NewsTitleTextView)localObject2).setIsHorizontaline(true);
      }
      for (;;)
      {
        ((NewsTitleTextView)localObject2).setIsVerticalLine(false);
        this.B.addView((View)localObject2);
        i += 1;
        break;
        ((NewsTitleTextView)localObject2).setTextColor(-16777216);
        ((NewsTitleTextView)localObject2).setIsHorizontaline(false);
      }
    }
  }
  
  private void b()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((UserInfo)localObject).getUid())
    {
      n.getLataComInfo(this, (String)localObject, new com.ziroom.commonlibrary.a.a(this, new v(e.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          SuggAndComActivity.f(SuggAndComActivity.this).setVisibility(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          SuggAndComActivity.a(SuggAndComActivity.this, paramAnonymouse);
          com.ziroom.ziroomcustomer.util.u.d("SuggAndComActivity", "===" + com.alibaba.fastjson.a.toJSONString(paramAnonymouse));
          if (paramAnonymouse != null)
          {
            SuggAndComActivity.e(SuggAndComActivity.this).setVisibility(0);
            SuggAndComActivity.f(SuggAndComActivity.this).setVisibility(8);
            SuggAndComActivity.b(SuggAndComActivity.this, paramAnonymouse);
            return;
          }
          SuggAndComActivity.f(SuggAndComActivity.this).setVisibility(0);
          SuggAndComActivity.e(SuggAndComActivity.this).setVisibility(8);
        }
      });
      e();
      return;
    }
  }
  
  private void e()
  {
    n.getSugTypeList(this, new h(this, new com.ziroom.ziroomcustomer.e.c.u(d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        d locald = new d();
        locald.setValue("全部");
        SuggAndComActivity.g(SuggAndComActivity.this).add(locald);
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          locald = (d)paramAnonymousList.next();
          SuggAndComActivity.g(SuggAndComActivity.this).add(locald);
        }
        SuggAndComActivity.a(SuggAndComActivity.this, SuggAndComActivity.g(SuggAndComActivity.this));
        paramAnonymousList = new ArrayList();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < SuggAndComActivity.g(SuggAndComActivity.this).size())
        {
          paramAnonymousList.add(new SuggAndComFrament(((d)SuggAndComActivity.g(SuggAndComActivity.this).get(paramAnonymousInt)).getKey(), SuggAndComActivity.h(SuggAndComActivity.this), paramAnonymousInt));
          paramAnonymousInt += 1;
        }
        SuggAndComActivity.h(SuggAndComActivity.this).setAdapter(new c(SuggAndComActivity.this.getSupportFragmentManager(), paramAnonymousList));
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903525);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    w.onEventToZiroomAndUmeng("life_camplain_time");
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696263: 
      startActivity(new Intent(this, MySuggestionActivity.class));
      return;
    case 2131696260: 
      startActivity(new Intent(this, ComplainActivity.class));
      return;
    case 2131694956: 
      startActivity(new Intent(this, SuggestActivity.class));
      return;
    case 2131696273: 
      startActivity(new Intent(this, MySuggestionActivity.class));
      return;
    }
    paramView = new Intent(this, ComplainDetailActivity.class);
    paramView.putExtra("consultId", this.D.getConsultId());
    startActivity(paramView);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.I = (this.c.getBottom() - this.H.getMeasuredHeight());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/SuggAndComActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */