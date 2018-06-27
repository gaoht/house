package com.mob.tools.gui;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;

public abstract class PullToRequestGridAdapter
  extends PullToRequestBaseListAdapter
{
  private PullToRequestBaseAdapter adapter;
  private boolean fling;
  private ScrollableGridView gridView = onNewGridView(getContext());
  private OnListStopScrollListener osListener;
  private boolean pullUpReady;
  
  public PullToRequestGridAdapter(PullToRequestView paramPullToRequestView)
  {
    super(paramPullToRequestView);
    this.gridView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      private int firstVisibleItem;
      private int visibleItemCount;
      
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.firstVisibleItem = paramAnonymousInt1;
        this.visibleItemCount = paramAnonymousInt2;
        View localView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt2 - 1);
        PullToRequestGridAdapter localPullToRequestGridAdapter = PullToRequestGridAdapter.this;
        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (localView != null) && (localView.getBottom() <= paramAnonymousAbsListView.getBottom())) {}
        for (boolean bool = true;; bool = false)
        {
          PullToRequestGridAdapter.access$302(localPullToRequestGridAdapter, bool);
          PullToRequestGridAdapter.this.onScroll(PullToRequestGridAdapter.this.gridView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          return;
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        paramAnonymousAbsListView = PullToRequestGridAdapter.this;
        boolean bool;
        if (paramAnonymousInt == 2)
        {
          bool = true;
          PullToRequestGridAdapter.access$002(paramAnonymousAbsListView, bool);
          if (paramAnonymousInt == 0)
          {
            if (PullToRequestGridAdapter.this.osListener == null) {
              break label58;
            }
            PullToRequestGridAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
          }
        }
        label58:
        while (PullToRequestGridAdapter.this.adapter == null)
        {
          return;
          bool = false;
          break;
        }
        PullToRequestGridAdapter.this.adapter.notifyDataSetChanged();
      }
    });
    this.adapter = new PullToRequestBaseAdapter(this);
    this.gridView.setAdapter(this.adapter);
  }
  
  public Scrollable getBodyView()
  {
    return this.gridView;
  }
  
  public GridView getGridView()
  {
    return this.gridView;
  }
  
  public boolean isFling()
  {
    return this.fling;
  }
  
  public boolean isPullDownReady()
  {
    return this.gridView.isReadyToPull();
  }
  
  public boolean isPullUpReady()
  {
    return this.pullUpReady;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.adapter.notifyDataSetChanged();
  }
  
  protected ScrollableGridView onNewGridView(Context paramContext)
  {
    return new ScrollableGridView(paramContext);
  }
  
  public void onScroll(Scrollable paramScrollable, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setColumnWidth(int paramInt)
  {
    this.gridView.setColumnWidth(paramInt);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    this.gridView.setHorizontalSpacing(paramInt);
  }
  
  public void setNumColumns(int paramInt)
  {
    this.gridView.setNumColumns(paramInt);
  }
  
  public void setStretchMode(int paramInt)
  {
    this.gridView.setStretchMode(paramInt);
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    this.gridView.setVerticalSpacing(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/PullToRequestGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */