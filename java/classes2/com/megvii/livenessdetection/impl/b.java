package com.megvii.livenessdetection.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import com.megvii.a.a.d;
import com.megvii.livenessdetection.DetectionConfig;
import com.megvii.livenessdetection.DetectionFrame;
import com.megvii.livenessdetection.Detector.DetectionType;
import com.megvii.livenessdetection.a.b.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  extends DetectionFrame
{
  private int a;
  private int b;
  private Detector.DetectionType c;
  private byte[] d;
  private int e;
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Detector.DetectionType paramDetectionType)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramInt3;
    System.currentTimeMillis();
    this.c = paramDetectionType;
    this.d = paramArrayOfByte;
  }
  
  private byte[] a(int paramInt, Rect paramRect)
  {
    try
    {
      paramRect = a(paramInt, paramRect, 80);
      return paramRect;
    }
    finally
    {
      paramRect = finally;
      throw paramRect;
    }
  }
  
  private byte[] a(int paramInt1, Rect paramRect, int paramInt2)
  {
    try
    {
      boolean bool = hasFace();
      if (!bool) {
        paramRect = null;
      }
      for (;;)
      {
        return paramRect;
        Object localObject4 = new YuvImage(this.d, 17, this.a, this.b, null);
        Object localObject3 = new ByteArrayOutputStream();
        Object localObject2 = new Matrix();
        ((Matrix)localObject2).postRotate(360 - this.e, 0.5F, 0.5F);
        Object localObject1 = new RectF();
        ((Matrix)localObject2).mapRect((RectF)localObject1, this.mFaceInfo.b);
        localObject2 = new Rect();
        ((Rect)localObject2).left = ((int)(((RectF)localObject1).left * this.a));
        ((Rect)localObject2).right = ((int)(((RectF)localObject1).right * this.a));
        ((Rect)localObject2).top = ((int)(((RectF)localObject1).top * this.b));
        ((Rect)localObject2).bottom = ((int)(((RectF)localObject1).bottom * this.b));
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(1.5F, 1.5F, ((Rect)localObject2).centerX(), ((Rect)localObject2).centerY());
        localObject1 = new RectF();
        localMatrix.mapRect((RectF)localObject1, new RectF((Rect)localObject2));
        ((RectF)localObject1).left = Math.max(0.0F, ((RectF)localObject1).left);
        ((RectF)localObject1).top = Math.max(0.0F, ((RectF)localObject1).top);
        ((RectF)localObject1).right = Math.min(((RectF)localObject1).right, this.a);
        ((RectF)localObject1).bottom = Math.min(((RectF)localObject1).bottom, this.b);
        ((YuvImage)localObject4).compressToJpeg(new Rect((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom), paramInt2, (OutputStream)localObject3);
        try
        {
          ((ByteArrayOutputStream)localObject3).close();
          localObject3 = ((ByteArrayOutputStream)localObject3).toByteArray();
          localObject3 = BitmapFactory.decodeByteArray((byte[])localObject3, 0, localObject3.length);
          localObject4 = new Matrix();
          ((Matrix)localObject4).postRotate(this.e);
          if (paramInt1 != -1)
          {
            f1 = Math.max(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight()) / paramInt1;
            if (f1 > 1.0F) {
              ((Matrix)localObject4).postScale(1.0F / f1, 1.0F / f1);
            }
          }
          localObject3 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject4, true);
          float f1 = ((Rect)localObject2).centerX();
          float f2 = ((RectF)localObject1).left;
          float f3 = ((Rect)localObject2).centerY();
          float f4 = ((RectF)localObject1).top;
          localObject2 = new Matrix();
          ((Matrix)localObject2).setRotate(this.e, 0.5F, 0.5F);
          localObject4 = new float[2];
          ((Matrix)localObject2).mapPoints((float[])localObject4, new float[] { (f1 - f2) / ((RectF)localObject1).width(), (f3 - f4) / ((RectF)localObject1).height() });
          f1 = localObject4[0] * ((Bitmap)localObject3).getWidth();
          f2 = localObject4[1] * ((Bitmap)localObject3).getHeight();
          f3 = Math.max(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight()) / 1.5F;
          localObject1 = paramRect;
          if (paramRect == null) {
            localObject1 = new Rect();
          }
          ((Rect)localObject1).left = ((int)(f1 - f3 / 2.0F));
          ((Rect)localObject1).top = ((int)(f2 - f3 / 2.0F));
          ((Rect)localObject1).right = ((int)(f1 + f3 / 2.0F));
          ((Rect)localObject1).bottom = ((int)(f3 / 2.0F + f2));
          paramRect = com.megvii.a.a.b.a((Rect)localObject1);
          localObject1 = new ByteArrayOutputStream();
          ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, paramInt2, (OutputStream)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            try
            {
              ((ByteArrayOutputStream)localObject1).close();
              paramRect = EncodeImpl.a(((ByteArrayOutputStream)localObject1).toByteArray(), false, false, 1824058797, paramRect);
            }
            catch (IOException paramRect)
            {
              paramRect = null;
            }
            localIOException = localIOException;
            d.a(localIOException.toString());
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  private byte[] b(int paramInt1, Rect paramRect, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 46	android/graphics/YuvImage
    //   5: dup
    //   6: aload_0
    //   7: getfield 33	com/megvii/livenessdetection/impl/b:d	[B
    //   10: bipush 17
    //   12: aload_0
    //   13: getfield 19	com/megvii/livenessdetection/impl/b:a	I
    //   16: aload_0
    //   17: getfield 21	com/megvii/livenessdetection/impl/b:b	I
    //   20: aconst_null
    //   21: invokespecial 49	android/graphics/YuvImage:<init>	([BIII[I)V
    //   24: astore 6
    //   26: new 51	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 52	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 5
    //   35: aload 6
    //   37: new 78	android/graphics/Rect
    //   40: dup
    //   41: iconst_0
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 19	com/megvii/livenessdetection/impl/b:a	I
    //   47: aload_0
    //   48: getfield 21	com/megvii/livenessdetection/impl/b:b	I
    //   51: invokespecial 127	android/graphics/Rect:<init>	(IIII)V
    //   54: iload_3
    //   55: aload 5
    //   57: invokevirtual 131	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   60: pop
    //   61: aload 5
    //   63: invokevirtual 134	java/io/ByteArrayOutputStream:close	()V
    //   66: aload 5
    //   68: invokevirtual 138	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   71: astore 5
    //   73: aload 5
    //   75: iconst_0
    //   76: aload 5
    //   78: arraylength
    //   79: invokestatic 144	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   82: astore 5
    //   84: new 54	android/graphics/Matrix
    //   87: dup
    //   88: invokespecial 55	android/graphics/Matrix:<init>	()V
    //   91: astore 6
    //   93: aload 6
    //   95: aload_0
    //   96: getfield 23	com/megvii/livenessdetection/impl/b:e	I
    //   99: i2f
    //   100: invokevirtual 147	android/graphics/Matrix:postRotate	(F)Z
    //   103: pop
    //   104: iload_1
    //   105: iconst_m1
    //   106: if_icmpeq +43 -> 149
    //   109: aload 5
    //   111: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   114: aload 5
    //   116: invokevirtual 155	android/graphics/Bitmap:getHeight	()I
    //   119: invokestatic 158	java/lang/Math:max	(II)I
    //   122: i2f
    //   123: iload_1
    //   124: i2f
    //   125: fdiv
    //   126: fstore 4
    //   128: fload 4
    //   130: fconst_1
    //   131: fcmpl
    //   132: ifle +17 -> 149
    //   135: aload 6
    //   137: fconst_1
    //   138: fload 4
    //   140: fdiv
    //   141: fconst_1
    //   142: fload 4
    //   144: fdiv
    //   145: invokevirtual 161	android/graphics/Matrix:postScale	(FF)Z
    //   148: pop
    //   149: aload 5
    //   151: iconst_0
    //   152: iconst_0
    //   153: aload 5
    //   155: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   158: aload 5
    //   160: invokevirtual 155	android/graphics/Bitmap:getHeight	()I
    //   163: aload 6
    //   165: iconst_1
    //   166: invokestatic 165	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   169: astore 6
    //   171: aload_2
    //   172: astore 5
    //   174: aload_2
    //   175: ifnonnull +12 -> 187
    //   178: new 78	android/graphics/Rect
    //   181: dup
    //   182: invokespecial 79	android/graphics/Rect:<init>	()V
    //   185: astore 5
    //   187: aload_0
    //   188: invokevirtual 44	com/megvii/livenessdetection/impl/b:hasFace	()Z
    //   191: ifeq +95 -> 286
    //   194: aload 5
    //   196: aload_0
    //   197: getfield 67	com/megvii/livenessdetection/impl/b:mFaceInfo	Lcom/megvii/livenessdetection/a/b;
    //   200: getfield 72	com/megvii/livenessdetection/a/b:b	Landroid/graphics/RectF;
    //   203: getfield 83	android/graphics/RectF:left	F
    //   206: aload 6
    //   208: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   211: i2f
    //   212: fmul
    //   213: f2i
    //   214: putfield 85	android/graphics/Rect:left	I
    //   217: aload 5
    //   219: aload_0
    //   220: getfield 67	com/megvii/livenessdetection/impl/b:mFaceInfo	Lcom/megvii/livenessdetection/a/b;
    //   223: getfield 72	com/megvii/livenessdetection/a/b:b	Landroid/graphics/RectF;
    //   226: getfield 93	android/graphics/RectF:top	F
    //   229: aload 6
    //   231: invokevirtual 155	android/graphics/Bitmap:getHeight	()I
    //   234: i2f
    //   235: fmul
    //   236: f2i
    //   237: putfield 95	android/graphics/Rect:top	I
    //   240: aload 5
    //   242: aload_0
    //   243: getfield 67	com/megvii/livenessdetection/impl/b:mFaceInfo	Lcom/megvii/livenessdetection/a/b;
    //   246: getfield 72	com/megvii/livenessdetection/a/b:b	Landroid/graphics/RectF;
    //   249: getfield 88	android/graphics/RectF:right	F
    //   252: aload 6
    //   254: invokevirtual 152	android/graphics/Bitmap:getWidth	()I
    //   257: i2f
    //   258: fmul
    //   259: f2i
    //   260: putfield 90	android/graphics/Rect:right	I
    //   263: aload 5
    //   265: aload_0
    //   266: getfield 67	com/megvii/livenessdetection/impl/b:mFaceInfo	Lcom/megvii/livenessdetection/a/b;
    //   269: getfield 72	com/megvii/livenessdetection/a/b:b	Landroid/graphics/RectF;
    //   272: getfield 98	android/graphics/RectF:bottom	F
    //   275: aload 6
    //   277: invokevirtual 155	android/graphics/Bitmap:getHeight	()I
    //   280: i2f
    //   281: fmul
    //   282: f2i
    //   283: putfield 100	android/graphics/Rect:bottom	I
    //   286: new 51	java/io/ByteArrayOutputStream
    //   289: dup
    //   290: invokespecial 52	java/io/ByteArrayOutputStream:<init>	()V
    //   293: astore_2
    //   294: aload 6
    //   296: getstatic 191	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   299: iload_3
    //   300: aload_2
    //   301: invokevirtual 195	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   304: pop
    //   305: aload_2
    //   306: invokevirtual 134	java/io/ByteArrayOutputStream:close	()V
    //   309: aload_2
    //   310: invokevirtual 138	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   313: astore 6
    //   315: aload 6
    //   317: astore_2
    //   318: aload_0
    //   319: invokevirtual 44	com/megvii/livenessdetection/impl/b:hasFace	()Z
    //   322: ifeq +18 -> 340
    //   325: aload 6
    //   327: iconst_0
    //   328: iconst_0
    //   329: ldc -60
    //   331: aload 5
    //   333: invokestatic 185	com/megvii/a/a/b:a	(Landroid/graphics/Rect;)Ljava/lang/String;
    //   336: invokestatic 201	com/megvii/livenessdetection/impl/EncodeImpl:a	([BZZILjava/lang/String;)[B
    //   339: astore_2
    //   340: aload_0
    //   341: monitorexit
    //   342: aload_2
    //   343: areturn
    //   344: astore 6
    //   346: aload 6
    //   348: invokevirtual 205	java/io/IOException:toString	()Ljava/lang/String;
    //   351: invokestatic 210	com/megvii/a/a/d:a	(Ljava/lang/String;)V
    //   354: goto -288 -> 66
    //   357: astore_2
    //   358: aload_0
    //   359: monitorexit
    //   360: aload_2
    //   361: athrow
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_2
    //   365: goto -25 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	b
    //   0	368	1	paramInt1	int
    //   0	368	2	paramRect	Rect
    //   0	368	3	paramInt2	int
    //   126	17	4	f	float
    //   33	299	5	localObject1	Object
    //   24	302	6	localObject2	Object
    //   344	3	6	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   61	66	344	java/io/IOException
    //   2	61	357	finally
    //   61	66	357	finally
    //   66	104	357	finally
    //   109	128	357	finally
    //   135	149	357	finally
    //   149	171	357	finally
    //   178	187	357	finally
    //   187	286	357	finally
    //   286	305	357	finally
    //   305	315	357	finally
    //   318	340	357	finally
    //   346	354	357	finally
    //   305	315	362	java/io/IOException
    //   318	340	362	java/io/IOException
  }
  
  public final Detector.DetectionType a()
  {
    return this.c;
  }
  
  public final void a(String paramString, DetectionConfig paramDetectionConfig, com.megvii.a.a.b paramb)
  {
    this.mFaceInfo = b.a.a(paramString);
    paramb.a(this.mFaceInfo);
  }
  
  public final boolean a(DetectionFrame paramDetectionFrame)
  {
    if (this.mFaceInfo == null) {}
    for (float f = 0.0F; (paramDetectionFrame == null) || (!paramDetectionFrame.hasFace()) || (f > paramDetectionFrame.getFaceInfo().w); f = this.mFaceInfo.w) {
      return true;
    }
    return false;
  }
  
  public final byte[] getCroppedFaceImageData()
  {
    try
    {
      byte[] arrayOfByte = a(-1, null);
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final byte[] getCroppedFaceImageData(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = a(paramInt, null);
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final byte[] getCroppedFaceImageData(int paramInt, Rect paramRect)
  {
    return a(paramInt, paramRect);
  }
  
  public final byte[] getCroppedFaceImageData(Rect paramRect)
  {
    return a(-1, paramRect);
  }
  
  public final byte[] getEncodedFaceImageData(int paramInt1, int paramInt2, Rect paramRect)
  {
    return EncodeImpl.a(getCroppedFaceImageData(paramInt2, paramRect), true, true, paramInt1);
  }
  
  public final byte[] getImageData(Rect paramRect, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (((paramBoolean2) || (paramBoolean3)) && (paramInt3 < 0)) {
      return null;
    }
    if ((paramInt1 < 0) || (paramInt1 > 100)) {
      return null;
    }
    if (paramBoolean1)
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        return EncodeImpl.a(a(paramInt2, paramRect, paramInt1), paramBoolean2, paramBoolean3, paramInt3);
        paramInt2 = -1;
      }
    }
    if (paramInt2 > 0) {}
    for (;;)
    {
      return EncodeImpl.a(b(paramInt2, paramRect, paramInt1), paramBoolean2, paramBoolean3, paramInt3);
      paramInt2 = -1;
    }
  }
  
  public final int getImageHeight()
  {
    return this.b;
  }
  
  public final int getImageWidth()
  {
    return this.a;
  }
  
  public final int getRotation()
  {
    return this.e;
  }
  
  public final byte[] getYUVData()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/livenessdetection/impl/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */