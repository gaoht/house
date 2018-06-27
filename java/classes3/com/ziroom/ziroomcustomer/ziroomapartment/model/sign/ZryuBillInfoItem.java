package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.io.Serializable;

public class ZryuBillInfoItem
  implements Serializable
{
  private String color;
  private String name;
  private String value;
  
  public String getColor()
  {
    return this.color;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setColor(String paramString)
  {
    this.color = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuBillInfoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */