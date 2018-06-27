package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheErrorLogger
  implements CacheErrorLogger
{
  private static NoOpCacheErrorLogger sInstance = null;
  
  public static NoOpCacheErrorLogger getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpCacheErrorLogger();
      }
      NoOpCacheErrorLogger localNoOpCacheErrorLogger = sInstance;
      return localNoOpCacheErrorLogger;
    }
    finally {}
  }
  
  public void logError(CacheErrorLogger.CacheErrorCategory paramCacheErrorCategory, Class<?> paramClass, String paramString, @Nullable Throwable paramThrowable) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/NoOpCacheErrorLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */