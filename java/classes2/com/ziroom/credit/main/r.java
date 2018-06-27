package com.ziroom.credit.main;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.ziroom.datacenter.remote.responsebody.financial.b.q;

public class r<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements q.a
{
  public r(T paramT)
  {
    super(paramT);
  }
  
  public SpannableStringBuilder getMyString(String paramString1, String paramString2, String paramString3)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString1);
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 0, i, 33);
    i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramString2);
    int j = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ffa000")), i, j, 33);
    i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(paramString3);
    j = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), i, j, 33);
    return localSpannableStringBuilder;
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserRankInfo((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if (!r.this.getView().isActive()) {}
        do
        {
          do
          {
            return;
          } while (!(paramAnonymousThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.a));
          paramAnonymousThrowable = ((com.ziroom.commonlib.ziroomhttp.d.a)paramAnonymousThrowable).getCode();
        } while ((TextUtils.isEmpty(paramAnonymousThrowable)) || (!"20106".equals(paramAnonymousThrowable)));
        ((q.b)r.this.getView()).setIsGetData(false);
      }
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (!r.this.getView().isActive()) {
          return false;
        }
        if ((paramAnonymousThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.a))
        {
          paramAnonymousThrowable = ((com.ziroom.commonlib.ziroomhttp.d.a)paramAnonymousThrowable).getCode();
          if ((!TextUtils.isEmpty(paramAnonymousThrowable)) && ("20106".equals(paramAnonymousThrowable)))
          {
            ((q.b)r.this.getView()).setIsGetData(false);
            return true;
          }
        }
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, q paramAnonymousq)
      {
        if (!r.this.getView().isActive()) {}
        q.b localb;
        do
        {
          return;
          localb = (q.b)r.this.getView();
          if (paramAnonymousq == null)
          {
            localb.setIsGetData(false);
            return;
          }
          localb.setIsGetData(true);
          str = paramAnonymousq.getData().getRankDes();
          paramAnonymousInt = paramAnonymousq.getData().getRankPercent().intValue();
          localb.setCreditScoreRankPercent(paramAnonymousInt);
          paramAnonymousq = String.valueOf(paramAnonymousInt);
        } while (!str.contains(paramAnonymousq));
        paramAnonymousq = paramAnonymousq.concat("%");
        Object localObject = str.split(paramAnonymousq);
        String str = localObject[0];
        localObject = localObject[1];
        localb.setCreditRankExplain(r.this.getMyString(str, paramAnonymousq, (String)localObject));
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */