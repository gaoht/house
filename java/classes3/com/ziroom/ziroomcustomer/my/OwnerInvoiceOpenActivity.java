package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.h;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OIOpenModel;
import com.ziroom.ziroomcustomer.my.model.OIOpenModel.InvoiceTypeBean;
import com.ziroom.ziroomcustomer.my.model.OIOpenModel.TypeListBean;
import com.ziroom.ziroomcustomer.my.widget.InvoiceTextView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import java.util.List;

public class OwnerInvoiceOpenActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  private String b = OwnerInvoiceOpenActivity.class.getSimpleName();
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131690636)
  ImageView cbCompany;
  @BindView(2131690638)
  ImageView cbPersonal;
  private Context d;
  private int e = -1;
  @BindView(2131690641)
  EditText etInvoiceIdentityNum;
  @BindView(2131692010)
  EditText etInvoicePhoneNum;
  private int f = -1;
  @BindView(2131690631)
  FlowLayout flInvoiceType;
  private OIOpenModel g;
  @BindView(2131690635)
  LinearLayout llCompany;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131690640)
  LinearLayout llInvoiceIdentityContainer;
  @BindView(2131690637)
  LinearLayout llPersonal;
  @BindView(2131692009)
  LinearLayout llSeePriceDetail;
  private boolean r = false;
  private boolean s = false;
  @BindView(2131690620)
  ViewStub stubError;
  private String t;
  @BindView(2131692008)
  TextView tvInvoiceContent;
  @BindView(2131690609)
  TextView tvInvoiceDetailDesc;
  @BindView(2131692006)
  TextView tvInvoiceOpenDesc;
  @BindView(2131690644)
  TextView tvInvoicePrice;
  @BindView(2131690639)
  TextView tvInvoiceTopName;
  @BindView(2131692007)
  TextView tvInvoiceTypeDesc;
  @BindView(2131689997)
  TextView tvSubmit;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131690624)
  TextView tvTopRight;
  private String u;
  private String v;
  private String w;
  private String x;
  
  private void a(List<OIOpenModel.TypeListBean> paramList)
  {
    if (!i.isLegal(paramList)) {}
    int i;
    OIOpenModel.TypeListBean localTypeListBean;
    for (;;)
    {
      return;
      this.flInvoiceType.removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = 0;
        while (i < paramList.size())
        {
          localTypeListBean = (OIOpenModel.TypeListBean)paramList.get(i);
          if (!TextUtils.isEmpty(localTypeListBean.name)) {
            break label70;
          }
          i += 1;
        }
      }
    }
    label70:
    InvoiceTextView localInvoiceTextView = new InvoiceTextView(this);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this, 34.0F));
    int j = n.dip2px(this, 6.0F);
    if (i == 0) {
      localMarginLayoutParams.setMargins(0, 0, 0, j);
    }
    for (;;)
    {
      localInvoiceTextView.setLayoutParams(localMarginLayoutParams);
      j = n.dip2px(this, 12.0F);
      localInvoiceTextView.setPadding(j, 0, j, 0);
      localInvoiceTextView.setGravity(16);
      localInvoiceTextView.setTagBean(localTypeListBean);
      localInvoiceTextView.setTag(2);
      localInvoiceTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (InvoiceTextView)paramAnonymousView;
          if ((paramAnonymousView.getCurTag() != 0) && (OwnerInvoiceOpenActivity.g(OwnerInvoiceOpenActivity.this) != paramAnonymousView.getTagBean().code))
          {
            OwnerInvoiceOpenActivity.a(OwnerInvoiceOpenActivity.this, paramAnonymousView.getTagBean().code);
            OwnerInvoiceOpenActivity.h(OwnerInvoiceOpenActivity.this);
          }
          while (paramAnonymousView.getCurTag() != 0) {
            return;
          }
          af.showToast(OwnerInvoiceOpenActivity.this, "线上暂未开通此发票类型，开具请拨打电话");
        }
      });
      this.flInvoiceType.addView(localInvoiceTextView);
      this.flInvoiceType.requestLayout();
      break;
      localMarginLayoutParams.setMargins(j * 2, 0, 0, j);
    }
  }
  
  private void b()
  {
    this.u = getIntent().getStringExtra("hireContractCode");
    this.v = getIntent().getStringExtra("beautyContractCode");
    this.w = getIntent().getStringExtra("feeCode");
    this.x = getIntent().getStringExtra("applyCode");
  }
  
  private void e()
  {
    f();
    a(this.g.invoiceType.typeList);
    this.tvInvoiceTopName.setText(this.g.titleName);
    this.tvInvoiceContent.setText(this.g.feeName);
    this.tvInvoicePrice.setText("" + this.g.amount);
    if (ae.isNull(this.g.phone))
    {
      this.s = false;
      return;
    }
    this.etInvoicePhoneNum.setText(this.g.phone);
    this.s = true;
  }
  
  private void f()
  {
    if (ae.isNull(this.g.topTip)) {
      this.tvInvoiceOpenDesc.setVisibility(8);
    }
    for (;;)
    {
      if (!ae.isNull(this.g.invoiceType.tip)) {
        this.tvInvoiceTypeDesc.setText(this.g.invoiceType.tip);
      }
      return;
      this.tvInvoiceOpenDesc.setVisibility(0);
      this.tvInvoiceOpenDesc.setText(this.g.topTip);
    }
  }
  
  private void g()
  {
    if (this.e == -1) {
      af.showToast(this, "请选择抬头类型");
    }
    do
    {
      return;
      if (this.f == -1)
      {
        af.showToast(this, "请选择发票类型");
        return;
      }
      if (this.e != 1) {
        break;
      }
      if ((!ae.isNull(VdsAgent.trackEditTextSilent(this.etInvoiceIdentityNum).toString())) && (!ae.isNull(VdsAgent.trackEditTextSilent(this.etInvoicePhoneNum).toString()))) {
        break label254;
      }
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.etInvoiceIdentityNum).toString()))
      {
        af.showToast(this, "纳税人识别号不能为空");
        this.etInvoiceIdentityNum.setHint("");
        this.etInvoiceIdentityNum.setHintTextColor(getResources().getColor(2131624610));
        this.etInvoiceIdentityNum.setBackgroundResource(2130837840);
      }
    } while (!ae.isNull(VdsAgent.trackEditTextSilent(this.etInvoicePhoneNum).toString()));
    af.showToast(this, "手机号不能为空");
    this.etInvoicePhoneNum.setHint("");
    this.etInvoicePhoneNum.setHintTextColor(getResources().getColor(2131624610));
    this.etInvoicePhoneNum.setBackgroundResource(2130837840);
    return;
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etInvoicePhoneNum).toString()))
    {
      af.showToast(this, "手机号不能为空");
      this.etInvoicePhoneNum.setHint("");
      this.etInvoicePhoneNum.setHintTextColor(getResources().getColor(2131624610));
      this.etInvoicePhoneNum.setBackgroundResource(2130837840);
      return;
    }
    label254:
    if ((this.e == 1) && (!ah.isTaxpayerNum(VdsAgent.trackEditTextSilent(this.etInvoiceIdentityNum).toString().trim())))
    {
      af.showToast(this, "纳税人识别号错误，请重新填写");
      return;
    }
    if (!ah.isMobile(VdsAgent.trackEditTextSilent(this.etInvoicePhoneNum).toString().trim()))
    {
      af.showToast(this, "手机号错误，请重新填写");
      return;
    }
    d.newBuilder(this.d).setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        OwnerInvoiceOpenActivity.c(OwnerInvoiceOpenActivity.this);
      }
    }).setTitle("温馨提示").setContent("您确定填写信息都正确吗？\n发票一旦开具将无法修改").setButtonText("取消", "确定").show();
  }
  
  private void h()
  {
    j.openInvoice(this, com.ziroom.ziroomcustomer.e.g.buildOpenInvoice(this.t, this.u, this.v, this.e, VdsAgent.trackEditTextSilent(this.etInvoiceIdentityNum).toString().trim(), VdsAgent.trackEditTextSilent(this.etInvoicePhoneNum).toString().trim(), this.w, this.f), new f(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        af.showToast(OwnerInvoiceOpenActivity.this, paramAnonymousThrowable.getMessage());
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.logBigData(OwnerInvoiceOpenActivity.a(OwnerInvoiceOpenActivity.this), "===ymq:" + paramAnonymouse.toString());
        String str1 = paramAnonymouse.getString("status");
        String str2 = paramAnonymouse.getString("code");
        if (("success".equals(str1)) && ("200".equals(str2)))
        {
          paramAnonymouse = new Intent(OwnerInvoiceOpenActivity.this, OwnerInvoiceSubmitSuccActivity.class);
          paramAnonymouse.putExtra("beautyContractCode", OwnerInvoiceOpenActivity.d(OwnerInvoiceOpenActivity.this));
          paramAnonymouse.putExtra("hireContractCode", OwnerInvoiceOpenActivity.e(OwnerInvoiceOpenActivity.this));
          paramAnonymouse.putExtra("applyCode", OwnerInvoiceOpenActivity.f(OwnerInvoiceOpenActivity.this));
          OwnerInvoiceOpenActivity.this.startActivity(paramAnonymouse);
          return;
        }
        af.showToast(OwnerInvoiceOpenActivity.this, paramAnonymouse.getString("message"));
      }
    });
  }
  
  private void i()
  {
    if (this.e != 1)
    {
      this.e = 1;
      k();
      this.llInvoiceIdentityContainer.setVisibility(0);
      this.cbCompany.setImageResource(2130840182);
      this.cbPersonal.setImageResource(2130840185);
    }
  }
  
  private void j()
  {
    if (this.e != 2)
    {
      this.e = 2;
      k();
      this.llInvoiceIdentityContainer.setVisibility(8);
      this.cbCompany.setImageResource(2130840185);
      this.cbPersonal.setImageResource(2130840182);
    }
  }
  
  private void k()
  {
    int i = 0;
    if (i < this.flInvoiceType.getChildCount())
    {
      InvoiceTextView localInvoiceTextView = (InvoiceTextView)this.flInvoiceType.getChildAt(i);
      switch (this.e)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localInvoiceTextView.setTag(2);
        if (this.f == localInvoiceTextView.getTagBean().code)
        {
          localInvoiceTextView.setTag(1);
        }
        else
        {
          localInvoiceTextView.setTag(2);
          continue;
          if (localInvoiceTextView.getTagBean().companyChoose)
          {
            if (this.f == localInvoiceTextView.getTagBean().code) {
              localInvoiceTextView.setTag(1);
            } else {
              localInvoiceTextView.setTag(2);
            }
          }
          else if (this.f == localInvoiceTextView.getTagBean().code)
          {
            localInvoiceTextView.setTag(0);
            this.f = -1;
          }
          else
          {
            localInvoiceTextView.setTag(0);
            continue;
            if (localInvoiceTextView.getTagBean().personChoose)
            {
              if (this.f == localInvoiceTextView.getTagBean().code) {
                localInvoiceTextView.setTag(1);
              } else {
                localInvoiceTextView.setTag(2);
              }
            }
            else if (this.f == localInvoiceTextView.getTagBean().code)
            {
              localInvoiceTextView.setTag(0);
              this.f = -1;
            }
            else
            {
              localInvoiceTextView.setTag(0);
            }
          }
        }
      }
    }
  }
  
  void a()
  {
    showError(this.llContentContainer, this.stubError, "网络故障，");
  }
  
  public void initData()
  {
    if (ApplicationEx.c.getUser() != null) {
      this.t = ApplicationEx.c.getUser().getUid();
    }
    for (;;)
    {
      j.getInvoiceBeforeOpen(this, com.ziroom.ziroomcustomer.e.g.buildInvoiceBeforeOpen(this.t, this.u, this.v, this.w), new f(this, new h())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          OwnerInvoiceOpenActivity.this.c.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(OwnerInvoiceOpenActivity.a(OwnerInvoiceOpenActivity.this), "===ymq:" + paramAnonymouse.toString());
            OwnerInvoiceOpenActivity.a(OwnerInvoiceOpenActivity.this, (OIOpenModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), OIOpenModel.class));
            if (OwnerInvoiceOpenActivity.this.stubError.getVisibility() == 0) {
              OwnerInvoiceOpenActivity.this.closeError(OwnerInvoiceOpenActivity.this.llContentContainer, OwnerInvoiceOpenActivity.this.stubError);
            }
            OwnerInvoiceOpenActivity.b(OwnerInvoiceOpenActivity.this);
            return;
          }
          OwnerInvoiceOpenActivity.this.c.sendEmptyMessage(0);
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  public void initView()
  {
    this.etInvoiceIdentityNum.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!ae.isNull(VdsAgent.trackEditTextSilent(OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum).toString().trim()))
        {
          OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum.setHint("");
          OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum.setHintTextColor(OwnerInvoiceOpenActivity.this.getResources().getColor(2131624599));
          OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum.setBackgroundResource(2130837839);
          return;
        }
        OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum.setHint("");
        OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum.setHintTextColor(OwnerInvoiceOpenActivity.this.getResources().getColor(2131624610));
        OwnerInvoiceOpenActivity.this.etInvoiceIdentityNum.setBackgroundResource(2130837840);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.etInvoicePhoneNum.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!ae.isNull(VdsAgent.trackEditTextSilent(OwnerInvoiceOpenActivity.this.etInvoicePhoneNum).toString().trim()))
        {
          OwnerInvoiceOpenActivity.this.etInvoicePhoneNum.setHint("");
          OwnerInvoiceOpenActivity.this.etInvoicePhoneNum.setHintTextColor(OwnerInvoiceOpenActivity.this.getResources().getColor(2131624599));
          OwnerInvoiceOpenActivity.this.etInvoicePhoneNum.setBackgroundResource(2130837839);
          return;
        }
        OwnerInvoiceOpenActivity.this.etInvoicePhoneNum.setHint("");
        OwnerInvoiceOpenActivity.this.etInvoicePhoneNum.setHintTextColor(OwnerInvoiceOpenActivity.this.getResources().getColor(2131624610));
        OwnerInvoiceOpenActivity.this.etInvoicePhoneNum.setBackgroundResource(2130837840);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = this;
    setContentView(2130903410);
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
  
  @OnClick({2131690078, 2131690624, 2131690635, 2131690637, 2131692009, 2131689997})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    case 2131690624: 
      startActivity(new Intent(this, OwnerInvoiceExampleActivity.class));
      return;
    case 2131690635: 
      i();
      return;
    case 2131690637: 
      j();
      return;
    case 2131692009: 
      paramView = new Intent(this, OwnerInvoicePriceListActivity.class);
      paramView.putExtra("beautyContractCode", this.v);
      paramView.putExtra("feeCode", this.w);
      startActivity(paramView);
      return;
    }
    g();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceOpenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */