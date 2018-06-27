package com.ziroom.ziroomcustomer.util.b;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  extends b
{
  private WalkingRouteLine a = null;
  
  public d(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }
  
  public int getLineColor()
  {
    return 0;
  }
  
  public final List<OverlayOptions> getOverlayOptions()
  {
    List localList = null;
    if (this.a == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.a.getAllStep() != null) && (this.a.getAllStep().size() > 0))
    {
      localObject1 = this.a.getAllStep().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WalkingRouteLine.WalkingStep)((Iterator)localObject1).next();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("index", this.a.getAllStep().indexOf(localObject2));
        if (((WalkingRouteLine.WalkingStep)localObject2).getEntrance() != null) {
          localArrayList.add(new MarkerOptions().position(((WalkingRouteLine.WalkingStep)localObject2).getEntrance().getLocation()).rotate(360 - ((WalkingRouteLine.WalkingStep)localObject2).getDirection()).zIndex(10).anchor(0.5F, 0.5F).extraInfo((Bundle)localObject3).icon(BitmapDescriptorFactory.fromAssetWithDpi("Icon_line_node.png")));
        }
        if ((this.a.getAllStep().indexOf(localObject2) == this.a.getAllStep().size() - 1) && (((WalkingRouteLine.WalkingStep)localObject2).getExit() != null)) {
          localArrayList.add(new MarkerOptions().position(((WalkingRouteLine.WalkingStep)localObject2).getExit().getLocation()).anchor(0.5F, 0.5F).zIndex(10).icon(BitmapDescriptorFactory.fromAssetWithDpi("Icon_line_node.png")));
        }
      }
    }
    label375:
    label435:
    int i;
    if (this.a.getStarting() != null)
    {
      localObject2 = new MarkerOptions().position(this.a.getStarting().getLocation());
      if (getStartMarker() != null)
      {
        localObject1 = getStartMarker();
        localArrayList.add(((MarkerOptions)localObject2).icon((BitmapDescriptor)localObject1).zIndex(10));
      }
    }
    else
    {
      if (this.a.getTerminal() != null)
      {
        localObject2 = new MarkerOptions().position(this.a.getTerminal().getLocation());
        if (getTerminalMarker() == null) {
          break label571;
        }
        localObject1 = getTerminalMarker();
        localArrayList.add(((MarkerOptions)localObject2).icon((BitmapDescriptor)localObject1).zIndex(10));
      }
      if ((this.a.getAllStep() == null) || (this.a.getAllStep().size() <= 0)) {
        break label596;
      }
      localObject2 = this.a.getAllStep().iterator();
      localObject1 = localList;
      if (!((Iterator)localObject2).hasNext()) {
        break label596;
      }
      localList = ((WalkingRouteLine.WalkingStep)((Iterator)localObject2).next()).getWayPoints();
      if (localList == null) {
        break label599;
      }
      localObject3 = new ArrayList();
      if (localObject1 != null) {
        ((List)localObject3).add(localObject1);
      }
      ((List)localObject3).addAll(localList);
      localObject1 = new PolylineOptions().points((List)localObject3).width(10);
      if (getLineColor() == 0) {
        break label580;
      }
      i = getLineColor();
      label524:
      localArrayList.add(((PolylineOptions)localObject1).color(i).zIndex(0));
      localObject1 = (LatLng)localList.get(localList.size() - 1);
    }
    label571:
    label580:
    label596:
    label599:
    for (;;)
    {
      break label435;
      localObject1 = BitmapDescriptorFactory.fromAssetWithDpi("Icon_start.png");
      break;
      localObject1 = BitmapDescriptorFactory.fromAssetWithDpi("Icon_end.png");
      break label375;
      i = Color.argb(178, 0, 78, 255);
      break label524;
      return localArrayList;
    }
  }
  
  public BitmapDescriptor getStartMarker()
  {
    return null;
  }
  
  public BitmapDescriptor getTerminalMarker()
  {
    return null;
  }
  
  public final boolean onMarkerClick(Marker paramMarker)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if (((localOverlay instanceof Marker)) && (localOverlay.equals(paramMarker)) && (paramMarker.getExtraInfo() != null)) {
        onRouteNodeClick(paramMarker.getExtraInfo().getInt("index"));
      }
    }
    return true;
  }
  
  public boolean onPolylineClick(Polyline paramPolyline)
  {
    return false;
  }
  
  public boolean onRouteNodeClick(int paramInt)
  {
    if ((this.a.getAllStep() != null) && (this.a.getAllStep().get(paramInt) != null)) {
      Log.i("baidumapsdk", "WalkingRouteOverlay onRouteNodeClick");
    }
    return false;
  }
  
  public void setData(WalkingRouteLine paramWalkingRouteLine)
  {
    this.a = paramWalkingRouteLine;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */