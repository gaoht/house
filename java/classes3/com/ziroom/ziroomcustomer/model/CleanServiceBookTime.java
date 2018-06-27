package com.ziroom.ziroomcustomer.model;

public class CleanServiceBookTime
{
  private String endPoint;
  private int index;
  private String period;
  private String periodId;
  private String startPoint;
  
  public CleanServiceBookTime() {}
  
  public CleanServiceBookTime(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.periodId = paramString1;
    this.endPoint = paramString2;
    this.period = paramString3;
    this.startPoint = paramString4;
    this.index = paramInt;
  }
  
  public String getEndPoint()
  {
    return this.endPoint;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getPeriod()
  {
    return this.period;
  }
  
  public String getPeriodId()
  {
    return this.periodId;
  }
  
  public String getStartPoint()
  {
    return this.startPoint;
  }
  
  public void setEndPoint(String paramString)
  {
    this.endPoint = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setPeriod(String paramString)
  {
    this.period = paramString;
  }
  
  public void setPeriodId(String paramString)
  {
    this.periodId = paramString;
  }
  
  public void setStartPoint(String paramString)
  {
    this.startPoint = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanServiceBookTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */