package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillListModel.DataBean.BillListBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZryuBillListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static int b = 1;
  public static int c = 2;
  Unbinder a;
  private String d;
  private String e = ZryuBillListActivity.class.getSimpleName();
  private ZryuBillListModel f;
  private List<ZryuBillListModel.DataBean.BillListBean> g;
  @BindView(2131692830)
  RelativeLayout houseBillLayout;
  @BindView(2131692832)
  TextView houseBillLine;
  @BindView(2131692831)
  TextView houseBillText;
  @BindView(2131691914)
  ImageView ivLeaseBack;
  @BindView(2131692838)
  ListViewForScrollView leaseAllBillList;
  @BindView(2131692665)
  RelativeLayout leaseLinePop;
  @BindView(2131692829)
  LinearLayout leaseTab;
  @BindView(2131692836)
  View lineBelowTab;
  @BindView(2131692833)
  RelativeLayout livingCostBillLayout;
  @BindView(2131692835)
  TextView livingCostBillLine;
  @BindView(2131692834)
  TextView livingCostBillText;
  @BindView(2131692840)
  LinearLayout llEmptyContainer;
  private List<ZryuBillListModel.DataBean.BillListBean> r;
  private boolean s = false;
  @BindView(2131692837)
  ScrollView svLeaseListContainer;
  private b t;
  @BindView(2131692839)
  TextView tvCheckPaiedBills;
  @BindView(2131692841)
  TextView tvCheckPaiedBillsEmpty;
  @BindView(2131690822)
  TextView tvEmpty;
  @BindView(2131689541)
  TextView tvTitle;
  private c u;
  private int v = 1;
  private String w;
  private String x;
  
  private void a()
  {
    this.w = getResources().getString(2131297573);
    this.x = getResources().getString(2131297572);
    if (this.s)
    {
      this.tvTitle.setText("已支付账单列表");
      this.tvCheckPaiedBills.setVisibility(8);
      this.tvCheckPaiedBillsEmpty.setVisibility(8);
      this.t = new b(this, this.g);
      this.leaseAllBillList.setAdapter(this.t);
    }
    for (;;)
    {
      f();
      this.tvCheckPaiedBills.getPaint().setFlags(8);
      this.tvCheckPaiedBillsEmpty.getPaint().setFlags(8);
      this.ivLeaseBack.setOnClickListener(this);
      this.tvCheckPaiedBills.setOnClickListener(this);
      this.tvCheckPaiedBillsEmpty.setOnClickListener(this);
      this.houseBillLayout.setOnClickListener(this);
      this.livingCostBillLayout.setOnClickListener(this);
      return;
      this.tvTitle.setText("账单列表");
      this.tvCheckPaiedBills.setVisibility(0);
      this.tvCheckPaiedBillsEmpty.setVisibility(0);
      this.u = new c(this, this.g);
      this.leaseAllBillList.setAdapter(this.u);
    }
  }
  
  private void b()
  {
    if (checkNet(this))
    {
      Map localMap = c.buildGetContractBillList(this, this.d);
      e.getContractBillList(this, new a(), localMap, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void b(int paramInt)
  {
    if (b == paramInt)
    {
      if (this.v != paramInt)
      {
        this.v = b;
        this.houseBillText.setTextColor(Color.parseColor("#ffa000"));
        this.houseBillLine.setBackgroundColor(Color.parseColor("#ffa000"));
        this.livingCostBillText.setTextColor(Color.parseColor("#444444"));
        this.livingCostBillLine.setBackgroundColor(Color.parseColor("#ffffff"));
      }
      if (this.s) {
        this.t.setDatas(this.g);
      }
    }
    for (;;)
    {
      f();
      return;
      this.u.setDatas(this.g);
      continue;
      if (c == paramInt)
      {
        if (this.v != paramInt)
        {
          this.v = c;
          this.livingCostBillText.setTextColor(Color.parseColor("#ffa000"));
          this.livingCostBillLine.setBackgroundColor(Color.parseColor("#ffa000"));
          this.houseBillText.setTextColor(Color.parseColor("#444444"));
          this.houseBillLine.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        if (this.s) {
          this.t.setDatas(this.r);
        } else {
          this.u.setDatas(this.r);
        }
      }
    }
  }
  
  private void e()
  {
    this.g = new ArrayList();
    this.r = new ArrayList();
    if ((this.f.data != null) && (this.f.data.billList != null))
    {
      int i = 0;
      if (i < this.f.data.billList.size())
      {
        ZryuBillListModel.DataBean.BillListBean localBillListBean = (ZryuBillListModel.DataBean.BillListBean)this.f.data.billList.get(i);
        if (this.s) {
          if ((2 == localBillListBean.state) && (localBillListBean.payNum > 0)) {
            this.g.add(localBillListBean);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((2 == localBillListBean.state) && (localBillListBean.payNum == 0))
          {
            this.r.add(localBillListBean);
            continue;
            if ((2 != localBillListBean.state) && (localBillListBean.payNum > 0)) {
              this.g.add(localBillListBean);
            } else if ((2 != localBillListBean.state) && (localBillListBean.payNum == 0)) {
              this.r.add(localBillListBean);
            }
          }
        }
      }
    }
    b(this.v);
  }
  
  private void f()
  {
    if (b == this.v) {
      if ((this.g != null) && (this.g.size() > 0))
      {
        this.llEmptyContainer.setVisibility(8);
        this.svLeaseListContainer.setVisibility(0);
      }
    }
    while (c != this.v)
    {
      return;
      showEmptyView(this.w);
      return;
    }
    if ((this.r != null) && (this.r.size() > 0))
    {
      this.llEmptyContainer.setVisibility(8);
      this.svLeaseListContainer.setVisibility(0);
      return;
    }
    showEmptyView(this.x);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691914: 
      finish();
      return;
    case 2131692839: 
    case 2131692841: 
      paramView = new Intent(this, ZryuBillListActivity.class);
      paramView.putExtra("onlyHadPaied", true);
      paramView.putExtra("contractId", this.d);
      startActivity(paramView);
      return;
    case 2131692830: 
      b(b);
      return;
    }
    b(c);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903579);
    this.a = ButterKnife.bind(this);
    this.s = getIntent().getBooleanExtra("onlyHadPaied", false);
    this.d = getIntent().getStringExtra("contractId");
    u.i(this.e, "contractId:" + this.d);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  public void showEmptyView(String paramString)
  {
    this.llEmptyContainer.setVisibility(0);
    this.svLeaseListContainer.setVisibility(8);
    this.tvEmpty.setText(paramString);
  }
  
  static class PaiedViewHolder
  {
    @BindView(2131695887)
    LinearLayout ll_zryu_online_had_pay_item;
    @BindView(2131692814)
    TextView tvBillNum;
    @BindView(2131695888)
    TextView tvBillTitle;
    @BindView(2131695891)
    TextView tvRealPayPrice;
    @BindView(2131695889)
    TextView tvRealPayTime;
    @BindView(2131695890)
    TextView tvShouldPayPrice;
    @BindView(2131692817)
    TextView tvShouldPayTime;
    
    PaiedViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  static class WillViewHolder
  {
    @BindView(2131695893)
    TextView btnTvToPay;
    @BindView(2131691870)
    LinearLayout llBtn;
    @BindView(2131695892)
    LinearLayout ll_zryu_online_will_pay_item;
    @BindView(2131692814)
    TextView tvBillNum;
    @BindView(2131695888)
    TextView tvBillTitle;
    @BindView(2131695891)
    TextView tvRealPayPrice;
    @BindView(2131695890)
    TextView tvShouldPayPrice;
    @BindView(2131692817)
    TextView tvShouldPayTime;
    @BindView(2131694452)
    TextView tvWillPayPrice;
    @BindView(2131689863)
    View vDivider;
    
    WillViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuBillListActivity.c(ZryuBillListActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuBillListActivity.a(ZryuBillListActivity.this, (ZryuBillListModel)paramk.getObject());
        if (ZryuBillListActivity.a(ZryuBillListActivity.this) != null)
        {
          if (200 == ZryuBillListActivity.a(ZryuBillListActivity.this).error_code) {
            ZryuBillListActivity.b(ZryuBillListActivity.this);
          }
        }
        else {
          return;
        }
        ZryuBillListActivity.this.showToast(ZryuBillListActivity.a(ZryuBillListActivity.this).error_message);
        return;
      }
      ZryuBillListActivity.this.showToast(paramk.getMessage());
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private Context b;
    private List<ZryuBillListModel.DataBean.BillListBean> c;
    
    public b(List<ZryuBillListModel.DataBean.BillListBean> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        ZryuBillListActivity.PaiedViewHolder localPaiedViewHolder = (ZryuBillListActivity.PaiedViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = localPaiedViewHolder;
        if (((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).payNum <= 0) {
          break label284;
        }
        paramView.tvBillTitle.setText("第" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).payNum + "期");
      }
      for (;;)
      {
        paramView.tvBillNum.setText(((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).billNum);
        paramView.tvShouldPayTime.setText(((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).gatherDateStr);
        paramView.tvShouldPayPrice.setText("¥" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).oughtTotalAmountStr);
        paramView.tvRealPayPrice.setText("¥" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).actualAmountStr);
        paramView.tvRealPayTime.setText(((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).paymentTime);
        paramView.ll_zryu_online_had_pay_item.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(ZryuBillListActivity.this, ZryuBillDetailOptiActivity.class);
            paramAnonymousView.putExtra("billFid", ((ZryuBillListModel.DataBean.BillListBean)ZryuBillListActivity.b.a(ZryuBillListActivity.b.this).get(paramInt)).billFid);
            ZryuBillListActivity.b.b(ZryuBillListActivity.b.this).startActivity(paramAnonymousView);
          }
        });
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904621, paramViewGroup, false);
        paramView = new ZryuBillListActivity.PaiedViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
        break;
        label284:
        paramView.tvBillTitle.setText("生活费用账单");
      }
    }
    
    public void setDatas(List<ZryuBillListModel.DataBean.BillListBean> paramList)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
  }
  
  private class c
    extends BaseAdapter
  {
    private Context b;
    private List<ZryuBillListModel.DataBean.BillListBean> c;
    
    public c(List<ZryuBillListModel.DataBean.BillListBean> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      label83:
      final int i;
      if (paramView != null)
      {
        ZryuBillListActivity.WillViewHolder localWillViewHolder = (ZryuBillListActivity.WillViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = localWillViewHolder;
        if (((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).payNum <= 0) {
          break label346;
        }
        paramView.tvBillTitle.setText("第" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).payNum + "期");
        paramView.tvBillNum.setText(((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).billNum);
        paramView.tvShouldPayTime.setText(((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).gatherDateStr);
        paramView.tvShouldPayPrice.setText("¥" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).oughtTotalAmountStr);
        paramView.tvRealPayPrice.setText("¥" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).actualAmountStr);
        paramView.tvWillPayPrice.setText("¥" + ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).pendingAmountStr);
        i = ((ZryuBillListModel.DataBean.BillListBean)this.c.get(paramInt)).showPay;
        if (i != 1) {
          break label358;
        }
        paramView.llBtn.setVisibility(8);
        paramView.vDivider.setVisibility(8);
      }
      for (;;)
      {
        paramView.ll_zryu_online_will_pay_item.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(ZryuBillListActivity.this, ZryuBillDetailOptiActivity.class);
            paramAnonymousView.putExtra("billFid", ((ZryuBillListModel.DataBean.BillListBean)ZryuBillListActivity.c.a(ZryuBillListActivity.c.this).get(paramInt)).billFid);
            paramAnonymousView.putExtra("showPay", i);
            ((ZryuBillListActivity)ZryuBillListActivity.c.b(ZryuBillListActivity.c.this)).startActivityForResult(paramAnonymousView, 0);
          }
        });
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904622, paramViewGroup, false);
        paramView = new ZryuBillListActivity.WillViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
        break;
        label346:
        paramView.tvBillTitle.setText("生活费用账单");
        break label83;
        label358:
        paramView.llBtn.setVisibility(0);
        paramView.btnTvToPay.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(ZryuBillListActivity.this, ZryuBillDetailOptiActivity.class);
            paramAnonymousView.putExtra("billFid", ((ZryuBillListModel.DataBean.BillListBean)ZryuBillListActivity.c.a(ZryuBillListActivity.c.this).get(paramInt)).billFid);
            ((ZryuBillListActivity)ZryuBillListActivity.c.b(ZryuBillListActivity.c.this)).startActivityForResult(paramAnonymousView, 0);
          }
        });
        paramView.vDivider.setVisibility(0);
      }
    }
    
    public void setDatas(List<ZryuBillListModel.DataBean.BillListBean> paramList)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuBillListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */