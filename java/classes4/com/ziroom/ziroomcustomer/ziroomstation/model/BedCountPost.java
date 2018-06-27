package com.ziroom.ziroomcustomer.ziroomstation.model;

public class BedCountPost
{
  private String houseTypeBid;
  private int quantity;
  
  public BedCountPost(String paramString, int paramInt)
  {
    this.houseTypeBid = paramString;
    this.quantity = paramInt;
  }
  
  public String getHouseTypeBid()
  {
    return this.houseTypeBid;
  }
  
  public int getQuantity()
  {
    return this.quantity;
  }
  
  public void setHouseTypeBid(String paramString)
  {
    this.houseTypeBid = paramString;
  }
  
  public void setQuantity(int paramInt)
  {
    this.quantity = paramInt;
  }
  
  public String toString()
  {
    return "BedCountPost{houseTypeBid='" + this.houseTypeBid + '\'' + ", quantity=" + this.quantity + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/BedCountPost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */