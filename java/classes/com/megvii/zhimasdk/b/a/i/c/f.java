package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.p;
import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.j.c;
import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.t;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
public class f
  extends com.megvii.zhimasdk.b.a.i.f
  implements p, com.megvii.zhimasdk.b.a.e.q, com.megvii.zhimasdk.b.a.n.e
{
  public b a = new b(getClass());
  public b b = new b("cz.msebera.android.httpclient.headers");
  public b c = new b("cz.msebera.android.httpclient.wire");
  private volatile Socket d;
  private com.megvii.zhimasdk.b.a.n e;
  private boolean f;
  private volatile boolean g;
  private final Map<String, Object> h = new HashMap();
  
  protected c<s> a(com.megvii.zhimasdk.b.a.j.f paramf, t paramt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    return new h(paramf, null, paramt, parame);
  }
  
  protected com.megvii.zhimasdk.b.a.j.f a(Socket paramSocket, int paramInt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    if (paramInt > 0) {}
    for (;;)
    {
      paramSocket = super.a(paramSocket, paramInt, parame);
      if (!this.c.a()) {
        break;
      }
      return new m(paramSocket, new r(this.c), com.megvii.zhimasdk.b.a.l.f.a(parame));
      paramInt = 8192;
    }
    return paramSocket;
  }
  
  public s a()
  {
    s locals = super.a();
    if (this.a.a()) {
      this.a.a("Receiving response: " + locals.a());
    }
    if (this.b.a())
    {
      this.b.a("<< " + locals.a().toString());
      com.megvii.zhimasdk.b.a.e[] arrayOfe = locals.e();
      int j = arrayOfe.length;
      int i = 0;
      while (i < j)
      {
        com.megvii.zhimasdk.b.a.e locale = arrayOfe[i];
        this.b.a("<< " + locale.toString());
        i += 1;
      }
    }
    return locals;
  }
  
  public Object a(String paramString)
  {
    return this.h.get(paramString);
  }
  
  public void a(com.megvii.zhimasdk.b.a.q paramq)
  {
    if (this.a.a()) {
      this.a.a("Sending request: " + paramq.h());
    }
    super.a(paramq);
    if (this.b.a())
    {
      this.b.a(">> " + paramq.h().toString());
      paramq = paramq.e();
      int j = paramq.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramq[i];
        this.b.a(">> " + localObject.toString());
        i += 1;
      }
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.h.put(paramString, paramObject);
  }
  
  public void a(Socket paramSocket, com.megvii.zhimasdk.b.a.n paramn)
  {
    q();
    this.d = paramSocket;
    this.e = paramn;
    if (this.g)
    {
      paramSocket.close();
      throw new InterruptedIOException("Connection already shutdown");
    }
  }
  
  public void a(Socket paramSocket, com.megvii.zhimasdk.b.a.n paramn, boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    j();
    a.a(paramn, "Target host");
    a.a(parame, "Parameters");
    if (paramSocket != null)
    {
      this.d = paramSocket;
      a(paramSocket, parame);
    }
    this.e = paramn;
    this.f = paramBoolean;
  }
  
  public void a(boolean paramBoolean, com.megvii.zhimasdk.b.a.l.e parame)
  {
    a.a(parame, "Parameters");
    q();
    this.f = paramBoolean;
    a(this.d, parame);
  }
  
  protected g b(Socket paramSocket, int paramInt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    if (paramInt > 0) {}
    for (;;)
    {
      paramSocket = super.b(paramSocket, paramInt, parame);
      if (!this.c.a()) {
        break;
      }
      return new n(paramSocket, new r(this.c), com.megvii.zhimasdk.b.a.l.f.a(parame));
      paramInt = 8192;
    }
    return paramSocket;
  }
  
  public void close()
  {
    try
    {
      super.close();
      if (this.a.a()) {
        this.a.a("Connection " + this + " closed");
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error closing connection", localIOException);
    }
  }
  
  public void e()
  {
    this.g = true;
    try
    {
      super.e();
      if (this.a.a()) {
        this.a.a("Connection " + this + " shut down");
      }
      Socket localSocket = this.d;
      if (localSocket != null) {
        localSocket.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error shutting down connection", localIOException);
    }
  }
  
  public final boolean h()
  {
    return this.f;
  }
  
  public final Socket i()
  {
    return this.d;
  }
  
  public SSLSession m()
  {
    if ((this.d instanceof SSLSocket)) {
      return ((SSLSocket)this.d).getSession();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */