package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

public class NativeMemoryCacheTrimStrategy
  implements CountingMemoryCache.CacheTrimStrategy
{
  private static final String TAG = "NativeMemoryCacheTrimStrategy";
  
  public double getTrimRatio(MemoryTrimType paramMemoryTrimType)
  {
    switch (paramMemoryTrimType)
    {
    default: 
      FLog.wtf("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] { paramMemoryTrimType });
    case ???: 
      return 0.0D;
    }
    return 1.0D;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/NativeMemoryCacheTrimStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */