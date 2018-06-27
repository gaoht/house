package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CleanServiceId
  implements Serializable
{
  String serviceInfoId;
  
  public CleanServiceId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public String getServiceInfoId()
  {
    return this.serviceInfoId;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public String toString()
  {
    return "CleanParam serviceInfoId=" + this.serviceInfoId + "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanServiceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */