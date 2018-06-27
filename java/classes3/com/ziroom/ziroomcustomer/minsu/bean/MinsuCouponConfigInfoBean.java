package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuCouponConfigInfoBean
  extends MinsuBaseJson
{
  private DataBean data;
  
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
    private int mgStatus;
    private String mgUrl;
    private int mgVersion;
    
    public int getMgStatus()
    {
      return this.mgStatus;
    }
    
    public String getMgUrl()
    {
      return this.mgUrl;
    }
    
    public int getMgVersion()
    {
      return this.mgVersion;
    }
    
    public void setMgStatus(int paramInt)
    {
      this.mgStatus = paramInt;
    }
    
    public void setMgUrl(String paramString)
    {
      this.mgUrl = paramString;
    }
    
    public void setMgVersion(int paramInt)
    {
      this.mgVersion = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuCouponConfigInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */