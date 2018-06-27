package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;

public final class DistrictSearchRequest
  extends CommonRequest
{
  private String f;
  private ReturnType g = ReturnType.all;
  
  public DistrictSearchRequest() {}
  
  public DistrictSearchRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, SortBy paramSortBy, CoordType paramCoordType, String paramString, ReturnType paramReturnType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramSortBy, paramCoordType, paramInt2, paramInt3);
    this.f = paramString;
    this.g = paramReturnType;
  }
  
  public DistrictSearchRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, CoordType paramCoordType, String paramString, ReturnType paramReturnType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType, paramInt2, paramInt3);
    this.f = paramString;
    this.g = paramReturnType;
  }
  
  public DistrictSearchRequest(int paramInt, long paramLong, String paramString, ReturnType paramReturnType)
  {
    super(paramInt, paramLong);
    this.f = paramString;
    this.g = paramReturnType;
  }
  
  public final String getKeyword()
  {
    return this.f;
  }
  
  public final ReturnType getReturnType()
  {
    return this.g;
  }
  
  public final void setKeyword(String paramString)
  {
    this.f = paramString;
  }
  
  public final void setReturnType(ReturnType paramReturnType)
  {
    this.g = paramReturnType;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("DistrictSearchRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", filterCondition=").append(this.a);
    localStringBuffer.append(", sortBy=").append(this.b);
    localStringBuffer.append(", coordTypeOutput=").append(this.c);
    localStringBuffer.append(", keyword='").append(this.f).append("'");
    localStringBuffer.append(", returnType=").append(this.g);
    localStringBuffer.append(", pageIndex=").append(this.d);
    localStringBuffer.append(", pageSize=").append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/DistrictSearchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */