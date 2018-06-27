package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.j;
import java.util.List;

public class ab<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements aa.a
{
  public ab(T paramT)
  {
    super(paramT);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getThirdAuthoizationInfo((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, List<j> paramAnonymousList)
      {
        if (!ab.this.getView().isActive()) {
          return;
        }
        ((aa.b)ab.this.getView()).getThirdAuthoizationInfo(paramAnonymousList);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */