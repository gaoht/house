package com.ziroom.ziroomcustomer.newchat;

import java.io.Serializable;

public class b
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  public String getDetailUrl()
  {
    return this.d;
  }
  
  public String getHouseUrl()
  {
    return this.c;
  }
  
  public String getStImage()
  {
    return this.a;
  }
  
  public String getStPrice()
  {
    return this.b;
  }
  
  public void setDetailUrl(String paramString)
  {
    this.d = paramString;
  }
  
  public void setHouseUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setStImage(String paramString)
  {
    this.a = paramString;
  }
  
  public void setStPrice(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */