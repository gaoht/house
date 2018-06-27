package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.map.s;
import com.baidu.platform.comapi.map.v;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineMapUtil
{
  public static MKOLSearchRecord getSearchRecordFromLocalCityInfo(s params)
  {
    if (params == null) {
      return null;
    }
    MKOLSearchRecord localMKOLSearchRecord = new MKOLSearchRecord();
    localMKOLSearchRecord.cityID = params.a;
    localMKOLSearchRecord.cityName = params.b;
    localMKOLSearchRecord.cityType = params.d;
    if (params.a() != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = params.a().iterator();
      for (int i = 0;; i = j + i)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        s locals = (s)localIterator.next();
        localArrayList.add(getSearchRecordFromLocalCityInfo(locals));
        j = locals.c;
        localMKOLSearchRecord.childCities = localArrayList;
      }
    }
    int j = 0;
    if (localMKOLSearchRecord.cityType == 1) {}
    for (localMKOLSearchRecord.size = j;; localMKOLSearchRecord.size = params.c) {
      return localMKOLSearchRecord;
    }
  }
  
  public static MKOLUpdateElement getUpdatElementFromLocalMapElement(v paramv)
  {
    if (paramv == null) {
      return null;
    }
    MKOLUpdateElement localMKOLUpdateElement = new MKOLUpdateElement();
    localMKOLUpdateElement.cityID = paramv.a;
    localMKOLUpdateElement.cityName = paramv.b;
    if (paramv.g != null) {
      localMKOLUpdateElement.geoPt = CoordUtil.mc2ll(paramv.g);
    }
    localMKOLUpdateElement.level = paramv.e;
    localMKOLUpdateElement.ratio = paramv.i;
    localMKOLUpdateElement.serversize = paramv.h;
    if (paramv.i == 100) {}
    for (localMKOLUpdateElement.size = paramv.h;; localMKOLUpdateElement.size = (paramv.h / 100 * paramv.i))
    {
      localMKOLUpdateElement.status = paramv.l;
      localMKOLUpdateElement.update = paramv.j;
      return localMKOLUpdateElement;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/offline/OfflineMapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */