package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.map.K;
import java.util.concurrent.locks.Lock;

class d
  implements K
{
  d(BaiduMap paramBaiduMap) {}
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Context paramContext)
  {
    BaiduMap.y(this.a).lock();
    try
    {
      if (BaiduMap.z(this.a) != null)
      {
        paramContext = BaiduMap.z(this.a).a(paramInt1, paramInt2, paramInt3);
        if (paramContext != null)
        {
          paramContext = paramContext.toBundle();
          return paramContext;
        }
      }
      return null;
    }
    finally
    {
      BaiduMap.y(this.a).unlock();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */