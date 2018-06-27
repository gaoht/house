package com.ziroom.ziroomcustomer.minsu.view.refresh.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

public abstract class a
  extends Drawable
  implements Animatable
{
  private final Context a;
  private boolean b;
  private Handler c;
  private int[] d;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  protected int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, a().getResources().getDisplayMetrics());
  }
  
  protected Context a()
  {
    return this.a;
  }
  
  protected void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0);
  }
  
  protected void a(Runnable paramRunnable, int paramInt)
  {
    if (this.c == null) {}
    try
    {
      this.c = new Handler(Looper.getMainLooper());
      this.c.postDelayed(paramRunnable, paramInt);
      return;
    }
    finally {}
  }
  
  protected void b(Runnable paramRunnable)
  {
    if (this.c != null) {
      this.c.removeCallbacks(paramRunnable);
    }
  }
  
  public int[] getColors()
  {
    return this.d;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.b;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setColors(int... paramVarArgs)
  {
    this.d = paramVarArgs;
  }
  
  public void setPercent(float paramFloat)
  {
    setPercent(paramFloat, false);
  }
  
  public abstract void setPercent(float paramFloat, boolean paramBoolean);
  
  public void setRunning(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/refresh/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */