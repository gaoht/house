package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;

public final class MapPoi
{
  private static final String d = MapPoi.class.getSimpleName();
  String a;
  LatLng b;
  String c;
  
  void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("tx");
    this.b = CoordUtil.decodeNodeLocation(paramJSONObject.optString("geo"));
    this.c = paramJSONObject.optString("ud");
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public LatLng getPosition()
  {
    return this.b;
  }
  
  public String getUid()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MapPoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */