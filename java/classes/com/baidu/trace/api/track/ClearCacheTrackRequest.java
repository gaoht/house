package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;
import java.util.List;

public final class ClearCacheTrackRequest
  extends BaseRequest
{
  private List<String> a = null;
  private List<CacheTrackInfo> b = null;
  
  public ClearCacheTrackRequest() {}
  
  public ClearCacheTrackRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public ClearCacheTrackRequest(int paramInt, long paramLong, List<String> paramList)
  {
    super(paramInt, paramLong);
    this.a = paramList;
  }
  
  public final List<CacheTrackInfo> getCacheTrackInfos()
  {
    return this.b;
  }
  
  public final List<String> getEntityNames()
  {
    return this.a;
  }
  
  public final void setCacheTrackInfos(List<CacheTrackInfo> paramList)
  {
    this.b = paramList;
  }
  
  public final void setEntityNames(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ClearCacheTrackRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", entityNames=").append(this.a);
    localStringBuffer.append(", cacheTrackInfos=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/ClearCacheTrackRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */