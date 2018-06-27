package com.ziroom.datacenter.remote.c.a;

import com.alibaba.fastjson.e;
import com.ziroom.commonlib.utils.g;

public class b
  extends f
{
  private final String b = "BiweeklyCleanHandler";
  
  public void decode(String paramString)
  {
    super.decode(g.desDecrypt(paramString));
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
      String str = this.a.getString("status");
      if (!"0".equals(str))
      {
        bool1 = bool2;
        if (!"success".equals(str)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */