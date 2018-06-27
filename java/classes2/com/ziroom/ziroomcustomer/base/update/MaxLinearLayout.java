package com.ziroom.ziroomcustomer.base.update;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MaxLinearLayout
  extends LinearLayout
{
  private int mMaxHeight = 300;
  
  public MaxLinearLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MaxLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MaxLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mMaxHeight = (((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getHeight() / 10 * 7);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 0);
    if (paramInt2 < this.mMaxHeight) {}
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/update/MaxLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */