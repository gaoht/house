package com.ziroom.ziroomcustomer.minsu.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.a.b;
import java.util.List;

public abstract class a<T>
  extends com.freelxl.baselibrary.a.a<T>
{
  public a(Context paramContext, List<T> paramList, int paramInt)
  {
    super(paramContext, paramList, paramInt);
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */