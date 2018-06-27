package com.ziroom.ziroomcustomer.repay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.repay.a.b;
import com.ziroom.ziroomcustomer.repay.adapter.RepayBillListAdapter;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepayBillListActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private List<b> c;
  private List<b> d;
  private List<b> e;
  private String f;
  private RepayBillListAdapter g;
  @BindView(2131692205)
  ListView list_bill_repay_lv;
  @BindView(2131692203)
  TextLineView repay_bill_tab_not_tl;
  @BindView(2131692204)
  TextLineView repay_bill_tab_pay_tl;
  
  private void a()
  {
    this.repay_bill_tab_not_tl.setOnCheckShowListener(new TextLineView.a()
    {
      public void onCheckShow(View paramAnonymousView)
      {
        if (RepayBillListActivity.a(RepayBillListActivity.this) == null) {
          return;
        }
        if (RepayBillListActivity.b(RepayBillListActivity.this) == null)
        {
          RepayBillListActivity.a(RepayBillListActivity.this, new RepayBillListAdapter(RepayBillListActivity.a(RepayBillListActivity.this), RepayBillListActivity.c(RepayBillListActivity.this)));
          RepayBillListActivity.this.list_bill_repay_lv.setAdapter(RepayBillListActivity.b(RepayBillListActivity.this));
          return;
        }
        RepayBillListActivity.b(RepayBillListActivity.this).setmList(RepayBillListActivity.a(RepayBillListActivity.this));
        RepayBillListActivity.b(RepayBillListActivity.this).notifyDataSetChanged();
      }
    });
    this.repay_bill_tab_pay_tl.setOnCheckShowListener(new TextLineView.a()
    {
      public void onCheckShow(View paramAnonymousView)
      {
        if (RepayBillListActivity.d(RepayBillListActivity.this) == null) {
          return;
        }
        if (RepayBillListActivity.b(RepayBillListActivity.this) == null)
        {
          RepayBillListActivity.a(RepayBillListActivity.this, new RepayBillListAdapter(RepayBillListActivity.d(RepayBillListActivity.this), RepayBillListActivity.c(RepayBillListActivity.this)));
          RepayBillListActivity.this.list_bill_repay_lv.setAdapter(RepayBillListActivity.b(RepayBillListActivity.this));
          return;
        }
        RepayBillListActivity.b(RepayBillListActivity.this).setmList(RepayBillListActivity.d(RepayBillListActivity.this));
        RepayBillListActivity.b(RepayBillListActivity.this).notifyDataSetChanged();
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    this.repay_bill_tab_not_tl.setShow(paramBoolean, true);
    TextLineView localTextLineView = this.repay_bill_tab_pay_tl;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextLineView.setShow(paramBoolean, true);
      return;
    }
  }
  
  private void b()
  {
    this.f = getIntent().getStringExtra("contractCode");
  }
  
  private void e()
  {
    this.d = new ArrayList();
    this.e = new ArrayList();
    if (this.c == null) {
      return;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ("01".equals(localb.getZrSts())) {
        this.d.add(localb);
      } else if ("02".equals(localb.getZrSts())) {
        this.e.add(localb);
      }
    }
    a(this.repay_bill_tab_not_tl.isShow());
  }
  
  private void f()
  {
    j.getBillList(this, this.f, new com.ziroom.commonlibrary.a.a(this.b, new c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        if ("0".equals(paramAnonymouse.get("code") + ""))
        {
          RepayBillListActivity.a(RepayBillListActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymouse.get("data") + "", b.class));
          RepayBillListActivity.e(RepayBillListActivity.this);
        }
        for (;;)
        {
          dismissProgress();
          return;
          if ("101019".equals(paramAnonymouse.get("code") + "")) {
            RepayBillListActivity.this.showToast(paramAnonymouse.get("message") + "");
          } else {
            RepayBillListActivity.this.showToast(paramAnonymouse.get("message") + "");
          }
        }
      }
    });
  }
  
  @OnClick({2131692203, 2131692204, 2131690511})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690511: 
      finish();
      return;
    case 2131692203: 
      a(true);
      return;
    }
    a(false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903454);
    this.a = ButterKnife.bind(this);
    this.b = this;
    b();
    f();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayBillListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */