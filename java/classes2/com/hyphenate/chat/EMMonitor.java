package com.hyphenate.chat;

import android.content.Context;
import com.hyphenate.chat.core.EMMonitorDB;
import com.hyphenate.util.EasyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EMMonitor
{
  private static String FILENAME = "pid";
  private static final String TAG = "EMMonitor";
  private static EMMonitor _instance = null;
  private EMMonitorDB monitorDB = new EMMonitorDB();
  private boolean nativeServiceStarted = false;
  private boolean wakeuped;
  
  static EMMonitor getInstance()
  {
    try
    {
      if (_instance == null) {
        _instance = new EMMonitor();
      }
      EMMonitor localEMMonitor = _instance;
      return localEMMonitor;
    }
    finally {}
  }
  
  private native void startMonitor(String paramString);
  
  private native void startWakeup(String[] paramArrayOfString);
  
  EMMonitorDB getMonitorDB()
  {
    return this.monitorDB;
  }
  
  boolean isStarted()
  {
    return (this.nativeServiceStarted) && (this.wakeuped);
  }
  
  void start(Context paramContext, String paramString)
  {
    if (!this.nativeServiceStarted)
    {
      startMonitor(paramString);
      this.nativeServiceStarted = true;
    }
  }
  
  void startWakeup(Context paramContext, String paramString)
  {
    if ((this.wakeuped) || ("wakeup".equals(paramString))) {}
    do
    {
      return;
      this.wakeuped = true;
      paramString = new ArrayList();
      Object localObject = this.monitorDB.a();
      paramContext = EasyUtils.getRunningApps(paramContext);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramContext.contains(str)) {
          paramString.add(str + "/" + EMChatService.class.getName());
        }
      }
    } while (paramString.size() == 0);
    startWakeup((String[])paramString.toArray(new String[paramString.size()]));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */