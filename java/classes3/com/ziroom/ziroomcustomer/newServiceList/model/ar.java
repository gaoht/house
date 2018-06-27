package com.ziroom.ziroomcustomer.newServiceList.model;

import java.io.Serializable;
import java.util.List;

public class ar
  implements Serializable
{
  private String a;
  private String b;
  private List<ao> c;
  
  public List<ao> getData()
  {
    return this.c;
  }
  
  public String getMessage()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.a;
  }
  
  public void setData(List<ao> paramList)
  {
    this.c = paramList;
  }
  
  public void setMessage(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */