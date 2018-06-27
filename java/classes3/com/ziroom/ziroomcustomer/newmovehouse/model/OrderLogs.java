package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class OrderLogs
  implements Serializable
{
  private String detail;
  private String operTime;
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public String getOperTime()
  {
    return this.operTime;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
  
  public void setOperTime(String paramString)
  {
    this.operTime = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/OrderLogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */