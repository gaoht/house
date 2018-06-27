package com.ziroom.ziroomcustomer.pay.uniondk.bean;

import java.io.Serializable;

public class UnionWithholdBean
  implements Serializable
{
  private String bankCardNo;
  private String bankName;
  private String certificateNum;
  private String mobile;
  private String uid;
  private String userName;
  
  public String getBankCardNo()
  {
    return this.bankCardNo;
  }
  
  public String getBankName()
  {
    return this.bankName;
  }
  
  public String getCertificateNum()
  {
    return this.certificateNum;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setBankCardNo(String paramString)
  {
    this.bankCardNo = paramString;
  }
  
  public void setBankName(String paramString)
  {
    this.bankName = paramString;
  }
  
  public void setCertificateNum(String paramString)
  {
    this.certificateNum = paramString;
  }
  
  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/bean/UnionWithholdBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */