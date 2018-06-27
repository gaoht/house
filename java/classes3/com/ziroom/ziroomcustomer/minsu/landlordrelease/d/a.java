package com.ziroom.ziroomcustomer.minsu.landlordrelease.d;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLDaysEditInitBean;

public class a
  extends c
{
  private LLDaysEditInitBean b;
  private String c;
  private String d;
  private String e;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public LLDaysEditInitBean getCalendarEidtInitBean()
  {
    return this.b;
  }
  
  public String getCalendarEidtInitErrorMsg()
  {
    return this.c;
  }
  
  public String getCalendarEidtSaveBean()
  {
    return this.d;
  }
  
  public String getCalendarEidtSaveErrorMsg()
  {
    return this.e;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!str.equals("CalendarEditInit")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("CalendarEditInitError")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("CalendarEditSave")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("CalendarEditSaveError")) {
        break;
      }
      i = 3;
      break;
      this.b = ((LLDaysEditInitBean)parama.getData());
      continue;
      this.c = ((String)parama.getData());
      continue;
      this.d = ((String)parama.getData());
      continue;
      this.e = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */