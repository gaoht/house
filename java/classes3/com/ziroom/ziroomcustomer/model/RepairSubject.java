package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class RepairSubject
{
  private String code;
  private String czhth;
  private List<RepairItem> itemList;
  private String name;
  private String space_code;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getCzhth()
  {
    return this.czhth;
  }
  
  public List<RepairItem> getItemList()
  {
    return this.itemList;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSpace_code()
  {
    return this.space_code;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCzhth(String paramString)
  {
    this.czhth = paramString;
  }
  
  public void setItemList(List<RepairItem> paramList)
  {
    this.itemList = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSpace_code(String paramString)
  {
    this.space_code = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RepairSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */