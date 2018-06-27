package com.ziroom.credit.main;

import com.ziroom.credit.base.b;
import com.ziroom.credit.base.c;

public class u
{
  static abstract interface a
    extends b
  {
    public abstract void getAgreeUrl();
    
    public abstract void gotoAuthorization();
  }
  
  static abstract interface b
    extends c<u.a>
  {
    public abstract void AuthorizationSuccess(boolean paramBoolean);
    
    public abstract void setAgreeUrl(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */