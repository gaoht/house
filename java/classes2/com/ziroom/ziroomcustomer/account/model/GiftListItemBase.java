package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;
import java.io.Serializable;

public class GiftListItemBase
  extends b
  implements Serializable
{
  private static final long serialVersionUID = -7847750777171559707L;
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public class DataBean
    implements Serializable
  {
    private static final long serialVersionUID = 3114625387805499783L;
    private double amount;
    private String marketName;
    private String ruleStr;
    
    public DataBean() {}
    
    public double getAmount()
    {
      return this.amount;
    }
    
    public String getMarketName()
    {
      return this.marketName;
    }
    
    public String getRuleStr()
    {
      return this.ruleStr;
    }
    
    public void setAmount(double paramDouble)
    {
      this.amount = paramDouble;
    }
    
    public void setMarketName(String paramString)
    {
      this.marketName = paramString;
    }
    
    public void setRuleStr(String paramString)
    {
      this.ruleStr = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/GiftListItemBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */