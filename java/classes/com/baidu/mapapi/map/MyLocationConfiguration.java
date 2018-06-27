package com.baidu.mapapi.map;

import android.graphics.Color;

public class MyLocationConfiguration
{
  public int accuracyCircleFillColor = 4521984;
  public int accuracyCircleStrokeColor = 4653056;
  public final BitmapDescriptor customMarker;
  public final boolean enableDirection;
  public final LocationMode locationMode;
  
  public MyLocationConfiguration(LocationMode paramLocationMode, boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor)
  {
    LocationMode localLocationMode = paramLocationMode;
    if (paramLocationMode == null) {
      localLocationMode = LocationMode.NORMAL;
    }
    this.locationMode = localLocationMode;
    this.enableDirection = paramBoolean;
    this.customMarker = paramBitmapDescriptor;
    this.accuracyCircleFillColor = a(this.accuracyCircleFillColor);
    this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
  }
  
  public MyLocationConfiguration(LocationMode paramLocationMode, boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor, int paramInt1, int paramInt2)
  {
    LocationMode localLocationMode = paramLocationMode;
    if (paramLocationMode == null) {
      localLocationMode = LocationMode.NORMAL;
    }
    this.locationMode = localLocationMode;
    this.enableDirection = paramBoolean;
    this.customMarker = paramBitmapDescriptor;
    this.accuracyCircleFillColor = a(paramInt1);
    this.accuracyCircleStrokeColor = a(paramInt2);
  }
  
  private int a(int paramInt)
  {
    return Color.argb((0xFF000000 & paramInt) >> 24, paramInt & 0xFF, (0xFF00 & paramInt) >> 8, (0xFF0000 & paramInt) >> 16);
  }
  
  public static enum LocationMode
  {
    static
    {
      FOLLOWING = new LocationMode("FOLLOWING", 1);
    }
    
    private LocationMode() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MyLocationConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */