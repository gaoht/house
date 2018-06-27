package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.io.Serializable;

public class ZryuLeaseInfoInlet
  implements Serializable
{
  private String desc;
  private String linkType;
  private String name;
  private String value;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getLinkType()
  {
    return this.linkType;
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
  
  public void setLinkType(String paramString)
  {
    this.linkType = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuLeaseInfoInlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */