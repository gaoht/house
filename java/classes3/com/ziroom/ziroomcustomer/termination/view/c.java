package com.ziroom.ziroomcustomer.termination.view;

import com.ziroom.ziroomcustomer.termination.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Serializable
{
  public int a;
  public int b;
  public int c;
  public String d;
  public int e;
  private List<b> f = new ArrayList();
  private String g;
  private int h;
  
  public c()
  {
    this.a = a.getYear();
    this.b = a.getMonth();
    this.c = a.getCurrentMonthDay();
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int j;
    if (paramInt2 > 12)
    {
      i = paramInt1 + 1;
      j = 1;
    }
    for (;;)
    {
      this.a = i;
      this.b = j;
      this.c = paramInt3;
      return;
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 < 1)
      {
        i = paramInt1 - 1;
        j = 12;
      }
    }
  }
  
  public static c modifiDayForObject(c paramc, int paramInt)
  {
    return new c(paramc.a, paramc.b, paramInt);
  }
  
  public int getDay()
  {
    return this.c;
  }
  
  public int getMonth()
  {
    return this.b;
  }
  
  public int getState()
  {
    return this.h;
  }
  
  public int getWeek()
  {
    return this.e;
  }
  
  public String getXingqi()
  {
    return this.g;
  }
  
  public int getYear()
  {
    return this.a;
  }
  
  public List<b> getmList()
  {
    return this.f;
  }
  
  public void setDay(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMonth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setWeek(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setXingqi(String paramString)
  {
    this.g = paramString;
  }
  
  public void setYear(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setmList(List<b> paramList)
  {
    this.f = paramList;
  }
  
  public String toString()
  {
    return this.a + "-" + this.b + "-" + this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */