package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;

public class InfoWindow
{
  BitmapDescriptor a;
  View b;
  LatLng c;
  OnInfoWindowClickListener d;
  int e;
  
  public InfoWindow(View paramView, LatLng paramLatLng, int paramInt)
  {
    if ((paramView == null) || (paramLatLng == null)) {
      throw new IllegalArgumentException("view and position can not be null");
    }
    this.b = paramView;
    this.c = paramLatLng;
    this.e = paramInt;
  }
  
  public InfoWindow(BitmapDescriptor paramBitmapDescriptor, LatLng paramLatLng, int paramInt, OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if ((paramBitmapDescriptor == null) || (paramLatLng == null)) {
      throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
    }
    this.a = paramBitmapDescriptor;
    this.c = paramLatLng;
    this.d = paramOnInfoWindowClickListener;
    this.e = paramInt;
  }
  
  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/InfoWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */