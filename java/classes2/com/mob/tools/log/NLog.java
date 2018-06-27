package com.mob.tools.log;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.util.HashMap;

public abstract class NLog
{
  private static boolean disable;
  private static HashMap<String, NLog> loggers = new HashMap();
  private static LogPrinter printer = new LogPrinter();
  
  static
  {
    MobUncaughtExceptionHandler.register();
  }
  
  public NLog()
  {
    synchronized (loggers)
    {
      loggers.put(getSDKTag(), this);
      if (loggers.size() == 1) {
        loggers.put("__FIRST__", this);
      }
      return;
    }
  }
  
  public static void disable()
  {
    disable = true;
  }
  
  protected static final NLog getInstanceForSDK(String paramString, boolean paramBoolean)
  {
    synchronized (loggers)
    {
      Object localObject2 = (NLog)loggers.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (NLog)loggers.get("__FIRST__");
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (paramBoolean) {
          localObject2 = new NLog()
          {
            protected String getSDKTag()
            {
              return this.val$sdkTag;
            }
          };
        }
      }
      return (NLog)localObject2;
    }
  }
  
  private final String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject = paramThrowable;
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        if ((localObject instanceof UnknownHostException)) {
          return "";
        }
        localObject = ((Throwable)localObject).getCause();
      }
      catch (Throwable paramThrowable)
      {
        PrintWriter localPrintWriter;
        if (!(paramThrowable instanceof OutOfMemoryError)) {
          break label79;
        }
        return "getStackTraceString oom";
        if (paramThrowable == null) {
          break;
        }
        return paramThrowable.getMessage();
      }
    }
    localObject = new StringWriter();
    localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    paramThrowable = ((StringWriter)localObject).toString();
    ((StringWriter)localObject).close();
    return paramThrowable;
    label79:
    return "";
  }
  
  public static void setCollector(String paramString, LogCollector paramLogCollector)
  {
    printer.setCollector(paramString, paramLogCollector);
  }
  
  public static void setContext(Context paramContext) {}
  
  public final int crash(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 6, 1, getStackTraceString(paramThrowable));
  }
  
  public final int d(Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.println(getSDKTag(), 3, 0, (String)paramObject);
  }
  
  public final int d(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 3, 0, getStackTraceString(paramThrowable));
  }
  
  public final int d(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + getStackTraceString(paramThrowable);
    return printer.println(getSDKTag(), 3, 0, paramThrowable);
  }
  
  public final int e(Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.println(getSDKTag(), 6, 0, (String)paramObject);
  }
  
  public final int e(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 6, 0, getStackTraceString(paramThrowable));
  }
  
  public final int e(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + getStackTraceString(paramThrowable);
    return printer.println(getSDKTag(), 6, 0, paramThrowable);
  }
  
  protected abstract String getSDKTag();
  
  public final int i(Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.println(getSDKTag(), 4, 0, (String)paramObject);
  }
  
  public final int i(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 4, 0, getStackTraceString(paramThrowable));
  }
  
  public final int i(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + getStackTraceString(paramThrowable);
    return printer.println(getSDKTag(), 4, 0, paramThrowable);
  }
  
  public final void nativeCrashLog(String paramString)
  {
    if (disable) {
      return;
    }
    printer.nativeCrashLog(getSDKTag(), paramString);
  }
  
  public final int v(Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.println(getSDKTag(), 2, 0, (String)paramObject);
  }
  
  public final int v(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 2, 0, getStackTraceString(paramThrowable));
  }
  
  public final int v(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + getStackTraceString(paramThrowable);
    return printer.println(getSDKTag(), 2, 0, paramThrowable);
  }
  
  public final int w(Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.println(getSDKTag(), 5, 0, (String)paramObject);
  }
  
  public final int w(String paramString)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 5, 0, paramString);
  }
  
  public final int w(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 5, 0, getStackTraceString(paramThrowable));
  }
  
  public final int w(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    if (disable) {
      return 0;
    }
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + getStackTraceString(paramThrowable);
    return printer.println(getSDKTag(), 5, 0, paramThrowable);
  }
  
  public int wtf(Throwable paramThrowable)
  {
    if (disable) {
      return 0;
    }
    return printer.println(getSDKTag(), 6, 0, getStackTraceString(paramThrowable));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/log/NLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */