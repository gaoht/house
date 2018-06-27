package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public class HoneycombBitmapFactory
  extends PlatformBitmapFactory
{
  private final EmptyJpegGenerator mJpegGenerator;
  private final PlatformDecoder mPurgeableDecoder;
  
  public HoneycombBitmapFactory(EmptyJpegGenerator paramEmptyJpegGenerator, PlatformDecoder paramPlatformDecoder)
  {
    this.mJpegGenerator = paramEmptyJpegGenerator;
    this.mPurgeableDecoder = paramPlatformDecoder;
  }
  
  /* Error */
  @TargetApi(12)
  public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmapInternal(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   4: iload_1
    //   5: i2s
    //   6: iload_2
    //   7: i2s
    //   8: invokevirtual 31	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   11: astore 4
    //   13: new 33	com/facebook/imagepipeline/image/EncodedImage
    //   16: dup
    //   17: aload 4
    //   19: invokespecial 36	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   22: astore 5
    //   24: aload 5
    //   26: getstatic 42	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   29: invokevirtual 46	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   32: aload_0
    //   33: getfield 21	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mPurgeableDecoder	Lcom/facebook/imagepipeline/platform/PlatformDecoder;
    //   36: aload 5
    //   38: aload_3
    //   39: aload 4
    //   41: invokevirtual 52	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   44: checkcast 54	com/facebook/imagepipeline/memory/PooledByteBuffer
    //   47: invokeinterface 58 1 0
    //   52: invokeinterface 64 4 0
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 52	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   62: checkcast 66	android/graphics/Bitmap
    //   65: iconst_1
    //   66: invokevirtual 70	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   69: aload_3
    //   70: invokevirtual 52	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   73: checkcast 66	android/graphics/Bitmap
    //   76: iconst_0
    //   77: invokevirtual 74	android/graphics/Bitmap:eraseColor	(I)V
    //   80: aload 5
    //   82: invokestatic 78	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   85: aload 4
    //   87: invokevirtual 81	com/facebook/common/references/CloseableReference:close	()V
    //   90: aload_3
    //   91: areturn
    //   92: astore_3
    //   93: aload 5
    //   95: invokestatic 78	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   98: aload_3
    //   99: athrow
    //   100: astore_3
    //   101: aload 4
    //   103: invokevirtual 81	com/facebook/common/references/CloseableReference:close	()V
    //   106: aload_3
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	HoneycombBitmapFactory
    //   0	108	1	paramInt1	int
    //   0	108	2	paramInt2	int
    //   0	108	3	paramConfig	android.graphics.Bitmap.Config
    //   11	91	4	localCloseableReference	com.facebook.common.references.CloseableReference
    //   22	72	5	localEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    // Exception table:
    //   from	to	target	type
    //   32	80	92	finally
    //   13	32	100	finally
    //   80	85	100	finally
    //   93	100	100	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */