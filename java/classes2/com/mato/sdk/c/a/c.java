package com.mato.sdk.c.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static final int d = 100;
  private static final int e = 101;
  private static final int f = 102;
  private final HandlerThread a;
  private final Handler b;
  private final List<b> c;
  
  public c()
  {
    this.a = new HandlerThread("Accesslog-Dispatcher");
    this.a.start();
    this.b = new d(this.a.getLooper(), this);
    this.c = new ArrayList();
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      try
      {
        localb.a(paramString);
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private void c(b paramb)
  {
    this.c.add(paramb);
  }
  
  private void d(b paramb)
  {
    this.c.remove(paramb);
  }
  
  public final void a(b paramb)
  {
    this.b.obtainMessage(101, paramb).sendToTarget();
  }
  
  final void a(String paramString)
  {
    this.b.obtainMessage(100, paramString).sendToTarget();
  }
  
  public final void b(b paramb)
  {
    this.b.obtainMessage(102, paramb).sendToTarget();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */