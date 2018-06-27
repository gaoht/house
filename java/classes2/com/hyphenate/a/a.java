package com.hyphenate.a;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import com.hyphenate.util.EMLog;

@SuppressLint({"NewApi"})
public class a
{
  static final String a = "net";
  protected static a b = null;
  static long c = 0L;
  static long d = 0L;
  static long e = 0L;
  static long f = 0L;
  static long g = 0L;
  static long h = 0L;
  static long i = 0L;
  static long j = 0L;
  static long k;
  static long l;
  static long m = 0L;
  static long n = 0L;
  static long o = 0L;
  static long p = 0L;
  static long q = 0L;
  static long r = 0L;
  static int s;
  static long t = 0L;
  static long u = 0L;
  static boolean v = false;
  
  public static void a()
  {
    s = Process.myUid();
    b();
    v = true;
  }
  
  public static void b()
  {
    c = TrafficStats.getUidRxBytes(s);
    d = TrafficStats.getUidTxBytes(s);
    if (Build.VERSION.SDK_INT >= 12) {
      e = TrafficStats.getUidRxPackets(s);
    }
    for (f = TrafficStats.getUidTxPackets(s);; f = 0L)
    {
      k = 0L;
      l = 0L;
      m = 0L;
      n = 0L;
      o = 0L;
      p = 0L;
      q = 0L;
      r = 0L;
      u = System.currentTimeMillis();
      t = System.currentTimeMillis();
      return;
      e = 0L;
    }
  }
  
  public static void c()
  {
    v = false;
    b();
  }
  
  public static void d()
  {
    if (!v) {
      return;
    }
    Long localLong = Long.valueOf(System.currentTimeMillis());
    long l2 = (localLong.longValue() - t) / 1000L;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    o = TrafficStats.getUidRxBytes(s);
    p = TrafficStats.getUidTxBytes(s);
    k = o - c;
    l = p - d;
    g += k;
    h += l;
    if (Build.VERSION.SDK_INT >= 12)
    {
      q = TrafficStats.getUidRxPackets(s);
      r = TrafficStats.getUidTxPackets(s);
      m = q - e;
      n = r - f;
      i += m;
      j += n;
    }
    if ((k != 0L) || (l != 0L))
    {
      EMLog.d("net", l + " bytes send; " + k + " bytes received in " + l1 + " sec");
      if ((Build.VERSION.SDK_INT >= 12) && (n > 0L)) {
        EMLog.d("net", n + " packets send; " + m + " packets received in " + l1 + " sec");
      }
      EMLog.d("net", "total:" + h + " bytes send; " + g + " bytes received");
      if ((Build.VERSION.SDK_INT >= 12) && (j > 0L))
      {
        l1 = (System.currentTimeMillis() - u) / 1000L;
        EMLog.d("net", "total:" + j + " packets send; " + i + " packets received in " + l1);
      }
      c = o;
      d = p;
      e = q;
      f = r;
      t = localLong.longValue();
      return;
    }
    EMLog.d("net", "no network traffice");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */