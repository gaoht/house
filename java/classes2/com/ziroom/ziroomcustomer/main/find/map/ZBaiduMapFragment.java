package com.ziroom.ziroomcustomer.main.find.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MarkerOptions.MarkerAnimateType;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import java.util.ArrayList;

public class ZBaiduMapFragment
  extends BaseFragment
{
  FrameLayout a;
  MapView b;
  BaiduMap c;
  private int d = 10;
  private int e = 11;
  private int f = 12;
  private int g = 14;
  
  public Marker addMarker(LatLng paramLatLng, BitmapDescriptor paramBitmapDescriptor)
  {
    paramLatLng = new MarkerOptions().position(paramLatLng).animateType(MarkerOptions.MarkerAnimateType.grow).icon(paramBitmapDescriptor);
    return (Marker)this.c.addOverlay(paramLatLng);
  }
  
  public Marker addMarker(LatLng paramLatLng, ArrayList<BitmapDescriptor> paramArrayList)
  {
    return addMarker(paramLatLng, paramArrayList, 10);
  }
  
  public Marker addMarker(LatLng paramLatLng, ArrayList<BitmapDescriptor> paramArrayList, int paramInt)
  {
    paramLatLng = new MarkerOptions().position(paramLatLng).animateType(MarkerOptions.MarkerAnimateType.grow).icons(paramArrayList).period(paramInt);
    return (Marker)this.c.addOverlay(paramLatLng);
  }
  
  public void clearMap()
  {
    this.c.clear();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903996, paramViewGroup, false);
    this.a = ((FrameLayout)paramLayoutInflater);
    this.b = ((MapView)paramLayoutInflater.findViewById(2131690814));
    this.c = this.b.getMap();
    this.b.showScaleControl(false);
    this.c.setMaxAndMinZoomLevel(10.0F, 20.0F);
    paramViewGroup = this.c.getUiSettings();
    paramViewGroup.setOverlookingGesturesEnabled(false);
    paramViewGroup.setRotateGesturesEnabled(false);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.onResume();
  }
  
  public void setMapBounds(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds != null) {
      this.c.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(paramLatLngBounds));
    }
  }
  
  public void setMapCenterPoint(LatLng paramLatLng)
  {
    if (paramLatLng != null) {
      this.c.animateMapStatus(MapStatusUpdateFactory.newLatLng(paramLatLng));
    }
  }
  
  public void setMapZoomLevel(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public void zoomMapToBusinessCircle()
  {
    zoomMapToLevel(this.f);
  }
  
  public void zoomMapToCity()
  {
    zoomMapToLevel(this.d);
  }
  
  public void zoomMapToCommunity()
  {
    zoomMapToLevel(this.g);
  }
  
  public void zoomMapToDistrict()
  {
    zoomMapToLevel(this.e);
  }
  
  public void zoomMapToLevel(int paramInt)
  {
    this.c.setMapStatus(MapStatusUpdateFactory.zoomTo(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/map/ZBaiduMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */