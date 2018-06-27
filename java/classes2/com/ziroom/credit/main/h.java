package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.n;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a.d;
import com.ziroom.router.activityrouter.Routers;

public class h<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements g.a
{
  private n b;
  
  public h(T paramT)
  {
    super(paramT);
  }
  
  public void setIdentityOnClick()
  {
    int i = this.b.getUserInfoScore().getUserIdentity().getStatus();
    if (this.b.getUserInfoScore().getCertType() == 1)
    {
      if ((i == 2) || (i == 4))
      {
        Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/identifyInfoView");
        com.ziroom.credit.b.a.startAcAnim((Activity)getView().getViewContext());
        return;
      }
      Routers.open(getView().getViewContext(), "ziroomCustomer://zrRentModule/nameAuthenticationMethod");
      return;
    }
    if ((i == 1) || (i == 4))
    {
      Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/identifyInfoView");
      com.ziroom.credit.b.a.startAcAnim((Activity)getView().getViewContext());
      return;
    }
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrRentModule/nameAuthenticationMethod");
  }
  
  public void setSchoolOnClick()
  {
    int i = this.b.getUserInfoScore().getUserEducation().getStatus();
    if ((i == 1) || (i == 4))
    {
      Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/educationView");
      com.ziroom.credit.b.a.startAcAnim((Activity)getView().getViewContext());
      return;
    }
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrRentModule/educationalInfo");
  }
  
  public void setThirdOnClick()
  {
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/authorizationView");
    com.ziroom.credit.b.a.startAcAnim((Activity)getView().getViewContext());
  }
  
  public void setWorkOnClick()
  {
    int i = this.b.getUserInfoScore().getUserWork().getStatus();
    if ((i == 1) || (i == 4))
    {
      Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/workView");
      com.ziroom.credit.b.a.startAcAnim((Activity)getView().getViewContext());
      return;
    }
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrRentModule/qualificationInfo?activityName=AccountInfoActivity");
  }
  
  public void setWrongOnClick()
  {
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/negativeListView");
    com.ziroom.credit.b.a.startAcAnim((Activity)getView().getViewContext());
  }
  
  public void setZiroomscoreOnClick()
  {
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrCreditModule/scorePromoteView");
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
        if (!h.this.getView().isActive()) {
          return;
        }
        h.a(h.this, paramAnonymousn);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */