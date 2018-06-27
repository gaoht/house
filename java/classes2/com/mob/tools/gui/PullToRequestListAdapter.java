package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public abstract class PullToRequestListAdapter
  extends PullToRequestBaseListAdapter
{
  private PullToRequestBaseAdapter adapter;
  private boolean fling;
  private ScrollableListView listView = onNewListView(getContext());
  private OnListStopScrollListener osListener;
  private boolean pullUpReady;
  
  public PullToRequestListAdapter(PullToRequestView paramPullToRequestView)
  {
    super(paramPullToRequestView);
    this.listView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      private int firstVisibleItem;
      private int visibleItemCount;
      
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.firstVisibleItem = paramAnonymousInt1;
        this.visibleItemCount = paramAnonymousInt2;
        View localView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt2 - 1);
        PullToRequestListAdapter localPullToRequestListAdapter = PullToRequestListAdapter.this;
        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (localView != null) && (localView.getBottom() <= paramAnonymousAbsListView.getBottom())) {}
        for (boolean bool = true;; bool = false)
        {
          PullToRequestListAdapter.access$302(localPullToRequestListAdapter, bool);
          PullToRequestListAdapter.this.onScroll(PullToRequestListAdapter.this.listView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          return;
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        paramAnonymousAbsListView = PullToRequestListAdapter.this;
        boolean bool;
        if (paramAnonymousInt == 2)
        {
          bool = true;
          PullToRequestListAdapter.access$002(paramAnonymousAbsListView, bool);
          if (paramAnonymousInt == 0)
          {
            if (PullToRequestListAdapter.this.osListener == null) {
              break label58;
            }
            PullToRequestListAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
          }
        }
        label58:
        while (PullToRequestListAdapter.this.adapter == null)
        {
          return;
          bool = false;
          break;
        }
        PullToRequestListAdapter.this.adapter.notifyDataSetChanged();
      }
    });
    this.adapter = new PullToRequestBaseAdapter(this);
    this.listView.setAdapter(this.adapter);
  }
  
  public Scrollable getBodyView()
  {
    return this.listView;
  }
  
  public ListView getListView()
  {
    return this.listView;
  }
  
  public boolean isFling()
  {
    return this.fling;
  }
  
  public boolean isPullDownReady()
  {
    return this.listView.isReadyToPull();
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
  
  protected ScrollableListView onNewListView(Context paramContext)
  {
    return new ScrollableListView(paramContext);
  }
  
  public void onScroll(Scrollable paramScrollable, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setDivider(Drawable paramDrawable)
  {
    this.listView.setDivider(paramDrawable);
  }
  
  public void setDividerHeight(int paramInt)
  {
    this.listView.setDividerHeight(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/PullToRequestListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */