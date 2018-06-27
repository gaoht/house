package com.superrtc.call;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.view.Surface;

@TargetApi(18)
public final class g
  extends e
{
  private static final int f = Build.VERSION.SDK_INT;
  private EGLContext g;
  private EGLConfig h;
  private EGLDisplay i = b();
  private EGLSurface j = EGL14.EGL_NO_SURFACE;
  
  public g(a parama, int[] paramArrayOfInt)
  {
    this.h = a(this.i, paramArrayOfInt);
    this.g = a(parama, this.i, this.h);
  }
  
  private static EGLConfig a(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!EGL14.eglChooseConfig(paramEGLDisplay, paramArrayOfInt, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt, 0)) {
      throw new RuntimeException("Unable to find any matching EGL config");
    }
    return arrayOfEGLConfig[0];
  }
  
  private static EGLContext a(a parama, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if ((parama != null) && (a.a(parama) == EGL14.EGL_NO_CONTEXT)) {
      throw new RuntimeException("Invalid sharedContext");
    }
    if (parama == null) {}
    for (parama = EGL14.EGL_NO_CONTEXT;; parama = a.a(parama))
    {
      parama = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, parama, new int[] { 12440, 2, 12344 }, 0);
      if (parama != EGL14.EGL_NO_CONTEXT) {
        break;
      }
      throw new RuntimeException("Failed to create EGL context");
    }
    return parama;
  }
  
  private void a()
  {
    if ((this.i == EGL14.EGL_NO_DISPLAY) || (this.g == EGL14.EGL_NO_CONTEXT) || (this.h == null)) {
      throw new RuntimeException("This object has been released");
    }
  }
  
  private void a(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
    }
    a();
    if (this.j != EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("Already has an EGLSurface");
    }
    this.j = EGL14.eglCreateWindowSurface(this.i, this.h, paramObject, new int[] { 12344 }, 0);
    if (this.j == EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("Failed to create window surface");
    }
  }
  
  private static EGLDisplay b()
  {
    EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    if (localEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("Unable to get EGL14 display");
    }
    int[] arrayOfInt = new int[2];
    if (!EGL14.eglInitialize(localEGLDisplay, arrayOfInt, 0, arrayOfInt, 1)) {
      throw new RuntimeException("Unable to initialize EGL14");
    }
    return localEGLDisplay;
  }
  
  public static boolean isEGL14Supported()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SDK version: ").append(f).append(". isEGL14Supported: ");
    if (f >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      Logging.d("EglBase14", bool);
      if (f < 18) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void createDummyPbufferSurface()
  {
    createPbufferSurface(1, 1);
  }
  
  public void createPbufferSurface(int paramInt1, int paramInt2)
  {
    a();
    if (this.j != EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("Already has an EGLSurface");
    }
    this.j = EGL14.eglCreatePbufferSurface(this.i, this.h, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    if (this.j == EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("Failed to create pixel buffer surface");
    }
  }
  
  public void createSurface(SurfaceTexture paramSurfaceTexture)
  {
    a(paramSurfaceTexture);
  }
  
  public void createSurface(Surface paramSurface)
  {
    a(paramSurface);
  }
  
  public void detachCurrent()
  {
    if (!EGL14.eglMakeCurrent(this.i, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public a getEglBaseContext()
  {
    return new a(this.g);
  }
  
  public boolean hasSurface()
  {
    return this.j != EGL14.EGL_NO_SURFACE;
  }
  
  public void makeCurrent()
  {
    a();
    if (this.j == EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("No EGLSurface - can't make current");
    }
    if (!EGL14.eglMakeCurrent(this.i, this.j, this.j, this.g)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void release()
  {
    a();
    releaseSurface();
    detachCurrent();
    EGL14.eglDestroyContext(this.i, this.g);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.i);
    this.g = EGL14.EGL_NO_CONTEXT;
    this.i = EGL14.EGL_NO_DISPLAY;
    this.h = null;
  }
  
  public void releaseSurface()
  {
    if (this.j != EGL14.EGL_NO_SURFACE)
    {
      EGL14.eglDestroySurface(this.i, this.j);
      this.j = EGL14.EGL_NO_SURFACE;
    }
  }
  
  public int surfaceHeight()
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.i, this.j, 12374, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public int surfaceWidth()
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.i, this.j, 12375, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public void swapBuffers()
  {
    a();
    if (this.j == EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("No EGLSurface - can't swap buffers");
    }
    EGL14.eglSwapBuffers(this.i, this.j);
  }
  
  public void swapBuffers(long paramLong)
  {
    a();
    if (this.j == EGL14.EGL_NO_SURFACE) {
      throw new RuntimeException("No EGLSurface - can't swap buffers");
    }
    EGLExt.eglPresentationTimeANDROID(this.i, this.j, paramLong);
    EGL14.eglSwapBuffers(this.i, this.j);
  }
  
  public static class a
    extends e.a
  {
    private final EGLContext a;
    
    public a(EGLContext paramEGLContext)
    {
      this.a = paramEGLContext;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */