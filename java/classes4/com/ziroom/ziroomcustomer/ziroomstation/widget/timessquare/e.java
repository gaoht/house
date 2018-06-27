package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import java.util.Date;

public class e
{
  private final Date a;
  private final int b;
  private final boolean c;
  private boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private boolean i;
  private a j;
  
  e(Date paramDate, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt, a parama)
  {
    this.a = paramDate;
    this.c = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramBoolean7;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
    this.f = paramBoolean5;
    this.g = paramBoolean6;
    this.b = paramInt;
    this.j = parama;
  }
  
  void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  boolean a()
  {
    return this.i;
  }
  
  public Date getDate()
  {
    return this.a;
  }
  
  public a getRangeState()
  {
    return this.j;
  }
  
  public int getValue()
  {
    return this.b;
  }
  
  public boolean isAftertomorrow()
  {
    return this.g;
  }
  
  public boolean isCurrentMonth()
  {
    return this.c;
  }
  
  public boolean isSelectable()
  {
    return this.h;
  }
  
  public boolean isSelected()
  {
    return this.d;
  }
  
  public boolean isToday()
  {
    return this.e;
  }
  
  public boolean isTomorrow()
  {
    return this.f;
  }
  
  public void setRangeState(a parama)
  {
    this.j = parama;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public String toString()
  {
    return "MonthCellDescriptor{date=" + this.a + ", value=" + this.b + ", isCurrentMonth=" + this.c + ", isSelected=" + this.d + ", isToday=" + this.e + ", isSelectable=" + this.h + ", isHighlighted=" + this.i + ", rangeState=" + this.j + '}';
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */