package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

public class SegmentedRadioGroup
  extends RadioGroup
{
  private Context a;
  
  public SegmentedRadioGroup(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public SegmentedRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  private void a()
  {
    int i = 1;
    int j = super.getChildCount();
    if (j > 1)
    {
      super.getChildAt(0).setBackgroundResource(2130839446);
      while (i < j - 1)
      {
        super.getChildAt(i).setBackgroundResource(2130839447);
        i += 1;
      }
      super.getChildAt(j - 1).setBackgroundResource(2130839448);
    }
    while (j != 1) {
      return;
    }
    super.getChildAt(0).setBackgroundResource(2130839440);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SegmentedRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */