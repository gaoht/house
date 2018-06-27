package com.baidu.platform.comjni.map.commonmemcache;

import android.os.Bundle;

public class JNICommonMemCache
{
  public native long Create();
  
  public native String GetPhoneInfoUrl(long paramLong);
  
  public native void Init(long paramLong, Bundle paramBundle);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/map/commonmemcache/JNICommonMemCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */