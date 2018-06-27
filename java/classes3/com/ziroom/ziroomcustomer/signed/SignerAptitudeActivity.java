package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.d.a;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.d;
import com.ziroom.ziroomcustomer.e.e.k;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.signed.a.i;
import com.ziroom.ziroomcustomer.signed.a.n;
import com.ziroom.ziroomcustomer.signed.a.p;
import com.ziroom.ziroomcustomer.signed.widget.SignerLabeledEditText;
import com.ziroom.ziroomcustomer.signed.widget.SignerLabeledEditText.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.SignerInfoView;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSignHouseInfoActivity;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SignerAptitudeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private com.ziroom.ziroomcustomer.signed.a.j A;
  private String B;
  private HouseDetail C;
  private View D;
  private Dialog E;
  private int F;
  private i G;
  private int H;
  private String I;
  private String J;
  private String K;
  private String L;
  private com.freelxl.baselibrary.d.c.a<String> M = new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.e())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      SignerAptitudeActivity.this.tv_rightButton.setEnabled(true);
      SignerAptitudeActivity.this.signer_btn_next.setEnabled(true);
      if ((paramAnonymousThrowable instanceof com.freelxl.baselibrary.d.d.a))
      {
        SignerAptitudeActivity.this.showToast(paramAnonymousThrowable.getMessage());
        return;
      }
      if (((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b)) || ((paramAnonymousThrowable instanceof com.ziroom.ziroomcustomer.e.b.a)))
      {
        SignerAptitudeActivity.this.showToast(paramAnonymousThrowable.getMessage());
        return;
      }
      SignerAptitudeActivity.this.showToast("服务器请求异常！");
    }
    
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      SignerAptitudeActivity.this.tv_rightButton.setEnabled(true);
      SignerAptitudeActivity.this.signer_btn_next.setEnabled(true);
      com.freelxl.baselibrary.f.d.d("SignerAptitudeActivity ", paramAnonymousString);
      if ("success".equals(com.ziroom.ziroomcustomer.ziroomstation.utils.h.getJsonString(paramAnonymousString, "status"))) {
        if (TextUtils.isEmpty(SignerAptitudeActivity.a(SignerAptitudeActivity.this))) {
          if ("AccountInfoActivity".equals(SignerAptitudeActivity.b(SignerAptitudeActivity.this)))
          {
            com.freelxl.baselibrary.f.g.textToast(SignerAptitudeActivity.this.getApplicationContext(), "提交成功");
            SignerAptitudeActivity.this.finish();
          }
        }
      }
      String str;
      do
      {
        do
        {
          return;
          if ((SignerAptitudeActivity.c(SignerAptitudeActivity.this) == 2) || (SignerAptitudeActivity.c(SignerAptitudeActivity.this) == 3))
          {
            paramAnonymousString = new Intent(SignerAptitudeActivity.this, ContractTermsActivity.class);
            paramAnonymousString.putExtra("type", SignerAptitudeActivity.c(SignerAptitudeActivity.this));
            paramAnonymousString.putExtra("detail", SignerAptitudeActivity.d(SignerAptitudeActivity.this));
            SignerAptitudeActivity.this.startActivity(paramAnonymousString);
            return;
          }
          paramAnonymousString = new Intent(SignerAptitudeActivity.this, SignedLeaseInfoActivity.class);
          paramAnonymousString.putExtra("detail", SignerAptitudeActivity.d(SignerAptitudeActivity.this));
          SignerAptitudeActivity.this.startActivity(paramAnonymousString);
          return;
        } while (!"zra".equals(SignerAptitudeActivity.a(SignerAptitudeActivity.this)));
        paramAnonymousString = new Intent(SignerAptitudeActivity.this, ZryuSignHouseInfoActivity.class);
        paramAnonymousString.putExtra("contractId", SignerAptitudeActivity.e(SignerAptitudeActivity.this));
        SignerAptitudeActivity.this.startActivity(paramAnonymousString);
        return;
        str = com.ziroom.ziroomcustomer.ziroomstation.utils.h.getJsonString(paramAnonymousString, "error_code");
        paramAnonymousString = com.ziroom.ziroomcustomer.ziroomstation.utils.h.getJsonString(paramAnonymousString, "error_message");
      } while (TextUtils.isEmpty(paramAnonymousString));
      if ("30070".equals(str))
      {
        SignerAptitudeActivity.a(SignerAptitudeActivity.this, paramAnonymousString);
        return;
      }
      SignerAptitudeActivity.this.showToast(paramAnonymousString);
    }
  };
  private f<String> N = new f(this, new com.ziroom.ziroomcustomer.e.c.q(String.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      u.e("SignerAptitudeActivity", "onSuccess:获取资质信息成功 " + paramAnonymousString);
      paramAnonymousString = com.ziroom.ziroomcustomer.ziroomstation.utils.h.parseArray(paramAnonymousString, com.ziroom.ziroomcustomer.signed.a.j.class);
      if (!s.isEmpty(paramAnonymousString)) {
        SignerAptitudeActivity.a(SignerAptitudeActivity.this, (com.ziroom.ziroomcustomer.signed.a.j)paramAnonymousString.get(0));
      }
      if (SignerAptitudeActivity.f(SignerAptitudeActivity.this) == 100)
      {
        if (SignerAptitudeActivity.g(SignerAptitudeActivity.this) != null) {
          SignerAptitudeActivity.g(SignerAptitudeActivity.this).getLinkedinStatus();
        }
        SignerAptitudeActivity.a(SignerAptitudeActivity.this, -1);
        return;
      }
      SignerAptitudeActivity.h(SignerAptitudeActivity.this);
    }
  };
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a O;
  private com.ziroom.ziroomcustomer.signed.a.e P;
  private n Q;
  String a = "0";
  int b = 0;
  String c = "";
  String d = "";
  String e = "";
  String f = "";
  String g = "";
  @BindView(2131692466)
  ImageView iv_photo_help;
  @BindView(2131692461)
  SignerLabeledEditText let_signerEmergencyContactName;
  @BindView(2131692462)
  SignerLabeledEditText let_signerEmergencyContactPhone;
  @BindView(2131692464)
  LabeledEditText let_signerEmergencyContactRelate;
  @BindView(2131692465)
  LinearLayout ll_photo;
  String r = "";
  private p s;
  @BindView(2131692467)
  SimpleDraweeView sdv_photo;
  @BindView(2131692468)
  SignerInfoView sif_linkLingYin;
  @BindView(2131692460)
  SignerInfoView sif_signerAddress;
  @BindView(2131692457)
  SignerInfoView sif_signerPlace;
  @BindView(2131692456)
  SignerInfoView sif_signerTradeDirect;
  @BindView(2131692453)
  LinearLayout signerDetail_ll_status;
  @BindView(2131692454)
  ImageView signerIvStatus;
  @BindView(2131692455)
  TextView signerTvStatus;
  @BindView(2131692470)
  Button signer_btn_next;
  @BindView(2131692458)
  SignerLabeledEditText signer_let_schoolName;
  @BindView(2131692469)
  TextView signer_tv_hint;
  @BindView(2131692463)
  SignerInfoView singer_relate;
  private p t;
  @BindView(2131691446)
  TextView tv_photo;
  @BindView(2131695950)
  TextView tv_rightButton;
  @BindView(2131695949)
  TextView tv_title;
  private int u = 0;
  private String v;
  @BindView(2131692459)
  View v_divideLine;
  private String w;
  private com.ziroom.ziroomcustomer.signed.a.d x;
  private String y = "";
  private a z;
  
  private void a()
  {
    String str1;
    String str2;
    if (this.A != null)
    {
      this.v = this.A.getWork_name();
      this.w = this.A.getWork_address();
      this.c = this.A.getIndustry();
      this.d = this.A.getIndustry_id();
      this.e = this.A.getDirection();
      this.f = this.A.getDirection_id();
      this.g = this.A.getSocial_proof();
      this.r = this.A.getCert_id();
      this.P = this.A.getCredits();
      if (this.P == null) {
        break label789;
      }
      str1 = "重新提交";
      str2 = this.P.getWorkStatus();
      if ((!"1".equals(str2)) && (!"2".equals(str2))) {
        break label635;
      }
      this.signerTvStatus.setText("已提交，您的资质信息正在审核中。");
      this.signerTvStatus.setTextColor(Color.parseColor("#999999"));
      this.signerIvStatus.setVisibility(8);
      this.tv_rightButton.setText(str1);
      if ("1".equals(this.P.getLinkedinStatus())) {}
      label197:
      if (TextUtils.isEmpty(this.c)) {
        break label935;
      }
      if ((!TextUtils.isEmpty(this.e)) && (!"3".equals(this.g))) {
        break label834;
      }
      this.sif_signerTradeDirect.setContent(this.c);
      label242:
      if (!"3".equals(this.g)) {
        break label875;
      }
      this.signer_let_schoolName.setVisibility(0);
      this.v_divideLine.setVisibility(0);
      this.signer_let_schoolName.setText(this.v);
      this.signer_let_schoolName.setTopHint("在读学校");
      this.sif_signerAddress.setTitle("学校地址");
      label303:
      this.sif_signerAddress.setVisibility(0);
      this.sif_signerAddress.setContent(this.w);
      this.s = new p();
      this.s.setId(this.d);
      this.s.setName(this.c);
      this.t = new p();
      this.t.setId(this.f);
      this.t.setName(this.e);
      label389:
      if (!"1".equals(this.a)) {
        break label1003;
      }
      this.signerDetail_ll_status.setVisibility(8);
      label410:
      if ((this.I == null) || (!"zra".equals(this.I))) {
        break label1014;
      }
      this.ll_photo.setVisibility(0);
      this.sdv_photo.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          SignerAptitudeActivity.j(SignerAptitudeActivity.this);
        }
      });
      if ((!TextUtils.isEmpty(this.A.getAccessory_url())) && (!this.A.getAccessory_url().startsWith("http:")) && (!this.A.getAccessory_url().startsWith("https:")))
      {
        this.L = this.A.getAccessory_url();
        d(this.A.getAccessory_url());
      }
      this.iv_photo_help.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(SignerAptitudeActivity.this).setTitle("提示").setContent("社会资质证明照片：可证明您在上述单位就职或在学校上学，例如劳动合同第一页和最后一页、工作证明（需加盖公章）、工牌、学生证等").build().show();
        }
      });
    }
    for (;;)
    {
      this.let_signerEmergencyContactName.setText(this.A.getUrgency_name());
      this.let_signerEmergencyContactPhone.setText(this.A.getUrgency_phone());
      this.singer_relate.setContent(this.A.getUrgency_relation());
      if ("1".equals(this.A.getHint())) {
        e("尊敬的用户，资质信息已升级，请\n重新提交认证。");
      }
      this.let_signerEmergencyContactName.addTextChangedListener(new SignerLabeledEditText.a()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousCharSequence = SignerAptitudeActivity.this;
          paramAnonymousCharSequence.b += 1;
        }
      });
      this.let_signerEmergencyContactPhone.addTextChangedListener(new SignerLabeledEditText.a()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousCharSequence = SignerAptitudeActivity.this;
          paramAnonymousCharSequence.b += 1;
        }
      });
      j();
      return;
      label635:
      if ("3".equals(str2))
      {
        this.signerIvStatus.setVisibility(8);
        this.signerIvStatus.setImageResource(2130839723);
        this.signerTvStatus.setText(Html.fromHtml("<font color='#999999'>未通过，</font><font color='#FFA000'><U>查看驳回原因</U></font>"));
        this.signerTvStatus.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = SignerAptitudeActivity.i(SignerAptitudeActivity.this).getCredits();
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.getRejectReason()))) {
              SignerAptitudeActivity.b(SignerAptitudeActivity.this, paramAnonymousView.getRejectReason());
            }
          }
        });
        break;
      }
      if ("4".equals(str2))
      {
        this.signerIvStatus.setVisibility(8);
        this.signerIvStatus.setImageResource(2130839724);
        this.signerTvStatus.setText("已认证，您的资质信息已通过审核。");
        this.signerTvStatus.setTextColor(Color.parseColor("#999999"));
        break;
      }
      str1 = "提交";
      this.signerIvStatus.setVisibility(8);
      this.signerTvStatus.setText("待完善");
      this.signerTvStatus.setTextColor(Color.parseColor("#999999"));
      break;
      label789:
      this.tv_rightButton.setText("提交");
      this.signerIvStatus.setVisibility(8);
      this.signerTvStatus.setText("待完善");
      this.signerTvStatus.setTextColor(Color.parseColor("#999999"));
      break label197;
      label834:
      this.sif_signerTradeDirect.setContent(this.c + "/" + this.e);
      break label242;
      label875:
      this.signer_let_schoolName.setVisibility(8);
      this.signer_let_schoolName.setText(this.v);
      this.sif_signerPlace.setVisibility(0);
      this.sif_signerPlace.setTitle("公司名称").setContent(this.v);
      this.sif_signerAddress.setTitle("公司地址");
      break label303;
      label935:
      this.signer_let_schoolName.setVisibility(8);
      this.v_divideLine.setVisibility(8);
      this.sif_signerPlace.setVisibility(8);
      this.sif_signerAddress.setVisibility(8);
      this.sif_signerPlace.setContent("");
      this.sif_signerAddress.setContent("");
      this.signer_let_schoolName.setText("");
      break label389;
      label1003:
      this.signerDetail_ll_status.setVisibility(0);
      break label410;
      label1014:
      this.ll_photo.setVisibility(8);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.F = paramIntent.getIntExtra("type", 0);
    this.B = paramIntent.getStringExtra("activityName");
    if ("AccountInfoActivity".equals(this.B))
    {
      this.signer_btn_next.setVisibility(8);
      this.signer_tv_hint.setVisibility(8);
      this.tv_rightButton.setVisibility(0);
      if ((this.F != 2) && (this.F != 3)) {
        break label185;
      }
      w.onEvent(this, "book_qualification_promise");
      label90:
      this.I = getIntent().getStringExtra("zraType");
      if (!TextUtils.isEmpty(this.I)) {
        break label204;
      }
      this.C = ((HouseDetail)getIntent().getSerializableExtra("detail"));
      if (this.C != null) {
        break label195;
      }
      this.a = "0";
    }
    for (;;)
    {
      e();
      return;
      this.tv_rightButton.setVisibility(8);
      this.signer_btn_next.setVisibility(0);
      this.signer_tv_hint.setVisibility(0);
      this.sif_linkLingYin.setVisibility(0);
      break;
      label185:
      w.onEvent(this, "signup_qualification_promise");
      break label90;
      label195:
      this.a = "1";
      continue;
      label204:
      if ("zra".equals(this.I))
      {
        this.J = getIntent().getStringExtra("contractId");
        this.a = "1";
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        return paramString1.equals(paramString2);
      }
      return false;
    }
    return TextUtils.isEmpty(paramString2);
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("拍照");
    localArrayList.add("照片选择");
    new com.ziroom.ziroomcustomer.dialog.d(this, localArrayList, new d.a()
    {
      public void callback(int paramAnonymousInt, String paramAnonymousString)
      {
        if ("拍照".equals(paramAnonymousString)) {
          SignerAptitudeActivity.this.takePhoto();
        }
        while (!"照片选择".equals(paramAnonymousString)) {
          return;
        }
        SignerAptitudeActivity.this.selectPhoto();
      }
    }).show();
  }
  
  private void b(int paramInt)
  {
    String str1 = this.let_signerEmergencyContactName.getText();
    String str2 = this.let_signerEmergencyContactPhone.getText();
    String str3 = this.singer_relate.getContent();
    Object localObject;
    if (this.s != null)
    {
      this.c = this.s.getName();
      this.d = this.s.getId();
      if (!s.isEmpty(this.s.getAspects()))
      {
        localObject = (p)this.s.getAspects().get(this.u);
        this.e = ((p)localObject).getName();
        this.f = ((p)localObject).getId();
      }
    }
    if (TextUtils.isEmpty(this.c)) {
      com.freelxl.baselibrary.f.g.textToast(this, "请选择行业/方向");
    }
    do
    {
      return;
      if (!"3".equals(this.g)) {
        break;
      }
      this.v = this.signer_let_schoolName.getText();
    } while ((checkNotNull(this.v, "请填写学校名称")) || (checkNotNull(this.w, "请选择学校地址")));
    for (;;)
    {
      if (TextUtils.isEmpty(str1))
      {
        com.freelxl.baselibrary.f.g.textToast(this, "请留一个紧急联系人/证明人姓名");
        return;
        if (checkNotNull(this.v, "请填写公司名称")) {
          break;
        }
        if (checkNotNull(this.w, "请选择公司地址")) {
          return;
        }
      }
    }
    if (TextUtils.isEmpty(str2))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "请填写紧急联系人/证明人电话");
      return;
    }
    if (TextUtils.isEmpty(str3))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "请说明与紧急联系人/证明人的关系");
      return;
    }
    if (this.v.length() > 50)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "公司名称不能超过50个字");
      return;
    }
    if (("3".equals(this.g)) && (this.v.length() > 50))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "学校名称不能超过50个字");
      return;
    }
    if (str1.length() > 20)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "紧急联系人/证明人不能超过20位");
      return;
    }
    if (str2.length() > 20)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "紧急联系人/证明人电话不能超过20位");
      return;
    }
    if ((!n()) && ("0".equals(this.a)))
    {
      if ("AccountInfoActivity".equals(this.B))
      {
        finish();
        return;
      }
      if ((this.F == 2) || (this.F == 3))
      {
        localObject = new Intent(this, ContractTermsActivity.class);
        ((Intent)localObject).putExtra("type", this.F);
        ((Intent)localObject).putExtra("detail", this.C);
        startActivity((Intent)localObject);
        return;
      }
      localObject = new Intent(this, SignedLeaseInfoActivity.class);
      ((Intent)localObject).putExtra("detail", this.C);
      startActivity((Intent)localObject);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this));
    if (!ae.notNull(this.r)) {
      this.r = "0";
    }
    localHashMap.put("cert_id", this.r);
    localHashMap.put("social_proof", this.g);
    localHashMap.put("work_name", this.v);
    if (this.x == null)
    {
      localObject = "";
      localHashMap.put("work_id", localObject);
      localHashMap.put("work_address", this.w);
      if (this.z != null) {
        break label1080;
      }
      localObject = "";
      label595:
      localHashMap.put("work_longitude", localObject);
      if (this.z != null) {
        break label1094;
      }
      localObject = "";
      label617:
      localHashMap.put("work_latitude", localObject);
      localHashMap.put("industry", this.c);
      localHashMap.put("industry_id", this.d);
      if ((this.G == null) || (((!"2".equals(this.g)) || (!this.sif_signerPlace.getContent().equals(this.G.getWork_name())) || (!this.sif_signerTradeDirect.getContent().equals(this.G.getIndustry() + "/" + this.G.getDirection()))) && ((!"3".equals(this.g)) || (!this.signer_let_schoolName.getText().equals(this.G.getWork_name())) || (!this.sif_signerAddress.getContent().equals(this.G.getWork_address()))))) {
        break label1108;
      }
      label800:
      localHashMap.put("judge", this.y);
      if (!"3".equals(this.g)) {
        break label1118;
      }
      localHashMap.put("direction", "");
      localHashMap.put("direction_id", "");
    }
    for (;;)
    {
      localHashMap.put("is_newsign", this.a);
      localHashMap.put("urgency_name", str1);
      localHashMap.put("urgency_phone", str2);
      localHashMap.put("urgency_relation", str3);
      if (paramInt == 2131692470)
      {
        if (this.C == null)
        {
          this.C = new HouseDetail();
          this.C.setHouse_code("0");
          this.C.setHouse_id("0");
          this.C.setHouse_type("1");
        }
        localHashMap.put("house_code", this.C.getHouse_code());
        localHashMap.put("house_id", this.C.getHouse_id());
        localHashMap.put("house_type", this.C.getHouse_type());
      }
      if ((paramInt != 2131695950) || (this.b != 0) || (this.A == null) || (this.A.getCredits() == null) || (!"3".equals(this.A.getCredits().getWorkStatus()))) {
        break label1151;
      }
      com.freelxl.baselibrary.f.g.textToast(this, "您需要根据驳回原因修改后才能重新提交！");
      return;
      localObject = this.x.getId();
      break;
      label1080:
      localObject = String.valueOf(this.z.getLongitude());
      break label595;
      label1094:
      localObject = String.valueOf(this.z.getLatitude());
      break label617;
      label1108:
      this.y = "3";
      break label800;
      label1118:
      localHashMap.put("direction", this.e);
      localHashMap.put("direction_id", this.f);
    }
    label1151:
    if ((!TextUtils.isEmpty(this.I)) && ("zra".equals(this.I)))
    {
      if (TextUtils.isEmpty(this.L))
      {
        com.freelxl.baselibrary.f.g.textToast(this, "请上传社会资质证明照片！");
        return;
      }
      localHashMap.put("accessory_url", this.L);
    }
    this.tv_rightButton.setEnabled(false);
    this.signer_btn_next.setEnabled(false);
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.e.q.O + e.k.b).tag(this).addHeader("Accept", "application/json; version=1").params(com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap)).enqueue(this.M);
    com.freelxl.baselibrary.f.d.d("SignerAptitudeActivity", com.ziroom.ziroomcustomer.e.q.O + e.k.b + com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap));
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this));
    localHashMap.put("is_newsign", this.a);
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.e.q.O + e.k.a).tag(this).addHeader("Accept", "application/json; version=1").params(com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap)).enqueue(this.N);
  }
  
  private void e(String paramString)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this).setContent(paramString).setButtonText("知道了").build().show();
  }
  
  private void f()
  {
    Log.e("careerList", "开始请求资质信息列表数据");
    Object localObject = new HashMap();
    ((Map)localObject).put("token", com.ziroom.commonlibrary.login.a.getToken(this));
    ((Map)localObject).put("is_newsign", this.a);
    localObject = com.ziroom.ziroomcustomer.e.q.O + "/qualificate/maimai/isbind.json" + "?" + ah.encodeGetParams(com.ziroom.ziroomcustomer.e.g.getPassportSign((Map)localObject));
    Log.e("careerList", (String)localObject);
    com.freelxl.baselibrary.d.a.get((String)localObject).tag(this).addHeader("Accept", "application/json; version=1").enqueue(new com.ziroom.ziroomcustomer.findhouse.b.b(this, new com.ziroom.ziroomcustomer.findhouse.b.e(n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        Log.e("careerList", "职业认证数据获取失败！");
      }
      
      public void onSuccess(int paramAnonymousInt, n paramAnonymousn)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousn);
        Log.d("careerList", "获取到了careerList：" + paramAnonymousn.toString());
        SignerAptitudeActivity.a(SignerAptitudeActivity.this, paramAnonymousn);
        SignerAptitudeActivity.this.sif_linkLingYin.setContent(SignerAptitudeActivity.l(SignerAptitudeActivity.this).getRelated());
      }
    });
  }
  
  private void f(String paramString)
  {
    this.D = View.inflate(this, 2130905178, null);
    TextView localTextView1 = (TextView)this.D.findViewById(2131697634);
    TextView localTextView2 = (TextView)this.D.findViewById(2131697637);
    TextView localTextView3 = (TextView)this.D.findViewById(2131697639);
    TextView localTextView4 = (TextView)this.D.findViewById(2131697638);
    localTextView1.setText("提示");
    localTextView3.setText("去提升");
    localTextView4.setText("取消");
    localTextView4.setVisibility(0);
    localTextView2.setText(paramString + "");
    localTextView3.setOnClickListener(this);
    localTextView4.setOnClickListener(this);
    if (this.E == null)
    {
      this.E = new Dialog(this, 2131427781);
      this.E.setContentView(this.D);
      paramString = this.E;
      if (!(paramString instanceof Dialog)) {
        paramString.show();
      }
      for (;;)
      {
        this.E.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            SignerAptitudeActivity.a(SignerAptitudeActivity.this, null);
            SignerAptitudeActivity.o(SignerAptitudeActivity.this).dismiss();
          }
        });
        return;
        VdsAgent.showDialog((Dialog)paramString);
      }
    }
    paramString = this.E;
    if (!(paramString instanceof Dialog))
    {
      paramString.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramString);
  }
  
  private void g()
  {
    if (this.G == null) {
      return;
    }
    if ("3".equals(this.G.getSocial_proof()))
    {
      this.g = "3";
      this.sif_signerPlace.setVisibility(8);
      this.signer_let_schoolName.setVisibility(0);
      this.sif_signerAddress.setVisibility(0);
      this.sif_signerAddress.setTitle("学校地址");
      this.signer_let_schoolName.setText(this.G.getWork_name());
      this.v = this.G.getWork_name();
      this.w = this.G.getWork_address();
      this.x = new com.ziroom.ziroomcustomer.signed.a.d();
      this.x.setId(this.G.getWork_id());
      this.x.setName(this.G.getWork_name());
      this.x.setCode("");
      this.c = this.G.getIndustry();
      this.d = this.G.getIndustry_id();
      this.s = new p();
      this.s.setId(this.G.getIndustry_id());
      this.s.setName(this.G.getIndustry());
      this.e = this.G.getDirection();
      this.f = this.G.getDirection_id();
      this.sif_signerAddress.setContent(this.G.getWork_address());
      if (!"3".equals(this.G.getSocial_proof())) {
        break label351;
      }
    }
    label351:
    for (String str = this.G.getIndustry();; str = this.G.getIndustry() + "/" + this.G.getDirection())
    {
      this.sif_signerTradeDirect.setContent(str);
      h();
      j();
      return;
      this.g = "2";
      this.sif_signerPlace.setVisibility(0);
      this.signer_let_schoolName.setVisibility(8);
      this.sif_signerAddress.setVisibility(0);
      this.sif_signerAddress.setTitle("公司地址");
      this.sif_signerPlace.setContent(this.G.getWork_name());
      break;
    }
  }
  
  private void h()
  {
    if ("0".equals(this.G.getJudge()))
    {
      this.y = "2";
      return;
    }
    if ("1".equals(this.G.getJudge()))
    {
      this.y = "1";
      return;
    }
    this.y = "3";
  }
  
  private boolean i()
  {
    if (this.G == null) {}
    do
    {
      return true;
      if ((TextUtils.isEmpty(this.sif_signerTradeDirect.getContent())) || ("行业/方向".equals(this.sif_signerTradeDirect.getContent())))
      {
        g();
        return true;
      }
    } while ((!TextUtils.isEmpty(this.G.getIndustry())) && (!TextUtils.isEmpty(this.G.getIndustry_id())) && (!TextUtils.isEmpty(this.G.getDirection())) && (!TextUtils.isEmpty(this.G.getWork_name())) && (!TextUtils.isEmpty(this.G.getWork_id())) && (!TextUtils.isEmpty(this.G.getWork_address())) && (((!"2".equals(this.g)) || (this.x == null) || (!this.G.getWork_id().equals(this.x.getId()))) && (("3".equals(this.g)) && (this.G.getWork_name().equals(this.signer_let_schoolName.getText())) && (this.s != null) && (this.G.getIndustry_id().equals(this.s.getId())) && (this.G.getIndustry().equals(this.s.getName())) && (this.G.getWork_name().equals(this.v)) && (this.G.getWork_address().equals(this.w)))));
    return false;
  }
  
  private void j()
  {
    if (TextUtils.isEmpty(this.sif_signerTradeDirect.getContent())) {
      this.sif_signerTradeDirect.setContent("请选择行业方向");
    }
    if (TextUtils.isEmpty(this.sif_signerPlace.getContent())) {
      this.sif_signerPlace.setContent("请选择公司");
    }
    if (TextUtils.isEmpty(this.sif_signerAddress.getContent())) {
      this.sif_signerAddress.setContent("请选择公司地址");
    }
  }
  
  private void k()
  {
    this.tv_title.setText("资质信息");
    this.tv_rightButton.setVisibility(0);
    this.tv_rightButton.setText("提交");
    this.let_signerEmergencyContactName.setFocusChangeListenerAvailable(true);
    this.let_signerEmergencyContactPhone.setFocusChangeListenerAvailable(true);
    this.let_signerEmergencyContactRelate.setFocusChangeListenerAvailable(true);
    this.signer_let_schoolName.setFocusChangeListenerAvailable(true);
  }
  
  private void l()
  {
    this.let_signerEmergencyContactName.disposeFocus(this.tv_title);
    this.let_signerEmergencyContactPhone.disposeFocus(this.tv_title);
    this.let_signerEmergencyContactRelate.disposeFocus(this.tv_title);
    this.signer_let_schoolName.disposeFocus(this.tv_title);
  }
  
  private void m()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("家人");
    localArrayList.add("朋友");
    localArrayList.add("同事");
    localArrayList.add("同学");
    localArrayList.add("密友");
    localArrayList.add("其他");
    if (this.O == null) {
      this.O = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this, "", new a.b()
      {
        public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
        {
          paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
          SignerAptitudeActivity.this.singer_relate.setContent(paramAnonymousHashMap);
          SignerAptitudeActivity.n(SignerAptitudeActivity.this).dismiss();
        }
      }, new List[] { localArrayList });
    }
    this.O.show();
  }
  
  private boolean n()
  {
    if (this.A == null)
    {
      if ((this.v != null) || (this.w != null) || (!TextUtils.isEmpty(this.g)) || (this.s != null) || (!TextUtils.isEmpty(this.let_signerEmergencyContactName.getText())) || (!TextUtils.isEmpty(this.let_signerEmergencyContactPhone.getText())) || (!TextUtils.isEmpty(this.singer_relate.getContent()))) {
        return true;
      }
    }
    else
    {
      String str8 = this.let_signerEmergencyContactName.getText();
      String str9 = this.let_signerEmergencyContactPhone.getText();
      String str10 = this.signer_let_schoolName.getText();
      String str11 = this.singer_relate.getContent();
      if (this.v == null) {
        this.v = "";
      }
      if (this.w == null) {
        this.w = "";
      }
      String str2;
      String str3;
      label167:
      String str4;
      label181:
      String str12;
      String str5;
      label204:
      String str6;
      label218:
      String str7;
      label232:
      p localp2;
      String str1;
      p localp1;
      if (this.A.getWork_name() == null)
      {
        str2 = "";
        if (this.A.getWork_address() != null) {
          break label392;
        }
        str3 = "";
        if (this.A.getIndustry() != null) {
          break label403;
        }
        str4 = "";
        str12 = this.A.getDirection();
        if (this.A.getUrgency_name() != null) {
          break label415;
        }
        str5 = "";
        if (this.A.getUrgency_phone() != null) {
          break label427;
        }
        str6 = "";
        if (this.A.getUrgency_relation() != null) {
          break label439;
        }
        str7 = "";
        localp2 = this.s;
        str1 = "";
        if (localp2 != null) {
          break label451;
        }
        localp1 = new p();
        localp1.setName("");
        localp1.setCode("");
        localp1.setId("");
        localp1.setAspects(null);
        str1 = "";
      }
      for (;;)
      {
        if ((a(str8, str5)) && (a(str9, str6)) && (a(str11, str7)) && (a(str2, this.v)) && (a(str10, this.v)) && (a(str3, this.w)) && (a(str4, localp1.getName())) && (a(str12, str1))) {
          break label477;
        }
        return true;
        str2 = this.A.getWork_name();
        break;
        label392:
        str3 = this.A.getWork_address();
        break label167;
        label403:
        str4 = this.A.getIndustry();
        break label181;
        label415:
        str5 = this.A.getUrgency_name();
        break label204;
        label427:
        str6 = this.A.getUrgency_phone();
        break label218;
        label439:
        str7 = this.A.getUrgency_relation();
        break label232;
        label451:
        localp1 = localp2;
        if (this.t != null)
        {
          str1 = this.t.getName();
          localp1 = localp2;
        }
      }
      label477:
      return false;
    }
    return false;
  }
  
  private void o()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("确认要放弃编辑吗？").setContent("您编辑的信息未提交哦").setBtnCancelText("我再想想").setBtnConfirmText("确认放弃").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          SignerAptitudeActivity.this.finish();
        }
      }
    }).build().show();
  }
  
  protected String b(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.contains("?")) {
      localStringBuilder.append(paramString + "&");
    }
    while ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        localStringBuilder.append(str).append("=").append((String)paramMap.get(str)).append("&");
      }
      localStringBuilder.append(paramString + "?");
    }
    return localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString();
  }
  
  public boolean checkNotNull(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      com.freelxl.baselibrary.f.g.textToast(this, paramString2);
      return true;
    }
    return false;
  }
  
  protected void d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("uuid", paramString + "");
    paramString = com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap);
    paramString = b(com.ziroom.ziroomcustomer.e.q.O + e.d.d, paramString);
    this.sdv_photo.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 1092	com/ziroom/ziroomcustomer/base/BaseActivity:onActivityResult	(IILandroid/content/Intent;)V
    //   7: iload_1
    //   8: lookupswitch	default:+60->68, 1:+821->829, 2:+831->839, 97:+705->713, 98:+61->69, 99:+609->617, 100:+810->818
    //   68: return
    //   69: iload_2
    //   70: sipush 200
    //   73: if_icmpne -5 -> 68
    //   76: aload_3
    //   77: ldc_w 1094
    //   80: invokevirtual 470	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 4
    //   85: aload_0
    //   86: aload_3
    //   87: ldc_w 1096
    //   90: iconst_0
    //   91: invokevirtual 462	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   94: putfield 163	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:u	I
    //   97: aload_0
    //   98: aload 4
    //   100: ldc_w 331
    //   103: invokestatic 1102	com/ziroom/ziroomcustomer/ziroomstation/utils/h:parseObject	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   106: checkcast 331	com/ziroom/ziroomcustomer/signed/a/p
    //   109: putfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   112: aload_0
    //   113: getfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   116: invokevirtual 550	com/ziroom/ziroomcustomer/signed/a/p:getName	()Ljava/lang/String;
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   124: invokevirtual 557	com/ziroom/ziroomcustomer/signed/a/p:getAspects	()Ljava/util/List;
    //   127: invokestatic 562	com/ziroom/ziroomcustomer/util/s:isEmpty	(Ljava/util/List;)Z
    //   130: ifne +322 -> 452
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   138: invokevirtual 557	com/ziroom/ziroomcustomer/signed/a/p:getAspects	()Ljava/util/List;
    //   141: aload_0
    //   142: getfield 163	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:u	I
    //   145: invokeinterface 566 2 0
    //   150: checkcast 331	com/ziroom/ziroomcustomer/signed/a/p
    //   153: putfield 342	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:t	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   156: aload_0
    //   157: getfield 342	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:t	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   160: invokevirtual 550	com/ziroom/ziroomcustomer/signed/a/p:getName	()Ljava/lang/String;
    //   163: astore 4
    //   165: aload 4
    //   167: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +287 -> 457
    //   173: new 437	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 438	java/lang/StringBuilder:<init>	()V
    //   180: aload_3
    //   181: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 444
    //   187: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 4
    //   192: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_3
    //   199: ldc_w 788
    //   202: new 437	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 438	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 1104
    //   212: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: getfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   219: invokevirtual 791	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: ldc_w 1106
    //   225: invokevirtual 442	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: getfield 163	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:u	I
    //   232: invokevirtual 1108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 447	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 1112	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_3
    //   242: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +12 -> 257
    //   248: aload_0
    //   249: getfield 297	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerTradeDirect	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   252: aload_3
    //   253: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   256: pop
    //   257: ldc_w 1114
    //   260: aload_0
    //   261: getfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   264: invokevirtual 1117	com/ziroom/ziroomcustomer/signed/a/p:getCode	()Ljava/lang/String;
    //   267: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   270: ifeq +202 -> 472
    //   273: aload_0
    //   274: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   277: ldc_w 318
    //   280: invokevirtual 321	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:setTopHint	(Ljava/lang/CharSequence;)V
    //   283: aload_0
    //   284: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   287: ldc_w 325
    //   290: invokevirtual 328	com/ziroom/ziroomcustomer/widget/SignerInfoView:setTitle	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   293: pop
    //   294: aload_0
    //   295: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   298: iconst_0
    //   299: invokevirtual 329	com/ziroom/ziroomcustomer/widget/SignerInfoView:setVisibility	(I)V
    //   302: ldc -3
    //   304: aload_0
    //   305: getfield 159	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:g	Ljava/lang/String;
    //   308: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +42 -> 353
    //   314: aload_0
    //   315: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   318: invokevirtual 547	com/ziroom/ziroomcustomer/widget/SignerInfoView:getContent	()Ljava/lang/String;
    //   321: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifeq +136 -> 460
    //   327: aload_0
    //   328: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   331: astore 4
    //   333: aload_0
    //   334: aload 4
    //   336: putfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   339: aload_0
    //   340: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   343: aload_0
    //   344: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   347: invokevirtual 547	com/ziroom/ziroomcustomer/widget/SignerInfoView:getContent	()Ljava/lang/String;
    //   350: invokevirtual 316	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:setText	(Ljava/lang/String;)V
    //   353: aload_0
    //   354: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   357: bipush 8
    //   359: invokevirtual 329	com/ziroom/ziroomcustomer/widget/SignerInfoView:setVisibility	(I)V
    //   362: aload_0
    //   363: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   366: iconst_0
    //   367: invokevirtual 308	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:setVisibility	(I)V
    //   370: aload_0
    //   371: getfield 310	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v_divideLine	Landroid/view/View;
    //   374: iconst_0
    //   375: invokevirtual 313	android/view/View:setVisibility	(I)V
    //   378: aload_0
    //   379: ldc_w 295
    //   382: putfield 159	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:g	Ljava/lang/String;
    //   385: aload_3
    //   386: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifne -321 -> 68
    //   392: aload_0
    //   393: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   396: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +30 -> 429
    //   402: ldc_w 1114
    //   405: aload_0
    //   406: getfield 334	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:s	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   409: invokevirtual 1117	com/ziroom/ziroomcustomer/signed/a/p:getCode	()Ljava/lang/String;
    //   412: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   415: ifeq +187 -> 602
    //   418: aload_0
    //   419: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   422: aload_0
    //   423: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   426: invokevirtual 316	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:setText	(Ljava/lang/String;)V
    //   429: aload_0
    //   430: getfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   433: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   436: ifne -368 -> 68
    //   439: aload_0
    //   440: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   443: aload_0
    //   444: getfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   447: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   450: pop
    //   451: return
    //   452: aload_0
    //   453: aconst_null
    //   454: putfield 342	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:t	Lcom/ziroom/ziroomcustomer/signed/a/p;
    //   457: goto -258 -> 199
    //   460: aload_0
    //   461: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   464: invokevirtual 547	com/ziroom/ziroomcustomer/widget/SignerInfoView:getContent	()Ljava/lang/String;
    //   467: astore 4
    //   469: goto -136 -> 333
    //   472: aload_0
    //   473: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   476: ldc_w 451
    //   479: invokevirtual 328	com/ziroom/ziroomcustomer/widget/SignerInfoView:setTitle	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   482: pop
    //   483: aload_0
    //   484: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   487: ldc_w 453
    //   490: invokevirtual 328	com/ziroom/ziroomcustomer/widget/SignerInfoView:setTitle	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   493: pop
    //   494: aload_0
    //   495: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   498: bipush 8
    //   500: invokevirtual 308	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:setVisibility	(I)V
    //   503: aload_0
    //   504: getfield 310	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v_divideLine	Landroid/view/View;
    //   507: bipush 8
    //   509: invokevirtual 313	android/view/View:setVisibility	(I)V
    //   512: ldc_w 295
    //   515: aload_0
    //   516: getfield 159	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:g	Ljava/lang/String;
    //   519: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   522: ifeq +43 -> 565
    //   525: aload_0
    //   526: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   529: invokevirtual 544	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:getText	()Ljava/lang/String;
    //   532: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   535: ifeq +55 -> 590
    //   538: aload_0
    //   539: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   542: astore 4
    //   544: aload_0
    //   545: aload 4
    //   547: putfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   550: aload_0
    //   551: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   554: aload_0
    //   555: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   558: invokevirtual 544	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:getText	()Ljava/lang/String;
    //   561: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   564: pop
    //   565: aload_0
    //   566: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   569: iconst_0
    //   570: invokevirtual 329	com/ziroom/ziroomcustomer/widget/SignerInfoView:setVisibility	(I)V
    //   573: aload_0
    //   574: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   577: iconst_0
    //   578: invokevirtual 329	com/ziroom/ziroomcustomer/widget/SignerInfoView:setVisibility	(I)V
    //   581: aload_0
    //   582: ldc -3
    //   584: putfield 159	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:g	Ljava/lang/String;
    //   587: goto -202 -> 385
    //   590: aload_0
    //   591: getfield 305	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:signer_let_schoolName	Lcom/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText;
    //   594: invokevirtual 544	com/ziroom/ziroomcustomer/signed/widget/SignerLabeledEditText:getText	()Ljava/lang/String;
    //   597: astore 4
    //   599: goto -55 -> 544
    //   602: aload_0
    //   603: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   606: aload_0
    //   607: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   610: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   613: pop
    //   614: goto -185 -> 429
    //   617: iload_2
    //   618: sipush 200
    //   621: if_icmpne -553 -> 68
    //   624: aload_3
    //   625: ldc_w 1119
    //   628: iconst_m1
    //   629: invokevirtual 462	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   632: istore_1
    //   633: aload_0
    //   634: aload_3
    //   635: ldc_w 1121
    //   638: invokevirtual 470	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   641: putfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   644: iload_1
    //   645: iconst_2
    //   646: if_icmpne +44 -> 690
    //   649: aload_0
    //   650: aload_0
    //   651: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   654: ldc_w 721
    //   657: invokestatic 1102	com/ziroom/ziroomcustomer/ziroomstation/utils/h:parseObject	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   660: checkcast 721	com/ziroom/ziroomcustomer/signed/a/d
    //   663: putfield 656	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:x	Lcom/ziroom/ziroomcustomer/signed/a/d;
    //   666: aload_0
    //   667: aload_0
    //   668: getfield 656	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:x	Lcom/ziroom/ziroomcustomer/signed/a/d;
    //   671: invokevirtual 1122	com/ziroom/ziroomcustomer/signed/a/d:getName	()Ljava/lang/String;
    //   674: putfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   677: aload_0
    //   678: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   681: aload_0
    //   682: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   685: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   688: pop
    //   689: return
    //   690: aload_0
    //   691: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   694: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   697: ifne -629 -> 68
    //   700: aload_0
    //   701: getfield 449	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerPlace	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   704: aload_0
    //   705: getfield 209	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:v	Ljava/lang/String;
    //   708: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   711: pop
    //   712: return
    //   713: iload_2
    //   714: sipush 200
    //   717: if_icmpne -649 -> 68
    //   720: aload_3
    //   721: ldc_w 1119
    //   724: iconst_m1
    //   725: invokevirtual 462	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   728: istore_1
    //   729: aload_3
    //   730: ldc_w 1124
    //   733: invokevirtual 470	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   736: astore_3
    //   737: iload_1
    //   738: iconst_1
    //   739: if_icmpne +31 -> 770
    //   742: aload_0
    //   743: aload_3
    //   744: putfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   747: aload_0
    //   748: getfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   751: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   754: ifne -686 -> 68
    //   757: aload_0
    //   758: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   761: aload_0
    //   762: getfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   765: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   768: pop
    //   769: return
    //   770: aload_0
    //   771: aload_3
    //   772: ldc_w 724
    //   775: invokestatic 1102	com/ziroom/ziroomcustomer/ziroomstation/utils/h:parseObject	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   778: checkcast 724	com/ziroom/ziroomcustomer/signed/a
    //   781: putfield 662	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:z	Lcom/ziroom/ziroomcustomer/signed/a;
    //   784: aload_0
    //   785: aload_0
    //   786: getfield 662	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:z	Lcom/ziroom/ziroomcustomer/signed/a;
    //   789: invokevirtual 1127	com/ziroom/ziroomcustomer/signed/a:getAddress	()Ljava/lang/String;
    //   792: putfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   795: aload_0
    //   796: getfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   799: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   802: ifne -734 -> 68
    //   805: aload_0
    //   806: getfield 323	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:sif_signerAddress	Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   809: aload_0
    //   810: getfield 214	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:w	Ljava/lang/String;
    //   813: invokevirtual 303	com/ziroom/ziroomcustomer/widget/SignerInfoView:setContent	(Ljava/lang/String;)Lcom/ziroom/ziroomcustomer/widget/SignerInfoView;
    //   816: pop
    //   817: return
    //   818: aload_0
    //   819: bipush 100
    //   821: putfield 189	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:H	I
    //   824: aload_0
    //   825: invokespecial 508	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:e	()V
    //   828: return
    //   829: iconst_m1
    //   830: iload_2
    //   831: if_icmpne -763 -> 68
    //   834: aload_0
    //   835: invokevirtual 1130	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity:uploadPhoto	()V
    //   838: return
    //   839: iconst_m1
    //   840: iload_2
    //   841: if_icmpne -773 -> 68
    //   844: aload_3
    //   845: ldc_w 1132
    //   848: invokevirtual 470	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   851: astore_3
    //   852: aload_3
    //   853: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   856: ifne -788 -> 68
    //   859: new 1134	java/io/File
    //   862: dup
    //   863: aload_3
    //   864: invokespecial 1136	java/io/File:<init>	(Ljava/lang/String;)V
    //   867: astore 4
    //   869: aload 4
    //   871: invokevirtual 1139	java/io/File:isFile	()Z
    //   874: ifeq +111 -> 985
    //   877: aload 4
    //   879: invokevirtual 1142	java/io/File:exists	()Z
    //   882: ifeq +103 -> 985
    //   885: new 1134	java/io/File
    //   888: dup
    //   889: aload_3
    //   890: invokespecial 1136	java/io/File:<init>	(Ljava/lang/String;)V
    //   893: sipush 2048
    //   896: invokestatic 1148	com/ziroom/ziroomcustomer/util/r:zoomImageWithQuality	(Ljava/io/File;I)Ljava/io/File;
    //   899: astore 4
    //   901: aload 4
    //   903: ifnull +32 -> 935
    //   906: aload 4
    //   908: astore_3
    //   909: aload_0
    //   910: aload_0
    //   911: invokestatic 637	com/ziroom/commonlibrary/login/a:getToken	(Landroid/content/Context;)Ljava/lang/String;
    //   914: aload 4
    //   916: new 28	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity$5
    //   919: dup
    //   920: aload_0
    //   921: aload_0
    //   922: new 1150	com/ziroom/ziroomcustomer/e/c/o
    //   925: dup
    //   926: invokespecial 1151	com/ziroom/ziroomcustomer/e/c/o:<init>	()V
    //   929: invokespecial 1152	com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity$5:<init>	(Lcom/ziroom/ziroomcustomer/signed/SignerAptitudeActivity;Landroid/content/Context;Lcom/freelxl/baselibrary/d/f/a;)V
    //   932: invokestatic 1158	com/ziroom/ziroomcustomer/e/j:headSignerImgUpload	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lcom/freelxl/baselibrary/d/c/a;)V
    //   935: aload 4
    //   937: ifnonnull -869 -> 68
    //   940: return
    //   941: astore 5
    //   943: aconst_null
    //   944: astore 4
    //   946: aload 4
    //   948: astore_3
    //   949: aload 5
    //   951: invokevirtual 1161	java/io/FileNotFoundException:printStackTrace	()V
    //   954: aload 4
    //   956: ifnonnull -888 -> 68
    //   959: return
    //   960: aload 4
    //   962: astore_3
    //   963: aload 5
    //   965: invokevirtual 1162	java/io/IOException:printStackTrace	()V
    //   968: aload 4
    //   970: ifnonnull -902 -> 68
    //   973: return
    //   974: astore 4
    //   976: aconst_null
    //   977: astore_3
    //   978: aload_3
    //   979: ifnull -911 -> 68
    //   982: aload 4
    //   984: athrow
    //   985: aload_0
    //   986: ldc_w 1164
    //   989: invokestatic 573	com/freelxl/baselibrary/f/g:textToast	(Landroid/content/Context;Ljava/lang/String;)V
    //   992: return
    //   993: astore 4
    //   995: goto -17 -> 978
    //   998: astore 5
    //   1000: goto -40 -> 960
    //   1003: astore 5
    //   1005: goto -59 -> 946
    //   1008: astore 5
    //   1010: aconst_null
    //   1011: astore 4
    //   1013: goto -53 -> 960
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	this	SignerAptitudeActivity
    //   0	1016	1	paramInt1	int
    //   0	1016	2	paramInt2	int
    //   0	1016	3	paramIntent	Intent
    //   83	886	4	localObject1	Object
    //   974	9	4	localObject2	Object
    //   993	1	4	localObject3	Object
    //   1011	1	4	localObject4	Object
    //   941	23	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   998	1	5	localIOException1	java.io.IOException
    //   1003	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1008	1	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   885	901	941	java/io/FileNotFoundException
    //   885	901	974	finally
    //   909	935	993	finally
    //   949	954	993	finally
    //   963	968	993	finally
    //   909	935	998	java/io/IOException
    //   909	935	1003	java/io/FileNotFoundException
    //   885	901	1008	java/io/IOException
  }
  
  public void onBackPressed()
  {
    if (n())
    {
      o();
      return;
    }
    finish();
  }
  
  @OnClick({2131695948, 2131695950, 2131692457, 2131692460, 2131692456, 2131692468, 2131692470, 2131692463})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131695948: 
    case 2131695950: 
    case 2131692456: 
    case 2131692457: 
    case 2131692460: 
    case 2131692468: 
    case 2131692470: 
    case 2131692463: 
    case 2131697638: 
      label216:
      do
      {
        return;
        onBackPressed();
        return;
        b(2131695950);
        return;
        paramView = new Intent(this, TradeDirectActivity.class);
        if (this.s != null)
        {
          paramView.putExtra("selected", com.alibaba.fastjson.a.toJSONString(this.s));
          if (this.u == -1) {
            break label216;
          }
          if (!s.isEmpty(this.s.getAspects())) {
            paramView.putExtra("selectedDirected", com.alibaba.fastjson.a.toJSONString((p)this.s.getAspects().get(this.u)));
          }
        }
        for (;;)
        {
          startActivityForResult(paramView, 98);
          this.b += 1;
          return;
          if (this.t != null) {
            paramView.putExtra("selectedDirected", com.alibaba.fastjson.a.toJSONString(this.t));
          }
        }
        startActivityForResult(new Intent(this, SignerPlaceActivity.class), 99);
        this.b += 1;
        return;
        startActivityForResult(new Intent(this, AptitudeMapActivity.class), 97);
        this.b += 1;
        return;
        if (this.Q == null)
        {
          com.freelxl.baselibrary.f.g.textToast(this, "服务器异常，正在努力抢修中，请稍后再试!");
          return;
        }
        paramView = new Intent(this, SignerCareerActivity.class);
        paramView.putExtra("careerList", this.Q);
        startActivity(paramView);
        overridePendingTransition(2130968666, 2130968652);
        return;
        b(2131692470);
        return;
        m();
        this.b += 1;
        return;
      } while (this.E == null);
      this.E.dismiss();
      return;
    }
    if ((this.E != null) && (this.E.isShowing())) {
      this.E.dismiss();
    }
    Routers.open(this, "ziroomCustomer://zrCreditModule/home");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903503);
    ButterKnife.bind(this);
    this.G = null;
    k();
    a(getIntent());
    if ((this.I != null) && ("zra".equals(this.I))) {
      ApplicationEx.c.addToZryuSign(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.I != null) && ("zra".equals(this.I))) {
      ApplicationEx.c.removeFromZryuSign(this);
    }
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    this.G = null;
    this.G = ((i)paramIntent.getSerializableExtra("maimai"));
    if (this.G == null) {
      a(paramIntent);
    }
    while (i()) {
      return;
    }
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this).setContent("是否替换为在脉脉的职业信息？").setButtonText("不替换").setSecondButtonText("是").setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SignerAptitudeActivity.m(SignerAptitudeActivity.this);
      }
    }).build().show();
  }
  
  protected void onResume()
  {
    super.onResume();
    l();
    f();
  }
  
  public void selectPhoto()
  {
    startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 1, false, 0, 0), 2);
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.K = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File(localFile, this.K)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    if (ae.isNull(this.K)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(com.ziroom.ziroomcustomer.util.h.a + "/" + this.K);
      Bitmap localBitmap = com.ziroom.ziroomcustomer.util.h.toturn(com.ziroom.ziroomcustomer.util.h.tryGetBitmap(this.K, 1280, 500000), com.ziroom.ziroomcustomer.util.h.readPictureDegree(localFile.getPath()));
      com.ziroom.ziroomcustomer.util.h.saveBitmap(localBitmap, this.K, 100);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    } while (this.K == null);
    com.ziroom.ziroomcustomer.e.j.headSignerImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), localFile, new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
        SignerAptitudeActivity.c(SignerAptitudeActivity.this, (String)paramAnonymouse.get("uuid"));
        SignerAptitudeActivity.this.d(SignerAptitudeActivity.k(SignerAptitudeActivity.this));
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerAptitudeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */