package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.e;
import java.util.ArrayList;
import java.util.List;

class a
  implements Overlay.a
{
  a(BaiduMap paramBaiduMap) {}
  
  public void a(Overlay paramOverlay)
  {
    if ((paramOverlay != null) && (BaiduMap.a(this.a).contains(paramOverlay)))
    {
      Bundle localBundle = paramOverlay.a();
      if (BaiduMap.b(this.a) != null) {
        BaiduMap.b(this.a).d(localBundle);
      }
      BaiduMap.a(this.a).remove(paramOverlay);
    }
    if ((paramOverlay != null) && (BaiduMap.c(this.a).contains(paramOverlay))) {
      BaiduMap.c(this.a).remove(paramOverlay);
    }
    if ((paramOverlay != null) && (BaiduMap.d(this.a).contains(paramOverlay)))
    {
      paramOverlay = (Marker)paramOverlay;
      if (paramOverlay.n != null)
      {
        BaiduMap.d(this.a).remove(paramOverlay);
        if ((BaiduMap.d(this.a).size() == 0) && (BaiduMap.b(this.a) != null)) {
          BaiduMap.b(this.a).b(false);
        }
      }
    }
  }
  
  public void b(Overlay paramOverlay)
  {
    if ((paramOverlay != null) && (BaiduMap.a(this.a).contains(paramOverlay)))
    {
      if ((paramOverlay instanceof Marker))
      {
        localObject = (Marker)paramOverlay;
        if ((((Marker)localObject).n != null) && (((Marker)localObject).n.size() != 0))
        {
          if (BaiduMap.d(this.a).contains(localObject)) {
            BaiduMap.d(this.a).remove(localObject);
          }
          BaiduMap.d(this.a).add(localObject);
          if (BaiduMap.b(this.a) != null) {
            BaiduMap.b(this.a).b(true);
          }
        }
      }
      Object localObject = new Bundle();
      if (BaiduMap.b(this.a) != null) {
        BaiduMap.b(this.a).c(paramOverlay.a((Bundle)localObject));
      }
    }
    if (BaiduMap.c(this.a).contains(paramOverlay)) {
      BaiduMap.c(this.a).remove(paramOverlay);
    }
    if ((paramOverlay instanceof Marker))
    {
      paramOverlay = (Marker)paramOverlay;
      BaiduMap.c(this.a).add(paramOverlay);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */