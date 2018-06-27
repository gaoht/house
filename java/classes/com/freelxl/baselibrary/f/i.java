package com.freelxl.baselibrary.f;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

public class i
  implements Supplier<MemoryCacheParams>
{
  private final ActivityManager a;
  
  public i(ActivityManager paramActivityManager)
  {
    this.a = paramActivityManager;
  }
  
  private int a()
  {
    int j = 16777216;
    int k = Math.min(this.a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
    d.e("maxMemory", k + "MB");
    int i;
    if (k < 33554432) {
      i = 4194304;
    }
    do
    {
      do
      {
        return i;
        if (k < 67108864) {
          return 6291456;
        }
        if (k < 134217728) {
          return 8388608;
        }
        i = j;
      } while (k < 268435456);
      i = j;
    } while (k < 536870912);
    return k / 4;
  }
  
  public MemoryCacheParams get()
  {
    return new MemoryCacheParams(a(), 32, 4194304, 5, 1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */