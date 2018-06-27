package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class EncodedMemoryCacheProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<EncodedImage> mInputProducer;
  private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
  
  public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject1 = null;
    EncodedImage localEncodedImage = null;
    EncodedMemoryCacheConsumer localEncodedMemoryCacheConsumer = null;
    String str = paramProducerContext.getId();
    ProducerListener localProducerListener = paramProducerContext.getListener();
    localProducerListener.onProducerStart(str, "EncodedMemoryCacheProducer");
    Object localObject2 = paramProducerContext.getImageRequest();
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject2, paramProducerContext.getCallerContext());
    localObject2 = this.mMemoryCache.get(localCacheKey);
    if (localObject2 != null) {
      try
      {
        localEncodedImage = new EncodedImage((CloseableReference)localObject2);
        localEncodedImage.setEncodedCacheKey(localCacheKey);
        paramProducerContext = localEncodedMemoryCacheConsumer;
        try
        {
          if (localProducerListener.requiresExtraMap(str)) {
            paramProducerContext = ImmutableMap.of("cached_value_found", "true");
          }
          localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramProducerContext);
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(localEncodedImage, true);
          EncodedImage.closeSafely(localEncodedImage);
          return;
        }
        finally
        {
          EncodedImage.closeSafely(localEncodedImage);
        }
        if (paramProducerContext.getLowestPermittedRequestLevel().getValue() < ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
          break label242;
        }
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject2);
      }
    }
    paramProducerContext = (ProducerContext)localObject1;
    if (localProducerListener.requiresExtraMap(str)) {
      paramProducerContext = ImmutableMap.of("cached_value_found", "false");
    }
    localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramProducerContext);
    paramConsumer.onNewResult(null, true);
    CloseableReference.closeSafely((CloseableReference)localObject2);
    return;
    label242:
    localEncodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(paramConsumer, this.mMemoryCache, localCacheKey);
    paramConsumer = localEncodedImage;
    if (localProducerListener.requiresExtraMap(str)) {
      paramConsumer = ImmutableMap.of("cached_value_found", "false");
    }
    localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramConsumer);
    this.mInputProducer.produceResults(localEncodedMemoryCacheConsumer, paramProducerContext);
    CloseableReference.closeSafely((CloseableReference)localObject2);
  }
  
  private static class EncodedMemoryCacheConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
    private final CacheKey mRequestedCacheKey;
    
    public EncodedMemoryCacheConsumer(Consumer<EncodedImage> paramConsumer, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKey paramCacheKey)
    {
      super();
      this.mMemoryCache = paramMemoryCache;
      this.mRequestedCacheKey = paramCacheKey;
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((!paramBoolean) || (paramEncodedImage == null))
      {
        getConsumer().onNewResult(paramEncodedImage, paramBoolean);
        return;
      }
      Object localObject2 = paramEncodedImage.getByteBufferRef();
      Object localObject1;
      if (localObject2 != null) {
        for (;;)
        {
          try
          {
            if (paramEncodedImage.getEncodedCacheKey() != null)
            {
              localObject1 = paramEncodedImage.getEncodedCacheKey();
              localObject1 = this.mMemoryCache.cache(localObject1, (CloseableReference)localObject2);
              CloseableReference.closeSafely((CloseableReference)localObject2);
              if (localObject1 == null) {
                break label144;
              }
            }
          }
          finally
          {
            CloseableReference.closeSafely((CloseableReference)localObject2);
          }
          try
          {
            localObject2 = new EncodedImage((CloseableReference)localObject1);
            ((EncodedImage)localObject2).copyMetaDataFrom(paramEncodedImage);
            CloseableReference.closeSafely((CloseableReference)localObject1);
          }
          finally
          {
            CloseableReference.closeSafely((CloseableReference)localObject1);
          }
          try
          {
            getConsumer().onProgressUpdate(1.0F);
            getConsumer().onNewResult(localObject2, true);
            EncodedImage.closeSafely((EncodedImage)localObject2);
            return;
          }
          finally
          {
            EncodedImage.closeSafely((EncodedImage)localObject2);
          }
          localObject1 = this.mRequestedCacheKey;
        }
      }
      label144:
      getConsumer().onNewResult(paramEncodedImage, true);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */