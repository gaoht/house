package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class DecodeProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
  public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
  public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
  public static final String EXTRA_IS_FINAL = "isFinal";
  public static final String PRODUCER_NAME = "DecodeProducer";
  public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
  public static final String SAMPLE_SIZE = "sampleSize";
  private final ByteArrayPool mByteArrayPool;
  private final boolean mDecodeCancellationEnabled;
  private final boolean mDownsampleEnabled;
  private final boolean mDownsampleEnabledForNetwork;
  private final Executor mExecutor;
  private final ImageDecoder mImageDecoder;
  private final Producer<EncodedImage> mInputProducer;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;
  
  public DecodeProducer(ByteArrayPool paramByteArrayPool, Executor paramExecutor, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Producer<EncodedImage> paramProducer)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mImageDecoder = ((ImageDecoder)Preconditions.checkNotNull(paramImageDecoder));
    this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramProgressiveJpegConfig));
    this.mDownsampleEnabled = paramBoolean1;
    this.mDownsampleEnabledForNetwork = paramBoolean2;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mDecodeCancellationEnabled = paramBoolean3;
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    if (!UriUtil.isNetworkUri(paramProducerContext.getImageRequest().getSourceUri())) {}
    for (paramConsumer = new LocalImagesProgressiveDecoder(paramConsumer, paramProducerContext, this.mDecodeCancellationEnabled);; paramConsumer = new NetworkImagesProgressiveDecoder(paramConsumer, paramProducerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
  }
  
  private class LocalImagesProgressiveDecoder
    extends DecodeProducer.ProgressiveDecoder
  {
    public LocalImagesProgressiveDecoder(ProducerContext paramProducerContext, boolean paramBoolean)
    {
      super(paramProducerContext, paramBoolean, bool);
    }
    
    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return paramEncodedImage.getSize();
    }
    
    protected QualityInfo getQualityInfo()
    {
      return ImmutableQualityInfo.of(0, false, false);
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (!paramBoolean) {
        paramBoolean = false;
      }
      for (;;)
      {
        return paramBoolean;
        try
        {
          paramBoolean = super.updateDecodeJob(paramEncodedImage, paramBoolean);
        }
        finally {}
      }
    }
  }
  
  private class NetworkImagesProgressiveDecoder
    extends DecodeProducer.ProgressiveDecoder
  {
    private int mLastScheduledScanNumber;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final ProgressiveJpegParser mProgressiveJpegParser;
    
    public NetworkImagesProgressiveDecoder(ProducerContext paramProducerContext, ProgressiveJpegParser paramProgressiveJpegParser, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean)
    {
      super(paramProducerContext, paramProgressiveJpegParser, bool);
      this.mProgressiveJpegParser = ((ProgressiveJpegParser)Preconditions.checkNotNull(paramProgressiveJpegConfig));
      this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramBoolean));
      this.mLastScheduledScanNumber = 0;
    }
    
    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return this.mProgressiveJpegParser.getBestScanEndOffset();
    }
    
    protected QualityInfo getQualityInfo()
    {
      return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
    }
    
    /* Error */
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 4
      //   3: aload_0
      //   4: monitorenter
      //   5: aload_0
      //   6: aload_1
      //   7: iload_2
      //   8: invokespecial 59	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:updateDecodeJob	(Lcom/facebook/imagepipeline/image/EncodedImage;Z)Z
      //   11: istore 5
      //   13: iload_2
      //   14: ifne +74 -> 88
      //   17: aload_1
      //   18: invokestatic 65	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
      //   21: ifeq +67 -> 88
      //   24: aload_0
      //   25: getfield 32	com/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder:mProgressiveJpegParser	Lcom/facebook/imagepipeline/decoder/ProgressiveJpegParser;
      //   28: aload_1
      //   29: invokevirtual 68	com/facebook/imagepipeline/decoder/ProgressiveJpegParser:parseMoreData	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
      //   32: istore_2
      //   33: iload_2
      //   34: ifne +10 -> 44
      //   37: iload 4
      //   39: istore_2
      //   40: aload_0
      //   41: monitorexit
      //   42: iload_2
      //   43: ireturn
      //   44: aload_0
      //   45: getfield 32	com/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder:mProgressiveJpegParser	Lcom/facebook/imagepipeline/decoder/ProgressiveJpegParser;
      //   48: invokevirtual 52	com/facebook/imagepipeline/decoder/ProgressiveJpegParser:getBestScanNumber	()I
      //   51: istore_3
      //   52: iload 4
      //   54: istore_2
      //   55: iload_3
      //   56: aload_0
      //   57: getfield 38	com/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder:mLastScheduledScanNumber	I
      //   60: if_icmple -20 -> 40
      //   63: iload 4
      //   65: istore_2
      //   66: iload_3
      //   67: aload_0
      //   68: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder:mProgressiveJpegConfig	Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;
      //   71: aload_0
      //   72: getfield 38	com/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder:mLastScheduledScanNumber	I
      //   75: invokeinterface 72 2 0
      //   80: if_icmplt -40 -> 40
      //   83: aload_0
      //   84: iload_3
      //   85: putfield 38	com/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder:mLastScheduledScanNumber	I
      //   88: iload 5
      //   90: istore_2
      //   91: goto -51 -> 40
      //   94: astore_1
      //   95: aload_0
      //   96: monitorexit
      //   97: aload_1
      //   98: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	99	0	this	NetworkImagesProgressiveDecoder
      //   0	99	1	paramEncodedImage	EncodedImage
      //   0	99	2	paramBoolean	boolean
      //   51	34	3	i	int
      //   1	63	4	bool1	boolean
      //   11	78	5	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   5	13	94	finally
      //   17	33	94	finally
      //   44	52	94	finally
      //   55	63	94	finally
      //   66	88	94	finally
    }
  }
  
  private abstract class ProgressiveDecoder
    extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>>
  {
    private final ImageDecodeOptions mImageDecodeOptions;
    @GuardedBy("this")
    private boolean mIsFinished;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    private final ProducerListener mProducerListener;
    
    public ProgressiveDecoder(ProducerContext paramProducerContext, final boolean paramBoolean)
    {
      super();
      this.mProducerContext = paramBoolean;
      this.mProducerListener = paramBoolean.getListener();
      this.mImageDecodeOptions = paramBoolean.getImageRequest().getImageDecodeOptions();
      this.mIsFinished = false;
      paramProducerContext = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousEncodedImage != null)
          {
            if (DecodeProducer.this.mDownsampleEnabled)
            {
              ImageRequest localImageRequest = paramBoolean.getImageRequest();
              if ((DecodeProducer.this.mDownsampleEnabledForNetwork) || (!UriUtil.isNetworkUri(localImageRequest.getSourceUri()))) {
                paramAnonymousEncodedImage.setSampleSize(DownsampleUtil.determineSampleSize(localImageRequest, paramAnonymousEncodedImage));
              }
            }
            DecodeProducer.ProgressiveDecoder.this.doDecode(paramAnonymousEncodedImage, paramAnonymousBoolean);
          }
        }
      };
      this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, paramProducerContext, this.mImageDecodeOptions.minDecodeIntervalMs);
      final boolean bool;
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          if (bool) {
            DecodeProducer.ProgressiveDecoder.this.handleCancellation();
          }
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          if (DecodeProducer.ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
            DecodeProducer.ProgressiveDecoder.this.mJobScheduler.scheduleJob();
          }
        }
      });
    }
    
    /* Error */
    private void doDecode(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 110	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:isFinished	()Z
      //   4: ifne +10 -> 14
      //   7: aload_1
      //   8: invokestatic 116	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
      //   11: ifne +4 -> 15
      //   14: return
      //   15: aload_1
      //   16: invokevirtual 120	com/facebook/imagepipeline/image/EncodedImage:getImageFormat	()Lcom/facebook/imageformat/ImageFormat;
      //   19: astore 6
      //   21: aload 6
      //   23: ifnull +230 -> 253
      //   26: aload 6
      //   28: invokevirtual 126	com/facebook/imageformat/ImageFormat:getName	()Ljava/lang/String;
      //   31: astore 6
      //   33: aload_1
      //   34: ifnull +226 -> 260
      //   37: new 128	java/lang/StringBuilder
      //   40: dup
      //   41: invokespecial 130	java/lang/StringBuilder:<init>	()V
      //   44: aload_1
      //   45: invokevirtual 134	com/facebook/imagepipeline/image/EncodedImage:getWidth	()I
      //   48: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   51: ldc -116
      //   53: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   56: aload_1
      //   57: invokevirtual 146	com/facebook/imagepipeline/image/EncodedImage:getHeight	()I
      //   60: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   63: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   66: astore 7
      //   68: aload_1
      //   69: invokevirtual 152	com/facebook/imagepipeline/image/EncodedImage:getSampleSize	()I
      //   72: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   75: astore 8
      //   77: aload_0
      //   78: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   81: invokeinterface 48 1 0
      //   86: invokevirtual 162	com/facebook/imagepipeline/request/ImageRequest:getResizeOptions	()Lcom/facebook/imagepipeline/common/ResizeOptions;
      //   89: astore 9
      //   91: aload 9
      //   93: ifnull +178 -> 271
      //   96: new 128	java/lang/StringBuilder
      //   99: dup
      //   100: invokespecial 130	java/lang/StringBuilder:<init>	()V
      //   103: aload 9
      //   105: getfield 167	com/facebook/imagepipeline/common/ResizeOptions:width	I
      //   108: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   111: ldc -116
      //   113: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: aload 9
      //   118: getfield 170	com/facebook/imagepipeline/common/ResizeOptions:height	I
      //   121: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   124: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   127: astore 9
      //   129: aload_0
      //   130: getfield 78	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mJobScheduler	Lcom/facebook/imagepipeline/producers/JobScheduler;
      //   133: invokevirtual 174	com/facebook/imagepipeline/producers/JobScheduler:getQueuedTime	()J
      //   136: lstore 4
      //   138: iload_2
      //   139: ifeq +139 -> 278
      //   142: aload_1
      //   143: invokevirtual 177	com/facebook/imagepipeline/image/EncodedImage:getSize	()I
      //   146: istore_3
      //   147: iload_2
      //   148: ifeq +139 -> 287
      //   151: getstatic 183	com/facebook/imagepipeline/image/ImmutableQualityInfo:FULL_QUALITY	Lcom/facebook/imagepipeline/image/QualityInfo;
      //   154: astore 10
      //   156: aload_0
      //   157: getfield 44	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerListener	Lcom/facebook/imagepipeline/producers/ProducerListener;
      //   160: aload_0
      //   161: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   164: invokeinterface 186 1 0
      //   169: ldc -68
      //   171: invokeinterface 194 3 0
      //   176: aload_0
      //   177: getfield 31	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:this$0	Lcom/facebook/imagepipeline/producers/DecodeProducer;
      //   180: invokestatic 198	com/facebook/imagepipeline/producers/DecodeProducer:access$700	(Lcom/facebook/imagepipeline/producers/DecodeProducer;)Lcom/facebook/imagepipeline/decoder/ImageDecoder;
      //   183: aload_1
      //   184: iload_3
      //   185: aload 10
      //   187: aload_0
      //   188: getfield 56	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mImageDecodeOptions	Lcom/facebook/imagepipeline/common/ImageDecodeOptions;
      //   191: invokeinterface 204 5 0
      //   196: astore 11
      //   198: aload_0
      //   199: aload 11
      //   201: lload 4
      //   203: aload 10
      //   205: iload_2
      //   206: aload 6
      //   208: aload 7
      //   210: aload 9
      //   212: aload 8
      //   214: invokespecial 208	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getExtraMap	(Lcom/facebook/imagepipeline/image/CloseableImage;JLcom/facebook/imagepipeline/image/QualityInfo;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
      //   217: astore 6
      //   219: aload_0
      //   220: getfield 44	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerListener	Lcom/facebook/imagepipeline/producers/ProducerListener;
      //   223: aload_0
      //   224: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   227: invokeinterface 186 1 0
      //   232: ldc -68
      //   234: aload 6
      //   236: invokeinterface 212 4 0
      //   241: aload_0
      //   242: aload 11
      //   244: iload_2
      //   245: invokespecial 216	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:handleResult	(Lcom/facebook/imagepipeline/image/CloseableImage;Z)V
      //   248: aload_1
      //   249: invokestatic 220	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   252: return
      //   253: ldc -34
      //   255: astore 6
      //   257: goto -224 -> 33
      //   260: ldc -34
      //   262: astore 7
      //   264: ldc -34
      //   266: astore 8
      //   268: goto -191 -> 77
      //   271: ldc -34
      //   273: astore 9
      //   275: goto -146 -> 129
      //   278: aload_0
      //   279: aload_1
      //   280: invokevirtual 226	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getIntermediateImageEndOffset	(Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   283: istore_3
      //   284: goto -137 -> 147
      //   287: aload_0
      //   288: invokevirtual 230	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getQualityInfo	()Lcom/facebook/imagepipeline/image/QualityInfo;
      //   291: astore 10
      //   293: goto -137 -> 156
      //   296: astore 11
      //   298: aload_0
      //   299: aconst_null
      //   300: lload 4
      //   302: aload 10
      //   304: iload_2
      //   305: aload 6
      //   307: aload 7
      //   309: aload 9
      //   311: aload 8
      //   313: invokespecial 208	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:getExtraMap	(Lcom/facebook/imagepipeline/image/CloseableImage;JLcom/facebook/imagepipeline/image/QualityInfo;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
      //   316: astore 6
      //   318: aload_0
      //   319: getfield 44	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerListener	Lcom/facebook/imagepipeline/producers/ProducerListener;
      //   322: aload_0
      //   323: getfield 36	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   326: invokeinterface 186 1 0
      //   331: ldc -68
      //   333: aload 11
      //   335: aload 6
      //   337: invokeinterface 234 5 0
      //   342: aload_0
      //   343: aload 11
      //   345: invokespecial 238	com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder:handleError	(Ljava/lang/Throwable;)V
      //   348: aload_1
      //   349: invokestatic 220	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   352: return
      //   353: astore 6
      //   355: aload_1
      //   356: invokestatic 220	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   359: aload 6
      //   361: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	362	0	this	ProgressiveDecoder
      //   0	362	1	paramEncodedImage	EncodedImage
      //   0	362	2	paramBoolean	boolean
      //   146	138	3	i	int
      //   136	165	4	l	long
      //   19	317	6	localObject1	Object
      //   353	7	6	localObject2	Object
      //   66	242	7	str1	String
      //   75	237	8	str2	String
      //   89	221	9	localObject3	Object
      //   154	149	10	localQualityInfo	QualityInfo
      //   196	47	11	localCloseableImage	CloseableImage
      //   296	48	11	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   176	198	296	java/lang/Exception
      //   129	138	353	finally
      //   142	147	353	finally
      //   151	156	353	finally
      //   156	176	353	finally
      //   176	198	353	finally
      //   198	248	353	finally
      //   278	284	353	finally
      //   287	293	353	finally
      //   298	348	353	finally
    }
    
    private Map<String, String> getExtraMap(@Nullable CloseableImage paramCloseableImage, long paramLong, QualityInfo paramQualityInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
        return null;
      }
      String str1 = String.valueOf(paramLong);
      paramQualityInfo = String.valueOf(paramQualityInfo.isOfGoodEnoughQuality());
      String str2 = String.valueOf(paramBoolean);
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        paramCloseableImage = ((CloseableStaticBitmap)paramCloseableImage).getUnderlyingBitmap();
        paramCloseableImage = paramCloseableImage.getWidth() + "x" + paramCloseableImage.getHeight();
        HashMap localHashMap = new HashMap(8);
        localHashMap.put("bitmapSize", paramCloseableImage);
        localHashMap.put("queueTime", str1);
        localHashMap.put("hasGoodQuality", paramQualityInfo);
        localHashMap.put("isFinal", str2);
        localHashMap.put("encodedImageSize", paramString2);
        localHashMap.put("imageFormat", paramString1);
        localHashMap.put("requestedImageSize", paramString3);
        localHashMap.put("sampleSize", paramString4);
        return ImmutableMap.copyOf(localHashMap);
      }
      paramCloseableImage = new HashMap(7);
      paramCloseableImage.put("queueTime", str1);
      paramCloseableImage.put("hasGoodQuality", paramQualityInfo);
      paramCloseableImage.put("isFinal", str2);
      paramCloseableImage.put("encodedImageSize", paramString2);
      paramCloseableImage.put("imageFormat", paramString1);
      paramCloseableImage.put("requestedImageSize", paramString3);
      paramCloseableImage.put("sampleSize", paramString4);
      return ImmutableMap.copyOf(paramCloseableImage);
    }
    
    private void handleCancellation()
    {
      maybeFinish(true);
      getConsumer().onCancellation();
    }
    
    private void handleError(Throwable paramThrowable)
    {
      maybeFinish(true);
      getConsumer().onFailure(paramThrowable);
    }
    
    private void handleResult(CloseableImage paramCloseableImage, boolean paramBoolean)
    {
      paramCloseableImage = CloseableReference.of(paramCloseableImage);
      try
      {
        maybeFinish(paramBoolean);
        getConsumer().onNewResult(paramCloseableImage, paramBoolean);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(paramCloseableImage);
      }
    }
    
    private boolean isFinished()
    {
      try
      {
        boolean bool = this.mIsFinished;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void maybeFinish(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        if (this.mIsFinished) {
          return;
        }
        getConsumer().onProgressUpdate(1.0F);
        this.mIsFinished = true;
        this.mJobScheduler.clearJob();
        return;
      }
      finally {}
    }
    
    protected abstract int getIntermediateImageEndOffset(EncodedImage paramEncodedImage);
    
    protected abstract QualityInfo getQualityInfo();
    
    public void onCancellationImpl()
    {
      handleCancellation();
    }
    
    public void onFailureImpl(Throwable paramThrowable)
    {
      handleError(paramThrowable);
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramBoolean) && (!EncodedImage.isValid(paramEncodedImage))) {
        handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
      }
      while ((!updateDecodeJob(paramEncodedImage, paramBoolean)) || ((!paramBoolean) && (!this.mProducerContext.isIntermediateResultExpected()))) {
        return;
      }
      this.mJobScheduler.scheduleJob();
    }
    
    protected void onProgressUpdateImpl(float paramFloat)
    {
      super.onProgressUpdateImpl(0.99F * paramFloat);
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      return this.mJobScheduler.updateJob(paramEncodedImage, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/DecodeProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */