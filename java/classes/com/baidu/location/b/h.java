package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.a.i;
import com.baidu.location.a.q;
import com.baidu.location.a.s;
import com.baidu.location.f;
import java.util.List;

public class h
{
  public static long a = 0L;
  private static h b = null;
  private WifiManager c = null;
  private a d = null;
  private g e = null;
  private long f = 0L;
  private long g = 0L;
  private boolean h = false;
  private Handler i = new Handler();
  
  public static h a()
  {
    try
    {
      if (b == null) {
        b = new h();
      }
      h localh = b;
      return localh;
    }
    finally {}
  }
  
  private String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  public static boolean a(g paramg1, g paramg2, float paramFloat)
  {
    if ((paramg1 == null) || (paramg2 == null)) {
      return false;
    }
    paramg1 = paramg1.a;
    paramg2 = paramg2.a;
    if (paramg1 == paramg2) {
      return true;
    }
    if ((paramg1 == null) || (paramg2 == null)) {
      return false;
    }
    int n = paramg1.size();
    int i1 = paramg2.size();
    float f1 = n + i1;
    if ((n == 0) && (i1 == 0)) {
      return true;
    }
    if ((n == 0) || (i1 == 0)) {
      return false;
    }
    int k = 0;
    int j = 0;
    String str;
    if (k < n)
    {
      str = ((ScanResult)paramg1.get(k)).BSSID;
      if (str != null) {}
    }
    for (;;)
    {
      k += 1;
      break;
      int m = 0;
      for (;;)
      {
        if (m < i1)
        {
          if (str.equals(((ScanResult)paramg2.get(m)).BSSID))
          {
            j += 1;
            break;
          }
          m += 1;
          continue;
          return j * 2 > f1 * paramFloat;
        }
      }
    }
  }
  
  public static boolean h()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int j = localNetworkInfo.getType();
        if (j == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void p()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = this.c.getScanResults();
        if (localObject != null)
        {
          localObject = new g((List)localObject, System.currentTimeMillis());
          if ((this.e == null) || (!((g)localObject).a(this.e)))
          {
            this.e = ((g)localObject);
            return;
          }
        }
      }
      catch (Exception localException) {}
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/baidu/location/b/h:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 155	com/baidu/location/f:isServing	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 115	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc -99
    //   27: invokevirtual 123	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 136	android/net/wifi/WifiManager
    //   33: putfield 36	com/baidu/location/b/h:c	Landroid/net/wifi/WifiManager;
    //   36: aload_0
    //   37: new 8	com/baidu/location/b/h$a
    //   40: dup
    //   41: aload_0
    //   42: aconst_null
    //   43: invokespecial 160	com/baidu/location/b/h$a:<init>	(Lcom/baidu/location/b/h;Lcom/baidu/location/b/h$1;)V
    //   46: putfield 38	com/baidu/location/b/h:d	Lcom/baidu/location/b/h$a;
    //   49: invokestatic 115	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 38	com/baidu/location/b/h:d	Lcom/baidu/location/b/h$a;
    //   56: new 162	android/content/IntentFilter
    //   59: dup
    //   60: ldc -92
    //   62: invokespecial 167	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 171	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   68: pop
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 46	com/baidu/location/b/h:h	Z
    //   74: goto -62 -> 12
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    //   82: astore_2
    //   83: goto -14 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	h
    //   6	4	1	bool	boolean
    //   77	4	2	localObject	Object
    //   82	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	77	finally
    //   15	49	77	finally
    //   49	69	77	finally
    //   69	74	77	finally
    //   49	69	82	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/baidu/location/b/h:h	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 115	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 38	com/baidu/location/b/h:d	Lcom/baidu/location/b/h$a;
    //   21: invokevirtual 175	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: lconst_0
    //   25: putstatic 30	com/baidu/location/b/h:a	J
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 38	com/baidu/location/b/h:d	Lcom/baidu/location/b/h$a;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 36	com/baidu/location/b/h:c	Landroid/net/wifi/WifiManager;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 46	com/baidu/location/b/h:h	Z
    //   43: goto -32 -> 11
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: goto -24 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	h
    //   6	2	1	bool	boolean
    //   46	4	2	localObject	Object
    //   51	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	46	finally
    //   14	28	46	finally
    //   28	43	46	finally
    //   14	28	51	java/lang/Exception
  }
  
  public boolean d()
  {
    long l = System.currentTimeMillis();
    if ((l - this.g > 0L) && (l - this.g <= 5000L)) {
      return false;
    }
    this.g = l;
    return e();
  }
  
  public boolean e()
  {
    if (this.c == null) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l - this.f > 0L) && ((l - this.f <= 5000L) || (l - a * 1000L <= 5000L) || ((h()) && (l - this.f <= 10000L))));
    return g();
  }
  
  public String f()
  {
    String str2 = "";
    String str1 = str2;
    if (this.c != null) {}
    try
    {
      if (!this.c.isWifiEnabled())
      {
        str1 = str2;
        if (Build.VERSION.SDK_INT > 17)
        {
          str1 = str2;
          if (!this.c.isScanAlwaysAvailable()) {}
        }
      }
      else
      {
        str1 = "&wifio=1";
      }
      return str1;
    }
    catch (Exception localException)
    {
      return "";
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public boolean g()
  {
    boolean bool2 = false;
    try
    {
      boolean bool1;
      if (!this.c.isWifiEnabled())
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT > 17)
        {
          bool1 = bool2;
          if (!this.c.isScanAlwaysAvailable()) {}
        }
      }
      else
      {
        this.c.startScan();
        this.f = System.currentTimeMillis();
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return false;
  }
  
  public WifiInfo i()
  {
    if (this.c == null) {}
    for (;;)
    {
      return null;
      try
      {
        WifiInfo localWifiInfo = this.c.getConnectionInfo();
        if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null))
        {
          String str = localWifiInfo.getBSSID();
          if (str != null)
          {
            str = str.replace(":", "");
            if (!"000000000000".equals(str))
            {
              boolean bool = "".equals(str);
              if (bool) {}
            }
          }
          else
          {
            return localWifiInfo;
          }
        }
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public String j()
  {
    Object localObject2 = null;
    StringBuffer localStringBuffer = new StringBuffer();
    WifiInfo localWifiInfo = a().i();
    Object localObject1 = localObject2;
    if (localWifiInfo != null)
    {
      localObject1 = localObject2;
      if (localWifiInfo.getBSSID() != null)
      {
        String str1 = localWifiInfo.getBSSID().replace(":", "");
        int k = localWifiInfo.getRssi();
        String str2 = a().k();
        int j = k;
        if (k < 0) {
          j = -k;
        }
        localObject1 = localObject2;
        if (str1 != null)
        {
          localStringBuffer.append("&wf=");
          localStringBuffer.append(str1);
          localStringBuffer.append(";");
          localStringBuffer.append("" + j + ";");
          localStringBuffer.append(localWifiInfo.getSSID());
          localStringBuffer.append("&wf_n=1");
          if (str2 != null)
          {
            localStringBuffer.append("&wf_gt=");
            localStringBuffer.append(str2);
          }
          localObject1 = localStringBuffer.toString();
        }
      }
    }
    return (String)localObject1;
  }
  
  public String k()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c != null)
    {
      DhcpInfo localDhcpInfo = this.c.getDhcpInfo();
      localObject1 = localObject2;
      if (localDhcpInfo != null) {
        localObject1 = a(localDhcpInfo.gateway);
      }
    }
    return (String)localObject1;
  }
  
  public g l()
  {
    if ((this.e == null) || (!this.e.f())) {
      return n();
    }
    return this.e;
  }
  
  public g m()
  {
    if ((this.e == null) || (!this.e.g())) {
      return n();
    }
    return this.e;
  }
  
  public g n()
  {
    if (this.c != null) {
      try
      {
        g localg = new g(this.c.getScanResults(), this.f);
        return localg;
      }
      catch (Exception localException) {}
    }
    return new g(null, 0L);
  }
  
  public String o()
  {
    String str = null;
    try
    {
      WifiInfo localWifiInfo = this.c.getConnectionInfo();
      if (localWifiInfo != null) {
        str = localWifiInfo.getMacAddress();
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private class a
    extends BroadcastReceiver
  {
    private long b = 0L;
    private boolean c = false;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext == null) {}
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            if (!paramContext.equals("android.net.wifi.SCAN_RESULTS")) {
              break;
            }
            h.a = System.currentTimeMillis() / 1000L;
            h.a(h.this);
            i.c().h();
          } while (System.currentTimeMillis() - q.b() > 5000L);
          s.a(q.c(), h.this.l(), q.d(), q.a());
          return;
        } while ((!paramContext.equals("android.net.wifi.STATE_CHANGE")) || (!((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED)) || (System.currentTimeMillis() - this.b < 5000L));
        this.b = System.currentTimeMillis();
      } while (this.c);
      this.c = true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */