package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class CalendarGridView
  extends ViewGroup
{
  private final Paint a = new Paint();
  private int b;
  private int c;
  
  public CalendarGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setColor(getResources().getColor(2131623989));
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() == 0) {
      ((CalendarRowView)paramView).setIsHeaderRow(true);
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = 0;
    super.dispatchDraw(paramCanvas);
    ViewGroup localViewGroup = (ViewGroup)getChildAt(1);
    int j = localViewGroup.getTop();
    int k = getBottom();
    int m = localViewGroup.getChildAt(0).getLeft() + getLeft();
    paramCanvas.drawLine(m + 0.5F, j, m + 0.5F, k, this.a);
    while (i < 7)
    {
      float f = localViewGroup.getChildAt(i).getRight() + m - 0.5F;
      paramCanvas.drawLine(f, j, f, k, this.a);
      i += 1;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    int i = paramView.getBottom() - 1;
    paramCanvas.drawLine(paramView.getLeft(), i, paramView.getRight() - 2, i, this.a);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = System.currentTimeMillis();
    int i = getChildCount();
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      int j = localView.getMeasuredHeight();
      localView.layout(paramInt1, paramInt4, paramInt3, paramInt4 + j);
      paramInt4 += j;
      paramInt2 += 1;
    }
    d.d("Grid.onLayout %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    d.d("Grid.onMeasure w=%s h=%s", new Object[] { View.MeasureSpec.toString(paramInt1), View.MeasureSpec.toString(paramInt2) });
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (this.b == paramInt1)
    {
      d.d("SKIP Grid.onMeasure");
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
    long l = System.currentTimeMillis();
    this.b = paramInt1;
    int j = paramInt1 / 7;
    int k = j * 7;
    int m = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
    View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    int n = getChildCount();
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt1 < n)
    {
      View localView = getChildAt(paramInt1);
      int i = paramInt2;
      if (localView.getVisibility() == 0)
      {
        if (paramInt1 != 0) {
          break label163;
        }
        measureChild(localView, m, View.MeasureSpec.makeMeasureSpec(j, Integer.MIN_VALUE));
      }
      for (;;)
      {
        i = paramInt2 + localView.getMeasuredHeight();
        paramInt1 += 1;
        paramInt2 = i;
        break;
        label163:
        measureChild(localView, m, View.MeasureSpec.makeMeasureSpec(j, 0));
      }
    }
    setMeasuredDimension(k + 2, paramInt2);
    d.d("Grid.onMeasure %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void setDayBackground(int paramInt)
  {
    int i = 1;
    while (i < getChildCount())
    {
      ((CalendarRowView)getChildAt(i)).setCellBackground(paramInt);
      i += 1;
    }
  }
  
  public void setDayTextColor(int paramInt)
  {
    int i = 0;
    while (i < getChildCount())
    {
      ColorStateList localColorStateList = getResources().getColorStateList(paramInt);
      ((CalendarRowView)getChildAt(i)).setCellTextColor(localColorStateList);
      i += 1;
    }
  }
  
  public void setDayViewAdapter(b paramb)
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((CalendarRowView)getChildAt(i)).setDayViewAdapter(paramb);
      i += 1;
    }
  }
  
  public void setDisplayHeader(boolean paramBoolean)
  {
    int i = 0;
    View localView = getChildAt(0);
    if (paramBoolean) {}
    for (;;)
    {
      localView.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
  
  public void setHeaderTextColor(int paramInt)
  {
    ((CalendarRowView)getChildAt(0)).setCellTextColor(paramInt);
  }
  
  public void setNumRows(int paramInt)
  {
    if (this.c != paramInt) {
      this.b = 0;
    }
    this.c = paramInt;
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    int i = 0;
    while (i < getChildCount())
    {
      ((CalendarRowView)getChildAt(i)).setTypeface(paramTypeface);
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/CalendarGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */