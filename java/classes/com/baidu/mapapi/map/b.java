package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b
  implements k
{
  b(BaiduMap paramBaiduMap) {}
  
  public void a() {}
  
  public void a(Bitmap paramBitmap)
  {
    if (BaiduMap.l(this.a) != null) {
      BaiduMap.l(this.a).onSnapshotReady(paramBitmap);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (BaiduMap.g(this.a) != null) {
      BaiduMap.g(this.a).onTouch(paramMotionEvent);
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    if (BaiduMap.h(this.a) != null)
    {
      paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
      BaiduMap.h(this.a).onMapClick(paramGeoPoint);
    }
  }
  
  public void a(D paramD)
  {
    if (BaiduMap.e(this.a) != null) {
      BaiduMap.e(this.a).setVisibility(4);
    }
    if (BaiduMap.f(this.a) != null)
    {
      paramD = MapStatus.a(paramD);
      BaiduMap.f(this.a).onMapStatusChangeStart(paramD);
    }
  }
  
  public void a(String paramString)
  {
    int i;
    Object localObject1;
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("dataset").optJSONObject(0);
      i = paramString.optInt("ty");
      if (i == 17)
      {
        if (BaiduMap.h(this.a) == null) {
          return;
        }
        localObject1 = new MapPoi();
        ((MapPoi)localObject1).a(paramString);
        BaiduMap.h(this.a).onMapPoiClick((MapPoi)localObject1);
        return;
      }
      if (i == 18)
      {
        if (BaiduMap.m(this.a) == null) {
          return;
        }
        BaiduMap.m(this.a).onMyLocationClick();
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (i == 19)
    {
      if (BaiduMap.b(this.a) != null)
      {
        paramString = BaiduMap.b(this.a).D();
        paramString.c = 0;
        paramString.b = 0;
        BaiduMap.b(this.a).a(paramString, 300);
      }
    }
    else
    {
      Object localObject2;
      if (i == 90909)
      {
        localObject1 = paramString.optString("marker_id");
        if ((BaiduMap.n(this.a) != null) && (((String)localObject1).equals(BaiduMap.o(this.a).p)))
        {
          paramString = BaiduMap.n(this.a).d;
          if (paramString != null) {
            paramString.onInfoWindowClick();
          }
        }
        else
        {
          localObject2 = BaiduMap.a(this.a).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramString = (Overlay)((Iterator)localObject2).next();
          } while ((!(paramString instanceof Marker)) || (!paramString.p.equals(localObject1)) || (BaiduMap.p(this.a) == null));
          localObject1 = BaiduMap.p(this.a).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((BaiduMap.OnMarkerClickListener)((Iterator)localObject1).next()).onMarkerClick((Marker)paramString);
          }
        }
      }
      else if (i == 90910)
      {
        paramString = paramString.optString("polyline_id");
        localObject1 = BaiduMap.a(this.a).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Overlay)((Iterator)localObject1).next();
          if (((localObject2 instanceof Polyline)) && (((Overlay)localObject2).p.equals(paramString)) && (BaiduMap.q(this.a) != null))
          {
            Iterator localIterator = BaiduMap.q(this.a).iterator();
            while (localIterator.hasNext()) {
              ((BaiduMap.OnPolylineClickListener)localIterator.next()).onPolylineClick((Polyline)localObject2);
            }
          }
        }
      }
    }
  }
  
  public void a(GL10 paramGL10, D paramD)
  {
    if (BaiduMap.w(this.a) != null)
    {
      paramD = MapStatus.a(paramD);
      BaiduMap.w(this.a).onMapDrawFrame(paramGL10, paramD);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (BaiduMap.x(this.a) != null)
    {
      MapBaseIndoorMapInfo localMapBaseIndoorMapInfo = this.a.getFocusedBaseIndoorMapInfo();
      BaiduMap.x(this.a).onBaseIndoorMapMode(paramBoolean, localMapBaseIndoorMapInfo);
    }
  }
  
  public void b()
  {
    BaiduMap.a(this.a, new Projection(BaiduMap.b(this.a)));
    BaiduMap.a(this.a, true);
    if (BaiduMap.k(this.a) != null) {
      BaiduMap.k(this.a).onMapLoaded();
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    if (BaiduMap.i(this.a) != null)
    {
      paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
      BaiduMap.i(this.a).onMapDoubleClick(paramGeoPoint);
    }
  }
  
  public void b(D paramD)
  {
    if (BaiduMap.f(this.a) != null)
    {
      paramD = MapStatus.a(paramD);
      BaiduMap.f(this.a).onMapStatusChange(paramD);
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("dataset").optJSONObject(0);
      if (paramString.optInt("ty") == 90909)
      {
        paramString = paramString.optString("marker_id");
        if ((BaiduMap.o(this.a) == null) || (!paramString.equals(BaiduMap.o(this.a).p)))
        {
          Iterator localIterator = BaiduMap.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            Overlay localOverlay = (Overlay)localIterator.next();
            if (((localOverlay instanceof Marker)) && (localOverlay.p.equals(paramString)))
            {
              paramString = (Marker)localOverlay;
              if (paramString.f)
              {
                BaiduMap.a(this.a, paramString);
                paramString = BaiduMap.s(this.a).toScreenLocation(BaiduMap.r(this.a).a);
                paramString = new Point(paramString.x, paramString.y - 60);
                paramString = BaiduMap.s(this.a).fromScreenLocation(paramString);
                BaiduMap.r(this.a).setPosition(paramString);
                if (BaiduMap.t(this.a) != null) {
                  BaiduMap.t(this.a).onMarkerDragStart(BaiduMap.r(this.a));
                }
                return true;
              }
            }
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void c()
  {
    BaiduMap.u(this.a).lock();
    try
    {
      if (BaiduMap.v(this.a) != null) {
        BaiduMap.v(this.a).a();
      }
      return;
    }
    finally
    {
      BaiduMap.u(this.a).unlock();
    }
  }
  
  public void c(GeoPoint paramGeoPoint)
  {
    if (BaiduMap.j(this.a) != null)
    {
      paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
      BaiduMap.j(this.a).onMapLongClick(paramGeoPoint);
    }
  }
  
  public void c(D paramD)
  {
    if (BaiduMap.e(this.a) != null) {
      BaiduMap.e(this.a).setVisibility(0);
    }
    if (BaiduMap.f(this.a) != null)
    {
      paramD = MapStatus.a(paramD);
      BaiduMap.f(this.a).onMapStatusChangeFinish(paramD);
    }
  }
  
  public void d()
  {
    BaiduMap.u(this.a).lock();
    try
    {
      if (BaiduMap.v(this.a) != null)
      {
        BaiduMap.v(this.a).a();
        BaiduMap.b(this.a).n();
      }
      return;
    }
    finally
    {
      BaiduMap.u(this.a).unlock();
    }
  }
  
  public void d(GeoPoint paramGeoPoint)
  {
    if ((BaiduMap.r(this.a) != null) && (BaiduMap.r(this.a).f))
    {
      paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
      paramGeoPoint = BaiduMap.s(this.a).toScreenLocation(paramGeoPoint);
      paramGeoPoint = new Point(paramGeoPoint.x, paramGeoPoint.y - 60);
      paramGeoPoint = BaiduMap.s(this.a).fromScreenLocation(paramGeoPoint);
      BaiduMap.r(this.a).setPosition(paramGeoPoint);
      if ((BaiduMap.t(this.a) != null) && (BaiduMap.r(this.a).f)) {
        BaiduMap.t(this.a).onMarkerDrag(BaiduMap.r(this.a));
      }
    }
  }
  
  public void e()
  {
    BaiduMap.b(this.a).b(false);
    BaiduMap.u(this.a).lock();
    try
    {
      if (BaiduMap.v(this.a) != null) {
        this.a.a(BaiduMap.v(this.a));
      }
      return;
    }
    finally
    {
      BaiduMap.u(this.a).unlock();
    }
  }
  
  public void e(GeoPoint paramGeoPoint)
  {
    if ((BaiduMap.r(this.a) != null) && (BaiduMap.r(this.a).f))
    {
      paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
      paramGeoPoint = BaiduMap.s(this.a).toScreenLocation(paramGeoPoint);
      paramGeoPoint = new Point(paramGeoPoint.x, paramGeoPoint.y - 60);
      paramGeoPoint = BaiduMap.s(this.a).fromScreenLocation(paramGeoPoint);
      BaiduMap.r(this.a).setPosition(paramGeoPoint);
      if ((BaiduMap.t(this.a) != null) && (BaiduMap.r(this.a).f)) {
        BaiduMap.t(this.a).onMarkerDragEnd(BaiduMap.r(this.a));
      }
      BaiduMap.a(this.a, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */