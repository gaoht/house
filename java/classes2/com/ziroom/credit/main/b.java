package com.ziroom.credit.main;

import android.app.Activity;
import android.text.TextUtils;
import com.ziroom.datacenter.remote.responsebody.financial.b.n;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.n.a.a;

public class b<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements a.a
{
  public b(T paramT)
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
        if (!b.this.getView().isActive()) {}
        a.b localb;
        do
        {
          return;
          localb = (a.b)b.this.getView();
          String str1 = paramAnonymousn.getData().getUserInfoScore().getUserEducation().getDegreeStr();
          String str2 = paramAnonymousn.getData().getUserInfoScore().getUserEducation().getEntranceDateStr();
          String str3 = paramAnonymousn.getData().getUserInfoScore().getUserEducation().getGraduateDateStr();
          String str4 = paramAnonymousn.getData().getUserInfoScore().getUserEducation().getSchoolName();
          paramAnonymousn = paramAnonymousn.getData().getUserInfoScore().getUserEducation().getEducationTypeStr();
          if (!TextUtils.isEmpty(str1)) {
            localb.setEducationName(str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            localb.setEducationStart(str2);
          }
          if (!TextUtils.isEmpty(str3)) {
            localb.setEducationEnd(str3);
          }
          if (!TextUtils.isEmpty(str4)) {
            localb.setSchoolName(str4);
          }
        } while (TextUtils.isEmpty(paramAnonymousn));
        localb.setEducationType(paramAnonymousn);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */