package com.ziroom.ziroomcustomer.minsu.searchlist.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.searchlist.widget.a.a;

public abstract class BaseSearchListFragment
  extends BaseFluxFragment
  implements a.a
{
  private a b;
  protected Context c;
  protected RecyclerView d;
  protected RecyclerView.h e;
  protected RecyclerView.a f;
  protected View g;
  protected Unbinder h;
  protected int i = 1;
  
  protected abstract void c();
  
  protected abstract int d();
  
  protected abstract RecyclerView.h e();
  
  protected abstract RecyclerView.a f();
  
  public View getScrollableView()
  {
    return this.d;
  }
  
  public abstract String getTitle();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = getActivity();
    this.g = paramLayoutInflater.inflate(d(), null);
    this.d = ((RecyclerView)this.g.findViewById(2131691646));
    this.e = e();
    this.f = f();
    if (this.d != null) {
      if (this.e != null)
      {
        this.d.setLayoutManager(this.e);
        if (this.f == null) {
          break label151;
        }
        this.d.setAdapter(this.f);
      }
    }
    for (;;)
    {
      c();
      if ((getActivity() instanceof a))
      {
        this.b = ((a)getActivity());
        this.d.addOnScrollListener(new RecyclerView.l()
        {
          public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
          {
            super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          }
          
          public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
            if (BaseSearchListFragment.this.e != null)
            {
              if (!(BaseSearchListFragment.this.e instanceof GridLayoutManager)) {
                break label59;
              }
              paramAnonymousRecyclerView = (GridLayoutManager)BaseSearchListFragment.this.e;
              BaseSearchListFragment.a(BaseSearchListFragment.this).onScrolledDistance(paramAnonymousInt2, paramAnonymousRecyclerView.findFirstVisibleItemPosition());
            }
            label59:
            while (!(BaseSearchListFragment.this.e instanceof LinearLayoutManager)) {
              return;
            }
            paramAnonymousRecyclerView = (LinearLayoutManager)BaseSearchListFragment.this.e;
            BaseSearchListFragment.a(BaseSearchListFragment.this).onScrolledDistance(paramAnonymousInt2, paramAnonymousRecyclerView.findFirstVisibleItemPosition());
          }
        });
      }
      return this.g;
      d.d("BaseSearchListFragment", "LayoutManager is null!");
      break;
      label151:
      d.d("BaseSearchListFragment", "Adapter is null!");
      continue;
      d.d("BaseSearchListFragment", "Don't find the RecyclerView!");
    }
  }
  
  public void onDestroy()
  {
    if (this.h != null) {
      this.h.unbind();
    }
    super.onDestroy();
  }
  
  public abstract void pullToRefresh();
  
  public abstract void refreshComplete();
  
  public abstract void request();
  
  public void reset()
  {
    this.i = 1;
  }
  
  public static abstract interface a
  {
    public abstract void onBannerItemClick(int paramInt, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/base/BaseSearchListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */