package com.hyphenate.chat.adapter;

import com.superrtc.sdk.d.b;

public class EMACallManagerListener
  extends EMABase
  implements EMACallManagerListenerInterface
{
  public EMACallManagerListener()
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
  
  public void onNewRtcConnection(String paramString1, int paramInt, String paramString2, d.b paramb, EMACallRtcImpl paramEMACallRtcImpl) {}
  
  public void onRecvCallAccepted(EMACallSession paramEMACallSession) {}
  
  public void onRecvCallConnected(EMACallSession paramEMACallSession) {}
  
  public void onRecvCallEnded(EMACallSession paramEMACallSession, int paramInt, EMAError paramEMAError) {}
  
  public void onRecvCallFeatureUnsupported(EMACallSession paramEMACallSession, EMAError paramEMAError) {}
  
  public void onRecvCallIncoming(EMACallSession paramEMACallSession) {}
  
  public void onRecvCallNetworkStatusChanged(EMACallSession paramEMACallSession, int paramInt) {}
  
  public void onRecvCallStateChanged(EMACallSession paramEMACallSession, int paramInt) {}
  
  public void onSendPushMessage(String paramString1, String paramString2) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */