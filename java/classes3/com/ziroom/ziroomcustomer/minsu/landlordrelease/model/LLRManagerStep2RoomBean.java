package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class LLRManagerStep2RoomBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public int balconyNum;
    public BedTypeListBean bedTypeList;
    public List<BedTypeMsgListBean> bedTypeMsgList;
    public HouseAreaBean houseArea;
    public HouseAroundDescBean houseAroundDesc;
    public HouseDescBean houseDesc;
    public HouseFacilityBean houseFacility;
    public List<HouseFacilityGroupBean> houseFacilityGroup;
    public HouseModelBean houseModel;
    public IsTogetherLandlordBean isTogetherLandlord;
    public IsTogetherLandlordListBean isTogetherLandlordList;
    public IsToiletBean isToilet;
    public IsToiletListBean isToiletList;
    public int kitchenNum;
    public LimitPersonBean limitPerson;
    public LimitPersonListBean limitPersonList;
    public int maxBalcony;
    public int maxKitchen;
    public int maxParlor;
    public int maxRoom;
    public int maxToilet;
    public int parlorNum;
    public RentRoomNumBean rentRoomNum;
    public RoomNameBean roomName;
    public int roomNum;
    public int roomStatus;
    public int roomType;
    public int toiletNum;
    
    public static class BedTypeListBean
    {
      public boolean isEdit;
      public List<ListBeanX> list;
      
      public static class ListBeanX
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public int value;
      }
    }
    
    public static class BedTypeMsgListBean
    {
      public int bedType;
      public List<?> bedfids;
      public int maxNum;
      public int num;
    }
    
    public static class HouseAreaBean
    {
      public boolean isEdit;
      public int value;
    }
    
    public static class HouseAroundDescBean
    {
      public String auditMsg;
      public boolean isEdit;
      public String value;
    }
    
    public static class HouseDescBean
    {
      public String auditMsg;
      public boolean isEdit;
      public String value;
    }
    
    public static class HouseFacilityBean
    {
      public String explain;
      public boolean isEdit;
      public String text;
      public String value;
    }
    
    public static class HouseFacilityGroupBean
    {
      public FacilitiesListBean facilitiesList;
      public String name;
      
      public static class FacilitiesListBean
      {
        public boolean isEdit;
        public List<ListBeanXXXX> list;
        
        public static class ListBeanXXXX
        {
          public String explain;
          public boolean isSelect;
          public String text;
          public String value;
        }
      }
    }
    
    public static class HouseModelBean
    {
      public String explain;
      public boolean isEdit;
      public String text;
      public String value;
    }
    
    public static class IsTogetherLandlordBean
    {
      public boolean isEdit;
      public int value;
    }
    
    public static class IsTogetherLandlordListBean
    {
      public boolean isEdit;
      public List<ListBean> list;
      
      public static class ListBean
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public int value;
      }
    }
    
    public static class IsToiletBean
    {
      public boolean isEdit;
      public int value;
    }
    
    public static class IsToiletListBean
    {
      public boolean isEdit;
      public List<ListBeanXX> list;
      
      public static class ListBeanXX
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public int value;
      }
    }
    
    public static class LimitPersonBean
    {
      public boolean isEdit;
      public int value;
    }
    
    public static class LimitPersonListBean
    {
      public boolean isEdit;
      public List<ListBeanXXX> list;
      
      public static class ListBeanXXX
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public int value;
      }
    }
    
    public static class RentRoomNumBean
    {
      public boolean isEdit;
      public String value;
    }
    
    public static class RoomNameBean
    {
      public String auditMsg;
      public boolean isEdit;
      public String value;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLRManagerStep2RoomBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */