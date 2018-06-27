package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.my.model.InvoiceDetailInfoBean;
import com.ziroom.ziroomcustomer.my.model.InvoiceDetailInfoBean.Bean;
import com.ziroom.ziroomcustomer.my.widget.InvoiceInfoItemView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendlyInvoiceDetailActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  InvoiceDetailInfoBean b;
  @BindView(2131690078)
  ImageView btnBack;
  private String d = FriendlyInvoiceDetailActivity.class.getSimpleName();
  private Context e;
  private int f = -10235509;
  private int g = 862179723;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131690614)
  LinearLayout llDownloadUrlContainer;
  @BindView(2131696247)
  LinearLayout llInvoiceDetailTimeCounter;
  @BindView(2131690610)
  LinearLayout llInvoiceInfoList;
  @BindView(2131690612)
  LinearLayout llInvoicePersonalInfo;
  @BindView(2131690617)
  LinearLayout llPayButtons;
  private int r = -40350;
  private int s = 872374882;
  @BindView(2131690620)
  ViewStub stubError;
  private int t = 40960;
  @BindView(2131690613)
  TextView tvCancelOpen;
  @BindView(2131690616)
  TextView tvDownload;
  @BindView(2131690615)
  TextView tvDownloadUrl;
  @BindView(2131690618)
  TextView tvInvoiceCancel;
  @BindView(2131690609)
  TextView tvInvoiceDetailDesc;
  @BindView(2131696248)
  TextView tvInvoiceDetailMinute;
  @BindView(2131696249)
  TextView tvInvoiceDetailSecond;
  @BindView(2131696250)
  TextView tvInvoiceDetailTax;
  @BindView(2131690611)
  TextView tvInvoiceReceiverTips;
  @BindView(2131690619)
  TextView tvTaxPay;
  @BindView(2131689541)
  TextView tvTitle;
  private int u = 872390656;
  private int v;
  private String w;
  private String x;
  private a y;
  
  private void b()
  {
    this.w = getIntent().getStringExtra("invoiceNum");
    this.v = getIntent().getIntExtra("busType", 100);
    this.x = getIntent().getStringExtra("contractCode");
  }
  
  private void e()
  {
    if (this.b == null) {
      return;
    }
    f();
    g();
    h();
  }
  
  private void f()
  {
    int k = 0;
    this.tvInvoiceDetailDesc.setText(this.b.getInvoiceStatusName());
    int j;
    if (this.b.isCancelApplyButton())
    {
      j = 0;
      this.tvCancelOpen.setVisibility(j);
      this.tvDownload.setVisibility(8);
      this.tvInvoiceDetailDesc.setVisibility(0);
      this.tvInvoiceDetailDesc.setBackgroundColor(this.u);
      this.tvInvoiceDetailDesc.setTextColor(this.t);
      this.llInvoiceDetailTimeCounter.setVisibility(8);
      this.llPayButtons.setVisibility(8);
      if (!TextUtils.isEmpty(this.b.getInvoiceStatus())) {
        break label113;
      }
    }
    label113:
    int i;
    label411:
    label535:
    do
    {
      return;
      j = 8;
      break;
      Object localObject = this.b.getInvoiceStatus();
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        case 1: 
        default: 
          return;
        case 0: 
          this.llInvoiceDetailTimeCounter.setVisibility(0);
          this.llPayButtons.setVisibility(0);
          this.tvCancelOpen.setVisibility(8);
          this.tvInvoiceCancel.setVisibility(j);
          if (!this.b.isPayButton()) {}
          break;
        }
        break;
      }
      for (i = k;; i = 8)
      {
        this.tvTaxPay.setVisibility(i);
        this.tvInvoiceDetailDesc.setVisibility(8);
        localObject = Long.valueOf(0L);
        try
        {
          long l = Long.parseLong(this.b.getDeadLineTime());
          localObject = Long.valueOf(l);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Log.e("invoice_open", localNumberFormatException.getStackTrace().toString());
          }
          j = i / 1000 / 60;
          k = i / 1000;
          this.tvInvoiceDetailMinute.setText(j + "");
          this.tvInvoiceDetailSecond.setText(k % 60 + "");
          this.tvInvoiceDetailTax.setText(this.b.getPayAmount() / 100.0D + "");
          if (this.y == null) {
            break label535;
          }
          this.y.cancel();
        }
        i = (int)(((Long)localObject).longValue() - System.currentTimeMillis());
        if (i > 0) {
          break label411;
        }
        this.tvInvoiceDetailMinute.setText("00");
        this.tvInvoiceDetailSecond.setText("00");
        return;
        if (!((String)localObject).equals("dzf")) {
          break;
        }
        i = 0;
        break;
        if (!((String)localObject).equals("shz")) {
          break;
        }
        i = 1;
        break;
        if (!((String)localObject).equals("ybh")) {
          break;
        }
        i = 2;
        break;
        if (!((String)localObject).equals("ykp")) {
          break;
        }
        i = 3;
        break;
      }
    } while (i <= 0);
    this.y = new a(i, 1000L);
    this.y.start();
    return;
    this.tvInvoiceDetailDesc.setBackgroundColor(this.s);
    this.tvInvoiceDetailDesc.setTextColor(this.r);
    this.tvInvoiceDetailDesc.setText(this.b.getInvoiceStatusName() + " " + this.b.getRejectReason());
    return;
    this.tvInvoiceDetailDesc.setBackgroundColor(this.g);
    this.tvInvoiceDetailDesc.setTextColor(this.f);
    if ((this.b.getInvoiceType() == 3) && (!ae.isNull(this.b.getDownUrl())))
    {
      this.tvDownload.setVisibility(0);
      return;
    }
    this.tvDownload.setVisibility(8);
  }
  
  private void g()
  {
    if ((this.b == null) || (this.b.getInvoiceInfo() == null) || (this.b.getInvoiceInfo().size() < 1)) {}
    for (;;)
    {
      return;
      this.llInvoiceInfoList.removeAllViews();
      List localList = this.b.getInvoiceInfo();
      int i = 0;
      while (i < localList.size())
      {
        InvoiceDetailInfoBean.Bean localBean = (InvoiceDetailInfoBean.Bean)localList.get(i);
        InvoiceInfoItemView localInvoiceInfoItemView = new InvoiceInfoItemView(this);
        localInvoiceInfoItemView.setText(localBean.getTitle(), localBean.getValue());
        this.llInvoiceInfoList.addView(localInvoiceInfoItemView);
        i += 1;
      }
    }
  }
  
  private void h()
  {
    if ((this.b == null) || (this.b.getReceiverInfo() == null) || (this.b.getReceiverInfo().size() < 1)) {
      return;
    }
    if (this.b.getInvoiceType() == 3) {
      this.tvInvoiceReceiverTips.setVisibility(0);
    }
    for (;;)
    {
      this.llInvoicePersonalInfo.removeAllViews();
      List localList = this.b.getReceiverInfo();
      int i = 0;
      while (i < localList.size())
      {
        InvoiceDetailInfoBean.Bean localBean = (InvoiceDetailInfoBean.Bean)localList.get(i);
        InvoiceInfoItemView localInvoiceInfoItemView = new InvoiceInfoItemView(this);
        localInvoiceInfoItemView.setText(localBean.getTitle(), localBean.getValue());
        this.llInvoicePersonalInfo.addView(localInvoiceInfoItemView);
        i += 1;
      }
      break;
      this.tvInvoiceReceiverTips.setVisibility(8);
    }
  }
  
  private void i()
  {
    com.ziroom.ziroomcustomer.payment.a.startPayActivty(this, this.b.getPayAmount(), "110", this.b.getReceivableNum(), this.b.getSystemId(), this.b.getDeadLineTime());
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this, FriendlyInvoiceListActivity.class);
    localIntent.putExtra("contractCode", this.x);
    startActivity(localIntent);
    finish();
  }
  
  private void k()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this.e).setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        paramAnonymousView = new HashMap();
        paramAnonymousView.put("invoiceNum", FriendlyInvoiceDetailActivity.b(FriendlyInvoiceDetailActivity.this));
        paramAnonymousView.put("busType", Integer.valueOf(FriendlyInvoiceDetailActivity.c(FriendlyInvoiceDetailActivity.this)));
        j.cancelFInvoiceApply(FriendlyInvoiceDetailActivity.this, paramAnonymousView, new com.ziroom.ziroomcustomer.e.a.d(FriendlyInvoiceDetailActivity.this, new f(e.class))
        {
          public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
            if (paramAnonymous2e == null) {
              return;
            }
            FriendlyInvoiceDetailActivity.a(FriendlyInvoiceDetailActivity.this, paramAnonymous2e.getString("applyNo"));
            FriendlyInvoiceDetailActivity.this.initData();
          }
        });
      }
    }).setTitle("温馨提示").setContent("你确定要取消开票吗？\n").setButtonText("取消", "确定").show();
  }
  
  private void l()
  {
    af.showToast(this, "下载发票");
    ah.downloadPdf(this.e, this.b.getDownUrl());
  }
  
  void a()
  {
    showError(this.llContentContainer, this.stubError, "网络故障，");
  }
  
  public void initData()
  {
    if (this.y != null)
    {
      this.y.cancel();
      this.y = null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("invoiceNum", this.w);
    localHashMap.put("busType", Integer.valueOf(this.v));
    j.getFInvoiceDetail(this, localHashMap, new com.ziroom.ziroomcustomer.e.a.d(this, new f(InvoiceDetailInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        FriendlyInvoiceDetailActivity.this.a();
      }
      
      public void onSuccess(int paramAnonymousInt, InvoiceDetailInfoBean paramAnonymousInvoiceDetailInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousInvoiceDetailInfoBean);
        if (paramAnonymousInvoiceDetailInfoBean == null) {
          return;
        }
        FriendlyInvoiceDetailActivity.this.b = paramAnonymousInvoiceDetailInfoBean;
        FriendlyInvoiceDetailActivity.a(FriendlyInvoiceDetailActivity.this);
      }
    });
  }
  
  public void initView() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = this;
    setContentView(2130903179);
    this.a = ButterKnife.bind(this);
    b();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
    if (this.y != null)
    {
      this.y.cancel();
      this.y = null;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    initData();
  }
  
  @OnClick({2131690078, 2131690613, 2131690616, 2131690618, 2131690619})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      j();
      return;
    case 2131690613: 
    case 2131690618: 
      k();
      return;
    case 2131690616: 
      l();
      return;
    }
    i();
  }
  
  private class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      cancel();
      FriendlyInvoiceDetailActivity.this.initData();
    }
    
    public void onTick(long paramLong)
    {
      int i = (int)(paramLong / 1000L / 60L);
      int j = (int)(paramLong / 1000L % 60L);
      FriendlyInvoiceDetailActivity.this.tvInvoiceDetailMinute.setText(i + "");
      FriendlyInvoiceDetailActivity.this.tvInvoiceDetailSecond.setText(j + "");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/FriendlyInvoiceDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */