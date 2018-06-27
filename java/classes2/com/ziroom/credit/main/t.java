package com.ziroom.credit.main;

import android.app.Activity;
import com.ziroom.datacenter.remote.responsebody.financial.b.k;
import com.ziroom.datacenter.remote.responsebody.financial.b.k.a;
import java.util.ArrayList;
import java.util.List;

public class t<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements s.a
{
  public t(T paramT)
  {
    super(paramT);
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserTotalScoreInfoByUid((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return true;
      }
      
      public void onSuccess(int paramAnonymousInt, k paramAnonymousk)
      {
        int i = 0;
        if (!t.this.getView().isActive()) {}
        while (paramAnonymousk == null) {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        paramAnonymousk = paramAnonymousk.getScoreLevelModel();
        if (paramAnonymousk.getUserinfoScore() < 0)
        {
          paramAnonymousInt = 0;
          localArrayList.add(Float.valueOf(paramAnonymousInt / 35.0F));
          if (paramAnonymousk.getContractScore() >= 0) {
            break label162;
          }
          paramAnonymousInt = 0;
          label70:
          localArrayList.add(Float.valueOf(paramAnonymousInt / 80.0F));
          if (paramAnonymousk.getLeasebScore() >= 0) {
            break label170;
          }
          paramAnonymousInt = 0;
          label95:
          localArrayList.add(Float.valueOf(paramAnonymousInt / 40.0F));
          if (paramAnonymousk.getHistoryScore() >= 0) {
            break label178;
          }
        }
        label162:
        label170:
        label178:
        for (paramAnonymousInt = i;; paramAnonymousInt = paramAnonymousk.getHistoryScore())
        {
          localArrayList.add(Float.valueOf(paramAnonymousInt / 40.0F));
          ((s.b)t.this.getView()).setScores(localArrayList);
          return;
          paramAnonymousInt = paramAnonymousk.getUserinfoScore();
          break;
          paramAnonymousInt = paramAnonymousk.getContractScore();
          break label70;
          paramAnonymousInt = paramAnonymousk.getLeasebScore();
          break label95;
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */