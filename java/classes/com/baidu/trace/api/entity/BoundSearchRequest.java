package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;

public final class BoundSearchRequest
  extends CommonRequest
{
  private LatLng f;
  private LatLng g;
  private CoordType h = CoordType.bd09ll;
  
  public BoundSearchRequest() {}
  
  public BoundSearchRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public BoundSearchRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType, paramInt2, paramInt3);
  }
  
  public BoundSearchRequest(int paramInt1, long paramLong, LatLng paramLatLng1, LatLng paramLatLng2, CoordType paramCoordType1, FilterCondition paramFilterCondition, SortBy paramSortBy, CoordType paramCoordType2, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramSortBy, paramCoordType2, paramInt2, paramInt3);
    this.f = paramLatLng1;
    this.g = paramLatLng2;
    this.h = paramCoordType1;
  }
  
  public BoundSearchRequest(int paramInt1, long paramLong, LatLng paramLatLng1, LatLng paramLatLng2, CoordType paramCoordType1, FilterCondition paramFilterCondition, CoordType paramCoordType2, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType2, paramInt2, paramInt3);
    this.f = paramLatLng1;
    this.g = paramLatLng2;
    this.h = paramCoordType1;
  }
  
  public final CoordType getCoordTypeInput()
  {
    return this.h;
  }
  
  public final FilterCondition getFilterCondition()
  {
    return this.a;
  }
  
  public final LatLng getLowerLeft()
  {
    return this.f;
  }
  
  public final LatLng getUpperRight()
  {
    return this.g;
  }
  
  public final void setCoordTypeInput(CoordType paramCoordType)
  {
    this.h = paramCoordType;
  }
  
  public final void setLowerLeft(LatLng paramLatLng)
  {
    this.f = paramLatLng;
  }
  
  public final void setUpperRight(LatLng paramLatLng)
  {
    this.g = paramLatLng;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BoundSearchRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", lowerLeft=").append(this.f);
    localStringBuffer.append(", upperRight=").append(this.g);
    localStringBuffer.append(", coordTypeInput=").append(this.h);
    localStringBuffer.append(", filterCondition=").append(this.a);
    localStringBuffer.append(", sortBy=").append(this.b);
    localStringBuffer.append(", coordTypeOutput=").append(this.c);
    localStringBuffer.append(", pageIndex=").append(this.d);
    localStringBuffer.append(", pageSize=").append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/BoundSearchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */