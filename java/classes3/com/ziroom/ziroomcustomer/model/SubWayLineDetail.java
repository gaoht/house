package com.ziroom.ziroomcustomer.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class SubWayLineDetail
  extends b
{
  public List<subwayList> data;
  
  public class subwayList
  {
    public String subwayList_name;
    public List<SubWayLineDetail.subwayStation> subway_station;
    
    public subwayList() {}
  }
  
  public static class subwayStation
  {
    public String subway_station_name;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SubWayLineDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */