package com.mob.tools.log;

import java.util.HashMap;

public class LogPrinter
{
  private HashMap<String, LogCollector> collectors = new HashMap();
  
  public void nativeCrashLog(String paramString1, String paramString2)
  {
    LogCollector localLogCollector = (LogCollector)this.collectors.get(paramString1);
    if (localLogCollector != null) {
      localLogCollector.log(paramString1, 6, 2, null, paramString2);
    }
  }
  
  public int println(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString2 = Thread.currentThread().getName() + " " + paramString2;
    LogCollector localLogCollector = (LogCollector)this.collectors.get(paramString1);
    if (localLogCollector != null) {
      localLogCollector.log(paramString1, paramInt1, paramInt2, null, paramString2);
    }
    return 0;
  }
  
  public void setCollector(String paramString, LogCollector paramLogCollector)
  {
    this.collectors.put(paramString, paramLogCollector);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/log/LogPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */