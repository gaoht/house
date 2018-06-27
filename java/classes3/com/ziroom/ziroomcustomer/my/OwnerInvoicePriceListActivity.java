package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.h;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.OIDetailPricesModel;
import com.ziroom.ziroomcustomer.my.model.OIDetailPricesModel.GoodDetailBean;
import com.ziroom.ziroomcustomer.my.model.OIDetailPricesModel.GoodsListBean;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.Iterator;
import java.util.List;

public class OwnerInvoicePriceListActivity
  extends OwnerBaseActivity
{
  Unbinder a;
  private String b = OwnerInvoicePriceListActivity.class.getSimpleName();
  @BindView(2131690078)
  ImageView btnBack;
  private Context d;
  private OIDetailPricesModel e;
  private a f;
  private List<OIDetailPricesModel.GoodsListBean> g;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131692011)
  ListViewForScrollView lvOwnerInvoices;
  @BindView(2131692012)
  TextView ownerInvoiceName;
  private String r;
  private String s;
  @BindView(2131690620)
  ViewStub stubError;
  private String t;
  @BindView(2131692013)
  TextView tvPriceTotal;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a(LinearLayout paramLinearLayout, List<OIDetailPricesModel.GoodDetailBean> paramList)
  {
    paramLinearLayout.removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        OIDetailPricesModel.GoodDetailBean localGoodDetailBean = (OIDetailPricesModel.GoodDetailBean)paramList.next();
        View localView = LayoutInflater.from(this.d).inflate(2130904422, null, false);
        TextView localTextView1 = (TextView)localView.findViewById(2131695033);
        TextView localTextView2 = (TextView)localView.findViewById(2131695034);
        localTextView1.setText(localGoodDetailBean.title);
        localTextView2.setText(localGoodDetailBean.value);
        paramLinearLayout.addView(localView);
      }
    }
  }
  
  private void b()
  {
    this.s = getIntent().getStringExtra("beautyContractCode");
    this.t = getIntent().getStringExtra("feeCode");
  }
  
  private void e()
  {
    this.tvPriceTotal.setText("" + this.e.totalNum);
    this.g = this.e.goodsList;
    this.f.notifyDataSetChanged();
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
      j.getPriceList(this, g.buildPriceList(this.r, this.s, this.t), new f(this, new h())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          OwnerInvoicePriceListActivity.this.c.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.logBigData(OwnerInvoicePriceListActivity.a(OwnerInvoicePriceListActivity.this), "===ymq:" + paramAnonymouse.toString());
          OwnerInvoicePriceListActivity.a(OwnerInvoicePriceListActivity.this, (OIDetailPricesModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), OIDetailPricesModel.class));
          if (OwnerInvoicePriceListActivity.this.stubError.getVisibility() == 0) {
            OwnerInvoicePriceListActivity.this.closeError(OwnerInvoicePriceListActivity.this.llContentContainer, OwnerInvoicePriceListActivity.this.stubError);
          }
          OwnerInvoicePriceListActivity.b(OwnerInvoicePriceListActivity.this);
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  public void initView()
  {
    this.f = new a();
    this.lvOwnerInvoices.setAdapter(this.f);
  }
  
  public void onBackPressed()
  {
    setResult(999);
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = this;
    setContentView(2130903411);
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
    @BindView(2131695520)
    LinearLayout llContainerPrices;
    @BindView(2131692012)
    TextView ownerInvoiceName;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  class a
    extends BaseAdapter
  {
    OwnerInvoicePriceListActivity.ViewHolder a;
    
    a() {}
    
    public int getCount()
    {
      if (OwnerInvoicePriceListActivity.c(OwnerInvoicePriceListActivity.this) == null) {
        return 0;
      }
      return OwnerInvoicePriceListActivity.c(OwnerInvoicePriceListActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return OwnerInvoicePriceListActivity.c(OwnerInvoicePriceListActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(OwnerInvoicePriceListActivity.d(OwnerInvoicePriceListActivity.this), 2130904420, null);
        this.a = new OwnerInvoicePriceListActivity.ViewHolder(paramView);
        paramView.setTag(this.a);
      }
      for (;;)
      {
        paramViewGroup = (OIDetailPricesModel.GoodsListBean)OwnerInvoicePriceListActivity.c(OwnerInvoicePriceListActivity.this).get(paramInt);
        this.a.ownerInvoiceName.setText(paramViewGroup.goodName);
        OwnerInvoicePriceListActivity.a(OwnerInvoicePriceListActivity.this, this.a.llContainerPrices, paramViewGroup.goodDetail);
        return paramView;
        this.a = ((OwnerInvoicePriceListActivity.ViewHolder)paramView.getTag());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerInvoicePriceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */