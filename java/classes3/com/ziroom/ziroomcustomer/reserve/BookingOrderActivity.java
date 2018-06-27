package com.ziroom.ziroomcustomer.reserve;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BookingOrderActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private XListView a;
  private String b;
  private Context c;
  private int d = 1;
  private int e = 3;
  private List<d> f;
  private String g;
  private String r;
  private LinearLayout s;
  private BroadcastReceiver t = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 7)
      {
        paramAnonymousContext = ApplicationEx.c.getmActivity();
        if (paramAnonymousContext != null)
        {
          paramAnonymousContext = paramAnonymousContext.iterator();
          while (paramAnonymousContext.hasNext()) {
            ((Activity)paramAnonymousContext.next()).finish();
          }
        }
        BookingOrderActivity.this.finish();
      }
    }
  };
  private b u;
  
  private void a()
  {
    this.a.stopRefresh();
    this.a.stopLoadMore();
    this.a.setRefreshTime("刚刚");
  }
  
  public void initView()
  {
    this.a.setPullRefreshEnable(false);
    this.a.setPullLoadEnable(true);
    this.u = new b(this.f, this.c, this.g);
    this.u.setmNotify(new b.a()
    {
      public void notify(String paramAnonymousString)
      {
        BookingOrderActivity.a(BookingOrderActivity.this, 1);
        paramAnonymousString = q.s + e.m.i;
        Map localMap = g.buildGetreserveOrderList(BookingOrderActivity.c(BookingOrderActivity.this), BookingOrderActivity.i(BookingOrderActivity.this));
        j.getReservationOrderText(BookingOrderActivity.j(BookingOrderActivity.this), new BookingOrderActivity.a(BookingOrderActivity.this), localMap, false, paramAnonymousString);
      }
    });
    this.a.setAdapter(this.u);
    this.a.setXListViewListener(new XListView.a()
    {
      public void onLoadMore()
      {
        BookingOrderActivity.k(BookingOrderActivity.this);
        Map localMap = g.buildGetreserveOrderList(BookingOrderActivity.c(BookingOrderActivity.this), BookingOrderActivity.i(BookingOrderActivity.this));
        j.getReservationOrderText(BookingOrderActivity.j(BookingOrderActivity.this), new BookingOrderActivity.a(BookingOrderActivity.this), localMap, false, BookingOrderActivity.b(BookingOrderActivity.this));
      }
      
      public void onRefresh() {}
    });
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if ("orders".equals(this.r))
    {
      finish();
      return;
    }
    toMain();
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
    if ("orders".equals(this.r))
    {
      finish();
      return;
    }
    toMain();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903659);
    this.c = this;
    this.b = (q.s + e.m.i);
    this.g = com.ziroom.ziroomcustomer.base.b.d;
    paramBundle = g.buildGetreserveOrderList(this.d, this.e);
    j.getReservationOrderText(this.c, new a(), paramBundle, false, this.b);
    paramBundle = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.t, paramBundle);
    this.r = getIntent().getStringExtra("from");
    this.s = ((LinearLayout)findViewById(2131689818));
    this.a = ((XListView)findViewById(2131693189));
    paramBundle = (BasicZiroomToolBar)findViewById(2131689787);
    paramBundle.setTitle("合租/整租订单");
    paramBundle.setOnBackClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ("orders".equals(BookingOrderActivity.a(BookingOrderActivity.this)))
        {
          BookingOrderActivity.this.finish();
          return;
        }
        BookingOrderActivity.this.toMain();
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.t);
  }
  
  public void toMain()
  {
    Intent localIntent = new Intent(this, MainActivity.class);
    localIntent.putExtra("FRAGMENT_TYPE", 7);
    startActivity(localIntent);
    finish();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (BookingOrderActivity.b(BookingOrderActivity.this).equals(paramk.getUrl()))
        {
          paramString = a.parseArray(paramString.get("data").toString(), d.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (BookingOrderActivity.b(BookingOrderActivity.this).equals(paramk.getUrl()))
        {
          BookingOrderActivity.a(BookingOrderActivity.this, (List)paramk.getObject());
          if (BookingOrderActivity.c(BookingOrderActivity.this) != 1) {
            break label121;
          }
          if (BookingOrderActivity.d(BookingOrderActivity.this).size() <= 0) {
            break label101;
          }
          BookingOrderActivity.this.initView();
          BookingOrderActivity.e(BookingOrderActivity.this).setVisibility(0);
          BookingOrderActivity.f(BookingOrderActivity.this);
        }
      }
      for (;;)
      {
        BookingOrderActivity.this.dismissProgress();
        return;
        label101:
        BookingOrderActivity.e(BookingOrderActivity.this).setEmptyView(BookingOrderActivity.g(BookingOrderActivity.this));
        continue;
        label121:
        BookingOrderActivity.h(BookingOrderActivity.this).getmList().addAll(BookingOrderActivity.d(BookingOrderActivity.this));
        BookingOrderActivity.h(BookingOrderActivity.this).notifyDataSetChanged();
        BookingOrderActivity.f(BookingOrderActivity.this);
        continue;
        paramk = paramk.getMessage();
        BookingOrderActivity.this.showToast(paramk);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/reserve/BookingOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */