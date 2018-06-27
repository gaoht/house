package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class SignedPayServiceDataEntity
  implements Serializable
{
  private String activity;
  private String activityCode;
  private String activity_rule;
  private SignedPayServiceInfoEntity commission;
  private SignedPayServiceInfoEntity deposit;
  private String is_default_check = "0";
  private SignedPayServiceInfoEntity price;
  
  public String getActivity()
  {
    return this.activity;
  }
  
  public String getActivityCode()
  {
    return this.activityCode;
  }
  
  public String getActivity_rule()
  {
    return this.activity_rule;
  }
  
  public SignedPayServiceInfoEntity getCommission()
  {
    return this.commission;
  }
  
  public SignedPayServiceInfoEntity getDeposit()
  {
    return this.deposit;
  }
  
  public String getIs_default_check()
  {
    return this.is_default_check;
  }
  
  public SignedPayServiceInfoEntity getPrice()
  {
    return this.price;
  }
  
  public void setActivity(String paramString)
  {
    this.activity = paramString;
  }
  
  public void setActivityCode(String paramString)
  {
    this.activityCode = paramString;
  }
  
  public void setActivity_rule(String paramString)
  {
    this.activity_rule = paramString;
  }
  
  public void setCommission(SignedPayServiceInfoEntity paramSignedPayServiceInfoEntity)
  {
    this.commission = paramSignedPayServiceInfoEntity;
  }
  
  public void setDeposit(SignedPayServiceInfoEntity paramSignedPayServiceInfoEntity)
  {
    this.deposit = paramSignedPayServiceInfoEntity;
  }
  
  public void setIs_default_check(String paramString)
  {
    this.is_default_check = paramString;
  }
  
  public void setPrice(SignedPayServiceInfoEntity paramSignedPayServiceInfoEntity)
  {
    this.price = paramSignedPayServiceInfoEntity;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedPayServiceDataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */