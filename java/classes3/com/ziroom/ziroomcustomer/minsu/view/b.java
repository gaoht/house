package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class b
  extends BaseAdapter
{
  protected Context a;
  protected List<String> b;
  protected int c = -1;
  
  public b(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public String getItem(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void hideView(int paramInt)
  {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public void removeView(int paramInt)
  {
    this.b.remove(paramInt);
    notifyDataSetChanged();
  }
  
  public void setHideView(View paramView) {}
  
  public void showHideView()
  {
    this.c = -1;
    notifyDataSetChanged();
  }
  
  public void swapView(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      this.b.add(paramInt2 + 1, getItem(paramInt1));
      this.b.remove(paramInt1);
    }
    for (;;)
    {
      this.c = paramInt2;
      notifyDataSetChanged();
      return;
      if (paramInt1 > paramInt2)
      {
        this.b.add(paramInt2, getItem(paramInt1));
        this.b.remove(paramInt1 + 1);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */