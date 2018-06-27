package com.ziroom.ziroomcustomer.findhouse.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatus.Builder;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Projection;
import com.baidu.mapapi.model.LatLng;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.model.MapMarkerData;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.Map;

public class BaseHouseMapActivity
  extends BaseActivity
{
  protected LocationClient a;
  protected BDLocationListener b;
  protected boolean c = true;
  protected final float d = 12.5F;
  protected c e;
  protected Map<String, Bitmap> f = new HashMap();
  private Map<String, View> g = new HashMap();
  
  protected View a(int paramInt, String paramString1, String paramString2)
  {
    View localView;
    b localb;
    if (this.g.containsKey(paramInt + ""))
    {
      localView = (View)this.g.get(paramInt + "");
      localb = (b)localView.getTag();
    }
    for (;;)
    {
      localb.a.setText(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        break;
      }
      localb.b.setVisibility(8);
      return localView;
      localView = LayoutInflater.from(this).inflate(paramInt, null, false);
      localb = new b(null);
      localb.a = ((TextView)localView.findViewById(2131689751));
      localb.b = ((TextView)localView.findViewById(2131695090));
      localView.setTag(localb);
    }
    localb.b.setVisibility(0);
    localb.b.setText(paramString2);
    return localView;
  }
  
  protected View a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    View localView;
    b localb;
    if (this.g.containsKey(paramInt + ""))
    {
      localView = (View)this.g.get(paramInt + "");
      localb = (b)localView.getTag();
      localb.a.setText(paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        break label199;
      }
      localb.b.setVisibility(8);
      label101:
      if (!TextUtils.isEmpty(paramString1)) {
        break label221;
      }
      localb.c.setVisibility(8);
    }
    label199:
    label221:
    do
    {
      return localView;
      localView = LayoutInflater.from(this).inflate(paramInt, null, false);
      localb = new b(null);
      localb.a = ((TextView)localView.findViewById(2131689751));
      localb.b = ((TextView)localView.findViewById(2131695090));
      localb.c = ((ImageView)localView.findViewById(2131694449));
      localView.setTag(localb);
      break;
      localb.b.setVisibility(0);
      localb.b.setText(paramString3);
      break label101;
      localb.c.setVisibility(0);
      paramString3 = (Bitmap)this.f.get(paramString1);
      paramString2 = paramString3;
      if (paramString3 == null)
      {
        paramString2 = BitmapFactory.decodeFile(paramString1);
        this.f.put(paramString1, paramString2);
      }
    } while (paramString2 == null);
    localb.c.setImageBitmap(paramString2);
    return localView;
  }
  
  protected BitmapDescriptor a(String paramString1, String paramString2, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131689751);
    TextView localTextView2 = (TextView)localView.findViewById(2131695090);
    if (TextUtils.isEmpty(paramString2)) {
      localTextView2.setVisibility(8);
    }
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    return BitmapDescriptorFactory.fromView(localView);
  }
  
  protected BitmapDescriptor a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131689751);
    TextView localTextView2 = (TextView)localView.findViewById(2131695090);
    ImageView localImageView = (ImageView)localView.findViewById(2131694449);
    if (TextUtils.isEmpty(paramString2)) {
      localTextView2.setVisibility(8);
    }
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    if (TextUtils.isEmpty(paramString3)) {
      localImageView.setVisibility(8);
    }
    for (;;)
    {
      return BitmapDescriptorFactory.fromView(localView);
      localImageView.setVisibility(0);
      paramString2 = (Bitmap)this.f.get(paramString3);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = BitmapFactory.decodeFile(paramString3);
        this.f.put(paramString3, paramString1);
      }
      if (paramString1 != null) {
        localImageView.setImageBitmap(paramString1);
      }
    }
  }
  
  protected Marker a(BaiduMap paramBaiduMap, LatLng paramLatLng, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramLatLng == null) {
      return null;
    }
    paramString1 = BitmapDescriptorFactory.fromView(a(paramInt2, paramString1, paramString2));
    paramBaiduMap = (Marker)paramBaiduMap.addOverlay(new MarkerOptions().position(paramLatLng).icon(paramString1).zIndex(paramInt1));
    paramString1.recycle();
    return paramBaiduMap;
  }
  
  protected Marker a(BaiduMap paramBaiduMap, LatLng paramLatLng, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramLatLng == null) {
      return null;
    }
    paramString1 = BitmapDescriptorFactory.fromView(a(paramInt2, paramString1, paramString2, paramString3));
    paramBaiduMap = (Marker)paramBaiduMap.addOverlay(new MarkerOptions().position(paramLatLng).icon(paramString1).zIndex(paramInt1));
    paramString1.recycle();
    return paramBaiduMap;
  }
  
  protected LatLng a()
  {
    return new LatLng(com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLat(), com.ziroom.ziroomcustomer.base.b.getCurrentCity().getLng());
  }
  
  protected a a(MapView paramMapView)
  {
    if ((paramMapView == null) || (paramMapView.getMap() == null) || (paramMapView.getMap().getProjection() == null)) {
      return new a();
    }
    Object localObject = paramMapView.getMap();
    int i = paramMapView.getTop();
    int j = paramMapView.getBottom();
    int k = paramMapView.getLeft();
    int m = paramMapView.getRight();
    paramMapView = ((BaiduMap)localObject).getProjection().fromScreenLocation(new Point(k, i));
    localObject = ((BaiduMap)localObject).getProjection().fromScreenLocation(new Point(m, j));
    u.i("baidumap", Integer.valueOf(k));
    u.i("baidumap", Integer.valueOf(i));
    u.i("baidumap", Integer.valueOf(m));
    u.i("baidumap", Integer.valueOf(j));
    if ((paramMapView == null) || (localObject == null)) {
      return new a();
    }
    a locala = new a();
    if (paramMapView.latitude < ((LatLng)localObject).latitude)
    {
      d1 = paramMapView.latitude;
      locala.a = d1;
      if (((LatLng)localObject).longitude >= paramMapView.longitude) {
        break label276;
      }
      d1 = ((LatLng)localObject).longitude;
      label209:
      locala.b = d1;
      if (paramMapView.latitude <= ((LatLng)localObject).latitude) {
        break label284;
      }
      d1 = paramMapView.latitude;
      label233:
      locala.c = d1;
      if (((LatLng)localObject).longitude <= paramMapView.longitude) {
        break label293;
      }
    }
    label276:
    label284:
    label293:
    for (double d1 = ((LatLng)localObject).longitude;; d1 = paramMapView.longitude)
    {
      locala.d = d1;
      return locala;
      d1 = ((LatLng)localObject).latitude;
      break;
      d1 = paramMapView.longitude;
      break label209;
      d1 = ((LatLng)localObject).latitude;
      break label233;
    }
  }
  
  protected void a(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null) {
      return;
    }
    this.a = new LocationClient(this);
    this.b = paramBDLocationListener;
    this.a.registerLocationListener(this.b);
    paramBDLocationListener = new LocationClientOption();
    paramBDLocationListener.setOpenGps(true);
    paramBDLocationListener.setCoorType("bd09ll");
    paramBDLocationListener.setScanSpan(5000);
    paramBDLocationListener.setIsNeedAddress(true);
    this.a.setLocOption(paramBDLocationListener);
    this.a.start();
  }
  
  protected void a(MapView paramMapView, LatLng paramLatLng)
  {
    if ((paramMapView == null) || (paramLatLng == null)) {
      return;
    }
    a locala = a(paramMapView);
    double d1 = (locala.c - locala.a) / 5.0D;
    b(paramMapView, new LatLng(paramLatLng.latitude - d1 * 1.0D, paramLatLng.longitude));
  }
  
  protected void a(MapView paramMapView, LatLng paramLatLng, float paramFloat)
  {
    if ((paramLatLng == null) || (paramFloat < 3.0F) || (paramFloat > 21.0F)) {
      return;
    }
    paramLatLng = MapStatusUpdateFactory.newLatLngZoom(paramLatLng, paramFloat);
    paramMapView.getMap().animateMapStatus(paramLatLng);
  }
  
  protected void a(Marker paramMarker, MapMarkerData paramMapMarkerData, int paramInt1, int paramInt2)
  {
    if ((paramMarker == null) || (paramMapMarkerData == null)) {
      return;
    }
    paramMarker.setIcon(a(paramMapMarkerData.getMapMarkerName(), paramMapMarkerData.getMapMarkerDesc(), paramInt1));
    paramMarker.setZIndex(paramInt2);
  }
  
  protected void a(Marker paramMarker, MapMarkerData paramMapMarkerData, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramMarker == null) || (paramMapMarkerData == null)) {
      return;
    }
    paramMarker.setIcon(a(paramMapMarkerData.getMapMarkerName(), paramMapMarkerData.getMapMarkerDesc(), paramString, paramInt1));
    paramMarker.setZIndex(paramInt2);
  }
  
  protected void b(MapView paramMapView, LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return;
    }
    paramLatLng = MapStatusUpdateFactory.newLatLng(paramLatLng);
    paramMapView.getMap().animateMapStatus(paramLatLng);
  }
  
  public c getZoomType(float paramFloat)
  {
    if ((paramFloat > 10.0F) && (paramFloat <= 14.0F)) {
      return c.a;
    }
    if ((paramFloat > 14.0D) && (paramFloat < 16.0D)) {
      return c.b;
    }
    if (paramFloat >= 16.0D) {
      return c.c;
    }
    return c.d;
  }
  
  public boolean isLatLngEquals(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null)) {
      if ((paramLatLng1 != null) || (paramLatLng2 != null)) {}
    }
    while (((int)(paramLatLng1.latitude * 1000000.0D) == (int)(paramLatLng2.latitude * 1000000.0D)) && ((int)(paramLatLng1.longitude * 1000000.0D) == (int)(paramLatLng2.longitude * 1000000.0D)))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public MapStatus makeMapStatus(float paramFloat, LatLng paramLatLng)
  {
    MapStatus.Builder localBuilder2 = new MapStatus.Builder().zoom(paramFloat);
    MapStatus.Builder localBuilder1 = localBuilder2;
    if (paramLatLng != null) {
      localBuilder1 = localBuilder2.target(paramLatLng);
    }
    return localBuilder1.build();
  }
  
  public MapStatus makeMapStatus(c paramc, LatLng paramLatLng)
  {
    float f2 = 14.0F;
    float f1 = f2;
    switch (1.a[paramc.ordinal()])
    {
    default: 
      f1 = f2;
    }
    for (;;)
    {
      return makeMapStatus(f1, paramLatLng);
      f1 = 15.0F;
      continue;
      f1 = 16.0F;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.stop();
    }
  }
  
  public void zoomTo(MapStatus paramMapStatus, BaiduMap paramBaiduMap)
  {
    paramBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(paramMapStatus));
  }
  
  public static class a
  {
    double a;
    double b;
    double c;
    double d;
  }
  
  private class b
  {
    TextView a;
    TextView b;
    ImageView c;
    
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/BaseHouseMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */