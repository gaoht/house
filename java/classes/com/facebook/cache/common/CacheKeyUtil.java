package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class CacheKeyUtil
{
  public static String getFirstResourceId(CacheKey paramCacheKey)
  {
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey)) {
        return secureHashKey((CacheKey)((MultiCacheKey)paramCacheKey).getCacheKeys().get(0));
      }
      paramCacheKey = secureHashKey(paramCacheKey);
      return paramCacheKey;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
      throw new RuntimeException(paramCacheKey);
    }
  }
  
  public static List<String> getResourceIds(CacheKey paramCacheKey)
  {
    ArrayList localArrayList;
    try
    {
      if ((paramCacheKey instanceof MultiCacheKey))
      {
        paramCacheKey = ((MultiCacheKey)paramCacheKey).getCacheKeys();
        localArrayList = new ArrayList(paramCacheKey.size());
        int i = 0;
        while (i < paramCacheKey.size())
        {
          localArrayList.add(secureHashKey((CacheKey)paramCacheKey.get(i)));
          i += 1;
        }
      }
      localArrayList = new ArrayList(1);
      localArrayList.add(secureHashKey(paramCacheKey));
      return localArrayList;
    }
    catch (UnsupportedEncodingException paramCacheKey)
    {
      throw new RuntimeException(paramCacheKey);
    }
    return localArrayList;
  }
  
  private static String secureHashKey(CacheKey paramCacheKey)
    throws UnsupportedEncodingException
  {
    return SecureHashUtil.makeSHA1HashBase64(paramCacheKey.getUriString().getBytes("UTF-8"));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/common/CacheKeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */