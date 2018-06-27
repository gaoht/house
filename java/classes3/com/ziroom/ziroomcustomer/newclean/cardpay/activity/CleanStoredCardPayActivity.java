package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.c.c;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceWebActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.BuyCard;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanPaySuccessActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanStoredCardPayActivity
  extends BaseActivity
  implements View.OnClickListener, ObservableScrollView.a
{
  private RelativeLayout A;
  private View B;
  private RelativeLayout C;
  private View D;
  private RelativeLayout E;
  private View F;
  private RelativeLayout G;
  private View H;
  private RelativeLayout I;
  private View J;
  private Context K;
  private ObservableScrollView L;
  private TextView M;
  private View N;
  private LinearLayout O;
  private String P;
  private boolean Q = true;
  private BroadcastReceiver R = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getIntExtra("code", -1) == 1))
      {
        paramAnonymousContext = new Intent();
        paramAnonymousContext.setAction("refresh_card");
        LocalBroadcastManager.getInstance(CleanStoredCardPayActivity.b(CleanStoredCardPayActivity.this)).sendBroadcast(paramAnonymousContext);
        CleanStoredCardPayActivity.this.finish();
        if (CleanStoredCardPayActivity.c(CleanStoredCardPayActivity.this))
        {
          CleanStoredCardPayActivity.a(CleanStoredCardPayActivity.this, false);
          paramAnonymousContext = new Intent(CleanStoredCardPayActivity.b(CleanStoredCardPayActivity.this), CleanPaySuccessActivity.class);
          if (!TextUtils.isEmpty(CleanStoredCardPayActivity.d(CleanStoredCardPayActivity.this))) {
            paramAnonymousContext.putExtra("type", CleanStoredCardPayActivity.d(CleanStoredCardPayActivity.this));
          }
          CleanStoredCardPayActivity.this.startActivity(paramAnonymousContext);
        }
      }
      while ((paramAnonymousIntent == null) || (paramAnonymousIntent.getStringExtra("message") == null)) {
        return;
      }
      g.textToast(CleanStoredCardPayActivity.this, paramAnonymousIntent.getStringExtra("message"));
    }
  };
  private ImageView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private EditText g;
  private TextView r;
  private Button s;
  private UserInfo t;
  private int u;
  private String v;
  private String w;
  private Integer x;
  private String y;
  private String z;
  
  private void a()
  {
    this.K = this;
    View localView = findViewById(2131689492);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.M = ((TextView)findViewById(2131690337));
    this.N = findViewById(2131690338);
    this.O = ((LinearLayout)findViewById(2131690223));
    this.a = ((ImageView)findViewById(2131689492));
    this.L = ((ObservableScrollView)findViewById(2131690339));
    this.b = ((TextView)findViewById(2131690342));
    this.c = ((TextView)findViewById(2131690311));
    this.d = ((TextView)findViewById(2131690349));
    this.e = ((TextView)findViewById(2131690353));
    this.f = ((TextView)findViewById(2131690357));
    this.g = ((EditText)findViewById(2131690359));
    this.r = ((TextView)findViewById(2131690214));
    this.s = ((Button)findViewById(2131689816));
    this.A = ((RelativeLayout)findViewById(2131690340));
    this.B = findViewById(2131690343);
    this.C = ((RelativeLayout)findViewById(2131690344));
    this.D = findViewById(2131690346);
    this.E = ((RelativeLayout)findViewById(2131690347));
    this.F = findViewById(2131690350);
    this.G = ((RelativeLayout)findViewById(2131690351));
    this.H = findViewById(2131690354);
    this.I = ((RelativeLayout)findViewById(2131690355));
    this.J = findViewById(2131690358);
  }
  
  private void a(SpannableString paramSpannableString, String paramString, int paramInt)
  {
    paramSpannableString.setSpan(new ClickableSpan()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        Intent localIntent = new Intent(CleanStoredCardPayActivity.this, ServiceWebActivity.class);
        localIntent.putExtra("title_name", "自如保洁卡会员协议");
        localIntent.putExtra("url", "http://www.ziroom.com/zhuanti/2016/czkxy/index.html");
        CleanStoredCardPayActivity.this.startActivity(localIntent);
        CleanStoredCardPayActivity.a(CleanStoredCardPayActivity.this, paramAnonymousView);
      }
      
      public void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        super.updateDrawState(paramAnonymousTextPaint);
        paramAnonymousTextPaint.setColor(40960);
        paramAnonymousTextPaint.setUnderlineText(false);
      }
    }, paramInt, paramString.length() + paramInt, 0);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setHighlightColor(getResources().getColor(17170445));
    }
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.L.setOnScrollChangedCallback(this);
  }
  
  private void e()
  {
    this.P = getIntent().getStringExtra("type");
    if (!c.isNetworkConnected(this.K))
    {
      this.M.setVisibility(0);
      this.N.setVisibility(0);
      this.O.setVisibility(0);
      showEmpty(this.O, "网络异常，请稍后重试");
      this.L.setVisibility(8);
      this.s.setVisibility(8);
      g.textToast(this.K, "网络异常，请稍后重试");
      return;
    }
    registerReceiver(this.R, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    this.u = getIntent().getIntExtra("valueCardTypeId", -1);
    this.v = getIntent().getStringExtra("accountName");
    this.w = getIntent().getStringExtra("storedCardName");
    this.x = Integer.valueOf(getIntent().getIntExtra("storedCardValid", -1));
    this.y = getIntent().getStringExtra("storedCardMoney");
    this.z = getIntent().getStringExtra("storedCardGiveMoney");
    if (!ae.isNull(this.v))
    {
      this.A.setVisibility(0);
      this.B.setVisibility(0);
      this.b.setText(this.v);
      if (ae.isNull(this.w)) {
        break label445;
      }
      this.C.setVisibility(0);
      this.D.setVisibility(0);
      this.c.setText(this.w);
      label269:
      if (this.x == null) {
        break label466;
      }
      this.E.setVisibility(8);
      this.F.setVisibility(8);
      label294:
      if (ae.isNull(this.y)) {
        break label487;
      }
      this.G.setVisibility(0);
      this.H.setVisibility(0);
      this.e.setText(this.y + "元");
      label350:
      if ((ae.isNull(this.z)) || ("0".equals(this.z))) {
        break label508;
      }
      this.I.setVisibility(0);
      this.J.setVisibility(0);
      this.f.setText(this.z + "元");
    }
    for (;;)
    {
      f();
      return;
      this.A.setVisibility(8);
      this.B.setVisibility(8);
      break;
      label445:
      this.C.setVisibility(8);
      this.D.setVisibility(8);
      break label269;
      label466:
      this.E.setVisibility(8);
      this.F.setVisibility(8);
      break label294;
      label487:
      this.G.setVisibility(8);
      this.H.setVisibility(8);
      break label350;
      label508:
      this.I.setVisibility(8);
      this.J.setVisibility(8);
    }
  }
  
  private void f()
  {
    SpannableString localSpannableString = new SpannableString("购卡请阅读《自如保洁卡会员协议》");
    a(localSpannableString, "《自如保洁卡会员协议》", "购卡请阅读《自如保洁卡会员协议》".indexOf("《自如保洁卡会员协议》"));
    this.r.setText(localSpannableString);
    this.r.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void g()
  {
    String str = VdsAgent.trackEditTextSilent(this.g).toString();
    if ((!TextUtils.isEmpty(str)) && (!Pattern.compile("^[a-z0-9A-Z]{1,11}$").matcher(str).matches()))
    {
      g.textToast(getApplicationContext(), "请填写正确的推荐码");
      return;
    }
    this.t = ApplicationEx.c.getUser();
    if (this.t != null)
    {
      n.buyCleanStoredCard(this, this.u, this.t.getUid(), this.t.getPhone(), this.t.getRealName(), str, new a(), true);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
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
      finish();
      return;
    }
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903153);
    a();
    b();
    e();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    if (paramInt2 / 100.0F > 0.85D)
    {
      this.N.setVisibility(0);
      return;
    }
    this.N.setVisibility(8);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.d("CleanStoredCardPayActivity", "====" + com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((BuyCard)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), BuyCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (BuyCard)paramk.getObject();
        if ((CleanStoredCardPayActivity.a(CleanStoredCardPayActivity.this) != null) && (paramk != null))
        {
          l = Long.parseLong(paramk.getPayAmount());
          n.requestServicePayment(CleanStoredCardPayActivity.this, CleanStoredCardPayActivity.a(CleanStoredCardPayActivity.this).getUid(), paramk.getOrderNumber(), 1, 3, l, null, null, new d(CleanStoredCardPayActivity.this, new f(bc.class))
          {
            public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymousbc);
              com.ziroom.ziroomcustomer.payment.a.startPayActivty(CleanStoredCardPayActivity.this, paramAnonymousbc.getAmount(), "ChuzhiCard", paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId(), paramAnonymousbc.getTimeInterval().toString());
            }
          });
        }
      }
      while (TextUtils.isEmpty(paramk.getMessage()))
      {
        long l;
        return;
      }
      g.textToast(CleanStoredCardPayActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanStoredCardPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */