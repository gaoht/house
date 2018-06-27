package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuWhetherOpenCouponBean
{
  private DataBean data;
  private String message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private int whetherOpen;
    
    public int getWhetherOpen()
    {
      return this.whetherOpen;
    }
    
    public void setWhetherOpen(int paramInt)
    {
      this.whetherOpen = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuWhetherOpenCouponBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */