package com.ziroom.ziroomcustomer.account.swipemenulistview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private Context a;
  private List<d> b;
  private int c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  public void addMenuItem(d paramd)
  {
    this.b.add(paramd);
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public d getMenuItem(int paramInt)
  {
    return (d)this.b.get(paramInt);
  }
  
  public List<d> getMenuItems()
  {
    return this.b;
  }
  
  public int getViewType()
  {
    return this.c;
  }
  
  public void removeMenuItem(d paramd)
  {
    this.b.remove(paramd);
  }
  
  public void setViewType(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */