package com.facebook.imagepipeline.producers;

import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.MediaVariations.Variant;
import java.util.List;

public abstract interface MediaVariationsIndex
{
  public abstract j<List<MediaVariations.Variant>> getCachedVariants(String paramString);
  
  public abstract void saveCachedVariant(String paramString, CacheKey paramCacheKey, EncodedImage paramEncodedImage);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/MediaVariationsIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */