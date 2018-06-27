package com.xiaomi.mipush.sdk;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class e
  implements Comparator<ScanResult>
{
  e(d paramd) {}
  
  public int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
  {
    return paramScanResult2.level - paramScanResult1.level;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */