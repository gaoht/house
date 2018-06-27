package com.superrtc.call;

import java.util.LinkedList;

public class MediaStream
{
  public final LinkedList<b> a = new LinkedList();
  public final LinkedList<VideoTrack> b = new LinkedList();
  public final LinkedList<VideoTrack> c = new LinkedList();
  final long d;
  
  public MediaStream(long paramLong)
  {
    this.d = paramLong;
  }
  
  private static native void free(long paramLong);
  
  private static native boolean nativeAddAudioTrack(long paramLong1, long paramLong2);
  
  private static native boolean nativeAddVideoTrack(long paramLong1, long paramLong2);
  
  private static native String nativeLabel(long paramLong);
  
  private static native boolean nativeRemoveAudioTrack(long paramLong1, long paramLong2);
  
  private static native boolean nativeRemoveVideoTrack(long paramLong1, long paramLong2);
  
  public boolean addPreservedTrack(VideoTrack paramVideoTrack)
  {
    if (nativeAddVideoTrack(this.d, paramVideoTrack.a))
    {
      this.c.add(paramVideoTrack);
      return true;
    }
    return false;
  }
  
  public boolean addTrack(VideoTrack paramVideoTrack)
  {
    if (nativeAddVideoTrack(this.d, paramVideoTrack.a))
    {
      this.b.add(paramVideoTrack);
      return true;
    }
    return false;
  }
  
  public boolean addTrack(b paramb)
  {
    if (nativeAddAudioTrack(this.d, paramb.a))
    {
      this.a.add(paramb);
      return true;
    }
    return false;
  }
  
  public void dispose()
  {
    Object localObject;
    while (!this.a.isEmpty())
    {
      localObject = (b)this.a.getFirst();
      removeTrack((b)localObject);
      ((b)localObject).dispose();
    }
    while (!this.b.isEmpty())
    {
      localObject = (VideoTrack)this.b.getFirst();
      removeTrack((VideoTrack)localObject);
      ((VideoTrack)localObject).dispose();
    }
    while (!this.c.isEmpty()) {
      removeTrack((VideoTrack)this.c.getFirst());
    }
    free(this.d);
  }
  
  public String label()
  {
    return nativeLabel(this.d);
  }
  
  public boolean removeTrack(VideoTrack paramVideoTrack)
  {
    this.b.remove(paramVideoTrack);
    this.c.remove(paramVideoTrack);
    return nativeRemoveVideoTrack(this.d, paramVideoTrack.a);
  }
  
  public boolean removeTrack(b paramb)
  {
    this.a.remove(paramb);
    return nativeRemoveAudioTrack(this.d, paramb.a);
  }
  
  public String toString()
  {
    return "[" + label() + ":A=" + this.a.size() + ":V=" + this.b.size() + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/MediaStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */