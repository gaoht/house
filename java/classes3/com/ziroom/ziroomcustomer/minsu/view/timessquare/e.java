package com.ziroom.ziroomcustomer.minsu.view.timessquare;

import java.util.Date;

public class e
{
  private final Date a;
  private final int b;
  private final boolean c;
  private boolean d;
  private final boolean e;
  private final boolean f;
  private boolean g;
  private a h;
  
  public e(Date paramDate, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt, a parama)
  {
    this.a = paramDate;
    this.c = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean5;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
    this.b = paramInt;
    this.h = parama;
  }
  
  boolean a()
  {
    return this.g;
  }
  
  public Date getDate()
  {
    return this.a;
  }
  
  public a getRangeState()
  {
    return this.h;
  }
  
  public int getValue()
  {
    return this.b;
  }
  
  public boolean isCurrentMonth()
  {
    return this.c;
  }
  
  public boolean isSelectable()
  {
    return this.f;
  }
  
  public boolean isSelected()
  {
    return this.d;
  }
  
  public boolean isToday()
  {
    return this.e;
  }
  
  public void setHighlighted(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setRangeState(a parama)
  {
    this.h = parama;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public String toString()
  {
    return "MonthCellDescriptor{date=" + this.a + ", value=" + this.b + ", isCurrentMonth=" + this.c + ", isSelected=" + this.d + ", isToday=" + this.e + ", isSelectable=" + this.f + ", isHighlighted=" + this.g + ", rangeState=" + this.h + '}';
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/timessquare/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */