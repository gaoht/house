package com.mato.sdk.instrumentation;

import com.mato.sdk.b.m;
import com.mato.sdk.g.f;
import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public final class TcpInstrumentation
{
  private static final String a = TcpInstrumentation.class.getSimpleName();
  
  public static void close(SocketChannel paramSocketChannel)
    throws IOException
  {
    m.d(paramSocketChannel.socket().getLocalPort());
    paramSocketChannel.close();
  }
  
  public static void closeSocket(Socket paramSocket)
    throws IOException
  {
    m.d(paramSocket.getLocalPort());
    paramSocket.close();
  }
  
  public static void connect(Socket paramSocket, SocketAddress paramSocketAddress)
    throws IOException
  {
    paramSocket.connect(paramSocketAddress, 0);
  }
  
  public static void connect(Socket paramSocket, SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    if (((Boolean)f.a(paramSocket, "usingSocks")).booleanValue())
    {
      paramSocket.connect(paramSocketAddress, paramInt);
      return;
    }
    InstrumentationUtils.connect(paramSocket, paramSocketAddress, paramInt);
  }
  
  public static boolean connect(SocketChannel paramSocketChannel, SocketAddress paramSocketAddress)
    throws IOException
  {
    return InstrumentationUtils.connect(paramSocketChannel, paramSocketAddress);
  }
  
  public static Object createSocket(String paramString1, int paramInt, String paramString2)
    throws IOException, UnknownHostException
  {
    localObject1 = null;
    try
    {
      paramString2 = Class.forName(paramString2).getConstructor(new Class[] { String.class, Integer.TYPE });
      Object localObject2 = a.b().g();
      if (localObject2 == null) {}
      try
      {
        localObject2 = paramString2.newInstance(new Object[] { ((Address)localObject2).getHost(), Integer.valueOf(((Address)localObject2).getPort()) });
        paramString2 = (Socket)localObject2;
        i = paramString2.getLocalPort();
        if (i != -1) {
          break label165;
        }
        paramString2.bind(null);
        i = paramString2.getLocalPort();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            int i;
            paramString1 = paramString2.newInstance(new Object[] { paramString1, Integer.valueOf(paramInt) });
            return paramString1;
          }
          catch (Exception paramString1)
          {
            paramString1 = (String)localObject1;
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      try
      {
        paramString1 = paramString2.newInstance(new Object[] { paramString1, Integer.valueOf(paramInt) });
        return paramString1;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString1 = paramString1;
      return null;
    }
    m.a(paramString1, paramInt, i);
    InstrumentationUtils.initSocket(paramString2);
    return paramString2;
  }
  
  public static Socket createSocket(SocketFactory paramSocketFactory, String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    Object localObject = a.b().g();
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramString, paramInt);
    }
    localObject = paramSocketFactory.createSocket(((Address)localObject).getHost(), ((Address)localObject).getPort());
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramString, paramInt);
    }
    int j = ((Socket)localObject).getLocalPort();
    int i = j;
    if (j == -1)
    {
      ((Socket)localObject).bind(null);
      i = ((Socket)localObject).getLocalPort();
    }
    m.a(paramString, paramInt, i);
    InstrumentationUtils.initSocket((Socket)localObject);
    return (Socket)localObject;
  }
  
  public static Socket createSocket(SocketFactory paramSocketFactory, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    Object localObject = a.b().g();
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    }
    localObject = paramSocketFactory.createSocket(((Address)localObject).getHost(), ((Address)localObject).getPort(), paramInetAddress, paramInt2);
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    }
    m.a(paramString, paramInt1, paramInt2);
    InstrumentationUtils.initSocket((Socket)localObject);
    return (Socket)localObject;
  }
  
  public static Socket createSocket(SocketFactory paramSocketFactory, InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    Object localObject = a.b().g();
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramInetAddress, paramInt);
    }
    localObject = paramSocketFactory.createSocket(((Address)localObject).getHost(), ((Address)localObject).getPort());
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramInetAddress, paramInt);
    }
    int j = ((Socket)localObject).getLocalPort();
    int i = j;
    if (j == -1)
    {
      ((Socket)localObject).bind(null);
      i = ((Socket)localObject).getLocalPort();
    }
    m.a(paramInetAddress.getHostName(), paramInt, i);
    InstrumentationUtils.initSocket((Socket)localObject);
    return (Socket)localObject;
  }
  
  public static Socket createSocket(SocketFactory paramSocketFactory, InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    Object localObject = a.b().g();
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    }
    localObject = paramSocketFactory.createSocket(InetAddress.getByName(((Address)localObject).getHost()), ((Address)localObject).getPort(), paramInetAddress2, paramInt2);
    if (localObject == null) {
      return paramSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    }
    m.a(paramInetAddress1.getHostName(), paramInt1, paramInt2);
    InstrumentationUtils.initSocket((Socket)localObject);
    return (Socket)localObject;
  }
  
  public static Socket createSocket(SSLSocketFactory paramSSLSocketFactory, Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    Object localObject = a.b().g();
    if (localObject == null) {
      return paramSSLSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
    localObject = paramSSLSocketFactory.createSocket(paramSocket, ((Address)localObject).getHost(), ((Address)localObject).getPort(), paramBoolean);
    if (localObject == null) {
      return paramSSLSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
    int j = ((Socket)localObject).getLocalPort();
    int i = j;
    if (j == -1)
    {
      paramSocket.bind(null);
      i = ((Socket)localObject).getLocalPort();
    }
    m.a(paramString, paramInt, i);
    InstrumentationUtils.initSocket((Socket)localObject);
    return (Socket)localObject;
  }
  
  public static boolean finishConnect(SocketChannel paramSocketChannel)
    throws IOException
  {
    boolean bool = paramSocketChannel.finishConnect();
    if (bool)
    {
      int i = paramSocketChannel.socket().getLocalPort();
      if (m.c(i))
      {
        InstrumentationUtils.nioSendMato(paramSocketChannel);
        m.b(i);
      }
    }
    return bool;
  }
  
  public static Socket newSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    Socket localSocket2 = a.b().a(paramString, paramInt, 0);
    Socket localSocket1 = localSocket2;
    if (localSocket2 == null) {
      localSocket1 = new Socket(paramString, paramInt);
    }
    return localSocket1;
  }
  
  public static Socket newSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    Object localObject;
    if (paramInetAddress == null) {
      localObject = new Socket(paramInetAddress, paramInt);
    }
    Socket localSocket;
    do
    {
      return (Socket)localObject;
      localSocket = a.b().a(paramInetAddress.getHostName(), paramInt, 0);
      localObject = localSocket;
    } while (localSocket != null);
    return new Socket(paramInetAddress, paramInt);
  }
  
  public static SocketChannel open(SocketAddress paramSocketAddress)
    throws IOException
  {
    SocketChannel localSocketChannel = SocketChannel.open();
    if (localSocketChannel != null) {
      connect(localSocketChannel, paramSocketAddress);
    }
    return localSocketChannel;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/TcpInstrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */