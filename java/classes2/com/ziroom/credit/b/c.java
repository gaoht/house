package com.ziroom.credit.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.ziroom.datacenter.remote.b.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.m;
import com.ziroom.router.activityrouter.Routers;

public class c
{
  public static void GotoCreditMainActivity(Context paramContext, Bundle paramBundle)
  {
    com.ziroom.datacenter.remote.e.c.getUserBaseInfo((Activity)paramContext, new a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
      {
        if (paramAnonymousm == null) {}
        while (paramAnonymousm.getUserType() == 2) {
          return;
        }
        if (paramAnonymousm.getUserType() == 1)
        {
          if (paramAnonymousm.getAuthStatus() == 1)
          {
            Routers.open(this.a, "ziroomCustomer://zrCreditModule/homeView");
            return;
          }
          Routers.open(this.a, "ziroomCustomer://zrCreditModule/impowerView");
          return;
        }
        if (paramAnonymousm.getAuthStatus() == 1)
        {
          Routers.open(this.a, "ziroomCustomer://zrCreditModule/homeView");
          return;
        }
        Routers.open(this.a, "ziroomCustomer://zrCreditModule/impowerView");
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */