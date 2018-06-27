package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.q;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;

public class l
  implements com.megvii.zhimasdk.b.a.b.j
{
  public static final l a = new l();
  private final int b;
  private final boolean c;
  private final Set<Class<? extends IOException>> d;
  
  public l()
  {
    this(3, false);
  }
  
  public l(int paramInt, boolean paramBoolean)
  {
    this(paramInt, paramBoolean, Arrays.asList(new Class[] { InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class }));
  }
  
  protected l(int paramInt, boolean paramBoolean, Collection<Class<? extends IOException>> paramCollection)
  {
    this.b = paramInt;
    this.c = paramBoolean;
    this.d = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Class localClass = (Class)paramCollection.next();
      this.d.add(localClass);
    }
  }
  
  protected boolean a(q paramq)
  {
    return !(paramq instanceof com.megvii.zhimasdk.b.a.l);
  }
  
  public boolean a(IOException paramIOException, int paramInt, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramIOException, "Exception parameter");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP context");
    if (paramInt > this.b) {
      return false;
    }
    if (this.d.contains(paramIOException.getClass())) {
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (((Class)localIterator.next()).isInstance(paramIOException)) {
        return false;
      }
    }
    paramIOException = com.megvii.zhimasdk.b.a.b.e.a.a(parame);
    parame = paramIOException.m();
    if (b(parame)) {
      return false;
    }
    if (a(parame)) {
      return true;
    }
    return (!paramIOException.n()) || (this.c);
  }
  
  @Deprecated
  protected boolean b(q paramq)
  {
    if ((paramq instanceof v)) {
      paramq = ((v)paramq).m();
    }
    for (;;)
    {
      return ((paramq instanceof com.megvii.zhimasdk.b.a.b.c.j)) && (((com.megvii.zhimasdk.b.a.b.c.j)paramq).i());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */