package com.baidu.mapapi.a.a;

import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.platform.comapi.NativeLoader;

public class a
{
  static
  {
    if (!VersionInfo.getApiVersion().equals(b.a())) {
      throw new BaiduMapSDKException("the version of util is not match with base");
    }
    NativeLoader.getInstance().loadLibrary(b.b());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */