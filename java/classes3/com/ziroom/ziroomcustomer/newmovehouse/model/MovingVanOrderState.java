package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.util.List;

public class MovingVanOrderState
{
  private int actualAllAmount;
  private String employeeOrderCode;
  private List<UserOrderLogVOsBean> userOrderLogVOs;
  
  public int getActualAllAmount()
  {
    return this.actualAllAmount;
  }
  
  public String getEmployeeOrderCode()
  {
    return this.employeeOrderCode;
  }
  
  public List<UserOrderLogVOsBean> getUserOrderLogVOs()
  {
    return this.userOrderLogVOs;
  }
  
  public void setActualAllAmount(int paramInt)
  {
    this.actualAllAmount = paramInt;
  }
  
  public void setEmployeeOrderCode(String paramString)
  {
    this.employeeOrderCode = paramString;
  }
  
  public void setUserOrderLogVOs(List<UserOrderLogVOsBean> paramList)
  {
    this.userOrderLogVOs = paramList;
  }
  
  public static class UserOrderLogVOsBean
  {
    private long createTime;
    private String logContent;
    private String operationType;
    private String orderStatus;
    
    public long getCreateTime()
    {
      return this.createTime;
    }
    
    public String getLogContent()
    {
      return this.logContent;
    }
    
    public String getOperationType()
    {
      return this.operationType;
    }
    
    public String getOrderStatus()
    {
      return this.orderStatus;
    }
    
    public void setCreateTime(long paramLong)
    {
      this.createTime = paramLong;
    }
    
    public void setLogContent(String paramString)
    {
      this.logContent = paramString;
    }
    
    public void setOperationType(String paramString)
    {
      this.operationType = paramString;
    }
    
    public void setOrderStatus(String paramString)
    {
      this.orderStatus = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanOrderState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */