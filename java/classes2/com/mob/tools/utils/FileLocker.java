package com.mob.tools.utils;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLocker
{
  private FileOutputStream fos;
  private FileLock lock;
  
  private boolean getLock(boolean paramBoolean)
    throws Throwable
  {
    if (paramBoolean) {}
    for (this.lock = this.fos.getChannel().lock(); this.lock != null; this.lock = this.fos.getChannel().tryLock()) {
      return true;
    }
    return false;
  }
  
  public void lock(Runnable paramRunnable, boolean paramBoolean)
  {
    try
    {
      if ((lock(paramBoolean)) && (paramRunnable != null)) {
        paramRunnable.run();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean lock(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +21 -> 24
    //   6: ldc2_w 45
    //   9: lstore_2
    //   10: aload_0
    //   11: iload_1
    //   12: lload_2
    //   13: ldc2_w 47
    //   16: invokevirtual 51	com/mob/tools/utils/FileLocker:lock	(ZJJ)Z
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: ldc2_w 52
    //   27: lstore_2
    //   28: goto -18 -> 10
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	FileLocker
    //   0	38	1	paramBoolean	boolean
    //   9	19	2	l	long
    //   31	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	20	31	finally
  }
  
  /* Error */
  public boolean lock(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   6: astore 13
    //   8: aload 13
    //   10: ifnonnull +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: iload_1
    //   21: invokespecial 55	com/mob/tools/utils/FileLocker:getLock	(Z)Z
    //   24: istore 6
    //   26: iload 6
    //   28: istore_1
    //   29: goto -14 -> 15
    //   32: astore 13
    //   34: lload_2
    //   35: lconst_0
    //   36: lcmp
    //   37: ifle +173 -> 210
    //   40: aload 13
    //   42: instanceof 57
    //   45: ifeq +165 -> 210
    //   48: invokestatic 63	android/os/SystemClock:elapsedRealtime	()J
    //   51: lstore 11
    //   53: lload_2
    //   54: lstore 7
    //   56: lload 7
    //   58: lconst_0
    //   59: lcmp
    //   60: ifle +184 -> 244
    //   63: lload 4
    //   65: invokestatic 69	java/lang/Thread:sleep	(J)V
    //   68: lload_2
    //   69: lload 11
    //   71: ladd
    //   72: invokestatic 63	android/os/SystemClock:elapsedRealtime	()J
    //   75: lsub
    //   76: lstore 9
    //   78: lload 9
    //   80: lstore 7
    //   82: aload_0
    //   83: iload_1
    //   84: invokespecial 55	com/mob/tools/utils/FileLocker:getLock	(Z)Z
    //   87: istore 6
    //   89: iload 6
    //   91: istore_1
    //   92: lload 9
    //   94: lstore 7
    //   96: lload 7
    //   98: lconst_0
    //   99: lcmp
    //   100: ifgt -85 -> 15
    //   103: aload_0
    //   104: getfield 32	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   107: astore 13
    //   109: aload 13
    //   111: ifnull +15 -> 126
    //   114: aload_0
    //   115: getfield 32	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   118: invokevirtual 74	java/nio/channels/FileLock:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 32	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   126: aload_0
    //   127: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   130: astore 13
    //   132: aload 13
    //   134: ifnull +115 -> 249
    //   137: aload_0
    //   138: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   141: invokevirtual 77	java/io/FileOutputStream:close	()V
    //   144: aload_0
    //   145: aconst_null
    //   146: putfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   149: goto +100 -> 249
    //   152: astore 14
    //   154: lload 7
    //   156: lstore 9
    //   158: aload 14
    //   160: instanceof 57
    //   163: ifeq +30 -> 193
    //   166: lload 9
    //   168: lstore 7
    //   170: lload 9
    //   172: lconst_0
    //   173: lcmp
    //   174: ifgt +80 -> 254
    //   177: invokestatic 83	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   180: ldc 85
    //   182: invokevirtual 91	com/mob/tools/log/NLog:w	(Ljava/lang/String;)I
    //   185: pop
    //   186: lload 9
    //   188: lstore 7
    //   190: goto +64 -> 254
    //   193: invokestatic 83	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   196: aload 13
    //   198: invokevirtual 94	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   201: pop
    //   202: ldc2_w 95
    //   205: lstore 7
    //   207: goto +47 -> 254
    //   210: invokestatic 83	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   213: aload 13
    //   215: invokevirtual 94	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   218: pop
    //   219: goto -116 -> 103
    //   222: astore 13
    //   224: aload_0
    //   225: monitorexit
    //   226: aload 13
    //   228: athrow
    //   229: astore 14
    //   231: goto -163 -> 68
    //   234: astore 13
    //   236: goto -92 -> 144
    //   239: astore 13
    //   241: goto -120 -> 121
    //   244: iconst_0
    //   245: istore_1
    //   246: goto -150 -> 96
    //   249: iconst_0
    //   250: istore_1
    //   251: goto -236 -> 15
    //   254: goto -198 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	FileLocker
    //   0	257	1	paramBoolean	boolean
    //   0	257	2	paramLong1	long
    //   0	257	4	paramLong2	long
    //   24	66	6	bool	boolean
    //   54	152	7	l1	long
    //   76	111	9	l2	long
    //   51	19	11	l3	long
    //   6	3	13	localFileOutputStream	FileOutputStream
    //   32	9	13	localThrowable1	Throwable
    //   107	107	13	localObject1	Object
    //   222	5	13	localObject2	Object
    //   234	1	13	localThrowable2	Throwable
    //   239	1	13	localThrowable3	Throwable
    //   152	7	14	localThrowable4	Throwable
    //   229	1	14	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	26	32	java/lang/Throwable
    //   68	78	152	java/lang/Throwable
    //   82	89	152	java/lang/Throwable
    //   2	8	222	finally
    //   19	26	222	finally
    //   40	53	222	finally
    //   63	68	222	finally
    //   68	78	222	finally
    //   82	89	222	finally
    //   103	109	222	finally
    //   114	121	222	finally
    //   121	126	222	finally
    //   126	132	222	finally
    //   137	144	222	finally
    //   144	149	222	finally
    //   158	166	222	finally
    //   177	186	222	finally
    //   193	202	222	finally
    //   210	219	222	finally
    //   63	68	229	java/lang/Throwable
    //   137	144	234	java/lang/Throwable
    //   114	121	239	java/lang/Throwable
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 99	com/mob/tools/utils/FileLocker:unlock	()V
    //   18: aload_0
    //   19: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   22: invokevirtual 77	java/io/FileOutputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    //   38: astore_1
    //   39: goto -14 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	FileLocker
    //   6	2	1	localFileOutputStream	FileOutputStream
    //   33	4	1	localObject	Object
    //   38	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   14	18	33	finally
    //   18	25	33	finally
    //   25	30	33	finally
    //   18	25	38	java/lang/Throwable
  }
  
  /* Error */
  public void setLockFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 21	java/io/FileOutputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: putfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull -10 -> 14
    //   27: aload_0
    //   28: getfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   31: invokevirtual 77	java/io/FileOutputStream:close	()V
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 19	com/mob/tools/utils/FileLocker:fos	Ljava/io/FileOutputStream;
    //   39: goto -25 -> 14
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: goto -14 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	FileLocker
    //   0	51	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	17	java/lang/Throwable
    //   2	14	42	finally
    //   18	23	42	finally
    //   27	34	42	finally
    //   34	39	42	finally
    //   27	34	47	java/lang/Throwable
  }
  
  /* Error */
  public void unlock()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 32	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   18: invokevirtual 74	java/nio/channels/FileLock:release	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 32	com/mob/tools/utils/FileLocker:lock	Ljava/nio/channels/FileLock;
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    //   34: astore_1
    //   35: goto -14 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	FileLocker
    //   6	2	1	localFileLock	FileLock
    //   29	4	1	localObject	Object
    //   34	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   14	21	29	finally
    //   21	26	29	finally
    //   14	21	34	java/lang/Throwable
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/FileLocker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */