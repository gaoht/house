package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.List;

public class OwnerContractDetailModel
  implements Serializable
{
  private String contractItem;
  private List<Object> contractSpecial;
  public String hireCommissionerPhone;
  
  public String getContractItem()
  {
    return this.contractItem;
  }
  
  public List<Object> getContractSpecial()
  {
    return this.contractSpecial;
  }
  
  public void setContractItem(String paramString)
  {
    this.contractItem = paramString;
  }
  
  public void setContractSpecial(List<Object> paramList)
  {
    this.contractSpecial = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerContractDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */