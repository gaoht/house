package com.superrtc.call;

public class VideoSource
  extends MediaSource
{
  public VideoSource(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void restart(long paramLong);
  
  private static native void stop(long paramLong);
  
  public void dispose()
  {
    super.dispose();
  }
  
  public void restart()
  {
    restart(this.a);
  }
  
  public void stop()
  {
    stop(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/VideoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */