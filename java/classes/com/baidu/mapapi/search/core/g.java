package com.baidu.mapapi.search.core;

import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.platform.comapi.NativeLoader;

public class g
{
  static
  {
    if (!VersionInfo.getApiVersion().equals(j.a())) {
      throw new BaiduMapSDKException("the version of search is not match with base");
    }
    NativeLoader.getInstance().loadLibrary(j.b());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */