package com.baidu.trace;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.baidu.trace.a.j;
import com.baidu.trace.c.d;
import com.baidu.trace.c.e;
import java.util.ArrayList;
import java.util.List;

public final class y
{
  private WifiManager a;
  private List<ScanResult> b;
  private List<ScanResult> c;
  private long d;
  
  protected y(Context paramContext)
  {
    this.a = ((WifiManager)paramContext.getSystemService("wifi"));
  }
  
  protected final void a(ArrayList<j> paramArrayList)
  {
    if (this.a != null)
    {
      this.a.startScan();
      this.b = this.a.getScanResults();
    }
    int i;
    label87:
    label127:
    int j;
    label151:
    int k;
    label164:
    Object localObject;
    if ((this.b == null) || (this.b.size() <= 0))
    {
      if (e.a(this.b, this.c))
      {
        long l = e.b() - this.d;
        if ((l < 0L) || (l > 60L))
        {
          i = 1;
          if (i == 0) {
            break label289;
          }
        }
      }
      else
      {
        if (this.c != null)
        {
          this.c.clear();
          this.c = null;
        }
        this.c = this.b;
        this.d = e.b();
        if (this.b != null) {
          break label321;
        }
      }
    }
    else
    {
      j = this.b.size();
      i = 1;
      j -= 1;
      if ((j > 0) && (i != 0))
      {
        i = 0;
        k = 0;
        if (k < j)
        {
          if (((ScanResult)this.b.get(k)).level >= ((ScanResult)this.b.get(k + 1)).level) {
            break label567;
          }
          localObject = (ScanResult)this.b.get(k + 1);
          this.b.set(k + 1, this.b.get(k));
          this.b.set(k, localObject);
          i = 1;
        }
      }
    }
    label289:
    label321:
    label338:
    label340:
    label558:
    label567:
    for (;;)
    {
      k += 1;
      break label164;
      j -= 1;
      break label151;
      break;
      i = 0;
      break label87;
      if (this.b != null)
      {
        this.b.clear();
        this.b = null;
      }
      this.b = this.c;
      break label127;
      if (this.b.size() > 15)
      {
        i = 15;
        j = 0;
        if (j < i)
        {
          localObject = new j();
          ((j)localObject).a = d.b(((ScanResult)this.b.get(j)).BSSID);
          ((j)localObject).b = Integer.valueOf(((ScanResult)this.b.get(j)).level).byteValue();
          ((j)localObject).c = d.a(((ScanResult)this.b.get(j)).SSID);
          if ((!((ScanResult)this.b.get(j)).capabilities.contains("WPA")) && (!((ScanResult)this.b.get(j)).capabilities.contains("wpa")) && (!((ScanResult)this.b.get(j)).capabilities.contains("WEP")) && (!((ScanResult)this.b.get(j)).capabilities.contains("wep"))) {
            break label558;
          }
        }
      }
      for (((j)localObject).d = 1;; ((j)localObject).d = 0)
      {
        paramArrayList.add(localObject);
        j += 1;
        break label340;
        break;
        i = this.b.size();
        break label338;
      }
    }
  }
  
  protected final boolean a()
  {
    if (this.a == null) {}
    boolean bool;
    do
    {
      return false;
      bool = this.a.isWifiEnabled();
      if ((bool) || (Build.VERSION.SDK_INT < 18)) {
        break;
      }
    } while (!this.a.isScanAlwaysAvailable());
    return true;
    return bool;
  }
  
  protected final void b()
  {
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */