package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuSearchHistoryBean
{
  public String cityCode;
  public String cityName;
  public Double city_latitude;
  public Double city_longitude;
  public String endDate;
  public String startDate;
  public long updateTime;
  
  public String toString()
  {
    return "MinsuSearchHistoryBean{cityName='" + this.cityName + '\'' + ", cityCode='" + this.cityCode + '\'' + ", city_latitude=" + this.city_latitude + ", city_longitude=" + this.city_longitude + ", startDate='" + this.startDate + '\'' + ", endDate='" + this.endDate + '\'' + ", updateTime=" + this.updateTime + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuSearchHistoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */