package com.ziroom.ziroomcustomer.minsu.view.swipemenulistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class ReMeasureSwipeListView
  extends SwipeMenuListView
{
  public ReMeasureSwipeListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReMeasureSwipeListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReMeasureSwipeListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/swipemenulistview/ReMeasureSwipeListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */