package com.ziroom.ziroomcustomer.bestgoods.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

public class ScrollGridLayoutManager
  extends GridLayoutManager
{
  private boolean z = true;
  
  public ScrollGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ScrollGridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt1, paramInt2, paramBoolean);
  }
  
  public ScrollGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean canScrollVertically()
  {
    return (this.z) && (super.canScrollVertically());
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/widget/ScrollGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */