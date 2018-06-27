package com.ziroom.ziroomcustomer.minsu.landlord.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLOrderListBean.DataBean.OrderListBean;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.b.a.b;
import com.ziroom.ziroomcustomer.minsu.landlord.b.a.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.a.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinsuLLNeadDealOrderFragment
  extends BaseFragment
  implements a.a
{
  private Context a;
  private RecyclerView b;
  private int c = 1;
  private int d = 1;
  private com.ziroom.ziroomcustomer.minsu.landlord.b.a e;
  private List<Object> f = new LinkedList();
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.c += 1;
    }
    e();
  }
  
  private void c()
  {
    this.e = new com.ziroom.ziroomcustomer.minsu.landlord.b.a(this.a);
    this.e.setType(this.d);
    this.e.setmOnItemClickListener(new a.c()
    {
      public void onFooterClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        paramAnonymousView = MinsuLLNeadDealOrderFragment.this;
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          MinsuLLNeadDealOrderFragment.a(paramAnonymousView, paramAnonymousBoolean);
          return;
        }
      }
      
      public void onItemClick(View paramAnonymousView, int paramAnonymousInt)
      {
        if (MinsuLLNeadDealOrderFragment.a(MinsuLLNeadDealOrderFragment.this) == 1)
        {
          paramAnonymousView = (MinsuLLOrderListBean.DataBean.OrderListBean)MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).get(paramAnonymousInt);
          localIntent = new Intent(MinsuLLNeadDealOrderFragment.c(MinsuLLNeadDealOrderFragment.this), LandlordOrderDetailActivity.class);
          localIntent.putExtra("orderSn", paramAnonymousView.orderSn);
          MinsuLLNeadDealOrderFragment.c(MinsuLLNeadDealOrderFragment.this).startActivity(localIntent);
          return;
        }
        if (MinsuLLNeadDealOrderFragment.a(MinsuLLNeadDealOrderFragment.this) == 2)
        {
          paramAnonymousView = (MinsuEvaluationListBean.DataBean.RowsBean)MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).get(paramAnonymousInt);
          localIntent = new Intent(MinsuLLNeadDealOrderFragment.c(MinsuLLNeadDealOrderFragment.this), LandlordOrderDetailActivity.class);
          localIntent.putExtra("orderSn", paramAnonymousView.orderSn);
          MinsuLLNeadDealOrderFragment.c(MinsuLLNeadDealOrderFragment.this).startActivity(localIntent);
          return;
        }
        paramAnonymousView = (MinsuLLOrderListBean.DataBean.OrderListBean)MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).get(paramAnonymousInt);
        Intent localIntent = new Intent(MinsuLLNeadDealOrderFragment.c(MinsuLLNeadDealOrderFragment.this), LandlordOrderDetailActivity.class);
        localIntent.putExtra("orderSn", paramAnonymousView.orderSn);
        MinsuLLNeadDealOrderFragment.c(MinsuLLNeadDealOrderFragment.this).startActivity(localIntent);
      }
    });
  }
  
  private void d()
  {
    this.b.setOnScrollListener(new RecyclerView.l()
    {
      int a;
      
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (this.a + 1 == MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).getItemCount()) && (MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).getmLoadType() != a.b.d) && (MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).getmLoadType() != a.b.e)) {
          MinsuLLNeadDealOrderFragment.a(MinsuLLNeadDealOrderFragment.this, true);
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        this.a = ((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
      }
    });
  }
  
  private void e()
  {
    d.e("yangxj", "房东端首页刷新数据" + this.d);
    if (this.d != 2)
    {
      com.ziroom.ziroomcustomer.minsu.e.a.orderListLL(getActivity(), this.d, this.c, 10, true, new s(getActivity(), new r(MinsuLLOrderListBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.c);
          MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).notifyDataSetChanged();
        }
        
        public void onSuccess(int paramAnonymousInt, MinsuLLOrderListBean paramAnonymousMinsuLLOrderListBean)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLOrderListBean);
          if ((paramAnonymousMinsuLLOrderListBean == null) || (paramAnonymousMinsuLLOrderListBean.data == null)) {
            return;
          }
          if (paramAnonymousMinsuLLOrderListBean.data.orderList == null) {
            paramAnonymousMinsuLLOrderListBean.data.orderList = new ArrayList();
          }
          MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).a = paramAnonymousMinsuLLOrderListBean.data.isShowMoreOrder;
          MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).addAll(paramAnonymousMinsuLLOrderListBean.data.orderList);
          if (MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).size() % 10 > 0) {
            MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.d);
          }
          for (;;)
          {
            if ((paramAnonymousMinsuLLOrderListBean.data.orderList.size() == 0) && (MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).size() > 0)) {
              MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.d);
            }
            MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setData(MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this));
            return;
            if (MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).size() == 0) {
              MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.e);
            } else {
              MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.b);
            }
          }
        }
      });
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.queryEvaluate(getActivity(), 10, this.c, 1, 1, new s(getActivity(), new r(MinsuEvaluationListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.c);
        MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).notifyDataSetChanged();
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuEvaluationListBean paramAnonymousMinsuEvaluationListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuEvaluationListBean);
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        String str;
        if (paramAnonymousMinsuEvaluationListBean == null)
        {
          str = "null";
          d.e("lanzhihong", str);
          if ((paramAnonymousMinsuEvaluationListBean.data != null) && (paramAnonymousMinsuEvaluationListBean.data.rows != null))
          {
            MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).addAll(paramAnonymousMinsuEvaluationListBean.data.rows);
            if (MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).size() % 10 <= 0) {
              break label178;
            }
            MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.d);
          }
        }
        for (;;)
        {
          if ((paramAnonymousMinsuEvaluationListBean.data.rows.size() == 0) && (MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).size() > 0)) {
            MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.d);
          }
          MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setData(MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this));
          return;
          str = paramAnonymousMinsuEvaluationListBean.toString();
          break;
          label178:
          if (MinsuLLNeadDealOrderFragment.b(MinsuLLNeadDealOrderFragment.this).size() == 0) {
            MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.e);
          } else {
            MinsuLLNeadDealOrderFragment.d(MinsuLLNeadDealOrderFragment.this).setLoadType(a.b.b);
          }
        }
      }
    });
  }
  
  public static MinsuLLNeadDealOrderFragment getInitstance(int paramInt)
  {
    MinsuLLNeadDealOrderFragment localMinsuLLNeadDealOrderFragment = new MinsuLLNeadDealOrderFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localMinsuLLNeadDealOrderFragment.setArguments(localBundle);
    return localMinsuLLNeadDealOrderFragment;
  }
  
  public void FristLoadData()
  {
    if (this.e != null)
    {
      this.c = 1;
      this.f.clear();
      e();
    }
  }
  
  public View getScrollableView()
  {
    return this.b;
  }
  
  public void notifyItemChanged(Object paramObject)
  {
    int i = this.f.indexOf(paramObject);
    if (i != -1) {
      this.e.notifyItemChanged(i);
    }
  }
  
  public void notifyItemInserted(Object paramObject)
  {
    this.f.add(0, paramObject);
    this.e.notifyItemRangeInserted(0, 1);
  }
  
  public void notifyItemRemoved(Object paramObject)
  {
    int i = this.f.indexOf(paramObject);
    if (i != -1)
    {
      this.f.remove(i);
      this.e.notifyItemRemoved(i);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getContext();
    this.d = getArguments().getInt("type");
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(getActivity(), 2130904908, null);
    this.b = ((RecyclerView)paramLayoutInflater.findViewById(2131694160));
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b.setLayoutManager(new LinearLayoutManager(this.a));
    this.b.setAdapter(this.e);
    d();
    e();
  }
  
  public void resetData()
  {
    if (this.e != null)
    {
      this.c = 1;
      this.f.clear();
      this.e.notifyDataSetChanged();
      this.e.setLoadType(a.b.e);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/fragment/MinsuLLNeadDealOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */