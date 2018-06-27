package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class User
  implements Serializable
{
  private String login_name;
  private String login_type;
  
  public String getLogin_name()
  {
    return this.login_name;
  }
  
  public String getLogin_type()
  {
    return this.login_type;
  }
  
  public void setLogin_name(String paramString)
  {
    this.login_name = paramString;
  }
  
  public void setLogin_type(String paramString)
  {
    this.login_type = paramString;
  }
  
  public String toString()
  {
    return "User [login_name=" + this.login_name + ", login_type=" + this.login_type + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */