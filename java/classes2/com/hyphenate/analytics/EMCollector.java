package com.hyphenate.analytics;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EMCollector
{
  static boolean collectorEnabled = false;
  
  public static String getTagPrefix(String paramString)
  {
    return "[" + paramString + "]";
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String timeToString(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("mm:ss:SSS").format(localDate);
  }
  
  public void enableCollector(boolean paramBoolean)
  {
    collectorEnabled = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/analytics/EMCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */