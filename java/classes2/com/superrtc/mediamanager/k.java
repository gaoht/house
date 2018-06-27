package com.superrtc.mediamanager;

import android.util.Log;
import c.a.b.a.h;
import c.a.b.c.a;
import c.a.b.c.d;
import java.net.URI;
import java.net.URISyntaxException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;

public class k
{
  public String a;
  public String b;
  public a c;
  private j d;
  private a e;
  private boolean f = false;
  
  public k(String paramString1, a parama, String paramString2)
    throws URISyntaxException
  {
    this.b = paramString2;
    this.c = parama;
    this.a = paramString1;
    this.e = new d();
    this.d = new j(new URI(paramString1), this.e)
    {
      public void onClose(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        k.a(k.this, false);
        k.this.c.didCloseWithCode(k.this, paramAnonymousInt, paramAnonymousString, paramAnonymousBoolean);
      }
      
      public void onError(Exception paramAnonymousException)
      {
        k.this.c.didFailWithError(k.this, paramAnonymousException);
      }
      
      public void onMessage(String paramAnonymousString)
      {
        if (!k.a(k.this))
        {
          Log.e("SRWebSocketExt", "websocket is not open!");
          return;
        }
        k.this.c.didReceiveMessageWithString(k.this, paramAnonymousString);
      }
      
      public void onOpen(h paramAnonymoush)
      {
        k.a(k.this, true);
        k.this.c.webSocketDidOpen(k.this);
      }
    };
    if (this.a.indexOf("wss") != -1) {}
    try
    {
      paramString1 = SSLContext.getInstance("TLS");
      paramString1.init(null, null, null);
      this.d.setSocket(paramString1.getSocketFactory().createSocket());
      return;
    }
    catch (SSLHandshakeException paramString1)
    {
      this.f = false;
      this.d.close();
      return;
    }
    catch (Exception paramString1)
    {
      this.f = false;
      this.d.close();
      paramString1.printStackTrace();
    }
  }
  
  public void close()
  {
    this.f = false;
    this.d.close();
  }
  
  public void open()
  {
    if (this.f) {
      return;
    }
    this.d.connect();
  }
  
  public void send(String paramString)
  {
    if ((this.d != null) && (this.f)) {
      this.d.send(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void didCloseWithCode(k paramk, int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void didFailWithError(k paramk, Exception paramException);
    
    public abstract void didReceiveMessageWithData(k paramk, byte[] paramArrayOfByte);
    
    public abstract void didReceiveMessageWithString(k paramk, String paramString);
    
    public abstract void didReceivePong(k paramk, byte[] paramArrayOfByte);
    
    public abstract void invokeConnWithWebsocket(k paramk, String paramString);
    
    public abstract void webSocketDidOpen(k paramk);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */