package com.ziroom.ziroomcustomer.model;

public class PayPartStateInfo
{
  private String address;
  private Integer already_count;
  private Float already_price;
  private String contract_code;
  private Float should_price;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public Integer getAlready_count()
  {
    return this.already_count;
  }
  
  public Float getAlready_price()
  {
    return this.already_price;
  }
  
  public String getContract_code()
  {
    return this.contract_code;
  }
  
  public Float getShould_price()
  {
    return this.should_price;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAlready_count(Integer paramInteger)
  {
    this.already_count = paramInteger;
  }
  
  public void setAlready_price(Float paramFloat)
  {
    this.already_price = paramFloat;
  }
  
  public void setContract_code(String paramString)
  {
    this.contract_code = paramString;
  }
  
  public void setShould_price(Float paramFloat)
  {
    this.should_price = paramFloat;
  }
  
  public String toString()
  {
    return "PayPartStateInfo [contract_code=" + this.contract_code + ", should_price=" + this.should_price + ", already_price=" + this.already_price + ", already_count=" + this.already_count + ", address=" + this.address + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/PayPartStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */