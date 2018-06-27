package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class ZZSubway
{
  String subway_code = "";
  String subway_name = "";
  List<Subway_station> subway_station;
  
  public String getSubway_code()
  {
    return this.subway_code;
  }
  
  public String getSubway_name()
  {
    return this.subway_name;
  }
  
  public List<Subway_station> getSubway_station()
  {
    return this.subway_station;
  }
  
  public void setSubway_code(String paramString)
  {
    this.subway_code = paramString;
  }
  
  public void setSubway_name(String paramString)
  {
    this.subway_name = paramString;
  }
  
  public void setSubway_station(List<Subway_station> paramList)
  {
    this.subway_station = paramList;
  }
  
  public String toString()
  {
    return "ZZSubway{subway_name='" + this.subway_name + '\'' + ", subway_station=" + this.subway_station + '}';
  }
  
  public class Subway_station
  {
    String subway_station_code = "";
    String subway_station_name = "";
    
    public Subway_station() {}
    
    public String getSubway_station_code()
    {
      return this.subway_station_code;
    }
    
    public String getSubway_station_name()
    {
      return this.subway_station_name;
    }
    
    public void setSubway_station_code(String paramString)
    {
      this.subway_station_code = paramString;
    }
    
    public void setSubway_station_name(String paramString)
    {
      this.subway_station_name = paramString;
    }
    
    public String toString()
    {
      return "Subway_station{subway_station_name='" + this.subway_station_name + '\'' + ", subway_station_code='" + this.subway_station_code + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ZZSubway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */