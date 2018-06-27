package com.superrtc.call;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public abstract class e
{
  public static final int[] a = { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344 };
  public static final int[] b = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344 };
  public static final int[] c = { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344 };
  public static final int[] d = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 };
  public static final int[] e = { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 };
  
  public static e create()
  {
    return create(null, a);
  }
  
  public static e create(a parama)
  {
    return create(parama, a);
  }
  
  public static e create(a parama, int[] paramArrayOfInt)
  {
    if ((g.isEGL14Supported()) && ((parama == null) || ((parama instanceof g.a)))) {
      return new g((g.a)parama, paramArrayOfInt);
    }
    return new f((f.b)parama, paramArrayOfInt);
  }
  
  public abstract void createDummyPbufferSurface();
  
  public abstract void createPbufferSurface(int paramInt1, int paramInt2);
  
  public abstract void createSurface(SurfaceTexture paramSurfaceTexture);
  
  public abstract void createSurface(Surface paramSurface);
  
  public abstract void detachCurrent();
  
  public abstract a getEglBaseContext();
  
  public abstract boolean hasSurface();
  
  public abstract void makeCurrent();
  
  public abstract void release();
  
  public abstract void releaseSurface();
  
  public abstract int surfaceHeight();
  
  public abstract int surfaceWidth();
  
  public abstract void swapBuffers();
  
  public static class a {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */