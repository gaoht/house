package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.a.a;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.CleaningFeesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.LeasePriceBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.SevenDiscountRateBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.ThirtyDiscountRateBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.WeekendPriceBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean.WeekendLisDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class HousePriceSettingActivity
  extends BaseFluxActivity
  implements View.OnClickListener
{
  private ImageView A;
  private EditText B;
  private EditText C;
  private EditText D;
  private RelativeLayout E;
  private RelativeLayout F;
  private Context G;
  private List<WeekendListBean.WeekendLisDataBean> H;
  private ArrayList<SingleChoseBean> I = new ArrayList();
  private String J;
  private WeekendListBean.WeekendLisDataBean K;
  private int L;
  private int M;
  private int N;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c O;
  private String P;
  private String Q;
  private int R;
  private int S = 0;
  private int T = 0;
  private String U;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c V;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b W;
  int b;
  int c;
  String d;
  int e;
  Double f = Double.valueOf(-1.0D);
  Double g = Double.valueOf(-1.0D);
  private ImageView r;
  private TextView s;
  private ObservableScrollView t;
  private View u;
  private EditText v;
  private ImageView w;
  private RelativeLayout x;
  private TextView y;
  private EditText z;
  
  private void a()
  {
    this.G = this;
    this.r = ((ImageView)findViewById(2131689492));
    this.s = ((TextView)findViewById(2131690401));
    this.u = findViewById(2131689863);
    this.t = ((ObservableScrollView)findViewById(2131689506));
    this.v = ((EditText)findViewById(2131690860));
    this.w = ((ImageView)findViewById(2131690863));
    this.x = ((RelativeLayout)findViewById(2131690865));
    this.y = ((TextView)findViewById(2131690867));
    this.z = ((EditText)findViewById(2131690869));
    this.A = ((ImageView)findViewById(2131690871));
    this.B = ((EditText)findViewById(2131690875));
    this.C = ((EditText)findViewById(2131690877));
    this.D = ((EditText)findViewById(2131690880));
    this.E = ((RelativeLayout)findViewById(2131690864));
    this.F = ((RelativeLayout)findViewById(2131690872));
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, int paramInt5)
  {
    String str1 = getIntent().getStringExtra("houseBaseFid");
    String str2 = getIntent().getStringExtra("roomFid");
    int i = getIntent().getIntExtra("rentWay", 0);
    this.W.saveSetPrice(this, this, str1, str2, i, paramInt1, paramInt2, paramString, paramInt3, paramInt4, paramDouble1, paramDouble2, paramInt5);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, Double paramDouble1, Double paramDouble2, int paramInt5)
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("leasePrice", paramInt1);
    localIntent.putExtra("weekendPriceSwitch", paramInt2);
    localIntent.putExtra("weekendPriceType", paramString1);
    localIntent.putExtra("weekendPriceTypeD", paramString2);
    localIntent.putExtra("weekendPriceVal", paramInt3);
    localIntent.putExtra("fullDayRateSwitch", paramInt4);
    localIntent.putExtra("sevenDiscountRate", paramDouble1);
    localIntent.putExtra("thirtyDiscountRate", paramDouble2);
    localIntent.putExtra("cleaningFees", paramInt5);
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(LandlordReleaseHousePriceBasicData paramLandlordReleaseHousePriceBasicData)
  {
    if (paramLandlordReleaseHousePriceBasicData == null) {
      return;
    }
    this.M = paramLandlordReleaseHousePriceBasicData.getMaxPrice();
    this.N = paramLandlordReleaseHousePriceBasicData.getMinPrice();
    this.L = paramLandlordReleaseHousePriceBasicData.getCleaningFeesPer();
    this.S = paramLandlordReleaseHousePriceBasicData.getWeekendPriceSwitch();
    this.T = paramLandlordReleaseHousePriceBasicData.getFullDayRateSwitch();
    this.D.setHint("清洁费最高为每晚房费的2倍".replace("2", this.L + ""));
    Object localObject2 = paramLandlordReleaseHousePriceBasicData.getLeasePrice();
    LandlordReleaseHousePriceBasicData.WeekendPriceBean localWeekendPriceBean = paramLandlordReleaseHousePriceBasicData.getWeekendPrice();
    WeekendListBean localWeekendListBean = paramLandlordReleaseHousePriceBasicData.getWeekendList();
    LandlordReleaseHousePriceBasicData.SevenDiscountRateBean localSevenDiscountRateBean = paramLandlordReleaseHousePriceBasicData.getSevenDiscountRate();
    Object localObject1 = paramLandlordReleaseHousePriceBasicData.getThirtyDiscountRate();
    int i;
    if (localObject2 != null)
    {
      i = ((LandlordReleaseHousePriceBasicData.LeasePriceBean)localObject2).getValue();
      if (i > 0) {
        this.b = i;
      }
      if (!((LandlordReleaseHousePriceBasicData.LeasePriceBean)localObject2).isEdit()) {
        break label262;
      }
      this.v.setClickable(true);
    }
    for (;;)
    {
      if (localWeekendPriceBean != null) {
        this.e = localWeekendPriceBean.getValue();
      }
      a(localWeekendListBean);
      if (localSevenDiscountRateBean != null)
      {
        localObject2 = localSevenDiscountRateBean.getValue();
        if (((Double)localObject2).doubleValue() > 0.0D) {
          this.f = ((Double)localObject2);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((LandlordReleaseHousePriceBasicData.ThirtyDiscountRateBean)localObject1).getValue();
        if (((Double)localObject1).doubleValue() > 0.0D) {
          this.g = ((Double)localObject1);
        }
      }
      i = paramLandlordReleaseHousePriceBasicData.getCleaningFees().getValue();
      if (i > 0) {
        this.c = i;
      }
      f();
      g();
      h();
      j();
      i();
      k();
      return;
      label262:
      this.v.setClickable(false);
    }
  }
  
  private void a(WeekendListBean paramWeekendListBean)
  {
    if (paramWeekendListBean != null)
    {
      this.H = paramWeekendListBean.getList();
      if ((this.H != null) && (!this.H.isEmpty()))
      {
        int i = 0;
        while (i < this.H.size())
        {
          if (((WeekendListBean.WeekendLisDataBean)this.H.get(i)).isSelect()) {
            this.K = ((WeekendListBean.WeekendLisDataBean)this.H.get(i));
          }
          i += 1;
        }
      }
    }
  }
  
  private void b()
  {
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.t.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        HousePriceSettingActivity.a(HousePriceSettingActivity.this).setAlpha(f);
        ad.hideSoftInput(HousePriceSettingActivity.this);
      }
    });
  }
  
  private void e()
  {
    a((LandlordReleaseHousePriceBasicData)getIntent().getExtras().getSerializable("basicData"));
  }
  
  private void f()
  {
    if (this.b > 0)
    {
      this.v.setInputType(1);
      this.v.setText(this.b + "元");
      this.v.setInputType(2);
    }
    if (this.S == 1)
    {
      this.E.setVisibility(0);
      this.w.setImageResource(2130838663);
      if (this.e > 0) {
        this.z.setText(this.e + "元");
      }
      if (this.K != null) {
        this.y.setText(this.K.getText());
      }
      if (this.T != 0) {
        break label321;
      }
      this.F.setVisibility(8);
      this.A.setImageResource(2130838662);
    }
    for (;;)
    {
      if ((this.f != null) && (this.f.doubleValue() > 0.0D)) {
        this.B.setText(this.f + "折");
      }
      if ((this.g != null) && (this.g.doubleValue() > 0.0D)) {
        this.C.setText(this.g + "折");
      }
      if (this.c > 0) {
        this.D.setText(this.c + "元");
      }
      return;
      this.E.setVisibility(8);
      this.w.setImageResource(2130838662);
      break;
      label321:
      this.F.setVisibility(0);
      this.A.setImageResource(2130838663);
    }
  }
  
  private void g()
  {
    this.v.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.v.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          HousePriceSettingActivity.b(HousePriceSettingActivity.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(7) });
          paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.b(HousePriceSettingActivity.this)).toString().trim();
          if ((!TextUtils.isEmpty(paramAnonymousView)) && (!paramAnonymousView.contains("元"))) {}
        }
        do
        {
          return;
          HousePriceSettingActivity.b(HousePriceSettingActivity.this).setInputType(1);
          HousePriceSettingActivity.b(HousePriceSettingActivity.this).setText(paramAnonymousView + "元");
          return;
          paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.b(HousePriceSettingActivity.this)).toString();
        } while ((TextUtils.isEmpty(paramAnonymousView)) || (!paramAnonymousView.contains("元")));
        paramAnonymousView = paramAnonymousView.replaceAll("元", "");
        HousePriceSettingActivity.b(HousePriceSettingActivity.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });
        HousePriceSettingActivity.b(HousePriceSettingActivity.this).setText(paramAnonymousView);
        HousePriceSettingActivity.b(HousePriceSettingActivity.this).setInputType(2);
        HousePriceSettingActivity.b(HousePriceSettingActivity.this).setSelection(paramAnonymousView.length());
      }
    });
  }
  
  private void h()
  {
    this.z.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        CharSequence localCharSequence = paramAnonymousCharSequence;
        if (paramAnonymousCharSequence.toString().contains("."))
        {
          localCharSequence = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence.length() - 1 - paramAnonymousCharSequence.toString().indexOf(".") > 1)
          {
            localCharSequence = paramAnonymousCharSequence.toString().subSequence(0, paramAnonymousCharSequence.toString().indexOf(".") + 3);
            HousePriceSettingActivity.c(HousePriceSettingActivity.this).setText(localCharSequence);
            HousePriceSettingActivity.c(HousePriceSettingActivity.this).setSelection(localCharSequence.length());
          }
        }
        paramAnonymousCharSequence = localCharSequence;
        if (localCharSequence.toString().trim().substring(0).equals("."))
        {
          paramAnonymousCharSequence = "0" + localCharSequence;
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setText(paramAnonymousCharSequence);
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setSelection(2);
        }
        if ((paramAnonymousCharSequence.toString().startsWith("0")) && (paramAnonymousCharSequence.toString().trim().length() > 1) && (!paramAnonymousCharSequence.toString().substring(1, 2).equals(".")) && (!paramAnonymousCharSequence.toString().substring(1, 2).equals("元")))
        {
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setText(paramAnonymousCharSequence.subSequence(1, 2));
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setSelection(1);
        }
      }
    });
    this.z.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(7) });
          paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.c(HousePriceSettingActivity.this)).toString().trim();
          if (TextUtils.isEmpty(paramAnonymousView)) {}
        }
        for (;;)
        {
          try
          {
            HousePriceSettingActivity.c(HousePriceSettingActivity.this).setInputType(1);
            HousePriceSettingActivity.c(HousePriceSettingActivity.this).setText(paramAnonymousView + "元");
            return;
          }
          catch (NumberFormatException paramAnonymousView) {}
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });
          HousePriceSettingActivity.c(HousePriceSettingActivity.this).setInputType(2);
          paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.c(HousePriceSettingActivity.this)).toString();
          if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("元")))
          {
            paramAnonymousView = paramAnonymousView.replace("元", "");
            HousePriceSettingActivity.c(HousePriceSettingActivity.this).setText(paramAnonymousView);
            HousePriceSettingActivity.c(HousePriceSettingActivity.this).setSelection(paramAnonymousView.length());
            return;
          }
        }
      }
    });
  }
  
  private void i()
  {
    this.B.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.toString().contains("折")) {
          return;
        }
        CharSequence localCharSequence;
        if (paramAnonymousCharSequence.toString().contains("."))
        {
          localCharSequence = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence.length() - 1 - paramAnonymousCharSequence.toString().indexOf(".") > 1)
          {
            localCharSequence = paramAnonymousCharSequence.toString().subSequence(0, paramAnonymousCharSequence.toString().indexOf(".") + 2);
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText(localCharSequence);
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setSelection(localCharSequence.length());
          }
        }
        for (;;)
        {
          paramAnonymousCharSequence = localCharSequence;
          if (localCharSequence.toString().trim().substring(0).equals("."))
          {
            paramAnonymousCharSequence = "0" + localCharSequence;
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText(paramAnonymousCharSequence);
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setSelection(2);
          }
          if ((!paramAnonymousCharSequence.toString().startsWith("0")) || (paramAnonymousCharSequence.toString().trim().length() <= 1) || (paramAnonymousCharSequence.toString().substring(1, 2).equals(".")) || (paramAnonymousCharSequence.toString().substring(1, 2).equals("折"))) {
            break;
          }
          HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText(paramAnonymousCharSequence.subSequence(1, 2));
          HousePriceSettingActivity.d(HousePriceSettingActivity.this).setSelection(1);
          return;
          localCharSequence = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence.length() > 1)
          {
            localCharSequence = paramAnonymousCharSequence.toString().subSequence(0, 1);
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText(localCharSequence);
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setSelection(localCharSequence.length());
          }
        }
      }
    });
    this.B.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          try
          {
            paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.d(HousePriceSettingActivity.this)).toString().trim();
            if (Double.valueOf(Double.parseDouble(paramAnonymousView)).doubleValue() == 0.0D)
            {
              g.textToast(HousePriceSettingActivity.this, "入住满7天折扣不能为0");
              HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText("");
              return;
            }
            if (TextUtils.isEmpty(paramAnonymousView)) {
              return;
            }
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setInputType(1);
            HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText(paramAnonymousView + "折");
            return;
          }
          catch (Exception paramAnonymousView)
          {
            return;
          }
        }
        paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.d(HousePriceSettingActivity.this)).toString();
        if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("折")))
        {
          paramAnonymousView = paramAnonymousView.replace("折", "");
          HousePriceSettingActivity.d(HousePriceSettingActivity.this).setText(paramAnonymousView);
          HousePriceSettingActivity.d(HousePriceSettingActivity.this).setInputType(8194);
          HousePriceSettingActivity.d(HousePriceSettingActivity.this).setSelection(paramAnonymousView.length());
        }
      }
    });
  }
  
  private void j()
  {
    this.C.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.toString().contains("折")) {
          return;
        }
        CharSequence localCharSequence;
        if (paramAnonymousCharSequence.toString().contains("."))
        {
          localCharSequence = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence.length() - 1 - paramAnonymousCharSequence.toString().indexOf(".") > 1)
          {
            localCharSequence = paramAnonymousCharSequence.toString().subSequence(0, paramAnonymousCharSequence.toString().indexOf(".") + 2);
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText(localCharSequence);
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setSelection(localCharSequence.length());
          }
        }
        for (;;)
        {
          paramAnonymousCharSequence = localCharSequence;
          if (localCharSequence.toString().trim().substring(0).equals("."))
          {
            paramAnonymousCharSequence = "0" + localCharSequence;
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText(paramAnonymousCharSequence);
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setSelection(2);
          }
          if ((!paramAnonymousCharSequence.toString().startsWith("0")) || (paramAnonymousCharSequence.toString().trim().length() <= 1) || (paramAnonymousCharSequence.toString().substring(1, 2).equals(".")) || (paramAnonymousCharSequence.toString().substring(1, 2).equals("折"))) {
            break;
          }
          HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText(paramAnonymousCharSequence.subSequence(1, 2));
          HousePriceSettingActivity.e(HousePriceSettingActivity.this).setSelection(1);
          return;
          localCharSequence = paramAnonymousCharSequence;
          if (paramAnonymousCharSequence.length() > 1)
          {
            localCharSequence = paramAnonymousCharSequence.toString().subSequence(0, 1);
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText(localCharSequence);
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setSelection(localCharSequence.length());
          }
        }
      }
    });
    this.C.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {
          try
          {
            paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.e(HousePriceSettingActivity.this)).toString().trim();
            if (Double.valueOf(Double.parseDouble(paramAnonymousView)).doubleValue() == 0.0D)
            {
              g.textToast(HousePriceSettingActivity.this, "入住满30天折扣不能为0");
              HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText("");
              return;
            }
            if (TextUtils.isEmpty(paramAnonymousView)) {
              return;
            }
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setInputType(1);
            HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText(paramAnonymousView + "折");
            return;
          }
          catch (Exception paramAnonymousView)
          {
            return;
          }
        }
        paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.e(HousePriceSettingActivity.this)).toString();
        if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("折")))
        {
          paramAnonymousView = paramAnonymousView.replace("折", "");
          HousePriceSettingActivity.e(HousePriceSettingActivity.this).setText(paramAnonymousView);
          HousePriceSettingActivity.e(HousePriceSettingActivity.this).setInputType(8194);
          HousePriceSettingActivity.e(HousePriceSettingActivity.this).setSelection(paramAnonymousView.length());
        }
      }
    });
  }
  
  private void k()
  {
    this.D.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.D.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          HousePriceSettingActivity.f(HousePriceSettingActivity.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(7) });
          paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.f(HousePriceSettingActivity.this)).toString().trim();
          if (TextUtils.isEmpty(paramAnonymousView)) {}
        }
        for (;;)
        {
          try
          {
            HousePriceSettingActivity.f(HousePriceSettingActivity.this).setInputType(1);
            HousePriceSettingActivity.f(HousePriceSettingActivity.this).setText(paramAnonymousView + "元");
            return;
          }
          catch (NumberFormatException paramAnonymousView) {}
          HousePriceSettingActivity.f(HousePriceSettingActivity.this).setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });
          paramAnonymousView = VdsAgent.trackEditTextSilent(HousePriceSettingActivity.f(HousePriceSettingActivity.this)).toString();
          if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("元")))
          {
            paramAnonymousView = paramAnonymousView.replace("元", "");
            HousePriceSettingActivity.f(HousePriceSettingActivity.this).setText(paramAnonymousView);
            HousePriceSettingActivity.f(HousePriceSettingActivity.this).setInputType(2);
            HousePriceSettingActivity.f(HousePriceSettingActivity.this).setSelection(paramAnonymousView.length());
            return;
          }
        }
      }
    });
  }
  
  private void l()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.v).toString();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(this, "请填写基础价格");
      return;
    }
    this.b = Integer.parseInt(str1.replaceAll("元", ""));
    if (this.b > this.M)
    {
      g.textToast(this, String.format("基础价格不能高于%d元", new Object[] { Integer.valueOf(this.M) }));
      return;
    }
    if (this.b < this.N)
    {
      g.textToast(this, String.format("基础价格不能低于%d元", new Object[] { Integer.valueOf(this.N) }));
      return;
    }
    str1 = VdsAgent.trackEditTextSilent(this.D).toString();
    if (!TextUtils.isEmpty(str1)) {}
    for (this.c = Integer.parseInt(str1.replace("元", "")); (this.L != 0) && (this.c > this.b * this.L); this.c = 0)
    {
      g.textToast(this, String.format("清洁费最高为基础价格的%d倍", new Object[] { Integer.valueOf(this.L) }));
      return;
    }
    str1 = "";
    if (this.K != null)
    {
      this.d = this.K.getValue();
      str1 = this.K.getText();
    }
    String str2 = VdsAgent.trackEditTextSilent(this.z).toString();
    if (!TextUtils.isEmpty(str2)) {
      this.e = Integer.parseInt(str2.replaceAll("元", ""));
    }
    while (this.S == 1) {
      if (this.K == null)
      {
        g.textToast(this, "请选择周末价格日期");
        return;
        this.e = 0;
      }
      else
      {
        if (this.e == 0)
        {
          g.textToast(this, "请填写周末价格");
          return;
        }
        if (this.e > this.M)
        {
          g.textToast(this, String.format("周末价格不能高于%d元", new Object[] { Integer.valueOf(this.M) }));
          return;
        }
        if (this.e < this.N)
        {
          g.textToast(this, String.format("周末价格不能低于%d元", new Object[] { Integer.valueOf(this.N) }));
          return;
        }
      }
    }
    str2 = VdsAgent.trackEditTextSilent(this.B) + "";
    if (!TextUtils.isEmpty(str2))
    {
      this.f = Double.valueOf(Double.parseDouble(str2.replace("折", "")));
      str2 = VdsAgent.trackEditTextSilent(this.C) + "";
      if (TextUtils.isEmpty(str2)) {
        break label531;
      }
      this.g = Double.valueOf(Double.parseDouble(str2.replace("折", "")));
    }
    for (;;)
    {
      if (this.T == 1)
      {
        if (this.f == null)
        {
          g.textToast(this, "请设置7天长租折扣");
          return;
          this.f = Double.valueOf(0.0D);
          break;
          label531:
          this.g = Double.valueOf(0.0D);
          continue;
        }
        if (this.f == null)
        {
          g.textToast(this, "请设置30天长租折扣");
          return;
        }
      }
    }
    if ("from_manager_release".equals(this.J))
    {
      a(this.b, this.S, this.d, this.e, this.T, this.f.doubleValue(), this.g.doubleValue(), this.c);
      return;
    }
    a(this.b, this.S, this.d, str1, this.e, this.T, this.f, this.g, this.c);
  }
  
  private void m()
  {
    if (!this.I.isEmpty()) {
      this.I.clear();
    }
    if (this.H != null)
    {
      int i = 0;
      while (i < this.H.size())
      {
        localObject1 = ((WeekendListBean.WeekendLisDataBean)this.H.get(i)).getText();
        boolean bool = ((WeekendListBean.WeekendLisDataBean)this.H.get(i)).isSelect();
        localObject2 = ((WeekendListBean.WeekendLisDataBean)this.H.get(i)).getValue();
        SingleChoseBean localSingleChoseBean = new SingleChoseBean();
        localSingleChoseBean.setText((String)localObject1);
        localSingleChoseBean.setIsChosen(bool);
        localSingleChoseBean.setValue((String)localObject2);
        this.I.add(localSingleChoseBean);
        i += 1;
      }
    }
    if (this.O != null)
    {
      this.O.show();
      return;
    }
    this.O = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(this.G, "weekend_chose", new a(null), this.I);
    this.O.setCanceledOnTouchOutside(true);
    Object localObject1 = this.O.getWindow();
    ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
    Object localObject2 = ((Window)localObject1).getAttributes();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).height = -2;
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    ((Window)localObject1).setGravity(80);
    this.O.show();
  }
  
  private void n()
  {
    if (this.S == 1)
    {
      this.E.setVisibility(8);
      this.w.setImageResource(2130838662);
      this.S = 0;
      return;
    }
    this.E.setVisibility(0);
    this.w.setImageResource(2130838663);
    this.S = 1;
  }
  
  private void o()
  {
    if (this.T == 1)
    {
      this.F.setVisibility(8);
      this.A.setImageResource(2130838662);
      this.T = 0;
      return;
    }
    this.F.setVisibility(0);
    this.A.setImageResource(2130838663);
    this.T = 1;
  }
  
  private void p()
  {
    this.W.initSetPrice(this, this, this.P, this.Q, this.R);
  }
  
  private void q()
  {
    a((LandlordReleaseHousePriceBasicData)e.parseObject(e.parseObject(this.U).get("data").toString(), LandlordReleaseHousePriceBasicData.class));
  }
  
  private void r()
  {
    this.V = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.V);
    this.W = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void s()
  {
    Intent localIntent = getIntent();
    a((WeekendListBean)getIntent().getExtras().getSerializable("weekendList"));
    if (localIntent.getIntExtra("priceTag", -1) == -1) {
      return;
    }
    int i = localIntent.getIntExtra("leasePrice", -1);
    if (i != -1) {
      this.b = i;
    }
    i = localIntent.getIntExtra("weekendPriceSwitch", -1);
    if (i != -1) {
      this.S = i;
    }
    Object localObject = localIntent.getStringExtra("weekendPriceType");
    String str = localIntent.getStringExtra("weekendPriceTypeD");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
    {
      WeekendListBean.WeekendLisDataBean localWeekendLisDataBean = new WeekendListBean.WeekendLisDataBean();
      localWeekendLisDataBean.setText(str);
      localWeekendLisDataBean.setValue((String)localObject);
      this.K = localWeekendLisDataBean;
    }
    i = localIntent.getIntExtra("weekendPriceVal", -1);
    if (i != -1) {
      this.e = i;
    }
    i = localIntent.getIntExtra("fullDayRateSwitch", -1);
    if (i != -1) {
      this.T = i;
    }
    localObject = Double.valueOf(localIntent.getDoubleExtra("sevenDiscountRate", -1.0D));
    if (((Double)localObject).doubleValue() != -1.0D) {
      this.f = ((Double)localObject);
    }
    localObject = Double.valueOf(localIntent.getDoubleExtra("thirtyDiscountRate", -1.0D));
    if (((Double)localObject).doubleValue() != -1.0D) {
      this.g = ((Double)localObject);
    }
    i = localIntent.getIntExtra("cleaningFees", -1);
    if (i != -1) {
      this.c = i;
    }
    f();
  }
  
  private void t()
  {
    Intent localIntent = getIntent();
    this.M = localIntent.getIntExtra("maxPrice", 0);
    this.N = localIntent.getIntExtra("minPrice", 0);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    ad.hideSoftInput(this);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690401: 
      l();
      return;
    case 2131690863: 
      n();
      return;
    case 2131690865: 
      m();
      return;
    }
    o();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903204);
    this.J = getIntent().getStringExtra("from");
    a();
    b();
    r();
    this.P = getIntent().getStringExtra("houseBaseFid");
    this.Q = getIntent().getStringExtra("roomFid");
    this.R = getIntent().getIntExtra("rentWay", 0);
    if ((TextUtils.isEmpty(this.P)) || ((this.R == 1) && (TextUtils.isEmpty(this.Q))))
    {
      t();
      e();
      s();
      return;
    }
    p();
  }
  
  protected void onEventHandle(a parama)
  {
    parama = parama.getType();
    int i;
    switch (parama.hashCode())
    {
    default: 
      i = -1;
      label38:
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!parama.equals("ll_r_manager_init_set_price")) {
          break;
        }
        i = 0;
        break label38;
        if (!parama.equals("ll_r_manager_set_price_save")) {
          break;
        }
        i = 1;
        break label38;
        this.U = this.V.getInitSetPriceBean();
        e.parseObject(this.U);
      } while (TextUtils.isEmpty(this.U));
      q();
      s();
      return;
    } while (!((MinsuBaseJson)e.parseObject(this.V.getSaveSetPriceBean(), MinsuBaseJson.class)).checkSuccess(this));
    g.textToast(this, "保存成功");
    setResult(-1);
    finish();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ad.hideSoftInput(this);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      HousePriceSettingActivity.a(HousePriceSettingActivity.this, (WeekendListBean.WeekendLisDataBean)HousePriceSettingActivity.g(HousePriceSettingActivity.this).get(paramInt));
      HousePriceSettingActivity.i(HousePriceSettingActivity.this).setText(HousePriceSettingActivity.h(HousePriceSettingActivity.this).getText());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/HousePriceSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */