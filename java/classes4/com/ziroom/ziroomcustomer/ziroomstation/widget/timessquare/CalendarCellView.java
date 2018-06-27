package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CalendarCellView
  extends FrameLayout
{
  private static final int[] a = { 2130772820 };
  private static final int[] b = { 2130772821 };
  private static final int[] c = { 2130772822 };
  private static final int[] d = { 2130772826 };
  private static final int[] e = { 2130772823 };
  private static final int[] f = { 2130772824 };
  private static final int[] g = { 2130772825 };
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private e.a n = e.a.a;
  private TextView o;
  
  public CalendarCellView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextView getDayOfMonthTextView()
  {
    if (this.o == null) {
      throw new IllegalStateException("You have to setDayOfMonthTextView in your custom DayViewAdapter.");
    }
    return this.o;
  }
  
  public e.a getRangeState()
  {
    return this.n;
  }
  
  public boolean isAfterTomorrow()
  {
    return this.l;
  }
  
  public boolean isCurrentMonth()
  {
    return this.i;
  }
  
  public boolean isSelectable()
  {
    return this.h;
  }
  
  public boolean isToday()
  {
    return this.j;
  }
  
  public boolean isTomorrow()
  {
    return this.k;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 5);
    if (this.h) {
      mergeDrawableStates(arrayOfInt, a);
    }
    if (this.i) {
      mergeDrawableStates(arrayOfInt, b);
    }
    if (this.j) {
      mergeDrawableStates(arrayOfInt, c);
    }
    if (this.k) {
      mergeDrawableStates(arrayOfInt, c);
    }
    if (this.l) {
      mergeDrawableStates(arrayOfInt, c);
    }
    if (this.m) {
      mergeDrawableStates(arrayOfInt, d);
    }
    if (this.n == e.a.b) {
      mergeDrawableStates(arrayOfInt, e);
    }
    do
    {
      return arrayOfInt;
      if (this.n == e.a.c)
      {
        mergeDrawableStates(arrayOfInt, f);
        return arrayOfInt;
      }
    } while (this.n != e.a.d);
    mergeDrawableStates(arrayOfInt, g);
    return arrayOfInt;
  }
  
  public void setAfterTomorrow(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setCurrentMonth(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setDayOfMonthTextView(TextView paramTextView)
  {
    this.o = paramTextView;
  }
  
  public void setHighlighted(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setRangeState(e.a parama)
  {
    if (this.n != parama)
    {
      this.n = parama;
      refreshDrawableState();
    }
  }
  
  public void setSelectable(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setToday(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setTomorrow(boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      this.k = paramBoolean;
      refreshDrawableState();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/CalendarCellView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */