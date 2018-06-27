package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.mato.sdk.instrumentation.WebviewInstrumentation;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.maa.android.agent.instrumentation.Instrumented
public class QuestionDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private String B = "";
  private TextView C;
  private TextView D;
  private int E = 0;
  private List<Contract> F;
  private LinearLayout G;
  private FrameLayout H;
  private SimpleDraweeView I;
  private int J;
  private ObservableScrollView K;
  private FrameLayout L;
  private TextView M;
  private TextView N;
  private EditText O;
  private TextView P;
  private RelativeLayout Q;
  private String R;
  private boolean S = true;
  private int T = 0;
  private String U = "";
  private String V = null;
  private ViewTreeObserver.OnGlobalLayoutListener W = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (QuestionDetailActivity.m(QuestionDetailActivity.this).getRootView().getHeight() - QuestionDetailActivity.m(QuestionDetailActivity.this).getHeight() <= QuestionDetailActivity.this.getWindow().findViewById(16908290).getTop())
      {
        QuestionDetailActivity.n(QuestionDetailActivity.this).setVisibility(0);
        return;
      }
      QuestionDetailActivity.n(QuestionDetailActivity.this).setVisibility(8);
    }
  };
  private boolean X = false;
  private ViewGroup Y;
  BasicZiroomToolBar a;
  private Context b;
  private TextView c;
  private WebView d;
  private ListViewForScrollView e;
  private h f;
  private c g;
  private RelativeLayout r;
  private RelativeLayout s;
  private LinearLayout t;
  private ImageView u;
  private TextView v;
  private RelativeLayout w;
  private ImageView x;
  private TextView y;
  private TextView z;
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.f != null) {
      com.ziroom.ziroomcustomer.e.n.getQueationDetailEvaluation(this, this.V, paramString1, paramString2, paramString3, paramString4, paramString5, new d(this, new com.ziroom.ziroomcustomer.e.c.g())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          Object localObject = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString());
          paramAnonymouse = ((e)localObject).getString("status");
          String str = ((e)localObject).getString("code");
          localObject = ((e)localObject).getString("message");
          if (("success".equals(paramAnonymouse)) && ("200".equals(str))) {
            com.freelxl.baselibrary.f.g.textToast(QuestionDetailActivity.this, (String)localObject);
          }
          for (;;)
          {
            QuestionDetailActivity.h(QuestionDetailActivity.this).setVisibility(8);
            QuestionDetailActivity.f(QuestionDetailActivity.this).setEnabled(false);
            return;
            com.freelxl.baselibrary.f.g.textToast(QuestionDetailActivity.this, (String)localObject);
          }
        }
      });
    }
  }
  
  private void b()
  {
    this.F = ApplicationEx.c.getContracts();
    this.A = getIntent().getStringExtra("item_id");
    com.ziroom.ziroomcustomer.e.n.getQueationDetail(this, ApplicationEx.c.getUser().getUid(), b.d, this.A, new d(this, new com.ziroom.ziroomcustomer.e.c.f(h.class))
    {
      public void onSuccess(int paramAnonymousInt, h paramAnonymoush)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoush);
        QuestionDetailActivity.a(QuestionDetailActivity.this, paramAnonymoush);
        if (QuestionDetailActivity.a(QuestionDetailActivity.this) != null)
        {
          QuestionDetailActivity.b(QuestionDetailActivity.this).setVisibility(0);
          QuestionDetailActivity.c(QuestionDetailActivity.this);
        }
      }
    });
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((QuestionDetailActivity.a(QuestionDetailActivity.this) != null) && (QuestionDetailActivity.a(QuestionDetailActivity.this).getCorrelativeLore().size() > 0))
        {
          paramAnonymousAdapterView = ((h.a)QuestionDetailActivity.a(QuestionDetailActivity.this).getCorrelativeLore().get(paramAnonymousInt)).getLoreGroupId();
          paramAnonymousView = new Intent(QuestionDetailActivity.d(QuestionDetailActivity.this), QuestionDetailActivity.class);
          paramAnonymousView.putExtra("item_id", paramAnonymousAdapterView);
          QuestionDetailActivity.this.startActivity(paramAnonymousView);
        }
      }
    });
  }
  
  private View d(String paramString)
  {
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130904766, null, false);
    RadioButton localRadioButton = (RadioButton)localView.findViewById(2131695865);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, sp2px(25.0F));
    Drawable localDrawable = getResources().getDrawable(2130839285);
    localDrawable.setBounds(0, 0, sp2px(20.0F), sp2px(20.0F));
    localRadioButton.setCompoundDrawables(localDrawable, null, null, null);
    localRadioButton.setCompoundDrawablePadding(sp2px(6.0F));
    localRadioButton.setLayoutParams(localLayoutParams);
    localRadioButton.setText(paramString);
    localRadioButton.setTextSize(14.0F);
    localRadioButton.setTextColor(Color.parseColor("#444444"));
    localRadioButton.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (RadioButton)paramAnonymousView;
        if (QuestionDetailActivity.i(QuestionDetailActivity.this))
        {
          RadioButton localRadioButton = (RadioButton)QuestionDetailActivity.j(QuestionDetailActivity.this).getTag();
          if (localRadioButton != null) {
            localRadioButton.setChecked(false);
          }
          QuestionDetailActivity.j(QuestionDetailActivity.this).setTag(paramAnonymousView);
          QuestionDetailActivity.b(QuestionDetailActivity.this, paramAnonymousView.getText().toString());
          paramAnonymousView.setChecked(true);
          if ("其他原因".equals(QuestionDetailActivity.k(QuestionDetailActivity.this)))
          {
            QuestionDetailActivity.l(QuestionDetailActivity.this).setVisibility(0);
            if (com.freelxl.baselibrary.f.f.isNull(VdsAgent.trackEditTextSilent(QuestionDetailActivity.f(QuestionDetailActivity.this)).toString()))
            {
              QuestionDetailActivity.h(QuestionDetailActivity.this).setBackgroundResource(2131624042);
              QuestionDetailActivity.h(QuestionDetailActivity.this).setEnabled(false);
              return;
            }
            QuestionDetailActivity.h(QuestionDetailActivity.this).setBackgroundResource(2131624516);
            QuestionDetailActivity.h(QuestionDetailActivity.this).setEnabled(true);
            return;
          }
          QuestionDetailActivity.f(QuestionDetailActivity.this).setText("");
          QuestionDetailActivity.l(QuestionDetailActivity.this).setVisibility(8);
          QuestionDetailActivity.h(QuestionDetailActivity.this).setBackgroundResource(2131624516);
          QuestionDetailActivity.h(QuestionDetailActivity.this).setEnabled(true);
          return;
        }
        if (!paramAnonymousView.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          return;
        }
      }
    });
    return localView;
  }
  
  private void e()
  {
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("问题详情");
    this.Q = ((RelativeLayout)findViewById(2131690668));
    this.c = ((TextView)findViewById(2131690939));
    this.d = ((WebView)findViewById(2131690409));
    this.e = ((ListViewForScrollView)findViewById(2131690176));
    this.r = ((RelativeLayout)findViewById(2131690944));
    this.u = ((ImageView)findViewById(2131690945));
    this.v = ((TextView)findViewById(2131690946));
    this.w = ((RelativeLayout)findViewById(2131690947));
    this.x = ((ImageView)findViewById(2131690948));
    this.y = ((TextView)findViewById(2131690949));
    this.z = ((TextView)findViewById(2131690938));
    this.C = ((TextView)findViewById(2131690942));
    this.G = ((LinearLayout)findViewById(2131690943));
    this.H = ((FrameLayout)findViewById(2131690940));
    this.I = ((SimpleDraweeView)findViewById(2131690941));
    this.K = ((ObservableScrollView)findViewById(2131690031));
    this.s = ((RelativeLayout)findViewById(2131690950));
    this.t = ((LinearLayout)findViewById(2131690952));
    this.D = ((TextView)findViewById(2131690954));
    this.L = ((FrameLayout)findViewById(2131690402));
    this.M = ((TextView)findViewById(2131690403));
    this.N = ((TextView)findViewById(2131690404));
    this.O = ((EditText)findViewById(2131690002));
    this.P = ((TextView)findViewById(2131690953));
    this.r.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.O.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        QuestionDetailActivity.e(QuestionDetailActivity.this).setText("" + paramAnonymousEditable.length());
        this.c = QuestionDetailActivity.f(QuestionDetailActivity.this).getSelectionStart();
        this.d = QuestionDetailActivity.f(QuestionDetailActivity.this).getSelectionEnd();
        if (this.b.length() > 140)
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          QuestionDetailActivity.f(QuestionDetailActivity.this).setText(paramAnonymousEditable);
          QuestionDetailActivity.f(QuestionDetailActivity.this).setSelection(i);
        }
        QuestionDetailActivity.a(QuestionDetailActivity.this, VdsAgent.trackEditTextSilent(QuestionDetailActivity.f(QuestionDetailActivity.this)).toString());
        if (QuestionDetailActivity.g(QuestionDetailActivity.this).length() > 0)
        {
          QuestionDetailActivity.h(QuestionDetailActivity.this).setBackgroundResource(2131624516);
          QuestionDetailActivity.h(QuestionDetailActivity.this).setEnabled(true);
          return;
        }
        QuestionDetailActivity.h(QuestionDetailActivity.this).setBackgroundResource(2131624042);
        QuestionDetailActivity.h(QuestionDetailActivity.this).setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
  }
  
  private void e(String paramString)
  {
    if (paramString.isEmpty()) {
      return;
    }
    this.d.getSettings().setUseWideViewPort(true);
    this.d.setBackgroundColor(0);
    this.d.getSettings().setJavaScriptEnabled(true);
    this.d.getSettings().setLoadWithOverviewMode(true);
    this.d.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.d.getSettings().setDefaultFontSize(18);
    WebView localWebView = this.d;
    if (!(localWebView instanceof WebView)) {
      localWebView.loadDataWithBaseURL(null, paramString, "text/html", "utf-8", null);
    }
    for (;;)
    {
      this.d.setWebViewClient(new WebViewClient()
      {
        public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        }
        
        public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          if (!(paramAnonymousWebView instanceof WebView)) {
            paramAnonymousWebView.loadUrl(paramAnonymousString);
          }
          for (;;)
          {
            return true;
            WebviewInstrumentation.loadUrl((WebView)paramAnonymousWebView, paramAnonymousString);
          }
        }
      });
      return;
      WebviewInstrumentation.loadDataWithBaseURL((WebView)localWebView, null, paramString, "text/html", "utf-8", null);
    }
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.n.getQueationEventAdd(this, this.V, this.A, new d(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        Object localObject = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
        paramAnonymouse = ((e)localObject).getString("status");
        localObject = ((e)localObject).getString("code");
        if (("success".equals(paramAnonymouse)) && ("200".equals(localObject))) {
          QuestionDetailActivity.this.startActivity(new Intent(QuestionDetailActivity.this, ChatWebViewActivity.class));
        }
      }
    });
  }
  
  private void g()
  {
    if ((this.f.getCorrelativeLore() != null) && (this.f.getCorrelativeLore().size() > 0))
    {
      this.g = new c(this.b, this.f.getCorrelativeLore());
      this.e.setAdapter(this.g);
      this.D.setVisibility(0);
    }
    for (;;)
    {
      this.c.setText(this.f.getQuestion().trim());
      if (this.f.getAnswer() != null) {
        e(this.f.getAnswer());
      }
      this.G.setVisibility(0);
      if (this.f.getSelfForm() != null)
      {
        this.C.setVisibility(0);
        this.C.setText(this.f.getSelfForm().getFormName());
      }
      Object localObject2 = this.f.getUselessCauses();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      ((List)localObject1).add("其他原因");
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = d((String)((Iterator)localObject1).next());
        int i = this.t.getChildCount();
        this.t.addView((View)localObject2, i - 2);
      }
      this.D.setVisibility(8);
    }
  }
  
  private void h()
  {
    this.r.setOnClickListener(null);
    this.w.setOnClickListener(null);
    if ("EFFECTIVE".equals(this.B))
    {
      this.u.setImageResource(2130838112);
      this.v.setTextColor(40960);
      this.x.setImageResource(2130838124);
      this.y.setTextColor(-3355444);
    }
    while (!"USELESS".equals(this.B)) {
      return;
    }
    this.x.setImageResource(2130838125);
    this.y.setTextColor(40960);
    this.u.setImageResource(2130838111);
    this.v.setTextColor(-3355444);
  }
  
  protected void a()
  {
    if (this.X) {
      return;
    }
    this.Y = ((ViewGroup)findViewById(2131690936));
    this.Y.getViewTreeObserver().addOnGlobalLayoutListener(this.W);
    this.X = true;
  }
  
  @com.growingio.android.sdk.instrumentation.Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690953: 
      this.P.setEnabled(false);
      this.P.setBackgroundResource(2131624042);
      this.S = false;
      if (com.freelxl.baselibrary.f.f.isNull(this.U)) {}
      for (paramView = this.R;; paramView = this.U)
      {
        a(this.f.getTrackCode(), this.f.getLogicCode(), this.f.getLoreGroupId(), this.B, paramView);
        return;
      }
    case 2131690938: 
      f();
      return;
    case 2131690944: 
      this.B = "EFFECTIVE";
      h();
      a(this.f.getTrackCode(), this.f.getLogicCode(), this.f.getLoreGroupId(), this.B, "");
      this.s.setVisibility(8);
      return;
    case 2131690947: 
      if (this.s.getVisibility() == 8) {
        this.s.setVisibility(0);
      }
      for (;;)
      {
        this.B = "USELESS";
        h();
        return;
        this.s.setVisibility(8);
      }
    }
    com.ziroom.ziroomcustomer.newchat.chatcenter.c.a.ToAotherActivity(this, this.f.getSelfForm());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903215);
    this.b = this;
    e();
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.X) {
      this.Y.getViewTreeObserver().removeGlobalOnLayoutListener(this.W);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this.J = getWindowManager().getDefaultDisplay().getWidth();
    int i = (this.J - com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 32.0F)) * 2 / 3;
    ViewGroup.LayoutParams localLayoutParams = this.H.getLayoutParams();
    localLayoutParams.height = i;
    this.H.setLayoutParams(localLayoutParams);
  }
  
  public int sp2px(float paramFloat)
  {
    return (int)(this.b.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/QuestionDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */