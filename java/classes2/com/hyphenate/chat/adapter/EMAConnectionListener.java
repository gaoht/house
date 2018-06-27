package com.hyphenate.chat.adapter;

public abstract class EMAConnectionListener
  extends EMABase
  implements EMAConnectionListenerInterface
{
  public EMAConnectionListener()
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
  
  public void onConnected() {}
  
  public void onDisconnected(int paramInt) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAConnectionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */