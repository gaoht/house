package com.hyphenate.chat.adapter;

public abstract class EMACallConferenceListener
  extends EMABase
{
  public EMACallConferenceListener()
  {
    nativeInit();
  }
  
  protected void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit();
  
  public void onReceiveInvite(String paramString1, String paramString2, String paramString3) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallConferenceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */