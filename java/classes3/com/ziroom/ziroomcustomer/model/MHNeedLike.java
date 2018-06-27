package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class MHNeedLike
  implements Serializable
{
  private String detail;
  private int id;
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public String toString()
  {
    return this.id + "@" + this.detail;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MHNeedLike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */