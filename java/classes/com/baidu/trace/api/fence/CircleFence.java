package com.baidu.trace.api.fence;

import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;

public final class CircleFence
  extends Fence
{
  private LatLng f;
  private double g;
  private CoordType h = CoordType.bd09ll;
  
  private CircleFence(long paramLong, String paramString1, FenceType paramFenceType, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt, CoordType paramCoordType)
  {
    super(paramLong, paramString1, paramString2, paramInt, paramFenceType);
    this.f = paramLatLng;
    this.g = paramDouble;
    this.h = paramCoordType;
  }
  
  public static CircleFence buildLocalFence(long paramLong, String paramString1, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt, CoordType paramCoordType)
  {
    return new CircleFence(paramLong, paramString1, FenceType.local, paramString2, paramLatLng, paramDouble, paramInt, paramCoordType);
  }
  
  public static CircleFence buildServerFence(long paramLong, String paramString1, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt, CoordType paramCoordType)
  {
    return new CircleFence(paramLong, paramString1, FenceType.server, paramString2, paramLatLng, paramDouble, paramInt, paramCoordType);
  }
  
  public final LatLng getCenter()
  {
    return this.f;
  }
  
  public final CoordType getCoordType()
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
  
  public final void setCoordType(CoordType paramCoordType)
  {
    this.h = paramCoordType;
  }
  
  public final void setRadius(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public final String toString()
  {
    return "CircleFence [fenceId=" + this.a + ", fenceName=" + this.b + ", fenceType=" + this.e + ", monitoredPerson=" + this.c + ", center=" + this.f + ", radius=" + this.g + ", denoise=" + this.d + ", coordType=" + this.h + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/CircleFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */