package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.io.Serializable;

public class WeekBean
  implements Serializable
{
  private String weekName;
  private int weekNum;
  
  public String getWeekName()
  {
    return this.weekName;
  }
  
  public int getWeekNum()
  {
    return this.weekNum;
  }
  
  public void setWeekName(String paramString)
  {
    this.weekName = paramString;
  }
  
  public void setWeekNum(int paramInt)
  {
    this.weekNum = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/WeekBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */