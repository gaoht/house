package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class l<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements k.a
{
  public l(T paramT)
  {
    super(paramT);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getMedalListByUid((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, List<f> paramAnonymousList)
      {
        if (!l.this.getView().isActive()) {
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          f localf1 = (f)paramAnonymousList.next();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < localf1.getMedalList().size())
          {
            if (paramAnonymousInt == 0)
            {
              localf2 = new f();
              localf2.setmName(localf1.getmName());
              localf2.setType(0);
              localLinkedList.add(localf2);
            }
            f localf2 = (f)localf1.getMedalList().get(paramAnonymousInt);
            int i = 0;
            while (i < localf2.getMedalList().size())
            {
              if (i % 3 == 0)
              {
                f localf3 = new f();
                localf3.setMedalList(new LinkedList());
                localf3.setType(1);
                localLinkedList.add(localf3);
              }
              ((f)localLinkedList.get(localLinkedList.size() - 1)).getMedalList().add(localf2.getMedalList().get(i));
              i += 1;
            }
            paramAnonymousInt += 1;
          }
        }
        ((k.b)l.this.getView()).getMedalList(localLinkedList);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */