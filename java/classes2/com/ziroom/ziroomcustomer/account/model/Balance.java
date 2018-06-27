package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class Balance
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
    private String balance;
    private List<ChildrenAccountsBean> childrenAccounts;
    private String frozenBalance;
    
    public String getBalance()
    {
      return this.balance;
    }
    
    public List<ChildrenAccountsBean> getChildrenAccounts()
    {
      return this.childrenAccounts;
    }
    
    public String getFrozenBalance()
    {
      return this.frozenBalance;
    }
    
    public void setBalance(String paramString)
    {
      this.balance = paramString;
    }
    
    public void setChildrenAccounts(List<ChildrenAccountsBean> paramList)
    {
      this.childrenAccounts = paramList;
    }
    
    public void setFrozenBalance(String paramString)
    {
      this.frozenBalance = paramString;
    }
    
    public static class ChildrenAccountsBean
    {
      private String accountName;
      private String balance;
      private String cityCode;
      private String frozenBalance;
      
      public String getAccountName()
      {
        return this.accountName;
      }
      
      public String getBalance()
      {
        return this.balance;
      }
      
      public String getCityCode()
      {
        return this.cityCode;
      }
      
      public String getFrozenBalance()
      {
        return this.frozenBalance;
      }
      
      public void setAccountName(String paramString)
      {
        this.accountName = paramString;
      }
      
      public void setBalance(String paramString)
      {
        this.balance = paramString;
      }
      
      public void setCityCode(String paramString)
      {
        this.cityCode = paramString;
      }
      
      public void setFrozenBalance(String paramString)
      {
        this.frozenBalance = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/Balance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */