package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class CleanDetail
  implements Serializable
{
  private List<CleanInfo> cleanList;
  private int days;
  private List<Integer> orderdate;
  private int rows;
  
  public List<CleanInfo> getCleanList()
  {
    return this.cleanList;
  }
  
  public int getDays()
  {
    return this.days;
  }
  
  public List<Integer> getOrderdate()
  {
    return this.orderdate;
  }
  
  public int getRows()
  {
    return this.rows;
  }
  
  public void setCleanList(List<CleanInfo> paramList)
  {
    this.cleanList = paramList;
  }
  
  public void setDays(int paramInt)
  {
    this.days = paramInt;
  }
  
  public void setOrderdate(List<Integer> paramList)
  {
    this.orderdate = paramList;
  }
  
  public void setRows(int paramInt)
  {
    this.rows = paramInt;
  }
  
  public String toString()
  {
    return "CleanDetail [orderdate=" + this.orderdate + ", rows=" + this.rows + ", days=" + this.days + ", cleanList=" + this.cleanList + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */