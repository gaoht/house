package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.platform.comapi.a.a.a;
import com.baidu.platform.comapi.a.c;

final class a
  implements a.a<c>
{
  a(Context paramContext) {}
  
  public void a(HttpClient.HttpStateError paramHttpStateError)
  {
    switch (BaiduMapPoiSearch.1.b[paramHttpStateError.ordinal()])
    {
    default: 
      return;
    case 1: 
      Log.d("baidumapsdk", "current network is not available");
      return;
    }
    Log.d("baidumapsdk", "network inner error, please check network");
  }
  
  public void a(c paramc)
  {
    if (paramc == null)
    {
      Log.d("baidumapsdk", "pano info is null");
      return;
    }
    switch (BaiduMapPoiSearch.1.a[paramc.a().ordinal()])
    {
    default: 
      return;
    case 1: 
      Log.d("baidumapsdk", "pano uid is error, please check param poi uid");
      return;
    case 2: 
      Log.d("baidumapsdk", "pano id not found for this poi point");
      return;
    case 3: 
      Log.d("baidumapsdk", "please check ak for permission");
      return;
    }
    if (paramc.c() == 1)
    {
      BaiduMapPoiSearch.a(paramc.b(), this.a);
      return;
    }
    Log.d("baidumapsdk", "this point do not support for pano show");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/utils/poi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */