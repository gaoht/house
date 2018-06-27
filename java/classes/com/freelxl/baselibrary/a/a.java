package com.freelxl.baselibrary.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class a<T>
  extends BaseAdapter
{
  protected Context a;
  protected List<T> b;
  protected final int c;
  
  public a(Context paramContext, List<T> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
  }
  
  private b a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return b.get(this.a, paramView, paramViewGroup, this.c, paramInt);
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
    paramView = a(paramInt, paramView, paramViewGroup);
    convert(paramView, getItem(paramInt), paramInt);
    return paramView.getConvertView();
  }
  
  public void setDatas(List<T> paramList)
  {
    this.b = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */