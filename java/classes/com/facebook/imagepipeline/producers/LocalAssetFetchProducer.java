package com.facebook.imagepipeline.producers;

import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalAssetFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalAssetFetchProducer";
  private final AssetManager mAssetManager;
  
  public LocalAssetFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, AssetManager paramAssetManager)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mAssetManager = paramAssetManager;
  }
  
  private static String getAssetName(ImageRequest paramImageRequest)
  {
    return paramImageRequest.getSourceUri().getPath().substring(1);
  }
  
  /* Error */
  private int getLength(ImageRequest paramImageRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/facebook/imagepipeline/producers/LocalAssetFetchProducer:mAssetManager	Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokestatic 44	com/facebook/imagepipeline/producers/LocalAssetFetchProducer:getAssetName	(Lcom/facebook/imagepipeline/request/ImageRequest;)Ljava/lang/String;
    //   8: invokevirtual 50	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 55	android/content/res/AssetFileDescriptor:getLength	()J
    //   16: lstore 4
    //   18: lload 4
    //   20: l2i
    //   21: istore_3
    //   22: iload_3
    //   23: istore_2
    //   24: aload_1
    //   25: ifnull +9 -> 34
    //   28: aload_1
    //   29: invokevirtual 59	android/content/res/AssetFileDescriptor:close	()V
    //   32: iload_3
    //   33: istore_2
    //   34: iload_2
    //   35: ireturn
    //   36: astore_1
    //   37: aconst_null
    //   38: astore_1
    //   39: iconst_m1
    //   40: istore_2
    //   41: aload_1
    //   42: ifnull -8 -> 34
    //   45: aload_1
    //   46: invokevirtual 59	android/content/res/AssetFileDescriptor:close	()V
    //   49: iconst_m1
    //   50: ireturn
    //   51: astore_1
    //   52: iconst_m1
    //   53: ireturn
    //   54: astore 6
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 59	android/content/res/AssetFileDescriptor:close	()V
    //   66: aload 6
    //   68: athrow
    //   69: astore_1
    //   70: iload_3
    //   71: ireturn
    //   72: astore_1
    //   73: goto -7 -> 66
    //   76: astore 6
    //   78: goto -20 -> 58
    //   81: astore 6
    //   83: goto -44 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	LocalAssetFetchProducer
    //   0	86	1	paramImageRequest	ImageRequest
    //   23	18	2	i	int
    //   21	50	3	j	int
    //   16	3	4	l	long
    //   54	13	6	localObject1	Object
    //   76	1	6	localObject2	Object
    //   81	1	6	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	12	36	java/io/IOException
    //   45	49	51	java/io/IOException
    //   0	12	54	finally
    //   28	32	69	java/io/IOException
    //   62	66	72	java/io/IOException
    //   12	18	76	finally
    //   12	18	81	java/io/IOException
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(this.mAssetManager.open(getAssetName(paramImageRequest), 2), getLength(paramImageRequest));
  }
  
  protected String getProducerName()
  {
    return "LocalAssetFetchProducer";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/LocalAssetFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */