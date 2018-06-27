package com.facebook.cache.common;

import android.net.Uri;

public abstract interface CacheKey
{
  public abstract boolean containsUri(Uri paramUri);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract String getUriString();
  
  public abstract int hashCode();
  
  public abstract String toString();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/CacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */