package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.AddressComponent;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption.DrivingPolicy;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.mapapi.utils.DistanceUtil;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.b.a;
import com.ziroom.ziroomcustomer.util.b.c;
import com.ziroom.ziroomcustomer.util.b.d;
import java.util.List;

public class BaiduMapActivity
  extends BaseActivity
  implements BaiduMap.OnMapClickListener, OnGetGeoCoderResultListener, OnGetRoutePlanResultListener
{
  GeoCoder a = null;
  int b = -1;
  RouteLine c = null;
  com.ziroom.ziroomcustomer.util.b.b d = null;
  boolean e = false;
  MapView f = null;
  BaiduMap g = null;
  RoutePlanSearch r = null;
  String s = com.ziroom.ziroomcustomer.base.b.c;
  private Button t;
  private Button u;
  private TextView v;
  private TextView w;
  private LinearLayout x;
  private TextView y = null;
  private String z = "";
  
  public static LatLng Str2LatLng(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (ae.notNull(paramString))
    {
      localObject1 = localObject2;
      if (paramString.contains("-"))
      {
        paramString = paramString.split("-");
        localObject1 = localObject2;
        if (paramString.length > 1) {
          localObject1 = new LatLng(Double.parseDouble(paramString[0]), Double.parseDouble(paramString[1]));
        }
      }
    }
    return (LatLng)localObject1;
  }
  
  private void a()
  {
    this.w = ((TextView)findViewById(2131689541));
    this.x = ((LinearLayout)findViewById(2131692247));
    this.t = ((Button)findViewById(2131690078));
    this.t.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BaiduMapActivity.this.finish();
      }
    });
    this.u = ((Button)findViewById(2131692249));
    this.u.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("address", BaiduMapActivity.a(BaiduMapActivity.this).getText().toString());
        paramAnonymousView.putExtra("latlng", BaiduMapActivity.b(BaiduMapActivity.this));
        BaiduMapActivity.this.setResult(-1, paramAnonymousView);
        BaiduMapActivity.this.finish();
      }
    });
    this.f = ((MapView)findViewById(2131690529));
    this.g = this.f.getMap();
    this.g.setOnMapClickListener(this);
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    LatLng localLatLng = new LatLng(paramDouble1, paramDouble2);
    this.a.reverseGeoCode(new ReverseGeoCodeOption().location(localLatLng));
  }
  
  private void d(String paramString)
  {
    PlanNode.withCityNameAndPlaceName(this.s, paramString);
    this.a.geocode(new GeoCodeOption().city(this.s).address(paramString));
  }
  
  public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return DistanceUtil.getDistance(new LatLng(paramDouble1, paramDouble2), new LatLng(paramDouble3, paramDouble4));
  }
  
  public static double getDistance(String paramString1, String paramString2)
  {
    if ((ae.isNull(paramString1)) || (ae.isNull(paramString2)) || (!paramString1.contains("-")) || (!paramString2.contains("-"))) {}
    do
    {
      return 0.0D;
      paramString1 = paramString1.split("-");
      paramString2 = paramString2.split("-");
    } while ((paramString1.length <= 1) || (paramString2.length <= 1));
    return getDistance(Double.parseDouble(paramString1[0]), Double.parseDouble(paramString1[1]), Double.parseDouble(paramString2[0]), Double.parseDouble(paramString2[1]));
  }
  
  public static void searchRoutePlanByLatLng(RoutePlanSearch paramRoutePlanSearch, String paramString1, String paramString2)
  {
    paramString1 = Str2LatLng(paramString1);
    paramString2 = Str2LatLng(paramString2);
    if ((paramString1 != null) && (paramString2 != null))
    {
      paramString1 = PlanNode.withLocation(paramString1);
      paramString2 = PlanNode.withLocation(paramString2);
      paramRoutePlanSearch.drivingSearch(new DrivingRoutePlanOption().policy(DrivingRoutePlanOption.DrivingPolicy.ECAR_DIS_FIRST).from(paramString1).to(paramString2));
    }
  }
  
  public void nodeClick(View paramView)
  {
    paramView = null;
    if ((this.c == null) || (this.c.getAllStep() == null)) {}
    for (;;)
    {
      return;
      Object localObject = this.c.getAllStep().get(this.b);
      LatLng localLatLng;
      if ((localObject instanceof DrivingRouteLine.DrivingStep))
      {
        localLatLng = ((DrivingRouteLine.DrivingStep)localObject).getEntrance().getLocation();
        paramView = ((DrivingRouteLine.DrivingStep)localObject).getInstructions();
      }
      while ((localLatLng != null) && (paramView != null))
      {
        this.g.setMapStatus(MapStatusUpdateFactory.newLatLng(localLatLng));
        this.y = new TextView(this);
        this.y.setBackgroundResource(2130839336);
        this.y.setTextColor(-16777216);
        this.y.setText(paramView);
        this.g.showInfoWindow(new InfoWindow(this.y, localLatLng, 0));
        return;
        if ((localObject instanceof WalkingRouteLine.WalkingStep))
        {
          localLatLng = ((WalkingRouteLine.WalkingStep)localObject).getEntrance().getLocation();
          paramView = ((WalkingRouteLine.WalkingStep)localObject).getInstructions();
        }
        else if ((localObject instanceof TransitRouteLine.TransitStep))
        {
          localLatLng = ((TransitRouteLine.TransitStep)localObject).getEntrance().getLocation();
          paramView = ((TransitRouteLine.TransitStep)localObject).getInstructions();
        }
        else
        {
          localLatLng = null;
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903463);
    this.r = RoutePlanSearch.newInstance();
    this.r.setOnGetRoutePlanResultListener(this);
    this.a = GeoCoder.newInstance();
    this.a.setOnGetGeoCodeResultListener(this);
    a();
    showNodeMarker();
    searchRoutePlanByAddress();
    searchRoutePlanByLatLng();
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    if (this.r != null) {
      this.r.destroy();
    }
    if (this.f != null) {
      this.f.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onGetBikingRouteResult(BikingRouteResult paramBikingRouteResult) {}
  
  public void onGetDrivingRouteResult(DrivingRouteResult paramDrivingRouteResult)
  {
    if ((paramDrivingRouteResult == null) || (paramDrivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR)) {
      g.textToast(this, "抱歉，未找到结果");
    }
    if (paramDrivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {}
    while (paramDrivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR) {
      return;
    }
    this.b = -1;
    this.c = ((RouteLine)paramDrivingRouteResult.getRouteLines().get(0));
    a locala = new a(this.g);
    this.d = locala;
    this.g.setOnMarkerClickListener(locala);
    paramDrivingRouteResult = (DrivingRouteLine)paramDrivingRouteResult.getRouteLines().get(0);
    locala.setData(paramDrivingRouteResult);
    paramDrivingRouteResult.getDistance();
    locala.addToMap();
    locala.zoomToSpan();
  }
  
  public void onGetGeoCodeResult(GeoCodeResult paramGeoCodeResult)
  {
    if ((paramGeoCodeResult == null) || (paramGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR))
    {
      g.textToast(this, "抱歉，未能找到结果");
      return;
    }
    this.g.clear();
    this.g.addOverlay(new MarkerOptions().position(paramGeoCodeResult.getLocation()).icon(BitmapDescriptorFactory.fromResource(2130838378)).draggable(true));
    this.g.setMapStatus(MapStatusUpdateFactory.newLatLng(paramGeoCodeResult.getLocation()));
    this.z = (paramGeoCodeResult.getLocation().latitude + "-" + paramGeoCodeResult.getLocation().longitude);
    this.g.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener()
    {
      public void onMarkerDrag(Marker paramAnonymousMarker) {}
      
      public void onMarkerDragEnd(Marker paramAnonymousMarker)
      {
        BaiduMapActivity.a(BaiduMapActivity.this, paramAnonymousMarker.getPosition().latitude + "-" + paramAnonymousMarker.getPosition().longitude);
        BaiduMapActivity.a(BaiduMapActivity.this, paramAnonymousMarker.getPosition().latitude, paramAnonymousMarker.getPosition().longitude);
      }
      
      public void onMarkerDragStart(Marker paramAnonymousMarker) {}
    });
  }
  
  public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramReverseGeoCodeResult)
  {
    if ((paramReverseGeoCodeResult == null) || (paramReverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR))
    {
      g.textToast(this, "抱歉，未能找到结果");
      return;
    }
    new StringBuilder().append(paramReverseGeoCodeResult.getAddressDetail().province).append(paramReverseGeoCodeResult.getAddressDetail().district).toString();
    g.textToast(this, paramReverseGeoCodeResult.getAddress());
    this.v.setText(paramReverseGeoCodeResult.getAddress());
  }
  
  public void onGetTransitRouteResult(TransitRouteResult paramTransitRouteResult)
  {
    if ((paramTransitRouteResult == null) || (paramTransitRouteResult.error != SearchResult.ERRORNO.NO_ERROR)) {
      g.textToast(this, "抱歉，未找到结果");
    }
    if (paramTransitRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {}
    while (paramTransitRouteResult.error != SearchResult.ERRORNO.NO_ERROR) {
      return;
    }
    this.b = -1;
    this.c = ((RouteLine)paramTransitRouteResult.getRouteLines().get(0));
    b localb = new b(this.g);
    this.g.setOnMarkerClickListener(localb);
    this.d = localb;
    localb.setData((TransitRouteLine)paramTransitRouteResult.getRouteLines().get(0));
    localb.addToMap();
    localb.zoomToSpan();
  }
  
  public void onGetWalkingRouteResult(WalkingRouteResult paramWalkingRouteResult)
  {
    if ((paramWalkingRouteResult == null) || (paramWalkingRouteResult.error != SearchResult.ERRORNO.NO_ERROR)) {
      g.textToast(this, "抱歉，未找到结果");
    }
    if (paramWalkingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {}
    while (paramWalkingRouteResult.error != SearchResult.ERRORNO.NO_ERROR) {
      return;
    }
    this.b = -1;
    this.c = ((RouteLine)paramWalkingRouteResult.getRouteLines().get(0));
    c localc = new c(this.g);
    this.g.setOnMarkerClickListener(localc);
    this.d = localc;
    localc.setData((WalkingRouteLine)paramWalkingRouteResult.getRouteLines().get(0));
    localc.addToMap();
    localc.zoomToSpan();
  }
  
  public void onMapClick(LatLng paramLatLng)
  {
    this.g.hideInfoWindow();
  }
  
  public boolean onMapPoiClick(MapPoi paramMapPoi)
  {
    return false;
  }
  
  protected void onPause()
  {
    this.f.onPause();
    super.onPause();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    this.f.onResume();
    super.onResume();
    a();
  }
  
  public void searchRoutePlanByAddress()
  {
    Object localObject2 = getIntent().getStringExtra("start_address");
    Object localObject1 = getIntent().getStringExtra("end_address");
    if ((ae.notNull((String)localObject2)) && (ae.notNull((String)localObject1)))
    {
      this.w.setText(getString(2131297221));
      this.x.setVisibility(8);
      this.c = null;
      this.g.clear();
      localObject2 = PlanNode.withCityNameAndPlaceName(this.s, (String)localObject2);
      localObject1 = PlanNode.withCityNameAndPlaceName(this.s, (String)localObject1);
      this.r.drivingSearch(new DrivingRoutePlanOption().policy(DrivingRoutePlanOption.DrivingPolicy.ECAR_DIS_FIRST).from((PlanNode)localObject2).to((PlanNode)localObject1));
    }
  }
  
  public void searchRoutePlanByLatLng()
  {
    Object localObject2 = getIntent().getStringExtra("start_node");
    Object localObject1 = getIntent().getStringExtra("end_node");
    localObject2 = Str2LatLng((String)localObject2);
    localObject1 = Str2LatLng((String)localObject1);
    if ((localObject2 != null) && (localObject1 != null))
    {
      this.w.setText(getString(2131297221));
      this.x.setVisibility(8);
      this.c = null;
      this.g.clear();
      localObject2 = PlanNode.withLocation((LatLng)localObject2);
      localObject1 = PlanNode.withLocation((LatLng)localObject1);
      this.r.drivingSearch(new DrivingRoutePlanOption().policy(DrivingRoutePlanOption.DrivingPolicy.ECAR_DIS_FIRST).from((PlanNode)localObject2).to((PlanNode)localObject1));
    }
  }
  
  public void showNodeMarker()
  {
    String str = getIntent().getStringExtra("node");
    if (ae.notNull(str))
    {
      this.v = ((TextView)findViewById(2131692248));
      this.v.setText(str);
      this.w.setText(getString(2131297222));
      d(str);
    }
  }
  
  private class a
    extends a
  {
    public a(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public BitmapDescriptor getStartMarker()
    {
      if (BaiduMapActivity.this.e) {
        return BitmapDescriptorFactory.fromResource(2130838844);
      }
      return null;
    }
    
    public BitmapDescriptor getTerminalMarker()
    {
      if (BaiduMapActivity.this.e) {
        return BitmapDescriptorFactory.fromResource(2130838784);
      }
      return null;
    }
  }
  
  private class b
    extends c
  {
    public b(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public BitmapDescriptor getStartMarker()
    {
      if (BaiduMapActivity.this.e) {
        return BitmapDescriptorFactory.fromResource(2130838844);
      }
      return null;
    }
    
    public BitmapDescriptor getTerminalMarker()
    {
      if (BaiduMapActivity.this.e) {
        return BitmapDescriptorFactory.fromResource(2130838784);
      }
      return null;
    }
  }
  
  private class c
    extends d
  {
    public c(BaiduMap paramBaiduMap)
    {
      super();
    }
    
    public BitmapDescriptor getStartMarker()
    {
      if (BaiduMapActivity.this.e) {
        return BitmapDescriptorFactory.fromResource(2130838844);
      }
      return null;
    }
    
    public BitmapDescriptor getTerminalMarker()
    {
      if (BaiduMapActivity.this.e) {
        return BitmapDescriptorFactory.fromResource(2130838784);
      }
      return null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/BaiduMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */