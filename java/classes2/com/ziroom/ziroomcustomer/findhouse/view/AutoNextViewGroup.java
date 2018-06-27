package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class AutoNextViewGroup
  extends ViewGroup
{
  private static int a;
  
  public AutoNextViewGroup(Context paramContext)
  {
    super(paramContext);
    a = a(9.0F);
  }
  
  public AutoNextViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a = a(9.0F);
  }
  
  protected int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("AutoNextViewGroup", "changed = " + paramBoolean + " left = " + paramInt1 + " top = " + paramInt2 + " right = " + paramInt3 + " botom = " + paramInt4);
    int i1 = getChildCount();
    int i = 0;
    paramInt4 = paramInt1;
    int k;
    for (int j = 0; i < i1; j = k)
    {
      View localView = getChildAt(i);
      int i2 = localView.getMeasuredWidth();
      int i3 = localView.getMeasuredHeight();
      int n = paramInt4 + (a + i2);
      int m = (a + i3) * j + paramInt2;
      paramInt4 = n;
      k = j;
      if (n > paramInt3)
      {
        paramInt4 = a + i2 + paramInt1;
        k = j + 1;
        m = (a + i3) * k + paramInt2;
      }
      localView.layout(paramInt4 - i2, m - i3, paramInt4, m);
      i += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Log.d("AutoNextViewGroup", "widthMeasureSpec = " + paramInt1 + " heightMeasureSpec" + paramInt2);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).measure(0, 0);
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/AutoNextViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */