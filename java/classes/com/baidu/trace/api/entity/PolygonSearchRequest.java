package com.baidu.trace.api.entity;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.util.List;

public final class PolygonSearchRequest
  extends CommonRequest
{
  private List<LatLng> f;
  private CoordType g = CoordType.bd09ll;
  
  public PolygonSearchRequest() {}
  
  public PolygonSearchRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, SortBy paramSortBy, CoordType paramCoordType1, List<LatLng> paramList, CoordType paramCoordType2, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramSortBy, paramCoordType1, paramInt2, paramInt3);
    this.f = paramList;
    this.g = paramCoordType2;
  }
  
  public PolygonSearchRequest(int paramInt1, long paramLong, FilterCondition paramFilterCondition, CoordType paramCoordType1, List<LatLng> paramList, CoordType paramCoordType2, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramLong, paramFilterCondition, paramCoordType1, paramInt2, paramInt3);
    this.f = paramList;
    this.g = paramCoordType2;
  }
  
  public PolygonSearchRequest(int paramInt, long paramLong, List<LatLng> paramList, CoordType paramCoordType)
  {
    super(paramInt, paramLong);
    this.f = paramList;
    this.g = paramCoordType;
  }
  
  public final CoordType getCoordTypeInput()
  {
    return this.g;
  }
  
  public final List<LatLng> getVertexes()
  {
    return this.f;
  }
  
  public final void setCoordTypeInput(CoordType paramCoordType)
  {
    this.g = paramCoordType;
  }
  
  public final void setVertexes(List<LatLng> paramList)
  {
    this.f = paramList;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PolygonSearchRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", vertexes=").append(this.f);
    localStringBuffer.append(", coordTypeInput=").append(this.g);
    localStringBuffer.append(", filterCondition=").append(this.a);
    localStringBuffer.append(", sortBy=").append(this.b);
    localStringBuffer.append(", coordTypeOutput=").append(this.c);
    localStringBuffer.append(", pageIndex=").append(this.d);
    localStringBuffer.append(", pageSize=").append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/PolygonSearchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */