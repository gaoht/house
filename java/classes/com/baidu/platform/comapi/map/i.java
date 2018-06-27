package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comjni.map.basemap.a;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

@SuppressLint({"NewApi"})
public class i
  extends GLSurfaceView
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a
{
  private static final String a = i.class.getSimpleName();
  private Handler b;
  private MapRenderer c;
  private int d;
  private int e;
  private GestureDetector f;
  private e g;
  
  public i(Context paramContext, B paramB, String paramString)
  {
    super(paramContext);
    if (paramContext == null) {
      throw new RuntimeException("when you create an mapview, the context can not be null");
    }
    this.f = new GestureDetector(paramContext, this);
    EnvironmentUtilities.initAppDirectory(paramContext);
    if (this.g == null) {
      this.g = new e(paramContext, paramString);
    }
    this.g.a();
    f();
    this.g.b();
    this.g.a(paramB);
    g();
    this.g.a(this.b);
    this.g.e();
    setBackgroundColor(0);
  }
  
  public static void a(boolean paramBoolean)
  {
    e.j(paramBoolean);
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[100];
    int[] arrayOfInt = new int[1];
    return (localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 }, arrayOfEGLConfig, 100, arrayOfInt)) && (arrayOfInt[0] > 0);
  }
  
  private void f()
  {
    try
    {
      if (a(5, 6, 5, 0, 24, 0)) {
        setEGLConfigChooser(5, 6, 5, 0, 24, 0);
      }
      for (;;)
      {
        this.c = new MapRenderer(this, this);
        this.c.a(this.g.h);
        setRenderer(this.c);
        setRenderMode(1);
        return;
        setEGLConfigChooser(true);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        setEGLConfigChooser(true);
      }
    }
  }
  
  private void g()
  {
    this.b = new j(this);
  }
  
  public e a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    if (this.g == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 50;
    localMessage.obj = Long.valueOf(this.g.h);
    boolean bool = this.g.p();
    if (paramInt == 3) {
      localMessage.arg1 = 0;
    }
    for (;;)
    {
      this.b.sendMessage(localMessage);
      return;
      if (bool) {
        localMessage.arg1 = 1;
      }
    }
  }
  
  public void a(String paramString, Rect paramRect)
  {
    if ((this.g == null) || (this.g.g == null)) {
      return;
    }
    if (paramRect != null)
    {
      int n = paramRect.left;
      if (this.e < paramRect.bottom) {}
      int k;
      int j;
      for (int i = 0;; i = this.e - paramRect.bottom)
      {
        k = paramRect.width();
        int m = paramRect.height();
        if ((n < 0) || (i < 0) || (k <= 0) || (m <= 0)) {
          break;
        }
        j = k;
        if (k > this.d) {
          j = Math.abs(paramRect.width()) - (paramRect.right - this.d);
        }
        k = m;
        if (m > this.e) {
          k = Math.abs(paramRect.height()) - (paramRect.bottom - this.e);
        }
        if ((n <= SysOSUtil.getScreenSizeX()) && (i <= SysOSUtil.getScreenSizeY())) {
          break label181;
        }
        this.g.g.a(paramString, null);
        requestRender();
        return;
      }
      label181:
      this.d = j;
      this.e = k;
      paramRect = new Bundle();
      paramRect.putInt("x", n);
      paramRect.putInt("y", i);
      paramRect.putInt("width", j);
      paramRect.putInt("height", k);
      this.g.g.a(paramString, paramRect);
      requestRender();
      return;
    }
    this.g.g.a(paramString, null);
    requestRender();
  }
  
  public void b()
  {
    if (this.g != null)
    {
      Iterator localIterator = this.g.f.iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).e();
      }
      this.g.b(this.b);
      this.g.M();
      this.g = null;
    }
  }
  
  public void c()
  {
    if (this.g == null) {
      return;
    }
    this.g.t();
  }
  
  public void d()
  {
    if (this.g == null) {
      return;
    }
    this.g.u();
  }
  
  public void e() {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.g == null) || (this.g.g == null) || (!this.g.i)) {
      return true;
    }
    paramMotionEvent = this.g.b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      Object localObject = this.g.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((k)((Iterator)localObject).next()).b(paramMotionEvent);
      }
      if (this.g.e)
      {
        localObject = this.g.D();
        ((D)localObject).a += 1.0F;
        ((D)localObject).d = paramMotionEvent.getLongitudeE6();
        ((D)localObject).e = paramMotionEvent.getLatitudeE6();
        this.g.a((D)localObject, 300);
        paramMotionEvent = this.g;
        e.k = System.currentTimeMillis();
        return true;
      }
      return false;
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.g == null) || (this.g.g == null) || (!this.g.i)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.g.d);
      paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      bool1 = bool2;
    } while (paramFloat1 <= 500.0F);
    this.g.z();
    this.g.a(34, (int)(paramFloat1 * 0.6F), (int)paramMotionEvent2.getY() << 16 | (int)paramMotionEvent2.getX());
    this.g.L();
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.g == null) || (this.g.g == null) || (!this.g.i)) {}
    for (;;)
    {
      return;
      Object localObject = this.g.g.a(-1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.g.j);
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        Iterator localIterator = this.g.f.iterator();
        while (localIterator.hasNext())
        {
          k localk = (k)localIterator.next();
          if (localk.b((String)localObject)) {
            this.g.n = true;
          } else {
            localk.c(this.g.b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
          }
        }
      }
      else
      {
        localObject = this.g.f.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((k)((Iterator)localObject).next()).c(this.g.b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.g == null) || (this.g.g == null)) {
      return;
    }
    this.g.g.e();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.g == null) || (this.g.g == null)) {
      return;
    }
    Iterator localIterator = this.g.f.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).c();
    }
    this.g.g.i();
    this.g.g.f();
    this.g.g.p();
    setRenderMode(1);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((this.g == null) || (this.g.g == null) || (!this.g.i)) {}
    for (;;)
    {
      return true;
      Object localObject = this.g.g.a(-1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.g.j);
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        paramMotionEvent = this.g.f.iterator();
        while (paramMotionEvent.hasNext()) {
          ((k)paramMotionEvent.next()).a((String)localObject);
        }
      }
      else
      {
        localObject = this.g.f.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((k)((Iterator)localObject).next()).a(this.g.b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        }
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.g == null) || (this.g.g == null)) {
      return true;
    }
    super.onTouchEvent(paramMotionEvent);
    Iterator localIterator = this.g.f.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).a(paramMotionEvent);
    }
    if (this.f.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    return this.g.a(paramMotionEvent);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    if ((this.g == null) || (this.g.g == null)) {
      return;
    }
    this.c.a = paramInt2;
    this.c.b = paramInt3;
    this.d = paramInt2;
    this.e = paramInt3;
    this.c.c = 0;
    paramSurfaceHolder = this.g.D();
    if ((paramSurfaceHolder.f == 0) || (paramSurfaceHolder.f == -1) || (paramSurfaceHolder.f == (paramSurfaceHolder.j.a - paramSurfaceHolder.j.b) / 2)) {
      paramSurfaceHolder.f = -1;
    }
    if ((paramSurfaceHolder.g == 0) || (paramSurfaceHolder.g == -1) || (paramSurfaceHolder.g == (paramSurfaceHolder.j.d - paramSurfaceHolder.j.c) / 2)) {
      paramSurfaceHolder.g = -1;
    }
    paramSurfaceHolder.j.a = 0;
    paramSurfaceHolder.j.c = 0;
    paramSurfaceHolder.j.d = paramInt3;
    paramSurfaceHolder.j.b = paramInt2;
    this.g.a(paramSurfaceHolder);
    this.g.a(this.d, this.e);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
    if ((paramSurfaceHolder != null) && (!paramSurfaceHolder.getSurface().isValid())) {
      surfaceDestroyed(paramSurfaceHolder);
    }
  }
  
  static class a
  {
    float a;
    float b;
    float c;
    float d;
    boolean e;
    float f;
    float g;
    double h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/map/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */