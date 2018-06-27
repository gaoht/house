package com.superrtc.call;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NetworkMonitorAutoDetect
  extends BroadcastReceiver
{
  private final f a;
  private final IntentFilter b;
  private final Context c;
  private final ConnectivityManager.NetworkCallback d;
  private final ConnectivityManager.NetworkCallback e;
  private b f;
  private h g;
  private boolean h;
  private a i;
  private String j;
  
  @SuppressLint({"NewApi"})
  public NetworkMonitorAutoDetect(f paramf, Context paramContext)
  {
    this.a = paramf;
    this.c = paramContext;
    this.f = new b(paramContext);
    this.g = new h(paramContext);
    paramf = this.f.a();
    this.i = getConnectionType(paramf);
    this.j = a(paramf);
    this.b = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    a();
    if (this.f.supportNetworkCallback())
    {
      this.d = new ConnectivityManager.NetworkCallback();
      this.f.requestMobileNetwork(this.d);
      this.e = new g(null);
      this.f.registerNetworkCallback(this.e);
      return;
    }
    this.d = null;
    this.e = null;
  }
  
  private String a(e parame)
  {
    if (getConnectionType(parame) != a.c) {
      return "";
    }
    return this.g.a();
  }
  
  private void a()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.c.registerReceiver(this, this.b);
  }
  
  @SuppressLint({"NewApi"})
  private static int b(Network paramNetwork)
  {
    return Integer.parseInt(paramNetwork.toString());
  }
  
  private void b()
  {
    if (!this.h) {
      return;
    }
    this.h = false;
    this.c.unregisterReceiver(this);
  }
  
  private void b(e parame)
  {
    a locala = getConnectionType(parame);
    parame = a(parame);
    if ((locala == this.i) && (parame.equals(this.j))) {
      return;
    }
    this.i = locala;
    this.j = parame;
    Logging.d("NetworkMonitorAutoDetect", "Network connectivity changed, type is: " + this.i);
    this.a.onConnectionTypeChanged(locala);
  }
  
  public static a getConnectionType(e parame)
  {
    if (!parame.isConnected()) {
      return a.h;
    }
    switch (parame.getNetworkType())
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    default: 
      return a.a;
    case 9: 
      return a.b;
    case 1: 
      return a.c;
    case 6: 
      return a.d;
    case 7: 
      return a.g;
    }
    switch (parame.getNetworkSubType())
    {
    default: 
      return a.a;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return a.f;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return a.e;
    }
    return a.d;
  }
  
  public void destroy()
  {
    if (this.e != null) {
      this.f.releaseCallback(this.e);
    }
    if (this.d != null) {
      this.f.releaseCallback(this.d);
    }
    b();
  }
  
  public List<d> getActiveNetworkList()
  {
    return this.f.c();
  }
  
  public e getCurrentNetworkState()
  {
    return this.f.a();
  }
  
  public int getDefaultNetId()
  {
    return this.f.d();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = getCurrentNetworkState();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      b(paramContext);
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  static class b
  {
    private final ConnectivityManager b;
    
    static
    {
      if (!NetworkMonitorAutoDetect.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        a = bool;
        return;
      }
    }
    
    b()
    {
      this.b = null;
    }
    
    b(Context paramContext)
    {
      this.b = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    }
    
    @SuppressLint({"NewApi"})
    private NetworkMonitorAutoDetect.d c(Network paramNetwork)
    {
      LinkProperties localLinkProperties = this.b.getLinkProperties(paramNetwork);
      if (localLinkProperties == null)
      {
        Logging.w("NetworkMonitorAutoDetect", "Detected unknown network: " + paramNetwork.toString());
        return null;
      }
      if (localLinkProperties.getInterfaceName() == null)
      {
        Logging.w("NetworkMonitorAutoDetect", "Null interface name for network " + paramNetwork.toString());
        return null;
      }
      NetworkMonitorAutoDetect.a locala = NetworkMonitorAutoDetect.getConnectionType(a(paramNetwork));
      if ((locala == NetworkMonitorAutoDetect.a.a) || (locala == NetworkMonitorAutoDetect.a.h))
      {
        Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " has connection type " + locala);
        return null;
      }
      return new NetworkMonitorAutoDetect.d(localLinkProperties.getInterfaceName(), locala, NetworkMonitorAutoDetect.a(paramNetwork), a(localLinkProperties));
    }
    
    NetworkMonitorAutoDetect.e a()
    {
      if (this.b == null) {
        return new NetworkMonitorAutoDetect.e(false, -1, -1);
      }
      return a(this.b.getActiveNetworkInfo());
    }
    
    @SuppressLint({"NewApi"})
    NetworkMonitorAutoDetect.e a(Network paramNetwork)
    {
      if (this.b == null) {
        return new NetworkMonitorAutoDetect.e(false, -1, -1);
      }
      return a(this.b.getNetworkInfo(paramNetwork));
    }
    
    NetworkMonitorAutoDetect.e a(NetworkInfo paramNetworkInfo)
    {
      if ((paramNetworkInfo == null) || (!paramNetworkInfo.isConnected())) {
        return new NetworkMonitorAutoDetect.e(false, -1, -1);
      }
      return new NetworkMonitorAutoDetect.e(true, paramNetworkInfo.getType(), paramNetworkInfo.getSubtype());
    }
    
    @SuppressLint({"NewApi"})
    NetworkMonitorAutoDetect.c[] a(LinkProperties paramLinkProperties)
    {
      NetworkMonitorAutoDetect.c[] arrayOfc = new NetworkMonitorAutoDetect.c[paramLinkProperties.getLinkAddresses().size()];
      paramLinkProperties = paramLinkProperties.getLinkAddresses().iterator();
      int i = 0;
      while (paramLinkProperties.hasNext())
      {
        arrayOfc[i] = new NetworkMonitorAutoDetect.c(((LinkAddress)paramLinkProperties.next()).getAddress().getAddress());
        i += 1;
      }
      return arrayOfc;
    }
    
    @SuppressLint({"NewApi"})
    boolean b(Network paramNetwork)
    {
      if (this.b == null) {}
      do
      {
        return false;
        paramNetwork = this.b.getNetworkCapabilities(paramNetwork);
      } while ((paramNetwork == null) || (!paramNetwork.hasCapability(12)));
      return true;
    }
    
    @SuppressLint({"NewApi"})
    Network[] b()
    {
      if (this.b == null) {
        return new Network[0];
      }
      return this.b.getAllNetworks();
    }
    
    List<NetworkMonitorAutoDetect.d> c()
    {
      Object localObject;
      if (!supportNetworkCallback())
      {
        localObject = null;
        return (List<NetworkMonitorAutoDetect.d>)localObject;
      }
      ArrayList localArrayList = new ArrayList();
      Network[] arrayOfNetwork = b();
      int j = arrayOfNetwork.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = c(arrayOfNetwork[i]);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    @SuppressLint({"NewApi"})
    int d()
    {
      int k;
      if (!supportNetworkCallback()) {
        k = -1;
      }
      NetworkInfo localNetworkInfo1;
      Network[] arrayOfNetwork;
      int m;
      int j;
      int i;
      do
      {
        return k;
        localNetworkInfo1 = this.b.getActiveNetworkInfo();
        if (localNetworkInfo1 == null) {
          return -1;
        }
        arrayOfNetwork = b();
        m = arrayOfNetwork.length;
        j = 0;
        i = -1;
        k = i;
      } while (j >= m);
      Network localNetwork = arrayOfNetwork[j];
      if (!b(localNetwork)) {
        k = i;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        NetworkInfo localNetworkInfo2 = this.b.getNetworkInfo(localNetwork);
        k = i;
        if (localNetworkInfo2 != null)
        {
          k = i;
          if (localNetworkInfo2.getType() == localNetworkInfo1.getType())
          {
            if ((!a) && (i != -1)) {
              throw new AssertionError();
            }
            k = NetworkMonitorAutoDetect.a(localNetwork);
          }
        }
      }
    }
    
    @SuppressLint({"NewApi"})
    public void registerNetworkCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      this.b.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), paramNetworkCallback);
    }
    
    @SuppressLint({"NewApi"})
    public void releaseCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      if (supportNetworkCallback())
      {
        Logging.d("NetworkMonitorAutoDetect", "Unregister network callback");
        this.b.unregisterNetworkCallback(paramNetworkCallback);
      }
    }
    
    @SuppressLint({"NewApi"})
    public void requestMobileNetwork(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      NetworkRequest.Builder localBuilder = new NetworkRequest.Builder();
      localBuilder.addCapability(12).addTransportType(0);
      this.b.requestNetwork(localBuilder.build(), paramNetworkCallback);
    }
    
    public boolean supportNetworkCallback()
    {
      return (Build.VERSION.SDK_INT >= 21) && (this.b != null);
    }
  }
  
  public static class c
  {
    public final byte[] a;
    
    public c(byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
    }
  }
  
  public static class d
  {
    public final String a;
    public final NetworkMonitorAutoDetect.a b;
    public final int c;
    public final NetworkMonitorAutoDetect.c[] d;
    
    public d(String paramString, NetworkMonitorAutoDetect.a parama, int paramInt, NetworkMonitorAutoDetect.c[] paramArrayOfc)
    {
      this.a = paramString;
      this.b = parama;
      this.c = paramInt;
      this.d = paramArrayOfc;
    }
  }
  
  public static class e
  {
    private final boolean a;
    private final int b;
    private final int c;
    
    public e(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.a = paramBoolean;
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public int getNetworkSubType()
    {
      return this.c;
    }
    
    public int getNetworkType()
    {
      return this.b;
    }
    
    public boolean isConnected()
    {
      return this.a;
    }
  }
  
  public static abstract interface f
  {
    public abstract void onConnectionTypeChanged(NetworkMonitorAutoDetect.a parama);
    
    public abstract void onNetworkConnect(NetworkMonitorAutoDetect.d paramd);
    
    public abstract void onNetworkDisconnect(int paramInt);
  }
  
  @SuppressLint({"NewApi"})
  private class g
    extends ConnectivityManager.NetworkCallback
  {
    private g() {}
    
    private void a(Network paramNetwork)
    {
      paramNetwork = NetworkMonitorAutoDetect.b.a(NetworkMonitorAutoDetect.b(NetworkMonitorAutoDetect.this), paramNetwork);
      if (paramNetwork != null) {
        NetworkMonitorAutoDetect.a(NetworkMonitorAutoDetect.this).onNetworkConnect(paramNetwork);
      }
    }
    
    public void onAvailable(Network paramNetwork)
    {
      Logging.d("NetworkMonitorAutoDetect", "Network becomes available: " + paramNetwork.toString());
      a(paramNetwork);
    }
    
    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
    {
      Logging.d("NetworkMonitorAutoDetect", "capabilities changed: " + paramNetworkCapabilities.toString());
      a(paramNetwork);
    }
    
    public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
    {
      Logging.d("NetworkMonitorAutoDetect", "link properties changed: " + paramLinkProperties.toString());
      a(paramNetwork);
    }
    
    public void onLosing(Network paramNetwork, int paramInt)
    {
      Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " is about to lose in " + paramInt + "ms");
    }
    
    public void onLost(Network paramNetwork)
    {
      Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " is disconnected");
      NetworkMonitorAutoDetect.a(NetworkMonitorAutoDetect.this).onNetworkDisconnect(NetworkMonitorAutoDetect.a(paramNetwork));
    }
  }
  
  static class h
  {
    private final Context a;
    
    h()
    {
      this.a = null;
    }
    
    h(Context paramContext)
    {
      this.a = paramContext;
    }
    
    String a()
    {
      Object localObject = this.a.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
      if (localObject != null)
      {
        localObject = (WifiInfo)((Intent)localObject).getParcelableExtra("wifiInfo");
        if (localObject != null)
        {
          localObject = ((WifiInfo)localObject).getSSID();
          if (localObject != null) {
            return (String)localObject;
          }
        }
      }
      return "";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/NetworkMonitorAutoDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */