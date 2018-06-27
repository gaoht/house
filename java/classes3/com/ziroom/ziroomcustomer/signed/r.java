package com.ziroom.ziroomcustomer.signed;

import java.io.Serializable;

public class r
  implements Serializable
{
  private String a;
  private String b;
  
  public r() {}
  
  public r(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getContract_code()
  {
    return this.a;
  }
  
  public String getSign_data()
  {
    return this.b;
  }
  
  public void setContract_code(String paramString)
  {
    this.a = paramString;
  }
  
  public void setSign_data(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */