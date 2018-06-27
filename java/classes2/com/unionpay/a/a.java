package com.unionpay.a;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class a
  implements LayeredSocketFactory, SocketFactory
{
  private SSLContext a = null;
  private Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private SSLContext a()
  {
    if (this.a == null) {
      this.a = a(this.b);
    }
    return this.a;
  }
  
  private static SSLContext a(Context paramContext)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { new b(paramContext) }, null);
      return localSSLContext;
    }
    catch (Exception paramContext)
    {
      throw new IOException(paramContext.getMessage());
    }
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    int i = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
    int j = HttpConnectionParams.getSoTimeout(paramHttpParams);
    paramString = new InetSocketAddress(paramString, paramInt1);
    if (paramSocket != null) {}
    for (;;)
    {
      paramSocket = (SSLSocket)paramSocket;
      if ((paramInetAddress != null) || (paramInt2 > 0))
      {
        paramInt1 = paramInt2;
        if (paramInt2 < 0) {
          paramInt1 = 0;
        }
        paramSocket.bind(new InetSocketAddress(paramInetAddress, paramInt1));
      }
      paramSocket.connect(paramString, i);
      paramSocket.setSoTimeout(j);
      return paramSocket;
      paramSocket = createSocket();
    }
  }
  
  public Socket createSocket()
  {
    return a().getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return a().getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && (paramObject.getClass().equals(a.class));
  }
  
  public int hashCode()
  {
    return a.class.hashCode();
  }
  
  public boolean isSecure(Socket paramSocket)
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */