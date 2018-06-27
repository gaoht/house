package com.mato.sdk.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.mato.sdk.c.c.b;
import com.mato.sdk.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends f
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final c b;
  private Thread.UncaughtExceptionHandler c;
  private final ArrayList<String> d = new ArrayList();
  
  private g(c paramc, boolean paramBoolean)
  {
    this.b = paramc;
    if (paramBoolean)
    {
      paramc = Thread.getDefaultUncaughtExceptionHandler();
      if (paramc != null)
      {
        if (!(paramc instanceof a))
        {
          this.c = paramc;
          this.c.getClass().getName();
        }
      }
      else {
        Thread.setDefaultUncaughtExceptionHandler(new a((byte)0));
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    f.a(new g(new c(paramContext), paramBoolean));
  }
  
  private void a(final a parama)
  {
    if (!parama.g())
    {
      this.b.b(parama);
      return;
    }
    b.a(parama, new c.b()
    {
      public final void a()
      {
        g.c();
        g.a(g.this).b(parama);
      }
      
      public final void b()
      {
        g.c();
      }
    });
  }
  
  private void a(Thread paramThread, Throwable paramThrowable)
  {
    if (this.c != null) {
      this.c.uncaughtException(paramThread, paramThrowable);
    }
  }
  
  private void d()
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (localUncaughtExceptionHandler != null)
    {
      if ((localUncaughtExceptionHandler instanceof a)) {
        return;
      }
      this.c = localUncaughtExceptionHandler;
      this.c.getClass().getName();
    }
    Thread.setDefaultUncaughtExceptionHandler(new a((byte)0));
  }
  
  public final void a()
  {
    Object localObject = this.b.a();
    ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      int j = i + 1;
      if (i < 5)
      {
        locala.c();
        a(locala);
        i = j;
      }
      else
      {
        locala.c();
        this.b.b(locala);
        i = j;
      }
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      paramString = a.a(paramString);
      this.b.a(paramString);
      a(paramString);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public final void a(Throwable paramThrowable)
  {
    a(paramThrowable, null);
  }
  
  public final void a(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {}
    for (;;)
    {
      return;
      try
      {
        paramThrowable = a.a(paramThrowable, true, paramString);
        paramString = paramThrowable.f().a();
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = m.a(paramString);
          if (!this.d.contains(paramString))
          {
            this.d.add(paramString);
            a(paramThrowable);
            return;
          }
        }
      }
      catch (Throwable paramThrowable) {}
    }
  }
  
  public final void b(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    try
    {
      paramThrowable = a.a(paramThrowable, false, "");
      this.b.a(paramThrowable);
      return;
    }
    catch (Throwable paramThrowable) {}
  }
  
  final class a
    implements Thread.UncaughtExceptionHandler
  {
    private a() {}
    
    public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      g.c();
      if (paramThrowable == null) {
        return;
      }
      try
      {
        g.this.b(paramThrowable);
        g.a(g.this, paramThread, paramThrowable);
        return;
      }
      catch (Throwable paramThread)
      {
        g.c();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */