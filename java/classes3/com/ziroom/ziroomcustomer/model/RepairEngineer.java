package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class RepairEngineer
  implements Serializable
{
  private String czhth;
  private String empid;
  private String name;
  private String subid;
  
  public String getCzhth()
  {
    return this.czhth;
  }
  
  public String getEmpid()
  {
    return this.empid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSubid()
  {
    return this.subid;
  }
  
  public void setCzhth(String paramString)
  {
    this.czhth = paramString;
  }
  
  public void setEmpid(String paramString)
  {
    this.empid = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSubid(String paramString)
  {
    this.subid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RepairEngineer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */