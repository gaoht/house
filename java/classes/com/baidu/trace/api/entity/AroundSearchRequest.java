package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;

public final class AroundSearchRequest
  extends CommonRequest
{
  private LatLng f;
  private double g;
  private CoordType h = CoordType.bd09ll;
  
  public AroundSearchRequest() {}
  
  public AroundSearchRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public AroundSearchRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType, paramInt2, paramInt3);
  }
  
  public AroundSearchRequest(int paramInt1, long paramLong, LatLng paramLatLng, double paramDouble, CoordType paramCoordType1, FilterCondition paramFilterCondition, SortBy paramSortBy, CoordType paramCoordType2, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramSortBy, paramCoordType2, paramInt2, paramInt3);
    this.f = paramLatLng;
    this.g = paramDouble;
    this.h = paramCoordType1;
  }
  
  public AroundSearchRequest(int paramInt1, long paramLong, LatLng paramLatLng, double paramDouble, CoordType paramCoordType1, FilterCondition paramFilterCondition, CoordType paramCoordType2, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType2, paramInt2, paramInt3);
    this.f = paramLatLng;
    this.g = paramDouble;
    this.h = paramCoordType1;
  }
  
  public final LatLng getCenter()
  {
    return this.f;
  }
  
  public final CoordType getCoordTypeInput()
  {
    return this.h;
  }
  
  public final double getRadius()
  {
    return this.g;
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    this.f = paramLatLng;
  }
  
  public final void setCoordTypeInput(CoordType paramCoordType)
  {
    this.h = paramCoordType;
  }
  
  public final void setRadius(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("AroundSearchRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", center=").append(this.f);
    localStringBuffer.append(", radius=").append(this.g);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/AroundSearchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */