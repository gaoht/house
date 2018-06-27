package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;

public class LLSaveHouseDescBean
  extends MinsuBaseJson
{
  private SaveHouseDescData data;
  
  public SaveHouseDescData getData()
  {
    return this.data;
  }
  
  public void setData(SaveHouseDescData paramSaveHouseDescData)
  {
    this.data = paramSaveHouseDescData;
  }
  
  public class SaveHouseDescData
  {
    private String houseBaseFid;
    private Integer rentWay;
    private String roomFid;
    
    public SaveHouseDescData() {}
    
    public String getHouseBaseFid()
    {
      return this.houseBaseFid;
    }
    
    public Integer getRentWay()
    {
      return this.rentWay;
    }
    
    public String getRoomFid()
    {
      return this.roomFid;
    }
    
    public void setHouseBaseFid(String paramString)
    {
      this.houseBaseFid = paramString;
    }
    
    public void setRentWay(Integer paramInteger)
    {
      this.rentWay = paramInteger;
    }
    
    public void setRoomFid(String paramString)
    {
      this.roomFid = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/housedesec/LLSaveHouseDescBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */