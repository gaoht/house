package com.facebook.imagepipeline.cache;

import b.j;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache
{
  private static final Class<?> TAG = BufferedDiskCache.class;
  private final FileCache mFileCache;
  private final ImageCacheStatsTracker mImageCacheStatsTracker;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final PooledByteStreams mPooledByteStreams;
  private final Executor mReadExecutor;
  private final StagingArea mStagingArea;
  private final Executor mWriteExecutor;
  
  public BufferedDiskCache(FileCache paramFileCache, PooledByteBufferFactory paramPooledByteBufferFactory, PooledByteStreams paramPooledByteStreams, Executor paramExecutor1, Executor paramExecutor2, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    this.mFileCache = paramFileCache;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mPooledByteStreams = paramPooledByteStreams;
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
    this.mImageCacheStatsTracker = paramImageCacheStatsTracker;
    this.mStagingArea = StagingArea.getInstance();
  }
  
  private boolean checkInStagingAreaAndFileCache(CacheKey paramCacheKey)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
    {
      localEncodedImage.close();
      FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
      this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
      return true;
    }
    FLog.v(TAG, "Did not find image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaMiss();
    try
    {
      boolean bool = this.mFileCache.hasKey(paramCacheKey);
      return bool;
    }
    catch (Exception paramCacheKey) {}
    return false;
  }
  
  private j<Boolean> containsAsync(final CacheKey paramCacheKey)
  {
    try
    {
      j localj = j.call(new Callable()
      {
        public Boolean call()
          throws Exception
        {
          return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(paramCacheKey));
        }
      }, this.mReadExecutor);
      return localj;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.getUriString() });
      return j.forError(localException);
    }
  }
  
  private j<EncodedImage> foundPinnedImage(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
    return j.forResult(paramEncodedImage);
  }
  
  private j<EncodedImage> getAsync(final CacheKey paramCacheKey, final AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      paramAtomicBoolean = j.call(new Callable()
      {
        /* Error */
        public EncodedImage call()
          throws Exception
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
          //   4: invokevirtual 40	java/util/concurrent/atomic/AtomicBoolean:get	()Z
          //   7: ifeq +11 -> 18
          //   10: new 42	java/util/concurrent/CancellationException
          //   13: dup
          //   14: invokespecial 43	java/util/concurrent/CancellationException:<init>	()V
          //   17: athrow
          //   18: aload_0
          //   19: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   22: invokestatic 47	com/facebook/imagepipeline/cache/BufferedDiskCache:access$100	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;
          //   25: aload_0
          //   26: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   29: invokevirtual 52	com/facebook/imagepipeline/cache/StagingArea:get	(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/image/EncodedImage;
          //   32: astore_1
          //   33: aload_1
          //   34: ifnull +76 -> 110
          //   37: invokestatic 56	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   40: ldc 58
          //   42: aload_0
          //   43: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   46: invokeinterface 64 1 0
          //   51: invokestatic 70	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   54: aload_0
          //   55: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   58: invokestatic 74	com/facebook/imagepipeline/cache/BufferedDiskCache:access$300	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   61: aload_0
          //   62: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   65: invokeinterface 80 2 0
          //   70: aload_1
          //   71: aload_0
          //   72: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   75: invokevirtual 85	com/facebook/imagepipeline/image/EncodedImage:setEncodedCacheKey	(Lcom/facebook/cache/common/CacheKey;)V
          //   78: aload_1
          //   79: astore_2
          //   80: invokestatic 90	java/lang/Thread:interrupted	()Z
          //   83: ifeq +105 -> 188
          //   86: invokestatic 56	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   89: ldc 92
          //   91: invokestatic 95	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;)V
          //   94: aload_1
          //   95: ifnull +7 -> 102
          //   98: aload_1
          //   99: invokevirtual 98	com/facebook/imagepipeline/image/EncodedImage:close	()V
          //   102: new 100	java/lang/InterruptedException
          //   105: dup
          //   106: invokespecial 101	java/lang/InterruptedException:<init>	()V
          //   109: athrow
          //   110: invokestatic 56	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   113: ldc 103
          //   115: aload_0
          //   116: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   119: invokeinterface 64 1 0
          //   124: invokestatic 70	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   127: aload_0
          //   128: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   131: invokestatic 74	com/facebook/imagepipeline/cache/BufferedDiskCache:access$300	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   134: invokeinterface 106 1 0
          //   139: aload_0
          //   140: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   143: aload_0
          //   144: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   147: invokestatic 110	com/facebook/imagepipeline/cache/BufferedDiskCache:access$400	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/memory/PooledByteBuffer;
          //   150: invokestatic 116	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
          //   153: astore_2
          //   154: new 82	com/facebook/imagepipeline/image/EncodedImage
          //   157: dup
          //   158: aload_2
          //   159: invokespecial 119	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
          //   162: astore_1
          //   163: aload_1
          //   164: aload_0
          //   165: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   168: invokevirtual 85	com/facebook/imagepipeline/image/EncodedImage:setEncodedCacheKey	(Lcom/facebook/cache/common/CacheKey;)V
          //   171: aload_2
          //   172: invokestatic 122	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   175: goto -97 -> 78
          //   178: astore_1
          //   179: aload_2
          //   180: invokestatic 122	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   183: aload_1
          //   184: athrow
          //   185: astore_1
          //   186: aconst_null
          //   187: astore_2
          //   188: aload_2
          //   189: areturn
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	190	0	this	2
          //   32	132	1	localEncodedImage	EncodedImage
          //   178	6	1	localObject1	Object
          //   185	1	1	localException	Exception
          //   79	110	2	localObject2	Object
          // Exception table:
          //   from	to	target	type
          //   154	171	178	finally
          //   139	154	185	java/lang/Exception
          //   171	175	185	java/lang/Exception
          //   179	185	185	java/lang/Exception
        }
      }, this.mReadExecutor);
      return paramAtomicBoolean;
    }
    catch (Exception paramAtomicBoolean)
    {
      FLog.w(TAG, paramAtomicBoolean, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.getUriString() });
    }
    return j.forError(paramAtomicBoolean);
  }
  
  /* Error */
  private com.facebook.imagepipeline.memory.PooledByteBuffer readFromDiskCache(CacheKey paramCacheKey)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   3: ldc -85
    //   5: aload_1
    //   6: invokeinterface 111 1 0
    //   11: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 43	com/facebook/imagepipeline/cache/BufferedDiskCache:mFileCache	Lcom/facebook/cache/disk/FileCache;
    //   18: aload_1
    //   19: invokeinterface 175 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +28 -> 54
    //   29: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   32: ldc -79
    //   34: aload_1
    //   35: invokeinterface 111 1 0
    //   40: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   47: invokeinterface 180 1 0
    //   52: aconst_null
    //   53: areturn
    //   54: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   57: ldc -74
    //   59: aload_1
    //   60: invokeinterface 111 1 0
    //   65: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   72: invokeinterface 185 1 0
    //   77: aload_3
    //   78: invokeinterface 191 1 0
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 45	com/facebook/imagepipeline/cache/BufferedDiskCache:mPooledByteBufferFactory	Lcom/facebook/imagepipeline/memory/PooledByteBufferFactory;
    //   88: aload_2
    //   89: aload_3
    //   90: invokeinterface 195 1 0
    //   95: l2i
    //   96: invokeinterface 201 3 0
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 204	java/io/InputStream:close	()V
    //   106: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   109: ldc -50
    //   111: aload_1
    //   112: invokeinterface 111 1 0
    //   117: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   126: aload_2
    //   127: ldc -48
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: invokeinterface 111 1 0
    //   141: aastore
    //   142: invokestatic 150	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   149: invokeinterface 211 1 0
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aload_2
    //   158: invokevirtual 204	java/io/InputStream:close	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	BufferedDiskCache
    //   0	163	1	paramCacheKey	CacheKey
    //   83	20	2	localInputStream	java.io.InputStream
    //   122	36	2	localIOException	IOException
    //   24	97	3	localObject1	Object
    //   156	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	25	122	java/io/IOException
    //   29	52	122	java/io/IOException
    //   54	84	122	java/io/IOException
    //   102	120	122	java/io/IOException
    //   157	163	122	java/io/IOException
    //   84	102	156	finally
  }
  
  private void writeToDiskCache(CacheKey paramCacheKey, final EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "About to write to disk-cache for key %s", paramCacheKey.getUriString());
    try
    {
      this.mFileCache.insert(paramCacheKey, new WriterCallback()
      {
        public void write(OutputStream paramAnonymousOutputStream)
          throws IOException
        {
          BufferedDiskCache.this.mPooledByteStreams.copy(paramEncodedImage.getInputStream(), paramAnonymousOutputStream);
        }
      });
      FLog.v(TAG, "Successful disk-cache write for key %s", paramCacheKey.getUriString());
      return;
    }
    catch (IOException paramEncodedImage)
    {
      FLog.w(TAG, paramEncodedImage, "Failed to write to disk-cache for key %s", new Object[] { paramCacheKey.getUriString() });
    }
  }
  
  public j<Void> clearAll()
  {
    this.mStagingArea.clearAll();
    try
    {
      j localj = j.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.clearAll();
          BufferedDiskCache.this.mFileCache.clearAll();
          return null;
        }
      }, this.mWriteExecutor);
      return localj;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache clear", new Object[0]);
      return j.forError(localException);
    }
  }
  
  public j<Boolean> contains(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey)) {
      return j.forResult(Boolean.valueOf(true));
    }
    return containsAsync(paramCacheKey);
  }
  
  public boolean containsSync(CacheKey paramCacheKey)
  {
    return (this.mStagingArea.containsKey(paramCacheKey)) || (this.mFileCache.hasKeySync(paramCacheKey));
  }
  
  public boolean diskCheckSync(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey)) {
      return true;
    }
    return checkInStagingAreaAndFileCache(paramCacheKey);
  }
  
  public j<EncodedImage> get(CacheKey paramCacheKey, AtomicBoolean paramAtomicBoolean)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null) {
      return foundPinnedImage(paramCacheKey, localEncodedImage);
    }
    return getAsync(paramCacheKey, paramAtomicBoolean);
  }
  
  public void put(final CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    Preconditions.checkNotNull(paramCacheKey);
    Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
    this.mStagingArea.put(paramCacheKey, paramEncodedImage);
    paramEncodedImage.setEncodedCacheKey(paramCacheKey);
    final EncodedImage localEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
    try
    {
      this.mWriteExecutor.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            BufferedDiskCache.this.writeToDiskCache(paramCacheKey, localEncodedImage);
            return;
          }
          finally
          {
            BufferedDiskCache.this.mStagingArea.remove(paramCacheKey, localEncodedImage);
            EncodedImage.closeSafely(localEncodedImage);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache write for %s", new Object[] { paramCacheKey.getUriString() });
      this.mStagingArea.remove(paramCacheKey, paramEncodedImage);
      EncodedImage.closeSafely(localEncodedImage);
    }
  }
  
  public j<Void> remove(final CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    this.mStagingArea.remove(paramCacheKey);
    try
    {
      j localj = j.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.remove(paramCacheKey);
          BufferedDiskCache.this.mFileCache.remove(paramCacheKey);
          return null;
        }
      }, this.mWriteExecutor);
      return localj;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache remove for %s", new Object[] { paramCacheKey.getUriString() });
      return j.forError(localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/cache/BufferedDiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */