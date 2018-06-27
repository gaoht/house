package com.ziroom.ziroomcustomer.model;

public class CleanPriceUnit
{
  private int code;
  private double price;
  private String priceRemark;
  private String serivicePmName;
  private String servicePmId;
  
  public CleanPriceUnit() {}
  
  public CleanPriceUnit(int paramInt, double paramDouble, String paramString1, String paramString2, String paramString3)
  {
    this.code = paramInt;
    this.price = paramDouble;
    this.priceRemark = paramString1;
    this.serivicePmName = paramString2;
    this.servicePmId = paramString3;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public double getPrice()
  {
    return this.price;
  }
  
  public String getPriceRemark()
  {
    return this.priceRemark;
  }
  
  public String getSerivicePmName()
  {
    return this.serivicePmName;
  }
  
  public String getServicePmId()
  {
    return this.servicePmId;
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
  }
  
  public void setPrice(double paramDouble)
  {
    this.price = paramDouble;
  }
  
  public void setPriceRemark(String paramString)
  {
    this.priceRemark = paramString;
  }
  
  public void setSerivicePmName(String paramString)
  {
    this.serivicePmName = paramString;
  }
  
  public void setServicePmId(String paramString)
  {
    this.servicePmId = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanPriceUnit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */