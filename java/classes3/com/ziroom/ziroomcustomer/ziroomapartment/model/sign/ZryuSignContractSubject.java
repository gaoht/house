package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

public class ZryuSignContractSubject
{
  private String contractId;
  private String handleZOPhone;
  private Integer isExpire;
  private ZryuSignProject projectInfo;
  private ZryuSignPerson signPerson;
  
  public String getContractId()
  {
    return this.contractId;
  }
  
  public String getHandleZOPhone()
  {
    return this.handleZOPhone;
  }
  
  public Integer getIsExpire()
  {
    return this.isExpire;
  }
  
  public ZryuSignProject getProjectInfo()
  {
    return this.projectInfo;
  }
  
  public ZryuSignPerson getSignPerson()
  {
    return this.signPerson;
  }
  
  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }
  
  public void setHandleZOPhone(String paramString)
  {
    this.handleZOPhone = paramString;
  }
  
  public void setIsExpire(Integer paramInteger)
  {
    this.isExpire = paramInteger;
  }
  
  public void setProjectInfo(ZryuSignProject paramZryuSignProject)
  {
    this.projectInfo = paramZryuSignProject;
  }
  
  public void setSignPerson(ZryuSignPerson paramZryuSignPerson)
  {
    this.signPerson = paramZryuSignPerson;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignContractSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */