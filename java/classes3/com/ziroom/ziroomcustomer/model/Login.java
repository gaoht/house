package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class Login
  implements Serializable
{
  private String login_name;
  private String reg_mes;
  private String uid;
  
  public String getLogin_name()
  {
    return this.login_name;
  }
  
  public String getReg_mes()
  {
    return this.reg_mes;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setLogin_name(String paramString)
  {
    this.login_name = paramString;
  }
  
  public void setReg_mes(String paramString)
  {
    this.reg_mes = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Login.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */