package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.HashMap;
import java.util.Map;

public class LeaseSubletInfomationActivity
  extends BaseActivity
{
  private String A;
  private boolean B = true;
  private String C = "查看示例";
  private String D = "";
  private boolean E = false;
  private Context a;
  private String b;
  @BindView(2131692249)
  Button btnOk;
  @BindView(2131689787)
  BasicZiroomToolBar bztb;
  private int c;
  @BindView(2131696697)
  CheckBox cbAgreeRegulation;
  private Unbinder d;
  private e e;
  @BindView(2131696694)
  EditText etSubletDesc;
  @BindView(2131696688)
  EditText etSubletName;
  @BindView(2131696692)
  EditText etSubletPhone;
  private String f = "http://zhuanti.ziroom.com/zhuanti/2017/zrk/zhuanzu/index.html";
  private String g = "http://www.ziroom.com/zhuanti/2016/zjlc/shenqing.html";
  @BindView(2131696696)
  LinearLayout llAgreeRegulation;
  private String r;
  @BindView(2131696691)
  RadioButton rbSubletSexMan;
  @BindView(2131696690)
  RadioButton rbSubletSexWoman;
  @BindView(2131696689)
  RadioGroup rgSubletSex;
  private a s;
  @BindView(2131696659)
  LabeledEditText sublet_data_code_edit;
  private boolean t;
  @BindView(2131696698)
  TextView tvRegulation;
  @BindView(2131696693)
  TextView tvSeeExample;
  @BindView(2131696695)
  TextView tvSubletDescNum;
  private String u;
  private String v;
  @BindView(2131696660)
  TextView verification_code;
  @BindView(2131696658)
  RelativeLayout verivication_rl;
  private String w;
  private int x = 200;
  private int y = 40;
  private String z;
  
  private void a()
  {
    this.bztb.setTitle("转租申请");
    if (this.B) {
      this.btnOk.setText("提交转租申请");
    }
    for (;;)
    {
      this.rgSubletSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousRadioGroup, paramAnonymousInt);
          if (LeaseSubletInfomationActivity.this.rbSubletSexWoman.getId() == paramAnonymousInt) {
            LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, "1");
          }
          while (LeaseSubletInfomationActivity.this.rbSubletSexMan.getId() != paramAnonymousInt) {
            return;
          }
          LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, "2");
        }
      });
      this.cbAgreeRegulation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        }
      });
      this.etSubletDesc.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (VdsAgent.trackEditTextSilent(LeaseSubletInfomationActivity.this.etSubletDesc).toString().length() > LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this))
          {
            LeaseSubletInfomationActivity.this.etSubletDesc.setText(LeaseSubletInfomationActivity.b(LeaseSubletInfomationActivity.this) + "");
            LeaseSubletInfomationActivity.this.showToast("请不要输入大于" + LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this) + "个字符");
            LeaseSubletInfomationActivity.c(LeaseSubletInfomationActivity.this, LeaseSubletInfomationActivity.b(LeaseSubletInfomationActivity.this) + "");
            return;
          }
          LeaseSubletInfomationActivity.c(LeaseSubletInfomationActivity.this, VdsAgent.trackEditTextSilent(LeaseSubletInfomationActivity.this.etSubletDesc).toString());
          LeaseSubletInfomationActivity.this.tvSubletDescNum.setText(VdsAgent.trackEditTextSilent(LeaseSubletInfomationActivity.this.etSubletDesc).toString().length() + "/" + LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this));
          if (VdsAgent.trackEditTextSilent(LeaseSubletInfomationActivity.this.etSubletDesc).toString().length() > LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this) - 10)
          {
            LeaseSubletInfomationActivity.this.tvSubletDescNum.setTextColor(LeaseSubletInfomationActivity.this.getResources().getColor(2131624610));
            return;
          }
          LeaseSubletInfomationActivity.this.tvSubletDescNum.setTextColor(LeaseSubletInfomationActivity.this.getResources().getColor(2131624599));
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          LeaseSubletInfomationActivity.b(LeaseSubletInfomationActivity.this, paramAnonymousCharSequence.toString());
        }
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.etSubletName.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          LeaseSubletInfomationActivity.d(LeaseSubletInfomationActivity.this, paramAnonymousEditable.toString());
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.etSubletPhone.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          LeaseSubletInfomationActivity.e(LeaseSubletInfomationActivity.this, VdsAgent.trackEditTextSilent(LeaseSubletInfomationActivity.this.etSubletPhone).toString());
          int i = paramAnonymousEditable.length();
          paramAnonymousEditable = ApplicationEx.c.getUser().getPhone();
          String str = LeaseSubletInfomationActivity.c(LeaseSubletInfomationActivity.this).get("customer_phone").toString();
          if (i == 11) {
            if ((str.equals(LeaseSubletInfomationActivity.d(LeaseSubletInfomationActivity.this))) || (paramAnonymousEditable.equals(LeaseSubletInfomationActivity.d(LeaseSubletInfomationActivity.this))))
            {
              LeaseSubletInfomationActivity.this.verivication_rl.setVisibility(8);
              LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, false);
            }
          }
          while (i >= 11)
          {
            return;
            LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, true);
            LeaseSubletInfomationActivity.this.verivication_rl.setVisibility(0);
            return;
          }
          LeaseSubletInfomationActivity.this.verivication_rl.setVisibility(8);
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
      this.btnOk.setText("修改并提交审核");
    }
  }
  
  private void a(View paramView)
  {
    paramView.setEnabled(false);
    paramView.setClickable(false);
    paramView.setFocusable(false);
  }
  
  private void a(e parame)
  {
    e locale = parame.getJSONObject("desc_ex");
    this.C = locale.getString("prompt_title");
    this.D = locale.getString("prompt_text");
    if (ae.isNull(this.r)) {
      this.r = parame.getString("checkin_date");
    }
    this.y = parame.getIntValue("describe_minlen");
    this.x = parame.getIntValue("describe_maxlen");
    this.w = parame.getString("describe");
    this.etSubletDesc.setText(this.w);
    this.z = parame.getString("customer_name");
    this.etSubletName.setText(this.z);
    this.u = parame.getString("customer_phone");
    this.etSubletPhone.setText(this.u);
    this.A = parame.getString("customer_sex");
    d(this.A);
    this.g = parame.getString("apply_agreement_url");
    this.f = parame.getString("turn_rule_url");
    if (ae.notNull(this.f)) {
      this.bztb.addButton(this.bztb.newButton("转租规则", new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          JsBridgeWebActivity.start(LeaseSubletInfomationActivity.e(LeaseSubletInfomationActivity.this), "转租规则", LeaseSubletInfomationActivity.f(LeaseSubletInfomationActivity.this));
        }
      }));
    }
    if (this.E)
    {
      a(this.etSubletName);
      a(this.rgSubletSex);
      a(this.rbSubletSexMan);
      a(this.rbSubletSexWoman);
      a(this.etSubletPhone);
      a(this.etSubletDesc);
      this.llAgreeRegulation.setVisibility(8);
      this.btnOk.setVisibility(8);
      this.verivication_rl.setVisibility(8);
    }
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("contract_code", this.b);
    com.freelxl.baselibrary.d.a.get(q.Q + e.q.g + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString()));
        if (LeaseSubletInfomationActivity.c(LeaseSubletInfomationActivity.this) != null)
        {
          LeaseSubletInfomationActivity.b(LeaseSubletInfomationActivity.this, LeaseSubletInfomationActivity.c(LeaseSubletInfomationActivity.this));
          return;
        }
        LeaseSubletInfomationActivity.this.showToast("");
      }
    });
  }
  
  private void d(String paramString)
  {
    if ("1".equals(paramString)) {
      this.rgSubletSex.check(this.rbSubletSexWoman.getId());
    }
    while (!"2".equals(paramString)) {
      return;
    }
    this.rgSubletSex.check(this.rbSubletSexMan.getId());
  }
  
  private void e()
  {
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etSubletName).toString().trim()))
    {
      showToast("请填写转租联系人姓名");
      return;
    }
    if ((!"1".equals(this.A)) && (!"2".equals(this.A)))
    {
      showToast("请填写转租联系人性别");
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etSubletPhone).toString().trim()))
    {
      showToast("请填写转租联系电话");
      return;
    }
    if ((this.t) && (ae.isNull(this.sublet_data_code_edit.getText())))
    {
      showToast("请验证手机号");
      return;
    }
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etSubletDesc).toString().trim()))
    {
      showToast("填写转租联系推荐理由后方可提交哦～");
      return;
    }
    if (VdsAgent.trackEditTextSilent(this.etSubletDesc).toString().trim().length() < this.y)
    {
      showToast("转租推荐理由不得少于" + this.y + "字哦～");
      return;
    }
    if (!this.cbAgreeRegulation.isChecked())
    {
      showToast("您还未阅读并勾选《转租申请协议》");
      return;
    }
    f();
  }
  
  private void e(String paramString)
  {
    if (ae.notNull(paramString))
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("phone", paramString + "");
      com.freelxl.baselibrary.d.a.post(q.Q + e.q.b).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
          if (paramAnonymouse != null)
          {
            paramAnonymousInt = paramAnonymouse.getInteger("expire").intValue();
            LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, new LeaseSubletInfomationActivity.a(LeaseSubletInfomationActivity.this, paramAnonymousInt * 1000, 1000L));
            LeaseSubletInfomationActivity.h(LeaseSubletInfomationActivity.this).start();
            LeaseSubletInfomationActivity.this.verification_code.setEnabled(false);
            return;
          }
          LeaseSubletInfomationActivity.this.showToast("");
        }
      });
      return;
    }
    showToast("手机号为空");
  }
  
  private void f()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("turn_id", this.e.getString("turn_id") + "");
    localHashMap.put("contract_code", this.b);
    localHashMap.put("customer_name", VdsAgent.trackEditTextSilent(this.etSubletName).toString().trim());
    localHashMap.put("customer_phone", VdsAgent.trackEditTextSilent(this.etSubletPhone).toString().trim());
    localHashMap.put("checkin_date", this.r);
    localHashMap.put("customer_sex", this.A);
    localHashMap.put("authcode", this.sublet_data_code_edit.getText().toString().trim());
    localHashMap.put("describe", VdsAgent.trackEditTextSilent(this.etSubletDesc).toString().trim());
    com.freelxl.baselibrary.d.a.post(q.Q + e.q.h).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        Intent localIntent = new Intent(LeaseSubletInfomationActivity.e(LeaseSubletInfomationActivity.this), LeaseSubletSuccessActivity.class);
        localIntent.putExtra("lease", LeaseSubletInfomationActivity.g(LeaseSubletInfomationActivity.this));
        if (paramAnonymouse != null)
        {
          if (paramAnonymouse.get("success_text") != null) {
            localIntent.putExtra("success_text", paramAnonymouse.get("success_text").toString());
          }
          if (paramAnonymouse.get("success_tip") != null) {
            localIntent.putExtra("success_tip", paramAnonymouse.get("success_tip").toString());
          }
          if (paramAnonymouse.get("activity_info") != null) {
            localIntent.putExtra("activity_info", paramAnonymouse.get("activity_info").toString());
          }
        }
        LeaseSubletInfomationActivity.this.startActivity(localIntent);
        if (LeaseSubletInfomationActivity.h(LeaseSubletInfomationActivity.this) != null) {
          LeaseSubletInfomationActivity.h(LeaseSubletInfomationActivity.this).cancel();
        }
        LeaseSubletInfomationActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904840);
    this.a = this;
    this.d = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("lease");
    this.c = getIntent().getIntExtra("version", 2);
    this.r = getIntent().getStringExtra("subletTime");
    this.B = getIntent().getBooleanExtra("isNewSublet", true);
    this.E = getIntent().getBooleanExtra("isShow", false);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.d.unbind();
  }
  
  @OnClick({2131696693, 2131696698, 2131696660, 2131692249})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692249: 
      e();
      return;
    case 2131696693: 
      com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.a).setTitle(this.C).setContent(this.D).setContentGravity(3).setButtonText("我知道了").build().show();
      return;
    case 2131696698: 
      JsBridgeWebActivity.start(this.a, "转租申请协议", this.g);
      return;
    }
    e(VdsAgent.trackEditTextSilent(this.etSubletPhone).toString().trim());
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
      if (LeaseSubletInfomationActivity.this.verification_code == null) {
        return;
      }
      LeaseSubletInfomationActivity.this.verification_code.setEnabled(true);
      LeaseSubletInfomationActivity.this.verification_code.setText("重新获取");
    }
    
    public void onTick(long paramLong)
    {
      if (LeaseSubletInfomationActivity.this.verification_code == null) {
        return;
      }
      LeaseSubletInfomationActivity.this.verification_code.setText(paramLong / 1000L + "s");
      LeaseSubletInfomationActivity.this.verification_code.setEnabled(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletInfomationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */