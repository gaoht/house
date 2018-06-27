package com.ziroom.commonlibrary.widget.convenientbanner;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class a
  extends Scroller
{
  private int a = 800;
  private boolean b;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public a(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public a(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    super(paramContext, paramInterpolator, paramBoolean);
  }
  
  public int getScrollDuration()
  {
    return this.a;
  }
  
  public boolean isZero()
  {
    return this.b;
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setZero(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.b) {}
    for (int i = 0;; i = this.a)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, i);
      return;
    }
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.b) {}
    for (paramInt5 = 0;; paramInt5 = this.a)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/convenientbanner/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */