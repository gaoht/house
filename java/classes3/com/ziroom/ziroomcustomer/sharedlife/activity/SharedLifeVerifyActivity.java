package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.sharedlife.c.a.a;
import java.util.List;

public class SharedLifeVerifyActivity
  extends BaseActivity
{
  private String a;
  private SharedLifeVerifyActivity b;
  private List<a.a> c;
  @BindView(2131691139)
  EditText edt_pwd;
  @BindView(2131695949)
  TextView myinfoTvTitle;
  @BindView(2131695950)
  TextView tv_rightButton;
  
  private void a()
  {
    this.myinfoTvTitle.setText("登录密码验证");
    this.tv_rightButton.setVisibility(8);
    String str = getIntent().getStringExtra("sl_contractList");
    if (!TextUtils.isEmpty(str)) {
      this.c = com.alibaba.fastjson.a.parseArray(str, a.a.class);
    }
  }
  
  private void b()
  {
    this.a = VdsAgent.trackEditTextSilent(this.edt_pwd).toString();
    if (TextUtils.isEmpty(this.a)) {
      g.textToast(this, "密码不能为空");
    }
    String str;
    do
    {
      return;
      str = com.ziroom.commonlibrary.login.a.getToken(this);
    } while (TextUtils.isEmpty(str));
    j.delGestureLock(this, str, this.a, new com.ziroom.commonlibrary.a.a.b(this, new com.ziroom.commonlibrary.a.b.b())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
        {
          String str = paramAnonymousThrowable.getMessage();
          paramAnonymousThrowable = str;
          if (TextUtils.isEmpty(str)) {
            paramAnonymousThrowable = "错误,请稍后重试";
          }
          g.textToast(SharedLifeVerifyActivity.a(SharedLifeVerifyActivity.this), paramAnonymousThrowable);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((SharedLifeVerifyActivity.b(SharedLifeVerifyActivity.this) != null) && (SharedLifeVerifyActivity.b(SharedLifeVerifyActivity.this).size() > 0))
        {
          if (SharedLifeVerifyActivity.b(SharedLifeVerifyActivity.this).size() == 1)
          {
            paramAnonymouse = new Intent(SharedLifeVerifyActivity.a(SharedLifeVerifyActivity.this), SharedLifeEquipmentHomeActivity.class);
            paramAnonymouse.putExtra("rentContractCode", ((a.a)SharedLifeVerifyActivity.b(SharedLifeVerifyActivity.this).get(0)).getRentContractCode());
            paramAnonymouse.putExtra("villageName", ((a.a)SharedLifeVerifyActivity.b(SharedLifeVerifyActivity.this).get(0)).getVillage());
            SharedLifeVerifyActivity.this.startActivity(paramAnonymouse);
            SharedLifeVerifyActivity.this.finish();
            return;
          }
          paramAnonymouse = new Intent(SharedLifeVerifyActivity.a(SharedLifeVerifyActivity.this), SharedLifeContractActivity.class);
          paramAnonymouse.putExtra("tbRentContracts", com.alibaba.fastjson.a.toJSONString(SharedLifeVerifyActivity.b(SharedLifeVerifyActivity.this)));
          SharedLifeVerifyActivity.this.startActivity(paramAnonymouse);
          SharedLifeVerifyActivity.this.finish();
          return;
        }
        paramAnonymouse = new Intent(SharedLifeVerifyActivity.a(SharedLifeVerifyActivity.this), SharedLifeContractActivity.class);
        paramAnonymouse.putExtra("tbRentContracts", "");
        SharedLifeVerifyActivity.this.startActivity(paramAnonymouse);
        SharedLifeVerifyActivity.this.finish();
      }
    });
  }
  
  @OnClick({2131695948, 2131691140})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131695948: 
      finish();
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903251);
    ButterKnife.bind(this);
    this.b = this;
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */