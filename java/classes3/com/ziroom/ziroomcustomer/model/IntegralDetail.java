package com.ziroom.ziroomcustomer.model;

public class IntegralDetail
{
  private int available_integral;
  private String creation_date;
  private String expiration_date;
  private int integral_cost;
  private int integral_detail_id;
  private int integral_num;
  private String is_expired;
  private String source_description;
  private String source_type;
  
  public int getAvailable_integral()
  {
    return this.available_integral;
  }
  
  public String getCreation_date()
  {
    return this.creation_date;
  }
  
  public String getExpiration_date()
  {
    return this.expiration_date;
  }
  
  public int getIntegral_cost()
  {
    return this.integral_cost;
  }
  
  public int getIntegral_detail_id()
  {
    return this.integral_detail_id;
  }
  
  public int getIntegral_num()
  {
    return this.integral_num;
  }
  
  public String getIs_expired()
  {
    return this.is_expired;
  }
  
  public String getSource_description()
  {
    return this.source_description;
  }
  
  public String getSource_type()
  {
    return this.source_type;
  }
  
  public void setAvailable_integral(int paramInt)
  {
    this.available_integral = paramInt;
  }
  
  public void setCreation_date(String paramString)
  {
    this.creation_date = paramString;
  }
  
  public void setExpiration_date(String paramString)
  {
    this.expiration_date = paramString;
  }
  
  public void setIntegral_cost(int paramInt)
  {
    this.integral_cost = paramInt;
  }
  
  public void setIntegral_detail_id(int paramInt)
  {
    this.integral_detail_id = paramInt;
  }
  
  public void setIntegral_num(int paramInt)
  {
    this.integral_num = paramInt;
  }
  
  public void setIs_expired(String paramString)
  {
    this.is_expired = paramString;
  }
  
  public void setSource_description(String paramString)
  {
    this.source_description = paramString;
  }
  
  public void setSource_type(String paramString)
  {
    this.source_type = paramString;
  }
  
  public String toString()
  {
    return "IntegralDetail [integral_detail_id=" + this.integral_detail_id + ", integral_num=" + this.integral_num + ", integral_cost=" + this.integral_cost + ", available_integral=" + this.available_integral + ", expiration_date=" + this.expiration_date + ", source_type=" + this.source_type + ", source_description=" + this.source_description + ", is_expired=" + this.is_expired + ", creation_date=" + this.creation_date + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/IntegralDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */