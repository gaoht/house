package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
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
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class OwnerContractConfirmActivity
  extends BaseActivity
{
  private static final String a = OwnerContractConfirmActivity.class.getSimpleName();
  private Unbinder b;
  @BindView(2131691101)
  Button btnBottom;
  private int c;
  private boolean d = false;
  private String e = "";
  private String f = "";
  @BindView(2131691866)
  FrameLayout flFrag;
  private String g = "";
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131691993)
  ImageView ivConfirmStep1;
  @BindView(2131691995)
  ImageView ivConfirmStep2;
  @BindView(2131691997)
  ImageView ivConfirmStep3;
  @BindView(2131691992)
  LinearLayout llConfirmStep1;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  private String r = "";
  private FragmentManager s;
  @BindView(2131690620)
  ViewStub stubError;
  private OCContractInfoFragment t;
  @BindView(2131691994)
  TextView tvConfirmStep1;
  @BindView(2131691996)
  TextView tvConfirmStep2;
  @BindView(2131691998)
  TextView tvConfirmStep3;
  @BindView(2131691990)
  TextView tvContactKeeper;
  @BindView(2131691991)
  TextView tvTopTips;
  private OCContractInfoFragment u;
  private OCContractItemFragment v;
  @BindView(2131690678)
  View viewLine;
  private OwnerConfirmContractBean w;
  private int x = 0;
  private Handler y = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      OwnerContractConfirmActivity.a(OwnerContractConfirmActivity.this, "网络故障，");
    }
  };
  
  private void b()
  {
    this.x = getIntent().getIntExtra("isLoan", 0);
    this.r = getIntent().getStringExtra("contractCode");
  }
  
  private void b(int paramInt)
  {
    this.c = paramInt;
    c(paramInt);
    d(paramInt);
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.ivConfirmStep1.setImageResource(2130840346);
      this.ivConfirmStep2.setImageResource(2130840345);
      this.ivConfirmStep3.setImageResource(2130840345);
      this.tvConfirmStep1.setTextColor(ContextCompat.getColor(this, 2131624609));
      this.tvConfirmStep2.setTextColor(ContextCompat.getColor(this, 2131624599));
      this.tvConfirmStep3.setTextColor(ContextCompat.getColor(this, 2131624599));
      return;
    case 2: 
      this.ivConfirmStep1.setImageResource(2130840347);
      this.ivConfirmStep2.setImageResource(2130840346);
      this.ivConfirmStep3.setImageResource(2130840345);
      this.tvConfirmStep1.setTextColor(ContextCompat.getColor(this, 2131624599));
      this.tvConfirmStep2.setTextColor(ContextCompat.getColor(this, 2131624609));
      this.tvConfirmStep3.setTextColor(ContextCompat.getColor(this, 2131624599));
      return;
    }
    this.ivConfirmStep1.setImageResource(2130840347);
    this.ivConfirmStep2.setImageResource(2130840347);
    this.ivConfirmStep3.setImageResource(2130840346);
    this.tvConfirmStep1.setTextColor(ContextCompat.getColor(this, 2131624599));
    this.tvConfirmStep2.setTextColor(ContextCompat.getColor(this, 2131624599));
    this.tvConfirmStep3.setTextColor(ContextCompat.getColor(this, 2131624609));
  }
  
  private void d(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.s.beginTransaction();
    switch (paramInt)
    {
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.replace(2131691866, this.t);
      this.btnBottom.setText("下一步");
      this.btnBottom.setBackgroundColor(40960);
      continue;
      localFragmentTransaction.replace(2131691866, this.u);
      this.btnBottom.setText("下一步");
      this.btnBottom.setBackgroundColor(40960);
      continue;
      localFragmentTransaction.replace(2131691866, this.v);
      this.btnBottom.setText("确认合同");
      g();
    }
  }
  
  private void d(String paramString)
  {
    this.llContentContainer.setVisibility(8);
    this.stubError.setVisibility(0);
    ((TextView)findViewById(2131690822)).setText(paramString);
    paramString = (TextView)findViewById(2131694446);
    paramString.getPaint().setFlags(8);
    paramString.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        OwnerContractConfirmActivity.e(OwnerContractConfirmActivity.this);
      }
    });
  }
  
  private void e()
  {
    j.getOCContractNeedConfirm(this, com.ziroom.ziroomcustomer.e.g.buildOCContractNeedConfirm(this.f, this.r), new f(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        OwnerContractConfirmActivity.c(OwnerContractConfirmActivity.this).sendEmptyMessage(0);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          u.logBigData(OwnerContractConfirmActivity.a(), "===ymq:" + paramAnonymouse.toString());
          OwnerContractConfirmActivity.a(OwnerContractConfirmActivity.this, (OwnerConfirmContractBean)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), OwnerConfirmContractBean.class));
          if (OwnerContractConfirmActivity.a(OwnerContractConfirmActivity.this) != null) {
            OwnerContractConfirmActivity.b(OwnerContractConfirmActivity.this);
          }
          return;
        }
        OwnerContractConfirmActivity.c(OwnerContractConfirmActivity.this).sendEmptyMessage(0);
      }
    });
  }
  
  private void f()
  {
    this.e = this.w.hireCommissionerPhone;
    if (!ae.isNull(this.e))
    {
      this.tvContactKeeper.setVisibility(0);
      this.s = getSupportFragmentManager();
      this.t = OCContractInfoFragment.getInstance(this.tvConfirmStep1.getText().toString(), this.w.personInfo);
      this.u = OCContractInfoFragment.getInstance(this.tvConfirmStep2.getText().toString(), this.w.contractInfo);
      this.v = OCContractItemFragment.getInstance(this.w.contractItem);
      if (this.w.personInfo == null) {
        this.x = 1;
      }
      if (this.x != 0) {
        break label159;
      }
      b(1);
      this.viewLine.setVisibility(0);
      this.llConfirmStep1.setVisibility(0);
    }
    label159:
    while (this.x != 1)
    {
      return;
      this.tvContactKeeper.setVisibility(8);
      break;
    }
    b(2);
    this.viewLine.setVisibility(8);
    this.llConfirmStep1.setVisibility(8);
  }
  
  private void g()
  {
    if (3 == this.c)
    {
      if (this.d) {
        this.btnBottom.setBackgroundColor(40960);
      }
    }
    else {
      return;
    }
    this.btnBottom.setBackgroundColor(-2236963);
  }
  
  private void h()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("您还未确认收房合同，确认要离开？").setTitle("温馨提示").setButtonText("取消", "确定").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        OwnerContractConfirmActivity.this.finish();
      }
    }).show();
  }
  
  private void i()
  {
    j.getOCConfirmContractContinue(this, com.ziroom.ziroomcustomer.e.g.buildOCConfirmContractContinue(this.f, this.r, this.g), new f(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        af.showToast(OwnerContractConfirmActivity.this, paramAnonymousThrowable.getMessage());
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        Object localObject;
        if (paramAnonymouse != null)
        {
          u.logBigData(OwnerContractConfirmActivity.a(), "===ymq:" + paramAnonymouse.toString());
          if (!"200".equals(paramAnonymouse.getString("code"))) {
            break label328;
          }
          localObject = paramAnonymouse.getJSONObject("data");
          if (localObject != null)
          {
            paramAnonymousInt = ((e)localObject).getIntValue("signType");
            int i = ((e)localObject).getIntValue("confirmFlag");
            int j = ((e)localObject).getIntValue("evaluateFlag");
            if (1 != i) {
              break label296;
            }
            if ((2 != paramAnonymousInt) || (1 != j)) {
              break label246;
            }
            paramAnonymouse = ((e)localObject).getString("evaluateH5Url");
            if (!ae.notNull(paramAnonymouse)) {
              break label236;
            }
            localObject = new StringBuilder().append(paramAnonymouse);
            if (!paramAnonymouse.contains("?")) {
              break label230;
            }
          }
        }
        label230:
        for (paramAnonymouse = "&";; paramAnonymouse = "?")
        {
          paramAnonymouse = paramAnonymouse;
          paramAnonymouse = paramAnonymouse + "token=" + com.ziroom.commonlibrary.login.a.getToken(OwnerContractConfirmActivity.this);
          Log.i(OwnerContractConfirmActivity.a(), "跳转到H5:" + paramAnonymouse);
          JsBridgeWebActivity.start(OwnerContractConfirmActivity.this, "", paramAnonymouse);
          OwnerContractConfirmActivity.this.finish();
          return;
        }
        label236:
        af.showToast(OwnerContractConfirmActivity.this, "评价链接为空");
        return;
        label246:
        paramAnonymouse = new Intent(OwnerContractConfirmActivity.this, OwnerConfirmSuccessActivity.class);
        paramAnonymouse.putExtra("pageTitle", "签约成功");
        paramAnonymouse.putExtra("title", "您已成为自如业主");
        paramAnonymouse.putExtra("content", "想了解房屋近况、查询收益明细？登录业主个人中心即可了解最新最全的信息");
        OwnerContractConfirmActivity.this.startActivity(paramAnonymouse);
        return;
        label296:
        af.showToast(OwnerContractConfirmActivity.this, "确认失败！message：" + paramAnonymouse.getString("message"));
        return;
        label328:
        af.showToast(OwnerContractConfirmActivity.this, "确认失败！message：" + paramAnonymouse.getString("message"));
      }
    });
  }
  
  public void lightConfirmButton(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (3 == this.c)
    {
      if (paramBoolean) {
        this.btnBottom.setBackgroundColor(40960);
      }
    }
    else {
      return;
    }
    this.btnBottom.setBackgroundColor(-2236963);
  }
  
  public void onBackPressed()
  {
    if (this.x == 0) {
      if (this.c == 2) {
        b(1);
      }
    }
    while (this.x != 1)
    {
      return;
      if (this.c == 3)
      {
        b(2);
        return;
      }
      h();
      return;
    }
    if (this.c == 2)
    {
      h();
      return;
    }
    if (this.c == 3)
    {
      b(2);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903403);
    this.b = ButterKnife.bind(this);
    paramBundle = ApplicationEx.c.getUser();
    if (paramBundle != null)
    {
      this.f = paramBundle.getUid();
      this.g = paramBundle.getPhone();
    }
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  @OnClick({2131689492, 2131691990, 2131691994, 2131691996, 2131691998, 2131691101})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131691994: 
    case 2131691996: 
    case 2131691998: 
    default: 
    case 2131689492: 
      do
      {
        return;
        if (this.x == 0)
        {
          if (this.c == 2)
          {
            b(1);
            return;
          }
          if (this.c == 3)
          {
            b(2);
            return;
          }
          h();
          return;
        }
      } while (this.x != 1);
      if (this.c == 2)
      {
        h();
        return;
      }
      if (this.c == 3)
      {
        b(2);
        return;
      }
      finish();
      return;
    case 2131691990: 
      ah.callPhone(this, this.e);
      return;
    }
    switch (this.c)
    {
    default: 
      return;
    case 1: 
      b(2);
      return;
    case 2: 
      b(3);
      return;
    }
    if (this.d)
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("您确认合同信息无误？").setTitle("温馨提示").setButtonText("取消", "确定").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          OwnerContractConfirmActivity.d(OwnerContractConfirmActivity.this);
        }
      }).show();
      return;
    }
    af.showToast(this, "请阅读并同意相关条款");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContractConfirmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */