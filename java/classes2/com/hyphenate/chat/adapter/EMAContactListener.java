package com.hyphenate.chat.adapter;

public abstract class EMAContactListener
  extends EMABase
  implements EMAContactListenerInterface
{
  public EMAContactListener()
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
  
  public void onContactAdded(String paramString) {}
  
  public void onContactAgreed(String paramString) {}
  
  public void onContactDeleted(String paramString) {}
  
  public void onContactInvited(String paramString1, String paramString2) {}
  
  public void onContactRefused(String paramString) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAContactListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */