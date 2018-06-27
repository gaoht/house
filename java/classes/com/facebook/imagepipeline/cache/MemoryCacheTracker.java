package com.facebook.imagepipeline.cache;

public abstract interface MemoryCacheTracker<K>
{
  public abstract void onCacheHit(K paramK);
  
  public abstract void onCacheMiss();
  
  public abstract void onCachePut();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/MemoryCacheTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */