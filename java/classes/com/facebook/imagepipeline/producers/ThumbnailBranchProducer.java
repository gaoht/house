package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class ThumbnailBranchProducer
  implements Producer<EncodedImage>
{
  private final ThumbnailProducer<EncodedImage>[] mThumbnailProducers;
  
  public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... paramVarArgs)
  {
    this.mThumbnailProducers = ((ThumbnailProducer[])Preconditions.checkNotNull(paramVarArgs));
    Preconditions.checkElementIndex(0, this.mThumbnailProducers.length);
  }
  
  private int findFirstProducerForSize(int paramInt, ResizeOptions paramResizeOptions)
  {
    while (paramInt < this.mThumbnailProducers.length)
    {
      if (this.mThumbnailProducers[paramInt].canProvideImageForSize(paramResizeOptions)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private boolean produceResultsFromThumbnailProducer(int paramInt, Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramInt = findFirstProducerForSize(paramInt, paramProducerContext.getImageRequest().getResizeOptions());
    if (paramInt == -1) {
      return false;
    }
    this.mThumbnailProducers[paramInt].produceResults(new ThumbnailConsumer(paramConsumer, paramProducerContext, paramInt), paramProducerContext);
    return true;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getImageRequest().getResizeOptions() == null) {
      paramConsumer.onNewResult(null, true);
    }
    while (produceResultsFromThumbnailProducer(0, paramConsumer, paramProducerContext)) {
      return;
    }
    paramConsumer.onNewResult(null, true);
  }
  
  private class ThumbnailConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final ProducerContext mProducerContext;
    private final int mProducerIndex;
    private final ResizeOptions mResizeOptions;
    
    public ThumbnailConsumer(ProducerContext paramProducerContext, int paramInt)
    {
      super();
      this.mProducerContext = paramInt;
      int i;
      this.mProducerIndex = i;
      this.mResizeOptions = this.mProducerContext.getImageRequest().getResizeOptions();
    }
    
    protected void onFailureImpl(Throwable paramThrowable)
    {
      if (!ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
        getConsumer().onFailure(paramThrowable);
      }
    }
    
    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramEncodedImage != null) && ((!paramBoolean) || (ThumbnailSizeChecker.isImageBigEnough(paramEncodedImage, this.mResizeOptions)))) {
        getConsumer().onNewResult(paramEncodedImage, paramBoolean);
      }
      do
      {
        do
        {
          return;
        } while (!paramBoolean);
        EncodedImage.closeSafely(paramEncodedImage);
      } while (ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext));
      getConsumer().onNewResult(null, true);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/ThumbnailBranchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */