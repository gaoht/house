package com.ziroom.ziroomcustomer.ziroomstation.model;

public class StationEvaluateBean
{
  private DateBean date;
  private String message;
  private String status;
  
  public DateBean getDate()
  {
    return this.date;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setDate(DateBean paramDateBean)
  {
    this.date = paramDateBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DateBean
  {
    private double averageStar;
    private int evaluateRecordCount;
    private int starLevelQuestionCount;
    private int totalStarCount;
    
    public double getAverageStar()
    {
      return this.averageStar;
    }
    
    public int getEvaluateRecordCount()
    {
      return this.evaluateRecordCount;
    }
    
    public int getStarLevelQuestionCount()
    {
      return this.starLevelQuestionCount;
    }
    
    public int getTotalStarCount()
    {
      return this.totalStarCount;
    }
    
    public void setAverageStar(double paramDouble)
    {
      this.averageStar = paramDouble;
    }
    
    public void setEvaluateRecordCount(int paramInt)
    {
      this.evaluateRecordCount = paramInt;
    }
    
    public void setStarLevelQuestionCount(int paramInt)
    {
      this.starLevelQuestionCount = paramInt;
    }
    
    public void setTotalStarCount(int paramInt)
    {
      this.totalStarCount = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationEvaluateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */