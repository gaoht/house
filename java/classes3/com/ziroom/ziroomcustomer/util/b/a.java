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
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends b
{
  private DrivingRouteLine a = null;
  boolean b = false;
  
  public a(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }
  
  public List<BitmapDescriptor> getCustomTextureList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_blue_arrow.png"));
    localArrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_green_arrow.png"));
    localArrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_yellow_arrow.png"));
    localArrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_red_arrow.png"));
    localArrayList.add(BitmapDescriptorFactory.fromAsset("Icon_road_nofocus.png"));
    return localArrayList;
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
    Object localObject3;
    if ((this.a.getAllStep() != null) && (this.a.getAllStep().size() > 0))
    {
      localObject1 = this.a.getAllStep().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DrivingRouteLine.DrivingStep)((Iterator)localObject1).next();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("index", this.a.getAllStep().indexOf(localObject2));
        if (((DrivingRouteLine.DrivingStep)localObject2).getEntrance() != null) {
          localArrayList.add(new MarkerOptions().position(((DrivingRouteLine.DrivingStep)localObject2).getEntrance().getLocation()).anchor(0.5F, 0.5F).zIndex(10).rotate(360 - ((DrivingRouteLine.DrivingStep)localObject2).getDirection()).extraInfo((Bundle)localObject3).icon(BitmapDescriptorFactory.fromAssetWithDpi("Icon_line_node.png")));
        }
        if ((this.a.getAllStep().indexOf(localObject2) == this.a.getAllStep().size() - 1) && (((DrivingRouteLine.DrivingStep)localObject2).getExit() != null)) {
          localArrayList.add(new MarkerOptions().position(((DrivingRouteLine.DrivingStep)localObject2).getExit().getLocation()).anchor(0.5F, 0.5F).zIndex(10).icon(BitmapDescriptorFactory.fromAssetWithDpi("Icon_line_node.png")));
        }
      }
    }
    label379:
    int m;
    int j;
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
          break label619;
        }
        localObject1 = getTerminalMarker();
        localArrayList.add(((MarkerOptions)localObject2).icon((BitmapDescriptor)localObject1).zIndex(10));
      }
      if ((this.a.getAllStep() == null) || (this.a.getAllStep().size() <= 0)) {
        break label793;
      }
      localObject1 = this.a.getAllStep();
      m = ((List)localObject1).size();
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if (j >= m) {
        break label695;
      }
      if (j == m - 1) {
        ((List)localObject2).addAll(((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getWayPoints());
      }
      int n;
      for (;;)
      {
        n = ((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getWayPoints().size();
        if ((((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getTrafficList() == null) || (((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getTrafficList().length <= 0)) {
          break label681;
        }
        int k = 0;
        while (k < ((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getTrafficList().length)
        {
          ((ArrayList)localObject3).add(Integer.valueOf(((DrivingRouteLine.DrivingStep)localObject1.get(j)).getTrafficList()[k]));
          k += 1;
        }
        localObject1 = BitmapDescriptorFactory.fromAssetWithDpi("Icon_start.png");
        break;
        label619:
        localObject1 = BitmapDescriptorFactory.fromAssetWithDpi("Icon_end.png");
        break label379;
        ((List)localObject2).addAll(((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getWayPoints().subList(0, ((DrivingRouteLine.DrivingStep)((List)localObject1).get(j)).getWayPoints().size() - 1));
      }
      label681:
      j += 1;
      i += n - 1;
    }
    label695:
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new PolylineOptions().points((List)localObject2).textureIndex((List)localObject3).width(7).dottedLine(bool).focus(true);
      if (getLineColor() != 0) {}
      for (i = getLineColor();; i = Color.argb(178, 0, 78, 255))
      {
        localObject1 = ((PolylineOptions)localObject1).color(i).zIndex(0);
        if (bool) {
          ((PolylineOptions)localObject1).customTextureList(getCustomTextureList());
        }
        localArrayList.add(localObject1);
        label793:
        return localArrayList;
      }
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
    Iterator localIterator = this.d.iterator();
    Overlay localOverlay;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localOverlay = (Overlay)localIterator.next();
    } while ((!(localOverlay instanceof Polyline)) || (!localOverlay.equals(paramPolyline)));
    for (boolean bool = true;; bool = false)
    {
      setFocus(bool);
      return true;
    }
  }
  
  public boolean onRouteNodeClick(int paramInt)
  {
    if ((this.a.getAllStep() != null) && (this.a.getAllStep().get(paramInt) != null)) {
      Log.i("baidumapsdk", "DrivingRouteOverlay onRouteNodeClick");
    }
    return false;
  }
  
  public void setData(DrivingRouteLine paramDrivingRouteLine)
  {
    this.a = paramDrivingRouteLine;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    this.b = paramBoolean;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Polyline)) {
        ((Polyline)localOverlay).setFocus(paramBoolean);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */