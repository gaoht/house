package com.ziroom.ziroomcustomer.signed;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.d.f.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.k;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.signed.a.d;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignerPlaceActivity
  extends BaseActivity
{
  private List<d> a;
  private com.ziroom.ziroomcustomer.signed.adapter.a b;
  @BindView(2131689934)
  EditText edt_search;
  @BindView(2131692476)
  LinearLayout signerPlace_ll_search;
  @BindView(2131692478)
  ListView signerPlace_lv;
  @BindView(2131692477)
  TextView signerPlace_tv_name;
  
  private void a()
  {
    this.b.setmList(this.a);
  }
  
  public void getCompanyList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this));
    localHashMap.put("work_name", paramString);
    com.freelxl.baselibrary.d.a.get(q.O + e.k.d).tag(this).addHeader("Accept", "application/json; version=1").params(g.getPassportSign(localHashMap)).enqueue(new com.freelxl.baselibrary.d.c.a(new e())
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        u.e("SignerPlaceActivity", "onSuccess:KeyWork List: " + paramAnonymousString);
        paramAnonymousString = h.getJsonString(h.getJsonString(paramAnonymousString, "data"), "companyList");
        SignerPlaceActivity.a(SignerPlaceActivity.this, h.parseArray(paramAnonymousString, d.class));
        if ((SignerPlaceActivity.a(SignerPlaceActivity.this) != null) && (SignerPlaceActivity.a(SignerPlaceActivity.this).size() > 0))
        {
          SignerPlaceActivity.b(SignerPlaceActivity.this);
          return;
        }
        SignerPlaceActivity.b(SignerPlaceActivity.this);
        SignerPlaceActivity.this.signerPlace_ll_search.setVisibility(0);
        ah.setTextColor(SignerPlaceActivity.this.signerPlace_tv_name, "没有找到结果，点击添加", "没有找到结果，点击添加".length() - 4, 4);
        SignerPlaceActivity.this.signerPlace_tv_name.setTag("" + VdsAgent.trackEditTextSilent(SignerPlaceActivity.this.edt_search).toString());
      }
    });
  }
  
  @OnClick({2131692475, 2131692476})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692476: 
      paramView = new Intent();
      paramView.putExtra("signerPlace", this.signerPlace_tv_name.getTag().toString());
      paramView.putExtra("signerPlaceType", 1);
      setResult(200, paramView);
      finish();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903505);
    ButterKnife.bind(this);
    this.b = new com.ziroom.ziroomcustomer.signed.adapter.a(this, null);
    this.signerPlace_lv.setAdapter(this.b);
    this.edt_search.addTextChangedListener(new TextWatcher()
    {
      private String b;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (TextUtils.isEmpty(paramAnonymousEditable.toString())) {
          SignerPlaceActivity.this.signerPlace_ll_search.setVisibility(8);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence.toString();
        SignerPlaceActivity.this.getCompanyList(this.b);
      }
    });
    this.signerPlace_lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.putExtra("signerPlace", com.alibaba.fastjson.a.toJSONString(SignerPlaceActivity.a(SignerPlaceActivity.this).get(paramAnonymousInt)));
        paramAnonymousAdapterView.putExtra("signerPlaceType", 2);
        SignerPlaceActivity.this.setResult(200, paramAnonymousAdapterView);
        SignerPlaceActivity.this.finish();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerPlaceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */