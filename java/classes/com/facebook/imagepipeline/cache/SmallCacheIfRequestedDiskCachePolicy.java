package com.facebook.imagepipeline.cache;

import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmallCacheIfRequestedDiskCachePolicy
  implements DiskCachePolicy
{
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public SmallCacheIfRequestedDiskCachePolicy(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }
  
  public j<EncodedImage> createAndStartCacheReadTask(ImageRequest paramImageRequest, Object paramObject, AtomicBoolean paramAtomicBoolean)
  {
    paramObject = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    if (paramImageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
      return this.mSmallImageBufferedDiskCache.get((CacheKey)paramObject, paramAtomicBoolean);
    }
    return this.mDefaultBufferedDiskCache.get((CacheKey)paramObject, paramAtomicBoolean);
  }
  
  public void writeToCache(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, Object paramObject)
  {
    paramObject = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    if (paramImageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL)
    {
      this.mSmallImageBufferedDiskCache.put((CacheKey)paramObject, paramEncodedImage);
      return;
    }
    this.mDefaultBufferedDiskCache.put((CacheKey)paramObject, paramEncodedImage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/SmallCacheIfRequestedDiskCachePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */