package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

public class SaveAloneRoomInitInfoBean
{
  private SaveAloneRoomData data;
  private String message;
  private int status;
  
  public SaveAloneRoomData getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setData(SaveAloneRoomData paramSaveAloneRoomData)
  {
    this.data = paramSaveAloneRoomData;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public class SaveAloneRoomData
  {
    private String houseBaseFid;
    private Integer rentWay;
    private String roomFid;
    
    public SaveAloneRoomData() {}
    
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/SaveAloneRoomInitInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */