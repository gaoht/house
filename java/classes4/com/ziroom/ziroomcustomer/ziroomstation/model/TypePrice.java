package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.io.Serializable;

public class TypePrice
  implements Serializable
{
  public int availableCount;
  public String houseTypeBid;
  public int isPreferential;
  public double maxPrice;
  public double minPrice;
  public int num;
  public String roomName;
  public String typeName;
  public double typePrice;
  
  public String toString()
  {
    return "TypePrice{typeName='" + this.typeName + '\'' + ", typePrice=" + this.typePrice + ", num=" + this.num + ", isPreferential=" + this.isPreferential + ", availableCount=" + this.availableCount + ", maxPrice=" + this.maxPrice + ", minPrice=" + this.minPrice + ", houseTypeBid='" + this.houseTypeBid + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/TypePrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */