package com.superrtc.call;

public class RtpSender
{
  final long a;
  private MediaStreamTrack b;
  private boolean c = true;
  
  public RtpSender(long paramLong)
  {
    this.a = paramLong;
    paramLong = nativeGetTrack(paramLong);
    if (paramLong == 0L) {}
    for (MediaStreamTrack localMediaStreamTrack = null;; localMediaStreamTrack = new MediaStreamTrack(paramLong))
    {
      this.b = localMediaStreamTrack;
      return;
    }
  }
  
  private static native void free(long paramLong);
  
  private static native long nativeGetTrack(long paramLong);
  
  private static native String nativeId(long paramLong);
  
  private static native boolean nativeSetTrack(long paramLong1, long paramLong2);
  
  public void dispose()
  {
    if ((this.b != null) && (this.c)) {
      this.b.dispose();
    }
    free(this.a);
  }
  
  public String id()
  {
    return nativeId(this.a);
  }
  
  public boolean setTrack(MediaStreamTrack paramMediaStreamTrack, boolean paramBoolean)
  {
    long l2 = this.a;
    if (paramMediaStreamTrack == null) {}
    for (long l1 = 0L; !nativeSetTrack(l2, l1); l1 = paramMediaStreamTrack.a) {
      return false;
    }
    if ((this.b != null) && (this.c)) {
      this.b.dispose();
    }
    this.b = paramMediaStreamTrack;
    this.c = paramBoolean;
    return true;
  }
  
  public MediaStreamTrack track()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/RtpSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */