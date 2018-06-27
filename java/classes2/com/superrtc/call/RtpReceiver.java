package com.superrtc.call;

public class RtpReceiver
{
  final long a;
  private MediaStreamTrack b;
  
  public RtpReceiver(long paramLong)
  {
    this.a = paramLong;
    this.b = new MediaStreamTrack(nativeGetTrack(paramLong));
  }
  
  private static native void free(long paramLong);
  
  private static native long nativeGetTrack(long paramLong);
  
  private static native String nativeId(long paramLong);
  
  public void dispose()
  {
    this.b.dispose();
    free(this.a);
  }
  
  public String id()
  {
    return nativeId(this.a);
  }
  
  public MediaStreamTrack track()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/RtpReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */