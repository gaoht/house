package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.e;

public final class Projection
{
  private e a;
  
  Projection(e parame)
  {
    this.a = parame;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    if ((paramPoint != null) && (this.a != null)) {
      return CoordUtil.mc2ll(this.a.b(paramPoint.x, paramPoint.y));
    }
    return null;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    return (float)(paramFloat / this.a.I());
  }
  
  public PointF toOpenGLLocation(LatLng paramLatLng, MapStatus paramMapStatus)
  {
    if ((paramLatLng != null) && (paramMapStatus != null))
    {
      paramLatLng = CoordUtil.ll2mc(paramLatLng);
      paramMapStatus = paramMapStatus.a;
      double d1 = paramMapStatus.d;
      double d2 = paramMapStatus.e;
      return new PointF((float)((paramLatLng.getLongitudeE6() - d1) / paramMapStatus.n), (float)((paramLatLng.getLatitudeE6() - d2) / paramMapStatus.n));
    }
    return null;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    if ((paramLatLng != null) && (this.a != null))
    {
      paramLatLng = CoordUtil.ll2mc(paramLatLng);
      return this.a.a(paramLatLng);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/Projection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */