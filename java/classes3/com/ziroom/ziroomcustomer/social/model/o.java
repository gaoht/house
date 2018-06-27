package com.ziroom.ziroomcustomer.social.model;

import java.io.Serializable;

public class o
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  public String getBizcircle_name()
  {
    return this.c;
  }
  
  public String getCity_code()
  {
    return this.a;
  }
  
  public String getCity_name()
  {
    return this.b;
  }
  
  public String getHouse_address()
  {
    return this.d;
  }
  
  public void setBizcircle_name(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCity_code(String paramString)
  {
    this.a = paramString;
  }
  
  public void setCity_name(String paramString)
  {
    this.b = paramString;
  }
  
  public void setHouse_address(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */