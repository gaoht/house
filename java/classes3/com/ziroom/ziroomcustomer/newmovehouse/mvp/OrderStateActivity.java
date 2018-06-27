package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public class OrderStateActivity
  extends BaseActivity
  implements j.b
{
  private j.a a;
  private View b;
  private TextView c;
  private View d;
  private PullToRefreshScrollView e;
  private ListViewForScrollView f;
  private FragmentActivity g;
  
  private void a()
  {
    this.b = findViewById(2131689492);
    this.c = ((TextView)findViewById(2131689541));
    this.d = findViewById(2131690023);
    this.d.setVisibility(8);
    this.c.setText("订单跟踪");
    this.e = ((PullToRefreshScrollView)findViewById(2131690468));
    this.f = ((ListViewForScrollView)findViewById(2131691763));
    this.e.setMode(PullToRefreshBase.b.b);
    this.e.setOnRefreshListener(new PullToRefreshBase.d()
    {
      public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
      {
        OrderStateActivity.a(OrderStateActivity.this).refresh();
      }
    });
    View localView = findViewById(2131690279);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        OrderStateActivity.this.finish();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        OrderStateActivity.a(OrderStateActivity.this).toChat();
      }
    });
  }
  
  public BaseActivity getActivity()
  {
    return this;
  }
  
  public Intent getExtras()
  {
    return getIntent();
  }
  
  public Context getViewContext()
  {
    return this.g;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903350);
    this.g = this;
    a();
    new k(this);
    this.a.start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.detachView();
  }
  
  public void onLoad()
  {
    if ((this.e != null) && (this.e.isRefreshing())) {
      this.e.onRefreshComplete();
    }
  }
  
  public void setPresenter(j.a parama)
  {
    this.a = parama;
  }
  
  public void setXLAdapter(BaseAdapter paramBaseAdapter)
  {
    this.f.setAdapter(paramBaseAdapter);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/OrderStateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */