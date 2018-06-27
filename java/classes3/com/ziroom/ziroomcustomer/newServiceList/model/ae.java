package com.ziroom.ziroomcustomer.newServiceList.model;

import java.io.Serializable;
import java.util.List;

public class ae
  implements Serializable
{
  private String a;
  private List<Object> b;
  
  public List<Object> getData()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.a;
  }
  
  public void setData(List<Object> paramList)
  {
    this.b = paramList;
  }
  
  public void setStatus(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */