package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBannerBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.a.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.BaseSearchListFragment.a;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.SearchTab;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.s;
import java.util.Collections;
import java.util.List;

public class MinsuSearchListFragment
  extends BaseSearchListFragment
{
  protected com.ziroom.ziroomcustomer.minsu.searchlist.b.a b;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a j;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a k;
  private MinsuHouseBean l;
  private int m;
  private boolean n = false;
  
  private void a(int paramInt, String paramString)
  {
    SearchTab.MINSU.setVisibility(paramInt);
    SearchTab.MINSU.setSuggestMsg(paramString);
    ((MinsuSearchListActivity)getActivity()).setListTopBar();
  }
  
  private void a(List<MinsuHouseBean.DataBean.ListBean> paramList, List<MinsuHouseBannerBean> paramList1)
  {
    if (!s.isEmpty(paramList1))
    {
      Collections.sort(paramList1);
      int i = 0;
      while (i < paramList1.size())
      {
        if ("TonightDiscountGuideBanner001".equals(((MinsuHouseBannerBean)paramList1.get(i)).getBannerType()))
        {
          MinsuHouseBean.DataBean.ListBean localListBean = new MinsuHouseBean.DataBean.ListBean();
          localListBean.houseBannerBean = ((MinsuHouseBannerBean)paramList1.get(i));
          paramList.add(((MinsuHouseBannerBean)paramList1.get(i)).getBannerIndex(), localListBean);
        }
        i += 1;
      }
    }
  }
  
  private void g()
  {
    this.j = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.j);
    this.k = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  public static MinsuSearchListFragment getInstance()
  {
    MinsuSearchListFragment localMinsuSearchListFragment = new MinsuSearchListFragment();
    localMinsuSearchListFragment.setArguments(new Bundle());
    return localMinsuSearchListFragment;
  }
  
  @OnClick({})
  public void OnClick(View paramView)
  {
    paramView.getId();
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
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
      if (!parama.equals("minsu_query")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("minsu_query_error")) {
        break;
      }
      i = 1;
      break;
      if (!parama.equals("collect_house")) {
        break;
      }
      i = 2;
      break;
      if (!parama.equals("cancel_collect_house")) {
        break;
      }
      i = 3;
      break;
      this.l = this.j.getMinsuHouseBean();
    } while ((this.l == null) || (this.l.data == null));
    if (!s.isEmpty(this.l.data.list))
    {
      a(this.l.data.list, this.l.data.bannerList);
      if (this.i == 1)
      {
        a(8, this.l.data.suggestMsg);
        this.b.setData(this.l.data.list, a.c.a);
        this.d.smoothScrollToPosition(0);
        this.b.changeMoreStatus(0);
        this.n = false;
        if (this.i > (this.l.data.total - 1) / 10) {
          break label343;
        }
        this.b.setCanLoadMore(true);
      }
      for (;;)
      {
        this.i += 1;
        return;
        this.b.addData(this.l.data.list);
        break;
        label343:
        this.b.setCanLoadMore(false);
      }
    }
    if (!s.isEmpty(this.l.data.suggest))
    {
      this.b.setData(this.l.data.suggest, a.c.b);
      a(0, this.l.data.suggestMsg);
      this.d.smoothScrollToPosition(0);
      this.b.setCanLoadMore(false);
      return;
    }
    if (this.l.data.total == 0)
    {
      a(8, this.l.data.suggestMsg);
      this.b.setData(null, a.c.a);
      this.b.setCanLoadMore(false);
      return;
    }
    this.b.setCanLoadMore(false);
    a(8, this.l.data.suggestMsg);
    return;
    af.showToast(this.c, this.j.getMinsuHouseErrMsg());
    this.b.changeMoreStatus(0);
    this.n = false;
    this.b.setCanLoadMore(false);
    return;
    parama = this.j.getMinsuHouseCollectResultBean();
    if ((parama != null) && (parama.checkSuccess(getActivity())) && (parama.data != null) && ("0".equals(parama.data.collResult)))
    {
      if ((this.b != null) && (this.b.getCurrentCollectData() != null))
      {
        this.b.getCurrentCollectData().isCollect = 1;
        this.b.notifyDataSetChanged();
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
    parama = this.j.getMinsuCancelCollectResultBean();
    if ((parama != null) && (parama.checkSuccess(getActivity())) && ("0".equals(parama.data.delCollResult)))
    {
      if ((this.b != null) && (this.b.getCurrentCancelCollectData() != null))
      {
        this.b.getCurrentCancelCollectData().isCollect = 0;
        this.b.notifyDataSetChanged();
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
  
  protected void c()
  {
    g();
    this.h = ButterKnife.bind(this, this.g);
    this.d.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (MinsuSearchListFragment.a(MinsuSearchListFragment.this) + 1 == MinsuSearchListFragment.this.b.getItemCount()) && (MinsuSearchListFragment.this.b.getCurrentModel() == a.c.a) && (MinsuSearchListFragment.this.b.getCanLoadMore()))
        {
          MinsuSearchListFragment.this.b.changeMoreStatus(1);
          MinsuSearchListFragment.a(MinsuSearchListFragment.this, true);
          MinsuSearchListFragment.this.request();
        }
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MinsuSearchListFragment.a(MinsuSearchListFragment.this, ((LinearLayoutManager)MinsuSearchListFragment.b(MinsuSearchListFragment.this)).findLastVisibleItemPosition());
      }
    });
    this.b.setonBannerItemClick(new BaseSearchListFragment.a()
    {
      public void onBannerItemClick(int paramAnonymousInt, String paramAnonymousString)
      {
        if ("TonightDiscountGuideBanner001".equals(paramAnonymousString))
        {
          c.getInstance().setJiaxinDiscount("ProductRulesEnum020001");
          paramAnonymousInt = c.getInstance().getMinsuConditionCount();
          ((MinsuSearchListActivity)MinsuSearchListFragment.this.getActivity()).setSearchCount(paramAnonymousInt);
          MinsuSearchListFragment.this.reset();
          MinsuSearchListFragment.this.request();
        }
      }
    });
  }
  
  protected int d()
  {
    return 2130903965;
  }
  
  protected RecyclerView.h e()
  {
    return new LinearLayoutManager(this.c, 1, false);
  }
  
  protected RecyclerView.a f()
  {
    this.b = new com.ziroom.ziroomcustomer.minsu.searchlist.b.a(this.c, new com.ziroom.ziroomcustomer.minsu.searchlist.base.b()
    {
      public void onCollectClick(MinsuHouseBean.DataBean.ListBean paramAnonymousListBean, boolean paramAnonymousBoolean)
      {
        if (ApplicationEx.c.isLoginState())
        {
          if (paramAnonymousBoolean)
          {
            MinsuSearchListFragment.c(MinsuSearchListFragment.this).collectHouse(MinsuSearchListFragment.this, MinsuSearchListFragment.this.getActivity(), paramAnonymousListBean);
            return;
          }
          MinsuSearchListFragment.c(MinsuSearchListFragment.this).cancelCollectHouse(MinsuSearchListFragment.this, MinsuSearchListFragment.this.getActivity(), paramAnonymousListBean);
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(MinsuSearchListFragment.d(MinsuSearchListFragment.this));
      }
    });
    return this.b;
  }
  
  public String getTitle()
  {
    return "民宿";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    }
    label75:
    label146:
    label161:
    label255:
    label261:
    label266:
    label278:
    label280:
    label285:
    for (;;)
    {
      return;
      if ((paramInt2 == 101) && (paramIntent != null) && (this.b != null))
      {
        String str = paramIntent.getStringExtra("fid");
        int i1 = paramIntent.getIntExtra("rentWay", -1);
        Object localObject;
        boolean bool;
        if (this.b.getData() == null)
        {
          paramInt2 = 0;
          paramInt1 = 0;
          if (paramInt1 >= paramInt2) {
            break label280;
          }
          localObject = (MinsuHouseBean.DataBean.ListBean)this.b.getData().get(paramInt1);
          if ((localObject == null) || (((MinsuHouseBean.DataBean.ListBean)localObject).rentWay != i1) || (((MinsuHouseBean.DataBean.ListBean)localObject).fid == null) || (!((MinsuHouseBean.DataBean.ListBean)localObject).fid.equals(str))) {
            break label266;
          }
          if (((MinsuHouseBean.DataBean.ListBean)localObject).isCollect != 1) {
            break label255;
          }
          bool = true;
          if (!paramIntent.getBooleanExtra("isCollect", bool)) {
            break label261;
          }
          paramInt2 = i;
          ((MinsuHouseBean.DataBean.ListBean)localObject).isCollect = paramInt2;
          paramIntent = (Intent)localObject;
        }
        for (;;)
        {
          if ((paramInt1 == -1) || (paramIntent == null)) {
            break label285;
          }
          localObject = (LinearLayoutManager)this.d.getLayoutManager();
          paramInt1 = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
          paramInt2 = ((LinearLayoutManager)localObject).findLastVisibleItemPosition();
          for (;;)
          {
            if (paramInt1 > paramInt2) {
              break label278;
            }
            if (paramIntent.equals((MinsuHouseBean.DataBean.ListBean)((LinearLayoutManager)localObject).findViewByPosition(paramInt1).getTag(2131689523)))
            {
              this.b.notifyItemChanged(paramInt1);
              return;
              paramInt2 = this.b.getData().size();
              break;
              bool = false;
              break label146;
              paramInt2 = 0;
              break label161;
              paramInt1 += 1;
              break label75;
            }
            paramInt1 += 1;
          }
          break;
          paramIntent = null;
          paramInt1 = -1;
        }
      }
    }
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
    if ((this.n) || (c.getInstance().isMinsuNeedRequest()))
    {
      if (!this.n) {
        this.i = 1;
      }
      if ((this.k != null) && (this.b != null))
      {
        this.k.queryMinsuList(this, getActivity(), this.i);
        this.b.setCanLoadMore(true);
      }
    }
    else
    {
      return;
    }
    c.getInstance().setInitMinsu(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/MinsuSearchListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */