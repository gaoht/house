package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

public class SaveLLReleaseRoomBasicBean
{
  private DataBean data;
  private String message;
  private int status;
  
  public DataBean getData()
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
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public static class DataBean
  {
    private String roomFid;
    private int roomType;
    
    public String getRoomFid()
    {
      return this.roomFid;
    }
    
    public int getRoomType()
    {
      return this.roomType;
    }
    
    public void setRoomFid(String paramString)
    {
      this.roomFid = paramString;
    }
    
    public void setRoomType(int paramInt)
    {
      this.roomType = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/SaveLLReleaseRoomBasicBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */