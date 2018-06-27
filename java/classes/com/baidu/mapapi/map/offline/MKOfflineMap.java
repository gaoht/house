package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.BMapManager;
import com.baidu.platform.comapi.map.s;
import com.baidu.platform.comapi.map.t;
import com.baidu.platform.comapi.map.v;
import com.baidu.platform.comapi.map.w;
import java.util.ArrayList;
import java.util.Iterator;

public class MKOfflineMap
{
  public static final int TYPE_DOWNLOAD_UPDATE = 0;
  public static final int TYPE_NEW_OFFLINE = 6;
  public static final int TYPE_VER_UPDATE = 4;
  private static final String a = MKOfflineMap.class.getSimpleName();
  private t b;
  private MKOfflineMapListener c;
  
  public void destroy()
  {
    this.b.d(0);
    this.b.b(null);
    this.b.b();
    BMapManager.destroy();
  }
  
  public ArrayList<MKOLUpdateElement> getAllUpdateInfo()
  {
    Object localObject = this.b.e();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(((w)((Iterator)localObject).next()).a()));
    }
    return localArrayList;
  }
  
  public ArrayList<MKOLSearchRecord> getHotCityList()
  {
    Object localObject = this.b.c();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((s)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public ArrayList<MKOLSearchRecord> getOfflineCityList()
  {
    Object localObject = this.b.d();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((s)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public MKOLUpdateElement getUpdateInfo(int paramInt)
  {
    w localw = this.b.g(paramInt);
    if (localw == null) {
      return null;
    }
    return OfflineMapUtil.getUpdatElementFromLocalMapElement(localw.a());
  }
  
  @Deprecated
  public int importOfflineData()
  {
    return importOfflineData(false);
  }
  
  @Deprecated
  public int importOfflineData(boolean paramBoolean)
  {
    int i = 0;
    ArrayList localArrayList = this.b.e();
    if (localArrayList != null) {
      i = localArrayList.size();
    }
    for (int j = i;; j = 0)
    {
      this.b.a(paramBoolean, true);
      localArrayList = this.b.e();
      if (localArrayList != null) {
        i = localArrayList.size();
      }
      return i - j;
    }
  }
  
  public boolean init(MKOfflineMapListener paramMKOfflineMapListener)
  {
    BMapManager.init();
    this.b = t.a();
    if (this.b == null) {
      return false;
    }
    this.b.a(new a(this));
    this.c = paramMKOfflineMapListener;
    return true;
  }
  
  public boolean pause(int paramInt)
  {
    return this.b.c(paramInt);
  }
  
  public boolean remove(int paramInt)
  {
    return this.b.e(paramInt);
  }
  
  public ArrayList<MKOLSearchRecord> searchCity(String paramString)
  {
    Object localObject = this.b.a(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((s)((Iterator)localObject).next()));
    }
    return paramString;
  }
  
  public boolean start(int paramInt)
  {
    if (this.b == null) {
      return false;
    }
    if (this.b.e() != null)
    {
      Iterator localIterator = this.b.e().iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (localw.a.a == paramInt)
        {
          if ((localw.a.j) || (localw.a.l == 2) || (localw.a.l == 3) || (localw.a.l == 6)) {
            return this.b.b(paramInt);
          }
          return false;
        }
      }
    }
    return this.b.a(paramInt);
  }
  
  public boolean update(int paramInt)
  {
    if (this.b == null) {
      return false;
    }
    if (this.b.e() != null)
    {
      Iterator localIterator = this.b.e().iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        if (localw.a.a == paramInt)
        {
          if (localw.a.j) {
            return this.b.f(paramInt);
          }
          return false;
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/offline/MKOfflineMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */