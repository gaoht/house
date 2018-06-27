package com.g.a;

import android.app.Activity;
import android.content.Context;
import java.lang.reflect.Method;

class co
  implements x
{
  co(db paramdb, Context paramContext) {}
  
  public void a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    if ((this.a instanceof Activity))
    {
      if (!((String)paramObject).equalsIgnoreCase("activityPaused")) {
        break label38;
      }
      cx.b((Activity)this.a, a.a);
    }
    label38:
    while (!((String)paramObject).equalsIgnoreCase("activityIdle")) {
      return;
    }
    cx.a((Activity)this.a, a.a);
  }
  
  public void a(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */