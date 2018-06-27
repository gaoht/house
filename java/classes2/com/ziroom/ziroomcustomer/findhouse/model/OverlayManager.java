package com.ziroom.ziroomcustomer.findhouse.model;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class OverlayManager
  implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener
{
  BaiduMap mBaiduMap = null;
  List<Overlay> mOverlayList = null;
  private List<OverlayOptions> mOverlayOptionList = null;
  
  public OverlayManager(BaiduMap paramBaiduMap)
  {
    this.mBaiduMap = paramBaiduMap;
    if (this.mOverlayOptionList == null) {
      this.mOverlayOptionList = new ArrayList();
    }
    if (this.mOverlayList == null) {
      this.mOverlayList = new ArrayList();
    }
  }
  
  public final void addToMap()
  {
    if (this.mBaiduMap == null) {}
    for (;;)
    {
      return;
      removeFromMap();
      Object localObject = getOverlayOptions();
      if (localObject != null) {
        this.mOverlayOptionList.addAll((Collection)localObject);
      }
      localObject = this.mOverlayOptionList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        OverlayOptions localOverlayOptions = (OverlayOptions)((Iterator)localObject).next();
        this.mOverlayList.add(this.mBaiduMap.addOverlay(localOverlayOptions));
      }
    }
  }
  
  public abstract List<OverlayOptions> getOverlayOptions();
  
  public final void removeFromMap()
  {
    if (this.mBaiduMap == null) {
      return;
    }
    Iterator localIterator = this.mOverlayList.iterator();
    while (localIterator.hasNext()) {
      ((Overlay)localIterator.next()).remove();
    }
    this.mOverlayOptionList.clear();
    this.mOverlayList.clear();
  }
  
  public void zoomToSpan()
  {
    if (this.mBaiduMap == null) {}
    while (this.mOverlayList.size() <= 0) {
      return;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    Iterator localIterator = this.mOverlayList.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Marker)) {
        localBuilder.include(((Marker)localOverlay).getPosition());
      }
    }
    this.mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(localBuilder.build()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/OverlayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */