package com.aspsine.swipetoloadlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SwipeRefreshHeaderLayout
  extends FrameLayout
  implements d, e
{
  public SwipeRefreshHeaderLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeRefreshHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void complete() {}
  
  public void onPrepare() {}
  
  public void onRefresh() {}
  
  public void onRelease() {}
  
  public void onReset() {}
  
  public void onSwipe(int paramInt, boolean paramBoolean) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/aspsine/swipetoloadlayout/SwipeRefreshHeaderLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */