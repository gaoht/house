package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.io.Serializable;

public class FrequencyBean
  implements Serializable
{
  private int cycleIndex;
  private String logicCode;
  private String name;
  private String remark;
  private int weekNumber;
  
  public int getCycleIndex()
  {
    return this.cycleIndex;
  }
  
  public String getLogicCode()
  {
    return this.logicCode;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public int getWeekNumber()
  {
    return this.weekNumber;
  }
  
  public void setCycleIndex(int paramInt)
  {
    this.cycleIndex = paramInt;
  }
  
  public void setLogicCode(String paramString)
  {
    this.logicCode = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setWeekNumber(int paramInt)
  {
    this.weekNumber = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/FrequencyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */