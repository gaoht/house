package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.signed.a.h;
import com.ziroom.ziroomcustomer.termination.a.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class LoanInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A = q.s + e.a.q;
  private com.ziroom.ziroomcustomer.termination.a B;
  private com.ziroom.commonlibrary.a.a<e> C = new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.c())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      LoanInfoActivity.c(LoanInfoActivity.this, "");
      LoanInfoActivity.a(LoanInfoActivity.this, 0);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      com.freelxl.baselibrary.f.d.e("okhttp", paramAnonymouse.toJSONString());
      if ("0".equals(paramAnonymouse.get("code") + ""))
      {
        paramAnonymouse = (h)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "", h.class);
        if (paramAnonymouse != null)
        {
          LoanInfoActivity.a(LoanInfoActivity.this, paramAnonymouse);
          if ((paramAnonymouse.getLoanStatus() != null) && (!LoanInfoActivity.b(LoanInfoActivity.this)))
          {
            LoanInfoActivity.a(LoanInfoActivity.this, paramAnonymouse.getLoanStatus());
            LoanInfoActivity.b(LoanInfoActivity.this, LoanInfoActivity.c(LoanInfoActivity.this));
            if ((LoanInfoActivity.c(LoanInfoActivity.this) != null) && (LoanInfoActivity.c(LoanInfoActivity.this).equals("processing"))) {
              LoanInfoActivity.e(LoanInfoActivity.this).schedule(LoanInfoActivity.d(LoanInfoActivity.this), 0L, 10000L);
            }
          }
          LoanInfoActivity.this.mTvLender.setText(paramAnonymouse.getLoanMoneyLender());
          LoanInfoActivity.this.mTvAmount.setText(paramAnonymouse.getLoanMoney());
          LoanInfoActivity.this.mTvRepayment.setText(paramAnonymouse.getPeriodPayMoney());
          LoanInfoActivity.this.mTvFee.setText(paramAnonymouse.getPeriodInterest());
          LoanInfoActivity.c(LoanInfoActivity.this, paramAnonymouse.getCouponCode());
          if (!TextUtils.isEmpty(paramAnonymouse.getCouponCode()))
          {
            LoanInfoActivity.this.mTvVoucher.setText("-¥" + paramAnonymouse.getCouponValue().divide(new BigDecimal(100)));
            LoanInfoActivity.a(LoanInfoActivity.this, paramAnonymouse.getCouponValue().intValue());
            LoanInfoActivity.this.mTvVoucher.setTextColor(LoanInfoActivity.this.getResources().getColor(2131624516));
          }
        }
      }
    }
  };
  private final Timer D = new Timer();
  private TimerTask E = new TimerTask()
  {
    public void run()
    {
      LoanInfoActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          UserInfo localUserInfo = ApplicationEx.c.getUser();
          if ((localUserInfo != null) && (ApplicationEx.c.isLoginState()))
          {
            j.getLoanstatus(LoanInfoActivity.this, localUserInfo.getUid(), LoanInfoActivity.g(LoanInfoActivity.this), new com.ziroom.commonlibrary.a.a(LoanInfoActivity.this, new com.freelxl.baselibrary.d.f.c())
            {
              public void onFailure(Throwable paramAnonymous3Throwable)
              {
                super.onFailure(paramAnonymous3Throwable);
              }
              
              public void onSuccess(int paramAnonymous3Int, e paramAnonymous3e)
              {
                super.onSuccess(paramAnonymous3Int, paramAnonymous3e);
                if ("0".equals(paramAnonymous3e.get("code") + ""))
                {
                  paramAnonymous3e = (com.ziroom.ziroomcustomer.signed.a.g)com.alibaba.fastjson.a.parseObject(paramAnonymous3e.get("data").toString(), com.ziroom.ziroomcustomer.signed.a.g.class);
                  if ((paramAnonymous3e != null) && (ae.notNull(paramAnonymous3e.getLoanStatus())))
                  {
                    String str = paramAnonymous3e.getLoanStatus();
                    if ((str != null) && (!str.equals(LoanInfoActivity.c(LoanInfoActivity.this))))
                    {
                      LoanInfoActivity.a(LoanInfoActivity.this, paramAnonymous3e.getLoanStatus());
                      LoanInfoActivity.b(LoanInfoActivity.this, LoanInfoActivity.c(LoanInfoActivity.this));
                    }
                    if ((str != null) && ((str.equals("fail")) || (str.equals("success")))) {
                      LoanInfoActivity.e(LoanInfoActivity.this).cancel();
                    }
                  }
                }
                do
                {
                  return;
                  LoanInfoActivity.this.showToast(paramAnonymous3e.get("message") + "");
                } while (LoanInfoActivity.e(LoanInfoActivity.this) == null);
                LoanInfoActivity.e(LoanInfoActivity.this).cancel();
              }
            });
            return;
          }
          LoanInfoActivity.this.showToast("登录信息过期");
        }
      });
    }
  };
  private Handler F = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69665: 
        LoanInfoActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          localObject = VdsAgent.trackEditTextSilent(LoanInfoActivity.i(LoanInfoActivity.this)).toString();
          if (ae.notNull((String)localObject)) {
            LoanInfoActivity.c(LoanInfoActivity.this, (String)localObject);
          }
          paramAnonymousMessage = new BigDecimal(((Float)paramAnonymousMessage.getObject()).floatValue());
          UserInfo localUserInfo;
          if (LoanInfoActivity.l(LoanInfoActivity.this) != null)
          {
            localObject = LoanInfoActivity.l(LoanInfoActivity.this).getCommission();
            if ((localObject != null) && (((BigDecimal)localObject).compareTo(BigDecimal.ZERO) > 0))
            {
              localUserInfo = ApplicationEx.c.getUser();
              if ((ApplicationEx.c.isLoginState()) && (localUserInfo != null))
              {
                if (((BigDecimal)localObject).compareTo(paramAnonymousMessage) <= 0) {
                  break label256;
                }
                LoanInfoActivity.a(LoanInfoActivity.this, paramAnonymousMessage.multiply(new BigDecimal(100)).intValue());
              }
            }
          }
          for (;;)
          {
            j.getZwhiteLoanPayInfo(LoanInfoActivity.this, localUserInfo.getUid(), LoanInfoActivity.g(LoanInfoActivity.this), LoanInfoActivity.m(LoanInfoActivity.this), LoanInfoActivity.n(LoanInfoActivity.this), LoanInfoActivity.o(LoanInfoActivity.this));
            LoanInfoActivity.p(LoanInfoActivity.this).dismiss();
            return;
            label256:
            LoanInfoActivity.a(LoanInfoActivity.this, ((BigDecimal)localObject).multiply(new BigDecimal(100)).intValue());
          }
        }
        LoanInfoActivity.j(LoanInfoActivity.this).setVisibility(0);
        LoanInfoActivity.k(LoanInfoActivity.this).setText(paramAnonymousMessage.getMessage());
        return;
      }
      Object localObject = (l)paramAnonymousMessage.obj;
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        paramAnonymousMessage = new Intent(LoanInfoActivity.this, MainActivity.class);
        LoanInfoActivity.this.startActivityAndFinish(paramAnonymousMessage);
      }
      for (;;)
      {
        LoanInfoActivity.this.dismissProgress();
        return;
        LoanInfoActivity.this.showToast(paramAnonymousMessage.getMessage());
      }
    }
  };
  public Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        paramAnonymousMessage = (String)paramAnonymousMessage.obj;
        LoanInfoActivity.this.showToast(paramAnonymousMessage);
        return;
      }
      LoanInfoActivity.this.mBtnSubmit.setEnabled(true);
    }
  };
  private Unbinder b;
  private Dialog c;
  private LinearLayout d;
  private TextView e;
  private EditText f;
  private String g;
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131691111)
  CheckBox mCbAgreeContract;
  @BindView(2131691102)
  LinearLayout mLlStatus;
  @BindView(2131691112)
  TextView mTvAgreeContract;
  @BindView(2131691105)
  TextView mTvAmount;
  @BindView(2131691107)
  TextView mTvFee;
  @BindView(2131691104)
  TextView mTvLender;
  @BindView(2131691106)
  TextView mTvRepayment;
  @BindView(2131689822)
  TextView mTvStatus;
  @BindView(2131691103)
  TextView mTvStatusDesc;
  @BindView(2131691110)
  TextView mTvVoucher;
  @BindView(2131691109)
  TextView mTvVoucherLabel;
  @BindView(2131691108)
  View mVDividerVoucher;
  @BindView(2131691113)
  View mVMasking;
  private String r;
  private String s;
  private String t;
  private int u;
  private HouseDetail v;
  private String w = "unLoan";
  private h x;
  private boolean y = false;
  private boolean z = false;
  
  private void a()
  {
    Bundle localBundle = getIntent().getExtras();
    this.z = localBundle.getBoolean("isEasilyPay");
    this.y = localBundle.getBoolean("is_back_pre");
    this.g = localBundle.getString("contract_code");
    this.r = localBundle.getString("old_contract_code");
    if (TextUtils.isEmpty(this.r))
    {
      this.s = "0";
      if (this.z) {
        this.mLlStatus.setVisibility(8);
      }
      this.v = ((HouseDetail)localBundle.getSerializable("detail"));
      this.mBztb.setTitle("贷款信息");
      this.mBztb.setBackVisible(true);
      this.mBztb.setOnBackClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LoanInfoActivity.a(LoanInfoActivity.this);
        }
      });
      if (!"1".equals(this.s)) {
        break label195;
      }
      this.mVDividerVoucher.setVisibility(8);
      this.mTvVoucherLabel.setVisibility(8);
      this.mTvVoucher.setVisibility(8);
    }
    for (;;)
    {
      this.mBtnSubmit.setOnClickListener(this);
      this.mTvAgreeContract.setOnClickListener(this);
      return;
      this.s = "1";
      break;
      label195:
      this.mVDividerVoucher.setVisibility(0);
      this.mTvVoucherLabel.setVisibility(0);
      this.mTvVoucher.setVisibility(0);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTvVoucher.setOnClickListener(this);
      this.mCbAgreeContract.setEnabled(true);
      this.mTvAgreeContract.setEnabled(true);
      this.mVMasking.setVisibility(8);
      return;
    }
    this.mTvVoucher.setOnClickListener(null);
    this.mCbAgreeContract.setEnabled(false);
    this.mTvAgreeContract.setEnabled(false);
    this.mVMasking.setVisibility(0);
  }
  
  private void b()
  {
    if ((ApplicationEx.c.getUser() != null) && (ApplicationEx.c.isLoginState()))
    {
      j.getZwhiteLoanPayInfo(this, this.g, this.C);
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(this, "登录信息过期！");
  }
  
  private void back()
  {
    if (this.y)
    {
      finish();
      return;
    }
    String str = "";
    if (this.w.equals("unLoan")) {
      str = "您可以从“我的合同”里进入查看当前合同提交申请并进行后续支付";
    }
    for (;;)
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent(str).setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            paramAnonymousView = new Intent(LoanInfoActivity.this, MainActivity.class);
            LoanInfoActivity.this.startActivityAndFinish(paramAnonymousView);
          }
        }
      }).build().show();
      return;
      if (this.w.equals("processing")) {
        str = "您可以从“我的合同”里进入查看当前合同的申请状态并进行后续支付";
      } else if (this.w.equals("fail")) {
        str = "您可以从“我的合同”里进入关闭当前合同";
      } else if (this.w.equals("success")) {
        str = "您可以从“我的合同”里进入查看当前合同并进行后续支付";
      }
    }
  }
  
  private void d(String paramString)
  {
    if (paramString.equals("unLoan"))
    {
      this.mBtnSubmit.setText("提交贷款申请");
      this.mBtnSubmit.setEnabled(true);
      this.mLlStatus.setVisibility(8);
      a(true);
      this.mCbAgreeContract.setChecked(false);
    }
    do
    {
      return;
      if (paramString.equals("processing"))
      {
        this.mBtnSubmit.setText("下一步");
        this.mBtnSubmit.setEnabled(false);
        this.mLlStatus.setVisibility(0);
        this.mTvStatus.setText("已提交审核");
        this.mTvStatusDesc.setText("请耐心等待，审核完成后即可进行支付");
        a(false);
        this.mCbAgreeContract.setChecked(true);
        return;
      }
      if (paramString.equals("success"))
      {
        this.mBtnSubmit.setText("下一步");
        this.mBtnSubmit.setEnabled(true);
        this.mLlStatus.setVisibility(0);
        this.mTvStatus.setText("审核通过");
        this.mTvStatusDesc.setText("审核已完成，请尽快完成支付");
        a(false);
        this.mCbAgreeContract.setChecked(true);
        return;
      }
    } while (!paramString.equals("fail"));
    if (TextUtils.isEmpty(this.r))
    {
      this.mBtnSubmit.setText("关闭合同");
      this.mBtnSubmit.setEnabled(true);
    }
    for (;;)
    {
      this.mLlStatus.setVisibility(0);
      this.mTvStatus.setText("抱歉，无法进行贷款");
      this.mTvStatusDesc.setText("由于资金方可贷款金额不足，无法进行贷款，请关闭合同重新签约");
      a(false);
      this.mCbAgreeContract.setChecked(true);
      return;
      this.mBtnSubmit.setText("请联系管家关闭合同");
      this.mBtnSubmit.setEnabled(false);
    }
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((localUserInfo != null) && (ApplicationEx.c.isLoginState()))
    {
      j.submitContractLoanInfo(this, localUserInfo.getUid(), this.g, new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.c())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          com.freelxl.baselibrary.f.d.e("okhttp", paramAnonymouse.toJSONString());
          if ("0".equals(paramAnonymouse.get("code") + "")) {
            if (LoanInfoActivity.b(LoanInfoActivity.this))
            {
              paramAnonymouse = new Intent(this.b, EasilyPayLoanInfoActivity.class);
              paramAnonymouse.putExtra("mContractCode", LoanInfoActivity.g(LoanInfoActivity.this));
              paramAnonymouse.putExtra("isBack", false);
              LoanInfoActivity.this.startActivity(paramAnonymouse);
              ApplicationEx.c.finishAllActivity();
              LoanInfoActivity.this.finish();
            }
          }
          for (;;)
          {
            dismissProgress();
            return;
            LoanInfoActivity.e(LoanInfoActivity.this).schedule(LoanInfoActivity.d(LoanInfoActivity.this), 0L, 10000L);
            LoanInfoActivity.this.mBtnSubmit.setEnabled(false);
            LoanInfoActivity.this.mCbAgreeContract.setEnabled(false);
            LoanInfoActivity.this.mTvVoucher.setEnabled(false);
            continue;
            LoanInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
            if ((LoanInfoActivity.b(LoanInfoActivity.this)) && (("90002".equals(paramAnonymouse.get("code") + "")) || ("90003".equals(paramAnonymouse.get("code") + "")))) {
              LoanInfoActivity.this.mBtnSubmit.setText("重新发起支付");
            }
          }
        }
      });
      return;
    }
    com.freelxl.baselibrary.f.g.textToast(this, "登录信息过期！");
  }
  
  private void e(String paramString)
  {
    if (this.B != null) {
      this.B.sign(paramString);
    }
  }
  
  private void f()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((localUserInfo != null) && (ApplicationEx.c.isLoginState()))
    {
      j.getSearchData(this, localUserInfo.getUid(), this.g, new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.c())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ("0".equals(paramAnonymouse.get("code") + ""))
          {
            paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "");
            LoanInfoActivity.d(LoanInfoActivity.this, paramAnonymouse.get("initialParam").toString());
          }
          for (;;)
          {
            dismissProgress();
            return;
            LoanInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
          }
        }
      });
      return;
    }
    showToast("登录信息过期");
  }
  
  private void g()
  {
    View localView = View.inflate(this, 2130905018, null);
    this.d = ((LinearLayout)localView.findViewById(2131697226));
    this.e = ((TextView)localView.findViewById(2131697227));
    TextView localTextView1 = (TextView)localView.findViewById(2131697228);
    TextView localTextView2 = (TextView)localView.findViewById(2131697229);
    this.f = ((EditText)localView.findViewById(2131697225));
    this.c = new Dialog(this, 2131427781);
    this.c.setContentView(localView);
    localTextView1.setOnClickListener(this);
    localTextView2.setOnClickListener(this);
    this.c.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        LoanInfoActivity.i(LoanInfoActivity.this).setText("");
        LoanInfoActivity.j(LoanInfoActivity.this).setVisibility(8);
        LoanInfoActivity.k(LoanInfoActivity.this).setText("");
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131689816: 
      do
      {
        do
        {
          return;
          if ("重新发起支付".equals(this.mBtnSubmit.getText().toString()))
          {
            this.mBtnSubmit.setEnabled(false);
            paramView = new Intent(this, HouseBillInfoActivity.class);
            paramView.putExtra("uniqueCode", this.g);
            paramView.putExtra("period", this.x.getPeriod() + "");
            paramView.putExtra("payType", "fz");
            startActivity(paramView);
            this.mBtnSubmit.setEnabled(true);
            ApplicationEx.c.finishAllActivity();
            finish();
            return;
          }
          if (this.w.equals("unLoan"))
          {
            if ((ApplicationEx.c.getUser() != null) && (ApplicationEx.c.isLoginState()))
            {
              if (this.mCbAgreeContract.isChecked())
              {
                this.mBtnSubmit.setEnabled(false);
                paramView = com.ziroom.ziroomcustomer.e.g.getRaConfig();
                j.getReservationOrderText(this, new a(), paramView, true, this.A);
                return;
              }
              com.freelxl.baselibrary.f.g.textToast(this, "您还未勾选同意《贷款合同》");
              return;
            }
            com.freelxl.baselibrary.f.g.textToast(this, "登录信息过期！");
            return;
          }
          if (!this.w.equals("fail")) {
            break label369;
          }
          if ((ApplicationEx.c.getUser() == null) || (!ApplicationEx.c.isLoginState())) {
            break;
          }
        } while (!TextUtils.isEmpty(this.r));
        com.ziroom.ziroomcustomer.dialog.c.newBuilder(this).setTitle("").setContent("确定要关闭合同吗？").setButtonText("取消").setSecondButtonText("确定").setCanceledOnTouchOutside(true).setOnSecondClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            LoanInfoActivity.this.showProgress("");
            com.ziroom.ziroomcustomer.e.d.getModifyContractState(LoanInfoActivity.f(LoanInfoActivity.this), LoanInfoActivity.g(LoanInfoActivity.this), LoanInfoActivity.h(LoanInfoActivity.this).getHouse_id(), LoanInfoActivity.h(LoanInfoActivity.this).getHouse_code(), LoanInfoActivity.h(LoanInfoActivity.this).getHouse_type(), "OPT001");
          }
        }).build().show();
        return;
        com.freelxl.baselibrary.f.g.textToast(this, "登录信息过期！");
        return;
      } while (!this.w.equals("success"));
      paramView = new Intent(this, HouseBillInfoActivity.class);
      paramView.putExtra("uniqueCode", this.g);
      paramView.putExtra("period", "1");
      paramView.putExtra("payType", "fz");
      if (this.r != null) {
        paramView.putExtra("old_contract_code", this.r);
      }
      if (!this.y) {
        paramView.putExtra("mContentText", "倒计时结束之前，您可以在“我的合同”里找到待支付合同进行支付。");
      }
      startActivityAndFinish(paramView);
      return;
    case 2131691110: 
      if (this.c == null) {
        g();
      }
      paramView = this.c;
      if (!(paramView instanceof Dialog))
      {
        paramView.show();
        return;
      }
      VdsAgent.showDialog((Dialog)paramView);
      return;
    case 2131697229: 
      paramView = VdsAgent.trackEditTextSilent(this.f).toString();
      if (!TextUtils.isEmpty(paramView))
      {
        if (this.v != null)
        {
          com.ziroom.ziroomcustomer.e.d.getPayKims(this.F, paramView, this.v.getHouse_code(), this.v.getHouse_id(), this.v.getHouse_type(), this.s, this.r, this.g);
          return;
        }
        showToast("房屋信息为空");
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(this, "输入的代金券为空");
      return;
    case 2131697228: 
      label369:
      this.c.dismiss();
      return;
    }
    JsBridgeWebActivity.start(this, "贷款合同", q.W + "/btForAppV1.0/loanCode.html?token=" + com.ziroom.commonlibrary.login.a.getToken(this) + "&outContractCode=" + this.g, false, "", "", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903249);
    this.b = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    this.D.cancel();
    this.E.cancel();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      back();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (paramk.getUrl().equals(LoanInfoActivity.q(LoanInfoActivity.this)))
      {
        if ("success".equals(str))
        {
          paramString = (IkeyRaConfig)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), IkeyRaConfig.class);
          if (paramString != null) {
            ApplicationEx.c.setRaConfig(paramString);
          }
          paramk.setSuccess(Boolean.valueOf(true));
          return;
        }
        str = q.s + e.a.r;
        Map localMap = com.ziroom.ziroomcustomer.e.g.getAddErrorMsg("获取RA配置信息失败", paramk.getMessage(), ApplicationEx.c);
        j.getReservationOrderText(LoanInfoActivity.this, this, localMap, true, str);
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage((String)paramString.get("error_message"));
        return;
      }
      if (str.equals("success"))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (paramk.getUrl().equals(LoanInfoActivity.q(LoanInfoActivity.this))) {
          if ((LoanInfoActivity.l(LoanInfoActivity.this) != null) && (ApplicationEx.c.getUser() != null))
          {
            LoanInfoActivity.this.showProgressNoCancel("下证书", 5000L);
            localHashMap = new HashMap();
            localHashMap.put("name", ApplicationEx.c.getUser().getRealName());
            paramk = "";
            if (LoanInfoActivity.l(LoanInfoActivity.this).getCertType() != null) {
              paramk = com.ziroom.ziroomcustomer.util.a.c.certTypeToName(LoanInfoActivity.l(LoanInfoActivity.this).getCertType().intValue());
            }
            localHashMap.put("mCerType2", paramk);
            localHashMap.put("cerNum", LoanInfoActivity.l(LoanInfoActivity.this).getCertNum());
            ApplicationEx.c.setUserMap(localHashMap);
            LoanInfoActivity.a(LoanInfoActivity.this, new com.ziroom.ziroomcustomer.termination.a(LoanInfoActivity.this, LoanInfoActivity.this, localHashMap, this, LoanInfoActivity.this.a));
            LoanInfoActivity.t(LoanInfoActivity.this).setmPaperless(new a.b()
            {
              public void Attestation(String paramAnonymousString)
              {
                LoanInfoActivity.this.dismissProgress();
                j.checkSign(LoanInfoActivity.this, "1", paramAnonymousString, LoanInfoActivity.g(LoanInfoActivity.this), new com.ziroom.commonlibrary.a.a(LoanInfoActivity.this, new com.freelxl.baselibrary.d.f.c())
                {
                  public void onFailure(Throwable paramAnonymous2Throwable)
                  {
                    dismissProgress();
                    u.e("BoundCardActivity", paramAnonymous2Throwable.getMessage() + "");
                  }
                  
                  public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
                  {
                    super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
                    if ("0".equals(paramAnonymous2e.get("code") + ""))
                    {
                      u.d("OKHttp", "===" + paramAnonymous2e.toString());
                      LoanInfoActivity.s(LoanInfoActivity.this);
                    }
                    for (;;)
                    {
                      dismissProgress();
                      return;
                      LoanInfoActivity.this.showToast(paramAnonymous2e.get("message") + "");
                    }
                  }
                });
              }
              
              public void DownloadError()
              {
                LoanInfoActivity.this.a.sendEmptyMessage(9437185);
              }
              
              public void DownloadSuccess()
              {
                LoanInfoActivity.this.dismissProgress();
                LoanInfoActivity.this.mBtnSubmit.setEnabled(true);
                LoanInfoActivity.r(LoanInfoActivity.this);
              }
            });
            LoanInfoActivity.t(LoanInfoActivity.this).initCaManager();
            LoanInfoActivity.t(LoanInfoActivity.this).iKeyFilter();
          }
        }
        while (!paramk.getUrl().equals(q.s + e.a.r))
        {
          HashMap localHashMap;
          return;
        }
        LoanInfoActivity.this.showToast("无纸化错误");
        return;
      }
      LoanInfoActivity.this.mBtnSubmit.setEnabled(true);
      paramk = paramk.getMessage();
      LoanInfoActivity.this.showToast(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/LoanInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */