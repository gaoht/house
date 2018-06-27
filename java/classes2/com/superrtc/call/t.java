package com.superrtc.call;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class t
{
  private final Handler a;
  private final e b;
  private final SurfaceTexture c;
  private final int d;
  private b e;
  private a f;
  private boolean g = false;
  private volatile boolean h = false;
  private boolean i = false;
  
  private t(e.a parama, Handler paramHandler)
  {
    if (paramHandler.getLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
    }
    this.a = paramHandler;
    this.b = e.create(parama, e.c);
    this.b.createDummyPbufferSurface();
    this.b.makeCurrent();
    this.d = k.generateTexture(36197);
    this.c = new SurfaceTexture(this.d);
    this.c.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        t.a(t.this, true);
        t.a(t.this);
      }
    });
  }
  
  private b a()
  {
    if (this.e != null) {
      return this.e;
    }
    try
    {
      if (this.e == null) {
        this.e = new b(this.b.getEglBaseContext());
      }
      b localb = this.e;
      return localb;
    }
    finally {}
  }
  
  private void b()
  {
    if (this.a.getLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Wrong thread.");
    }
    if ((this.i) || (!this.g) || (this.h) || (this.f == null)) {
      return;
    }
    this.h = true;
    this.g = false;
    this.b.makeCurrent();
    this.c.updateTexImage();
    float[] arrayOfFloat = new float[16];
    this.c.getTransformMatrix(arrayOfFloat);
    if (Build.VERSION.SDK_INT >= 14) {}
    for (long l = this.c.getTimestamp();; l = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime()))
    {
      this.f.onTextureFrameAvailable(this.d, arrayOfFloat, l);
      return;
    }
  }
  
  private void c()
  {
    if (this.a.getLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Wrong thread.");
    }
    if ((this.h) || (!this.i)) {
      throw new IllegalStateException("Unexpected release.");
    }
    try
    {
      if (this.e != null) {
        this.e.a();
      }
      this.b.makeCurrent();
      GLES20.glDeleteTextures(1, new int[] { this.d }, 0);
      this.c.release();
      this.b.release();
      this.a.getLooper().quit();
      return;
    }
    finally {}
  }
  
  public static t create(e.a parama)
  {
    final Object localObject = new HandlerThread("SurfaceTextureHelper");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    (t)u.invokeUninterruptibly((Handler)localObject, new Callable()
    {
      public t call()
      {
        return new t(this.a, localObject, null);
      }
    });
  }
  
  public void dispose()
  {
    if (this.a.getLooper().getThread() == Thread.currentThread())
    {
      this.i = true;
      if (!this.h) {
        c();
      }
      return;
    }
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.a.postAtFrontOfQueue(new Runnable()
    {
      public void run()
      {
        t.c(t.this, true);
        localCountDownLatch.countDown();
        if (!t.d(t.this)) {
          t.c(t.this);
        }
      }
    });
    u.awaitUninterruptibly(localCountDownLatch);
  }
  
  public Handler getHandler()
  {
    return this.a;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.c;
  }
  
  public boolean isTextureInUse()
  {
    return this.h;
  }
  
  public void returnTextureFrame()
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        t.b(t.this, false);
        if (t.b(t.this))
        {
          t.c(t.this);
          return;
        }
        t.a(t.this);
      }
    });
  }
  
  public void startListening(final a parama)
  {
    if (this.f != null) {
      throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
    }
    this.a.post(new Runnable()
    {
      public void run()
      {
        t.a(t.this, parama);
        t.a(t.this);
      }
    });
  }
  
  public void stopListening()
  {
    if (this.a.getLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Wrong thread.");
    }
    this.f = null;
  }
  
  public void textureToYUV(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    if (paramInt4 != this.d) {
      throw new IllegalStateException("textureToByteBuffer called with unexpected textureId");
    }
    a().a(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat);
  }
  
  public static abstract interface a
  {
    public abstract void onTextureFrameAvailable(int paramInt, float[] paramArrayOfFloat, long paramLong);
  }
  
  private static class b
  {
    private static final FloatBuffer d = k.createFloatBuffer(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
    private static final FloatBuffer e = k.createFloatBuffer(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
    private final e a;
    private final i b;
    private boolean c = false;
    private int f;
    private int g;
    private int h;
    
    b(e.a parama)
    {
      this.a = e.create(parama, e.d);
      this.a.createDummyPbufferSurface();
      this.a.makeCurrent();
      this.b = new i("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
      this.b.useProgram();
      this.f = this.b.getUniformLocation("texMatrix");
      this.g = this.b.getUniformLocation("xUnit");
      this.h = this.b.getUniformLocation("coeffs");
      GLES20.glUniform1i(this.b.getUniformLocation("oesTex"), 0);
      k.checkNoGLES2Error("Initialize fragment shader uniform values.");
      this.b.setVertexAttribArray("in_pos", 2, d);
      this.b.setVertexAttribArray("in_tc", 2, e);
      this.a.detachCurrent();
    }
    
    void a()
    {
      try
      {
        this.c = true;
        this.a.makeCurrent();
        this.b.release();
        this.a.release();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
    {
      try
      {
        if (this.c) {
          throw new IllegalStateException("YuvConverter.convert called on released object");
        }
      }
      finally {}
      if (paramInt3 % 8 != 0) {
        throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
      }
      if (paramInt3 < paramInt1) {
        throw new IllegalArgumentException("Invalid stride, must >= width");
      }
      int i = (paramInt1 + 3) / 4;
      int j = (paramInt1 + 7) / 8;
      int k = (paramInt2 + 1) / 2;
      int m = paramInt2 + k;
      if (paramByteBuffer.capacity() < paramInt3 * m) {
        throw new IllegalArgumentException("YuvConverter.convert called with too small buffer");
      }
      paramArrayOfFloat = o.multiplyMatrices(paramArrayOfFloat, o.verticalFlipMatrix());
      if (this.a.hasSurface()) {
        if ((this.a.surfaceWidth() != paramInt3 / 4) || (this.a.surfaceHeight() != m))
        {
          this.a.releaseSurface();
          this.a.createPbufferSurface(paramInt3 / 4, m);
        }
      }
      for (;;)
      {
        this.a.makeCurrent();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, paramInt4);
        GLES20.glUniformMatrix4fv(this.f, 1, false, paramArrayOfFloat, 0);
        GLES20.glViewport(0, 0, i, paramInt2);
        GLES20.glUniform2f(this.g, paramArrayOfFloat[0] / paramInt1, paramArrayOfFloat[1] / paramInt1);
        GLES20.glUniform4f(this.h, 0.299F, 0.587F, 0.114F, 0.0F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(0, paramInt2, j, k);
        GLES20.glUniform2f(this.g, 2.0F * paramArrayOfFloat[0] / paramInt1, paramArrayOfFloat[1] * 2.0F / paramInt1);
        GLES20.glUniform4f(this.h, -0.169F, -0.331F, 0.499F, 0.5F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glViewport(paramInt3 / 8, paramInt2, j, k);
        GLES20.glUniform4f(this.h, 0.499F, -0.418F, -0.0813F, 0.5F);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glReadPixels(0, 0, paramInt3 / 4, m, 6408, 5121, paramByteBuffer);
        k.checkNoGLES2Error("YuvConverter.convert");
        GLES20.glBindTexture(36197, 0);
        this.a.detachCurrent();
        return;
        this.a.createPbufferSurface(paramInt3 / 4, m);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */