package com.superrtc.call;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Point;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import java.util.concurrent.CountDownLatch;

public class SurfaceViewRenderer
  extends SurfaceView
  implements SurfaceHolder.Callback, VideoRenderer.a
{
  private final Runnable A = new Runnable()
  {
    public void run()
    {
      SurfaceViewRenderer.a(SurfaceViewRenderer.this);
    }
  };
  private final Runnable B = new Runnable()
  {
    public void run()
    {
      SurfaceViewRenderer.b(SurfaceViewRenderer.this);
    }
  };
  private HandlerThread a;
  private final Object b = new Object();
  private Handler c;
  private e d;
  private final o.d e = new o.d();
  private o.a f;
  private int[] g = null;
  private final Object h = new Object();
  private VideoRenderer.b i;
  private final Object j = new Object();
  private Point k = new Point();
  private final Point l = new Point();
  private final Point m = new Point();
  private boolean n;
  private int o;
  private int p;
  private int q;
  private o.c r = o.c.c;
  private boolean s;
  private o.b t;
  private final Object u = new Object();
  private int v;
  private int w;
  private int x;
  private long y;
  private long z;
  
  public SurfaceViewRenderer(Context paramContext)
  {
    super(paramContext);
    getHolder().addCallback(this);
  }
  
  public SurfaceViewRenderer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getHolder().addCallback(this);
  }
  
  private Point a(int paramInt1, int paramInt2)
  {
    synchronized (this.j)
    {
      int i1 = getDefaultSize(Integer.MAX_VALUE, paramInt1);
      int i2 = getDefaultSize(Integer.MAX_VALUE, paramInt2);
      Point localPoint = o.getDisplaySize(this.r, d(), i1, i2);
      if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
        localPoint.x = i1;
      }
      if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
        localPoint.y = i2;
      }
      return localPoint;
    }
  }
  
  private void a()
  {
    if (Thread.currentThread() != this.a) {
      throw new IllegalStateException(getResourceName() + "Wrong thread.");
    }
    if ((this.d != null) && (this.d.hasSurface()))
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      this.d.swapBuffers();
    }
  }
  
  private void a(VideoRenderer.b paramb)
  {
    synchronized (this.j)
    {
      if ((this.o != paramb.a) || (this.p != paramb.b) || (this.q != paramb.h))
      {
        Logging.d("SurfaceViewRenderer", getResourceName() + "Reporting frame resolution changed to " + paramb.a + "x" + paramb.b + " with rotation " + paramb.h);
        if (this.t != null) {
          this.t.onFrameResolutionChanged(paramb.a, paramb.b, paramb.h);
        }
        this.o = paramb.a;
        this.p = paramb.b;
        this.q = paramb.h;
        post(new Runnable()
        {
          public void run()
          {
            SurfaceViewRenderer.this.requestLayout();
          }
        });
      }
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.b)
    {
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      return;
    }
  }
  
  private boolean b()
  {
    if (Thread.currentThread() != this.a) {
      throw new IllegalStateException(getResourceName() + "Wrong thread.");
    }
    for (;;)
    {
      synchronized (this.j)
      {
        if ((this.l.equals(this.k)) && (this.m.equals(this.l)))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void c()
  {
    if (Thread.currentThread() != this.a) {
      throw new IllegalStateException(getResourceName() + "Wrong thread.");
    }
    synchronized (this.h)
    {
      if (this.i == null) {
        return;
      }
      VideoRenderer.b localb1 = this.i;
      this.i = null;
      if ((this.d == null) || (!this.d.hasSurface()))
      {
        Logging.d("SurfaceViewRenderer", getResourceName() + "No surface to draw on");
        VideoRenderer.renderFrameDone(localb1);
        return;
      }
    }
    if (!b())
    {
      a();
      VideoRenderer.renderFrameDone(localb2);
      return;
    }
    long l1;
    synchronized (this.j)
    {
      if ((this.d.surfaceWidth() != this.m.x) || (this.d.surfaceHeight() != this.m.y)) {
        a();
      }
      l1 = System.nanoTime();
    }
    float[] arrayOfFloat;
    synchronized (this.j)
    {
      arrayOfFloat = o.multiplyMatrices(o.rotateTextureMatrix(localb2.f, localb2.h), o.getLayoutMatrix(this.s, d(), this.l.x / this.l.y));
      GLES20.glClear(16384);
      if (!localb2.e) {
        break label535;
      }
      if (this.g == null)
      {
        this.g = new int[3];
        int i1 = 0;
        while (i1 < 3)
        {
          this.g[i1] = k.generateTexture(3553);
          i1 += 1;
          continue;
          localObject1 = finally;
          throw ((Throwable)localObject1);
        }
      }
    }
    this.e.uploadYuvData(this.g, localb3.a, localb3.b, localb3.c, localb3.d);
    this.f.drawYuv(this.g, arrayOfFloat, 0, 0, this.m.x, this.m.y);
    for (;;)
    {
      this.d.swapBuffers();
      VideoRenderer.renderFrameDone(localb3);
      synchronized (this.u)
      {
        if (this.x == 0) {
          this.y = l1;
        }
      }
      synchronized (this.j)
      {
        Logging.d("SurfaceViewRenderer", getResourceName() + "Reporting first rendered frame.");
        if (this.t != null) {
          this.t.onFirstFrameRendered();
        }
        this.x += 1;
        this.z += System.nanoTime() - l1;
        if (this.x % 300 == 0) {
          e();
        }
        return;
        localObject4 = finally;
        throw ((Throwable)localObject4);
        label535:
        this.f.drawOes(((VideoRenderer.b)???).g, arrayOfFloat, 0, 0, this.m.x, this.m.y);
      }
    }
  }
  
  private float d()
  {
    for (;;)
    {
      synchronized (this.j)
      {
        if ((this.o == 0) || (this.p == 0)) {
          return 0.0F;
        }
        if (this.q % 180 == 0)
        {
          f1 = this.o / this.p;
          return f1;
        }
      }
      float f1 = this.p;
      int i1 = this.o;
      f1 /= i1;
    }
  }
  
  private void e()
  {
    synchronized (this.u)
    {
      Logging.d("SurfaceViewRenderer", getResourceName() + "Frames received: " + this.v + ". Dropped: " + this.w + ". Rendered: " + this.x);
      if ((this.v > 0) && (this.x > 0))
      {
        long l1 = System.nanoTime() - this.y;
        Logging.d("SurfaceViewRenderer", getResourceName() + "Duration: " + (int)(l1 / 1000000.0D) + " ms. FPS: " + this.x * 1.0E9D / l1);
        Logging.d("SurfaceViewRenderer", getResourceName() + "Average render time: " + (int)(this.z / (this.x * 1000)) + " us.");
      }
      return;
    }
  }
  
  private String getResourceName()
  {
    try
    {
      String str = getResources().getResourceEntryName(getId()) + ": ";
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return "";
  }
  
  public void init(e.a parama, o.b paramb)
  {
    init(parama, paramb, e.a, new h());
  }
  
  public void init(e.a parama, o.b paramb, int[] paramArrayOfInt, o.a parama1)
  {
    synchronized (this.b)
    {
      if (this.c != null) {
        throw new IllegalStateException(getResourceName() + "Already initialized");
      }
    }
    Logging.d("SurfaceViewRenderer", getResourceName() + "Initializing.");
    this.t = paramb;
    this.f = parama1;
    this.a = new HandlerThread("SurfaceViewRenderer");
    this.a.start();
    this.d = e.create(parama, paramArrayOfInt);
    this.c = new Handler(this.a.getLooper());
    tryCreateEglSurface();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    synchronized (this.j)
    {
      this.l.x = (paramInt3 - paramInt1);
      this.l.y = (paramInt4 - paramInt2);
      a(this.A);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    synchronized (this.j)
    {
      if ((this.o == 0) || (this.p == 0))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      this.k = a(paramInt1, paramInt2);
      if (this.k.x == getMeasuredWidth()) {
        if (this.k.y == getMeasuredHeight()) {
          break label99;
        }
      }
    }
    synchronized (this.b)
    {
      if (this.c != null) {
        this.c.postAtFrontOfQueue(this.B);
      }
      label99:
      setMeasuredDimension(this.k.x, this.k.y);
      return;
      localObject3 = finally;
      throw ((Throwable)localObject3);
    }
  }
  
  public void release()
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    synchronized (this.b)
    {
      if (this.c == null)
      {
        Logging.d("SurfaceViewRenderer", getResourceName() + "Already released");
        return;
      }
      this.c.postAtFrontOfQueue(new Runnable()
      {
        public void run()
        {
          SurfaceViewRenderer.f(SurfaceViewRenderer.this).release();
          SurfaceViewRenderer.a(SurfaceViewRenderer.this, null);
          if (SurfaceViewRenderer.g(SurfaceViewRenderer.this) != null)
          {
            GLES20.glDeleteTextures(3, SurfaceViewRenderer.g(SurfaceViewRenderer.this), 0);
            SurfaceViewRenderer.a(SurfaceViewRenderer.this, null);
          }
          SurfaceViewRenderer.b(SurfaceViewRenderer.this);
          SurfaceViewRenderer.e(SurfaceViewRenderer.this).release();
          SurfaceViewRenderer.a(SurfaceViewRenderer.this, null);
          localCountDownLatch.countDown();
        }
      });
      this.c = null;
      u.awaitUninterruptibly(localCountDownLatch);
      this.a.quit();
      synchronized (this.h)
      {
        if (this.i != null)
        {
          VideoRenderer.renderFrameDone(this.i);
          this.i = null;
        }
        u.joinUninterruptibly(this.a);
        this.a = null;
      }
    }
    synchronized (this.j)
    {
      this.o = 0;
      this.p = 0;
      this.q = 0;
      this.t = null;
      resetStatistics();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
      localObject3 = finally;
      throw ((Throwable)localObject3);
    }
  }
  
  public void renderFrame(VideoRenderer.b paramb)
  {
    synchronized (this.u)
    {
      this.v += 1;
    }
    synchronized (this.h)
    {
      if (this.i != null) {}
      synchronized (this.u)
      {
        this.w += 1;
        VideoRenderer.renderFrameDone(this.i);
        this.i = paramb;
        a(paramb);
        this.c.post(this.A);
        return;
        paramb = finally;
        throw paramb;
      }
    }
  }
  
  public void resetStatistics()
  {
    synchronized (this.u)
    {
      this.v = 0;
      this.w = 0;
      this.x = 0;
      this.y = 0L;
      this.z = 0L;
      return;
    }
  }
  
  public void setMirror(boolean paramBoolean)
  {
    synchronized (this.j)
    {
      this.s = paramBoolean;
      return;
    }
  }
  
  public void setScalingType(o.c paramc)
  {
    synchronized (this.j)
    {
      this.r = paramc;
      return;
    }
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    Logging.d("SurfaceViewRenderer", getResourceName() + "Surface changed: " + paramInt2 + "x" + paramInt3);
    synchronized (this.j)
    {
      this.m.x = paramInt2;
      this.m.y = paramInt3;
      a(this.A);
      return;
    }
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    Logging.d("SurfaceViewRenderer", getResourceName() + "Surface created.");
    synchronized (this.j)
    {
      this.n = true;
      tryCreateEglSurface();
      return;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    Logging.d("SurfaceViewRenderer", getResourceName() + "Surface destroyed.");
    synchronized (this.j)
    {
      this.n = false;
      this.m.x = 0;
      this.m.y = 0;
      a(new Runnable()
      {
        public void run()
        {
          SurfaceViewRenderer.e(SurfaceViewRenderer.this).releaseSurface();
        }
      });
      return;
    }
  }
  
  public void tryCreateEglSurface()
  {
    a(new Runnable()
    {
      public void run()
      {
        synchronized (SurfaceViewRenderer.c(SurfaceViewRenderer.this))
        {
          if ((SurfaceViewRenderer.d(SurfaceViewRenderer.this)) && (!SurfaceViewRenderer.e(SurfaceViewRenderer.this).hasSurface()))
          {
            SurfaceViewRenderer.e(SurfaceViewRenderer.this).createSurface(SurfaceViewRenderer.this.getHolder().getSurface());
            SurfaceViewRenderer.e(SurfaceViewRenderer.this).makeCurrent();
            GLES20.glPixelStorei(3317, 1);
          }
          return;
        }
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/SurfaceViewRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */