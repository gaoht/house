package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class BankList
  extends b
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataBean
  {
    private String appUrl;
    private int bankCode;
    private String bankName;
    private String pcUrl;
    
    public String getAppUrl()
    {
      return this.appUrl;
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
    
    public void setAppUrl(String paramString)
    {
      this.appUrl = paramString;
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
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/BankList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */