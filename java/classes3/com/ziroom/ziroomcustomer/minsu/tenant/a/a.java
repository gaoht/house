package com.ziroom.ziroomcustomer.minsu.tenant.a;

import android.app.Activity;
import android.content.Context;
import com.freelxl.baselibrary.d.f.d;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;

public class a
{
  private static a b;
  private static final Object c = new Object();
  final b a;
  
  private a(b paramb)
  {
    this.a = paramb;
  }
  
  public static a getInstance(b paramb)
  {
    if (b == null) {}
    synchronized (c)
    {
      if (b == null) {
        b = new a(paramb);
      }
      return b;
    }
  }
  
  public void getLandlordHouseList(final Object paramObject, Activity paramActivity, String paramString, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.landlistOk(paramActivity, paramString, "", 0, paramInt, 10, true, false, new com.ziroom.commonlibrary.a.a(paramActivity, new d(MinsuHouseBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("landlord_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseBean paramAnonymousMinsuHouseBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("landlord_house", paramAnonymousMinsuHouseBean), paramObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/tenant/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */