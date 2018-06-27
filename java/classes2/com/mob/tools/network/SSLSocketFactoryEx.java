package com.mob.tools.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SSLSocketFactoryEx
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public SSLSocketFactoryEx(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    paramKeyStore = new NetworkHelper.SimpleX509TrustManager(null);
    SSLContext localSSLContext = this.sslContext;
    SecureRandom localSecureRandom = new SecureRandom();
    localSSLContext.init(null, new TrustManager[] { paramKeyStore }, localSecureRandom);
  }
  
  public void allowAllHostnameVerifier()
  {
    setHostnameVerifier(STRICT_HOSTNAME_VERIFIER);
  }
  
  public Socket createSocket()
    throws IOException
  {
    return this.sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this.sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/network/SSLSocketFactoryEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */