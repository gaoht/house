package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class EncodedImage
  implements Closeable
{
  public static final int DEFAULT_SAMPLE_SIZE = 1;
  public static final int UNKNOWN_HEIGHT = -1;
  public static final int UNKNOWN_ROTATION_ANGLE = -1;
  public static final int UNKNOWN_STREAM_SIZE = -1;
  public static final int UNKNOWN_WIDTH = -1;
  @Nullable
  private CacheKey mEncodedCacheKey;
  private int mHeight = -1;
  private ImageFormat mImageFormat = ImageFormat.UNKNOWN;
  @Nullable
  private final Supplier<FileInputStream> mInputStreamSupplier;
  @Nullable
  private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
  private int mRotationAngle = -1;
  private int mSampleSize = 1;
  private int mStreamSize = -1;
  private int mWidth = -1;
  
  public EncodedImage(Supplier<FileInputStream> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    this.mPooledByteBufferRef = null;
    this.mInputStreamSupplier = paramSupplier;
  }
  
  public EncodedImage(Supplier<FileInputStream> paramSupplier, int paramInt)
  {
    this(paramSupplier);
    this.mStreamSize = paramInt;
  }
  
  public EncodedImage(CloseableReference<PooledByteBuffer> paramCloseableReference)
  {
    Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
    this.mPooledByteBufferRef = paramCloseableReference.clone();
    this.mInputStreamSupplier = null;
  }
  
  public static EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null) {
      return paramEncodedImage.cloneOrNull();
    }
    return null;
  }
  
  public static void closeSafely(@Nullable EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null) {
      paramEncodedImage.close();
    }
  }
  
  public static boolean isMetaDataAvailable(EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage.mRotationAngle >= 0) && (paramEncodedImage.mWidth >= 0) && (paramEncodedImage.mHeight >= 0);
  }
  
  public static boolean isValid(@Nullable EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage != null) && (paramEncodedImage.isValid());
  }
  
  /* Error */
  private Pair<Integer, Integer> readImageSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 110	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
    //   6: astore_2
    //   7: aload_2
    //   8: astore_1
    //   9: aload_2
    //   10: invokestatic 116	com/facebook/imageutils/BitmapUtil:decodeDimensions	(Ljava/io/InputStream;)Landroid/util/Pair;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +35 -> 50
    //   18: aload_2
    //   19: astore_1
    //   20: aload_0
    //   21: aload_3
    //   22: getfield 122	android/util/Pair:first	Ljava/lang/Object;
    //   25: checkcast 124	java/lang/Integer
    //   28: invokevirtual 128	java/lang/Integer:intValue	()I
    //   31: putfield 47	com/facebook/imagepipeline/image/EncodedImage:mWidth	I
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_3
    //   38: getfield 131	android/util/Pair:second	Ljava/lang/Object;
    //   41: checkcast 124	java/lang/Integer
    //   44: invokevirtual 128	java/lang/Integer:intValue	()I
    //   47: putfield 49	com/facebook/imagepipeline/image/EncodedImage:mHeight	I
    //   50: aload_2
    //   51: ifnull +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 134	java/io/InputStream:close	()V
    //   58: aload_3
    //   59: areturn
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 134	java/io/InputStream:close	()V
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: aload_3
    //   73: areturn
    //   74: astore_1
    //   75: goto -6 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	EncodedImage
    //   1	65	1	localObject1	Object
    //   71	1	1	localIOException1	java.io.IOException
    //   74	1	1	localIOException2	java.io.IOException
    //   6	49	2	localInputStream	InputStream
    //   60	10	2	localObject2	Object
    //   13	60	3	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   2	7	60	finally
    //   9	14	60	finally
    //   20	34	60	finally
    //   36	50	60	finally
    //   54	58	71	java/io/IOException
    //   65	69	74	java/io/IOException
  }
  
  private Pair<Integer, Integer> readWebPImageSize()
  {
    Pair localPair = WebpUtil.getSize(getInputStream());
    if (localPair != null)
    {
      this.mWidth = ((Integer)localPair.first).intValue();
      this.mHeight = ((Integer)localPair.second).intValue();
    }
    return localPair;
  }
  
  /* Error */
  public EncodedImage cloneOrNull()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/facebook/imagepipeline/image/EncodedImage:mInputStreamSupplier	Lcom/facebook/common/internal/Supplier;
    //   4: ifnull +30 -> 34
    //   7: new 2	com/facebook/imagepipeline/image/EncodedImage
    //   10: dup
    //   11: aload_0
    //   12: getfield 63	com/facebook/imagepipeline/image/EncodedImage:mInputStreamSupplier	Lcom/facebook/common/internal/Supplier;
    //   15: aload_0
    //   16: getfield 53	com/facebook/imagepipeline/image/EncodedImage:mStreamSize	I
    //   19: invokespecial 143	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/internal/Supplier;I)V
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +8 -> 32
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 146	com/facebook/imagepipeline/image/EncodedImage:copyMetaDataFrom	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   38: invokestatic 149	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +12 -> 55
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_2
    //   49: invokestatic 151	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   52: goto -29 -> 23
    //   55: new 2	com/facebook/imagepipeline/image/EncodedImage
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 153	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   63: astore_1
    //   64: goto -16 -> 48
    //   67: astore_1
    //   68: aload_2
    //   69: invokestatic 151	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	EncodedImage
    //   22	42	1	localEncodedImage	EncodedImage
    //   67	6	1	localObject	Object
    //   41	28	2	localCloseableReference	CloseableReference
    // Exception table:
    //   from	to	target	type
    //   55	64	67	finally
  }
  
  public void close()
  {
    CloseableReference.closeSafely(this.mPooledByteBufferRef);
  }
  
  public void copyMetaDataFrom(EncodedImage paramEncodedImage)
  {
    this.mImageFormat = paramEncodedImage.getImageFormat();
    this.mWidth = paramEncodedImage.getWidth();
    this.mHeight = paramEncodedImage.getHeight();
    this.mRotationAngle = paramEncodedImage.getRotationAngle();
    this.mSampleSize = paramEncodedImage.getSampleSize();
    this.mStreamSize = paramEncodedImage.getSize();
    this.mEncodedCacheKey = paramEncodedImage.getEncodedCacheKey();
  }
  
  public CloseableReference<PooledByteBuffer> getByteBufferRef()
  {
    return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
  }
  
  @Nullable
  public CacheKey getEncodedCacheKey()
  {
    return this.mEncodedCacheKey;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public ImageFormat getImageFormat()
  {
    return this.mImageFormat;
  }
  
  public InputStream getInputStream()
  {
    if (this.mInputStreamSupplier != null) {
      return (InputStream)this.mInputStreamSupplier.get();
    }
    CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localCloseableReference != null) {
      try
      {
        PooledByteBufferInputStream localPooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer)localCloseableReference.get());
        return localPooledByteBufferInputStream;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
    return null;
  }
  
  public int getRotationAngle()
  {
    return this.mRotationAngle;
  }
  
  public int getSampleSize()
  {
    return this.mSampleSize;
  }
  
  public int getSize()
  {
    if ((this.mPooledByteBufferRef != null) && (this.mPooledByteBufferRef.get() != null)) {
      return ((PooledByteBuffer)this.mPooledByteBufferRef.get()).size();
    }
    return this.mStreamSize;
  }
  
  /* Error */
  @com.facebook.common.internal.VisibleForTesting
  public com.facebook.common.references.SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   13: invokevirtual 202	com/facebook/common/references/CloseableReference:getUnderlyingReferenceTestOnly	()Lcom/facebook/common/references/SharedReference;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	EncodedImage
    //   16	7	1	localSharedReference	com.facebook.common.references.SharedReference
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isCompleteAt(int paramInt)
  {
    if (this.mImageFormat != DefaultImageFormats.JPEG) {}
    while (this.mInputStreamSupplier != null) {
      return true;
    }
    Preconditions.checkNotNull(this.mPooledByteBufferRef);
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)this.mPooledByteBufferRef.get();
    if ((localPooledByteBuffer.read(paramInt - 2) == -1) && (localPooledByteBuffer.read(paramInt - 1) == -39)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  public boolean isValid()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/facebook/imagepipeline/image/EncodedImage:mPooledByteBufferRef	Lcom/facebook/common/references/CloseableReference;
    //   6: invokestatic 77	com/facebook/common/references/CloseableReference:isValid	(Lcom/facebook/common/references/CloseableReference;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 63	com/facebook/imagepipeline/image/EncodedImage:mInputStreamSupplier	Lcom/facebook/common/internal/Supplier;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	EncodedImage
    //   22	7	1	bool	boolean
    //   16	2	2	localSupplier	Supplier
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public void parseMetaData()
  {
    ImageFormat localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
    this.mImageFormat = localImageFormat;
    if (DefaultImageFormats.isWebpFormat(localImageFormat)) {}
    for (Pair localPair = readWebPImageSize(); (localImageFormat == DefaultImageFormats.JPEG) && (this.mRotationAngle == -1); localPair = readImageSize())
    {
      if (localPair != null) {
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(JfifUtil.getOrientation(getInputStream()));
      }
      return;
    }
    this.mRotationAngle = 0;
  }
  
  public void setEncodedCacheKey(@Nullable CacheKey paramCacheKey)
  {
    this.mEncodedCacheKey = paramCacheKey;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setImageFormat(ImageFormat paramImageFormat)
  {
    this.mImageFormat = paramImageFormat;
  }
  
  public void setRotationAngle(int paramInt)
  {
    this.mRotationAngle = paramInt;
  }
  
  public void setSampleSize(int paramInt)
  {
    this.mSampleSize = paramInt;
  }
  
  public void setStreamSize(int paramInt)
  {
    this.mStreamSize = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/image/EncodedImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */