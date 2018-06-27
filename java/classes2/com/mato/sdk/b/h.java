package com.mato.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.a.a;
import com.mato.sdk.g.i;

public final class h
{
  private static int a = -1;
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 4;
  private static String g = "Unknown";
  private final String h;
  private final int i;
  private final boolean j;
  private final boolean k;
  
  public h()
  {
    this(-1, false);
  }
  
  private h(int paramInt, String paramString, boolean paramBoolean)
  {
    this(paramInt, paramString, paramBoolean, true);
  }
  
  private h(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.h = paramString;
    this.i = paramInt;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
  }
  
  private h(int paramInt, boolean paramBoolean) {}
  
  public static int a(String paramString)
  {
    if (paramString.equals("WIFI")) {
      return 1;
    }
    if (paramString.equals("3G")) {
      return 3;
    }
    if ((paramString.equals("2G")) || (paramString.equals("EDGE")) || (paramString.equals("GPRS"))) {
      return 2;
    }
    if (paramString.equals("LTE")) {
      return 4;
    }
    if (paramString.equals("None")) {
      return 0;
    }
    return -1;
  }
  
  public static h a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 11: 
    case 16: 
    case 18: 
    default: 
      if ((paramString.equalsIgnoreCase("TD-SCDMA")) || (paramString.equalsIgnoreCase("WCDMA")) || (paramString.equalsIgnoreCase("CDMA2000"))) {
        return new h(3, true);
      }
      break;
    case 2: 
      return new h(2, "EDGE", true);
    case 1: 
      return new h(2, "GPRS", true);
    case 4: 
    case 7: 
      return new h(2, "CDMA", true);
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      return new h(3, true);
    case 13: 
    case 19: 
      return new h(4, true);
    case 0: 
      return new h(-1, true);
    }
    return new h(-1, true);
  }
  
  public static h a(Context paramContext)
  {
    return a(paramContext, null);
  }
  
  public static h a(Context paramContext, a parama)
  {
    try
    {
      paramContext = i.b(paramContext);
      if (paramContext == null) {
        return new h(-1, false);
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        paramContext = new h(0, false);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      return new h(-1, "Unknown", false, false);
    }
    if ((!paramContext.isAvailable()) || (!paramContext.isConnected())) {
      return new h(0, false);
    }
    if (paramContext.getType() == 1) {
      return new h(1, false);
    }
    if (paramContext.getType() == 0) {
      return a(paramContext.getSubtype(), paramContext.getSubtypeName());
    }
    paramContext = new h(-1, false);
    return paramContext;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return "Unknown";
    case 1: 
      return "WIFI";
    case -1: 
      return "Unknown";
    case 3: 
      return "3G";
    case 4: 
      return "LTE";
    }
    return "None";
  }
  
  private boolean g()
  {
    return this.i == 1;
  }
  
  public final String a()
  {
    return this.h;
  }
  
  public final boolean a(h paramh)
  {
    return (this.i == paramh.i) && (this.k == paramh.k);
  }
  
  public final boolean b()
  {
    return this.k;
  }
  
  public final int c()
  {
    return this.i;
  }
  
  public final boolean d()
  {
    return this.j;
  }
  
  public final boolean e()
  {
    return this.i != 0;
  }
  
  public final String f()
  {
    if (this.i == 2) {
      return "2G";
    }
    return this.h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */