package com.superrtc.call;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.superrtc.sdk.VideoView;
import com.superrtc.sdk.VideoView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class y
  implements GLSurfaceView.Renderer
{
  private Runnable a = null;
  private VideoView b;
  private e.a c = null;
  private boolean d;
  private int e;
  private int f;
  private final ArrayList<a> g;
  private Thread h;
  private Thread i;
  private boolean j = true;
  
  @SuppressLint({"NewApi"})
  public y(VideoView paramVideoView, Runnable paramRunnable)
  {
    this.b = paramVideoView;
    this.a = paramRunnable;
    paramVideoView.setPreserveEGLContextOnPause(true);
    paramVideoView.setEGLContextClientVersion(2);
    paramVideoView.setRenderer(this);
    paramVideoView.setRenderMode(0);
    this.g = new ArrayList();
  }
  
  private static void a(Thread paramThread, String paramString)
  {
    if (paramThread != null)
    {
      paramThread = paramThread.getStackTrace();
      if (paramThread.length > 0)
      {
        Logging.d("VideoRendererGui2", paramString + " stacks trace:");
        int m = paramThread.length;
        int k = 0;
        while (k < m)
        {
          Logging.d("VideoRendererGui2", paramThread[k].toString());
          k += 1;
        }
      }
    }
  }
  
  public a create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
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
  
  /* Error */
  public a create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, final o.c paramc, boolean paramBoolean, o.a arg7)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt +58 -> 61
    //   6: iload_1
    //   7: bipush 100
    //   9: if_icmpgt +52 -> 61
    //   12: iload_2
    //   13: iflt +48 -> 61
    //   16: iload_2
    //   17: bipush 100
    //   19: if_icmpgt +42 -> 61
    //   22: iload_3
    //   23: iflt +38 -> 61
    //   26: iload_3
    //   27: bipush 100
    //   29: if_icmpgt +32 -> 61
    //   32: iload 4
    //   34: iflt +27 -> 61
    //   37: iload 4
    //   39: bipush 100
    //   41: if_icmpgt +20 -> 61
    //   44: iload_1
    //   45: iload_3
    //   46: iadd
    //   47: bipush 100
    //   49: if_icmpgt +12 -> 61
    //   52: iload_2
    //   53: iload 4
    //   55: iadd
    //   56: bipush 100
    //   58: if_icmple +20 -> 78
    //   61: new 119	java/lang/RuntimeException
    //   64: dup
    //   65: ldc 121
    //   67: invokespecial 124	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore 5
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 5
    //   77: athrow
    //   78: aload_0
    //   79: ifnonnull +13 -> 92
    //   82: new 119	java/lang/RuntimeException
    //   85: dup
    //   86: ldc 126
    //   88: invokespecial 124	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: new 12	com/superrtc/call/y$a
    //   95: dup
    //   96: aload_0
    //   97: getfield 48	com/superrtc/call/y:b	Lcom/superrtc/sdk/VideoView;
    //   100: aload_0
    //   101: getfield 70	com/superrtc/call/y:g	Ljava/util/ArrayList;
    //   104: invokevirtual 130	java/util/ArrayList:size	()I
    //   107: iload_1
    //   108: iload_2
    //   109: iload_3
    //   110: iload 4
    //   112: aload 5
    //   114: iload 6
    //   116: aload 7
    //   118: aconst_null
    //   119: invokespecial 133	com/superrtc/call/y$a:<init>	(Lcom/superrtc/sdk/VideoView;IIIIILcom/superrtc/call/o$c;ZLcom/superrtc/call/o$a;Lcom/superrtc/call/y$1;)V
    //   122: astore 5
    //   124: aload_0
    //   125: getfield 135	com/superrtc/call/y:d	Z
    //   128: ifeq +45 -> 173
    //   131: new 137	java/util/concurrent/CountDownLatch
    //   134: dup
    //   135: iconst_1
    //   136: invokespecial 139	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   139: astore 7
    //   141: aload_0
    //   142: getfield 48	com/superrtc/call/y:b	Lcom/superrtc/sdk/VideoView;
    //   145: ifnull +55 -> 200
    //   148: aload_0
    //   149: getfield 48	com/superrtc/call/y:b	Lcom/superrtc/sdk/VideoView;
    //   152: new 8	com/superrtc/call/y$1
    //   155: dup
    //   156: aload_0
    //   157: aload 5
    //   159: aload_0
    //   160: aload 7
    //   162: invokespecial 142	com/superrtc/call/y$1:<init>	(Lcom/superrtc/call/y;Lcom/superrtc/call/y$a;Lcom/superrtc/call/y;Ljava/util/concurrent/CountDownLatch;)V
    //   165: invokevirtual 146	com/superrtc/sdk/VideoView:queueEvent	(Ljava/lang/Runnable;)V
    //   168: aload 7
    //   170: invokevirtual 149	java/util/concurrent/CountDownLatch:await	()V
    //   173: aload_0
    //   174: getfield 70	com/superrtc/call/y:g	Ljava/util/ArrayList;
    //   177: astore 7
    //   179: aload 7
    //   181: monitorenter
    //   182: aload_0
    //   183: getfield 70	com/superrtc/call/y:g	Ljava/util/ArrayList;
    //   186: aload 5
    //   188: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload 7
    //   194: monitorexit
    //   195: aload_0
    //   196: monitorexit
    //   197: aload 5
    //   199: areturn
    //   200: aload 7
    //   202: invokevirtual 156	java/util/concurrent/CountDownLatch:countDown	()V
    //   205: goto -37 -> 168
    //   208: astore 5
    //   210: new 119	java/lang/RuntimeException
    //   213: dup
    //   214: aload 5
    //   216: invokespecial 159	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   219: athrow
    //   220: astore 5
    //   222: aload 7
    //   224: monitorexit
    //   225: aload 5
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	y
    //   0	228	1	paramInt1	int
    //   0	228	2	paramInt2	int
    //   0	228	3	paramInt3	int
    //   0	228	4	paramInt4	int
    //   0	228	5	paramc	o.c
    //   0	228	6	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   61	71	71	finally
    //   82	92	71	finally
    //   92	168	71	finally
    //   168	173	71	finally
    //   173	182	71	finally
    //   200	205	71	finally
    //   210	220	71	finally
    //   225	228	71	finally
    //   168	173	208	java/lang/InterruptedException
    //   182	195	220	finally
    //   222	225	220	finally
  }
  
  public VideoRenderer createGui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
    throws Exception
  {
    return new VideoRenderer(create(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean));
  }
  
  public VideoRenderer.a createGuiRenderer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
  {
    return create(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean);
  }
  
  public a createRenderer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c arg5, boolean paramBoolean, final o.a parama)
  {
    if ((paramInt1 < 0) || (paramInt1 > 100) || (paramInt2 < 0) || (paramInt2 > 100) || (paramInt3 < 0) || (paramInt3 > 100) || (paramInt4 < 0) || (paramInt4 > 100) || (paramInt1 + paramInt3 > 100) || (paramInt2 + paramInt4 > 100)) {
      try
      {
        throw new RuntimeException("Incorrect window parameters.");
      }
      finally {}
    }
    parama = new a(this.b, this.g.size(), paramInt1, paramInt2, paramInt3, paramInt4, ???, paramBoolean, parama, null);
    synchronized (this.g)
    {
      final CountDownLatch localCountDownLatch;
      if (this.d)
      {
        localCountDownLatch = new CountDownLatch(1);
        this.b.queueEvent(new Runnable()
        {
          public void run()
          {
            y.a.c(parama);
            parama.setScreenSize(y.a(jdField_this), y.b(jdField_this));
            localCountDownLatch.countDown();
          }
        });
      }
      try
      {
        localCountDownLatch.await();
        this.g.add(parama);
        return parama;
      }
      catch (InterruptedException parama)
      {
        throw new RuntimeException(parama);
      }
    }
  }
  
  public void dispose()
  {
    if (this == null) {}
    for (;;)
    {
      return;
      try
      {
        Logging.d("VideoRendererGui2", "VideoRendererGui.dispose");
        synchronized (this.g)
        {
          Iterator localIterator = this.g.iterator();
          if (localIterator.hasNext()) {
            a.b((a)localIterator.next());
          }
        }
        this.g.clear();
      }
      finally {}
      this.h = null;
      this.i = null;
      this.b = null;
      this.c = null;
      this.a = null;
    }
  }
  
  public e.a getEglBaseContext()
  {
    try
    {
      e.a locala = this.c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean getRenderEnable()
  {
    synchronized (this.g)
    {
      boolean bool = this.j;
      return bool;
    }
  }
  
  public int getScreenHeight()
  {
    int k = 0;
    Iterator localIterator = this.g.iterator();
    if (localIterator.hasNext()) {
      k = ((a)localIterator.next()).getVideoHeight();
    }
    return k;
  }
  
  public int getScreenWidth()
  {
    int k = 0;
    Iterator localIterator = this.g.iterator();
    if (localIterator.hasNext()) {
      k = ((a)localIterator.next()).getVideoWidth();
    }
    return k;
  }
  
  public int getframesReceived()
  {
    int k = 0;
    Iterator localIterator = this.g.iterator();
    if (localIterator.hasNext()) {
      k = a.a((a)localIterator.next());
    }
    return k;
  }
  
  public void makeblack(boolean paramBoolean)
  {
    if (this == null) {}
    for (;;)
    {
      return;
      try
      {
        Logging.e("VideoRendererGui2", "VideoRendererGui makeblack " + paramBoolean);
        synchronized (this.g)
        {
          Iterator localIterator = this.g.iterator();
          if (localIterator.hasNext()) {
            a.a((a)localIterator.next(), paramBoolean);
          }
        }
      }
      finally {}
      if (paramBoolean)
      {
        GLES20.glPixelStorei(3317, 1);
        GLES20.glClearColor(0.15F, 0.15F, 0.15F, 1.0F);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFinish();
      }
    }
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    synchronized (this.g)
    {
      if (!this.d) {
        return;
      }
      if (this.i == null) {
        this.i = Thread.currentThread();
      }
      GLES20.glViewport(0, 0, this.e, this.f);
      GLES20.glClear(16384);
      synchronized (this.g)
      {
        if (!this.j) {
          return;
        }
      }
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      a.d((a)localIterator.next());
    }
  }
  
  public void onSurfaceChanged(GL10 arg1, int paramInt1, int paramInt2)
  {
    Logging.d("VideoRendererGui2", "VideoRendererGui.onSurfaceChanged: " + paramInt1 + " x " + paramInt2 + "  ");
    this.e = paramInt1;
    this.f = paramInt2;
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).setScreenSize(this.e, this.f);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onSurfaceCreated(GL10 arg1, EGLConfig paramEGLConfig)
  {
    Logging.d("VideoRendererGui2", "VideoRendererGui.onSurfaceCreated");
    try
    {
      if (g.isEGL14Supported()) {}
      for (this.c = new g.a(EGL14.eglGetCurrentContext());; this.c = new f.b(((EGL10)EGLContext.getEGL()).eglGetCurrentContext()))
      {
        Logging.d("VideoRendererGui2", "VideoRendererGui EGL Context: " + this.c);
        synchronized (this.g)
        {
          paramEGLConfig = this.g.iterator();
          if (!paramEGLConfig.hasNext()) {
            break;
          }
          a.c((a)paramEGLConfig.next());
        }
      }
      this.d = true;
    }
    finally {}
    k.checkNoGLES2Error("onSurfaceCreated done");
    GLES20.glPixelStorei(3317, 1);
    GLES20.glClearColor(0.15F, 0.15F, 0.15F, 1.0F);
    try
    {
      if (this.a != null) {
        this.a.run();
      }
      return;
    }
    finally {}
  }
  
  public void printStackTraces()
  {
    try
    {
      a(this.h, "Render frame thread");
      a(this.i, "Draw thread");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void remove(VideoRenderer.a parama)
  {
    try
    {
      Logging.d("VideoRendererGui2", "VideoRendererGui.remove");
      if (this == null) {
        throw new RuntimeException("Attempt to remove renderer before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (this.g)
    {
      int k = this.g.indexOf(parama);
      if (k == -1)
      {
        Logging.w("VideoRendererGui2", "Couldn't remove renderer (not present in current list)");
        return;
      }
      a.b((a)this.g.remove(k));
    }
  }
  
  public void reset(VideoRenderer.a parama)
  {
    try
    {
      Logging.d("VideoRendererGui2", "VideoRendererGui.reset");
      if (this == null) {
        throw new RuntimeException("Attempt to reset renderer before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala == parama) {
          locala.reset();
        }
      }
    }
  }
  
  public void setReadyCallback(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void setRenderEnable(boolean paramBoolean)
  {
    synchronized (this.g)
    {
      this.j = paramBoolean;
      return;
    }
  }
  
  public void setRendererEvents(VideoRenderer.a parama, o.b paramb)
  {
    try
    {
      Logging.d("VideoRendererGui2", "VideoRendererGui.setRendererEvents");
      if (this == null) {
        throw new RuntimeException("Attempt to set renderer events before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala == parama) {
          a.a(locala, paramb);
        }
      }
    }
  }
  
  public void update(VideoRenderer.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, o.c paramc, boolean paramBoolean)
  {
    try
    {
      Logging.d("VideoRendererGui2", "VideoRendererGui.update");
      if (this == null) {
        throw new RuntimeException("Attempt to update yuv renderer before setting GLSurfaceView");
      }
    }
    finally {}
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala == parama) {
          locala.setPosition(paramInt1, paramInt2, paramInt3, paramInt4, paramc, paramBoolean);
        }
      }
    }
  }
  
  private static class a
    implements VideoRenderer.a
  {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E = false;
    private int F;
    o.c a;
    boolean b;
    private VideoView c;
    private int d;
    private int[] e = { 0, 0, 0 };
    private final o.d f = new o.d();
    private final o.a g;
    private j h;
    private VideoRenderer.b i;
    private final Object j = new Object();
    private a k;
    private o.c l = o.c.a;
    private boolean m;
    private o.b n;
    private int o;
    private int p;
    private int q;
    private long r = -1L;
    private long s;
    private long t;
    private final Rect u;
    private final Rect v = new Rect();
    private float[] w;
    private boolean x;
    private final Object y = new Object();
    private float[] z;
    
    private a(VideoView paramVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, o.c paramc, boolean paramBoolean, o.a parama)
    {
      Logging.d("VideoRendererGui2", "YuvImageRenderer.Create id: " + paramInt1);
      this.c = paramVideoView;
      this.d = paramInt1;
      if (paramVideoView != null) {
        if (paramVideoView.getScaleMode() == VideoView.b.a) {
          paramVideoView = o.c.a;
        }
      }
      for (this.l = paramVideoView;; this.l = paramc)
      {
        this.m = paramBoolean;
        this.g = parama;
        this.u = new Rect(paramInt2, paramInt3, Math.min(100, paramInt2 + paramInt4), Math.min(100, paramInt3 + paramInt5));
        this.x = false;
        this.F = 0;
        return;
        paramVideoView = o.c.b;
        break;
      }
    }
    
    /* Error */
    private void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aconst_null
      //   4: putfield 115	com/superrtc/call/y$a:c	Lcom/superrtc/sdk/VideoView;
      //   7: aload_0
      //   8: getfield 132	com/superrtc/call/y$a:g	Lcom/superrtc/call/o$a;
      //   11: invokeinterface 164 1 0
      //   16: aload_0
      //   17: getfield 71	com/superrtc/call/y$a:j	Ljava/lang/Object;
      //   20: astore_1
      //   21: aload_1
      //   22: monitorenter
      //   23: aload_0
      //   24: getfield 166	com/superrtc/call/y$a:i	Lcom/superrtc/call/VideoRenderer$b;
      //   27: ifnull +15 -> 42
      //   30: aload_0
      //   31: getfield 166	com/superrtc/call/y$a:i	Lcom/superrtc/call/VideoRenderer$b;
      //   34: invokestatic 172	com/superrtc/call/VideoRenderer:renderFrameDone	(Lcom/superrtc/call/VideoRenderer$b;)V
      //   37: aload_0
      //   38: aconst_null
      //   39: putfield 166	com/superrtc/call/y$a:i	Lcom/superrtc/call/VideoRenderer$b;
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
      if ((paramInt1 == this.C) && (paramInt2 == this.D) && (paramInt3 == this.F)) {
        return;
      }
      if (this.n != null)
      {
        Logging.d("VideoRendererGui2", "ID: " + this.d + ". Reporting frame resolution changed to " + paramInt1 + " x " + paramInt2);
        this.n.onFrameResolutionChanged(paramInt1, paramInt2, paramInt3);
      }
      synchronized (this.y)
      {
        Logging.d("VideoRendererGui2", "ID: " + this.d + ". YuvImageRenderer.setSize: " + paramInt1 + " x " + paramInt2 + " rotation " + paramInt3);
        this.C = paramInt1;
        this.D = paramInt2;
        this.F = paramInt3;
        this.x = true;
        Logging.d("VideoRendererGui2", "  YuvImageRenderer.setSize done.");
        return;
      }
    }
    
    /* Error */
    private void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 71	com/superrtc/call/y$a:j	Ljava/lang/Object;
      //   6: astore_2
      //   7: aload_2
      //   8: monitorenter
      //   9: aload_0
      //   10: iload_1
      //   11: putfield 90	com/superrtc/call/y$a:E	Z
      //   14: aload_2
      //   15: monitorexit
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: astore_3
      //   20: aload_2
      //   21: monitorexit
      //   22: aload_3
      //   23: athrow
      //   24: astore_2
      //   25: aload_0
      //   26: monitorexit
      //   27: aload_2
      //   28: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	29	0	this	a
      //   0	29	1	paramBoolean	boolean
      //   24	4	2	localObject2	Object
      //   19	4	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   9	16	19	finally
      //   20	22	19	finally
      //   2	9	24	finally
      //   22	24	24	finally
    }
    
    private void b()
    {
      Logging.d("VideoRendererGui2", "  YuvImageRenderer.createTextures " + this.d + " on GL thread:" + Thread.currentThread().getId());
      int i1 = 0;
      while (i1 < 3)
      {
        this.e[i1] = k.generateTexture(3553);
        i1 += 1;
      }
      this.h = new j(6407);
    }
    
    private void c()
    {
      for (;;)
      {
        synchronized (this.y)
        {
          Object localObject1;
          if (this.c.getScaleMode() == VideoView.b.a)
          {
            localObject1 = o.c.a;
            this.a = ((o.c)localObject1);
            if (this.a != this.l)
            {
              this.x = true;
              this.l = this.a;
            }
            if (this.x) {}
          }
          else
          {
            localObject1 = o.c.b;
            continue;
          }
          this.v.set((this.A * this.u.left + 99) / 100, (this.B * this.u.top + 99) / 100, this.A * this.u.right / 100, this.B * this.u.bottom / 100);
          Logging.d("VideoRendererGui2", "ID: " + this.d + ". AdjustTextureCoords. Allowed display size: " + this.v.width() + " x " + this.v.height() + ". Video: " + this.C + " x " + this.D + ". Rotation: " + this.F + ". Mirror: " + this.m);
          if (this.F % 180 == 0)
          {
            f1 = this.C / this.D;
            localObject1 = o.getDisplaySize(this.l, f1, this.v.width(), this.v.height());
            this.v.inset((this.v.width() - ((Point)localObject1).x) / 2, (this.v.height() - ((Point)localObject1).y) / 2);
            Logging.d("VideoRendererGui2", "  Adjusted display size: " + this.v.width() + " x " + this.v.height());
            this.w = o.getLayoutMatrix(this.m, f1, this.v.width() / this.v.height());
            this.x = false;
            Logging.d("VideoRendererGui2", "  AdjustTextureCoords done");
            return;
          }
        }
        float f1 = this.D;
        int i1 = this.C;
        f1 /= i1;
      }
    }
    
    private void d()
    {
      if (!this.b) {}
      while (this.E) {
        return;
      }
      long l1 = System.nanoTime();
      for (;;)
      {
        int i2;
        synchronized (this.j)
        {
          if (this.i != null)
          {
            i1 = 1;
            if ((i1 != 0) && (this.r == -1L)) {
              this.r = l1;
            }
            if (i1 != 0)
            {
              this.z = o.rotateTextureMatrix(this.i.f, this.i.h);
              if (!this.i.e) {
                continue;
              }
              this.k = a.a;
              this.f.uploadYuvData(this.e, this.i.a, this.i.b, this.i.c, this.i.d);
              this.t += System.nanoTime() - l1;
              VideoRenderer.renderFrameDone(this.i);
              this.i = null;
            }
            c();
            ??? = o.multiplyMatrices(this.z, this.w);
            i2 = this.B - this.v.bottom;
            if (this.k != a.a) {
              break label405;
            }
            this.g.drawYuv(this.e, (float[])???, this.v.left, i2, this.v.width(), this.v.height());
            if (i1 == 0) {
              break;
            }
            this.q += 1;
            this.s += System.nanoTime() - l1;
            if (this.q % 300 != 0) {
              break;
            }
            e();
            return;
          }
          int i1 = 0;
          continue;
          this.k = a.b;
          this.h.setSize(this.i.rotatedWidth(), this.i.rotatedHeight());
          GLES20.glBindFramebuffer(36160, this.h.getFrameBufferId());
          k.checkNoGLES2Error("glBindFramebuffer");
          this.g.drawOes(this.i.g, this.z, 0, 0, this.h.getWidth(), this.h.getHeight());
          this.z = o.identityMatrix();
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glFinish();
        }
        label405:
        this.g.drawRgb(this.h.getTextureId(), (float[])???, this.v.left, i2, this.v.width(), this.v.height());
      }
    }
    
    private void e()
    {
      long l1 = System.nanoTime() - this.r;
      Logging.d("VideoRendererGui2", "ID: " + this.d + ". Type: " + this.k + ". Frames received: " + this.o + ". Dropped: " + this.p + ". Rendered: " + this.q);
      if ((this.o > 0) && (this.q > 0))
      {
        Logging.d("VideoRendererGui2", "Duration: " + (int)(l1 / 1000000.0D) + " ms. FPS: " + this.q * 1.0E9D / l1);
        Logging.d("VideoRendererGui2", "Draw time: " + (int)(this.s / (this.q * 1000)) + " us. Copy time: " + (int)(this.t / (this.o * 1000)) + " us");
      }
    }
    
    public int getVideoHeight()
    {
      return this.D;
    }
    
    public int getVideoWidth()
    {
      return this.C;
    }
    
    public void renderFrame(VideoRenderer.b paramb)
    {
      for (;;)
      {
        try
        {
          if (this.c == null)
          {
            VideoRenderer.renderFrameDone(paramb);
            return;
          }
          if ((!this.b) && (this.n != null))
          {
            Logging.d("VideoRendererGui2", "ID: " + this.d + ". Reporting first rendered frame.");
            this.n.onFirstFrameRendered();
          }
          this.o += 1;
          synchronized (this.j)
          {
            if ((paramb.e) && ((paramb.c[0] < paramb.a) || (paramb.c[1] < paramb.a / 2) || (paramb.c[2] < paramb.a / 2)))
            {
              Logging.e("VideoRendererGui2", "Incorrect strides " + paramb.c[0] + ", " + paramb.c[1] + ", " + paramb.c[2]);
              VideoRenderer.renderFrameDone(paramb);
            }
          }
          if (this.i == null) {
            break label249;
          }
        }
        finally {}
        this.p += 1;
        VideoRenderer.renderFrameDone(paramb);
        this.b = true;
        continue;
        label249:
        this.i = paramb;
        a(paramb.a, paramb.b, paramb.h);
        this.b = true;
        this.c.requestRender();
      }
    }
    
    public void reset()
    {
      try
      {
        this.b = false;
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
      synchronized (this.y)
      {
        if ((localRect.equals(this.u)) && (paramc == this.l) && (paramBoolean == this.m)) {
          return;
        }
        Logging.d("VideoRendererGui2", "ID: " + this.d + ". YuvImageRenderer.setPosition: (" + paramInt1 + ", " + paramInt2 + ") " + paramInt3 + " x " + paramInt4 + ". Scaling: " + paramc + ". Mirror: " + paramBoolean);
        this.u.set(localRect);
        this.m = paramBoolean;
        this.x = true;
        return;
      }
    }
    
    public void setScreenSize(int paramInt1, int paramInt2)
    {
      synchronized (this.y)
      {
        if ((paramInt1 == this.A) && (paramInt2 == this.B)) {
          return;
        }
        Logging.d("VideoRendererGui2", "ID: " + this.d + ". YuvImageRenderer.setScreenSize: " + paramInt1 + " x " + paramInt2);
        this.A = paramInt1;
        this.B = paramInt2;
        this.x = true;
        return;
      }
    }
    
    private static enum a
    {
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */