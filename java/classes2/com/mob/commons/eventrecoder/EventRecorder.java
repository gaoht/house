package com.mob.commons.eventrecoder;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.FileLocker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public final class EventRecorder
  implements PublicMemberKeeper
{
  private static File a;
  private static FileOutputStream b;
  
  private static final void a(LockAction paramLockAction)
  {
    c.a(new File(MobSDK.getContext().getFilesDir(), "comm/locks/.mrlock"), paramLockAction);
  }
  
  private static final void a(String paramString)
  {
    a(new LockAction()
    {
      public boolean run(FileLocker paramAnonymousFileLocker)
      {
        try
        {
          EventRecorder.b().write(this.a.getBytes("utf-8"));
          EventRecorder.b().flush();
          return false;
        }
        catch (Throwable paramAnonymousFileLocker)
        {
          for (;;)
          {
            MobLog.getInstance().w(paramAnonymousFileLocker);
          }
        }
      }
    });
  }
  
  public static final void addBegin(String paramString1, String paramString2)
  {
    try
    {
      a(paramString1 + " " + paramString2 + " 0\n");
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static final void addEnd(String paramString1, String paramString2)
  {
    try
    {
      a(paramString1 + " " + paramString2 + " 1\n");
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static final String checkRecord(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 86	java/util/LinkedList
    //   6: dup
    //   7: invokespecial 87	java/util/LinkedList:<init>	()V
    //   10: astore_1
    //   11: new 12	com/mob/commons/eventrecoder/EventRecorder$3
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 90	com/mob/commons/eventrecoder/EventRecorder$3:<init>	(Ljava/lang/String;Ljava/util/LinkedList;)V
    //   20: invokestatic 59	com/mob/commons/eventrecoder/EventRecorder:a	(Lcom/mob/commons/LockAction;)V
    //   23: aload_1
    //   24: invokevirtual 94	java/util/LinkedList:size	()I
    //   27: ifle +17 -> 44
    //   30: aload_1
    //   31: iconst_0
    //   32: invokevirtual 98	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   35: checkcast 100	java/lang/String
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -7 -> 39
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   10	21	1	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   3	39	49	finally
  }
  
  public static final void clear()
  {
    try
    {
      a(new LockAction()
      {
        public boolean run(FileLocker paramAnonymousFileLocker)
        {
          try
          {
            EventRecorder.b().close();
            EventRecorder.a().delete();
            EventRecorder.a(new File(MobSDK.getContext().getFilesDir(), ".mrecord"));
            EventRecorder.a().createNewFile();
            EventRecorder.a(new FileOutputStream(EventRecorder.a(), true));
            return false;
          }
          catch (Throwable paramAnonymousFileLocker)
          {
            for (;;)
            {
              MobLog.getInstance().w(paramAnonymousFileLocker);
            }
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static final void prepare()
  {
    try
    {
      a(new LockAction()
      {
        public boolean run(FileLocker paramAnonymousFileLocker)
        {
          try
          {
            EventRecorder.a(new File(MobSDK.getContext().getFilesDir(), ".mrecord"));
            if (!EventRecorder.a().exists()) {
              EventRecorder.a().createNewFile();
            }
            EventRecorder.a(new FileOutputStream(EventRecorder.a(), true));
          }
          catch (Throwable paramAnonymousFileLocker)
          {
            for (;;)
            {
              MobLog.getInstance().w(paramAnonymousFileLocker);
            }
          }
          return false;
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/eventrecoder/EventRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */