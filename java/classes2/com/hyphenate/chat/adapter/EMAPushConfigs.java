package com.hyphenate.chat.adapter;

public class EMAPushConfigs
  extends EMABase
{
  public EMAPushConfigs()
  {
    nativeInit();
  }
  
  public EMAPushConfigs(EMAPushConfigs paramEMAPushConfigs)
  {
    nativeInit(paramEMAPushConfigs);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public String getDisplayNickname()
  {
    return nativeGetDisplayNickname();
  }
  
  public int getNoDisturbEndHour()
  {
    return nativeGetNoDisturbEndHour();
  }
  
  public int getNoDisturbStartHour()
  {
    return nativeGetNoDisturbStartHour();
  }
  
  public boolean isNoDisturbOn()
  {
    return nativeIsNoDisturbOn();
  }
  
  native void nativeFinalize();
  
  native String nativeGetDisplayNickname();
  
  native int nativeGetNoDisturbEndHour();
  
  native int nativeGetNoDisturbStartHour();
  
  native void nativeInit();
  
  native void nativeInit(EMAPushConfigs paramEMAPushConfigs);
  
  native boolean nativeIsNoDisturbOn();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAPushConfigs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */