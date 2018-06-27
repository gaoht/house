package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class bf
{
  private static JSONObject b = new JSONObject();
  private final Map<String, Long> a = new HashMap();
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        synchronized (b)
        {
          if (b.length() > 0)
          {
            w.a(paramContext).a(bd.a(), b, w.a.b);
            b = new JSONObject();
          }
          return;
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    String str = null;
    long l = 0L;
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Long)localEntry.getValue()).longValue() > l)
          {
            l = ((Long)localEntry.getValue()).longValue();
            str = (String)localEntry.getKey();
          }
        }
        else
        {
          if (str != null) {
            b(str);
          }
          return;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.a)
      {
        this.a.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Long localLong;
      synchronized (this.a)
      {
        localLong = (Long)this.a.remove(paramString);
        if (localLong == null) {
          return;
        }
      }
      long l1 = System.currentTimeMillis();
      long l2 = localLong.longValue();
      try
      {
        synchronized (b)
        {
          b = new JSONObject();
          b.put("page_name", paramString);
          b.put("duration", l1 - l2);
          return;
        }
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */