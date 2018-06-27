package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapCountingMemoryCacheFactory
{
  public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PlatformBitmapFactory paramPlatformBitmapFactory, boolean paramBoolean)
  {
    paramSupplier = new CountingMemoryCache(new ValueDescriptor()new BitmapMemoryCacheTrimStrategy
    {
      public int getSizeInBytes(CloseableImage paramAnonymousCloseableImage)
      {
        return paramAnonymousCloseableImage.getSizeInBytes();
      }
    }, new BitmapMemoryCacheTrimStrategy(), paramSupplier, paramPlatformBitmapFactory, paramBoolean);
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(paramSupplier);
    return paramSupplier;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/BitmapCountingMemoryCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */