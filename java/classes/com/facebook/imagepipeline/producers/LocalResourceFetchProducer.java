package com.facebook.imagepipeline.producers;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalResourceFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalResourceFetchProducer";
  private final Resources mResources;
  
  public LocalResourceFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, Resources paramResources)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mResources = paramResources;
  }
  
  /* Error */
  private int getLength(ImageRequest paramImageRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/facebook/imagepipeline/producers/LocalResourceFetchProducer:mResources	Landroid/content/res/Resources;
    //   4: aload_1
    //   5: invokestatic 27	com/facebook/imagepipeline/producers/LocalResourceFetchProducer:getResourceId	(Lcom/facebook/imagepipeline/request/ImageRequest;)I
    //   8: invokevirtual 33	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 38	android/content/res/AssetFileDescriptor:getLength	()J
    //   16: lstore 4
    //   18: lload 4
    //   20: l2i
    //   21: istore_3
    //   22: iload_3
    //   23: istore_2
    //   24: aload_1
    //   25: ifnull +9 -> 34
    //   28: aload_1
    //   29: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
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
    //   46: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
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
    //   63: invokevirtual 42	android/content/res/AssetFileDescriptor:close	()V
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
    //   0	86	0	this	LocalResourceFetchProducer
    //   0	86	1	paramImageRequest	ImageRequest
    //   23	18	2	i	int
    //   21	50	3	j	int
    //   16	3	4	l	long
    //   54	13	6	localObject1	Object
    //   76	1	6	localObject2	Object
    //   81	1	6	localNotFoundException	android.content.res.Resources.NotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	12	36	android/content/res/Resources$NotFoundException
    //   45	49	51	java/io/IOException
    //   0	12	54	finally
    //   28	32	69	java/io/IOException
    //   62	66	72	java/io/IOException
    //   12	18	76	finally
    //   12	18	81	android/content/res/Resources$NotFoundException
  }
  
  private static int getResourceId(ImageRequest paramImageRequest)
  {
    return Integer.parseInt(paramImageRequest.getSourceUri().getPath().substring(1));
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(this.mResources.openRawResource(getResourceId(paramImageRequest)), getLength(paramImageRequest));
  }
  
  protected String getProducerName()
  {
    return "LocalResourceFetchProducer";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/LocalResourceFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */