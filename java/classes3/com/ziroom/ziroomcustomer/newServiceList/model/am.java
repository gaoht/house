package com.ziroom.ziroomcustomer.newServiceList.model;

import java.io.Serializable;
import java.util.List;

public class am
  implements Serializable
{
  private String a;
  private Object b;
  private List<al> c;
  
  public List<al> getData()
  {
    return this.c;
  }
  
  public Object getMessage()
  {
    return this.b;
  }
  
  public String getStatus()
  {
    return this.a;
  }
  
  public void setData(List<al> paramList)
  {
    this.c = paramList;
  }
  
  public void setMessage(Object paramObject)
  {
    this.b = paramObject;
  }
  
  public void setStatus(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */