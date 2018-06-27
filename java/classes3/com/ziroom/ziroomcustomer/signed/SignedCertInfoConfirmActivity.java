package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
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
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.certInfo;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.account.BankcardDetailActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.CompanyBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.PersonalBean;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.util.a.b;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SignedCertInfoConfirmActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Map<String, String> A = new HashMap();
  private Handler B = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.ziroom.ziroomcustomer.e.l locall = (com.ziroom.ziroomcustomer.e.l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69699: 
        if (locall.getSuccess().booleanValue())
        {
          MobclickAgent.onEvent(SignedCertInfoConfirmActivity.this, "SignedCertInfoConfirmActivity_0", SignedCertInfoConfirmActivity.e(SignedCertInfoConfirmActivity.this));
          SignedCertInfoConfirmActivity.f(SignedCertInfoConfirmActivity.this);
          SignedCertInfoConfirmActivity.g(SignedCertInfoConfirmActivity.this);
          return;
        }
        MobclickAgent.onEvent(SignedCertInfoConfirmActivity.this, "SignedCertInfoConfirmActivity_1", SignedCertInfoConfirmActivity.e(SignedCertInfoConfirmActivity.this));
        SignedCertInfoConfirmActivity.this.showToast("无纸化签约证书出现问题,请稍后再试!!!");
        com.ziroom.ziroomcustomer.e.d.errorLog(SignedCertInfoConfirmActivity.this, "获取RA配置信息失败", locall.getMessage());
        SignedCertInfoConfirmActivity.this.dismissProgress();
        return;
      }
      SignedCertInfoConfirmActivity.this.dismissProgress();
      if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 0)
      {
        SignedCertInfoConfirmActivity.this.finish();
        return;
      }
      if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 5)
      {
        if ("1".equals(SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getCert_type()))
        {
          paramAnonymousMessage = new Intent(SignedCertInfoConfirmActivity.this, BankcardDetailActivity.class);
          paramAnonymousMessage.putExtra("name", SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getReal_name());
          SignedCertInfoConfirmActivity.this.startActivity(paramAnonymousMessage);
          SignedCertInfoConfirmActivity.this.finish();
          return;
        }
        SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, Integer.valueOf(2));
        return;
      }
      if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 4)
      {
        paramAnonymousMessage = new Intent(SignedCertInfoConfirmActivity.this, TurnSignTermsActivity.class);
        SignedCertInfoConfirmActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      if ((SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 1) || (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 2))
      {
        paramAnonymousMessage = new Intent(SignedCertInfoConfirmActivity.this, SignerAptitudeActivity.class);
        paramAnonymousMessage.putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
        paramAnonymousMessage.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
        SignedCertInfoConfirmActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 3)
      {
        if ("QRYD".equals(com.alibaba.fastjson.a.parseObject(SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this).getSubletReserveCode()).getString("confirmType")))
        {
          paramAnonymousMessage = new Intent(SignedCertInfoConfirmActivity.this, ContractTermsActivity.class);
          paramAnonymousMessage.putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
          paramAnonymousMessage.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
          SignedCertInfoConfirmActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        paramAnonymousMessage = new Intent(SignedCertInfoConfirmActivity.this, SignerAptitudeActivity.class);
        paramAnonymousMessage.putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
        paramAnonymousMessage.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
        SignedCertInfoConfirmActivity.this.startActivity(paramAnonymousMessage);
        return;
      }
      SignedCertInfoConfirmActivity.this.finish();
    }
  };
  private View C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private Dialog H;
  private View I;
  private TextView J;
  private TextView K;
  private TextView L;
  private TextView M;
  private Dialog N;
  private com.ziroom.ziroomcustomer.e.a.c O = new com.ziroom.ziroomcustomer.e.a.c(this, new com.ziroom.ziroomcustomer.e.c.a(IkeyRaConfig.class))
  {
    public void onSuccess(int paramAnonymousInt, IkeyRaConfig paramAnonymousIkeyRaConfig)
    {
      if ((paramAnonymousIkeyRaConfig != null) && (ApplicationEx.c.getUser() != null) && (SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this) != null))
      {
        paramAnonymousIkeyRaConfig = new com.ziroom.ziroomcustomer.util.a.c(new com.ziroom.ziroomcustomer.util.a.a(ApplicationEx.c.getUser().getUid(), SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).real_name, SignedCertInfoConfirmActivity.c(SignedCertInfoConfirmActivity.this, Integer.parseInt(SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).cert_type)), SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).cert_num), paramAnonymousIkeyRaConfig);
        paramAnonymousIkeyRaConfig.setListener(new b()
        {
          public void onCertInitEnd(String paramAnonymous2String)
          {
            super.onCertInitEnd(paramAnonymous2String);
            SignedCertInfoConfirmActivity.2.this.dismissProgress();
            if (!TextUtils.isEmpty(paramAnonymous2String))
            {
              if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 0) {
                SignedCertInfoConfirmActivity.this.finish();
              }
            }
            else {
              return;
            }
            if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 5)
            {
              if ("1".equals(SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getCert_type()))
              {
                paramAnonymous2String = new Intent(SignedCertInfoConfirmActivity.this, BankcardDetailActivity.class);
                paramAnonymous2String.putExtra("name", SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getReal_name());
                SignedCertInfoConfirmActivity.this.startActivity(paramAnonymous2String);
                SignedCertInfoConfirmActivity.this.finish();
                return;
              }
              SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, Integer.valueOf(2));
              return;
            }
            if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 4)
            {
              paramAnonymous2String = new Intent(SignedCertInfoConfirmActivity.this, TurnSignTermsActivity.class);
              SignedCertInfoConfirmActivity.this.startActivity(paramAnonymous2String);
              return;
            }
            if ((SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 1) || (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 2))
            {
              paramAnonymous2String = new Intent(SignedCertInfoConfirmActivity.this, SignerAptitudeActivity.class);
              paramAnonymous2String.putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
              paramAnonymous2String.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
              SignedCertInfoConfirmActivity.this.startActivity(paramAnonymous2String);
              return;
            }
            if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 3)
            {
              if ("QRYD".equals(com.alibaba.fastjson.a.parseObject(SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this).getSubletReserveCode()).getString("confirmType")))
              {
                paramAnonymous2String = new Intent(SignedCertInfoConfirmActivity.this, ContractTermsActivity.class);
                paramAnonymous2String.putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
                paramAnonymous2String.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
                SignedCertInfoConfirmActivity.this.startActivity(paramAnonymous2String);
                return;
              }
              paramAnonymous2String = new Intent(SignedCertInfoConfirmActivity.this, SignerAptitudeActivity.class);
              paramAnonymous2String.putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
              paramAnonymous2String.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
              SignedCertInfoConfirmActivity.this.startActivity(paramAnonymous2String);
              return;
            }
            SignedCertInfoConfirmActivity.this.finish();
          }
          
          public void onCertInitStart()
          {
            super.onCertInitStart();
            SignedCertInfoConfirmActivity.2.this.showProgress();
          }
          
          public void onError(String paramAnonymous2String)
          {
            super.onError(paramAnonymous2String);
            SignedCertInfoConfirmActivity.this.showToast("无纸化签约证书出现问题,请稍后再试!!!");
            new StringBuilder().append("手机信息:").append(ah.getPhoneInfo()).toString();
            com.ziroom.ziroomcustomer.e.d.errorLog(SignedCertInfoConfirmActivity.this, "签约流程错误", paramAnonymous2String);
            SignedCertInfoConfirmActivity.2.this.dismissProgress();
          }
        });
        paramAnonymousIkeyRaConfig.certInit();
      }
    }
  };
  l.a a = new l.a()
  {
    public void showHour(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      switch (paramAnonymousInt2)
      {
      default: 
      case 0: 
        do
        {
          return;
          SignedCertInfoConfirmActivity.this.signed_person_cert_info_sex.setText(paramAnonymousString);
          if ("男".equals(paramAnonymousString))
          {
            SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, 1);
            return;
          }
        } while (!"女".equals(paramAnonymousString));
        SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, 2);
        return;
      }
      SignedCertInfoConfirmActivity.this.signed_person_cert_info_cert_type.setText(paramAnonymousString);
      SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this, ((CertInfoEntity.NewsignCertListBean.PersonalBean)SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getCert_type());
    }
  };
  private Unbinder b;
  @BindView(2131690105)
  ImageView btn_menu;
  private Context c;
  @BindView(2131692450)
  TextView cert_info_confirm_btn;
  @BindView(2131692427)
  SimpleDraweeView cert_info_confirm_img;
  private int d;
  private String[] e;
  private String[] f;
  private CertInfoEntity g;
  @BindView(2131692426)
  LinearLayout ll_house_info_signed_cert;
  private HouseDetail r;
  private HashMap<String, String> s;
  @BindView(2131692436)
  TextView signed_cert_info_id_left;
  @BindView(2131692437)
  TextView signed_cert_info_id_right;
  @BindView(2131692431)
  TextView signed_cert_info_name_left;
  @BindView(2131692432)
  TextView signed_cert_info_name_right;
  @BindView(2131692439)
  TextView signed_cert_info_phone_left;
  @BindView(2131692440)
  TextView signed_cert_info_phone_right;
  @BindView(2131692438)
  RelativeLayout signed_cert_info_phone_rl;
  @BindView(2131692434)
  TextView signed_cert_info_sex_left;
  @BindView(2131692435)
  TextView signed_cert_info_sex_right;
  @BindView(2131692433)
  RelativeLayout signed_cert_info_sex_rl;
  @BindView(2131692441)
  TextView signed_cert_info_tip;
  @BindView(2131692428)
  TextView signed_house_address;
  @BindView(2131692430)
  TextView signed_house_area;
  @BindView(2131692429)
  TextView signed_house_price;
  @BindView(2131692448)
  LabeledEditText signed_person_cert_info_cert_id;
  @BindView(2131692447)
  LabeledEditText signed_person_cert_info_cert_type;
  @BindView(2131692442)
  LinearLayout signed_person_cert_info_ll;
  @BindView(2131692443)
  LabeledEditText signed_person_cert_info_name;
  @BindView(2131692449)
  LabeledEditText signed_person_cert_info_phone;
  @BindView(2131692445)
  LabeledEditText signed_person_cert_info_sex;
  private String t = "";
  private int u = 0;
  private int v = 0;
  private com.ziroom.ziroomcustomer.c.a w;
  private boolean x = true;
  private Thread y;
  private int z;
  
  private void a()
  {
    Object localObject;
    if (this.r != null)
    {
      localObject = this.r.getHouse_photos_small();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.cert_info_confirm_img.setController(com.freelxl.baselibrary.f.c.frescoController((String)((List)localObject).get(0)));
      }
      this.signed_house_address.setText(this.r.getHouse_name());
      if (this.r.getIs_duanzu() == 1)
      {
        localObject = this.r.getHouse_price() + "元/天";
        ah.setTextColor(this.signed_house_price, (String)localObject, 0, this.r.getHouse_price().length());
        if (ae.notNull(this.r.getHouse_area())) {
          this.signed_house_area.setText(this.r.getHouse_area() + "m²");
        }
      }
    }
    for (;;)
    {
      if (this.g != null) {
        break label233;
      }
      return;
      localObject = this.r.getHouse_price() + "元/月";
      ah.setTextColor(this.signed_house_price, (String)localObject, 0, this.r.getHouse_price().length());
      break;
      this.ll_house_info_signed_cert.setVisibility(8);
    }
    try
    {
      label233:
      this.d = Integer.parseInt(this.g.user_type);
      ad.putOther(this, "signed_user_type", this.d + "");
      this.signed_cert_info_name_right.setText(this.g.real_name);
      this.signed_cert_info_id_right.setText(c(this.g.cert_num));
      if (this.d == 2)
      {
        if (this.z == 3) {
          if ("QRYD".equals(com.alibaba.fastjson.a.parseObject(this.r.getSubletReserveCode()).getString("confirmType"))) {
            this.signed_person_cert_info_ll.setVisibility(8);
          }
        }
        for (;;)
        {
          this.signed_cert_info_name_left.setText("企业名称");
          localObject = this.g.getNewsign_cert_list().getCompany().iterator();
          while (((Iterator)localObject).hasNext())
          {
            CertInfoEntity.NewsignCertListBean.CompanyBean localCompanyBean = (CertInfoEntity.NewsignCertListBean.CompanyBean)((Iterator)localObject).next();
            if ((localCompanyBean != null) && ((localCompanyBean.getCert_type() + "").equals(this.g.getCert_type()))) {
              this.signed_cert_info_id_left.setText(localCompanyBean.getCert_name() + "号码");
            }
          }
          this.signed_person_cert_info_ll.setVisibility(0);
          continue;
          this.signed_person_cert_info_ll.setVisibility(0);
        }
        this.signed_cert_info_phone_rl.setVisibility(8);
        this.signed_cert_info_sex_rl.setVisibility(8);
        if ((this.g.getNewsign_cert_list() != null) && (ae.notNull(this.g.getNewsign_cert_list().change_object))) {
          this.signed_cert_info_tip.setText("*" + this.g.getNewsign_cert_list().change_object);
        }
        this.signed_person_cert_info_cert_id.addTextChangedListener(new LabeledEditText.a()
        {
          public void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        this.signed_person_cert_info_phone.addTextChangedListener(new LabeledEditText.a()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            if (SignedCertInfoConfirmActivity.this.signed_person_cert_info_phone.getText().toString().length() > 11) {
              SignedCertInfoConfirmActivity.this.signed_person_cert_info_phone.setText(SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this) + "");
            }
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, paramAnonymousCharSequence.toString());
          }
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        this.cert_info_confirm_btn.setOnClickListener(this);
        return;
      }
      this.signed_person_cert_info_ll.setVisibility(8);
      this.signed_cert_info_phone_rl.setVisibility(0);
      if (ApplicationEx.c.getUser() != null) {
        this.signed_cert_info_phone_right.setText(ApplicationEx.c.getUser().getPhone());
      }
      for (;;)
      {
        this.signed_cert_info_name_left.setText("姓名");
        if (!ae.isNull(this.g.cert_type))
        {
          localObject = a(this.g.cert_type, this.g.newsign_cert_list.personal);
          if (localObject != null) {
            this.signed_cert_info_id_left.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject).getCert_name());
          }
        }
        this.signed_cert_info_sex_left.setText("性别");
        this.signed_cert_info_sex_right.setText(a(this.g.gender));
        break;
        com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(int paramInt, String[] paramArrayOfString)
  {
    paramArrayOfString = new l(this, this.a, paramArrayOfString, paramInt);
    paramArrayOfString.setCanceledOnTouchOutside(true);
    Window localWindow = paramArrayOfString.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    paramArrayOfString.show();
    paramArrayOfString.getTv_choose().setText("");
  }
  
  private void a(final com.ziroom.ziroomcustomer.signed.a.c paramc)
  {
    String str = "0";
    Object localObject = ApplicationEx.c.getUser();
    if (localObject != null) {
      str = ((com.ziroom.ziroomcustomer.model.UserInfo)localObject).getUid();
    }
    com.freelxl.baselibrary.d.a.isLog(true);
    localObject = new HashMap();
    ((Map)localObject).put("interfaceId", "122");
    ((Map)localObject).put("uid", str);
    g.appendCommenParamsString((Map)localObject);
    com.freelxl.baselibrary.d.a.post(q.s + e.n.X).tag(this).params((Map)localObject).enqueue(new f(this.c, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        paramAnonymouse = new Intent(SignedCertInfoConfirmActivity.c(SignedCertInfoConfirmActivity.this), SignedLeaseInfoActivity.class);
        paramAnonymouse.putExtra("person", paramc);
        paramAnonymouse.putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
        SignedCertInfoConfirmActivity.this.startActivity(paramAnonymouse);
      }
    });
  }
  
  private void a(Integer paramInteger)
  {
    this.I = View.inflate(this, 2130905178, null);
    this.L = ((TextView)this.I.findViewById(2131697634));
    this.M = ((TextView)this.I.findViewById(2131697637));
    this.J = ((TextView)this.I.findViewById(2131697639));
    this.K = ((TextView)this.I.findViewById(2131697638));
    if (paramInteger.intValue() == 1)
    {
      this.L.setVisibility(8);
      this.M.setVisibility(0);
      this.J.setText("联系管家");
      this.K.setText("稍后再说");
      this.M.setText("因无法获取到您的证件信息，需要您联系管家进行转签确认。");
      this.J.setOnClickListener(this);
      this.K.setOnClickListener(this);
      if (this.N == null)
      {
        this.N = new Dialog(this, 2131427781);
        this.N.setContentView(this.I);
        paramInteger = this.N;
        if ((paramInteger instanceof Dialog)) {
          break label303;
        }
        paramInteger.show();
      }
    }
    for (;;)
    {
      this.N.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, null);
          SignedCertInfoConfirmActivity.j(SignedCertInfoConfirmActivity.this).dismiss();
        }
      });
      return;
      if (paramInteger.intValue() != 2) {
        break;
      }
      this.L.setVisibility(0);
      this.M.setVisibility(8);
      this.L.setHeight(n.dip2px(this, 48.0F));
      this.K.setText("知道了");
      this.J.setVisibility(8);
      this.K.setVisibility(0);
      this.L.setText("非身份证用户请联系客服400-100-1111进行认证");
      this.K.setOnClickListener(this);
      break;
      label303:
      VdsAgent.showDialog((Dialog)paramInteger);
    }
  }
  
  private void a(final HashMap<String, String> paramHashMap)
  {
    this.y = new Thread(new Runnable()
    {
      public void run()
      {
        String str = SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, paramHashMap);
        if (TextUtils.isEmpty(str))
        {
          if ((SignedCertInfoConfirmActivity.k(SignedCertInfoConfirmActivity.this)) && (SignedCertInfoConfirmActivity.l(SignedCertInfoConfirmActivity.this)))
          {
            SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, false);
            SignedCertInfoConfirmActivity.f(SignedCertInfoConfirmActivity.this);
            SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this, paramHashMap);
            return;
          }
          MobclickAgent.onEvent(SignedCertInfoConfirmActivity.this, "SignedCertInfoConfirmActivity_2", SignedCertInfoConfirmActivity.e(SignedCertInfoConfirmActivity.this));
          com.ziroom.ziroomcustomer.e.d.errorLog(SignedCertInfoConfirmActivity.this, "生成CSR失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
          SignedCertInfoConfirmActivity.this.dismissProgress();
          SignedCertInfoConfirmActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              SignedCertInfoConfirmActivity.this.showToast("无纸化出现异常,请稍后再试!");
            }
          });
          return;
        }
        u.d("ikey", "CSR生成成功!! 正在申请证书...");
        com.itrus.raapi.implement.UserInfo localUserInfo = new com.itrus.raapi.implement.UserInfo();
        localUserInfo.setUserAdditionalField1(ApplicationEx.c.getUserId(SignedCertInfoConfirmActivity.this));
        localUserInfo.setUserName((String)paramHashMap.get("name"));
        localUserInfo.setUserSurname((String)paramHashMap.get("cerNum"));
        localUserInfo.setUserAdditionalField2(SignedCertInfoConfirmActivity.c(SignedCertInfoConfirmActivity.this, Integer.parseInt(((String)paramHashMap.get("mCerType2")).toString())));
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("UserInfo", localUserInfo);
        localBundle.putString("CSR", str);
        localBundle.putString("PassPort", "");
        localBundle.putString("CHALLENGE", ApplicationEx.c.getRaConfig().getStrChangllege());
        localBundle.putString("Time", "1");
        new SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, null).execute(new Bundle[] { localBundle });
      }
    });
    this.y.start();
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "身份证 ";
    case 2: 
      return "护照 ";
    case 13: 
      return "港澳居民来往通行证 ";
    }
    return "台湾居民来往通行证 ";
  }
  
  private String b(HashMap<String, String> paramHashMap)
  {
    try
    {
      Thread.sleep(1000L);
      u.d("ikey", "正在生成CSR");
      paramHashMap = ApplicationEx.c.k.GenCSR(Build.MODEL, (String)paramHashMap.get("name"), "", "", "", 1024, "RSA");
      return paramHashMap;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void b()
  {
    if ((this.g != null) && (this.g.getNewsign_cert_list() != null) && (this.g.getNewsign_cert_list().getCompany() != null))
    {
      int j = this.g.getNewsign_cert_list().getPersonal().size();
      this.e = new String[j];
      int i = 0;
      while (i < j)
      {
        this.e[i] = ((CertInfoEntity.NewsignCertListBean.PersonalBean)this.g.getNewsign_cert_list().getPersonal().get(i)).getCert_name();
        i += 1;
      }
    }
    this.f = new String[2];
    this.f[0] = "男";
    this.f[1] = "女";
    if (this.s == null) {
      this.s = new HashMap();
    }
    for (;;)
    {
      this.s.put("name", this.g.real_name);
      this.s.put("mCerType2", this.g.cert_type + "");
      this.s.put("cerNum", this.g.cert_num);
      ApplicationEx.c.setUserMap(this.s);
      return;
      this.s.clear();
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      if (Long.valueOf(m.getDaysBetween(new Date(System.currentTimeMillis()), new Date(h()))).longValue() < 0L)
      {
        ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(paramString));
        a(this.s);
        return;
      }
      paramString = this.B.obtainMessage();
      paramString.what = 69700;
      this.B.sendMessage(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    this.C = View.inflate(this, 2130905178, null);
    this.D = ((TextView)this.C.findViewById(2131697639));
    this.G = ((TextView)this.C.findViewById(2131697638));
    this.F = ((TextView)this.C.findViewById(2131697637));
    this.E = ((TextView)this.C.findViewById(2131697634));
    this.E.setHeight(n.dip2px(this, 48.0F));
    this.D.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.E.setText("您确定退出转签操作吗？");
    this.F.setVisibility(8);
    this.D.setText("确认");
    this.G.setText("取消");
    Dialog localDialog;
    if (this.H == null)
    {
      this.H = new Dialog(this, 2131427781);
      this.H.setContentView(this.C);
      this.H.setCanceledOnTouchOutside(false);
      localDialog = this.H;
      if ((localDialog instanceof Dialog)) {
        break label222;
      }
      localDialog.show();
    }
    for (;;)
    {
      this.H.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, null);
          SignedCertInfoConfirmActivity.i(SignedCertInfoConfirmActivity.this).dismiss();
          SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, null);
        }
      });
      return;
      label222:
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  private void f()
  {
    if (!i())
    {
      showToast("无纸化签约证书出现问题,请稍后再试!!!");
      MobclickAgent.onEvent(this, "SignedCertInfoConfirmActivity_6", this.A);
      com.ziroom.ziroomcustomer.e.d.errorLog(this, "无纸化错误", ApplicationEx.c.k.GetLastErrInfo());
    }
    do
    {
      return;
      this.w = new com.ziroom.ziroomcustomer.c.a(ApplicationEx.c.getRaConfig().getWebsite(), ApplicationEx.c.getRaConfig().getAccounthash(), this);
    } while (ApplicationEx.c.k != null);
    ApplicationEx.c.k = ClientForAndroid.getInstance(this);
  }
  
  private void g()
  {
    String[] arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (arrayOfString.length < 1)
    {
      u.d("ikey", "过滤证书失败!!!");
      a(this.s);
      return;
    }
    int k = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < k)
      {
        localObject1 = arrayOfString[i];
        if ((ApplicationEx.c.getUser() == null) || (TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))) {}
      }
      else
      {
        try
        {
          Object localObject4 = ApplicationEx.c.k.GetCertAttribute((String)localObject1).Subject.split(",");
          String str = localObject4[0].split("=")[1];
          Object localObject2 = localObject4[1].split("=")[1].replace("\"", "");
          Object localObject3 = localObject4[2].split(":")[1];
          localObject4 = localObject4[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(localObject3)) && (((String)this.s.get("name")).equals(localObject4)) && (b(Integer.parseInt((String)this.s.get("mCerType2"))).equals(localObject2)) && (((String)this.s.get("cerNum")).equals(str)))
          {
            u.d("ikey", "证书主题为:" + ApplicationEx.c.k.GetCertAttribute((String)localObject1).toString());
            d((String)localObject1);
            u.d("ikey", "同一用户");
          }
          for (;;)
          {
            delRepetition(arrayOfString);
            return;
            u.d("ikey", "不同用户");
            a(this.s);
          }
          int j;
          i += 1;
        }
        catch (Exception localException)
        {
          localObject1 = localException.getCause();
          localObject2 = new StringBuffer();
          while (localObject1 != null)
          {
            localObject3 = ((Throwable)localObject1).getStackTrace();
            ((StringBuffer)localObject2).append("\n");
            ((StringBuffer)localObject2).append(localObject1);
            j = 0;
            while (j < localObject3.length)
            {
              ((StringBuffer)localObject2).append("\nError:" + localObject3[j].toString());
              j += 1;
            }
            localObject1 = ((Throwable)localObject1).getCause();
          }
          MobclickAgent.onEvent(this, "SignedCertInfoConfirmActivity_7", this.A);
          com.ziroom.ziroomcustomer.e.d.errorLog(this, localException.getMessage(), ((StringBuffer)localObject2).toString());
        }
      }
    }
  }
  
  private String h()
  {
    Object localObject1 = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
    if (localObject1.length > 0)
    {
      localObject1 = ApplicationEx.c.k.GetCertAttribute(localObject1[0]).toString().split(",");
      if (localObject1.length > 15)
      {
        Object localObject2 = localObject1[15];
        localObject1 = localObject2;
        if (((String)localObject2).trim().startsWith("ValidTo")) {
          localObject1 = ((String)localObject2).replace("ValidTo=", "");
        }
        return (String)localObject1;
      }
    }
    return null;
  }
  
  private boolean i()
  {
    if (ApplicationEx.c.k == null) {
      ApplicationEx.c.k = ClientForAndroid.getInstance(this);
    }
    k();
    int i = ApplicationEx.c.k.SetLicense(ApplicationEx.c.getRaConfig().getLicense());
    u.d("ikey", "SetLicense===" + i + "---" + ApplicationEx.c.getRaConfig().getLicense());
    if (i == 0)
    {
      ApplicationEx.c.k.SetSystemDBDir(getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
      File localFile = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/db/");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return j();
    }
    return false;
  }
  
  private boolean j()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5);
    if (i == 3)
    {
      bool1 = bool2;
      if (ApplicationEx.c.k.CSetAdminPIN("", "123", 0) == 0)
      {
        bool1 = bool2;
        if (ApplicationEx.c.k.CInitUserPIN("123", "111") == 0)
        {
          bool1 = bool2;
          if (ApplicationEx.c.k.VerifyUserPIN(Build.MODEL, "111", 5) == 0) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (i == 1)
    {
      if ((l()) && (this.x))
      {
        this.x = false;
        f();
        return false;
      }
      MobclickAgent.onEvent(this, "SignedCertInfoConfirmActivity_8", this.A);
      com.ziroom.ziroomcustomer.e.d.errorLog(this, "初始化pin失败", "操作失败!!" + ApplicationEx.c.k.GetLastErrInfo());
      dismissProgress();
      showToast("无纸化出现异常,请稍后再试!");
      return false;
    }
    if (i == 0) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  private boolean k()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
  }
  
  private boolean l()
  {
    boolean bool = false;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "cert9.db";
    arrayOfString[1] = "itrusChina.db";
    arrayOfString[2] = "key4.db";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(getApplicationContext().getFilesDir().getAbsolutePath() + "/db/" + (String)localObject);
      if (((File)localObject).exists()) {
        bool = ((File)localObject).delete();
      }
      i += 1;
    }
    return bool;
  }
  
  public void delRepetition(String[] paramArrayOfString)
  {
    u.d("ikey", "去除证书重复!");
    if (paramArrayOfString.length <= 1) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j) {
          break;
        }
        String str1 = paramArrayOfString[i];
        if (!TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))
        {
          Object localObject = ApplicationEx.c.k.GetCertAttribute(str1).Subject.split(",");
          String str2 = localObject[0].split("=")[1];
          String str3 = localObject[1].split("=")[1].replace("\"", "");
          String str4 = localObject[2].split(":")[1];
          localObject = localObject[5].split("=")[1];
          if ((ApplicationEx.c.getUser().getUid().equals(str4)) && (((String)this.s.get("name")).equals(localObject)) && (b(Integer.parseInt((String)this.s.get("mCerType2"))).equals(str3)) && (((String)this.s.get("cerNum")).equals(str2)))
          {
            u.d("ikey", "相同证书");
          }
          else
          {
            ApplicationEx.c.k.DeleteCertBySerialNumber(ApplicationEx.c.k.GetCertSerialNumber(str1));
            u.d("ikey", "删除证书");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        return;
      }
      i += 1;
    }
  }
  
  @OnClick({2131690105, 2131692444, 2131692446})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690105: 
      if (this.z == 4)
      {
        e();
        return;
      }
      finish();
      return;
    case 2131692444: 
      a(0, this.f);
      return;
    }
    a(1, this.e);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    label277:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.d == 1)
              {
                if (this.z != 2)
                {
                  j.iTrusRaConfig(this, this.O);
                  return;
                }
                paramView = new Intent(this.c, SignerAptitudeActivity.class);
                paramView.putExtra("type", this.z);
                paramView.putExtra("detail", this.r);
                startActivity(paramView);
                return;
              }
              if (this.z == 4)
              {
                com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("企业用户需要联系管家线下转签").setTitle("").setButtonText("知道了", "联系管家").setOnConfirmClickListener(new d.b()
                {
                  public void onLeftClick(View paramAnonymousView) {}
                  
                  public void onRightClick(View paramAnonymousView)
                  {
                    if (ApplicationEx.c.getContracts() != null)
                    {
                      paramAnonymousView = ((Contract)ApplicationEx.c.getContracts().get(0)).getHire_commissioner_phone();
                      if (ae.notNull(paramAnonymousView))
                      {
                        ah.callPhone(SignedCertInfoConfirmActivity.c(SignedCertInfoConfirmActivity.this), paramAnonymousView);
                        return;
                      }
                      SignedCertInfoConfirmActivity.this.showToast("获取管家手机号失败");
                      return;
                    }
                    SignedCertInfoConfirmActivity.this.showToast("获取管家手机号失败");
                  }
                }).show();
                return;
              }
              if (this.z == 2)
              {
                showToast("以公司名称签约，暂不支持配置中房源预订哦");
                return;
              }
              if (this.z == 3)
              {
                if ("QRYD".equals(com.alibaba.fastjson.a.parseObject(this.r.getSubletReserveCode()).getString("confirmType")))
                {
                  paramView = new Intent(this, ContractTermsActivity.class);
                  paramView.putExtra("type", this.z);
                  paramView.putExtra("detail", this.r);
                  startActivity(paramView);
                }
              }
              else
              {
                if (this.z != 5) {
                  break label277;
                }
                a(Integer.valueOf(2));
                return;
              }
              showToast("以公司名称签约，暂不支持转租中房源预订哦");
              return;
              if (this.z == 1)
              {
                paramView = this.signed_person_cert_info_name.getText().toString().trim();
                String str1 = this.signed_person_cert_info_cert_id.getText().toString().trim();
                String str2 = this.signed_person_cert_info_phone.getText().toString().trim();
                if (ae.isNull(paramView))
                {
                  showToast("请填写真是姓名");
                  return;
                }
                if (this.v == 0)
                {
                  showToast("请选择性别");
                  return;
                }
                if (this.u == 0)
                {
                  showToast("请选择证件类型");
                  return;
                }
                if (ae.isNull(str1))
                {
                  showToast("请填写证件号码");
                  return;
                }
                if (ae.isNull(str2))
                {
                  showToast("手机号格式错误");
                  return;
                }
                if (str2.length() != 11)
                {
                  showToast("手机号格式错误");
                  return;
                }
                if (paramView.length() > 42)
                {
                  showToast("姓名不能超过42位字符");
                  return;
                }
                if (!ah.isMobile(str2))
                {
                  showToast("手机号格式错误");
                  return;
                }
                if (!ah.checkCertCode(str1))
                {
                  showToast("证件号格式错误");
                  return;
                }
                com.ziroom.ziroomcustomer.signed.a.c localc = new com.ziroom.ziroomcustomer.signed.a.c();
                localc.setName(paramView);
                localc.setCertId(str1);
                localc.setCertType(this.u + "");
                localc.setPhone(str2);
                localc.setSex(this.v + "");
                a(localc);
                return;
              }
              finish();
              return;
              if (!"联系管家".equals(((TextView)paramView).getText())) {
                break;
              }
            } while (ApplicationEx.c.getContracts() == null);
            ah.callPhone(this, ((Contract)ApplicationEx.c.getContracts().get(0)).getHire_commissioner_phone());
            this.N.dismiss();
            return;
          } while (!"确认".equals(((TextView)paramView).getText()));
          finish();
          return;
          if (!"稍后再说".equals(((TextView)paramView).getText())) {
            break;
          }
        } while (this.N == null);
        this.N.dismiss();
        return;
        if (!"取消".equals(((TextView)paramView).getText())) {
          break;
        }
      } while (this.H == null);
      this.H.dismiss();
      return;
    } while (!"知道了".equals(((TextView)paramView).getText()));
    if (this.H != null) {
      this.H.dismiss();
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903500);
    this.c = this;
    this.b = ButterKnife.bind(this);
    this.g = ((CertInfoEntity)getIntent().getParcelableExtra("cert_info"));
    this.r = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    this.z = getIntent().getIntExtra("type", 0);
    this.A.put("brand", Build.BRAND);
    this.A.put("product", Build.PRODUCT);
    this.A.put("version", Build.VERSION.RELEASE);
    b();
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      if (this.z == 4) {
        e();
      } else {
        finish();
      }
    }
  }
  
  private class a
    extends AsyncTask<Bundle, Integer, String>
  {
    private a() {}
    
    protected String a(Bundle... paramVarArgs)
    {
      Object localObject = paramVarArgs[0];
      paramVarArgs = ((Bundle)localObject).getString("CSR");
      String str1 = ((Bundle)localObject).getString("CHALLENGE");
      String str2 = ((Bundle)localObject).getString("PassPort");
      localObject = (com.itrus.raapi.implement.UserInfo)((Bundle)localObject).getSerializable("UserInfo");
      return SignedCertInfoConfirmActivity.m(SignedCertInfoConfirmActivity.this).enrollCert(paramVarArgs, (com.itrus.raapi.implement.UserInfo)localObject, str2, str1, "1");
    }
    
    protected void a(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        u.d("ikey", "证书申请失败");
        MobclickAgent.onEvent(SignedCertInfoConfirmActivity.this, "SignedCertInfoConfirmActivity_3", SignedCertInfoConfirmActivity.e(SignedCertInfoConfirmActivity.this));
        com.ziroom.ziroomcustomer.e.d.errorLog(SignedCertInfoConfirmActivity.this, "证书申请失败", "操作失败!!" + paramString);
      }
      for (;;)
      {
        SignedCertInfoConfirmActivity.this.dismissProgress();
        super.onPostExecute(paramString);
        return;
        if ("$OKOKOK$".equals(paramString.substring(0, "$OKOKOK$".length())))
        {
          if (ApplicationEx.c.k.ImportCert("", paramString.substring("$OKOKOK$".length() - 1)) == 0)
          {
            u.d("ikey", "证书导入成功!!!");
            Object localObject = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
            if (localObject.length < 1)
            {
              u.d("ikey", "过滤证书失败!!!");
            }
            else
            {
              u.d("ikey", "证书主题为:" + ApplicationEx.c.k.GetCertAttribute(localObject[0]).toString());
              if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 0)
              {
                SignedCertInfoConfirmActivity.this.finish();
              }
              else if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 5)
              {
                if ("1".equals(SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getCert_type()))
                {
                  localObject = new Intent(SignedCertInfoConfirmActivity.this, BankcardDetailActivity.class);
                  ((Intent)localObject).putExtra("name", SignedCertInfoConfirmActivity.b(SignedCertInfoConfirmActivity.this).getReal_name());
                  SignedCertInfoConfirmActivity.this.startActivity((Intent)localObject);
                  SignedCertInfoConfirmActivity.this.finish();
                }
                else
                {
                  SignedCertInfoConfirmActivity.a(SignedCertInfoConfirmActivity.this, Integer.valueOf(2));
                }
              }
              else if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 4)
              {
                localObject = new Intent(SignedCertInfoConfirmActivity.this, TurnSignTermsActivity.class);
                SignedCertInfoConfirmActivity.this.startActivity((Intent)localObject);
              }
              else if ((SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 1) || (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 2))
              {
                localObject = new Intent(SignedCertInfoConfirmActivity.this, SignerAptitudeActivity.class);
                ((Intent)localObject).putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
                ((Intent)localObject).putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
                SignedCertInfoConfirmActivity.this.startActivity((Intent)localObject);
              }
              else if (SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this) == 3)
              {
                if ("QRYD".equals(com.alibaba.fastjson.a.parseObject(SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this).getSubletReserveCode()).getString("confirmType")))
                {
                  localObject = new Intent(SignedCertInfoConfirmActivity.this, ContractTermsActivity.class);
                  ((Intent)localObject).putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
                  ((Intent)localObject).putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
                  SignedCertInfoConfirmActivity.this.startActivity((Intent)localObject);
                }
                else
                {
                  localObject = new Intent(SignedCertInfoConfirmActivity.this, SignerAptitudeActivity.class);
                  ((Intent)localObject).putExtra("type", SignedCertInfoConfirmActivity.h(SignedCertInfoConfirmActivity.this));
                  ((Intent)localObject).putExtra("detail", SignedCertInfoConfirmActivity.d(SignedCertInfoConfirmActivity.this));
                  SignedCertInfoConfirmActivity.this.startActivity((Intent)localObject);
                }
              }
              else
              {
                SignedCertInfoConfirmActivity.this.finish();
              }
            }
          }
          else
          {
            MobclickAgent.onEvent(SignedCertInfoConfirmActivity.this, "SignedCertInfoConfirmActivity_4", SignedCertInfoConfirmActivity.e(SignedCertInfoConfirmActivity.this));
            com.ziroom.ziroomcustomer.e.d.errorLog(SignedCertInfoConfirmActivity.this, "证书导入失败!!!", "证书导入失败!!!" + ApplicationEx.c.k.GetLastErrInfo());
          }
        }
        else
        {
          u.d("ikey", "证书申请失败!!!\n" + paramString);
          MobclickAgent.onEvent(SignedCertInfoConfirmActivity.this, "SignedCertInfoConfirmActivity_5", SignedCertInfoConfirmActivity.e(SignedCertInfoConfirmActivity.this));
          com.ziroom.ziroomcustomer.e.d.errorLog(SignedCertInfoConfirmActivity.this, "证书申请失败!!!", "证书申请失败!!!\n" + paramString + "\n" + ApplicationEx.c.k.GetLastErrInfo());
          SignedCertInfoConfirmActivity.this.showToast("无纸化签约证书出现问题,请稍后再试!!!");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignedCertInfoConfirmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */