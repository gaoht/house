package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.h;

public final class Dot
  extends Overlay
{
  LatLng a;
  int b;
  int c;
  
  Dot()
  {
    this.q = h.g;
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    GeoPoint localGeoPoint = CoordUtil.ll2mc(this.a);
    paramBundle.putDouble("location_x", localGeoPoint.getLongitudeE6());
    paramBundle.putDouble("location_y", localGeoPoint.getLatitudeE6());
    paramBundle.putInt("radius", this.c);
    Overlay.a(this.b, paramBundle);
    return paramBundle;
  }
  
  public LatLng getCenter()
  {
    return this.a;
  }
  
  public int getColor()
  {
    return this.b;
  }
  
  public int getRadius()
  {
    return this.c;
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      throw new IllegalArgumentException("dot center can not be null");
    }
    this.a = paramLatLng;
    this.listener.b(this);
  }
  
  public void setColor(int paramInt)
  {
    this.b = paramInt;
    this.listener.b(this);
  }
  
  public void setRadius(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.listener.b(this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/Dot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */