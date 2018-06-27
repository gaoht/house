package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.C;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.E;
import com.baidu.platform.comapi.map.K;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.h;
import com.baidu.platform.comapi.map.i;
import com.baidu.platform.comapi.map.k;
import com.baidu.platform.comapi.map.p;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduMap
{
  public static final int MAP_TYPE_NONE = 3;
  public static final int MAP_TYPE_NORMAL = 1;
  public static final int MAP_TYPE_SATELLITE = 2;
  private static final String e = BaiduMap.class.getSimpleName();
  private OnBaseIndoorMapListener A;
  private TileOverlay B;
  private HeatMap C;
  private Lock D = new ReentrantLock();
  private Lock E = new ReentrantLock();
  private InfoWindow F;
  private Marker G;
  private View H;
  private Marker I;
  private MyLocationData J;
  private MyLocationConfiguration K;
  private boolean L;
  private boolean M;
  private boolean N;
  private boolean O;
  private Point P;
  MapView a;
  TextureMapView b;
  WearMapView c;
  C d;
  private Projection f;
  private UiSettings g;
  private i h;
  private e i;
  private E j;
  private List<Overlay> k;
  private List<Marker> l;
  private List<Marker> m;
  private Overlay.a n;
  private OnMapStatusChangeListener o;
  private OnMapTouchListener p;
  private OnMapClickListener q;
  private OnMapLoadedCallback r;
  private OnMapDoubleClickListener s;
  private OnMapLongClickListener t;
  private CopyOnWriteArrayList<OnMarkerClickListener> u = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<OnPolylineClickListener> v = new CopyOnWriteArrayList();
  private OnMarkerDragListener w;
  private OnMyLocationClickListener x;
  private SnapshotReadyCallback y;
  private OnMapDrawFrameCallback z;
  
  BaiduMap(E paramE)
  {
    this.j = paramE;
    this.i = this.j.b();
    this.d = C.b;
    c();
  }
  
  BaiduMap(i parami)
  {
    this.h = parami;
    this.i = this.h.a();
    this.d = C.a;
    c();
  }
  
  private Point a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",");
    int i4 = paramString.length;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (i1 < i4)
    {
      String[] arrayOfString = paramString[i1].replaceAll("\"", "").split(":");
      if ("x".equals(arrayOfString[0])) {
        i3 = Integer.valueOf(arrayOfString[1]).intValue();
      }
      if ("y".equals(arrayOfString[0])) {
        i2 = Integer.valueOf(arrayOfString[1]).intValue();
      }
      i1 += 1;
    }
    return new Point(i3, i2);
  }
  
  private D a(MapStatusUpdate paramMapStatusUpdate)
  {
    if (this.i == null) {
      return null;
    }
    D localD = this.i.D();
    return paramMapStatusUpdate.a(this.i, getMapStatus()).b(localD);
  }
  
  private final void a(MyLocationData paramMyLocationData, MyLocationConfiguration paramMyLocationConfiguration)
  {
    int i1 = 0;
    if ((paramMyLocationData == null) || (paramMyLocationConfiguration == null) || (!isMyLocationEnabled())) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    Object localObject3 = new LatLng(paramMyLocationData.latitude, paramMyLocationData.longitude);
    Object localObject4 = CoordUtil.ll2mc((LatLng)localObject3);
    for (;;)
    {
      try
      {
        localJSONObject.put("type", 0);
        ((JSONObject)localObject1).put("ptx", ((GeoPoint)localObject4).getLongitudeE6());
        ((JSONObject)localObject1).put("pty", ((GeoPoint)localObject4).getLatitudeE6());
        ((JSONObject)localObject1).put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius((LatLng)localObject3, (int)paramMyLocationData.accuracy));
        f1 = paramMyLocationData.direction;
        if (!paramMyLocationConfiguration.enableDirection) {
          continue;
        }
        f2 = paramMyLocationData.direction % 360.0F;
        if (f2 <= 180.0F) {
          continue;
        }
        f1 = f2 - 360.0F;
        ((JSONObject)localObject1).put("direction", f1);
        ((JSONObject)localObject1).put("iconarrownor", "NormalLocArrow");
        ((JSONObject)localObject1).put("iconarrownorid", 28);
        ((JSONObject)localObject1).put("iconarrowfoc", "FocusLocArrow");
        ((JSONObject)localObject1).put("iconarrowfocid", 29);
        ((JSONObject)localObject1).put("lineid", paramMyLocationConfiguration.accuracyCircleStrokeColor);
        ((JSONObject)localObject1).put("areaid", paramMyLocationConfiguration.accuracyCircleFillColor);
        localJSONArray.put(localObject1);
        localJSONObject.put("data", localJSONArray);
        if (paramMyLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS)
        {
          ((JSONObject)localObject2).put("ptx", ((GeoPoint)localObject4).getLongitudeE6());
          ((JSONObject)localObject2).put("pty", ((GeoPoint)localObject4).getLatitudeE6());
          ((JSONObject)localObject2).put("radius", 0);
          ((JSONObject)localObject2).put("direction", 0);
          ((JSONObject)localObject2).put("iconarrownor", "direction_wheel");
          ((JSONObject)localObject2).put("iconarrownorid", 54);
          ((JSONObject)localObject2).put("iconarrowfoc", "direction_wheel");
          ((JSONObject)localObject2).put("iconarrowfocid", 54);
          localJSONArray.put(localObject2);
        }
      }
      catch (JSONException localJSONException)
      {
        float f1;
        float f2;
        localJSONException.printStackTrace();
        continue;
        localObject2 = new ArrayList();
        ((List)localObject2).add(paramMyLocationConfiguration.customMarker);
        Bundle localBundle1 = new Bundle();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject3 = (BitmapDescriptor)((Iterator)localObject2).next();
        localObject4 = new ParcelItem();
        Bundle localBundle2 = new Bundle();
        Bitmap localBitmap = ((BitmapDescriptor)localObject3).a;
        ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getWidth() * localBitmap.getHeight() * 4);
        localBitmap.copyPixelsToBuffer(localByteBuffer);
        localBundle2.putByteArray("imgdata", localByteBuffer.array());
        localBundle2.putInt("imgindex", localObject3.hashCode());
        localBundle2.putInt("imgH", localBitmap.getHeight());
        localBundle2.putInt("imgW", localBitmap.getWidth());
        ((ParcelItem)localObject4).setBundle(localBundle2);
        ((ArrayList)localObject1).add(localObject4);
        continue;
        if (((ArrayList)localObject1).size() <= 0) {
          continue;
        }
        localObject2 = new ParcelItem[((ArrayList)localObject1).size()];
        if (i1 >= ((ArrayList)localObject1).size()) {
          continue;
        }
        localObject2[i1] = ((ParcelItem)((ArrayList)localObject1).get(i1));
        i1 += 1;
        continue;
        localBundle1.putParcelableArray("icondata", (Parcelable[])localObject2);
        continue;
        animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(paramMyLocationData.latitude, paramMyLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
      }
      if (paramMyLocationConfiguration.customMarker != null) {
        continue;
      }
      localJSONArray = null;
      if (this.i != null) {
        this.i.a(localJSONObject.toString(), localJSONArray);
      }
      switch (1.a[paramMyLocationConfiguration.locationMode.ordinal()])
      {
      case 3: 
      default: 
        return;
      case 1: 
        animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(paramMyLocationData.direction).overlook(-45.0F).target(new LatLng(paramMyLocationData.latitude, paramMyLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
        return;
        f1 = f2;
        if (f2 < -180.0F)
        {
          f1 = f2 + 360.0F;
          continue;
          f1 = -1.0F;
        }
        break;
      }
    }
  }
  
  private void c()
  {
    this.k = new CopyOnWriteArrayList();
    this.l = new CopyOnWriteArrayList();
    this.m = new CopyOnWriteArrayList();
    this.P = new Point((int)(SysOSUtil.getDensity() * 40.0F), (int)(SysOSUtil.getDensity() * 40.0F));
    this.g = new UiSettings(this.i);
    this.n = new a(this);
    Object localObject = new b(this);
    this.i.a((k)localObject);
    localObject = new c(this);
    this.i.a((p)localObject);
    localObject = new d(this);
    this.i.a((K)localObject);
    this.L = this.i.B();
    this.M = this.i.C();
  }
  
  void a()
  {
    if (this.i == null) {
      return;
    }
    this.i.s();
  }
  
  void a(HeatMap paramHeatMap)
  {
    this.D.lock();
    try
    {
      if ((this.C != null) && (this.i != null) && (paramHeatMap == this.C))
      {
        this.C.b();
        this.C.c();
        this.C.a = null;
        this.i.n();
        this.C = null;
        this.i.l(false);
      }
      return;
    }
    finally
    {
      this.D.unlock();
    }
  }
  
  void a(TileOverlay paramTileOverlay)
  {
    this.E.lock();
    if (paramTileOverlay != null) {}
    try
    {
      if (this.B == paramTileOverlay)
      {
        paramTileOverlay.b();
        paramTileOverlay.a = null;
        if (this.i != null) {
          this.i.c(false);
        }
      }
      return;
    }
    finally
    {
      this.B = null;
      this.E.unlock();
    }
  }
  
  public void addHeatMap(HeatMap paramHeatMap)
  {
    if (paramHeatMap == null) {
      return;
    }
    this.D.lock();
    try
    {
      HeatMap localHeatMap = this.C;
      if (paramHeatMap == localHeatMap) {
        return;
      }
      if (this.C != null)
      {
        this.C.b();
        this.C.c();
        this.C.a = null;
        this.i.n();
      }
      this.C = paramHeatMap;
      this.C.a = this;
      this.i.l(true);
      return;
    }
    finally
    {
      this.D.unlock();
    }
  }
  
  public final Overlay addOverlay(OverlayOptions paramOverlayOptions)
  {
    if (paramOverlayOptions == null) {
      return null;
    }
    paramOverlayOptions = paramOverlayOptions.a();
    paramOverlayOptions.listener = this.n;
    if ((paramOverlayOptions instanceof Marker))
    {
      localObject = (Marker)paramOverlayOptions;
      if ((((Marker)localObject).n != null) && (((Marker)localObject).n.size() != 0))
      {
        this.l.add(localObject);
        if (this.i != null) {
          this.i.b(true);
        }
      }
      this.m.add(localObject);
    }
    Object localObject = new Bundle();
    paramOverlayOptions.a((Bundle)localObject);
    if (this.i != null) {
      this.i.b((Bundle)localObject);
    }
    this.k.add(paramOverlayOptions);
    return paramOverlayOptions;
  }
  
  public final List<Overlay> addOverlays(List<OverlayOptions> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Bundle[] arrayOfBundle = new Bundle[paramList.size()];
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      Object localObject = (OverlayOptions)paramList.next();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localObject = ((OverlayOptions)localObject).a();
        ((Overlay)localObject).listener = this.n;
        if ((localObject instanceof Marker))
        {
          Marker localMarker = (Marker)localObject;
          if ((localMarker.n != null) && (localMarker.n.size() != 0))
          {
            this.l.add(localMarker);
            if (this.i != null) {
              this.i.b(true);
            }
          }
          this.m.add(localMarker);
        }
        this.k.add(localObject);
        localArrayList.add(localObject);
        ((Overlay)localObject).a(localBundle);
        arrayOfBundle[i1] = localBundle;
        i1 += 1;
      }
    }
    int i3 = arrayOfBundle.length / 400;
    i1 = 0;
    while (i1 < i3 + 1)
    {
      paramList = new ArrayList();
      int i2 = 0;
      if ((i2 < 400) && (i1 * 400 + i2 < arrayOfBundle.length))
      {
        if (arrayOfBundle[(i1 * 400 + i2)] == null) {}
        for (;;)
        {
          i2 += 1;
          break;
          paramList.add(arrayOfBundle[(i1 * 400 + i2)]);
        }
      }
      if (this.i != null) {
        this.i.a(paramList);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public TileOverlay addTileLayer(TileOverlayOptions paramTileOverlayOptions)
  {
    if (paramTileOverlayOptions == null) {}
    do
    {
      return null;
      if (this.B != null)
      {
        this.B.b();
        this.B.a = null;
      }
    } while ((this.i == null) || (!this.i.a(paramTileOverlayOptions.a())));
    paramTileOverlayOptions = paramTileOverlayOptions.a(this);
    this.B = paramTileOverlayOptions;
    return paramTileOverlayOptions;
  }
  
  public final void animateMapStatus(MapStatusUpdate paramMapStatusUpdate)
  {
    animateMapStatus(paramMapStatusUpdate, 300);
  }
  
  public final void animateMapStatus(MapStatusUpdate paramMapStatusUpdate, int paramInt)
  {
    if ((paramMapStatusUpdate == null) || (paramInt <= 0)) {}
    do
    {
      return;
      paramMapStatusUpdate = a(paramMapStatusUpdate);
    } while (this.i == null);
    if (!this.O)
    {
      this.i.a(paramMapStatusUpdate);
      return;
    }
    this.i.a(paramMapStatusUpdate, paramInt);
  }
  
  boolean b()
  {
    if (this.i == null) {
      return false;
    }
    return this.i.d();
  }
  
  public final void clear()
  {
    this.k.clear();
    this.l.clear();
    this.m.clear();
    if (this.i != null)
    {
      this.i.b(false);
      this.i.m();
    }
    hideInfoWindow();
  }
  
  public final Point getCompassPosition()
  {
    if (this.i != null) {
      return a(this.i.g());
    }
    return null;
  }
  
  public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo()
  {
    return this.i.o();
  }
  
  public final MyLocationConfiguration getLocationConfigeration()
  {
    return this.K;
  }
  
  public final MyLocationData getLocationData()
  {
    return this.J;
  }
  
  public final MapStatus getMapStatus()
  {
    if (this.i == null) {
      return null;
    }
    return MapStatus.a(this.i.D());
  }
  
  public final LatLngBounds getMapStatusLimit()
  {
    if (this.i == null) {
      return null;
    }
    return this.i.E();
  }
  
  public final int getMapType()
  {
    if (this.i == null) {}
    do
    {
      return 1;
      if (!this.i.k()) {
        return 3;
      }
    } while (!this.i.j());
    return 2;
  }
  
  public List<Marker> getMarkersInBounds(LatLngBounds paramLatLngBounds)
  {
    if (getMapStatus() == null) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
    } while (this.m.size() == 0);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      Marker localMarker = (Marker)localIterator.next();
      if (paramLatLngBounds.contains(localMarker.getPosition())) {
        localArrayList.add(localMarker);
      }
    }
    return localArrayList;
  }
  
  public final float getMaxZoomLevel()
  {
    if (this.i == null) {
      return 0.0F;
    }
    return this.i.a;
  }
  
  public final float getMinZoomLevel()
  {
    if (this.i == null) {
      return 0.0F;
    }
    return this.i.b;
  }
  
  public final Projection getProjection()
  {
    return this.f;
  }
  
  public final UiSettings getUiSettings()
  {
    return this.g;
  }
  
  public void hideInfoWindow()
  {
    if (this.F != null) {
      if (this.F.b != null) {
        switch (1.b[this.d.ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      this.H = null;
      this.F = null;
      this.G.remove();
      this.G = null;
      return;
      if (this.b != null)
      {
        this.b.removeView(this.H);
        continue;
        if (this.h != null) {
          this.a.removeView(this.H);
        }
      }
    }
  }
  
  public final boolean isBaiduHeatMapEnabled()
  {
    if (this.i == null) {
      return false;
    }
    return this.i.h();
  }
  
  public boolean isBaseIndoorMapMode()
  {
    return this.i.p();
  }
  
  public final boolean isBuildingsEnabled()
  {
    if (this.i == null) {
      return false;
    }
    return this.i.l();
  }
  
  public final boolean isMyLocationEnabled()
  {
    if (this.i == null) {
      return false;
    }
    return this.i.r();
  }
  
  public final boolean isSupportBaiduHeatMap()
  {
    if (this.i == null) {
      return false;
    }
    return this.i.i();
  }
  
  public final boolean isTrafficEnabled()
  {
    if (this.i == null) {
      return false;
    }
    return this.i.f();
  }
  
  public final void removeMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener)
  {
    if (this.u.contains(paramOnMarkerClickListener)) {
      this.u.remove(paramOnMarkerClickListener);
    }
  }
  
  public final void setBaiduHeatMapEnabled(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.e(paramBoolean);
    }
  }
  
  public final void setBuildingsEnabled(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.g(paramBoolean);
    }
  }
  
  public void setCompassIcon(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("compass's icon can not be null");
    }
    this.i.a(paramBitmap);
  }
  
  public void setCompassPosition(Point paramPoint)
  {
    if (this.i.a(paramPoint)) {
      this.P = paramPoint;
    }
  }
  
  public final void setIndoorEnable(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.N = paramBoolean;
      this.i.i(paramBoolean);
    }
    if ((this.A != null) && (!paramBoolean)) {
      this.A.onBaseIndoorMapMode(false, null);
    }
  }
  
  public final void setMapStatus(MapStatusUpdate paramMapStatusUpdate)
  {
    if (paramMapStatusUpdate == null) {}
    do
    {
      do
      {
        return;
        paramMapStatusUpdate = a(paramMapStatusUpdate);
      } while (this.i == null);
      this.i.a(paramMapStatusUpdate);
    } while (this.o == null);
    this.o.onMapStatusChange(getMapStatus());
  }
  
  public final void setMapStatusLimits(LatLngBounds paramLatLngBounds)
  {
    if (this.i == null) {
      return;
    }
    this.i.a(paramLatLngBounds);
    setMapStatus(MapStatusUpdateFactory.newLatLngBounds(paramLatLngBounds));
  }
  
  public final void setMapType(int paramInt)
  {
    if (this.i == null) {}
    for (;;)
    {
      return;
      switch (paramInt)
      {
      }
      while (this.h != null)
      {
        this.h.a(paramInt);
        return;
        if (this.i.B()) {
          this.i.q(false);
        }
        if (this.i.C()) {
          this.i.r(false);
        }
        this.i.d(false);
        this.i.i(false);
        continue;
        this.i.a(false);
        this.i.q(this.L);
        this.i.r(this.M);
        this.i.d(true);
        this.i.i(this.N);
        continue;
        this.i.a(true);
        this.i.q(this.L);
        this.i.r(this.M);
        this.i.d(true);
      }
    }
  }
  
  public final void setMaxAndMinZoomLevel(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 21.0F) {}
    while ((paramFloat2 < 3.0F) || (paramFloat1 < paramFloat2) || (this.i == null)) {
      return;
    }
    this.i.a(paramFloat1, paramFloat2);
  }
  
  public final void setMyLocationConfigeration(MyLocationConfiguration paramMyLocationConfiguration)
  {
    this.K = paramMyLocationConfiguration;
    a(this.J, this.K);
  }
  
  public final void setMyLocationData(MyLocationData paramMyLocationData)
  {
    this.J = paramMyLocationData;
    if (this.K == null) {
      this.K = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
    }
    a(paramMyLocationData, this.K);
  }
  
  public final void setMyLocationEnabled(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.k(paramBoolean);
    }
  }
  
  public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener paramOnBaseIndoorMapListener)
  {
    this.A = paramOnBaseIndoorMapListener;
  }
  
  public final void setOnMapClickListener(OnMapClickListener paramOnMapClickListener)
  {
    this.q = paramOnMapClickListener;
  }
  
  public final void setOnMapDoubleClickListener(OnMapDoubleClickListener paramOnMapDoubleClickListener)
  {
    this.s = paramOnMapDoubleClickListener;
  }
  
  public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback paramOnMapDrawFrameCallback)
  {
    this.z = paramOnMapDrawFrameCallback;
  }
  
  public void setOnMapLoadedCallback(OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    this.r = paramOnMapLoadedCallback;
  }
  
  public final void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.t = paramOnMapLongClickListener;
  }
  
  public final void setOnMapStatusChangeListener(OnMapStatusChangeListener paramOnMapStatusChangeListener)
  {
    this.o = paramOnMapStatusChangeListener;
  }
  
  public final void setOnMapTouchListener(OnMapTouchListener paramOnMapTouchListener)
  {
    this.p = paramOnMapTouchListener;
  }
  
  public final void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener)
  {
    if ((paramOnMarkerClickListener != null) && (!this.u.contains(paramOnMarkerClickListener))) {
      this.u.add(paramOnMarkerClickListener);
    }
  }
  
  public final void setOnMarkerDragListener(OnMarkerDragListener paramOnMarkerDragListener)
  {
    this.w = paramOnMarkerDragListener;
  }
  
  public final void setOnMyLocationClickListener(OnMyLocationClickListener paramOnMyLocationClickListener)
  {
    this.x = paramOnMyLocationClickListener;
  }
  
  public final void setOnPolylineClickListener(OnPolylineClickListener paramOnPolylineClickListener)
  {
    if (paramOnPolylineClickListener != null) {
      this.v.add(paramOnPolylineClickListener);
    }
  }
  
  @Deprecated
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.i == null);
        this.i.D();
        switch (1.b[this.d.ordinal()])
        {
        default: 
          return;
        }
      } while (this.b == null);
      f2 = (this.b.getWidth() - paramInt1 - paramInt3) / this.b.getWidth();
      f1 = (this.b.getHeight() - paramInt2 - paramInt4) / this.b.getHeight();
      i1 = this.b.getWidth();
      i2 = this.b.getHeight();
      localMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point((i1 + paramInt1 - paramInt3) / 2, (i2 + paramInt2 - paramInt4) / 2)).build());
      locale = this.i;
      f3 = paramInt1;
      i1 = (int)(f2 * this.P.x + f3);
      f2 = paramInt2;
      locale.a(new Point(i1, (int)(f1 * this.P.y + f2)));
      setMapStatus(localMapStatusUpdate);
      this.b.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      this.b.invalidate();
      return;
    } while (this.a == null);
    float f2 = (this.a.getWidth() - paramInt1 - paramInt3) / this.a.getWidth();
    float f1 = (this.a.getHeight() - paramInt2 - paramInt4) / this.a.getHeight();
    int i1 = this.a.getWidth();
    int i2 = this.a.getHeight();
    MapStatusUpdate localMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point((i1 + paramInt1 - paramInt3) / 2, (i2 + paramInt2 - paramInt4) / 2)).build());
    e locale = this.i;
    float f3 = paramInt1;
    i1 = (int)(f2 * this.P.x + f3);
    f2 = paramInt2;
    locale.a(new Point(i1, (int)(f1 * this.P.y + f2)));
    setMapStatus(localMapStatusUpdate);
    this.a.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.invalidate();
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.f(paramBoolean);
    }
  }
  
  public final void setViewPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.i == null);
        switch (1.b[this.d.ordinal()])
        {
        default: 
          return;
        }
      } while (this.b == null);
      f2 = (this.b.getWidth() - paramInt1 - paramInt3) / this.b.getWidth();
      f1 = (this.b.getHeight() - paramInt2 - paramInt4) / this.b.getHeight();
      locale = this.i;
      f3 = paramInt1;
      i1 = (int)(f2 * this.P.x + f3);
      f2 = paramInt2;
      locale.a(new Point(i1, (int)(f1 * this.P.y + f2)));
      this.b.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      this.b.invalidate();
      return;
    } while (this.a == null);
    float f2 = (this.a.getWidth() - paramInt1 - paramInt3) / this.a.getWidth();
    float f1 = (this.a.getHeight() - paramInt2 - paramInt4) / this.a.getHeight();
    e locale = this.i;
    float f3 = paramInt1;
    int i1 = (int)(f2 * this.P.x + f3);
    f2 = paramInt2;
    locale.a(new Point(i1, (int)(f1 * this.P.y + f2)));
    this.a.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.invalidate();
  }
  
  public void showInfoWindow(InfoWindow paramInfoWindow)
  {
    if (paramInfoWindow != null)
    {
      hideInfoWindow();
      if (paramInfoWindow.b != null)
      {
        this.H = paramInfoWindow.b;
        this.H.destroyDrawingCache();
        localObject = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(paramInfoWindow.c).yOffset(paramInfoWindow.e).build();
      }
      switch (1.b[this.d.ordinal()])
      {
      default: 
        this.F = paramInfoWindow;
        if (paramInfoWindow.b == null) {
          break;
        }
      }
    }
    for (Object localObject = BitmapDescriptorFactory.fromView(paramInfoWindow.b);; localObject = paramInfoWindow.a)
    {
      paramInfoWindow = new MarkerOptions().perspective(false).icon((BitmapDescriptor)localObject).position(paramInfoWindow.c).zIndex(Integer.MAX_VALUE).a(paramInfoWindow.e).a();
      paramInfoWindow.listener = this.n;
      paramInfoWindow.q = h.b;
      localObject = new Bundle();
      paramInfoWindow.a((Bundle)localObject);
      if (this.i != null) {
        this.i.b((Bundle)localObject);
      }
      this.k.add(paramInfoWindow);
      this.G = ((Marker)paramInfoWindow);
      return;
      if (this.b == null) {
        break;
      }
      this.b.addView(this.H, (ViewGroup.LayoutParams)localObject);
      break;
      if (this.h == null) {
        break;
      }
      this.a.addView(this.H, (ViewGroup.LayoutParams)localObject);
      break;
    }
  }
  
  public final void showMapIndoorPoi(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.r(paramBoolean);
      this.M = paramBoolean;
    }
  }
  
  public final void showMapPoi(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.q(paramBoolean);
      this.L = paramBoolean;
    }
  }
  
  public final void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    this.y = paramSnapshotReadyCallback;
    switch (1.b[this.d.ordinal()])
    {
    }
    do
    {
      do
      {
        return;
      } while (this.j == null);
      this.j.a("anything", null);
      return;
    } while (this.h == null);
    this.h.a("anything", null);
  }
  
  public final void snapshotScope(Rect paramRect, SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    this.y = paramSnapshotReadyCallback;
    switch (1.b[this.d.ordinal()])
    {
    }
    do
    {
      do
      {
        return;
      } while (this.j == null);
      this.j.a("anything", paramRect);
      return;
    } while (this.h == null);
    this.h.a("anything", paramRect);
  }
  
  public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
    }
    Object localObject = getFocusedBaseIndoorMapInfo();
    if (!paramString2.equals(((MapBaseIndoorMapInfo)localObject).a)) {
      return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
    }
    localObject = ((MapBaseIndoorMapInfo)localObject).getFloors();
    if ((localObject == null) || (!((List)localObject).contains(paramString1))) {
      return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
    }
    if (this.i.a(paramString1, paramString2)) {
      return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
    }
    return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
  }
  
  public static abstract interface OnBaseIndoorMapListener
  {
    public abstract void onBaseIndoorMapMode(boolean paramBoolean, MapBaseIndoorMapInfo paramMapBaseIndoorMapInfo);
  }
  
  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);
    
    public abstract boolean onMapPoiClick(MapPoi paramMapPoi);
  }
  
  public static abstract interface OnMapDoubleClickListener
  {
    public abstract void onMapDoubleClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapDrawFrameCallback
  {
    public abstract void onMapDrawFrame(GL10 paramGL10, MapStatus paramMapStatus);
  }
  
  public static abstract interface OnMapLoadedCallback
  {
    public abstract void onMapLoaded();
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapStatusChangeListener
  {
    public abstract void onMapStatusChange(MapStatus paramMapStatus);
    
    public abstract void onMapStatusChangeFinish(MapStatus paramMapStatus);
    
    public abstract void onMapStatusChangeStart(MapStatus paramMapStatus);
  }
  
  public static abstract interface OnMapTouchListener
  {
    public abstract void onTouch(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }
  
  public static abstract interface OnMarkerDragListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);
    
    public abstract void onMarkerDragEnd(Marker paramMarker);
    
    public abstract void onMarkerDragStart(Marker paramMarker);
  }
  
  public static abstract interface OnMyLocationClickListener
  {
    public abstract boolean onMyLocationClick();
  }
  
  public static abstract interface OnPolylineClickListener
  {
    public abstract boolean onPolylineClick(Polyline paramPolyline);
  }
  
  public static abstract interface SnapshotReadyCallback
  {
    public abstract void onSnapshotReady(Bitmap paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/BaiduMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */