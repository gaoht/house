package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.util.List;

public class LLReleaseRoomHaveBean
  extends MinsuBaseJson
{
  private LLReleaseRoomHaveDataBean data;
  
  public LLReleaseRoomHaveDataBean getData()
  {
    return this.data;
  }
  
  public void setData(LLReleaseRoomHaveDataBean paramLLReleaseRoomHaveDataBean)
  {
    this.data = paramLLReleaseRoomHaveDataBean;
  }
  
  public class LLReleaseRoomHaveDataBean
  {
    private String houseBaseFid;
    private List<HouseRoomListBean> houseRoomList;
    private int maxRentRoomNum;
    private RentRoomNumBean rentRoomNum;
    private int rentWay;
    
    public LLReleaseRoomHaveDataBean() {}
    
    public String getHouseBaseFid()
    {
      return this.houseBaseFid;
    }
    
    public List<HouseRoomListBean> getHouseRoomList()
    {
      return this.houseRoomList;
    }
    
    public int getMaxRentRoomNum()
    {
      return this.maxRentRoomNum;
    }
    
    public RentRoomNumBean getRentRoomNum()
    {
      return this.rentRoomNum;
    }
    
    public int getRentWay()
    {
      return this.rentWay;
    }
    
    public void setHouseBaseFid(String paramString)
    {
      this.houseBaseFid = paramString;
    }
    
    public void setHouseRoomList(List<HouseRoomListBean> paramList)
    {
      this.houseRoomList = paramList;
    }
    
    public void setMaxRentRoomNum(int paramInt)
    {
      this.maxRentRoomNum = paramInt;
    }
    
    public void setRentRoomNum(RentRoomNumBean paramRentRoomNumBean)
    {
      this.rentRoomNum = paramRentRoomNumBean;
    }
    
    public void setRentWay(int paramInt)
    {
      this.rentWay = paramInt;
    }
    
    public class RentRoomNumBean
    {
      private boolean isEdit;
      private int value;
      
      public RentRoomNumBean() {}
      
      public int getValue()
      {
        return this.value;
      }
      
      public boolean isIsEdit()
      {
        return this.isEdit;
      }
      
      public void setIsEdit(boolean paramBoolean)
      {
        this.isEdit = paramBoolean;
      }
      
      public void setValue(int paramInt)
      {
        this.value = paramInt;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLReleaseRoomHaveBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */