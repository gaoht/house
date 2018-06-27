package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

public abstract class PullToRequestBaseListAdapter
  extends PullToRequestAdatper
{
  public PullToRequestBaseListAdapter(PullToRequestView paramPullToRequestView)
  {
    super(paramPullToRequestView);
  }
  
  public abstract int getCount();
  
  public abstract Object getItem(int paramInt);
  
  public abstract long getItemId(int paramInt);
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public abstract boolean isFling();
  
  public abstract void onScroll(Scrollable paramScrollable, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/PullToRequestBaseListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */