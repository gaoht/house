package com.ziroom.credit.main;

import com.ziroom.credit.base.b;
import com.ziroom.credit.base.c;
import com.ziroom.datacenter.remote.responsebody.financial.b.d;
import com.ziroom.datacenter.remote.responsebody.financial.b.i;
import java.util.List;

public class y
{
  static abstract interface a
    extends b
  {
    public abstract void getSingleAuthInfo();
    
    public abstract void getZhimaUrl();
    
    public abstract void setMaimaiOnClick();
    
    public abstract void setRealNameOnClick();
    
    public abstract void setZhimaOnClick();
  }
  
  static abstract interface b
    extends c<y.a>
  {
    public abstract void gotoSignerCareerInfoActivity(i parami);
    
    public abstract void setBillsData(List<d> paramList);
    
    public abstract void setDataCount(int paramInt);
    
    public abstract void setEducationVisibility(boolean paramBoolean);
    
    public abstract void setLinkedVisibility(boolean paramBoolean);
    
    public abstract void setMaimaiVisibility(boolean paramBoolean);
    
    public abstract void setRealNameVisibility(boolean paramBoolean);
    
    public abstract void setUserScoreInfo(String paramString1, String paramString2, String paramString3, String paramString4);
    
    public abstract void setWorkVisibility(boolean paramBoolean);
    
    public abstract void setZhimaUrl(String paramString);
    
    public abstract void setZhimaVisibility(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */