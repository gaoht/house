package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.io.Serializable;

public class SaveHouseRoomListBean
  implements Serializable
{
  private String bedMsg;
  private String fid;
  
  public String getBedMsg()
  {
    return this.bedMsg;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public void setBedMsg(String paramString)
  {
    this.bedMsg = paramString;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/SaveHouseRoomListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */