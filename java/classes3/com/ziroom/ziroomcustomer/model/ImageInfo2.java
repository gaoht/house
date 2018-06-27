package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class ImageInfo2
  implements Serializable
{
  String imageid;
  String status;
  String url;
  
  public String getImageid()
  {
    return this.imageid;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setImageid(String paramString)
  {
    this.imageid = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return "ImageInfo2 [imageid=" + this.imageid + ", url=" + this.url + ", status=" + this.status + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ImageInfo2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */