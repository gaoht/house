package com.ziroom.ziroomcustomer.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class a
{
  private static final b a = new a(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new c(null);
      return;
    }
  }
  
  static int a(View paramView)
  {
    return a.getPaddingStart(paramView);
  }
  
  static int b(View paramView)
  {
    return a.getPaddingEnd(paramView);
  }
  
  private static class a
    implements a.b
  {
    public int getPaddingEnd(View paramView)
    {
      return paramView.getPaddingRight();
    }
    
    public int getPaddingStart(View paramView)
    {
      return paramView.getPaddingLeft();
    }
  }
  
  private static abstract interface b
  {
    public abstract int getPaddingEnd(View paramView);
    
    public abstract int getPaddingStart(View paramView);
  }
  
  @TargetApi(17)
  private static class c
    extends a.a
  {
    private c()
    {
      super();
    }
    
    public int getPaddingEnd(View paramView)
    {
      return paramView.getPaddingEnd();
    }
    
    public int getPaddingStart(View paramView)
    {
      return paramView.getPaddingStart();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */