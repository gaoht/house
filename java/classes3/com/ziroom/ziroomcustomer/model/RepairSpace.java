package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class RepairSpace
{
  private String code;
  private String czhth;
  private String name;
  private List<RepairSubject> subjectList;
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getCzhth()
  {
    return this.czhth;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<RepairSubject> getSubjectList()
  {
    return this.subjectList;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCzhth(String paramString)
  {
    this.czhth = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSubjectList(List<RepairSubject> paramList)
  {
    this.subjectList = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RepairSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */