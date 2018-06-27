package com.ziroom.ziroomcustomer.newclean.periodclean.bean;

import java.io.Serializable;

public class OrderListStatus
  implements Serializable
{
  private int allAmount;
  private String appointmentTime;
  private String appointmentTimeName;
  private String employeeCode;
  private String employeeName;
  private String orderCode;
  private int orderStatus;
  private String orderStatusName;
  
  public int getAllAmount()
  {
    return this.allAmount;
  }
  
  public String getAppointmentTime()
  {
    return this.appointmentTime;
  }
  
  public String getAppointmentTimeName()
  {
    return this.appointmentTimeName;
  }
  
  public String getEmployeeCode()
  {
    return this.employeeCode;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public String getOrderCode()
  {
    return this.orderCode;
  }
  
  public int getOrderStatus()
  {
    return this.orderStatus;
  }
  
  public String getOrderStatusName()
  {
    return this.orderStatusName;
  }
  
  public void setAllAmount(int paramInt)
  {
    this.allAmount = paramInt;
  }
  
  public void setAppointmentTime(String paramString)
  {
    this.appointmentTime = paramString;
  }
  
  public void setAppointmentTimeName(String paramString)
  {
    this.appointmentTimeName = paramString;
  }
  
  public void setEmployeeCode(String paramString)
  {
    this.employeeCode = paramString;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public void setOrderCode(String paramString)
  {
    this.orderCode = paramString;
  }
  
  public void setOrderStatus(int paramInt)
  {
    this.orderStatus = paramInt;
  }
  
  public void setOrderStatusName(String paramString)
  {
    this.orderStatusName = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/bean/OrderListStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */