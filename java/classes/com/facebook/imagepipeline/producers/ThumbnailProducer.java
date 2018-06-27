package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

public abstract interface ThumbnailProducer<T>
  extends Producer<T>
{
  public abstract boolean canProvideImageForSize(ResizeOptions paramResizeOptions);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/ThumbnailProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */