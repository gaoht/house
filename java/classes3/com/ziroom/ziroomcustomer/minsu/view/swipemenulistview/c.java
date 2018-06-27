package com.ziroom.ziroomcustomer.minsu.view.swipemenulistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

public class c
  implements WrapperListAdapter, SwipeMenuView.a
{
  private ListAdapter a;
  private Context b;
  private SwipeMenuListView.a c;
  
  public c(Context paramContext, ListAdapter paramListAdapter)
  {
    this.a = paramListAdapter;
    this.b = paramContext;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }
  
  public void createMenu(b paramb)
  {
    e locale = new e(this.b);
    locale.setTitle("Item 1");
    locale.setBackground(new ColorDrawable(-7829368));
    locale.setWidth(300);
    paramb.addMenuItem(locale);
    locale = new e(this.b);
    locale.setTitle("Item 2");
    locale.setBackground(new ColorDrawable(-65536));
    locale.setWidth(300);
    paramb.addMenuItem(locale);
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.a.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getView(paramInt, paramView, paramViewGroup);
      Object localObject = new b(this.b);
      ((b)localObject).setViewType(getItemViewType(paramInt));
      createMenu((b)localObject);
      localObject = new SwipeMenuView((b)localObject, (SwipeMenuListView)paramViewGroup);
      ((SwipeMenuView)localObject).setOnSwipeItemClickListener(this);
      paramViewGroup = (SwipeMenuListView)paramViewGroup;
      paramView = new SwipeMenuLayout(paramView, (SwipeMenuView)localObject, paramViewGroup.getCloseInterpolator(), paramViewGroup.getOpenInterpolator());
      paramView.setPosition(paramInt);
    }
    for (;;)
    {
      if ((this.a instanceof a)) {
        paramView.setSwipEnable(((a)this.a).getSwipEnableByPosition(paramInt));
      }
      return paramView;
      paramView = (SwipeMenuLayout)paramView;
      paramView.closeMenu();
      paramView.setPosition(paramInt);
      this.a.getView(paramInt, paramView.getContentView(), paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return this.a.getViewTypeCount();
  }
  
  public ListAdapter getWrappedAdapter()
  {
    return this.a;
  }
  
  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.a.isEnabled(paramInt);
  }
  
  public void onItemClick(SwipeMenuView paramSwipeMenuView, b paramb, int paramInt)
  {
    if (this.c != null) {
      this.c.onMenuItemClick(paramSwipeMenuView.getPosition(), paramb, paramInt);
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void setOnSwipeItemClickListener(SwipeMenuListView.a parama)
  {
    this.c = parama;
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/swipemenulistview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */