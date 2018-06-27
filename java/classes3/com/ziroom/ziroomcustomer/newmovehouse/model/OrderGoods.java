package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class OrderGoods
  implements Serializable
{
  private int buyNum;
  private String goodsName;
  private double totalPrice;
  private double unitPrice;
  
  public int getBuyNum()
  {
    return this.buyNum;
  }
  
  public String getGoodsName()
  {
    return this.goodsName;
  }
  
  public double getTotalPrice()
  {
    return this.totalPrice;
  }
  
  public double getUnitPrice()
  {
    return this.unitPrice;
  }
  
  public void setBuyNum(int paramInt)
  {
    this.buyNum = paramInt;
  }
  
  public void setGoodsName(String paramString)
  {
    this.goodsName = paramString;
  }
  
  public void setTotalPrice(double paramDouble)
  {
    this.totalPrice = paramDouble;
  }
  
  public void setUnitPrice(double paramDouble)
  {
    this.unitPrice = paramDouble;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/OrderGoods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */