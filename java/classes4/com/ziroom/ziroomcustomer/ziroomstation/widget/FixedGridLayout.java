package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class FixedGridLayout
  extends ViewGroup
{
  int a;
  int b;
  private final int c = 4;
  private int d;
  private int e = 4;
  private int f;
  
  public FixedGridLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FixedGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedGridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Log.d("FixedGridLayout", "FixedGridLayout");
    setFocusable(false);
    setFocusableInTouchMode(false);
    setClipChildren(false);
    a();
  }
  
  private void a()
  {
    this.d = ((int)TypedValue.applyDimension(1, 4.0F, getResources().getDisplayMetrics()));
  }
  
  private int getCellbetweenMarginHeight()
  {
    return this.d;
  }
  
  private int getCellbetweenMarginWidth()
  {
    return this.d;
  }
  
  public int getFixedGridRowNum()
  {
    return this.f;
  }
  
  public int getFixedGridcolumnsNum()
  {
    return this.e;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("FixedGridLayout", "onLayout");
    int i = this.a;
    int j = this.b;
    int k = getChildCount();
    paramInt2 = 0;
    paramInt4 = 0;
    paramInt1 = 0;
    paramInt3 = 0;
    if (paramInt3 < k)
    {
      View localView = getChildAt(paramInt3);
      localView.layout(paramInt1, paramInt4, localView.getMeasuredWidth() + paramInt1, localView.getMeasuredHeight() + paramInt4);
      if (paramInt2 >= this.e - 1)
      {
        paramInt2 = 0;
        paramInt1 = 0;
        paramInt4 += getCellbetweenMarginHeight() + j;
      }
      for (;;)
      {
        paramInt3 += 1;
        break;
        paramInt2 += 1;
        paramInt1 += getCellbetweenMarginWidth() + i;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    Log.d("FixedGridLayout", "onMeasure");
    int k = View.MeasureSpec.makeMeasureSpec(this.a, 1073741824);
    int m = View.MeasureSpec.makeMeasureSpec(this.b, 1073741824);
    int n = getChildCount();
    int i = j;
    int i1;
    if (this.e != 0)
    {
      i1 = n / this.e;
      if (n % this.e != 0) {
        break label106;
      }
    }
    label106:
    for (i = 0;; i = 1)
    {
      this.f = (i + i1);
      i = j;
      while (i < n)
      {
        getChildAt(i).measure(k, m);
        i += 1;
      }
    }
    if (n > 3) {}
    setMeasuredDimension(resolveSize(this.a * this.e, paramInt1), resolveSize(this.b * this.f, paramInt2));
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("FixedGridLayout", "onSizeChangedw, " + paramInt1 + " h " + paramInt2 + " oldw " + paramInt3 + " oldh " + paramInt4);
    this.a = ((paramInt1 - this.d * 3) / 4);
    this.b = this.a;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setCellHeight(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setCellWidth(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setConlumeNum(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/FixedGridLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */