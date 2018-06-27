package com.ziroom.ziroomcustomer.findhouse.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.PoiResult;
import java.util.ArrayList;
import java.util.List;

public class ResblockPoiOverlay
  extends OverlayManager
{
  private static final int MAX_POI_SIZE = 10;
  private List<BitmapDescriptor> mBitmapDescriptor;
  private PoiResult mPoiResult = null;
  
  public ResblockPoiOverlay(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }
  
  public final List<OverlayOptions> getOverlayOptions()
  {
    if ((this.mPoiResult == null) || (this.mPoiResult.getAllPoi() == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if ((i < this.mPoiResult.getAllPoi().size()) && (j < 10))
    {
      if (((PoiInfo)this.mPoiResult.getAllPoi().get(i)).location == null) {}
      for (;;)
      {
        i += 1;
        break;
        j += 1;
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("PoiInfo", (Parcelable)this.mPoiResult.getAllPoi().get(i));
        localArrayList.add(new MarkerOptions().icon((BitmapDescriptor)this.mBitmapDescriptor.get(i)).extraInfo(localBundle).position(((PoiInfo)this.mPoiResult.getAllPoi().get(i)).location));
      }
    }
    return localArrayList;
  }
  
  public PoiResult getPoiResult()
  {
    return this.mPoiResult;
  }
  
  public final boolean onMarkerClick(Marker paramMarker)
  {
    if (!this.mOverlayList.contains(paramMarker)) {
      return false;
    }
    onPoiClick((PoiInfo)paramMarker.getExtraInfo().get("PoiInfo"));
    return false;
  }
  
  public boolean onPoiClick(PoiInfo paramPoiInfo)
  {
    return false;
  }
  
  public boolean onPolylineClick(Polyline paramPolyline)
  {
    return false;
  }
  
  public void setBitmapDescriptor(List<BitmapDescriptor> paramList)
  {
    if (paramList != null) {
      this.mBitmapDescriptor = paramList;
    }
  }
  
  public void setData(PoiResult paramPoiResult)
  {
    this.mPoiResult = paramPoiResult;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/ResblockPoiOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */