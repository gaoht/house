package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;

public class BindedCard
  extends b
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
    private String appUrl;
    private String bankArea;
    private String bankCardNo;
    private int bankCode;
    private String bankName;
    private String pcUrl;
    private String uid;
    
    public String getAppUrl()
    {
      return this.appUrl;
    }
    
    public String getBankArea()
    {
      return this.bankArea;
    }
    
    public String getBankCardNo()
    {
      return this.bankCardNo;
    }
    
    public int getBankCode()
    {
      return this.bankCode;
    }
    
    public String getBankName()
    {
      return this.bankName;
    }
    
    public String getPcUrl()
    {
      return this.pcUrl;
    }
    
    public String getUid()
    {
      return this.uid;
    }
    
    public void setAppUrl(String paramString)
    {
      this.appUrl = paramString;
    }
    
    public void setBankArea(String paramString)
    {
      this.bankArea = paramString;
    }
    
    public void setBankCardNo(String paramString)
    {
      this.bankCardNo = paramString;
    }
    
    public void setBankCode(int paramInt)
    {
      this.bankCode = paramInt;
    }
    
    public void setBankName(String paramString)
    {
      this.bankName = paramString;
    }
    
    public void setPcUrl(String paramString)
    {
      this.pcUrl = paramString;
    }
    
    public void setUid(String paramString)
    {
      this.uid = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/BindedCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */