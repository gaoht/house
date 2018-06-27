package com.ziroom.ziroomcustomer.newclean.periodclean.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newclean.periodclean.a.b;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodGeneralDetailActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.OrderListStatus;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.c;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.i;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;

public class PeriodCleanStateFrament
  extends BaseFragment
{
  int a = 1;
  private PullToRefreshScrollView b;
  private ListViewForScrollView c;
  private String d;
  private FragmentActivity e;
  private List<OrderListStatus> f = new ArrayList();
  private b g;
  private TextView h;
  
  private void a(View paramView)
  {
    this.b = ((PullToRefreshScrollView)paramView.findViewById(2131690468));
    this.c = ((ListViewForScrollView)paramView.findViewById(2131691763));
    this.h = ((TextView)paramView.findViewById(2131690175));
  }
  
  private void c()
  {
    this.d = getArguments().getString("orderId");
    this.b.setMode(PullToRefreshBase.b.d);
    this.b.setOnRefreshListener(new PullToRefreshBase.d()
    {
      public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
      {
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("period_button_refresh", null));
        PeriodCleanStateFrament.this.a = 1;
        PeriodCleanStateFrament.a(PeriodCleanStateFrament.this).clear();
        PeriodCleanStateFrament.b(PeriodCleanStateFrament.this);
      }
    });
    this.b.setOnPullEventListener(new PullToRefreshBase.c()
    {
      public void onPullEvent(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase, PullToRefreshBase.i paramAnonymousi, PullToRefreshBase.b paramAnonymousb)
      {
        if (PullToRefreshBase.i.c == paramAnonymousi) {
          PeriodCleanStateFrament.b(PeriodCleanStateFrament.this);
        }
      }
    });
    this.g = new b(this.e, this.f);
    this.c.setAdapter(this.g);
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(PeriodCleanStateFrament.c(PeriodCleanStateFrament.this), PeriodGeneralDetailActivity.class);
        paramAnonymousAdapterView.putExtra("cleanId", PeriodCleanStateFrament.d(PeriodCleanStateFrament.this).getItem(paramAnonymousInt).getOrderCode());
        PeriodCleanStateFrament.c(PeriodCleanStateFrament.this).startActivity(paramAnonymousAdapterView);
      }
    });
    d();
  }
  
  private void d()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanOrderList(this.e, this.d, this.a, 10, new d(this.e, new e(OrderListStatus.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        PeriodCleanStateFrament.e(PeriodCleanStateFrament.this);
      }
      
      public void onSuccess(int paramAnonymousInt, List<OrderListStatus> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        PeriodCleanStateFrament.e(PeriodCleanStateFrament.this);
        PeriodCleanStateFrament.a(PeriodCleanStateFrament.this).addAll(paramAnonymousList);
        if (PeriodCleanStateFrament.a(PeriodCleanStateFrament.this).size() == 0) {
          PeriodCleanStateFrament.f(PeriodCleanStateFrament.this).setVisibility(0);
        }
        for (;;)
        {
          paramAnonymousList = PeriodCleanStateFrament.this;
          paramAnonymousList.a += 1;
          PeriodCleanStateFrament.d(PeriodCleanStateFrament.this).notifyDataSetChanged();
          return;
          PeriodCleanStateFrament.f(PeriodCleanStateFrament.this).setVisibility(8);
        }
      }
    });
  }
  
  private void e()
  {
    if ((this.b != null) && (this.b.isRefreshing())) {
      this.b.onRefreshComplete();
    }
  }
  
  public static PeriodCleanStateFrament getInstance(String paramString)
  {
    PeriodCleanStateFrament localPeriodCleanStateFrament = new PeriodCleanStateFrament();
    Bundle localBundle = new Bundle();
    localBundle.putString("orderId", paramString);
    localPeriodCleanStateFrament.setArguments(localBundle);
    return localPeriodCleanStateFrament;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903977, paramViewGroup, false);
    this.e = getActivity();
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/fragment/PeriodCleanStateFrament.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */