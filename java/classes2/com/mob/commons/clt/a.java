package com.mob.commons.clt;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.mob.commons.LockAction;
import com.mob.commons.c;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.HashMap;

public class a
  implements Handler.Callback
{
  private static HashMap<String, a> c = new HashMap();
  private MobHandlerThread a;
  private boolean b = false;
  private Handler d;
  
  private void g()
  {
    final File localFile = a();
    if (localFile == null) {
      return;
    }
    this.a = new MobHandlerThread()
    {
      private void a()
      {
        super.run();
      }
      
      protected void onLooperPrepared(Looper paramAnonymousLooper)
      {
        try
        {
          a.a(a.this, new Handler(paramAnonymousLooper, a.this));
          a.this.c();
          return;
        }
        catch (Throwable paramAnonymousLooper)
        {
          MobLog.getInstance().d(paramAnonymousLooper);
        }
      }
      
      public void run()
      {
        try
        {
          if (!c.a(localFile, new LockAction()
          {
            public boolean run(FileLocker paramAnonymous2FileLocker)
            {
              try
              {
                MobLog.getInstance().d("synchronizeProcess success clt: " + a.this.getClass().getSimpleName() + ", file: " + a.1.this.a.getPath() + ", pid: " + Process.myPid() + ", isStop: " + a.a(a.this), new Object[0]);
                if ((!a.a(a.this)) && (a.this.b())) {
                  a.1.a(a.1.this);
                }
                return false;
              }
              catch (Throwable paramAnonymous2FileLocker)
              {
                MobLog.getInstance().d(paramAnonymous2FileLocker);
              }
              return false;
            }
          }))
          {
            MobLog.getInstance().w("synchronizeProcess failed clt: " + a.this.getClass().getSimpleName() + ", file: " + localFile.getPath());
            a.f().put(getClass().getSimpleName(), null);
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          MobLog.getInstance().d(localThrowable);
        }
      }
    };
    this.a.start();
  }
  
  /* Error */
  public static final void startCollectors(Class<? extends a>... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: arraylength
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: arraylength
    //   20: istore_2
    //   21: iconst_0
    //   22: istore_1
    //   23: iload_1
    //   24: iload_2
    //   25: if_icmpge -11 -> 14
    //   28: aload_0
    //   29: iload_1
    //   30: aaload
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +51 -> 86
    //   38: aload 4
    //   40: invokevirtual 62	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   43: astore_3
    //   44: getstatic 28	com/mob/commons/clt/a:c	Ljava/util/HashMap;
    //   47: aload_3
    //   48: invokevirtual 66	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 2	com/mob/commons/clt/a
    //   54: astore 5
    //   56: aload 5
    //   58: ifnonnull +28 -> 86
    //   61: aload 4
    //   63: invokevirtual 70	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   66: checkcast 2	com/mob/commons/clt/a
    //   69: astore 4
    //   71: getstatic 28	com/mob/commons/clt/a:c	Ljava/util/HashMap;
    //   74: aload_3
    //   75: aload 4
    //   77: invokevirtual 74	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload 4
    //   83: invokespecial 76	com/mob/commons/clt/a:g	()V
    //   86: iload_1
    //   87: iconst_1
    //   88: iadd
    //   89: istore_1
    //   90: goto -67 -> 23
    //   93: astore_3
    //   94: invokestatic 82	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   97: aload_3
    //   98: invokevirtual 87	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   101: pop
    //   102: goto -16 -> 86
    //   105: astore_0
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramVarArgs	Class<? extends a>[]
    //   9	81	1	i	int
    //   20	6	2	j	int
    //   43	32	3	str	String
    //   93	5	3	localThrowable	Throwable
    //   31	51	4	localObject	Object
    //   54	3	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   61	86	93	java/lang/Throwable
    //   7	10	105	finally
    //   18	21	105	finally
    //   38	56	105	finally
    //   61	86	105	finally
    //   94	102	105	finally
  }
  
  protected File a()
  {
    return null;
  }
  
  final void a(int paramInt)
  {
    if (this.d != null) {
      this.d.removeMessages(paramInt);
    }
  }
  
  final void a(int paramInt, long paramLong)
  {
    if (this.d != null) {
      this.d.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  protected void a(Message paramMessage) {}
  
  final void a(Message paramMessage, long paramLong)
  {
    if (this.d != null) {
      this.d.sendMessageDelayed(paramMessage, paramLong);
    }
  }
  
  final void b(int paramInt)
  {
    if (this.d != null) {
      this.d.sendEmptyMessage(paramInt);
    }
  }
  
  final void b(Message paramMessage)
  {
    if (this.d != null) {
      this.d.sendMessage(paramMessage);
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c() {}
  
  final void d()
  {
    try
    {
      if (this.d != null) {
        this.d.removeCallbacksAndMessages(null);
      }
      if (this.a != null) {
        this.a.quit();
      }
      this.d = null;
      this.a = null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().d(localThrowable);
      }
    }
    e();
    this.b = true;
    c.put(getClass().getSimpleName(), null);
  }
  
  protected void e() {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (com.mob.commons.a.E()) {
      d();
    }
    for (;;)
    {
      return false;
      a(paramMessage);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/clt/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */