package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.a.b;
import com.ziroom.ziroomcustomer.minsu.view.swipemenulistview.a;
import java.util.List;

abstract class c<T>
  extends a
{
  protected Context a;
  protected List<T> b;
  protected final int c;
  
  public c(Context paramContext, List<T> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
  }
  
  private b a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return b.get(this.a, paramView, paramViewGroup, this.c, paramInt);
  }
  
  public void addDatas(List<T> paramList)
  {
    if (this.b == null)
    {
      this.b = paramList;
      return;
    }
    this.b.addAll(paramList);
  }
  
  public abstract void convert(b paramb, T paramT);
  
  public void convert(b paramb, T paramT, int paramInt)
  {
    convert(paramb, paramT);
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public List<T> getDatas()
  {
    return this.b;
  }
  
  public T getItem(int paramInt)
  {
    return (T)this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = a(paramInt, paramView, paramViewGroup);
    if (paramView == null) {
      initView(paramViewGroup.getConvertView());
    }
    convert(paramViewGroup, getItem(paramInt), paramInt);
    return paramViewGroup.getConvertView();
  }
  
  public void initView(View paramView) {}
  
  public void setDatas(List<T> paramList)
  {
    this.b = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */