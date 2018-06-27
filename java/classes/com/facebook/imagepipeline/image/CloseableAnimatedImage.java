package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

public class CloseableAnimatedImage
  extends CloseableImage
{
  private AnimatedImageResult mImageResult;
  
  public CloseableAnimatedImage(AnimatedImageResult paramAnimatedImageResult)
  {
    this.mImageResult = paramAnimatedImageResult;
  }
  
  public void close()
  {
    try
    {
      if (this.mImageResult == null) {
        return;
      }
      AnimatedImageResult localAnimatedImageResult = this.mImageResult;
      this.mImageResult = null;
      localAnimatedImageResult.dispose();
      return;
    }
    finally {}
  }
  
  /* Error */
  public int getHeight()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: invokeinterface 34 1 0
    //   29: istore_1
    //   30: goto -17 -> 13
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CloseableAnimatedImage
    //   12	18	1	i	int
    //   6	2	2	bool	boolean
    //   33	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  /* Error */
  public com.facebook.imagepipeline.animated.base.AnimatedImage getImage()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: astore_2
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	CloseableAnimatedImage
    //   6	2	1	bool	boolean
    //   12	13	2	localAnimatedImage	com.facebook.imagepipeline.animated.base.AnimatedImage
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  public AnimatedImageResult getImageResult()
  {
    try
    {
      AnimatedImageResult localAnimatedImageResult = this.mImageResult;
      return localAnimatedImageResult;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getSizeInBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: invokeinterface 39 1 0
    //   29: istore_1
    //   30: goto -17 -> 13
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CloseableAnimatedImage
    //   12	18	1	i	int
    //   6	2	2	bool	boolean
    //   33	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  /* Error */
  public int getWidth()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 26	com/facebook/imagepipeline/image/CloseableAnimatedImage:isClosed	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   21: invokevirtual 30	com/facebook/imagepipeline/animated/base/AnimatedImageResult:getImage	()Lcom/facebook/imagepipeline/animated/base/AnimatedImage;
    //   24: invokeinterface 42 1 0
    //   29: istore_1
    //   30: goto -17 -> 13
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	CloseableAnimatedImage
    //   12	18	1	i	int
    //   6	2	2	bool	boolean
    //   33	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   17	30	33	finally
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 13	com/facebook/imagepipeline/image/CloseableAnimatedImage:mImageResult	Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CloseableAnimatedImage
    //   12	7	1	bool	boolean
    //   6	2	2	localAnimatedImageResult	AnimatedImageResult
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean isStateful()
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/image/CloseableAnimatedImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */