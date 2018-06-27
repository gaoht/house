package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.mapapi.MessageCenter;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comjni.map.basemap.BaseMapCallback;
import com.baidu.platform.comjni.map.basemap.JNIBaseMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class e
  implements com.baidu.platform.comjni.map.basemap.b
{
  private static int N;
  private static int O;
  private static List<JNIBaseMap> ai;
  static long k = 0L;
  private static final String o = i.class.getSimpleName();
  private Context A;
  private List<d> B;
  private z C;
  private g D;
  private n E;
  private G F;
  private J G;
  private r H;
  private m I;
  private o J;
  private a K;
  private p L;
  private H M;
  private int P;
  private int Q;
  private int R;
  private i.a S = new i.a();
  private VelocityTracker T;
  private long U;
  private long V;
  private long W;
  private long X;
  private int Y;
  private float Z;
  public float a = 22.0F;
  private float aa;
  private boolean ab;
  private long ac;
  private long ad;
  private f ae;
  private String af;
  private b ag;
  private c ah;
  public float b = 3.0F;
  public float c = 22.0F;
  boolean d = true;
  boolean e = true;
  List<k> f;
  com.baidu.platform.comjni.map.basemap.a g;
  long h;
  boolean i;
  public int j;
  boolean l;
  boolean m;
  boolean n;
  private boolean p;
  private boolean q;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = true;
  private boolean w = true;
  private boolean x = false;
  private L y;
  private K z;
  
  public e(Context paramContext, String paramString)
  {
    this.A = paramContext;
    this.f = new ArrayList();
    this.af = paramString;
  }
  
  private void N()
  {
    if ((this.t) || (this.q) || (this.p) || (this.u))
    {
      if (this.a > 20.0F) {
        this.a = 20.0F;
      }
      if (D().a > 20.0F)
      {
        D localD = D();
        localD.a = 20.0F;
        a(localD);
      }
      return;
    }
    this.a = this.c;
  }
  
  private Activity a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return a(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  private boolean e(Bundle paramBundle)
  {
    if (this.g == null) {
      return false;
    }
    return this.g.e(paramBundle);
  }
  
  private boolean f(Bundle paramBundle)
  {
    boolean bool1 = false;
    if (paramBundle == null) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (this.g == null);
      bool2 = this.g.d(paramBundle);
      bool1 = bool2;
    } while (!bool2);
    c(bool2);
    this.g.b(this.y.a);
    return bool2;
  }
  
  private void g(Bundle paramBundle)
  {
    if (paramBundle.get("param") != null)
    {
      paramBundle = (Bundle)paramBundle.get("param");
      i1 = paramBundle.getInt("type");
      if (i1 == h.d.ordinal())
      {
        paramBundle.putLong("layer_addr", this.E.a);
        return;
      }
      if (i1 >= h.f.ordinal())
      {
        paramBundle.putLong("layer_addr", this.I.a);
        return;
      }
      if (i1 == h.b.ordinal())
      {
        paramBundle.putLong("layer_addr", this.H.a);
        return;
      }
      paramBundle.putLong("layer_addr", this.G.a);
      return;
    }
    int i1 = paramBundle.getInt("type");
    if (i1 == h.d.ordinal())
    {
      paramBundle.putLong("layer_addr", this.E.a);
      return;
    }
    if (i1 >= h.f.ordinal())
    {
      paramBundle.putLong("layer_addr", this.I.a);
      return;
    }
    if (i1 == h.b.ordinal())
    {
      paramBundle.putLong("layer_addr", this.H.a);
      return;
    }
    paramBundle.putLong("layer_addr", this.G.a);
  }
  
  public static void j(boolean paramBoolean)
  {
    ai = com.baidu.platform.comjni.map.basemap.a.d();
    Iterator localIterator;
    if ((ai != null) && (ai.size() != 0))
    {
      com.baidu.platform.comjni.map.basemap.a.b(((JNIBaseMap)ai.get(0)).a, paramBoolean);
      localIterator = ai.iterator();
    }
    while (localIterator.hasNext())
    {
      JNIBaseMap localJNIBaseMap = (JNIBaseMap)localIterator.next();
      localJNIBaseMap.ClearLayer(localJNIBaseMap.a, -1L);
      continue;
      com.baidu.platform.comjni.map.basemap.a.b(0L, paramBoolean);
    }
  }
  
  void A()
  {
    this.m = false;
    this.l = false;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).c(D());
    }
  }
  
  public boolean B()
  {
    if (this.g != null) {
      return this.g.a(this.F.a);
    }
    return false;
  }
  
  public boolean C()
  {
    if (this.g != null) {
      return this.g.a(this.ah.a);
    }
    return false;
  }
  
  public D D()
  {
    if (this.g == null) {
      return null;
    }
    Bundle localBundle = this.g.j();
    D localD = new D();
    localD.a(localBundle);
    return localD;
  }
  
  public LatLngBounds E()
  {
    if (this.g == null) {
      return null;
    }
    Bundle localBundle = this.g.k();
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    int i1 = localBundle.getInt("maxCoorx");
    int i2 = localBundle.getInt("minCoorx");
    int i3 = localBundle.getInt("maxCoory");
    localBuilder.include(CoordUtil.mc2ll(new GeoPoint(localBundle.getInt("minCoory"), i1))).include(CoordUtil.mc2ll(new GeoPoint(i3, i2)));
    return localBuilder.build();
  }
  
  public int F()
  {
    return this.P;
  }
  
  public int G()
  {
    return this.Q;
  }
  
  public D H()
  {
    if (this.g == null) {
      return null;
    }
    Bundle localBundle = this.g.l();
    D localD = new D();
    localD.a(localBundle);
    return localD;
  }
  
  public double I()
  {
    return D().m;
  }
  
  void J()
  {
    if (!this.l)
    {
      this.l = true;
      this.m = false;
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).a(D());
      }
    }
  }
  
  void K()
  {
    this.l = false;
    if (!this.m)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).c(D());
      }
    }
  }
  
  void L()
  {
    this.R = 0;
    this.S.e = false;
    this.S.h = 0.0D;
  }
  
  void M()
  {
    if (this.g != null)
    {
      this.g.b();
      this.g = null;
    }
  }
  
  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!this.i) {
      return 12.0F;
    }
    if (this.g == null) {
      return 0.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramInt1);
    localBundle.putInt("right", paramInt3);
    localBundle.putInt("bottom", paramInt4);
    localBundle.putInt("top", paramInt2);
    localBundle.putInt("hasHW", 1);
    localBundle.putInt("width", paramInt5);
    localBundle.putInt("height", paramInt6);
    return this.g.c(localBundle);
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return com.baidu.platform.comjni.map.basemap.a.a(this.h, paramInt1, paramInt2, paramInt3);
  }
  
  public int a(Bundle paramBundle1, long paramLong, int paramInt, Bundle paramBundle2)
  {
    if (paramLong == this.D.a)
    {
      paramBundle1.putString("jsondata", this.D.a());
      paramBundle1.putBundle("param", this.D.b());
      return this.D.g;
    }
    if (paramLong == this.C.a)
    {
      paramBundle1.putString("jsondata", this.C.a());
      paramBundle1.putBundle("param", this.C.b());
      return this.C.g;
    }
    int i1;
    int i2;
    if (paramLong == this.J.a)
    {
      paramInt = paramBundle2.getInt("x");
      i1 = paramBundle2.getInt("y");
      i2 = paramBundle2.getInt("zoom");
      paramBundle1.putBundle("param", this.L.a(paramInt, i1, i2));
      return this.J.g;
    }
    if (paramLong == this.y.a)
    {
      paramInt = paramBundle2.getInt("x");
      i1 = paramBundle2.getInt("y");
      i2 = paramBundle2.getInt("zoom");
      paramBundle1.putBundle("param", this.z.a(paramInt, i1, i2, this.A));
      return this.y.g;
    }
    return 0;
  }
  
  public Point a(GeoPoint paramGeoPoint)
  {
    return this.M.a(paramGeoPoint);
  }
  
  void a()
  {
    this.g = new com.baidu.platform.comjni.map.basemap.a();
    this.g.a();
    this.h = this.g.c();
    String str5;
    String str4;
    String str3;
    String str2;
    int i1;
    int i2;
    int i3;
    if (SysOSUtil.getDensityDpi() < 180)
    {
      this.j = 18;
      str5 = SysOSUtil.getModuleFileName();
      str4 = EnvironmentUtilities.getAppSDCardPath();
      str3 = EnvironmentUtilities.getAppCachePath();
      str2 = EnvironmentUtilities.getAppSecondCachePath();
      i1 = EnvironmentUtilities.getMapTmpStgMax();
      i2 = EnvironmentUtilities.getDomTmpStgMax();
      i3 = EnvironmentUtilities.getItsTmpStgMax();
      if (SysOSUtil.getDensityDpi() < 180) {
        break label417;
      }
    }
    label417:
    for (String str1 = "/h/";; str1 = "/l/")
    {
      String str6 = str5 + "/cfg";
      Object localObject = str4 + "/vmp";
      str4 = str6 + str1;
      str5 = str6 + "/a/";
      str6 = str6 + "/idrres/";
      String str7 = (String)localObject + str1;
      str1 = (String)localObject + str1;
      str3 = str3 + "/tmp/";
      str2 = str2 + "/tmp/";
      localObject = a(this.A).getWindowManager().getDefaultDisplay();
      int i4 = ((Display)localObject).getWidth();
      int i5 = ((Display)localObject).getHeight();
      this.g.a(str4, str7, str3, str2, str1, str5, this.af, str6, i4, i5, SysOSUtil.getDensityDpi(), i1, i2, i3, 0);
      this.g.f();
      return;
      if (SysOSUtil.getDensityDpi() < 240)
      {
        this.j = 25;
        break;
      }
      if (SysOSUtil.getDensityDpi() < 320)
      {
        this.j = 37;
        break;
      }
      this.j = 50;
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.c = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.P = paramInt1;
    this.Q = paramInt2;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.g == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Object localObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 0);
      ((JSONObject)localObject).put("x", N);
      ((JSONObject)localObject).put("y", O);
      ((JSONObject)localObject).put("hidetime", 1000);
      localJSONArray.put(localObject);
      localJSONObject.put("data", localJSONArray);
      if (paramBitmap == null)
      {
        paramBitmap = null;
        b(localJSONObject.toString(), paramBitmap);
        this.g.b(this.D.a);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        Bundle localBundle1 = new Bundle();
        localObject = new ArrayList();
        ParcelItem localParcelItem = new ParcelItem();
        Bundle localBundle2 = new Bundle();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
        paramBitmap.copyPixelsToBuffer(localByteBuffer);
        localBundle2.putByteArray("imgdata", localByteBuffer.array());
        localBundle2.putInt("imgindex", paramBitmap.hashCode());
        localBundle2.putInt("imgH", paramBitmap.getHeight());
        localBundle2.putInt("imgW", paramBitmap.getWidth());
        localBundle2.putInt("hasIcon", 1);
        localParcelItem.setBundle(localBundle2);
        ((ArrayList)localObject).add(localParcelItem);
        if (((ArrayList)localObject).size() > 0)
        {
          paramBitmap = new ParcelItem[((ArrayList)localObject).size()];
          int i1 = 0;
          while (i1 < ((ArrayList)localObject).size())
          {
            paramBitmap[i1] = ((ParcelItem)((ArrayList)localObject).get(i1));
            i1 += 1;
          }
          localBundle1.putParcelableArray("icondata", paramBitmap);
        }
        paramBitmap = localBundle1;
      }
    }
  }
  
  void a(Handler paramHandler)
  {
    MessageCenter.registMessage(4000, paramHandler);
    MessageCenter.registMessage(39, paramHandler);
    MessageCenter.registMessage(41, paramHandler);
    MessageCenter.registMessage(49, paramHandler);
    MessageCenter.registMessage(65289, paramHandler);
    MessageCenter.registMessage(50, paramHandler);
    MessageCenter.registMessage(999, paramHandler);
    BaseMapCallback.addLayerDataInterface(this.h, this);
  }
  
  public void a(LatLngBounds paramLatLngBounds)
  {
    if ((paramLatLngBounds == null) || (this.g == null)) {
      return;
    }
    Object localObject = paramLatLngBounds.northeast;
    paramLatLngBounds = paramLatLngBounds.southwest;
    localObject = CoordUtil.ll2mc((LatLng)localObject);
    paramLatLngBounds = CoordUtil.ll2mc(paramLatLngBounds);
    int i1 = (int)((GeoPoint)localObject).getLongitudeE6();
    int i2 = (int)paramLatLngBounds.getLatitudeE6();
    int i3 = (int)paramLatLngBounds.getLongitudeE6();
    int i4 = (int)((GeoPoint)localObject).getLatitudeE6();
    paramLatLngBounds = new Bundle();
    paramLatLngBounds.putInt("maxCoorx", i1);
    paramLatLngBounds.putInt("minCoory", i2);
    paramLatLngBounds.putInt("minCoorx", i3);
    paramLatLngBounds.putInt("maxCoory", i4);
    this.g.b(paramLatLngBounds);
  }
  
  void a(B paramB)
  {
    new D();
    B localB = paramB;
    if (paramB == null) {
      localB = new B();
    }
    paramB = localB.a;
    this.v = localB.f;
    this.w = localB.d;
    this.d = localB.e;
    this.e = localB.g;
    this.g.a(paramB.a(this));
    this.g.a(A.a.ordinal());
    this.r = localB.b;
    if (!localB.b) {
      this.g.a(this.D.a, false);
    }
    for (;;)
    {
      int i1 = localB.c;
      if (i1 == 2) {
        a(true);
      }
      if (i1 == 3) {
        this.g.a(this.ae.a, false);
      }
      return;
      N = (int)(SysOSUtil.getDensity() * 40.0F);
      O = (int)(SysOSUtil.getDensity() * 40.0F);
      paramB = String.format("{\"data\":[{\"x\":%d,\"y\":%d,\"hidetime\":1000}]}", new Object[] { Integer.valueOf(N), Integer.valueOf(O) });
      this.D.a(paramB);
      this.g.a(this.D.a, true);
    }
  }
  
  public void a(D paramD)
  {
    if (this.g == null) {
      return;
    }
    paramD = paramD.a(this);
    paramD.putInt("animation", 0);
    paramD.putInt("animatime", 0);
    this.g.a(paramD);
  }
  
  public void a(D paramD, int paramInt)
  {
    if (this.g == null) {
      return;
    }
    paramD = paramD.a(this);
    paramD.putInt("animation", 1);
    paramD.putInt("animatime", paramInt);
    z();
    this.g.a(paramD);
  }
  
  public void a(K paramK)
  {
    this.z = paramK;
  }
  
  void a(d paramd)
  {
    if (this.g == null) {
      return;
    }
    paramd.a = this.g.a(paramd.c, paramd.d, paramd.b);
    this.B.add(paramd);
  }
  
  public void a(k paramk)
  {
    this.f.add(paramk);
  }
  
  public void a(p paramp)
  {
    this.L = paramp;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (this.g == null) {
      return;
    }
    this.C.a(paramString);
    this.C.a(paramBundle);
    this.g.b(this.C.a);
  }
  
  public void a(List<Bundle> paramList)
  {
    if ((this.g == null) || (paramList == null)) {
      return;
    }
    int i2 = paramList.size();
    Bundle[] arrayOfBundle = new Bundle[paramList.size()];
    int i1 = 0;
    while (i1 < i2)
    {
      g((Bundle)paramList.get(i1));
      arrayOfBundle[i1] = ((Bundle)paramList.get(i1));
      i1 += 1;
    }
    this.g.a(arrayOfBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    if (!this.g.a(this.ae.a)) {
      this.g.a(this.ae.a, true);
    }
    this.q = paramBoolean;
    N();
    this.g.a(this.q);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.B.iterator();
    while (localIterator.hasNext()) {
      if (((d)localIterator.next()).a == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((this.g == null) || (paramPoint.x < 0) || (paramPoint.y < 0)) {
      return false;
    }
    N = paramPoint.x;
    O = paramPoint.y;
    paramPoint = String.format("{\"data\":[{\"x\":%d,\"y\":%d,\"hidetime\":1000}]}", new Object[] { Integer.valueOf(N), Integer.valueOf(O) });
    this.D.a(paramPoint);
    this.g.b(this.D.a);
    return true;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (this.g == null) {}
    do
    {
      long l1;
      do
      {
        return false;
        this.y = new L();
        l1 = this.g.a(this.y.c, this.y.d, this.y.b);
      } while (l1 == 0L);
      this.y.a = l1;
      this.B.add(this.y);
      paramBundle.putLong("sdktileaddr", l1);
    } while ((!e(paramBundle)) || (!f(paramBundle)));
    return true;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getPointerCount();
    int i1 = i2;
    if (i2 == 2) {
      if (c((int)paramMotionEvent.getX(0), (int)paramMotionEvent.getY(0)))
      {
        i1 = i2;
        if (c((int)paramMotionEvent.getX(1), (int)paramMotionEvent.getY(1))) {}
      }
      else
      {
        i1 = 1;
      }
    }
    if (i1 == 2)
    {
      float f1 = this.Q - paramMotionEvent.getY(0);
      float f2 = this.Q - paramMotionEvent.getY(1);
      float f3 = paramMotionEvent.getX(0);
      float f4 = paramMotionEvent.getX(1);
      float f5;
      float f6;
      float f7;
      switch (paramMotionEvent.getAction())
      {
      default: 
        if (this.T == null) {
          this.T = VelocityTracker.obtain();
        }
        this.T.addMovement(paramMotionEvent);
        i1 = ViewConfiguration.getMinimumFlingVelocity();
        i2 = ViewConfiguration.getMaximumFlingVelocity();
        this.T.computeCurrentVelocity(1000, i2);
        f5 = this.T.getXVelocity(1);
        f6 = this.T.getYVelocity(1);
        f7 = this.T.getXVelocity(2);
        float f8 = this.T.getYVelocity(2);
        if ((Math.abs(f5) <= i1) && (Math.abs(f6) <= i1) && (Math.abs(f7) <= i1) && (Math.abs(f8) <= i1)) {
          break label1409;
        }
        if (this.S.e != true) {
          break label692;
        }
        if (this.R != 0) {
          break label634;
        }
        if (((this.S.c - f1 > 0.0F) && (this.S.d - f2 > 0.0F)) || ((this.S.c - f1 < 0.0F) && (this.S.d - f2 < 0.0F)))
        {
          d1 = Math.atan2(f2 - f1, f4 - f3);
          d2 = Math.atan2(this.S.d - this.S.c, this.S.b - this.S.a);
          d3 = Math.sqrt((f4 - f3) * (f4 - f3) + (f2 - f1) * (f2 - f1)) / this.S.h;
          i1 = (int)(Math.log(d3) / Math.log(2.0D) * 10000.0D);
          i2 = (int)((d1 - d2) * 180.0D / 3.1416D);
          if (((d3 > 0.0D) && ((i1 > 3000) || (i1 < 62536))) || (Math.abs(i2) >= 10)) {
            this.R = 2;
          }
        }
        break;
      }
      for (;;)
      {
        if (this.R != 0) {
          break label634;
        }
        return true;
        this.V = paramMotionEvent.getEventTime();
        this.Y -= 1;
        break;
        this.U = paramMotionEvent.getEventTime();
        this.Y -= 1;
        break;
        this.X = paramMotionEvent.getEventTime();
        this.Y += 1;
        break;
        this.W = paramMotionEvent.getEventTime();
        this.Y += 1;
        break;
        this.R = 1;
        continue;
        this.R = 2;
      }
      label634:
      if ((this.R == 1) && (this.v)) {
        if ((this.S.c - f1 > 0.0F) && (this.S.d - f2 > 0.0F))
        {
          J();
          a(1, 83, 0);
        }
      }
      label692:
      label1318:
      label1409:
      while ((this.R != 0) || (this.Y != 0))
      {
        do
        {
          for (;;)
          {
            if (2 != this.R)
            {
              this.S.c = f1;
              this.S.d = f2;
              this.S.a = f3;
              this.S.b = f4;
            }
            if (!this.S.e)
            {
              this.S.f = (this.P / 2);
              this.S.g = (this.Q / 2);
              this.S.e = true;
              if (0.0D == this.S.h)
              {
                d1 = Math.sqrt((this.S.b - this.S.a) * (this.S.b - this.S.a) + (this.S.d - this.S.c) * (this.S.d - this.S.c));
                this.S.h = d1;
              }
            }
            return true;
            if ((this.S.c - f1 < 0.0F) && (this.S.d - f2 < 0.0F))
            {
              J();
              a(1, 87, 0);
            }
          }
        } while ((this.R != 2) && (this.R != 4) && (this.R != 3));
        double d1 = Math.atan2(f2 - f1, f4 - f3) - Math.atan2(this.S.d - this.S.c, this.S.b - this.S.a);
        double d2 = Math.sqrt((f4 - f3) * (f4 - f3) + (f2 - f1) * (f2 - f1)) / this.S.h;
        i1 = (int)(Math.log(d2) / Math.log(2.0D) * 10000.0D);
        double d3 = Math.atan2(this.S.g - this.S.c, this.S.f - this.S.a);
        double d4 = Math.sqrt((this.S.f - this.S.a) * (this.S.f - this.S.a) + (this.S.g - this.S.c) * (this.S.g - this.S.c));
        f5 = (float)(Math.cos(d3 + d1) * d4 * d2 + f3);
        f6 = (float)(Math.sin(d3 + d1) * d4 * d2 + f1);
        i2 = (int)(d1 * 180.0D / 3.1416D);
        if ((d2 > 0.0D) && ((3 == this.R) || ((Math.abs(i1) > 2000) && (2 == this.R))))
        {
          this.R = 3;
          f7 = D().a;
          if (this.e)
          {
            if (d2 <= 1.0D) {
              break label1318;
            }
            if (f7 >= this.a) {
              return false;
            }
            J();
            a(8193, 3, i1);
          }
        }
        for (;;)
        {
          this.S.f = f5;
          this.S.g = f6;
          break;
          if (f7 <= this.b) {
            return false;
          }
          J();
          a(8193, 3, i1);
          continue;
          if ((i2 != 0) && ((4 == this.R) || ((Math.abs(i2) > 10) && (2 == this.R))))
          {
            this.R = 4;
            if (this.w)
            {
              J();
              a(8193, 1, i2);
            }
          }
        }
      }
      if (this.W > this.X)
      {
        l1 = this.W;
        label1441:
        this.W = l1;
        if (this.U >= this.V) {
          break label1533;
        }
      }
      label1533:
      for (long l1 = this.V;; l1 = this.U)
      {
        this.U = l1;
        if ((this.W - this.U >= 200L) || (!this.e)) {
          break;
        }
        paramMotionEvent = D();
        if (paramMotionEvent == null) {
          break;
        }
        paramMotionEvent.a -= 1.0F;
        a(paramMotionEvent, 300);
        break;
        l1 = this.X;
        break label1441;
      }
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      b(paramMotionEvent);
      return true;
    case 1: 
      return d(paramMotionEvent);
    }
    c(paramMotionEvent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.g.a(paramString1, paramString2);
  }
  
  public GeoPoint b(int paramInt1, int paramInt2)
  {
    return this.M.a(paramInt1, paramInt2);
  }
  
  void b()
  {
    this.B = new ArrayList();
    this.ae = new f();
    a(this.ae);
    this.ag = new b();
    a(this.ag);
    if (this.g != null) {
      this.g.e(false);
    }
    this.E = new n();
    a(this.E);
    this.J = new o();
    a(this.J);
    this.K = new a();
    a(this.K);
    a(new q());
    this.F = new G();
    a(this.F);
    this.ah = new c();
    a(this.ah);
    this.I = new m();
    a(this.I);
    this.G = new J();
    a(this.G);
    this.D = new g();
    a(this.D);
    this.C = new z();
    a(this.C);
    this.H = new r();
    a(this.H);
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.g == null) {
      return;
    }
    g(paramBundle);
    this.g.f(paramBundle);
  }
  
  void b(Handler paramHandler)
  {
    MessageCenter.unregistMessage(4000, paramHandler);
    MessageCenter.unregistMessage(41, paramHandler);
    MessageCenter.unregistMessage(49, paramHandler);
    MessageCenter.unregistMessage(39, paramHandler);
    MessageCenter.unregistMessage(65289, paramHandler);
    MessageCenter.unregistMessage(50, paramHandler);
    MessageCenter.unregistMessage(999, paramHandler);
    BaseMapCallback.removeLayerDataInterface(this.h);
  }
  
  void b(MotionEvent paramMotionEvent)
  {
    if (this.S.e) {
      return;
    }
    this.ad = paramMotionEvent.getDownTime();
    if (this.ad - this.ac < 400L) {
      if ((Math.abs(paramMotionEvent.getX() - this.Z) < 120.0F) && (Math.abs(paramMotionEvent.getY() - this.aa) < 120.0F)) {
        this.ac = 0L;
      }
    }
    for (;;)
    {
      this.Z = paramMotionEvent.getX();
      this.aa = paramMotionEvent.getY();
      a(4, 0, (int)paramMotionEvent.getX() | (int)paramMotionEvent.getY() << 16);
      this.ab = true;
      return;
      this.ac = this.ad;
      continue;
      this.ac = this.ad;
    }
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    if (this.g == null) {
      return;
    }
    this.D.a(paramString);
    this.D.a(paramBundle);
    this.g.b(this.D.a);
  }
  
  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void c(Bundle paramBundle)
  {
    if (this.g == null) {
      return;
    }
    g(paramBundle);
    this.g.g(paramBundle);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.g.a(this.y.a, paramBoolean);
  }
  
  public boolean c()
  {
    return this.x;
  }
  
  boolean c(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 <= this.P + 0) && (paramInt2 >= 0) && (paramInt2 <= this.Q + 0);
  }
  
  boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (this.S.e) {
      bool = true;
    }
    int i2;
    int i1;
    do
    {
      return bool;
      if (System.currentTimeMillis() - k < 300L) {
        return true;
      }
      if (this.n)
      {
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((k)localIterator.next()).d(b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        }
        return true;
      }
      float f1 = Math.abs(paramMotionEvent.getX() - this.Z);
      float f2 = Math.abs(paramMotionEvent.getY() - this.aa);
      if (SysOSUtil.getDensity() > 1.5D) {}
      for (double d1 = SysOSUtil.getDensity() * 1.5D;; d1 = SysOSUtil.getDensity())
      {
        float f3 = (float)d1;
        if ((!this.ab) || (f1 / f3 > 3.0F) || (f2 / f3 > 3.0F)) {
          break;
        }
        return true;
      }
      this.ab = false;
      i2 = (int)paramMotionEvent.getX();
      int i3 = (int)paramMotionEvent.getY();
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      i2 = i3;
      if (i3 < 0) {
        i2 = 0;
      }
    } while (!this.d);
    J();
    a(3, 0, i2 << 16 | i1);
    return false;
  }
  
  public void d(Bundle paramBundle)
  {
    if (this.g == null) {
      return;
    }
    g(paramBundle);
    this.g.h(paramBundle);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.g.a(this.ae.a, paramBoolean);
  }
  
  public boolean d()
  {
    if ((this.y != null) && (this.g != null)) {
      return this.g.c(this.y.a);
    }
    return false;
  }
  
  boolean d(MotionEvent paramMotionEvent)
  {
    if (this.n)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).e(b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
      }
      this.n = false;
      return true;
    }
    if ((!this.S.e) && (paramMotionEvent.getEventTime() - this.ad < 400L) && (Math.abs(paramMotionEvent.getX() - this.Z) < 10.0F) && (Math.abs(paramMotionEvent.getY() - this.aa) < 10.0F)) {}
    for (int i1 = 1;; i1 = 0)
    {
      L();
      int i3 = (int)paramMotionEvent.getX();
      int i2 = (int)paramMotionEvent.getY();
      if (i1 == 0)
      {
        i1 = i3;
        if (i3 < 0) {
          i1 = 0;
        }
        if (i2 < 0) {
          i2 = 0;
        }
        for (;;)
        {
          a(5, 0, i2 << 16 | i1);
          return true;
        }
      }
      return false;
    }
  }
  
  void e()
  {
    if (this.g == null) {
      return;
    }
    this.M = new H(this.g);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.u = paramBoolean;
    this.g.b(this.u);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.p = paramBoolean;
    this.g.c(this.p);
  }
  
  public boolean f()
  {
    return this.p;
  }
  
  public String g()
  {
    if (this.g == null) {
      return null;
    }
    return this.g.e(this.D.a);
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.g.d(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.r = paramBoolean;
    this.g.a(this.D.a, paramBoolean);
  }
  
  public boolean h()
  {
    return this.u;
  }
  
  public void i(boolean paramBoolean)
  {
    this.g.e(paramBoolean);
    this.g.d(this.ag.a);
    this.g.d(this.ah.a);
  }
  
  public boolean i()
  {
    if (this.g == null) {
      return false;
    }
    return this.g.m();
  }
  
  public boolean j()
  {
    return this.q;
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.s = paramBoolean;
    this.g.a(this.C.a, paramBoolean);
  }
  
  public boolean k()
  {
    return this.g.a(this.ae.a);
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    this.t = paramBoolean;
    this.g.a(this.J.a, paramBoolean);
  }
  
  public boolean l()
  {
    if (this.g == null) {
      return false;
    }
    return this.g.q();
  }
  
  public void m()
  {
    if (this.g == null) {
      return;
    }
    this.g.d(this.E.a);
    this.g.d(this.I.a);
    this.g.d(this.G.a);
    this.g.d(this.H.a);
  }
  
  public void m(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void n()
  {
    if (this.g == null) {
      return;
    }
    this.g.r();
    this.g.b(this.J.a);
  }
  
  public void n(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public MapBaseIndoorMapInfo o()
  {
    return this.g.s();
  }
  
  public void o(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void p(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public boolean p()
  {
    return this.g.t();
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.a(this.F.a, paramBoolean);
    }
  }
  
  public boolean q()
  {
    return this.r;
  }
  
  public void r(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.a(this.ah.a, paramBoolean);
    }
  }
  
  public boolean r()
  {
    return this.s;
  }
  
  public void s()
  {
    if (this.g == null) {
      return;
    }
    this.g.b(this.J.a);
  }
  
  public void t()
  {
    if (this.g == null) {
      return;
    }
    this.g.g();
  }
  
  public void u()
  {
    if (this.g == null) {
      return;
    }
    this.g.h();
  }
  
  public boolean v()
  {
    return this.d;
  }
  
  public boolean w()
  {
    return this.e;
  }
  
  public boolean x()
  {
    return this.w;
  }
  
  public boolean y()
  {
    return this.v;
  }
  
  void z()
  {
    if ((!this.l) && (!this.m))
    {
      this.m = true;
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).a(D());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/map/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */