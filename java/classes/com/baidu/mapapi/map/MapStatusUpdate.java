package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.D.b;
import com.baidu.platform.comapi.map.e;

public final class MapStatusUpdate
{
  private static final String l = MapStatusUpdate.class.getSimpleName();
  int a;
  MapStatus b;
  LatLng c;
  LatLngBounds d;
  int e;
  int f;
  float g;
  int h;
  int i;
  float j;
  Point k;
  
  MapStatusUpdate() {}
  
  MapStatusUpdate(int paramInt)
  {
    this.a = paramInt;
  }
  
  MapStatus a(e parame, MapStatus paramMapStatus)
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return this.b;
    case 2: 
      return new MapStatus(paramMapStatus.rotate, this.c, paramMapStatus.overlook, paramMapStatus.zoom, paramMapStatus.targetScreen, null);
    case 3: 
      localObject = CoordUtil.ll2mc(this.d.southwest);
      localGeoPoint = CoordUtil.ll2mc(this.d.northeast);
      d1 = ((GeoPoint)localObject).getLongitudeE6();
      d2 = localGeoPoint.getLatitudeE6();
      d3 = localGeoPoint.getLongitudeE6();
      d4 = ((GeoPoint)localObject).getLatitudeE6();
      f1 = parame.a((int)d1, (int)d2, (int)d3, (int)d4, paramMapStatus.a.j.b - paramMapStatus.a.j.a, paramMapStatus.a.j.d - paramMapStatus.a.j.c);
      parame = this.d.getCenter();
      return new MapStatus(paramMapStatus.rotate, parame, paramMapStatus.overlook, f1, paramMapStatus.targetScreen, null);
    case 4: 
      return new MapStatus(paramMapStatus.rotate, this.c, paramMapStatus.overlook, this.g, paramMapStatus.targetScreen, null);
    case 5: 
      parame.F();
      parame = parame.b(parame.F() / 2 + this.h, parame.G() / 2 + this.i);
      localObject = CoordUtil.mc2ll(parame);
      return new MapStatus(paramMapStatus.rotate, (LatLng)localObject, paramMapStatus.overlook, paramMapStatus.zoom, paramMapStatus.targetScreen, parame.getLongitudeE6(), parame.getLatitudeE6(), null);
    case 6: 
      return new MapStatus(paramMapStatus.rotate, paramMapStatus.target, paramMapStatus.overlook, paramMapStatus.zoom + this.j, paramMapStatus.targetScreen, paramMapStatus.a(), paramMapStatus.b(), null);
    case 7: 
      parame = CoordUtil.mc2ll(parame.b(this.k.x, this.k.y));
      return new MapStatus(paramMapStatus.rotate, parame, paramMapStatus.overlook, paramMapStatus.zoom + this.j, this.k, null);
    case 8: 
      return new MapStatus(paramMapStatus.rotate, paramMapStatus.target, paramMapStatus.overlook, this.g, paramMapStatus.targetScreen, paramMapStatus.a(), paramMapStatus.b(), null);
    }
    Object localObject = CoordUtil.ll2mc(this.d.southwest);
    GeoPoint localGeoPoint = CoordUtil.ll2mc(this.d.northeast);
    double d1 = ((GeoPoint)localObject).getLongitudeE6();
    double d2 = localGeoPoint.getLatitudeE6();
    double d3 = localGeoPoint.getLongitudeE6();
    double d4 = ((GeoPoint)localObject).getLatitudeE6();
    float f1 = parame.a((int)d1, (int)d2, (int)d3, (int)d4, this.e, this.f);
    parame = this.d.getCenter();
    return new MapStatus(paramMapStatus.rotate, parame, paramMapStatus.overlook, f1, paramMapStatus.targetScreen, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MapStatusUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */