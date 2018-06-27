package com.ziroom.ziroomcustomer.findhouse.presenter.model;

public class HouseConfig
{
  private String category;
  private String icon;
  private int num;
  private String title;
  private String value;
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    return "HouseConfig{title='" + this.title + '\'' + ", value='" + this.value + '\'' + ", icon='" + this.icon + '\'' + ", category='" + this.category + '\'' + ", num=" + this.num + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/HouseConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */