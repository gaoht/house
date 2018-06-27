package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

public class HoneycombBitmapCreator
  implements BitmapCreator
{
  private final FlexByteArrayPool mFlexByteArrayPool;
  private final EmptyJpegGenerator mJpegGenerator;
  
  public HoneycombBitmapCreator(PoolFactory paramPoolFactory)
  {
    this.mFlexByteArrayPool = paramPoolFactory.getFlexByteArrayPool();
    this.mJpegGenerator = new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory());
  }
  
  private static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    return localOptions;
  }
  
  /* Error */
  @android.annotation.TargetApi(12)
  public android.graphics.Bitmap createNakedBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 34	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   7: iload_1
    //   8: i2s
    //   9: iload_2
    //   10: i2s
    //   11: invokevirtual 75	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   14: astore 7
    //   16: new 77	com/facebook/imagepipeline/image/EncodedImage
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 80	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   25: astore 4
    //   27: aload 4
    //   29: getstatic 86	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   32: invokevirtual 90	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   35: aload 4
    //   37: invokevirtual 94	com/facebook/imagepipeline/image/EncodedImage:getSampleSize	()I
    //   40: aload_3
    //   41: invokestatic 96	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:getBitmapFactoryOptions	(ILandroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    //   44: astore 6
    //   46: aload 7
    //   48: invokevirtual 102	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   51: checkcast 104	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   54: invokeinterface 107 1 0
    //   59: istore_1
    //   60: aload 7
    //   62: invokevirtual 102	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   65: checkcast 104	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   68: astore 8
    //   70: aload_0
    //   71: getfield 23	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mFlexByteArrayPool	Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;
    //   74: iload_1
    //   75: iconst_2
    //   76: iadd
    //   77: invokevirtual 112	com/facebook/imagepipeline/memory/FlexByteArrayPool:get	(I)Lcom/facebook/common/references/CloseableReference;
    //   80: astore_3
    //   81: aload_3
    //   82: invokevirtual 102	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   85: checkcast 114	[B
    //   88: astore 5
    //   90: aload 8
    //   92: iconst_0
    //   93: aload 5
    //   95: iconst_0
    //   96: iload_1
    //   97: invokeinterface 118 5 0
    //   102: aload 5
    //   104: iconst_0
    //   105: iload_1
    //   106: aload 6
    //   108: invokestatic 124	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   111: astore 5
    //   113: aload 5
    //   115: iconst_1
    //   116: invokevirtual 130	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   119: aload 5
    //   121: iconst_0
    //   122: invokevirtual 134	android/graphics/Bitmap:eraseColor	(I)V
    //   125: aload_3
    //   126: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   129: aload 4
    //   131: invokestatic 140	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   134: aload 7
    //   136: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   139: aload 5
    //   141: areturn
    //   142: astore_3
    //   143: aconst_null
    //   144: astore 4
    //   146: aload 5
    //   148: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   151: aload 4
    //   153: invokestatic 140	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   156: aload 7
    //   158: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   161: aload_3
    //   162: athrow
    //   163: astore_3
    //   164: goto -18 -> 146
    //   167: astore 6
    //   169: aload_3
    //   170: astore 5
    //   172: aload 6
    //   174: astore_3
    //   175: goto -29 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	HoneycombBitmapCreator
    //   0	178	1	paramInt1	int
    //   0	178	2	paramInt2	int
    //   0	178	3	paramConfig	Bitmap.Config
    //   25	127	4	localEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    //   1	170	5	localObject1	Object
    //   44	63	6	localOptions	BitmapFactory.Options
    //   167	6	6	localObject2	Object
    //   14	143	7	localCloseableReference	com.facebook.common.references.CloseableReference
    //   68	23	8	localPooledByteBuffer	com.facebook.imagepipeline.memory.PooledByteBuffer
    // Exception table:
    //   from	to	target	type
    //   16	27	142	finally
    //   27	81	163	finally
    //   81	125	167	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */