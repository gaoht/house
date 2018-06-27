package com.superrtc.call;

public class MediaStreamTrack
{
  final long a;
  
  public MediaStreamTrack(long paramLong)
  {
    this.a = paramLong;
  }
  
  private static native void free(long paramLong);
  
  private static native boolean nativeEnabled(long paramLong);
  
  private static native String nativeId(long paramLong);
  
  private static native String nativeKind(long paramLong);
  
  private static native boolean nativeSetEnabled(long paramLong, boolean paramBoolean);
  
  private static native boolean nativeSetState(long paramLong, int paramInt);
  
  private static native a nativeState(long paramLong);
  
  public void dispose()
  {
    free(this.a);
  }
  
  public boolean enabled()
  {
    return nativeEnabled(this.a);
  }
  
  public String id()
  {
    return nativeId(this.a);
  }
  
  public String kind()
  {
    return nativeKind(this.a);
  }
  
  public boolean setEnabled(boolean paramBoolean)
  {
    return nativeSetEnabled(this.a, paramBoolean);
  }
  
  public boolean setState(a parama)
  {
    return nativeSetState(this.a, parama.ordinal());
  }
  
  public a state()
  {
    return nativeState(this.a);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/MediaStreamTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */