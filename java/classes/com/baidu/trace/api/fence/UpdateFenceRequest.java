package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.util.List;

public final class UpdateFenceRequest
  extends BaseRequest
{
  private Fence a;
  
  private UpdateFenceRequest(int paramInt, long paramLong, Fence paramFence)
  {
    super(paramInt, paramLong);
    this.a = paramFence;
  }
  
  public static UpdateFenceRequest buildLocalCircleRequest(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt2, CoordType paramCoordType)
  {
    return new UpdateFenceRequest(paramInt1, paramLong1, CircleFence.buildLocalFence(paramLong2, paramString1, paramString2, paramLatLng, paramDouble, paramInt2, paramCoordType));
  }
  
  public static UpdateFenceRequest buildServerCircleRequest(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt2, CoordType paramCoordType)
  {
    return new UpdateFenceRequest(paramInt1, paramLong1, CircleFence.buildServerFence(paramLong2, paramString1, paramString2, paramLatLng, paramDouble, paramInt2, paramCoordType));
  }
  
  public static UpdateFenceRequest buildServerDistrictRequest(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    return new UpdateFenceRequest(paramInt1, paramLong1, DistrictFence.buildServerFence(paramLong2, paramString1, paramString2, paramInt2, paramString3));
  }
  
  public static UpdateFenceRequest buildServerPolygonRequest(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, List<LatLng> paramList, int paramInt2, CoordType paramCoordType)
  {
    return new UpdateFenceRequest(paramInt1, paramLong1, PolygonFence.buildServerFence(paramLong2, paramString1, paramString2, paramList, paramInt2, paramCoordType));
  }
  
  public static UpdateFenceRequest buildServerPolylineRequest(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, List<LatLng> paramList, int paramInt2, int paramInt3, CoordType paramCoordType)
  {
    return new UpdateFenceRequest(paramInt1, paramLong1, PolylineFence.buildServerFence(paramLong2, paramString1, paramString2, paramList, paramInt2, paramInt3, paramCoordType));
  }
  
  public final Fence getFence()
  {
    return this.a;
  }
  
  public final String toString()
  {
    if ((this.a instanceof CircleFence)) {
      return "UpdateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", circleFence=" + this.a.toString() + "]";
    }
    if ((this.a instanceof PolygonFence)) {
      return "UpdateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", polygonFence=" + this.a.toString() + "]";
    }
    if ((this.a instanceof PolylineFence)) {
      return "UpdateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", polylineFence=" + this.a.toString() + "]";
    }
    if ((this.a instanceof DistrictFence)) {
      return "UpdateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", districtFence=" + this.a.toString() + "]";
    }
    return "UpdateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", fence=" + this.a.toString() + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/UpdateFenceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */