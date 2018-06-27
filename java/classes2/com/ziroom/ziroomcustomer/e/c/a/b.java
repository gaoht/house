package com.ziroom.ziroomcustomer.e.c.a;

import com.alibaba.fastjson.e;

public class b
  extends f
{
  public int getCode()
  {
    if (this.a != null)
    {
      Integer localInteger = this.a.getInteger("error_code");
      if (localInteger != null) {
        return localInteger.intValue();
      }
    }
    return -1;
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
    if (this.a != null) {
      return this.a.getString("error_message");
    }
    return null;
  }
  
  public boolean isSuccess()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      Integer localInteger = this.a.getInteger("error_code");
      bool1 = bool2;
      if (localInteger != null)
      {
        bool1 = bool2;
        if (localInteger.intValue() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */