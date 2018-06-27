package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

public class SaveHouseRoomBedListBean
{
  private int bedCount;
  private String bedType;
  
  public int getBedCount()
  {
    return this.bedCount;
  }
  
  public String getBedType()
  {
    return this.bedType;
  }
  
  public void setBedCount(int paramInt)
  {
    this.bedCount = paramInt;
  }
  
  public void setBedType(String paramString)
  {
    this.bedType = paramString;
  }
  
  public String toString()
  {
    return this.bedType + "_" + this.bedCount;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/SaveHouseRoomBedListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */