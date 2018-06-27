package com.ziroom.ziroomcustomer.home.bean;

import java.io.Serializable;

public class BannerPic
  implements Serializable
{
  private String lbt_id = "";
  private String pic = "";
  private String title = "";
  private String types = "";
  private String url = "";
  
  public String getLbt_id()
  {
    return this.lbt_id;
  }
  
  public String getPic()
  {
    return this.pic;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getTypes()
  {
    return this.types;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setLbt_id(String paramString)
  {
    this.lbt_id = paramString;
  }
  
  public void setPic(String paramString)
  {
    this.pic = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTypes(String paramString)
  {
    this.types = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/BannerPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */