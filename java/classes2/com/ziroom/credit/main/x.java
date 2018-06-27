package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.r;

public class x
  extends com.ziroom.credit.base.a
  implements w.a
{
  public x(com.ziroom.credit.base.c paramc)
  {
    super(paramc);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserScoreInfoByUid((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, r paramAnonymousr)
      {
        if ((paramAnonymousr == null) || (paramAnonymousr.getData() == null)) {
          return;
        }
        w.b localb = (w.b)x.this.getView();
        localb.setScore(paramAnonymousr.getData().getZiroomScore());
        localb.setLevelText(paramAnonymousr.getData().getLevelName());
        if (paramAnonymousr.getData().getBacklogCount() == 0) {}
        for (paramAnonymousInt = 8;; paramAnonymousInt = 0)
        {
          localb.setPromoteVisible(paramAnonymousInt);
          return;
        }
      }
    });
    com.ziroom.datacenter.remote.e.c.getBannerList((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
      {
        ((w.b)x.this.getView()).getBannerData(paramAnonymousb.getBanner());
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */