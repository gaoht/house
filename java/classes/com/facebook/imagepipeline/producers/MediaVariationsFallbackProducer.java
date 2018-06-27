package com.facebook.imagepipeline.producers;

import b.h;
import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.MediaVariations;
import com.facebook.imagepipeline.request.MediaVariations.Variant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaVariationsFallbackProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String EXTRA_CACHED_VALUE_USED_AS_LAST = "cached_value_used_as_last";
  @VisibleForTesting
  static final String PRODUCER_NAME = "MediaVariationsFallbackProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final Producer<EncodedImage> mInputProducer;
  private final MediaVariationsIndex mMediaVariationsIndex;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public MediaVariationsFallbackProducer(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, MediaVariationsIndex paramMediaVariationsIndex, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mMediaVariationsIndex = paramMediaVariationsIndex;
    this.mInputProducer = paramProducer;
  }
  
  private j chooseFromVariants(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, MediaVariations paramMediaVariations, List<MediaVariations.Variant> paramList, ImageRequest paramImageRequest, ResizeOptions paramResizeOptions, AtomicBoolean paramAtomicBoolean)
  {
    BufferedDiskCache localBufferedDiskCache;
    Object localObject1;
    Object localObject2;
    int i;
    label34:
    Object localObject3;
    if (paramImageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL)
    {
      localBufferedDiskCache = this.mSmallImageBufferedDiskCache;
      Object localObject4 = paramProducerContext.getCallerContext();
      localObject1 = null;
      localObject2 = null;
      i = 0;
      if (i >= paramList.size()) {
        break label140;
      }
      MediaVariations.Variant localVariant = (MediaVariations.Variant)paramList.get(i);
      localObject3 = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, localVariant.getUri(), localObject4);
      if ((!localBufferedDiskCache.containsSync((CacheKey)localObject3)) || (!isCloserToRequest(localVariant, (MediaVariations.Variant)localObject1, paramResizeOptions))) {
        break label212;
      }
      localObject2 = localVariant;
      localObject1 = localObject3;
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label34;
      localBufferedDiskCache = this.mDefaultBufferedDiskCache;
      break;
      label140:
      boolean bool;
      if (localObject2 == null)
      {
        paramMediaVariations = j.forResult(null);
        bool = false;
      }
      for (;;)
      {
        return paramMediaVariations.continueWith(onFinishDiskReads(paramConsumer, paramProducerContext, bool));
        paramList = localBufferedDiskCache.get((CacheKey)localObject2, paramAtomicBoolean);
        if ((!paramMediaVariations.shouldForceRequestForSpecifiedUri()) && (isBigEnoughForRequestedSize((MediaVariations.Variant)localObject1, paramResizeOptions)))
        {
          bool = true;
          paramMediaVariations = paramList;
        }
        else
        {
          bool = false;
          paramMediaVariations = paramList;
        }
      }
      label212:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  @VisibleForTesting
  static Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramProducerListener.requiresExtraMap(paramString)) {
      return null;
    }
    if (paramBoolean1) {
      return ImmutableMap.of("cached_value_found", String.valueOf(true), "cached_value_used_as_last", String.valueOf(paramBoolean2));
    }
    return ImmutableMap.of("cached_value_found", String.valueOf(false));
  }
  
  private static boolean isBigEnoughForRequestedSize(MediaVariations.Variant paramVariant, ResizeOptions paramResizeOptions)
  {
    return (paramVariant.getWidth() >= paramResizeOptions.width) && (paramVariant.getHeight() >= paramResizeOptions.height);
  }
  
  private static boolean isCloserToRequest(MediaVariations.Variant paramVariant1, MediaVariations.Variant paramVariant2, ResizeOptions paramResizeOptions)
  {
    if (paramVariant2 == null) {}
    do
    {
      do
      {
        return true;
        if (!isBigEnoughForRequestedSize(paramVariant2, paramResizeOptions)) {
          break;
        }
      } while ((paramVariant1.getWidth() < paramVariant2.getWidth()) && (isBigEnoughForRequestedSize(paramVariant1, paramResizeOptions)));
      return false;
    } while (paramVariant1.getWidth() > paramVariant2.getWidth());
    return false;
  }
  
  private static boolean isTaskCancelled(j<?> paramj)
  {
    return (paramj.isCancelled()) || ((paramj.isFaulted()) && ((paramj.getError() instanceof CancellationException)));
  }
  
  private h<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext, final boolean paramBoolean)
  {
    final String str = paramProducerContext.getId();
    new h()
    {
      public Void then(j<EncodedImage> paramAnonymousj)
        throws Exception
      {
        int i = 1;
        if (MediaVariationsFallbackProducer.isTaskCancelled(paramAnonymousj))
        {
          this.val$listener.onProducerFinishWithCancellation(str, "MediaVariationsFallbackProducer", null);
          paramConsumer.onCancellation();
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            MediaVariationsFallbackProducer.this.startInputProducer(paramConsumer, paramProducerContext);
          }
          return null;
          if (paramAnonymousj.isFaulted())
          {
            this.val$listener.onProducerFinishWithFailure(str, "MediaVariationsFallbackProducer", paramAnonymousj.getError(), null);
            MediaVariationsFallbackProducer.this.startInputProducer(paramConsumer, paramProducerContext);
          }
          else
          {
            paramAnonymousj = (EncodedImage)paramAnonymousj.getResult();
            if (paramAnonymousj != null)
            {
              this.val$listener.onProducerFinishWithSuccess(str, "MediaVariationsFallbackProducer", MediaVariationsFallbackProducer.getExtraMap(this.val$listener, str, true, paramBoolean));
              if (paramBoolean) {
                paramConsumer.onProgressUpdate(1.0F);
              }
              paramConsumer.onNewResult(paramAnonymousj, paramBoolean);
              paramAnonymousj.close();
              if (!paramBoolean) {}
              for (i = 1;; i = 0) {
                break;
              }
            }
            this.val$listener.onProducerFinishWithSuccess(str, "MediaVariationsFallbackProducer", MediaVariationsFallbackProducer.getExtraMap(this.val$listener, str, false, false));
          }
        }
      }
    };
  }
  
  private void startInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new MediaVariationsConsumer(paramConsumer, paramProducerContext), paramProducerContext);
  }
  
  private void subscribeTaskForRequestCancellation(final AtomicBoolean paramAtomicBoolean, ProducerContext paramProducerContext)
  {
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramAtomicBoolean.set(true);
      }
    });
  }
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext)
  {
    final ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    final ResizeOptions localResizeOptions = localImageRequest.getResizeOptions();
    final MediaVariations localMediaVariations = localImageRequest.getMediaVariations();
    if ((!localImageRequest.isDiskCacheEnabled()) || (localResizeOptions == null) || (localResizeOptions.height <= 0) || (localResizeOptions.width <= 0) || (localMediaVariations == null))
    {
      startInputProducer(paramConsumer, paramProducerContext);
      return;
    }
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "MediaVariationsFallbackProducer");
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    if (localMediaVariations.getVariants() != null) {
      chooseFromVariants(paramConsumer, paramProducerContext, localMediaVariations, localMediaVariations.getVariants(), localImageRequest, localResizeOptions, localAtomicBoolean);
    }
    for (;;)
    {
      subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
      return;
      this.mMediaVariationsIndex.getCachedVariants(localMediaVariations.getMediaId()).continueWith(new h()
      {
        public Object then(j<List<MediaVariations.Variant>> paramAnonymousj)
          throws Exception
        {
          if ((paramAnonymousj.isCancelled()) || (paramAnonymousj.isFaulted())) {
            return paramAnonymousj;
          }
          try
          {
            if ((paramAnonymousj.getResult() == null) || (((List)paramAnonymousj.getResult()).isEmpty()))
            {
              MediaVariationsFallbackProducer.this.startInputProducer(paramConsumer, paramProducerContext);
              return null;
            }
            paramAnonymousj = MediaVariationsFallbackProducer.this.chooseFromVariants(paramConsumer, paramProducerContext, localMediaVariations, (List)paramAnonymousj.getResult(), localImageRequest, localResizeOptions, localAtomicBoolean);
            return paramAnonymousj;
          }
          catch (Exception paramAnonymousj) {}
          return null;
        }
      });
    }
  }
  
  @VisibleForTesting
  class MediaVariationsConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final ProducerContext mProducerContext;
    
    public MediaVariationsConsumer(ProducerContext paramProducerContext)
    {
      super();
      ProducerContext localProducerContext;
      this.mProducerContext = localProducerContext;
    }
    
    private void storeResultInDatabase(EncodedImage paramEncodedImage)
    {
      Object localObject = this.mProducerContext.getImageRequest();
      MediaVariations localMediaVariations = ((ImageRequest)localObject).getMediaVariations();
      if ((!((ImageRequest)localObject).isDiskCacheEnabled()) || (localMediaVariations == null)) {
        return;
      }
      localObject = MediaVariationsFallbackProducer.this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject, this.mProducerContext.getCallerContext());
      MediaVariationsFallbackProducer.this.mMediaVariationsIndex.saveCachedVariant(localMediaVariations.getMediaId(), (CacheKey)localObject, paramEncodedImage);
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramBoolean) && (paramEncodedImage != null)) {
        storeResultInDatabase(paramEncodedImage);
      }
      getConsumer().onNewResult(paramEncodedImage, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/MediaVariationsFallbackProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */