package com.baidu.location.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.d.e;
import com.baidu.location.d.j;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class b
{
  private static Method e = null;
  private static Method f = null;
  private static Method g = null;
  private static Class<?> h = null;
  c a = new c();
  private Context b = null;
  private TelephonyManager c = null;
  private a d = new a(null);
  private WifiManager i = null;
  private d j = null;
  private String k = null;
  private LocationClientOption l;
  private b m;
  private String n = null;
  private String o = null;
  
  public b(Context paramContext, LocationClientOption paramLocationClientOption, b paramb)
  {
    this.b = paramContext.getApplicationContext();
    this.l = paramLocationClientOption;
    this.m = paramb;
    String str = this.b.getPackageName();
    try
    {
      this.c = ((TelephonyManager)this.b.getSystemService("phone"));
      paramContext = this.c.getDeviceId();
    }
    catch (Exception paramContext)
    {
      try
      {
        for (;;)
        {
          paramb = CommonParam.a(this.b);
          if (paramb == null) {
            break;
          }
          this.k = ("&prod=" + this.l.prodName + ":" + str + "|&cu=" + paramb + "&coor=" + paramLocationClientOption.getCoorType());
          paramContext = new StringBuffer(256);
          paramContext.append("&fw=");
          paramContext.append("7.02");
          paramContext.append("&lt=1");
          paramContext.append("&mb=");
          paramContext.append(Build.MODEL);
          paramContext.append("&resid=");
          paramContext.append("12");
          if ((paramLocationClientOption.getAddrType() == null) || ((paramLocationClientOption.getAddrType() != null) && (paramLocationClientOption.getAddrType().equals("all")))) {
            this.k += "&addr=all";
          }
          if ((paramLocationClientOption.isNeedAptag == true) || (paramLocationClientOption.isNeedAptagd == true))
          {
            this.k += "&sema=";
            if (paramLocationClientOption.isNeedAptag == true) {
              this.k += "aptag|";
            }
            if (paramLocationClientOption.isNeedAptagd == true) {
              this.k += "aptagd|";
            }
            this.o = h.b(this.b);
          }
          paramContext.append("&first=1");
          paramContext.append(Build.VERSION.SDK);
          this.k += paramContext.toString();
          this.i = ((WifiManager)this.b.getSystemService("wifi"));
          paramLocationClientOption = a();
          paramContext = paramLocationClientOption;
          if (!TextUtils.isEmpty(paramLocationClientOption)) {
            paramContext = paramLocationClientOption.replace(":", "");
          }
          if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals("02:00:00:00:00:00"))) {
            this.k = (this.k + "&mac=" + paramContext);
          }
          b();
          return;
          paramContext = paramContext;
          paramContext = null;
        }
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          paramb = null;
          continue;
          this.k = ("&prod=" + this.l.prodName + ":" + str + "|&im=" + paramContext + "&coor=" + paramLocationClientOption.getCoorType());
        }
      }
    }
  }
  
  private String a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 3) {
      i1 = 3;
    }
    try
    {
      a(this.c.getCellLocation());
      str1 = this.d.b();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str1;
          this.j = null;
          this.j = new d(this.i.getScanResults());
          String str3 = this.j.a(i1);
          if ((str1 != null) || (str3 != null)) {
            break;
          }
          this.n = null;
          return null;
          localException1 = localException1;
          str2 = null;
        }
      }
      catch (Exception localException2)
      {
        String str5;
        do
        {
          String str2;
          String str4;
          for (;;)
          {
            str4 = null;
          }
          str5 = str2;
          if (str4 != null) {
            str5 = str2 + str4;
          }
        } while (str5 == null);
        this.n = (str5 + this.k);
        return str5 + this.k;
      }
    }
  }
  
  private void a(CellLocation paramCellLocation)
  {
    int i2 = 0;
    int i3 = 0;
    if ((paramCellLocation == null) || (this.c == null)) {
      return;
    }
    a locala = new a(null);
    String str = this.c.getNetworkOperator();
    if ((str != null) && (str.length() > 0)) {}
    try
    {
      if (str.length() >= 3)
      {
        int i4 = Integer.valueOf(str.substring(0, 3)).intValue();
        i1 = i4;
        if (i4 < 0) {
          i1 = this.d.c;
        }
        locala.c = i1;
      }
      str = str.substring(3);
      if (str != null)
      {
        char[] arrayOfChar = str.toCharArray();
        i1 = i3;
        i2 = i1;
        if (i1 < arrayOfChar.length)
        {
          if (Character.isDigit(arrayOfChar[i1])) {
            break label227;
          }
          i2 = i1;
        }
      }
      i2 = Integer.valueOf(str.substring(0, i2)).intValue();
      i1 = i2;
      if (i2 < 0) {
        i1 = this.d.d;
      }
      locala.d = i1;
    }
    catch (Exception localException)
    {
      int i1;
      for (;;) {}
    }
    if ((paramCellLocation instanceof GsmCellLocation))
    {
      locala.a = ((GsmCellLocation)paramCellLocation).getLac();
      locala.b = ((GsmCellLocation)paramCellLocation).getCid();
      locala.e = 'g';
    }
    for (;;)
    {
      if (a.a(locala))
      {
        this.d = locala;
        return;
        label227:
        i1 += 1;
        break;
        if (!(paramCellLocation instanceof CdmaCellLocation)) {
          continue;
        }
        locala.e = 'c';
        if (h == null) {}
        try
        {
          h = Class.forName("android.telephony.cdma.CdmaCellLocation");
          e = h.getMethod("getBaseStationId", new Class[0]);
          f = h.getMethod("getNetworkId", new Class[0]);
          g = h.getMethod("getSystemId", new Class[0]);
          if ((h != null) && (h.isInstance(paramCellLocation)))
          {
            try
            {
              i2 = ((Integer)g.invoke(paramCellLocation, new Object[0])).intValue();
              i1 = i2;
              if (i2 < 0) {
                i1 = this.d.d;
              }
              locala.d = i1;
              locala.b = ((Integer)e.invoke(paramCellLocation, new Object[0])).intValue();
              locala.a = ((Integer)f.invoke(paramCellLocation, new Object[0])).intValue();
            }
            catch (Exception paramCellLocation)
            {
              return;
            }
            this.d = null;
          }
        }
        catch (Exception paramCellLocation)
        {
          h = null;
          return;
        }
      }
    }
  }
  
  public String a()
  {
    String str = null;
    try
    {
      WifiInfo localWifiInfo = this.i.getConnectionInfo();
      if (localWifiInfo != null) {
        str = localWifiInfo.getMacAddress();
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String b()
  {
    try
    {
      String str = a(15);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void c()
  {
    if (this.n == null) {}
    while ((this.d == null) || (this.d.a() != 1) || (0 != 0)) {
      return;
    }
    this.a.a(this.n);
  }
  
  private class a
  {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public char e = '\000';
    
    private a() {}
    
    private boolean c()
    {
      return (this.a > -1) && (this.b > 0);
    }
    
    public int a()
    {
      int j = 2;
      int i = j;
      if (this.c > 0)
      {
        i = j;
        if (c())
        {
          if ((this.c != 460) && (this.c != 454) && (this.c != 455) && (this.c != 466)) {
            break label64;
          }
          i = 1;
        }
      }
      return i;
      label64:
      return 0;
    }
    
    public String b()
    {
      if (!c()) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append("&nw=");
      localStringBuffer.append(this.e);
      localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      return localStringBuffer.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onReceiveLocation(BDLocation paramBDLocation);
  }
  
  class c
    extends e
  {
    String a = null;
    
    c()
    {
      this.k = new HashMap();
    }
    
    public void a()
    {
      this.h = j.c();
      Object localObject = Jni.encodeTp4(this.a);
      this.a = null;
      this.k.put("bloc", localObject);
      localObject = new StringBuffer(512);
      if (b.a(b.this) != null) {
        ((StringBuffer)localObject).append(String.format(Locale.CHINA, "&ki=%s", new Object[] { b.a(b.this) }));
      }
      if (((StringBuffer)localObject).length() > 0) {
        this.k.put("ext", Jni.encode(((StringBuffer)localObject).toString()));
      }
      localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.k.put("trtm", localObject);
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
      e();
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.j != null)) {}
      for (;;)
      {
        try
        {
          localObject = this.j;
        }
        catch (Exception localException2)
        {
          Object localObject;
          BDLocation localBDLocation;
          continue;
        }
        try
        {
          localObject = new BDLocation((String)localObject);
          if ((localObject != null) && (((BDLocation)localObject).getLocType() == 161))
          {
            ((BDLocation)localObject).setCoorType(b.b(b.this).coorType);
            b.c(b.this).onReceiveLocation((BDLocation)localObject);
          }
          if (this.k != null) {
            this.k.clear();
          }
          return;
        }
        catch (Exception localException1)
        {
          localBDLocation = new BDLocation();
          localBDLocation.setLocType(63);
        }
      }
    }
  }
  
  protected class d
  {
    public List<ScanResult> a = null;
    private long c = 0L;
    
    public d()
    {
      List localList;
      this.a = localList;
      this.c = System.currentTimeMillis();
      b();
    }
    
    private void b()
    {
      if (a() < 1) {
        return;
      }
      int j = this.a.size() - 1;
      int i = 1;
      label23:
      int k;
      if ((j >= 1) && (i != 0))
      {
        k = 0;
        i = 0;
        label36:
        if (k < j)
        {
          if (((ScanResult)this.a.get(k)).level >= ((ScanResult)this.a.get(k + 1)).level) {
            break label147;
          }
          ScanResult localScanResult = (ScanResult)this.a.get(k + 1);
          this.a.set(k + 1, this.a.get(k));
          this.a.set(k, localScanResult);
          i = 1;
        }
      }
      label147:
      for (;;)
      {
        k += 1;
        break label36;
        j -= 1;
        break label23;
        break;
      }
    }
    
    public int a()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public String a(int paramInt)
    {
      if (a() < 2) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer(512);
      int i1 = this.a.size();
      int k = 0;
      int j = 0;
      int m;
      for (int i = 1;; i = m)
      {
        m = i;
        if (k >= i1) {
          break label208;
        }
        if (((ScanResult)this.a.get(k)).level != 0) {
          break;
        }
        m = i;
        k += 1;
      }
      if (i != 0)
      {
        localStringBuffer.append("&wf=");
        i = 0;
      }
      for (;;)
      {
        localStringBuffer.append(((ScanResult)this.a.get(k)).BSSID.replace(":", ""));
        int n = ((ScanResult)this.a.get(k)).level;
        m = n;
        if (n < 0) {
          m = -n;
        }
        localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(m) }));
        n = j + 1;
        j = n;
        m = i;
        if (n <= paramInt) {
          break;
        }
        m = i;
        label208:
        if (m == 0) {
          break label226;
        }
        return null;
        localStringBuffer.append("|");
      }
      label226:
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */