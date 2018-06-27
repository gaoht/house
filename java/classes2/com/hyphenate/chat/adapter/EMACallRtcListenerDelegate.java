package com.hyphenate.chat.adapter;

import com.superrtc.sdk.d;
import com.superrtc.sdk.d.b;
import com.superrtc.sdk.d.n;

public class EMACallRtcListenerDelegate
  extends EMABase
  implements d.b
{
  d.n states;
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public d.n getStatistics()
  {
    try
    {
      d.n localn = this.states;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  native void nativeFinalize();
  
  native void nativeOnCandidateCompleted();
  
  native void nativeOnClosed();
  
  native void nativeOnConnected();
  
  native void nativeOnConnectionSetup();
  
  native void nativeOnDisconnected();
  
  native void nativeOnError();
  
  native void nativeOnLocalCandidate(String paramString);
  
  native void nativeOnLocalSdp(String paramString);
  
  native void nativeOnStats(EMAChannelStatistics paramEMAChannelStatistics);
  
  public void onCandidateCompleted(d paramd)
  {
    nativeOnCandidateCompleted();
  }
  
  public void onClosed(d paramd)
  {
    nativeOnClosed();
  }
  
  public void onConnected(d paramd)
  {
    nativeOnConnected();
  }
  
  public void onConnectionsetup(d paramd)
  {
    nativeOnConnectionSetup();
  }
  
  public void onDisconnected(d paramd)
  {
    nativeOnDisconnected();
  }
  
  public void onError(d paramd, String paramString)
  {
    nativeOnError();
  }
  
  public void onLocalCandidate(d paramd, String paramString)
  {
    nativeOnLocalCandidate(paramString);
  }
  
  public void onLocalSdp(d paramd, String paramString)
  {
    nativeOnLocalSdp(paramString);
  }
  
  public void onStats(d paramd, d.n paramn)
  {
    try
    {
      this.states = paramn;
      paramd = new EMAChannelStatistics();
      paramd.setConnType(this.states.a);
      paramd.setLocalVideoRtt(this.states.l);
      paramd.setRemoteVideoWidth(this.states.q);
      paramd.setRemoteVideoHeight(this.states.r);
      paramd.setLocalVideoFps(this.states.g);
      paramd.setRemoteVideoFps(this.states.s);
      paramd.setLocalVideoPacketsLost(this.states.j);
      paramd.setRemoteVideoPacketsLost(this.states.t);
      paramd.setLocalVideoActualBps(this.states.h);
      paramd.setRemoteAudioBps(this.states.y);
      paramd.setRemoteVideoBps(this.states.v);
      nativeOnStats(paramd);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMACallRtcListenerDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */