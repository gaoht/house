package com.superrtc.call;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class f
  extends e
{
  private final EGL10 f = (EGL10)EGLContext.getEGL();
  private EGLContext g = a(paramb, this.i, this.h);
  private EGLConfig h = a(this.i, paramArrayOfInt);
  private EGLDisplay i = b();
  private EGLSurface j = EGL10.EGL_NO_SURFACE;
  
  f(b paramb, int[] paramArrayOfInt) {}
  
  private EGLConfig a(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.f.eglChooseConfig(paramEGLDisplay, paramArrayOfInt, arrayOfEGLConfig, arrayOfEGLConfig.length, arrayOfInt)) {
      throw new RuntimeException("Unable to find any matching EGL config");
    }
    return arrayOfEGLConfig[0];
  }
  
  private EGLContext a(b paramb, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if ((paramb != null) && (b.a(paramb) == EGL10.EGL_NO_CONTEXT)) {
      throw new RuntimeException("Invalid sharedContext");
    }
    if (paramb == null) {}
    for (paramb = EGL10.EGL_NO_CONTEXT;; paramb = b.a(paramb))
    {
      paramb = this.f.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramb, new int[] { 12440, 2, 12344 });
      if (paramb != EGL10.EGL_NO_CONTEXT) {
        break;
      }
      throw new RuntimeException("Failed to create EGL context");
    }
    return paramb;
  }
  
  private void a()
  {
    if ((this.i == EGL10.EGL_NO_DISPLAY) || (this.g == EGL10.EGL_NO_CONTEXT) || (this.h == null)) {
      throw new RuntimeException("This object has been released");
    }
  }
  
  private void a(Object paramObject)
  {
    if ((!(paramObject instanceof SurfaceHolder)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
    }
    a();
    if (this.j != EGL10.EGL_NO_SURFACE) {
      throw new RuntimeException("Already has an EGLSurface");
    }
    this.j = this.f.eglCreateWindowSurface(this.i, this.h, paramObject, new int[] { 12344 });
    if (this.j == EGL10.EGL_NO_SURFACE) {
      throw new RuntimeException("Failed to create window surface");
    }
  }
  
  private EGLDisplay b()
  {
    EGLDisplay localEGLDisplay = this.f.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (localEGLDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("Unable to get EGL10 display");
    }
    int[] arrayOfInt = new int[2];
    if (!this.f.eglInitialize(localEGLDisplay, arrayOfInt)) {
      throw new RuntimeException("Unable to initialize EGL10");
    }
    return localEGLDisplay;
  }
  
  public void createDummyPbufferSurface()
  {
    createPbufferSurface(1, 1);
  }
  
  public void createPbufferSurface(int paramInt1, int paramInt2)
  {
    a();
    if (this.j != EGL10.EGL_NO_SURFACE) {
      throw new RuntimeException("Already has an EGLSurface");
    }
    this.j = this.f.eglCreatePbufferSurface(this.i, this.h, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    if (this.j == EGL10.EGL_NO_SURFACE) {
      throw new RuntimeException("Failed to create pixel buffer surface");
    }
  }
  
  public void createSurface(SurfaceTexture paramSurfaceTexture)
  {
    a(paramSurfaceTexture);
  }
  
  public void createSurface(Surface paramSurface)
  {
    a(new f.a(this, paramSurface));
  }
  
  public void detachCurrent()
  {
    if (!this.f.eglMakeCurrent(this.i, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public e.a getEglBaseContext()
  {
    return new b(this.g);
  }
  
  public boolean hasSurface()
  {
    return this.j != EGL10.EGL_NO_SURFACE;
  }
  
  public void makeCurrent()
  {
    a();
    if (this.j == EGL10.EGL_NO_SURFACE) {
      throw new RuntimeException("No EGLSurface - can't make current");
    }
    if (!this.f.eglMakeCurrent(this.i, this.j, this.j, this.g)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void release()
  {
    a();
    releaseSurface();
    detachCurrent();
    this.f.eglDestroyContext(this.i, this.g);
    this.f.eglTerminate(this.i);
    this.g = EGL10.EGL_NO_CONTEXT;
    this.i = EGL10.EGL_NO_DISPLAY;
    this.h = null;
  }
  
  public void releaseSurface()
  {
    if (this.j != EGL10.EGL_NO_SURFACE)
    {
      this.f.eglDestroySurface(this.i, this.j);
      this.j = EGL10.EGL_NO_SURFACE;
    }
  }
  
  public int surfaceHeight()
  {
    int[] arrayOfInt = new int[1];
    this.f.eglQuerySurface(this.i, this.j, 12374, arrayOfInt);
    return arrayOfInt[0];
  }
  
  public int surfaceWidth()
  {
    int[] arrayOfInt = new int[1];
    this.f.eglQuerySurface(this.i, this.j, 12375, arrayOfInt);
    return arrayOfInt[0];
  }
  
  public void swapBuffers()
  {
    a();
    if (this.j == EGL10.EGL_NO_SURFACE) {
      throw new RuntimeException("No EGLSurface - can't swap buffers");
    }
    this.f.eglSwapBuffers(this.i, this.j);
  }
  
  public static class b
    extends e.a
  {
    private final EGLContext a;
    
    public b(EGLContext paramEGLContext)
    {
      this.a = paramEGLContext;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */