package com.ziroom.ziroomcustomer.findhouse.presenter.model;

public class FeatureDetail
{
  private String describe;
  private String icon;
  private String title;
  
  public String getDescribe()
  {
    return this.describe;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setDescribe(String paramString)
  {
    this.describe = paramString;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "FeatureDetail{title='" + this.title + '\'' + ", icon='" + this.icon + '\'' + ", describe='" + this.describe + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/FeatureDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */