package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.cache.DiskCachePolicy;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class DiskCacheWriteProducer
  implements Producer<EncodedImage>
{
  private final DiskCachePolicy mDiskCachePolicy;
  private final Producer<EncodedImage> mInputProducer;
  
  public DiskCacheWriteProducer(Producer<EncodedImage> paramProducer, DiskCachePolicy paramDiskCachePolicy)
  {
    this.mInputProducer = paramProducer;
    this.mDiskCachePolicy = paramDiskCachePolicy;
  }
  
  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramConsumer.onNewResult(null, true);
      return;
    }
    Object localObject = paramConsumer;
    if (paramProducerContext.getImageRequest().isDiskCacheEnabled()) {
      localObject = new DiskCacheWriteConsumer(paramConsumer, paramProducerContext, this.mDiskCachePolicy, null);
    }
    this.mInputProducer.produceResults((Consumer)localObject, paramProducerContext);
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    maybeStartInputProducer(paramConsumer, paramProducerContext);
  }
  
  private static class DiskCacheWriteConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final DiskCachePolicy mDiskCachePolicy;
    private final ProducerContext mProducerContext;
    
    private DiskCacheWriteConsumer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, DiskCachePolicy paramDiskCachePolicy)
    {
      super();
      this.mProducerContext = paramProducerContext;
      this.mDiskCachePolicy = paramDiskCachePolicy;
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramEncodedImage != null) && (paramBoolean)) {
        this.mDiskCachePolicy.writeToCache(paramEncodedImage, this.mProducerContext.getImageRequest(), this.mProducerContext.getCallerContext());
      }
      getConsumer().onNewResult(paramEncodedImage, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/DiskCacheWriteProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */