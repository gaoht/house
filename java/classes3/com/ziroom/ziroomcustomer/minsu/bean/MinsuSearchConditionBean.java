package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class MinsuSearchConditionBean
  extends MinsuBaseJson
  implements Serializable
{
  public DataBean data;
  
  public static class DataBean
    implements Serializable
  {
    public CommercialRegionBean commercialRegion;
    public DistrictBean district;
    public SceneryRegionBean sceneryRegion;
    public SubwayBean subway;
    
    public static class CommercialRegionBean
      implements Serializable
    {
      public int index;
      public List<String> list;
      public String name;
    }
    
    public static class DistrictBean
      implements Serializable
    {
      public List<DistrictsBean> districts;
      public int index;
      public String name;
      
      public static class DistrictsBean
        implements Serializable
      {
        public String code;
        public String name;
      }
    }
    
    public static class SceneryRegionBean
      implements Serializable
    {
      public int index;
      public List<String> list;
      public String name;
    }
    
    public static class SubwayBean
      implements Serializable
    {
      public int index;
      public List<ListBean> list;
      public String name;
      
      public static class ListBean
        implements Serializable
      {
        public String lineFid;
        public String name;
        public List<StationsBean> stations;
        
        public static class StationsBean
          implements Serializable
        {
          public int code;
          public String name;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuSearchConditionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */