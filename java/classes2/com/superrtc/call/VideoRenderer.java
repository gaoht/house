package com.superrtc.call;

import java.nio.ByteBuffer;

public class VideoRenderer
{
  long a;
  
  public VideoRenderer(a parama)
  {
    this.a = nativeWrapVideoRenderer(parama);
  }
  
  private static native void freeWrappedVideoRenderer(long paramLong);
  
  public static native void nativeCopyPlane(ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer2, int paramInt4);
  
  private static native long nativeWrapVideoRenderer(a parama);
  
  private static native void releaseNativeFrame(long paramLong);
  
  public static void renderFrameDone(b paramb)
  {
    paramb.d = null;
    paramb.g = 0;
    if (b.a(paramb) != 0L)
    {
      releaseNativeFrame(b.a(paramb));
      b.a(paramb, 0L);
    }
  }
  
  public void dispose()
  {
    if (this.a == 0L) {
      return;
    }
    freeWrappedVideoRenderer(this.a);
    this.a = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void renderFrame(VideoRenderer.b paramb);
  }
  
  public static class b
  {
    public final int a;
    public final int b;
    public final int[] c;
    public ByteBuffer[] d;
    public final boolean e;
    public final float[] f;
    public int g;
    public int h;
    private long i;
    
    public int rotatedHeight()
    {
      if (this.h % 180 == 0) {
        return this.b;
      }
      return this.a;
    }
    
    public int rotatedWidth()
    {
      if (this.h % 180 == 0) {
        return this.a;
      }
      return this.b;
    }
    
    public String toString()
    {
      return this.a + "x" + this.b + ":" + this.c[0] + ":" + this.c[1] + ":" + this.c[2];
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/VideoRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */