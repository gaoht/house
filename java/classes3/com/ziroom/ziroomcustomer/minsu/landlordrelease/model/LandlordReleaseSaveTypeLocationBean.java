package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;

public class LandlordReleaseSaveTypeLocationBean
  extends MinsuBaseJson
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private String houseBaseFid;
    private int rentWay;
    private String roomFid;
    
    public String getHouseBaseFid()
    {
      return this.houseBaseFid;
    }
    
    public int getRentWay()
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
    
    public void setRentWay(int paramInt)
    {
      this.rentWay = paramInt;
    }
    
    public void setRoomFid(String paramString)
    {
      this.roomFid = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordReleaseSaveTypeLocationBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */