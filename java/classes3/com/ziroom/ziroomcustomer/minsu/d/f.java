package com.ziroom.ziroomcustomer.minsu.d;

import android.app.Activity;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInitSearchBase;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.s;

public class f
{
  private static f d;
  private Activity a;
  private MinsuInitSearchBase b;
  private String c;
  
  private f(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public static f getInstance(Activity paramActivity)
  {
    if (d == null) {
      d = new f(paramActivity);
    }
    return d;
  }
  
  public boolean checkCityCode(String paramString)
  {
    if (((c.isNull(paramString)) && (!c.isNull(this.c))) || ((!c.isNull(paramString)) && (!paramString.equals(this.c))))
    {
      init(paramString, null);
      return false;
    }
    return true;
  }
  
  public MinsuInitSearchBase getData()
  {
    return this.b;
  }
  
  public void init(String paramString, final com.freelxl.baselibrary.d.c.a<MinsuInitSearchBase> parama)
  {
    this.c = paramString;
    this.b = null;
    com.ziroom.ziroomcustomer.minsu.e.a.initSearchBaseData(this.a, false, paramString, new s(this.a, new d(MinsuInitSearchBase.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if (parama != null) {
          parama.onFailure(paramAnonymousThrowable);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuInitSearchBase paramAnonymousMinsuInitSearchBase)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuInitSearchBase);
        if ((paramAnonymousMinsuInitSearchBase != null) && (paramAnonymousMinsuInitSearchBase.checkSuccessNoLogin())) {
          f.a(f.this, paramAnonymousMinsuInitSearchBase);
        }
        if (parama != null) {
          parama.onSuccess(paramAnonymousInt, paramAnonymousMinsuInitSearchBase);
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */