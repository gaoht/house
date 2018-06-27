package com.hyphenate.chat.adapter;

public class EMACallConfigs
{
  public EMACallConfigs(EMACallConfigs paramEMACallConfigs)
  {
    nativeInit(paramEMACallConfigs);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public boolean getIsSendPushIfOffline()
  {
    return nativeGetIsSendPushIfOffline();
  }
  
  public long getVideoKbps()
  {
    return nativeGetVideoKbps();
  }
  
  public long getVideoResolutionHeight()
  {
    return nativeGetVideoResolutionHeight();
  }
  
  public long getVideoResolutionWidth()
  {
    return nativeGetVideoResolutionWidth();
  }
  
  native void nativeFinalize();
  
  native boolean nativeGetIsSendPushIfOffline();
  
  native long nativeGetVideoKbps();
  
  native long nativeGetVideoResolutionHeight();
  
  native long nativeGetVideoResolutionWidth();
  
  native void nativeInit();
  
  native void nativeInit(EMACallConfigs paramEMACallConfigs);
  
  native void nativeSetIsSendPushIfOffline(boolean paramBoolean);
  
  native long nativeSetVideoKbps(long paramLong);
  
  native long nativeSetVideoResolution(long paramLong1, long paramLong2);
  
  public void setIsSendPushIfOffline(boolean paramBoolean)
  {
    nativeSetIsSendPushIfOffline(paramBoolean);
  }
  
  public void setVideoKbps(long paramLong)
  {
    nativeSetVideoKbps(paramLong);
  }
  
  public void setVideoResolution(long paramLong1, long paramLong2)
  {
    nativeSetVideoResolution(paramLong1, paramLong2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallConfigs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */