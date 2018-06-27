package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.io.Serializable;

public class DatePlanListBean
  implements Serializable
{
  private String dateName;
  private String dateValue;
  private int index;
  
  public String getDateName()
  {
    return this.dateName;
  }
  
  public String getDateValue()
  {
    return this.dateValue;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void setDateName(String paramString)
  {
    this.dateName = paramString;
  }
  
  public void setDateValue(String paramString)
  {
    this.dateValue = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/DatePlanListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */