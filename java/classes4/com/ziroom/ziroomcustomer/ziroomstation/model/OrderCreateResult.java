package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.util.List;

public class OrderCreateResult
  extends a
{
  private DataEntity data;
  
  public DataEntity getData()
  {
    return this.data;
  }
  
  public void setData(DataEntity paramDataEntity)
  {
    this.data = paramDataEntity;
  }
  
  public static class DataEntity
  {
    private String orderBid;
    private String payOrderNumber;
    private List<String> payWays;
    
    public String getOrderBid()
    {
      return this.orderBid;
    }
    
    public String getPayOrderNumber()
    {
      return this.payOrderNumber;
    }
    
    public List<String> getPayWays()
    {
      return this.payWays;
    }
    
    public void setOrderBid(String paramString)
    {
      this.orderBid = paramString;
    }
    
    public void setPayOrderNumber(String paramString)
    {
      this.payOrderNumber = paramString;
    }
    
    public void setPayWays(List<String> paramList)
    {
      this.payWays = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/OrderCreateResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */