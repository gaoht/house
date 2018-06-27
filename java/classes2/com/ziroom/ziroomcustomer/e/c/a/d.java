package com.ziroom.ziroomcustomer.e.c.a;

import com.alibaba.fastjson.e;

public class d
  extends f
{
  private final String b = "HouseKeeperHandler";
  
  public void decode(String paramString)
  {
    super.decode(paramString);
  }
  
  public int getCode()
  {
    return 0;
  }
  
  public String getData()
  {
    if (this.a != null) {
      return this.a.getString("data");
    }
    return null;
  }
  
  public String getMessage()
  {
    return null;
  }
  
  public boolean isSuccess()
  {
    if (this.a != null) {
      return "success".equals(this.a.getString("status"));
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */