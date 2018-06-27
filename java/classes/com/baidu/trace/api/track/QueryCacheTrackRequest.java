package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;

public final class QueryCacheTrackRequest
  extends BaseRequest
{
  private String a;
  
  public QueryCacheTrackRequest() {}
  
  public QueryCacheTrackRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public QueryCacheTrackRequest(int paramInt, long paramLong, String paramString)
  {
    super(paramInt, paramLong);
    this.a = paramString;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    return "QueryCacheTrackRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", entityName=" + this.a + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/QueryCacheTrackRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */