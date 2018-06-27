package com.ziroom.ziroomcustomer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.j;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseBillInfoEntity;
import com.ziroom.ziroomcustomer.model.HouseBillInfoEntity.ActualPayData;
import com.ziroom.ziroomcustomer.model.HouseBillInfoEntity.HouseInfoMessage;
import com.ziroom.ziroomcustomer.model.HouseBillInfoEntity.HousePayCost;
import com.ziroom.ziroomcustomer.repay.RepayPayStatusActivity;
import com.ziroom.ziroomcustomer.signed.EasilyPayInfoActivity;
import com.ziroom.ziroomcustomer.signed.EnterprisePaySuccessActivity;
import com.ziroom.ziroomcustomer.signed.PayPartActivity;
import com.ziroom.ziroomcustomer.signed.PaySuccessActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletPaySuccessActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HouseBillInfoActivity
  extends BaseActivity
  implements View.OnLayoutChangeListener
{
  private int A = 0;
  private int B = 0;
  private String C;
  private boolean D = false;
  private boolean E = false;
  CheckBox a;
  @BindView(2131690798)
  RelativeLayout activity_house_bill_info_rl;
  CheckBox b;
  @BindView(2131690799)
  BasicZiroomToolBar bill_title;
  CompoundButton.OnCheckedChangeListener c = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      switch (paramAnonymousCompoundButton.getId())
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((HouseBillInfoActivity.this.b == null) || (HouseBillInfoActivity.this.a == null));
          if (paramAnonymousBoolean)
          {
            HouseBillInfoActivity.this.b.setChecked(false);
            HouseBillInfoActivity.a(HouseBillInfoActivity.this, "1".equals(HouseBillInfoActivity.g(HouseBillInfoActivity.this).getIsChangePayEasyPay()));
            HouseBillInfoActivity.this.house_bill_info_money_hint.setText("首次仅需支付1个月的租金");
            HouseBillInfoActivity.this.house_bill_info_money_hint.setVisibility(0);
            HouseBillInfoActivity.this.to_pay_money_hint.setText(HouseBillInfoActivity.g(HouseBillInfoActivity.this).getMinPayMoneyEasyPayView());
            HouseBillInfoActivity.this.house_bill_info_money.setText(HouseBillInfoActivity.g(HouseBillInfoActivity.this).getSurplusShouldPayEasyPay() + "");
            HouseBillInfoActivity.this.to_pay_checkstand.setText("立刻申请");
            return;
          }
        } while (HouseBillInfoActivity.this.b.isChecked());
        HouseBillInfoActivity.this.a.setChecked(true);
        return;
        if (paramAnonymousBoolean)
        {
          HouseBillInfoActivity.this.a.setChecked(false);
          HouseBillInfoActivity.this.house_bill_info_money_hint.setText("可自定义编辑付款金额");
          HouseBillInfoActivity.c(HouseBillInfoActivity.this);
          return;
        }
      } while (HouseBillInfoActivity.this.a.isChecked());
      HouseBillInfoActivity.this.b.setChecked(true);
    }
  };
  View.OnClickListener d = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      }
      do
      {
        do
        {
          return;
        } while (HouseBillInfoActivity.this.b == null);
        HouseBillInfoActivity.this.b.setChecked(true);
        return;
      } while (HouseBillInfoActivity.this.a == null);
      HouseBillInfoActivity.this.a.setChecked(true);
    }
  };
  com.ziroom.commonlibrary.a.a e = new com.ziroom.commonlibrary.a.a(this.g, new com.freelxl.baselibrary.d.f.c())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      dismissProgress();
      HouseBillInfoActivity.this.to_pay_checkstand.setEnabled(true);
      u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      com.freelxl.baselibrary.f.d.e("jsonObject", paramAnonymouse.toJSONString());
      if ("success".equals(paramAnonymouse.get("status")))
      {
        paramAnonymouse = new Intent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), EasilyPayInfoActivity.class);
        paramAnonymouse.putExtra("contract_code", HouseBillInfoActivity.f(HouseBillInfoActivity.this));
        HouseBillInfoActivity.this.startActivity(paramAnonymouse);
        ApplicationEx.c.addActivity(HouseBillInfoActivity.this);
      }
      for (;;)
      {
        dismissProgress();
        HouseBillInfoActivity.this.to_pay_checkstand.setEnabled(true);
        return;
        HouseBillInfoActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    }
  };
  private Unbinder f;
  private Context g;
  @BindView(2131696053)
  TextView hint_date;
  @BindView(2131696052)
  LinearLayout hint_ll;
  @BindView(2131696054)
  TextView hint_status;
  @BindView(2131696055)
  TextView hint_text;
  @BindView(2131690803)
  LinearLayout house_bill_info_data_ll;
  @BindView(2131690809)
  EditText house_bill_info_money;
  @BindView(2131690806)
  TextView house_bill_info_money_hint;
  @BindView(2131690810)
  ImageView house_bill_info_money_im;
  @BindView(2131690805)
  TextView house_bill_info_money_text;
  @BindView(2131690808)
  TextView house_bill_info_money_tv;
  @BindView(2131690812)
  ImageView iv_easy_pay_guiding;
  @BindView(2131689908)
  SimpleDraweeView iv_pic;
  private String r;
  @BindView(2131690811)
  RelativeLayout rl_easy_pay_guiding;
  private String s;
  private String t;
  @BindView(2131690802)
  Button to_pay_checkstand;
  @BindView(2131690801)
  Button to_pay_money_hint;
  @BindView(2131691210)
  TextView tv_house_name;
  @BindView(2131690979)
  TextView tv_house_price;
  private HouseBillInfoEntity u;
  private LayoutInflater v;
  private String w;
  @BindView(2131692963)
  LinearLayout wyj_hint_ll;
  @BindView(2131692964)
  TextView wyj_hint_text;
  private String x;
  private String y;
  private a z;
  
  private void a()
  {
    this.house_bill_info_money.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((HouseBillInfoActivity.this.house_bill_info_money != null) && (HouseBillInfoActivity.this.to_pay_checkstand != null))
        {
          if ((VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).length() < 2) || (!".".equals(VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).toString().subSequence(VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).length() - 1, VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).length()).toString()))) {
            break label201;
          }
          int i = HouseBillInfoActivity.a(HouseBillInfoActivity.this).indexOf(".");
          int j = VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).subSequence(0, VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).toString().length() - 1).toString().indexOf(".");
          if ((i == -1) || (j == -1)) {
            break label201;
          }
          HouseBillInfoActivity.this.house_bill_info_money.setText(ah.Number(Double.parseDouble(HouseBillInfoActivity.a(HouseBillInfoActivity.this))));
          HouseBillInfoActivity.this.showToast("只能输入正确的数字");
        }
        label201:
        do
        {
          return;
          if ((VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).length() > 4) && (".".equals(VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).toString().subSequence(VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).length() - 4, VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).length() - 3).toString())))
          {
            HouseBillInfoActivity.this.house_bill_info_money.setText(ah.Number(Double.parseDouble(HouseBillInfoActivity.a(HouseBillInfoActivity.this))));
            HouseBillInfoActivity.this.showToast("只能输入小数点后两位数字");
            return;
          }
          if ("zrfq".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this)))
          {
            HouseBillInfoActivity.this.to_pay_checkstand.setText("确认还款￥" + VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).toString());
            return;
          }
        } while ((HouseBillInfoActivity.this.b == null) || (!HouseBillInfoActivity.this.b.isChecked()));
        HouseBillInfoActivity.this.to_pay_checkstand.setText("支付￥" + VdsAgent.trackEditTextSilent(HouseBillInfoActivity.this.house_bill_info_money).toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        HouseBillInfoActivity.a(HouseBillInfoActivity.this, paramAnonymousCharSequence.toString());
      }
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.activity_house_bill_info_rl.addOnLayoutChangeListener(this);
  }
  
  private void a(View paramView)
  {
    paramView.getY();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    paramView = getWindowManager();
    paramView.getDefaultDisplay().getWidth();
    int i = paramView.getDefaultDisplay().getHeight();
    if (arrayOfInt[1] > i - ah.dip2px(this, 100.0F)) {
      ah.setLayoutY(this.iv_easy_pay_guiding, arrayOfInt[1] - ah.dip2px(this, arrayOfInt[1] - (i - ah.dip2px(this, 100.0F)) + 75));
    }
    for (;;)
    {
      this.rl_easy_pay_guiding.setVisibility(0);
      return;
      ah.setLayoutY(this.iv_easy_pay_guiding, arrayOfInt[1] - ah.dip2px(this, 75.0F));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.house_bill_info_money.setEnabled(paramBoolean);
      this.house_bill_info_money_im.setVisibility(0);
      this.house_bill_info_money_hint.setVisibility(0);
      return;
    }
    this.house_bill_info_money.setEnabled(paramBoolean);
    this.house_bill_info_money_im.setVisibility(8);
    this.house_bill_info_money_hint.setVisibility(8);
  }
  
  private void b()
  {
    String str = q.s + e.j.q;
    Map localMap;
    if ("ZZYD".equals(this.s)) {
      localMap = g.buildBillInfo("pzyd", this.t, this.r);
    }
    for (;;)
    {
      com.freelxl.baselibrary.f.d.e("url", str + localMap.toString());
      com.freelxl.baselibrary.d.a.isLog(true);
      com.freelxl.baselibrary.d.a.post(str).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.g, new com.freelxl.baselibrary.d.f.c())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          dismissProgress();
          u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          com.freelxl.baselibrary.f.d.e("jsonObject", paramAnonymouse.toJSONString());
          if ("success".equals(paramAnonymouse.get("status")))
          {
            if (paramAnonymouse.get("data") != null) {
              HouseBillInfoActivity.a(HouseBillInfoActivity.this, (HouseBillInfoEntity)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data").toString(), HouseBillInfoEntity.class));
            }
            HouseBillInfoActivity.c(HouseBillInfoActivity.this);
          }
          for (;;)
          {
            dismissProgress();
            return;
            HouseBillInfoActivity.this.showToast(paramAnonymouse.get("error_message") + "");
          }
        }
      });
      return;
      if ("QRYD".equals(this.s)) {
        localMap = g.buildBillInfo("zzydfqz", this.t, this.r);
      } else {
        localMap = g.buildBillInfo(this.s, this.t, this.r);
      }
    }
  }
  
  private String d(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "";
        if (paramString.equals("unpaid"))
        {
          i = 0;
          continue;
          if (paramString.equals("paying"))
          {
            i = 1;
            continue;
            if (paramString.equals("paid"))
            {
              i = 2;
              continue;
              if (paramString.equals("unwind")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return "未还款";
    return "还款中";
    return "已还款";
    return "已解约";
  }
  
  private void e()
  {
    this.s = getIntent().getStringExtra("payType");
    this.r = getIntent().getStringExtra("uniqueCode");
    this.t = getIntent().getStringExtra("period");
    this.x = getIntent().getStringExtra("old_contract_code");
    this.y = getIntent().getStringExtra("mContentText");
  }
  
  private void e(String paramString)
  {
    j.getReimbursement(this.g, this.r, paramString, this.t, new com.ziroom.commonlibrary.a.a(this.g, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "");
          if (paramAnonymouse != null)
          {
            paramAnonymouse = paramAnonymouse.get("serialNo") + "";
            Intent localIntent = new Intent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), RepayPayStatusActivity.class);
            localIntent.putExtra("serialNo", paramAnonymouse);
            localIntent.putExtra("contract_code", HouseBillInfoActivity.f(HouseBillInfoActivity.this));
            HouseBillInfoActivity.this.startActivityForResult(localIntent, 153);
            HouseBillInfoActivity.this.finish();
          }
        }
        for (;;)
        {
          dismissProgress();
          return;
          HouseBillInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
        }
      }
    });
  }
  
  private SpannableString f(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new StrikethroughSpan(), 6, ah.changeF2Y(this.u.getOrigInt()).length() + 13, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA000")), ah.changeF2Y(this.u.getOrigInt()).length() + 14, paramString.length(), 33);
    return localSpannableString;
  }
  
  private void f()
  {
    this.bill_title.setTitle("账单详情");
    this.bill_title.setBackVisible(true);
    this.bill_title.setOnBackClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ae.notNull(HouseBillInfoActivity.e(HouseBillInfoActivity.this)))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(HouseBillInfoActivity.this).setContent(HouseBillInfoActivity.e(HouseBillInfoActivity.this)).setTitle("").setButtonText("取消", "我知道了").setOnConfirmClickListener(new d.b()
          {
            public void onLeftClick(View paramAnonymous2View) {}
            
            public void onRightClick(View paramAnonymous2View)
            {
              w.onEvent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), "signup_pay_return_know");
              paramAnonymous2View = new Intent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), MainActivity.class);
              if (("pzyd".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this))) || ("ZZYD".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this))) || ("QRYD".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this)))) {
                paramAnonymous2View.putExtra("FRAGMENT_TYPE", 7);
              }
              HouseBillInfoActivity.this.startActivity(paramAnonymous2View);
              HouseBillInfoActivity.this.finish();
              ApplicationEx.c.finishAllActivity();
            }
          }).show();
          return;
        }
        HouseBillInfoActivity.this.finish();
      }
    });
    if (this.u == null) {
      return;
    }
    g();
    String str = this.s;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      this.house_bill_info_money.setText(ah.Number(this.u.getSurplusShouldPay()) + "");
      a("1".equals(this.u.getIsChangePay()));
      return;
      if (!str.equals("fz")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("wyj")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("pzyd")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("ZZYD")) {
        break;
      }
      i = 3;
      break;
      if (!str.equals("QRYD")) {
        break;
      }
      i = 4;
      break;
      if (!str.equals("zrfq")) {
        break;
      }
      i = 5;
      break;
      this.house_bill_info_data_ll.removeAllViews();
      this.house_bill_info_data_ll.addView(h());
      this.house_bill_info_money_text.setText("本次支付");
      this.house_bill_info_money_text.setTextColor(Color.parseColor("#4a4a4a"));
      this.to_pay_checkstand.setText("支付￥" + this.u.getSurplusShouldPay());
      this.hint_ll.setVisibility(0);
      this.wyj_hint_ll.setVisibility(8);
      continue;
      this.house_bill_info_money_text.setText("逾期违约金");
      this.house_bill_info_money_tv.setTextColor(Color.parseColor("#ff6262"));
      this.house_bill_info_money_text.setTextColor(Color.parseColor("#ff6262"));
      this.house_bill_info_money.setTextColor(Color.parseColor("#ff6262"));
      this.hint_ll.setVisibility(8);
      this.wyj_hint_ll.setVisibility(0);
      continue;
      this.house_bill_info_money_text.setText("订金");
      this.house_bill_info_money_text.setTextColor(Color.parseColor("#4a4a4a"));
      this.hint_ll.setVisibility(0);
      this.wyj_hint_ll.setVisibility(8);
      continue;
      this.house_bill_info_money_text.setText("订金");
      this.house_bill_info_money_text.setTextColor(Color.parseColor("#4a4a4a"));
      this.hint_ll.setVisibility(0);
      this.wyj_hint_ll.setVisibility(8);
      continue;
      this.house_bill_info_money_text.setText("保证金");
      this.house_bill_info_money_text.setTextColor(Color.parseColor("#4a4a4a"));
      this.hint_ll.setVisibility(0);
      this.wyj_hint_ll.setVisibility(8);
      continue;
      this.house_bill_info_money_text.setText("总款");
      this.house_bill_info_money_text.setTextColor(Color.parseColor("#4a4a4a"));
      this.house_bill_info_data_ll.addView(i());
      this.to_pay_checkstand.setText("确认还款￥" + this.u.getSurplusShouldPay());
      this.hint_status.setVisibility(0);
      this.hint_status.setText(d(this.u.getPayStatus()));
      if (this.u.getIsConfirmDisplay() == 1) {
        this.to_pay_checkstand.setVisibility(0);
      } else {
        this.to_pay_checkstand.setVisibility(8);
      }
    }
  }
  
  private void g()
  {
    if (this.u == null) {}
    while (this.u.getHouseInfo() == null) {
      return;
    }
    if ((ae.notNull(this.u.getMinPayMoneyView())) && (!"0".equals(this.u.getMinPayMoney()))) {
      this.to_pay_money_hint.setText(this.u.getMinPayMoneyView());
    }
    String str2 = "";
    String str1 = str2;
    if (ae.notNull(this.u.getHouseInfo().getHouseAddress()))
    {
      if (ae.notNull(this.u.getHouseInfo().getHouseTypeStr())) {
        str2 = this.u.getHouseInfo().getHouseTypeStr() + "-";
      }
      str2 = str2 + this.u.getHouseInfo().getHouseAddress();
      str1 = str2;
      if (ae.notNull(this.u.getHouseInfo().getRoomName())) {
        str1 = str2 + "-" + this.u.getHouseInfo().getRoomName();
      }
    }
    this.tv_house_name.setText(str1);
    if (ae.notNull(this.u.getHouseInfo().getHousePrice()))
    {
      str2 = "¥" + this.u.getHouseInfo().getHousePrice();
      str1 = str2;
      if (!ae.notNull(this.u.getHouseInfo().getPriceUnit())) {}
    }
    for (str1 = str2 + "/" + this.u.getHouseInfo().getPriceUnit();; str1 = "")
    {
      this.tv_house_price.setText(str1);
      this.iv_pic.setController(com.freelxl.baselibrary.f.c.frescoController(this.u.getHouseInfo().getPicUrl()));
      if ("wyj".equals(this.s))
      {
        this.wyj_hint_ll.setVisibility(0);
        this.hint_ll.setVisibility(8);
        if (ae.notNull(this.u.getPayRemindDesc()))
        {
          this.wyj_hint_text.setText(this.u.getPayRemindDesc());
          this.wyj_hint_text.setVisibility(0);
          return;
        }
        this.wyj_hint_text.setVisibility(8);
        return;
      }
      if ("zrfq".equals(this.s))
      {
        this.hint_ll.setVisibility(0);
        this.hint_text.setVisibility(8);
        if (ae.notNull(this.u.getShouldPayDate())) {
          this.hint_date.setText("应缴费日期" + this.u.getShouldPayDate());
        }
        while (ae.notNull(this.u.getPayRemindDesc()))
        {
          this.wyj_hint_text.setText(this.u.getPayRemindDesc());
          this.wyj_hint_text.setVisibility(0);
          this.wyj_hint_ll.setVisibility(0);
          return;
          this.hint_date.setVisibility(8);
        }
        this.wyj_hint_text.setVisibility(8);
        this.wyj_hint_ll.setVisibility(8);
        return;
      }
      this.wyj_hint_ll.setVisibility(8);
      this.hint_ll.setVisibility(0);
      if (ae.notNull(this.u.getShouldPayDate())) {
        this.hint_date.setText("应缴费日期" + this.u.getShouldPayDate());
      }
      while (ae.notNull(this.u.getPayRemindDesc()))
      {
        this.hint_text.setText(this.u.getPayRemindDesc());
        this.hint_text.setVisibility(0);
        return;
        this.hint_date.setVisibility(8);
      }
      this.hint_text.setVisibility(8);
      return;
    }
  }
  
  private View h()
  {
    View localView1 = this.v.inflate(2130905012, null);
    Object localObject2 = (LinearLayout)localView1.findViewById(2131697155);
    Object localObject1 = (ImageView)localView1.findViewById(2131697159);
    ((LinearLayout)localObject2).removeAllViews();
    if ((this.u != null) && (this.u.getCostList() != null) && (this.u.getCostList().size() > 0))
    {
      localObject3 = this.u.getCostList().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (HouseBillInfoEntity.HousePayCost)((Iterator)localObject3).next();
        localView2 = this.v.inflate(2130904226, this.house_bill_info_data_ll, false);
        localObject5 = (TextView)localView2.findViewById(2131692968);
        localObject6 = (TextView)localView2.findViewById(2131692969);
        ((TextView)localObject5).setText(((HouseBillInfoEntity.HousePayCost)localObject4).getCostName());
        ((TextView)localObject6).setText(((HouseBillInfoEntity.HousePayCost)localObject4).getCostShouldPayView());
        ((LinearLayout)localObject2).addView(localView2);
      }
    }
    localObject2 = localView1.findViewById(2131697157);
    Object localObject7 = (TextView)localView1.findViewById(2131697160);
    final Object localObject3 = (TextView)localView1.findViewById(2131697161);
    Object localObject4 = localView1.findViewById(2131697171);
    final View localView2 = localView1.findViewById(2131697172);
    Object localObject8 = (TextView)localView1.findViewById(2131697164);
    TextView localTextView1 = (TextView)localView1.findViewById(2131697167);
    TextView localTextView2 = (TextView)localView1.findViewById(2131697169);
    Object localObject5 = localView1.findViewById(2131697165);
    ImageView localImageView = (ImageView)localView1.findViewById(2131697166);
    final Object localObject6 = (LinearLayout)localView1.findViewById(2131697168);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131697170);
    TextView localTextView3 = (TextView)localView1.findViewById(2131697176);
    this.a = ((CheckBox)localView1.findViewById(2131697174));
    this.b = ((CheckBox)localView1.findViewById(2131695062));
    if (this.u.getIsEasyPay() == 1)
    {
      localView2.post(new Runnable()
      {
        public void run()
        {
          if (ae.isNull(ad.getEasyPayTag(HouseBillInfoActivity.d(HouseBillInfoActivity.this)))) {
            HouseBillInfoActivity.a(HouseBillInfoActivity.this, localView2);
          }
        }
      });
      localLinearLayout.setVisibility(0);
      if (Integer.parseInt(this.u.getOrigInt()) > Integer.parseInt(this.u.getNormInt()))
      {
        localTextView3.setText(f("房租分期贷款，原手续费" + ah.changeF2Y(this.u.getOrigInt()) + "元/月，特惠价" + ah.changeF2Y(this.u.getNormInt()) + "元/月"));
        this.a.setOnCheckedChangeListener(this.c);
        this.b.setOnCheckedChangeListener(this.c);
        label494:
        if (!ae.notNull(this.u.getActiveTotalMoneyView())) {
          break label840;
        }
        ((TextView)localObject7).setText(this.u.getActiveTotalMoneyView());
        label519:
        ((TextView)localObject8).setText(this.u.getTotalShouldPayView());
        if (!ae.notNull(this.u.getTotalActualPayFeeView())) {
          break label850;
        }
        localTextView1.setText(this.u.getTotalActualPayFeeView());
        label556:
        if (ae.notNull(this.u.getSurplusShouldPayView())) {
          localTextView2.setText(this.u.getSurplusShouldPayView() + "");
        }
        if (!ae.notNull(this.u.getActiveNames())) {
          break label860;
        }
        ((TextView)localObject3).setText(this.u.getActiveNames());
      }
    }
    for (;;)
    {
      if ((this.u == null) || (this.u.getActualPayList() == null) || (this.u.getActualPayList().size() <= 0)) {
        break label875;
      }
      localObject1 = this.u.getActualPayList().iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject7 = (HouseBillInfoEntity.ActualPayData)((Iterator)localObject1).next();
        localObject8 = this.v.inflate(2130904227, this.house_bill_info_data_ll, false);
        localTextView1 = (TextView)((View)localObject8).findViewById(2131695059);
        localTextView2 = (TextView)((View)localObject8).findViewById(2131695060);
        i += 1;
        localTextView1.setText("第" + i + "次");
        localTextView2.setText(((HouseBillInfoEntity.ActualPayData)localObject7).getActualPayFee());
        ((LinearLayout)localObject6).addView((View)localObject8);
      }
      localTextView3.setText("房租分期贷款，手续费" + this.u.getOrigInt() + "元/月");
      break;
      localLinearLayout.setVisibility(8);
      break label494;
      label840:
      ((View)localObject2).setVisibility(8);
      break label519;
      label850:
      ((View)localObject5).setVisibility(8);
      break label556;
      label860:
      ((View)localObject2).setEnabled(false);
      ((ImageView)localObject1).setVisibility(8);
    }
    label875:
    ((View)localObject5).setEnabled(false);
    ((View)localObject5).setVisibility(8);
    localImageView.setVisibility(8);
    ((View)localObject2).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (HouseBillInfoActivity.h(HouseBillInfoActivity.this))
        {
          localObject3.setVisibility(8);
          HouseBillInfoActivity.b(HouseBillInfoActivity.this, false);
          return;
        }
        localObject3.setVisibility(0);
        HouseBillInfoActivity.b(HouseBillInfoActivity.this, true);
      }
    });
    ((View)localObject5).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (HouseBillInfoActivity.i(HouseBillInfoActivity.this))
        {
          localObject6.setVisibility(8);
          HouseBillInfoActivity.c(HouseBillInfoActivity.this, false);
          return;
        }
        localObject6.setVisibility(0);
        HouseBillInfoActivity.c(HouseBillInfoActivity.this, true);
      }
    });
    ((View)localObject4).setOnClickListener(this.d);
    localView2.setOnClickListener(this.d);
    return localView1;
  }
  
  private View i()
  {
    View localView1 = this.v.inflate(2130905012, null);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131697155);
    localLinearLayout.removeAllViews();
    if ((this.u != null) && (this.u.getCostList() != null) && (this.u.getCostList().size() > 0))
    {
      Iterator localIterator = this.u.getCostList().iterator();
      while (localIterator.hasNext())
      {
        HouseBillInfoEntity.HousePayCost localHousePayCost = (HouseBillInfoEntity.HousePayCost)localIterator.next();
        View localView2 = this.v.inflate(2130904226, this.house_bill_info_data_ll, false);
        TextView localTextView1 = (TextView)localView2.findViewById(2131692968);
        TextView localTextView2 = (TextView)localView2.findViewById(2131692969);
        localTextView1.setText(localHousePayCost.getCostName());
        localTextView2.setText(localHousePayCost.getCostShouldPayView());
        localLinearLayout.addView(localView2);
      }
    }
    localView1.findViewById(2131697156).setVisibility(8);
    return localView1;
  }
  
  private void j()
  {
    startActivity(new Intent(this.g, HouseBillPaySuccessActivity.class));
    finish();
  }
  
  private void k()
  {
    Object localObject;
    if (Float.parseFloat(this.w) == this.u.getSurplusShouldPay()) {
      if ("2".equals(this.u.getContractStrategy()))
      {
        localObject = new Intent(this.g, EnterprisePaySuccessActivity.class);
        ((Intent)localObject).putExtra("sub_amount", this.w);
        ((Intent)localObject).putExtra("contract_code", this.r);
        ((Intent)localObject).putExtra("is_all", "1");
        startActivity((Intent)localObject);
      }
    }
    for (;;)
    {
      if ((this.u.getActualPayList() == null) || (this.u.getActualPayList().size() == 0))
      {
        localObject = GrowingIO.getInstance();
        ((GrowingIO)localObject).setPageGroup(this, "PaySuccessActivity");
        ((GrowingIO)localObject).setPS4(this, "长租首期支付成功");
      }
      finish();
      return;
      localObject = new Intent(this.g, PaySuccessActivity.class);
      ((Intent)localObject).putExtra("contract_code", this.r);
      ((Intent)localObject).putExtra("className", "LeaseConfirmPayActivity");
      ((Intent)localObject).putExtra("sub_amount", this.w);
      ((Intent)localObject).putExtra("pay_status", "yzf");
      String str = getIntent().getStringExtra("wystate");
      if (str != null) {
        ((Intent)localObject).putExtra("wystate", str);
      }
      if (this.x != null)
      {
        ((Intent)localObject).putExtra("new_contract_code", this.r);
        ((Intent)localObject).putExtra("old_contract_code", this.x);
      }
      startActivity((Intent)localObject);
      continue;
      if ("2".equals(this.u.getContractStrategy()))
      {
        localObject = new Intent(this.g, EnterprisePaySuccessActivity.class);
        ((Intent)localObject).putExtra("sub_amount", this.w);
        ((Intent)localObject).putExtra("contract_code", this.r);
        ((Intent)localObject).putExtra("is_all", "0");
        startActivity((Intent)localObject);
      }
      else
      {
        localObject = new Intent(this.g, PayPartActivity.class);
        ((Intent)localObject).putExtra("contract_code", this.r);
        ((Intent)localObject).putExtra("sub_amount", this.w);
        if (this.x != null) {
          ((Intent)localObject).putExtra("old_contract_code", this.x);
        }
        str = getIntent().getStringExtra("wystate");
        if (str != null) {
          ((Intent)localObject).putExtra("wystate", str);
        }
        startActivity((Intent)localObject);
      }
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent(this.g, PaySuccessActivity.class);
    localIntent.putExtra("sub_amount", this.w + "");
    localIntent.putExtra("reserve", "reserve");
    localIntent.putExtra("is_blank", "0");
    startActivity(localIntent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 17) && (ae.notNull(paramIntent.getStringExtra("message")))) {
      showToast(paramIntent.getStringExtra("message"));
    }
    if (paramInt2 == 153)
    {
      b();
      return;
    }
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (ae.notNull(this.y))
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent(this.y).setTitle("").setButtonText("取消", "我知道了").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          w.onEvent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), "signup_pay_return_know");
          paramAnonymousView = new Intent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), MainActivity.class);
          if (("pzyd".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this))) || ("ZZYD".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this))) || ("QRYD".equals(HouseBillInfoActivity.b(HouseBillInfoActivity.this)))) {
            paramAnonymousView.putExtra("FRAGMENT_TYPE", 7);
          }
          HouseBillInfoActivity.this.startActivity(paramAnonymousView);
          HouseBillInfoActivity.this.finish();
          ApplicationEx.c.finishAllActivity();
        }
      }).show();
      return;
    }
    finish();
  }
  
  @OnClick({2131690802, 2131690811})
  @Instrumented
  public void onClick(final View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    int i;
    do
    {
      for (;;)
      {
        return;
        ad.saveEasyPayTag(this, "1");
        this.rl_easy_pay_guiding.setVisibility(8);
        return;
        if (this.u == null)
        {
          showToast("查询支付信息失败，请退出重进");
          return;
        }
        this.w = VdsAgent.trackEditTextSilent(this.house_bill_info_money).toString();
        try
        {
          i = ah.getInt(Float.parseFloat(this.w) * 100.0F);
          if ("zrfq".equals(this.s))
          {
            paramView = i + "";
            com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent(this.u.getPopupMsg()).setTitle("确认还款").setButtonText("再想想", "确认").setOnConfirmClickListener(new d.b()
            {
              public void onLeftClick(View paramAnonymousView) {}
              
              public void onRightClick(View paramAnonymousView)
              {
                HouseBillInfoActivity.this.showProgress("");
                HouseBillInfoActivity.b(HouseBillInfoActivity.this, paramView);
              }
            }).show();
            return;
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            showToast("输入的金额无效，请重新输入");
            i = 0;
          }
          if ("fz".equals(this.s))
          {
            if (this.b.isChecked())
            {
              if (this.u.getBillNumList() == null)
              {
                showToast("获取账单编号失败，请退出重进");
                return;
              }
              if (i != 0)
              {
                str = this.u.getBillNumList().toString();
                paramView = str;
                if (ae.notNull(str)) {
                  paramView = str.replace("[", "").replace("]", "").replace(" ", "");
                }
                if ((ae.notNull(this.u.getPayLimitTime())) && (!"0".equals(this.u.getPayLimitTime())))
                {
                  com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, i, this.s, paramView, this.u.getSystemId(), this.u.getPayLimitTime());
                  return;
                }
                com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, i, this.s, paramView, this.u.getSystemId());
              }
            }
            else
            {
              this.to_pay_checkstand.setEnabled(false);
              j.putLoanEasyPay(this, this.r, this.t, this.u.getLoanType(), this.u.getLoanCode(), this.u.getProductCode(), this.e);
            }
          }
          else if (this.u.getBillNumList() == null)
          {
            showToast("获取账单编号失败，请退出重进");
            return;
          }
        }
      }
    } while (i == 0);
    String str = this.u.getBillNumList().toString();
    paramView = str;
    if (ae.notNull(str)) {
      paramView = str.replace("[", "").replace("]", "").replace(" ", "");
    }
    if ((ae.notNull(this.u.getPayLimitTime())) && (!"0".equals(this.u.getPayLimitTime())))
    {
      com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, i, this.s, paramView, this.u.getSystemId(), this.u.getPayLimitTime());
      return;
    }
    com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, i, this.s, paramView, this.u.getSystemId());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903200);
    this.v = LayoutInflater.from(this);
    this.g = this;
    this.f = ButterKnife.bind(this);
    this.A = getWindowManager().getDefaultDisplay().getHeight();
    this.B = (this.A / 3);
    e();
    b();
    a();
    this.z = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.z, paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.z);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt8 - paramInt4 > this.B))
    {
      this.to_pay_money_hint.setVisibility(0);
      this.to_pay_checkstand.setVisibility(8);
    }
    float f1;
    float f2;
    do
    {
      do
      {
        return;
      } while ((paramInt8 == 0) || (paramInt4 == 0) || (paramInt4 - paramInt8 <= this.B));
      this.to_pay_money_hint.setVisibility(8);
      this.to_pay_checkstand.setVisibility(0);
      for (;;)
      {
        try
        {
          if (this.a.isChecked())
          {
            paramView = this.u.getMinPayMoneyEasyPay();
            f1 = this.u.getSurplusShouldPayEasyPay();
            if (!ae.isNull(VdsAgent.trackEditTextSilent(this.house_bill_info_money).toString())) {
              break;
            }
            this.house_bill_info_money.setText(ah.Number(f1) + "");
            showToast("请输入正确金额");
            return;
          }
        }
        catch (Exception paramView)
        {
          showToast("请输入有效的数字");
          return;
        }
        paramView = this.u.getMinPayMoney();
        f1 = this.u.getSurplusShouldPay();
      }
      f2 = Float.parseFloat(VdsAgent.trackEditTextSilent(this.house_bill_info_money).toString());
      if (this.u == null)
      {
        showToast("数据异常");
        return;
      }
      try
      {
        if (f2 < Float.parseFloat(paramView))
        {
          this.house_bill_info_money.setText(ah.Number(Double.parseDouble(paramView)));
          showToast("单次至少支付" + paramView + "元哟～");
          return;
        }
      }
      catch (Exception paramView)
      {
        this.house_bill_info_money.setText(ah.Number(f1) + "");
        showToast("数据异常");
        return;
      }
    } while (f2 <= f1);
    showToast("请输入正确金额");
    this.house_bill_info_money.setText(ah.Number(f1) + "");
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    if (ae.notNull(paramIntent.getStringExtra("isPay")))
    {
      setResult(66, getIntent());
      finish();
      return;
    }
    e();
    b();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = 0;
      int j = -1;
      int k = paramIntent.getIntExtra("code", -1);
      paramContext = paramIntent.getStringExtra("payType");
      paramIntent = paramIntent.getStringExtra("message");
      HouseBillInfoActivity.this.showToast(paramIntent);
      if (k == 1)
      {
        switch (paramContext.hashCode())
        {
        default: 
          i = j;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return;
            i = j;
            if (paramContext.equals("fz"))
            {
              i = 0;
              continue;
              i = j;
              if (paramContext.equals("wyj"))
              {
                i = 1;
                continue;
                i = j;
                if (paramContext.equals("pzyd"))
                {
                  i = 2;
                  continue;
                  i = j;
                  if (paramContext.equals("ZZYD"))
                  {
                    i = 3;
                    continue;
                    i = j;
                    if (paramContext.equals("QRYD")) {
                      i = 4;
                    }
                  }
                }
              }
            }
            break;
          }
        }
        if ("1".equals(HouseBillInfoActivity.j(HouseBillInfoActivity.this)))
        {
          HouseBillInfoActivity.k(HouseBillInfoActivity.this);
          return;
        }
        HouseBillInfoActivity.l(HouseBillInfoActivity.this);
        return;
        HouseBillInfoActivity.l(HouseBillInfoActivity.this);
        return;
        HouseBillInfoActivity.m(HouseBillInfoActivity.this);
        return;
        paramContext = new Intent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), SubletPaySuccessActivity.class);
        paramContext.putExtra("reserveCode", HouseBillInfoActivity.f(HouseBillInfoActivity.this));
        paramContext.putExtra("isPaySuccess", 1);
        paramContext.putExtra("payType", "ZZYD");
        HouseBillInfoActivity.d(HouseBillInfoActivity.this).startActivity(paramContext);
        return;
        paramContext = new Intent(HouseBillInfoActivity.d(HouseBillInfoActivity.this), SubletPaySuccessActivity.class);
        paramContext.putExtra("contract_code", HouseBillInfoActivity.this.getIntent().getStringExtra("contract_code"));
        paramContext.putExtra("payType", "QRYD");
        HouseBillInfoActivity.d(HouseBillInfoActivity.this).startActivity(paramContext);
        return;
      }
      switch (paramContext.hashCode())
      {
      default: 
        label440:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
        case 0: 
          if (!"1".equals(HouseBillInfoActivity.j(HouseBillInfoActivity.this))) {
            break label568;
          }
          HouseBillInfoActivity.n(HouseBillInfoActivity.this);
          return;
          if (!paramContext.equals("fz")) {
            break label440;
          }
          continue;
          if (!paramContext.equals("wyj")) {
            break label440;
          }
          i = 1;
          continue;
          if (!paramContext.equals("pzyd")) {
            break label440;
          }
          i = 2;
          continue;
          if (!paramContext.equals("ZZYD")) {
            break label440;
          }
          i = 3;
          continue;
          if (!paramContext.equals("QRYD")) {
            break label440;
          }
          i = 4;
        }
      }
      label568:
      paramContext = HouseBillInfoActivity.this.getIntent();
      HouseBillInfoActivity.this.setResult(66, paramContext);
      HouseBillInfoActivity.this.finish();
      return;
      HouseBillInfoActivity.n(HouseBillInfoActivity.this);
      return;
      HouseBillInfoActivity.n(HouseBillInfoActivity.this);
      return;
      HouseBillInfoActivity.n(HouseBillInfoActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/HouseBillInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */