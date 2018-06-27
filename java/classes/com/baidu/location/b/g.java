package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
{
  public List<ScanResult> a = null;
  private long b = 0L;
  private long c = 0L;
  private boolean d = false;
  private boolean e;
  
  public g(List<ScanResult> paramList, long paramLong)
  {
    this.b = paramLong;
    this.a = paramList;
    this.c = System.currentTimeMillis();
    i();
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("wpa|wep", 2).matcher(paramString).find();
  }
  
  private void i()
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
    return a(paramInt, false);
  }
  
  @SuppressLint({"NewApi"})
  public String a(int paramInt, boolean paramBoolean)
  {
    if (a() < 1) {
      return null;
    }
    int j = 0;
    Object localObject3;
    int n;
    long l2;
    long l3;
    int i;
    int k;
    long l4;
    label161:
    int i2;
    label178:
    int m;
    label209:
    int i4;
    label258:
    int i1;
    for (;;)
    {
      try
      {
        localObject7 = new Random();
        localStringBuffer = new StringBuffer(512);
        localObject6 = new ArrayList();
        localObject3 = h.a().i();
        if ((localObject3 == null) || (((WifiInfo)localObject3).getBSSID() == null)) {
          break label1255;
        }
        Object localObject1 = ((WifiInfo)localObject3).getBSSID().replace(":", "");
        n = ((WifiInfo)localObject3).getRssi();
        localObject3 = h.a().k();
        if (n >= 0) {
          break label1240;
        }
        n = -n;
        Object localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject4;
        l2 = 0L;
        l3 = 0L;
        i = 0;
        k = Build.VERSION.SDK_INT;
        if (k < 17) {
          break label1233;
        }
      }
      catch (Error localError1)
      {
        StringBuffer localStringBuffer;
        return null;
        if ((paramInt != 1) || (((Random)localObject7).nextInt(20) != 1) || (((ScanResult)this.a.get(i4)).SSID == null) || (((ScanResult)this.a.get(i4)).SSID.length() >= 30)) {
          break label1221;
        }
        localStringBuffer.append(((ScanResult)this.a.get(i4)).SSID);
        paramInt = 2;
        continue;
        continue;
        localStringBuffer.append(((ScanResult)this.a.get(i4)).SSID);
        i1 = k;
        break label1284;
        if (j != 0) {
          continue;
        }
        localStringBuffer.append("&wf_n=" + i);
        if ((localObject3 == null) || (n == -1)) {
          continue;
        }
        localStringBuffer.append("&wf_rs=" + n);
        if ((l2 <= 10L) || (((List)localObject6).size() <= 0) || (((Long)((List)localObject6).get(0)).longValue() <= 0L)) {
          continue;
        }
        localObject3 = new StringBuffer(128);
        ((StringBuffer)localObject3).append("&wf_ut=");
        paramInt = 1;
        localObject5 = (Long)((List)localObject6).get(0);
        Object localObject6 = ((List)localObject6).iterator();
        if (!((Iterator)localObject6).hasNext()) {
          continue;
        }
        Object localObject7 = (Long)((Iterator)localObject6).next();
        if (paramInt == 0) {
          continue;
        }
        ((StringBuffer)localObject3).append(((Long)localObject7).longValue());
        paramInt = 0;
        ((StringBuffer)localObject3).append("|");
        continue;
        long l1 = ((Long)localObject7).longValue() - ((Long)localObject5).longValue();
        if (l1 == 0L) {
          break label1302;
        }
        ((StringBuffer)localObject3).append("" + l1);
        break label1302;
        localStringBuffer.append(((StringBuffer)localObject3).toString());
        localStringBuffer.append("&wf_st=");
        localStringBuffer.append(this.b);
        localStringBuffer.append("&wf_et=");
        localStringBuffer.append(this.c);
        localStringBuffer.append("&wf_vt=");
        localStringBuffer.append(h.a);
        if (i <= 0) {
          continue;
        }
        this.d = true;
        localStringBuffer.append("&wf_en=");
        if (!this.e) {
          continue;
        }
        paramInt = 1;
        localStringBuffer.append(paramInt);
        if (localError1 == null) {
          continue;
        }
        localStringBuffer.append("&wf_gw=");
        localStringBuffer.append(localError1);
        str1 = localStringBuffer.toString();
        return str1;
        paramInt = 0;
        continue;
        return null;
      }
      catch (Exception localException1)
      {
        label647:
        return null;
      }
      try
      {
        l1 = SystemClock.elapsedRealtimeNanos() / 1000L;
        l2 = l1;
        if (l1 <= 0L) {
          break label1233;
        }
        i = 1;
        l4 = l1;
        if (i == 0) {
          break label1227;
        }
        if ((i != 0) && (paramBoolean))
        {
          i = 1;
          i2 = i;
          k = 0;
          i = 0;
          int i3 = this.a.size();
          m = 1;
          if (i3 <= paramInt) {
            break label1224;
          }
          i3 = paramInt;
          break label1267;
          if (i4 >= i3) {
            continue;
          }
          m = ((ScanResult)this.a.get(i4)).level;
          if (m != 0) {
            continue;
          }
          m = j;
          j = k;
          l1 = l2;
          k = paramInt;
          paramInt = m;
          i4 += 1;
          m = j;
          j = paramInt;
          paramInt = k;
          k = m;
          l2 = l1;
          continue;
        }
      }
      catch (Error localError2)
      {
        l1 = 0L;
        continue;
        i = 0;
        continue;
        l1 = l2;
        if (i2 == 0) {}
      }
      try
      {
        l3 = (l4 - ((ScanResult)this.a.get(i4)).timestamp) / 1000000L;
        ((List)localObject6).add(Long.valueOf(l3));
        l1 = l2;
        if (l3 > l2) {
          l1 = l3;
        }
        if (j != 0)
        {
          j = 0;
          localStringBuffer.append("&wf=");
          String str2 = ((ScanResult)this.a.get(i4)).BSSID;
          i1 = i;
          m = k;
          if (str2 == null) {
            break label1284;
          }
          str2 = str2.replace(":", "");
          localStringBuffer.append(str2);
          i1 = ((ScanResult)this.a.get(i4)).level;
          m = i1;
          if (i1 < 0) {
            m = -i1;
          }
          localStringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[] { Integer.valueOf(m) }));
          m = k + 1;
          int i5 = 0;
          i1 = i5;
          k = i;
          if (localObject3 != null)
          {
            i1 = i5;
            k = i;
            if (((String)localObject3).equals(str2))
            {
              this.e = a(((ScanResult)this.a.get(i4)).capabilities);
              i1 = 1;
              k = m;
            }
          }
          if (i1 != 0) {
            continue;
          }
          if (paramInt != 0) {
            continue;
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          if ((((Random)localObject7).nextInt(10) != 2) || (((ScanResult)this.a.get(i4)).SSID == null) || (((ScanResult)this.a.get(i4)).SSID.length() >= 30)) {
            break label1221;
          }
          localStringBuffer.append(((ScanResult)this.a.get(i4)).SSID);
          paramInt = 1;
          i = k;
          k = paramInt;
          paramInt = j;
          j = m;
        }
        catch (Exception localException3)
        {
          i = j;
          j = m;
          m = paramInt;
          paramInt = i;
          i = k;
          k = m;
        }
        localException2 = localException2;
        l3 = 0L;
        continue;
        localStringBuffer.append("|");
      }
    }
    label1221:
    label1224:
    label1227:
    label1233:
    label1240:
    label1255:
    label1267:
    label1284:
    label1302:
    for (;;)
    {
      String str1;
      break label647;
      break label1267;
      i2 = i;
      break label178;
      l4 = l2;
      break label161;
      Object localObject5 = localException1;
      Object localObject2 = localObject3;
      localObject3 = localObject5;
      break;
      n = -1;
      localObject2 = null;
      localObject3 = null;
      break;
      i4 = 0;
      paramInt = j;
      j = m;
      l2 = l3;
      break label209;
      i = j;
      j = m;
      k = paramInt;
      paramInt = i;
      i = i1;
      break label258;
    }
  }
  
  public boolean a(g paramg)
  {
    if ((this.a != null) && (paramg != null) && (paramg.a != null))
    {
      int i;
      int j;
      if (this.a.size() < paramg.a.size())
      {
        i = this.a.size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label116;
        }
        if (!((ScanResult)this.a.get(j)).BSSID.equals(((ScanResult)paramg.a.get(j)).BSSID))
        {
          return false;
          i = paramg.a.size();
          break;
        }
        j += 1;
      }
      label116:
      return true;
    }
    return false;
  }
  
  public String b()
  {
    try
    {
      String str = a(j.L, true);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String b(int paramInt)
  {
    int i = 0;
    if ((paramInt == 0) || (a() < 1)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(256);
    int j = this.a.size();
    if (j > j.L) {
      j = j.L;
    }
    for (;;)
    {
      int m = 1;
      int k = 0;
      if (k < j)
      {
        if (((m & paramInt) == 0) || (((ScanResult)this.a.get(k)).BSSID == null)) {
          break label199;
        }
        if (i == 0)
        {
          localStringBuffer.append("&ssid=");
          label101:
          localStringBuffer.append(((ScanResult)this.a.get(k)).BSSID.replace(":", ""));
          localStringBuffer.append(";");
          localStringBuffer.append(((ScanResult)this.a.get(k)).SSID);
          i += 1;
        }
      }
      label199:
      for (;;)
      {
        m <<= 1;
        k += 1;
        break;
        localStringBuffer.append("|");
        break label101;
        return localStringBuffer.toString();
      }
    }
  }
  
  public boolean b(g paramg)
  {
    if ((this.a != null) && (paramg != null) && (paramg.a != null))
    {
      int i;
      int j;
      if (this.a.size() < paramg.a.size())
      {
        i = this.a.size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label167;
        }
        String str1 = ((ScanResult)this.a.get(j)).BSSID;
        int k = ((ScanResult)this.a.get(j)).level;
        String str2 = ((ScanResult)paramg.a.get(j)).BSSID;
        int m = ((ScanResult)paramg.a.get(j)).level;
        if ((!str1.equals(str2)) || (k != m))
        {
          return false;
          i = paramg.a.size();
          break;
        }
        j += 1;
      }
      label167:
      return true;
    }
    return false;
  }
  
  public String c()
  {
    try
    {
      String str = a(15);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean c(g paramg)
  {
    return h.a(paramg, this, j.O);
  }
  
  public int d()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < a())
      {
        j = -((ScanResult)this.a.get(i)).level;
        if (j <= 0) {}
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.c < 5000L);
  }
  
  public boolean g()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.c < 5000L);
  }
  
  public boolean h()
  {
    return (System.currentTimeMillis() - this.c > 0L) && (System.currentTimeMillis() - this.b < 5000L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */