package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;

public class MultiCacheKey
  implements CacheKey
{
  final List<CacheKey> mCacheKeys;
  
  public MultiCacheKey(List<CacheKey> paramList)
  {
    this.mCacheKeys = ((List)Preconditions.checkNotNull(paramList));
  }
  
  public boolean containsUri(Uri paramUri)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mCacheKeys.size())
      {
        if (((CacheKey)this.mCacheKeys.get(i)).containsUri(paramUri)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof MultiCacheKey))
    {
      paramObject = (MultiCacheKey)paramObject;
      return this.mCacheKeys.equals(((MultiCacheKey)paramObject).mCacheKeys);
    }
    return false;
  }
  
  public List<CacheKey> getCacheKeys()
  {
    return this.mCacheKeys;
  }
  
  public String getUriString()
  {
    return ((CacheKey)this.mCacheKeys.get(0)).getUriString();
  }
  
  public int hashCode()
  {
    return this.mCacheKeys.hashCode();
  }
  
  public String toString()
  {
    return "MultiCacheKey:" + this.mCacheKeys.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/MultiCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */