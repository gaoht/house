package com.megvii.livenessdetection.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.megvii.a.a.b;
import com.megvii.livenessdetection.DetectionConfig;
import com.megvii.livenessdetection.DetectionFrame;
import com.megvii.livenessdetection.a.b.a;

public final class a
  extends DetectionFrame
{
  private Bitmap a;
  private byte[] b;
  
  public a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  private boolean b()
  {
    return (this.a != null) && (!this.a.isRecycled()) && (Bitmap.Config.ARGB_8888.equals(this.a.getConfig()));
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/megvii/livenessdetection/impl/a:mFaceInfo	Lcom/megvii/livenessdetection/a/b;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 43	com/megvii/livenessdetection/impl/a:mFaceInfo	Lcom/megvii/livenessdetection/a/b;
    //   20: getfield 48	com/megvii/livenessdetection/a/b:b	Landroid/graphics/RectF;
    //   23: astore 6
    //   25: aload_0
    //   26: getfield 15	com/megvii/livenessdetection/impl/a:a	Landroid/graphics/Bitmap;
    //   29: invokevirtual 52	android/graphics/Bitmap:getWidth	()I
    //   32: istore_2
    //   33: aload_0
    //   34: getfield 15	com/megvii/livenessdetection/impl/a:a	Landroid/graphics/Bitmap;
    //   37: invokevirtual 55	android/graphics/Bitmap:getHeight	()I
    //   40: istore_3
    //   41: aload_0
    //   42: getfield 15	com/megvii/livenessdetection/impl/a:a	Landroid/graphics/Bitmap;
    //   45: astore 7
    //   47: aload 6
    //   49: getfield 61	android/graphics/RectF:left	F
    //   52: iload_2
    //   53: i2f
    //   54: fmul
    //   55: f2i
    //   56: istore 4
    //   58: aload 6
    //   60: getfield 64	android/graphics/RectF:top	F
    //   63: iload_3
    //   64: i2f
    //   65: fmul
    //   66: f2i
    //   67: istore 5
    //   69: aload 6
    //   71: invokevirtual 68	android/graphics/RectF:width	()F
    //   74: fstore_1
    //   75: aload 7
    //   77: iload 4
    //   79: iload 5
    //   81: iload_2
    //   82: i2f
    //   83: fload_1
    //   84: fmul
    //   85: f2i
    //   86: aload 6
    //   88: invokevirtual 71	android/graphics/RectF:height	()F
    //   91: iload_3
    //   92: i2f
    //   93: fmul
    //   94: f2i
    //   95: invokestatic 75	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   98: astore 7
    //   100: aload 7
    //   102: ifnull -89 -> 13
    //   105: new 77	java/io/ByteArrayOutputStream
    //   108: dup
    //   109: invokespecial 78	java/io/ByteArrayOutputStream:<init>	()V
    //   112: astore 6
    //   114: aload 7
    //   116: getstatic 84	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   119: bipush 80
    //   121: aload 6
    //   123: invokevirtual 88	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   126: pop
    //   127: aload 7
    //   129: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   132: aload 6
    //   134: invokevirtual 94	java/io/ByteArrayOutputStream:close	()V
    //   137: aload_0
    //   138: aload 6
    //   140: invokevirtual 98	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   143: putfield 100	com/megvii/livenessdetection/impl/a:b	[B
    //   146: goto -133 -> 13
    //   149: astore 6
    //   151: aload_0
    //   152: monitorexit
    //   153: aload 6
    //   155: athrow
    //   156: astore 7
    //   158: goto -21 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	a
    //   74	10	1	f	float
    //   32	50	2	i	int
    //   40	52	3	j	int
    //   56	22	4	k	int
    //   67	13	5	m	int
    //   6	133	6	localObject1	Object
    //   149	5	6	localObject2	Object
    //   45	83	7	localBitmap	Bitmap
    //   156	1	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	8	149	finally
    //   16	100	149	finally
    //   105	132	149	finally
    //   132	137	149	finally
    //   137	146	149	finally
    //   132	137	156	java/io/IOException
  }
  
  public final void a(String paramString, DetectionConfig paramDetectionConfig, b paramb)
  {
    this.mFaceInfo = b.a.a(paramString);
    if (this.mFaceInfo != null) {
      paramb.a(this.mFaceInfo);
    }
  }
  
  public final byte[] a()
  {
    if (!b()) {
      return null;
    }
    Bitmap localBitmap = this.a;
    byte[] arrayOfByte = new byte[localBitmap.getWidth() * localBitmap.getHeight()];
    int i = 0;
    while (i < localBitmap.getHeight())
    {
      int j = 0;
      while (j < localBitmap.getWidth())
      {
        int k = localBitmap.getPixel(j, i);
        arrayOfByte[(localBitmap.getWidth() * i + j)] = ((byte)(((k & 0xFF) * 114 + ((k >> 16 & 0xFF) * 299 + (k >> 8 & 0xFF) * 587)) / 1000));
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public final byte[] getCroppedFaceImageData()
  {
    if ((this.b == null) && (b()) && (hasFace())) {
      c();
    }
    return this.b;
  }
  
  public final byte[] getCroppedFaceImageData(int paramInt)
  {
    return null;
  }
  
  public final byte[] getCroppedFaceImageData(int paramInt, Rect paramRect)
  {
    return null;
  }
  
  public final byte[] getCroppedFaceImageData(Rect paramRect)
  {
    return null;
  }
  
  public final byte[] getEncodedFaceImageData(int paramInt1, int paramInt2, Rect paramRect)
  {
    return null;
  }
  
  public final byte[] getImageData(Rect paramRect, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    return null;
  }
  
  public final int getImageHeight()
  {
    if (b()) {
      return this.a.getHeight();
    }
    return -1;
  }
  
  public final int getImageWidth()
  {
    if (b()) {
      return this.a.getWidth();
    }
    return -1;
  }
  
  public final int getRotation()
  {
    return 0;
  }
  
  public final byte[] getYUVData()
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/livenessdetection/impl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */