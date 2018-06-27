package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class MoveGood
  implements Serializable
{
  private String detail;
  private String large;
  private String name;
  private int num;
  private String price;
  private String size;
  private String small;
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public String getLarge()
  {
    return this.large;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getSmall()
  {
    return this.small;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
  
  public void setLarge(String paramString)
  {
    this.large = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setSmall(String paramString)
  {
    this.small = paramString;
  }
  
  public String toString()
  {
    return "MoveGood [num=" + this.num + ", name=" + this.name + ", price=" + this.price + ", size=" + this.size + ", large=" + this.large + ", small=" + this.small + ", detail=" + this.detail + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MoveGood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */