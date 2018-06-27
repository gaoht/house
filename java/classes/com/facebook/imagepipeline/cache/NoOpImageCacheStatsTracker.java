package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public class NoOpImageCacheStatsTracker
  implements ImageCacheStatsTracker
{
  private static NoOpImageCacheStatsTracker sInstance = null;
  
  public static NoOpImageCacheStatsTracker getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpImageCacheStatsTracker();
      }
      NoOpImageCacheStatsTracker localNoOpImageCacheStatsTracker = sInstance;
      return localNoOpImageCacheStatsTracker;
    }
    finally {}
  }
  
  public void onBitmapCacheHit(CacheKey paramCacheKey) {}
  
  public void onBitmapCacheMiss() {}
  
  public void onBitmapCachePut() {}
  
  public void onDiskCacheGetFail() {}
  
  public void onDiskCacheHit() {}
  
  public void onDiskCacheMiss() {}
  
  public void onMemoryCacheHit(CacheKey paramCacheKey) {}
  
  public void onMemoryCacheMiss() {}
  
  public void onMemoryCachePut() {}
  
  public void onStagingAreaHit(CacheKey paramCacheKey) {}
  
  public void onStagingAreaMiss() {}
  
  public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache) {}
  
  public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/NoOpImageCacheStatsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */