package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.d;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.d.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.SearchTab;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StrategySearchListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.s;
import java.util.Iterator;
import java.util.List;

public class StrategySearchListFragment
  extends BaseSearchListFragment
{
  protected d b;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a j;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a k;
  private StrategySearchListBean l;
  private int m;
  private boolean n = false;
  
  private void a(int paramInt, String paramString)
  {
    SearchTab.STRATEGY.setVisibility(paramInt);
    SearchTab.STRATEGY.setSuggestMsg(paramString);
    ((MinsuSearchListActivity)getActivity()).setListTopBar();
  }
  
  private void g()
  {
    this.k = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.k);
    this.j = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  public static StrategySearchListFragment getInstance()
  {
    StrategySearchListFragment localStrategySearchListFragment = new StrategySearchListFragment();
    localStrategySearchListFragment.setArguments(new Bundle());
    return localStrategySearchListFragment;
  }
  
  @OnClick({})
  public void OnClick(View paramView)
  {
    paramView.getId();
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("strategy_query")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("strategy_query_error")) {
        break;
      }
      i = 1;
      break;
      this.l = this.k.getStrategySearchListBean();
    } while ((this.l == null) || (this.l.getData() == null));
    if (this.l.getData().getTotal() < 10)
    {
      this.b.setData(this.l.getData().getList(), d.c.b);
      this.b.setSuggestData(this.l.getData().getSuggest());
      if (s.isEmpty(this.l.getData().getList())) {
        a(0, this.l.getData().getSuggestMsg());
      }
      for (;;)
      {
        this.d.smoothScrollToPosition(0);
        this.b.setCanLoadMore(false);
        return;
        a(8, this.l.getData().getSuggestMsg());
      }
    }
    if (this.i == 1)
    {
      this.b.setSuggestData(null);
      a(8, this.l.getData().getSuggestMsg());
      this.b.setData(this.l.getData().getList(), d.c.a);
      this.d.smoothScrollToPosition(0);
      this.b.changeMoreStatus(0);
      this.n = false;
      if (this.i * 10 >= this.l.getData().getTotal()) {
        break label420;
      }
      this.b.setCanLoadMore(true);
    }
    for (;;)
    {
      this.i += 1;
      return;
      parama = this.l.getData().getList().iterator();
      while (parama.hasNext())
      {
        StrategySearchListBean.DataBean.ListBean localListBean = (StrategySearchListBean.DataBean.ListBean)parama.next();
        if (!this.b.getData().contains(localListBean)) {
          this.b.addSearchItem(localListBean);
        }
      }
      this.b.notifyDataSetChanged();
      break;
      label420:
      this.b.setCanLoadMore(false);
    }
    af.showToast(this.c, this.k.getStrategySearchListErrMsg());
    this.b.changeMoreStatus(0);
    this.n = false;
    this.b.setCanLoadMore(false);
  }
  
  protected void c()
  {
    g();
    this.h = ButterKnife.bind(this, this.g);
    this.d.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (StrategySearchListFragment.a(StrategySearchListFragment.this) + 1 == StrategySearchListFragment.this.b.getItemCount()) && (StrategySearchListFragment.this.b.getCurrentModel() == d.c.a) && (StrategySearchListFragment.this.b.getCanLoadMore()))
        {
          StrategySearchListFragment.this.b.changeMoreStatus(1);
          StrategySearchListFragment.a(StrategySearchListFragment.this, true);
          StrategySearchListFragment.this.request();
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        StrategySearchListFragment.a(StrategySearchListFragment.this, ((LinearLayoutManager)StrategySearchListFragment.b(StrategySearchListFragment.this)).findLastVisibleItemPosition());
      }
    });
  }
  
  protected int d()
  {
    return 2130903992;
  }
  
  protected RecyclerView.h e()
  {
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(this.c, 2, 1, false);
    localGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.b()
    {
      public int getSpanSize(int paramAnonymousInt)
      {
        int i = 1;
        int j = StrategySearchListFragment.this.b.getItemViewType(paramAnonymousInt);
        if ((j != -1) && (j != 1))
        {
          paramAnonymousInt = i;
          if (j != 2) {}
        }
        else
        {
          paramAnonymousInt = 2;
        }
        return paramAnonymousInt;
      }
    });
    return localGridLayoutManager;
  }
  
  protected RecyclerView.a f()
  {
    this.b = new d(this.c);
    return this.b;
  }
  
  public String getTitle()
  {
    return "攻略";
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.k);
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    request();
  }
  
  public void pullToRefresh() {}
  
  public void refreshComplete() {}
  
  public void request()
  {
    if ((this.n) || (c.getInstance().isStrategyNeedRequest()))
    {
      if (!this.n) {
        this.i = 1;
      }
      if ((this.j != null) && (this.b != null))
      {
        this.j.queryStrategyList(this, getActivity(), this.i);
        this.b.setCanLoadMore(true);
      }
    }
    else
    {
      return;
    }
    c.getInstance().setInitStrategy(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/StrategySearchListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */