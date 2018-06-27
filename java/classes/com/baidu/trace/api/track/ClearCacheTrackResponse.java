package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseResponse;

public final class ClearCacheTrackResponse
  extends BaseResponse
{
  public ClearCacheTrackResponse() {}
  
  public ClearCacheTrackResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public ClearCacheTrackResponse(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public final String toString()
  {
    return "ClearCacheTrackResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/ClearCacheTrackResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */