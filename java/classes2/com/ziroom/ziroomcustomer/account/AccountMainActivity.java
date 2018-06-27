package com.ziroom.ziroomcustomer.account;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.account.gift.GiftDialog;
import com.ziroom.ziroomcustomer.account.gift.GiftListActivity;
import com.ziroom.ziroomcustomer.account.model.Balance;
import com.ziroom.ziroomcustomer.account.model.Balance.DataBean;
import com.ziroom.ziroomcustomer.account.model.BindedCard;
import com.ziroom.ziroomcustomer.account.model.BindedCard.DataBean;
import com.ziroom.ziroomcustomer.account.model.Cards;
import com.ziroom.ziroomcustomer.account.model.GiftListBase;
import com.ziroom.ziroomcustomer.account.model.GiftListBase.DataBean;
import com.ziroom.ziroomcustomer.account.model.GiftUnDrawBase;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.CreditsEntity;
import com.ziroom.ziroomcustomer.model.SignedInfo;
import com.ziroom.ziroomcustomer.my.MyCardsActivity;
import com.ziroom.ziroomcustomer.my.MyCouponActivity;
import com.ziroom.ziroomcustomer.my.MyRentCardActivity;
import com.ziroom.ziroomcustomer.payment.activity.BandCardMangeActivity;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.NumberScrollTextView;
import com.ziroom.ziroomcustomer.widget.NumberScrollTextView.a;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMainActivity
  extends BaseActivity
  implements View.OnClickListener, NumberScrollTextView.a, ObservableScrollView.a
{
  private View A;
  private View B;
  private ObservableScrollView C;
  private Cards D;
  private String E;
  private boolean F = true;
  private boolean G = false;
  private boolean H = false;
  private f<e> I = new f(this.r, new o())
  {
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      paramAnonymouse = (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
      Intent localIntent;
      if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {
        localIntent = new Intent();
      }
      switch (paramAnonymouse.credits.realNameStatus)
      {
      default: 
        return;
      case 2: 
        localIntent.setClass(AccountMainActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", AccountMainActivity.this.g);
        localIntent.putExtra("type", 0);
        AccountMainActivity.this.startActivity(localIntent);
        return;
      case 3: 
        localIntent.setClass(AccountMainActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", AccountMainActivity.this.g);
        localIntent.putExtra("type", 0);
        AccountMainActivity.this.startActivity(localIntent);
        return;
      case 4: 
        localIntent.setClass(AccountMainActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("type", 0);
        localIntent.putExtra("phone", AccountMainActivity.this.g);
        localIntent.putExtra("cert_info", paramAnonymouse);
        AccountMainActivity.this.startActivity(localIntent);
        return;
      case 1: 
        if ("1".equals(paramAnonymouse.getCert_type()))
        {
          localIntent.setClass(AccountMainActivity.this, CertInformationActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", AccountMainActivity.this.g);
          localIntent.putExtra("type", 0);
          AccountMainActivity.this.startActivity(localIntent);
          return;
        }
        localIntent.setClass(AccountMainActivity.this, CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", AccountMainActivity.this.g);
        localIntent.putExtra("type", 0);
        AccountMainActivity.this.startActivity(localIntent);
        return;
      }
      localIntent.setClass(AccountMainActivity.this, CertInformationActivity.class);
      localIntent.putExtra("cert_info", paramAnonymouse);
      localIntent.putExtra("phone", AccountMainActivity.this.g);
      localIntent.putExtra("type", 0);
      AccountMainActivity.this.startActivity(localIntent);
    }
  };
  public RelativeLayout a;
  public RelativeLayout b;
  public RelativeLayout c;
  public RelativeLayout d;
  public RelativeLayout e;
  public RelativeLayout f;
  String g;
  private Context r;
  private NumberScrollTextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private ImageView y;
  private ImageView z;
  
  private void a()
  {
    if (TextUtils.isEmpty(this.E))
    {
      Map localMap = com.ziroom.ziroomcustomer.e.g.buildBalance();
      j.getBalanceSums(this, new b(), localMap, false);
      return;
    }
    this.s.setGravity(16);
    this.s.setFromAndEndNumber(0.0F, Float.parseFloat(this.E));
    this.s.start();
  }
  
  private void a(Class paramClass)
  {
    if (ApplicationEx.c.isLoginState())
    {
      startActivity(new Intent(this, paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void b()
  {
    this.A = findViewById(2131689773);
    this.B = findViewById(2131689769);
    this.w = ((TextView)findViewById(2131689771));
    this.x = ((TextView)findViewById(2131689772));
    this.f = ((RelativeLayout)findViewById(2131689768));
    this.C = ((ObservableScrollView)findViewById(2131689749));
    this.a = ((RelativeLayout)findViewById(2131689755));
    this.b = ((RelativeLayout)findViewById(2131689764));
    this.v = ((TextView)findViewById(2131689766));
    this.s = ((NumberScrollTextView)findViewById(2131689753));
    this.u = ((TextView)findViewById(2131689754));
    this.t = ((TextView)findViewById(2131689772));
    this.y = ((ImageView)findViewById(2131689770));
    this.z = ((ImageView)findViewById(2131689767));
    this.E = getIntent().getStringExtra("balance_sums");
    this.c = ((RelativeLayout)findViewById(2131689758));
    this.d = ((RelativeLayout)findViewById(2131689760));
    this.e = ((RelativeLayout)findViewById(2131689762));
    e();
    f();
  }
  
  private void e()
  {
    this.y.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.s.setOnEndListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.C.setOnScrollChangedCallback(this);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getGifListResult(this, new i(this, new com.ziroom.ziroomcustomer.payment.d.a(GiftListBase.class))
    {
      public void onSuccess(int paramAnonymousInt, GiftListBase paramAnonymousGiftListBase)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousGiftListBase);
        paramAnonymousInt = paramAnonymousGiftListBase.getData().getUndrawCount();
        GiftDialog localGiftDialog;
        FragmentManager localFragmentManager;
        if (paramAnonymousInt != 0)
        {
          AccountMainActivity.a(AccountMainActivity.this).setText(paramAnonymousInt + "个红包未领取");
          localGiftDialog = new GiftDialog(AccountMainActivity.this, (GiftUnDrawBase)paramAnonymousGiftListBase.getData().getUndraws().get(0));
          localFragmentManager = AccountMainActivity.this.getSupportFragmentManager();
          if (!(localGiftDialog instanceof DialogFragment)) {
            localGiftDialog.show(localFragmentManager, null);
          }
        }
        while (paramAnonymousGiftListBase.getData().getDraws().size() + paramAnonymousInt > 0)
        {
          AccountMainActivity.this.b.setOnClickListener(AccountMainActivity.this);
          AccountMainActivity.b(AccountMainActivity.this).setVisibility(0);
          return;
          VdsAgent.showDialogFragment((DialogFragment)localGiftDialog, localFragmentManager, null);
          continue;
          AccountMainActivity.a(AccountMainActivity.this).setText("无未领取红包");
        }
        AccountMainActivity.this.b.setOnClickListener(null);
        AccountMainActivity.b(AccountMainActivity.this).setVisibility(8);
      }
    });
  }
  
  private void g()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.r).setTitle("提示").setBtnConfirmText("去绑定").setContent("使用提现功能需添加一张支持提现的储蓄卡").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          AccountMainActivity.this.getData("");
        }
      }
    }).build().show();
  }
  
  public void doAuthenticate(String paramString)
  {
    j.getCertInfo(this.r, com.ziroom.commonlibrary.login.a.getToken(this.r), 1, this.I);
  }
  
  public void doSign()
  {
    com.ziroom.commonlibrary.login.a.getUserInfo(this.r, new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        AccountMainActivity.this.g = ((String)paramAnonymouse.get("phone"));
        if (!TextUtils.isEmpty(AccountMainActivity.this.g))
        {
          AccountMainActivity.this.doAuthenticate(AccountMainActivity.this.g);
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(AccountMainActivity.c(AccountMainActivity.this));
      }
    });
  }
  
  public void getData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("is_newsign", "0");
    localHashMap.put("cert_type", paramString + "");
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.get(q.O + e.n.p).tag(this).params(com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap)).addHeader("Accept", "application/json; version=1").enqueue(new com.ziroom.commonlibrary.a.a(this.r, new com.freelxl.baselibrary.d.f.c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        dismissProgress();
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = paramAnonymouse.get("data").toString();
          if ((ae.notNull(paramAnonymouse)) && (paramAnonymouse.length() > 5))
          {
            paramAnonymouse = (SignedInfo)com.alibaba.fastjson.a.parseObject(paramAnonymouse, SignedInfo.class);
            if (paramAnonymouse.getCredits().getRealNameStatus() == 4)
            {
              Intent localIntent = new Intent(AccountMainActivity.this, BankcardDetailActivity.class);
              localIntent.putExtra("name", paramAnonymouse.getReal_name());
              AccountMainActivity.this.startActivity(localIntent);
              return;
            }
            AccountMainActivity.this.doSign();
            return;
          }
          AccountMainActivity.this.doSign();
          return;
        }
        AccountMainActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100) {
      this.F = false;
    }
    do
    {
      return;
      if (paramInt1 == 101)
      {
        this.G = true;
        this.F = false;
        return;
      }
      if ((paramInt1 == 102) || (paramInt1 == 103))
      {
        f();
        return;
      }
    } while (paramInt1 != 104);
    this.F = true;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(MyCardsActivity.class);
      return;
      a(MyCouponActivity.class);
      return;
      a(MyRentCardActivity.class);
      return;
      finish();
      return;
      startActivityForResult(new Intent(this, AccountDetailsActivity.class), 100);
      return;
      getData("");
      startActivityForResult(new Intent(this, BandCardMangeActivity.class), 104);
      return;
      startActivityForResult(new Intent(this, GiftListActivity.class), 102);
      return;
      if (!this.H) {
        break;
      }
    } while (TextUtils.isEmpty(this.E));
    if (Float.valueOf(this.E).floatValue() > 0.0F)
    {
      paramView = new Intent(this, WithdrawActivity.class);
      paramView.putExtra("cardName", this.D.name);
      paramView.putExtra("cardNum", this.D.cardNum);
      paramView.putExtra("cardPicUrl", this.D.picUrl);
      paramView.putExtra("balance", this.E);
      startActivityForResult(paramView, 101);
      overridePendingTransition(2130968673, 2130968678);
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(this, "余额不足");
    return;
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903070);
    this.r = this;
    b();
    a();
  }
  
  public void onEndFinish()
  {
    if (this.E != null) {
      this.s.setText(this.E);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Map localMap;
    if (this.G)
    {
      localMap = com.ziroom.ziroomcustomer.e.g.buildBalance();
      j.getBalanceSums(this, new b(), localMap, false);
    }
    if (this.F)
    {
      localMap = com.ziroom.ziroomcustomer.e.g.buildBalance();
      j.getAccountCards(this, new a(), localMap, true);
    }
    this.F = true;
    this.G = false;
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / n.dip2px(this.r, 100.0F);
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.A.setAlpha(f1);
      this.B.setAlpha(f1);
      if (f1 > 0.6D)
      {
        this.y.setImageResource(2130840141);
        this.w.setTextColor(Color.parseColor("#444444"));
        this.x.setTextColor(Color.parseColor("#444444"));
        return;
      }
      this.y.setImageResource(2130840142);
      this.w.setTextColor(Color.parseColor("#ffffff"));
      this.x.setTextColor(Color.parseColor("#ffffff"));
      return;
      f1 = f2;
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (BindedCard)paramk.getObject();
        if (paramk.getData() != null)
        {
          AccountMainActivity.a(AccountMainActivity.this, new Cards());
          AccountMainActivity.g(AccountMainActivity.this).name = paramk.getData().getBankName();
          AccountMainActivity.g(AccountMainActivity.this).cardNum = paramk.getData().getBankCardNo();
          AccountMainActivity.g(AccountMainActivity.this).picUrl = paramk.getData().getAppUrl();
          AccountMainActivity.a(AccountMainActivity.this, true);
          return;
        }
        AccountMainActivity.a(AccountMainActivity.this, false);
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(AccountMainActivity.this, paramk.getMessage());
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (Balance)paramk.getObject();
        if (paramk.getData() != null)
        {
          AccountMainActivity.a(AccountMainActivity.this, paramk.getData().getBalance());
          if ((TextUtils.isEmpty(AccountMainActivity.d(AccountMainActivity.this))) || ("0.00".equals(AccountMainActivity.d(AccountMainActivity.this))))
          {
            AccountMainActivity.e(AccountMainActivity.this).setText("0.00");
            AccountMainActivity.f(AccountMainActivity.this).setOnClickListener(null);
            AccountMainActivity.f(AccountMainActivity.this).setAlpha(0.5F);
            return;
          }
          AccountMainActivity.f(AccountMainActivity.this).setOnClickListener(AccountMainActivity.this);
          AccountMainActivity.f(AccountMainActivity.this).setAlpha(1.0F);
          AccountMainActivity.e(AccountMainActivity.this).setFromAndEndNumber(0.0F, Float.parseFloat(AccountMainActivity.d(AccountMainActivity.this)));
          AccountMainActivity.e(AccountMainActivity.this).start();
          return;
        }
        AccountMainActivity.e(AccountMainActivity.this).setText("0.00");
        AccountMainActivity.f(AccountMainActivity.this).setOnClickListener(null);
        AccountMainActivity.f(AccountMainActivity.this).setAlpha(0.5F);
        return;
      }
      AccountMainActivity.e(AccountMainActivity.this).setText("0.00");
      AccountMainActivity.f(AccountMainActivity.this).setOnClickListener(null);
      AccountMainActivity.f(AccountMainActivity.this).setAlpha(0.5F);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/AccountMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */