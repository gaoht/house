package android.support.v7.view.menu;

import android.support.v7.appcompat.R.layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class g
  extends BaseAdapter
{
  static final int a = R.layout.abc_popup_menu_item_layout;
  h b;
  private int c = -1;
  private boolean d;
  private final boolean e;
  private final LayoutInflater f;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.f = paramLayoutInflater;
    this.b = paramh;
    a();
  }
  
  void a()
  {
    j localj = this.b.getExpandedItem();
    if (localj != null)
    {
      ArrayList localArrayList = this.b.getNonActionItems();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((j)localArrayList.get(i) == localj)
        {
          this.c = i;
          return;
        }
        i += 1;
      }
    }
    this.c = -1;
  }
  
  public h getAdapterMenu()
  {
    return this.b;
  }
  
  public int getCount()
  {
    if (this.e) {}
    for (ArrayList localArrayList = this.b.getNonActionItems(); this.c < 0; localArrayList = this.b.getVisibleItems()) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public boolean getForceShowIcon()
  {
    return this.d;
  }
  
  public j getItem(int paramInt)
  {
    if (this.e) {}
    for (ArrayList localArrayList = this.b.getNonActionItems();; localArrayList = this.b.getVisibleItems())
    {
      int i = paramInt;
      if (this.c >= 0)
      {
        i = paramInt;
        if (paramInt >= this.c) {
          i = paramInt + 1;
        }
      }
      return (j)localArrayList.get(i);
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.f.inflate(a, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = (o.a)paramView;
      if (this.d) {
        ((ListMenuItemView)paramView).setForceShowIcon(true);
      }
      paramViewGroup.initialize(getItem(paramInt), 0);
      return paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */