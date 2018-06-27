package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class payDetailEntity
  implements Serializable
{
  private String payDate;
  private String payMoney;
  private String seq;
  
  public String getPayDate()
  {
    return this.payDate;
  }
  
  public String getPayMoney()
  {
    return this.payMoney;
  }
  
  public String getSeq()
  {
    return this.seq;
  }
  
  public void setPayDate(String paramString)
  {
    this.payDate = paramString;
  }
  
  public void setPayMoney(String paramString)
  {
    this.payMoney = paramString;
  }
  
  public void setSeq(String paramString)
  {
    this.seq = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/payDetailEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */