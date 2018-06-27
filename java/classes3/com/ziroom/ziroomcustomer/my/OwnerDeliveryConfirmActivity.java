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
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean.DeliveryInfoBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean.ThingInfoBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean.ThingsBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OwnerDeliveryConfirmActivity
  extends BaseActivity
{
  private static final String a = OwnerDeliveryConfirmActivity.class.getSimpleName();
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
  @BindView(2131690608)
  LinearLayout llContentContainer;
  private FragmentManager r;
  private OCDeliveryInfoFragment s;
  @BindView(2131690620)
  ViewStub stubError;
  private OCDeliveryInfoFragment t;
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
  private OCDeliveryInfoFragment u;
  private OwnerConfirmDeliveryBean v;
  private Handler w = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      OwnerDeliveryConfirmActivity.a(OwnerDeliveryConfirmActivity.this, "网络故障，");
    }
  };
  
  private void b()
  {
    this.g = getIntent().getStringExtra("contractCode");
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
    FragmentTransaction localFragmentTransaction = this.r.beginTransaction();
    switch (paramInt)
    {
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.replace(2131691866, this.s);
      this.btnBottom.setText("下一步");
      continue;
      localFragmentTransaction.replace(2131691866, this.t);
      this.btnBottom.setText("下一步");
      continue;
      localFragmentTransaction.replace(2131691866, this.u);
      this.btnBottom.setText("确认物业交割合同");
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
        OwnerDeliveryConfirmActivity.e(OwnerDeliveryConfirmActivity.this);
      }
    });
  }
  
  private void e()
  {
    j.getOCDelieverNeedConfirm(this, com.ziroom.ziroomcustomer.e.g.buildOCDelieverNeedConfirm(this.f, this.g), new f(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        OwnerDeliveryConfirmActivity.c(OwnerDeliveryConfirmActivity.this).sendEmptyMessage(0);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          u.logBigData(OwnerDeliveryConfirmActivity.a(), "===ymq:" + paramAnonymouse.toString());
          OwnerDeliveryConfirmActivity.a(OwnerDeliveryConfirmActivity.this, (OwnerConfirmDeliveryBean)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), OwnerConfirmDeliveryBean.class));
          if (OwnerDeliveryConfirmActivity.a(OwnerDeliveryConfirmActivity.this) != null) {
            OwnerDeliveryConfirmActivity.b(OwnerDeliveryConfirmActivity.this);
          }
        }
      }
    });
  }
  
  private void f()
  {
    this.e = this.v.hireCommissionerPhone;
    if (!ae.isNull(this.e)) {
      this.tvContactKeeper.setVisibility(0);
    }
    ArrayList localArrayList;
    for (;;)
    {
      this.tvTopTips.setText("物业交割日期" + this.v.deliveryDate);
      this.r = getSupportFragmentManager();
      this.s = OCDeliveryInfoFragment.getInstance(this.tvConfirmStep1.getText().toString(), "下一步", this.v.lifeFee);
      this.t = OCDeliveryInfoFragment.getInstance(this.tvConfirmStep2.getText().toString(), "下一步", this.v.keyCredit);
      localArrayList = new ArrayList();
      if ((this.v.thingInfo == null) || (this.v.thingInfo.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.v.thingInfo.iterator();
      while (localIterator.hasNext())
      {
        OwnerConfirmDeliveryBean.ThingInfoBean localThingInfoBean = (OwnerConfirmDeliveryBean.ThingInfoBean)localIterator.next();
        if ((localThingInfoBean != null) && (localThingInfoBean.things != null) && (localThingInfoBean.things.size() > 0))
        {
          int i = 0;
          while (i < localThingInfoBean.things.size())
          {
            OwnerConfirmDeliveryBean.ThingsBean localThingsBean = (OwnerConfirmDeliveryBean.ThingsBean)localThingInfoBean.things.get(i);
            OwnerConfirmDeliveryBean.DeliveryInfoBean localDeliveryInfoBean = new OwnerConfirmDeliveryBean.DeliveryInfoBean();
            if (i == 0) {
              localDeliveryInfoBean.deliveryName = localThingInfoBean.roomName;
            }
            localDeliveryInfoBean.subName = localThingsBean.deliveryName;
            localDeliveryInfoBean.imgUrls = localThingsBean.imgUrls;
            localDeliveryInfoBean.data = localThingsBean.data;
            localArrayList.add(localDeliveryInfoBean);
            i += 1;
          }
        }
      }
      this.tvContactKeeper.setVisibility(8);
    }
    this.u = OCDeliveryInfoFragment.getInstance("遗留" + this.tvConfirmStep3.getText().toString(), "确认物业交割合同", localArrayList);
    b(1);
  }
  
  private void g()
  {
    j.getOCConfirmDeliever(this, com.ziroom.ziroomcustomer.e.g.buildOCConfirmDeliever(this.f, this.g), new f(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        af.showToast(OwnerDeliveryConfirmActivity.this, paramAnonymousThrowable.getMessage());
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null)
        {
          u.logBigData(OwnerDeliveryConfirmActivity.a(), "===ymq:" + paramAnonymouse.toString());
          String str1 = paramAnonymouse.getString("status");
          String str2 = paramAnonymouse.getString("code");
          if (("success".equals(str1)) && ("200".equals(str2)))
          {
            paramAnonymouse = new Intent(OwnerDeliveryConfirmActivity.this, OwnerConfirmSuccessActivity.class);
            paramAnonymouse.putExtra("pageTitle", "物业交割成功");
            paramAnonymouse.putExtra("title", "确认物业交割成功");
            paramAnonymouse.putExtra("content", "想了解房屋近况、查询收益明细？登录业主个人中心即可了解最新最全的信息");
            OwnerDeliveryConfirmActivity.this.startActivity(paramAnonymouse);
          }
        }
        else
        {
          return;
        }
        af.showToast(OwnerDeliveryConfirmActivity.this, "确认失败！message：" + paramAnonymouse.getString("message"));
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903406);
    this.b = ButterKnife.bind(this);
    paramBundle = ApplicationEx.c.getUser();
    if (paramBundle != null) {
      this.f = paramBundle.getUid();
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
      return;
    case 2131689492: 
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
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("您确认合同信息无误？").setTitle("温馨提示").setButtonText("取消", "确定").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        OwnerDeliveryConfirmActivity.d(OwnerDeliveryConfirmActivity.this);
      }
    }).show();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerDeliveryConfirmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */