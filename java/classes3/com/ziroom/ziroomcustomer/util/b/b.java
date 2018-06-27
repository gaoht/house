package com.ziroom.ziroomcustomer.util.b;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnPolylineClickListener;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class b
  implements BaiduMap.OnMarkerClickListener, BaiduMap.OnPolylineClickListener
{
  private List<OverlayOptions> a = null;
  BaiduMap c = null;
  List<Overlay> d = null;
  
  public b(BaiduMap paramBaiduMap)
  {
    this.c = paramBaiduMap;
    if (this.a == null) {
      this.a = new ArrayList();
    }
    if (this.d == null) {
      this.d = new ArrayList();
    }
  }
  
  public final void addToMap()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      removeFromMap();
      if (getOverlayOptions() != null) {
        this.a.addAll(getOverlayOptions());
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        OverlayOptions localOverlayOptions = (OverlayOptions)localIterator.next();
        this.d.add(this.c.addOverlay(localOverlayOptions));
      }
    }
  }
  
  public abstract List<OverlayOptions> getOverlayOptions();
  
  public final void removeFromMap()
  {
    if (this.c == null) {
      return;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((Overlay)localIterator.next()).remove();
    }
    this.a.clear();
    this.d.clear();
  }
  
  public void zoomToSpan()
  {
    if (this.c == null) {}
    while (this.d.size() <= 0) {
      return;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Marker)) {
        localBuilder.include(((Marker)localOverlay).getPosition());
      }
    }
    this.c.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(localBuilder.build()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */