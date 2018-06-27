package com.megvii.zhimasdk.b.a.e.c;

import com.megvii.zhimasdk.b.a.e.f;
import com.megvii.zhimasdk.b.a.l.c;
import com.megvii.zhimasdk.b.a.l.e;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Deprecated
public class d
  implements j, l
{
  private final a a = null;
  
  public static d a()
  {
    return new d();
  }
  
  public Socket a(e parame)
  {
    return new Socket();
  }
  
  @Deprecated
  public Socket a(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, e parame)
  {
    InetSocketAddress localInetSocketAddress = null;
    if ((paramInetAddress != null) || (paramInt2 > 0))
    {
      if (paramInt2 > 0) {
        localInetSocketAddress = new InetSocketAddress(paramInetAddress, paramInt2);
      }
    }
    else {
      if (this.a == null) {
        break label74;
      }
    }
    label74:
    for (paramString = this.a.a(paramString);; paramString = InetAddress.getByName(paramString))
    {
      return a(paramSocket, new InetSocketAddress(paramString, paramInt1), localInetSocketAddress, parame);
      paramInt2 = 0;
      break;
    }
  }
  
  public Socket a(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramInetSocketAddress1, "Remote address");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    Socket localSocket = paramSocket;
    if (paramSocket == null) {
      localSocket = c();
    }
    if (paramInetSocketAddress2 != null)
    {
      localSocket.setReuseAddress(c.b(parame));
      localSocket.bind(paramInetSocketAddress2);
    }
    int i = c.e(parame);
    int j = c.a(parame);
    try
    {
      localSocket.setSoTimeout(j);
      localSocket.connect(paramInetSocketAddress1, i);
      return localSocket;
    }
    catch (SocketTimeoutException paramSocket)
    {
      throw new f("Connect to " + paramInetSocketAddress1 + " timed out");
    }
  }
  
  public final boolean a(Socket paramSocket)
  {
    return false;
  }
  
  public Socket c()
  {
    return new Socket();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */