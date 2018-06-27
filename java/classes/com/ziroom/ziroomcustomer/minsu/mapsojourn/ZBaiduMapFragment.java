package com.ziroom.ziroomcustomer.minsu.mapsojourn;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData.Builder;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.UiSettings;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.e;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;

public class ZBaiduMapFragment
  extends BaseFragment
{
  FrameLayout a;
  MapView b;
  BaiduMap c;
  LayoutInflater d;
  com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c e;
  private Context f;
  private boolean g = false;
  private LocationClient h;
  private BDLocation i;
  
  private void a(BDLocation paramBDLocation)
  {
    BaiduMap localBaiduMap = this.c;
    if (paramBDLocation != null) {}
    for (boolean bool = true;; bool = false)
    {
      localBaiduMap.setMyLocationEnabled(bool);
      if (paramBDLocation != null)
      {
        paramBDLocation = new MyLocationData.Builder().accuracy(paramBDLocation.getRadius()).direction(0.0F).latitude(paramBDLocation.getLatitude()).longitude(paramBDLocation.getLongitude()).build();
        this.c.setMyLocationData(paramBDLocation);
      }
      return;
    }
  }
  
  private void c()
  {
    if (this.h == null) {
      return;
    }
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
    localLocationClientOption.setCoorType("bd09ll");
    localLocationClientOption.setScanSpan(10000);
    localLocationClientOption.setOpenGps(true);
    localLocationClientOption.setLocationNotify(true);
    localLocationClientOption.setIgnoreKillProcess(false);
    localLocationClientOption.SetIgnoreCacheException(false);
    localLocationClientOption.setEnableSimulateGps(false);
    this.h.setLocOption(localLocationClientOption);
  }
  
  public static ZBaiduMapFragment newInstance()
  {
    return new ZBaiduMapFragment();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e.initMapStylePath();
    MapView.setMapCustomEnable(true);
    org.greenrobot.eventbus.c.getDefault().register(this);
    paramViewGroup = paramLayoutInflater.inflate(2130903996, paramViewGroup, false);
    this.f = getActivity();
    this.d = paramLayoutInflater;
    this.a = ((FrameLayout)paramViewGroup);
    this.b = ((MapView)paramViewGroup.findViewById(2131690814));
    this.c = this.b.getMap();
    this.h = new LocationClient(getContext());
    this.h.registerLocationListener(new ZBaiduMapFragment.1(this));
    c();
    this.b.showScaleControl(false);
    this.b.showZoomControls(false);
    this.c.setMaxAndMinZoomLevel(20.0F, 10.0F);
    this.c.setOnMapLoadedCallback(new ZBaiduMapFragment.2(this));
    this.c.setOnMarkerClickListener(new ZBaiduMapFragment.3(this));
    this.c.setOnMapClickListener(new ZBaiduMapFragment.4(this));
    this.c.setOnMapLongClickListener(new ZBaiduMapFragment.5(this));
    this.c.setOnMapDoubleClickListener(new ZBaiduMapFragment.6(this));
    this.c.setOnMapStatusChangeListener(new ZBaiduMapFragment.7(this));
    this.c.setOnMyLocationClickListener(new ZBaiduMapFragment.8(this));
    paramLayoutInflater = this.c.getUiSettings();
    paramLayoutInflater.setOverlookingGesturesEnabled(false);
    paramLayoutInflater.setRotateGesturesEnabled(false);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (this.e != null) {
      org.greenrobot.eventbus.c.getDefault().removeStickyEvent(this.e);
    }
    org.greenrobot.eventbus.c.getDefault().unregister(this);
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
  
  public void onStart()
  {
    super.onStart();
    if (this.h != null) {
      this.h.start();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.h != null) {
      this.h.stop();
    }
  }
  
  @j(threadMode=ThreadMode.MAIN)
  public void onZBaiduMapEvent(com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c paramc)
  {
    if (this.c == null) {
      break label7;
    }
    label7:
    int j;
    do
    {
      do
      {
        return;
      } while ((paramc == null) || (TextUtils.isEmpty(paramc.getType())));
      localObject1 = paramc.getType();
      j = -1;
      switch (((String)localObject1).hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          return;
        case 0: 
          paramc = (MarkerOptions)paramc.getTag();
          if (paramc == null) {
            break label7;
          }
          paramc = (Marker)this.c.addOverlay(paramc);
          if (paramc == null) {
            break label7;
          }
          org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c("event_b_resp_on_add_bussinesscircle_marker", paramc));
          return;
          if (((String)localObject1).equals("event_a_add_bussinesscircle_marker"))
          {
            j = 0;
            continue;
            if (((String)localObject1).equals("event_a_add_my_location"))
            {
              j = 1;
              continue;
              if (((String)localObject1).equals("event_a_add_marker"))
              {
                j = 2;
                continue;
                if (((String)localObject1).equals("event_a_add_markers"))
                {
                  j = 3;
                  continue;
                  if (((String)localObject1).equals("event_a_add_overlay"))
                  {
                    j = 4;
                    continue;
                    if (((String)localObject1).equals("event_a_add_overlays"))
                    {
                      j = 5;
                      continue;
                      if (((String)localObject1).equals("event_a_change_map_status"))
                      {
                        j = 6;
                        continue;
                        if (((String)localObject1).equals("event_a_set_map_status"))
                        {
                          j = 7;
                          continue;
                          if (((String)localObject1).equals("event_a_clear"))
                          {
                            j = 8;
                            continue;
                            if (((String)localObject1).equals("event_a_req_map_status")) {
                              j = 9;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      this.i = ((BDLocation)paramc.getTag());
      a(this.i);
      return;
      localObject1 = (MarkerOptions)paramc.getTag();
    } while (localObject1 == null);
    Object localObject1 = (Marker)this.c.addOverlay((OverlayOptions)localObject1);
    if ((localObject1 != null) && (((Marker)localObject1).getIcon() != null)) {
      ((Marker)localObject1).getIcon().recycle();
    }
    if (paramc.getData() != null) {
      ((Marker)localObject1).setExtraInfo(paramc.getData());
    }
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c("event_b_resp_on_add_marker", localObject1));
    return;
    localObject1 = (List)paramc.getTag();
    if ((paramc.getData() != null) && (paramc.getData().containsKey("z_markers"))) {}
    for (paramc = paramc.getData().getParcelableArrayList("z_markers");; paramc = null)
    {
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label7;
      }
      ArrayList localArrayList = new ArrayList();
      j = 0;
      while (j < ((List)localObject1).size())
      {
        Object localObject2 = (MarkerOptions)((List)localObject1).get(j);
        localObject2 = (Marker)this.c.addOverlay((OverlayOptions)localObject2);
        localArrayList.add(localObject2);
        if ((paramc != null) && (paramc.size() == ((List)localObject1).size())) {
          new Bundle().putParcelable("z_marker", (Parcelable)paramc.get(j));
        }
        if ((localObject2 != null) && (((Marker)localObject2).getIcon() != null)) {
          ((Marker)localObject2).getIcon().recycle();
        }
        j += 1;
      }
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c("event_b_resp_on_add_markers", localArrayList));
      return;
      paramc = (OverlayOptions)paramc.getTag();
      if (paramc == null) {
        break label7;
      }
      paramc = this.c.addOverlay(paramc);
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c("event_b_resp_on_add_overlay", paramc));
      return;
      paramc = (List)paramc.getTag();
      if ((paramc == null) || (paramc.size() <= 0)) {
        break label7;
      }
      paramc = this.c.addOverlays(paramc);
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c("event_b_resp_on_add_overlays", paramc));
      return;
      paramc = (MapStatusUpdate)paramc.getTag();
      if (paramc == null) {
        break label7;
      }
      this.c.animateMapStatus(paramc);
      return;
      paramc = (MapStatusUpdate)paramc.getTag();
      if (paramc == null) {
        break label7;
      }
      this.c.setMapStatus(paramc);
      return;
      this.c.clear();
      return;
      paramc = this.c.getMapStatus();
      if (paramc == null) {
        break;
      }
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.minsu.mapsojourn.model.c("event_b_resp_map_status", paramc));
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/ZBaiduMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */