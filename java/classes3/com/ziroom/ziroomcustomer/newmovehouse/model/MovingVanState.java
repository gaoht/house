package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.util.List;

public class MovingVanState
{
  private String vanState;
  private List<DataBean> vanStateList;
  
  public static class DataBean
  {
    private String createTime;
    private String logContent;
    private String operationType;
    private String orderStatus;
    
    public String getCreateTime()
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
    
    public void setCreateTime(String paramString)
    {
      this.createTime = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */