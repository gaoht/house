package com.ziroom.credit.main;

import com.ziroom.credit.base.b;
import com.ziroom.credit.base.c;

public class e
{
  static abstract interface a
    extends b
  {}
  
  static abstract interface b
    extends c<e.a>
  {
    public abstract void setCertName(String paramString);
    
    public abstract void setCertificateNum(String paramString);
    
    public abstract void setUserName(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */