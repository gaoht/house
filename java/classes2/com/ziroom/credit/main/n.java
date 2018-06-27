package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.p;

public class n<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements m.a
{
  public n(T paramT)
  {
    super(paramT);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserNegativeRecord((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, p paramAnonymousp)
      {
        if (!n.this.getView().isActive()) {
          return;
        }
        ((m.b)n.this.getView()).getUserNegativeRecord(paramAnonymousp);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */