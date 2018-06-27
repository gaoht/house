package com.ziroom.credit.main;

import android.app.Activity;
import android.text.TextUtils;
import com.ziroom.datacenter.remote.responsebody.financial.b.n;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a.b;

public class f<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements e.a
{
  public f(T paramT)
  {
    super(paramT);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserInfoScoreRecord((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, n paramAnonymousn)
      {
        if (!f.this.getView().isActive()) {}
        e.b localb;
        do
        {
          return;
          localb = (e.b)f.this.getView();
          String str1 = paramAnonymousn.getData().getUserInfoScore().getUserIdentity().getUserName();
          String str2 = paramAnonymousn.getData().getUserInfoScore().getCertName();
          paramAnonymousn = paramAnonymousn.getData().getUserInfoScore().getUserIdentity().getCertificateNum();
          if (!TextUtils.isEmpty(str1)) {
            localb.setUserName(str1);
          }
          localb.setCertName(str2);
        } while (TextUtils.isEmpty(paramAnonymousn));
        localb.setCertificateNum(paramAnonymousn);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */