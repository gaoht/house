package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class BranchOnSeparateImagesProducer
  implements Producer<EncodedImage>
{
  private final Producer<EncodedImage> mInputProducer1;
  private final Producer<EncodedImage> mInputProducer2;
  
  public BranchOnSeparateImagesProducer(Producer<EncodedImage> paramProducer1, Producer<EncodedImage> paramProducer2)
  {
    this.mInputProducer1 = paramProducer1;
    this.mInputProducer2 = paramProducer2;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new OnFirstImageConsumer(paramConsumer, paramProducerContext, null);
    this.mInputProducer1.produceResults(paramConsumer, paramProducerContext);
  }
  
  private class OnFirstImageConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private ProducerContext mProducerContext;
    
    private OnFirstImageConsumer(ProducerContext paramProducerContext)
    {
      super();
      ProducerContext localProducerContext;
      this.mProducerContext = localProducerContext;
    }
    
    protected void onFailureImpl(Throwable paramThrowable)
    {
      BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      Object localObject = this.mProducerContext.getImageRequest();
      boolean bool2 = ThumbnailSizeChecker.isImageBigEnough(paramEncodedImage, ((ImageRequest)localObject).getResizeOptions());
      if ((paramEncodedImage != null) && ((bool2) || (((ImageRequest)localObject).getLocalThumbnailPreviewsEnabled())))
      {
        localObject = getConsumer();
        if ((!paramBoolean) || (!bool2)) {
          break label99;
        }
      }
      label99:
      for (boolean bool1 = true;; bool1 = false)
      {
        ((Consumer)localObject).onNewResult(paramEncodedImage, bool1);
        if ((paramBoolean) && (!bool2))
        {
          EncodedImage.closeSafely(paramEncodedImage);
          BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
        }
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/BranchOnSeparateImagesProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */