package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.e.c.i;
import com.megvii.zhimasdk.b.a.e.d;
import com.megvii.zhimasdk.b.a.e.m;
import com.megvii.zhimasdk.b.a.l.c;
import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
public class g
  implements d
{
  public com.megvii.zhimasdk.b.a.h.b a = new com.megvii.zhimasdk.b.a.h.b(getClass());
  protected final i b;
  protected final com.megvii.zhimasdk.b.a.e.j c;
  
  public g(i parami)
  {
    a.a(parami, "Scheme registry");
    this.b = parami;
    this.c = new q();
  }
  
  private i a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    i locali = (i)parame.a("http.scheme-registry");
    parame = locali;
    if (locali == null) {
      parame = this.b;
    }
    return parame;
  }
  
  public com.megvii.zhimasdk.b.a.e.q a()
  {
    return new f();
  }
  
  public void a(com.megvii.zhimasdk.b.a.e.q paramq, n paramn, com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    a.a(paramq, "Connection");
    a.a(paramn, "Target host");
    a.a(parame1, "Parameters");
    com.megvii.zhimasdk.b.a.o.b.a(paramq.c(), "Connection must be open");
    Object localObject = a(parame).a(paramn.c());
    com.megvii.zhimasdk.b.a.o.b.a(((com.megvii.zhimasdk.b.a.e.c.e)localObject).b() instanceof com.megvii.zhimasdk.b.a.e.c.f, "Socket factory must implement SchemeLayeredSocketFactory");
    com.megvii.zhimasdk.b.a.e.c.f localf = (com.megvii.zhimasdk.b.a.e.c.f)((com.megvii.zhimasdk.b.a.e.c.e)localObject).b();
    localObject = localf.a(paramq.i(), paramn.a(), ((com.megvii.zhimasdk.b.a.e.c.e)localObject).a(paramn.b()), parame1);
    a((Socket)localObject, parame, parame1);
    paramq.a((Socket)localObject, paramn, localf.a((Socket)localObject), parame1);
  }
  
  public void a(com.megvii.zhimasdk.b.a.e.q paramq, n paramn, InetAddress paramInetAddress, com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    a.a(paramq, "Connection");
    a.a(paramn, "Target host");
    a.a(parame1, "HTTP parameters");
    boolean bool;
    Object localObject1;
    com.megvii.zhimasdk.b.a.e.c.j localj;
    int i;
    label87:
    int j;
    label115:
    Socket localSocket;
    m localm;
    if (!paramq.c())
    {
      bool = true;
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Connection must not be open");
      localObject1 = a(parame).a(paramn.c());
      localj = ((com.megvii.zhimasdk.b.a.e.c.e)localObject1).b();
      InetAddress[] arrayOfInetAddress = a(paramn.a());
      int k = ((com.megvii.zhimasdk.b.a.e.c.e)localObject1).a(paramn.b());
      i = 0;
      if (i < arrayOfInetAddress.length)
      {
        localObject1 = arrayOfInetAddress[i];
        if (i != arrayOfInetAddress.length - 1) {
          break label271;
        }
        j = 1;
        localSocket = localj.a(parame1);
        paramq.a(localSocket, paramn);
        localm = new m(paramn, (InetAddress)localObject1, k);
        localObject1 = null;
        if (paramInetAddress != null) {
          localObject1 = new InetSocketAddress(paramInetAddress, 0);
        }
        if (this.a.a()) {
          this.a.a("Connecting to " + localm);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = localj.a(localSocket, localm, (InetSocketAddress)localObject1, parame1);
        if (localSocket == localObject1) {
          break label353;
        }
        paramq.a((Socket)localObject1, paramn);
        a((Socket)localObject1, parame, parame1);
        paramq.a(localj.a((Socket)localObject1), parame1);
        return;
      }
      catch (ConnectException localConnectException)
      {
        if (j == 0) {
          continue;
        }
        throw localConnectException;
      }
      catch (com.megvii.zhimasdk.b.a.e.f localf)
      {
        label271:
        if (j == 0) {
          continue;
        }
        throw localf;
        if (!this.a.a()) {
          continue;
        }
        this.a.a("Connect to " + localm + " timed out. " + "Connection will be retried using another IP address");
        i += 1;
      }
      bool = false;
      break;
      j = 0;
      break label115;
      break label87;
      label353:
      Object localObject2 = localSocket;
    }
  }
  
  protected void a(Socket paramSocket, com.megvii.zhimasdk.b.a.n.e parame, com.megvii.zhimasdk.b.a.l.e parame1)
  {
    paramSocket.setTcpNoDelay(c.c(parame1));
    paramSocket.setSoTimeout(c.a(parame1));
    int i = c.d(parame1);
    if (i >= 0) {
      if (i <= 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      paramSocket.setSoLinger(bool, i);
      return;
    }
  }
  
  protected InetAddress[] a(String paramString)
  {
    return this.c.a(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */