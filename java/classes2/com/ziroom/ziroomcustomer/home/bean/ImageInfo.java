package com.ziroom.ziroomcustomer.home.bean;

import java.io.Serializable;

public class ImageInfo
  implements Serializable
{
  String bImageUrl;
  String lbt_id = "";
  String sImageUrl;
  String title;
  String type;
  String url;
  
  public String getLbt_id()
  {
    return this.lbt_id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getbImageUrl()
  {
    return this.bImageUrl;
  }
  
  public String getsImageUrl()
  {
    return this.sImageUrl;
  }
  
  public void setLbt_id(String paramString)
  {
    this.lbt_id = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setbImageUrl(String paramString)
  {
    this.bImageUrl = paramString;
  }
  
  public void setsImageUrl(String paramString)
  {
    this.sImageUrl = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */