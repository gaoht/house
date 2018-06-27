package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class SharedLifeOrdersActivity
  extends BaseActivity
  implements XListView.a
{
  private Context a;
  private ImageView b;
  private XListView c;
  private String d;
  private List<com.ziroom.ziroomcustomer.sharedlife.c.d> e = new ArrayList();
  private int f = 1;
  private com.ziroom.ziroomcustomer.sharedlife.a.d g;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((XListView)findViewById(2131691811));
  }
  
  private void b()
  {
    this.d = getIntent().getStringExtra("rentContractCode");
    this.c.setPullLoadEnable(false);
    this.c.setPullRefreshEnable(true);
    this.c.setXListViewListener(this);
    this.g = new com.ziroom.ziroomcustomer.sharedlife.a.d(this.a, this.e);
    this.c.setAdapter(this.g);
    b(1);
  }
  
  private void b(int paramInt)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null)
    {
      g.textToast(this.a, "请重新登陆");
      return;
    }
    com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeOrderList(this, localUserInfo.getUid(), this.d, paramInt, new com.ziroom.ziroomcustomer.e.a.d(this, new e(com.ziroom.ziroomcustomer.sharedlife.c.d.class))
    {
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.sharedlife.c.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        SharedLifeOrdersActivity.a(SharedLifeOrdersActivity.this);
        if (paramAnonymousList != null)
        {
          SharedLifeOrdersActivity.b(SharedLifeOrdersActivity.this).setPullLoadEnable(true);
          SharedLifeOrdersActivity.c(SharedLifeOrdersActivity.this).addAll(paramAnonymousList);
          SharedLifeOrdersActivity.d(SharedLifeOrdersActivity.this).notifyDataSetChanged();
          return;
        }
        SharedLifeOrdersActivity.b(SharedLifeOrdersActivity.this).setPullLoadEnable(false);
      }
    });
  }
  
  private void e()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeOrdersActivity.this.finish();
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((SharedLifeOrdersActivity.c(SharedLifeOrdersActivity.this) == null) || (SharedLifeOrdersActivity.c(SharedLifeOrdersActivity.this).size() == 0)) {
          return;
        }
        paramAnonymousAdapterView = new Intent(SharedLifeOrdersActivity.e(SharedLifeOrdersActivity.this), SharedLifeOrderDetailActivity.class);
        paramAnonymousAdapterView.putExtra("rentContractCode", SharedLifeOrdersActivity.f(SharedLifeOrdersActivity.this));
        paramAnonymousAdapterView.putExtra("orderCode", ((com.ziroom.ziroomcustomer.sharedlife.c.d)SharedLifeOrdersActivity.c(SharedLifeOrdersActivity.this).get(paramAnonymousInt - 1)).getOrderCode());
        SharedLifeOrdersActivity.this.startActivityForResult(paramAnonymousAdapterView, 1111);
      }
    });
  }
  
  private void f()
  {
    this.c.stopRefresh();
    this.c.stopLoadMore();
    this.c.setRefreshTime("刚刚");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1111) && (paramInt2 == -1)) {
      b(1);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903491);
    this.a = this;
    a();
    b();
    e();
  }
  
  public void onLoadMore()
  {
    int i = this.f + 1;
    this.f = i;
    b(i);
  }
  
  public void onRefresh()
  {
    this.c.setPullLoadEnable(false);
    this.f = 1;
    this.e.clear();
    this.g.notifyDataSetChanged();
    b(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeOrdersActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */