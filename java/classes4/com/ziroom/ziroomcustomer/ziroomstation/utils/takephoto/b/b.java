package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class b<T>
  extends BaseAdapter
{
  protected LayoutInflater c;
  protected Context d;
  protected List<T> e;
  protected final int f;
  
  public b(Context paramContext, List<T> paramList, int paramInt)
  {
    this.d = paramContext;
    this.c = LayoutInflater.from(this.d);
    this.e = paramList;
    this.f = paramInt;
  }
  
  private d a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return d.get(this.d, paramView, paramViewGroup, this.f, paramInt);
  }
  
  public abstract void convert(d paramd, T paramT);
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public T getItem(int paramInt)
  {
    return (T)this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = a(paramInt, paramView, paramViewGroup);
    convert(paramView, getItem(paramInt));
    return paramView.getConvertView();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */