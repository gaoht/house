package com.megvii.zhimasdk.b.a.i;

import com.megvii.zhimasdk.b.a.i.f.n;
import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.l.e;
import com.megvii.zhimasdk.b.a.o.b;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

@Deprecated
public class f
  extends a
  implements com.megvii.zhimasdk.b.a.o
{
  private volatile boolean a;
  private volatile Socket b = null;
  
  private static void a(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress)
  {
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      if (localInetSocketAddress.getAddress() != null) {}
      for (paramSocketAddress = localInetSocketAddress.getAddress().getHostAddress();; paramSocketAddress = localInetSocketAddress.getAddress())
      {
        paramStringBuilder.append(paramSocketAddress).append(':').append(localInetSocketAddress.getPort());
        return;
      }
    }
    paramStringBuilder.append(paramSocketAddress);
  }
  
  protected com.megvii.zhimasdk.b.a.j.f a(Socket paramSocket, int paramInt, e parame)
  {
    return new n(paramSocket, paramInt, parame);
  }
  
  protected void a(Socket paramSocket, e parame)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramSocket, "Socket");
    com.megvii.zhimasdk.b.a.o.a.a(parame, "HTTP parameters");
    this.b = paramSocket;
    int i = parame.a("http.socket.buffer-size", -1);
    a(a(paramSocket, i, parame), b(paramSocket, i, parame), parame);
    this.a = true;
  }
  
  protected g b(Socket paramSocket, int paramInt, e parame)
  {
    return new com.megvii.zhimasdk.b.a.i.f.o(paramSocket, paramInt, parame);
  }
  
  public void b(int paramInt)
  {
    j();
    if (this.b != null) {}
    try
    {
      this.b.setSoTimeout(paramInt);
      return;
    }
    catch (SocketException localSocketException) {}
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/megvii/zhimasdk/b/a/i/f:a	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield 80	com/megvii/zhimasdk/b/a/i/f:a	Z
    //   13: aload_0
    //   14: getfield 17	com/megvii/zhimasdk/b/a/i/f:b	Ljava/net/Socket;
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 104	com/megvii/zhimasdk/b/a/i/f:o	()V
    //   22: aload_1
    //   23: invokevirtual 107	java/net/Socket:shutdownOutput	()V
    //   26: aload_1
    //   27: invokevirtual 110	java/net/Socket:shutdownInput	()V
    //   30: aload_1
    //   31: invokevirtual 112	java/net/Socket:close	()V
    //   34: return
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 112	java/net/Socket:close	()V
    //   40: aload_2
    //   41: athrow
    //   42: astore_2
    //   43: goto -17 -> 26
    //   46: astore_2
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: goto -21 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	f
    //   17	20	1	localSocket	Socket
    //   35	6	2	localObject	Object
    //   42	1	2	localIOException1	java.io.IOException
    //   46	1	2	localIOException2	java.io.IOException
    //   50	1	2	localUnsupportedOperationException	UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   18	22	35	finally
    //   22	26	35	finally
    //   26	30	35	finally
    //   22	26	42	java/io/IOException
    //   26	30	46	java/io/IOException
    //   22	26	50	java/lang/UnsupportedOperationException
    //   26	30	50	java/lang/UnsupportedOperationException
  }
  
  public void e()
  {
    this.a = false;
    Socket localSocket = this.b;
    if (localSocket != null) {
      localSocket.close();
    }
  }
  
  public InetAddress f()
  {
    if (this.b != null) {
      return this.b.getInetAddress();
    }
    return null;
  }
  
  public int g()
  {
    if (this.b != null) {
      return this.b.getPort();
    }
    return -1;
  }
  
  protected Socket i()
  {
    return this.b;
  }
  
  protected void j()
  {
    b.a(this.a, "Connection is not open");
  }
  
  protected void q()
  {
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(bool, "Connection is already open");
      return;
    }
  }
  
  public String toString()
  {
    if (this.b != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      SocketAddress localSocketAddress1 = this.b.getRemoteSocketAddress();
      SocketAddress localSocketAddress2 = this.b.getLocalSocketAddress();
      if ((localSocketAddress1 != null) && (localSocketAddress2 != null))
      {
        a(localStringBuilder, localSocketAddress2);
        localStringBuilder.append("<->");
        a(localStringBuilder, localSocketAddress1);
      }
      return localStringBuilder.toString();
    }
    return super.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */