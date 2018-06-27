package com.mato.sdk.instrumentation;

import android.os.Build.VERSION;
import android.util.Log;
import com.mato.sdk.b.g;
import com.mato.sdk.b.m;
import com.mato.sdk.proxy.Address;
import com.mato.sdk.proxy.a;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class InstrumentationUtils
{
  private static final String a = g.b("");
  private static Address b;
  private static boolean c = false;
  
  static void a()
  {
    if (c) {
      return;
    }
    c = true;
    Log.d(a, "proxyutil set webview proxy");
    a.b().f();
  }
  
  static boolean a(String paramString)
  {
    boolean bool;
    if (paramString == null)
    {
      bool = false;
      if (!bool) {
        break label41;
      }
      if (Build.VERSION.SDK_INT >= 17) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label41;
      }
      return true;
      bool = paramString.equalsIgnoreCase("https");
      break;
    }
    label41:
    return false;
  }
  
  static boolean a(URI paramURI)
  {
    if (paramURI == null) {
      return true;
    }
    return a(paramURI.getScheme());
  }
  
  static boolean a(URL paramURL)
  {
    if (paramURL == null) {
      return true;
    }
    return a(paramURL.getProtocol());
  }
  
  private static boolean b()
  {
    return Build.VERSION.SDK_INT < 17;
  }
  
  private static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.equalsIgnoreCase("https");
  }
  
  public static Socket connect(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    Socket localSocket = new Socket();
    connect(localSocket, new InetSocketAddress(paramString, paramInt1), paramInt2);
    return localSocket;
  }
  
  public static void connect(Socket paramSocket, SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    Address localAddress = a.b().g();
    if (localAddress == null)
    {
      paramSocket.connect(paramSocketAddress, paramInt);
      return;
    }
    int i = getLocalPort(paramSocket);
    paramSocketAddress = (InetSocketAddress)paramSocketAddress;
    m.a(paramSocketAddress.getHostName(), paramSocketAddress.getPort(), i);
    paramSocket.connect(localAddress.getSocketAddress(), paramInt);
    initSocket(paramSocket);
  }
  
  public static boolean connect(SocketChannel paramSocketChannel, SocketAddress paramSocketAddress)
    throws IOException
  {
    Address localAddress = a.b().g();
    if (localAddress == null) {
      return paramSocketChannel.connect(paramSocketAddress);
    }
    int i = getLocalPort(paramSocketChannel.socket());
    paramSocketAddress = (InetSocketAddress)paramSocketAddress;
    m.a(paramSocketAddress.getHostName(), paramSocketAddress.getPort(), i);
    boolean bool = paramSocketChannel.connect(localAddress.getSocketAddress());
    if (paramSocketChannel.isBlocking())
    {
      nioSendMato(paramSocketChannel);
      return bool;
    }
    m.a(i);
    return bool;
  }
  
  public static Proxy getHttpProxy()
  {
    Address localAddress = a.b().g();
    if (localAddress != null) {
      return localAddress.getHttpProxy();
    }
    return null;
  }
  
  public static Address getLastAddress()
  {
    return b;
  }
  
  public static int getLocalPort(Socket paramSocket)
    throws IOException
  {
    int j = paramSocket.getLocalPort();
    int i = j;
    if (j == -1)
    {
      paramSocket.bind(null);
      i = paramSocket.getLocalPort();
    }
    return i;
  }
  
  public static void init(Address paramAddress)
  {
    b = paramAddress;
  }
  
  public static void initSocket(Socket paramSocket)
    throws IOException
  {
    paramSocket = paramSocket.getOutputStream();
    paramSocket.write("MATO".getBytes());
    paramSocket.flush();
  }
  
  public static void nioSendMato(SocketChannel paramSocketChannel)
    throws IOException
  {
    paramSocketChannel.write(ByteBuffer.wrap("MATO".getBytes()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/instrumentation/InstrumentationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */