package com.ziroom.ziroomcustomer.e.c.a;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.util.k;

public class c
  extends f
{
  private final String b = "BiweeklyCleanHandler";
  
  public void decode(String paramString)
  {
    super.decode(k.decrypt(paramString));
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
    if (this.a != null) {
      return this.a.getString("message");
    }
    return null;
  }
  
  public boolean isSuccess()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      String str1 = this.a.getString("status");
      String str2 = this.a.getString("code");
      bool1 = bool2;
      if ("success".equals(str1))
      {
        bool1 = bool2;
        if ("200".equals(str2)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */