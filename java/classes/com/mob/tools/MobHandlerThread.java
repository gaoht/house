package com.mob.tools;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Process;
import com.mob.tools.log.NLog;

public class MobHandlerThread
  extends Thread
{
  private Looper looper;
  private int priority;
  private int tid = -1;
  
  public MobHandlerThread()
  {
    caughtException();
    this.priority = 0;
  }
  
  public MobHandlerThread(int paramInt)
  {
    caughtException();
    this.priority = paramInt;
  }
  
  private void caughtException()
  {
    setUncaughtExceptionHandler(new MobHandlerThread.1(this));
  }
  
  public static Handler newHandler(Handler.Callback paramCallback)
  {
    return newHandler(null, null, paramCallback);
  }
  
  public static Handler newHandler(Runnable paramRunnable, Handler.Callback paramCallback)
  {
    return newHandler(null, paramRunnable, paramCallback);
  }
  
  public static Handler newHandler(String paramString, Handler.Callback paramCallback)
  {
    return newHandler(paramString, null, paramCallback);
  }
  
  public static Handler newHandler(String paramString, Runnable paramRunnable, Handler.Callback paramCallback)
  {
    paramString = new Handler[1];
    paramRunnable = new MobHandlerThread.2(paramRunnable, paramString, paramCallback);
    if (0 != 0) {}
    try
    {
      paramRunnable.setName(null);
      paramRunnable.start();
      paramString.wait();
    }
    catch (Throwable paramRunnable)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramRunnable);
      }
    }
    finally {}
    return paramString[0];
  }
  
  public Looper getLooper()
  {
    if (!isAlive()) {
      return null;
    }
    try
    {
      while (isAlive())
      {
        Looper localLooper = this.looper;
        if (localLooper != null) {
          break;
        }
        try
        {
          wait();
        }
        catch (Throwable localThrowable) {}
      }
      return this.looper;
    }
    finally {}
  }
  
  public int getThreadId()
  {
    return this.tid;
  }
  
  protected void onLooperPrepared() {}
  
  protected void onLooperPrepared(Looper paramLooper) {}
  
  public boolean quit()
  {
    Looper localLooper = getLooper();
    if (localLooper != null)
    {
      localLooper.quit();
      return true;
    }
    return false;
  }
  
  @Deprecated
  public void realRun() {}
  
  public void run()
  {
    try
    {
      realRun();
      this.tid = Process.myTid();
      Looper.prepare();
      try
      {
        this.looper = Looper.myLooper();
        notifyAll();
        Process.setThreadPriority(this.priority);
        onLooperPrepared(this.looper);
        onLooperPrepared();
        Looper.loop();
        this.tid = -1;
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().d(localThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/mob/tools/MobHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */