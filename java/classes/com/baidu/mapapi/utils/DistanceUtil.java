package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;

public class DistanceUtil
{
  public static double getDistance(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null)) {}
    do
    {
      return -1.0D;
      paramLatLng1 = CoordUtil.ll2point(paramLatLng1);
      paramLatLng2 = CoordUtil.ll2point(paramLatLng2);
    } while ((paramLatLng1 == null) || (paramLatLng2 == null));
    return CoordUtil.getDistance(paramLatLng1, paramLatLng2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/DistanceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */