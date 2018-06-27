package com.hyphenate.chat.adapter;

import java.util.List;

public class EMAMultiDeviceListener
  extends EMABase
  implements EMAMultiDeviceListenerInterface
{
  public EMAMultiDeviceListener()
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
  
  public void onContactEvent(int paramInt, String paramString1, String paramString2) {}
  
  public void onGroupEvent(int paramInt, String paramString, List<String> paramList) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAMultiDeviceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */