package com.ziroom.ziroomcustomer.home.view.recyclerview2gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class SpeedRecyclerView
  extends RecyclerView
{
  public SpeedRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SpeedRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SpeedRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    if (paramInt > 0) {
      return Math.min(paramInt, 2000);
    }
    return Math.max(paramInt, 63536);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    return super.fling(a(paramInt1), a(paramInt2));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/recyclerview2gallery/SpeedRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */