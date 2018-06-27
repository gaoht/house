package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class MUIPropertyValuesLayout
  extends ViewGroup
{
  private final int a = (int)getResources().getDimension(2131231199);
  
  public MUIPropertyValuesLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MUIPropertyValuesLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MUIPropertyValuesLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      View localView = getChildAt(paramInt1);
      paramInt4 = paramInt1 % 4 * (localView.getMeasuredWidth() + this.a) + paramInt2;
      int i = paramInt1 / 4 * localView.getMeasuredHeight() + paramInt3;
      localView.layout(paramInt4, i, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + i);
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = (View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight() - this.a * 3) / 4;
    paramInt2 = 0;
    int j;
    if (paramInt2 < getChildCount())
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        j = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(10000, Integer.MIN_VALUE), localView.getPaddingTop() + localView.getPaddingBottom(), localLayoutParams.height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), j);
      }
    }
    if (getChildCount() % 4 == 0) {}
    for (paramInt2 = getChildCount() / 4;; paramInt2 = getChildCount() / 4 + 1)
    {
      i = getChildAt(0).getMeasuredHeight();
      j = getPaddingTop();
      int k = getPaddingBottom();
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.makeMeasureSpec(paramInt2 * i + j + k, 1073741824));
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/MUIPropertyValuesLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */