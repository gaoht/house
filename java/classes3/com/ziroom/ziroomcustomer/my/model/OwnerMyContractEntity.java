package com.ziroom.ziroomcustomer.my.model;

import java.io.Serializable;
import java.util.List;

public class OwnerMyContractEntity
  implements Serializable
{
  private List<OwnerMySignedEntity> contracts_signed;
  private List<OwnerMyUnSignedEntity> contracts_unsigned;
  
  public List<OwnerMySignedEntity> getContracts_signed()
  {
    return this.contracts_signed;
  }
  
  public List<OwnerMyUnSignedEntity> getContracts_unsigned()
  {
    return this.contracts_unsigned;
  }
  
  public void setContracts_signed(List<OwnerMySignedEntity> paramList)
  {
    this.contracts_signed = paramList;
  }
  
  public void setContracts_unsigned(List<OwnerMyUnSignedEntity> paramList)
  {
    this.contracts_unsigned = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OwnerMyContractEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */