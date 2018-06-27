package com.ziroom.ziroomcustomer.findhouse.presenter.model;

public class Goods
{
  private int coordx;
  private int coordy;
  private String id;
  private String link;
  private String title;
  
  public int getCoordx()
  {
    return this.coordx;
  }
  
  public int getCoordy()
  {
    return this.coordy;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setCoordx(int paramInt)
  {
    this.coordx = paramInt;
  }
  
  public void setCoordy(int paramInt)
  {
    this.coordy = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "Goods [id=" + this.id + ", title=" + this.title + ", link=" + this.link + ", coordx=" + this.coordx + ", coordy=" + this.coordy + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/Goods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */