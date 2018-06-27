package com.baidu.trace.api.fence;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.util.List;

public final class CreateFenceRequest
  extends BaseRequest
{
  private Fence a;
  
  private CreateFenceRequest(int paramInt, long paramLong, Fence paramFence)
  {
    super(paramInt, paramLong);
    this.a = paramFence;
  }
  
  public static CreateFenceRequest buildLocalCircleRequest(int paramInt1, long paramLong, String paramString1, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt2, CoordType paramCoordType)
  {
    return new CreateFenceRequest(paramInt1, paramLong, CircleFence.buildLocalFence(0L, paramString1, paramString2, paramLatLng, paramDouble, paramInt2, paramCoordType));
  }
  
  public static CreateFenceRequest buildServerCircleRequest(int paramInt1, long paramLong, String paramString1, String paramString2, LatLng paramLatLng, double paramDouble, int paramInt2, CoordType paramCoordType)
  {
    return new CreateFenceRequest(paramInt1, paramLong, CircleFence.buildServerFence(0L, paramString1, paramString2, paramLatLng, paramDouble, paramInt2, paramCoordType));
  }
  
  public static CreateFenceRequest buildServerDistrictRequest(int paramInt1, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    return new CreateFenceRequest(paramInt1, paramLong, DistrictFence.buildServerFence(0L, paramString1, paramString2, paramInt2, paramString3));
  }
  
  public static CreateFenceRequest buildServerPolygonRequest(int paramInt1, long paramLong, String paramString1, String paramString2, List<LatLng> paramList, int paramInt2, CoordType paramCoordType)
  {
    return new CreateFenceRequest(paramInt1, paramLong, PolygonFence.buildServerFence(0L, paramString1, paramString2, paramList, paramInt2, paramCoordType));
  }
  
  public static CreateFenceRequest buildServerPolylineRequest(int paramInt1, long paramLong, String paramString1, String paramString2, List<LatLng> paramList, int paramInt2, int paramInt3, CoordType paramCoordType)
  {
    return new CreateFenceRequest(paramInt1, paramLong, PolylineFence.buildServerFence(0L, paramString1, paramString2, paramList, paramInt2, paramInt3, paramCoordType));
  }
  
  public final Fence getFence()
  {
    return this.a;
  }
  
  public final String toString()
  {
    if ((this.a instanceof CircleFence)) {
      return "CreateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", circleFence=" + this.a.toString() + "]";
    }
    if ((this.a instanceof PolygonFence)) {
      return "CreateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", polygonFence=" + this.a.toString() + "]";
    }
    if ((this.a instanceof PolylineFence)) {
      return "CreateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", polylineFence=" + this.a.toString() + "]";
    }
    if ((this.a instanceof DistrictFence)) {
      return "CreateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", districtFence=" + this.a.toString() + "]";
    }
    return "CreateFenceRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", Fence=" + this.a.toString() + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/fence/CreateFenceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */