package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponInfoBean;
import com.ziroom.ziroomcustomer.minsu.e.a;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuCouponActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private EditText a;
  private TextView b;
  private String c;
  private String d;
  private String e;
  private int f;
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131691276));
    this.b.setOnClickListener(this);
    this.a = ((EditText)findViewById(2131691275));
    this.a.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        MinsuCouponActivity.a(MinsuCouponActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void b()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setLeftButtonType(4);
    localCommonTitle.setBottomLineVisible(false);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCouponActivity.this.finish();
      }
    });
    localCommonTitle.showRightText(false, null);
  }
  
  private void e()
  {
    v.onClick(this, "M-Exchange_coupon");
    String str = VdsAgent.trackEditTextSilent(this.a).toString();
    if (c.isNull(str))
    {
      showToast("优惠券号不能为空哦！");
      return;
    }
    a.checkCoupon(this, str, this.c, this.f, this.d, this.e, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        d.e("lanzhihong", "str======" + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuCouponInfoBean localMinsuCouponInfoBean = (MinsuCouponInfoBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuCouponInfoBean != null) && (localMinsuCouponInfoBean.checkSuccess(MinsuCouponActivity.this)))
        {
          d.e("lanzhihong", "ro======" + localMinsuCouponInfoBean.toString());
          MinsuCouponActivity.this.showToast("兑换成功!");
          MinsuCouponActivity.this.finish();
          return;
        }
        if (localMinsuCouponInfoBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuCouponInfoBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void f()
  {
    if ((this.b == null) || (this.a == null)) {
      return;
    }
    boolean bool;
    if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.a).toString()))
    {
      bool = true;
      this.b.setEnabled(bool);
      if (!bool) {
        break label71;
      }
    }
    label71:
    for (int i = 2131624475;; i = 2131624046)
    {
      this.b.setBackgroundColor(ApplicationEx.c.getResources().getColor(i));
      return;
      bool = false;
      break;
    }
  }
  
  public void finish()
  {
    super.finish();
    com.ziroom.ziroomcustomer.minsu.f.k.animFinishAlpha(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903266);
    this.c = getIntent().getStringExtra("fid");
    this.f = getIntent().getIntExtra("rentWay", 0);
    this.d = getIntent().getStringExtra("startTime");
    this.e = getIntent().getStringExtra("endTime");
    b();
    a();
  }
  
  protected void onResume()
  {
    super.onResume();
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */