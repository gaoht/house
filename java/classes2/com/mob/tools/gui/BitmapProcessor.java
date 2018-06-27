package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class BitmapProcessor
{
  private static final int CAPACITY = 3;
  private static final int MAX_CACHE_SIZE = 50;
  private static final int MAX_CACHE_TIME = 60000;
  private static final int MAX_REQ_TIME = 20000;
  private static final int MAX_SIZE = 100;
  private static final int OVERFLOW_SIZE = 120;
  private static final int SCAN_INTERVAL = 20000;
  private static File cacheDir;
  private static CachePool<String, SoftReference<Bitmap>> cachePool = new CachePool(50);
  private static ManagerThread manager;
  private static ArrayList<ImageReq> netReqTPS;
  private static ArrayList<ImageReq> reqList;
  private static NetworkHelper.NetworkTimeOut timeout = new NetworkHelper.NetworkTimeOut();
  private static boolean work;
  private static WorkerThread[] workerList;
  
  static
  {
    timeout.connectionTimeout = 5000;
    timeout.readTimout = (20000 - timeout.connectionTimeout);
    reqList = new ArrayList();
    netReqTPS = new ArrayList();
    workerList = new WorkerThread[3];
  }
  
  private static void deleteCacheDir()
  {
    try
    {
      File localFile = new File(cacheDir.getPath());
      if (localFile.isDirectory())
      {
        String[] arrayOfString = localFile.list();
        int i = 0;
        while (i < arrayOfString.length)
        {
          new File(localFile, arrayOfString[i]).delete();
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public static void deleteCacheDir(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      deleteCacheDir();
      return;
    }
    new Thread()
    {
      public void run() {}
    }.start();
  }
  
  public static void deleteCachedFile(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions)
  {
    removeBitmapFromRamCache(paramString, paramBitmapDesiredOptions);
    try
    {
      new File(cacheDir, Data.MD5(paramString)).delete();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public static Bitmap getBitmapFromCache(String paramString)
  {
    return getBitmapFromCache(paramString, null);
  }
  
  public static Bitmap getBitmapFromCache(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions)
  {
    if ((cachePool == null) || (paramString == null) || (cachePool.get(getCacheKey(paramString, paramBitmapDesiredOptions)) == null)) {
      return null;
    }
    return (Bitmap)((SoftReference)cachePool.get(getCacheKey(paramString, paramBitmapDesiredOptions))).get();
  }
  
  private static String getCacheKey(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions)
  {
    if (paramBitmapDesiredOptions == null) {
      return paramString;
    }
    return paramString + paramBitmapDesiredOptions.toString();
  }
  
  public static long getCacheSizeInByte()
  {
    Object localObject = new File(cacheDir.getPath());
    long l = 0L;
    localObject = ((File)localObject).listFiles();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      l += localObject[i].length();
      i += 1;
    }
    return l;
  }
  
  public static String getCacheSizeText()
  {
    float f = (float)getCacheSizeInByte();
    if (f < 1024.0F) {
      return String.format(Locale.CHINA, "%.02f", new Object[] { Float.valueOf(f) }) + " B";
    }
    if (f / 1024.0F < 1000.0F) {
      return String.format(Locale.CHINA, "%.02f", new Object[] { Float.valueOf(f / 1024.0F) }) + " KB";
    }
    return String.format(Locale.CHINA, "%.02f", new Object[] { Float.valueOf(f / 1024.0F / 1204.0F) }) + " MB";
  }
  
  public static void prepare(Context paramContext)
  {
    try
    {
      cacheDir = new File(ResHelper.getImageCachePath(paramContext));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void process(String paramString, BitmapCallback paramBitmapCallback)
  {
    try
    {
      process(paramString, null, paramBitmapCallback);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void process(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions, BitmapCallback paramBitmapCallback)
  {
    try
    {
      process(paramString, paramBitmapDesiredOptions, true, paramBitmapCallback);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void process(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions, boolean paramBoolean, BitmapCallback paramBitmapCallback)
  {
    try
    {
      process(paramString, paramBitmapDesiredOptions, paramBoolean, true, paramBitmapCallback);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void process(String arg0, BitmapDesiredOptions paramBitmapDesiredOptions, boolean paramBoolean1, boolean paramBoolean2, long paramLong, BitmapCallback paramBitmapCallback)
  {
    if (??? == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        synchronized (reqList)
        {
          int k = reqList.size();
          i = 0;
          if (i >= k) {
            break label172;
          }
          ImageReq localImageReq = (ImageReq)reqList.get(i);
          boolean bool = localImageReq.url.equals(???);
          if ((localImageReq.bitmapDesiredOptions == null) && (paramBitmapDesiredOptions == null)) {
            break label297;
          }
          if ((localImageReq.bitmapDesiredOptions != null) && (localImageReq.bitmapDesiredOptions.equals(paramBitmapDesiredOptions)))
          {
            break label297;
            if ((!bool) || (j == 0)) {
              break label163;
            }
            if ((paramBitmapCallback != null) && (localImageReq.callbacks.indexOf(paramBitmapCallback) == -1)) {
              localImageReq.callbacks.add(paramBitmapCallback);
            }
            start();
          }
        }
        j = 0;
      }
      finally {}
      continue;
      label163:
      i += 1;
      continue;
      label172:
      ??? = new ImageReq();
      ImageReq.access$002((ImageReq)???, ???);
      ImageReq.access$102((ImageReq)???, paramBitmapDesiredOptions);
      ImageReq.access$302((ImageReq)???, paramBoolean1);
      ImageReq.access$402((ImageReq)???, paramLong);
      ImageReq.access$502((ImageReq)???, paramBoolean2);
      if (paramBitmapCallback != null) {
        ((ImageReq)???).callbacks.add(paramBitmapCallback);
      }
      synchronized (reqList)
      {
        reqList.add(???);
        if ((reqList.size() > 120) && (reqList.size() > 100)) {
          reqList.remove(0);
        }
      }
      start();
      break;
      label297:
      int j = 1;
    }
  }
  
  public static void process(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions, boolean paramBoolean1, boolean paramBoolean2, BitmapCallback paramBitmapCallback)
  {
    try
    {
      process(paramString, paramBitmapDesiredOptions, paramBoolean1, paramBoolean2, 0L, paramBitmapCallback);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void removeBitmapFromRamCache(String paramString, BitmapDesiredOptions paramBitmapDesiredOptions)
  {
    if (cachePool != null) {
      cachePool.put(getCacheKey(paramString, paramBitmapDesiredOptions), null);
    }
  }
  
  public static void start()
  {
    try
    {
      if (!work)
      {
        work = true;
        manager = new ManagerThread();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static void stop()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 100	com/mob/tools/gui/BitmapProcessor:work	Z
    //   6: ifeq +33 -> 39
    //   9: iconst_0
    //   10: putstatic 100	com/mob/tools/gui/BitmapProcessor:work	Z
    //   13: getstatic 79	com/mob/tools/gui/BitmapProcessor:reqList	Ljava/util/ArrayList;
    //   16: astore_0
    //   17: aload_0
    //   18: monitorenter
    //   19: getstatic 79	com/mob/tools/gui/BitmapProcessor:reqList	Ljava/util/ArrayList;
    //   22: invokevirtual 314	java/util/ArrayList:clear	()V
    //   25: getstatic 90	com/mob/tools/gui/BitmapProcessor:cachePool	Lcom/mob/tools/gui/CachePool;
    //   28: invokevirtual 315	com/mob/tools/gui/CachePool:clear	()V
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 310	com/mob/tools/gui/BitmapProcessor:manager	Lcom/mob/tools/gui/BitmapProcessor$ManagerThread;
    //   36: invokevirtual 318	com/mob/tools/gui/BitmapProcessor$ManagerThread:quit	()V
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	5	0	localObject1	Object
    //   43	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	33	43	finally
    //   44	46	43	finally
    //   3	19	48	finally
    //   33	39	48	finally
    //   46	48	48	finally
  }
  
  public static abstract interface BitmapCallback
  {
    public abstract void onImageGot(String paramString, Bitmap paramBitmap);
  }
  
  public static class BitmapDesiredOptions
  {
    public int desiredHeight = 0;
    public int desiredWidth = 0;
    public long maxBytes = 0L;
    public int quality = 0;
    
    public boolean equals(Object paramObject)
    {
      return (super.equals(paramObject)) || ((paramObject != null) && (paramObject.toString().equals(toString())));
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.desiredWidth > 0) {
        localStringBuilder.append(this.desiredWidth);
      }
      if (this.desiredHeight > 0) {
        localStringBuilder.append(this.desiredHeight);
      }
      if (this.maxBytes > 0L) {
        localStringBuilder.append(this.maxBytes);
      }
      if (this.quality > 0) {
        localStringBuilder.append(this.quality);
      }
      return localStringBuilder.toString();
    }
  }
  
  public static class ImageReq
  {
    private BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions;
    private ArrayList<BitmapProcessor.BitmapCallback> callbacks = new ArrayList();
    private long diskCacheTime = 0L;
    private long reqTime = System.currentTimeMillis();
    private String url;
    private boolean useDiskCache = true;
    private boolean useRamCache = true;
    private BitmapProcessor.WorkerThread worker;
    
    private void throwComplete(Bitmap paramBitmap)
    {
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((BitmapProcessor.BitmapCallback)localIterator.next()).onImageGot(this.url, paramBitmap);
      }
      this.callbacks.clear();
    }
    
    private void throwError()
    {
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext()) {
        ((BitmapProcessor.BitmapCallback)localIterator.next()).onImageGot(this.url, null);
      }
      this.callbacks.clear();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url=").append(this.url);
      localStringBuilder.append("time=").append(this.reqTime);
      localStringBuilder.append("worker=").append(this.worker.getName()).append(" (").append(this.worker.getId()).append("");
      return localStringBuilder.toString();
    }
  }
  
  private static class ManagerThread
    implements Handler.Callback
  {
    private Handler handler = MobHandlerThread.newHandler(new Runnable()
    {
      public void run()
      {
        int i = 0;
        if (i < BitmapProcessor.workerList.length)
        {
          BitmapProcessor.WorkerThread localWorkerThread;
          if (BitmapProcessor.workerList[i] == null)
          {
            BitmapProcessor.workerList[i] = new BitmapProcessor.WorkerThread(null);
            BitmapProcessor.workerList[i].setName("worker " + i);
            localWorkerThread = BitmapProcessor.workerList[i];
            if (i != 0) {
              break label91;
            }
          }
          label91:
          for (boolean bool = true;; bool = false)
          {
            BitmapProcessor.WorkerThread.access$902(localWorkerThread, bool);
            BitmapProcessor.workerList[i].start();
            i += 1;
            break;
          }
        }
      }
    }, this);
    
    public ManagerThread()
    {
      this.handler.sendEmptyMessageDelayed(1, 20000L);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      if (BitmapProcessor.cachePool != null) {
        BitmapProcessor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000L);
      }
      if (BitmapProcessor.cachePool == null)
      {
        i = 0;
        MobLog.getInstance().d(">>>> BitmapProcessor.cachePool: " + i, new Object[0]);
        if (BitmapProcessor.reqList != null) {
          break label125;
        }
      }
      label125:
      for (int i = 0;; i = BitmapProcessor.reqList.size())
      {
        MobLog.getInstance().d(">>>> BitmapProcessor.reqList: " + i, new Object[0]);
        if (BitmapProcessor.work) {
          this.handler.sendEmptyMessageDelayed(1, 20000L);
        }
        return false;
        i = BitmapProcessor.cachePool.size();
        break;
      }
    }
    
    public void quit()
    {
      this.handler.removeMessages(1);
      this.handler.getLooper().quit();
      int i = 0;
      while (i < BitmapProcessor.workerList.length)
      {
        if (BitmapProcessor.workerList[i] != null)
        {
          BitmapProcessor.workerList[i].interrupt();
          BitmapProcessor.workerList[i] = null;
        }
        i += 1;
      }
    }
  }
  
  private static class PatchInputStream
    extends FilterInputStream
  {
    InputStream in;
    
    protected PatchInputStream(InputStream paramInputStream)
    {
      super();
      this.in = paramInputStream;
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L;; l1 += l2) {
        if (l1 < paramLong)
        {
          l2 = this.in.skip(paramLong - l1);
          if (l2 != 0L) {}
        }
        else
        {
          return l1;
        }
      }
    }
  }
  
  private static class WorkerThread
    extends Thread
  {
    private BitmapProcessor.ImageReq curReq;
    private boolean localType;
    
    private void doLocalTask()
      throws Throwable
    {
      for (;;)
      {
        synchronized (BitmapProcessor.reqList)
        {
          if (BitmapProcessor.reqList.size() <= 0) {
            break label236;
          }
          BitmapProcessor.ImageReq localImageReq1 = (BitmapProcessor.ImageReq)BitmapProcessor.reqList.remove(0);
          if (localImageReq1 == null) {
            break label222;
          }
          if (!localImageReq1.useRamCache) {
            break label231;
          }
          ??? = (SoftReference)BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(localImageReq1.url, localImageReq1.bitmapDesiredOptions));
          if (??? == null)
          {
            ??? = null;
            if (??? == null) {
              break label106;
            }
            this.curReq = localImageReq1;
            BitmapProcessor.ImageReq.access$1402(this.curReq, this);
            localImageReq1.throwComplete((Bitmap)???);
            return;
          }
        }
        ??? = (Bitmap)((SoftReference)???).get();
        continue;
        label106:
        if ((localImageReq2.useDiskCache) && (BitmapProcessor.cacheDir != null) && (new File(BitmapProcessor.cacheDir, Data.MD5(localImageReq2.url)).exists()))
        {
          doTask(localImageReq2);
          return;
        }
        synchronized (BitmapProcessor.reqList)
        {
          if (BitmapProcessor.netReqTPS.size() <= 100) {
            break label211;
          }
          synchronized (BitmapProcessor.reqList)
          {
            if (BitmapProcessor.reqList.size() > 0) {
              BitmapProcessor.reqList.remove(0);
            }
          }
        }
        BitmapProcessor.netReqTPS.remove(0);
        label211:
        BitmapProcessor.netReqTPS.add(localObject4);
        return;
        try
        {
          label222:
          Thread.sleep(30L);
          return;
        }
        catch (Throwable localThrowable)
        {
          return;
        }
        label231:
        Object localObject2 = null;
        continue;
        label236:
        Object localObject5 = null;
      }
    }
    
    private void doNetworkTask()
      throws Throwable
    {
      for (;;)
      {
        Object localObject1;
        synchronized (BitmapProcessor.netReqTPS)
        {
          if (BitmapProcessor.netReqTPS.size() <= 0) {
            break label170;
          }
          localObject1 = (BitmapProcessor.ImageReq)BitmapProcessor.netReqTPS.remove(0);
          if (localObject1 != null) {}
        }
        for (;;)
        {
          synchronized (BitmapProcessor.reqList)
          {
            if (BitmapProcessor.reqList.size() > 0) {
              localObject1 = (BitmapProcessor.ImageReq)BitmapProcessor.reqList.remove(0);
            }
            ??? = localObject1;
            if (??? == null) {
              break label151;
            }
            if (!((BitmapProcessor.ImageReq)???).useRamCache) {
              break label160;
            }
            localObject1 = (SoftReference)BitmapProcessor.cachePool.get(BitmapProcessor.getCacheKey(((BitmapProcessor.ImageReq)???).url, ((BitmapProcessor.ImageReq)???).bitmapDesiredOptions));
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject1 == null) {
                break label145;
              }
              this.curReq = ((BitmapProcessor.ImageReq)???);
              BitmapProcessor.ImageReq.access$1402(this.curReq, this);
              ((BitmapProcessor.ImageReq)???).throwComplete((Bitmap)localObject1);
              return;
              localObject2 = finally;
              throw ((Throwable)localObject2);
            }
          }
          Bitmap localBitmap = (Bitmap)((SoftReference)localObject3).get();
          continue;
          label145:
          doTask((BitmapProcessor.ImageReq)???);
          return;
          try
          {
            label151:
            Thread.sleep(30L);
            return;
          }
          catch (Throwable localThrowable)
          {
            return;
          }
          label160:
          localObject4 = null;
          continue;
          ??? = localObject4;
        }
        label170:
        Object localObject4 = null;
      }
    }
    
    private void doTask(final BitmapProcessor.ImageReq paramImageReq)
      throws Throwable
    {
      try
      {
        this.curReq = paramImageReq;
        BitmapProcessor.ImageReq.access$1402(this.curReq, this);
        Object localObject = Data.MD5(paramImageReq.url);
        File localFile = new File(BitmapProcessor.cacheDir, (String)localObject);
        if ((paramImageReq.useDiskCache) && (paramImageReq.diskCacheTime > 0L) && (localFile.exists()))
        {
          long l1 = localFile.lastModified();
          long l2 = System.currentTimeMillis();
          if (l1 + paramImageReq.diskCacheTime < l2) {
            localFile.delete();
          }
        }
        if ((paramImageReq.useDiskCache) && (BitmapProcessor.cacheDir != null) && (localFile.exists()))
        {
          if ((paramImageReq.bitmapDesiredOptions == null) || (paramImageReq.bitmapDesiredOptions.equals("")))
          {
            localObject = BitmapHelper.getBitmap(localFile.getAbsolutePath());
            if (localObject == null) {
              break label242;
            }
            if (paramImageReq.useRamCache) {
              BitmapProcessor.cachePool.put(BitmapProcessor.getCacheKey(paramImageReq.url, paramImageReq.bitmapDesiredOptions), new SoftReference(localObject));
            }
            paramImageReq.throwComplete((Bitmap)localObject);
          }
          for (;;)
          {
            this.curReq = null;
            return;
            localObject = BitmapHelper.getBitmapByCompressQuality(new File(BitmapProcessor.cacheDir, (String)localObject).getAbsolutePath(), paramImageReq.bitmapDesiredOptions.desiredWidth, paramImageReq.bitmapDesiredOptions.desiredHeight, paramImageReq.bitmapDesiredOptions.quality, paramImageReq.bitmapDesiredOptions.maxBytes);
            break;
            label242:
            paramImageReq.throwError();
          }
        }
        new NetworkHelper().rawGet(paramImageReq.url, new RawNetworkCallback()
        {
          public void onResponse(InputStream paramAnonymousInputStream)
            throws Throwable
          {
            paramAnonymousInputStream = new BitmapProcessor.PatchInputStream(paramAnonymousInputStream);
            File localFile;
            Object localObject;
            if (BitmapProcessor.cacheDir != null)
            {
              localFile = new File(BitmapProcessor.cacheDir, localThrowable);
              BitmapProcessor.WorkerThread.this.saveFile(paramAnonymousInputStream, localFile);
              if ((paramImageReq.bitmapDesiredOptions == null) || (paramImageReq.bitmapDesiredOptions.equals("")))
              {
                paramAnonymousInputStream = BitmapHelper.getBitmap(localFile, 1);
                localObject = paramAnonymousInputStream;
                if (!paramImageReq.useDiskCache)
                {
                  localFile.delete();
                  localObject = paramAnonymousInputStream;
                }
                label89:
                if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
                  break label177;
                }
                paramImageReq.throwError();
              }
            }
            for (;;)
            {
              BitmapProcessor.WorkerThread.access$2002(BitmapProcessor.WorkerThread.this, null);
              return;
              paramAnonymousInputStream = BitmapHelper.getBitmapByCompressQuality(localFile.getAbsolutePath(), paramImageReq.bitmapDesiredOptions.desiredWidth, paramImageReq.bitmapDesiredOptions.desiredHeight, paramImageReq.bitmapDesiredOptions.quality, paramImageReq.bitmapDesiredOptions.maxBytes);
              break;
              localObject = BitmapHelper.getBitmap(paramAnonymousInputStream, 1);
              break label89;
              label177:
              if (paramImageReq.useRamCache) {
                BitmapProcessor.cachePool.put(BitmapProcessor.getCacheKey(paramImageReq.url, paramImageReq.bitmapDesiredOptions), new SoftReference(localObject));
              }
              paramImageReq.throwComplete((Bitmap)localObject);
            }
          }
        }, BitmapProcessor.timeout);
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        paramImageReq.throwError();
        this.curReq = null;
        return;
      }
    }
    
    /* Error */
    private void saveFile(InputStream paramInputStream, File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_2
      //   4: invokevirtual 116	java/io/File:exists	()Z
      //   7: ifeq +8 -> 15
      //   10: aload_2
      //   11: invokevirtual 151	java/io/File:delete	()Z
      //   14: pop
      //   15: aload_2
      //   16: invokevirtual 225	java/io/File:getParentFile	()Ljava/io/File;
      //   19: invokevirtual 116	java/io/File:exists	()Z
      //   22: ifne +11 -> 33
      //   25: aload_2
      //   26: invokevirtual 225	java/io/File:getParentFile	()Ljava/io/File;
      //   29: invokevirtual 228	java/io/File:mkdirs	()Z
      //   32: pop
      //   33: aload_2
      //   34: invokevirtual 231	java/io/File:createNewFile	()Z
      //   37: pop
      //   38: new 233	java/io/FileOutputStream
      //   41: dup
      //   42: aload_2
      //   43: invokespecial 236	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   46: astore 4
      //   48: sipush 256
      //   51: newarray <illegal type>
      //   53: astore 5
      //   55: aload_1
      //   56: aload 5
      //   58: invokevirtual 242	java/io/InputStream:read	([B)I
      //   61: istore_3
      //   62: iload_3
      //   63: ifle +22 -> 85
      //   66: aload 4
      //   68: aload 5
      //   70: iconst_0
      //   71: iload_3
      //   72: invokevirtual 246	java/io/FileOutputStream:write	([BII)V
      //   75: aload_1
      //   76: aload 5
      //   78: invokevirtual 242	java/io/InputStream:read	([B)I
      //   81: istore_3
      //   82: goto -20 -> 62
      //   85: aload 4
      //   87: invokevirtual 249	java/io/FileOutputStream:flush	()V
      //   90: aload 4
      //   92: invokevirtual 252	java/io/FileOutputStream:close	()V
      //   95: aload_1
      //   96: invokevirtual 253	java/io/InputStream:close	()V
      //   99: return
      //   100: astore 4
      //   102: aload 5
      //   104: astore 4
      //   106: aload_2
      //   107: invokevirtual 116	java/io/File:exists	()Z
      //   110: ifeq +8 -> 118
      //   113: aload_2
      //   114: invokevirtual 151	java/io/File:delete	()Z
      //   117: pop
      //   118: aload 4
      //   120: invokevirtual 252	java/io/FileOutputStream:close	()V
      //   123: aload_1
      //   124: invokevirtual 253	java/io/InputStream:close	()V
      //   127: return
      //   128: astore_1
      //   129: return
      //   130: astore_2
      //   131: aconst_null
      //   132: astore 4
      //   134: aload 4
      //   136: invokevirtual 252	java/io/FileOutputStream:close	()V
      //   139: aload_1
      //   140: invokevirtual 253	java/io/InputStream:close	()V
      //   143: aload_2
      //   144: athrow
      //   145: astore_1
      //   146: goto -3 -> 143
      //   149: astore_2
      //   150: goto -16 -> 134
      //   153: astore_2
      //   154: goto -20 -> 134
      //   157: astore 5
      //   159: goto -53 -> 106
      //   162: astore_1
      //   163: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	164	0	this	WorkerThread
      //   0	164	1	paramInputStream	InputStream
      //   0	164	2	paramFile	File
      //   61	21	3	i	int
      //   46	45	4	localFileOutputStream	java.io.FileOutputStream
      //   100	1	4	localThrowable1	Throwable
      //   104	31	4	arrayOfByte1	byte[]
      //   1	102	5	arrayOfByte2	byte[]
      //   157	1	5	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   3	15	100	java/lang/Throwable
      //   15	33	100	java/lang/Throwable
      //   33	48	100	java/lang/Throwable
      //   118	127	128	java/lang/Throwable
      //   3	15	130	finally
      //   15	33	130	finally
      //   33	48	130	finally
      //   134	143	145	java/lang/Throwable
      //   48	62	149	finally
      //   66	82	149	finally
      //   85	90	149	finally
      //   106	118	153	finally
      //   48	62	157	java/lang/Throwable
      //   66	82	157	java/lang/Throwable
      //   85	90	157	java/lang/Throwable
      //   90	99	162	java/lang/Throwable
    }
    
    public void interrupt()
    {
      try
      {
        super.interrupt();
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    public void run()
    {
      while (BitmapProcessor.work)
      {
        try
        {
          if (!this.localType) {
            break label32;
          }
          doLocalTask();
        }
        catch (Throwable localThrowable)
        {
          MobLog.getInstance().w(localThrowable);
        }
        continue;
        label32:
        doNetworkTask();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/BitmapProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */