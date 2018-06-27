package com.ziroom.ziroomcustomer.newServiceList.model;

import java.io.Serializable;

public class q
  implements Serializable
{
  String a;
  String b;
  
  public String getGoodsOrderCode()
  {
    return this.a;
  }
  
  public String getOrderPrice()
  {
    return this.b;
  }
  
  public void setGoodsOrderCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setOrderPrice(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */