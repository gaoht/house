package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class HouseDetailConfig
  implements Serializable, Comparable
{
  private String cat;
  private int count;
  private String name;
  
  public int compareTo(Object paramObject)
  {
    if ("WiFi".equals(this.name)) {
      return -1;
    }
    return 0;
  }
  
  public String getCat()
  {
    return this.cat;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setCat(String paramString)
  {
    this.cat = paramString;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/HouseDetailConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */