package com.ziroom.ziroomcustomer.newclean.d;

import java.io.Serializable;

public class bg
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  public String getDetAddress()
  {
    return this.c;
  }
  
  public String getFid()
  {
    return this.a;
  }
  
  public String getLinkPhone()
  {
    return this.b;
  }
  
  public String getVillage()
  {
    return this.d;
  }
  
  public void setDetAddress(String paramString)
  {
    this.c = paramString;
  }
  
  public void setFid(String paramString)
  {
    this.a = paramString;
  }
  
  public void setLinkPhone(String paramString)
  {
    this.b = paramString;
  }
  
  public void setVillage(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/d/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */