package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.util.List;

public class LLCalendarInfoBean
{
  private List<ListBean> list;
  private String nowDate;
  private String tillDate;
  
  public List<ListBean> getList()
  {
    return this.list;
  }
  
  public String getNowDate()
  {
    return this.nowDate;
  }
  
  public String getTillDate()
  {
    return this.tillDate;
  }
  
  public void setList(List<ListBean> paramList)
  {
    this.list = paramList;
  }
  
  public void setNowDate(String paramString)
  {
    this.nowDate = paramString;
  }
  
  public void setTillDate(String paramString)
  {
    this.tillDate = paramString;
  }
  
  public static class ListBean
  {
    private List<LLCalendarDayInfoBean> calendarList;
    private String monthSpecialStr;
    private String monthStr;
    
    public List<LLCalendarDayInfoBean> getCalendarList()
    {
      return this.calendarList;
    }
    
    public String getMonthSpecialStr()
    {
      return this.monthSpecialStr;
    }
    
    public String getMonthStr()
    {
      return this.monthStr;
    }
    
    public void setCalendarList(List<LLCalendarDayInfoBean> paramList)
    {
      this.calendarList = paramList;
    }
    
    public void setMonthSpecialStr(String paramString)
    {
      this.monthSpecialStr = paramString;
    }
    
    public void setMonthStr(String paramString)
    {
      this.monthStr = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLCalendarInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */