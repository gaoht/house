package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
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
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.h;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OIDetailModel;
import com.ziroom.ziroomcustomer.my.model.OIDetailModel.InfoBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Iterator;
import java.util.List;

public class OwnerInvoiceDetailActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  private String b = OwnerInvoiceDetailActivity.class.getSimpleName();
  @BindView(2131690078)
  ImageView btnBack;
  private Context d;
  private int e = -10235509;
  private int f = 862179723;
  private int g = -40350;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131690614)
  LinearLayout llDownloadUrlContainer;
  @BindView(2131690610)
  LinearLayout llInvoiceInfoList;
  @BindView(2131690612)
  LinearLayout llInvoicePersonalInfo;
  private int r = 872374882;
  private int s = 40960;
  @BindView(2131690620)
  ViewStub stubError;
  private int t = 872390656;
  @BindView(2131690613)
  TextView tvCancelOpen;
  @BindView(2131690616)
  TextView tvDownload;
  @BindView(2131690615)
  TextView tvDownloadUrl;
  @BindView(2131690609)
  TextView tvInvoiceDetailDesc;
  @BindView(2131689541)
  TextView tvTitle;
  private OIDetailModel u;
  private String v;
  private String w;
  private String x;
  private String y;
  
  private void a(LinearLayout paramLinearLayout, List<OIDetailModel.InfoBean> paramList)
  {
    paramLinearLayout.removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        OIDetailModel.InfoBean localInfoBean = (OIDetailModel.InfoBean)paramList.next();
        View localView = LayoutInflater.from(this.d).inflate(2130904421, null, false);
        TextView localTextView1 = (TextView)localView.findViewById(2131695033);
        TextView localTextView2 = (TextView)localView.findViewById(2131695034);
        localTextView1.setText(localInfoBean.title);
        localTextView2.setText(localInfoBean.value);
        paramLinearLayout.addView(localView);
      }
    }
  }
  
  private void b()
  {
    this.y = getIntent().getStringExtra("beautyContractCode");
    this.x = getIntent().getStringExtra("hireContractCode");
    this.w = getIntent().getStringExtra("applyCode");
  }
  
  private void e()
  {
    label18:
    label49:
    String str;
    label94:
    int i;
    if (this.u.cancelButton)
    {
      this.tvCancelOpen.setVisibility(0);
      if (!ae.isNull(this.u.downUrl)) {
        break label237;
      }
      this.tvDownload.setVisibility(8);
      this.llDownloadUrlContainer.setVisibility(8);
      TextView localTextView = this.tvInvoiceDetailDesc;
      StringBuilder localStringBuilder = new StringBuilder().append(this.u.statusName).append("  ");
      if (!ae.isNull(this.u.statusInstruct)) {
        break label270;
      }
      str = "";
      localTextView.setText(str);
      str = this.u.status;
      i = -1;
      switch (str.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.tvInvoiceDetailDesc.setTextColor(this.s);
        this.tvInvoiceDetailDesc.setBackgroundColor(this.t);
        a(this.llInvoiceInfoList, this.u.invoiceInfo);
        a(this.llInvoicePersonalInfo, this.u.receiverInfo);
        return;
        this.tvCancelOpen.setVisibility(8);
        break label18;
        label237:
        this.tvDownload.setVisibility(0);
        this.llDownloadUrlContainer.setVisibility(0);
        this.tvDownloadUrl.setText(this.u.downUrl);
        break label49;
        label270:
        str = this.u.statusInstruct;
        break label94;
        if (str.equals("ybh"))
        {
          i = 0;
          continue;
          if (str.equals("ykj")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.tvInvoiceDetailDesc.setTextColor(this.g);
    this.tvInvoiceDetailDesc.setBackgroundColor(this.r);
    a(this.llInvoiceInfoList, this.u.invoiceInfo);
    a(this.llInvoicePersonalInfo, this.u.receiverInfo);
    return;
    this.tvInvoiceDetailDesc.setTextColor(this.e);
    this.tvInvoiceDetailDesc.setBackgroundColor(this.f);
    a(this.llInvoiceInfoList, this.u.invoiceInfo);
    a(this.llInvoicePersonalInfo, this.u.receiverInfo);
  }
  
  private void f()
  {
    j.cancelOpenInvoice(this, com.ziroom.ziroomcustomer.e.g.buildCancelOpenInvoice(this.v, this.w), new f(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.logBigData(OwnerInvoiceDetailActivity.a(OwnerInvoiceDetailActivity.this), "===ymq:" + paramAnonymouse.toString());
        String str1 = paramAnonymouse.getString("status");
        String str2 = paramAnonymouse.getString("code");
        if (("success".equals(str1)) && ("200".equals(str2)))
        {
          af.showToast(OwnerInvoiceDetailActivity.this, "取消开票成功");
          paramAnonymouse = new Intent(OwnerInvoiceDetailActivity.this, OwnerInvoiceListActivity.class);
          paramAnonymouse.putExtra("beautyContractCode", OwnerInvoiceDetailActivity.d(OwnerInvoiceDetailActivity.this));
          paramAnonymouse.putExtra("hireContractCode", OwnerInvoiceDetailActivity.e(OwnerInvoiceDetailActivity.this));
          OwnerInvoiceDetailActivity.this.startActivity(paramAnonymouse);
          return;
        }
        af.showToast(OwnerInvoiceDetailActivity.this, paramAnonymouse.getString("message"));
      }
    });
  }
  
  private void g()
  {
    af.showToast(this, "下载发票");
    ah.downloadPdf(this.d, this.u.realUrl);
  }
  
  void a()
  {
    showError(this.llContentContainer, this.stubError, "网络故障，");
  }
  
  public void initData()
  {
    if (ApplicationEx.c.getUser() != null) {
      this.v = ApplicationEx.c.getUser().getUid();
    }
    for (;;)
    {
      j.getInvoiceDetail(this, com.ziroom.ziroomcustomer.e.g.buildInvoiceDetail(this.v, this.w), new f(this, new h())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          OwnerInvoiceDetailActivity.this.c.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          paramAnonymouse = paramAnonymouse.toJSONString();
          u.logBigData(OwnerInvoiceDetailActivity.a(OwnerInvoiceDetailActivity.this), "===ymq:" + paramAnonymouse);
          OwnerInvoiceDetailActivity.a(OwnerInvoiceDetailActivity.this, (OIDetailModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse, OIDetailModel.class));
          if (OwnerInvoiceDetailActivity.this.stubError.getVisibility() == 0) {
            OwnerInvoiceDetailActivity.this.closeError(OwnerInvoiceDetailActivity.this.llContentContainer, OwnerInvoiceDetailActivity.this.stubError);
          }
          OwnerInvoiceDetailActivity.b(OwnerInvoiceDetailActivity.this);
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  public void initView() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = this;
    setContentView(2130903408);
    this.a = ButterKnife.bind(this);
    b();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131690078, 2131690613, 2131690616})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      paramView = new Intent(this, OwnerInvoiceListActivity.class);
      paramView.putExtra("beautyContractCode", this.y);
      paramView.putExtra("hireContractCode", this.x);
      startActivity(paramView);
      finish();
      return;
    case 2131690613: 
      d.newBuilder(this.d).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          OwnerInvoiceDetailActivity.c(OwnerInvoiceDetailActivity.this);
        }
      }).setTitle("温馨提示").setContent("你确定要取消开票吗？\n").setButtonText("取消", "确定").show();
      return;
    }
    g();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */