package com.ziroom.ziroomcustomer.minsu.view.b.b;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;

public class a
{
  public static void onAttachedToRecyclerView(final RecyclerView.a parama, RecyclerView paramRecyclerView, a parama1)
  {
    parama.onAttachedToRecyclerView(paramRecyclerView);
    parama = paramRecyclerView.getLayoutManager();
    if ((parama instanceof GridLayoutManager))
    {
      parama = (GridLayoutManager)parama;
      parama.setSpanSizeLookup(new GridLayoutManager.b()
      {
        public int getSpanSize(int paramAnonymousInt)
        {
          return this.b.getSpanSize(parama, this.d, paramAnonymousInt);
        }
      });
      parama.setSpanCount(parama.getSpanCount());
    }
  }
  
  public static void setFullSpan(RecyclerView.u paramu)
  {
    paramu = paramu.itemView.getLayoutParams();
    if ((paramu != null) && ((paramu instanceof StaggeredGridLayoutManager.LayoutParams))) {
      ((StaggeredGridLayoutManager.LayoutParams)paramu).setFullSpan(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract int getSpanSize(GridLayoutManager paramGridLayoutManager, GridLayoutManager.b paramb, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */