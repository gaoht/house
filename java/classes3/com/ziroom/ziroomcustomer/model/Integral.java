package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class Integral
{
  private int available_total_integral;
  private List<IntegralDetail> integral_detail;
  private int total_num;
  
  public int getAvailable_total_integral()
  {
    return this.available_total_integral;
  }
  
  public List<IntegralDetail> getIntegral_detail()
  {
    return this.integral_detail;
  }
  
  public int getTotal_num()
  {
    return this.total_num;
  }
  
  public void setAvailable_total_integral(int paramInt)
  {
    this.available_total_integral = paramInt;
  }
  
  public void setIntegral_detail(List<IntegralDetail> paramList)
  {
    this.integral_detail = paramList;
  }
  
  public void setTotal_num(int paramInt)
  {
    this.total_num = paramInt;
  }
  
  public String toString()
  {
    return "Integral [available_total_integral=" + this.available_total_integral + ", total_num=" + this.total_num + ", integral_detail=" + this.integral_detail + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Integral.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */