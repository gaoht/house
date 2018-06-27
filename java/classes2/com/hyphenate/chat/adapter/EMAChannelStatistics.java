package com.hyphenate.chat.adapter;

public class EMAChannelStatistics
  extends EMABase
{
  EMAChannelStatistics()
  {
    nativeInit();
  }
  
  EMAChannelStatistics(EMAChannelStatistics paramEMAChannelStatistics)
  {
    nativeInit(paramEMAChannelStatistics);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit();
  
  native void nativeInit(EMAChannelStatistics paramEMAChannelStatistics);
  
  native void nativeSetConnType(String paramString);
  
  native void nativeSetLocalVideoActualBps(int paramInt);
  
  native void nativeSetLocalVideoFps(int paramInt);
  
  native void nativeSetLocalVideoPacketsLost(int paramInt);
  
  native void nativeSetLocalVideoRtt(int paramInt);
  
  native void nativeSetRemoteAudioBps(int paramInt);
  
  native void nativeSetRemoteVideoBps(int paramInt);
  
  native void nativeSetRemoteVideoFps(int paramInt);
  
  native void nativeSetRemoteVideoHeight(int paramInt);
  
  native void nativeSetRemoteVideoPacketsLost(int paramInt);
  
  native void nativeSetRemoteVideoWidth(int paramInt);
  
  native void nativeSetRtcReport(String paramString);
  
  public void setConnType(String paramString)
  {
    nativeSetConnType(paramString);
  }
  
  public void setLocalVideoActualBps(int paramInt)
  {
    nativeSetLocalVideoActualBps(paramInt);
  }
  
  public void setLocalVideoFps(int paramInt)
  {
    nativeSetLocalVideoFps(paramInt);
  }
  
  public void setLocalVideoPacketsLost(int paramInt)
  {
    nativeSetLocalVideoPacketsLost(paramInt);
  }
  
  public void setLocalVideoRtt(int paramInt)
  {
    nativeSetLocalVideoRtt(paramInt);
  }
  
  public void setRemoteAudioBps(int paramInt)
  {
    nativeSetRemoteAudioBps(paramInt);
  }
  
  public void setRemoteVideoBps(int paramInt)
  {
    nativeSetRemoteVideoBps(paramInt);
  }
  
  public void setRemoteVideoFps(int paramInt)
  {
    nativeSetRemoteVideoFps(paramInt);
  }
  
  public void setRemoteVideoHeight(int paramInt)
  {
    nativeSetRemoteVideoHeight(paramInt);
  }
  
  public void setRemoteVideoPacketsLost(int paramInt)
  {
    nativeSetRemoteVideoPacketsLost(paramInt);
  }
  
  public void setRemoteVideoWidth(int paramInt)
  {
    nativeSetRemoteVideoWidth(paramInt);
  }
  
  public void setRtcReport(String paramString)
  {
    nativeSetRtcReport(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChannelStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */