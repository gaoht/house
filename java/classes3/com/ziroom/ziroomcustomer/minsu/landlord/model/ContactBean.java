package com.ziroom.ziroomcustomer.minsu.landlord.model;

import java.util.List;

public class ContactBean
{
  private String name;
  private List<PeopleItem> subList;
  private String subTitle;
  private String value;
  
  public String getName()
  {
    return this.name;
  }
  
  public List<PeopleItem> getSubList()
  {
    return this.subList;
  }
  
  public String getSubTitle()
  {
    return this.subTitle;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSubList(List<PeopleItem> paramList)
  {
    this.subList = paramList;
  }
  
  public void setSubTitle(String paramString)
  {
    this.subTitle = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/model/ContactBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */