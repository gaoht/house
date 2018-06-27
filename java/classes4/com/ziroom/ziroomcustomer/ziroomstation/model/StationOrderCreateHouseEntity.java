package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.io.Serializable;

public class StationOrderCreateHouseEntity
  implements Serializable
{
  private String houseTypeId;
  private int maxSize;
  private String name;
  private int price;
  private int size;
  private int usedSize;
  
  public StationOrderCreateHouseEntity() {}
  
  public StationOrderCreateHouseEntity(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.maxSize = paramInt1;
    this.size = paramInt2;
    this.name = paramString1;
    this.price = paramInt3;
    this.usedSize = 0;
    this.houseTypeId = paramString2;
  }
  
  public String getHouseTypeId()
  {
    return this.houseTypeId;
  }
  
  public int getMaxSize()
  {
    return this.maxSize;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getUsedSize()
  {
    return this.usedSize;
  }
  
  public void setHouseTypeId(String paramString)
  {
    this.houseTypeId = paramString;
  }
  
  public void setMaxSize(int paramInt)
  {
    this.maxSize = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public void setUsedSize(int paramInt)
  {
    this.usedSize = paramInt;
  }
  
  public String toString()
  {
    return "StationOrderCreateHouseEntity{maxSize=" + this.maxSize + ", size=" + this.size + ", name='" + this.name + '\'' + ", usedSize=" + this.usedSize + ", price=" + this.price + ", houseTypeId='" + this.houseTypeId + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationOrderCreateHouseEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */