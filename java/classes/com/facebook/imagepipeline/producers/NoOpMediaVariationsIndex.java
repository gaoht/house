package com.facebook.imagepipeline.producers;

import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.MediaVariations.Variant;
import java.util.List;

public class NoOpMediaVariationsIndex
  implements MediaVariationsIndex
{
  public j<List<MediaVariations.Variant>> getCachedVariants(String paramString)
  {
    return j.forResult(null);
  }
  
  public void saveCachedVariant(String paramString, CacheKey paramCacheKey, EncodedImage paramEncodedImage) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/NoOpMediaVariationsIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */