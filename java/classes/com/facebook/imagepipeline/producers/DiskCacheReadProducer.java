package com.facebook.imagepipeline.producers;

import b.h;
import b.j;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.DiskCachePolicy;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiskCacheReadProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "DiskCacheProducer";
  private final DiskCachePolicy mDiskCachePolicy;
  private final Producer<EncodedImage> mInputProducer;
  
  public DiskCacheReadProducer(Producer<EncodedImage> paramProducer, DiskCachePolicy paramDiskCachePolicy)
  {
    this.mInputProducer = paramProducer;
    this.mDiskCachePolicy = paramDiskCachePolicy;
  }
  
  @VisibleForTesting
  static Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, boolean paramBoolean)
  {
    if (!paramProducerListener.requiresExtraMap(paramString)) {
      return null;
    }
    return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean));
  }
  
  private static boolean isTaskCancelled(j<?> paramj)
  {
    return (paramj.isCancelled()) || ((paramj.isFaulted()) && ((paramj.getError() instanceof CancellationException)));
  }
  
  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramConsumer.onNewResult(null, true);
      return;
    }
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
  
  private h<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext)
  {
    final String str = paramProducerContext.getId();
    new h()
    {
      public Void then(j<EncodedImage> paramAnonymousj)
        throws Exception
      {
        if (DiskCacheReadProducer.isTaskCancelled(paramAnonymousj))
        {
          this.val$listener.onProducerFinishWithCancellation(str, "DiskCacheProducer", null);
          paramConsumer.onCancellation();
          return null;
        }
        if (paramAnonymousj.isFaulted())
        {
          this.val$listener.onProducerFinishWithFailure(str, "DiskCacheProducer", paramAnonymousj.getError(), null);
          DiskCacheReadProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
          return null;
        }
        paramAnonymousj = (EncodedImage)paramAnonymousj.getResult();
        if (paramAnonymousj != null)
        {
          this.val$listener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(this.val$listener, str, true));
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(paramAnonymousj, true);
          paramAnonymousj.close();
          return null;
        }
        this.val$listener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(this.val$listener, str, false));
        DiskCacheReadProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
        return null;
      }
    };
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
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    if (!localImageRequest.isDiskCacheEnabled())
    {
      maybeStartInputProducer(paramConsumer, paramProducerContext);
      return;
    }
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "DiskCacheProducer");
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    this.mDiskCachePolicy.createAndStartCacheReadTask(localImageRequest, paramProducerContext.getCallerContext(), localAtomicBoolean).continueWith(onFinishDiskReads(paramConsumer, paramProducerContext));
    subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/DiskCacheReadProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */