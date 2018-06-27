package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;

public final class SearchRequest
  extends CommonRequest
{
  private String f;
  
  public SearchRequest() {}
  
  public SearchRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public SearchRequest(int paramInt1, long paramLong, String paramString, FilterCondition paramFilterCondition, SortBy paramSortBy, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramSortBy, paramCoordType, paramInt2, paramInt3);
    this.f = paramString;
  }
  
  public SearchRequest(int paramInt1, long paramLong, String paramString, FilterCondition paramFilterCondition, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType, paramInt2, paramInt3);
    this.f = paramString;
  }
  
  public final String getKeyword()
  {
    return this.f;
  }
  
  public final void setKeyword(String paramString)
  {
    this.f = paramString;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("SearchRequest{");
    localStringBuffer.append("tag='").append(this.tag);
    localStringBuffer.append(", serviceId='").append(this.serviceId);
    localStringBuffer.append(", keyword='").append(this.f).append('\'');
    localStringBuffer.append(", filterCondition=").append(this.a);
    localStringBuffer.append(", sortBy=").append(this.b);
    localStringBuffer.append(", coordTypeOutput=").append(this.c);
    localStringBuffer.append(", pageIndex=").append(this.d);
    localStringBuffer.append(", pageSize=").append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/SearchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */