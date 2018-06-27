package com.mob.commons.authorize;

import android.text.TextUtils;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashSet;

public final class DeviceAuthorizer
  implements PublicMemberKeeper
{
  static String a = null;
  private static HashSet<String> b = new HashSet();
  private static Object c = new Object();
  
  public static String authorize(MobProduct paramMobProduct)
  {
    int k = 1;
    int i = 0;
    int j = 0;
    if (paramMobProduct != null) {}
    try
    {
      MobProductCollector.registerProduct(paramMobProduct);
      if (!b.contains(paramMobProduct.getProductTag())) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        b.add(paramMobProduct.getProductTag());
        i = j;
      }
      if (TextUtils.isEmpty(a))
      {
        a = new a().a(true, false);
        i = k;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(a))
        {
          a = b(paramMobProduct);
          if (TextUtils.isEmpty(a)) {
            paramMobProduct = new a().a();
          }
        }
        for (;;)
        {
          return paramMobProduct;
          paramMobProduct = a;
          continue;
          if (i != 0) {
            new Thread()
            {
              public void run()
              {
                DeviceAuthorizer.a(this.a);
              }
            }.start();
          }
          paramMobProduct = a;
        }
      }
    }
    finally {}
  }
  
  public static String authorizeForOnce()
  {
    if (a != null) {
      return a;
    }
    return new a().a(true, true);
  }
  
  private static String b(MobProduct paramMobProduct)
  {
    synchronized (c)
    {
      a locala = new a();
      if (com.mob.commons.a.i())
      {
        paramMobProduct = locala.a(paramMobProduct);
        return paramMobProduct;
      }
      paramMobProduct = locala.a(false, true);
      return paramMobProduct;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/authorize/DeviceAuthorizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */