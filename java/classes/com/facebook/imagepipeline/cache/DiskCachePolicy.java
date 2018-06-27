package com.facebook.imagepipeline.cache;

import b.j;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface DiskCachePolicy
{
  public abstract j<EncodedImage> createAndStartCacheReadTask(ImageRequest paramImageRequest, Object paramObject, AtomicBoolean paramAtomicBoolean);
  
  public abstract void writeToCache(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, Object paramObject);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/DiskCachePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */