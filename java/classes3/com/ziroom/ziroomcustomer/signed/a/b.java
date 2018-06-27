package com.ziroom.ziroomcustomer.signed.a;

import java.io.Serializable;

public class b
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  
  public String getBankName()
  {
    return this.a;
  }
  
  public String getBankPicture()
  {
    return this.b;
  }
  
  public String getZrBankCode()
  {
    return this.c;
  }
  
  public void setBankName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setBankPicture(String paramString)
  {
    this.b = paramString;
  }
  
  public void setZrBankCode(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */