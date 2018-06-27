package com.hyphenate.chat.adapter;

public class EMARHttpCallback
  extends EMABase
{
  EMARHttpCallback()
  {
    nativeInit();
  }
  
  public EMARHttpCallback(EMARHttpCallback paramEMARHttpCallback)
  {
    nativeInit();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit();
  
  native void nativeInit(EMARHttpCallback paramEMARHttpCallback);
  
  native void native_onProgress(double paramDouble1, double paramDouble2);
  
  public void onProgress(double paramDouble1, double paramDouble2)
  {
    native_onProgress(paramDouble1, paramDouble2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMARHttpCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */