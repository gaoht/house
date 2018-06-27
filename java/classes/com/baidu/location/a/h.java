package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.d.a;

public class h
  implements LBSAuthManagerListener
{
  private static Object a = new Object();
  private static h b = null;
  private int c = 0;
  
  public static h a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new h();
      }
      h localh = b;
      return localh;
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = LBSAuthManager.getInstance(paramContext).getPublicKey(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    LBSAuthManager.getInstance(paramContext).authenticate(false, "lbs_locsdk", null, this);
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (this.c != 0) {
      bool = false;
    }
    return bool;
  }
  
  public void onAuthResult(int paramInt, String paramString)
  {
    this.c = paramInt;
    Log.i(a.a, "LocationAuthManager status = " + paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */