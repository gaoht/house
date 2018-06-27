package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class EnterprisePaySuccessActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  @BindView(2131690549)
  TextView back;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  @BindView(2131689492)
  ImageView iv_back;
  private a r;
  @BindView(2131690552)
  TextView tv_complete;
  @BindView(2131690551)
  TextView tv_pay_money;
  @BindView(2131690550)
  TextView tv_price_item;
  
  private void a()
  {
    if (ae.notNull(this.g)) {
      return;
    }
    j.getSignInfo(this, this.e, new com.ziroom.ziroomcustomer.e.a.e(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("is_display")) && (paramAnonymouse.getInteger("is_display").intValue() == 1) && (paramAnonymouse.containsKey("popup")))
        {
          String str = paramAnonymouse.getString("popup");
          if (!TextUtils.isEmpty(str)) {
            h.creatDialog(this.e, str, false, true, paramAnonymouse.get("skipUrl") + "", null, new h.a()
            {
              public void closeDialog() {}
              
              public void toMoveHouseWeb(String paramAnonymous2String)
              {
                if (ae.notNull(paramAnonymous2String)) {
                  JsBridgeWebActivity.start(EnterprisePaySuccessActivity.this, null, paramAnonymous2String);
                }
              }
            });
          }
        }
      }
    });
    this.r = new a(2000L, 1000L);
    this.r.start();
  }
  
  public void onBackPressed() {}
  
  @OnClick({2131689492, 2131690552, 2131690549})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690549: 
      paramView = new Intent(this, MainActivity.class);
      paramView.putExtra("FRAGMENT_TYPE", 7);
      startActivity(paramView);
      finish();
      return;
    case 2131689492: 
      finish();
      return;
    }
    if ("支付剩余款项".equals(((TextView)paramView).getText().toString()))
    {
      paramView = new Intent(this, HouseBillInfoActivity.class);
      paramView.putExtra("uniqueCode", this.e);
      paramView.putExtra("period", "1");
      paramView.putExtra("payType", "fz");
      if (this.g != null) {
        paramView.putExtra("old_contract_code", this.g);
      }
      startActivityAndFinish(paramView);
      return;
    }
    paramView = new Intent(this.b, NewLeaseInfoActivity.class);
    paramView.putExtra("contract_code", this.e);
    paramView.putExtra("className", "EnterprisePaySuccessActivity");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903168);
    this.b = this;
    this.a = ButterKnife.bind(this);
    this.c = getIntent().getStringExtra("is_all");
    this.d = getIntent().getStringExtra("sub_amount");
    this.e = getIntent().getStringExtra("contract_code");
    this.f = getIntent().getStringExtra("mCityCode");
    this.g = getIntent().getStringExtra("old_contract_code");
    if ("1".equals(this.c))
    {
      a();
      this.tv_complete.setText("查看合同详情");
    }
    for (;;)
    {
      this.tv_pay_money.setText("￥" + this.d);
      return;
      this.tv_complete.setText("支付剩余款项");
    }
  }
  
  class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      com.freelxl.baselibrary.d.a.cancel(EnterprisePaySuccessActivity.this);
      u.e("关闭", "关闭请求");
    }
    
    public void onTick(long paramLong)
    {
      u.e("关闭", paramLong + "后关闭请求");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/EnterprisePaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */