package com.baidu.trace.api.fence;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.util.List;

public final class PolygonFence
  extends Fence
{
  private List<LatLng> f;
  private CoordType g = CoordType.bd09ll;
  
  private PolygonFence(long paramLong, String paramString1, FenceType paramFenceType, String paramString2, List<LatLng> paramList, int paramInt, CoordType paramCoordType)
  {
    super(paramLong, paramString1, paramString2, paramInt, paramFenceType);
    this.f = paramList;
    this.g = paramCoordType;
  }
  
  public static PolygonFence buildServerFence(long paramLong, String paramString1, String paramString2, List<LatLng> paramList, int paramInt, CoordType paramCoordType)
  {
    return new PolygonFence(paramLong, paramString1, FenceType.server, paramString2, paramList, paramInt, paramCoordType);
  }
  
  public final CoordType getCoordType()
  {
    return this.g;
  }
  
  public final List<LatLng> getVertexes()
  {
    return this.f;
  }
  
  public final void setCoordType(CoordType paramCoordType)
  {
    this.g = paramCoordType;
  }
  
  public final void setVertexes(List<LatLng> paramList)
  {
    this.f = paramList;
  }
  
  public final String toString()
  {
    return "PolygonFence [fenceId=" + this.a + ", fenceName=" + this.b + ", fenceType=" + this.e + ", monitoredPerson=" + this.c + ", vertexes=" + this.f + ", denoise=" + this.d + ", coordType=" + this.g + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/PolygonFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */