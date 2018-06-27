package com.xiaomi.channel.commonutils.logger;

import android.util.Log;

public class a
  implements LoggerInterface
{
  private String a = "xiaomi";
  
  public void log(String paramString)
  {
    Log.v(this.a, paramString);
  }
  
  public void log(String paramString, Throwable paramThrowable)
  {
    Log.v(this.a, paramString, paramThrowable);
  }
  
  public void setTag(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/logger/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */