package com.huawei.hms.support.log;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public enum LogLevel
{
  private static final SparseArray<LogLevel> a;
  private static final Map<String, LogLevel> b;
  private final int c;
  
  static
  {
    int i = 0;
    ALL = new LogLevel("ALL", 0, 0);
    VERBOSE = new LogLevel("VERBOSE", 1, 2);
    DEBUG = new LogLevel("DEBUG", 2, 3);
    INFO = new LogLevel("INFO", 3, 4);
    WARN = new LogLevel("WARN", 4, 5);
    ERROR = new LogLevel("ERROR", 5, 6);
    ASSERT = new LogLevel("ASSERT", 6, 7);
    OUT = new LogLevel("OUT", 7, 100);
    NONE = new LogLevel("NONE", 8, 255);
    d = new LogLevel[] { ALL, VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, OUT, NONE };
    a = new SparseArray();
    b = new HashMap();
    LogLevel[] arrayOfLogLevel = values();
    int j = arrayOfLogLevel.length;
    while (i < j)
    {
      LogLevel localLogLevel = arrayOfLogLevel[i];
      a.put(localLogLevel.value(), localLogLevel);
      b.put(localLogLevel.name(), localLogLevel);
      i += 1;
    }
  }
  
  private LogLevel(int paramInt)
  {
    this.c = paramInt;
  }
  
  public static LogLevel get(int paramInt)
  {
    return (LogLevel)a.get(paramInt);
  }
  
  public static LogLevel get(String paramString)
  {
    return (LogLevel)b.get(paramString);
  }
  
  public boolean isEnable(LogLevel paramLogLevel)
  {
    return paramLogLevel.c <= this.c;
  }
  
  public int value()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/LogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */