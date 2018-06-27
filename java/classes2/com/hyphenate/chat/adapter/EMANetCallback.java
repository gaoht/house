package com.hyphenate.chat.adapter;

public abstract class EMANetCallback
  extends EMABase
{
  public EMANetCallback()
  {
    nativeInit();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public abstract int getNetState();
  
  native void nativeFinalize();
  
  native void nativeInit();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMANetCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */