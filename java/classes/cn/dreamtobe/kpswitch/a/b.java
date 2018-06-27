package cn.dreamtobe.kpswitch.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import cn.dreamtobe.kpswitch.R.styleable;
import cn.dreamtobe.kpswitch.a;
import cn.dreamtobe.kpswitch.b.e;

public class b
  implements a
{
  private final View a;
  private boolean b = false;
  private boolean c = false;
  private final int[] d = new int[2];
  private boolean e = false;
  
  public b(View paramView, AttributeSet paramAttributeSet)
  {
    this.a = paramView;
    View localView;
    if (paramAttributeSet != null) {
      localView = null;
    }
    try
    {
      paramView = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.KPSwitchPanelLayout);
      localView = paramView;
      this.c = paramView.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
      return;
    }
    finally
    {
      if (localView != null) {
        localView.recycle();
      }
    }
  }
  
  public boolean filterSetVisibility(int paramInt)
  {
    if (paramInt == 0) {
      this.b = false;
    }
    if (paramInt == this.a.getVisibility()) {}
    while ((isKeyboardShowing()) && (paramInt == 0)) {
      return true;
    }
    return false;
  }
  
  public void handleHide()
  {
    this.b = true;
  }
  
  public void handleShow()
  {
    throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
  }
  
  public boolean isKeyboardShowing()
  {
    return this.e;
  }
  
  public boolean isVisible()
  {
    return !this.b;
  }
  
  public int[] processOnMeasure(int paramInt1, int paramInt2)
  {
    if (this.b)
    {
      this.a.setVisibility(8);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    this.d[0] = paramInt1;
    this.d[1] = paramInt2;
    return this.d;
  }
  
  public void resetToRecommendPanelHeight(int paramInt)
  {
    if (this.c) {
      return;
    }
    e.refreshHeight(this.a, paramInt);
  }
  
  public void setIgnoreRecommendHeight(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setIsKeyboardShowing(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */