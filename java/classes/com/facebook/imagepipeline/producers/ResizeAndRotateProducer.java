package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer
  implements Producer<EncodedImage>
{
  @VisibleForTesting
  static final int DEFAULT_JPEG_QUALITY = 85;
  private static final String DOWNSAMPLE_ENUMERATOR_KEY = "downsampleEnumerator";
  private static final String FRACTION_KEY = "Fraction";
  private static final int FULL_ROUND = 360;
  @VisibleForTesting
  static final int MAX_JPEG_SCALE_NUMERATOR = 8;
  @VisibleForTesting
  static final int MIN_TRANSFORM_INTERVAL_MS = 100;
  private static final String ORIGINAL_SIZE_KEY = "Original size";
  public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
  private static final String REQUESTED_SIZE_KEY = "Requested size";
  private static final String ROTATION_ANGLE_KEY = "rotationAngle";
  private static final String SOFTWARE_ENUMERATOR_KEY = "softwareEnumerator";
  private final Executor mExecutor;
  private final Producer<EncodedImage> mInputProducer;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final boolean mResizingEnabled;
  private final boolean mUseDownsamplingRatio;
  
  public ResizeAndRotateProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, boolean paramBoolean1, Producer<EncodedImage> paramProducer, boolean paramBoolean2)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mPooledByteBufferFactory = ((PooledByteBufferFactory)Preconditions.checkNotNull(paramPooledByteBufferFactory));
    this.mResizingEnabled = paramBoolean1;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mUseDownsamplingRatio = paramBoolean2;
  }
  
  @VisibleForTesting
  static int calculateDownsampleNumerator(int paramInt)
  {
    return Math.max(1, 8 / paramInt);
  }
  
  @VisibleForTesting
  static float determineResizeRatio(ResizeOptions paramResizeOptions, int paramInt1, int paramInt2)
  {
    float f2;
    if (paramResizeOptions == null) {
      f2 = 1.0F;
    }
    float f1;
    do
    {
      return f2;
      f2 = Math.max(paramResizeOptions.width / paramInt1, paramResizeOptions.height / paramInt2);
      f1 = f2;
      if (paramInt1 * f2 > paramResizeOptions.maxBitmapSize) {
        f1 = paramResizeOptions.maxBitmapSize / paramInt1;
      }
      f2 = f1;
    } while (paramInt2 * f1 <= paramResizeOptions.maxBitmapSize);
    return paramResizeOptions.maxBitmapSize / paramInt2;
  }
  
  private static int extractOrientationFromMetadata(EncodedImage paramEncodedImage)
  {
    switch (paramEncodedImage.getRotationAngle())
    {
    default: 
      return 0;
    }
    return paramEncodedImage.getRotationAngle();
  }
  
  private static int getRotationAngle(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    int i;
    if (!paramRotationOptions.rotationEnabled()) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = extractOrientationFromMetadata(paramEncodedImage);
      i = j;
    } while (paramRotationOptions.useImageMetadata());
    return (j + paramRotationOptions.getForcedAngle()) % 360;
  }
  
  private static int getSoftwareNumerator(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 8;
    }
    int j;
    label58:
    label103:
    label111:
    label120:
    do
    {
      return i;
      ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
      if (localResizeOptions == null) {
        return 8;
      }
      i = getRotationAngle(paramImageRequest.getRotationOptions(), paramEncodedImage);
      if ((i == 90) || (i == 270))
      {
        j = 1;
        if (j == 0) {
          break label103;
        }
        i = paramEncodedImage.getHeight();
        if (j == 0) {
          break label111;
        }
      }
      for (j = paramEncodedImage.getWidth();; j = paramEncodedImage.getHeight())
      {
        j = roundNumerator(determineResizeRatio(localResizeOptions, i, j), localResizeOptions.roundUpFraction);
        if (j <= 8) {
          break label120;
        }
        return 8;
        j = 0;
        break;
        i = paramEncodedImage.getWidth();
        break label58;
      }
      i = j;
    } while (j >= 1);
    return 1;
  }
  
  @VisibleForTesting
  static int roundNumerator(float paramFloat1, float paramFloat2)
  {
    return (int)(8.0F * paramFloat1 + paramFloat2);
  }
  
  private static boolean shouldResize(int paramInt)
  {
    return paramInt < 8;
  }
  
  private static boolean shouldRotate(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    return (!paramRotationOptions.canDeferUntilRendered()) && (getRotationAngle(paramRotationOptions, paramEncodedImage) != 0);
  }
  
  private static TriState shouldTransform(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    if ((paramEncodedImage == null) || (paramEncodedImage.getImageFormat() == ImageFormat.UNKNOWN)) {
      return TriState.UNSET;
    }
    if (paramEncodedImage.getImageFormat() != DefaultImageFormats.JPEG) {
      return TriState.NO;
    }
    if ((shouldRotate(paramImageRequest.getRotationOptions(), paramEncodedImage)) || (shouldResize(getSoftwareNumerator(paramImageRequest, paramEncodedImage, paramBoolean)))) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return TriState.valueOf(paramBoolean);
    }
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new TransformingConsumer(paramConsumer, paramProducerContext), paramProducerContext);
  }
  
  private class TransformingConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private boolean mIsCancelled = false;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    
    public TransformingConsumer(final ProducerContext paramProducerContext)
    {
      super();
      this.mProducerContext = local1;
      JobScheduler.JobRunnable local1 = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, boolean paramAnonymousBoolean)
        {
          ResizeAndRotateProducer.TransformingConsumer.this.doTransform(paramAnonymousEncodedImage, paramAnonymousBoolean);
        }
      };
      this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, local1, 100);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.clearJob();
          ResizeAndRotateProducer.TransformingConsumer.access$402(ResizeAndRotateProducer.TransformingConsumer.this, true);
          paramProducerContext.onCancellation();
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          if (ResizeAndRotateProducer.TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
            ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.scheduleJob();
          }
        }
      });
    }
    
    /* Error */
    private void doTransform(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 9
      //   3: aload_0
      //   4: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   7: invokeinterface 75 1 0
      //   12: aload_0
      //   13: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   16: invokeinterface 79 1 0
      //   21: ldc 81
      //   23: invokeinterface 87 3 0
      //   28: aload_0
      //   29: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   32: invokeinterface 91 1 0
      //   37: astore 7
      //   39: aload_0
      //   40: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   43: invokestatic 95	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$700	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Lcom/facebook/imagepipeline/memory/PooledByteBufferFactory;
      //   46: invokeinterface 101 1 0
      //   51: astore 10
      //   53: aload 7
      //   55: aload_1
      //   56: aload_0
      //   57: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   60: invokestatic 105	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$500	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
      //   63: invokestatic 109	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$800	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I
      //   66: istore 4
      //   68: aload 7
      //   70: aload_1
      //   71: invokestatic 115	com/facebook/imagepipeline/producers/DownsampleUtil:determineSampleSize	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   74: invokestatic 119	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:calculateDownsampleNumerator	(I)I
      //   77: istore 5
      //   79: aload_0
      //   80: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   83: invokestatic 122	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$900	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
      //   86: ifeq +151 -> 237
      //   89: iload 5
      //   91: istore_3
      //   92: aload 7
      //   94: invokevirtual 128	com/facebook/imagepipeline/request/ImageRequest:getRotationOptions	()Lcom/facebook/imagepipeline/common/RotationOptions;
      //   97: aload_1
      //   98: invokestatic 132	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$1000	(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   101: istore 6
      //   103: aload_0
      //   104: aload_1
      //   105: aload 7
      //   107: iload_3
      //   108: iload 5
      //   110: iload 4
      //   112: iload 6
      //   114: invokespecial 136	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getExtraMap	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/request/ImageRequest;IIII)Ljava/util/Map;
      //   117: astore 8
      //   119: aload_1
      //   120: invokevirtual 142	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
      //   123: astore_1
      //   124: aload_1
      //   125: astore 7
      //   127: aload_1
      //   128: aload 10
      //   130: iload 6
      //   132: iload_3
      //   133: bipush 85
      //   135: invokestatic 148	com/facebook/imagepipeline/nativecode/JpegTranscoder:transcodeJpeg	(Ljava/io/InputStream;Ljava/io/OutputStream;III)V
      //   138: aload_1
      //   139: astore 7
      //   141: aload 10
      //   143: invokevirtual 154	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/imagepipeline/memory/PooledByteBuffer;
      //   146: invokestatic 160	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
      //   149: astore 9
      //   151: new 138	com/facebook/imagepipeline/image/EncodedImage
      //   154: dup
      //   155: aload 9
      //   157: invokespecial 163	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   160: astore 7
      //   162: aload 7
      //   164: getstatic 169	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
      //   167: invokevirtual 173	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
      //   170: aload 7
      //   172: invokevirtual 177	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
      //   175: aload_0
      //   176: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   179: invokeinterface 75 1 0
      //   184: aload_0
      //   185: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   188: invokeinterface 79 1 0
      //   193: ldc 81
      //   195: aload 8
      //   197: invokeinterface 181 4 0
      //   202: aload_0
      //   203: invokevirtual 185	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   206: aload 7
      //   208: iload_2
      //   209: invokeinterface 191 3 0
      //   214: aload 7
      //   216: invokestatic 195	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   219: aload_1
      //   220: astore 7
      //   222: aload 9
      //   224: invokestatic 197	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   227: aload_1
      //   228: invokestatic 203	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   231: aload 10
      //   233: invokevirtual 206	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
      //   236: return
      //   237: iload 4
      //   239: istore_3
      //   240: goto -148 -> 92
      //   243: astore 11
      //   245: aload 7
      //   247: invokestatic 195	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   250: aload 11
      //   252: athrow
      //   253: astore 11
      //   255: aload_1
      //   256: astore 7
      //   258: aload 9
      //   260: invokestatic 197	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   263: aload_1
      //   264: astore 7
      //   266: aload 11
      //   268: athrow
      //   269: astore 7
      //   271: aload 8
      //   273: astore 9
      //   275: aload 7
      //   277: astore 8
      //   279: aload_1
      //   280: astore 7
      //   282: aload_0
      //   283: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   286: invokeinterface 75 1 0
      //   291: aload_0
      //   292: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   295: invokeinterface 79 1 0
      //   300: ldc 81
      //   302: aload 8
      //   304: aload 9
      //   306: invokeinterface 210 5 0
      //   311: aload_1
      //   312: astore 7
      //   314: aload_0
      //   315: invokevirtual 185	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   318: aload 8
      //   320: invokeinterface 214 2 0
      //   325: aload_1
      //   326: invokestatic 203	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   329: aload 10
      //   331: invokevirtual 206	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
      //   334: return
      //   335: astore_1
      //   336: aconst_null
      //   337: astore 7
      //   339: aload 7
      //   341: invokestatic 203	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   344: aload 10
      //   346: invokevirtual 206	com/facebook/imagepipeline/memory/PooledByteBufferOutputStream:close	()V
      //   349: aload_1
      //   350: athrow
      //   351: astore_1
      //   352: goto -13 -> 339
      //   355: astore 8
      //   357: aconst_null
      //   358: astore_1
      //   359: goto -80 -> 279
      //   362: astore 7
      //   364: aconst_null
      //   365: astore_1
      //   366: aload 8
      //   368: astore 9
      //   370: aload 7
      //   372: astore 8
      //   374: goto -95 -> 279
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	377	0	this	TransformingConsumer
      //   0	377	1	paramEncodedImage	EncodedImage
      //   0	377	2	paramBoolean	boolean
      //   91	149	3	i	int
      //   66	172	4	j	int
      //   77	32	5	k	int
      //   101	30	6	m	int
      //   37	228	7	localObject1	Object
      //   269	7	7	localException1	Exception
      //   280	60	7	localEncodedImage	EncodedImage
      //   362	9	7	localException2	Exception
      //   117	202	8	localObject2	Object
      //   355	12	8	localException3	Exception
      //   372	1	8	localException4	Exception
      //   1	368	9	localObject3	Object
      //   51	294	10	localPooledByteBufferOutputStream	com.facebook.imagepipeline.memory.PooledByteBufferOutputStream
      //   243	8	11	localObject4	Object
      //   253	14	11	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   170	214	243	finally
      //   151	170	253	finally
      //   214	219	253	finally
      //   245	253	253	finally
      //   127	138	269	java/lang/Exception
      //   141	151	269	java/lang/Exception
      //   222	227	269	java/lang/Exception
      //   258	263	269	java/lang/Exception
      //   266	269	269	java/lang/Exception
      //   53	89	335	finally
      //   92	119	335	finally
      //   119	124	335	finally
      //   127	138	351	finally
      //   141	151	351	finally
      //   222	227	351	finally
      //   258	263	351	finally
      //   266	269	351	finally
      //   282	311	351	finally
      //   314	325	351	finally
      //   53	89	355	java/lang/Exception
      //   92	119	355	java/lang/Exception
      //   119	124	362	java/lang/Exception
    }
    
    private Map<String, String> getExtraMap(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
        return null;
      }
      String str = paramEncodedImage.getWidth() + "x" + paramEncodedImage.getHeight();
      if (paramImageRequest.getResizeOptions() != null)
      {
        paramEncodedImage = paramImageRequest.getResizeOptions().width + "x" + paramImageRequest.getResizeOptions().height;
        if (paramInt1 <= 0) {
          break label255;
        }
      }
      label255:
      for (paramImageRequest = paramInt1 + "/8";; paramImageRequest = "")
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Original size", str);
        localHashMap.put("Requested size", paramEncodedImage);
        localHashMap.put("Fraction", paramImageRequest);
        localHashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
        localHashMap.put("downsampleEnumerator", Integer.toString(paramInt2));
        localHashMap.put("softwareEnumerator", Integer.toString(paramInt3));
        localHashMap.put("rotationAngle", Integer.toString(paramInt4));
        return ImmutableMap.copyOf(localHashMap);
        paramEncodedImage = "Unspecified";
        break;
      }
    }
    
    protected void onNewResultImpl(@Nullable EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (this.mIsCancelled) {}
      do
      {
        TriState localTriState;
        do
        {
          do
          {
            return;
            if (paramEncodedImage != null) {
              break;
            }
          } while (!paramBoolean);
          getConsumer().onNewResult(null, true);
          return;
          localTriState = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), paramEncodedImage, ResizeAndRotateProducer.this.mResizingEnabled);
        } while ((!paramBoolean) && (localTriState == TriState.UNSET));
        if (localTriState != TriState.YES)
        {
          getConsumer().onNewResult(paramEncodedImage, paramBoolean);
          return;
        }
      } while ((!this.mJobScheduler.updateJob(paramEncodedImage, paramBoolean)) || ((!paramBoolean) && (!this.mProducerContext.isIntermediateResultExpected())));
      this.mJobScheduler.scheduleJob();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/ResizeAndRotateProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */