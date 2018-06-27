package com.superrtc.call;

public class MediaSource
{
  final long a;
  
  public MediaSource(long paramLong)
  {
    this.a = paramLong;
  }
  
  private static native void free(long paramLong);
  
  private static native a nativeState(long paramLong);
  
  public void dispose()
  {
    free(this.a);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/MediaSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */