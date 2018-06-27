package com.facebook.imagepipeline.cache;

import b.h;
import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class SplitCachesByImageSizeDiskCachePolicy
  implements DiskCachePolicy
{
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final int mForceSmallCacheThresholdBytes;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public SplitCachesByImageSizeDiskCachePolicy(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, int paramInt)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mForceSmallCacheThresholdBytes = paramInt;
  }
  
  private static boolean isTaskCancelled(j<?> paramj)
  {
    return (paramj.isCancelled()) || ((paramj.isFaulted()) && ((paramj.getError() instanceof CancellationException)));
  }
  
  public j<EncodedImage> createAndStartCacheReadTask(final ImageRequest paramImageRequest, Object paramObject, final AtomicBoolean paramAtomicBoolean)
  {
    final CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    boolean bool1 = this.mSmallImageBufferedDiskCache.containsSync(localCacheKey);
    boolean bool2 = this.mDefaultBufferedDiskCache.containsSync(localCacheKey);
    if ((bool1) || (!bool2)) {
      paramObject = this.mSmallImageBufferedDiskCache;
    }
    for (paramImageRequest = this.mDefaultBufferedDiskCache;; paramImageRequest = this.mSmallImageBufferedDiskCache)
    {
      ((BufferedDiskCache)paramObject).get(localCacheKey, paramAtomicBoolean).continueWithTask(new h()
      {
        public j<EncodedImage> then(j<EncodedImage> paramAnonymousj)
          throws Exception
        {
          if ((SplitCachesByImageSizeDiskCachePolicy.isTaskCancelled(paramAnonymousj)) || ((!paramAnonymousj.isFaulted()) && (paramAnonymousj.getResult() != null))) {
            return paramAnonymousj;
          }
          return paramImageRequest.get(localCacheKey, paramAtomicBoolean);
        }
      });
      paramObject = this.mDefaultBufferedDiskCache;
    }
  }
  
  public void writeToCache(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, Object paramObject)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    int i = paramEncodedImage.getSize();
    if ((i > 0) && (i < this.mForceSmallCacheThresholdBytes))
    {
      this.mSmallImageBufferedDiskCache.put(paramImageRequest, paramEncodedImage);
      return;
    }
    this.mDefaultBufferedDiskCache.put(paramImageRequest, paramEncodedImage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/SplitCachesByImageSizeDiskCachePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */