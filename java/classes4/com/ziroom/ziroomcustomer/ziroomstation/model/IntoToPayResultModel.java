package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class IntoToPayResultModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    public String orderBid;
    public String payOrderNumber;
    public List<String> payWays;
    
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


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/IntoToPayResultModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */