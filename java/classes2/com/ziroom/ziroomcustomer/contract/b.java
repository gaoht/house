package com.ziroom.ziroomcustomer.contract;

import java.io.Serializable;

public class b
  implements Serializable
{
  private String a;
  private String b;
  
  public String getContract_code()
  {
    return this.b;
  }
  
  public String getRenew_state()
  {
    return this.a;
  }
  
  public void setContract_code(String paramString)
  {
    this.b = paramString;
  }
  
  public void setRenew_state(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/contract/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */