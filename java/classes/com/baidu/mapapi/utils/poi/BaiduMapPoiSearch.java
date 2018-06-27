package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.route.BaiduMapRoutePlan;
import java.util.List;

public class BaiduMapPoiSearch
{
  private static boolean a = true;
  
  private static void a(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("http://api.map.baidu.com/place/detail?");
    ((StringBuilder)localObject).append("uid=");
    ((StringBuilder)localObject).append(paramPoiParaOption.a);
    ((StringBuilder)localObject).append("&output=html");
    ((StringBuilder)localObject).append("&src=");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    paramPoiParaOption = Uri.parse(((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(paramPoiParaOption);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void b(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("http://api.map.baidu.com/place/search?");
    ((StringBuilder)localObject).append("query=");
    ((StringBuilder)localObject).append(paramPoiParaOption.b);
    ((StringBuilder)localObject).append("&location=");
    ((StringBuilder)localObject).append(paramPoiParaOption.c.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramPoiParaOption.c.longitude);
    ((StringBuilder)localObject).append("&radius=");
    ((StringBuilder)localObject).append(paramPoiParaOption.d);
    ((StringBuilder)localObject).append("&output=html");
    ((StringBuilder)localObject).append("&src=");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    paramPoiParaOption = Uri.parse(((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(paramPoiParaOption);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void b(String paramString, Context paramContext)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new RuntimeException("pano id can not be null.");
    }
    if (paramContext == null) {
      throw new RuntimeException("context cannot be null.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("baidumap://map/streetscape?");
    localStringBuilder.append("panoid=").append(paramString);
    localStringBuilder.append("&pid=").append(paramString);
    localStringBuilder.append("&panotype=").append("street");
    localStringBuilder.append("&src=").append("sdk_[" + paramContext.getPackageName() + "]");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString()));
    paramString.setFlags(268435456);
    paramContext.startActivity(paramString);
  }
  
  public static boolean dispatchPoiToBaiduMap(List<DispathcPoiData> paramList, Context paramContext)
    throws Exception
  {
    if ((paramList.isEmpty()) || (paramList.size() <= 0)) {
      throw new NullPointerException("dispatch poidata is null");
    }
    int i = OpenClientUtil.getBaiduMapVersion(paramContext);
    if (i != 0)
    {
      if (i >= 840) {
        return com.baidu.mapapi.utils.a.a(paramList, paramContext, 6);
      }
      Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.4");
    }
    for (;;)
    {
      return false;
      Log.e("baidumapsdk", "BaiduMap app is not installed.");
    }
  }
  
  public static void finish(Context paramContext)
  {
    if (paramContext != null) {
      com.baidu.mapapi.utils.a.a(paramContext);
    }
  }
  
  public static void openBaiduMapPanoShow(String paramString, Context paramContext)
  {
    new com.baidu.platform.comapi.a.a(paramContext).a(paramString, new a(paramContext));
  }
  
  public static boolean openBaiduMapPoiDetialsPage(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    if ((paramPoiParaOption == null) || (paramContext == null)) {
      throw new IllegalPoiSearchArgumentException("para or context can not be null.");
    }
    if (paramPoiParaOption.a == null) {
      throw new IllegalPoiSearchArgumentException("poi uid can not be null.");
    }
    if (paramPoiParaOption.a.equals(""))
    {
      Log.e(BaiduMapRoutePlan.class.getName(), "poi uid can not be empty string");
      return false;
    }
    int i = OpenClientUtil.getBaiduMapVersion(paramContext);
    if (i != 0)
    {
      if (i >= 810) {
        return com.baidu.mapapi.utils.a.a(paramPoiParaOption, paramContext, 3);
      }
      Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
      if (a)
      {
        a(paramPoiParaOption, paramContext);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
    }
    Log.e("baidumapsdk", "BaiduMap app is not installed.");
    if (a)
    {
      a(paramPoiParaOption, paramContext);
      return true;
    }
    throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
  }
  
  public static boolean openBaiduMapPoiNearbySearch(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    if ((paramPoiParaOption == null) || (paramContext == null)) {
      throw new IllegalPoiSearchArgumentException("para or context can not be null.");
    }
    if (paramPoiParaOption.b == null) {
      throw new IllegalPoiSearchArgumentException("poi search key can not be null.");
    }
    if (paramPoiParaOption.c == null) {
      throw new IllegalPoiSearchArgumentException("poi search center can not be null.");
    }
    if ((paramPoiParaOption.c.longitude == 0.0D) || (paramPoiParaOption.c.latitude == 0.0D)) {
      throw new IllegalPoiSearchArgumentException("poi search center longitude or latitude can not be 0.");
    }
    if (paramPoiParaOption.d == 0) {
      throw new IllegalPoiSearchArgumentException("poi search radius larger than 0.");
    }
    if (paramPoiParaOption.b.equals(""))
    {
      Log.e(BaiduMapRoutePlan.class.getName(), "poi key can not be empty string");
      return false;
    }
    int i = OpenClientUtil.getBaiduMapVersion(paramContext);
    if (i != 0)
    {
      if (i >= 810) {
        return com.baidu.mapapi.utils.a.a(paramPoiParaOption, paramContext, 4);
      }
      Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
      if (a)
      {
        b(paramPoiParaOption, paramContext);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("Baidumap app version is too lowl.Version is greater than 8.1");
    }
    Log.e("baidumapsdk", "BaiduMap app is not installed.");
    if (a)
    {
      b(paramPoiParaOption, paramContext);
      return true;
    }
    throw new IllegalPoiSearchArgumentException("BaiduMap app is not installed.");
  }
  
  public static void setSupportWebPoi(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/poi/BaiduMapPoiSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */