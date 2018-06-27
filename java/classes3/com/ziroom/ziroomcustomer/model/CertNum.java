package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class CertNum
  implements Serializable
{
  private String cert_num;
  private int cert_type;
  
  public String getCert_num()
  {
    return this.cert_num;
  }
  
  public int getCert_type()
  {
    return this.cert_type;
  }
  
  public void setCert_num(String paramString)
  {
    this.cert_num = paramString;
  }
  
  public void setCert_type(int paramInt)
  {
    this.cert_type = paramInt;
  }
  
  public String toString()
  {
    return "CertNum [cert_type=" + this.cert_type + ", cert_num=" + this.cert_num + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CertNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */