package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuBillInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuBillInfo.ThisTimeNeedPay;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuBillInfo.ZryuBillInfoEntity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuBillInfo.ZryuBillPayDate;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuBillInfoItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignProject;
import java.util.Iterator;
import java.util.List;

public class ZryuSignBillsInfoActivity
  extends BaseActivity
  implements View.OnLayoutChangeListener
{
  private ZryuBillInfo a;
  private Unbinder b;
  @BindView(2131692989)
  EditText bill_info_money;
  @BindView(2131692986)
  TextView bill_info_money_hint;
  @BindView(2131692990)
  ImageView bill_info_money_im;
  @BindView(2131692983)
  RelativeLayout bill_info_money_rl;
  @BindView(2131692985)
  TextView bill_info_money_text;
  @BindView(2131690043)
  Button btn;
  @BindView(2131692991)
  Button btn_hint;
  private Context c;
  private String d;
  private String e;
  private boolean f;
  private int g = 0;
  @BindView(2131692978)
  LinearLayout pay_history_list_ll;
  @BindView(2131692973)
  LinearLayout pay_history_ll;
  @BindView(2131692977)
  TextView pay_history_price_tv;
  @BindView(2131692976)
  ImageView pay_history_title_iv;
  @BindView(2131692974)
  RelativeLayout pay_history_title_rl;
  @BindView(2131692975)
  TextView pay_history_title_tv;
  private int r = 0;
  @BindView(2131692982)
  View remain_money_line;
  @BindView(2131692981)
  TextView remain_money_price_tv;
  @BindView(2131692979)
  RelativeLayout remain_money_rl;
  @BindView(2131692980)
  TextView remain_money_title_tv;
  @BindView(2131696578)
  RelativeLayout rl_house_info;
  private boolean s = false;
  @BindView(2131691098)
  SimpleDraweeView sdv;
  private boolean t;
  @BindView(2131692968)
  TextView tv_cost_name;
  @BindView(2131692969)
  TextView tv_cost_value;
  @BindView(2131696579)
  TextView tv_house_info_add;
  @BindView(2131696404)
  TextView tv_house_info_name;
  @BindView(2131696402)
  TextView tv_house_info_price;
  private a u;
  private String v;
  @BindView(2131692963)
  LinearLayout wyj_hint_ll;
  @BindView(2131692964)
  TextView wyj_hint_text;
  @BindView(2131692959)
  LinearLayout zryu_bill_activity_ll;
  @BindView(2131692958)
  ScrollView zryu_bill_activity_sv;
  @BindView(2131692970)
  LinearLayout zryu_bill_activitys_info;
  @BindView(2131692966)
  LinearLayout zryu_bill_activitys_ll;
  @BindView(2131692967)
  LinearLayout zryu_bill_activitys_title_ll;
  @BindView(2131692962)
  TextView zryu_bill_info_date;
  @BindView(2131692965)
  LinearLayout zryu_bill_info_list;
  @BindView(2131692957)
  LinearLayout zryu_bill_info_ll;
  @BindView(2131692961)
  TextView zryu_bill_info_title;
  @BindView(2131692960)
  LinearLayout zryu_bill_info_title_ll;
  @BindView(2131692972)
  TextView zryu_bill_pay_all_money_tv;
  @BindView(2131692971)
  TextView zryu_bill_pay_all_tv;
  
  private View a(ZryuBillInfoItem paramZryuBillInfoItem)
  {
    View localView = View.inflate(this, 2130904607, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131692968);
    TextView localTextView2 = (TextView)localView.findViewById(2131692969);
    localTextView1.setText(paramZryuBillInfoItem.getName());
    localTextView2.setText(paramZryuBillInfoItem.getValue());
    if (com.freelxl.baselibrary.f.f.notNull(paramZryuBillInfoItem.getColor()))
    {
      localTextView1.setTextColor(Color.parseColor(paramZryuBillInfoItem.getColor()));
      localTextView2.setTextColor(Color.parseColor(paramZryuBillInfoItem.getColor()));
    }
    return localView;
  }
  
  private void a()
  {
    j.getBillInfo(this, this.d, this.e, this.v, new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.f(ZryuBillInfo.class))
    {
      public void onSuccess(int paramAnonymousInt, ZryuBillInfo paramAnonymousZryuBillInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousZryuBillInfo);
        ZryuSignBillsInfoActivity.a(ZryuSignBillsInfoActivity.this, paramAnonymousZryuBillInfo);
        ZryuSignBillsInfoActivity.b(ZryuSignBillsInfoActivity.this, ZryuSignBillsInfoActivity.a(ZryuSignBillsInfoActivity.this));
      }
    });
  }
  
  private void a(ZryuBillInfo paramZryuBillInfo)
  {
    if (paramZryuBillInfo == null) {
      return;
    }
    Object localObject1 = paramZryuBillInfo.getPayInfo();
    Object localObject2;
    if (localObject1 != null)
    {
      if (ae.notNull(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getName())) {
        this.zryu_bill_pay_all_tv.setText(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getName());
      }
      if (ae.notNull(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getValue())) {
        this.zryu_bill_pay_all_money_tv.setText(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getValue());
      }
      this.zryu_bill_info_list.removeAllViews();
      if ((paramZryuBillInfo.getPayInfo() != null) && (paramZryuBillInfo.getPayInfo().getList() != null))
      {
        localObject1 = paramZryuBillInfo.getPayInfo().getList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ZryuBillInfoItem)((Iterator)localObject1).next();
          this.zryu_bill_info_list.addView(a((ZryuBillInfoItem)localObject2));
        }
      }
    }
    else
    {
      this.zryu_bill_info_list.setVisibility(8);
    }
    localObject1 = paramZryuBillInfo.getProjectInfo();
    if (localObject1 != null)
    {
      this.tv_house_info_name.setText(((ZryuSignProject)localObject1).getProName());
      this.tv_house_info_add.setText(((ZryuSignProject)localObject1).getProAddress());
      this.tv_house_info_price.setText(((ZryuSignProject)localObject1).getRoomSalesPrice() + "");
      this.sdv.setController(com.freelxl.baselibrary.f.c.frescoController(((ZryuSignProject)localObject1).getProHeadFigureUrl()));
      this.rl_house_info.setVisibility(0);
      localObject1 = paramZryuBillInfo.getShouldPayDate();
      if (localObject1 == null) {
        break label627;
      }
      this.zryu_bill_info_title_ll.setVisibility(0);
      if ((!ae.notNull(((ZryuBillInfo.ZryuBillPayDate)localObject1).getName())) || (!ae.notNull(((ZryuBillInfo.ZryuBillPayDate)localObject1).getValue()))) {
        break label487;
      }
      this.zryu_bill_info_title.setVisibility(0);
      this.zryu_bill_info_title.setText(((ZryuBillInfo.ZryuBillPayDate)localObject1).getName() + ((ZryuBillInfo.ZryuBillPayDate)localObject1).getValue());
      label295:
      if (!"1".equals(((ZryuBillInfo.ZryuBillPayDate)localObject1).getPenaltyWarn())) {
        break label511;
      }
      this.wyj_hint_ll.setVisibility(0);
      this.zryu_bill_info_date.setVisibility(8);
      if (!ae.notNull(((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc())) {
        break label499;
      }
      this.wyj_hint_text.setText(((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc());
      label346:
      localObject1 = paramZryuBillInfo.getActivityInfo();
      if (localObject1 == null) {
        break label839;
      }
      this.zryu_bill_activitys_ll.setVisibility(0);
      if (!com.freelxl.baselibrary.f.f.notNull(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getName())) {
        break label639;
      }
      this.tv_cost_name.setText(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getName());
      label384:
      if (!com.freelxl.baselibrary.f.f.notNull(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getValue())) {
        break label652;
      }
      this.tv_cost_value.setText(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getValue());
    }
    for (;;)
    {
      label405:
      if (((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getList() != null) {
        if (((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getList().size() > 0)
        {
          this.zryu_bill_activitys_info.removeAllViews();
          localObject1 = ((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getList().iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ZryuBillInfoItem)((Iterator)localObject1).next();
              this.zryu_bill_activitys_info.addView(b((ZryuBillInfoItem)localObject2));
              continue;
              this.rl_house_info.setVisibility(8);
              break;
              label487:
              this.zryu_bill_info_title.setVisibility(8);
              break label295;
              label499:
              this.wyj_hint_ll.setVisibility(8);
              break label346;
              label511:
              this.wyj_hint_ll.setVisibility(8);
              this.zryu_bill_info_date.setVisibility(0);
              if (ae.notNull(((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc()))
              {
                if (!com.freelxl.baselibrary.f.f.notNull(((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc())) {
                  break label346;
                }
                if (((ZryuBillInfo.ZryuBillPayDate)localObject1).getTime() != null)
                {
                  localObject2 = ((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc().replace("{1}", ((ZryuBillInfo.ZryuBillPayDate)localObject1).getTime());
                  ah.setTextColor(this.zryu_bill_info_date, (String)localObject2, ((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc().indexOf("{1}"), ((ZryuBillInfo.ZryuBillPayDate)localObject1).getTime().length(), "#000000");
                  break label346;
                }
                this.zryu_bill_info_date.setText(((ZryuBillInfo.ZryuBillPayDate)localObject1).getDesc());
                break label346;
              }
              this.zryu_bill_info_date.setVisibility(8);
              break label346;
              label627:
              this.zryu_bill_info_title_ll.setVisibility(8);
              break label346;
              label639:
              this.tv_cost_name.setText("");
              break label384;
              label652:
              this.tv_cost_value.setText("");
              break label405;
            }
          }
          this.zryu_bill_activitys_info.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      localObject1 = paramZryuBillInfo.getHavePayInfo();
      if (localObject1 == null) {
        break label1095;
      }
      this.pay_history_ll.setVisibility(0);
      if (com.freelxl.baselibrary.f.f.notNull(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getName())) {
        this.pay_history_title_tv.setText(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getName());
      }
      if (com.freelxl.baselibrary.f.f.notNull(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getValue())) {
        this.pay_history_price_tv.setText(((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getValue());
      }
      if ((((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getList() == null) || (((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getList().size() <= 0)) {
        break;
      }
      this.pay_history_title_iv.setVisibility(0);
      a(true);
      this.pay_history_list_ll.removeAllViews();
      localObject1 = ((ZryuBillInfo.ZryuBillInfoEntity)localObject1).getList().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ZryuBillInfoItem)((Iterator)localObject1).next();
        this.pay_history_list_ll.addView(a((ZryuBillInfoItem)localObject2));
      }
      this.zryu_bill_activitys_info.setVisibility(8);
      continue;
      this.zryu_bill_activitys_info.setVisibility(8);
      continue;
      label839:
      this.zryu_bill_activitys_ll.setVisibility(8);
    }
    this.pay_history_title_iv.setVisibility(8);
    label860:
    localObject1 = paramZryuBillInfo.getLeftPayInfo();
    if (localObject1 != null)
    {
      this.remain_money_rl.setVisibility(0);
      this.remain_money_line.setVisibility(0);
      if (ae.notNull(((ZryuBillInfoItem)localObject1).getName()))
      {
        this.remain_money_title_tv.setText(((ZryuBillInfoItem)localObject1).getName());
        label906:
        if (!ae.notNull(((ZryuBillInfoItem)localObject1).getValue())) {
          break label1120;
        }
        this.remain_money_price_tv.setText(((ZryuBillInfoItem)localObject1).getValue());
        label927:
        paramZryuBillInfo = paramZryuBillInfo.getThisTimeNeedPay();
        if (paramZryuBillInfo == null) {
          break label1217;
        }
        this.bill_info_money_rl.setVisibility(0);
        if (!com.freelxl.baselibrary.f.f.notNull(paramZryuBillInfo.getName())) {
          break label1154;
        }
        this.bill_info_money_text.setText(paramZryuBillInfo.getName());
        label965:
        if (!ae.notNull(paramZryuBillInfo.getNeedPay())) {
          break label1167;
        }
        this.bill_info_money.setText(ah.changeF2Y(paramZryuBillInfo.getNeedPay()));
        this.btn.setText("去支付¥" + VdsAgent.trackEditTextSilent(this.bill_info_money).toString());
      }
    }
    for (;;)
    {
      if (!"1".equals(paramZryuBillInfo.getIsChangePay())) {
        break label1190;
      }
      this.btn_hint.setText(paramZryuBillInfo.getMinPayMoneyDesc());
      this.bill_info_money.setEnabled(true);
      this.bill_info_money_hint.setVisibility(0);
      this.bill_info_money_im.setVisibility(0);
      if (!com.freelxl.baselibrary.f.f.notNull(paramZryuBillInfo.getIsChangePayDesc())) {
        break;
      }
      this.bill_info_money_hint.setText(paramZryuBillInfo.getIsChangePayDesc());
      return;
      label1095:
      this.pay_history_ll.setVisibility(8);
      break label860;
      this.remain_money_title_tv.setText("");
      break label906;
      label1120:
      this.remain_money_price_tv.setText("");
      break label927;
      this.remain_money_rl.setVisibility(8);
      this.remain_money_line.setVisibility(8);
      break label927;
      label1154:
      this.bill_info_money_text.setText("");
      break label965;
      label1167:
      this.bill_info_money.setText("");
      this.btn.setText("去支付");
    }
    label1190:
    this.bill_info_money.setEnabled(false);
    this.bill_info_money_hint.setVisibility(8);
    this.bill_info_money_im.setVisibility(8);
    return;
    label1217:
    this.bill_info_money_rl.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean)
    {
      this.pay_history_list_ll.setVisibility(0);
      this.pay_history_title_iv.setBackgroundResource(2130840135);
      return;
    }
    this.pay_history_list_ll.setVisibility(8);
    this.pay_history_title_iv.setBackgroundResource(2130840139);
  }
  
  private View b(ZryuBillInfoItem paramZryuBillInfoItem)
  {
    View localView = View.inflate(this, 2130904606, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131692968);
    TextView localTextView2 = (TextView)localView.findViewById(2131692969);
    localTextView1.setText(paramZryuBillInfoItem.getName());
    localTextView2.setText(paramZryuBillInfoItem.getValue());
    if (com.freelxl.baselibrary.f.f.notNull(paramZryuBillInfoItem.getColor()))
    {
      localTextView1.setTextColor(Color.parseColor(paramZryuBillInfoItem.getColor()));
      localTextView2.setTextColor(Color.parseColor(paramZryuBillInfoItem.getColor()));
    }
    return localView;
  }
  
  private void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager.isActive()) && (getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  private void e()
  {
    String str = VdsAgent.trackEditTextSilent(this.bill_info_money).toString();
    int i = ah.getInt(Float.parseFloat(str) * 100.0F);
    int j = Integer.parseInt(this.a.getThisTimeNeedPay().getNeedPay());
    Intent localIntent = new Intent(this.c, ZryuSignPaySuccessActivity.class);
    localIntent.putExtra("contractId", this.d);
    localIntent.putExtra("contractCode", this.a.getContractCode());
    localIntent.putExtra("period", this.e);
    localIntent.putExtra("type", this.v);
    localIntent.putExtra("signType", this.a.getSignType());
    if (j <= i) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isPaySuccess", bool);
      localIntent.putExtra("money", str);
      startActivity(localIntent);
      finish();
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (this.t)
    {
      super.onBackPressed();
      return;
    }
    d.newBuilder(this).setContent("您需要在支付有效期前完成首期房租支付，在“我的合同”里可以找到待支付合同进行支付").setTitle("提示").setButtonText("取消", "我知道了").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(ZryuSignBillsInfoActivity.b(ZryuSignBillsInfoActivity.this), MainActivity.class);
        paramAnonymousView.putExtra("FRAGMENT_TYPE", 7);
        ZryuSignBillsInfoActivity.this.startActivity(paramAnonymousView);
        ZryuSignBillsInfoActivity.this.finish();
      }
    }).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903603);
    this.b = ButterKnife.bind(this);
    this.c = this;
    this.r = getWindowManager().getDefaultDisplay().getHeight();
    this.g = (this.r / 3);
    this.d = getIntent().getStringExtra("contractId");
    this.e = getIntent().getStringExtra("period");
    this.t = getIntent().getBooleanExtra("isBack", true);
    this.v = getIntent().getStringExtra("type");
    a();
    this.zryu_bill_info_ll.addOnLayoutChangeListener(this);
    this.u = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.u, paramBundle);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0) && (paramInt8 - paramInt4 > this.g))
    {
      this.s = true;
      this.btn_hint.setVisibility(0);
      this.btn.setVisibility(8);
    }
    while ((paramInt8 == 0) || (paramInt4 == 0) || (paramInt4 - paramInt8 <= this.g)) {
      return;
    }
    this.s = false;
    this.btn_hint.setVisibility(8);
    this.btn.setVisibility(0);
    float f1;
    try
    {
      paramView = ah.changeF2Y(this.a.getThisTimeNeedPay().getMinPayMoney());
      f1 = Float.parseFloat(ah.changeF2Y(this.a.getThisTimeNeedPay().getNeedPay()));
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.bill_info_money).toString()))
      {
        this.bill_info_money.setText(ah.Number(f1) + "");
        showToast("请输入正确金额");
        return;
      }
    }
    catch (Exception paramView)
    {
      showToast("请输入有效的数字");
      return;
    }
    float f2 = Float.parseFloat(VdsAgent.trackEditTextSilent(this.bill_info_money).toString());
    if (this.a == null)
    {
      showToast("数据异常");
      return;
    }
    try
    {
      if (f2 < Float.parseFloat(paramView))
      {
        this.bill_info_money.setText(ah.Number(Double.parseDouble(paramView)));
        showToast("单次至少支付" + paramView + "元哟～");
      }
      for (;;)
      {
        this.btn.setText("去支付¥" + VdsAgent.trackEditTextSilent(this.bill_info_money).toString());
        return;
        if (f2 > f1)
        {
          showToast("请输入正确金额");
          this.bill_info_money.setText(ah.Number(f1) + "");
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        this.bill_info_money.setText(ah.Number(f1) + "");
        showToast("数据异常");
      }
    }
  }
  
  @OnClick({2131692974, 2131690043, 2131689492, 2131692958, 2131692959})
  public void onViewClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
    case 2131692958: 
    case 2131692959: 
    case 2131692974: 
    case 2131690043: 
      do
      {
        do
        {
          return;
          b();
          return;
        } while (this.pay_history_title_iv.getVisibility() != 0);
        if (!this.f) {
          bool = true;
        }
        a(bool);
        return;
      } while (this.a == null);
      paramView = VdsAgent.trackEditTextSilent(this.bill_info_money).toString();
      try
      {
        i = ah.getInt(Float.parseFloat(paramView) * 100.0F);
        if (this.a.getPayEndTime() > 0L)
        {
          com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, i, this.a.getBillType(), this.a.getBillNumList(), this.a.getSystemId(), this.a.getPayEndTime() + "");
          return;
        }
      }
      catch (Exception paramView)
      {
        int i;
        for (;;)
        {
          showToast("输入的金额无效，请重新输入");
          i = 0;
        }
        com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, i, this.a.getBillType(), this.a.getBillNumList(), this.a.getSystemId());
        return;
      }
    }
    if (this.t)
    {
      finish();
      return;
    }
    d.newBuilder(this).setContent("您需要在支付有效期前完成首期房租支付，在“我的合同”里可以找到待支付合同进行支付").setTitle("提示").setButtonText("取消", "我知道了").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(ZryuSignBillsInfoActivity.b(ZryuSignBillsInfoActivity.this), MainActivity.class);
        paramAnonymousView.putExtra("FRAGMENT_TYPE", 7);
        ZryuSignBillsInfoActivity.this.startActivity(paramAnonymousView);
        ZryuSignBillsInfoActivity.this.finish();
      }
    }).show();
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
            if (paramContext.equals("1007"))
            {
              i = 0;
              continue;
              i = j;
              if (paramContext.equals("1001")) {
                i = 1;
              }
            }
            break;
          }
        }
        ZryuSignBillsInfoActivity.c(ZryuSignBillsInfoActivity.this);
        return;
        ZryuSignBillsInfoActivity.c(ZryuSignBillsInfoActivity.this);
        return;
      }
      switch (paramContext.hashCode())
      {
      default: 
        label164:
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
        case 0: 
          ZryuSignBillsInfoActivity.d(ZryuSignBillsInfoActivity.this);
          return;
          if (!paramContext.equals("1007")) {
            break label164;
          }
          continue;
          if (!paramContext.equals("1001")) {
            break label164;
          }
          i = 1;
        }
      }
      ZryuSignBillsInfoActivity.d(ZryuSignBillsInfoActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignBillsInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */