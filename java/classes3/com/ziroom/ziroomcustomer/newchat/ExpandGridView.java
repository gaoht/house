package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class ExpandGridView
  extends GridView
{
  public ExpandGridView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExpandGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/ExpandGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */