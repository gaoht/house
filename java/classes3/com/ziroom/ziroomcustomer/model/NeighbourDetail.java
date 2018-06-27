package com.ziroom.ziroomcustomer.model;

public class NeighbourDetail
{
  private String channel_id;
  private int gender;
  private String head_img;
  private String house_code;
  private String job;
  private String room_name;
  private String uid;
  private String user_name;
  
  public String getChannel_id()
  {
    return this.channel_id;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public String getHead_img()
  {
    return this.head_img;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getJob()
  {
    return this.job;
  }
  
  public String getRoom_name()
  {
    return this.room_name;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getUser_name()
  {
    return this.user_name;
  }
  
  public void setChannel_id(String paramString)
  {
    this.channel_id = paramString;
  }
  
  public void setGender(int paramInt)
  {
    this.gender = paramInt;
  }
  
  public void setHead_img(String paramString)
  {
    this.head_img = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setJob(String paramString)
  {
    this.job = paramString;
  }
  
  public void setRoom_name(String paramString)
  {
    this.room_name = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setUser_name(String paramString)
  {
    this.user_name = paramString;
  }
  
  public String toString()
  {
    return "NeighbourDetail [house_code=" + this.house_code + ", uid=" + this.uid + ", room_name=" + this.room_name + ", user_name=" + this.user_name + ", gender=" + this.gender + ", job=" + this.job + ", head_img=" + this.head_img + ", channel_id=" + this.channel_id + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/NeighbourDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */