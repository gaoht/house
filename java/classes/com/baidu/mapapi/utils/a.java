package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.BaiduMapRoutePlan;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption.EBusStrategyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static int a;
  static ServiceConnection b = new c();
  private static final String c = BaiduMapRoutePlan.class.getName();
  private static com.baidu.a.a.a.b d;
  private static com.baidu.a.a.a.a e;
  private static int f;
  private static String g;
  private static String h;
  private static String i;
  private static List<DispathcPoiData> j;
  private static LatLng k;
  private static LatLng l;
  private static String m;
  private static String n;
  private static RouteParaOption.EBusStrategyType o;
  private static String p;
  private static String q;
  private static LatLng r;
  private static int s;
  private static boolean t;
  private static boolean u;
  private static Thread v;
  
  static
  {
    a = -1;
    g = null;
    h = null;
    i = null;
    j = new ArrayList();
    k = null;
    l = null;
    m = null;
    n = null;
    p = null;
    q = null;
    r = null;
    s = 0;
    t = false;
    u = false;
  }
  
  public static String a()
  {
    return AppTools.getBaiduMapToken();
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
      c(paramContext, paramInt);
      return;
    case 3: 
      c(paramContext);
      return;
    case 4: 
      d(paramContext);
      return;
    case 5: 
      e(paramContext);
      return;
    case 7: 
      f(paramContext);
      return;
    }
    g(paramContext);
  }
  
  public static void a(Context paramContext)
  {
    if (u)
    {
      paramContext.unbindService(b);
      u = false;
    }
  }
  
  private static void a(List<DispathcPoiData> paramList, Context paramContext)
  {
    g = paramContext.getPackageName();
    h = b(paramContext);
    i = "";
    if (j != null) {
      j.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramContext = (DispathcPoiData)paramList.next();
      j.add(paramContext);
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
    case 1: 
    case 2: 
      return g();
    case 3: 
      return h();
    case 4: 
      return m();
    case 5: 
      return j();
    case 6: 
      return i();
    case 7: 
      return k();
    }
    return l();
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        t = false;
        switch (paramInt)
        {
        case 0: 
          if ((d == null) || (!u)) {
            break label174;
          }
          if (e == null) {
            break label156;
          }
          t = true;
          return a(paramInt);
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return true;
      }
      a = 0;
      continue;
      a = 1;
      continue;
      a = 2;
      continue;
      a = 3;
      continue;
      a = 4;
      continue;
      a = 5;
      continue;
      a = 6;
      continue;
      a = 7;
      continue;
      a = 8;
      continue;
      label156:
      d.a(new b(paramInt));
      return true;
      label174:
      b(paramContext, paramInt);
      return true;
    }
  }
  
  public static boolean a(NaviParaOption paramNaviParaOption, Context paramContext, int paramInt)
  {
    b(paramNaviParaOption, paramContext, paramInt);
    return a(paramContext, paramInt);
  }
  
  public static boolean a(PoiParaOption paramPoiParaOption, Context paramContext, int paramInt)
  {
    b(paramPoiParaOption, paramContext, paramInt);
    return a(paramContext, paramInt);
  }
  
  public static boolean a(RouteParaOption paramRouteParaOption, Context paramContext, int paramInt)
  {
    b(paramRouteParaOption, paramContext, paramInt);
    return a(paramContext, paramInt);
  }
  
  public static boolean a(List<DispathcPoiData> paramList, Context paramContext, int paramInt)
  {
    a(paramList, paramContext);
    return a(paramContext, paramInt);
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 218	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: invokevirtual 126	android/content/Context:getPackageName	()Ljava/lang/String;
    //   12: iconst_0
    //   13: invokevirtual 224	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   16: astore_0
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual 228	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   22: checkcast 230	java/lang/String
    //   25: areturn
    //   26: astore_0
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_2
    //   30: astore_0
    //   31: goto -14 -> 17
    //   34: astore_0
    //   35: aload_2
    //   36: astore_0
    //   37: goto -20 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramContext	Context
    //   6	23	1	localPackageManager	android.content.pm.PackageManager
    //   1	35	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	android/content/pm/PackageManager$NameNotFoundException
    //   7	17	34	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private static void b(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    String str = a();
    if (str == null) {}
    do
    {
      return;
      localIntent.putExtra("api_token", str);
      localIntent.setAction("com.baidu.map.action.OPEN_SERVICE");
      localIntent.setPackage("com.baidu.BaiduMap");
      u = paramContext.bindService(localIntent, b, 1);
    } while (!u);
    v = new Thread(new e(paramContext, paramInt));
    v.setDaemon(true);
    v.start();
  }
  
  private static void b(NaviParaOption paramNaviParaOption, Context paramContext, int paramInt)
  {
    g = paramContext.getPackageName();
    if (paramNaviParaOption.getStartPoint() != null) {
      k = paramNaviParaOption.getStartPoint();
    }
    if (paramNaviParaOption.getEndPoint() != null) {
      l = paramNaviParaOption.getEndPoint();
    }
    if (paramNaviParaOption.getStartName() != null) {
      m = paramNaviParaOption.getStartName();
    }
    if (paramNaviParaOption.getEndName() != null) {
      n = paramNaviParaOption.getEndName();
    }
  }
  
  private static void b(PoiParaOption paramPoiParaOption, Context paramContext, int paramInt)
  {
    g = paramContext.getPackageName();
    if (paramPoiParaOption.getUid() != null) {
      p = paramPoiParaOption.getUid();
    }
    if (paramPoiParaOption.getKey() != null) {
      q = paramPoiParaOption.getKey();
    }
    if (paramPoiParaOption.getCenter() != null) {
      r = paramPoiParaOption.getCenter();
    }
    if (paramPoiParaOption.getRadius() != 0) {
      s = paramPoiParaOption.getRadius();
    }
  }
  
  private static void b(RouteParaOption paramRouteParaOption, Context paramContext, int paramInt)
  {
    g = paramContext.getPackageName();
    if (paramRouteParaOption.getStartPoint() != null) {
      k = paramRouteParaOption.getStartPoint();
    }
    if (paramRouteParaOption.getEndPoint() != null) {
      l = paramRouteParaOption.getEndPoint();
    }
    if (paramRouteParaOption.getStartName() != null) {
      m = paramRouteParaOption.getStartName();
    }
    if (paramRouteParaOption.getEndName() != null) {
      n = paramRouteParaOption.getEndName();
    }
    if (paramRouteParaOption.getBusStrategyType() != null) {
      o = paramRouteParaOption.getBusStrategyType();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      f = 0;
      return;
    case 1: 
      f = 1;
      return;
    }
    f = 2;
  }
  
  private static void c(Context paramContext)
  {
    v.interrupt();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/place/detail?");
    ((StringBuilder)localObject).append("uid=").append(p);
    ((StringBuilder)localObject).append("&show_type=").append("detail_page");
    ((StringBuilder)localObject).append("&src=").append("sdk_[" + g + "]");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void c(Context paramContext, int paramInt)
  {
    v.interrupt();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/direction?");
    ((StringBuilder)localObject).append("origin=");
    if ((!TextUtils.isEmpty(m)) && (k != null))
    {
      ((StringBuilder)localObject).append("name:").append(m).append("|latlng:").append(k.latitude).append(",").append(k.longitude);
      ((StringBuilder)localObject).append("&destination=");
      if ((TextUtils.isEmpty(n)) || (l == null)) {
        break label331;
      }
      ((StringBuilder)localObject).append("name:").append(n).append("|latlng:").append(l.latitude).append(",").append(l.longitude);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("&mode=").append(new String[] { "driving", "transit", "walking" }[paramInt]);
      ((StringBuilder)localObject).append("&target=").append("1");
      ((StringBuilder)localObject).append("&src=").append("sdk_[" + g + "]");
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
      return;
      if (!TextUtils.isEmpty(m))
      {
        ((StringBuilder)localObject).append(m);
        break;
      }
      if (k == null) {
        break;
      }
      ((StringBuilder)localObject).append(k.latitude).append(",").append(k.longitude);
      break;
      label331:
      if (!TextUtils.isEmpty(n)) {
        ((StringBuilder)localObject).append(n);
      } else if (l != null) {
        ((StringBuilder)localObject).append(l.latitude).append(",").append(l.longitude);
      }
    }
  }
  
  private static void d(Context paramContext)
  {
    v.interrupt();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/nearbysearch?");
    ((StringBuilder)localObject).append("center=").append(r.latitude).append(",").append(r.longitude);
    ((StringBuilder)localObject).append("&query=").append(q).append("&radius=").append(s);
    ((StringBuilder)localObject).append("&src=").append("sdk_[" + g + "]");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void e(Context paramContext)
  {
    v.interrupt();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/navi?");
    ((StringBuilder)localObject).append("origin=").append(k.latitude).append(",").append(k.longitude);
    ((StringBuilder)localObject).append("&location=").append(l.latitude).append(",").append(l.longitude);
    ((StringBuilder)localObject).append("&src=").append("sdk_[" + g + "]");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void f(Context paramContext)
  {
    v.interrupt();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/walknavi?");
    ((StringBuilder)localObject).append("origin=").append(k.latitude).append(",").append(k.longitude);
    ((StringBuilder)localObject).append("&destination=").append(l.latitude).append(",").append(l.longitude);
    ((StringBuilder)localObject).append("&src=").append("sdk_[" + g + "]");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void g(Context paramContext)
  {
    v.interrupt();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/bikenavi?");
    ((StringBuilder)localObject).append("origin=").append(k.latitude).append(",").append(k.longitude);
    ((StringBuilder)localObject).append("&destination=").append(l.latitude).append(",").append(l.longitude);
    ((StringBuilder)localObject).append("&src=").append("sdk_[" + g + "]");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static boolean g()
  {
    for (;;)
    {
      Bundle localBundle2;
      try
      {
        Log.d(c, "callDispatchTakeOutRoute");
        String str = e.a("map.android.baidu.mainmap");
        if (str == null) {
          break;
        }
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("target", "route_search_page");
        localBundle2 = new Bundle();
        localBundle2.putInt("route_type", f);
        localBundle2.putInt("bus_strategy", o.ordinal());
        localBundle2.putInt("cross_city_bus_strategy", 5);
        if (k != null)
        {
          localBundle2.putInt("start_type", 1);
          localBundle2.putInt("start_longitude", (int)CoordUtil.ll2mc(k).getLongitudeE6());
          localBundle2.putInt("start_latitude", (int)CoordUtil.ll2mc(k).getLatitudeE6());
          if (m != null)
          {
            localBundle2.putString("start_keyword", m);
            localBundle2.putString("start_uid", "");
            if (l == null) {
              break label356;
            }
            localBundle2.putInt("end_type", 1);
            localBundle2.putInt("end_longitude", (int)CoordUtil.ll2mc(l).getLongitudeE6());
            localBundle2.putInt("end_latitude", (int)CoordUtil.ll2mc(l).getLatitudeE6());
            if (n == null) {
              break label383;
            }
            localBundle2.putString("end_keyword", n);
            localBundle2.putString("end_uid", "");
            localBundle1.putBundle("base_params", localBundle2);
            localBundle2 = new Bundle();
            localBundle2.putString("launch_from", "sdk_[" + g + "]");
            localBundle1.putBundle("ext_params", localBundle2);
            return e.a("map.android.baidu.mainmap", str, localBundle1);
          }
        }
        else
        {
          localBundle2.putInt("start_type", 2);
          localBundle2.putInt("start_longitude", 0);
          localBundle2.putInt("start_latitude", 0);
          continue;
        }
        localBundle2.putString("start_keyword", "地图上的点");
      }
      catch (RemoteException localRemoteException)
      {
        Log.d(c, "callDispatchTakeOut exception", localRemoteException);
        return false;
      }
      continue;
      label356:
      localBundle2.putInt("end_type", 2);
      localBundle2.putInt("end_longitude", 0);
      localBundle2.putInt("end_latitude", 0);
      continue;
      label383:
      localBundle2.putString("end_keyword", "地图上的点");
    }
    Log.d(c, "callDispatchTakeOut com not found");
    return false;
  }
  
  private static boolean h()
  {
    try
    {
      Log.d(c, "callDispatchTakeOutPoiDetials");
      String str = e.a("map.android.baidu.mainmap");
      if (str != null)
      {
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("target", "request_poi_detail_page");
        Bundle localBundle2 = new Bundle();
        if (p != null) {
          localBundle2.putString("uid", p);
        }
        for (;;)
        {
          localBundle1.putBundle("base_params", localBundle2);
          localBundle2 = new Bundle();
          localBundle2.putString("launch_from", "sdk_[" + g + "]");
          localBundle1.putBundle("ext_params", localBundle2);
          return e.a("map.android.baidu.mainmap", str, localBundle1);
          localBundle2.putString("uid", "");
        }
        return false;
      }
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(c, "callDispatchTakeOut exception", localRemoteException);
    }
    for (;;)
    {
      Log.d(c, "callDispatchTakeOut com not found");
    }
  }
  
  private static boolean i()
  {
    if ((j == null) || (j.size() <= 0)) {
      return false;
    }
    for (;;)
    {
      String str;
      Bundle localBundle2;
      Bundle localBundle3;
      JSONArray localJSONArray;
      int i2;
      int i1;
      try
      {
        Log.d(c, "callDispatchPoiToBaiduMap");
        str = e.a("map.android.baidu.mainmap");
        if (str != null)
        {
          localBundle2 = new Bundle();
          localBundle2.putString("target", "favorite_page");
          localBundle3 = new Bundle();
          localJSONArray = new JSONArray();
          i2 = 0;
          i1 = 0;
          if (i2 < j.size())
          {
            if ((((DispathcPoiData)j.get(i2)).name == null) || (((DispathcPoiData)j.get(i2)).name.equals("")) || (((DispathcPoiData)j.get(i2)).pt == null)) {
              break label475;
            }
            localJSONObject = new JSONObject();
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        JSONObject localJSONObject;
        GeoPoint localGeoPoint;
        Log.d(c, "callDispatchPoiToBaiduMap exception", localRemoteException);
        return false;
      }
      try
      {
        localJSONObject.put("name", ((DispathcPoiData)j.get(i2)).name);
        localGeoPoint = CoordUtil.ll2mc(((DispathcPoiData)j.get(i2)).pt);
        localJSONObject.put("ptx", localGeoPoint.getLongitudeE6());
        localJSONObject.put("pty", localGeoPoint.getLatitudeE6());
        localJSONObject.put("addr", ((DispathcPoiData)j.get(i2)).addr);
        localJSONObject.put("uid", ((DispathcPoiData)j.get(i2)).uid);
        i1 += 1;
        try
        {
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        Bundle localBundle1;
        continue;
      }
      localJSONException1.printStackTrace();
      break label475;
      if (i1 == 0) {
        return false;
      }
      localBundle3.putString("data", localJSONArray.toString());
      localBundle3.putString("from", h);
      localBundle3.putString("pkg", g);
      localBundle3.putString("cls", i);
      localBundle3.putInt("count", i1);
      localBundle2.putBundle("base_params", localBundle3);
      localBundle1 = new Bundle();
      localBundle1.putString("launch_from", "sdk_[" + g + "]");
      localBundle2.putBundle("ext_params", localBundle1);
      return e.a("map.android.baidu.mainmap", str, localBundle2);
      Log.d(c, "callDispatchPoiToBaiduMap com not found");
      continue;
      label475:
      i2 += 1;
    }
  }
  
  private static boolean j()
  {
    try
    {
      Log.d(c, "callDispatchTakeOutRouteNavi");
      String str = e.a("map.android.baidu.mainmap");
      if (str != null)
      {
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("target", "navigation_page");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("coord_type", "bd09ll");
        localBundle2.putString("type", "DIS");
        StringBuffer localStringBuffer1 = new StringBuffer();
        if (m != null) {
          localStringBuffer1.append("name:" + m + "|");
        }
        localStringBuffer1.append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(k.latitude), Double.valueOf(k.longitude) }));
        StringBuffer localStringBuffer2 = new StringBuffer();
        if (n != null) {
          localStringBuffer2.append("name:" + n + "|");
        }
        localStringBuffer2.append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(l.latitude), Double.valueOf(l.longitude) }));
        localBundle2.putString("origin", localStringBuffer1.toString());
        localBundle2.putString("destination", localStringBuffer2.toString());
        localBundle1.putBundle("base_params", localBundle2);
        localBundle2 = new Bundle();
        localBundle2.putString("launch_from", "sdk_[" + g + "]");
        localBundle1.putBundle("ext_params", localBundle2);
        return e.a("map.android.baidu.mainmap", str, localBundle1);
      }
      Log.d(c, "callDispatchTakeOut com not found");
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(c, "callDispatchTakeOut exception", localRemoteException);
    }
    return false;
  }
  
  private static boolean k()
  {
    try
    {
      Log.d(c, "callDispatchTakeOutRouteNavi");
      String str = e.a("map.android.baidu.mainmap");
      if (str != null)
      {
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("target", "walknavi_page");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("coord_type", "bd09ll");
        StringBuffer localStringBuffer1 = new StringBuffer();
        if (m != null) {
          localStringBuffer1.append("name:" + m + "|");
        }
        localStringBuffer1.append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(k.latitude), Double.valueOf(k.longitude) }));
        StringBuffer localStringBuffer2 = new StringBuffer();
        if (n != null) {
          localStringBuffer2.append("name:" + n + "|");
        }
        localStringBuffer2.append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(l.latitude), Double.valueOf(l.longitude) }));
        localBundle2.putString("origin", localStringBuffer1.toString());
        localBundle2.putString("destination", localStringBuffer2.toString());
        localBundle1.putBundle("base_params", localBundle2);
        localBundle2 = new Bundle();
        localBundle2.putString("launch_from", "sdk_[" + g + "]");
        localBundle1.putBundle("ext_params", localBundle2);
        return e.a("map.android.baidu.mainmap", str, localBundle1);
      }
      Log.d(c, "callDispatchTakeOut com not found");
      return false;
    }
    catch (Exception localException)
    {
      Log.d(c, "callDispatchTakeOut exception", localException);
    }
    return false;
  }
  
  private static boolean l()
  {
    try
    {
      Log.d(c, "callDispatchTakeOutRouteRidingNavi");
      String str = e.a("map.android.baidu.mainmap");
      if (str != null)
      {
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("target", "bikenavi_page");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("coord_type", "bd09ll");
        StringBuffer localStringBuffer1 = new StringBuffer();
        if (m != null) {
          localStringBuffer1.append("name:" + m + "|");
        }
        localStringBuffer1.append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(k.latitude), Double.valueOf(k.longitude) }));
        StringBuffer localStringBuffer2 = new StringBuffer();
        if (n != null) {
          localStringBuffer2.append("name:" + n + "|");
        }
        localStringBuffer2.append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(l.latitude), Double.valueOf(l.longitude) }));
        localBundle2.putString("origin", localStringBuffer1.toString());
        localBundle2.putString("destination", localStringBuffer2.toString());
        localBundle1.putBundle("base_params", localBundle2);
        localBundle2 = new Bundle();
        localBundle2.putString("launch_from", "sdk_[" + g + "]");
        localBundle1.putBundle("ext_params", localBundle2);
        return e.a("map.android.baidu.mainmap", str, localBundle1);
      }
      Log.d(c, "callDispatchTakeOut com not found");
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(c, "callDispatchTakeOut exception", localRemoteException);
    }
    return false;
  }
  
  private static boolean m()
  {
    Bundle localBundle2;
    try
    {
      Log.d(c, "callDispatchTakeOutPoiNearbySearch");
      String str = e.a("map.android.baidu.mainmap");
      if (str != null)
      {
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("target", "poi_search_page");
        localBundle2 = new Bundle();
        if (q != null) {
          localBundle2.putString("search_key", q);
        }
        while (r != null)
        {
          localBundle2.putInt("center_pt_x", (int)CoordUtil.ll2mc(r).getLongitudeE6());
          localBundle2.putInt("center_pt_y", (int)CoordUtil.ll2mc(r).getLatitudeE6());
          if (s == 0) {
            break label251;
          }
          localBundle2.putInt("search_radius", s);
          label124:
          localBundle2.putBoolean("is_direct_search", true);
          localBundle2.putBoolean("is_direct_area_search", true);
          localBundle1.putBundle("base_params", localBundle2);
          localBundle2 = new Bundle();
          localBundle2.putString("launch_from", "sdk_[" + g + "]");
          localBundle1.putBundle("ext_params", localBundle2);
          return e.a("map.android.baidu.mainmap", str, localBundle1);
          localBundle2.putString("search_key", "");
          continue;
          return false;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(c, "callDispatchTakeOut exception", localRemoteException);
    }
    for (;;)
    {
      localBundle2.putString("search_key", "");
      break;
      label251:
      localBundle2.putInt("search_radius", 1000);
      break label124;
      Log.d(c, "callDispatchTakeOut com not found");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */