package com.ziroom.ziroomcustomer.newmovehouse.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class HomeZiroListView
  extends ListView
{
  public HomeZiroListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HomeZiroListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HomeZiroListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    super.onMeasure(paramInt1, paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/HomeZiroListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */