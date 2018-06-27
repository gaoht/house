package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public abstract interface f
  extends ListAdapter
{
  public abstract long getHeaderId(int paramInt);
  
  public abstract View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */