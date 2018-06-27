package com.ziroom.credit.main;

import android.app.Activity;
import android.text.TextUtils;
import com.ziroom.datacenter.remote.responsebody.financial.b.n;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a.d;

public class ad<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements ac.a
{
  public ad(T paramT)
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
        if (!ad.this.getView().isActive()) {
          return;
        }
        ac.b localb = (ac.b)ad.this.getView();
        String str1 = paramAnonymousn.getData().getUserInfoScore().getUserWork().getIndustryName();
        String str2 = paramAnonymousn.getData().getUserInfoScore().getUserWork().getUnitName();
        paramAnonymousn = paramAnonymousn.getData().getUserInfoScore().getUserWork().getCompanyAddr();
        if (!TextUtils.isEmpty(str1)) {
          localb.setWorkName(str1);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(str2)) {
            localb.setCompanyName(str2);
          }
          if (TextUtils.isEmpty(paramAnonymousn)) {
            break;
          }
          localb.setCompanyAddress(paramAnonymousn);
          return;
          localb.setWorkName("暂无");
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */