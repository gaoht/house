package com.ziroom.credit.main;

import android.app.Activity;
import com.alibaba.fastjson.b;

public class d
  extends com.ziroom.credit.base.a
  implements c.a
{
  public d(com.ziroom.credit.base.c paramc)
  {
    super(paramc);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getEquities((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (!d.this.getView().isActive()) {
          return;
        }
        ((c.b)d.this.getView()).getEquities((b)paramAnonymousObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */