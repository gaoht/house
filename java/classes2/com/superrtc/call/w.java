package com.superrtc.call;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.superrtc.a.g;
import com.superrtc.sdk.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class w
  implements Camera.PreviewCallback, t.a, v
{
  private d A;
  private boolean B;
  private boolean C;
  private int D = 0;
  private boolean E = false;
  private int F = 0;
  private final Camera.ErrorCallback G = new Camera.ErrorCallback()
  {
    public void onError(int paramAnonymousInt, Camera paramAnonymousCamera)
    {
      if (paramAnonymousInt == 100) {}
      for (paramAnonymousCamera = "Camera server died!";; paramAnonymousCamera = "Camera error: " + paramAnonymousInt)
      {
        Logging.e("VideoCapturerAndroid", paramAnonymousCamera);
        if (w.a(w.this) != null) {
          w.a(w.this).onCameraError(paramAnonymousCamera);
        }
        return;
      }
    }
  };
  private final Runnable H = new Runnable()
  {
    private int b;
    
    public void run()
    {
      int i = w.b(w.this).getAndResetFrameCount();
      int j = (i * 1000 + 1000) / 2000;
      Logging.d("VideoCapturerAndroid", "Camera fps: " + j + ".");
      if (i == 0)
      {
        this.b += 1;
        if ((this.b * 2000 >= 4000) && (w.a(w.this) != null))
        {
          Logging.e("VideoCapturerAndroid", "Camera freezed.");
          if (w.this.a.isTextureInUse())
          {
            w.a(w.this).onCameraFreezed("Camera failure. Client must return video buffers.");
            return;
          }
          w.a(w.this).onCameraFreezed("Camera failure.");
        }
      }
      else
      {
        this.b = 0;
      }
      w.c(w.this).postDelayed(this, 2000L);
    }
  };
  private e I;
  final t a;
  private Camera b;
  private Thread c;
  private final Handler d;
  private Context e;
  private final Object f = new Object();
  private int g;
  private Camera.CameraInfo h;
  private final b i;
  private int j;
  private int k;
  private int l;
  private c.a m;
  private final Object n = new Object();
  private volatile boolean o;
  private v.a p = null;
  private final a q;
  private boolean r;
  private final Set<byte[]> s = new HashSet();
  private final boolean t;
  private boolean u = false;
  private Runnable v;
  private int w;
  private boolean x = true;
  private boolean y = true;
  private e z;
  
  private w(int paramInt, a parama, e.a parama1)
  {
    this.g = paramInt;
    this.q = parama;
    if (parama1 != null) {}
    for (;;)
    {
      this.t = bool;
      this.i = new b();
      this.a = t.create(parama1);
      this.d = this.a.getHandler();
      this.c = this.d.getLooper().getThread();
      Logging.d("VideoCapturerAndroid", "VideoCapturerAndroid isCapturingToTexture : " + this.t);
      return;
      bool = false;
    }
  }
  
  private static int a(String paramString)
  {
    int i2 = 0;
    int i1 = 0;
    Logging.d("VideoCapturerAndroid", "lookupDeviceName: " + paramString);
    if ((paramString == null) || (Camera.getNumberOfCameras() == 0)) {
      i1 = -1;
    }
    while (paramString.isEmpty()) {
      return i1;
    }
    for (;;)
    {
      if (i2 >= Camera.getNumberOfCameras()) {
        break label76;
      }
      i1 = i2;
      if (paramString.equals(c.getDeviceName(i2))) {
        break;
      }
      i2 += 1;
    }
    label76:
    return -1;
  }
  
  private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    int i1 = Float.valueOf(300.0F * paramFloat3).intValue();
    paramInt1 = (int)(paramFloat1 / paramInt1 * 2000.0F - 1000.0F);
    paramInt2 = (int)(paramFloat2 / paramInt2 * 2000.0F - 1000.0F);
    i1 /= 2;
    RectF localRectF = new RectF(c(paramInt1 - i1, 64536, 1000), c(paramInt2 - i1, 64536, 1000), c(paramInt1 + i1, 64536, 1000), c(i1 + paramInt2, 64536, 1000));
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void a()
  {
    if (Thread.currentThread() != this.c) {
      throw new IllegalStateException("Wrong thread");
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 0;
    a();
    Logging.d("VideoCapturerAndroid", "startPreviewOnCameraThread requested: " + paramInt1 + "x" + paramInt2 + "@" + paramInt3);
    if (this.b == null) {
      Logging.e("VideoCapturerAndroid", "Calling startPreviewOnCameraThread on stopped camera.");
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      this.j = paramInt1;
      this.k = paramInt2;
      this.l = paramInt3;
      localObject1 = this.b.getParameters();
      localObject2 = c.getFramerateRange((Camera.Parameters)localObject1, paramInt3 * 1000);
      localSize = c.getClosestSupportedSize(((Camera.Parameters)localObject1).getSupportedPreviewSizes(), paramInt1, paramInt2);
      localObject2 = new c.a(localSize.width, localSize.height, localObject2[0], localObject2[1]);
    } while (((c.a)localObject2).isSameFormat(this.m));
    Logging.d("VideoCapturerAndroid", "isVideoStabilizationSupported: " + ((Camera.Parameters)localObject1).isVideoStabilizationSupported());
    if (((Camera.Parameters)localObject1).isVideoStabilizationSupported()) {
      ((Camera.Parameters)localObject1).setVideoStabilization(true);
    }
    if (((c.a)localObject2).c > 0) {
      ((Camera.Parameters)localObject1).setPreviewFpsRange(((c.a)localObject2).d, ((c.a)localObject2).c);
    }
    ((Camera.Parameters)localObject1).setPreviewSize(((c.a)localObject2).a, ((c.a)localObject2).b);
    if (!this.t)
    {
      localObject2.getClass();
      ((Camera.Parameters)localObject1).setPreviewFormat(17);
    }
    Camera.Size localSize = c.getClosestSupportedSize(((Camera.Parameters)localObject1).getSupportedPictureSizes(), paramInt1, paramInt2);
    ((Camera.Parameters)localObject1).setPictureSize(localSize.width, localSize.height);
    if (this.m != null)
    {
      this.b.stopPreview();
      this.u = true;
      this.b.setPreviewCallbackWithBuffer(null);
    }
    Logging.e("VideoCapturerAndroid", "Start capturing: " + localObject2);
    this.m = ((c.a)localObject2);
    if (((Camera.Parameters)localObject1).getSupportedFocusModes().contains("continuous-video")) {
      ((Camera.Parameters)localObject1).setFocusMode("continuous-video");
    }
    this.b.setParameters((Camera.Parameters)localObject1);
    if (!this.t)
    {
      this.s.clear();
      paramInt2 = ((c.a)localObject2).frameSize();
      paramInt1 = i1;
      while (paramInt1 < 3)
      {
        localObject1 = ByteBuffer.allocateDirect(paramInt2);
        this.s.add(((ByteBuffer)localObject1).array());
        this.b.addCallbackBuffer(((ByteBuffer)localObject1).array());
        paramInt1 += 1;
      }
      this.b.setPreviewCallbackWithBuffer(this);
    }
    this.b.startPreview();
  }
  
  /* Error */
  private void a(final int paramInt1, final int paramInt2, final int paramInt3, final v.a parama, final Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 284	com/superrtc/call/w:a	()V
    //   4: aload_0
    //   5: getfield 294	com/superrtc/call/w:b	Landroid/hardware/Camera;
    //   8: ifnull +14 -> 22
    //   11: new 437	java/lang/RuntimeException
    //   14: dup
    //   15: ldc_w 441
    //   18: invokespecial 442	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_0
    //   23: aload 5
    //   25: putfield 444	com/superrtc/call/w:e	Landroid/content/Context;
    //   28: aload_0
    //   29: aload 4
    //   31: putfield 113	com/superrtc/call/w:p	Lcom/superrtc/call/v$a;
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 446	com/superrtc/call/w:r	Z
    //   39: aload_0
    //   40: iload_1
    //   41: putfield 300	com/superrtc/call/w:j	I
    //   44: aload_0
    //   45: iload_2
    //   46: putfield 302	com/superrtc/call/w:k	I
    //   49: aload_0
    //   50: iload_3
    //   51: putfield 304	com/superrtc/call/w:l	I
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 448	com/superrtc/call/w:C	Z
    //   59: aload_0
    //   60: getfield 122	com/superrtc/call/w:x	Z
    //   63: ifne +4 -> 67
    //   66: return
    //   67: aload_0
    //   68: getfield 450	com/superrtc/call/w:B	Z
    //   71: ifne -5 -> 66
    //   74: aload_0
    //   75: getfield 109	com/superrtc/call/w:f	Ljava/lang/Object;
    //   78: astore 6
    //   80: aload 6
    //   82: monitorenter
    //   83: aload_0
    //   84: getfield 142	com/superrtc/call/w:q	Lcom/superrtc/call/w$a;
    //   87: ifnull +16 -> 103
    //   90: aload_0
    //   91: getfield 142	com/superrtc/call/w:q	Lcom/superrtc/call/w$a;
    //   94: aload_0
    //   95: getfield 140	com/superrtc/call/w:g	I
    //   98: invokeinterface 453 2 0
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 140	com/superrtc/call/w:g	I
    //   108: invokestatic 457	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   111: putfield 294	com/superrtc/call/w:b	Landroid/hardware/Camera;
    //   114: aload_0
    //   115: new 459	android/hardware/Camera$CameraInfo
    //   118: dup
    //   119: invokespecial 460	android/hardware/Camera$CameraInfo:<init>	()V
    //   122: putfield 462	com/superrtc/call/w:h	Landroid/hardware/Camera$CameraInfo;
    //   125: aload_0
    //   126: getfield 140	com/superrtc/call/w:g	I
    //   129: aload_0
    //   130: getfield 462	com/superrtc/call/w:h	Landroid/hardware/Camera$CameraInfo;
    //   133: invokestatic 466	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   136: aload 6
    //   138: monitorexit
    //   139: aload_0
    //   140: getfield 294	com/superrtc/call/w:b	Landroid/hardware/Camera;
    //   143: aload_0
    //   144: getfield 155	com/superrtc/call/w:a	Lcom/superrtc/call/t;
    //   147: invokevirtual 470	com/superrtc/call/t:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   150: invokevirtual 474	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   153: ldc -79
    //   155: new 179	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 476
    //   165: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: getfield 462	com/superrtc/call/w:h	Landroid/hardware/Camera$CameraInfo;
    //   172: getfield 479	android/hardware/Camera$CameraInfo:orientation	I
    //   175: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc_w 481
    //   181: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: invokespecial 483	com/superrtc/call/w:d	()I
    //   188: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 298	com/superrtc/call/Logging:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 294	com/superrtc/call/w:b	Landroid/hardware/Camera;
    //   201: aload_0
    //   202: getfield 135	com/superrtc/call/w:G	Landroid/hardware/Camera$ErrorCallback;
    //   205: invokevirtual 487	android/hardware/Camera:setErrorCallback	(Landroid/hardware/Camera$ErrorCallback;)V
    //   208: aload_0
    //   209: iload_1
    //   210: iload_2
    //   211: iload_3
    //   212: invokespecial 489	com/superrtc/call/w:a	(III)V
    //   215: aload 4
    //   217: iconst_1
    //   218: invokeinterface 494 2 0
    //   223: aload_0
    //   224: getfield 144	com/superrtc/call/w:t	Z
    //   227: ifeq +11 -> 238
    //   230: aload_0
    //   231: getfield 155	com/superrtc/call/w:a	Lcom/superrtc/call/t;
    //   234: aload_0
    //   235: invokevirtual 498	com/superrtc/call/t:startListening	(Lcom/superrtc/call/t$a;)V
    //   238: aload_0
    //   239: getfield 161	com/superrtc/call/w:d	Landroid/os/Handler;
    //   242: aload_0
    //   243: getfield 138	com/superrtc/call/w:H	Ljava/lang/Runnable;
    //   246: ldc2_w 499
    //   249: invokevirtual 504	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   252: pop
    //   253: return
    //   254: astore 5
    //   256: ldc -79
    //   258: ldc_w 506
    //   261: aload 5
    //   263: invokestatic 509	com/superrtc/call/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload_0
    //   267: invokespecial 511	com/superrtc/call/w:b	()V
    //   270: aload 4
    //   272: iconst_0
    //   273: invokeinterface 494 2 0
    //   278: aload_0
    //   279: getfield 142	com/superrtc/call/w:q	Lcom/superrtc/call/w$a;
    //   282: ifnull -216 -> 66
    //   285: aload_0
    //   286: getfield 142	com/superrtc/call/w:q	Lcom/superrtc/call/w$a;
    //   289: ldc_w 513
    //   292: invokeinterface 516 2 0
    //   297: return
    //   298: astore 7
    //   300: aload 6
    //   302: monitorexit
    //   303: aload 7
    //   305: athrow
    //   306: astore 6
    //   308: aload_0
    //   309: invokespecial 518	com/superrtc/call/w:f	()V
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 520	com/superrtc/call/w:w	I
    //   317: iconst_1
    //   318: iadd
    //   319: putfield 520	com/superrtc/call/w:w	I
    //   322: aload_0
    //   323: getfield 520	com/superrtc/call/w:w	I
    //   326: iconst_3
    //   327: if_icmpge +48 -> 375
    //   330: ldc -79
    //   332: ldc_w 522
    //   335: aload 6
    //   337: invokestatic 509	com/superrtc/call/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_0
    //   341: new 20	com/superrtc/call/w$13
    //   344: dup
    //   345: aload_0
    //   346: iload_1
    //   347: iload_2
    //   348: iload_3
    //   349: aload 4
    //   351: aload 5
    //   353: invokespecial 525	com/superrtc/call/w$13:<init>	(Lcom/superrtc/call/w;IIILcom/superrtc/call/v$a;Landroid/content/Context;)V
    //   356: putfield 527	com/superrtc/call/w:v	Ljava/lang/Runnable;
    //   359: aload_0
    //   360: getfield 161	com/superrtc/call/w:d	Landroid/os/Handler;
    //   363: aload_0
    //   364: getfield 527	com/superrtc/call/w:v	Ljava/lang/Runnable;
    //   367: ldc2_w 528
    //   370: invokevirtual 504	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   373: pop
    //   374: return
    //   375: aload_0
    //   376: iconst_0
    //   377: putfield 520	com/superrtc/call/w:w	I
    //   380: aload 6
    //   382: athrow
    //   383: astore 5
    //   385: ldc -79
    //   387: ldc_w 531
    //   390: aconst_null
    //   391: invokestatic 509	com/superrtc/call/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   394: new 437	java/lang/RuntimeException
    //   397: dup
    //   398: aload 5
    //   400: invokespecial 534	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   403: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	w
    //   0	404	1	paramInt1	int
    //   0	404	2	paramInt2	int
    //   0	404	3	paramInt3	int
    //   0	404	4	parama	v.a
    //   0	404	5	paramContext	Context
    //   306	75	6	localRuntimeException	RuntimeException
    //   298	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   139	153	254	java/lang/RuntimeException
    //   153	238	254	java/lang/RuntimeException
    //   238	253	254	java/lang/RuntimeException
    //   308	374	254	java/lang/RuntimeException
    //   375	383	254	java/lang/RuntimeException
    //   385	404	254	java/lang/RuntimeException
    //   83	103	298	finally
    //   103	139	298	finally
    //   300	303	298	finally
    //   74	83	306	java/lang/RuntimeException
    //   303	306	306	java/lang/RuntimeException
    //   139	153	383	java/io/IOException
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    int i1 = e();
    if (this.h.facing == 0) {
      if (i1 == 0)
      {
        paramArrayOfInt1[0] = (paramArrayOfInt3[0] * paramArrayOfInt1[0] / 10000);
        paramArrayOfInt2[0] = (paramArrayOfInt2[0] * paramArrayOfInt4[0] / 10000);
      }
    }
    do
    {
      do
      {
        return;
        if (i1 == 90)
        {
          i1 = paramArrayOfInt3[0];
          paramArrayOfInt3[0] = paramArrayOfInt4[0];
          paramArrayOfInt4[0] = i1;
          i1 = paramArrayOfInt1[0];
          paramArrayOfInt1[0] = (paramArrayOfInt2[0] * paramArrayOfInt3[0] / 10000);
          paramArrayOfInt2[0] = ((10000 - i1) * paramArrayOfInt4[0] / 10000);
          return;
        }
        if (i1 == 180)
        {
          paramArrayOfInt1[0] = ((10000 - paramArrayOfInt1[0]) * paramArrayOfInt3[0] / 10000);
          paramArrayOfInt2[0] = ((10000 - paramArrayOfInt2[0]) * paramArrayOfInt4[0] / 10000);
          return;
        }
      } while (i1 != 270);
      i1 = paramArrayOfInt3[0];
      paramArrayOfInt3[0] = paramArrayOfInt4[0];
      paramArrayOfInt4[0] = i1;
      i1 = paramArrayOfInt1[0];
      paramArrayOfInt1[0] = ((10000 - paramArrayOfInt2[0]) * paramArrayOfInt3[0] / 10000);
      paramArrayOfInt2[0] = (i1 * paramArrayOfInt4[0] / 10000);
      return;
      if (i1 == 0)
      {
        paramArrayOfInt1[0] = (paramArrayOfInt1[0] * paramArrayOfInt3[0] / 10000);
        paramArrayOfInt2[0] = (paramArrayOfInt2[0] * paramArrayOfInt4[0] / 10000);
        return;
      }
      if (i1 == 90)
      {
        i1 = paramArrayOfInt3[0];
        paramArrayOfInt3[0] = paramArrayOfInt4[0];
        paramArrayOfInt4[0] = i1;
        i1 = paramArrayOfInt1[0];
        paramArrayOfInt1[0] = (paramArrayOfInt2[0] * paramArrayOfInt3[0] / 10000);
        paramArrayOfInt2[0] = ((10000 - i1) * paramArrayOfInt4[0] / 10000);
        return;
      }
      if (i1 == 180)
      {
        paramArrayOfInt1[0] = ((10000 - paramArrayOfInt1[0]) * paramArrayOfInt3[0] / 10000);
        paramArrayOfInt2[0] = ((10000 - paramArrayOfInt2[0]) * paramArrayOfInt4[0] / 10000);
        return;
      }
    } while (i1 != 270);
    i1 = paramArrayOfInt3[0];
    paramArrayOfInt3[0] = paramArrayOfInt4[0];
    paramArrayOfInt4[0] = i1;
    i1 = paramArrayOfInt1[0];
    paramArrayOfInt1[0] = ((10000 - paramArrayOfInt2[0]) * paramArrayOfInt3[0] / 10000);
    paramArrayOfInt2[0] = (i1 * paramArrayOfInt4[0] / 10000);
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int paramInt1, int paramInt2)
  {
    int i1 = e();
    if (this.h.facing == 1)
    {
      paramArrayOfInt1[0] = (paramInt1 - paramArrayOfInt1[0]);
      if (i1 == 0)
      {
        paramArrayOfInt1[0] = (paramArrayOfInt3[0] * paramArrayOfInt1[0] / paramInt1);
        paramArrayOfInt2[0] = (paramArrayOfInt2[0] * paramArrayOfInt4[0] / paramInt2);
      }
    }
    do
    {
      do
      {
        return;
        if (i1 == 90)
        {
          i1 = paramArrayOfInt3[0];
          paramArrayOfInt3[0] = paramArrayOfInt4[0];
          paramArrayOfInt4[0] = i1;
          i1 = paramArrayOfInt1[0];
          paramArrayOfInt1[0] = (paramArrayOfInt2[0] * paramArrayOfInt3[0] / paramInt1);
          paramArrayOfInt2[0] = ((paramInt1 - i1) * paramArrayOfInt4[0] / paramInt2);
          return;
        }
        if (i1 == 180)
        {
          paramArrayOfInt1[0] = ((paramInt1 - paramArrayOfInt1[0]) * paramArrayOfInt3[0] / paramInt1);
          paramArrayOfInt2[0] = ((paramInt2 - paramArrayOfInt2[0]) * paramArrayOfInt4[0] / paramInt2);
          return;
        }
      } while (i1 != 270);
      i1 = paramArrayOfInt3[0];
      paramArrayOfInt3[0] = paramArrayOfInt4[0];
      paramArrayOfInt4[0] = i1;
      i1 = paramArrayOfInt1[0];
      paramArrayOfInt1[0] = ((paramInt2 - paramArrayOfInt2[0]) * paramArrayOfInt3[0] / paramInt1);
      paramArrayOfInt2[0] = (i1 * paramArrayOfInt4[0] / paramInt2);
      return;
      if (i1 == 0)
      {
        paramArrayOfInt1[0] = (paramArrayOfInt1[0] * paramArrayOfInt3[0] / paramInt1);
        paramArrayOfInt2[0] = (paramArrayOfInt2[0] * paramArrayOfInt4[0] / paramInt2);
        return;
      }
      if (i1 == 90)
      {
        i1 = paramArrayOfInt3[0];
        paramArrayOfInt3[0] = paramArrayOfInt4[0];
        paramArrayOfInt4[0] = i1;
        i1 = paramArrayOfInt1[0];
        paramArrayOfInt1[0] = (paramArrayOfInt2[0] * paramArrayOfInt3[0] / paramInt1);
        paramArrayOfInt2[0] = ((paramInt1 - i1) * paramArrayOfInt4[0] / paramInt2);
        return;
      }
      if (i1 == 180)
      {
        paramArrayOfInt1[0] = ((paramInt1 - paramArrayOfInt1[0]) * paramArrayOfInt3[0] / paramInt1);
        paramArrayOfInt2[0] = ((paramInt2 - paramArrayOfInt2[0]) * paramArrayOfInt4[0] / paramInt2);
        return;
      }
    } while (i1 != 270);
    i1 = paramArrayOfInt3[0];
    paramArrayOfInt3[0] = paramArrayOfInt4[0];
    paramArrayOfInt4[0] = i1;
    i1 = paramArrayOfInt1[0];
    paramArrayOfInt1[0] = ((paramInt1 - paramArrayOfInt2[0]) * paramArrayOfInt3[0] / paramInt1);
    paramArrayOfInt2[0] = (i1 * paramArrayOfInt4[0] / paramInt2);
  }
  
  private void b()
  {
    a();
    Logging.d("VideoCapturerAndroid", "stopCaptureOnCameraThread");
    if (this.v != null) {
      this.d.removeCallbacks(this.v);
    }
    this.w = 0;
    if (this.b == null) {
      Logging.e("VideoCapturerAndroid", "Calling stopCapture() for already stopped camera.");
    }
    do
    {
      do
      {
        return;
        this.a.stopListening();
        this.d.removeCallbacks(this.H);
        this.i.getAndResetFrameCount();
        Logging.d("VideoCapturerAndroid", "Stop preview.");
      } while (this.B);
      this.b.stopPreview();
      this.b.setPreviewCallbackWithBuffer(null);
      this.s.clear();
      this.m = null;
      Logging.d("VideoCapturerAndroid", "Release camera.");
      this.b.release();
      this.b = null;
    } while (this.q == null);
    this.q.onCameraClosed();
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    if (this.b == null)
    {
      Logging.e("VideoCapturerAndroid", "Calling onOutputFormatRequest() on stopped camera.");
      return;
    }
    Logging.d("VideoCapturerAndroid", "onOutputFormatRequestOnCameraThread: " + paramInt1 + "x" + paramInt2 + "@" + paramInt3);
    this.p.onOutputFormatRequest(paramInt1, paramInt2, paramInt3);
  }
  
  private static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private void c()
  {
    a();
    Logging.d("VideoCapturerAndroid", "switchCameraOnCameraThread");
    b();
    synchronized (this.f)
    {
      this.g = ((this.g + 1) % Camera.getNumberOfCameras());
      this.u = true;
      a(this.j, this.k, this.l, this.p, this.e);
      Logging.d("VideoCapturerAndroid", "switchCameraOnCameraThread done");
      return;
    }
  }
  
  public static w create(String paramString, a parama)
  {
    return create(paramString, parama, null);
  }
  
  public static w create(String paramString, a parama, e.a parama1)
  {
    int i1 = a(paramString);
    if (i1 == -1) {
      return null;
    }
    return new w(i1, parama, parama1);
  }
  
  private int d()
  {
    switch (((WindowManager)this.e.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  private int e()
  {
    int i2 = d();
    int i1 = i2;
    if (this.h.facing == 0) {
      i1 = 360 - i2;
    }
    return (i1 + this.h.orientation) % 360;
  }
  
  private void f()
  {
    if (this.I != null) {
      this.I.onError(com.superrtc.sdk.e.a.a);
    }
  }
  
  public void changeCaptureFormat(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        if (w.h(w.this)) {
          return;
        }
        w.b(w.this, paramInt1, paramInt2, paramInt3);
      }
    });
  }
  
  public void dispose()
  {
    Logging.d("VideoCapturerAndroid", "release");
    if (isDisposed()) {
      throw new IllegalStateException("Already released");
    }
    u.invokeUninterruptibly(this.d, new Runnable()
    {
      public void run()
      {
        if (w.d(w.this) != null) {
          throw new IllegalStateException("Release called while camera is running");
        }
      }
    });
    this.a.dispose();
    this.c = null;
  }
  
  public void enableCameraThread()
  {
    if (this.x) {
      return;
    }
    this.x = true;
    Logging.d("VideoCapturerAndroid", "enableCameraThread");
    this.d.post(new Runnable()
    {
      public void run()
      {
        w.a(w.this, w.j(w.this), w.k(w.this), w.l(w.this), w.m(w.this), w.n(w.this));
      }
    });
    Logging.d("VideoCapturerAndroid", "enableCameraThread done");
  }
  
  public c.a getCaptureFormat()
  {
    return this.m;
  }
  
  public int getCurrentCameraId()
  {
    synchronized (this.f)
    {
      int i1 = this.g;
      return i1;
    }
  }
  
  public List<c.a> getSupportedFormats()
  {
    return c.getSupportedFormats(getCurrentCameraId());
  }
  
  public boolean getSupportedGetCameraFormats()
  {
    return this.y;
  }
  
  public t getSurfaceTextureHelper()
  {
    return this.a;
  }
  
  public void handleFlashLight(boolean paramBoolean)
  {
    if (this.b == null)
    {
      Logging.e("VideoCapturerAndroid", "camera is not Initialized");
      return;
    }
    Camera.Parameters localParameters = this.b.getParameters();
    if (paramBoolean) {
      localParameters.setFlashMode("torch");
    }
    for (;;)
    {
      this.b.setParameters(localParameters);
      return;
      localParameters.setFlashMode("off");
    }
  }
  
  public void handleFocusMetering(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Object localObject1 = new int[1];
    localObject1[0] = paramInt1;
    Object localObject2 = new int[1];
    localObject2[0] = paramInt2;
    final Object localObject3 = new int[1];
    localObject3[0] = paramInt3;
    Object localObject4 = new int[1];
    localObject4[0] = paramInt4;
    a((int[])localObject1, (int[])localObject2, (int[])localObject3, (int[])localObject4);
    paramInt1 = localObject1[0];
    paramInt2 = localObject2[0];
    paramInt3 = localObject3[0];
    paramInt4 = localObject4[0];
    Logging.e("VideoCapturerAndroid", "remote focus x:" + paramInt1 + ", y:" + paramInt2 + ",width:" + paramInt3 + ", height:" + paramInt4);
    localObject4 = a(paramInt1, paramInt2, 1.0F, paramInt3, paramInt4);
    localObject1 = a(paramInt1, paramInt2, 1.5F, paramInt3, paramInt4);
    localObject2 = this.b.getParameters();
    localObject3 = ((Camera.Parameters)localObject2).getFocusMode();
    if (((Camera.Parameters)localObject2).getMaxNumFocusAreas() > 0)
    {
      this.b.cancelAutoFocus();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area((Rect)localObject4, 800));
      ((Camera.Parameters)localObject2).setFocusAreas(localArrayList);
      if (((Camera.Parameters)localObject2).getMaxNumMeteringAreas() <= 0) {
        break label307;
      }
      localObject4 = new ArrayList();
      ((List)localObject4).add(new Camera.Area((Rect)localObject1, 800));
      ((Camera.Parameters)localObject2).setMeteringAreas((List)localObject4);
    }
    for (;;)
    {
      this.b.setParameters((Camera.Parameters)localObject2);
      this.b.autoFocus(new Camera.AutoFocusCallback()
      {
        public void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          Logging.e("VideoCapturerAndroid", "onAutoFocus ok");
          Camera.Parameters localParameters = paramAnonymousCamera.getParameters();
          localParameters.setFocusMode(localObject3);
          paramAnonymousCamera.setParameters(localParameters);
        }
      });
      return;
      Logging.e("VideoCapturerAndroid", "focus areas not supported");
      break;
      label307:
      Logging.e("VideoCapturerAndroid", "metering areas not supported");
    }
  }
  
  public void handleManualFocus(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.b == null)
    {
      Logging.e("VideoCapturerAndroid", "camera is not Initialized");
      return;
    }
    Object localObject1 = new int[1];
    localObject1[0] = ((int)paramFloat1);
    Object localObject2 = new int[1];
    localObject2[0] = ((int)paramFloat2);
    final Object localObject3 = new int[1];
    localObject3[0] = paramInt1;
    Object localObject4 = new int[1];
    localObject4[0] = paramInt2;
    a((int[])localObject1, (int[])localObject2, (int[])localObject3, (int[])localObject4, paramInt3, paramInt4);
    paramFloat1 = localObject1[0];
    paramFloat2 = localObject2[0];
    paramInt1 = localObject3[0];
    paramInt2 = localObject4[0];
    Logging.e("VideoCapturerAndroid", "Manual focus x:" + paramFloat1 + ", y:" + paramFloat2 + ", width:" + paramInt1 + ", height:" + paramInt2);
    localObject4 = a(paramFloat1, paramFloat2, 1.0F, paramInt1, paramInt2);
    localObject1 = a(paramFloat1, paramFloat2, 1.5F, paramInt1, paramInt2);
    localObject2 = this.b.getParameters();
    localObject3 = ((Camera.Parameters)localObject2).getFocusMode();
    if (((Camera.Parameters)localObject2).getMaxNumFocusAreas() > 0)
    {
      this.b.cancelAutoFocus();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area((Rect)localObject4, 800));
      ((Camera.Parameters)localObject2).setFocusAreas(localArrayList);
      if (((Camera.Parameters)localObject2).getMaxNumMeteringAreas() <= 0) {
        break label327;
      }
      localObject4 = new ArrayList();
      ((List)localObject4).add(new Camera.Area((Rect)localObject1, 800));
      ((Camera.Parameters)localObject2).setMeteringAreas((List)localObject4);
    }
    for (;;)
    {
      this.b.setParameters((Camera.Parameters)localObject2);
      this.b.autoFocus(new Camera.AutoFocusCallback()
      {
        public void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          Logging.e("VideoCapturerAndroid", "onAutoFocus ok");
          Camera.Parameters localParameters = paramAnonymousCamera.getParameters();
          localParameters.setFocusMode(localObject3);
          paramAnonymousCamera.setParameters(localParameters);
        }
      });
      return;
      Logging.e("VideoCapturerAndroid", "focus areas not supported");
      break;
      label327:
      Logging.e("VideoCapturerAndroid", "metering areas not supported");
    }
  }
  
  public void handleManualZoom(boolean paramBoolean, int paramInt)
  {
    if (this.b == null)
    {
      Logging.e("VideoCapturerAndroid", "camera is not Initialized");
      return;
    }
    Camera.Parameters localParameters = this.b.getParameters();
    if (localParameters.isZoomSupported())
    {
      int i2 = localParameters.getMaxZoom();
      int i1 = localParameters.getZoom();
      if (paramBoolean)
      {
        i1 += paramInt;
        Logging.e("VideoCapturerAndroid", String.format("zoom camera max:%s, zoom:%s, scale:%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(paramInt) }));
        if (i1 <= i2) {
          break label123;
        }
        paramInt = i2;
      }
      for (;;)
      {
        localParameters.setZoom(paramInt);
        this.b.setParameters(localParameters);
        return;
        i1 -= paramInt;
        break;
        label123:
        paramInt = i1;
        if (i1 < 0) {
          paramInt = 0;
        }
      }
    }
    Logging.e("VideoCapturerAndroid", "zoom not supported");
  }
  
  public void handleZoom(Float paramFloat)
  {
    if (this.b == null) {
      Logging.e("VideoCapturerAndroid", "camera is not Initialized");
    }
    Camera.Parameters localParameters = this.b.getParameters();
    int i1;
    int i3;
    if (localParameters.isZoomSupported())
    {
      int i2 = localParameters.getMaxZoom();
      i1 = localParameters.getZoom();
      i3 = paramFloat.intValue();
      Logging.e("VideoCapturerAndroid", "handleZoom curzoom:" + i1 + ",last:" + this.F + " ,factor:" + i3);
      if (this.F == 0)
      {
        i1 *= i3;
        if (i1 <= i2) {
          break label177;
        }
        i1 = i2;
      }
    }
    for (;;)
    {
      localParameters.setZoom(i1);
      this.b.setParameters(localParameters);
      this.F = paramFloat.intValue();
      return;
      if (this.F < i3)
      {
        i1 *= i3 / this.F;
        break;
      }
      i1 /= this.F / i3;
      break;
      label177:
      if (i1 < 1)
      {
        i1 = 1;
        continue;
        Logging.e("VideoCapturerAndroid", "zoom not supported");
        return;
      }
    }
  }
  
  public void inputExternalVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.C) || (!this.B)) {}
    long l1;
    do
    {
      return;
      l1 = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
      if ((this.q != null) && (!this.r))
      {
        this.q.onFirstFrameAvailable();
        this.r = true;
      }
      this.i.addFrame();
    } while (this.p == null);
    this.p.onByteBufferFrameCaptured(paramArrayOfByte, paramInt1, paramInt2, paramInt3, l1);
  }
  
  public boolean isCapturingToTexture()
  {
    return this.t;
  }
  
  public boolean isDisposed()
  {
    return this.c == null;
  }
  
  public void onOutputFormatRequest(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        if (w.h(w.this)) {
          return;
        }
        w.a(w.this, paramInt1, paramInt2, paramInt3);
      }
    });
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    a();
    if ((this.b == null) || (!this.s.contains(paramArrayOfByte))) {
      return;
    }
    if (this.b != paramCamera) {
      throw new RuntimeException("Unexpected camera in callback!");
    }
    long l1 = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
    if ((this.q != null) && (!this.r))
    {
      this.q.onFirstFrameAvailable();
      this.r = true;
    }
    this.i.addFrame();
    int i1 = e();
    if (this.z != null) {}
    synchronized (this.z)
    {
      this.z.onProcessData(paramArrayOfByte, paramCamera, this.m.a, this.m.b, i1);
      if (this.E) {
        i1 = this.D;
      }
      this.p.onByteBufferFrameCaptured(paramArrayOfByte, this.m.a, this.m.b, i1, l1);
      this.b.addCallbackBuffer(paramArrayOfByte);
      return;
    }
  }
  
  public void onTextureFrameAvailable(int paramInt, float[] paramArrayOfFloat, long paramLong)
  {
    if (this.b == null) {
      throw new RuntimeException("onTextureFrameAvailable() called after stopCapture().");
    }
    a();
    if (this.u)
    {
      this.a.returnTextureFrame();
      this.u = false;
      return;
    }
    if ((this.q != null) && (!this.r))
    {
      this.q.onFirstFrameAvailable();
      this.r = true;
    }
    int i1 = e();
    if (this.h.facing == 1) {
      paramArrayOfFloat = o.multiplyMatrices(paramArrayOfFloat, o.horizontalFlipMatrix());
    }
    for (;;)
    {
      if (this.A != null) {}
      synchronized (this.A)
      {
        this.A.onDrawFrame(paramInt, this.m.a, this.m.b, paramArrayOfFloat, i1);
        this.i.addFrame();
        this.p.onTextureFrameCaptured(this.m.a, this.m.b, paramInt, paramArrayOfFloat, i1, paramLong);
        return;
      }
    }
  }
  
  public void printStackTrace()
  {
    if (this.c != null)
    {
      StackTraceElement[] arrayOfStackTraceElement = this.c.getStackTrace();
      if (arrayOfStackTraceElement.length > 0)
      {
        Logging.d("VideoCapturerAndroid", "VideoCapturerAndroid stacks trace:");
        int i2 = arrayOfStackTraceElement.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Logging.d("VideoCapturerAndroid", arrayOfStackTraceElement[i1].toString());
          i1 += 1;
        }
      }
    }
  }
  
  public void setCameraDataProcessor(e parame)
  {
    if (this.z != null) {
      synchronized (this.z)
      {
        this.z = parame;
        return;
      }
    }
    this.z = parame;
  }
  
  public void setEnableCamera(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setEnableCameragetsuppoted(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setEnableExternalVideoData(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void setGlTextureProcessor(d paramd)
  {
    if (this.A != null) {
      synchronized (this.A)
      {
        this.A = paramd;
        return;
      }
    }
    this.A = paramd;
  }
  
  public void setRotation(int paramInt)
  {
    this.E = true;
    this.D = paramInt;
  }
  
  public void setRtcListener(e parame)
  {
    this.I = parame;
  }
  
  public void startCapture(final int paramInt1, final int paramInt2, final int paramInt3, final Context paramContext, final v.a parama)
  {
    Logging.d("VideoCapturerAndroid", "startCapture requested: " + paramInt1 + "x" + paramInt2 + "@" + paramInt3);
    if (paramContext == null) {
      throw new RuntimeException("applicationContext not set.");
    }
    if (parama == null) {
      throw new RuntimeException("frameObserver not set.");
    }
    this.d.post(new Runnable()
    {
      public void run()
      {
        w.a(w.this, paramInt1, paramInt2, paramInt3, parama, paramContext);
      }
    });
  }
  
  public void stopCapture()
    throws InterruptedException
  {
    Logging.d("VideoCapturerAndroid", "stopCapture");
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.d.post(new Runnable()
    {
      public void run()
      {
        w.i(w.this);
        localCountDownLatch.countDown();
      }
    });
    localCountDownLatch.await();
    Logging.d("VideoCapturerAndroid", "stopCapture done");
  }
  
  public void switchCamera(final c paramc)
  {
    if (this.B) {}
    do
    {
      return;
      if (Camera.getNumberOfCameras() >= 2) {
        break;
      }
    } while (paramc == null);
    paramc.onCameraSwitchError("No camera to switch to.");
    return;
    synchronized (this.n)
    {
      if (this.o)
      {
        Logging.w("VideoCapturerAndroid", "Ignoring camera switch request.");
        if (paramc != null) {
          paramc.onCameraSwitchError("Pending camera switch already in progress.");
        }
        return;
      }
    }
    this.o = true;
    this.d.post(new Runnable()
    {
      public void run()
      {
        boolean bool = true;
        if (w.d(w.this) == null)
        {
          if (paramc != null) {
            paramc.onCameraSwitchError("Camera is stopped.");
          }
          return;
        }
        w.e(w.this);
        for (;;)
        {
          synchronized (w.f(w.this))
          {
            w.a(w.this, false);
            if (paramc == null) {
              break;
            }
            ??? = paramc;
            if (w.g(w.this).facing == 1)
            {
              ((w.c)???).onCameraSwitchDone(bool);
              return;
            }
          }
          bool = false;
        }
      }
    });
  }
  
  public void takeCameraPicture(final g paramg)
  {
    Log.d("VideoCapturerAndroid", "takeCameraPicture -- start -1-");
    if (this.b != null) {
      this.b.takePicture(new Camera.ShutterCallback()
      {
        public void onShutter()
        {
          Logging.d("ShutterCallback", "...onShutter...");
        }
      }, null, new Camera.PictureCallback()
      {
        public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          Log.d("VideoCapturerAndroid", "takeCameraPicture -- start -2-");
          Logging.d("VideoCapturerAndroid", "takeCameraPicture -- onPictureTaken start --");
          int i = w.o(w.this);
          if (Environment.getExternalStorageState().equals("mounted")) {}
          for (String str = w.n(w.this).getExternalFilesDir("").getAbsolutePath() + "/RTC_Camera_picture.jpg";; str = w.n(w.this).getFilesDir().getPath() + "/RTC_Camera_picture.jpg")
          {
            paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            Object localObject = new Matrix();
            ((Matrix)localObject).reset();
            ((Matrix)localObject).postRotate(i);
            paramAnonymousArrayOfByte = Bitmap.createBitmap(paramAnonymousArrayOfByte, 0, 0, paramAnonymousArrayOfByte.getWidth(), paramAnonymousArrayOfByte.getHeight(), (Matrix)localObject, true);
            localObject = new File(str);
            try
            {
              localObject = new FileOutputStream((File)localObject);
              paramAnonymousArrayOfByte.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
              ((FileOutputStream)localObject).flush();
              ((FileOutputStream)localObject).close();
              Logging.d("VideoCapturerAndroid", "takeCameraPicture -- onPictureTaken end --");
              Log.d("VideoCapturerAndroid", "takeCameraPicture -- end -1-");
              paramg.onDone(str);
              return;
            }
            catch (FileNotFoundException paramAnonymousArrayOfByte)
            {
              paramAnonymousArrayOfByte.printStackTrace();
              return;
            }
            catch (IOException paramAnonymousArrayOfByte)
            {
              Logging.d("onPictureTaken", paramAnonymousArrayOfByte.toString());
              return;
            }
            finally
            {
              Log.d("VideoCapturerAndroid", "takeCameraPicture -- end -2-");
              paramAnonymousCamera.startPreview();
            }
          }
        }
      });
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCameraClosed();
    
    public abstract void onCameraError(String paramString);
    
    public abstract void onCameraFreezed(String paramString);
    
    public abstract void onCameraOpening(int paramInt);
    
    public abstract void onFirstFrameAvailable();
  }
  
  private static class b
  {
    private int a = 0;
    private final u.c b = new u.c();
    
    b()
    {
      this.b.detachThread();
    }
    
    public void addFrame()
    {
      this.b.checkIsOnValidThread();
      this.a += 1;
    }
    
    public int getAndResetFrameCount()
    {
      this.b.checkIsOnValidThread();
      int i = this.a;
      this.a = 0;
      return i;
    }
  }
  
  public static abstract interface c
  {
    public abstract void onCameraSwitchDone(boolean paramBoolean);
    
    public abstract void onCameraSwitchError(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void onDrawFrame(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, int paramInt4);
  }
  
  public static abstract interface e
  {
    public abstract void onProcessData(byte[] paramArrayOfByte, Camera paramCamera, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void setResolution(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */