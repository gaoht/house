package com.ziroom.ziroomcustomer.minsu.view.swipemenulistview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private Context a;
  private List<e> b;
  private int c;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  public void addMenuItem(e parame)
  {
    this.b.add(parame);
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public e getMenuItem(int paramInt)
  {
    return (e)this.b.get(paramInt);
  }
  
  public List<e> getMenuItems()
  {
    return this.b;
  }
  
  public int getViewType()
  {
    return this.c;
  }
  
  public void removeMenuItem(e parame)
  {
    this.b.remove(parame);
  }
  
  public void setViewType(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/swipemenulistview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */