package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.c.b;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.SearchTab;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.StationSearchListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.util.af;
import java.util.Iterator;
import java.util.List;

public class StationSearchListFragment
  extends BaseSearchListFragment
{
  protected com.ziroom.ziroomcustomer.minsu.searchlist.b.c b;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a j;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a k;
  private StationSearchListBean l;
  private int m;
  private boolean n = false;
  
  private void a(int paramInt, String paramString)
  {
    SearchTab.STATION.setVisibility(paramInt);
    SearchTab.STATION.setSuggestMsg(paramString);
    ((MinsuSearchListActivity)getActivity()).setListTopBar();
  }
  
  private void g()
  {
    this.j = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.j);
    this.k = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  public static StationSearchListFragment getInstance()
  {
    StationSearchListFragment localStationSearchListFragment = new StationSearchListFragment();
    localStationSearchListFragment.setArguments(new Bundle());
    return localStationSearchListFragment;
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
      if (!parama.equals("zry_query")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("zry_query_error")) {
        break;
      }
      i = 1;
      break;
      this.l = this.j.getStationSearchListBean();
    } while ((this.l == null) || (this.l.getData() == null));
    if ((this.l.getData().getList() != null) && (this.l.getData().getList().size() > 0))
    {
      if (this.i == 1)
      {
        this.b.setData(this.l.getData().getList(), c.b.a);
        a(8, this.l.getData().getSuggestMsg());
        this.d.smoothScrollToPosition(0);
        this.b.changeMoreStatus(0);
        this.n = false;
        if (this.i * 10 >= this.l.getData().getTotal()) {
          break label324;
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
          StationSearchListBean.DataBean.ListBean localListBean = (StationSearchListBean.DataBean.ListBean)parama.next();
          if (!this.b.getData().contains(localListBean)) {
            this.b.addSearchItem(localListBean);
          }
        }
        this.b.notifyDataSetChanged();
        break;
        label324:
        this.b.setCanLoadMore(false);
      }
    }
    if ((this.l.getData().getSuggest() != null) && (this.l.getData().getSuggest().size() > 0))
    {
      this.b.setData(this.l.getData().getSuggest(), c.b.b);
      a(0, this.l.getData().getSuggestMsg());
      this.d.smoothScrollToPosition(0);
      this.b.setCanLoadMore(false);
      return;
    }
    if (this.l.getData().getTotal() == 0)
    {
      this.b.setData(null, c.b.a);
      a(8, this.l.getData().getSuggestMsg());
      this.b.setCanLoadMore(false);
      return;
    }
    this.b.setCanLoadMore(false);
    return;
    af.showToast(this.c, this.j.getStationSearchListErrMsg());
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
        if ((paramAnonymousInt == 0) && (StationSearchListFragment.a(StationSearchListFragment.this) + 1 == StationSearchListFragment.this.b.getItemCount()) && (StationSearchListFragment.this.b.getCurrentModel() == c.b.a) && (StationSearchListFragment.this.b.getCanLoadMore()))
        {
          StationSearchListFragment.this.b.changeMoreStatus(1);
          StationSearchListFragment.a(StationSearchListFragment.this, true);
          StationSearchListFragment.this.request();
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        StationSearchListFragment.a(StationSearchListFragment.this, ((LinearLayoutManager)StationSearchListFragment.b(StationSearchListFragment.this)).findLastVisibleItemPosition());
      }
    });
  }
  
  protected int d()
  {
    return 2130903989;
  }
  
  protected RecyclerView.h e()
  {
    return new LinearLayoutManager(this.c, 1, false);
  }
  
  protected RecyclerView.a f()
  {
    this.b = new com.ziroom.ziroomcustomer.minsu.searchlist.b.c(this.c);
    return this.b;
  }
  
  public String getTitle()
  {
    return "驿栈";
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.j);
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
    if ((this.n) || (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().isStationNeedRequest()))
    {
      if (!this.n) {
        this.i = 1;
      }
      if ((this.k != null) && (this.b != null))
      {
        this.k.queryStationList(this, getActivity(), this.i);
        this.b.setCanLoadMore(true);
      }
    }
    else
    {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setInitStation(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/StationSearchListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */