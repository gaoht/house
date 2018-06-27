package com.ziroom.ziroomcustomer.my;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.InvoiceAuthStatusBean;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialBigPicsActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.r;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FriendlyCompetencyApplyActivity
  extends OwnerBaseActivity
{
  private Context a;
  private Unbinder b;
  @BindView(2131690078)
  ImageView btnBack;
  private String d;
  private String e;
  @BindView(2131690647)
  TextView etCompetencyApplyName;
  @BindView(2131690649)
  EditText et_competency_apply_address;
  @BindView(2131690651)
  EditText et_competency_apply_bank_name;
  @BindView(2131690652)
  EditText et_competency_apply_bank_number;
  @BindView(2131690648)
  EditText et_competency_apply_identification_code;
  @BindView(2131690650)
  EditText et_competency_apply_phone;
  private String f;
  private String g;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  private String r;
  private String s;
  @BindView(2131690653)
  SimpleDraweeView sdv_competency_apply_pic1;
  @BindView(2131690654)
  SimpleDraweeView sdv_competency_apply_pic2;
  @BindView(2131690655)
  SimpleDraweeView sdv_competency_apply_pic3;
  @BindView(2131690656)
  SimpleDraweeView sdv_competency_apply_pic4;
  @BindView(2131690620)
  ViewStub stubError;
  private String t;
  @BindView(2131689997)
  TextView tvSubmit;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131690576)
  TextView tv_help;
  @BindView(2131690646)
  TextView tv_invoice_status;
  private int u = -1;
  private String v = "";
  private String w;
  private InvoiceAuthStatusBean x;
  
  private void b()
  {
    this.e = getIntent().getStringExtra("tradeNum");
    this.f = getIntent().getStringExtra("companyName");
    this.x = ((InvoiceAuthStatusBean)getIntent().getParcelableExtra("statusBean"));
  }
  
  private void e()
  {
    String str1 = this.etCompetencyApplyName.getText().toString();
    String str2 = VdsAgent.trackEditTextSilent(this.et_competency_apply_identification_code).toString();
    String str3 = VdsAgent.trackEditTextSilent(this.et_competency_apply_address).toString();
    String str4 = VdsAgent.trackEditTextSilent(this.et_competency_apply_phone).toString();
    String str5 = VdsAgent.trackEditTextSilent(this.et_competency_apply_bank_name).toString();
    String str6 = VdsAgent.trackEditTextSilent(this.et_competency_apply_bank_number).toString();
    if (ae.isNull(str1))
    {
      showToast("公司名称不能为空");
      return;
    }
    if (ae.isNull(str2))
    {
      showToast("纳税人识别号不能为空");
      return;
    }
    if (ae.isNull(str3))
    {
      showToast("注册地址不能为空");
      return;
    }
    if (ae.isNull(str4))
    {
      showToast("注册电话不能为空");
      return;
    }
    if (ae.isNull(str5))
    {
      showToast("开户银行不能为空");
      return;
    }
    if (ae.isNull(str6))
    {
      showToast("银行账户不能为空");
      return;
    }
    if (!isTaxpayerNum(str2))
    {
      showToast("请输入正确的纳税人识别号");
      return;
    }
    j.getCompetencyApply(this, com.ziroom.ziroomcustomer.e.g.buildCompetencyApply(this.d, str1, str4, this.e, str6, str5, str3, str2, this.r, this.s, this.t, this.g), new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        FriendlyCompetencyApplyActivity.this.setResult(-1);
        FriendlyCompetencyApplyActivity.this.finish();
      }
    });
  }
  
  private void f()
  {
    final Dialog localDialog = new Dialog(this, 2131427565);
    View localView = LayoutInflater.from(this).inflate(2130903877, null);
    Object localObject = (TextView)localView.findViewById(2131693932);
    this.v = "";
    switch (this.u)
    {
    default: 
      if (ae.isNull(this.v))
      {
        ((TextView)localObject).setText("上传");
        localView.findViewById(2131693933).setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(FriendlyCompetencyApplyActivity.this, false, 0, true, 400, 400);
          FriendlyCompetencyApplyActivity.this.startActivityForResult(paramAnonymousView, 16);
          localDialog.dismiss();
        }
      });
      localView.findViewById(2131693933).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(FriendlyCompetencyApplyActivity.this, ZzSocialBigPicsActivity.class);
          paramAnonymousView.putExtra("imageUrls", new String[] { FriendlyCompetencyApplyActivity.a(FriendlyCompetencyApplyActivity.this) });
          paramAnonymousView.putExtra("currentImageIndex", 0);
          FriendlyCompetencyApplyActivity.this.startActivity(paramAnonymousView);
          localDialog.dismiss();
        }
      });
      localView.findViewById(2131690169).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localDialog.dismiss();
        }
      });
      localDialog.setContentView(localView);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = getResources().getDisplayMetrics().widthPixels;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localDialog.getWindow().setGravity(80);
      localDialog.getWindow().setWindowAnimations(2131427566);
      localDialog.setCanceledOnTouchOutside(true);
      if ((localDialog instanceof Dialog)) {
        break label278;
      }
      localDialog.show();
      return;
      this.v = this.g;
      break;
      this.v = this.r;
      break;
      this.v = this.s;
      break;
      this.v = this.t;
      break;
      ((TextView)localObject).setText("更换");
      localView.findViewById(2131693933).setVisibility(0);
    }
    label278:
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  public static boolean isTaxpayerNum(String paramString)
  {
    return Pattern.compile("^(?![a-zA-Z]*$)[a-zA-Z0-9]{15}$|^(?![a-zA-Z]*$)[a-zA-Z0-9]{18}$|^(?![a-zA-Z]*$)[a-zA-Z0-9]{20}$").matcher(paramString).matches();
  }
  
  void a()
  {
    showError(this.llContentContainer, this.stubError, "网络故障，");
  }
  
  protected void a(String paramString, int paramInt)
  {
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.a);
    if (paramInt == 1)
    {
      localSimpleDraweeView = this.sdv_competency_apply_pic1;
      this.g = paramString;
    }
    for (;;)
    {
      localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
      return;
      if (paramInt == 2)
      {
        localSimpleDraweeView = this.sdv_competency_apply_pic2;
        this.r = paramString;
      }
      else if (paramInt == 3)
      {
        localSimpleDraweeView = this.sdv_competency_apply_pic3;
        this.s = paramString;
      }
      else if (paramInt == 4)
      {
        localSimpleDraweeView = this.sdv_competency_apply_pic4;
        this.t = paramString;
      }
    }
  }
  
  public void initData()
  {
    if (ApplicationEx.c.getUser() != null) {
      this.d = ApplicationEx.c.getUser().getUid();
    }
    for (;;)
    {
      if (ae.notNull(this.f)) {
        this.etCompetencyApplyName.setText(this.f);
      }
      if (this.x != null) {
        break;
      }
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
    if (!ae.isNull(this.x.getRejectReason()))
    {
      this.tv_invoice_status.setVisibility(0);
      this.tv_invoice_status.setText(this.x.getRejectReason());
    }
    for (;;)
    {
      this.etCompetencyApplyName.setText(this.x.getCompanyName());
      this.et_competency_apply_identification_code.setText(this.x.getTaxIdfa());
      this.et_competency_apply_address.setText(this.x.getAddress());
      this.et_competency_apply_phone.setText(this.x.getPhone());
      this.et_competency_apply_bank_name.setText(this.x.getBank());
      this.et_competency_apply_bank_number.setText(this.x.getBankNum());
      if (!ae.isNull(this.x.getBusinessLicense()))
      {
        this.g = this.x.getBusinessLicense();
        this.sdv_competency_apply_pic1.setController(com.freelxl.baselibrary.f.c.frescoController(this.x.getBusinessLicense()));
      }
      if (!ae.isNull(this.x.getTaxRegNum()))
      {
        this.r = this.x.getTaxRegNum();
        this.sdv_competency_apply_pic2.setController(com.freelxl.baselibrary.f.c.frescoController(this.x.getTaxRegNum()));
      }
      if (!ae.isNull(this.x.getAccountLicense()))
      {
        this.s = this.x.getAccountLicense();
        this.sdv_competency_apply_pic3.setController(com.freelxl.baselibrary.f.c.frescoController(this.x.getAccountLicense()));
      }
      if (ae.isNull(this.x.getOrgCode())) {
        break;
      }
      this.t = this.x.getOrgCode();
      this.sdv_competency_apply_pic4.setController(com.freelxl.baselibrary.f.c.frescoController(this.x.getOrgCode()));
      return;
      this.tv_invoice_status.setVisibility(8);
    }
  }
  
  public void initView() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    if ((paramInt1 == 16) && (paramInt2 == -1) && (paramIntent != null))
    {
      localObject4 = paramIntent.getStringExtra("path");
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        File localFile = new File((String)localObject4);
        localObject3 = null;
        paramIntent = null;
        localObject1 = null;
        if ((!localFile.isFile()) || (!localFile.exists())) {
          break label183;
        }
      }
    }
    try
    {
      localObject4 = r.zoomImageWithQuality(new File((String)localObject4), 2048);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        paramIntent = (Intent)localObject4;
        j.headInvoiceImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), (File)localObject4, new com.ziroom.commonlibrary.a.a(this.a, new com.freelxl.baselibrary.d.f.c())
        {
          public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymouse);
            if ("200".equals(paramAnonymouse.get("code") + ""))
            {
              paramAnonymouse = paramAnonymouse.getJSONObject("data");
              if (paramAnonymouse != null)
              {
                FriendlyCompetencyApplyActivity.a(FriendlyCompetencyApplyActivity.this, (String)paramAnonymouse.get("url"));
                FriendlyCompetencyApplyActivity.this.a(FriendlyCompetencyApplyActivity.b(FriendlyCompetencyApplyActivity.this), FriendlyCompetencyApplyActivity.c(FriendlyCompetencyApplyActivity.this));
              }
            }
            else
            {
              return;
            }
            FriendlyCompetencyApplyActivity.this.showToast("上传失败");
          }
        });
      }
      if (localObject4 == null) {}
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      do
      {
        paramIntent = (Intent)localObject1;
        localFileNotFoundException.printStackTrace();
      } while (localObject1 != null);
      return;
    }
    catch (IOException localIOException)
    {
      do
      {
        paramIntent = localFileNotFoundException;
        localIOException.printStackTrace();
      } while (localFileNotFoundException != null);
      return;
    }
    finally
    {
      while (paramIntent == null) {}
    }
    label183:
    com.freelxl.baselibrary.f.g.textToast(this, "当前图片不存在！");
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  @OnClick({2131689997, 2131690653, 2131690654, 2131690655, 2131690656, 2131690078, 2131690576})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    case 2131690653: 
      this.u = 1;
      f();
      return;
    case 2131690654: 
      this.u = 2;
      f();
      return;
    case 2131690655: 
      this.u = 3;
      f();
      return;
    case 2131690656: 
      this.u = 4;
      f();
      return;
    case 2131689997: 
      e();
      return;
    }
    JsBridgeWebActivity.start(this, "", "http://zhuanti.ziroom.com/zhuanti/2017/zrk/fphelp/index.html");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = this;
    setContentView(2130903182);
    this.b = ButterKnife.bind(this);
    b();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyCompetencyApplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */