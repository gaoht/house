package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.h;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OIInvoiceListModel;
import com.ziroom.ziroomcustomer.my.model.OIInvoiceListModel.InvoiceListBean;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;

public class OwnerInvoiceListActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  OIInvoiceListModel b;
  @BindView(2131690078)
  ImageView btnBack;
  private String d = OwnerInvoiceListActivity.class.getSimpleName();
  private Context e;
  private List<OIInvoiceListModel.InvoiceListBean> f = new ArrayList();
  private a g;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131690622)
  ListView lvOwnerInvoices;
  private String r;
  private String s;
  @BindView(2131690620)
  ViewStub stubError;
  private String t;
  @BindView(2131692005)
  TextView tvInvoiceDesc;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void b()
  {
    this.t = getIntent().getStringExtra("beautyContractCode");
    this.s = getIntent().getStringExtra("hireContractCode");
  }
  
  private void e()
  {
    f();
    this.g.notifyDataSetChanged();
  }
  
  private void f()
  {
    if (ae.isNull(this.b.topTip))
    {
      this.tvInvoiceDesc.setVisibility(8);
      return;
    }
    this.tvInvoiceDesc.setVisibility(0);
    this.tvInvoiceDesc.setText(this.b.topTip);
  }
  
  void a()
  {
    showError(this.llContentContainer, this.stubError, "网络故障，");
  }
  
  public void initData()
  {
    if (ApplicationEx.c.getUser() != null) {
      this.r = ApplicationEx.c.getUser().getUid();
    }
    for (;;)
    {
      j.getInvoiceList(this, g.buildInvoiceList(this.r, this.t), new f(this, new h())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          OwnerInvoiceListActivity.this.c.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(OwnerInvoiceListActivity.a(OwnerInvoiceListActivity.this), "===ymq:" + paramAnonymouse.toString());
            OwnerInvoiceListActivity.this.b = ((OIInvoiceListModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse + "", OIInvoiceListModel.class));
            if (OwnerInvoiceListActivity.this.stubError.getVisibility() == 0) {
              OwnerInvoiceListActivity.this.closeError(OwnerInvoiceListActivity.this.llContentContainer, OwnerInvoiceListActivity.this.stubError);
            }
            if (OwnerInvoiceListActivity.this.b != null)
            {
              OwnerInvoiceListActivity.a(OwnerInvoiceListActivity.this, OwnerInvoiceListActivity.this.b.invoiceList);
              OwnerInvoiceListActivity.b(OwnerInvoiceListActivity.this);
            }
            return;
          }
          af.showToast(OwnerInvoiceListActivity.this, "返回数据为空");
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  public void initView()
  {
    this.g = new a();
    this.lvOwnerInvoices.setAdapter(this.g);
  }
  
  public void onBackPressed()
  {
    setResult(999);
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = this;
    setContentView(2130903409);
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
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    b();
    initData();
  }
  
  @OnClick({2131690078})
  public void onViewClicked() {}
  
  @OnClick({2131690078, 2131689541})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  static class ViewHolder
  {
    @BindView(2131695517)
    TextView btnDownloadInvoice;
    @BindView(2131695511)
    TextView btnOpenInvoice;
    @BindView(2131695516)
    LinearLayout llContainerDownloadInvoice;
    @BindView(2131695512)
    LinearLayout llContainerNotOpen;
    @BindView(2131695509)
    LinearLayout llContainerOpen;
    @BindView(2131695518)
    LinearLayout llContainerReason;
    @BindView(2131692012)
    TextView ownerInvoiceName;
    @BindView(2131695513)
    TextView ownerInvoicePriceNotOpen;
    @BindView(2131695510)
    TextView ownerInvoicePriceOpen;
    @BindView(2131695508)
    TextView ownerInvoiceStatus;
    @BindView(2131695515)
    TextView ownerInvoiceTime;
    @BindView(2131695514)
    TextView ownerInvoiceType;
    @BindView(2131695519)
    TextView tvInvoiceReason;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  class a
    extends BaseAdapter
  {
    OwnerInvoiceListActivity.ViewHolder a;
    
    a() {}
    
    public int getCount()
    {
      if (OwnerInvoiceListActivity.c(OwnerInvoiceListActivity.this) == null) {
        return 0;
      }
      return OwnerInvoiceListActivity.c(OwnerInvoiceListActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return OwnerInvoiceListActivity.c(OwnerInvoiceListActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(OwnerInvoiceListActivity.d(OwnerInvoiceListActivity.this), 2130904419, null);
        this.a = new OwnerInvoiceListActivity.ViewHolder(paramView);
        paramView.setTag(this.a);
        paramViewGroup = (OIInvoiceListModel.InvoiceListBean)OwnerInvoiceListActivity.c(OwnerInvoiceListActivity.this).get(paramInt);
        this.a.ownerInvoiceName.setText(paramViewGroup.feeName);
        if (!paramViewGroup.applyButton) {
          break label231;
        }
        this.a.ownerInvoiceStatus.setVisibility(8);
        this.a.llContainerOpen.setVisibility(0);
        this.a.llContainerNotOpen.setVisibility(8);
        this.a.ownerInvoicePriceOpen.setText("" + paramViewGroup.amount);
        this.a.btnOpenInvoice.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(OwnerInvoiceListActivity.d(OwnerInvoiceListActivity.this), OwnerInvoiceOpenActivity.class);
            paramAnonymousView.putExtra("hireContractCode", OwnerInvoiceListActivity.e(OwnerInvoiceListActivity.this));
            paramAnonymousView.putExtra("beautyContractCode", OwnerInvoiceListActivity.f(OwnerInvoiceListActivity.this));
            paramAnonymousView.putExtra("feeCode", paramViewGroup.feeCode);
            paramAnonymousView.putExtra("applyCode", paramViewGroup.applyCode);
            OwnerInvoiceListActivity.d(OwnerInvoiceListActivity.this).startActivity(paramAnonymousView);
          }
        });
        label162:
        if (!paramViewGroup.downButton) {
          break label356;
        }
        this.a.llContainerDownloadInvoice.setVisibility(0);
        label180:
        if (!ae.isNull(paramViewGroup.rejectReason)) {
          break label371;
        }
        this.a.llContainerReason.setVisibility(8);
      }
      for (;;)
      {
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!paramViewGroup.applyButton)
            {
              paramAnonymousView = new Intent(OwnerInvoiceListActivity.d(OwnerInvoiceListActivity.this), OwnerInvoiceDetailActivity.class);
              paramAnonymousView.putExtra("beautyContractCode", OwnerInvoiceListActivity.f(OwnerInvoiceListActivity.this));
              paramAnonymousView.putExtra("hireContractCode", OwnerInvoiceListActivity.e(OwnerInvoiceListActivity.this));
              paramAnonymousView.putExtra("applyCode", paramViewGroup.applyCode);
              OwnerInvoiceListActivity.d(OwnerInvoiceListActivity.this).startActivity(paramAnonymousView);
            }
          }
        });
        return paramView;
        this.a = ((OwnerInvoiceListActivity.ViewHolder)paramView.getTag());
        break;
        label231:
        this.a.ownerInvoiceStatus.setVisibility(0);
        this.a.ownerInvoiceStatus.setText(paramViewGroup.statusName);
        this.a.llContainerOpen.setVisibility(8);
        this.a.llContainerNotOpen.setVisibility(0);
        this.a.ownerInvoicePriceNotOpen.setText("" + paramViewGroup.amount);
        this.a.ownerInvoiceStatus.setText(paramViewGroup.statusName);
        this.a.ownerInvoiceType.setText(paramViewGroup.type);
        this.a.ownerInvoiceTime.setText(paramViewGroup.applyDate);
        break label162;
        label356:
        this.a.llContainerDownloadInvoice.setVisibility(8);
        break label180;
        label371:
        this.a.llContainerReason.setVisibility(0);
        this.a.tvInvoiceReason.setText("驳回原因：" + paramViewGroup.rejectReason);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoiceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */