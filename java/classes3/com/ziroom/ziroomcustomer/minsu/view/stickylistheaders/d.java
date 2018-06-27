package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

class d
  extends BaseAdapter
  implements f
{
  c<View, Long> a = new c();
  b<Integer, View> b = new b();
  List<Long> c = new ArrayList();
  private final f d;
  
  d(f paramf)
  {
    this.d = paramf;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.d.areAllItemsEnabled();
  }
  
  public void collapse(long paramLong)
  {
    if (!isHeaderCollapsed(paramLong)) {
      this.c.add(Long.valueOf(paramLong));
    }
  }
  
  public void expand(long paramLong)
  {
    if (isHeaderCollapsed(paramLong)) {
      this.c.remove(Long.valueOf(paramLong));
    }
  }
  
  public long findItemIdByView(View paramView)
  {
    return ((Long)this.a.get(paramView)).longValue();
  }
  
  public View findViewByItemId(long paramLong)
  {
    return (View)this.a.getKey(Long.valueOf(paramLong));
  }
  
  public int getCount()
  {
    return this.d.getCount();
  }
  
  public long getHeaderId(int paramInt)
  {
    return this.d.getHeaderId(paramInt);
  }
  
  public View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.d.getHeaderView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.d.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.d.getItemViewType(paramInt);
  }
  
  public List<View> getItemViewsByHeaderId(long paramLong)
  {
    return this.b.get(Integer.valueOf((int)paramLong));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.d.getView(paramInt, paramView, paramViewGroup);
    this.a.put(paramView, Long.valueOf(getItemId(paramInt)));
    this.b.add(Integer.valueOf((int)getHeaderId(paramInt)), paramView);
    if (this.c.contains(Long.valueOf(getHeaderId(paramInt))))
    {
      paramView.setVisibility(8);
      return paramView;
    }
    paramView.setVisibility(0);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return this.d.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.d.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.d.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.d.isEnabled(paramInt);
  }
  
  public boolean isHeaderCollapsed(long paramLong)
  {
    return this.c.contains(Long.valueOf(paramLong));
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.d.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.d.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */