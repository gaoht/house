package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.io.Serializable;
import java.util.List;

public class LLReleaseRoomBasicBean
  extends MinsuBaseJson
  implements Serializable
{
  private LLReleaseRoomBasicDataBean data;
  
  public LLReleaseRoomBasicDataBean getData()
  {
    return this.data;
  }
  
  public void setData(LLReleaseRoomBasicDataBean paramLLReleaseRoomBasicDataBean)
  {
    this.data = paramLLReleaseRoomBasicDataBean;
  }
  
  public class LLReleaseRoomBasicDataBean
    implements Serializable
  {
    private int balconyNum;
    private HouseFacilityBean houseFacility;
    private List<RoomFacilityGroupBean> houseFacilityGroup;
    private HouseRoomTypeBean houseModel;
    private String immutableMsg;
    private WithLandlordBean isTogetherLandlordList;
    private int kitchenNum;
    private int maxBalcony;
    private int maxKitchen;
    private int maxParlor;
    private int maxRoom;
    private int maxToilet;
    private int parlorNum;
    private int roomNum;
    private int toiletNum;
    
    public LLReleaseRoomBasicDataBean() {}
    
    public int getBalconyNum()
    {
      return this.balconyNum;
    }
    
    public HouseFacilityBean getHouseFacility()
    {
      return this.houseFacility;
    }
    
    public List<RoomFacilityGroupBean> getHouseFacilityGroup()
    {
      return this.houseFacilityGroup;
    }
    
    public HouseRoomTypeBean getHouseModel()
    {
      return this.houseModel;
    }
    
    public String getImmutableMsg()
    {
      return this.immutableMsg;
    }
    
    public WithLandlordBean getIsTogetherLandlordList()
    {
      return this.isTogetherLandlordList;
    }
    
    public int getKitchenNum()
    {
      return this.kitchenNum;
    }
    
    public int getMaxBalcony()
    {
      return this.maxBalcony;
    }
    
    public int getMaxKitchen()
    {
      return this.maxKitchen;
    }
    
    public int getMaxParlor()
    {
      return this.maxParlor;
    }
    
    public int getMaxRoom()
    {
      return this.maxRoom;
    }
    
    public int getMaxToilet()
    {
      return this.maxToilet;
    }
    
    public int getParlorNum()
    {
      return this.parlorNum;
    }
    
    public int getRoomNum()
    {
      return this.roomNum;
    }
    
    public int getToiletNum()
    {
      return this.toiletNum;
    }
    
    public void setBalconyNum(int paramInt)
    {
      this.balconyNum = paramInt;
    }
    
    public void setHouseFacility(HouseFacilityBean paramHouseFacilityBean)
    {
      this.houseFacility = paramHouseFacilityBean;
    }
    
    public void setHouseFacilityGroup(List<RoomFacilityGroupBean> paramList)
    {
      this.houseFacilityGroup = paramList;
    }
    
    public void setHouseModel(HouseRoomTypeBean paramHouseRoomTypeBean)
    {
      this.houseModel = paramHouseRoomTypeBean;
    }
    
    public void setImmutableMsg(String paramString)
    {
      this.immutableMsg = paramString;
    }
    
    public void setIsTogetherLandlordList(WithLandlordBean paramWithLandlordBean)
    {
      this.isTogetherLandlordList = paramWithLandlordBean;
    }
    
    public void setKitchenNum(int paramInt)
    {
      this.kitchenNum = paramInt;
    }
    
    public void setMaxBalcony(int paramInt)
    {
      this.maxBalcony = paramInt;
    }
    
    public void setMaxKitchen(int paramInt)
    {
      this.maxKitchen = paramInt;
    }
    
    public void setMaxParlor(int paramInt)
    {
      this.maxParlor = paramInt;
    }
    
    public void setMaxRoom(int paramInt)
    {
      this.maxRoom = paramInt;
    }
    
    public void setMaxToilet(int paramInt)
    {
      this.maxToilet = paramInt;
    }
    
    public void setParlorNum(int paramInt)
    {
      this.parlorNum = paramInt;
    }
    
    public void setRoomNum(int paramInt)
    {
      this.roomNum = paramInt;
    }
    
    public void setToiletNum(int paramInt)
    {
      this.toiletNum = paramInt;
    }
    
    public class HouseFacilityBean
      implements Serializable
    {
      private String explain;
      private boolean isEdit;
      private String text;
      private String value;
      
      public HouseFacilityBean() {}
      
      public String getExplain()
      {
        return this.explain;
      }
      
      public String getText()
      {
        return this.text;
      }
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setExplain(String paramString)
      {
        this.explain = paramString;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public class HouseRoomTypeBean
      implements Serializable
    {
      private String explain;
      private boolean isEdit;
      private String text;
      private String value;
      
      public HouseRoomTypeBean() {}
      
      public String getExplain()
      {
        return this.explain;
      }
      
      public String getText()
      {
        return this.text;
      }
      
      public String getValue()
      {
        return this.value;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setExplain(String paramString)
      {
        this.explain = paramString;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
      
      public void setValue(String paramString)
      {
        this.value = paramString;
      }
    }
    
    public class WithLandlordBean
      implements Serializable
    {
      private boolean isEdit;
      private List<WithLandlordDataBean> list;
      
      public WithLandlordBean() {}
      
      public List<WithLandlordDataBean> getList()
      {
        return this.list;
      }
      
      public boolean isEdit()
      {
        return this.isEdit;
      }
      
      public void setEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setList(List<WithLandlordDataBean> paramList)
      {
        this.list = paramList;
      }
      
      public class WithLandlordDataBean
        implements Serializable
      {
        private String explain;
        private boolean isSelect;
        private String text;
        private int value;
        
        public WithLandlordDataBean() {}
        
        public String getExplain()
        {
          return this.explain;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public int getValue()
        {
          return this.value;
        }
        
        public boolean isSelect()
        {
          return this.isSelect;
        }
        
        public void setExplain(String paramString)
        {
          this.explain = paramString;
        }
        
        public void setSelect(boolean paramBoolean)
        {
          this.isSelect = paramBoolean;
        }
        
        public void setText(String paramString)
        {
          this.text = paramString;
        }
        
        public void setValue(int paramInt)
        {
          this.value = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/roombasic/LLReleaseRoomBasicBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */