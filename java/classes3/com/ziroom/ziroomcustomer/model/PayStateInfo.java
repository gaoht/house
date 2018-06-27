package com.ziroom.ziroomcustomer.model;

public class PayStateInfo
{
  private Float already_price;
  private String contract_code;
  private Integer is_pay;
  private Float should_price;
  
  public Float getAlready_price()
  {
    return this.already_price;
  }
  
  public String getContract_code()
  {
    return this.contract_code;
  }
  
  public Integer getIs_pay()
  {
    return this.is_pay;
  }
  
  public Float getShould_price()
  {
    return this.should_price;
  }
  
  public void setAlready_price(Float paramFloat)
  {
    this.already_price = paramFloat;
  }
  
  public void setContract_code(String paramString)
  {
    this.contract_code = paramString;
  }
  
  public void setIs_pay(Integer paramInteger)
  {
    this.is_pay = paramInteger;
  }
  
  public void setShould_price(Float paramFloat)
  {
    this.should_price = paramFloat;
  }
  
  public String toString()
  {
    return "PayStateInfo [contract_code=" + this.contract_code + ", is_pay=" + this.is_pay + ", should_price=" + this.should_price + ", already_price=" + this.already_price + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/PayStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */