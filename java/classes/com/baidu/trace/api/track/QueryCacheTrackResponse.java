package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class QueryCacheTrackResponse
  extends BaseResponse
{
  private List<CacheTrackInfo> a;
  
  public QueryCacheTrackResponse() {}
  
  public QueryCacheTrackResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public final List<CacheTrackInfo> getResult()
  {
    return this.a;
  }
  
  public final void setResult(List<CacheTrackInfo> paramList)
  {
    this.a = paramList;
  }
  
  public final String toString()
  {
    return "QueryCacheTrackResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", result=" + this.a + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/QueryCacheTrackResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */