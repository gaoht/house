package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaCommitBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaConfigBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaConfigBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNpsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNpsBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.FiveEvaluteButton;
import com.ziroom.ziroomcustomer.minsu.view.MinsuEvaluteButton.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.Timer;
import java.util.TimerTask;

public class MinsuEvaCommitActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener
{
  private LinearLayout A;
  private FiveEvaluteButton B;
  private FiveEvaluteButton C;
  private FiveEvaluteButton D;
  private FiveEvaluteButton E;
  private FiveEvaluteButton F;
  private MinsuEvaluteButton.a G = new MinsuEvaluteButton.a()
  {
    public void onSwitch(int paramAnonymousInt)
    {
      MinsuEvaCommitActivity.a(MinsuEvaCommitActivity.this).scrollTo(0, Integer.MAX_VALUE);
      MinsuEvaCommitActivity.this.a();
    }
  };
  private String a;
  private int b = 1;
  private int c = 0;
  private int d = Integer.MAX_VALUE;
  private String e = "0";
  private String f = "不限";
  private CommonTitle g;
  private ObservableScrollView r;
  private EditText s;
  private View t;
  private FiveEvaluteButton u;
  private View v;
  private LinearLayout w;
  private LinearLayout x;
  private LinearLayout y;
  private LinearLayout z;
  
  private void a(MinsuEvaCommitBean paramMinsuEvaCommitBean)
  {
    if (this.b == 1) {}
    for (h localh = h.b;; localh = h.a)
    {
      k();
      com.ziroom.ziroomcustomer.minsu.f.k.toMinsuEvaSuccessPage(this, localh, paramMinsuEvaCommitBean);
      paramMinsuEvaCommitBean = new Intent();
      paramMinsuEvaCommitBean.setAction("minsu_eva_commitsuccess");
      sendBroadcast(paramMinsuEvaCommitBean);
      setResult(-1);
      finish();
      return;
    }
  }
  
  private void a(FiveEvaluteButton paramFiveEvaluteButton, int[] paramArrayOfInt)
  {
    paramFiveEvaluteButton.setSwitch(true);
    paramFiveEvaluteButton.setScoreTextVisible(false);
    paramFiveEvaluteButton.setPadding(paramArrayOfInt);
    paramFiveEvaluteButton.setOnSwitchStateListener(this.G);
    paramFiveEvaluteButton.setScore(5.0F);
  }
  
  private boolean a(EditText paramEditText)
  {
    int i = paramEditText.getScrollY();
    int j = paramEditText.getLayout().getHeight() - (paramEditText.getHeight() - paramEditText.getCompoundPaddingTop() - paramEditText.getCompoundPaddingBottom());
    if (j == 0) {}
    while ((i <= 0) && (i >= j - 1)) {
      return false;
    }
    return true;
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.llCommitReply(this, paramString, this.a, new s(this, new r(MinsuBaseJson.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        if ((paramAnonymousMinsuBaseJson != null) && (paramAnonymousMinsuBaseJson.checkSuccess(MinsuEvaCommitActivity.this)))
        {
          d.e("lanzhihong", "ro======" + paramAnonymousMinsuBaseJson.toString());
          MinsuEvaCommitActivity.this.showToast("提交成功!");
          MinsuEvaCommitActivity.this.finish();
          return;
        }
        if (paramAnonymousMinsuBaseJson == null) {}
        for (paramAnonymousMinsuBaseJson = null;; paramAnonymousMinsuBaseJson = paramAnonymousMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuBaseJson);
          return;
        }
      }
    });
  }
  
  private void e()
  {
    int[] arrayOfInt = new int[4];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 12;
    int[] tmp10_5 = tmp5_4;
    tmp10_5[1] = 6;
    int[] tmp15_10 = tmp10_5;
    tmp15_10[2] = 12;
    int[] tmp20_15 = tmp15_10;
    tmp20_15[3] = 6;
    tmp20_15;
    this.w = ((LinearLayout)findViewById(2131694532));
    ((TextView)this.w.findViewById(2131690084)).setText("清洁度    ");
    this.B = ((FiveEvaluteButton)this.w.findViewById(2131694580));
    a(this.B, arrayOfInt);
    this.A = ((LinearLayout)findViewById(2131692948));
    ((TextView)this.A.findViewById(2131690084)).setText("性价比    ");
    this.F = ((FiveEvaluteButton)this.A.findViewById(2131694580));
    a(this.F, arrayOfInt);
    this.y = ((LinearLayout)findViewById(2131694534));
    ((TextView)this.y.findViewById(2131690084)).setText("描述相符");
    this.D = ((FiveEvaluteButton)this.y.findViewById(2131694580));
    a(this.D, arrayOfInt);
    this.x = ((LinearLayout)findViewById(2131694535));
    ((TextView)this.x.findViewById(2131690084)).setText("房东印象");
    this.C = ((FiveEvaluteButton)this.x.findViewById(2131694580));
    a(this.C, arrayOfInt);
    this.z = ((LinearLayout)findViewById(2131694533));
    ((TextView)this.z.findViewById(2131690084)).setText("周边环境");
    this.E = ((FiveEvaluteButton)this.z.findViewById(2131694580));
    a(this.E, arrayOfInt);
  }
  
  private void e(String paramString)
  {
    int i = (int)this.u.getScore();
    if (i == 0)
    {
      showToast("请对房客进行综合评分");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.llCommitEva(this, i, paramString, this.a, new s(this, new r(MinsuBaseJson.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        Object localObject = null;
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        if ((paramAnonymousMinsuBaseJson != null) && (paramAnonymousMinsuBaseJson.checkSuccess(MinsuEvaCommitActivity.this)))
        {
          d.e("lanzhihong", "ro======" + paramAnonymousMinsuBaseJson.toString());
          MinsuEvaCommitActivity.this.showToast("提交成功!");
          MinsuEvaCommitActivity.a(MinsuEvaCommitActivity.this, null);
          return;
        }
        if (paramAnonymousMinsuBaseJson == null) {}
        for (paramAnonymousMinsuBaseJson = (MinsuBaseJson)localObject;; paramAnonymousMinsuBaseJson = paramAnonymousMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuBaseJson);
          return;
        }
      }
    });
  }
  
  private void f()
  {
    this.s = ((EditText)findViewById(2131691290));
    this.s.setOnTouchListener(this);
    this.r = ((ObservableScrollView)findViewById(2131689709));
    this.v = findViewById(2131694531);
    this.t = findViewById(2131694622);
    switch (this.b)
    {
    default: 
      return;
    case 1: 
      this.t.setVisibility(8);
      e();
      return;
    case 2: 
      this.v.setVisibility(8);
      g();
      return;
    }
    this.t.setVisibility(8);
    this.v.setVisibility(8);
  }
  
  private void f(String paramString)
  {
    int i = (int)this.B.getScore();
    int j = (int)this.D.getScore();
    int k = (int)this.C.getScore();
    int m = (int)this.E.getScore();
    int n = (int)this.F.getScore();
    if ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (n == 0))
    {
      showToast("请对所有评价进行评分");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.customerCommitEvaluate(this, MinsuEvaCommitBean.class, i, j, k, m, n, paramString, this.a, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        final MinsuEvaCommitBean localMinsuEvaCommitBean = (MinsuEvaCommitBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuEvaCommitBean != null) && (localMinsuEvaCommitBean.checkSuccess(MinsuEvaCommitActivity.this)))
        {
          d.e("lanzhihong", "ro======" + localMinsuEvaCommitBean.toString());
          MinsuEvaCommitActivity.this.showToast("提交成功!");
          com.ziroom.ziroomcustomer.minsu.e.a.getRecommendNps(MinsuEvaCommitActivity.this, new s(MinsuEvaCommitActivity.this, new r(MinsuNpsBean.class))
          {
            public void onFailure(Throwable paramAnonymous2Throwable)
            {
              super.onFailure(paramAnonymous2Throwable);
              MinsuEvaCommitActivity.a(MinsuEvaCommitActivity.this, localMinsuEvaCommitBean);
            }
            
            public void onSuccess(int paramAnonymous2Int, MinsuNpsBean paramAnonymous2MinsuNpsBean)
            {
              super.onSuccess(paramAnonymous2Int, paramAnonymous2MinsuNpsBean);
              if ((paramAnonymous2MinsuNpsBean.checkSuccess(MinsuEvaCommitActivity.this)) && (paramAnonymous2MinsuNpsBean.data != null) && (1 == paramAnonymous2MinsuNpsBean.data.can))
              {
                MinsuEvaCommitActivity.f(MinsuEvaCommitActivity.this);
                if (MinsuEvaCommitActivity.g(MinsuEvaCommitActivity.this) == 1) {}
                for (h localh = h.b;; localh = h.a)
                {
                  com.ziroom.ziroomcustomer.minsu.f.k.toNps(MinsuEvaCommitActivity.this, MinsuEvaCommitActivity.h(MinsuEvaCommitActivity.this), localh, localMinsuEvaCommitBean, paramAnonymous2MinsuNpsBean.data.content);
                  MinsuEvaCommitActivity.this.finish();
                  return;
                }
              }
              MinsuEvaCommitActivity.a(MinsuEvaCommitActivity.this, localMinsuEvaCommitBean);
            }
          });
          return;
        }
        if (localMinsuEvaCommitBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuEvaCommitBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void g()
  {
    this.u = ((FiveEvaluteButton)this.t.findViewById(2131694580));
    a(this.u, new int[] { 12, 6, 12, 6 });
  }
  
  private void h()
  {
    this.g = ((CommonTitle)findViewById(2131691272));
    this.g.showRightText(true, getString(2131296704));
    this.g.setRightTextColorSize(2131624081, 14);
    this.g.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuEvaCommitActivity.c(MinsuEvaCommitActivity.this);
      }
    });
    this.g.setMiddleText("");
    this.g.setLeftButtonType(4);
    this.g.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuEvaCommitActivity.this.finish();
      }
    });
    this.g.showTopLine(this.r);
  }
  
  private void i()
  {
    a();
    com.ziroom.ziroomcustomer.minsu.e.a.evalConfig(this, new s(this, new r(MinsuEvaConfigBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuEvaConfigBean paramAnonymousMinsuEvaConfigBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuEvaConfigBean);
        if ((paramAnonymousMinsuEvaConfigBean != null) && (paramAnonymousMinsuEvaConfigBean.checkSuccessNoLogin()))
        {
          MinsuEvaCommitActivity.a(MinsuEvaCommitActivity.this, paramAnonymousMinsuEvaConfigBean.data.min);
          MinsuEvaCommitActivity.b(MinsuEvaCommitActivity.this, paramAnonymousMinsuEvaConfigBean.data.max);
          MinsuEvaCommitActivity.a(MinsuEvaCommitActivity.this, MinsuEvaCommitActivity.d(MinsuEvaCommitActivity.this) + "");
          MinsuEvaCommitActivity.b(MinsuEvaCommitActivity.this, MinsuEvaCommitActivity.e(MinsuEvaCommitActivity.this) + "");
          d.i("info", "min = " + MinsuEvaCommitActivity.d(MinsuEvaCommitActivity.this) + "  max = " + MinsuEvaCommitActivity.e(MinsuEvaCommitActivity.this));
          MinsuEvaCommitActivity.b(MinsuEvaCommitActivity.this).setHint(MinsuEvaCommitActivity.this.getEvaEtHint());
        }
      }
    });
  }
  
  private void j()
  {
    String str = VdsAgent.trackEditTextSilent(this.s).toString();
    if (ae.isNull(str)) {
      showToast("内容为空");
    }
    do
    {
      return;
      if (str.length() < this.c)
      {
        showToast(String.format("字数过短，评价内容不能少于%d字", new Object[] { Integer.valueOf(this.c) }));
        return;
      }
      if (str.length() > this.d)
      {
        showToast(String.format("字数过长，评价内容不能超过%d字", new Object[] { Integer.valueOf(this.d) }));
        return;
      }
      if (this.b == 1)
      {
        f(str);
        return;
      }
      if (this.b == 2)
      {
        e(str);
        return;
      }
    } while (this.b != 3);
    d(str);
  }
  
  private void k()
  {
    Intent localIntent = new Intent("action_customer_eva");
    localIntent.putExtra("orderSn", this.a);
    localIntent.putExtra("evaType", this.b);
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
  }
  
  protected void a()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  protected void b()
  {
    this.s.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)MinsuEvaCommitActivity.this.getSystemService("input_method");
        localInputMethodManager.showSoftInput(MinsuEvaCommitActivity.b(MinsuEvaCommitActivity.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 100L);
  }
  
  public void finish()
  {
    super.finish();
    com.ziroom.ziroomcustomer.minsu.f.k.animFinishAlpha(this);
  }
  
  public String getEvaEtHint()
  {
    if (this.b == 1) {
      return String.format(getString(2131297066), new Object[] { this.e, this.f });
    }
    if (this.b == 2) {
      return String.format(getString(2131297070), new Object[] { this.e, this.f });
    }
    if (this.b == 3) {
      return String.format(getString(2131297155), new Object[] { this.e, this.f });
    }
    return "";
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903272);
    this.a = getIntent().getStringExtra("orderSn");
    this.b = getIntent().getIntExtra("evaType", 1);
    f();
    h();
    i();
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131691290) && (a(this.s)))
    {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      if (paramMotionEvent.getAction() == 1) {
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuEvaCommitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */