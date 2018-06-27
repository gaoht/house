package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PullToRequestBaseAdapter
  extends BaseAdapter
{
  private PullToRequestBaseListAdapter adapter;
  
  public PullToRequestBaseAdapter(PullToRequestBaseListAdapter paramPullToRequestBaseListAdapter)
  {
    this.adapter = paramPullToRequestBaseListAdapter;
  }
  
  public int getCount()
  {
    return this.adapter.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.adapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.adapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.adapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.adapter.getView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return this.adapter.getViewTypeCount();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/PullToRequestBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */