package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.ak;
import com.ziroom.ziroomcustomer.bestgoods.model.ar;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newrepair.utils.b;
import com.ziroom.ziroomcustomer.newrepair.utils.c;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YouPinListActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private Context a;
  private ImageView b;
  private LinearLayout c;
  private XListView d;
  private UserInfo e;
  private int f = 1;
  private int g = 1000;
  private ar r;
  private Integer s;
  
  private void a()
  {
    this.a = this;
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((LinearLayout)findViewById(2131689998));
    this.d = ((XListView)findViewById(2131692726));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.d.setPullLoadEnable(false);
    this.d.setPullRefreshEnable(true);
    this.d.setXListViewListener(this);
  }
  
  private void d(String paramString)
  {
    showEmptyView(this.c, paramString).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ah.isNetworkAvailable(YouPinListActivity.c(YouPinListActivity.this)))
        {
          YouPinListActivity.f(YouPinListActivity.this);
          return;
        }
        g.textToast(YouPinListActivity.c(YouPinListActivity.this), "请检查网络连接");
      }
    });
  }
  
  private void e()
  {
    int i = getIntent().getIntExtra("orderState", -1);
    if (i == -1) {}
    for (this.s = null;; this.s = Integer.valueOf(i))
    {
      this.e = ApplicationEx.c.getUser();
      f();
      return;
    }
  }
  
  private void f()
  {
    if (ah.isNetworkAvailable(this.a))
    {
      showProgress("");
      HashMap localHashMap = new HashMap();
      localHashMap.put("page", this.f + "");
      localHashMap.put("pageSize", this.g + "");
      if (this.s == null) {
        localHashMap.put("orderState", "");
      }
      for (;;)
      {
        j.getYPOrderList(this.a, localHashMap, new a(new b(ar.class)));
        return;
        localHashMap.put("orderState", this.s + "");
      }
    }
    dismissProgress();
    d("请检查网络连接");
  }
  
  private void g()
  {
    this.d.stopRefresh();
    this.d.stopLoadMore();
    this.d.setRefreshTime("刚刚");
  }
  
  public void closeEmpty(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    for (;;)
    {
      return;
      View localView = paramViewGroup.findViewById(2131694408);
      if (localView != null) {
        paramViewGroup.removeView(localView);
      }
      LayoutInflater.from(this);
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        localView = paramViewGroup.getChildAt(i);
        if (!"humanControlled".equals(localView.getTag())) {
          localView.setVisibility(0);
        }
        i += 1;
      }
    }
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
    setContentView(2130903556);
    a();
    b();
    e();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    f();
  }
  
  public class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      c.catchExp(paramThrowable);
      YouPinListActivity.this.dismissProgress();
      YouPinListActivity.a(YouPinListActivity.this);
      YouPinListActivity.a(YouPinListActivity.this, "请点击重试");
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        YouPinListActivity.a(YouPinListActivity.this);
        YouPinListActivity.a(YouPinListActivity.this, (ar)paraml.getObject());
        if (YouPinListActivity.b(YouPinListActivity.this) == null)
        {
          YouPinListActivity.a(YouPinListActivity.this, "点击重试");
          g.textToast(YouPinListActivity.c(YouPinListActivity.this), "获取数据异常，请稍后再试！");
          return;
        }
        paraml = YouPinListActivity.b(YouPinListActivity.this).getList();
        if ((paraml != null) && (paraml.size() > 0))
        {
          paraml = new ak(YouPinListActivity.c(YouPinListActivity.this), paraml);
          YouPinListActivity.d(YouPinListActivity.this).setAdapter(paraml);
          YouPinListActivity.this.closeEmpty(YouPinListActivity.e(YouPinListActivity.this));
        }
      }
      for (;;)
      {
        YouPinListActivity.this.dismissProgress();
        return;
        if ((paraml != null) && (paraml.size() == 0))
        {
          YouPinListActivity.this.closeEmpty(YouPinListActivity.e(YouPinListActivity.this));
          YouPinListActivity.a(YouPinListActivity.this, "您还没有优品订单");
          continue;
          paraml = paraml.getMessage();
          g.textToast(YouPinListActivity.c(YouPinListActivity.this), paraml);
          YouPinListActivity.a(YouPinListActivity.this, "请点击重试");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */