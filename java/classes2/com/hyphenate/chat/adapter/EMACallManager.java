package com.hyphenate.chat.adapter;

public class EMACallManager
  extends EMABase
{
  public void addListener(EMACallManagerListener paramEMACallManagerListener)
  {
    nativeAddListener(paramEMACallManagerListener);
  }
  
  public void answerCall(String paramString, EMAError paramEMAError)
  {
    nativeAnswerCall(paramString, paramEMAError);
  }
  
  public native boolean capturePicture(String paramString);
  
  void clearListeners()
  {
    nativeClearListeners();
  }
  
  public String creatorGetTicketFromServer(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeCreatorGetTicketFromServer(paramString1, paramString2, paramEMAError);
  }
  
  public void endCall(String paramString, EMACallSession.EndReason paramEndReason)
  {
    nativeEndCall(paramString, paramEndReason.ordinal());
  }
  
  public boolean getIsSendPushIfOffline()
  {
    return nativeGetIsSendPushIfOffline();
  }
  
  public long getVideoKbps()
  {
    return nativeGetVideoKbps();
  }
  
  public long getVideoResolutionHeight()
  {
    return nativeGetVideoResolutionHeight();
  }
  
  public long getVideoResolutionWidth()
  {
    return nativeGetVideoResolutionWidth();
  }
  
  public void inviteUserToJoinConference(String paramString1, String paramString2, String paramString3, String paramString4, EMAError paramEMAError)
  {
    nativeInviteUserToJoinConference(paramString1, paramString2, paramString3, paramString4, paramEMAError);
  }
  
  public EMACallSession makeCall(String paramString, EMACallSession.Type paramType, EMAError paramEMAError)
  {
    return nativeMakeCall(paramString, paramType.ordinal(), "", paramEMAError);
  }
  
  public EMACallSession makeCall(String paramString1, EMACallSession.Type paramType, String paramString2, EMAError paramEMAError)
  {
    return nativeMakeCall(paramString1, paramType.ordinal(), paramString2, paramEMAError);
  }
  
  public String memberGetTicketFromServer(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeMemberGetTicketFromServer(paramString1, paramString2, paramEMAError);
  }
  
  native void nativeAddListener(EMACallManagerListener paramEMACallManagerListener);
  
  native void nativeAnswerCall(String paramString, EMAError paramEMAError);
  
  native void nativeClearListeners();
  
  native String nativeCreatorGetTicketFromServer(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeEndCall(String paramString, int paramInt);
  
  native boolean nativeGetIsSendPushIfOffline();
  
  native long nativeGetVideoKbps();
  
  native long nativeGetVideoResolutionHeight();
  
  native long nativeGetVideoResolutionWidth();
  
  native void nativeInviteUserToJoinConference(String paramString1, String paramString2, String paramString3, String paramString4, EMAError paramEMAError);
  
  native EMACallSession nativeMakeCall(String paramString1, int paramInt, String paramString2, EMAError paramEMAError);
  
  native String nativeMemberGetTicketFromServer(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeRemoveCallConferenceListener();
  
  native void nativeRemoveListener(EMACallManagerListener paramEMACallManagerListener);
  
  native void nativeSetCallConferenceListener(EMACallConferenceListener paramEMACallConferenceListener);
  
  native void nativeSetIsSendPushIfOffline(boolean paramBoolean);
  
  native void nativeSetMaxAudioKbps(long paramLong);
  
  native void nativeSetPingInterval(long paramLong);
  
  native void nativeSetVideoKbps(long paramLong);
  
  native void nativeSetVideoResolution(long paramLong1, long paramLong2);
  
  native void nativeUpdateCall(String paramString, int paramInt, EMAError paramEMAError);
  
  native void nativeUpdateSessionInfo(String paramString, int paramInt);
  
  public void removeCallConferenceListener()
  {
    nativeRemoveCallConferenceListener();
  }
  
  void removeListener(EMACallManagerListener paramEMACallManagerListener)
  {
    nativeRemoveListener(paramEMACallManagerListener);
  }
  
  public void setCallConferenceListener(EMACallConferenceListener paramEMACallConferenceListener)
  {
    nativeSetCallConferenceListener(paramEMACallConferenceListener);
  }
  
  public void setIsSendPushIfOffline(boolean paramBoolean)
  {
    nativeSetIsSendPushIfOffline(paramBoolean);
  }
  
  public void setMaxAudioKbps(long paramLong)
  {
    nativeSetMaxAudioKbps(paramLong);
  }
  
  public void setPingInterval(int paramInt)
  {
    nativeSetPingInterval(paramInt);
  }
  
  public void setVideoKbps(long paramLong)
  {
    nativeSetVideoKbps(paramLong);
  }
  
  public void setVideoResolution(long paramLong1, long paramLong2)
  {
    nativeSetVideoResolution(paramLong1, paramLong2);
  }
  
  public native void startRecordVideo(String paramString);
  
  public native String stopRecordVideo();
  
  public void updateCall(String paramString, EMACallSession.StreamControlType paramStreamControlType, EMAError paramEMAError)
  {
    nativeUpdateCall(paramString, paramStreamControlType.ordinal(), paramEMAError);
  }
  
  public void updateSessionInfo(String paramString, int paramInt)
  {
    nativeUpdateSessionInfo(paramString, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */