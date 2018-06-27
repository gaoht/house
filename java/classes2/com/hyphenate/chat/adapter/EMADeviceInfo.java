package com.hyphenate.chat.adapter;

public class EMADeviceInfo
  extends EMABase
{
  public EMADeviceInfo()
  {
    nativeInit();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public String getDeviceName()
  {
    return nativeGetDeviceName();
  }
  
  public String getDeviceUUID()
  {
    return nativeGetDeviceUUID();
  }
  
  public String getResource()
  {
    return nativeGetResource();
  }
  
  native void nativeFinalize();
  
  native String nativeGetDeviceName();
  
  native String nativeGetDeviceUUID();
  
  native String nativeGetResource();
  
  native void nativeInit();
  
  native void nativeSetDeviceName(String paramString);
  
  native void nativeSetDeviceUUID(String paramString);
  
  native void nativeSetResource(String paramString);
  
  public void setDeviceName(String paramString)
  {
    nativeSetDeviceName(paramString);
  }
  
  public void setDeviceUUID(String paramString)
  {
    nativeSetDeviceUUID(paramString);
  }
  
  public void setResource(String paramString)
  {
    nativeSetResource(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMADeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */