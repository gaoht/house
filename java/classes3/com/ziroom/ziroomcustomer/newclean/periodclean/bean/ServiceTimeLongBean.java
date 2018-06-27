package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.io.Serializable;

public class ServiceTimeLongBean
  implements Serializable
{
  private String burningTimeCode;
  private String burningTimeName;
  
  public String getBurningTimeCode()
  {
    return this.burningTimeCode;
  }
  
  public String getBurningTimeName()
  {
    return this.burningTimeName;
  }
  
  public void setBurningTimeCode(String paramString)
  {
    this.burningTimeCode = paramString;
  }
  
  public void setBurningTimeName(String paramString)
  {
    this.burningTimeName = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/ServiceTimeLongBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */