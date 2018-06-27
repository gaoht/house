package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class SignedPayServiceInfoEntity
  implements Serializable
{
  private float privilege_price;
  private String privilege_type;
  
  public float getPrivilege_price()
  {
    return this.privilege_price;
  }
  
  public String getPrivilege_type()
  {
    return this.privilege_type;
  }
  
  public void setPrivilege_price(float paramFloat)
  {
    this.privilege_price = paramFloat;
  }
  
  public void setPrivilege_type(String paramString)
  {
    this.privilege_type = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedPayServiceInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */