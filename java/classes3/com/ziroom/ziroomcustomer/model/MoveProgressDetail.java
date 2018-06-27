package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class MoveProgressDetail
  implements Serializable
{
  private String content;
  private String date;
  private String operter;
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public String getOperter()
  {
    return this.operter;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setOperter(String paramString)
  {
    this.operter = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MoveProgressDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */