package com.ziroom.ziroomcustomer.newmovehouse.model;

public class MoveChargeInfo
{
  private boolean isCoupon;
  private String money;
  private String name;
  
  public MoveChargeInfo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.name = paramString1;
    this.money = paramString2;
    this.isCoupon = paramBoolean;
  }
  
  public String getMoney()
  {
    return this.money;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isCoupon()
  {
    return this.isCoupon;
  }
  
  public void setCoupon(boolean paramBoolean)
  {
    this.isCoupon = paramBoolean;
  }
  
  public void setMoney(String paramString)
  {
    this.money = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MoveChargeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */