package com.megvii.zhimasdk.b.a.e.c;

import com.megvii.zhimasdk.b.a.l.e;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
class k
  implements j
{
  private final l a;
  
  k(l paraml)
  {
    this.a = paraml;
  }
  
  public Socket a(e parame)
  {
    return this.a.c();
  }
  
  public Socket a(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, e parame)
  {
    String str = paramInetSocketAddress1.getHostName();
    int j = paramInetSocketAddress1.getPort();
    paramInetSocketAddress1 = null;
    int i = 0;
    if (paramInetSocketAddress2 != null)
    {
      paramInetSocketAddress1 = paramInetSocketAddress2.getAddress();
      i = paramInetSocketAddress2.getPort();
    }
    return this.a.a(paramSocket, str, j, paramInetSocketAddress1, i, parame);
  }
  
  public boolean a(Socket paramSocket)
  {
    return this.a.a(paramSocket);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof k)) {
      return this.a.equals(((k)paramObject).a);
    }
    return this.a.equals(paramObject);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */