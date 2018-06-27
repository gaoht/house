package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.util.List;

public class ZryuSignChoosePayMethod
{
  private String contractId;
  private List<ZryuSignPayMethod> payList;
  private ZryuSignProject projectInfo;
  
  public String getContractId()
  {
    return this.contractId;
  }
  
  public List<ZryuSignPayMethod> getPayList()
  {
    return this.payList;
  }
  
  public ZryuSignProject getProjectInfo()
  {
    return this.projectInfo;
  }
  
  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }
  
  public void setPayList(List<ZryuSignPayMethod> paramList)
  {
    this.payList = paramList;
  }
  
  public void setProjectInfo(ZryuSignProject paramZryuSignProject)
  {
    this.projectInfo = paramZryuSignProject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignChoosePayMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */