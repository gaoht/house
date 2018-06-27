package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.payment.a.b.a;
import com.ziroom.ziroomcustomer.payment.b.k;
import com.ziroom.ziroomcustomer.payment.b.m;
import com.ziroom.ziroomcustomer.payment.b.q;
import com.ziroom.ziroomcustomer.payment.b.r;
import com.ziroom.ziroomcustomer.payment.b.s;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaymentActivity
  extends PayBaseActivity
{
  private m A;
  private ArrayList<com.ziroom.ziroomcustomer.payment.b.c> B = new ArrayList();
  private List<com.ziroom.ziroomcustomer.payment.b.d> C = new ArrayList();
  private String D = null;
  private int E = 0;
  private String F;
  private String G;
  @BindView(2131690461)
  Button btnPay;
  @BindView(2131692060)
  CheckBox checkAccount;
  @BindView(2131692054)
  CheckBox checkValuecard;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131692053)
  ImageView ivBuy;
  @BindView(2131691846)
  LinearLayout llAccount;
  @BindView(2131692056)
  LinearLayout llCards;
  @BindView(2131692049)
  LinearLayout llLastTime;
  @BindView(2131692062)
  ListViewForScrollView payList;
  int r = 0;
  @BindView(2131692050)
  RelativeLayout rlValuecard;
  int s = 0;
  @BindView(2131689506)
  ScrollView scrollview;
  int t = 0;
  @BindView(2131692059)
  TextView tvAccountMoney;
  @BindView(2131692057)
  TextView tvCardsContent;
  @BindView(2131691194)
  TextView tvLastTime;
  @BindView(2131689846)
  TextView tvMoney;
  @BindView(2131692061)
  TextView tvSelectPayway;
  @BindView(2131692052)
  TextView tvValuecardBuy;
  @BindView(2131692051)
  TextView tvValuecardMoney;
  int u = 0;
  Handler v = new Handler();
  @BindView(2131690343)
  View vAccount;
  @BindView(2131692058)
  View vCards;
  @BindView(2131692055)
  View vValuecard;
  Runnable w = new Runnable()
  {
    public void run()
    {
      PaymentActivity.a(PaymentActivity.this, PaymentActivity.f(PaymentActivity.this) - 1);
      if (PaymentActivity.f(PaymentActivity.this) >= 0)
      {
        if (PaymentActivity.f(PaymentActivity.this) > 3600) {
          PaymentActivity.this.tvLastTime.setText(PaymentActivity.a(PaymentActivity.this, new StringBuilder().append("").append(PaymentActivity.f(PaymentActivity.this) / 3600).toString()) + ":" + PaymentActivity.a(PaymentActivity.this, new StringBuilder().append("").append(PaymentActivity.f(PaymentActivity.this) % 3600 / 60).toString()) + ":" + PaymentActivity.a(PaymentActivity.this, new StringBuilder().append("").append(PaymentActivity.f(PaymentActivity.this) % 60).toString()));
        }
        for (;;)
        {
          PaymentActivity.this.v.postDelayed(this, 1000L);
          return;
          PaymentActivity.this.tvLastTime.setText(PaymentActivity.a(PaymentActivity.this, new StringBuilder().append("").append(PaymentActivity.f(PaymentActivity.this) / 60).toString()) + ":" + PaymentActivity.a(PaymentActivity.this, new StringBuilder().append("").append(PaymentActivity.f(PaymentActivity.this) % 60).toString()));
        }
      }
      PaymentActivity.this.btnPay.setText("支付超时");
      PaymentActivity.this.btnPay.setEnabled(false);
      PaymentActivity.b(PaymentActivity.this, "支付订单已超时");
    }
  };
  com.ziroom.ziroomcustomer.dialog.c x;
  private com.ziroom.ziroomcustomer.payment.a.b y;
  private com.ziroom.ziroomcustomer.payment.b.n z;
  
  private List<com.ziroom.ziroomcustomer.payment.b.n> a(List<com.ziroom.ziroomcustomer.payment.b.n> paramList, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.payment.b.n localn = (com.ziroom.ziroomcustomer.payment.b.n)localIterator.next();
      if ((localn.getLimit() <= paramInt) && (localn.getLimit() != -1)) {
        localArrayList1.add(localn);
      } else {
        localArrayList2.add(localn);
      }
    }
    if (localArrayList1.size() == 0) {
      return paramList;
    }
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  private void b(int paramInt)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getSinglePayWayType(this, paramInt, this.G, this.F, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(com.ziroom.ziroomcustomer.payment.b.n.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.payment.b.n paramAnonymousn)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousn);
        List localList = PaymentActivity.d(PaymentActivity.this).getmList();
        paramAnonymousInt = 0;
        for (;;)
        {
          if (paramAnonymousInt < localList.size())
          {
            com.ziroom.ziroomcustomer.payment.b.n localn = (com.ziroom.ziroomcustomer.payment.b.n)localList.get(paramAnonymousInt);
            if (localn.getPayChanel() == paramAnonymousn.getPayChanel()) {
              localList.remove(localn);
            }
          }
          else
          {
            localList.add(paramAnonymousInt, paramAnonymousn);
            PaymentActivity.a(PaymentActivity.this, paramAnonymousn);
            PaymentActivity.b(PaymentActivity.this, paramAnonymousInt);
            return;
          }
          paramAnonymousInt += 1;
        }
      }
    });
  }
  
  private void c(int paramInt)
  {
    int i = this.payList.getFirstVisiblePosition();
    int j = this.payList.getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = this.payList.getChildAt(paramInt - i);
      this.y.getView(paramInt, localView, this.payList);
    }
  }
  
  private void d(String paramString)
  {
    this.x = com.ziroom.ziroomcustomer.dialog.c.newBuilder(this).setContent(paramString).setButtonText("确定").setCanceledOnBackPressed(false).setOnButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PaymentActivity.this.x.dismiss();
        PaymentActivity.this.g.sendEmptyMessage(3);
      }
    }).build();
    this.x.show();
  }
  
  private String e(String paramString)
  {
    if (paramString.length() == 2) {
      return paramString;
    }
    return "0" + paramString;
  }
  
  private void e()
  {
    boolean bool2 = true;
    int j = 0;
    this.c = getIntent().getStringExtra("payType");
    this.F = getIntent().getStringExtra("cwOrderIds");
    this.G = getIntent().getStringExtra("systemId");
    this.D = getIntent().getStringExtra("time");
    this.r = getIntent().getIntExtra("payMoney", 0);
    this.y = new com.ziroom.ziroomcustomer.payment.a.b(this);
    this.payList.setAdapter(this.y);
    if ("0".equals(this.D)) {
      this.D = null;
    }
    if (f.notNull(this.D)) {
      f();
    }
    for (;;)
    {
      this.A = ((m)com.alibaba.fastjson.a.parseObject(getIntent().getStringExtra("PayMesssageBean"), m.class));
      if (this.A != null) {
        break;
      }
      return;
      this.llLastTime.setVisibility(8);
    }
    this.scrollview.setVisibility(0);
    this.btnPay.setVisibility(0);
    this.tvMoney.setText("¥" + ah.Number(this.r / 100.0F));
    g();
    this.tvAccountMoney.setText("可用账户余额¥" + ah.Number(this.A.getBalance() / 100.0F));
    this.ivBack.setFocusable(true);
    this.ivBack.setFocusableInTouchMode(true);
    this.t = 0;
    this.checkAccount.setChecked(false);
    Object localObject = this.checkAccount;
    boolean bool1;
    int i;
    if (this.A.getBalance() != 0)
    {
      bool1 = true;
      ((CheckBox)localObject).setEnabled(bool1);
      this.y.setmList(this.A.getPayTypes());
      if (this.A.getIsAccount() != 0) {
        break label546;
      }
      this.vAccount.setVisibility(0);
      this.llAccount.setVisibility(0);
      this.checkAccount.setChecked(this.checkAccount.isEnabled());
      if (this.A != null) {
        break label535;
      }
      i = 0;
      label389:
      this.t = i;
    }
    for (;;)
    {
      label394:
      if (this.A.getIsCard() == 0)
      {
        this.vCards.setVisibility(0);
        this.llCards.setVisibility(0);
        this.B.clear();
        localObject = this.A.getCoupons().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            com.ziroom.ziroomcustomer.payment.b.d locald = (com.ziroom.ziroomcustomer.payment.b.d)((Iterator)localObject).next();
            Iterator localIterator = locald.getCards().iterator();
            while (localIterator.hasNext())
            {
              com.ziroom.ziroomcustomer.payment.b.c localc = (com.ziroom.ziroomcustomer.payment.b.c)localIterator.next();
              localc.setParentName(locald.getName());
              localc.setParentType(locald.getOrderType());
              this.B.add(localc);
            }
            continue;
            bool1 = false;
            break;
            label535:
            i = this.A.getBalance();
            break label389;
            label546:
            this.vAccount.setVisibility(8);
            this.llAccount.setVisibility(8);
            break label394;
          }
        }
        this.s = 0;
        this.C.clear();
        if (this.B.size() == 0)
        {
          this.tvCardsContent.setText("无可用卡券");
          if ((this.A.getIsValueCard() != 0) || (this.A.getValueCard() == null)) {
            break label914;
          }
          this.vValuecard.setVisibility(0);
          this.rlValuecard.setVisibility(0);
          if (!"100011".equals(this.G)) {
            break label874;
          }
          localObject = "可用保洁卡余额¥";
          label655:
          this.tvValuecardMoney.setText((String)localObject + ah.Number(this.A.getValueCard().getAmount() / 100.0F));
          localObject = this.checkValuecard;
          if (this.A.getValueCard().getAmount() == 0) {
            break label882;
          }
          bool1 = bool2;
          label720:
          ((CheckBox)localObject).setEnabled(bool1);
          if (!f.notNull(this.A.getValueCard().getPromotionReminderDocument())) {
            break label887;
          }
          this.tvValuecardBuy.setText(this.A.getValueCard().getPromotionReminderDocument() + ",去购买");
          label778:
          this.checkValuecard.setChecked(this.checkValuecard.isEnabled());
          if (this.A != null) {
            break label900;
          }
          i = j;
          label801:
          this.u = i;
        }
      }
    }
    for (;;)
    {
      h();
      return;
      this.tvCardsContent.setText("可用卡券" + this.B.size() + "张");
      break;
      this.vCards.setVisibility(8);
      this.llCards.setVisibility(8);
      break;
      label874:
      localObject = "可用储值卡余额¥";
      break label655;
      label882:
      bool1 = false;
      break label720;
      label887:
      this.tvValuecardBuy.setText("去购买");
      break label778;
      label900:
      i = this.A.getValueCard().getAmount();
      break label801;
      label914:
      this.vValuecard.setVisibility(8);
      this.rlValuecard.setVisibility(8);
    }
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.n.getSystemTime(this, new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        u.d("sdjgkldsjg", "=====   " + com.alibaba.fastjson.a.toJSONString(paramAnonymousString));
        try
        {
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            long l = Long.parseLong(paramAnonymousString) - System.currentTimeMillis();
            u.d("aaa", "=======   timeDiff:" + l);
            ad.saveGateWayDiffTime(PaymentActivity.this, l);
            l = Long.parseLong(PaymentActivity.a(PaymentActivity.this));
            PaymentActivity.a(PaymentActivity.this, (int)((Long.valueOf(l).longValue() - Long.parseLong(paramAnonymousString)) / 1000L));
            PaymentActivity.this.llLastTime.setVisibility(0);
            PaymentActivity.this.v.post(PaymentActivity.this.w);
          }
          return;
        }
        catch (Exception paramAnonymousString)
        {
          paramAnonymousString.printStackTrace();
        }
      }
    });
  }
  
  private void g()
  {
    this.y.setmPayType(new b.a()
    {
      public void setPayType(com.ziroom.ziroomcustomer.payment.b.n paramAnonymousn)
      {
        PaymentActivity.a(PaymentActivity.this, paramAnonymousn);
        PaymentActivity.b(PaymentActivity.this);
      }
    });
    this.checkAccount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        int j = 0;
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        PaymentActivity.this.ivBack.setFocusable(true);
        PaymentActivity.this.ivBack.setFocusableInTouchMode(true);
        paramAnonymousCompoundButton = PaymentActivity.this;
        int i = j;
        if (paramAnonymousBoolean) {
          if (PaymentActivity.c(PaymentActivity.this) != null) {
            break label69;
          }
        }
        label69:
        for (i = j;; i = PaymentActivity.c(PaymentActivity.this).getBalance())
        {
          paramAnonymousCompoundButton.t = i;
          PaymentActivity.b(PaymentActivity.this);
          return;
        }
      }
    });
    this.checkValuecard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        int j = 0;
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        PaymentActivity.this.ivBack.setFocusable(true);
        PaymentActivity.this.ivBack.setFocusableInTouchMode(true);
        if (!paramAnonymousBoolean)
        {
          paramAnonymousCompoundButton = PaymentActivity.this.checkAccount;
          if (PaymentActivity.c(PaymentActivity.this).getBalance() != 0) {
            paramAnonymousCompoundButton.setEnabled(bool);
          }
        }
        else
        {
          paramAnonymousCompoundButton = PaymentActivity.this;
          i = j;
          if (paramAnonymousBoolean) {
            if (PaymentActivity.c(PaymentActivity.this) != null) {
              break label109;
            }
          }
        }
        label109:
        for (int i = j;; i = PaymentActivity.c(PaymentActivity.this).getValueCard().getAmount())
        {
          paramAnonymousCompoundButton.u = i;
          PaymentActivity.b(PaymentActivity.this);
          return;
          bool = false;
          break;
        }
      }
    });
  }
  
  private void h()
  {
    boolean bool = false;
    if (this.s >= this.r)
    {
      this.checkAccount.setChecked(false);
      this.t = 0;
      this.y.setShowCheck(Boolean.valueOf(false));
      this.btnPay.setEnabled(true);
      this.btnPay.setText("确认支付");
    }
    for (;;)
    {
      this.ivBack.setFocusable(true);
      this.ivBack.setFocusableInTouchMode(true);
      return;
      if (this.s + this.u >= this.r)
      {
        this.checkValuecard.setChecked(true);
        this.u = (this.r - this.s);
        this.checkAccount.setChecked(false);
        this.checkAccount.setEnabled(false);
        this.y.setShowCheck(Boolean.valueOf(false));
        this.btnPay.setEnabled(true);
        this.btnPay.setText("确认支付¥" + ah.Number(this.u / 100.0F));
      }
      else if (this.s + this.t >= this.r)
      {
        this.checkAccount.setChecked(true);
        this.t = (this.r - this.s - this.u);
        this.y.setShowCheck(Boolean.valueOf(false));
        this.btnPay.setEnabled(true);
        this.btnPay.setText("确认支付¥" + ah.Number((this.u + this.t) / 100.0F));
      }
      else if (this.s + this.u + this.t >= this.r)
      {
        this.checkValuecard.setChecked(true);
        this.checkAccount.setChecked(true);
        this.t = (this.r - this.s - this.u);
        this.y.setShowCheck(Boolean.valueOf(false));
        this.btnPay.setEnabled(true);
        this.btnPay.setText("确认支付¥" + ah.Number((this.u + this.t) / 100.0F));
      }
      else
      {
        if (this.A != null)
        {
          this.y.setmListAndMaxMoney(a(this.A.getPayTypes(), this.r - this.t - this.u - this.s), this.r - this.t - this.u - this.s);
          this.btnPay.setText("去支付¥" + ah.Number((this.r - this.t - this.u - this.s) / 100.0F));
        }
        if (this.z == null) {
          this.btnPay.setText("确认支付");
        }
        Button localButton = this.btnPay;
        if (this.z != null) {
          bool = true;
        }
        localButton.setEnabled(bool);
      }
    }
  }
  
  private void i()
  {
    k localk = new k();
    localk.setCoupons(this.C);
    localk.setCwOrderIds(this.F);
    localk.setTotalFee(this.r);
    localk.setSystemId(this.G);
    localk.setExpiredDate(this.D);
    Object localObject;
    if (this.checkAccount.isChecked())
    {
      localObject = new com.ziroom.ziroomcustomer.payment.b.a();
      ((com.ziroom.ziroomcustomer.payment.b.a)localObject).setActionType(1);
      ((com.ziroom.ziroomcustomer.payment.b.a)localObject).setOrderType(90);
      ((com.ziroom.ziroomcustomer.payment.b.a)localObject).setAmount(this.t);
      localk.setAcountPay((com.ziroom.ziroomcustomer.payment.b.a)localObject);
    }
    if ((this.checkValuecard.isChecked()) && (this.A.getIsValueCard() == 0))
    {
      localObject = new s();
      ((s)localObject).setActionType(1);
      ((s)localObject).setOrderType(99);
      ((s)localObject).setAmount(this.u);
      localk.setStoredValueCard((s)localObject);
    }
    if ((this.y.getShowCheck().booleanValue()) && (this.y.getmList().size() != 0))
    {
      localObject = new com.ziroom.ziroomcustomer.payment.b.e();
      ((com.ziroom.ziroomcustomer.payment.b.e)localObject).setAmount(this.r - this.t - this.u - this.s);
      ((com.ziroom.ziroomcustomer.payment.b.e)localObject).setOrderType(1);
      ((com.ziroom.ziroomcustomer.payment.b.e)localObject).setActionType(1);
      localk.setExternalPay((com.ziroom.ziroomcustomer.payment.b.e)localObject);
      localk.setPayChannel(this.z.getPayChanel());
    }
    if ((!this.y.getShowCheck().booleanValue()) && (this.checkAccount.isChecked())) {
      localk.setPayChannel(90);
    }
    while (localk.getPayChannel() == 0)
    {
      g.textToast(this, "请选择支付方式");
      return;
      if ((!this.y.getShowCheck().booleanValue()) && (this.checkValuecard.isChecked())) {
        localk.setPayChannel(99);
      } else if ((!this.y.getShowCheck().booleanValue()) && (!this.checkAccount.isChecked()) && (this.C.size() > 0)) {
        if (this.C.size() == 1) {
          localk.setPayChannel(((com.ziroom.ziroomcustomer.payment.b.d)this.C.get(0)).getOrderType());
        } else {
          localk.setPayChannel(96);
        }
      }
    }
    a(localk, this.z);
  }
  
  private void j()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getValueCardAccount(this, this.F, this.G, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(q.class))
    {
      public void onSuccess(int paramAnonymousInt, q paramAnonymousq)
      {
        boolean bool2 = true;
        super.onSuccess(paramAnonymousInt, paramAnonymousq);
        Object localObject;
        if (f.notNull(paramAnonymousq.getValueCard().getPromotionReminderDocument()))
        {
          PaymentActivity.this.tvValuecardBuy.setText(paramAnonymousq.getValueCard().getPromotionReminderDocument() + ",去购买");
          if (!"100011".equals(PaymentActivity.e(PaymentActivity.this))) {
            break label450;
          }
          localObject = "可用保洁卡余额¥";
          label76:
          PaymentActivity.this.tvValuecardMoney.setText((String)localObject + ah.Number(paramAnonymousq.getValueCard().getAmount() / 100.0F));
          localObject = PaymentActivity.this.checkValuecard;
          if (paramAnonymousq.getValueCard().getAmount() == 0) {
            break label457;
          }
          bool1 = true;
          label139:
          ((CheckBox)localObject).setEnabled(bool1);
          PaymentActivity.c(PaymentActivity.this).setValueCard(paramAnonymousq.getValueCard());
          PaymentActivity.c(PaymentActivity.this).setBalance(paramAnonymousq.getBalance());
          PaymentActivity.this.tvAccountMoney.setText("可用账户余额¥" + ah.Number(PaymentActivity.c(PaymentActivity.this).getBalance() / 100.0F));
          PaymentActivity.this.ivBack.setFocusable(true);
          PaymentActivity.this.ivBack.setFocusableInTouchMode(true);
          PaymentActivity.this.t = 0;
          if (PaymentActivity.c(PaymentActivity.this).getIsAccount() != 0) {
            break label476;
          }
          PaymentActivity.this.vAccount.setVisibility(0);
          PaymentActivity.this.llAccount.setVisibility(0);
          PaymentActivity.this.checkAccount.setChecked(PaymentActivity.this.checkAccount.isEnabled());
          localObject = PaymentActivity.this;
          if (PaymentActivity.c(PaymentActivity.this) != null) {
            break label462;
          }
          paramAnonymousInt = 0;
          label321:
          ((PaymentActivity)localObject).t = paramAnonymousInt;
          label327:
          PaymentActivity.this.checkValuecard.setChecked(PaymentActivity.this.checkValuecard.isEnabled());
          PaymentActivity.this.u = paramAnonymousq.getValueCard().getAmount();
          paramAnonymousq = PaymentActivity.this.checkAccount;
          if ((PaymentActivity.this.u >= PaymentActivity.this.r) || (PaymentActivity.c(PaymentActivity.this).getBalance() <= 0)) {
            break label503;
          }
        }
        label450:
        label457:
        label462:
        label476:
        label503:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          paramAnonymousq.setEnabled(bool1);
          PaymentActivity.this.checkAccount.setChecked(PaymentActivity.this.checkAccount.isEnabled());
          PaymentActivity.b(PaymentActivity.this);
          return;
          PaymentActivity.this.tvValuecardBuy.setText("去购买");
          break;
          localObject = "可用储值卡余额¥";
          break label76;
          bool1 = false;
          break label139;
          paramAnonymousInt = PaymentActivity.c(PaymentActivity.this).getBalance();
          break label321;
          PaymentActivity.this.vAccount.setVisibility(8);
          PaymentActivity.this.llAccount.setVisibility(8);
          break label327;
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 32)
    {
      j();
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 2: 
      b(16);
      return;
    case 3: 
      b(17);
      return;
    }
    this.B = paramIntent.getExtras().getParcelableArrayList("Cards");
    this.C.clear();
    paramIntent = this.B.iterator();
    label476:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (paramIntent.hasNext())
      {
        localObject1 = (com.ziroom.ziroomcustomer.payment.b.c)paramIntent.next();
        if (((com.ziroom.ziroomcustomer.payment.b.c)localObject1).isChecked())
        {
          localObject2 = this.C.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.ziroom.ziroomcustomer.payment.b.d)((Iterator)localObject2).next();
            if (((com.ziroom.ziroomcustomer.payment.b.d)localObject3).getOrderType() == ((com.ziroom.ziroomcustomer.payment.b.c)localObject1).getParentType())
            {
              ((com.ziroom.ziroomcustomer.payment.b.d)localObject3).getCards().add(localObject1);
              ((com.ziroom.ziroomcustomer.payment.b.d)localObject3).setAmount(((com.ziroom.ziroomcustomer.payment.b.d)localObject3).getAmount() + ((com.ziroom.ziroomcustomer.payment.b.c)localObject1).getMoney());
            }
          }
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label476;
          }
          localObject2 = new com.ziroom.ziroomcustomer.payment.b.d();
          ((com.ziroom.ziroomcustomer.payment.b.d)localObject2).setOrderType(((com.ziroom.ziroomcustomer.payment.b.c)localObject1).getParentType());
          ((com.ziroom.ziroomcustomer.payment.b.d)localObject2).setName(((com.ziroom.ziroomcustomer.payment.b.c)localObject1).getParentName());
          ((com.ziroom.ziroomcustomer.payment.b.d)localObject2).setOrderType(((com.ziroom.ziroomcustomer.payment.b.c)localObject1).getParentType());
          ((com.ziroom.ziroomcustomer.payment.b.d)localObject2).setAmount(((com.ziroom.ziroomcustomer.payment.b.c)localObject1).getMoney());
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject1);
          ((com.ziroom.ziroomcustomer.payment.b.d)localObject2).setCards((List)localObject3);
          this.C.add(localObject2);
          break;
          this.s = 0;
          if (this.C.size() != 0)
          {
            paramIntent = this.C.iterator();
            while (paramIntent.hasNext())
            {
              localObject1 = (com.ziroom.ziroomcustomer.payment.b.d)paramIntent.next();
              paramInt1 = this.s;
              this.s = (((com.ziroom.ziroomcustomer.payment.b.d)localObject1).getAmount() + paramInt1);
            }
            paramIntent = "" + "-¥" + ah.Number(this.s / 100.0F) + "  ";
          }
          for (;;)
          {
            this.tvCardsContent.setText(paramIntent);
            h();
            return;
            if (this.B.size() == 0) {
              paramIntent = "无可用卡券";
            } else {
              paramIntent = "可用卡券" + this.B.size() + "张";
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("message", "取消支付");
    setResult(17, localIntent);
    finish();
  }
  
  @OnClick({2131689492, 2131690461, 2131692056, 2131691846, 2131692052})
  @Instrumented
  public void onClick(View paramView)
  {
    boolean bool = true;
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = getIntent();
          paramView.putExtra("message", "取消支付");
          setResult(17, paramView);
          finish();
          return;
        } while (!this.checkAccount.isEnabled());
        paramView = this.checkAccount;
        if (!this.checkAccount.isChecked()) {}
        for (;;)
        {
          paramView.setChecked(bool);
          return;
          bool = false;
        }
        if ((this.D != null) && (this.E <= 0))
        {
          d("支付订单已超时");
          return;
        }
        i();
        return;
      } while (this.B.size() <= 0);
      paramView = new Intent(this, CouponCardsActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("couponCards", this.B);
      paramView.putExtra("money", this.r - this.s);
      paramView.putExtras(localBundle);
      startActivityForResult(paramView, 1);
      return;
    } while (!"100011".equals(this.G));
    paramView = new Intent(this, CleanStoredCardBuyActivity.class);
    paramView.putExtra("type", "clean_pay");
    startActivityForResult(paramView, 32);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903418);
    ButterKnife.bind(this);
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.v.removeCallbacksAndMessages(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/PaymentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */