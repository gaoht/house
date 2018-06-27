package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class Demand
  implements Serializable
{
  private String id;
  private String name;
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Demand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */