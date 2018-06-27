package com.ziroom.ziroomcustomer.account.swipemenulistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

public class b
  implements WrapperListAdapter, SwipeMenuView.a
{
  private ListAdapter a;
  private Context b;
  private SwipeMenuListView.a c;
  
  public b(Context paramContext, ListAdapter paramListAdapter)
  {
    this.a = paramListAdapter;
    this.b = paramContext;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }
  
  public void createMenu(a parama)
  {
    d locald = new d(this.b);
    locald.setTitle("Item 1");
    locald.setBackground(new ColorDrawable(-7829368));
    locald.setWidth(300);
    parama.addMenuItem(locald);
    locald = new d(this.b);
    locald.setTitle("Item 2");
    locald.setBackground(new ColorDrawable(-65536));
    locald.setWidth(300);
    parama.addMenuItem(locald);
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
      Object localObject = new a(this.b);
      ((a)localObject).setViewType(this.a.getItemViewType(paramInt));
      createMenu((a)localObject);
      localObject = new SwipeMenuView((a)localObject, (SwipeMenuListView)paramViewGroup);
      ((SwipeMenuView)localObject).setOnSwipeItemClickListener(this);
      paramViewGroup = (SwipeMenuListView)paramViewGroup;
      paramView = new SwipeMenuLayout(paramView, (SwipeMenuView)localObject, paramViewGroup.getCloseInterpolator(), paramViewGroup.getOpenInterpolator());
      paramView.setPosition(paramInt);
      return paramView;
    }
    paramView = (SwipeMenuLayout)paramView;
    paramView.closeMenu();
    paramView.setPosition(paramInt);
    this.a.getView(paramInt, paramView.getContentView(), paramViewGroup);
    return paramView;
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
  
  public void onItemClick(SwipeMenuView paramSwipeMenuView, a parama, int paramInt)
  {
    if (this.c != null) {
      this.c.onMenuItemClick(paramSwipeMenuView.getPosition(), parama, paramInt);
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void setOnMenuItemClickListener(SwipeMenuListView.a parama)
  {
    this.c = parama;
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */