package com.ziroom.credit.main;

import android.app.Activity;
import android.text.TextUtils;
import com.ziroom.datacenter.remote.responsebody.financial.b.l;
import com.ziroom.datacenter.remote.responsebody.financial.b.u;
import java.util.ArrayList;
import java.util.List;

public class p<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements o.a
{
  public p(T paramT)
  {
    super(paramT);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserCreditScoreBrokenLineInfo((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (!p.this.getView().isActive()) {
          return false;
        }
        if ((paramAnonymousThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.a))
        {
          paramAnonymousThrowable = ((com.ziroom.commonlib.ziroomhttp.d.a)paramAnonymousThrowable).getCode();
          if (!TextUtils.isEmpty(paramAnonymousThrowable))
          {
            ((o.b)p.this.getView()).setIsGetSuccess(false);
            if ("20107".equals(paramAnonymousThrowable))
            {
              paramAnonymousThrowable = new u();
              paramAnonymousThrowable.setDate("1月");
              paramAnonymousThrowable.setScore("45");
              paramAnonymousString = new u();
              paramAnonymousString.setDate("2月");
              paramAnonymousString.setScore("100");
              u localu1 = new u();
              localu1.setDate("3月");
              localu1.setScore("115");
              u localu2 = new u();
              localu2.setDate("4月");
              localu2.setScore("145");
              u localu3 = new u();
              localu3.setDate("5月");
              localu3.setScore("155");
              u localu4 = new u();
              localu4.setDate("6月");
              localu4.setScore("200");
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(paramAnonymousThrowable);
              localArrayList.add(paramAnonymousString);
              localArrayList.add(localu1);
              localArrayList.add(localu2);
              localArrayList.add(localu3);
              localArrayList.add(localu4);
              ((o.b)p.this.getView()).setcreditchart(localArrayList, false);
              return true;
            }
            return false;
          }
          return false;
        }
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, l paramAnonymousl)
      {
        if (!p.this.getView().isActive()) {}
        o.b localb;
        do
        {
          return;
          if (paramAnonymousl == null) {
            break;
          }
          localb = (o.b)p.this.getView();
          paramAnonymousl = paramAnonymousl.getData().getGraphs();
        } while (paramAnonymousl == null);
        localb.setcreditchart(paramAnonymousl, true);
        return;
        ((o.b)p.this.getView()).setIsGetSuccess(true);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */