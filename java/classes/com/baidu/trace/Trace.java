package com.baidu.trace;

import android.app.Notification;
import android.text.TextUtils;

public class Trace
{
  protected static int a = 5;
  protected static int b = 30;
  protected static int c = 0;
  protected static int d = 600000;
  protected static String e = "";
  private long f = 0L;
  private String g = "";
  private boolean h = false;
  private Notification i = null;
  
  public Trace() {}
  
  public Trace(long paramLong, String paramString)
  {
    this.f = paramLong;
    setEntityName(paramString);
  }
  
  public Trace(long paramLong, String paramString, boolean paramBoolean)
  {
    this.f = paramLong;
    this.h = paramBoolean;
    setEntityName(paramString);
  }
  
  public Trace(long paramLong, String paramString, boolean paramBoolean, Notification paramNotification)
  {
    this.f = paramLong;
    this.g = paramString;
    this.h = paramBoolean;
    this.i = paramNotification;
  }
  
  protected static boolean a(int paramInt)
  {
    if (paramInt < 50) {
      return false;
    }
    c = paramInt;
    return true;
  }
  
  protected static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt1 > 300) || (paramInt2 < paramInt1) || (paramInt2 < 2) || (paramInt2 > 300) || (paramInt2 % paramInt1 != 0)) {
      return false;
    }
    a = paramInt1;
    b = paramInt2;
    return true;
  }
  
  protected static boolean b(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    d = paramInt;
    return true;
  }
  
  public String getEntityName()
  {
    return this.g;
  }
  
  public Notification getNotification()
  {
    return this.i;
  }
  
  public long getServiceId()
  {
    return this.f;
  }
  
  public boolean isNeedObjectStorage()
  {
    return this.h;
  }
  
  public void setEntityName(String paramString)
  {
    this.g = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      e = paramString;
    }
  }
  
  public void setNeedObjectStorage(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setNotification(Notification paramNotification)
  {
    this.i = paramNotification;
  }
  
  public void setServiceId(long paramLong)
  {
    this.f = paramLong;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/Trace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */