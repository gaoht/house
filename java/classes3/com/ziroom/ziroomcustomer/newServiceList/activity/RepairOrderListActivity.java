package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.a.j.a;
import com.ziroom.ziroomcustomer.newServiceList.model.aq;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairEvalActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairPlanActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.UrgencyRepairActivity;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairOrderListActivity
  extends BaseActivity
  implements View.OnClickListener, j.a, XListView.a
{
  private Context a;
  private UserInfo b;
  private LinearLayout c;
  private XListView d;
  private com.ziroom.ziroomcustomer.newServiceList.a.j e;
  private List<aq> f = new ArrayList();
  private ImageView g;
  private int r = 1;
  private int s = 1000;
  private String t;
  private BroadcastReceiver u = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if ((!paramAnonymousContext.equals("repair_order_delete")) || (paramAnonymousContext.equals("external_repair_order_delete"))) {}
    }
  };
  
  private void a()
  {
    this.g.setOnClickListener(this);
    this.d.setPullLoadEnable(false);
    this.d.setPullRefreshEnable(true);
    this.d.setXListViewListener(this);
    this.e.setOnClickBtnListener(this);
  }
  
  private void a(List<String> paramList)
  {
    showProgressNoCancel("", 30000L);
    com.ziroom.ziroomcustomer.e.j.cancelInternalRepairOrder(this.a, "", new a(new com.ziroom.ziroomcustomer.newrepair.utils.b(null)), paramList);
  }
  
  private void b()
  {
    e();
  }
  
  private void d(String paramString)
  {
    showEmptyView(this.c, paramString).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ah.isNetworkAvailable(RepairOrderListActivity.f(RepairOrderListActivity.this)))
        {
          RepairOrderListActivity.g(RepairOrderListActivity.this);
          return;
        }
        g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), "请检查网络！");
      }
    });
  }
  
  private void e()
  {
    showProgress("");
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", this.r + "");
    localHashMap.put("pageSize", this.s + "");
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localHashMap.put("uid", this.t);
    localHashMap.put("timestamp", String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10));
    localHashMap.put("userPhone", this.b.getLogin_name_mobile());
    localHashMap.put("osType", "2");
    localHashMap.put("visitType", "-1");
    com.ziroom.ziroomcustomer.e.j.getInternalOrderList(this.a, localHashMap, new b(new com.ziroom.ziroomcustomer.newrepair.utils.a(aq.class, false)));
  }
  
  private void f()
  {
    this.d = ((XListView)findViewById(2131692183));
    this.g = ((ImageView)findViewById(2131689492));
    this.c = ((LinearLayout)findViewById(2131689998));
    this.e = new com.ziroom.ziroomcustomer.newServiceList.a.j(this.a, null, null);
  }
  
  private void g()
  {
    this.d.stopRefresh();
    this.d.stopLoadMore();
    this.d.setRefreshTime("刚刚");
  }
  
  public void cancelOrder(List<String> paramList)
  {
    showCancelOrderDialog(paramList);
  }
  
  public void confirmOrder(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = new Intent(this.a, InternalRepairPlanActivity.class);
    paramString2.putExtra("isDetail", false);
    paramString2.putExtra("mailBillId", paramString1);
    paramString2.putExtra("isFromList", false);
    startActivity(paramString2);
  }
  
  public void eval(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(this.a, InternalRepairEvalActivity.class);
    localIntent.putExtra("headUrl", paramString1);
    localIntent.putExtra("name", paramString2);
    localIntent.putExtra("mailBillId", paramString3);
    startActivity(localIntent);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903450);
    this.a = this;
    this.b = ApplicationEx.c.getUser();
    if (this.b != null)
    {
      this.t = this.b.getUid();
      f();
      a();
      b();
    }
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    e();
  }
  
  protected void onResume()
  {
    super.onResume();
    onRefresh();
  }
  
  public void passOrder(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(this.a, InternalRepairPlanActivity.class);
    localIntent.putExtra("isDetail", true);
    localIntent.putExtra("mailBillId", paramString1);
    localIntent.putExtra("isFromList", true);
    localIntent.putExtra("orderCode", paramString2);
    localIntent.putExtra("orderCodeType", paramString3);
    startActivity(localIntent);
  }
  
  public void payForIt(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.a, UrgencyRepairActivity.class);
    localIntent.putExtra("orderCode", paramString1);
    localIntent.putExtra("orderCodeType", paramString2);
    startActivity(localIntent);
  }
  
  public void promptOrder(String paramString)
  {
    com.ziroom.ziroomcustomer.e.j.promptInternalRepairOrder(this.a, paramString, new c(new com.ziroom.ziroomcustomer.newrepair.utils.b(null)));
  }
  
  public void showCancelOrderDialog(final List<String> paramList)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("是否确认取消订单").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          RepairOrderListActivity.b(RepairOrderListActivity.this, paramList);
        }
      }
    }).build().show();
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      RepairOrderListActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), "取消订单成功！");
        RepairOrderListActivity.this.onRefresh();
      }
      for (;;)
      {
        RepairOrderListActivity.this.dismissProgress();
        return;
        paraml = paraml.getMessage();
        g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), paraml);
      }
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      RepairOrderListActivity.this.dismissProgress();
      RepairOrderListActivity.a(RepairOrderListActivity.this, "点击重试");
      RepairOrderListActivity.a(RepairOrderListActivity.this);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      RepairOrderListActivity.a(RepairOrderListActivity.this);
      if (paraml.getSuccess().booleanValue())
      {
        RepairOrderListActivity.a(RepairOrderListActivity.this, (List)paraml.getObject());
        if ((RepairOrderListActivity.b(RepairOrderListActivity.this) != null) && (RepairOrderListActivity.b(RepairOrderListActivity.this).size() > 0))
        {
          RepairOrderListActivity.c(RepairOrderListActivity.this).setData(RepairOrderListActivity.b(RepairOrderListActivity.this));
          RepairOrderListActivity.d(RepairOrderListActivity.this).setAdapter(RepairOrderListActivity.c(RepairOrderListActivity.this));
          RepairOrderListActivity.this.closeEmpty(RepairOrderListActivity.e(RepairOrderListActivity.this));
        }
      }
      for (;;)
      {
        RepairOrderListActivity.this.dismissProgress();
        return;
        if ((RepairOrderListActivity.b(RepairOrderListActivity.this) != null) && (RepairOrderListActivity.b(RepairOrderListActivity.this).size() == 0))
        {
          RepairOrderListActivity.this.closeEmpty(RepairOrderListActivity.e(RepairOrderListActivity.this));
          RepairOrderListActivity.a(RepairOrderListActivity.this, "您还没有家修订单");
        }
        else
        {
          g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), "获取数据失败，请稍后再试！");
          RepairOrderListActivity.a(RepairOrderListActivity.this, "点击重试");
          continue;
          paraml = paraml.getMessage();
          g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), paraml);
          RepairOrderListActivity.a(RepairOrderListActivity.this, "点击重试");
        }
      }
    }
  }
  
  class c
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public c(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), "催单单失败，请稍后重试！");
      RepairOrderListActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), "催单成功！");
        RepairOrderListActivity.this.onRefresh();
      }
      for (;;)
      {
        RepairOrderListActivity.this.dismissProgress();
        return;
        paraml = paraml.getMessage();
        g.textToast(RepairOrderListActivity.f(RepairOrderListActivity.this), paraml);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairOrderListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */