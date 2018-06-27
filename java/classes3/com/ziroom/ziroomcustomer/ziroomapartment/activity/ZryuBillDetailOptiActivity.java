package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2.DataBean.CardCouponsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2.DataBean.DetailsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPayWayListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPayWayListModel.DataBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ZryuBillDetailOptiActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int A;
  private int B;
  private int C;
  private String D;
  private List<String> E;
  private int F;
  private BroadcastReceiver G = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("code", 1000) == 0) {}
      try
      {
        Thread.sleep(1000L);
        ZryuBillDetailOptiActivity.f(ZryuBillDetailOptiActivity.this);
        return;
        af.showToast(ZryuBillDetailOptiActivity.this, "支付失败!");
        return;
      }
      catch (Exception paramAnonymousContext)
      {
        for (;;) {}
      }
    }
  };
  Unbinder a;
  private int b = 0;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131692824)
  Button btnZryuOnlinePay;
  private int c = 1;
  private int d;
  private String e = ZryuBillDetailOptiActivity.class.getSimpleName();
  @BindView(2131692823)
  EditText etThisTimePayPrice;
  private double f = 5000.0D;
  private String g;
  @BindView(2131692828)
  View line_below_rentCoupon;
  @BindView(2131692820)
  LinearLayout llSeekBarContainer;
  @BindView(2131692825)
  LinearLayout ll_zryu_bill_detail_favorable;
  @BindView(2131692818)
  ListViewForScrollView lvBillDetailList;
  private ZryuBillDetailModelV2 r;
  private com.ziroom.ziroomcustomer.ziroomapartment.dialog.a s;
  @BindView(2131692822)
  SeekBar seekbarThisTimePayPrice;
  private ZryuPayWayListModel t;
  @BindView(2131692814)
  TextView tvBillNum;
  @BindView(2131692815)
  TextView tvContractNum;
  @BindView(2131692827)
  TextView tvFavorablePrice;
  @BindView(2131692826)
  TextView tvFavorableTitle;
  @BindView(2131692817)
  TextView tvShouldPayTime;
  @BindView(2131692821)
  TextView tvThisTimePayPriceDynamic;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131692819)
  TextView tvZryuBillDetailTotal;
  private List<ZryuBillDetailModelV2.DataBean.CardCouponsBean> u;
  private double v = 0.0D;
  private final int w = 100000;
  private double x;
  private double y;
  private boolean z;
  
  private void a()
  {
    this.g = getIntent().getStringExtra("billFid");
    this.F = getIntent().getIntExtra("showPay", 0);
    this.btnBack.setOnClickListener(this);
    this.ll_zryu_bill_detail_favorable.setOnClickListener(this);
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.ziroomcustomer.activity_1");
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_2");
    registerReceiver(this.G, localIntentFilter);
  }
  
  private void b()
  {
    this.C = 0;
    if (this.E != null) {
      this.E.removeAll(this.E);
    }
    Iterator localIterator;
    if ((this.u != null) && (this.u.size() > 0)) {
      localIterator = this.u.iterator();
    }
    while (localIterator.hasNext())
    {
      ZryuBillDetailModelV2.DataBean.CardCouponsBean localCardCouponsBean = (ZryuBillDetailModelV2.DataBean.CardCouponsBean)localIterator.next();
      if (1 == localCardCouponsBean.isChecked)
      {
        try
        {
          this.C += Integer.parseInt(localCardCouponsBean.money);
          if (this.E == null) {
            this.E = new ArrayList();
          }
          this.E.add(localCardCouponsBean.code);
        }
        catch (Exception localException) {}
        continue;
        this.C = 0;
      }
    }
    if (this.u != null)
    {
      this.B = this.u.size();
      if (this.C <= 0) {
        break label331;
      }
      this.tvFavorablePrice.setText("-¥" + this.C);
      this.tvFavorablePrice.setTextColor(getResources().getColor(2131624597));
    }
    for (;;)
    {
      this.y = (this.r.data.pendingAmount - this.C);
      this.y = ah.Number2(this.y);
      if (this.y < 0.0D) {
        this.y = 0.0D;
      }
      this.tvZryuBillDetailTotal.setText(this.y + "");
      this.x = (this.y - this.f);
      if (this.x > 0.0D) {
        break label418;
      }
      this.llSeekBarContainer.setVisibility(8);
      return;
      this.B = 0;
      break;
      label331:
      if (this.B > 0)
      {
        this.tvFavorablePrice.setText(this.B + "张可用");
        this.tvFavorablePrice.setTextColor(getResources().getColor(2131624609));
      }
      else
      {
        this.tvFavorablePrice.setText("暂无可用");
        this.tvFavorablePrice.setTextColor(getResources().getColor(2131624599));
      }
    }
    label418:
    this.seekbarThisTimePayPrice.setMax(100000);
    this.seekbarThisTimePayPrice.setProgress(100000);
    this.tvThisTimePayPriceDynamic.setText("¥" + ah.formatDouble(this.y));
    this.etThisTimePayPrice.setText("");
    this.tvThisTimePayPriceDynamic.post(new Runnable()
    {
      public void run()
      {
        ZryuBillDetailOptiActivity.this.tvThisTimePayPriceDynamic.setX(ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this) - n.dip2px(ZryuBillDetailOptiActivity.this, 16.0F) - ZryuBillDetailOptiActivity.this.tvThisTimePayPriceDynamic.getMeasuredWidth());
      }
    });
    this.seekbarThisTimePayPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        double d = ZryuBillDetailOptiActivity.b(ZryuBillDetailOptiActivity.this) + paramAnonymousInt / 100000.0D * ZryuBillDetailOptiActivity.c(ZryuBillDetailOptiActivity.this);
        u.i(ZryuBillDetailOptiActivity.d(ZryuBillDetailOptiActivity.this), ";minPayAmount:" + ZryuBillDetailOptiActivity.b(ZryuBillDetailOptiActivity.this) + ";progress:" + paramAnonymousInt + ";seekBarRange:" + ZryuBillDetailOptiActivity.c(ZryuBillDetailOptiActivity.this) + ";curPrice:" + d);
        if (ZryuBillDetailOptiActivity.e(ZryuBillDetailOptiActivity.this)) {
          ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, false);
        }
        for (;;)
        {
          ZryuBillDetailOptiActivity.this.tvThisTimePayPriceDynamic.setX(n.dip2px(ZryuBillDetailOptiActivity.this, 16.0F) + (ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this) - n.dip2px(ZryuBillDetailOptiActivity.this, 32.0F) - ZryuBillDetailOptiActivity.this.tvThisTimePayPriceDynamic.getMeasuredWidth()) * paramAnonymousInt / 100000);
          return;
          ZryuBillDetailOptiActivity.this.tvThisTimePayPriceDynamic.setText("¥" + ah.formatDouble(d));
          ZryuBillDetailOptiActivity.this.etThisTimePayPrice.setText("");
        }
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      @Instrumented
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        VdsAgent.onStopTrackingTouch(this, paramAnonymousSeekBar);
      }
    });
    this.etThisTimePayPrice.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (ae.isNull(paramAnonymousCharSequence.toString().trim())) {
          return;
        }
        ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, paramAnonymousCharSequence.toString().trim());
      }
    });
  }
  
  private void d(String paramString)
  {
    try
    {
      double d1 = Double.parseDouble(paramString);
      if ((d1 >= this.f) && (d1 <= this.y))
      {
        u.i(this.e, ";minPayAmount:" + this.f + ";seekBarRange:" + this.x + ";inputPrice:" + d1);
        this.tvThisTimePayPriceDynamic.setText("¥" + ah.formatDouble(d1));
        this.z = true;
        int i = (int)((d1 - this.f) / this.x * 100000.0D);
        this.seekbarThisTimePayPrice.setProgress(i);
        u.i(this.e, ";seekBarRange:" + this.x + ";inputPrice:" + d1 + ";progressCur:" + i);
        paramString = this.tvThisTimePayPriceDynamic;
        double d2 = n.dip2px(this, 16.0F);
        paramString.setX((float)((d1 - this.f) * (this.d - n.dip2px(this, 32.0F) - this.tvThisTimePayPriceDynamic.getMeasuredWidth()) / this.x + d2));
        return;
      }
      af.showToast(this, "请输入正确的金额(" + this.f + "-" + this.y + ")");
      return;
    }
    catch (Exception paramString)
    {
      u.i(this.e, paramString.getStackTrace());
      af.showToast(this, "请输入正确的金额(" + this.f + "-" + this.y + ")");
    }
  }
  
  private void e()
  {
    boolean bool = ApplicationEx.c.isLoginState();
    Object localObject = ApplicationEx.c.getUser();
    if (localObject != null) {}
    for (this.D = ((UserInfo)localObject).getUid(); !bool; this.D = "")
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    if (checkNet(this))
    {
      localObject = c.buildGetBillDetailV2(this, this.D, this.g);
      e.getBillDetailV2(this, new b(), (Map)localObject, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void f()
  {
    if (this.r.data != null)
    {
      this.A = this.r.data.billType;
      if (this.A != 0) {
        break label247;
      }
      this.tvFavorableTitle.setText("租金卡");
    }
    for (;;)
    {
      this.r.data.pendingAmount = ah.Number2(this.r.data.pendingAmount);
      this.tvZryuBillDetailTotal.setText(this.r.data.pendingAmount + "");
      this.tvBillNum.setText(this.r.data.billNum);
      this.tvContractNum.setText(this.r.data.contractCode);
      this.tvShouldPayTime.setText(this.r.data.gatherDateStr);
      List localList = this.r.data.details;
      this.lvBillDetailList.setAdapter(new a(this, localList));
      int i = -1;
      try
      {
        int j = Integer.parseInt(this.r.data.state);
        i = j;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      if ((2 != i) && (this.F != 1)) {
        break;
      }
      this.llSeekBarContainer.setVisibility(8);
      this.btnZryuOnlinePay.setVisibility(8);
      this.ll_zryu_bill_detail_favorable.setVisibility(8);
      this.line_below_rentCoupon.setVisibility(8);
      return;
      label247:
      if (1 == this.A) {
        this.tvFavorableTitle.setText("优惠券");
      }
    }
    this.btnZryuOnlinePay.setVisibility(0);
    this.llSeekBarContainer.setVisibility(0);
    this.ll_zryu_bill_detail_favorable.setVisibility(0);
    this.line_below_rentCoupon.setVisibility(0);
    this.btnZryuOnlinePay.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ZryuBillDetailOptiActivity.c(ZryuBillDetailOptiActivity.this) <= 0.0D) {
          ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, ZryuBillDetailOptiActivity.l(ZryuBillDetailOptiActivity.this));
        }
        while (BaseActivity.checkNet(ZryuBillDetailOptiActivity.this))
        {
          paramAnonymousView = c.buildGetPayWayListV2(ZryuBillDetailOptiActivity.this, ZryuBillDetailOptiActivity.j(ZryuBillDetailOptiActivity.this).data.billFid, ZryuBillDetailOptiActivity.j(ZryuBillDetailOptiActivity.this).data.billNum, ZryuBillDetailOptiActivity.h(ZryuBillDetailOptiActivity.this), ZryuBillDetailOptiActivity.m(ZryuBillDetailOptiActivity.this), ZryuBillDetailOptiActivity.n(ZryuBillDetailOptiActivity.this), ZryuBillDetailOptiActivity.o(ZryuBillDetailOptiActivity.this));
          e.getPayWayListV2(ZryuBillDetailOptiActivity.this, new ZryuBillDetailOptiActivity.c(ZryuBillDetailOptiActivity.this), paramAnonymousView, true);
          return;
          ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, ah.Number2(Double.parseDouble(ZryuBillDetailOptiActivity.this.tvThisTimePayPriceDynamic.getText().toString().substring(1))));
        }
        af.showToast(ZryuBillDetailOptiActivity.this, "请检查您的网络，稍后再试！");
      }
    });
    try
    {
      this.f = Double.parseDouble(this.r.data.minPayAmount);
      if ((this.r.data.cardCoupons != null) && (this.r.data.cardCoupons.size() > 0)) {
        this.u = this.r.data.cardCoupons;
      }
      b();
      return;
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.b == paramInt1)
    {
      this.u = null;
      this.u = paramIntent.getParcelableArrayListExtra("rentCards");
    }
    for (;;)
    {
      b();
      return;
      if (this.c == paramInt1) {
        this.u = paramIntent.getParcelableArrayListExtra("couponCards");
      }
    }
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
      do
      {
        return;
        setResult(-1);
        finish();
        return;
        if (this.A != 0) {
          break;
        }
      } while (this.B <= 0);
      paramView = new Intent(this, ZryuRentCardActivity.class);
      paramView.putExtra("rentCards", (ArrayList)this.u);
      startActivityForResult(paramView, this.b);
      return;
    } while (1 != this.A);
    paramView = new Intent(this, ZryuCouponActivity.class);
    paramView.putExtra("couponCards", (ArrayList)this.u);
    startActivityForResult(paramView, this.c);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903578);
    this.d = ac.getScreenWidth(this);
    this.a = ButterKnife.bind(this);
    a();
    e();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    unregisterReceiver(this.G);
    super.onDestroy();
  }
  
  static class ViewHolder
  {
    @BindView(2131695765)
    TextView tvPriceAmount;
    @BindView(2131690454)
    TextView tvPriceTitle;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    private List<ZryuBillDetailModelV2.DataBean.DetailsBean> c;
    
    public a(List<ZryuBillDetailModelV2.DataBean.DetailsBean> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        ZryuBillDetailOptiActivity.ViewHolder localViewHolder = (ZryuBillDetailOptiActivity.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = localViewHolder;
      }
      for (;;)
      {
        paramView.tvPriceTitle.setText(((ZryuBillDetailModelV2.DataBean.DetailsBean)this.c.get(paramInt)).key);
        paramView.tvPriceAmount.setText(((ZryuBillDetailModelV2.DataBean.DetailsBean)this.c.get(paramInt)).value);
        if (!"+".equals(((ZryuBillDetailModelV2.DataBean.DetailsBean)this.c.get(paramInt)).value.substring(0, 1))) {
          break;
        }
        paramView.tvPriceAmount.setTextColor(ZryuBillDetailOptiActivity.this.getResources().getColor(2131624610));
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904558, paramViewGroup, false);
        paramView = new ZryuBillDetailOptiActivity.ViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
      }
      if ("-".equals(((ZryuBillDetailModelV2.DataBean.DetailsBean)this.c.get(paramInt)).value.substring(0, 1)))
      {
        paramView.tvPriceAmount.setTextColor(ZryuBillDetailOptiActivity.this.getResources().getColor(2131624597));
        return paramViewGroup;
      }
      paramView.tvPriceAmount.setTextColor(ZryuBillDetailOptiActivity.this.getResources().getColor(2131624599));
      return paramViewGroup;
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuBillDetailOptiActivity.d(ZryuBillDetailOptiActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, (ZryuBillDetailModelV2)paramk.getObject());
        if (ZryuBillDetailOptiActivity.j(ZryuBillDetailOptiActivity.this) != null)
        {
          if (200 == ZryuBillDetailOptiActivity.j(ZryuBillDetailOptiActivity.this).error_code) {
            ZryuBillDetailOptiActivity.k(ZryuBillDetailOptiActivity.this);
          }
        }
        else {
          return;
        }
        ZryuBillDetailOptiActivity.this.showToast(ZryuBillDetailOptiActivity.j(ZryuBillDetailOptiActivity.this).error_message);
        return;
      }
      ZryuBillDetailOptiActivity.this.showToast(paramk.getMessage());
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuBillDetailOptiActivity.d(ZryuBillDetailOptiActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, (ZryuPayWayListModel)paramk.getObject());
        if ((ZryuBillDetailOptiActivity.g(ZryuBillDetailOptiActivity.this) != null) && ((200 == ZryuBillDetailOptiActivity.g(ZryuBillDetailOptiActivity.this).error_code) && (!ae.isNull(ZryuBillDetailOptiActivity.g(ZryuBillDetailOptiActivity.this).data.payOrderNum)))) {}
      }
      try
      {
        Thread.sleep(1000L);
        ZryuBillDetailOptiActivity.f(ZryuBillDetailOptiActivity.this);
        return;
        ZryuBillDetailOptiActivity.a(ZryuBillDetailOptiActivity.this, new com.ziroom.ziroomcustomer.ziroomapartment.dialog.a(ZryuBillDetailOptiActivity.this, ZryuBillDetailOptiActivity.g(ZryuBillDetailOptiActivity.this).data.payOrderNum, ZryuBillDetailOptiActivity.h(ZryuBillDetailOptiActivity.this), 2));
        ZryuBillDetailOptiActivity.i(ZryuBillDetailOptiActivity.this).setPayWay(true, false, false);
        ZryuBillDetailOptiActivity.i(ZryuBillDetailOptiActivity.this).show();
        return;
        ZryuBillDetailOptiActivity.this.showToast(ZryuBillDetailOptiActivity.g(ZryuBillDetailOptiActivity.this).error_message);
        return;
        ZryuBillDetailOptiActivity.this.showToast(paramk.getMessage());
        return;
      }
      catch (Exception paramk)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillDetailOptiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */