package com.hyphenate.chat.adapter;

import com.superrtc.sdk.d.b;

public abstract interface EMACallManagerListenerInterface
{
  public abstract void onNewRtcConnection(String paramString1, int paramInt, String paramString2, d.b paramb, EMACallRtcImpl paramEMACallRtcImpl);
  
  public abstract void onRecvCallAccepted(EMACallSession paramEMACallSession);
  
  public abstract void onRecvCallConnected(EMACallSession paramEMACallSession);
  
  public abstract void onRecvCallEnded(EMACallSession paramEMACallSession, int paramInt, EMAError paramEMAError);
  
  public abstract void onRecvCallFeatureUnsupported(EMACallSession paramEMACallSession, EMAError paramEMAError);
  
  public abstract void onRecvCallIncoming(EMACallSession paramEMACallSession);
  
  public abstract void onRecvCallNetworkStatusChanged(EMACallSession paramEMACallSession, int paramInt);
  
  public abstract void onRecvCallStateChanged(EMACallSession paramEMACallSession, int paramInt);
  
  public abstract void onSendPushMessage(String paramString1, String paramString2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallManagerListenerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */