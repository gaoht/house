package com.ziroom.ziroomcustomer.repay;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepayInfoActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private List<e> c;
  @BindView(2131692214)
  LinearLayout complete_repay_ll;
  private String[] d = { "贷款总额", "总手续费", "待还款总额", "贷款合同号" };
  private String e;
  @BindView(2131692223)
  ImageView error_iv;
  private com.ziroom.ziroomcustomer.repay.a.c f;
  private View g;
  @BindView(2131692222)
  RelativeLayout hint_rl;
  @BindView(2131692224)
  TextView hint_tv;
  @BindView(2131692215)
  ImageView repay_complete_iv;
  @BindView(2131692216)
  TextView repay_complete_tv;
  @BindView(2131692227)
  LinearLayout repay_data_ll;
  @BindView(2131692217)
  LinearLayout repay_info_ll;
  @BindView(2131692213)
  LinearLayout repay_ll;
  @BindView(2131692218)
  TextView repay_money_tv;
  @BindView(2131692219)
  TextView repay_poundage_tv;
  @BindView(2131692220)
  TextView repay_time;
  @BindView(2131692221)
  TextView to_pay_tv;
  
  private void a()
  {
    if (this.f == null) {
      return;
    }
    if (("unwind".equals(this.f.getPayStatus())) || ("finish".equals(this.f.getPayStatus())))
    {
      this.complete_repay_ll.setVisibility(0);
      this.repay_complete_iv.setImageResource(2130840406);
      this.repay_complete_tv.setText("您已还清全部账单");
      this.repay_info_ll.setVisibility(8);
    }
    for (;;)
    {
      h();
      g();
      return;
      if ("paying".equals(this.f.getPayStatus()))
      {
        this.repay_complete_iv.setImageResource(2130840407);
        this.repay_complete_tv.setText("还款结果正在查询，请稍候");
        this.complete_repay_ll.setVisibility(0);
        this.repay_info_ll.setVisibility(8);
      }
      else
      {
        this.complete_repay_ll.setVisibility(8);
        this.repay_info_ll.setVisibility(0);
        this.repay_money_tv.setText("¥" + ah.changeF2Y(new StringBuilder().append(this.f.getPayMoney()).append("").toString()));
        this.repay_poundage_tv.setText("(含手续费¥" + ah.changeF2Y(new StringBuilder().append(this.f.getNormInt()).append("").toString()) + ")");
        if (ae.notNull(this.f.getPayDate())) {
          this.repay_time.setText("还款日:" + this.f.getPayDate());
        }
        for (;;)
        {
          if (1 != this.f.getIsPayOpen()) {
            break label461;
          }
          this.to_pay_tv.setVisibility(0);
          this.to_pay_tv.setText("去还款");
          this.hint_tv.setText("请在还款日23:59:59前，完成还款");
          this.error_iv.setVisibility(8);
          if (this.f.getPayLine() >= 0) {
            break;
          }
          this.error_iv.setVisibility(0);
          this.hint_tv.setText("您已逾期" + (0 - this.f.getPayLine()) + "天，已产生¥" + ah.changeF2Y(new StringBuilder().append(this.f.getBreachFee()).append("").toString()) + "违约金");
          break;
          this.repay_time.setVisibility(4);
        }
        label461:
        this.to_pay_tv.setVisibility(4);
        this.hint_rl.setVisibility(4);
      }
    }
  }
  
  private void b()
  {
    j.getBoundCardState(this, this.e, new com.ziroom.commonlibrary.a.a(this.b, new com.freelxl.baselibrary.d.f.c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          if (paramAnonymouse.get("data") != null)
          {
            paramAnonymouse = (com.ziroom.ziroomcustomer.repay.a.a)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "", com.ziroom.ziroomcustomer.repay.a.a.class);
            if (paramAnonymouse.getStatus() == 1)
            {
              localIntent = new Intent(RepayInfoActivity.a(RepayInfoActivity.this), RepayCardActivity.class);
              localIntent.putExtra("contractCode", RepayInfoActivity.b(RepayInfoActivity.this));
              localIntent.putExtra("bound_card", paramAnonymouse);
              RepayInfoActivity.this.startActivity(localIntent);
            }
            do
            {
              return;
              if (paramAnonymouse.getStatus() == 2)
              {
                localIntent = new Intent(RepayInfoActivity.a(RepayInfoActivity.this), RepayCardActivity.class);
                localIntent.putExtra("contractCode", RepayInfoActivity.b(RepayInfoActivity.this));
                localIntent.putExtra("bound_card", paramAnonymouse);
                RepayInfoActivity.this.startActivity(localIntent);
                return;
              }
            } while (paramAnonymouse.getStatus() != 3);
            Intent localIntent = new Intent(RepayInfoActivity.a(RepayInfoActivity.this), RepayChangeCardActivity.class);
            localIntent.putExtra("contractCode", RepayInfoActivity.b(RepayInfoActivity.this));
            localIntent.putExtra("bound_card", paramAnonymouse);
            RepayInfoActivity.this.startActivity(localIntent);
            return;
          }
          RepayInfoActivity.this.showToast("数据获取失败，请稍后重试");
          return;
        }
        RepayInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
      }
    });
  }
  
  private void d(String paramString)
  {
    if (ae.notNull(paramString))
    {
      Object localObject = this.f.getLoanContractCode() + this.e + ".pdf";
      File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ziroom/file");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new File(localFile, (String)localObject);
      if (!((File)localObject).exists()) {}
      try
      {
        ((File)localObject).createNewFile();
        com.freelxl.baselibrary.d.a.get(paramString).tag(this.b).enqueue(new com.ziroom.commonlibrary.a.a(this.b, new com.freelxl.baselibrary.d.f.b((File)localObject))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
            g.textToast(RepayInfoActivity.a(RepayInfoActivity.this), "pdf下载失败！");
          }
          
          public void onSuccess(int paramAnonymousInt, File paramAnonymousFile)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousFile);
            if ((paramAnonymousFile.exists()) && (paramAnonymousFile.isFile()))
            {
              Intent localIntent = new Intent("android.intent.action.VIEW");
              localIntent.addCategory("android.intent.category.DEFAULT");
              localIntent.addFlags(268435456);
              localIntent.setDataAndType(Uri.fromFile(paramAnonymousFile), "application/pdf");
              paramAnonymousFile = RepayInfoActivity.a(RepayInfoActivity.this).getPackageManager().queryIntentActivities(localIntent, 65536);
              if ((paramAnonymousFile != null) && (paramAnonymousFile.size() > 0)) {
                RepayInfoActivity.a(RepayInfoActivity.this).startActivity(localIntent);
              }
            }
            else
            {
              return;
            }
            g.textToast(RepayInfoActivity.a(RepayInfoActivity.this), "设备不支持查看pdf文件，请安装pdf阅读软件！");
          }
        });
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          g.textToast(this.b, "pdf创建失败！");
          localIOException.printStackTrace();
        }
      }
    }
    showToast("贷款合同生成中");
  }
  
  private void e()
  {
    this.e = getIntent().getStringExtra("contractCode");
  }
  
  private void f()
  {
    j.getLoanInfo(this, this.e, new com.ziroom.commonlibrary.a.a(this.b, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          RepayInfoActivity.a(RepayInfoActivity.this, (com.ziroom.ziroomcustomer.repay.a.c)com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "", com.ziroom.ziroomcustomer.repay.a.c.class));
          RepayInfoActivity.c(RepayInfoActivity.this);
        }
        for (;;)
        {
          dismissProgress();
          return;
          if ("101020".equals(paramAnonymouse.get("code") + ""))
          {
            RepayInfoActivity.this.showMyEmptyView(paramAnonymouse.get("message") + "");
            RepayInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
          }
          else
          {
            RepayInfoActivity.this.showEmptyView(RepayInfoActivity.this.repay_ll, paramAnonymouse.get("message") + "");
            RepayInfoActivity.this.showToast(paramAnonymouse.get("message") + "");
          }
        }
      }
    });
  }
  
  private void g()
  {
    this.repay_data_ll.removeAllViews();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = View.inflate(this, 2130905220, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131697778);
      TextView localTextView2 = (TextView)localView.findViewById(2131697777);
      localTextView1.setText(locale.get("title") + "");
      localTextView2.setText(locale.get("content") + "");
      this.repay_data_ll.addView(localView);
    }
  }
  
  private void h()
  {
    if (this.f == null) {
      return;
    }
    this.c = new ArrayList();
    e locale = new e();
    locale.put("title", this.d[0]);
    locale.put("content", "¥" + ah.changeF2Y(new StringBuilder().append(this.f.getLoanMoney()).append("").toString()));
    this.c.add(locale);
    locale = new e();
    locale.put("title", this.d[1]);
    locale.put("content", "¥" + ah.changeF2Y(new StringBuilder().append(this.f.getHandlingCharge()).append("").toString()));
    this.c.add(locale);
    locale = new e();
    locale.put("title", this.d[2]);
    locale.put("content", "¥" + ah.changeF2Y(new StringBuilder().append(this.f.getToPayAmount()).append("").toString()));
    this.c.add(locale);
    locale = new e();
    locale.put("title", this.d[3]);
    locale.put("content", this.f.getLoanContractCode());
    this.c.add(locale);
  }
  
  private void i()
  {
    setResult(3, getIntent());
  }
  
  @OnClick({2131690511, 2131692221, 2131692225, 2131692206, 2131692226})
  public void click(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690511: 
      i();
      finish();
      return;
    case 2131692221: 
      paramView = new Intent(this.b, HouseBillInfoActivity.class);
      paramView.putExtra("uniqueCode", this.e);
      paramView.putExtra("period", this.f.getCnt() + "");
      paramView.putExtra("payType", "zrfq");
      this.b.startActivity(paramView);
      return;
    case 2131692225: 
      paramView = new Intent(this, RepayBillListActivity.class);
      paramView.putExtra("contractCode", this.e);
      startActivity(paramView);
      return;
    case 2131692206: 
      b();
      return;
    }
    if (this.f == null)
    {
      showToast("数据获取失败");
      return;
    }
    d(this.f.getSealContractUrl());
  }
  
  public void onBackPressed()
  {
    i();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903456);
    this.a = ButterKnife.bind(this);
    this.b = this;
    e();
    f();
  }
  
  public View showLivingEmptyView(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return null;
    }
    paramString = paramViewGroup.findViewById(2131697779);
    if (paramString != null) {
      paramViewGroup.removeView(paramString);
    }
    paramString = LayoutInflater.from(this);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramViewGroup.getChildAt(i).setVisibility(8);
      i += 1;
    }
    return paramString.inflate(2130905221, paramViewGroup, true);
  }
  
  public void showMyEmptyView(String paramString)
  {
    if (this.repay_ll == null) {
      return;
    }
    this.g = showLivingEmptyView(this.repay_ll, paramString);
    TextView localTextView = (TextView)this.g.findViewById(2131690822);
    LinearLayout localLinearLayout = (LinearLayout)this.g.findViewById(2131697779);
    localTextView.setText(paramString);
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepayInfoActivity.d(RepayInfoActivity.this);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */