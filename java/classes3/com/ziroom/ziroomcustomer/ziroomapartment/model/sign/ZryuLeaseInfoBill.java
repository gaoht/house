package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.io.Serializable;

public class ZryuLeaseInfoBill
  implements Serializable
{
  private String desc;
  private String name;
  private String value;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuLeaseInfoBill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */