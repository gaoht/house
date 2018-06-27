package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import java.lang.reflect.Method;
import java.util.HashMap;

final class ap
  implements m
{
  ap(Context paramContext) {}
  
  public final void a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    paramMethod = new HashMap();
    paramMethod.put("isSessionOnly", "1");
    paramMethod.put("occurTime", Long.valueOf(System.currentTimeMillis()));
    if ((this.a instanceof Activity))
    {
      if (!((String)paramObject).equalsIgnoreCase("activityPaused")) {
        break label65;
      }
      ag.a((Activity)this.a);
    }
    label65:
    while (!((String)paramObject).equalsIgnoreCase("activityIdle")) {
      return;
    }
    ag.b((Activity)this.a);
  }
  
  public final void a(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */