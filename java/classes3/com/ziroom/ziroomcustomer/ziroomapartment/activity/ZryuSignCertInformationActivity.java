package com.ziroom.ziroomcustomer.ziroomapartment.activity;

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
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
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
import com.ziroom.ziroomcustomer.model.CertInfoEntity.NewsignCertListBean.PersonalBean;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.signed.CertInformationAuditActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.signed.k;
import com.ziroom.ziroomcustomer.signed.l;
import com.ziroom.ziroomcustomer.signed.l.a;
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

public class ZryuSignCertInformationActivity
  extends BaseActivity
{
  private String A;
  private String B;
  private com.ziroom.ziroomcustomer.signed.widget.a C;
  private CertInfoEntity D;
  private HouseDetail E;
  private String F;
  private int G;
  private BroadcastReceiver H = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("code", -1);
      if (i == 0)
      {
        paramAnonymousContext = new Intent(ZryuSignCertInformationActivity.e(ZryuSignCertInformationActivity.this), CertificationInfoActivity.class);
        paramAnonymousContext.putExtra("phone", ZryuSignCertInformationActivity.f(ZryuSignCertInformationActivity.this));
        paramAnonymousContext.putExtra("detail", ZryuSignCertInformationActivity.g(ZryuSignCertInformationActivity.this));
        paramAnonymousContext.putExtra("type", ZryuSignCertInformationActivity.h(ZryuSignCertInformationActivity.this));
        ZryuSignCertInformationActivity.this.startActivity(paramAnonymousContext);
        ZryuSignCertInformationActivity.this.finish();
      }
      do
      {
        return;
        if (i == 1)
        {
          paramAnonymousContext = new Intent(ZryuSignCertInformationActivity.e(ZryuSignCertInformationActivity.this), CertificationInfoActivity.class);
          paramAnonymousContext.putExtra("phone", ZryuSignCertInformationActivity.f(ZryuSignCertInformationActivity.this));
          paramAnonymousContext.putExtra("detail", ZryuSignCertInformationActivity.g(ZryuSignCertInformationActivity.this));
          paramAnonymousContext.putExtra("type", ZryuSignCertInformationActivity.h(ZryuSignCertInformationActivity.this));
          ZryuSignCertInformationActivity.this.startActivity(paramAnonymousContext);
          ZryuSignCertInformationActivity.this.finish();
          return;
        }
      } while (i != -1);
    }
  };
  private com.ziroom.commonlibrary.a.a<e> I = new com.ziroom.commonlibrary.a.a(this.c, new com.freelxl.baselibrary.d.f.c())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      ZryuSignCertInformationActivity.this.cert_information_btn.setEnabled(true);
      dismissProgress();
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      ZryuSignCertInformationActivity.this.cert_information_btn.setEnabled(true);
      if ("success".equals(paramAnonymouse.get("status"))) {
        if (ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this).credits.getRealNameStatus() != 4) {
          if (ZryuSignCertInformationActivity.j(ZryuSignCertInformationActivity.this) == 1)
          {
            paramAnonymouse = "ziroomCustomer://zrCreditModule/zmAuthentication?userName=" + VdsAgent.trackEditTextSilent(ZryuSignCertInformationActivity.this.cert_information_personal_name).toString() + "&userPhone=" + ZryuSignCertInformationActivity.f(ZryuSignCertInformationActivity.this) + "&certType=" + ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this) + "&certNum=" + VdsAgent.trackEditTextSilent(ZryuSignCertInformationActivity.this.cert_information_personal_cert_id).toString() + "&cerPositiveUrl=" + ZryuSignCertInformationActivity.k(ZryuSignCertInformationActivity.this) + "&certReverseUrl=" + ZryuSignCertInformationActivity.l(ZryuSignCertInformationActivity.this) + "&certHandhelUrl=" + ZryuSignCertInformationActivity.m(ZryuSignCertInformationActivity.this) + "&userSex=" + ZryuSignCertInformationActivity.c(ZryuSignCertInformationActivity.this) + "&source=1&isEnterprise=0";
            Routers.open(ZryuSignCertInformationActivity.this, paramAnonymouse);
          }
        }
      }
      for (;;)
      {
        dismissProgress();
        return;
        if (ZryuSignCertInformationActivity.j(ZryuSignCertInformationActivity.this) == 2)
        {
          paramAnonymouse = "ziroomCustomer://zrCreditModule/zmAuthentication?userName=" + VdsAgent.trackEditTextSilent(ZryuSignCertInformationActivity.this.cert_information_personal_name).toString() + "&userPhone=" + ZryuSignCertInformationActivity.f(ZryuSignCertInformationActivity.this) + "&certType=" + ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this) + "&certNum=" + VdsAgent.trackEditTextSilent(ZryuSignCertInformationActivity.this.cert_information_personal_cert_id).toString() + "&cerPositiveUrl=" + ZryuSignCertInformationActivity.k(ZryuSignCertInformationActivity.this) + "&certReverseUrl=" + ZryuSignCertInformationActivity.l(ZryuSignCertInformationActivity.this) + "&certHandhelUrl=" + ZryuSignCertInformationActivity.m(ZryuSignCertInformationActivity.this) + "&userSex=" + ZryuSignCertInformationActivity.c(ZryuSignCertInformationActivity.this) + "&source=1&isEnterprise=1";
          Routers.open(ZryuSignCertInformationActivity.this, paramAnonymouse);
          continue;
          paramAnonymouse = new Intent(ZryuSignCertInformationActivity.e(ZryuSignCertInformationActivity.this), ZryuSignCertificationInfoActivity.class);
          paramAnonymouse.putExtra("phone", ZryuSignCertInformationActivity.f(ZryuSignCertInformationActivity.this));
          paramAnonymouse.putExtra("detail", ZryuSignCertInformationActivity.g(ZryuSignCertInformationActivity.this));
          paramAnonymouse.putExtra("type", ZryuSignCertInformationActivity.h(ZryuSignCertInformationActivity.this));
          ZryuSignCertInformationActivity.this.startActivity(paramAnonymouse);
          ZryuSignCertInformationActivity.this.finish();
          continue;
          ZryuSignCertInformationActivity.this.showToast(paramAnonymouse.get("error_message").toString());
        }
      }
    }
  };
  private View.OnClickListener J = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      ZryuSignCertInformationActivity.n(ZryuSignCertInformationActivity.this).dismiss();
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131692507: 
        ZryuSignCertInformationActivity.this.takePhoto();
        return;
      }
      ZryuSignCertInformationActivity.this.selectPhoto();
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
          ZryuSignCertInformationActivity.this.cert_information_personal_sex.setText(paramAnonymousString);
          if ("男".equals(paramAnonymousString))
          {
            ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this, 1);
            return;
          }
        } while (!"女".equals(paramAnonymousString));
        ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this, 2);
        return;
      }
      ZryuSignCertInformationActivity.this.cert_information_personal_cert_type.setText(paramAnonymousString);
      if (ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this) != ((CertInfoEntity.NewsignCertListBean.PersonalBean)ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getCert_type())
      {
        ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this, 0);
        ZryuSignCertInformationActivity.this.cert_information_personal_sex.setText(ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this, ZryuSignCertInformationActivity.c(ZryuSignCertInformationActivity.this)));
        ZryuSignCertInformationActivity.this.cert_information_personal_cert_id.setText("");
      }
      ZryuSignCertInformationActivity.c(ZryuSignCertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.PersonalBean)ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getCert_type());
      if (ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this) == 1)
      {
        ZryuSignCertInformationActivity.this.cert_information_personal_sex_ll.setVisibility(8);
        ZryuSignCertInformationActivity.this.cert_information_personal_image_ll.setVisibility(8);
        if (!ae.notNull(((CertInfoEntity.NewsignCertListBean.PersonalBean)ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getTips())) {
          break label383;
        }
        ZryuSignCertInformationActivity.this.cert_information_personal_tv.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getTips());
      }
      for (;;)
      {
        ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this, ((CertInfoEntity.NewsignCertListBean.PersonalBean)ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this).getNewsign_cert_list().getPersonal().get(paramAnonymousInt1)).getStandards());
        if (!ae.isNull(ZryuSignCertInformationActivity.d(ZryuSignCertInformationActivity.this))) {
          break label398;
        }
        ZryuSignCertInformationActivity.this.cert_information_personal_audit.setVisibility(8);
        return;
        ZryuSignCertInformationActivity.this.cert_information_personal_sex_ll.setVisibility(0);
        ZryuSignCertInformationActivity.this.cert_information_personal_image_ll.setVisibility(0);
        break;
        label383:
        ZryuSignCertInformationActivity.this.cert_information_personal_tv.setText("");
      }
      label398:
      ZryuSignCertInformationActivity.this.cert_information_personal_audit.setVisibility(0);
    }
  };
  private Unbinder b;
  private Context c;
  @BindView(2131690121)
  TextView cert_information_btn;
  @BindView(2131693017)
  LinearLayout cert_information_personal_audit;
  @BindView(2131693010)
  EditText cert_information_personal_cert_id;
  @BindView(2131693012)
  View cert_information_personal_cert_id_line;
  @BindView(2131693009)
  TextView cert_information_personal_cert_type;
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
  @BindView(2131690109)
  TextView cert_title_tv;
  private int d = 1;
  private k e;
  private String f;
  private String g = "";
  @BindView(2131690124)
  KeyboardView keyboard_view;
  @BindView(2131690119)
  View personal_ll;
  private String r = "";
  private String s = "";
  private String t;
  private int u = -1;
  private ArrayList<String> v = new ArrayList(3);
  private String[] w;
  private String[] x;
  private int y = 0;
  private int z = 0;
  
  private void a()
  {
    if (this.G == 0) {}
    for (this.F = "0"; (this.D != null) && (this.D.getNewsign_cert_list() != null) && (this.D.getNewsign_cert_list().getPersonal() != null); this.F = "1")
    {
      int j = this.D.getNewsign_cert_list().getPersonal().size();
      this.w = new String[j];
      int i = 0;
      while (i < j)
      {
        this.w[i] = ((CertInfoEntity.NewsignCertListBean.PersonalBean)this.D.getNewsign_cert_list().getPersonal().get(i)).getCert_name();
        i += 1;
      }
    }
    this.x = new String[2];
    this.x[0] = "男";
    this.x[1] = "女";
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
  
  private void a(String paramString, SimpleDraweeView paramSimpleDraweeView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("uuid", paramString + "");
    paramString = com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap);
    paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(b(q.O + e.d.d, paramString)));
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, int paramInt3, String paramString10)
  {
    j.putCertInfo(this.c, paramString1, paramString2, paramInt1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramInt3, this.F, paramString10, 0, this.I);
  }
  
  private void b()
  {
    registerReceiver(this.H, new IntentFilter("com.ziroom.ziroomcustomer.zmcertresult"));
    int i = 0;
    while (i < 3)
    {
      this.v.add("");
      i += 1;
    }
    if (this.D == null) {}
    for (;;)
    {
      return;
      try
      {
        this.d = Integer.parseInt(this.D.user_type);
        if (this.d == 2) {
          continue;
        }
        this.d = 1;
        this.personal_ll.setVisibility(0);
        this.cert_information_personal_name.setText(this.D.real_name);
        this.z = this.D.gender;
        this.cert_information_personal_sex.setText(a(this.z));
        Object localObject;
        if (ae.notNull(this.D.cert_type))
        {
          localObject = this.D.cert_type;
          label147:
          this.y = new Integer((String)localObject).intValue();
          if (this.y != 1) {
            break label395;
          }
          this.cert_information_personal_sex_ll.setVisibility(8);
          this.cert_information_personal_image_ll.setVisibility(8);
        }
        for (;;)
        {
          this.cert_information_personal_cert_id.setText(this.D.cert_num);
          this.g = this.D.getUser_cert1();
          this.r = this.D.getUser_cert2();
          this.s = this.D.getUser_cert3();
          this.v.set(0, this.D.getUser_cert1());
          this.v.set(1, this.D.getUser_cert2());
          this.v.set(2, this.D.getUser_cert3());
          a(this.D.getUser_cert1(), this.cert_information_personal_image1);
          a(this.D.getUser_cert2(), this.cert_information_personal_image2);
          a(this.D.getUser_cert3(), this.cert_information_personal_image3);
          localObject = a(this.y + "", this.D.getNewsign_cert_list().personal);
          if (localObject == null) {
            break;
          }
          this.A = ((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject).getStandards();
          this.cert_information_personal_cert_type.setText(((CertInfoEntity.NewsignCertListBean.PersonalBean)localObject).getCert_name());
          return;
          localObject = "0";
          break label147;
          label395:
          this.cert_information_personal_sex_ll.setVisibility(0);
          this.cert_information_personal_image_ll.setVisibility(0);
          if ((this.D.getNewsign_cert_list() != null) && (this.D.getNewsign_cert_list().getPersonal() != null) && (this.D.getNewsign_cert_list().getPersonal().size() > 0))
          {
            localObject = this.D.getNewsign_cert_list().getPersonal().iterator();
            CertInfoEntity.NewsignCertListBean.PersonalBean localPersonalBean;
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              localPersonalBean = (CertInfoEntity.NewsignCertListBean.PersonalBean)((Iterator)localObject).next();
            } while (localPersonalBean.getCert_type() != this.y);
            this.cert_information_personal_tv.setText(localPersonalBean.getTips());
            i = 1;
            if (i == 0) {
              this.cert_information_personal_tv.setText("");
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          i = 0;
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent(this, ScanImageActivity.class);
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.g)) {
      localArrayList.add(this.g);
    }
    if (ae.notNull(this.r)) {
      localArrayList.add(this.r);
    }
    if (ae.notNull(this.s)) {
      localArrayList.add(this.s);
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
      if (ae.isNull(this.g))
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
    this.cert_information_personal_name.addTextChangedListener(new TextWatcher()
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
    this.cert_information_personal_cert_id.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this) == 1)
        {
          ZryuSignCertInformationActivity.a(ZryuSignCertInformationActivity.this, new com.ziroom.ziroomcustomer.signed.widget.a(ZryuSignCertInformationActivity.this, ZryuSignCertInformationActivity.e(ZryuSignCertInformationActivity.this), ZryuSignCertInformationActivity.this.cert_information_personal_cert_id));
          ZryuSignCertInformationActivity.i(ZryuSignCertInformationActivity.this).showKeyboard();
          return true;
        }
        return false;
      }
    });
  }
  
  private String f()
  {
    if (this.d == 1)
    {
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim().replace("\n", " "))) {
        return "请填写姓名";
      }
      if ((this.z == 0) && (this.y != 1)) {
        return "请选择性别";
      }
      if (this.y == 0) {
        return "请选择证件类型";
      }
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString())) {
        return "请填写证件号";
      }
      if (this.y != 1)
      {
        if (ae.isNull(this.g)) {
          return "请按要求上传证件照";
        }
        if (ae.isNull(this.r)) {
          return "请按要求上传证件照";
        }
        if (ae.isNull(this.s)) {
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
        this.z = 1;
      }
      for (;;)
      {
        this.cert_information_personal_sex.setText(a(this.z));
        this.cert_information_btn.setBackgroundColor(Color.parseColor("#ffa000"));
        return "";
        label281:
        this.z = 2;
        continue;
        label289:
        if (VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().length() == 15) {
          if (Integer.valueOf(VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString().charAt(14)).intValue() % 2 != 0) {
            this.z = 1;
          } else {
            this.z = 2;
          }
        }
      }
    }
    if (this.d == 2) {
      return "";
    }
    return "非法类型";
  }
  
  private void g()
  {
    this.e = new k(this, this.J);
    k localk = this.e;
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
    SimpleDraweeView localSimpleDraweeView = new SimpleDraweeView(this.c);
    if (paramInt == 1)
    {
      localSimpleDraweeView = this.cert_information_personal_image1;
      this.g = paramString;
      this.v.set(0, paramString);
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
        this.r = paramString;
        this.v.set(1, paramString);
      }
      else if (paramInt == 3)
      {
        localSimpleDraweeView = this.cert_information_personal_image3;
        this.s = paramString;
        this.v.set(2, paramString);
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
    Routers.open(this, "ziroomCustomer://zrCreditModule/zmAuthenticationResult?requestCode=" + paramInt1 + "&resultCode=" + paramInt2);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      uploadPhoto();
    }
    label382:
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
          Object localObject1 = null;
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
                    ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this, (String)paramAnonymouse.get("uuid"));
                    ZryuSignCertInformationActivity.this.a(ZryuSignCertInformationActivity.o(ZryuSignCertInformationActivity.this), ZryuSignCertInformationActivity.p(ZryuSignCertInformationActivity.this));
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
              break label382;
            }
            String str = (String)paramIntent.next();
            if (str == null) {
              break;
            }
            if (str.equals(this.g))
            {
              this.g = "";
              this.cert_information_personal_image1.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.r))
            {
              this.r = "";
              this.cert_information_personal_image2.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
            if (str.equals(this.s))
            {
              this.s = "";
              this.cert_information_personal_image3.setController(com.freelxl.baselibrary.f.c.frescoController(""));
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if ((this.C != null) && (this.keyboard_view.getVisibility() == 0))
    {
      this.C.hideKeyboard();
      return;
    }
    super.onBackPressed();
  }
  
  @OnClick({2131690105, 2131693018, 2131693019, 2131693020, 2131693009, 2131693015, 2131690121, 2131690110, 2131693017, 2131690123})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131690123: 
    case 2131693017: 
    case 2131690110: 
    case 2131690121: 
      do
      {
        return;
        this.C.hideKeyboard();
        return;
        if (ae.isNull(this.A))
        {
          showToast("审核标准为空");
          return;
        }
        paramView = new Intent(this, CertInformationAuditActivity.class);
        paramView.putExtra("title", "审核标准");
        paramView.putExtra("content", this.A);
        startActivity(paramView);
        return;
        ah.callPhone(this, "400-100-1111");
        return;
        if (!ae.isNull(f())) {
          break;
        }
        paramView = null;
        if (this.E != null) {
          paramView = this.E.getHouse_type();
        }
        if (this.d == 1)
        {
          if ((VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim().replace("\n", " ").length() >= 2) && (VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim().replace("\n", " ").length() <= 42))
          {
            this.cert_information_btn.setEnabled(false);
            a(com.ziroom.commonlibrary.login.a.getToken(this.c), this.D.getCert_id(), this.y, VdsAgent.trackEditTextSilent(this.cert_information_personal_cert_id).toString(), this.g, this.r, this.s, VdsAgent.trackEditTextSilent(this.cert_information_personal_name).toString().trim(), this.z + "", this.B, 1, 0, paramView);
            return;
          }
          showToast("姓名应为2-42个字符");
          return;
        }
      } while (this.d != 2);
      return;
      showToast(f());
      return;
    case 2131693015: 
      a(0, this.x);
      return;
    case 2131693009: 
      a(1, this.w);
      return;
    case 2131693018: 
      if (ae.isNull(this.g))
      {
        this.u = 1;
        g();
        return;
      }
      b(0);
      return;
    case 2131693019: 
      if (ae.isNull(this.r))
      {
        this.u = 2;
        g();
        return;
      }
      b(1);
      return;
    case 2131693020: 
      if (ae.isNull(this.s))
      {
        this.u = 3;
        g();
        return;
      }
      b(2);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903607);
    this.c = this;
    this.b = ButterKnife.bind(this);
    this.D = ((CertInfoEntity)getIntent().getParcelableExtra("cert_info"));
    this.B = getIntent().getStringExtra("phone");
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.H);
    ApplicationEx.c.removeActivity(this);
  }
  
  public void selectPhoto()
  {
    startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 1, false, 0, 0), 2);
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.f = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File(localFile, this.f)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    if (ae.isNull(this.f)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(h.a + "/" + this.f);
      Bitmap localBitmap = h.toturn(h.tryGetBitmap(this.f, 1280, 500000), h.readPictureDegree(localFile.getPath()));
      h.saveBitmap(localBitmap, this.f, 100);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    } while (this.f == null);
    j.headSignerImgUpload(this, com.ziroom.commonlibrary.login.a.getToken(this), localFile, new f(this.c, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
        ZryuSignCertInformationActivity.b(ZryuSignCertInformationActivity.this, (String)paramAnonymouse.get("uuid"));
        ZryuSignCertInformationActivity.this.a(ZryuSignCertInformationActivity.o(ZryuSignCertInformationActivity.this), ZryuSignCertInformationActivity.p(ZryuSignCertInformationActivity.this));
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignCertInformationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */