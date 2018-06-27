package com.ziroom.ziroomcustomer.model;

public class Advertisement
{
  private String pic;
  private String rgb;
  private String subtitle;
  private String title;
  private String types;
  private String url;
  
  public String getPic()
  {
    return this.pic;
  }
  
  public String getRgb()
  {
    return this.rgb;
  }
  
  public String getSubtitle()
  {
    return this.subtitle;
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
  
  public void setPic(String paramString)
  {
    this.pic = paramString;
  }
  
  public void setRgb(String paramString)
  {
    this.rgb = paramString;
  }
  
  public void setSubtitle(String paramString)
  {
    this.subtitle = paramString;
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
  
  public String toString()
  {
    return "Advertisement{title='" + this.title + '\'' + ", subtitle='" + this.subtitle + '\'' + ", pic='" + this.pic + '\'' + ", types=" + this.types + ", rgb=" + this.rgb + ", url='" + this.url + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Advertisement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */