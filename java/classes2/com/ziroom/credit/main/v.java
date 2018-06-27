package com.ziroom.credit.main;

import android.app.Activity;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.f;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.m;

public class v<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements u.a
{
  public v(T paramT)
  {
    super(paramT);
  }
  
  private void a()
  {
    com.ziroom.commonlibrary.login.a.getUserInfo(getView().getViewContext(), new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        paramAnonymouse = (String)paramAnonymouse.get("phone");
        if (f.notNull(paramAnonymouse))
        {
          v.a(v.this, paramAnonymouse);
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(v.this.getView().getViewContext());
      }
    });
  }
  
  private void a(String paramString)
  {
    com.ziroom.datacenter.remote.e.c.userAuthorization((Activity)getView().getViewContext(), paramString, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        ((u.b)v.this.getView()).AuthorizationSuccess(false);
      }
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        ((u.b)v.this.getView()).AuthorizationSuccess(true);
      }
    });
  }
  
  public void getAgreeUrl()
  {
    com.ziroom.datacenter.remote.e.c.getUserBaseInfo((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
      {
        if (!v.this.getView().isActive()) {}
        while (paramAnonymousm == null) {
          return;
        }
        paramAnonymousm = paramAnonymousm.getAgreeUrl();
        ((u.b)v.this.getView()).setAgreeUrl(paramAnonymousm);
      }
    });
  }
  
  public void gotoAuthorization()
  {
    a();
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */