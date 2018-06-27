package com.superrtc.call;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class x
  implements GLSurfaceView.Renderer
{
  private static x a = null;
  private static Runnable b = null;
  private static e.a d = null;
  private static Thread i;
  private static Thread j;
  private GLSurfaceView c;
  private boolean e;
  private int f;
  private int g;
  private final ArrayList<a> h;
  
  private x(GLSurfaceView paramGLSurfaceView)
  {
    this.c = paramGLSurfaceView;
    paramGLSurfaceView.setPreserveEGLContextOnPause(true);
    paramGLSurfaceView.setEGLContextClientVersion(2);
    paramGLSurfaceView.setRenderer(this);
    paramGLSurfaceView.setRenderMode(0);
    this.h = new ArrayList();
  }
  
  private static void a(Thread paramThread, String paramString)
  {
    if (paramThread != null)
    {
      paramThread = paramThread.getStackTrace();
      if (paramThread.length > 0)
      {
        Logging.d("VideoRendererGui", paramString + " stacks trace:");
        int m = paramThread.length;
        int k = 0;
        while (k < m)
        {
          Logging.d("VideoRendererGui", paramThread[k].toString());
          k += 1;
        }
      }
    }
  }
  
  public static a create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
  {
    try
    {
      paramc = create(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean, new h());
      return paramc;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static a create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c arg4, boolean paramBoolean, o.a parama)
  {
    if ((paramInt1 < 0) || (paramInt1 > 100) || (paramInt2 < 0) || (paramInt2 > 100) || (paramInt3 < 0) || (paramInt3 > 100) || (paramInt4 < 0) || (paramInt4 > 100) || (paramInt1 + paramInt3 > 100) || (paramInt2 + paramInt4 > 100)) {
      try
      {
        throw new RuntimeException("Incorrect window parameters.");
      }
      finally {}
    }
    if (a == null) {
      throw new RuntimeException("Attempt to create yuv renderer before setting GLSurfaceView");
    }
    parama = new a(a.c, a.h.size(), paramInt1, paramInt2, paramInt3, paramInt4, ???, paramBoolean, parama, null);
    synchronized (a.h)
    {
      final CountDownLatch localCountDownLatch;
      if (a.e)
      {
        localCountDownLatch = new CountDownLatch(1);
        a.c.queueEvent(new Runnable()
        {
          public void run()
          {
            x.a.b(this.a);
            this.a.setScreenSize(x.a(x.b()), x.b(x.b()));
            localCountDownLatch.countDown();
          }
        });
      }
      try
      {
        localCountDownLatch.await();
        a.h.add(parama);
        return parama;
      }
      catch (InterruptedException parama)
      {
        throw new RuntimeException(parama);
      }
    }
  }
  
  public static VideoRenderer createGui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
    throws Exception
  {
    return new VideoRenderer(create(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean));
  }
  
  public static VideoRenderer.a createGuiRenderer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
  {
    return create(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean);
  }
  
  public static void dispose()
  {
    for (;;)
    {
      try
      {
        ??? = a;
        if (??? == null) {
          return;
        }
        Logging.d("VideoRendererGui", "VideoRendererGui.dispose");
        synchronized (a.h)
        {
          Iterator localIterator = a.h.iterator();
          if (localIterator.hasNext()) {
            a.a((a)localIterator.next());
          }
        }
        a.h.clear();
      }
      finally {}
      i = null;
      j = null;
      a.c = null;
      d = null;
      b = null;
      a = null;
    }
  }
  
  /* Error */
  public static void printStackTraces()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 35	com/superrtc/call/x:a	Lcom/superrtc/call/x;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 74	com/superrtc/call/x:i	Ljava/lang/Thread;
    //   18: ldc -57
    //   20: invokestatic 201	com/superrtc/call/x:a	(Ljava/lang/Thread;Ljava/lang/String;)V
    //   23: getstatic 196	com/superrtc/call/x:j	Ljava/lang/Thread;
    //   26: ldc -53
    //   28: invokestatic 201	com/superrtc/call/x:a	(Ljava/lang/Thread;Ljava/lang/String;)V
    //   31: goto -20 -> 11
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localx	x
    //   34	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	34	finally
    //   15	31	34	finally
  }
  
  public static void remove(VideoRenderer.a parama)
  {
    try
    {
      Logging.d("VideoRendererGui", "VideoRendererGui.remove");
      if (a == null) {
        throw new RuntimeException("Attempt to remove renderer before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (a.h)
    {
      int k = a.h.indexOf(parama);
      if (k == -1)
      {
        Logging.w("VideoRendererGui", "Couldn't remove renderer (not present in current list)");
        return;
      }
      a.a((a)a.h.remove(k));
    }
  }
  
  public static void reset(VideoRenderer.a parama)
  {
    try
    {
      Logging.d("VideoRendererGui", "VideoRendererGui.reset");
      if (a == null) {
        throw new RuntimeException("Attempt to reset renderer before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (a.h)
    {
      Iterator localIterator = a.h.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala == parama) {
          locala.reset();
        }
      }
    }
  }
  
  public static void setRendererEvents(VideoRenderer.a parama, o.b paramb)
  {
    try
    {
      Logging.d("VideoRendererGui", "VideoRendererGui.setRendererEvents");
      if (a == null) {
        throw new RuntimeException("Attempt to set renderer events before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (a.h)
    {
      Iterator localIterator = a.h.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala == parama) {
          a.a(locala, paramb);
        }
      }
    }
  }
  
  public static void setView(GLSurfaceView paramGLSurfaceView, Runnable paramRunnable)
  {
    try
    {
      Logging.d("VideoRendererGui", "VideoRendererGui.setView");
      a = new x(paramGLSurfaceView);
      b = paramRunnable;
      return;
    }
    finally
    {
      paramGLSurfaceView = finally;
      throw paramGLSurfaceView;
    }
  }
  
  public static void update(VideoRenderer.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
  {
    try
    {
      Logging.d("VideoRendererGui", "VideoRendererGui.update");
      if (a == null) {
        throw new RuntimeException("Attempt to update yuv renderer before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (a.h)
    {
      Iterator localIterator = a.h.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala == parama) {
          locala.setPosition(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean);
        }
      }
    }
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    if (j == null) {
      j = Thread.currentThread();
    }
    GLES20.glViewport(0, 0, this.f, this.g);
    GLES20.glClear(16384);
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      if (localIterator.hasNext()) {
        a.c((a)localIterator.next());
      }
    }
  }
  
  public void onSurfaceChanged(GL10 arg1, int paramInt1, int paramInt2)
  {
    Logging.d("VideoRendererGui", "VideoRendererGui.onSurfaceChanged: " + paramInt1 + " x " + paramInt2 + "  ");
    this.f = paramInt1;
    this.g = paramInt2;
    synchronized (this.h)
    {
      Iterator localIterator = this.h.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).setScreenSize(this.f, this.g);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onSurfaceCreated(GL10 arg1, EGLConfig paramEGLConfig)
  {
    Logging.d("VideoRendererGui", "VideoRendererGui.onSurfaceCreated");
    try
    {
      if (g.isEGL14Supported()) {}
      for (d = new g.a(EGL14.eglGetCurrentContext());; d = new f.b(((EGL10)EGLContext.getEGL()).eglGetCurrentContext()))
      {
        Logging.d("VideoRendererGui", "VideoRendererGui EGL Context: " + d);
        synchronized (this.h)
        {
          paramEGLConfig = this.h.iterator();
          if (!paramEGLConfig.hasNext()) {
            break;
          }
          a.b((a)paramEGLConfig.next());
        }
      }
      this.e = true;
    }
    finally {}
    k.checkNoGLES2Error("onSurfaceCreated done");
    GLES20.glPixelStorei(3317, 1);
    GLES20.glClearColor(0.15F, 0.15F, 0.15F, 1.0F);
    try
    {
      if (b != null) {
        b.run();
      }
      return;
    }
    finally {}
  }
  
  private static class a
    implements VideoRenderer.a
  {
    private int A;
    private int B;
    private int C;
    private int D;
    boolean a;
    private GLSurfaceView b;
    private int c;
    private int[] d = { 0, 0, 0 };
    private final o.d e = new o.d();
    private final o.a f;
    private j g;
    private VideoRenderer.b h;
    private final Object i = new Object();
    private a j;
    private o.c k;
    private boolean l;
    private o.b m;
    private int n;
    private int o;
    private int p;
    private long q = -1L;
    private long r;
    private long s;
    private final Rect t;
    private final Rect u = new Rect();
    private float[] v;
    private boolean w;
    private final Object x = new Object();
    private float[] y;
    private int z;
    
    private a(GLSurfaceView paramGLSurfaceView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, o.c paramc, boolean paramBoolean, o.a parama)
    {
      Logging.d("VideoRendererGui", "YuvImageRenderer.Create id: " + paramInt1);
      this.b = paramGLSurfaceView;
      this.c = paramInt1;
      this.k = paramc;
      this.l = paramBoolean;
      this.f = parama;
      this.t = new Rect(paramInt2, paramInt3, Math.min(100, paramInt2 + paramInt4), Math.min(100, paramInt3 + paramInt5));
      this.w = false;
      this.D = 0;
    }
    
    /* Error */
    private void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aconst_null
      //   4: putfield 105	com/superrtc/call/x$a:b	Landroid/opengl/GLSurfaceView;
      //   7: aload_0
      //   8: getfield 113	com/superrtc/call/x$a:f	Lcom/superrtc/call/o$a;
      //   11: invokeinterface 140 1 0
      //   16: aload_0
      //   17: getfield 69	com/superrtc/call/x$a:i	Ljava/lang/Object;
      //   20: astore_1
      //   21: aload_1
      //   22: monitorenter
      //   23: aload_0
      //   24: getfield 142	com/superrtc/call/x$a:h	Lcom/superrtc/call/VideoRenderer$b;
      //   27: ifnull +15 -> 42
      //   30: aload_0
      //   31: getfield 142	com/superrtc/call/x$a:h	Lcom/superrtc/call/VideoRenderer$b;
      //   34: invokestatic 148	com/superrtc/call/VideoRenderer:renderFrameDone	(Lcom/superrtc/call/VideoRenderer$b;)V
      //   37: aload_0
      //   38: aconst_null
      //   39: putfield 142	com/superrtc/call/x$a:h	Lcom/superrtc/call/VideoRenderer$b;
      //   42: aload_1
      //   43: monitorexit
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: astore_2
      //   48: aload_1
      //   49: monitorexit
      //   50: aload_2
      //   51: athrow
      //   52: astore_1
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_1
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	a
      //   52	4	1	localObject2	Object
      //   47	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   23	42	47	finally
      //   42	44	47	finally
      //   48	50	47	finally
      //   2	23	52	finally
      //   50	52	52	finally
    }
    
    private void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt1 == this.B) && (paramInt2 == this.C) && (paramInt3 == this.D)) {
        return;
      }
      if (this.m != null)
      {
        Logging.d("VideoRendererGui", "ID: " + this.c + ". Reporting frame resolution changed to " + paramInt1 + " x " + paramInt2);
        this.m.onFrameResolutionChanged(paramInt1, paramInt2, paramInt3);
      }
      synchronized (this.x)
      {
        Logging.d("VideoRendererGui", "ID: " + this.c + ". YuvImageRenderer.setSize: " + paramInt1 + " x " + paramInt2 + " rotation " + paramInt3);
        this.B = paramInt1;
        this.C = paramInt2;
        this.D = paramInt3;
        this.w = true;
        Logging.d("VideoRendererGui", "  YuvImageRenderer.setSize done.");
        return;
      }
    }
    
    private void b()
    {
      Logging.d("VideoRendererGui", "  YuvImageRenderer.createTextures " + this.c + " on GL thread:" + Thread.currentThread().getId());
      int i1 = 0;
      while (i1 < 3)
      {
        this.d[i1] = k.generateTexture(3553);
        i1 += 1;
      }
      this.g = new j(6407);
    }
    
    private void c()
    {
      for (;;)
      {
        synchronized (this.x)
        {
          if (!this.w) {
            return;
          }
          this.u.set((this.z * this.t.left + 99) / 100, (this.A * this.t.top + 99) / 100, this.z * this.t.right / 100, this.A * this.t.bottom / 100);
          Logging.d("VideoRendererGui", "ID: " + this.c + ". AdjustTextureCoords. Allowed display size: " + this.u.width() + " x " + this.u.height() + ". Video: " + this.B + " x " + this.C + ". Rotation: " + this.D + ". Mirror: " + this.l);
          if (this.D % 180 == 0)
          {
            f1 = this.B / this.C;
            Point localPoint = o.getDisplaySize(this.k, f1, this.u.width(), this.u.height());
            this.u.inset((this.u.width() - localPoint.x) / 2, (this.u.height() - localPoint.y) / 2);
            Logging.d("VideoRendererGui", "  Adjusted display size: " + this.u.width() + " x " + this.u.height());
            this.v = o.getLayoutMatrix(this.l, f1, this.u.width() / this.u.height());
            this.w = false;
            Logging.d("VideoRendererGui", "  AdjustTextureCoords done");
            return;
          }
        }
        float f1 = this.C;
        int i1 = this.B;
        f1 /= i1;
      }
    }
    
    private void d()
    {
      if (!this.a) {
        return;
      }
      long l1 = System.nanoTime();
      for (;;)
      {
        int i2;
        synchronized (this.i)
        {
          if (this.h != null)
          {
            i1 = 1;
            if ((i1 != 0) && (this.q == -1L)) {
              this.q = l1;
            }
            if (i1 != 0)
            {
              this.y = o.rotateTextureMatrix(this.h.f, this.h.h);
              if (!this.h.e) {
                continue;
              }
              this.j = a.a;
              this.e.uploadYuvData(this.d, this.h.a, this.h.b, this.h.c, this.h.d);
              this.s += System.nanoTime() - l1;
              VideoRenderer.renderFrameDone(this.h);
              this.h = null;
            }
            c();
            ??? = o.multiplyMatrices(this.y, this.v);
            i2 = this.A - this.u.bottom;
            if (this.j != a.a) {
              break label398;
            }
            this.f.drawYuv(this.d, (float[])???, this.u.left, i2, this.u.width(), this.u.height());
            if (i1 == 0) {
              break;
            }
            this.p += 1;
            this.r += System.nanoTime() - l1;
            if (this.p % 300 != 0) {
              break;
            }
            e();
            return;
          }
          int i1 = 0;
          continue;
          this.j = a.b;
          this.g.setSize(this.h.rotatedWidth(), this.h.rotatedHeight());
          GLES20.glBindFramebuffer(36160, this.g.getFrameBufferId());
          k.checkNoGLES2Error("glBindFramebuffer");
          this.f.drawOes(this.h.g, this.y, 0, 0, this.g.getWidth(), this.g.getHeight());
          this.y = o.identityMatrix();
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
        }
        label398:
        this.f.drawRgb(this.g.getTextureId(), (float[])???, this.u.left, i2, this.u.width(), this.u.height());
      }
    }
    
    private void e()
    {
      long l1 = System.nanoTime() - this.q;
      Logging.d("VideoRendererGui", "ID: " + this.c + ". Type: " + this.j + ". Frames received: " + this.n + ". Dropped: " + this.o + ". Rendered: " + this.p);
      if ((this.n > 0) && (this.p > 0))
      {
        Logging.d("VideoRendererGui", "Duration: " + (int)(l1 / 1000000.0D) + " ms. FPS: " + this.p * 1.0E9D / l1);
        Logging.d("VideoRendererGui", "Draw time: " + (int)(this.r / (this.p * 1000)) + " us. Copy time: " + (int)(this.s / (this.n * 1000)) + " us");
      }
    }
    
    public void renderFrame(VideoRenderer.b paramb)
    {
      for (;;)
      {
        try
        {
          if (this.b == null)
          {
            VideoRenderer.renderFrameDone(paramb);
            return;
          }
          if (x.a() == null) {
            x.a(Thread.currentThread());
          }
          if ((!this.a) && (this.m != null))
          {
            Logging.d("VideoRendererGui", "ID: " + this.c + ". Reporting first rendered frame.");
            this.m.onFirstFrameRendered();
          }
          this.n += 1;
          synchronized (this.i)
          {
            if ((paramb.e) && ((paramb.c[0] < paramb.a) || (paramb.c[1] < paramb.a / 2) || (paramb.c[2] < paramb.a / 2)))
            {
              Logging.e("VideoRendererGui", "Incorrect strides " + paramb.c[0] + ", " + paramb.c[1] + ", " + paramb.c[2]);
              VideoRenderer.renderFrameDone(paramb);
            }
          }
          if (this.h == null) {
            break label262;
          }
        }
        finally {}
        this.o += 1;
        VideoRenderer.renderFrameDone(paramb);
        this.a = true;
        continue;
        label262:
        this.h = paramb;
        a(paramb.a, paramb.b, paramb.h);
        this.a = true;
        this.b.requestRender();
      }
    }
    
    public void reset()
    {
      try
      {
        this.a = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
    {
      Rect localRect = new Rect(paramInt1, paramInt2, Math.min(100, paramInt1 + paramInt3), Math.min(100, paramInt2 + paramInt4));
      synchronized (this.x)
      {
        if ((localRect.equals(this.t)) && (paramc == this.k) && (paramBoolean == this.l)) {
          return;
        }
        Logging.d("VideoRendererGui", "ID: " + this.c + ". YuvImageRenderer.setPosition: (" + paramInt1 + ", " + paramInt2 + ") " + paramInt3 + " x " + paramInt4 + ". Scaling: " + paramc + ". Mirror: " + paramBoolean);
        this.t.set(localRect);
        this.k = paramc;
        this.l = paramBoolean;
        this.w = true;
        return;
      }
    }
    
    public void setScreenSize(int paramInt1, int paramInt2)
    {
      synchronized (this.x)
      {
        if ((paramInt1 == this.z) && (paramInt2 == this.A)) {
          return;
        }
        Logging.d("VideoRendererGui", "ID: " + this.c + ". YuvImageRenderer.setScreenSize: " + paramInt1 + " x " + paramInt2);
        this.z = paramInt1;
        this.A = paramInt2;
        this.w = true;
        return;
      }
    }
    
    private static enum a
    {
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */