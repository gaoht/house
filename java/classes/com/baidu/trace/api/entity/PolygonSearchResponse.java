package com.baidu.trace.api.entity;

import java.util.List;

public final class PolygonSearchResponse
  extends CommonResponse
{
  public PolygonSearchResponse() {}
  
  public PolygonSearchResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public PolygonSearchResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, List<EntityInfo> paramList)
  {
    super(paramInt1, paramInt2, paramString, paramInt3, paramInt4, paramList);
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PolygonSearchResponse{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", status=").append(this.status);
    localStringBuffer.append(", message='").append(this.message).append('\'');
    localStringBuffer.append(", total=").append(this.a);
    localStringBuffer.append(", size=").append(this.b);
    localStringBuffer.append(", entities=").append(this.c);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/PolygonSearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */