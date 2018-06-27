package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuAppointmentPhotographerTimeBean
{
  private List<TimesBean> times;
  
  public List<TimesBean> getTimes()
  {
    return this.times;
  }
  
  public void setTimes(List<TimesBean> paramList)
  {
    this.times = paramList;
  }
  
  public static class TimesBean
  {
    private String day;
    private String month;
    private String monthAndDay;
    private List<String> time;
    private String year;
    
    public String getDay()
    {
      return this.day;
    }
    
    public String getMonth()
    {
      return this.month;
    }
    
    public String getMonthAndDay()
    {
      return this.monthAndDay;
    }
    
    public List<String> getTime()
    {
      return this.time;
    }
    
    public String getYear()
    {
      return this.year;
    }
    
    public void setDay(String paramString)
    {
      this.day = paramString;
    }
    
    public void setMonth(String paramString)
    {
      this.month = paramString;
    }
    
    public void setMonthAndDay(String paramString)
    {
      this.monthAndDay = paramString;
    }
    
    public void setTime(List<String> paramList)
    {
      this.time = paramList;
    }
    
    public void setYear(String paramString)
    {
      this.year = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuAppointmentPhotographerTimeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */