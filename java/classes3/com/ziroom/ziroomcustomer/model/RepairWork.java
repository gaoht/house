package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class RepairWork
  implements Serializable
{
  private boolean done;
  private String lockSupEmpId;
  private String lockSupplierId;
  private String orderTime = "";
  private String orderTimeInterval;
  private int orderTimePeriod;
  private int query_object_index;
  private int query_reason_index;
  private String supEmpId;
  private String supplierId;
  private List<RepairWorkItem> wxxmList;
  
  public String getLockSupEmpId()
  {
    return this.lockSupEmpId;
  }
  
  public String getLockSupplierId()
  {
    return this.lockSupplierId;
  }
  
  public String getOrderTime()
  {
    return this.orderTime;
  }
  
  public String getOrderTimeInterval()
  {
    return this.orderTimeInterval;
  }
  
  public int getOrderTimePeriod()
  {
    return this.orderTimePeriod;
  }
  
  public int getQuery_object_index()
  {
    return this.query_object_index;
  }
  
  public int getQuery_reason_index()
  {
    return this.query_reason_index;
  }
  
  public String getSupEmpId()
  {
    return this.supEmpId;
  }
  
  public String getSupplierId()
  {
    return this.supplierId;
  }
  
  public List<RepairWorkItem> getWxxmList()
  {
    return this.wxxmList;
  }
  
  public boolean isDone()
  {
    return this.done;
  }
  
  public void setDone(boolean paramBoolean)
  {
    this.done = paramBoolean;
  }
  
  public void setLockSupEmpId(String paramString)
  {
    this.lockSupEmpId = paramString;
  }
  
  public void setLockSupplierId(String paramString)
  {
    this.lockSupplierId = paramString;
  }
  
  public void setOrderTime(String paramString)
  {
    this.orderTime = paramString;
  }
  
  public void setOrderTimeInterval(String paramString)
  {
    this.orderTimeInterval = paramString;
  }
  
  public void setOrderTimePeriod(int paramInt)
  {
    this.orderTimePeriod = paramInt;
  }
  
  public void setQuery_object_index(int paramInt)
  {
    this.query_object_index = paramInt;
  }
  
  public void setQuery_reason_index(int paramInt)
  {
    this.query_reason_index = paramInt;
  }
  
  public void setSupEmpId(String paramString)
  {
    this.supEmpId = paramString;
  }
  
  public void setSupplierId(String paramString)
  {
    this.supplierId = paramString;
  }
  
  public void setWxxmList(List<RepairWorkItem> paramList)
  {
    this.wxxmList = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RepairWork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */