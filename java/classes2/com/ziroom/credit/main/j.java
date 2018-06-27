package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.g;

public class j<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements i.a
{
  public j(T paramT)
  {
    super(paramT);
  }
  
  public void getCouponByCode(String paramString)
  {
    com.ziroom.datacenter.remote.e.c.getCouponByMedalCode((Activity)getView().getViewContext(), paramString, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (!j.this.getView().isActive()) {
          return;
        }
        ((i.b)j.this.getView()).setCouponByCode();
      }
    });
  }
  
  public void getMedalByMedalByCode(String paramString)
  {
    com.ziroom.datacenter.remote.e.c.getMedalByMedalByCode((Activity)getView().getViewContext(), paramString, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, g paramAnonymousg)
      {
        if (!j.this.getView().isActive()) {
          return;
        }
        ((i.b)j.this.getView()).setMedalByMedalByCode(paramAnonymousg);
      }
    });
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */