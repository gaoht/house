package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.p;
import java.util.concurrent.locks.Lock;

class c
  implements p
{
  c(BaiduMap paramBaiduMap) {}
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3)
  {
    BaiduMap.u(this.a).lock();
    try
    {
      if (BaiduMap.v(this.a) != null)
      {
        Object localObject1 = BaiduMap.v(this.a).a(paramInt1, paramInt2, paramInt3);
        if (localObject1 != null)
        {
          localObject1 = ((Tile)localObject1).toBundle();
          return (Bundle)localObject1;
        }
      }
      return null;
    }
    finally
    {
      BaiduMap.u(this.a).unlock();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */