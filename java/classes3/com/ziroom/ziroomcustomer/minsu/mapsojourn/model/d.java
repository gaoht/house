package com.ziroom.ziroomcustomer.minsu.mapsojourn.model;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

public class d
{
  public LatLng a;
  public float b;
  public LatLngBounds c;
  
  public d(LatLng paramLatLng, float paramFloat, LatLngBounds paramLatLngBounds)
  {
    this.a = paramLatLng;
    this.b = paramFloat;
    this.c = paramLatLngBounds;
  }
  
  public d clone()
  {
    return new d(this.a, this.b, this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/model/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */