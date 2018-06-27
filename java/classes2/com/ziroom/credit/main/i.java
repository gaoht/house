package com.ziroom.credit.main;

import com.ziroom.credit.base.b;
import com.ziroom.credit.base.c;
import com.ziroom.datacenter.remote.responsebody.financial.b.g;

public class i
{
  static abstract interface a
    extends b
  {
    public abstract void getCouponByCode(String paramString);
    
    public abstract void getMedalByMedalByCode(String paramString);
  }
  
  static abstract interface b
    extends c<i.a>
  {
    public abstract void setCouponByCode();
    
    public abstract void setMedalByMedalByCode(g paramg);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */