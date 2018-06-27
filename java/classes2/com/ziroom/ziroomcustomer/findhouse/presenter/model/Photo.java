package com.ziroom.ziroomcustomer.findhouse.presenter.model;

public class Photo
{
  private float height;
  private String url;
  private float width;
  
  public float getHeight()
  {
    return this.height;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public void setHeight(float paramFloat)
  {
    this.height = paramFloat;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(float paramFloat)
  {
    this.width = paramFloat;
  }
  
  public String toString()
  {
    return "Photo [width=" + this.width + ", height=" + this.height + ", url=" + this.url + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/Photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */