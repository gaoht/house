package com.ziroom.ziroomcustomer.minsu.activity;

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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.ContactVosBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsSaveResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsUpdateResultBean;
import com.ziroom.ziroomcustomer.minsu.dialog.b.a;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MinsuCustomerDetailsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  MinsuContactsListBean.ListUsualContactBean a;
  i b;
  private com.ziroom.ziroomcustomer.minsu.dialog.b<com.ziroom.ziroomcustomer.minsu.b.a> c;
  @BindView(2131691206)
  TextView commit;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691281)
  TextView customerCerType;
  @BindView(2131691282)
  EditText customerCerValue;
  @BindView(2131691280)
  EditText customerName;
  @BindView(2131691283)
  EditText customerPhoneValue;
  private com.ziroom.ziroomcustomer.minsu.b.a d;
  private List<String> e;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    this.a = ((MinsuContactsListBean.ListUsualContactBean)getIntent().getSerializableExtra("data"));
    if (this.a != null)
    {
      this.d = com.ziroom.ziroomcustomer.minsu.b.a.getCerType(this.a.cardType);
      this.tvTitle.setText("编辑入住人");
      return;
    }
    this.tvTitle.setText("添加入住人");
  }
  
  private void b()
  {
    initTitle();
    if (this.a != null)
    {
      this.customerName.setText(this.a.conName);
      this.customerCerType.setText(com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(this, this.a.cardType));
      this.customerCerValue.setText(this.a.cardValue);
      this.customerPhoneValue.setText(this.a.conTel);
    }
    e();
    TextWatcher local1 = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        MinsuCustomerDetailsActivity.this.updateSelectStatus();
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.customerName.addTextChangedListener(local1);
    this.customerCerType.addTextChangedListener(local1);
    this.customerCerValue.addTextChangedListener(local1);
    this.customerPhoneValue.addTextChangedListener(local1);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        MinsuCustomerDetailsActivity.this.commonTitle.setBottomLineAlpha(f);
      }
    });
  }
  
  private boolean d(String paramString)
  {
    switch (2.a[this.d.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
          paramString = new com.ziroom.ziroomcustomer.minsu.f.b().IDCardValidate(paramString);
        } while (TextUtils.isEmpty(paramString));
        g.textToast(this, paramString);
        return true;
      } while (com.ziroom.ziroomcustomer.minsu.f.b.checkId(paramString));
      g.textToast(this, getString(2131296618));
      return true;
    } while (c.isTaiwanCard(paramString));
    g.textToast(this, getString(2131296618));
    return true;
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.a);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.b);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.d);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.e);
    this.c = new com.ziroom.ziroomcustomer.minsu.dialog.b(this, new com.freelxl.baselibrary.a.a(this, localArrayList, 2130904541)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, com.ziroom.ziroomcustomer.minsu.b.a paramAnonymousa)
      {
        paramAnonymousb.setText(2131695219, com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(MinsuCustomerDetailsActivity.this, paramAnonymousa.getKey()));
      }
    }, null);
    this.c.setCallBack(new b.a()
    {
      public void onSelect(com.ziroom.ziroomcustomer.minsu.b.a paramAnonymousa)
      {
        MinsuCustomerDetailsActivity.a(MinsuCustomerDetailsActivity.this, paramAnonymousa);
        MinsuCustomerDetailsActivity.this.customerCerType.setText(MinsuCustomerDetailsActivity.this.getString(MinsuCustomerDetailsActivity.a(MinsuCustomerDetailsActivity.this).getValue()));
      }
    });
  }
  
  private void f()
  {
    ContactVosBean localContactVosBean = new ContactVosBean();
    Object localObject1 = VdsAgent.trackEditTextSilent(this.customerName).toString();
    if (f.isNull((String)localObject1)) {
      showToast(getString(2131297276));
    }
    Object localObject2;
    do
    {
      return;
      if (c.isNull(this.d))
      {
        showToast(getString(2131296626));
        return;
      }
      localObject2 = VdsAgent.trackEditTextSilent(this.customerCerValue).toString();
      if (f.isNull((String)localObject2))
      {
        showToast(getString(2131296619));
        return;
      }
    } while (d((String)localObject2));
    String str = VdsAgent.trackEditTextSilent(this.customerPhoneValue).toString();
    if ((c.isNull(str)) || (!c.isMobile(str)))
    {
      showToast(getString(2131296623));
      return;
    }
    localContactVosBean.conName = ((String)localObject1);
    localContactVosBean.cardType = this.d.getKey();
    localContactVosBean.cardValue = ((String)localObject2);
    localContactVosBean.userUid = null;
    localContactVosBean.conTel = str;
    if (this.a != null) {
      localContactVosBean.fid = this.a.fid;
    }
    localObject1 = g();
    if (this.a == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(localContactVosBean);
      com.ziroom.ziroomcustomer.minsu.e.a.saveContacts(this, (List)localObject2, (i.a)localObject1);
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.updateContacts(this, localContactVosBean, (i.a)localObject1);
  }
  
  private i.a g()
  {
    if (this.a == null) {
      new i.a()
      {
        public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
        
        public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
        {
          MinsuContactsSaveResultBean localMinsuContactsSaveResultBean = (MinsuContactsSaveResultBean)paramAnonymousk.getObject();
          StringBuilder localStringBuilder = new StringBuilder().append("-----");
          if (localMinsuContactsSaveResultBean == null) {}
          for (String str = "null";; str = localMinsuContactsSaveResultBean.toString())
          {
            d.e("lanzhihong", str);
            if ((!paramAnonymousk.getSuccess().booleanValue()) || (!localMinsuContactsSaveResultBean.checkSuccess(MinsuCustomerDetailsActivity.this)) || (localMinsuContactsSaveResultBean.data == null)) {
              break;
            }
            MinsuCustomerDetailsActivity.this.showToast(MinsuCustomerDetailsActivity.this.getString(2131297497));
            MinsuCustomerDetailsActivity.this.setResult(-1);
            MinsuCustomerDetailsActivity.this.finish();
            return;
          }
          if (localMinsuContactsSaveResultBean == null) {}
          for (paramAnonymousk = "";; paramAnonymousk = localMinsuContactsSaveResultBean.message)
          {
            ad.shouErrorMessage(paramAnonymousk);
            return;
          }
        }
      };
    }
    new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuContactsUpdateResultBean localMinsuContactsUpdateResultBean = (MinsuContactsUpdateResultBean)paramAnonymousk.getObject();
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        if (localMinsuContactsUpdateResultBean == null) {}
        for (String str = "null";; str = localMinsuContactsUpdateResultBean.toString())
        {
          d.e("lanzhihong", str);
          if ((!paramAnonymousk.getSuccess().booleanValue()) || (!localMinsuContactsUpdateResultBean.checkSuccess(MinsuCustomerDetailsActivity.this)) || (localMinsuContactsUpdateResultBean.data == null)) {
            break;
          }
          MinsuCustomerDetailsActivity.this.showToast(MinsuCustomerDetailsActivity.this.getString(2131297497));
          MinsuCustomerDetailsActivity.this.setResult(-1);
          MinsuCustomerDetailsActivity.this.finish();
          return;
        }
        if (localMinsuContactsUpdateResultBean == null) {}
        for (paramAnonymousk = "";; paramAnonymousk = localMinsuContactsUpdateResultBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    };
  }
  
  private void h()
  {
    if (ad.isKeyboardShown(findViewById(2131691279)))
    {
      ad.hideSoftInput(this);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          i locali = MinsuCustomerDetailsActivity.this.b;
          View localView = MinsuCustomerDetailsActivity.this.getWindow().getDecorView();
          if (!(locali instanceof PopupWindow))
          {
            locali.showAtLocation(localView, 80, 0, 0);
            return;
          }
          VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
        }
      }, 250L);
      return;
    }
    i locali = this.b;
    View localView = getWindow().getDecorView();
    if (!(locali instanceof PopupWindow))
    {
      locali.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
  }
  
  private void i()
  {
    this.e = new ArrayList();
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.a.getValue()));
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.b.getValue()));
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.d.getValue()));
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.e.getValue()));
    this.b = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuCustomerDetailsActivity.this.b.dismiss();
        MinsuCustomerDetailsActivity.a(MinsuCustomerDetailsActivity.this, com.ziroom.ziroomcustomer.minsu.b.a.getCerType((String)MinsuCustomerDetailsActivity.b(MinsuCustomerDetailsActivity.this).get(paramAnonymousInt)));
        MinsuCustomerDetailsActivity.this.customerCerType.setText(MinsuCustomerDetailsActivity.this.getString(MinsuCustomerDetailsActivity.a(MinsuCustomerDetailsActivity.this).getValue()));
      }
    }, this.e);
  }
  
  public void finish()
  {
    super.finish();
    com.ziroom.ziroomcustomer.minsu.f.k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.commonTitle = ((CommonTitle)findViewById(2131691272));
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCustomerDetailsActivity.this.finish();
      }
    });
  }
  
  @OnClick({2131691204, 2131691206})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131691205: 
    default: 
      return;
    case 2131691204: 
      h();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903269);
    ButterKnife.bind(this);
    a();
    b();
    i();
  }
  
  protected void onResume()
  {
    super.onResume();
    updateSelectStatus();
  }
  
  public String stringFilter(String paramString)
    throws PatternSyntaxException
  {
    return Pattern.compile("[^a-zA-Z0-9一-龥]").matcher(paramString).replaceAll("").trim();
  }
  
  public void updateSelectStatus()
  {
    boolean bool2 = false;
    if (this.commit == null) {
      return;
    }
    boolean bool1 = true;
    if (f.isNull(VdsAgent.trackEditTextSilent(this.customerName).toString())) {
      bool1 = false;
    }
    if (c.isNull(this.d)) {
      bool1 = false;
    }
    if (f.isNull(VdsAgent.trackEditTextSilent(this.customerCerValue).toString())) {
      bool1 = false;
    }
    if (c.isNull(VdsAgent.trackEditTextSilent(this.customerPhoneValue).toString())) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {}
      for (int i = 2131624475;; i = 2131624046)
      {
        this.commit.setEnabled(bool1);
        this.commit.setBackgroundColor(ApplicationEx.c.getResources().getColor(i));
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCustomerDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */