package com.ziroom.credit.main;

import android.text.SpannableStringBuilder;
import com.ziroom.credit.base.b;
import com.ziroom.credit.base.c;

public class q
{
  static abstract interface a
    extends b
  {}
  
  static abstract interface b
    extends c<q.a>
  {
    public abstract void setCreditRankExplain(SpannableStringBuilder paramSpannableStringBuilder);
    
    public abstract void setCreditScoreRankPercent(int paramInt);
    
    public abstract void setCreditScoreRankStr(String paramString);
    
    public abstract void setIsGetData(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */