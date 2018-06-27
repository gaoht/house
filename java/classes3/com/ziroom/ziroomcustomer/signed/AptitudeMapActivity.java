package com.ziroom.ziroomcustomer.signed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatus.Builder;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.MyLocationData.Builder;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AptitudeMapActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static Activity c;
  public LocationClient a = null;
  public BDLocationListener b = new a();
  OnGetGeoCoderResultListener d = new OnGetGeoCoderResultListener()
  {
    public void onGetGeoCodeResult(GeoCodeResult paramAnonymousGeoCodeResult)
    {
      if ((paramAnonymousGeoCodeResult == null) || (paramAnonymousGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR))
      {
        Log.e("结果", "没有检索到结果");
        g.textToast(AptitudeMapActivity.this, "当前网络不佳，请稍后再试。");
        return;
      }
      Log.e("结果", paramAnonymousGeoCodeResult.getLocation().latitude + "                 " + paramAnonymousGeoCodeResult.getLocation().longitude);
      AptitudeMapActivity.a(AptitudeMapActivity.this, paramAnonymousGeoCodeResult.getLocation().latitude, paramAnonymousGeoCodeResult.getLocation().longitude);
      AptitudeMapActivity.a(AptitudeMapActivity.this).destroy();
    }
    
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramAnonymousReverseGeoCodeResult)
    {
      if ((paramAnonymousReverseGeoCodeResult != null) && (paramAnonymousReverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR)) {}
    }
  };
  OnGetPoiSearchResultListener e = new OnGetPoiSearchResultListener()
  {
    public void onGetPoiDetailResult(PoiDetailResult paramAnonymousPoiDetailResult)
    {
      Log.e("add", "onGetPoiDetailResult");
    }
    
    public void onGetPoiIndoorResult(PoiIndoorResult paramAnonymousPoiIndoorResult)
    {
      Log.e("add", "onGetPoiIndoorResult");
    }
    
    public void onGetPoiResult(PoiResult paramAnonymousPoiResult)
    {
      Log.e("add", "onGetPoiResult");
      AptitudeMapActivity.b(AptitudeMapActivity.this).clear();
      if ((paramAnonymousPoiResult != null) && (paramAnonymousPoiResult.getAllPoi() != null))
      {
        paramAnonymousPoiResult = paramAnonymousPoiResult.getAllPoi().iterator();
        while (paramAnonymousPoiResult.hasNext())
        {
          PoiInfo localPoiInfo = (PoiInfo)paramAnonymousPoiResult.next();
          if (localPoiInfo != null) {
            AptitudeMapActivity.b(AptitudeMapActivity.this).add(new a(localPoiInfo.name, localPoiInfo.address + localPoiInfo.name, localPoiInfo.location.latitude, localPoiInfo.location.longitude));
          }
        }
        AptitudeMapActivity.c(AptitudeMapActivity.this).setmList(AptitudeMapActivity.b(AptitudeMapActivity.this));
        AptitudeMapActivity.c(AptitudeMapActivity.this).notifyDataSetChanged();
        AptitudeMapActivity.this.dismissProgress();
        return;
      }
      AptitudeMapActivity.this.dismissProgress();
      AptitudeMapActivity.d(AptitudeMapActivity.this).setVisibility(8);
      AptitudeMapActivity.e(AptitudeMapActivity.this).setVisibility(0);
    }
  };
  private GeoCoder f;
  private MapView g;
  private BaiduMap r;
  private ListView s;
  private PoiSearch t;
  private LatLng u;
  private AptitudeMapListAdapter v;
  private List<a> w;
  private a x;
  private View y;
  
  private void a()
  {
    this.g = ((MapView)findViewById(2131689935));
    this.s = ((ListView)findViewById(2131689937));
    this.y = findViewById(2131689938);
    this.r = this.g.getMap();
    this.r.setMyLocationEnabled(true);
    this.r.setBuildingsEnabled(false);
    this.t = PoiSearch.newInstance();
    this.t.setOnGetPoiSearchResultListener(this.e);
    b();
    this.a = new LocationClient(getApplicationContext());
    this.a.registerLocationListener(this.b);
    e();
    this.a.start();
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    Object localObject = new LatLng(paramDouble1, paramDouble2);
    localObject = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target((LatLng)localObject).zoom(18.0F).build());
    this.r.setMapStatus((MapStatusUpdate)localObject);
  }
  
  private void a(MapStatus paramMapStatus)
  {
    paramMapStatus = paramMapStatus.target;
    this.u = new LatLng(paramMapStatus.latitude, paramMapStatus.longitude);
  }
  
  private void b()
  {
    findViewById(2131689936).setOnClickListener(this);
    findViewById(2131689934).setOnClickListener(this);
    findViewById(2131689492).setOnClickListener(this);
    this.r.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener()
    {
      public void onMapStatusChange(MapStatus paramAnonymousMapStatus)
      {
        AptitudeMapActivity.a(AptitudeMapActivity.this, paramAnonymousMapStatus);
      }
      
      public void onMapStatusChangeFinish(MapStatus paramAnonymousMapStatus)
      {
        AptitudeMapActivity.a(AptitudeMapActivity.this, paramAnonymousMapStatus);
        Log.e("add", "onMapStatusChangeFinish");
        PoiNearbySearchOption localPoiNearbySearchOption = new PoiNearbySearchOption();
        localPoiNearbySearchOption.keyword("写字楼");
        localPoiNearbySearchOption.sortType(PoiSortType.distance_from_near_to_far);
        localPoiNearbySearchOption.location(paramAnonymousMapStatus.target);
        localPoiNearbySearchOption.radius(1000);
        localPoiNearbySearchOption.pageCapacity(20);
        AptitudeMapActivity.f(AptitudeMapActivity.this).searchNearby(localPoiNearbySearchOption);
      }
      
      public void onMapStatusChangeStart(MapStatus paramAnonymousMapStatus)
      {
        AptitudeMapActivity.a(AptitudeMapActivity.this, paramAnonymousMapStatus);
      }
    });
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ((AptitudeMapListAdapter.ViewHolder)paramAnonymousView.getTag()).aptitude_address_check.setVisibility(0);
        AptitudeMapActivity.c(AptitudeMapActivity.this).setCurrentPos(paramAnonymousInt);
        AptitudeMapActivity.c(AptitudeMapActivity.this).notifyDataSetChanged();
        AptitudeMapActivity.a(AptitudeMapActivity.this, (a)AptitudeMapActivity.b(AptitudeMapActivity.this).get(paramAnonymousInt));
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.putExtra("aptitudemap", com.alibaba.fastjson.a.toJSONString(AptitudeMapActivity.g(AptitudeMapActivity.this)));
        AptitudeMapActivity.this.setResult(200, paramAnonymousAdapterView);
        AptitudeMapActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(1000);
    localLocationClientOption.setIsNeedAddress(true);
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setLocationNotify(true);
    localLocationClientOption.setIsNeedLocationDescribe(true);
    localLocationClientOption.setIsNeedLocationPoiList(true);
    localLocationClientOption.setIgnoreKillProcess(false);
    localLocationClientOption.SetIgnoreCacheException(false);
    localLocationClientOption.setEnableSimulateGps(false);
    this.a.setLocOption(localLocationClientOption);
  }
  
  public static final boolean isOPenLocation(Context paramContext)
  {
    paramContext = (LocationManager)paramContext.getSystemService("location");
    boolean bool1 = paramContext.isProviderEnabled("gps");
    boolean bool2 = paramContext.isProviderEnabled("network");
    return (bool1) || (bool2);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689936: 
      this.a.start();
      return;
    case 2131689934: 
      paramView = new Intent(this, AptitudeEditActivity.class);
      paramView.addFlags(33554432);
      startActivity(paramView);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903098);
    c = this;
    a();
    if (!checkNet(this)) {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
    }
    if (!isOPenLocation(this)) {
      g.textToast(this, "请打开定位功能");
    }
    this.w = new ArrayList();
    this.v = new AptitudeMapListAdapter(this, this.w);
    this.s.setAdapter(this.v);
    showProgress(null);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.g.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.g.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.g.onResume();
  }
  
  public class a
    implements BDLocationListener
  {
    public a() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      VdsAgent.onReceiveLocation(this, paramBDLocation);
      if ((paramBDLocation == null) || (AptitudeMapActivity.h(AptitudeMapActivity.this) == null)) {
        return;
      }
      Object localObject = new MyLocationData.Builder().accuracy(paramBDLocation.getRadius()).direction(100.0F).latitude(paramBDLocation.getLatitude()).longitude(paramBDLocation.getLongitude()).build();
      AptitudeMapActivity.i(AptitudeMapActivity.this).setMyLocationData((MyLocationData)localObject);
      AptitudeMapActivity.this.a.stop();
      AptitudeMapActivity.a(AptitudeMapActivity.this, paramBDLocation.getLatitude(), paramBDLocation.getLongitude());
      localObject = new PoiNearbySearchOption();
      ((PoiNearbySearchOption)localObject).keyword("写字楼");
      ((PoiNearbySearchOption)localObject).sortType(PoiSortType.distance_from_near_to_far);
      ((PoiNearbySearchOption)localObject).location(new LatLng(paramBDLocation.getLatitude(), paramBDLocation.getLongitude()));
      ((PoiNearbySearchOption)localObject).radius(1000);
      ((PoiNearbySearchOption)localObject).pageCapacity(20);
      AptitudeMapActivity.f(AptitudeMapActivity.this).searchNearby((PoiNearbySearchOption)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */