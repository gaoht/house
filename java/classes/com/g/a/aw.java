package com.g.a;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class aw
{
  private static volatile aw a = null;
  private static final HandlerThread b = new HandlerThread("PauseEventThread");
  private static Handler c = null;
  
  static
  {
    b.start();
    c = new ax(b.getLooper());
    try
    {
      ad.a().register(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
  
  public static aw a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aw();
      }
      return a;
    }
    finally {}
  }
  
  private void a(long paramLong, a parama)
  {
    try
    {
      h.iForDeveloper("[Session] - New session!");
      String str = UUID.randomUUID().toString();
      h.iForDeveloper("[Session] - Id: " + str);
      long l2 = i.c(parama);
      long l1 = paramLong - l2;
      if (0L == l2) {
        l1 = 0L;
      }
      i.a(str, parama);
      i.a(paramLong, parama);
      bm.a().setSessionId(str);
      bm.a().setSessionStartTime(paramLong);
      if ((c.e != null) && (r.c(c.e))) {}
      for (int i = 1;; i = -1)
      {
        be localbe = new be();
        localbe.b = "session";
        localbe.c = "begin";
        TreeMap localTreeMap = new TreeMap();
        localTreeMap.put("sessionId", str);
        localTreeMap.put("interval", Long.valueOf(l1 / 1000L));
        localTreeMap.put("isConnected", Integer.valueOf(i));
        localbe.d = localTreeMap;
        localbe.a = parama;
        ad.a().post(localbe);
        b(parama);
        return;
      }
      return;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
  }
  
  private void a(a parama)
  {
    for (;;)
    {
      long l2;
      try
      {
        String str = i.a(parama);
        if ((str != null) && (!str.trim().isEmpty()))
        {
          long l3 = i.b(parama);
          l2 = i.c(parama) - l3;
          if ((!parama.b().equals("APP")) && (!parama.b().equals("APP_SQL")))
          {
            l1 = l2;
            if (!parama.b().equals("TRACKING"))
            {
              be localbe = new be();
              localbe.b = "session";
              localbe.c = "end";
              TreeMap localTreeMap = new TreeMap();
              localTreeMap.put("sessionId", str);
              localTreeMap.put("start", Long.valueOf(l3));
              localTreeMap.put("duration", Long.valueOf(l1 / 1000L));
              localbe.d = localTreeMap;
              localbe.a = parama;
              ad.a().post(localbe);
              b(parama);
              i.a(null, parama);
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable parama)
      {
        av.postSDKError(parama);
        return;
      }
      long l1 = l2;
      if (l2 < 500L) {
        l1 = -1000L;
      }
    }
  }
  
  private final void a(HashMap paramHashMap)
  {
    for (;;)
    {
      long l2;
      try
      {
        a locala = (a)paramHashMap.get("service");
        long l3 = Long.valueOf(String.valueOf(paramHashMap.get("occurTime"))).longValue();
        l2 = i.b(locala);
        l1 = i.c(locala);
        if (l1 > l2)
        {
          if (l3 - l1 > c.p)
          {
            a(locala);
            a(l3, locala);
            i.setLastActivity("");
            return;
          }
          h.iForDeveloper("[Session] - Same session as before!");
          paramHashMap = i.a(locala);
          bm.a().setSessionId(paramHashMap);
          bm.a().setSessionStartTime(l2);
          return;
        }
      }
      catch (Throwable paramHashMap)
      {
        av.postSDKError(paramHashMap);
        return;
      }
      long l1 = l2;
    }
  }
  
  public static Handler b()
  {
    return c;
  }
  
  private void b(a parama)
  {
    bd localbd = new bd();
    localbd.a = parama;
    localbd.b = bd.a.a;
    ad.a().post(localbd);
  }
  
  private final void b(HashMap paramHashMap)
  {
    try
    {
      a locala = (a)paramHashMap.get("service");
      long l = Long.valueOf(String.valueOf(paramHashMap.get("occurTime"))).longValue();
      if (paramHashMap.containsKey("sessionEnd"))
      {
        a(locala);
        return;
      }
      if (paramHashMap.containsKey("pageName")) {
        i.setLastActivity(String.valueOf(paramHashMap.get("pageName")));
      }
      if (locala.b().equals("GAME")) {
        b(locala);
      }
      i.b(l, locala);
      return;
    }
    catch (Throwable paramHashMap)
    {
      av.postSDKError(paramHashMap);
    }
  }
  
  public final void onTDEBEventSession(db.a parama)
  {
    if ((parama == null) || (parama.a == null)) {}
    int i;
    do
    {
      return;
      try
      {
        i = Integer.parseInt(String.valueOf(parama.a.get("apiType")));
        if (i == 10)
        {
          a(parama.a);
          return;
        }
      }
      catch (Throwable parama)
      {
        av.postSDKError(parama);
        return;
      }
    } while (i != 11);
    b(parama.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */