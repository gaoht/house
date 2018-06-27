package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.b.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CanBuyCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.LeftMoney;
import com.ziroom.ziroomcustomer.util.u;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CleanStoredCardBuyActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private b A;
  private int B;
  private String C;
  private LinearLayout D;
  private View E;
  private LinearLayout F;
  private RelativeLayout G;
  private ImageView H;
  private RelativeLayout I;
  private ImageView J;
  private String K;
  private List<CanBuyCard> L = new ArrayList();
  private String M;
  private i.a N = new i.a()
  {
    public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
    {
      u.d("CleanStoredCardBuyActivity", "====" + com.ziroom.ziroomcustomer.util.k.decrypt(paramAnonymousString));
      paramAnonymousString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramAnonymousString));
      String str = (String)paramAnonymousString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramAnonymousString.get("data") != null) {
          paramAnonymousk.setObject(com.alibaba.fastjson.a.parseArray(paramAnonymousString.get("data").toString(), CanBuyCard.class));
        }
        paramAnonymousk.setSuccess(Boolean.valueOf(true));
        return;
      }
      if ("2".equals(str))
      {
        paramAnonymousk.setMessage((String)paramAnonymousString.get("message"));
        paramAnonymousk.setSuccess(Boolean.valueOf(false));
        paramAnonymousk.setCode("2");
        return;
      }
      paramAnonymousk.setMessage((String)paramAnonymousString.get("message"));
      paramAnonymousk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
    {
      if (paramAnonymousk.getSuccess().booleanValue())
      {
        CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this, (List)paramAnonymousk.getObject());
        if ((CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this) != null) && (CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this).size() > 0))
        {
          CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this, new b(CleanStoredCardBuyActivity.b(CleanStoredCardBuyActivity.this), CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this)));
          CleanStoredCardBuyActivity.d(CleanStoredCardBuyActivity.this).setAdapter(CleanStoredCardBuyActivity.c(CleanStoredCardBuyActivity.this));
          CleanStoredCardBuyActivity.e(CleanStoredCardBuyActivity.this);
        }
        return;
      }
      CleanStoredCardBuyActivity.f(CleanStoredCardBuyActivity.this).setVisibility(0);
      CleanStoredCardBuyActivity.g(CleanStoredCardBuyActivity.this).setVisibility(0);
      CleanStoredCardBuyActivity.this.showEmpty(CleanStoredCardBuyActivity.g(CleanStoredCardBuyActivity.this), "服务异常");
      CleanStoredCardBuyActivity.d(CleanStoredCardBuyActivity.this).setVisibility(8);
      if ("2".equals(paramAnonymousk.getCode()))
      {
        paramAnonymousk = paramAnonymousk.getMessage();
        e.newBuilder(CleanStoredCardBuyActivity.b(CleanStoredCardBuyActivity.this)).setTitle("提示").setButtonText("我知道了").setContent(paramAnonymousk).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            CleanStoredCardBuyActivity.this.finish();
          }
        }).build().show();
        return;
      }
      g.textToast(CleanStoredCardBuyActivity.this, "服务异常");
    }
  };
  private int O = 111;
  private BroadcastReceiver P = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      if (i == 17) {
        CleanStoredCardBuyActivity.j(CleanStoredCardBuyActivity.this);
      }
      if (i == 19)
      {
        CleanStoredCardBuyActivity.k(CleanStoredCardBuyActivity.this);
        CleanStoredCardBuyActivity.l(CleanStoredCardBuyActivity.this);
      }
      if (paramAnonymousIntent.getAction().equals("refresh_card"))
      {
        if ((!TextUtils.isEmpty(CleanStoredCardBuyActivity.m(CleanStoredCardBuyActivity.this))) && ("clean_pay".equals(CleanStoredCardBuyActivity.m(CleanStoredCardBuyActivity.this)))) {
          CleanStoredCardBuyActivity.this.finish();
        }
      }
      else {
        return;
      }
      CleanStoredCardBuyActivity.k(CleanStoredCardBuyActivity.this);
      CleanStoredCardBuyActivity.l(CleanStoredCardBuyActivity.this);
    }
  };
  private ImageView a;
  private TextView b;
  private Button c;
  private ImageView d;
  private TextView e;
  private LinearLayout f;
  private ListView g;
  private boolean r;
  private Context s;
  private RelativeLayout t;
  private TextView u;
  private ImageView v;
  private View w;
  private String x;
  private final String y = "CleanStoredCardBuyActivity";
  private LeftMoney z;
  
  private void a()
  {
    this.s = this;
    this.G = ((RelativeLayout)findViewById(2131690221));
    this.F = ((LinearLayout)findViewById(2131690223));
    this.H = ((ImageView)findViewById(2131690222));
    this.D = ((LinearLayout)findViewById(2131690224));
    this.E = findViewById(2131690238);
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((TextView)findViewById(2131690225));
    this.c = ((Button)findViewById(2131690226));
    this.d = ((ImageView)findViewById(2131690227));
    this.e = ((TextView)findViewById(2131690228));
    this.t = ((RelativeLayout)findViewById(2131690229));
    this.u = ((TextView)findViewById(2131690230));
    this.v = ((ImageView)findViewById(2131690231));
    this.w = findViewById(2131690232);
    this.g = ((ListView)findViewById(2131690237));
    this.f = ((LinearLayout)findViewById(2131690219));
    this.I = ((RelativeLayout)findViewById(2131690234));
    this.J = ((ImageView)findViewById(2131690236));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
  }
  
  private void e()
  {
    f();
    this.K = getIntent().getStringExtra("type");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.commonlibrary.login.broadcast");
    localIntentFilter.addAction("refresh_card");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.P, localIntentFilter);
  }
  
  private void f()
  {
    if (!com.ziroom.ziroomcustomer.bestgoods.c.c.isNetworkConnected(this.s))
    {
      this.G.setVisibility(0);
      this.F.setVisibility(0);
      showEmpty(this.F, "网络异常，请稍后重试");
      g.textToast(this.s, "网络异常，请稍后重试");
      return;
    }
    this.r = ApplicationEx.c.isLoginState();
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {}
    for (this.x = localUserInfo.getUid(); !this.r; this.x = "")
    {
      this.c.setText("登录");
      this.c.setTextSize(16.0F);
      this.c.setTextColor(Color.parseColor("#FFA000"));
      this.e.setText("登录后可查看余额");
      this.t.setVisibility(8);
      g();
      return;
    }
    j();
    g();
  }
  
  private void g()
  {
    n.getCanBuyCleanStoredCard(this, this.N, this.x, 0);
  }
  
  private void h()
  {
    this.A.setOnclickPositionListener(new b.a()
    {
      public void getClickView(int paramAnonymousInt)
      {
        CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this, paramAnonymousInt);
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(CleanStoredCardBuyActivity.b(CleanStoredCardBuyActivity.this));
          return;
        }
        UserInfo localUserInfo = ApplicationEx.c.getUser();
        if (localUserInfo != null)
        {
          CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this, localUserInfo.getUid());
          CleanStoredCardBuyActivity.b(CleanStoredCardBuyActivity.this, localUserInfo.getPhone());
        }
        while (TextUtils.isEmpty(CleanStoredCardBuyActivity.h(CleanStoredCardBuyActivity.this)))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(CleanStoredCardBuyActivity.b(CleanStoredCardBuyActivity.this)).setTitle("提示").setContent("您的账号还没有绑定手机号，请绑定后再购买或直接使用手机号登录购买").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {
                com.ziroom.commonlibrary.login.a.startBindPhoneActivity(CleanStoredCardBuyActivity.b(CleanStoredCardBuyActivity.this));
              }
            }
          }).build().show();
          return;
          CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this, "");
        }
        CleanStoredCardBuyActivity.i(CleanStoredCardBuyActivity.this);
      }
    });
  }
  
  private void i()
  {
    int i = ((CanBuyCard)this.L.get(this.B)).getCid();
    Intent localIntent = new Intent(this.s, CleanStoredCardPayActivity.class);
    if ((!TextUtils.isEmpty(this.K)) && ("clean_pay".equals(this.K))) {
      localIntent.putExtra("type", "clean_pay");
    }
    for (;;)
    {
      localIntent.putExtra("valueCardTypeId", i);
      localIntent.putExtra("accountName", this.M);
      localIntent.putExtra("storedCardName", ((CanBuyCard)this.L.get(this.B)).getShowName());
      localIntent.putExtra("storedCardValid", ((CanBuyCard)this.L.get(this.B)).getValidMonth());
      localIntent.putExtra("storedCardMoney", Long.parseLong(((CanBuyCard)this.L.get(this.B)).getRechargeAmount()) / 100L + "");
      localIntent.putExtra("storedCardGiveMoney", ((CanBuyCard)this.L.get(this.B)).getGiftCount().longValue() / 100L + "");
      this.s.startActivity(localIntent);
      return;
      localIntent.putExtra("type", "clean_store");
    }
  }
  
  private void j()
  {
    n.getCleanCardLeft(this.s, this.x, new a(), false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == this.O) && (paramInt2 == -1))
    {
      j();
      g();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690222: 
      finish();
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690225: 
      if (!this.r)
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.s);
        return;
      }
      startActivityForResult(new Intent(this.s, CleanActiviteCardActivity.class), this.O);
      return;
    case 2131690226: 
      if (!this.r)
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.s);
        return;
      }
      startActivity(new Intent(this, CleanCardListActivity.class));
      return;
    case 2131690227: 
      startActivity(new Intent(this, CleanCardListActivity.class));
      return;
    case 2131690231: 
      this.t.setVisibility(8);
      this.w.setVisibility(8);
      return;
    case 2131690219: 
      startActivity(new Intent(this.s, CleanGiftCardActivity.class));
      return;
    }
    startActivity(new Intent(this, CleanStoredCardBuyHalfPennyActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903138);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.P);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", "=======  " + com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((LeftMoney)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), LeftMoney.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        CleanStoredCardBuyActivity.a(CleanStoredCardBuyActivity.this, (LeftMoney)paramk.getObject());
        if (CleanStoredCardBuyActivity.n(CleanStoredCardBuyActivity.this) != null)
        {
          float f = Float.parseFloat(CleanStoredCardBuyActivity.n(CleanStoredCardBuyActivity.this).getAmount()) / 100.0F;
          paramk = new DecimalFormat(",###,##0.00").format(f);
          CleanStoredCardBuyActivity.o(CleanStoredCardBuyActivity.this).setBackgroundResource(2130838183);
          CleanStoredCardBuyActivity.o(CleanStoredCardBuyActivity.this).setTextSize(36.0F);
          Object localObject = new LinearGradient(0.0F, 0.0F, 0.0F, CleanStoredCardBuyActivity.o(CleanStoredCardBuyActivity.this).getPaint().getTextSize(), -1, Color.parseColor("#B3FFFFFF"), Shader.TileMode.CLAMP);
          CleanStoredCardBuyActivity.o(CleanStoredCardBuyActivity.this).getPaint().setShader((Shader)localObject);
          localObject = new SpannableString(paramk);
          ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, paramk.length(), 33);
          CleanStoredCardBuyActivity.o(CleanStoredCardBuyActivity.this).setText((CharSequence)localObject);
          CleanStoredCardBuyActivity.p(CleanStoredCardBuyActivity.this).setText("当前余额");
          CleanStoredCardBuyActivity.q(CleanStoredCardBuyActivity.this).setVisibility(0);
          paramk = CleanStoredCardBuyActivity.n(CleanStoredCardBuyActivity.this).getWillExpireAmount();
          localObject = new DecimalFormat("0");
          if (paramk != null) {
            CleanStoredCardBuyActivity.c(CleanStoredCardBuyActivity.this, ((DecimalFormat)localObject).format(paramk.longValue() / 100L));
          }
          paramk = CleanStoredCardBuyActivity.n(CleanStoredCardBuyActivity.this).getWillExpireTime();
          if (!TextUtils.isEmpty(paramk))
          {
            CleanStoredCardBuyActivity.r(CleanStoredCardBuyActivity.this).setVisibility(8);
            CleanStoredCardBuyActivity.s(CleanStoredCardBuyActivity.this).setVisibility(8);
            CleanStoredCardBuyActivity.u(CleanStoredCardBuyActivity.this).setText("您有" + CleanStoredCardBuyActivity.t(CleanStoredCardBuyActivity.this) + "元余额即将在" + paramk + "过期，请及时使用。");
          }
        }
        else
        {
          return;
        }
        CleanStoredCardBuyActivity.r(CleanStoredCardBuyActivity.this).setVisibility(8);
        CleanStoredCardBuyActivity.s(CleanStoredCardBuyActivity.this).setVisibility(8);
        return;
      }
      CleanStoredCardBuyActivity.f(CleanStoredCardBuyActivity.this).setVisibility(0);
      CleanStoredCardBuyActivity.g(CleanStoredCardBuyActivity.this).setVisibility(0);
      CleanStoredCardBuyActivity.this.showEmpty(CleanStoredCardBuyActivity.g(CleanStoredCardBuyActivity.this), paramk.getMessage());
      CleanStoredCardBuyActivity.d(CleanStoredCardBuyActivity.this).setVisibility(8);
      g.textToast(CleanStoredCardBuyActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanStoredCardBuyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */