package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;

public class MinsuHouseDetailConfigBean
  implements Serializable
{
  private int count;
  private String icPath;
  private String name;
  private int type;
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getIcPath()
  {
    return this.icPath;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setIcPath(String paramString)
  {
    this.icPath = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHouseDetailConfigBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */