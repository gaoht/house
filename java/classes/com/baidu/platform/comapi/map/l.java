package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
public class l
  extends Thread
{
  private AtomicBoolean a;
  private SurfaceTexture b;
  private a c;
  private EGL10 d;
  private EGLDisplay e = EGL10.EGL_NO_DISPLAY;
  private EGLContext f = EGL10.EGL_NO_CONTEXT;
  private EGLSurface g = EGL10.EGL_NO_SURFACE;
  private GL10 h;
  private int i = 1;
  private boolean j = false;
  private final E k;
  
  public l(SurfaceTexture paramSurfaceTexture, a parama, AtomicBoolean paramAtomicBoolean, E paramE)
  {
    this.b = paramSurfaceTexture;
    this.c = parama;
    this.a = paramAtomicBoolean;
    this.k = paramE;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.d = ((EGL10)EGLContext.getEGL());
    this.e = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.e == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.d.eglGetError()));
    }
    Object localObject = new int[2];
    if (!this.d.eglInitialize(this.e, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.d.eglGetError()));
    }
    localObject = new EGLConfig[100];
    int[] arrayOfInt = new int[1];
    if ((this.d.eglChooseConfig(this.e, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 }, (EGLConfig[])localObject, 100, arrayOfInt)) && (arrayOfInt[0] > 0))
    {
      this.f = this.d.eglCreateContext(this.e, localObject[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 1, 12344 });
      this.g = this.d.eglCreateWindowSurface(this.e, localObject[0], this.b, null);
      if ((this.g == EGL10.EGL_NO_SURFACE) || (this.f == EGL10.EGL_NO_CONTEXT))
      {
        if (this.d.eglGetError() == 12299) {
          throw new RuntimeException("eglCreateWindowSurface returned  EGL_BAD_NATIVE_WINDOW. ");
        }
        GLUtils.getEGLErrorString(this.d.eglGetError());
      }
      if (!this.d.eglMakeCurrent(this.e, this.g, this.g, this.f))
      {
        GLUtils.getEGLErrorString(this.d.eglGetError());
        throw new RuntimeException("eglMakeCurrent failed : " + GLUtils.getEGLErrorString(this.d.eglGetError()));
      }
      this.h = ((GL10)this.f.getGL());
      return true;
    }
    return false;
  }
  
  private static boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[100];
    int[] arrayOfInt = new int[1];
    return (localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 }, arrayOfEGLConfig, 100, arrayOfInt)) && (arrayOfInt[0] > 0);
  }
  
  private void d()
  {
    try
    {
      if (b(5, 6, 5, 0, 24, 0)) {
        a(5, 6, 5, 0, 24, 0);
      }
      for (;;)
      {
        MapRenderer.nativeInit(this.k.b().h);
        MapRenderer.nativeResize(this.k.b().h, E.a, E.b);
        return;
        a(8, 8, 8, 0, 16, 0);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        a(8, 8, 8, 0, 16, 0);
      }
    }
  }
  
  private void e()
  {
    this.d.eglDestroyContext(this.e, this.f);
    this.d.eglDestroySurface(this.e, this.g);
    this.d.eglTerminate(this.e);
    this.f = EGL10.EGL_NO_CONTEXT;
    this.g = EGL10.EGL_NO_SURFACE;
  }
  
  public void a()
  {
    this.i = 1;
    try
    {
      if (getState() == Thread.State.WAITING) {
        notify();
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    this.i = 0;
  }
  
  public void c()
  {
    this.j = true;
    try
    {
      if (getState() == Thread.State.WAITING) {
        notify();
      }
      return;
    }
    finally {}
  }
  
  public void run()
  {
    d();
    if (this.c != null)
    {
      if (this.i != 1) {
        break label237;
      }
      if (this.k.b() != null) {}
    }
    else
    {
      label29:
      e();
      return;
    }
    for (;;)
    {
      k localk;
      D localD;
      synchronized (this.k.b())
      {
        this.i = this.c.a();
        Iterator localIterator = this.k.b().f.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localk = (k)localIterator.next();
        localD = this.k.b().H();
        if (this.h == null) {
          return;
        }
      }
      this.h.glPushMatrix();
      this.h.glRotatef(localD.c, 1.0F, 0.0F, 0.0F);
      this.h.glRotatef(localD.b, 0.0F, 0.0F, 1.0F);
      localk.a(this.h, localD);
      this.h.glPopMatrix();
      this.h.glColor4f(0.96F, 0.95F, 0.94F, 1.0F);
    }
    this.d.eglSwapBuffers(this.e, this.g);
    while (this.j)
    {
      break label29;
      try
      {
        try
        {
          label237:
          wait();
        }
        finally {}
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/map/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */