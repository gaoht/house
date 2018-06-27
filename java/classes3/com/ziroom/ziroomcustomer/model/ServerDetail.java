package com.ziroom.ziroomcustomer.model;

public class ServerDetail
{
  private int guide_id;
  private String title;
  private String url;
  
  public int getGuide_id()
  {
    return this.guide_id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setGuide_id(int paramInt)
  {
    this.guide_id = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return "ServerDetail [guide_id=" + this.guide_id + ", title=" + this.title + ", url=" + this.url + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ServerDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */