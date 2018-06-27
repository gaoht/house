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
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.dialog.a;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModel.DataBean.DetailsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPayWayListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPayWayListModel.DataBean;
import java.util.List;
import java.util.Map;

public class ZryuBillDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Unbinder a;
  private int b;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131692824)
  Button btnZryuOnlinePay;
  private String c = ZryuBillDetailActivity.class.getSimpleName();
  private double d = 5000.0D;
  private String e;
  @BindView(2131692823)
  EditText etThisTimePayPrice;
  private ZryuBillDetailModel f;
  private a g;
  @BindView(2131692820)
  LinearLayout llSeekBarContainer;
  @BindView(2131692818)
  ListViewForScrollView lvBillDetailList;
  private ZryuPayWayListModel r;
  private double s = 0.0D;
  @BindView(2131692822)
  SeekBar seekbarThisTimePayPrice;
  private final int t = 100000;
  @BindView(2131692814)
  TextView tvBillNum;
  @BindView(2131692815)
  TextView tvContractNum;
  @BindView(2131692816)
  TextView tvHadPaiedPrice;
  @BindView(2131692817)
  TextView tvShouldPayTime;
  @BindView(2131692821)
  TextView tvThisTimePayPriceDynamic;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131692819)
  TextView tvZryuBillDetailTotal;
  private double u;
  private double v;
  private boolean w;
  private BroadcastReceiver x = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("code", 1000) == 0)
      {
        ZryuBillDetailActivity.a(ZryuBillDetailActivity.this);
        return;
      }
      af.showToast(ZryuBillDetailActivity.this, "支付失败!");
    }
  };
  
  private void a()
  {
    this.e = getIntent().getStringExtra("billFid");
    this.btnBack.setOnClickListener(this);
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.ziroomcustomer.activity_1");
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_2");
    registerReceiver(this.x, localIntentFilter);
  }
  
  private void b()
  {
    if (checkNet(this))
    {
      Map localMap = c.buildGetBillDetail(this, this.e);
      e.getBillDetail(this, new b(), localMap, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void d(String paramString)
  {
    try
    {
      double d1 = Double.parseDouble(paramString);
      if ((d1 >= this.d) && (d1 <= this.v))
      {
        u.i(this.c, ";minPayAmount:" + this.d + ";seekBarRange:" + this.u + ";inputPrice:" + d1);
        this.tvThisTimePayPriceDynamic.setText("¥" + ah.formatDouble(d1));
        this.w = true;
        int i = (int)((d1 - this.d) / this.u * 100000.0D);
        this.seekbarThisTimePayPrice.setProgress(i);
        u.i(this.c, ";seekBarRange:" + this.u + ";inputPrice:" + d1 + ";progressCur:" + i);
        paramString = this.tvThisTimePayPriceDynamic;
        double d2 = n.dip2px(this, 16.0F);
        paramString.setX((float)((d1 - this.d) * (this.b - n.dip2px(this, 32.0F) - this.tvThisTimePayPriceDynamic.getMeasuredWidth()) / this.u + d2));
        return;
      }
      af.showToast(this, "请输入正确的金额(" + this.d + "-" + this.v + ")");
      return;
    }
    catch (Exception paramString)
    {
      u.i(this.c, paramString.getStackTrace());
      af.showToast(this, "请输入正确的金额(" + this.d + "-" + this.v + ")");
    }
  }
  
  private void e()
  {
    this.tvZryuBillDetailTotal.setText(this.f.data.oughtTotalAmountStr);
    this.tvBillNum.setText(this.f.data.billNum);
    this.tvContractNum.setText(this.f.data.contractCode);
    this.tvHadPaiedPrice.setText("¥" + this.f.data.actualAmountStr);
    this.tvShouldPayTime.setText(this.f.data.gatherDateStr);
    List localList = this.f.data.details;
    this.lvBillDetailList.setAdapter(new a(this, localList));
    int i = -1;
    try
    {
      int j = Integer.parseInt(this.f.data.state);
      i = j;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    if (2 == i)
    {
      this.llSeekBarContainer.setVisibility(8);
      this.btnZryuOnlinePay.setVisibility(8);
      return;
    }
    this.llSeekBarContainer.setVisibility(0);
    this.btnZryuOnlinePay.setVisibility(0);
    this.btnZryuOnlinePay.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ZryuBillDetailActivity.h(ZryuBillDetailActivity.this) <= 0.0D) {
          ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, ZryuBillDetailActivity.f(ZryuBillDetailActivity.this).data.oughtTotalAmount);
        }
        while (BaseActivity.checkNet(ZryuBillDetailActivity.this))
        {
          paramAnonymousView = ApplicationEx.c.getUserId(ZryuBillDetailActivity.this);
          paramAnonymousView = c.buildGetPayWayList(ZryuBillDetailActivity.this, ZryuBillDetailActivity.f(ZryuBillDetailActivity.this).data.billFid, ZryuBillDetailActivity.f(ZryuBillDetailActivity.this).data.billNum, ZryuBillDetailActivity.c(ZryuBillDetailActivity.this), paramAnonymousView);
          e.getPayWayList(ZryuBillDetailActivity.this, new ZryuBillDetailActivity.c(ZryuBillDetailActivity.this), paramAnonymousView, true);
          return;
          ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, Double.parseDouble(ZryuBillDetailActivity.this.tvThisTimePayPriceDynamic.getText().toString().substring(1)));
        }
        af.showToast(ZryuBillDetailActivity.this, "请检查您的网络，稍后再试！");
      }
    });
    this.v = (this.f.data.oughtTotalAmount - Double.parseDouble(this.f.data.actualAmountStr.trim()));
    try
    {
      this.d = Double.parseDouble(this.f.data.minPayAmount);
      this.u = (this.v - this.d);
      if (this.u <= 0.0D)
      {
        this.llSeekBarContainer.setVisibility(8);
        return;
      }
      this.seekbarThisTimePayPrice.setMax(100000);
      this.seekbarThisTimePayPrice.setProgress(100000);
      this.tvThisTimePayPriceDynamic.setText("¥" + ah.formatDouble(this.v));
      this.etThisTimePayPrice.setText("");
      this.tvThisTimePayPriceDynamic.post(new Runnable()
      {
        public void run()
        {
          ZryuBillDetailActivity.this.tvThisTimePayPriceDynamic.setX(ZryuBillDetailActivity.i(ZryuBillDetailActivity.this) - n.dip2px(ZryuBillDetailActivity.this, 16.0F) - ZryuBillDetailActivity.this.tvThisTimePayPriceDynamic.getMeasuredWidth());
        }
      });
      this.seekbarThisTimePayPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          double d = ZryuBillDetailActivity.j(ZryuBillDetailActivity.this) + paramAnonymousInt / 100000.0D * ZryuBillDetailActivity.h(ZryuBillDetailActivity.this);
          u.i(ZryuBillDetailActivity.e(ZryuBillDetailActivity.this), ";minPayAmount:" + ZryuBillDetailActivity.j(ZryuBillDetailActivity.this) + ";progress:" + paramAnonymousInt + ";seekBarRange:" + ZryuBillDetailActivity.h(ZryuBillDetailActivity.this) + ";curPrice:" + d);
          if (ZryuBillDetailActivity.k(ZryuBillDetailActivity.this)) {
            ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, false);
          }
          for (;;)
          {
            ZryuBillDetailActivity.this.tvThisTimePayPriceDynamic.setX(n.dip2px(ZryuBillDetailActivity.this, 16.0F) + (ZryuBillDetailActivity.i(ZryuBillDetailActivity.this) - n.dip2px(ZryuBillDetailActivity.this, 32.0F) - ZryuBillDetailActivity.this.tvThisTimePayPriceDynamic.getMeasuredWidth()) * paramAnonymousInt / 100000);
            return;
            ZryuBillDetailActivity.this.tvThisTimePayPriceDynamic.setText("¥" + ah.formatDouble(d));
            ZryuBillDetailActivity.this.etThisTimePayPrice.setText("");
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
          ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, paramAnonymousCharSequence.toString().trim());
        }
      });
      return;
    }
    catch (Exception localException1)
    {
      for (;;) {}
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
    }
    setResult(-1);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903577);
    this.b = ac.getScreenWidth(this);
    this.a = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    unregisterReceiver(this.x);
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
    private List<ZryuBillDetailModel.DataBean.DetailsBean> c;
    
    public a(List<ZryuBillDetailModel.DataBean.DetailsBean> paramList)
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
        ZryuBillDetailActivity.ViewHolder localViewHolder = (ZryuBillDetailActivity.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = localViewHolder;
      }
      for (;;)
      {
        paramView.tvPriceTitle.setText(((ZryuBillDetailModel.DataBean.DetailsBean)this.c.get(paramInt)).key);
        paramView.tvPriceAmount.setText(((ZryuBillDetailModel.DataBean.DetailsBean)this.c.get(paramInt)).value);
        if (!"+".equals(((ZryuBillDetailModel.DataBean.DetailsBean)this.c.get(paramInt)).value.substring(0, 1))) {
          break;
        }
        paramView.tvPriceAmount.setTextColor(ZryuBillDetailActivity.this.getResources().getColor(2131624610));
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904557, paramViewGroup, false);
        paramView = new ZryuBillDetailActivity.ViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
      }
      if ("-".equals(((ZryuBillDetailModel.DataBean.DetailsBean)this.c.get(paramInt)).value.substring(0, 1)))
      {
        paramView.tvPriceAmount.setTextColor(ZryuBillDetailActivity.this.getResources().getColor(2131624607));
        return paramViewGroup;
      }
      paramView.tvPriceAmount.setTextColor(ZryuBillDetailActivity.this.getResources().getColor(2131624599));
      return paramViewGroup;
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuBillDetailActivity.e(ZryuBillDetailActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, (ZryuBillDetailModel)paramk.getObject());
        if (ZryuBillDetailActivity.f(ZryuBillDetailActivity.this) != null)
        {
          if (200 == ZryuBillDetailActivity.f(ZryuBillDetailActivity.this).error_code) {
            ZryuBillDetailActivity.g(ZryuBillDetailActivity.this);
          }
        }
        else {
          return;
        }
        ZryuBillDetailActivity.this.showToast(ZryuBillDetailActivity.f(ZryuBillDetailActivity.this).error_message);
        return;
      }
      ZryuBillDetailActivity.this.showToast(paramk.getMessage());
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuBillDetailActivity.e(ZryuBillDetailActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, (ZryuPayWayListModel)paramk.getObject());
        if (ZryuBillDetailActivity.b(ZryuBillDetailActivity.this) != null)
        {
          if (200 == ZryuBillDetailActivity.b(ZryuBillDetailActivity.this).error_code)
          {
            ZryuBillDetailActivity.a(ZryuBillDetailActivity.this, new a(ZryuBillDetailActivity.this, ZryuBillDetailActivity.b(ZryuBillDetailActivity.this).data.payOrderNum, ZryuBillDetailActivity.c(ZryuBillDetailActivity.this), 2));
            ZryuBillDetailActivity.d(ZryuBillDetailActivity.this).setPayWay(true, false, false);
            ZryuBillDetailActivity.d(ZryuBillDetailActivity.this).show();
          }
        }
        else {
          return;
        }
        ZryuBillDetailActivity.this.showToast(ZryuBillDetailActivity.b(ZryuBillDetailActivity.this).error_message);
        return;
      }
      ZryuBillDetailActivity.this.showToast(paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */