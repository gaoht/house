package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;

public class SpatialRelationUtil
{
  private static LatLng a(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    paramLatLng1 = CoordUtil.ll2mc(paramLatLng1);
    paramLatLng2 = CoordUtil.ll2mc(paramLatLng2);
    paramLatLng3 = CoordUtil.ll2mc(paramLatLng3);
    double d1 = Math.sqrt((paramLatLng1.getLongitudeE6() - paramLatLng1.getLongitudeE6()) * (paramLatLng2.getLongitudeE6() - paramLatLng1.getLongitudeE6()) + (paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()) * (paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()));
    double d2 = paramLatLng2.getLongitudeE6();
    double d3 = paramLatLng1.getLongitudeE6();
    double d4 = paramLatLng3.getLongitudeE6();
    double d5 = paramLatLng1.getLongitudeE6();
    double d6 = paramLatLng2.getLatitudeE6();
    double d7 = paramLatLng1.getLatitudeE6();
    d1 = ((paramLatLng3.getLatitudeE6() - paramLatLng1.getLatitudeE6()) * (d6 - d7) + (d2 - d3) * (d4 - d5)) / (d1 * d1);
    d2 = paramLatLng1.getLongitudeE6();
    d3 = paramLatLng2.getLongitudeE6();
    d4 = paramLatLng1.getLongitudeE6();
    d5 = paramLatLng1.getLatitudeE6();
    return CoordUtil.mc2ll(new GeoPoint((paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()) * d1 + d5, d2 + (d3 - d4) * d1));
  }
  
  public static LatLng getNearestPointFromLine(List<LatLng> paramList, LatLng paramLatLng)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramLatLng == null)) {
      localObject2 = null;
    }
    int i;
    Object localObject1;
    do
    {
      return (LatLng)localObject2;
      i = 0;
      localObject1 = null;
      localObject2 = localObject1;
    } while (i >= paramList.size() - 1);
    Object localObject2 = a((LatLng)paramList.get(i), (LatLng)paramList.get(i + 1), paramLatLng);
    if (((((LatLng)localObject2).latitude - ((LatLng)paramList.get(i)).latitude) * (((LatLng)localObject2).latitude - ((LatLng)paramList.get(i + 1)).latitude) <= 0.0D) && ((((LatLng)localObject2).longitude - ((LatLng)paramList.get(i)).longitude) * (((LatLng)localObject2).longitude - ((LatLng)paramList.get(i + 1)).longitude) <= 0.0D))
    {
      label162:
      localObject3 = localObject2;
      if (localObject1 != null) {
        if (DistanceUtil.getDistance(paramLatLng, (LatLng)localObject2) >= DistanceUtil.getDistance(paramLatLng, (LatLng)localObject1)) {
          break label265;
        }
      }
    }
    label265:
    for (Object localObject3 = localObject2;; localObject3 = localObject1)
    {
      i += 1;
      localObject1 = localObject3;
      break;
      if (DistanceUtil.getDistance(paramLatLng, (LatLng)paramList.get(i)) < DistanceUtil.getDistance(paramLatLng, (LatLng)paramList.get(i + 1)))
      {
        localObject2 = (LatLng)paramList.get(i);
        break label162;
      }
      localObject2 = (LatLng)paramList.get(i + 1);
      break label162;
    }
  }
  
  public static boolean isCircleContainsPoint(LatLng paramLatLng1, int paramInt, LatLng paramLatLng2)
  {
    if ((paramLatLng1 == null) || (paramInt == 0) || (paramLatLng2 == null)) {}
    double d;
    do
    {
      return false;
      d = DistanceUtil.getDistance(paramLatLng1, paramLatLng2);
    } while (d > paramInt);
    return d == paramInt;
  }
  
  public static boolean isPolygonContainsPoint(List<LatLng> paramList, LatLng paramLatLng)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if ((paramList == null) || (paramList.size() == 0) || (paramLatLng == null))
    {
      bool1 = false;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label100;
      }
      if (paramLatLng.longitude == ((LatLng)paramList.get(i)).longitude)
      {
        bool1 = bool2;
        if (paramLatLng.latitude == ((LatLng)paramList.get(i)).latitude) {
          break;
        }
      }
      i += 1;
    }
    label100:
    int k = paramList.size();
    int j = 0;
    i = 0;
    label114:
    LatLng localLatLng1;
    LatLng localLatLng2;
    if (j < k)
    {
      localLatLng1 = (LatLng)paramList.get(j);
      localLatLng2 = (LatLng)paramList.get((j + 1) % k);
      if (localLatLng1.latitude != localLatLng2.latitude) {}
    }
    for (;;)
    {
      j += 1;
      break label114;
      if ((paramLatLng.latitude >= Math.min(localLatLng1.latitude, localLatLng2.latitude)) && (paramLatLng.latitude <= Math.max(localLatLng1.latitude, localLatLng2.latitude)))
      {
        double d = (paramLatLng.latitude - localLatLng1.latitude) * (localLatLng2.longitude - localLatLng1.longitude) / (localLatLng2.latitude - localLatLng1.latitude);
        d = localLatLng1.longitude + d;
        bool1 = bool2;
        if (d == paramLatLng.longitude) {
          break;
        }
        if (d < paramLatLng.longitude)
        {
          i += 1;
          continue;
          bool1 = bool3;
          if (i % 2 == 1) {
            bool1 = true;
          }
          return bool1;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/SpatialRelationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */