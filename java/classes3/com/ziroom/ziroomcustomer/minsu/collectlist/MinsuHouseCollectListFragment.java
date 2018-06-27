package com.ziroom.ziroomcustomer.minsu.collectlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCollectListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCollectListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.a.c;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.s;
import java.util.Iterator;
import java.util.List;

public class MinsuHouseCollectListFragment
  extends BaseFluxFragment
{
  private View b;
  private Context c;
  private Unbinder d;
  private com.ziroom.ziroomcustomer.minsu.collectlist.b.a e;
  private com.ziroom.ziroomcustomer.minsu.collectlist.a.a f;
  private MinsuCollectListBean g;
  private com.ziroom.ziroomcustomer.minsu.searchlist.b.a h;
  private LinearLayoutManager i;
  private int j;
  private int k = 1;
  @BindView(2131689818)
  LinearLayout ll_empty;
  @BindView(2131691646)
  RecyclerView rv_list;
  
  private void c()
  {
    this.e = new com.ziroom.ziroomcustomer.minsu.collectlist.b.a(this);
    this.a.register(this.e);
    this.f = com.ziroom.ziroomcustomer.minsu.collectlist.a.a.getInstance(this.a);
  }
  
  private void d()
  {
    this.h = new com.ziroom.ziroomcustomer.minsu.searchlist.b.a(this.c, new com.ziroom.ziroomcustomer.minsu.searchlist.base.b()
    {
      public void onCollectClick(MinsuHouseBean.DataBean.ListBean paramAnonymousListBean, boolean paramAnonymousBoolean)
      {
        if (ApplicationEx.c.isLoginState())
        {
          if (paramAnonymousBoolean)
          {
            MinsuHouseCollectListFragment.a(MinsuHouseCollectListFragment.this).collectHouse(MinsuHouseCollectListFragment.this, MinsuHouseCollectListFragment.this.getActivity(), paramAnonymousListBean);
            return;
          }
          MinsuHouseCollectListFragment.a(MinsuHouseCollectListFragment.this).cancelCollectHouse(MinsuHouseCollectListFragment.this, MinsuHouseCollectListFragment.this.getActivity(), paramAnonymousListBean);
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(MinsuHouseCollectListFragment.b(MinsuHouseCollectListFragment.this));
      }
    });
    this.h.setPricePrivilegeShow(false);
    this.i = new LinearLayoutManager(this.c, 1, false);
    this.rv_list.setLayoutManager(this.i);
    this.rv_list.setAdapter(this.h);
    this.rv_list.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (MinsuHouseCollectListFragment.c(MinsuHouseCollectListFragment.this) + 1 == MinsuHouseCollectListFragment.d(MinsuHouseCollectListFragment.this).getItemCount()) && (MinsuHouseCollectListFragment.d(MinsuHouseCollectListFragment.this).getCurrentModel() == a.c.a) && (MinsuHouseCollectListFragment.d(MinsuHouseCollectListFragment.this).getCanLoadMore()))
        {
          MinsuHouseCollectListFragment.d(MinsuHouseCollectListFragment.this).changeMoreStatus(1);
          MinsuHouseCollectListFragment.e(MinsuHouseCollectListFragment.this);
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MinsuHouseCollectListFragment.a(MinsuHouseCollectListFragment.this, MinsuHouseCollectListFragment.f(MinsuHouseCollectListFragment.this).findLastVisibleItemPosition());
      }
    });
  }
  
  private void e()
  {
    if ((this.f != null) && (this.h != null))
    {
      this.f.getCollectList(this, getActivity(), this.k);
      this.h.setCanLoadMore(true);
    }
  }
  
  public static MinsuHouseCollectListFragment getInstance()
  {
    return new MinsuHouseCollectListFragment();
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    parama = parama.getType();
    int m = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (m)
      {
      case 1: 
      default: 
        return;
        if (parama.equals("get_collect_list"))
        {
          m = 0;
          continue;
          if (parama.equals("get_collect_list_error"))
          {
            m = 1;
            continue;
            if (parama.equals("collect_house"))
            {
              m = 2;
              continue;
              if (parama.equals("cancel_collect_house")) {
                m = 3;
              }
            }
          }
        }
        break;
      }
    }
    this.g = this.e.getHouseCollectBean();
    if ((this.g != null) && (this.g.data != null))
    {
      if (!s.isEmpty(this.g.data.rows))
      {
        this.ll_empty.setVisibility(8);
        this.rv_list.setVisibility(0);
        parama = this.g.data.rows.iterator();
        while (parama.hasNext()) {
          ((MinsuHouseBean.DataBean.ListBean)parama.next()).isCollect = 1;
        }
        if (this.k == 1)
        {
          this.h.setData(this.g.data.rows, a.c.a);
          this.rv_list.smoothScrollToPosition(0);
          this.h.changeMoreStatus(0);
          if (this.k > (this.g.data.total - 1) / 10) {
            break label356;
          }
          this.h.setCanLoadMore(true);
        }
        for (;;)
        {
          this.k += 1;
          return;
          this.h.addData(this.g.data.rows);
          break;
          label356:
          this.h.setCanLoadMore(false);
        }
      }
      if (this.g.data.total == 0)
      {
        this.ll_empty.setVisibility(0);
        this.rv_list.setVisibility(8);
        this.h.setData(null, a.c.a);
        this.h.setCanLoadMore(false);
        return;
      }
      this.rv_list.setVisibility(8);
      this.ll_empty.setVisibility(0);
      this.h.setCanLoadMore(false);
      return;
    }
    this.rv_list.setVisibility(8);
    this.ll_empty.setVisibility(0);
    return;
    parama = this.e.getMinsuHouseCollectResultBean();
    if ((parama != null) && (parama.checkSuccess(getActivity())) && (parama.data != null) && ("0".equals(parama.data.collResult)))
    {
      if ((this.h != null) && (this.h.getCurrentCollectData() != null))
      {
        this.k = 1;
        e();
        af.showToast(this.c, "收藏成功");
      }
      ((BaseActivity)getActivity()).dismissProgress();
      return;
    }
    if (parama == null) {}
    for (parama = (com.ziroom.ziroomcustomer.flux.a.a)localObject1;; parama = parama.message)
    {
      ad.shouErrorMessage(parama);
      break;
    }
    parama = this.e.getMinsuCancelCollectResultBean();
    if ((parama != null) && (parama.checkSuccess(getActivity())) && ("0".equals(parama.data.delCollResult)))
    {
      if ((this.h != null) && (this.h.getCurrentCancelCollectData() != null))
      {
        this.k = 1;
        e();
        af.showToast(this.c, "取消收藏成功");
      }
      ((BaseActivity)getActivity()).dismissProgress();
      return;
    }
    if (parama == null) {}
    for (parama = (com.ziroom.ziroomcustomer.flux.a.a)localObject2;; parama = parama.message)
    {
      ad.shouErrorMessage(parama);
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2130903887, paramViewGroup, false);
    this.d = ButterKnife.bind(this, this.b);
    c();
    this.c = getActivity();
    d();
    e();
    return this.b;
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d.unbind();
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.e);
    super.onDestroyView();
  }
  
  public void refreshData(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      break;
    }
    label146:
    for (;;)
    {
      return;
      if (paramInt2 == 101)
      {
        String str = paramIntent.getStringExtra("fid");
        paramInt2 = paramIntent.getIntExtra("rentWay", -1);
        int m = this.h.getData().size();
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= m) {
            break label146;
          }
          MinsuHouseBean.DataBean.ListBean localListBean = (MinsuHouseBean.DataBean.ListBean)this.h.getData().get(paramInt1);
          if ((localListBean.rentWay == paramInt2) && (localListBean.fid.equals(str)))
          {
            if (paramIntent.getBooleanExtra("isCollect", true)) {
              break;
            }
            this.h.getData().remove(localListBean);
            this.h.notifyDataSetChanged();
            return;
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/collectlist/MinsuHouseCollectListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */