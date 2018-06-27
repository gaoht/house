package com.superrtc.call;

import java.util.LinkedList;

public class VideoTrack
  extends MediaStreamTrack
{
  private final LinkedList<VideoRenderer> b = new LinkedList();
  
  public VideoTrack(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeAddRenderer(long paramLong1, long paramLong2);
  
  private static native void nativeRemoveRenderer(long paramLong1, long paramLong2);
  
  public void addRenderer(VideoRenderer paramVideoRenderer)
  {
    this.b.add(paramVideoRenderer);
    nativeAddRenderer(this.a, paramVideoRenderer.a);
  }
  
  public void dispose()
  {
    while (!this.b.isEmpty()) {
      removeRenderer((VideoRenderer)this.b.getFirst());
    }
    super.dispose();
  }
  
  public void removeRenderer(VideoRenderer paramVideoRenderer)
  {
    if (!this.b.remove(paramVideoRenderer)) {
      return;
    }
    nativeRemoveRenderer(this.a, paramVideoRenderer.a);
    paramVideoRenderer.dispose();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/VideoTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */