package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class StagingArea
{
  private static final Class<?> TAG = StagingArea.class;
  @GuardedBy("this")
  private Map<CacheKey, EncodedImage> mMap = new HashMap();
  
  public static StagingArea getInstance()
  {
    return new StagingArea();
  }
  
  private void logStats()
  {
    try
    {
      FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void clearAll()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      int i = 0;
      while (i < localArrayList.size())
      {
        EncodedImage localEncodedImage = (EncodedImage)localArrayList.get(i);
        if (localEncodedImage != null) {
          localEncodedImage.close();
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean containsKey(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 86 2 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +9 -> 28
    //   22: iconst_0
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   32: aload_1
    //   33: invokeinterface 88 2 0
    //   38: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   41: astore_3
    //   42: aload_3
    //   43: monitorenter
    //   44: aload_3
    //   45: invokestatic 92	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   48: ifne +62 -> 110
    //   51: aload_0
    //   52: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   55: aload_1
    //   56: invokeinterface 95 2 0
    //   61: pop
    //   62: getstatic 17	com/facebook/imagepipeline/cache/StagingArea:TAG	Ljava/lang/Class;
    //   65: ldc 97
    //   67: iconst_3
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: invokestatic 103	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   77: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_1
    //   84: invokeinterface 109 1 0
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: aload_1
    //   93: invokestatic 103	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   96: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 113	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: monitorexit
    //   105: iconst_0
    //   106: istore_2
    //   107: goto -83 -> 24
    //   110: aload_3
    //   111: monitorexit
    //   112: iconst_1
    //   113: istore_2
    //   114: goto -90 -> 24
    //   117: astore_1
    //   118: aload_3
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	StagingArea
    //   0	127	1	paramCacheKey	CacheKey
    //   17	97	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   44	105	117	finally
    //   110	112	117	finally
    //   118	120	117	finally
    //   2	18	122	finally
    //   28	44	122	finally
    //   120	122	122	finally
  }
  
  /* Error */
  public EncodedImage get(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 88 2 0
    //   17: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: ifnull +68 -> 92
    //   27: aload_3
    //   28: monitorenter
    //   29: aload_3
    //   30: invokestatic 92	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   33: ifne +63 -> 96
    //   36: aload_0
    //   37: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 95 2 0
    //   46: pop
    //   47: getstatic 17	com/facebook/imagepipeline/cache/StagingArea:TAG	Ljava/lang/Class;
    //   50: ldc 97
    //   52: iconst_3
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_3
    //   59: invokestatic 103	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   62: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_1
    //   69: invokeinterface 109 1 0
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload_1
    //   78: invokestatic 103	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   81: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 113	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_3
    //   89: monitorexit
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: areturn
    //   96: aload_3
    //   97: invokestatic 118	com/facebook/imagepipeline/image/EncodedImage:cloneOrNull	(Lcom/facebook/imagepipeline/image/EncodedImage;)Lcom/facebook/imagepipeline/image/EncodedImage;
    //   100: astore_2
    //   101: aload_3
    //   102: monitorexit
    //   103: goto -11 -> 92
    //   106: astore_1
    //   107: aload_3
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	StagingArea
    //   0	116	1	paramCacheKey	CacheKey
    //   22	79	2	localEncodedImage1	EncodedImage
    //   20	88	3	localEncodedImage2	EncodedImage
    // Exception table:
    //   from	to	target	type
    //   29	90	106	finally
    //   96	103	106	finally
    //   107	109	106	finally
    //   2	21	111	finally
    //   27	29	111	finally
    //   109	111	111	finally
  }
  
  public void put(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage.closeSafely((EncodedImage)this.mMap.put(paramCacheKey, EncodedImage.cloneOrNull(paramEncodedImage)));
      logStats();
      return;
    }
    finally
    {
      paramCacheKey = finally;
      throw paramCacheKey;
    }
  }
  
  public boolean remove(CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    try
    {
      paramCacheKey = (EncodedImage)this.mMap.remove(paramCacheKey);
      if (paramCacheKey == null) {
        return false;
      }
    }
    finally {}
    try
    {
      boolean bool = paramCacheKey.isValid();
      return bool;
    }
    finally
    {
      paramCacheKey.close();
    }
  }
  
  /* Error */
  public boolean remove(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_2
    //   13: invokestatic 92	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   16: invokestatic 124	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   19: aload_0
    //   20: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 88 2 0
    //   29: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   32: astore 4
    //   34: aload 4
    //   36: ifnonnull +9 -> 45
    //   39: iconst_0
    //   40: istore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload 4
    //   47: invokevirtual 141	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   50: astore 5
    //   52: aload_2
    //   53: invokevirtual 141	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   56: astore_2
    //   57: aload 5
    //   59: ifnull +27 -> 86
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload 5
    //   68: invokevirtual 146	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   71: astore 6
    //   73: aload_2
    //   74: invokevirtual 146	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 6
    //   81: aload 7
    //   83: if_acmpeq +22 -> 105
    //   86: aload_2
    //   87: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   90: aload 5
    //   92: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   95: aload 4
    //   97: invokestatic 131	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   100: iconst_0
    //   101: istore_3
    //   102: goto -61 -> 41
    //   105: aload_0
    //   106: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   109: aload_1
    //   110: invokeinterface 95 2 0
    //   115: pop
    //   116: aload_2
    //   117: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   120: aload 5
    //   122: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   125: aload 4
    //   127: invokestatic 131	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   130: aload_0
    //   131: invokespecial 133	com/facebook/imagepipeline/cache/StagingArea:logStats	()V
    //   134: iconst_1
    //   135: istore_3
    //   136: goto -95 -> 41
    //   139: astore_1
    //   140: aload_2
    //   141: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   144: aload 5
    //   146: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   149: aload 4
    //   151: invokestatic 131	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	StagingArea
    //   0	161	1	paramCacheKey	CacheKey
    //   0	161	2	paramEncodedImage	EncodedImage
    //   40	96	3	bool	boolean
    //   32	118	4	localEncodedImage	EncodedImage
    //   50	95	5	localCloseableReference	com.facebook.common.references.CloseableReference
    //   71	9	6	localObject1	Object
    //   77	5	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   66	79	139	finally
    //   105	116	139	finally
    //   2	34	156	finally
    //   45	57	156	finally
    //   86	100	156	finally
    //   116	134	156	finally
    //   140	156	156	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/StagingArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */