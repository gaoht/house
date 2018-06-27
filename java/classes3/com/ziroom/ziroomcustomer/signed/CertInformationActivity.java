package com.ziroom.ziroomcustomer.signed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.CompanyBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.PersonalBean;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.UserType;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.h;
import com.ziroom.ziroomcustomer.util.r;
import com.ziroom.ziroomcustomer.widget.ScanImageActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CertInformationActivity
  extends BaseActivity
{
  private int A = 0;
  private String B;
  private List<String> C;
  private String D;
  private ArrayList<String> E = new ArrayList(3);
  private String[] F;
  private String[] G;
  private int H;
  private int I = 0;
  private int J;
  private String K = "";
  private String L = "";
  private String M = "";
  private String N;
  private List<String> O;
  private com.ziroom.ziroomcustomer.signed.widget.a P;
  private CertInfoEntity Q;
  private HouseDetail R;
  private String S;
  private int T;
  private BroadcastReceiver U = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("code", -1);
      if (i == 0)
      {
        paramAnonymousContext = new Intent(CertInformationActivity.h(CertInformationActivity.this), CertificationInfoActivity.class);
        paramAnonymousContext.putExtra("phone", CertInformationActivity.i(CertInformationActivity.this));
        paramAnonymousContext.putExtra("detail", CertInformationActivity.j(CertInformationActivity.this));
        paramAnonymousContext.putExtra("type", CertInformationActivity.k(CertInformationActivity.this));
        CertInformationActivity.this.startActivity(paramAnonymousContext);
        CertInformationActivity.this.finish();
      }
      do
      {
        return;
        if (i == 1)
        {
          paramAnonymousContext = new Intent(CertInformationActivity.h(CertInformationActivity.this), CertificationInfoActivity.class);
          paramAnonymousContext.putExtra("phone", CertInformationActivity.i(CertInformationActivity.this));
          paramAnonymousContext.putExtra("detail", CertInformationActivity.j(CertInformationActivity.this));
          paramAnonymousContext.putExtra("type", CertInformationActivity.k(CertInformationActivity.this));
          CertInformationActivity.this.startActivity(paramAnonymousContext);
          CertInformationActivity.this.finish();
          return;
        }
      } while (i != -1);
    }
  };
  private com.ziroom.commonlibrary.a.a<e> V = new com.ziroom.commonlibrary.a.a(this.d, new com.freelxl.baselibrary.d.f.c())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      CertInformationActivity.this.cert_information_btn.setEnabled(true);
      dismissProgress();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      CertInformationActivity.this.cert_information_btn.setEnabled(true);
      if ("success".equals(paramAnonymouse.get("status"))) {
        if (CertInformationActivity.a(CertInformationActivity.this).credits.getRealNameStatus() != 4) {
          if (CertInformationActivity.n(CertInformationActivity.this) == 1)
          {
            paramAnonymouse = "ziroomCustomer://zrCreditModule/zmAuthentication?userName=" + VdsAgent.trackEditTextSilent(CertInformationActivity.this.cert_information_personal_name).toString() + "&userPhone=" + CertInformationActivity.i(CertInformationActivity.this) + "&certType=" + CertInformationActivity.b(CertInformationActivity.this) + "&certNum=" + VdsAgent.trackEditTextSilent(CertInformationActivity.this.cert_information_personal_cert_id).toString() + "&cerPositiveUrl=" + CertInformationActivity.o(CertInformationActivity.this) + "&certReverseUrl=" + CertInformationActivity.p(CertInformationActivity.this) + "&certHandhelUrl=" + CertInformationActivity.q(CertInformationActivity.this) + "&userSex=" + CertInformationActivity.c(CertInformationActivity.this) + "&source=1&isEnterprise=0";
            Routers.open(CertInformationActivity.this, paramAnonymouse);
          }
        }
      }
      for (;;)
      {
        dismissProgress();
        return;
        if (CertInformationActivity.n(CertInformationActivity.this) == 2)
        {
          paramAnonymouse = "ziroomCustomer://zrCreditModule/zmAuthentication?userName=" + VdsAgent.trackEditTextSilent(CertInformationActivity.this.cert_information_enterprise_name).toString() + "&userPhone=" + CertInformationActivity.i(CertInformationActivity.this) + "&certType=" + CertInformationActivity.f(CertInformationActivity.this) + "&certNum=" + VdsAgent.trackEditTextSilent(CertInformationActivity.this.cert_information_enterprise_cert_id).toString() + "&cerPositiveUrl=" + CertInformationActivity.r(CertInformationActivity.this) + "&certReverseUrl=" + CertInformationActivity.s(CertInformationActivity.this) + "&certHandhelUrl=" + CertInformationActivity.t(CertInformationActivity.this) + "&userSex=1&source=0&isEnterprise=1";
          Routers.open(CertInformationActivity.this, paramAnonymouse);
          continue;
          paramAnonymouse = new Intent(CertInformationActivity.h(CertInformationActivity.this), CertificationInfoActivity.class);
          paramAnonymouse.putExtra("phone", CertInformationActivity.i(CertInformationActivity.this));
          paramAnonymouse.putExtra("detail", CertInformationActivity.j(CertInformationActivity.this));
          paramAnonymouse.putExtra("type", CertInformationActivity.k(CertInformationActivity.this));
          CertInformationActivity.this.startActivity(paramAnonymouse);
          CertInformationActivity.this.finish();
          continue;
          CertInformationActivity.this.showToast(paramAnonymouse.get("error_message").toString());
        }
      }
    }
  };
  private View.OnClickListener W = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      CertInformationActivity.u(CertInformationActivity.this).dismiss();
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131692507: 
        CertInformationActivity.this.takePhoto();
        return;
      }
      CertInformationActivity.this.selectPhoto();
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
          CertInformationActivity.this.cert_information_personal_sex.setText(paramAnonymousString);
          if ("男".equals(paramAnonymousString))
          {
            CertInformationActivity.a(CertInformationActivity.this, 1);
            return;
          }
        } while (!"女".equals(paramAnonymousString));
        CertInformationActivity.a(CertInformationActivity.this, 2);
        return;
      case 1: 
        CertInformationActivity.this.cert_information_personal_cert_type.setText(paramAnonymousString);
        if (ae.notNull(((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getRemarks()))
        {
          CertInformationActivity.this.cert_information_personal_cert_type_hint.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getRemarks());
          if (CertInformationActivity.b(CertInformationActivity.this) != ((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getCert_type())
          {
            CertInformationActivity.a(CertInformationActivity.this, 0);
            CertInformationActivity.this.cert_information_personal_sex.setText(CertInformationActivity.b(CertInformationActivity.this, CertInformationActivity.c(CertInformationActivity.this)));
            CertInformationActivity.this.cert_information_personal_cert_id.setText("");
            CertInformationActivity.a(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getDefault_pic());
          }
          CertInformationActivity.c(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getCert_type());
          if (CertInformationActivity.b(CertInformationActivity.this) != 1) {
            break label490;
          }
          CertInformationActivity.this.cert_information_personal_cert_id.setCursorVisible(false);
          CertInformationActivity.this.cert_information_personal_sex_ll.setVisibility(8);
          CertInformationActivity.this.cert_information_personal_image_ll.setVisibility(8);
          if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getTips())) {
            break label546;
          }
          CertInformationActivity.this.cert_information_personal_tv.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getTips());
        }
        for (;;)
        {
          CertInformationActivity.a(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.PersonalBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getStandards());
          if (!ae.isNull(CertInformationActivity.e(CertInformationActivity.this))) {
            break label561;
          }
          CertInformationActivity.this.cert_information_personal_audit.setVisibility(8);
          return;
          CertInformationActivity.this.cert_information_personal_cert_type_hint.setText("");
          break;
          if (CertInformationActivity.d(CertInformationActivity.this) != null) {
            CertInformationActivity.d(CertInformationActivity.this).hideKeyboard();
          }
          CertInformationActivity.this.cert_information_personal_cert_id.setCursorVisible(true);
          CertInformationActivity.this.cert_information_personal_sex_ll.setVisibility(0);
          CertInformationActivity.this.cert_information_personal_image_ll.setVisibility(0);
          break label350;
          CertInformationActivity.this.cert_information_personal_tv.setText("");
        }
        CertInformationActivity.this.cert_information_personal_audit.setVisibility(0);
        return;
      case 2: 
        label350:
        label490:
        label546:
        label561:
        if (CertInformationActivity.f(CertInformationActivity.this) != ((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getCert_type())
        {
          CertInformationActivity.this.cert_information_enterprise_cert_id.setText("");
          CertInformationActivity.b(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getDefault_pic());
        }
        CertInformationActivity.d(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getCert_type());
        CertInformationActivity.e(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getCompany_type());
        CertInformationActivity.this.cert_information_enterprise_image_ll.setVisibility(0);
        if (ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getCert_name())) {
          CertInformationActivity.this.cert_information_enterprise_cert_id_name.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getCert_name() + "号码（将加密处理）");
        }
        if (ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getTips()))
        {
          CertInformationActivity.this.cert_information_enterpiese_tv.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getTips());
          CertInformationActivity.b(CertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getStandards());
          CertInformationActivity.this.cert_information_enterprise_cert_type.setText(paramAnonymousString);
          if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getRemarks())) {
            break label1030;
          }
          CertInformationActivity.this.cert_information_enterprise_cert_type_hint.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany().get(paramAnonymousInt1)).getRemarks());
        }
        for (;;)
        {
          if (!ae.isNull(CertInformationActivity.g(CertInformationActivity.this))) {
            break label1045;
          }
          CertInformationActivity.this.cert_information_enterprise_audit.setVisibility(8);
          return;
          CertInformationActivity.this.cert_information_enterpiese_tv.setText("");
          break;
          label1030:
          CertInformationActivity.this.cert_information_enterprise_cert_type_hint.setText("");
        }
        label1045:
        CertInformationActivity.this.cert_information_enterprise_audit.setVisibility(0);
        return;
      }
      CertInformationActivity.a(CertInformationActivity.this, (CertInfoEntity.NewsignCertListBean.UserType)CertInformationActivity.a(CertInformationActivity.this).getNewsign_cert_list().getCompany_sign_type().get(paramAnonymousInt1));
    }
  };
  TextLineView.a b = new TextLineView.a()
  {
    public void onCheckShow(View paramAnonymousView)
    {
      switch (paramAnonymousView.getId())
      {
      case 2131690114: 
      case 2131690115: 
      case 2131690116: 
      default: 
        return;
      case 2131690117: 
        CertInformationActivity.this.personal_ll.setVisibility(0);
        CertInformationActivity.f(CertInformationActivity.this, 1);
        CertInformationActivity.this.enterprise_ll.setVisibility(8);
        return;
      case 2131690118: 
        CertInformationActivity.f(CertInformationActivity.this, 2);
        CertInformationActivity.this.personal_ll.setVisibility(8);
        CertInformationActivity.this.enterprise_ll.setVisibility(0);
        return;
      case 2131690112: 
        CertInformationActivity.f(CertInformationActivity.this, 1);
        CertInformationActivity.this.personal_ll.setVisibility(0);
        CertInformationActivity.this.enterprise_ll.setVisibility(8);
        return;
      }
      CertInformationActivity.f(CertInformationActivity.this, 2);
      CertInformationActivity.this.personal_ll.setVisibility(8);
      CertInformationActivity.this.enterprise_ll.setVisibility(0);
    }
  };
  @BindView(2131690105)
  ImageView btn_menu;
  private Unbinder c;
  @BindView(2131690121)
  TextView cert_information_btn;
  @BindView(2131694544)
  SimpleDraweeView cert_information_enterpiese_image1;
  @BindView(2131694545)
  SimpleDraweeView cert_information_enterpiese_image2;
  @BindView(2131694546)
  SimpleDraweeView cert_information_enterpiese_image3;
  @BindView(2131694547)
  TextView cert_information_enterpiese_tv;
  @BindView(2131694543)
  LinearLayout cert_information_enterprise_audit;
  @BindView(2131694542)
  EditText cert_information_enterprise_cert_id;
  @BindView(2131694541)
  TextView cert_information_enterprise_cert_id_name;
  @BindView(2131694539)
  TextView cert_information_enterprise_cert_type;
  @BindView(2131694538)
  TextView cert_information_enterprise_cert_type_hint;
  @BindView(2131694540)
  LinearLayout cert_information_enterprise_image_ll;
  @BindView(2131694536)
  EditText cert_information_enterprise_name;
  @BindView(2131694537)
  TextView cert_information_enterprise_user_type;
  @BindView(2131690116)
  LinearLayout cert_information_ll;
  @BindView(2131693017)
  LinearLayout cert_information_personal_audit;
  @BindView(2131693010)
  EditText cert_information_personal_cert_id;
  @BindView(2131693012)
  View cert_information_personal_cert_id_line;
  @BindView(2131693009)
  TextView cert_information_personal_cert_type;
  @BindView(2131694743)
  TextView cert_information_personal_cert_type_hint;
  @BindView(2131693018)
  SimpleDraweeView cert_information_personal_image1;
  @BindView(2131693019)
  SimpleDraweeView cert_information_personal_image2;
  @BindView(2131693020)
  SimpleDraweeView cert_information_personal_image3;
  @BindView(2131693016)
  LinearLayout cert_information_personal_image_ll;
  @BindView(2131693006)
  EditText cert_information_personal_name;
  @BindView(2131693015)
  TextView cert_information_personal_sex;
  @BindView(2131693013)
  LinearLayout cert_information_personal_sex_ll;
  @BindView(2131693021)
  TextView cert_information_personal_tv;
  @BindView(2131690115)
  LinearLayout cert_information_title_ll;
  @BindView(2131690111)
  RelativeLayout cert_information_title_tab_ll;
  @BindView(2131690109)
  TextView cert_title_tv;
  private Context d;
  private int e = 0;
  @BindView(2131690120)
  View enterprise_ll;
  @BindView(2131690118)
  TextLineView enterprise_tab;
  @BindView(2131690113)
  TextLineView enterprise_title_tab;
  private k f;
  private String g;
  @BindView(2131690124)
  KeyboardView keyboard_view;
  @BindView(2131690114)
  PayTermsScrollView pay_terms_scroll;
  @BindView(2131690119)
  View personal_ll;
  @BindView(2131690117)
  TextLineView personal_tab;
  @BindView(2131690112)
  TextLineView personal_title_tab;
  private String r = "";
  private String s = "";
  private String t = "";
  private String u;
  private int v = -1;
  private ArrayList<String> w = new ArrayList(3);
  private String[] x;
  private String[] y;
  private int z = 0;
  
  private CertInfoEntity.NewsignCertListBean.UserType a(int paramInt, List<CertInfoEntity.NewsignCertListBean.UserType> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CertInfoEntity.NewsignCertListBean.UserType localUserType = (CertInfoEntity.NewsignCertListBean.UserType)paramList.next();
      if (paramInt == localUserType.getSign_user_type()) {
        return localUserType;
      }
    }
    return null;
  }
  
  private void a()
  {
    int i = this.cert_information_enterpiese_image3.getLayoutParams().width;
    this.cert_information_enterpiese_image3.getLayoutParams().height = ((int)(i * 1.3D));
    this.cert_information_enterpiese_image2.getLayoutParams().height = ((int)(i * 1.3D));
    this.cert_information_enterpiese_image1.getLayoutParams().height = ((int)(i * 1.3D));
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
  
  private void a(CertInfoEntity.NewsignCertListBean.UserType paramUserType)
  {
    if (paramUserType == null) {
      return;
    }
    this.I = paramUserType.getSign_user_type();
    this.cert_information_enterprise_user_type.setText(paramUserType.getName());
    if (paramUserType.getPic_count() == 3)
    {
      this.cert_information_enterpiese_image3.setVisibility(0);
      return;
    }
    this.cert_information_enterpiese_image3.setVisibility(4);
  }
  
  private void a(String paramString, SimpleDraweeView paramSimpleDraweeView)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("uuid", paramString + "");
    paramString = com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap);
    paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(b(q.O + e.d.d, paramString)));
  }
  
  private void a(final String paramString1, final String paramString2, final int paramInt1, final String paramString3, final String paramString4, final String paramString5, final String paramString6, final String paramString7, final String paramString8, final String paramString9, final int paramInt2, final int paramInt3, final String paramString10, final int paramInt4)
  {
    d.newBuilder(this).setContent("请您认真核对以确保信息无误，您确认要提交吗？").setTitle("提交信息").setButtonText("取消", "确认").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView)
      {
        CertInformationActivity.this.cert_information_btn.setEnabled(true);
      }
      
      public void onRightClick(View paramAnonymousView)
      {
        j.putCertInfo(CertInformationActivity.h(CertInformationActivity.this), paramString1, paramString2, paramInt1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramInt3, CertInformationActivity.l(CertInformationActivity.this), paramString10, paramInt4, CertInformationActivity.m(CertInformationActivity.this));
      }
    }).show();
  }
  
  private void a(List<String> paramList)
  {
    this.C = paramList;
    if (paramList == null) {}
    do
    {
      do
      {
        return;
      } while (paramList.size() < 3);
      if (ae.isNull(this.r)) {
        this.cert_information_personal_image1.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(0)));
      }
      if (ae.isNull(this.s)) {
        this.cert_information_personal_image2.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(1)));
      }
    } while (!ae.isNull(this.t));
    this.cert_information_personal_image3.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(2)));
  }
  
  private void b()
  {
    if (this.T == 0) {
      this.S = "0";
    }
    while ((this.Q != null) && (this.Q.getNewsign_cert_list() != null))
    {
      int j;
      int i;
      if (this.Q.getNewsign_cert_list().getCompany() != null)
      {
        j = this.Q.getNewsign_cert_list().getCompany().size();
        this.F = new String[j];
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            this.F[i] = ((CertInfoEntity.NewsignCertListBean.CompanyBean)this.Q.getNewsign_cert_list().getCompany().get(i)).getType();
            i += 1;
            continue;
            this.S = "1";
            break;
          }
        }
      }
      if (this.Q.getNewsign_cert_list().getCompany_sign_type() != null)
      {
        j = this.Q.getNewsign_cert_list().getCompany_sign_type().size();
        this.G = new String[j];
        i = 0;
        while (i < j)
        {
          this.G[i] = ((CertInfoEntity.NewsignCertListBean.UserType)this.Q.getNewsign_cert_list().getCompany_sign_type().get(i)).getName();
          i += 1;
        }
      }
      if (this.Q.getNewsign_cert_list().getPersonal() != null)
      {
        j = this.Q.getNewsign_cert_list().getPersonal().size();
        this.x = new String[j];
        i = 0;
        while (i < j)
        {
          this.x[i] = ((CertInfoEntity.NewsignCertListBean.PersonalBean)this.Q.getNewsign_cert_list().getPersonal().get(i)).getCert_name();
          i += 1;
        }
      }
    }
    this.y = new String[2];
    this.y[0] = "男";
    this.y[1] = "女";
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent(this, ScanImageActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.K)) {
      localArrayList.add(this.K);
    }
    if (ae.notNull(this.L)) {
      localArrayList.add(this.L);
    }
    if (ae.notNull(this.M)) {
      localArrayList.add(this.M);
    }
    int i = paramInt;
    if (localArrayList.size() == 2)
    {
      if (paramInt != 2) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("tag", "CertInformationActivity");
      localIntent.putExtra("position", i);
      localIntent.putExtra("photos", localArrayList);
      startActivityForResult(localIntent, 3);
      return;
      label136:
      i = paramInt;
      if (ae.isNull(this.r))
      {
        i = paramInt;
        if (paramInt == 1) {
          i = 0;
        }
      }
    }
  }
  
  private void b(List<String> paramList)
  {
    this.O = paramList;
    if (paramList == null) {}
    do
    {
      do
      {
        return;
      } while (paramList.size() < 3);
      if (ae.isNull(this.K)) {
        this.cert_information_enterpiese_image1.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(0)));
      }
      if (ae.isNull(this.L)) {
        this.cert_information_enterpiese_image2.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(1)));
      }
    } while (!ae.isNull(this.M));
    this.cert_information_enterpiese_image3.setController(com.freelxl.baselibrary.f.c.frescoController((String)paramList.get(2)));
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent(this, ScanImageActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.r)) {
      localArrayList.add(this.r);
    }
    if (ae.notNull(this.s)) {
      localArrayList.add(this.s);
    }
    if (ae.notNull(this.t)) {
      localArrayList.add(this.t);
    }
    int i = paramInt;
    if (localArrayList.size() == 2)
    {
      if (paramInt != 2) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      localIntent.putExtra("tag", "CertInformationActivity");
      localIntent.putExtra("position", i);
      localIntent.putExtra("photos", localArrayList);
      startActivityForResult(localIntent, 3);
      return;
      label136:
      i = paramInt;
      if (ae.isNull(this.r))
      {
        i = paramInt;
        if (paramInt == 1) {
          i = 0;
        }
      }
    }
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    char[] arrayOfChar = new char[12];
    char[] tmp11_9 = arrayOfChar;
    tmp11_9[0] = 49;
    char[] tmp17_11 = tmp11_9;
    tmp17_11[1] = 50;
    char[] tmp23_17 = tmp17_11;
    tmp23_17[2] = 51;
    char[] tmp29_23 = tmp23_17;
    tmp29_23[3] = 52;
    char[] tmp35_29 = tmp29_23;
    tmp35_29[4] = 53;
    char[] tmp41_35 = tmp35_29;
    tmp41_35[5] = 54;
    char[] tmp47_41 = tmp41_35;
    tmp47_41[6] = 55;
    char[] tmp54_47 = tmp47_41;
    tmp54_47[7] = 56;
    char[] tmp61_54 = tmp54_47;
    tmp61_54[8] = 57;
    char[] tmp68_61 = tmp61_54;
    tmp68_61[9] = 48;
    char[] tmp75_68 = tmp68_61;
    tmp75_68[10] = 120;
    char[] tmp82_75 = tmp75_68;
    tmp82_75[11] = 88;
    tmp82_75;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < arrayOfChar.length)
      {
        if (arrayOfChar[i] == paramString.charAt(paramString.length() - 1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void e()
  {
    registerReceiver(this.U, new IntentFilter("com.ziroom.ziroomcustomer.zmcertresult"));
    int i = 0;
    while (i < 3)
    {
      this.w.add("");
      this.E.add("");
      i += 1;
    }
    this.pay_terms_scroll.setScrollViewListener(new PayTermsScrollView.a()
    {
      public void onScrollChanged(PayTermsScrollView paramAnonymousPayTermsScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousInt2 >= CertInformationActivity.this.cert_information_title_ll.getHeight())
        {
          CertInformationActivity.this.cert_information_ll.setVisibility(8);
          CertInformationActivity.this.cert_information_title_tab_ll.setVisibility(0);
          CertInformationActivity.this.cert_title_tv.setVisibility(8);
          return;
        }
        CertInformationActivity.this.cert_information_ll.setVisibility(0);
        CertInformationActivity.this.cert_information_title_tab_ll.setVisibility(8);
        CertInformationActivity.this.cert_title_tv.setVisibility(8);
      }
    });
    this.personal_tab.setOnCheckShowListener(this.b);
    this.personal_title_tab.setOnCheckShowListener(this.b);
    this.enterprise_title_tab.setOnCheckShowListener(this.b);
    this.enterprise_tab.setOnCheckShowListener(this.b);
    if (this.Q == null) {}
    for (;;)
    {
      return;
      try
      {
        this.e = Integer.parseInt(this.Q.user_type);
        label283:
        Object localObject2;
        if (this.e == 2)
        {
          this.personal_ll.setVisibility(8);
          this.enterprise_ll.setVisibility(0);
          this.personal_tab.setShow(false, false);
          this.personal_title_tab.setShow(false, false);
          this.enterprise_tab.setShow(true, false);
          this.enterprise_title_tab.setShow(true, false);
          this.cert_information_enterprise_name.setText(this.Q.real_name);
          if (ae.notNull(this.Q.company_type))
          {
            localObject1 = this.Q.company_type;
            this.J = new Integer((String)localObject1).intValue();
            if (this.J != 0) {
              this.cert_information_enterprise_image_ll.setVisibility(0);
            }
            if (this.J == 0) {
              break label405;
            }
            localObject1 = this.Q.getNewsign_cert_list().getCompany().iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (CertInfoEntity.NewsignCertListBean.CompanyBean)((Iterator)localObject1).next();
            } while (((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getCompany_type() != this.J);
            if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getTips())) {
              break label381;
            }
            this.cert_information_enterpiese_tv.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getTips());
            label334:
            if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getRemarks())) {
              break label393;
            }
            this.cert_information_enterprise_cert_type_hint.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getRemarks());
          }
          for (;;)
          {
            this.O = ((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject2).getDefault_pic();
            b(this.O);
            break label283;
            localObject1 = "0";
            break;
            label381:
            this.cert_information_enterpiese_tv.setText("");
            break label334;
            label393:
            this.cert_information_enterprise_cert_type_hint.setText("");
          }
          label405:
          this.cert_information_enterprise_cert_id.setText(this.Q.cert_num);
          this.K = this.Q.getUser_cert1();
          this.L = this.Q.getUser_cert2();
          this.M = this.Q.getUser_cert3();
          this.E.set(0, this.Q.getUser_cert1());
          this.E.set(1, this.Q.getUser_cert2());
          this.E.set(2, this.Q.getUser_cert3());
          a(this.Q.getUser_cert1(), this.cert_information_enterpiese_image1);
          a(this.Q.getUser_cert2(), this.cert_information_enterpiese_image2);
          a(this.Q.getUser_cert3(), this.cert_information_enterpiese_image3);
          if (b(this.J + "", this.Q.newsign_cert_list.company) != null)
          {
            this.H = b(this.J + "", this.Q.newsign_cert_list.company).cert_type;
            localObject1 = b(this.J + "", this.Q.newsign_cert_list.company);
            if (localObject1 == null) {
              continue;
            }
            if (ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject1).getCert_name())) {
              this.cert_information_enterprise_cert_id_name.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject1).getCert_name() + "号码（将加密处理）");
            }
            this.N = ((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject1).getStandards();
            this.cert_information_enterprise_cert_type.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject1).getType());
            if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject1).getTips())) {
              break label782;
            }
            this.cert_information_enterpiese_tv.setText(((CertInfoEntity.NewsignCertListBean.CompanyBean)localObject1).getTips());
          }
          for (;;)
          {
            this.I = this.Q.getSign_user_type();
            a(a(this.I, this.Q.getNewsign_cert_list().getCompany_sign_type()));
            return;
            label782:
            this.cert_information_enterpiese_tv.setText("");
          }
        }
        this.e = 1;
        this.personal_ll.setVisibility(0);
        this.enterprise_ll.setVisibility(8);
        this.personal_tab.setShow(true, false);
        this.personal_title_tab.setShow(true, false);
        this.enterprise_tab.setShow(false, false);
        this.enterprise_title_tab.setShow(false, false);
        this.cert_information_personal_name.setText(this.Q.real_name);
        this.A = this.Q.gender;
        this.cert_information_personal_sex.setText(a(this.A));
        if (ae.notNull(this.Q.cert_type))
        {
          localObject1 = this.Q.cert_type;
          this.z = new Integer((String)localObject1).intValue();
          if (this.z != 1) {
            break label1075;
          }
          this.cert_information_personal_sex_ll.setVisibility(8);
          this.cert_information_personal_image_ll.setVisibility(8);
          label954:
          if (this.z == 0) {
            break label1118;
          }
          localObject1 = this.Q.getNewsign_cert_list().getPersonal().iterator();
          label977:
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (CertInfoEntity.NewsignCertListBean.PersonalBean)((Iterator)localObject1).next();
          } while (((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject2).getCert_type() != this.z);
          if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject2).getTips())) {
            break label1094;
          }
          this.cert_information_personal_tv.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject2).getTips());
          label1028:
          if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject2).getRemarks())) {
            break label1106;
          }
          this.cert_information_personal_cert_type_hint.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject2).getRemarks());
        }
        for (;;)
        {
          this.C = ((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject2).getDefault_pic();
          a(this.C);
          break label977;
          localObject1 = "0";
          break;
          label1075:
          this.cert_information_personal_sex_ll.setVisibility(0);
          this.cert_information_personal_image_ll.setVisibility(0);
          break label954;
          label1094:
          this.cert_information_personal_tv.setText("");
          break label1028;
          label1106:
          this.cert_information_personal_cert_type_hint.setText("");
        }
        label1118:
        this.cert_information_personal_cert_id.setText(this.Q.cert_num);
        this.r = this.Q.getUser_cert1();
        this.s = this.Q.getUser_cert2();
        this.t = this.Q.getUser_cert3();
        this.w.set(0, this.Q.getUser_cert1());
        this.w.set(1, this.Q.getUser_cert2());
        this.w.set(2, this.Q.getUser_cert3());
        a(this.Q.getUser_cert1(), this.cert_information_personal_image1);
        a(this.Q.getUser_cert2(), this.cert_information_personal_image2);
        a(this.Q.getUser_cert3(), this.cert_information_personal_image3);
        Object localObject1 = a(this.z + "", this.Q.getNewsign_cert_list().personal);
        if (localObject1 == null) {
          continue;
        }
        this.B = ((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject1).getStandards();
        this.cert_information_personal_cert_type.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject1).getCert_name());
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private void f()
  {
    this.cert_information_personal_name.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.cert_information_enterprise_name.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.cert_information_personal_cert_id.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.cert_information_enterprise_cert_id.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.cert_information_personal_cert_id.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (CertInformationActivity.b(CertInformationActivity.this) == 1)
        {
          CertInformationActivity.this.cert_information_personal_cert_id.setCursorVisible(false);
          CertInformationActivity.a(CertInformationActivity.this, new com.ziroom.ziroomcustomer.signed.widget.a(CertInformationActivity.this, CertInformationActivity.h(CertInformationActivity.this), CertInformationActivity.this.cert_information_personal_cert_id));
          CertInformationActivity.d(CertInformationActivity.this).showKeyboard();
          CertInformationActivity.this.pay_terms_scroll.fullScroll(130);
          return true;
        }
        CertInformationActivity.this.cert_information_personal_cert_id.setCursorVisible(true);
        return false;
      }
    });
  }
  
  private String g()
  {
    if (this.e == 1)
    {
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim().replace("\n", " "))) {
        return "请填写姓名";
      }
      if ((this.A == 0) && (this.z != 1)) {
        return "请选择性别";
      }
      if (this.z == 0) {
        return "请选择证件类型";
      }
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString())) {
        return "请填写证件号";
      }
      if (this.z != 1)
      {
        if (ae.isNull(this.r)) {
          return "请按要求上传证件照";
        }
        if (ae.isNull(this.s)) {
          return "请按要求上传证件照";
        }
        if (ae.isNull(this.t)) {
          return "请按要求上传证件照";
        }
      }
      else
      {
        if ((VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().length() != 18) && (VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().length() != 15)) {
          return "请输入正确的身份证号哦～";
        }
        if (!d(VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString())) {
          return "请输入正确的身份证号哦～";
        }
        if (VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().length() != 18) {
          break label289;
        }
        if (Integer.valueOf(VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().charAt(16)).intValue() % 2 == 0) {
          break label281;
        }
        this.A = 1;
      }
      for (;;)
      {
        this.cert_information_personal_sex.setText(a(this.A));
        this.cert_information_btn.setBackgroundColor(Color.parseColor("#ffa000"));
        return "";
        label281:
        this.A = 2;
        continue;
        label289:
        if (VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().length() == 15) {
          if (Integer.valueOf(VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().charAt(14)).intValue() % 2 != 0) {
            this.A = 1;
          } else {
            this.A = 2;
          }
        }
      }
    }
    if (this.e == 2)
    {
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.cert_information_enterprise_name).toString().trim().replace("\n", " "))) {
        return "请填写企业名称";
      }
      if (this.J == 0) {
        return "请选择企业性质";
      }
      if (this.I == 0) {
        return "请选择签约人类型";
      }
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.cert_information_enterprise_cert_id).toString())) {
        return "请填写证件号码";
      }
      ArrayList localArrayList = new ArrayList();
      if (ae.notNull(this.K)) {
        localArrayList.add(this.K);
      }
      if (ae.notNull(this.L)) {
        localArrayList.add(this.L);
      }
      if (ae.notNull(this.M)) {
        localArrayList.add(this.M);
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.E.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (ae.notNull(str)) {
          localArrayList.add(str);
        }
      }
      if (localArrayList.size() < 2) {
        return "请按要求上传证件照";
      }
      this.cert_information_btn.setBackgroundColor(Color.parseColor("#ffa000"));
      return "";
    }
    return "非法类型";
  }
  
  private void h()
  {
    if (ae.isNull(g()))
    {
      String str = null;
      if (this.R != null) {
        str = this.R.getHouse_type();
      }
      if (this.e == 1) {
        if ((VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim().replace("\n", " ").length() >= 2) && (VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim().replace("\n", " ").length() <= 42))
        {
          this.cert_information_btn.setEnabled(false);
          a(com.ziroom.commonlibrary.login.a.getToken(this.d), this.Q.getCert_id(), this.z, VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString(), this.r, this.s, this.t, VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim(), this.A + "", this.D, 1, 0, str, this.I);
        }
      }
      while (this.e != 2)
      {
        return;
        showToast("姓名应为2-42个字符");
        return;
      }
      if ((VdsAgent.trackEditTextSilent(this.cert_information_enterprise_name).toString().trim().replace("\n", " ").length() >= 4) && (VdsAgent.trackEditTextSilent(this.cert_information_enterprise_name).toString().trim().replace("\n", " ").length() <= 42))
      {
        this.cert_information_btn.setEnabled(false);
        a(com.ziroom.commonlibrary.login.a.getToken(this.d), this.Q.getCert_id(), this.H, VdsAgent.trackEditTextSilent(this.cert_information_enterprise_cert_id).toString(), this.K, this.L, this.M, VdsAgent.trackEditTextSilent(this.cert_information_enterprise_name).toString().trim(), "", this.D, 2, this.J, str, this.I);
        return;
      }
      showToast("企业名称应为4-42个字符");
      return;
    }
    showToast(g());
  }
  
  private void i()
  {
    this.f = new k(this, this.W);
    k localk = this.f;
    View localView = findViewById(2131690107);
    if (!(localk instanceof PopupWindow))
    {
      localk.showAtLocation(localView, 81, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localk, localView, 81, 0, 0);
  }
  
  protected void a(String paramString, int paramInt)
  {
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.d);
    if (paramInt == 1)
    {
      localSimpleDraweeView = this.cert_information_personal_image1;
      this.r = paramString;
      this.w.set(0, paramString);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("uuid", paramString + "");
      paramString = com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap);
      localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(b(q.O + e.d.d, paramString)));
      return;
      if (paramInt == 2)
      {
        localSimpleDraweeView = this.cert_information_personal_image2;
        this.s = paramString;
        this.w.set(1, paramString);
      }
      else if (paramInt == 3)
      {
        localSimpleDraweeView = this.cert_information_personal_image3;
        this.t = paramString;
        this.w.set(2, paramString);
      }
      else if (paramInt == 4)
      {
        localSimpleDraweeView = this.cert_information_enterpiese_image1;
        this.K = paramString;
        this.E.set(0, paramString);
      }
      else if (paramInt == 5)
      {
        localSimpleDraweeView = this.cert_information_enterpiese_image2;
        this.L = paramString;
        this.E.set(1, paramString);
      }
      else if (paramInt == 6)
      {
        localSimpleDraweeView = this.cert_information_enterpiese_image3;
        this.M = paramString;
        this.E.set(2, paramString);
      }
    }
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("requestCode", paramInt1);
    ((Bundle)localObject1).putInt("resultCode", paramInt2);
    Routers.open(this, "ziroomCustomer://zrCreditModule/zmAuthenticationResult?requestCode=" + paramInt1 + "&resultCode=" + paramInt2);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      uploadPhoto();
    }
    label526:
    for (;;)
    {
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1) && (paramIntent != null))
      {
        Object localObject4 = paramIntent.getStringExtra("path");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          File localFile = new File((String)localObject4);
          Object localObject3 = null;
          paramIntent = null;
          localObject1 = null;
          if ((localFile.isFile()) && (localFile.exists()))
          {
            try
            {
              localObject4 = r.zoomImageWithQuality(new File((String)localObject4), 2048);
              if (localObject4 != null)
              {
                localObject1 = localObject4;
                localObject3 = localObject4;
                paramIntent = (Intent)localObject4;
                j.headSignerImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), (File)localObject4, new f(this, new o())
                {
                  public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
                  {
                    super.onSuccess(paramAnonymousInt, paramAnonymouse);
                    paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
                    CertInformationActivity.c(CertInformationActivity.this, (String)paramAnonymouse.get("uuid"));
                    CertInformationActivity.this.a(CertInformationActivity.v(CertInformationActivity.this), CertInformationActivity.w(CertInformationActivity.this));
                  }
                });
              }
              if (localObject4 != null) {
                continue;
              }
              return;
            }
            catch (FileNotFoundException localFileNotFoundException)
            {
              localFileNotFoundException = localFileNotFoundException;
              paramIntent = (Intent)localObject1;
              localFileNotFoundException.printStackTrace();
              if (localObject1 != null) {
                continue;
              }
              return;
            }
            catch (IOException localIOException)
            {
              localIOException = localIOException;
              paramIntent = localFileNotFoundException;
              localIOException.printStackTrace();
              if (localFileNotFoundException != null) {
                continue;
              }
              return;
            }
            finally {}
            if (paramIntent != null) {
              throw ((Throwable)localObject2);
            }
          }
          else
          {
            com.freelxl.baselibrary.f.g.textToast(this, "当前图片不存在！");
          }
        }
      }
      else if ((paramInt1 == 3) && (paramIntent != null))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("pics");
        if (paramIntent != null)
        {
          paramIntent = paramIntent.iterator();
          for (;;)
          {
            if (!paramIntent.hasNext()) {
              break label526;
            }
            String str = (String)paramIntent.next();
            if (str == null) {
              break;
            }
            if (str.equals(this.r))
            {
              this.r = "";
              this.cert_information_personal_image1.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.s))
            {
              this.s = "";
              this.cert_information_personal_image2.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.t))
            {
              this.t = "";
              this.cert_information_personal_image3.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.K))
            {
              this.K = "";
              this.cert_information_enterpiese_image1.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.L))
            {
              this.L = "";
              this.cert_information_enterpiese_image2.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.M))
            {
              this.M = "";
              this.cert_information_enterpiese_image3.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (this.e == 2) {
              b(this.O);
            } else {
              a(this.C);
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.P != null) && (this.keyboard_view.getVisibility() == 0))
    {
      this.pay_terms_scroll.fullScroll(33);
      this.cert_information_title_tab_ll.setVisibility(8);
      this.P.hideKeyboard();
      return;
    }
    super.onBackPressed();
  }
  
  @OnClick({2131690105, 2131690117, 2131690118, 2131690112, 2131690113, 2131693018, 2131693019, 2131693020, 2131693009, 2131693015, 2131694539, 2131694544, 2131694545, 2131694546, 2131690121, 2131690110, 2131694543, 2131693017, 2131690123, 2131694537})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131690123: 
      do
      {
        return;
        this.pay_terms_scroll.fullScroll(33);
        this.cert_information_title_tab_ll.setVisibility(8);
      } while (this.P == null);
      this.P.hideKeyboard();
      return;
    case 2131694543: 
      if (ae.isNull(this.N))
      {
        showToast("审核标准为空");
        return;
      }
      paramView = new Intent(this, CertInformationAuditActivity.class);
      paramView.putExtra("title", "审核标准");
      paramView.putExtra("content", this.N);
      startActivity(paramView);
      return;
    case 2131693017: 
      if (ae.isNull(this.B))
      {
        showToast("审核标准为空");
        return;
      }
      paramView = new Intent(this, CertInformationAuditActivity.class);
      paramView.putExtra("title", "审核标准");
      paramView.putExtra("content", this.B);
      startActivity(paramView);
      return;
    case 2131690110: 
      ah.callPhone(this, "400-100-1111");
      return;
    case 2131690121: 
      h();
      return;
    case 2131693015: 
      a(0, this.y);
      return;
    case 2131693009: 
      a(1, this.x);
      return;
    case 2131694539: 
      a(2, this.F);
      return;
    case 2131694537: 
      a(3, this.G);
      return;
    case 2131693018: 
      if (ae.isNull(this.r))
      {
        this.v = 1;
        i();
        return;
      }
      c(0);
      return;
    case 2131693019: 
      if (ae.isNull(this.s))
      {
        this.v = 2;
        i();
        return;
      }
      c(1);
      return;
    case 2131693020: 
      if (ae.isNull(this.t))
      {
        this.v = 3;
        i();
        return;
      }
      c(2);
      return;
    case 2131694544: 
      if (ae.isNull(this.K))
      {
        this.v = 4;
        i();
        return;
      }
      b(0);
      return;
    case 2131694545: 
      if (ae.isNull(this.L))
      {
        this.v = 5;
        i();
        return;
      }
      b(1);
      return;
    case 2131694546: 
      if (ae.isNull(this.M))
      {
        this.v = 6;
        i();
        return;
      }
      b(2);
      return;
    case 2131690105: 
      finish();
      return;
    case 2131690117: 
      this.personal_tab.setShow(true, true);
      this.personal_title_tab.setShow(true, false);
      this.enterprise_tab.setShow(false, false);
      this.enterprise_title_tab.setShow(false, false);
      return;
    case 2131690118: 
      this.personal_tab.setShow(false, false);
      this.personal_title_tab.setShow(false, false);
      this.enterprise_tab.setShow(true, true);
      this.enterprise_title_tab.setShow(true, false);
      return;
    case 2131690112: 
      this.personal_tab.setShow(true, false);
      this.personal_title_tab.setShow(true, true);
      this.enterprise_tab.setShow(false, false);
      this.enterprise_title_tab.setShow(false, false);
      return;
    }
    this.personal_tab.setShow(false, false);
    this.personal_title_tab.setShow(false, false);
    this.enterprise_tab.setShow(true, false);
    this.enterprise_title_tab.setShow(true, true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903125);
    this.d = this;
    this.c = ButterKnife.bind(this);
    this.T = getIntent().getIntExtra("type", 0);
    this.Q = ((CertInfoEntity)getIntent().getParcelableExtra("cert_info"));
    this.D = getIntent().getStringExtra("phone");
    this.R = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    b();
    e();
    f();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.U);
    ApplicationEx.c.removeActivity(this);
  }
  
  public void selectPhoto()
  {
    startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 1, false, 0, 0), 2);
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.g = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File(localFile, this.g)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    if (ae.isNull(this.g)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(h.a + "/" + this.g);
      Bitmap localBitmap = h.toturn(h.tryGetBitmap(this.g, 1280, 500000), h.readPictureDegree(localFile.getPath()));
      h.saveBitmap(localBitmap, this.g, 100);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    } while (this.g == null);
    j.headSignerImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), localFile, new f(this.d, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
        CertInformationActivity.c(CertInformationActivity.this, (String)paramAnonymouse.get("uuid"));
        CertInformationActivity.this.a(CertInformationActivity.v(CertInformationActivity.this), CertInformationActivity.w(CertInformationActivity.this));
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/CertInformationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */