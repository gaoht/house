package com.ziroom.ziroomcustomer.minsu.landlord.model;

import java.util.List;

public class RemarkBean
{
  private String desc;
  private String name;
  private List<RemarkItem> remarkList;
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<RemarkItem> getRemarkList()
  {
    return this.remarkList;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRemarkList(List<RemarkItem> paramList)
  {
    this.remarkList = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/model/RemarkBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */