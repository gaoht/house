package com.ziroom.ziroomcustomer.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDate
{
  private String orderTime;
  private int orderTimePeriod;
  private List<String> valueAddedList = new ArrayList();
  private String workBillId;
  
  public String getOrderTime()
  {
    return this.orderTime;
  }
  
  public int getOrderTimePeriod()
  {
    return this.orderTimePeriod;
  }
  
  public List getValueAddedList()
  {
    return this.valueAddedList;
  }
  
  public String getWorkBillId()
  {
    return this.workBillId;
  }
  
  public void putItem(String paramString)
  {
    if (this.valueAddedList.size() == 0) {
      this.valueAddedList.add(paramString);
    }
    Iterator localIterator = this.valueAddedList.iterator();
    while (localIterator.hasNext()) {
      if (!((String)localIterator.next()).equals(paramString)) {
        this.valueAddedList.add(paramString);
      }
    }
  }
  
  public void setOrderTime(String paramString)
  {
    this.orderTime = paramString;
  }
  
  public void setOrderTimePeriod(int paramInt)
  {
    this.orderTimePeriod = paramInt;
  }
  
  public void setValueAddedList(List paramList)
  {
    this.valueAddedList = paramList;
  }
  
  public void setWorkBillId(String paramString)
  {
    this.workBillId = paramString;
  }
  
  public String toString()
  {
    return "OrderDate [orderTime=" + this.orderTime + ", orderTimePeriod=" + this.orderTimePeriod + ", valueAddedList=" + this.valueAddedList + ", workBillId=" + this.workBillId + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/OrderDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */