package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
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
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.QuestionDetailActivity;
import com.ziroom.ziroomcustomer.repay.RepayChangeCardActivity;
import com.ziroom.ziroomcustomer.termination.a.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class BoundCardActivity
  extends BaseActivity
{
  private boolean A;
  private e B;
  private a C;
  b.a a = new b.a()
  {
    public void onBankSelected(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      BoundCardActivity.a(BoundCardActivity.this, paramAnonymousInt1);
      BoundCardActivity.a(BoundCardActivity.this, true);
      BoundCardActivity.this.mLetBank.setText(paramAnonymousString);
    }
  };
  private final int b = 0;
  @BindView(2131693206)
  CheckBox bound_card_check;
  private final int c = 1;
  private final int d = 2;
  private Unbinder e;
  private Context f;
  private String g = "正在获取到银行列表";
  @BindView(2131693194)
  ImageView let_bank_img;
  @BindView(2131693204)
  EditText let_verification;
  @BindView(2131693202)
  TextView let_verification_btn;
  @BindView(2131693201)
  RelativeLayout let_verification_rl;
  @BindView(2131690043)
  Button mBtn;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131690456)
  TextView mLetBank;
  @BindView(2131693198)
  EditText mLetCard;
  @BindView(2131689983)
  EditText mLetPhone;
  @BindView(2131692612)
  TextView mTvCheckNotPass;
  @BindView(2131693205)
  LinearLayout pay_installment_html;
  @BindView(2131693208)
  TextView pay_installment_html_text;
  private List<com.ziroom.ziroomcustomer.signed.a.b> r;
  private b s;
  private int t = 0;
  private boolean u = true;
  private int v = 0;
  private String w;
  private HouseDetail x;
  private String y;
  private String z;
  
  private void a()
  {
    this.mBztb.setTitle("添加银行卡");
    this.mBztb.setBackVisible(true);
    this.mLetPhone.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        BoundCardActivity.a(BoundCardActivity.this);
        BoundCardActivity.b(BoundCardActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mLetCard.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        BoundCardActivity.a(BoundCardActivity.this);
        BoundCardActivity.b(BoundCardActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mLetBank.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        BoundCardActivity.a(BoundCardActivity.this);
        BoundCardActivity.b(BoundCardActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.bound_card_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        BoundCardActivity.a(BoundCardActivity.this);
        BoundCardActivity.b(BoundCardActivity.this);
      }
    });
    this.let_verification.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        BoundCardActivity.b(BoundCardActivity.this);
        BoundCardActivity.a(BoundCardActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void a(e parame)
  {
    boolean bool;
    label78:
    Integer localInteger;
    if (parame != null)
    {
      if ((parame.getInteger("canChange") != null) && (parame.getInteger("canChange").intValue() == 0)) {
        break label97;
      }
      bool = true;
      this.u = bool;
      this.mLetCard.setEnabled(this.u);
      this.mLetPhone.setEnabled(this.u);
      if (!this.u) {
        break label113;
      }
      if (this.v != 1) {
        break label102;
      }
      this.let_verification_rl.setVisibility(8);
      localInteger = parame.getInteger("bindFlag");
      if ((localInteger == null) || (localInteger.intValue() != 0)) {
        break label134;
      }
    }
    label97:
    label102:
    label113:
    label134:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.let_verification_rl.setVisibility(0);
        break label78;
        this.let_verification_rl.setVisibility(8);
        this.let_bank_img.setVisibility(8);
        break label78;
      } while ((localInteger == null) || ((localInteger.intValue() != 1) && (localInteger.intValue() != 2)));
      parame = parame.getJSONObject("bindCardVo");
      this.B = parame;
    } while (parame == null);
    this.mLetBank.setText(parame.getString("bankName"));
    this.mLetCard.setText(parame.getString("cardCode"));
    this.mLetPhone.setText(parame.getString("userBankPhoneNum"));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    j.boundCard(this, localUserInfo.getUid(), null, localUserInfo.getRealName(), this.w, paramString3, paramString1, localUserInfo.getPhone(), paramString2, paramString4, "2", new com.ziroom.commonlibrary.a.a(this.f, new com.freelxl.baselibrary.d.f.c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        d.e("okhttp", paramAnonymouse.toJSONString());
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          paramAnonymouse = new Intent(BoundCardActivity.h(BoundCardActivity.this), RepayChangeCardActivity.class);
          paramAnonymouse.putExtra("contractCode", BoundCardActivity.f(BoundCardActivity.this));
          BoundCardActivity.this.startActivity(paramAnonymouse);
          BoundCardActivity.this.finish();
        }
        for (;;)
        {
          dismissProgress();
          return;
          BoundCardActivity.this.showToast(paramAnonymouse.get("message") + "");
        }
      }
    });
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    j.getValidateSms(this, paramString1, paramString2, paramString3, paramString4, paramString5, new com.ziroom.commonlibrary.a.a(this.f, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          BoundCardActivity.a(BoundCardActivity.this, new BoundCardActivity.a(BoundCardActivity.this, 60000, 1000L));
          BoundCardActivity.c(BoundCardActivity.this).start();
          BoundCardActivity.this.let_verification_btn.setEnabled(false);
          BoundCardActivity.this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
        }
        for (;;)
        {
          dismissProgress();
          return;
          BoundCardActivity.this.showToast(paramAnonymouse.get("message") + "");
        }
      }
    });
  }
  
  private void a(final String paramString1, final String paramString2, String paramString3, String paramString4, final String paramString5, final String paramString6)
  {
    j.getSign(this, paramString1, this.w, paramString2, paramString3, new com.ziroom.commonlibrary.a.a(this.f, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("BoundCardActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          BoundCardActivity.this.showProgress("无纸化验签", 5000L);
          com.ziroom.ziroomcustomer.termination.a locala = new com.ziroom.ziroomcustomer.termination.a(BoundCardActivity.this, null, null, BoundCardActivity.this.q, 1);
          locala.setmPaperless(new a.b()
          {
            public void Attestation(String paramAnonymous2String)
            {
              BoundCardActivity.6.this.dismissProgress();
              j.checkSign(BoundCardActivity.h(BoundCardActivity.this), "2", paramAnonymous2String, BoundCardActivity.f(BoundCardActivity.this) + "" + BoundCardActivity.6.this.c, new com.ziroom.commonlibrary.a.a(BoundCardActivity.this, new com.freelxl.baselibrary.d.f.c())
              {
                public void onFailure(Throwable paramAnonymous3Throwable)
                {
                  dismissProgress();
                  u.e("BoundCardActivity", paramAnonymous3Throwable.getMessage() + "");
                }
                
                public void onSuccess(int paramAnonymous3Int, e paramAnonymous3e)
                {
                  super.onSuccess(paramAnonymous3Int, paramAnonymous3e);
                  if ("0".equals(paramAnonymous3e.get("code") + ""))
                  {
                    u.d("OKHttp", "===" + paramAnonymous3e.toString());
                    BoundCardActivity.a(BoundCardActivity.this, BoundCardActivity.6.this.c, BoundCardActivity.6.this.d, BoundCardActivity.6.this.e, BoundCardActivity.6.this.f);
                  }
                  for (;;)
                  {
                    dismissProgress();
                    return;
                    BoundCardActivity.this.showToast(paramAnonymous3e.get("message") + "");
                  }
                }
              });
            }
            
            public void DownloadError() {}
            
            public void DownloadSuccess() {}
          });
          paramAnonymouse = e.parseObject(paramAnonymouse.get("data") + "");
          if (paramAnonymouse != null) {
            locala.checkSign(paramAnonymouse.get("initialParam").toString());
          }
          return;
        }
        BoundCardActivity.this.showToast(paramAnonymouse.get("message") + "");
      }
    });
  }
  
  private String[] a(List<com.ziroom.ziroomcustomer.signed.a.b> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((com.ziroom.ziroomcustomer.signed.a.b)paramList.get(i)).getBankName();
      i += 1;
    }
    return arrayOfString;
  }
  
  private void b()
  {
    if (ae.isNull(this.mLetBank.getText().toString()))
    {
      this.let_verification_btn.setEnabled(false);
      this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.mLetCard).toString()))
    {
      this.let_verification_btn.setEnabled(false);
      this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.mLetPhone).toString()))
    {
      this.let_verification_btn.setEnabled(false);
      this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
      return;
    }
    if (VdsAgent.trackEditTextSilent(this.mLetPhone).toString().length() != 11)
    {
      this.let_verification_btn.setEnabled(false);
      this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
      return;
    }
    if (!"获取验证码".equals(this.let_verification_btn.getText().toString()))
    {
      this.let_verification_btn.setEnabled(false);
      this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
      return;
    }
    this.let_verification_btn.setTextColor(Color.parseColor("#ffa000"));
    this.let_verification_btn.setEnabled(true);
  }
  
  private void e()
  {
    if (ae.isNull(this.mLetBank.getText().toString()))
    {
      this.mBtn.setEnabled(false);
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.mLetCard).toString()))
    {
      this.mBtn.setEnabled(false);
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.mLetPhone).toString()))
    {
      this.mBtn.setEnabled(false);
      return;
    }
    if ((ae.isNull(VdsAgent.trackEditTextSilent(this.let_verification).toString())) && (this.v != 1) && (this.u))
    {
      this.mBtn.setEnabled(false);
      return;
    }
    if ((!this.bound_card_check.isChecked()) && (this.pay_installment_html.getVisibility() == 0))
    {
      this.mBtn.setEnabled(false);
      return;
    }
    this.mBtn.setEnabled(true);
  }
  
  private void f()
  {
    this.v = getIntent().getIntExtra("mBoundCardType", 0);
    this.w = getIntent().getStringExtra("contract_code");
    this.y = getIntent().getStringExtra("old_contract_code");
    this.z = getIntent().getStringExtra("cityCode");
    this.x = ((HouseDetail)getIntent().getSerializableExtra("detail"));
  }
  
  private void g()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((ApplicationEx.c.isLoginState()) && (localUserInfo != null))
    {
      j.getBankList(this, localUserInfo.getUid(), this.w, new com.ziroom.ziroomcustomer.e.a.c(this, new l(com.ziroom.ziroomcustomer.signed.a.b.class, new com.ziroom.ziroomcustomer.e.c.a.b()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          dismissProgress();
          if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
          {
            BoundCardActivity.a(BoundCardActivity.this, paramAnonymousThrowable.getMessage());
            return;
          }
          BoundCardActivity.a(BoundCardActivity.this, "银行列表获取失败,请重试！");
        }
        
        public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.signed.a.b> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          if (paramAnonymousList != null)
          {
            BoundCardActivity.a(BoundCardActivity.this, paramAnonymousList);
            return;
          }
          BoundCardActivity.a(BoundCardActivity.this, "银行列表获取失败，请重试！");
        }
      });
      if (this.v == 1) {
        j.getPreBoundCard(this, localUserInfo.getUid(), new com.ziroom.ziroomcustomer.e.a.c(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
        {
          public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymouse);
            BoundCardActivity.a(BoundCardActivity.this, paramAnonymouse);
          }
        });
      }
      do
      {
        return;
        if (this.v == 2)
        {
          j.getBoundCard(this, localUserInfo.getUid(), this.w, new com.ziroom.ziroomcustomer.e.a.c(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
          {
            public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymouse);
              BoundCardActivity.a(BoundCardActivity.this, paramAnonymouse);
            }
          });
          return;
        }
        if (this.v == 3)
        {
          this.pay_installment_html.setVisibility(0);
          return;
        }
      } while (this.v != 4);
      j.getBoundCard(this, localUserInfo.getUid(), this.w, new com.ziroom.ziroomcustomer.e.a.c(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          BoundCardActivity.a(BoundCardActivity.this, paramAnonymouse);
        }
      });
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    finish();
  }
  
  private void h()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if ((ApplicationEx.c.isLoginState()) && (localUserInfo != null))
    {
      String str3;
      String str1;
      String str2;
      String str4;
      String str5;
      if (this.A)
      {
        str3 = this.mLetBank.getText().toString();
        if (this.r.get(this.t) == null)
        {
          str1 = "";
          str2 = str1;
          str1 = str3;
          str3 = VdsAgent.trackEditTextSilent(this.mLetPhone).toString();
          str4 = VdsAgent.trackEditTextSilent(this.mLetCard).toString();
          str5 = VdsAgent.trackEditTextSilent(this.let_verification).toString();
          if ((!ae.isNull(str1)) && (!TextUtils.isEmpty(str2))) {
            break label198;
          }
          g.textToast(this, "请选择开户银行");
        }
      }
      label157:
      label184:
      label198:
      do
      {
        return;
        str1 = ((com.ziroom.ziroomcustomer.signed.a.b)this.r.get(this.t)).getZrBankCode();
        break;
        if (this.B == null)
        {
          str1 = "";
          if (this.B != null) {
            break label184;
          }
        }
        for (str2 = "";; str2 = this.B.getString("zrBankCode"))
        {
          break;
          str1 = this.B.getString("bankName");
          break label157;
        }
        if (ae.isNull(str4))
        {
          g.textToast(this, "请输入银行卡号");
          return;
        }
        if ((str4.length() < 16) || (str4.length() > 19))
        {
          g.textToast(this, "请输入由16-19位数字组成的银行卡卡号");
          return;
        }
        if (ae.isNull(str3))
        {
          g.textToast(this, "请输入银行预留手机号");
          return;
        }
        if (str3.length() != 11)
        {
          g.textToast(this, "请输入正确格式的银行预留手机号");
          return;
        }
        if ((ae.isNull(str5)) && (this.v != 1) && (this.u))
        {
          g.textToast(this, "请输入验证码");
          return;
        }
        if (this.v == 1)
        {
          j.preBindCard(this, localUserInfo.getUid(), str1, str2, str4, localUserInfo.getPhone(), str3, new com.ziroom.ziroomcustomer.e.a.c(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
          {
            public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymouse);
              g.textToast(BoundCardActivity.this, "添加银行卡成功！");
              BoundCardActivity.this.finish();
            }
          });
          return;
        }
        if (this.v == 2)
        {
          j.bindCard(this, localUserInfo.getUid(), null, localUserInfo.getRealName(), this.w, str2, str4, localUserInfo.getPhone(), str3, str5, "1", new com.ziroom.ziroomcustomer.e.a.c(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
          {
            public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymouse);
              paramAnonymouse = new Intent(BoundCardActivity.this.getApplicationContext(), ContractTermsActivity.class);
              if (BoundCardActivity.d(BoundCardActivity.this) == null)
              {
                paramAnonymouse.putExtra("detail", BoundCardActivity.e(BoundCardActivity.this));
                paramAnonymouse.putExtra("contract_code", BoundCardActivity.f(BoundCardActivity.this));
              }
              for (;;)
              {
                BoundCardActivity.this.startActivity(paramAnonymouse);
                BoundCardActivity.this.finish();
                return;
                if (ae.notNull(BoundCardActivity.d(BoundCardActivity.this)))
                {
                  paramAnonymouse.putExtra("cityCode", BoundCardActivity.g(BoundCardActivity.this));
                  paramAnonymouse.putExtra("old_contract_code", BoundCardActivity.d(BoundCardActivity.this));
                }
              }
            }
          });
          return;
        }
        if (this.v == 3)
        {
          a(str4, str3, str1, str2, str2, str5);
          return;
        }
      } while (this.v != 4);
      j.bindCard(this, localUserInfo.getUid(), null, localUserInfo.getRealName(), this.w, str2, str4, localUserInfo.getPhone(), str3, str5, "1", new com.ziroom.ziroomcustomer.e.a.c(this, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          paramAnonymouse = new Intent(BoundCardActivity.h(BoundCardActivity.this), LoanInfoActivity.class);
          paramAnonymouse.putExtra("contract_code", BoundCardActivity.f(BoundCardActivity.this));
          paramAnonymouse.putExtra("is_back_pre", true);
          paramAnonymouse.putExtra("isEasilyPay", true);
          BoundCardActivity.this.startActivity(paramAnonymouse);
          ApplicationEx.c.addActivity(BoundCardActivity.this);
        }
      });
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    finish();
  }
  
  private void i()
  {
    j.bankBindFailToast(this, new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse == null) {
          return;
        }
        Intent localIntent = new Intent(BoundCardActivity.h(BoundCardActivity.this), QuestionDetailActivity.class);
        localIntent.putExtra("item_id", paramAnonymouse.getString("validType"));
        BoundCardActivity.this.startActivity(localIntent);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903662);
    this.f = this;
    this.e = ButterKnife.bind(this);
    a();
    f();
    g();
  }
  
  protected void onDestroy()
  {
    if (this.e != null) {
      this.e.unbind();
    }
    super.onDestroy();
  }
  
  @OnClick({2131693193, 2131690043, 2131693195, 2131693194, 2131690456, 2131693202, 2131693208, 2131692612})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131693202: 
    case 2131690043: 
    case 2131690456: 
    case 2131693193: 
    case 2131693194: 
    case 2131693195: 
      do
      {
        return;
        if (this.A)
        {
          if (this.r.get(this.t) == null) {}
          for (paramView = "";; paramView = ((com.ziroom.ziroomcustomer.signed.a.b)this.r.get(this.t)).getZrBankCode())
          {
            a(VdsAgent.trackEditTextSilent(this.mLetCard).toString(), this.w, VdsAgent.trackEditTextSilent(this.mLetPhone).toString(), paramView, "");
            return;
          }
        }
        if (this.B == null) {}
        for (paramView = "";; paramView = this.B.getString("zrBankCode")) {
          break;
        }
        h();
        return;
      } while (!this.u);
      if (this.r != null)
      {
        if (this.s == null)
        {
          this.s = new b(this.f, this.a, a(this.r), this.t);
          this.s.setCanceledOnTouchOutside(true);
          paramView = this.s.getWindow();
          paramView.getDecorView().setPadding(0, 0, 0, 0);
          WindowManager.LayoutParams localLayoutParams = paramView.getAttributes();
          localLayoutParams.width = -1;
          localLayoutParams.height = -2;
          paramView.setAttributes(localLayoutParams);
          paramView.setGravity(80);
        }
        this.s.show();
        return;
      }
      g.textToast(this, this.g);
      return;
    case 2131693208: 
      JsBridgeWebActivity.start(this, "代扣协议", q.W + "btForAppV1.0/agree.html?token=" + com.ziroom.commonlibrary.login.a.getToken(this) + "&outContractCode=" + this.w, false, "", "", false);
      return;
    }
    i();
  }
  
  class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if (BoundCardActivity.this.let_verification_btn == null) {
        return;
      }
      BoundCardActivity.this.let_verification_btn.setEnabled(true);
      BoundCardActivity.this.let_verification_btn.setTextColor(Color.parseColor("#ffa000"));
      BoundCardActivity.this.let_verification_btn.setText("获取验证码");
    }
    
    public void onTick(long paramLong)
    {
      if (BoundCardActivity.this.let_verification_btn == null) {
        return;
      }
      BoundCardActivity.this.let_verification_btn.setText(paramLong / 1000L + "s后重发");
      BoundCardActivity.this.let_verification_btn.setEnabled(false);
      BoundCardActivity.this.let_verification_btn.setTextColor(Color.parseColor("#dddddd"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/BoundCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */