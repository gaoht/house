package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.my.model.InvoiceAuthStatusBean;
import com.ziroom.ziroomcustomer.my.model.InvoiceAvailableInfo;
import com.ziroom.ziroomcustomer.my.model.InvoiceAvailableInfo.BusInvoiceType;
import com.ziroom.ziroomcustomer.my.model.InvoiceAvailableInfo.InvoiceTypeInfo;
import com.ziroom.ziroomcustomer.my.model.InvoiceAvailableInfo.MonthInfo;
import com.ziroom.ziroomcustomer.my.model.InvoiceSubmitReceiveBean;
import com.ziroom.ziroomcustomer.my.widget.InvoiceCitySelectDialog;
import com.ziroom.ziroomcustomer.my.widget.InvoiceCitySelectDialog.a;
import com.ziroom.ziroomcustomer.my.widget.InvoiceMonthSelectDialog;
import com.ziroom.ziroomcustomer.my.widget.InvoiceMonthSelectDialog.a;
import com.ziroom.ziroomcustomer.my.widget.InvoiceOpenTipsDialog;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FriendlyInvoiceOpenActivity
  extends OwnerBaseActivity
{
  private InvoiceAuthStatusBean A;
  private int B;
  private View.OnClickListener C = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = new Intent(FriendlyInvoiceOpenActivity.this, FriendlyCompetencyApplyActivity.class);
      paramAnonymousView.putExtra("tradeNum", FriendlyInvoiceOpenActivity.f(FriendlyInvoiceOpenActivity.this));
      paramAnonymousView.putExtra("companyName", FriendlyInvoiceOpenActivity.g(FriendlyInvoiceOpenActivity.this).getInvoiceTitle());
      if ((FriendlyInvoiceOpenActivity.h(FriendlyInvoiceOpenActivity.this) != null) && (3 == FriendlyInvoiceOpenActivity.h(FriendlyInvoiceOpenActivity.this).getStatus())) {
        paramAnonymousView.putExtra("statusBean", FriendlyInvoiceOpenActivity.h(FriendlyInvoiceOpenActivity.this));
      }
      FriendlyInvoiceOpenActivity.this.startActivityForResult(paramAnonymousView, 100);
    }
  };
  Unbinder a;
  private String b = FriendlyInvoiceOpenActivity.class.getSimpleName();
  private Context d;
  private int e = -1;
  private int f = -1;
  private boolean g = false;
  @BindView(2131690078)
  ImageView mBtnBack;
  @BindView(2131690636)
  ImageView mCbCompany;
  @BindView(2131690638)
  ImageView mCbPersonal;
  @BindView(2131695983)
  EditText mEtInvoiceAddress;
  @BindView(2131695980)
  EditText mEtInvoiceAddressee;
  @BindView(2131690641)
  EditText mEtInvoiceIdentityNum;
  @BindView(2131692010)
  EditText mEtInvoicePhoneNum;
  @BindView(2131690631)
  RadioGroup mFlInvoiceType;
  @BindView(2131695977)
  LinearLayout mLlAddressContainer;
  @BindView(2131690635)
  LinearLayout mLlCompany;
  @BindView(2131690608)
  LinearLayout mLlContentContainer;
  @BindView(2131695981)
  LinearLayout mLlInvoiceAddressSelect;
  @BindView(2131695979)
  LinearLayout mLlInvoiceAddressee;
  @BindView(2131690634)
  LinearLayout mLlInvoiceDetail;
  @BindView(2131690643)
  LinearLayout mLlInvoiceDetailPriceShow;
  @BindView(2131690640)
  LinearLayout mLlInvoiceIdentityContainer;
  @BindView(2131696254)
  LinearLayout mLlInvoiceMonth;
  @BindView(2131690629)
  LinearLayout mLlInvoiceType;
  @BindView(2131690637)
  LinearLayout mLlPersonal;
  @BindView(2131690628)
  RadioButton mRbSubjectRent;
  @BindView(2131690627)
  RadioButton mRbSubjectService;
  @BindView(2131690626)
  RadioGroup mRgInvoiceSubject;
  @BindView(2131690632)
  RelativeLayout mRlInvoiceCertification;
  @BindView(2131690620)
  ViewStub mStubError;
  @BindView(2131695982)
  TextView mTvInvoiceAddressSelect;
  @BindView(2131695978)
  TextView mTvInvoiceAddresseeTips;
  @BindView(2131690609)
  TextView mTvInvoiceDetailDesc;
  @BindView(2131690642)
  TextView mTvInvoiceIdentityNum;
  @BindView(2131696257)
  TextView mTvInvoiceMonthPrice;
  @BindView(2131696258)
  TextView mTvInvoiceMonthTax;
  @BindView(2131690644)
  TextView mTvInvoicePrice;
  @BindView(2131690625)
  TextView mTvInvoiceSubjectTitle;
  @BindView(2131690639)
  TextView mTvInvoiceTopName;
  @BindView(2131690630)
  TextView mTvInvoiceTypeTitle;
  @BindView(2131696256)
  TextView mTvMonthCount;
  @BindView(2131696255)
  TextView mTvMonthDesc;
  @BindView(2131689997)
  TextView mTvSubmit;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131690624)
  TextView mTvTopRight;
  @BindView(2131690633)
  TextView mtvInvoiceCertification;
  private boolean r = false;
  private String s;
  private InvoiceAvailableInfo t;
  private int u = 1;
  private boolean v;
  private double w;
  private double x;
  private boolean y = false;
  private ArrayList<InvoiceAvailableInfo.MonthInfo> z;
  
  private void a(InvoiceAuthStatusBean paramInvoiceAuthStatusBean)
  {
    this.e = 0;
    this.mLlInvoiceIdentityContainer.setVisibility(0);
    this.mEtInvoiceIdentityNum.setVisibility(8);
    this.mTvInvoiceIdentityNum.setVisibility(0);
    this.mCbCompany.setImageResource(2130840182);
    this.mLlPersonal.setVisibility(8);
    this.mTvInvoiceIdentityNum.setText(paramInvoiceAuthStatusBean.getTaxIdfa());
  }
  
  private void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.mRlInvoiceCertification.setVisibility(0);
    this.mLlAddressContainer.setVisibility(8);
    this.mtvInvoiceCertification.setText(paramString);
    this.mtvInvoiceCertification.setOnClickListener(paramOnClickListener);
  }
  
  private void a(List<InvoiceAvailableInfo.InvoiceTypeInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      this.mLlInvoiceType.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.mFlInvoiceType.removeAllViews();
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = (InvoiceAvailableInfo.InvoiceTypeInfo)paramList.get(i);
        RadioButton localRadioButton = l();
        localRadioButton.setTag(localObject);
        localRadioButton.setText(((InvoiceAvailableInfo.InvoiceTypeInfo)localObject).getInvoiceTypeName());
        localRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            if (!paramAnonymousBoolean) {
              return;
            }
            int i = 0;
            while (i < FriendlyInvoiceOpenActivity.this.mFlInvoiceType.getChildCount())
            {
              localObject = (RadioButton)FriendlyInvoiceOpenActivity.this.mFlInvoiceType.getChildAt(i);
              if (localObject != paramAnonymousCompoundButton) {
                ((RadioButton)localObject).setChecked(false);
              }
              i += 1;
            }
            FriendlyInvoiceOpenActivity.this.mRlInvoiceCertification.setVisibility(8);
            paramAnonymousCompoundButton = (InvoiceAvailableInfo.InvoiceTypeInfo)paramAnonymousCompoundButton.getTag();
            FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this, paramAnonymousCompoundButton.getInvoiceTypeCode());
            Object localObject = FriendlyInvoiceOpenActivity.this;
            if (paramAnonymousCompoundButton.getInvoiceTypeCode() == 3) {}
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              FriendlyInvoiceOpenActivity.a((FriendlyInvoiceOpenActivity)localObject, paramAnonymousBoolean);
              if (!paramAnonymousCompoundButton.isAuthNeed()) {
                break;
              }
              FriendlyInvoiceOpenActivity.c(FriendlyInvoiceOpenActivity.this);
              FriendlyInvoiceOpenActivity.this.mLlInvoiceDetail.setVisibility(8);
              return;
            }
            FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, null);
            FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, false, null);
            FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this, FriendlyInvoiceOpenActivity.d(FriendlyInvoiceOpenActivity.this));
          }
        });
        int j = (int)(8.0F * getResources().getDisplayMetrics().density);
        localObject = new RadioGroup.LayoutParams(-2, -2);
        ((RadioGroup.LayoutParams)localObject).setMargins(0, 0, j, 0);
        localRadioButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mFlInvoiceType.addView(localRadioButton, (ViewGroup.LayoutParams)localObject);
        i += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.mLlAddressContainer.setVisibility(0);
    if (paramBoolean)
    {
      this.mTvInvoiceAddresseeTips.setVisibility(0);
      this.mLlInvoiceAddressee.setVisibility(8);
      this.mLlInvoiceAddressSelect.setVisibility(8);
      this.mEtInvoiceAddress.setVisibility(8);
      return;
    }
    this.mTvInvoiceAddresseeTips.setVisibility(8);
    this.mLlInvoiceAddressee.setVisibility(0);
    this.mLlInvoiceAddressSelect.setVisibility(0);
    this.mEtInvoiceAddress.setVisibility(0);
  }
  
  private void a(boolean paramBoolean, InvoiceAuthStatusBean paramInvoiceAuthStatusBean)
  {
    this.mLlInvoiceDetail.setVisibility(0);
    this.mTvSubmit.setVisibility(0);
    if (this.u == 0) {
      this.mLlInvoiceDetailPriceShow.setVisibility(8);
    }
    for (;;)
    {
      this.mTvInvoiceTopName.setText(this.t.getInvoiceTitle());
      if (!paramBoolean) {
        break;
      }
      a(paramInvoiceAuthStatusBean);
      return;
      if (f() != null)
      {
        this.mLlInvoiceDetailPriceShow.setVisibility(0);
        this.mTvInvoicePrice.setText("¥" + f().getInvoiceMount() / 100.0D);
      }
      else
      {
        this.mLlInvoiceDetailPriceShow.setVisibility(8);
      }
    }
    i();
  }
  
  private void b()
  {
    this.s = getIntent().getStringExtra("contractCode");
    this.B = getIntent().getIntExtra("type", 0);
  }
  
  private void b(int paramInt)
  {
    if (this.e == paramInt) {
      return;
    }
    this.e = paramInt;
    if (this.e == 0)
    {
      this.mLlInvoiceIdentityContainer.setVisibility(0);
      this.mCbCompany.setImageResource(2130840182);
      this.mCbPersonal.setImageResource(2130840185);
      return;
    }
    this.mLlInvoiceIdentityContainer.setVisibility(8);
    this.mCbCompany.setImageResource(2130840185);
    this.mCbPersonal.setImageResource(2130840182);
  }
  
  private boolean e()
  {
    List localList = this.t.getBusInvoiceTypeList();
    if ((localList == null) || (localList.size() < 1)) {
      return false;
    }
    int i = 0;
    while (i < this.mRgInvoiceSubject.getChildCount())
    {
      this.mRgInvoiceSubject.getChildAt(i).setVisibility(8);
      i += 1;
    }
    int j = Math.min(localList.size(), this.mRgInvoiceSubject.getChildCount());
    i = 0;
    if (i < j)
    {
      RadioButton localRadioButton = (RadioButton)this.mRgInvoiceSubject.getChildAt(i);
      localRadioButton.setVisibility(0);
      localRadioButton.setTag(localList.get(i));
      localRadioButton.setText(((InvoiceAvailableInfo.BusInvoiceType)localList.get(i)).getName());
      localRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            paramAnonymousCompoundButton = (InvoiceAvailableInfo.BusInvoiceType)paramAnonymousCompoundButton.getTag();
            FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, paramAnonymousCompoundButton.getType());
            FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, paramAnonymousCompoundButton.getInvoiceTypeInfolist());
            FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this);
            FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this, -1);
          }
        }
      });
      if (this.t.getType() == ((InvoiceAvailableInfo.BusInvoiceType)localList.get(i)).getType()) {
        localRadioButton.setChecked(true);
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.t.getType() == ((InvoiceAvailableInfo.BusInvoiceType)localList.get(i)).getType()) {
          localRadioButton.setChecked(true);
        }
      }
    }
    return true;
  }
  
  private InvoiceAvailableInfo.BusInvoiceType f()
  {
    int i = 0;
    while (i < this.mRgInvoiceSubject.getChildCount())
    {
      RadioButton localRadioButton = (RadioButton)this.mRgInvoiceSubject.getChildAt(i);
      if (localRadioButton.isChecked()) {
        return (InvoiceAvailableInfo.BusInvoiceType)localRadioButton.getTag();
      }
      i += 1;
    }
    return null;
  }
  
  private void g()
  {
    this.mRlInvoiceCertification.setVisibility(8);
    this.mLlInvoiceDetail.setVisibility(8);
    this.mLlAddressContainer.setVisibility(8);
    this.mTvSubmit.setVisibility(8);
    if (this.u == 0)
    {
      this.mLlInvoiceMonth.setVisibility(0);
      return;
    }
    this.mLlInvoiceMonth.setVisibility(8);
  }
  
  private void h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this));
    localHashMap.put("tradeNum", this.s);
    j.getCompetencyRecord(this, localHashMap, new d(this, new f(InvoiceAuthStatusBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        FriendlyInvoiceOpenActivity.this.mTvSubmit.setVisibility(8);
        FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, "立即认证", FriendlyInvoiceOpenActivity.e(FriendlyInvoiceOpenActivity.this));
      }
      
      public void onSuccess(int paramAnonymousInt, InvoiceAuthStatusBean paramAnonymousInvoiceAuthStatusBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousInvoiceAuthStatusBean);
        FriendlyInvoiceOpenActivity.this.mTvSubmit.setVisibility(8);
        FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, paramAnonymousInvoiceAuthStatusBean);
        if (paramAnonymousInvoiceAuthStatusBean == null)
        {
          FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, "立即认证", FriendlyInvoiceOpenActivity.e(FriendlyInvoiceOpenActivity.this));
          return;
        }
        if (paramAnonymousInvoiceAuthStatusBean.getStatus() == 2)
        {
          FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, true, paramAnonymousInvoiceAuthStatusBean);
          FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this, FriendlyInvoiceOpenActivity.d(FriendlyInvoiceOpenActivity.this));
          return;
        }
        if (paramAnonymousInvoiceAuthStatusBean.getStatus() == 1)
        {
          FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, "资质认证审核中", null);
          return;
        }
        FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, "审核被拒", FriendlyInvoiceOpenActivity.e(FriendlyInvoiceOpenActivity.this));
      }
    });
  }
  
  private void i()
  {
    this.e = -1;
    this.mCbCompany.setImageResource(2130840185);
    this.mCbPersonal.setImageResource(2130840185);
    this.mLlPersonal.setVisibility(0);
    this.mEtInvoiceIdentityNum.setVisibility(0);
    this.mTvInvoiceIdentityNum.setVisibility(8);
  }
  
  public static boolean isTaxpayerNum(String paramString)
  {
    return Pattern.compile("^(?![a-zA-Z]*$)[a-zA-Z0-9]{15}$|^(?![a-zA-Z]*$)[a-zA-Z0-9]{18}$|^(?![a-zA-Z]*$)[a-zA-Z0-9]{20}$").matcher(paramString).matches();
  }
  
  private void j()
  {
    if (this.e == -1)
    {
      g.textToast(this, "请选择抬头类型");
      return;
    }
    if (this.f == -1)
    {
      g.textToast(this, "请选择发票类型");
      return;
    }
    if ((this.u == 0) && ((this.z == null) || (this.z.size() < 1) || (!this.y)))
    {
      g.textToast(this, "请选择开票月份");
      return;
    }
    if (this.e == 0)
    {
      if (this.mEtInvoiceIdentityNum.getVisibility() == 0) {}
      for (str = VdsAgent.trackEditTextSilent(this.mEtInvoiceIdentityNum).toString(); ae.isNull(str); str = this.mTvInvoiceIdentityNum.getText().toString())
      {
        g.textToast(this, "纳税人识别号不能为空");
        this.mEtInvoiceIdentityNum.setHint("");
        this.mEtInvoiceIdentityNum.setHintTextColor(getResources().getColor(2131624610));
        this.mEtInvoiceIdentityNum.setBackgroundResource(2130837840);
        return;
      }
      if (!isTaxpayerNum(str))
      {
        g.textToast(this, "纳税人识别号格式错误，请重新填写");
        return;
      }
    }
    String str = VdsAgent.trackEditTextSilent(this.mEtInvoicePhoneNum).toString();
    if (ae.isNull(str))
    {
      g.textToast(this, "手机号不能为空");
      this.mEtInvoicePhoneNum.setHint("");
      this.mEtInvoicePhoneNum.setHintTextColor(getResources().getColor(2131624610));
      this.mEtInvoicePhoneNum.setBackgroundResource(2130837840);
      return;
    }
    if (!ah.isMobile(str))
    {
      af.showToast(this, "手机号错误，请重新填写");
      return;
    }
    if (!this.v)
    {
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.mEtInvoiceAddressee).toString()))
      {
        g.textToast(this, "收件人不能为空");
        this.mEtInvoiceAddressee.setHint("");
        this.mEtInvoiceAddressee.setHintTextColor(getResources().getColor(2131624610));
        this.mEtInvoiceAddressee.setBackgroundResource(2130837840);
        return;
      }
      if (ae.isNull(this.mTvInvoiceAddressSelect.getText().toString()))
      {
        g.textToast(this, "省市选择不能为空");
        this.mTvInvoiceAddressSelect.setHintTextColor(getResources().getColor(2131624610));
        this.mTvInvoiceAddressSelect.setBackgroundResource(2130837840);
        return;
      }
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.mEtInvoiceAddress).toString()))
      {
        g.textToast(this, "具体地址不能为空");
        this.mEtInvoiceAddress.setHint("");
        this.mEtInvoiceAddress.setHintTextColor(getResources().getColor(2131624610));
        this.mEtInvoiceAddress.setBackgroundResource(2130837840);
        return;
      }
    }
    k();
  }
  
  private void k()
  {
    int j = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this));
    localHashMap.put("contractCode", this.s);
    localHashMap.put("busType", Integer.valueOf(this.u));
    localHashMap.put("invoiceType", Integer.valueOf(this.f));
    localHashMap.put("comOrPers", Integer.valueOf(this.e));
    localHashMap.put("invoiceTitle", this.t.getInvoiceTitle());
    Iterator localIterator = null;
    int i = 0;
    for (;;)
    {
      localObject = localIterator;
      if (i < this.mRgInvoiceSubject.getChildCount())
      {
        localObject = (RadioButton)this.mRgInvoiceSubject.getChildAt(i);
        if (((RadioButton)localObject).isChecked()) {
          localObject = (InvoiceAvailableInfo.BusInvoiceType)((RadioButton)localObject).getTag();
        }
      }
      else
      {
        if (localObject != null) {
          break;
        }
        return;
      }
      i += 1;
    }
    if (this.u == 0)
    {
      localIterator = this.z.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        InvoiceAvailableInfo.MonthInfo localMonthInfo = (InvoiceAvailableInfo.MonthInfo)localIterator.next();
        i += localMonthInfo.getMonthAmount();
        j += localMonthInfo.getMonthTaxAmount();
      }
      localHashMap.put("taxPoint", Integer.valueOf(((InvoiceAvailableInfo.BusInvoiceType)localObject).getTaxPoint()));
      localHashMap.put("taxAmount", Double.valueOf(this.w));
      localHashMap.put("availableMonthsListStr", com.alibaba.fastjson.a.toJSONString(this.z));
      if (this.mEtInvoiceIdentityNum.getVisibility() != 0) {
        break label489;
      }
    }
    label489:
    for (Object localObject = VdsAgent.trackEditTextSilent(this.mEtInvoiceIdentityNum).toString();; localObject = this.mTvInvoiceIdentityNum.getText().toString())
    {
      localHashMap.put("custTaxNo", localObject);
      localHashMap.put("invoiceAmount", Integer.valueOf(i));
      localHashMap.put("receiverPhone", VdsAgent.trackEditTextSilent(this.mEtInvoicePhoneNum).toString());
      if (!this.v)
      {
        localHashMap.put("receiverAddr", this.mTvInvoiceAddressSelect.getText().toString() + VdsAgent.trackEditTextSilent(this.mEtInvoiceAddress).toString());
        localHashMap.put("receiverName", VdsAgent.trackEditTextSilent(this.mEtInvoiceAddressee).toString());
      }
      if (this.A != null) {
        localHashMap.put("compentencyId", this.A.getApplyNum());
      }
      j.getFInvoiceOpen(this, localHashMap, new d(this, new f(InvoiceSubmitReceiveBean.class))
      {
        public void onSuccess(int paramAnonymousInt, InvoiceSubmitReceiveBean paramAnonymousInvoiceSubmitReceiveBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousInvoiceSubmitReceiveBean);
          Intent localIntent = new Intent(FriendlyInvoiceOpenActivity.this, FriendlyInvoiceDetailActivity.class);
          localIntent.putExtra("invoiceNum", paramAnonymousInvoiceSubmitReceiveBean.getApplyNo());
          localIntent.putExtra("busType", FriendlyInvoiceOpenActivity.i(FriendlyInvoiceOpenActivity.this));
          localIntent.putExtra("contractCode", FriendlyInvoiceOpenActivity.f(FriendlyInvoiceOpenActivity.this));
          FriendlyInvoiceOpenActivity.this.startActivity(localIntent);
          FriendlyInvoiceOpenActivity.this.finish();
        }
      });
      return;
      i = ((InvoiceAvailableInfo.BusInvoiceType)localObject).getInvoiceMount();
      break;
    }
  }
  
  private RadioButton l()
  {
    float f1 = getResources().getDisplayMetrics().density;
    RadioButton localRadioButton = new RadioButton(this);
    localRadioButton.setTextSize(1, 12.0F);
    localRadioButton.setButtonDrawable(2131624576);
    localRadioButton.setGravity(17);
    localRadioButton.setSingleLine(true);
    localRadioButton.setSingleLine(true);
    localRadioButton.setEllipsize(null);
    localRadioButton.setBackgroundResource(2130839490);
    localRadioButton.setTextColor(getResources().getColorStateList(2131624647));
    int i = (int)(12.0F * f1);
    int j = (int)(f1 * 11.0F);
    localRadioButton.setPadding(i, j, i, j);
    localRadioButton.setIncludeFontPadding(false);
    return localRadioButton;
  }
  
  private void m()
  {
    if (this.t.getBusInvoiceTypeList().size() == 2) {}
    for (Object localObject = ((InvoiceAvailableInfo.BusInvoiceType)this.t.getBusInvoiceTypeList().get(1)).getMounthList(); (localObject == null) || (((ArrayList)localObject).size() < 1); localObject = ((InvoiceAvailableInfo.BusInvoiceType)this.t.getBusInvoiceTypeList().get(0)).getMounthList()) {
      return;
    }
    localObject = InvoiceMonthSelectDialog.getInstance((ArrayList)localObject);
    ((InvoiceMonthSelectDialog)localObject).setOnMonthSelectListener(new InvoiceMonthSelectDialog.a()
    {
      public void onMonthSelect(ArrayList<InvoiceAvailableInfo.MonthInfo> paramAnonymousArrayList)
      {
        FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, paramAnonymousArrayList);
        if ((paramAnonymousArrayList == null) || (paramAnonymousArrayList.size() < 1)) {
          return;
        }
        if (paramAnonymousArrayList.size() == 1) {}
        for (Object localObject = ((InvoiceAvailableInfo.MonthInfo)paramAnonymousArrayList.get(0)).getMonthNum();; localObject = ((InvoiceAvailableInfo.MonthInfo)paramAnonymousArrayList.get(0)).getMonthNum() + " - " + ((InvoiceAvailableInfo.MonthInfo)paramAnonymousArrayList.get(paramAnonymousArrayList.size() - 1)).getMonthNum())
        {
          String str = "共" + paramAnonymousArrayList.size() + "月";
          FriendlyInvoiceOpenActivity.this.mTvMonthDesc.setText((CharSequence)localObject);
          FriendlyInvoiceOpenActivity.this.mTvMonthCount.setText(str);
          FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, 0.0D);
          paramAnonymousArrayList = paramAnonymousArrayList.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            localObject = (InvoiceAvailableInfo.MonthInfo)paramAnonymousArrayList.next();
            FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this, FriendlyInvoiceOpenActivity.j(FriendlyInvoiceOpenActivity.this) + ((InvoiceAvailableInfo.MonthInfo)localObject).getMonthTaxAmount());
            FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, FriendlyInvoiceOpenActivity.k(FriendlyInvoiceOpenActivity.this) + ((InvoiceAvailableInfo.MonthInfo)localObject).getMonthAmount());
          }
        }
        paramAnonymousArrayList = new HashMap();
        paramAnonymousArrayList.put("rentAmount", Integer.valueOf((int)FriendlyInvoiceOpenActivity.k(FriendlyInvoiceOpenActivity.this)));
        paramAnonymousArrayList.put("taxPoint", Integer.valueOf(FriendlyInvoiceOpenActivity.l(FriendlyInvoiceOpenActivity.this).getTaxPoint()));
        j.getFInvoiceComputePrice(FriendlyInvoiceOpenActivity.m(FriendlyInvoiceOpenActivity.this), paramAnonymousArrayList, new d(FriendlyInvoiceOpenActivity.m(FriendlyInvoiceOpenActivity.this), new f(e.class))
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
            FriendlyInvoiceOpenActivity.c(FriendlyInvoiceOpenActivity.this, false);
          }
          
          public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
            paramAnonymous2e = paramAnonymous2e.getString("taxPrice");
            FriendlyInvoiceOpenActivity.b(FriendlyInvoiceOpenActivity.this, Double.parseDouble(paramAnonymous2e));
            FriendlyInvoiceOpenActivity.this.mTvInvoiceMonthTax.setText("¥" + FriendlyInvoiceOpenActivity.j(FriendlyInvoiceOpenActivity.this) / 100.0D);
            FriendlyInvoiceOpenActivity.c(FriendlyInvoiceOpenActivity.this, true);
          }
        });
        FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, FriendlyInvoiceOpenActivity.k(FriendlyInvoiceOpenActivity.this) / 100.0D);
        FriendlyInvoiceOpenActivity.this.mTvInvoiceMonthPrice.setText("¥" + FriendlyInvoiceOpenActivity.k(FriendlyInvoiceOpenActivity.this));
      }
    });
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (!(localObject instanceof DialogFragment))
    {
      ((InvoiceMonthSelectDialog)localObject).show(localFragmentManager, "month");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localObject, localFragmentManager, "month");
  }
  
  private void n()
  {
    InvoiceCitySelectDialog.getInstance(this.t.getRegion()).show(getSupportFragmentManager(), "city", new InvoiceCitySelectDialog.a()
    {
      public void onCitySelect(String paramAnonymousString)
      {
        FriendlyInvoiceOpenActivity.this.mTvInvoiceAddressSelect.setText(paramAnonymousString);
        FriendlyInvoiceOpenActivity.this.mTvInvoiceAddressSelect.setHintTextColor(FriendlyInvoiceOpenActivity.this.getResources().getColor(2131624417));
        FriendlyInvoiceOpenActivity.this.mTvInvoiceAddressSelect.setBackgroundResource(2130837839);
      }
    });
  }
  
  void a()
  {
    showError(this.mLlContentContainer, this.mStubError, "网络故障，");
  }
  
  void initData()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", this.s);
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this));
    localHashMap.put("type", Integer.valueOf(this.B));
    j.getFInvoiceBeforeOpen(this, localHashMap, new d(this, new f(InvoiceAvailableInfo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        FriendlyInvoiceOpenActivity.this.a();
      }
      
      public void onSuccess(int paramAnonymousInt, InvoiceAvailableInfo paramAnonymousInvoiceAvailableInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousInvoiceAvailableInfo);
        if (paramAnonymousInvoiceAvailableInfo == null) {}
        do
        {
          return;
          FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this, paramAnonymousInvoiceAvailableInfo);
        } while (FriendlyInvoiceOpenActivity.a(FriendlyInvoiceOpenActivity.this));
        FriendlyInvoiceOpenActivity.this.showEmpty(FriendlyInvoiceOpenActivity.this.mLlContentContainer, "暂无可开票信息");
      }
    });
  }
  
  public void initView()
  {
    this.mEtInvoiceIdentityNum.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!ae.isNull(VdsAgent.trackEditTextSilent(FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum).toString().trim()))
        {
          FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum.setHint("");
          FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum.setHintTextColor(FriendlyInvoiceOpenActivity.this.getResources().getColor(2131624599));
          FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum.setBackgroundResource(2130837839);
          return;
        }
        FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum.setHint("");
        FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum.setHintTextColor(FriendlyInvoiceOpenActivity.this.getResources().getColor(2131624610));
        FriendlyInvoiceOpenActivity.this.mEtInvoiceIdentityNum.setBackgroundResource(2130837840);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.mEtInvoicePhoneNum.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!ae.isNull(VdsAgent.trackEditTextSilent(FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum).toString().trim()))
        {
          FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum.setHint("");
          FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum.setHintTextColor(FriendlyInvoiceOpenActivity.this.getResources().getColor(2131624599));
          FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum.setBackgroundResource(2130837839);
          return;
        }
        FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum.setHint("");
        FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum.setHintTextColor(FriendlyInvoiceOpenActivity.this.getResources().getColor(2131624610));
        FriendlyInvoiceOpenActivity.this.mEtInvoicePhoneNum.setBackgroundResource(2130837840);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    Object localObject = getSharedPreferences("youjia_invoice_open_tips", 0);
    InvoiceOpenTipsDialog localInvoiceOpenTipsDialog;
    FragmentManager localFragmentManager;
    if (((SharedPreferences)localObject).getBoolean("isFirst", true))
    {
      localInvoiceOpenTipsDialog = InvoiceOpenTipsDialog.getInstance("开票需知", "");
      localFragmentManager = getSupportFragmentManager();
      if ((localInvoiceOpenTipsDialog instanceof DialogFragment)) {
        break label108;
      }
      localInvoiceOpenTipsDialog.show(localFragmentManager, "tips");
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("isFirst", false);
      ((SharedPreferences.Editor)localObject).commit();
      return;
      label108:
      VdsAgent.showDialogFragment((DialogFragment)localInvoiceOpenTipsDialog, localFragmentManager, "tips");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      g();
      h();
    }
  }
  
  @OnClick({2131690635, 2131690637, 2131689997, 2131690624, 2131690078, 2131696255, 2131695982})
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
    case 2131690624: 
      JsBridgeWebActivity.start(this, "", "http://zhuanti.ziroom.com/zhuanti/2017/zrk/fphelp/index.html");
      return;
    case 2131696255: 
      m();
      return;
    case 2131690635: 
      b(0);
      return;
    case 2131690637: 
      b(1);
      return;
    case 2131695982: 
      n();
      return;
    }
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = this;
    setContentView(2130903181);
    this.a = ButterKnife.bind(this);
    b();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceOpenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */