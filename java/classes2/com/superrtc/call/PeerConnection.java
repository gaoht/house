package com.superrtc.call;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PeerConnection
{
  private final List<MediaStream> a;
  private final long b;
  private final long c;
  private List<RtpSender> d;
  private List<RtpReceiver> e;
  
  static
  {
    System.loadLibrary("hyphenate_av");
  }
  
  PeerConnection(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.a = new LinkedList();
    this.d = new LinkedList();
    this.e = new LinkedList();
  }
  
  private static native void freeObserver(long paramLong);
  
  private static native void freePeerConnection(long paramLong);
  
  public static String getVersion()
  {
    return "test1";
  }
  
  private native boolean nativeAddIceCandidate(String paramString1, int paramInt, String paramString2);
  
  private native boolean nativeAddLocalStream(long paramLong);
  
  private native RtpSender nativeCreateSender(String paramString1, String paramString2);
  
  private native long[][] nativeGetAudioLevel();
  
  private native List<RtpReceiver> nativeGetReceivers();
  
  private native List<RtpSender> nativeGetSenders();
  
  private native boolean nativeGetStats(r paramr, long paramLong);
  
  private native void nativeRemoveLocalStream(long paramLong);
  
  public static native int nativeSetDocDiretory(String paramString);
  
  private native boolean nativeSetMaxSendBandwidth(int paramInt);
  
  private native void nativeSetVideoResolution(int paramInt1, int paramInt2, boolean paramBoolean);
  
  private native boolean nativeTakePicture(String paramString);
  
  public static int setDocDiretory(String paramString)
  {
    return nativeSetDocDiretory(paramString);
  }
  
  public void SetMaxSendBandwidth(int paramInt)
  {
    nativeSetMaxSendBandwidth(paramInt);
  }
  
  public void SetVideoResolution(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    nativeSetVideoResolution(paramInt1, paramInt2, paramBoolean);
  }
  
  public boolean TakePicture(String paramString)
  {
    return nativeTakePicture(paramString);
  }
  
  public boolean addIceCandidate(l paraml)
  {
    return nativeAddIceCandidate(paraml.a, paraml.b, paraml.c);
  }
  
  public boolean addStream(MediaStream paramMediaStream)
  {
    if (!nativeAddLocalStream(paramMediaStream.d)) {
      return false;
    }
    this.a.add(paramMediaStream);
    return true;
  }
  
  public native void close();
  
  public native void createAnswer(p paramp, n paramn);
  
  public native DataChannel createDataChannel(String paramString, DataChannel.b paramb);
  
  public native void createOffer(p paramp, n paramn);
  
  public RtpSender createSender(String paramString1, String paramString2)
  {
    paramString1 = nativeCreateSender(paramString1, paramString2);
    if (paramString1 != null) {
      this.d.add(paramString1);
    }
    return paramString1;
  }
  
  public void dispose()
  {
    close();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MediaStream localMediaStream = (MediaStream)localIterator.next();
      nativeRemoveLocalStream(localMediaStream.d);
      localMediaStream.dispose();
    }
    this.a.clear();
    localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((RtpSender)localIterator.next()).dispose();
    }
    this.d.clear();
    localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((RtpReceiver)localIterator.next()).dispose();
    }
    this.e.clear();
    freePeerConnection(this.b);
    freeObserver(this.c);
  }
  
  public long[][] getAudioLevel()
  {
    return nativeGetAudioLevel();
  }
  
  public native q getLocalDescription();
  
  public List<RtpReceiver> getReceivers()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((RtpReceiver)localIterator.next()).dispose();
    }
    this.e = nativeGetReceivers();
    return Collections.unmodifiableList(this.e);
  }
  
  public native q getRemoteDescription();
  
  public List<RtpSender> getSenders()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((RtpSender)localIterator.next()).dispose();
    }
    this.d = nativeGetSenders();
    return Collections.unmodifiableList(this.d);
  }
  
  public boolean getStats(r paramr, MediaStreamTrack paramMediaStreamTrack)
  {
    if (paramMediaStreamTrack == null) {}
    for (long l = 0L;; l = paramMediaStreamTrack.a) {
      return nativeGetStats(paramr, l);
    }
  }
  
  public native c iceConnectionState();
  
  public native d iceGatheringState();
  
  public void removeStream(MediaStream paramMediaStream)
  {
    nativeRemoveLocalStream(paramMediaStream.d);
    this.a.remove(paramMediaStream);
  }
  
  public native boolean setConfiguration(i parami);
  
  public native void setLocalDescription(p paramp, q paramq);
  
  public native void setRemoteDescription(p paramp, q paramq);
  
  public native void setconfigminbitrate(int paramInt);
  
  public native void setdisableResize(boolean paramBoolean);
  
  public native k signalingState();
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static enum d
  {
    private d() {}
  }
  
  public static class e
  {
    public final String a;
    public final String b;
    public final String c;
    
    public e(String paramString)
    {
      this(paramString, "", "");
    }
    
    public e(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }
    
    public String toString()
    {
      return this.a + "[" + this.b + ":" + this.c + "]";
    }
  }
  
  public static enum f
  {
    private f() {}
  }
  
  public static enum g
  {
    private g() {}
  }
  
  public static abstract interface h
  {
    public abstract void onAddStream(MediaStream paramMediaStream);
    
    public abstract void onDataChannel(DataChannel paramDataChannel);
    
    public abstract void onIceCandidate(l paraml);
    
    public abstract void onIceConnectionChange(PeerConnection.c paramc);
    
    public abstract void onIceConnectionReceivingChange(boolean paramBoolean);
    
    public abstract void onIceGatheringChange(PeerConnection.d paramd);
    
    public abstract void onRemoveStream(MediaStream paramMediaStream);
    
    public abstract void onRenegotiationNeeded();
    
    public abstract void onSignalingChange(PeerConnection.k paramk);
  }
  
  public static class i
  {
    public PeerConnection.f a = PeerConnection.f.d;
    public List<PeerConnection.e> b;
    public PeerConnection.a c = PeerConnection.a.a;
    public PeerConnection.j d = PeerConnection.j.a;
    public PeerConnection.l e = PeerConnection.l.a;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public PeerConnection.g j;
    public PeerConnection.b k;
    
    public i(List<PeerConnection.e> paramList)
    {
      this.b = paramList;
      this.f = 50;
      this.g = false;
      this.h = -1;
      this.i = -1;
      this.j = PeerConnection.g.b;
      this.k = PeerConnection.b.a;
    }
  }
  
  public static enum j
  {
    private j() {}
  }
  
  public static enum k
  {
    private k() {}
  }
  
  public static enum l
  {
    private l() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/PeerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */