package com.facebook.cache.common;

import javax.annotation.Nullable;

public class DebuggingCacheKey
  extends SimpleCacheKey
{
  private final Object mCallerContext;
  
  public DebuggingCacheKey(String paramString, @Nullable Object paramObject)
  {
    super(paramString);
    this.mCallerContext = paramObject;
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/DebuggingCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */