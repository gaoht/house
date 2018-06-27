package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class ImageInfo
  implements Serializable
{
  String bImageUrl;
  String sImageUrl;
  String title;
  String url;
  
  public String getTitle()
  {
    return this.title;
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
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */