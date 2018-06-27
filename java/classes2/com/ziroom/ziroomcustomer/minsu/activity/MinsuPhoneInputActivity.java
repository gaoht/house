package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactInfoBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactInfoBean.DataBean.AreaListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactInfoBean.DataBean.AreaListBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.f.q;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification.MinsuQAVCodeActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MinsuPhoneInputActivity
  extends BaseActivity
{
  private List<String> a = new ArrayList();
  private List<MinsuContactInfoBean.DataBean.AreaListBean.ListBean> b = new ArrayList();
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a c;
  private HashMap<String, String> d = new HashMap();
  private Unbinder e;
  @BindView(2131691645)
  EditText et_customer_mobile;
  private String f;
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131691644)
  TextView nationCode;
  @BindView(2131691641)
  TextView nationName;
  
  private void a()
  {
    this.et_customer_mobile.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() == 0)
        {
          MinsuPhoneInputActivity.this.mBtnSubmit.setEnabled(false);
          return;
        }
        MinsuPhoneInputActivity.this.mBtnSubmit.setEnabled(true);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getContactInfo(this, new s(this, new r(MinsuContactInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuContactInfoBean paramAnonymousMinsuContactInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuContactInfoBean);
        if (!paramAnonymousMinsuContactInfoBean.checkSuccess(MinsuPhoneInputActivity.this)) {}
        while ((paramAnonymousMinsuContactInfoBean == null) || (paramAnonymousMinsuContactInfoBean.getData() == null)) {
          return;
        }
        MinsuPhoneInputActivity.this.nationName.setText(paramAnonymousMinsuContactInfoBean.getData().getNationName());
        MinsuPhoneInputActivity.a(MinsuPhoneInputActivity.this, paramAnonymousMinsuContactInfoBean.getData().getNationCode());
        MinsuPhoneInputActivity.this.nationCode.setText("+" + MinsuPhoneInputActivity.a(MinsuPhoneInputActivity.this));
        MinsuPhoneInputActivity.this.et_customer_mobile.setText(paramAnonymousMinsuContactInfoBean.getData().getCustomerMobile());
        MinsuPhoneInputActivity.a(MinsuPhoneInputActivity.this, paramAnonymousMinsuContactInfoBean.getData().getAreaList().getList());
        MinsuPhoneInputActivity.b(MinsuPhoneInputActivity.this);
      }
    });
  }
  
  private void e()
  {
    this.a.clear();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      MinsuContactInfoBean.DataBean.AreaListBean.ListBean localListBean = (MinsuContactInfoBean.DataBean.AreaListBean.ListBean)localIterator.next();
      this.a.add(localListBean.getText());
      this.d.put(localListBean.getText(), localListBean.getValue());
    }
    this.c = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this, "", new a.b()
    {
      public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
      {
        paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
        MinsuPhoneInputActivity.this.nationName.setText(paramAnonymousHashMap);
        MinsuPhoneInputActivity.this.nationCode.setText("+" + (String)MinsuPhoneInputActivity.c(MinsuPhoneInputActivity.this).get(paramAnonymousHashMap));
        MinsuPhoneInputActivity.a(MinsuPhoneInputActivity.this, (String)MinsuPhoneInputActivity.c(MinsuPhoneInputActivity.this).get(paramAnonymousHashMap));
      }
    }, new List[] { this.a });
  }
  
  private void f()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText(getString(2131297517));
    localCommonTitle.setLeftButtonType(0);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuPhoneInputActivity.this.finish();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
      return;
    }
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903323);
    this.e = ButterKnife.bind(this);
    f();
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.e.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131689816, 2131691639})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = VdsAgent.trackEditTextSilent(this.et_customer_mobile).toString();
      if ("86".equals(this.f))
      {
        if (h.isMobile(paramView))
        {
          Intent localIntent = new Intent(this, MinsuQAVCodeActivity.class);
          localIntent.putExtra("phone", paramView);
          localIntent.putExtra("areaCode", (String)this.d.get(this.nationName.getText().toString()));
          startActivity(localIntent);
          return;
        }
        g.textToast(this, getString(2131296950));
        return;
      }
      if (TextUtils.isEmpty(this.f))
      {
        g.textToast(this, "请选择国家/地区");
        return;
      }
      com.ziroom.ziroomcustomer.minsu.e.a.validateSmsCode(this, paramView, "", this.f, new s(this, new q())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousString);
          MinsuPhoneInputActivity.this.finish();
        }
      });
      return;
    } while (this.c == null);
    this.c.show();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPhoneInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */