package com.megvii.zhimasdk.b.a.e.c;

import com.megvii.zhimasdk.b.a.l.e;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
class h
  implements f
{
  private final b a;
  
  h(b paramb)
  {
    this.a = paramb;
  }
  
  public Socket a(e parame)
  {
    return this.a.a(parame);
  }
  
  public Socket a(Socket paramSocket, String paramString, int paramInt, e parame)
  {
    return this.a.b(paramSocket, paramString, paramInt, true);
  }
  
  public Socket a(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, e parame)
  {
    return this.a.a(paramSocket, paramInetSocketAddress1, paramInetSocketAddress2, parame);
  }
  
  public boolean a(Socket paramSocket)
  {
    return this.a.a(paramSocket);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */