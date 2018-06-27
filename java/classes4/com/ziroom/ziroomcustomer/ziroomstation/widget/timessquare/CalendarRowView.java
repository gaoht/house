package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class CalendarRowView
  extends ViewGroup
  implements View.OnClickListener
{
  private boolean a;
  private MonthView.a b;
  
  public CalendarRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setOnClickListener(this);
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.b != null) {
      this.b.handleClick((e)paramView.getTag());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = System.currentTimeMillis();
    paramInt3 -= paramInt1;
    int i = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      getChildAt(paramInt1).layout((paramInt1 + 0) * paramInt3 / 7, 0, (paramInt1 + 1) * paramInt3 / 7, paramInt4 - paramInt2);
      paramInt1 += 1;
    }
    d.d("Row.onLayout %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = getChildCount();
    paramInt2 = 0;
    paramInt1 = 0;
    int i;
    if (paramInt2 < k)
    {
      View localView = getChildAt(paramInt2);
      i = (paramInt2 + 0) * j / 7;
      i = (paramInt2 + 1) * j / 7 - i;
      int m = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      if (this.a)
      {
        i = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        label78:
        localView.measure(m, i);
        if (localView.getMeasuredHeight() <= paramInt1) {
          break label169;
        }
        paramInt1 = localView.getMeasuredHeight();
      }
    }
    label169:
    for (;;)
    {
      paramInt2 += 1;
      break;
      i = View.MeasureSpec.makeMeasureSpec(500, Integer.MIN_VALUE);
      break label78;
      setMeasuredDimension(getPaddingLeft() + j + getPaddingRight(), paramInt1 + getPaddingTop() + getPaddingBottom());
      d.d("Row.onMeasure %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
  }
  
  public void setCellBackground(int paramInt)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setBackgroundResource(paramInt);
      i += 1;
    }
  }
  
  public void setCellTextColor(int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if ((getChildAt(i) instanceof CalendarCellView)) {
        ((CalendarCellView)getChildAt(i)).getDayOfMonthTextView().setTextColor(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        ((TextView)getChildAt(i)).setTextColor(paramInt);
      }
    }
  }
  
  public void setCellTextColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if ((getChildAt(i) instanceof CalendarCellView)) {
        ((CalendarCellView)getChildAt(i)).getDayOfMonthTextView().setTextColor(paramColorStateList);
      }
      for (;;)
      {
        i += 1;
        break;
        ((TextView)getChildAt(i)).setTextColor(paramColorStateList);
      }
    }
  }
  
  public void setDayViewAdapter(b paramb)
  {
    int i = 0;
    while (i < getChildCount())
    {
      if ((getChildAt(i) instanceof CalendarCellView))
      {
        CalendarCellView localCalendarCellView = (CalendarCellView)getChildAt(i);
        localCalendarCellView.removeAllViews();
        paramb.makeCellView(localCalendarCellView);
      }
      i += 1;
    }
  }
  
  public void setIsHeaderRow(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setListener(MonthView.a parama)
  {
    this.b = parama;
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if ((getChildAt(i) instanceof CalendarCellView)) {
        ((CalendarCellView)getChildAt(i)).getDayOfMonthTextView().setTypeface(paramTypeface);
      }
      for (;;)
      {
        i += 1;
        break;
        ((TextView)getChildAt(i)).setTypeface(paramTypeface);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/CalendarRowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */