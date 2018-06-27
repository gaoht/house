package com.baidu.trace.api.fence;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.util.List;

public final class PolylineFence
  extends Fence
{
  private List<LatLng> f;
  private int g;
  private CoordType h = CoordType.bd09ll;
  
  private PolylineFence(long paramLong, String paramString1, FenceType paramFenceType, String paramString2, List<LatLng> paramList, int paramInt1, int paramInt2, CoordType paramCoordType)
  {
    super(paramLong, paramString1, paramString2, paramInt2, paramFenceType);
    this.f = paramList;
    this.g = paramInt1;
    this.h = paramCoordType;
  }
  
  public static PolylineFence buildServerFence(long paramLong, String paramString1, String paramString2, List<LatLng> paramList, int paramInt1, int paramInt2, CoordType paramCoordType)
  {
    return new PolylineFence(paramLong, paramString1, FenceType.server, paramString2, paramList, paramInt1, paramInt2, paramCoordType);
  }
  
  public final CoordType getCoordType()
  {
    return this.h;
  }
  
  public final int getOffset()
  {
    return this.g;
  }
  
  public final List<LatLng> getVertexes()
  {
    return this.f;
  }
  
  public final void setCoordType(CoordType paramCoordType)
  {
    this.h = paramCoordType;
  }
  
  public final void setOffset(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setVertexes(List<LatLng> paramList)
  {
    this.f = paramList;
  }
  
  public final String toString()
  {
    return "PolylineFence [fenceId=" + this.a + ", fenceName=" + this.b + ", fenceType=" + this.e + ", monitoredPerson=" + this.c + ", vertexes=" + this.f + ", offset=" + this.g + ", denoise=" + this.d + ", coordType=" + this.h + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/PolylineFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */