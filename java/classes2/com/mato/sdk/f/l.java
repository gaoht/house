package com.mato.sdk.f;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.net.ssl.SSLSocketFactory;

public final class l
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final i b = new i();
  private int c = 30000;
  private SSLSocketFactory d = null;
  private final ExecutorService e = Executors.newCachedThreadPool();
  private final j f = j.a;
  private final List<Future<?>> g = new ArrayList();
  
  private void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  private void a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.d = paramSSLSocketFactory;
  }
  
  public final void a()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    this.g.clear();
  }
  
  public final void a(e<?> parame)
  {
    parame = this.e.submit(new a(parame));
    this.g.add(parame);
  }
  
  final class a
    implements Runnable
  {
    private final e<?> a;
    
    public a()
    {
      e locale;
      this.a = locale;
    }
    
    private b a()
      throws IllegalArgumentException
    {
      switch (this.a.g())
      {
      default: 
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid request method: %d", new Object[] { Integer.valueOf(this.a.g()) }));
      case 1: 
        return b.b(this.a.h());
      }
      return b.a(this.a.h());
    }
    
    private d a(e<?> parame)
      throws Exception
    {
      int i = 0;
      for (;;)
      {
        try
        {
          switch (this.a.g())
          {
          case 1: 
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid request method: %d", new Object[] { Integer.valueOf(this.a.g()) }));
          }
        }
        catch (b.e locale)
        {
          Object localObject1 = locale.a();
          Object localObject2 = l.d(l.this);
          i += 1;
          if (!((j)localObject2).a((IOException)localObject1, i))
          {
            throw ((Throwable)localObject1);
            localObject1 = b.b(this.a.h());
            if (l.b(l.this) != null) {
              ((b)localObject1).a(l.b(l.this));
            }
            if (parame.i()) {
              ((b)localObject1).a(parame.j(), parame.k());
            }
            ((b)localObject1).b(l.c(l.this));
            ((b)localObject1).a(l.c(l.this));
            localObject2 = this.a.a();
            a locala = this.a.b();
            if (locala != null) {
              ((Map)localObject2).put(a.a(), locala.b());
            }
            if (localObject2 != null) {
              ((b)localObject1).a((Map)localObject2);
            }
            if (com.mato.sdk.b.g.a()) {
              a(parame.a, (b)localObject1);
            }
            localObject2 = parame.c();
            if (localObject2 != null) {
              ((g)localObject2).a((b)localObject1);
            }
            return new d(((b)localObject1).b(), ((b)localObject1).c(), a(((b)localObject1).d()));
            localObject1 = b.a(this.a.h());
            continue;
          }
          l.b();
          long l = parame.a;
        }
      }
    }
    
    private static Map<String, String> a(Map<String, List<String>> paramMap)
    {
      HashMap localHashMap = new HashMap();
      if (paramMap == null) {
        return localHashMap;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey(), ((List)localEntry.getValue()).get(0));
      }
      return localHashMap;
    }
    
    private static void a(long paramLong, b paramb)
    {
      l.b();
      l.b();
      paramb.e().toString();
      l.b();
      paramb.f();
      paramb = paramb.a().getRequestProperties().entrySet().iterator();
      while (paramb.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramb.next();
        l.b();
        localEntry.getKey();
        ((List)localEntry.getValue()).get(0);
      }
    }
    
    private void a(b paramb)
    {
      Map localMap = this.a.a();
      a locala = this.a.b();
      if (locala != null) {
        localMap.put(a.a(), locala.b());
      }
      if (localMap != null) {
        paramb.a(localMap);
      }
    }
    
    private void a(d paramd)
    {
      if (paramd.a == 200)
      {
        a locala = this.a.b();
        if (locala != null) {
          locala.a(paramd.c);
        }
      }
    }
    
    public final void run()
    {
      try
      {
        Object localObject = a(this.a);
        if (((d)localObject).a == 200)
        {
          a locala = this.a.b();
          if (locala != null) {
            locala.a(((d)localObject).c);
          }
        }
        localObject = this.a.a((d)localObject);
        l.a(l.this).a(this.a, (h)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        l.a(l.this).a(this.a, h.a(localThrowable));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */