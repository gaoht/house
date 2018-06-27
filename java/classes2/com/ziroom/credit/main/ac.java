package com.ziroom.credit.main;

import com.ziroom.credit.base.b;
import com.ziroom.credit.base.c;

public class ac
{
  static abstract interface a
    extends b
  {}
  
  static abstract interface b
    extends c<ac.a>
  {
    public abstract void setCompanyAddress(String paramString);
    
    public abstract void setCompanyName(String paramString);
    
    public abstract void setWorkName(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */