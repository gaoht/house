package com.megvii.zhimasdk.b.a.e.d;

import com.megvii.zhimasdk.b.a.e.c.f;
import com.megvii.zhimasdk.b.a.e.m;
import com.megvii.zhimasdk.b.a.n;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

@Deprecated
public class g
  implements com.megvii.zhimasdk.b.a.e.c.b, com.megvii.zhimasdk.b.a.e.c.c, f
{
  public static final j b = new b();
  public static final j c = new c();
  public static final j d = new h();
  private final SSLSocketFactory a;
  private final com.megvii.zhimasdk.b.a.e.c.a e;
  private volatile j f;
  private final String[] g;
  private final String[] h;
  
  public g(KeyStore paramKeyStore)
  {
    this(e.b().a(paramKeyStore).a(), c);
  }
  
  public g(SSLContext paramSSLContext, j paramj)
  {
    this(((SSLContext)com.megvii.zhimasdk.b.a.o.a.a(paramSSLContext, "SSL context")).getSocketFactory(), null, null, paramj);
  }
  
  public g(SSLSocketFactory paramSSLSocketFactory, String[] paramArrayOfString1, String[] paramArrayOfString2, j paramj)
  {
    this.a = ((SSLSocketFactory)com.megvii.zhimasdk.b.a.o.a.a(paramSSLSocketFactory, "SSL socket factory"));
    this.g = paramArrayOfString1;
    this.h = paramArrayOfString2;
    if (paramj != null) {}
    for (;;)
    {
      this.f = paramj;
      this.e = null;
      return;
      paramj = c;
    }
  }
  
  private void a(SSLSocket paramSSLSocket, String paramString)
  {
    try
    {
      this.f.a(paramString, paramSSLSocket);
      return;
    }
    catch (IOException paramString) {}
    try
    {
      paramSSLSocket.close();
      throw paramString;
    }
    catch (Exception paramSSLSocket)
    {
      for (;;) {}
    }
  }
  
  private void b(SSLSocket paramSSLSocket)
  {
    if (this.g != null) {
      paramSSLSocket.setEnabledProtocols(this.g);
    }
    if (this.h != null) {
      paramSSLSocket.setEnabledCipherSuites(this.h);
    }
    a(paramSSLSocket);
  }
  
  public static g d()
  {
    return new g(e.a(), c);
  }
  
  public Socket a(int paramInt, Socket paramSocket, n paramn, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, com.megvii.zhimasdk.b.a.n.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramn, "HTTP host");
    com.megvii.zhimasdk.b.a.o.a.a(paramInetSocketAddress1, "Remote address");
    if (paramSocket != null) {}
    for (;;)
    {
      if (paramInetSocketAddress2 != null) {
        paramSocket.bind(paramInetSocketAddress2);
      }
      try
      {
        paramSocket.connect(paramInetSocketAddress1, paramInt);
        if (!(paramSocket instanceof SSLSocket)) {
          break;
        }
        paramInetSocketAddress1 = (SSLSocket)paramSocket;
        paramInetSocketAddress1.startHandshake();
        a(paramInetSocketAddress1, paramn.a());
        return paramSocket;
      }
      catch (IOException paramn) {}
      paramSocket = a(parame);
    }
    try
    {
      paramSocket.close();
      throw paramn;
      return a(paramSocket, paramn.a(), paramInetSocketAddress1.getPort(), parame);
    }
    catch (IOException paramSocket)
    {
      for (;;) {}
    }
  }
  
  public Socket a(com.megvii.zhimasdk.b.a.l.e parame)
  {
    return a((com.megvii.zhimasdk.b.a.n.e)null);
  }
  
  public Socket a(com.megvii.zhimasdk.b.a.n.e parame)
  {
    parame = (SSLSocket)this.a.createSocket();
    b(parame);
    return parame;
  }
  
  public Socket a(Socket paramSocket, String paramString, int paramInt, com.megvii.zhimasdk.b.a.l.e parame)
  {
    return a(paramSocket, paramString, paramInt, (com.megvii.zhimasdk.b.a.n.e)null);
  }
  
  public Socket a(Socket paramSocket, String paramString, int paramInt, com.megvii.zhimasdk.b.a.n.e parame)
  {
    paramSocket = (SSLSocket)this.a.createSocket(paramSocket, paramString, paramInt, true);
    b(paramSocket);
    paramSocket.startHandshake();
    a(paramSocket, paramString);
    return paramSocket;
  }
  
  public Socket a(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, com.megvii.zhimasdk.b.a.l.e parame)
  {
    InetAddress localInetAddress;
    InetSocketAddress localInetSocketAddress;
    if (this.e != null)
    {
      localInetAddress = this.e.a(paramString);
      localInetSocketAddress = null;
      if ((paramInetAddress != null) || (paramInt2 > 0)) {
        if (paramInt2 <= 0) {
          break label88;
        }
      }
    }
    for (;;)
    {
      localInetSocketAddress = new InetSocketAddress(paramInetAddress, paramInt2);
      return a(paramSocket, new m(new n(paramString, paramInt1), localInetAddress, paramInt1), localInetSocketAddress, parame);
      localInetAddress = InetAddress.getByName(paramString);
      break;
      label88:
      paramInt2 = 0;
    }
  }
  
  public Socket a(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return b(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public Socket a(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, com.megvii.zhimasdk.b.a.l.e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramInetSocketAddress1, "Remote address");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    if ((paramInetSocketAddress1 instanceof m)) {}
    for (n localn = ((m)paramInetSocketAddress1).a();; localn = new n(paramInetSocketAddress1.getHostName(), paramInetSocketAddress1.getPort(), "https"))
    {
      int i = com.megvii.zhimasdk.b.a.l.c.a(parame);
      int j = com.megvii.zhimasdk.b.a.l.c.e(parame);
      paramSocket.setSoTimeout(i);
      return a(j, paramSocket, localn, paramInetSocketAddress1, paramInetSocketAddress2, null);
    }
  }
  
  public void a(j paramj)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramj, "Hostname verifier");
    this.f = paramj;
  }
  
  protected void a(SSLSocket paramSSLSocket) {}
  
  public boolean a(Socket paramSocket)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramSocket, "Socket");
    com.megvii.zhimasdk.b.a.o.b.a(paramSocket instanceof SSLSocket, "Socket not created by this factory");
    if (!paramSocket.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      com.megvii.zhimasdk.b.a.o.b.a(bool, "Socket is closed");
      return true;
    }
  }
  
  public Socket b(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramSocket, paramString, paramInt, (com.megvii.zhimasdk.b.a.n.e)null);
  }
  
  public Socket c()
  {
    return a((com.megvii.zhimasdk.b.a.n.e)null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */