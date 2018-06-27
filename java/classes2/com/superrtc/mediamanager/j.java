package com.superrtc.mediamanager;

import c.a.b.a.f;
import c.a.b.a.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public abstract class j
  extends c.a.b.b
  implements c.a.b.a, Runnable
{
  protected URI a = null;
  private c.a.b.d c = null;
  private Socket d = null;
  private InputStream e;
  private OutputStream f;
  private Proxy g = Proxy.NO_PROXY;
  private Thread h;
  private c.a.b.c.a i;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;
  
  static
  {
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public j(URI paramURI)
  {
    this(paramURI, new c.a.b.c.d());
  }
  
  public j(URI paramURI, c.a.b.c.a parama)
  {
    this(paramURI, parama, null, 0);
  }
  
  public j(URI paramURI, c.a.b.c.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.a = paramURI;
    this.i = parama;
    this.j = paramMap;
    this.m = paramInt;
    setTcpNoDelay(true);
    this.c = new c.a.b.d(this, parama);
  }
  
  private int d()
  {
    int i1 = this.a.getPort();
    int n = i1;
    String str;
    if (i1 == -1)
    {
      str = this.a.getScheme();
      if (str.equals("wss")) {
        n = 443;
      }
    }
    else
    {
      return n;
    }
    if (str.equals("ws")) {
      return 80;
    }
    throw new RuntimeException("unknown scheme: " + str);
  }
  
  private void e()
    throws c.a.b.d.d
  {
    Object localObject2 = this.a.getRawPath();
    Object localObject3 = this.a.getRawQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = (String)localObject1 + "?" + (String)localObject3;
    }
    int n = d();
    localObject3 = new StringBuilder().append(this.a.getHost());
    if (n != 80) {}
    for (Object localObject1 = ":" + n;; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new c.a.b.a.d();
      ((c.a.b.a.d)localObject1).a((String)localObject2);
      ((c.a.b.a.d)localObject1).a("Host", (String)localObject3);
      if (this.j == null) {
        break;
      }
      localObject2 = this.j.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((c.a.b.a.d)localObject1).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.c.a((c.a.b.a.b)localObject1);
  }
  
  protected Collection<c.a.b.a> a()
  {
    return Collections.singletonList(this.c);
  }
  
  public void close()
  {
    if (this.h != null) {
      this.c.close(1000);
    }
  }
  
  public void close(int paramInt)
  {
    this.c.close();
  }
  
  public void close(int paramInt, String paramString)
  {
    this.c.close(paramInt, paramString);
  }
  
  public void closeBlocking()
    throws InterruptedException
  {
    close();
    this.l.await();
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    this.c.closeConnection(paramInt, paramString);
  }
  
  public void connect()
  {
    if (this.h != null) {
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }
    this.h = new Thread(this);
    this.h.start();
  }
  
  public boolean connectBlocking()
    throws InterruptedException
  {
    connect();
    this.k.await();
    return this.c.isOpen();
  }
  
  public c.a.b.a getConnection()
  {
    return this.c;
  }
  
  public c.a.b.c.a getDraft()
  {
    return this.i;
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return this.c.getLocalSocketAddress();
  }
  
  public InetSocketAddress getLocalSocketAddress(c.a.b.a parama)
  {
    if (this.d != null) {
      return (InetSocketAddress)this.d.getLocalSocketAddress();
    }
    return null;
  }
  
  public c.a.b.a.a getReadyState()
  {
    return this.c.getReadyState();
  }
  
  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.c.getRemoteSocketAddress();
  }
  
  public InetSocketAddress getRemoteSocketAddress(c.a.b.a parama)
  {
    if (this.d != null) {
      return (InetSocketAddress)this.d.getRemoteSocketAddress();
    }
    return null;
  }
  
  public String getResourceDescriptor()
  {
    return this.a.getPath();
  }
  
  public Socket getSocket()
  {
    return this.d;
  }
  
  public URI getURI()
  {
    return this.a;
  }
  
  public boolean hasBufferedData()
  {
    return this.c.hasBufferedData();
  }
  
  public boolean isClosed()
  {
    return this.c.isClosed();
  }
  
  public boolean isClosing()
  {
    return this.c.isClosing();
  }
  
  public boolean isConnecting()
  {
    return this.c.isConnecting();
  }
  
  public boolean isFlushAndClose()
  {
    return this.c.isFlushAndClose();
  }
  
  public boolean isOpen()
  {
    return this.c.isOpen();
  }
  
  public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);
  
  public void onCloseInitiated(int paramInt, String paramString) {}
  
  public void onClosing(int paramInt, String paramString, boolean paramBoolean) {}
  
  public abstract void onError(Exception paramException);
  
  public void onFragment(c.a.b.e.a parama) {}
  
  public abstract void onMessage(String paramString);
  
  public void onMessage(ByteBuffer paramByteBuffer) {}
  
  public abstract void onOpen(h paramh);
  
  public final void onWebsocketClose(c.a.b.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    b();
    if (this.h != null) {
      this.h.interrupt();
    }
    try
    {
      if (this.d != null) {
        this.d.close();
      }
      onClose(paramInt, paramString, paramBoolean);
      this.k.countDown();
      this.l.countDown();
      return;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        onWebsocketError(this, parama);
      }
    }
  }
  
  public void onWebsocketCloseInitiated(c.a.b.a parama, int paramInt, String paramString)
  {
    onCloseInitiated(paramInt, paramString);
  }
  
  public void onWebsocketClosing(c.a.b.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramInt, paramString, paramBoolean);
  }
  
  public final void onWebsocketError(c.a.b.a parama, Exception paramException)
  {
    onError(paramException);
  }
  
  public final void onWebsocketMessage(c.a.b.a parama, String paramString)
  {
    onMessage(paramString);
  }
  
  public final void onWebsocketMessage(c.a.b.a parama, ByteBuffer paramByteBuffer)
  {
    onMessage(paramByteBuffer);
  }
  
  public void onWebsocketMessageFragment(c.a.b.a parama, c.a.b.e.a parama1)
  {
    onFragment(parama1);
  }
  
  public final void onWebsocketOpen(c.a.b.a parama, f paramf)
  {
    c();
    onOpen((h)paramf);
    this.k.countDown();
  }
  
  public final void onWriteDemand(c.a.b.a parama) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   4: ifnonnull +203 -> 207
    //   7: aload_0
    //   8: new 277	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 75	com/superrtc/mediamanager/j:g	Ljava/net/Proxy;
    //   16: invokespecial 381	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   26: aload_0
    //   27: invokevirtual 384	com/superrtc/mediamanager/j:isTcpNoDelay	()Z
    //   30: invokevirtual 385	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   37: invokevirtual 388	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   47: new 282	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 64	com/superrtc/mediamanager/j:a	Ljava/net/URI;
    //   55: invokevirtual 168	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 165	com/superrtc/mediamanager/j:d	()I
    //   62: invokespecial 391	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 86	com/superrtc/mediamanager/j:m	I
    //   69: invokevirtual 394	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   77: invokevirtual 398	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 400	com/superrtc/mediamanager/j:e	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   88: invokevirtual 404	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 113	com/superrtc/mediamanager/j:f	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 406	com/superrtc/mediamanager/j:e	()V
    //   98: aload_0
    //   99: new 254	java/lang/Thread
    //   102: dup
    //   103: new 12	com/superrtc/mediamanager/j$a
    //   106: dup
    //   107: aload_0
    //   108: aconst_null
    //   109: invokespecial 409	com/superrtc/mediamanager/j$a:<init>	(Lcom/superrtc/mediamanager/j;Lcom/superrtc/mediamanager/j$1;)V
    //   112: invokespecial 257	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   115: putfield 229	com/superrtc/mediamanager/j:h	Ljava/lang/Thread;
    //   118: aload_0
    //   119: getfield 229	com/superrtc/mediamanager/j:h	Ljava/lang/Thread;
    //   122: invokevirtual 260	java/lang/Thread:start	()V
    //   125: getstatic 411	c/a/b/d:a	I
    //   128: newarray <illegal type>
    //   130: astore_2
    //   131: aload_0
    //   132: invokevirtual 412	com/superrtc/mediamanager/j:isClosing	()Z
    //   135: ifne +113 -> 248
    //   138: aload_0
    //   139: invokevirtual 413	com/superrtc/mediamanager/j:isClosed	()Z
    //   142: ifne +106 -> 248
    //   145: aload_0
    //   146: getfield 400	com/superrtc/mediamanager/j:e	Ljava/io/InputStream;
    //   149: aload_2
    //   150: invokevirtual 419	java/io/InputStream:read	([B)I
    //   153: istore_1
    //   154: iload_1
    //   155: iconst_m1
    //   156: if_icmpeq +92 -> 248
    //   159: aload_0
    //   160: getfield 66	com/superrtc/mediamanager/j:c	Lc/a/b/d;
    //   163: aload_2
    //   164: iconst_0
    //   165: iload_1
    //   166: invokestatic 425	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   169: invokevirtual 427	c/a/b/d:a	(Ljava/nio/ByteBuffer;)V
    //   172: goto -41 -> 131
    //   175: astore_2
    //   176: aload_0
    //   177: getfield 66	com/superrtc/mediamanager/j:c	Lc/a/b/d;
    //   180: invokevirtual 428	c/a/b/d:b	()V
    //   183: getstatic 48	com/superrtc/mediamanager/j:b	Z
    //   186: ifne +61 -> 247
    //   189: aload_0
    //   190: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   193: invokevirtual 429	java/net/Socket:isClosed	()Z
    //   196: ifne +51 -> 247
    //   199: new 431	java/lang/AssertionError
    //   202: dup
    //   203: invokespecial 432	java/lang/AssertionError:<init>	()V
    //   206: athrow
    //   207: aload_0
    //   208: getfield 68	com/superrtc/mediamanager/j:d	Ljava/net/Socket;
    //   211: invokevirtual 429	java/net/Socket:isClosed	()Z
    //   214: ifeq -192 -> 22
    //   217: new 330	java/io/IOException
    //   220: dup
    //   221: invokespecial 433	java/io/IOException:<init>	()V
    //   224: athrow
    //   225: astore_2
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 66	com/superrtc/mediamanager/j:c	Lc/a/b/d;
    //   231: aload_2
    //   232: invokevirtual 345	com/superrtc/mediamanager/j:onWebsocketError	(Lc/a/b/a;Ljava/lang/Exception;)V
    //   235: aload_0
    //   236: getfield 66	com/superrtc/mediamanager/j:c	Lc/a/b/d;
    //   239: iconst_m1
    //   240: aload_2
    //   241: invokevirtual 436	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   244: invokevirtual 246	c/a/b/d:closeConnection	(ILjava/lang/String;)V
    //   247: return
    //   248: aload_0
    //   249: getfield 66	com/superrtc/mediamanager/j:c	Lc/a/b/d;
    //   252: invokevirtual 428	c/a/b/d:b	()V
    //   255: goto -72 -> 183
    //   258: astore_2
    //   259: aload_0
    //   260: aload_2
    //   261: invokevirtual 354	com/superrtc/mediamanager/j:onError	(Ljava/lang/Exception;)V
    //   264: aload_0
    //   265: getfield 66	com/superrtc/mediamanager/j:c	Lc/a/b/d;
    //   268: sipush 1006
    //   271: aload_2
    //   272: invokevirtual 437	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 246	c/a/b/d:closeConnection	(ILjava/lang/String;)V
    //   278: goto -95 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	j
    //   153	13	1	n	int
    //   130	34	2	arrayOfByte	byte[]
    //   175	1	2	localIOException	IOException
    //   225	16	2	localException	Exception
    //   258	14	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   131	154	175	java/io/IOException
    //   159	172	175	java/io/IOException
    //   248	255	175	java/io/IOException
    //   0	22	225	java/lang/Exception
    //   22	72	225	java/lang/Exception
    //   72	98	225	java/lang/Exception
    //   207	225	225	java/lang/Exception
    //   131	154	258	java/lang/RuntimeException
    //   159	172	258	java/lang/RuntimeException
    //   248	255	258	java/lang/RuntimeException
  }
  
  public void send(String paramString)
    throws NotYetConnectedException
  {
    this.c.send(paramString);
  }
  
  public void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, NotYetConnectedException
  {
    this.c.send(paramByteBuffer);
  }
  
  public void send(byte[] paramArrayOfByte)
    throws NotYetConnectedException
  {
    this.c.send(paramArrayOfByte);
  }
  
  public void sendFragmentedFrame(c.a.b.e.a.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.c.sendFragmentedFrame(parama, paramByteBuffer, paramBoolean);
  }
  
  public void sendFrame(c.a.b.e.a parama)
  {
    this.c.sendFrame(parama);
  }
  
  public void sendPing()
    throws NotYetConnectedException
  {
    this.c.sendPing();
  }
  
  public void setProxy(Proxy paramProxy)
  {
    if (paramProxy == null) {
      throw new IllegalArgumentException();
    }
    this.g = paramProxy;
  }
  
  public void setSocket(Socket paramSocket)
  {
    if (this.d != null) {
      throw new IllegalStateException("socket has already been set");
    }
    this.d = paramSocket;
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      Thread.currentThread().setName("WebsocketWriteThread");
      try
      {
        while (!Thread.interrupted())
        {
          ByteBuffer localByteBuffer = (ByteBuffer)j.a(j.this).c.take();
          j.b(j.this).write(localByteBuffer.array(), 0, localByteBuffer.limit());
          j.b(j.this).flush();
        }
        return;
      }
      catch (IOException localIOException)
      {
        j.a(j.this).b();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */