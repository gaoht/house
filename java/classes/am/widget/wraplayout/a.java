package am.widget.wraplayout;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

class a
{
  static final b a = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new c();
      return;
    }
  }
  
  public static int getPaddingEnd(View paramView)
  {
    return a.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView)
  {
    return a.getPaddingStart(paramView);
  }
  
  static class a
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
  
  static abstract interface b
  {
    public abstract int getPaddingEnd(View paramView);
    
    public abstract int getPaddingStart(View paramView);
  }
  
  @TargetApi(17)
  static class c
    extends a.a
  {
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/am/widget/wraplayout/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */