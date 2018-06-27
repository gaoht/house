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
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.TransitRouteStepType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  extends b
{
  private TransitRouteLine a = null;
  
  public c(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }
  
  private BitmapDescriptor a(TransitRouteLine.TransitStep paramTransitStep)
  {
    switch (1.a[paramTransitStep.getStepType().ordinal()])
    {
    default: 
      return null;
    case 1: 
      return BitmapDescriptorFactory.fromAssetWithDpi("Icon_bus_station.png");
    case 2: 
      return BitmapDescriptorFactory.fromAssetWithDpi("Icon_subway_station.png");
    }
    return BitmapDescriptorFactory.fromAssetWithDpi("Icon_walk_route.png");
  }
  
  public int getLineColor()
  {
    return 0;
  }
  
  public final List<OverlayOptions> getOverlayOptions()
  {
    if (this.a == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    if ((this.a.getAllStep() != null) && (this.a.getAllStep().size() > 0))
    {
      localObject1 = this.a.getAllStep().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TransitRouteLine.TransitStep)((Iterator)localObject1).next();
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", this.a.getAllStep().indexOf(localObject2));
        if (((TransitRouteLine.TransitStep)localObject2).getEntrance() != null) {
          localArrayList.add(new MarkerOptions().position(((TransitRouteLine.TransitStep)localObject2).getEntrance().getLocation()).anchor(0.5F, 0.5F).zIndex(10).extraInfo(localBundle).icon(a((TransitRouteLine.TransitStep)localObject2)));
        }
        if ((this.a.getAllStep().indexOf(localObject2) == this.a.getAllStep().size() - 1) && (((TransitRouteLine.TransitStep)localObject2).getExit() != null)) {
          localArrayList.add(new MarkerOptions().position(((TransitRouteLine.TransitStep)localObject2).getExit().getLocation()).anchor(0.5F, 0.5F).zIndex(10).icon(a((TransitRouteLine.TransitStep)localObject2)));
        }
      }
    }
    label358:
    label414:
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
          break label526;
        }
        localObject1 = getTerminalMarker();
        localArrayList.add(((MarkerOptions)localObject2).icon((BitmapDescriptor)localObject1).zIndex(10));
      }
      if ((this.a.getAllStep() == null) || (this.a.getAllStep().size() <= 0)) {
        return localArrayList;
      }
      localObject1 = this.a.getAllStep().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (TransitRouteLine.TransitStep)((Iterator)localObject1).next();
      } while ((((TransitRouteLine.TransitStep)localObject2).getWayPoints() == null) || (((TransitRouteLine.TransitStep)localObject2).getWayPoints().size() < 2));
      if (((TransitRouteLine.TransitStep)localObject2).getStepType() == TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING) {
        break label551;
      }
      if (getLineColor() == 0) {
        break label535;
      }
      i = getLineColor();
    }
    for (;;)
    {
      localArrayList.add(new PolylineOptions().points(((TransitRouteLine.TransitStep)localObject2).getWayPoints()).width(10).color(i).zIndex(0));
      break label414;
      localObject1 = BitmapDescriptorFactory.fromAssetWithDpi("Icon_start.png");
      break;
      label526:
      localObject1 = BitmapDescriptorFactory.fromAssetWithDpi("Icon_end.png");
      break label358;
      label535:
      i = Color.argb(178, 0, 78, 255);
      continue;
      label551:
      if (getLineColor() != 0) {
        i = getLineColor();
      } else {
        i = Color.argb(178, 88, 208, 0);
      }
    }
    return localArrayList;
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
      Log.i("baidumapsdk", "TransitRouteOverlay onRouteNodeClick");
    }
    return false;
  }
  
  public void setData(TransitRouteLine paramTransitRouteLine)
  {
    this.a = paramTransitRouteLine;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */