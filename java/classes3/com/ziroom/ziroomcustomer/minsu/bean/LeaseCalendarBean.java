package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class LeaseCalendarBean
  extends MinsuBaseJson
  implements Serializable
{
  public DataBean data;
  
  public String toString()
  {
    return "LeaseCalendarBean{data=" + this.data + '}';
  }
  
  public static class DataBean
    implements Serializable
  {
    public List<MonthListBean> monthList;
    public String tillDate;
    
    public String toString()
    {
      return "DataBean{tillDate='" + this.tillDate + '\'' + ", monthList=" + this.monthList + '}';
    }
    
    public static class MonthListBean
      implements Serializable
    {
      public List<CalendarListBean> calendarList;
      public String monthStr;
      
      public String toString()
      {
        return "MonthListBean{monthStr='" + this.monthStr + '\'' + ", calendarList=" + this.calendarList + '}';
      }
      
      public static class CalendarListBean
        implements Serializable
      {
        public String date;
        public int price;
        public int status;
        
        public String toString()
        {
          return "CalendarListBean{date='" + this.date + '\'' + ", price=" + this.price + ", status=" + this.status + '}';
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/LeaseCalendarBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */