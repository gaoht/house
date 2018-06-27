package com.ziroom.ziroomcustomer.minsu.view.b.c;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.ViewGroup;
import com.ziroom.ziroomcustomer.minsu.view.b.a.c;
import com.ziroom.ziroomcustomer.minsu.view.b.b.a.a;

public class a<T>
  extends RecyclerView.a<RecyclerView.u>
{
  private SparseArrayCompat<View> a = new SparseArrayCompat();
  private SparseArrayCompat<View> b = new SparseArrayCompat();
  private RecyclerView.a c;
  
  public a(RecyclerView.a parama)
  {
    this.c = parama;
  }
  
  private int a()
  {
    return this.c.getItemCount();
  }
  
  private boolean a(int paramInt)
  {
    return paramInt < getHeadersCount();
  }
  
  private boolean b(int paramInt)
  {
    return paramInt >= getHeadersCount() + a();
  }
  
  public void addFootView(View paramView)
  {
    this.b.put(this.b.size() + 200000, paramView);
  }
  
  public void addHeaderView(View paramView)
  {
    this.a.put(this.a.size() + 100000, paramView);
  }
  
  public int getFootersCount()
  {
    return this.b.size();
  }
  
  public int getHeadersCount()
  {
    return this.a.size();
  }
  
  public int getItemCount()
  {
    return getHeadersCount() + getFootersCount() + a();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.a.keyAt(paramInt);
    }
    if (b(paramInt)) {
      return this.b.keyAt(paramInt - getHeadersCount() - a());
    }
    return this.c.getItemViewType(paramInt - getHeadersCount());
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    com.ziroom.ziroomcustomer.minsu.view.b.b.a.onAttachedToRecyclerView(this.c, paramRecyclerView, new a.a()
    {
      public int getSpanSize(GridLayoutManager paramAnonymousGridLayoutManager, GridLayoutManager.b paramAnonymousb, int paramAnonymousInt)
      {
        int i = a.this.getItemViewType(paramAnonymousInt);
        if (a.a(a.this).get(i) != null) {
          return paramAnonymousGridLayoutManager.getSpanCount();
        }
        if (a.b(a.this).get(i) != null) {
          return paramAnonymousGridLayoutManager.getSpanCount();
        }
        if (paramAnonymousb != null) {
          return paramAnonymousb.getSpanSize(paramAnonymousInt);
        }
        return 1;
      }
    });
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    if (a(paramInt)) {}
    while (b(paramInt)) {
      return;
    }
    this.c.onBindViewHolder(paramu, paramInt - getHeadersCount());
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a.get(paramInt) != null) {
      return c.get(paramViewGroup.getContext(), (View)this.a.get(paramInt));
    }
    if (this.b.get(paramInt) != null) {
      return c.get(paramViewGroup.getContext(), (View)this.b.get(paramInt));
    }
    return this.c.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.u paramu)
  {
    this.c.onViewAttachedToWindow(paramu);
    int i = paramu.getLayoutPosition();
    if ((a(i)) || (b(i))) {
      com.ziroom.ziroomcustomer.minsu.view.b.b.a.setFullSpan(paramu);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */